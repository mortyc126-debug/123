/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.Volatile
 */
package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher;
import kotlinx.coroutines.scheduling.TaskContext;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u001c\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u00060\u0013j\u0002`\u0014H\u0016J\u001c\u0010\u001a\u001a\u00020\u00182\n\u0010\u001d\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001c\u0010 \u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u00060\u0013j\u0002`\u0014H\u0016J\u0014\u0010!\u001a\u00020\u00182\n\u0010\"\u001a\u00060\u0013j\u0002`\u0014H\u0016J\b\u0010#\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\t\u0010\u000f\u001a\u00020\u0010X\u0082\u0004R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0013j\u0002`\u00140\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006$"}, d2={"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;", "Ljava/util/concurrent/Executor;", "dispatcher", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "parallelism", "", "name", "", "taskMode", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;ILjava/lang/String;I)V", "executor", "getExecutor", "()Ljava/util/concurrent/Executor;", "inFlightTasks", "Lkotlinx/atomicfu/AtomicInt;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "getTaskMode", "()I", "afterTask", "", "close", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "tailDispatch", "", "dispatchYield", "execute", "command", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class LimitingDispatcher
extends ExecutorCoroutineDispatcher
implements TaskContext,
Executor {
    private static final AtomicIntegerFieldUpdater inFlightTasks$FU = AtomicIntegerFieldUpdater.newUpdater(LimitingDispatcher.class, "inFlightTasks");
    private final ExperimentalCoroutineDispatcher dispatcher;
    @Volatile
    private volatile int inFlightTasks;
    private final String name;
    private final int parallelism;
    private final ConcurrentLinkedQueue<Runnable> queue;
    private final int taskMode;

    public LimitingDispatcher(ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int n, String string2, int n2) {
        this.dispatcher = experimentalCoroutineDispatcher;
        this.parallelism = n;
        this.name = string2;
        this.taskMode = n2;
        this.queue = new ConcurrentLinkedQueue();
    }

    private final void dispatch(Runnable runnable2, boolean bl) {
        do {
            if (inFlightTasks$FU.incrementAndGet(this) <= this.parallelism) {
                this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(runnable2, this, bl);
                return;
            }
            this.queue.add(runnable2);
            if (inFlightTasks$FU.decrementAndGet(this) < this.parallelism) continue;
            return;
        } while ((runnable2 = this.queue.poll()) != null);
    }

    @Override
    public void afterTask() {
        Runnable runnable2 = this.queue.poll();
        if (runnable2 != null) {
            this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(runnable2, this, true);
            return;
        }
        inFlightTasks$FU.decrementAndGet(this);
        runnable2 = this.queue.poll();
        if (runnable2 == null) {
            return;
        }
        this.dispatch(runnable2, true);
    }

    @Override
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable2) {
        this.dispatch(runnable2, false);
    }

    @Override
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable2) {
        this.dispatch(runnable2, true);
    }

    @Override
    public void execute(Runnable runnable2) {
        this.dispatch(runnable2, false);
    }

    @Override
    public Executor getExecutor() {
        return this;
    }

    @Override
    public int getTaskMode() {
        return this.taskMode;
    }

    @Override
    public String toString() {
        String string2;
        String string3 = string2 = this.name;
        if (string2 == null) {
            string3 = super.toString() + "[dispatcher = " + this.dispatcher + ']';
        }
        return string3;
    }
}

