/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import kotlinx.coroutines.scheduling.LimitingDispatcher;
import kotlinx.coroutines.scheduling.TaskContext;
import kotlinx.coroutines.scheduling.TasksKt;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0011\u0018\u00002\u00020\u0001B%\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u001b\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0002J\u001c\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0016J)\u0010\u001e\u001a\u00020\u00162\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001d2\u0006\u0010\u0019\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0000\u00a2\u0006\u0002\b\"J\u001c\u0010#\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0016J\u000e\u0010$\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003J\b\u0010%\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2={"Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "corePoolSize", "", "maxPoolSize", "schedulerName", "", "(IILjava/lang/String;)V", "(II)V", "idleWorkerKeepAliveNs", "", "(IIJLjava/lang/String;)V", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "blocking", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "close", "", "createScheduler", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchWithContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "tailDispatch", "", "dispatchWithContext$kotlinx_coroutines_core", "dispatchYield", "limited", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public class ExperimentalCoroutineDispatcher
extends ExecutorCoroutineDispatcher {
    private final int corePoolSize;
    private CoroutineScheduler coroutineScheduler;
    private final long idleWorkerKeepAliveNs;
    private final int maxPoolSize;
    private final String schedulerName;

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility for Ktor 1.0-beta")
    public /* synthetic */ ExperimentalCoroutineDispatcher(int n, int n2) {
        this(n, n2, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, null, 8, null);
    }

    public /* synthetic */ ExperimentalCoroutineDispatcher(int n, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            n = TasksKt.CORE_POOL_SIZE;
        }
        if ((n3 & 2) != 0) {
            n2 = TasksKt.MAX_POOL_SIZE;
        }
        this(n, n2);
    }

    public ExperimentalCoroutineDispatcher(int n, int n2, long l, String string2) {
        this.corePoolSize = n;
        this.maxPoolSize = n2;
        this.idleWorkerKeepAliveNs = l;
        this.schedulerName = string2;
        this.coroutineScheduler = this.createScheduler();
    }

    public /* synthetic */ ExperimentalCoroutineDispatcher(int n, int n2, long l, String string2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 8) != 0) {
            string2 = "CoroutineScheduler";
        }
        this(n, n2, l, string2);
    }

    public ExperimentalCoroutineDispatcher(int n, int n2, String string2) {
        this(n, n2, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, string2);
    }

    public /* synthetic */ ExperimentalCoroutineDispatcher(int n, int n2, String string2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            n = TasksKt.CORE_POOL_SIZE;
        }
        if ((n3 & 2) != 0) {
            n2 = TasksKt.MAX_POOL_SIZE;
        }
        if ((n3 & 4) != 0) {
            string2 = TasksKt.DEFAULT_SCHEDULER_NAME;
        }
        this(n, n2, string2);
    }

    public static /* synthetic */ CoroutineDispatcher blocking$default(ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int n, int n2, Object object) {
        if (object == null) {
            if ((n2 & 1) != 0) {
                n = 16;
            }
            return experimentalCoroutineDispatcher.blocking(n);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
    }

    private final CoroutineScheduler createScheduler() {
        return new CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, this.schedulerName);
    }

    public final CoroutineDispatcher blocking(int n) {
        boolean bl = n > 0;
        if (bl) {
            return new LimitingDispatcher(this, n, null, 1);
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + n).toString());
    }

    @Override
    public void close() {
        this.coroutineScheduler.close();
    }

    @Override
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable2) {
        try {
            CoroutineScheduler.dispatch$default(this.coroutineScheduler, runnable2, null, false, 6, null);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            DefaultExecutor.INSTANCE.dispatch(coroutineContext, runnable2);
        }
    }

    public final void dispatchWithContext$kotlinx_coroutines_core(Runnable runnable2, TaskContext taskContext, boolean bl) {
        try {
            this.coroutineScheduler.dispatch(runnable2, taskContext, bl);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            DefaultExecutor.INSTANCE.enqueue(this.coroutineScheduler.createTask(runnable2, taskContext));
        }
    }

    @Override
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable2) {
        try {
            CoroutineScheduler.dispatch$default(this.coroutineScheduler, runnable2, null, true, 2, null);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            DefaultExecutor.INSTANCE.dispatchYield(coroutineContext, runnable2);
        }
    }

    @Override
    public Executor getExecutor() {
        return this.coroutineScheduler;
    }

    public final CoroutineDispatcher limited(int n) {
        boolean bl = true;
        boolean bl2 = n > 0;
        if (bl2) {
            bl2 = n <= this.corePoolSize ? bl : false;
            if (bl2) {
                return new LimitingDispatcher(this, n, null, 0);
            }
            throw new IllegalArgumentException(("Expected parallelism level lesser than core pool size (" + this.corePoolSize + "), but have " + n).toString());
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + n).toString());
    }

    @Override
    public String toString() {
        return super.toString() + "[scheduler = " + this.coroutineScheduler + ']';
    }
}

