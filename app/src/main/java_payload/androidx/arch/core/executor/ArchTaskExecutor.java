/*
 * Decompiled with CFR 0.152.
 */
package androidx.arch.core.executor;

import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda1;
import androidx.arch.core.executor.DefaultTaskExecutor;
import androidx.arch.core.executor.TaskExecutor;
import java.util.concurrent.Executor;

public class ArchTaskExecutor
extends TaskExecutor {
    private static final Executor sIOThreadExecutor;
    private static volatile ArchTaskExecutor sInstance;
    private static final Executor sMainThreadExecutor;
    private final TaskExecutor mDefaultTaskExecutor;
    private TaskExecutor mDelegate;

    static {
        sMainThreadExecutor = new ArchTaskExecutor$$ExternalSyntheticLambda0();
        sIOThreadExecutor = new ArchTaskExecutor$$ExternalSyntheticLambda1();
    }

    private ArchTaskExecutor() {
        this.mDelegate = this.mDefaultTaskExecutor = new DefaultTaskExecutor();
    }

    public static Executor getIOThreadExecutor() {
        return sIOThreadExecutor;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ArchTaskExecutor getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (ArchTaskExecutor.class) {
            if (sInstance == null) {
                ArchTaskExecutor archTaskExecutor;
                sInstance = archTaskExecutor = new ArchTaskExecutor();
            }
            return sInstance;
        }
    }

    public static Executor getMainThreadExecutor() {
        return sMainThreadExecutor;
    }

    static /* synthetic */ void lambda$static$0(Runnable runnable2) {
        ArchTaskExecutor.getInstance().postToMainThread(runnable2);
    }

    static /* synthetic */ void lambda$static$1(Runnable runnable2) {
        ArchTaskExecutor.getInstance().executeOnDiskIO(runnable2);
    }

    @Override
    public void executeOnDiskIO(Runnable runnable2) {
        this.mDelegate.executeOnDiskIO(runnable2);
    }

    @Override
    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }

    @Override
    public void postToMainThread(Runnable runnable2) {
        this.mDelegate.postToMainThread(runnable2);
    }

    public void setDelegate(TaskExecutor taskExecutor) {
        if (taskExecutor == null) {
            taskExecutor = this.mDefaultTaskExecutor;
        }
        this.mDelegate = taskExecutor;
    }
}

