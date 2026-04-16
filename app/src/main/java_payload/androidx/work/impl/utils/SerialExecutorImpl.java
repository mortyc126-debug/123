/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.utils;

import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class SerialExecutorImpl
implements SerialExecutor {
    private Runnable mActive;
    private final Executor mExecutor;
    final Object mLock;
    private final ArrayDeque<Task> mTasks;

    public SerialExecutorImpl(Executor executor) {
        this.mExecutor = executor;
        this.mTasks = new ArrayDeque();
        this.mLock = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void execute(Runnable runnable2) {
        Object object = this.mLock;
        synchronized (object) {
            ArrayDeque<Task> arrayDeque = this.mTasks;
            Task task = new Task(this, runnable2);
            arrayDeque.add(task);
            if (this.mActive == null) {
                this.scheduleNext();
            }
            return;
        }
    }

    public Executor getDelegatedExecutor() {
        return this.mExecutor;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean hasPendingTasks() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mTasks.isEmpty()) return false;
            return true;
        }
    }

    void scheduleNext() {
        Runnable runnable2;
        this.mActive = runnable2 = (Runnable)this.mTasks.poll();
        if (runnable2 != null) {
            this.mExecutor.execute(this.mActive);
        }
    }

    static class Task
    implements Runnable {
        final Runnable mRunnable;
        final SerialExecutorImpl mSerialExecutor;

        Task(SerialExecutorImpl serialExecutorImpl, Runnable runnable2) {
            this.mSerialExecutor = serialExecutorImpl;
            this.mRunnable = runnable2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void run() {
            try {
                this.mRunnable.run();
                return;
            }
            finally {
                Object object = this.mSerialExecutor.mLock;
                synchronized (object) {
                    this.mSerialExecutor.scheduleNext();
                }
            }
        }
    }
}

