/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.SerialExecutorImpl;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.concurrent.Executor;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

public class WorkManagerTaskExecutor
implements TaskExecutor {
    private final SerialExecutorImpl mBackgroundExecutor;
    private final Executor mMainThreadExecutor;
    final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    private final CoroutineDispatcher mTaskDispatcher;

    public WorkManagerTaskExecutor(Executor executor) {
        this.mMainThreadExecutor = new Executor(this){
            final WorkManagerTaskExecutor this$0;
            {
                this.this$0 = workManagerTaskExecutor;
            }

            @Override
            public void execute(Runnable runnable2) {
                this.this$0.mMainThreadHandler.post(runnable2);
            }
        };
        this.mBackgroundExecutor = new SerialExecutorImpl(executor);
        this.mTaskDispatcher = ExecutorsKt.from(this.mBackgroundExecutor);
    }

    @Override
    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }

    @Override
    public SerialExecutorImpl getSerialTaskExecutor() {
        return this.mBackgroundExecutor;
    }

    @Override
    public CoroutineDispatcher getTaskCoroutineDispatcher() {
        return this.mTaskDispatcher;
    }
}

