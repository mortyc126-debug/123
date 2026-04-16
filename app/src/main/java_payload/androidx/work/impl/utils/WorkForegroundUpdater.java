/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work.impl.utils;

import android.content.Context;
import android.content.Intent;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public class WorkForegroundUpdater
implements ForegroundUpdater {
    private static final String TAG = Logger.tagWithPrefix("WMFgUpdater");
    final ForegroundProcessor mForegroundProcessor;
    private final TaskExecutor mTaskExecutor;
    final WorkSpecDao mWorkSpecDao;

    public WorkForegroundUpdater(WorkDatabase workDatabase, ForegroundProcessor foregroundProcessor, TaskExecutor taskExecutor) {
        this.mForegroundProcessor = foregroundProcessor;
        this.mTaskExecutor = taskExecutor;
        this.mWorkSpecDao = workDatabase.workSpecDao();
    }

    @Override
    public ListenableFuture<Void> setForegroundAsync(Context context, UUID uUID, ForegroundInfo foregroundInfo) {
        SettableFuture<Void> settableFuture = SettableFuture.create();
        this.mTaskExecutor.executeOnTaskThread(new Runnable(){
            final WorkForegroundUpdater this$0;
            final Context val$context;
            final ForegroundInfo val$foregroundInfo;
            final SettableFuture val$future;
            final UUID val$id;
            {
                this.this$0 = workForegroundUpdater;
                this.val$future = settableFuture;
                this.val$id = uUID;
                this.val$foregroundInfo = foregroundInfo;
                this.val$context = context;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void run() {
                try {
                    if (!this.val$future.isCancelled()) {
                        Object object = this.val$id.toString();
                        WorkSpec workSpec = this.this$0.mWorkSpecDao.getWorkSpec((String)object);
                        if (workSpec != null && !workSpec.state.isFinished()) {
                            this.this$0.mForegroundProcessor.startForeground((String)object, this.val$foregroundInfo);
                            object = SystemForegroundDispatcher.createNotifyIntent(this.val$context, WorkSpecKt.generationalId(workSpec), this.val$foregroundInfo);
                            this.val$context.startService((Intent)object);
                        } else {
                            object = new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                            throw object;
                        }
                    }
                    this.val$future.set(null);
                    return;
                }
                catch (Throwable throwable) {
                    this.val$future.setException(throwable);
                }
            }
        });
        return settableFuture;
    }
}

