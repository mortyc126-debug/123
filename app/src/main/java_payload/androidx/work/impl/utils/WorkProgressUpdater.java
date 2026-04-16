/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public class WorkProgressUpdater
implements ProgressUpdater {
    static final String TAG = Logger.tagWithPrefix("WorkProgressUpdater");
    final TaskExecutor mTaskExecutor;
    final WorkDatabase mWorkDatabase;

    public WorkProgressUpdater(WorkDatabase workDatabase, TaskExecutor taskExecutor) {
        this.mWorkDatabase = workDatabase;
        this.mTaskExecutor = taskExecutor;
    }

    @Override
    public ListenableFuture<Void> updateProgress(Context object, UUID uUID, Data data) {
        object = SettableFuture.create();
        this.mTaskExecutor.executeOnTaskThread(new Runnable(){
            final WorkProgressUpdater this$0;
            final Data val$data;
            final SettableFuture val$future;
            final UUID val$id;
            {
                this.this$0 = workProgressUpdater;
                this.val$id = uUID;
                this.val$data = data;
                this.val$future = settableFuture;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void run() {
                Object object = this.val$id.toString();
                Logger.get().debug(TAG, "Updating progress for " + this.val$id + " (" + this.val$data + ")");
                this.this$0.mWorkDatabase.beginTransaction();
                try {
                    Object object2 = this.this$0.mWorkDatabase.workSpecDao().getWorkSpec((String)object);
                    if (object2 == null) {
                        object = new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        throw object;
                    }
                    if (((WorkSpec)object2).state == WorkInfo.State.RUNNING) {
                        object2 = new WorkProgress((String)object, this.val$data);
                        this.this$0.mWorkDatabase.workProgressDao().insert((WorkProgress)object2);
                    } else {
                        object2 = Logger.get();
                        String string2 = TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        ((Logger)object2).warning(string2, stringBuilder.append("Ignoring setProgressAsync(...). WorkSpec (").append((String)object).append(") is not in a RUNNING state.").toString());
                    }
                    this.val$future.set(null);
                    this.this$0.mWorkDatabase.setTransactionSuccessful();
                    return;
                }
                catch (Throwable throwable) {
                    try {
                        Logger.get().error(TAG, "Error updating Worker progress", throwable);
                        this.val$future.setException(throwable);
                        return;
                    }
                    finally {
                        this.this$0.mWorkDatabase.endTransaction();
                    }
                }
            }
        });
        return object;
    }
}

