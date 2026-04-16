/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import kotlinx.coroutines.scheduling.TaskContext;
import kotlinx.coroutines.scheduling.TasksKt;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0010\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\u001c\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0016J)\u0010\u0019\u001a\u00020\u00112\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010\u0014\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000\u00a2\u0006\u0002\b\u001dJ\u001c\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0016J\r\u0010\u001f\u001a\u00020\u0011H\u0000\u00a2\u0006\u0002\b J\u0015\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b#J\r\u0010$\u001a\u00020\u0011H\u0000\u00a2\u0006\u0002\b%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2={"Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "(IIJLjava/lang/String;)V", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "close", "", "createScheduler", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchWithContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "tailDispatch", "", "dispatchWithContext$kotlinx_coroutines_core", "dispatchYield", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "shutdown$kotlinx_coroutines_core", "usePrivateScheduler", "usePrivateScheduler$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public class SchedulerCoroutineDispatcher
extends ExecutorCoroutineDispatcher {
    private final int corePoolSize;
    private CoroutineScheduler coroutineScheduler;
    private final long idleWorkerKeepAliveNs;
    private final int maxPoolSize;
    private final String schedulerName;

    public SchedulerCoroutineDispatcher() {
        this(0, 0, 0L, null, 15, null);
    }

    public SchedulerCoroutineDispatcher(int n, int n2, long l, String string2) {
        this.corePoolSize = n;
        this.maxPoolSize = n2;
        this.idleWorkerKeepAliveNs = l;
        this.schedulerName = string2;
        this.coroutineScheduler = this.createScheduler();
    }

    public /* synthetic */ SchedulerCoroutineDispatcher(int n, int n2, long l, String string2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            n = TasksKt.CORE_POOL_SIZE;
        }
        if ((n3 & 2) != 0) {
            n2 = TasksKt.MAX_POOL_SIZE;
        }
        if ((n3 & 4) != 0) {
            l = TasksKt.IDLE_WORKER_KEEP_ALIVE_NS;
        }
        if ((n3 & 8) != 0) {
            string2 = "CoroutineScheduler";
        }
        this(n, n2, l, string2);
    }

    private final CoroutineScheduler createScheduler() {
        return new CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, this.schedulerName);
    }

    @Override
    public void close() {
        this.coroutineScheduler.close();
    }

    @Override
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable2) {
        CoroutineScheduler.dispatch$default(this.coroutineScheduler, runnable2, null, false, 6, null);
    }

    public final void dispatchWithContext$kotlinx_coroutines_core(Runnable runnable2, TaskContext taskContext, boolean bl) {
        this.coroutineScheduler.dispatch(runnable2, taskContext, bl);
    }

    @Override
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable2) {
        CoroutineScheduler.dispatch$default(this.coroutineScheduler, runnable2, null, true, 2, null);
    }

    @Override
    public Executor getExecutor() {
        return this.coroutineScheduler;
    }

    public final void restore$kotlinx_coroutines_core() {
        this.usePrivateScheduler$kotlinx_coroutines_core();
    }

    public final void shutdown$kotlinx_coroutines_core(long l) {
        synchronized (this) {
            this.coroutineScheduler.shutdown(l);
            return;
        }
    }

    public final void usePrivateScheduler$kotlinx_coroutines_core() {
        synchronized (this) {
            this.coroutineScheduler.shutdown(1000L);
            this.coroutineScheduler = this.createScheduler();
            return;
        }
    }
}

