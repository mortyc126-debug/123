/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import kotlinx.coroutines.internal.LockFreeTaskQueue;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0097A\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\tj\u0002`\nH\u0016J-\u0010\u0019\u001a\u00020\u00112\n\u0010\u0018\u001a\u00060\tj\u0002`\n2\u0016\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u001cR\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u001bH\u0082\bJ\u001c\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\tj\u0002`\nH\u0017J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00132\n\u0010\u0018\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0096\u0001J\u0010\u0010!\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\"\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0002J\u001f\u0010#\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00132\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110%H\u0096\u0001J\b\u0010&\u001a\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u0012\u0010\r\u001a\u00060\u000ej\u0002`\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2={"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "dispatcher", "parallelism", "", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", "queue", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "runningWorkers", "Lkotlinx/atomicfu/AtomicInt;", "workerAllocationLock", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "dispatchInternal", "startWorker", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "dispatchYield", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "limitedParallelism", "obtainTaskOrDeallocateWorker", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "tryAllocateWorker", "", "Worker", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class LimitedDispatcher
extends CoroutineDispatcher
implements Delay {
    private static final AtomicIntegerFieldUpdater runningWorkers$FU = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers");
    private final Delay $$delegate_0;
    private final CoroutineDispatcher dispatcher;
    private final int parallelism;
    private final LockFreeTaskQueue<Runnable> queue;
    @Volatile
    private volatile int runningWorkers;
    private final Object workerAllocationLock;

    public LimitedDispatcher(CoroutineDispatcher object, int n) {
        this.dispatcher = object;
        this.parallelism = n;
        object = object instanceof Delay ? (Delay)object : null;
        Object object2 = object;
        if (object == null) {
            object2 = DefaultExecutorKt.getDefaultDelay();
        }
        this.$$delegate_0 = object2;
        this.queue = new LockFreeTaskQueue(false);
        this.workerAllocationLock = new Object();
    }

    private final void dispatchInternal(Runnable runnable2, Function1<? super Worker, Unit> function1) {
        this.queue.addLast(runnable2);
        if (runningWorkers$FU.get(this) >= this.parallelism) {
            return;
        }
        if (!this.tryAllocateWorker()) {
            return;
        }
        runnable2 = this.obtainTaskOrDeallocateWorker();
        if (runnable2 == null) {
            return;
        }
        function1.invoke((Object)new Worker(this, runnable2));
    }

    private final Runnable obtainTaskOrDeallocateWorker() {
        Runnable runnable2;
        while ((runnable2 = this.queue.removeFirstOrNull()) == null) {
            Object object = this.workerAllocationLock;
            synchronized (object) {
                block5: {
                    runningWorkers$FU.decrementAndGet(this);
                    int n = this.queue.getSize();
                    if (n != 0) break block5;
                    return null;
                }
                runningWorkers$FU.incrementAndGet(this);
            }
        }
        return runnable2;
    }

    private final boolean tryAllocateWorker() {
        Object object = this.workerAllocationLock;
        synchronized (object) {
            block4: {
                int n = runningWorkers$FU.get(this);
                int n2 = this.parallelism;
                if (n < n2) break block4;
                return false;
            }
            runningWorkers$FU.incrementAndGet(this);
            return true;
        }
    }

    @Override
    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long l, Continuation<? super Unit> continuation) {
        return this.$$delegate_0.delay(l, continuation);
    }

    @Override
    public void dispatch(CoroutineContext object, Runnable runnable2) {
        this.queue.addLast(runnable2);
        if (runningWorkers$FU.get(this) < this.parallelism && this.tryAllocateWorker() && (object = this.obtainTaskOrDeallocateWorker()) != null) {
            object = new Worker(this, (Runnable)object);
            this.dispatcher.dispatch((CoroutineContext)this, (Runnable)object);
        }
    }

    @Override
    public void dispatchYield(CoroutineContext object, Runnable runnable2) {
        this.queue.addLast(runnable2);
        if (runningWorkers$FU.get(this) < this.parallelism && this.tryAllocateWorker() && (object = this.obtainTaskOrDeallocateWorker()) != null) {
            object = new Worker(this, (Runnable)object);
            this.dispatcher.dispatchYield((CoroutineContext)this, (Runnable)object);
        }
    }

    @Override
    public DisposableHandle invokeOnTimeout(long l, Runnable runnable2, CoroutineContext coroutineContext) {
        return this.$$delegate_0.invokeOnTimeout(l, runnable2, coroutineContext);
    }

    @Override
    public CoroutineDispatcher limitedParallelism(int n) {
        LimitedDispatcherKt.checkParallelism(n);
        if (n >= this.parallelism) {
            return this;
        }
        return super.limitedParallelism(n);
    }

    @Override
    public void scheduleResumeAfterDelay(long l, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.$$delegate_0.scheduleResumeAfterDelay(l, cancellableContinuation);
    }

    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "currentTask", "(Lkotlinx/coroutines/internal/LimitedDispatcher;Ljava/lang/Runnable;)V", "run", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private final class Worker
    implements Runnable {
        private Runnable currentTask;
        final LimitedDispatcher this$0;

        public Worker(LimitedDispatcher limitedDispatcher, Runnable runnable2) {
            this.this$0 = limitedDispatcher;
            this.currentTask = runnable2;
        }

        @Override
        public void run() {
            int n = 0;
            while (true) {
                int n2;
                try {
                    this.currentTask.run();
                }
                catch (Throwable throwable) {
                    CoroutineExceptionHandlerKt.handleCoroutineException((CoroutineContext)EmptyCoroutineContext.INSTANCE, throwable);
                }
                Runnable runnable2 = this.this$0.obtainTaskOrDeallocateWorker();
                if (runnable2 == null) {
                    return;
                }
                this.currentTask = runnable2;
                n = n2 = n + 1;
                if (n2 < 16) continue;
                n = n2;
                if (this.this$0.dispatcher.isDispatchNeeded((CoroutineContext)this.this$0)) break;
            }
            this.this$0.dispatcher.dispatch((CoroutineContext)this.this$0, this);
        }
    }
}

