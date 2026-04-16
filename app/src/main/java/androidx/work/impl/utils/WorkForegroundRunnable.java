/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WorkForegroundRunnable$$ExternalSyntheticLambda0;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class WorkForegroundRunnable
implements Runnable {
    static final String TAG = Logger.tagWithPrefix("WorkForegroundRunnable");
    final Context mContext;
    final ForegroundUpdater mForegroundUpdater;
    final SettableFuture<Void> mFuture = SettableFuture.create();
    final TaskExecutor mTaskExecutor;
    final WorkSpec mWorkSpec;
    final ListenableWorker mWorker;

    public WorkForegroundRunnable(Context context, WorkSpec workSpec, ListenableWorker listenableWorker, ForegroundUpdater foregroundUpdater, TaskExecutor taskExecutor) {
        this.mContext = context;
        this.mWorkSpec = workSpec;
        this.mWorker = listenableWorker;
        this.mForegroundUpdater = foregroundUpdater;
        this.mTaskExecutor = taskExecutor;
    }

    public ListenableFuture<Void> getFuture() {
        return this.mFuture;
    }

    /* synthetic */ void lambda$run$0$androidx-work-impl-utils-WorkForegroundRunnable(SettableFuture settableFuture) {
        if (!this.mFuture.isCancelled()) {
            settableFuture.setFuture(this.mWorker.getForegroundInfoAsync());
        } else {
            settableFuture.cancel(true);
        }
    }

    @Override
    public void run() {
        if (this.mWorkSpec.expedited && Build.VERSION.SDK_INT < 31) {
            SettableFuture settableFuture = SettableFuture.create();
            this.mTaskExecutor.getMainThreadExecutor().execute(new WorkForegroundRunnable$$ExternalSyntheticLambda0(this, settableFuture));
            settableFuture.addListener(new Runnable(){
                final WorkForegroundRunnable this$0;
                final SettableFuture val$foregroundFuture;
                {
                    this.this$0 = workForegroundRunnable;
                    this.val$foregroundFuture = settableFuture;
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                @Override
                public void run() {
                    if (this.this$0.mFuture.isCancelled()) {
                        return;
                    }
                    try {
                        ForegroundInfo foregroundInfo = (ForegroundInfo)this.val$foregroundFuture.get();
                        if (foregroundInfo != null) {
                            Logger logger = Logger.get();
                            String string2 = TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            logger.debug(string2, stringBuilder.append("Updating notification for ").append(this.this$0.mWorkSpec.workerClassName).toString());
                            this.this$0.mFuture.setFuture(this.this$0.mForegroundUpdater.setForegroundAsync(this.this$0.mContext, this.this$0.mWorker.getId(), foregroundInfo));
                            return;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        String string3 = stringBuilder.append("Worker was marked important (").append(this.this$0.mWorkSpec.workerClassName).append(") but did not provide ForegroundInfo").toString();
                        IllegalStateException illegalStateException = new IllegalStateException(string3);
                        throw illegalStateException;
                    }
                    catch (Throwable throwable) {
                        this.this$0.mFuture.setException(throwable);
                    }
                }
            }, this.mTaskExecutor.getMainThreadExecutor());
            return;
        }
        this.mFuture.set(null);
    }
}

