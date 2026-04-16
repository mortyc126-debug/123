/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work;

import android.content.Context;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class Worker
extends ListenableWorker {
    SettableFuture<ListenableWorker.Result> mFuture;

    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public abstract ListenableWorker.Result doWork();

    public ForegroundInfo getForegroundInfo() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for \n `getForegroundInfo()`");
    }

    @Override
    public ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        SettableFuture<ForegroundInfo> settableFuture = SettableFuture.create();
        this.getBackgroundExecutor().execute(new Runnable(){
            final Worker this$0;
            final SettableFuture val$future;
            {
                this.this$0 = worker;
                this.val$future = settableFuture;
            }

            @Override
            public void run() {
                try {
                    ForegroundInfo foregroundInfo = this.this$0.getForegroundInfo();
                    this.val$future.set(foregroundInfo);
                }
                catch (Throwable throwable) {
                    this.val$future.setException(throwable);
                }
            }
        });
        return settableFuture;
    }

    @Override
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        this.mFuture = SettableFuture.create();
        this.getBackgroundExecutor().execute(new Runnable(this){
            final Worker this$0;
            {
                this.this$0 = worker;
            }

            @Override
            public void run() {
                try {
                    ListenableWorker.Result result2 = this.this$0.doWork();
                    this.this$0.mFuture.set(result2);
                }
                catch (Throwable throwable) {
                    this.this$0.mFuture.setException(throwable);
                }
            }
        });
        return this.mFuture;
    }
}

