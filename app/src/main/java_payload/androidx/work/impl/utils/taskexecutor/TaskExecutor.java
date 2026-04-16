/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.utils.taskexecutor;

import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import java.util.concurrent.Executor;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

public interface TaskExecutor {
    default public void executeOnTaskThread(Runnable runnable2) {
        this.getSerialTaskExecutor().execute(runnable2);
    }

    public Executor getMainThreadExecutor();

    public SerialExecutor getSerialTaskExecutor();

    default public CoroutineDispatcher getTaskCoroutineDispatcher() {
        return ExecutorsKt.from(this.getSerialTaskExecutor());
    }
}

