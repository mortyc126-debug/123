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
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoopImplPlatform;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00020\u00012\u00020\u0002:\u00043456B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aH\u0002J\u001a\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u0019j\u0002`\u001aJ\u0014\u0010\u001f\u001a\u00020\u00172\n\u0010 \u001a\u00060\u0019j\u0002`\u001aH\u0016J\u0014\u0010!\u001a\u00020\f2\n\u0010 \u001a\u00060\u0019j\u0002`\u001aH\u0002J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0004J\u0016\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u00020*2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(H\u0002J\u001c\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00132\n\u0010\u001e\u001a\u00060\u0019j\u0002`\u001aH\u0004J\u001e\u0010.\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00132\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001700H\u0016J\u0010\u00101\u001a\u00020\f2\u0006\u0010 \u001a\u00020(H\u0002J\b\u00102\u001a\u00020\u0017H\u0016R\u0011\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004R\t\u0010\u0007\u001a\u00020\bX\u0082\u0004R\u0011\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005X\u0082\u0004R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\f8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00138TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u00067"}, d2={"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;", "()V", "_delayed", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "_isCompleted", "Lkotlinx/atomicfu/AtomicBoolean;", "_queue", "", "value", "", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "nextTime", "", "getNextTime", "()J", "closeQueue", "", "dequeue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "enqueue", "task", "enqueueImpl", "processNextEvent", "rescheduleAllDelayed", "resetAll", "schedule", "now", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "scheduleImpl", "", "scheduleInvokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "shouldUnpark", "shutdown", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class EventLoopImplBase
extends EventLoopImplPlatform
implements Delay {
    private static final AtomicReferenceFieldUpdater _delayed$FU;
    private static final AtomicIntegerFieldUpdater _isCompleted$FU;
    private static final AtomicReferenceFieldUpdater _queue$FU;
    @Volatile
    private volatile Object _delayed;
    @Volatile
    private volatile int _isCompleted = 0;
    @Volatile
    private volatile Object _queue;

    static {
        _queue$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");
        _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
        _isCompleted$FU = AtomicIntegerFieldUpdater.newUpdater(EventLoopImplBase.class, "_isCompleted");
    }

    public static final /* synthetic */ boolean access$isCompleted(EventLoopImplBase eventLoopImplBase) {
        return eventLoopImplBase.isCompleted();
    }

    private final void closeQueue() {
        if (DebugKt.getASSERTIONS_ENABLED() && !this.isCompleted()) {
            throw new AssertionError();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$FU;
        while (true) {
            Object v;
            if ((v = atomicReferenceFieldUpdater.get(this)) == null) {
                if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_queue$FU, this, null, EventLoop_commonKt.access$getCLOSED_EMPTY$p())) continue;
                return;
            }
            if (v instanceof LockFreeTaskQueueCore) {
                ((LockFreeTaskQueueCore)v).close();
                return;
            }
            if (v == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return;
            }
            LockFreeTaskQueueCore<Runnable> lockFreeTaskQueueCore = new LockFreeTaskQueueCore<Runnable>(8, true);
            Intrinsics.checkNotNull(v, (String)"null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
            lockFreeTaskQueueCore.addLast((Runnable)v);
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_queue$FU, this, v, lockFreeTaskQueueCore)) break;
        }
    }

    private final Runnable dequeue() {
        Object v;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$FU;
        while (true) {
            if ((v = atomicReferenceFieldUpdater.get(this)) == null) {
                return null;
            }
            if (v instanceof LockFreeTaskQueueCore) {
                Intrinsics.checkNotNull(v, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                Object object = ((LockFreeTaskQueueCore)v).removeFirstOrNull();
                if (object != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                    return (Runnable)object;
                }
                AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_queue$FU, this, v, ((LockFreeTaskQueueCore)v).next());
                continue;
            }
            if (v == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return null;
            }
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_queue$FU, this, v, null)) break;
        }
        Intrinsics.checkNotNull(v, (String)"null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        return (Runnable)v;
    }

    private final boolean enqueueImpl(Runnable runnable2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$FU;
        while (true) {
            Object v = atomicReferenceFieldUpdater.get(this);
            if (this.isCompleted()) {
                return false;
            }
            if (v == null) {
                if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_queue$FU, this, null, runnable2)) continue;
                return true;
            }
            if (v instanceof LockFreeTaskQueueCore) {
                Intrinsics.checkNotNull(v, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                switch (((LockFreeTaskQueueCore)v).addLast(runnable2)) {
                    default: {
                        break;
                    }
                    case 2: {
                        return false;
                    }
                    case 1: {
                        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_queue$FU, this, v, ((LockFreeTaskQueueCore)v).next());
                        break;
                    }
                    case 0: {
                        return true;
                    }
                }
                continue;
            }
            if (v == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return false;
            }
            LockFreeTaskQueueCore<Runnable> lockFreeTaskQueueCore = new LockFreeTaskQueueCore<Runnable>(8, true);
            Intrinsics.checkNotNull(v, (String)"null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
            lockFreeTaskQueueCore.addLast((Runnable)v);
            lockFreeTaskQueueCore.addLast(runnable2);
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_queue$FU, this, v, lockFreeTaskQueueCore)) break;
        }
        return true;
    }

    private final boolean isCompleted() {
        boolean bl = _isCompleted$FU.get(this) != 0;
        return bl;
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1, Object object) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(object));
        }
    }

    private final void rescheduleAllDelayed() {
        Object object = AbstractTimeSourceKt.getTimeSource();
        long l = object != null ? ((AbstractTimeSource)object).nanoTime() : System.nanoTime();
        while ((object = (DelayedTaskQueue)_delayed$FU.get(this)) != null && (object = (DelayedTask)((ThreadSafeHeap)object).removeFirstOrNull()) != null) {
            this.reschedule(l, (DelayedTask)object);
        }
    }

    private final int scheduleImpl(long l, DelayedTask delayedTask) {
        if (this.isCompleted()) {
            return 1;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue)_delayed$FU.get(this);
        Object object = delayedTaskQueue;
        if (delayedTaskQueue == null) {
            object = this;
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_delayed$FU, object, null, new DelayedTaskQueue(l));
            object = _delayed$FU.get(object);
            Intrinsics.checkNotNull((Object)object);
            object = (DelayedTaskQueue)object;
        }
        return delayedTask.scheduleTask(l, (DelayedTaskQueue)object, this);
    }

    private final void setCompleted(boolean bl) {
        _isCompleted$FU.set(this, bl ? 1 : 0);
    }

    private final boolean shouldUnpark(DelayedTask delayedTask) {
        Object object = (DelayedTaskQueue)_delayed$FU.get(this);
        object = object != null ? (DelayedTask)((ThreadSafeHeap)object).peek() : null;
        boolean bl = object == delayedTask;
        return bl;
    }

    @Override
    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long l, Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, l, continuation);
    }

    @Override
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable2) {
        this.enqueue(runnable2);
    }

    public void enqueue(Runnable runnable2) {
        if (this.enqueueImpl(runnable2)) {
            this.unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(runnable2);
        }
    }

    @Override
    protected long getNextTime() {
        if (super.getNextTime() == 0L) {
            return 0L;
        }
        Object object = _queue$FU.get(this);
        if (object != null) {
            if (object instanceof LockFreeTaskQueueCore) {
                if (!((LockFreeTaskQueueCore)object).isEmpty()) {
                    return 0L;
                }
            } else {
                if (object == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                    return Long.MAX_VALUE;
                }
                return 0L;
            }
        }
        if ((object = (DelayedTaskQueue)_delayed$FU.get(this)) != null && (object = (DelayedTask)((ThreadSafeHeap)object).peek()) != null) {
            long l = ((DelayedTask)object).nanoTime;
            object = AbstractTimeSourceKt.getTimeSource();
            long l2 = object != null ? ((AbstractTimeSource)object).nanoTime() : System.nanoTime();
            return RangesKt.coerceAtLeast((long)(l - l2), (long)0L);
        }
        return Long.MAX_VALUE;
    }

    @Override
    public DisposableHandle invokeOnTimeout(long l, Runnable runnable2, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.invokeOnTimeout(this, l, runnable2, coroutineContext);
    }

    @Override
    protected boolean isEmpty() {
        boolean bl = this.isUnconfinedQueueEmpty();
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue)_delayed$FU.get(this);
        if (delayedTaskQueue != null && !delayedTaskQueue.isEmpty()) {
            return false;
        }
        delayedTaskQueue = _queue$FU.get(this);
        if (delayedTaskQueue == null) {
            bl2 = true;
        } else if (delayedTaskQueue instanceof LockFreeTaskQueueCore) {
            bl2 = ((LockFreeTaskQueueCore)((Object)delayedTaskQueue)).isEmpty();
        } else if (delayedTaskQueue == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public long processNextEvent() {
        Object object;
        if (this.processUnconfinedEvent()) {
            return 0L;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue)_delayed$FU.get(this);
        if (delayedTaskQueue != null && !delayedTaskQueue.isEmpty()) {
            object = AbstractTimeSourceKt.getTimeSource();
            long l = object != null ? ((AbstractTimeSource)object).nanoTime() : System.nanoTime();
            do {
                ThreadSafeHeap threadSafeHeap = delayedTaskQueue;
                synchronized (threadSafeHeap) {
                    object = threadSafeHeap.firstImpl();
                    if (object == null) {
                        // MONITOREXIT @DISABLED, blocks:[2, 3, 5, 6] lbl12 : MonitorExitStatement: MONITOREXIT : var6_5
                        object = null;
                        continue;
                    }
                    boolean bl = ((DelayedTask)(object = (DelayedTask)object)).timeToExecute(l) ? this.enqueueImpl((Runnable)object) : false;
                    object = bl ? threadSafeHeap.removeAtImpl(0) : null;
                }
            } while ((DelayedTask)object != null);
        }
        if ((object = this.dequeue()) != null) {
            object.run();
            return 0L;
        }
        return this.getNextTime();
    }

    protected final void resetAll() {
        _queue$FU.set(this, null);
        _delayed$FU.set(this, null);
    }

    public final void schedule(long l, DelayedTask delayedTask) {
        switch (this.scheduleImpl(l, delayedTask)) {
            default: {
                throw new IllegalStateException("unexpected result".toString());
            }
            case 2: {
                break;
            }
            case 1: {
                this.reschedule(l, delayedTask);
                break;
            }
            case 0: {
                if (!this.shouldUnpark(delayedTask)) break;
                this.unpark();
            }
        }
    }

    protected final DisposableHandle scheduleInvokeOnTimeout(long l, Runnable object) {
        long l2 = EventLoop_commonKt.delayToNanos(l);
        if (l2 < 0x3FFFFFFFFFFFFFFFL) {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
            l = abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime();
            object = new DelayedRunnableTask(l + l2, (Runnable)object);
            this.schedule(l, (DelayedTask)object);
            object = (DisposableHandle)object;
        } else {
            object = NonDisposableHandle.INSTANCE;
        }
        return object;
    }

    @Override
    public void scheduleResumeAfterDelay(long l, CancellableContinuation<? super Unit> cancellableContinuation) {
        long l2 = EventLoop_commonKt.delayToNanos(l);
        if (l2 < 0x3FFFFFFFFFFFFFFFL) {
            Object object = AbstractTimeSourceKt.getTimeSource();
            l = object != null ? ((AbstractTimeSource)object).nanoTime() : System.nanoTime();
            object = new DelayedResumeTask(this, l + l2, cancellableContinuation);
            this.schedule(l, (DelayedTask)object);
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuation, (DisposableHandle)object);
        }
    }

    @Override
    public void shutdown() {
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        this.setCompleted(true);
        this.closeQueue();
        while (this.processNextEvent() <= 0L) {
        }
        this.rescheduleAllDelayed();
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private final class DelayedResumeTask
    extends DelayedTask {
        private final CancellableContinuation<Unit> cont;
        final EventLoopImplBase this$0;

        public DelayedResumeTask(EventLoopImplBase eventLoopImplBase, long l, CancellableContinuation<? super Unit> cancellableContinuation) {
            this.this$0 = eventLoopImplBase;
            super(l);
            this.cont = cancellableContinuation;
        }

        @Override
        public void run() {
            this.cont.resumeUndispatched(this.this$0, Unit.INSTANCE);
        }

        @Override
        public String toString() {
            return super.toString() + this.cont;
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private static final class DelayedRunnableTask
    extends DelayedTask {
        private final Runnable block;

        public DelayedRunnableTask(long l, Runnable runnable2) {
            super(l);
            this.block = runnable2;
        }

        @Override
        public void run() {
            this.block.run();
        }

        @Override
        public String toString() {
            return super.toString() + this.block;
        }
    }

    @Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u00052\u00060\u0006j\u0002`\u0007B\r\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u001e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\tJ\b\u0010%\u001a\u00020&H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R0\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "nanoTime", "", "(J)V", "_heap", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    public static abstract class DelayedTask
    implements Runnable,
    Comparable<DelayedTask>,
    DisposableHandle,
    ThreadSafeHeapNode {
        private volatile Object _heap;
        private int index;
        public long nanoTime;

        public DelayedTask(long l) {
            this.nanoTime = l;
            this.index = -1;
        }

        @Override
        public int compareTo(DelayedTask delayedTask) {
            long l = this.nanoTime - delayedTask.nanoTime;
            int n = l > 0L ? 1 : (l < 0L ? -1 : 0);
            return n;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public final void dispose() {
            synchronized (this) {
                Object object = this._heap;
                Object object2 = EventLoop_commonKt.access$getDISPOSED_TASK$p();
                if (object == object2) {
                    return;
                }
                object2 = object instanceof DelayedTaskQueue ? (DelayedTaskQueue)object : null;
                if (object2 != null) {
                    ((ThreadSafeHeap)object2).remove((ThreadSafeHeapNode)this);
                }
                this._heap = EventLoop_commonKt.access$getDISPOSED_TASK$p();
                object2 = Unit.INSTANCE;
                return;
            }
        }

        @Override
        public ThreadSafeHeap<?> getHeap() {
            ThreadSafeHeap threadSafeHeap = this._heap;
            threadSafeHeap = threadSafeHeap instanceof ThreadSafeHeap ? (ThreadSafeHeap)threadSafeHeap : null;
            return threadSafeHeap;
        }

        @Override
        public int getIndex() {
            return this.index;
        }

        /*
         * Unable to fully structure code
         */
        public final int scheduleTask(long var1_1, DelayedTaskQueue var3_2, EventLoopImplBase var4_11) {
            synchronized (this) {
                block18: {
                    var9_12 = this._heap;
                    var8_13 = EventLoop_commonKt.access$getDISPOSED_TASK$p();
                    if (var9_12 != var8_13) break block18;
                    return 2;
                }
                try {
                    var8_13 = var3_2;
                    ** synchronized (var8_13)
                }
                catch (Throwable var3_9) {
                    // empty catch block
                }
lbl-1000:
                // 1 sources

                {
                    block20: {
                        block21: {
                            block23: {
                                block19: {
                                    var9_12 = (DelayedTask)var8_13.firstImpl();
                                    var7_14 = EventLoopImplBase.access$isCompleted(var4_11);
                                    if (!var7_14) break block19;
                                    try {
                                        return 1;
                                    }
                                    catch (Throwable var3_3) {}
                                    ** break block22
                                }
                                if (var9_12 != null) break block23;
                                try {
                                    var3_2.timeNow = var1_1;
                                    ** GOTO lbl37
                                }
                                catch (Throwable var3_4) {
                                    break block20;
                                }
                            }
                            var5_15 = var9_12.nanoTime;
                            if (var5_15 - var1_1 >= 0L) break block21;
                            var1_1 = var5_15;
                        }
                        var5_15 = var3_2.timeNow;
                        if (var1_1 - var5_15 <= 0L) ** GOTO lbl37
                        try {
                            var3_2.timeNow = var1_1;
lbl37:
                            // 3 sources

                            if (this.nanoTime - var3_2.timeNow < 0L) {
                                this.nanoTime = var3_2.timeNow;
                            }
                            var8_13.addImpl((ThreadSafeHeapNode)this);
                            return 0;
                        }
                        catch (Throwable var3_5) {}
                        break block20;
                        catch (Throwable var3_6) {
                            // empty catch block
                        }
                    }
                    try {
                        throw var3_7;
                    }
                    catch (Throwable var3_8) {}
                }
lbl-1000:
                // 3 sources

                {
                    throw var3_10;
                }
            }
        }

        @Override
        public void setHeap(ThreadSafeHeap<?> threadSafeHeap) {
            boolean bl = this._heap != EventLoop_commonKt.access$getDISPOSED_TASK$p();
            if (bl) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override
        public void setIndex(int n) {
            this.index = n;
        }

        public final boolean timeToExecute(long l) {
            boolean bl = l - this.nanoTime >= 0L;
            return bl;
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class DelayedTaskQueue
    extends ThreadSafeHeap<DelayedTask> {
        public long timeNow;

        public DelayedTaskQueue(long l) {
            this.timeNow = l;
        }
    }
}

