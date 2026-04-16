/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KFunction
 */
package kotlinx.coroutines.sync;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.ChannelSegment$$ExternalSyntheticBackportWithForwarding0;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreImpl;
import kotlinx.coroutines.sync.SemaphoreKt;
import kotlinx.coroutines.sync.SemaphoreSegment;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\u0016\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017Jb\u0010\u0016\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0019\u001a\u0002H\u00182!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u0011H\u0018\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001d0\u00122!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u0011H\u0018\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00140\u0012H\u0083\b\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010\u0016\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140 H\u0005J\u0011\u0010!\u001a\u00020\u0014H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0014H\u0002J\b\u0010%\u001a\u00020\u0003H\u0002J\u001e\u0010&\u001a\u00020\u00142\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0004J\b\u0010+\u001a\u00020\u0014H\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020\u001dH\u0002J\f\u0010.\u001a\u00020\u001d*\u00020*H\u0002R\t\u0010\u0006\u001a\u00020\u0007X\u0082\u0004R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\t\u0010\r\u001a\u00020\fX\u0082\u0004R\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006/"}, d2={"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "", "acquiredPermits", "(II)V", "_availablePermits", "Lkotlinx/atomicfu/AtomicInt;", "availablePermits", "getAvailablePermits", "()I", "deqIdx", "Lkotlinx/atomicfu/AtomicLong;", "enqIdx", "head", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "onCancellationRelease", "Lkotlin/Function1;", "", "", "tail", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "W", "waiter", "suspend", "Lkotlin/ParameterName;", "name", "", "onAcquired", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancellableContinuation;", "acquireSlowPath", "addAcquireToQueue", "Lkotlinx/coroutines/Waiter;", "coerceAvailablePermitsAtMaximum", "decPermits", "onAcquireRegFunction", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "ignoredParam", "", "release", "tryAcquire", "tryResumeNextFromQueue", "tryResumeAcquire", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public class SemaphoreImpl
implements Semaphore {
    private static final AtomicIntegerFieldUpdater _availablePermits$FU;
    private static final AtomicLongFieldUpdater deqIdx$FU;
    private static final AtomicLongFieldUpdater enqIdx$FU;
    private static final AtomicReferenceFieldUpdater head$FU;
    private static final AtomicReferenceFieldUpdater tail$FU;
    @Volatile
    private volatile int _availablePermits;
    @Volatile
    private volatile long deqIdx;
    @Volatile
    private volatile long enqIdx;
    @Volatile
    private volatile Object head;
    private final Function1<Throwable, Unit> onCancellationRelease;
    private final int permits;
    @Volatile
    private volatile Object tail;

    static {
        head$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
        deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
        tail$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
        enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
        _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");
    }

    public SemaphoreImpl(int n, int n2) {
        n = this.permits = n;
        int n3 = 1;
        n = n > 0 ? 1 : 0;
        if (n != 0) {
            n = n2 >= 0 && n2 <= this.permits ? n3 : 0;
            if (n != 0) {
                SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
                this.head = semaphoreSegment;
                this.tail = semaphoreSegment;
                this._availablePermits = this.permits - n2;
                this.onCancellationRelease = (Function1)new Function1<Throwable, Unit>(this){
                    final SemaphoreImpl this$0;
                    {
                        this.this$0 = semaphoreImpl;
                        super(1);
                    }

                    public final void invoke(Throwable throwable) {
                        this.this$0.release();
                    }
                };
                return;
            }
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + this.permits).toString());
        }
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + this.permits).toString());
    }

    public static final /* synthetic */ Object access$acquireSlowPath(SemaphoreImpl semaphoreImpl, Continuation continuation) {
        return semaphoreImpl.acquireSlowPath((Continuation<? super Unit>)continuation);
    }

    private final <W> void acquire(W w, Function1<? super W, Boolean> function1, Function1<? super W, Unit> function12) {
        do {
            if (this.decPermits() <= 0) continue;
            function12.invoke(w);
            return;
        } while (!((Boolean)function1.invoke(w)).booleanValue());
    }

    static /* synthetic */ Object acquire$suspendImpl(SemaphoreImpl object, Continuation<? super Unit> continuation) {
        if (((SemaphoreImpl)object).decPermits() > 0) {
            return Unit.INSTANCE;
        }
        if ((object = ((SemaphoreImpl)object).acquireSlowPath(continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final Object acquireSlowPath(Continuation<? super Unit> continuation) {
        Object object;
        block4: {
            object = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
            try {
                if (this.addAcquireToQueue((Waiter)object)) break block4;
                this.acquire((CancellableContinuation)object);
            }
            catch (Throwable throwable) {
                ((CancellableContinuationImpl)object).releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw throwable;
            }
        }
        if ((object = ((CancellableContinuationImpl)object).getResult()) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final boolean addAcquireToQueue(Waiter waiter) {
        int n;
        Object object;
        block15: {
            block18: {
                block17: {
                    block16: {
                        Object object2;
                        Object object3;
                        Object object4 = (SemaphoreSegment)tail$FU.get(this);
                        long l = enqIdx$FU.getAndIncrement(this);
                        KFunction kFunction = (KFunction)addAcquireToQueue.createNewSegment.1.INSTANCE;
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = tail$FU;
                        long l2 = l / (long)SemaphoreKt.access$getSEGMENT_SIZE$p();
                        block0: while (!SegmentOrClosed.isClosed-impl(object3 = ConcurrentLinkedListKt.findSegmentInternal((Segment)object4, l2, (Function2)kFunction))) {
                            object = SegmentOrClosed.getSegment-impl(object3);
                            boolean bl = false;
                            while (true) {
                                block14: {
                                    block12: {
                                        block13: {
                                            block11: {
                                                object2 = (Segment)atomicReferenceFieldUpdater.get(this);
                                                if (((Segment)object2).id < ((Segment)object).id) break block11;
                                                n = 1;
                                                break block12;
                                            }
                                            if (((Segment)object).tryIncPointers$kotlinx_coroutines_core()) break block13;
                                            n = 0;
                                            break block12;
                                        }
                                        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, object2, object)) break block14;
                                        if (((Segment)object2).decPointers$kotlinx_coroutines_core()) {
                                            ((ConcurrentLinkedListNode)object2).remove();
                                        }
                                        n = 1;
                                    }
                                    if (n == 0) continue block0;
                                    break block0;
                                }
                                if (!((Segment)object).decPointers$kotlinx_coroutines_core()) continue;
                                ((ConcurrentLinkedListNode)object).remove();
                            }
                        }
                        object = (SemaphoreSegment)SegmentOrClosed.getSegment-impl(object3);
                        n = (int)(l % (long)SemaphoreKt.access$getSEGMENT_SIZE$p());
                        if (ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(((SemaphoreSegment)object).getAcquirers(), n, null, waiter)) {
                            waiter.invokeOnCancellation((Segment)object, n);
                            return true;
                        }
                        object4 = SemaphoreKt.access$getPERMIT$p();
                        object2 = SemaphoreKt.access$getTAKEN$p();
                        if (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(((SemaphoreSegment)object).getAcquirers(), n, object4, object2)) break block15;
                        if (!(waiter instanceof CancellableContinuation)) break block16;
                        Intrinsics.checkNotNull((Object)waiter, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                        object2 = (CancellableContinuation)((Object)waiter);
                        ((CancellableContinuation)((Object)waiter)).resume(Unit.INSTANCE, this.onCancellationRelease);
                        break block17;
                    }
                    if (!(waiter instanceof SelectInstance)) break block18;
                    ((SelectInstance)((Object)waiter)).selectInRegistrationPhase(Unit.INSTANCE);
                }
                return true;
            }
            throw new IllegalStateException(("unexpected: " + waiter).toString());
        }
        if (DebugKt.getASSERTIONS_ENABLED() && (n = ((SemaphoreSegment)object).getAcquirers().get(n) == SemaphoreKt.access$getBROKEN$p() ? 1 : 0) == 0) {
            throw new AssertionError();
        }
        return false;
    }

    private final void coerceAvailablePermitsAtMaximum() {
        int n;
        while ((n = _availablePermits$FU.get(this)) > this.permits && !_availablePermits$FU.compareAndSet(this, n, this.permits)) {
        }
    }

    private final int decPermits() {
        int n;
        while ((n = _availablePermits$FU.getAndDecrement(this)) > this.permits) {
        }
        return n;
    }

    private final boolean tryResumeAcquire(Object object) {
        block7: {
            boolean bl;
            block6: {
                block5: {
                    if (!(object instanceof CancellableContinuation)) break block5;
                    Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                    Object object2 = (CancellableContinuation)object;
                    object2 = ((CancellableContinuation)object).tryResume(Unit.INSTANCE, null, this.onCancellationRelease);
                    if (object2 != null) {
                        ((CancellableContinuation)object).completeResume(object2);
                        bl = true;
                    } else {
                        bl = false;
                    }
                    break block6;
                }
                if (!(object instanceof SelectInstance)) break block7;
                bl = ((SelectInstance)object).trySelect(this, Unit.INSTANCE);
            }
            return bl;
        }
        throw new IllegalStateException(("unexpected: " + object).toString());
    }

    private final boolean tryResumeNextFromQueue() {
        int n;
        Object object;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment)head$FU.get(this);
        long l = deqIdx$FU.getAndIncrement(this);
        long l2 = l / (long)SemaphoreKt.access$getSEGMENT_SIZE$p();
        Object object2 = (KFunction)tryResumeNextFromQueue.createNewSegment.1.INSTANCE;
        Object object3 = head$FU;
        block0: while (true) {
            object = ConcurrentLinkedListKt.findSegmentInternal((Segment)semaphoreSegment, l2, (Function2)object2);
            boolean bl = SegmentOrClosed.isClosed-impl(object);
            int n2 = 0;
            if (bl) break;
            Object s = SegmentOrClosed.getSegment-impl(object);
            bl = false;
            while (true) {
                block13: {
                    block11: {
                        Segment segment;
                        block12: {
                            block10: {
                                segment = (Segment)((AtomicReferenceFieldUpdater)object3).get(this);
                                long l3 = segment.id;
                                if (l3 < ((Segment)s).id) break block10;
                                n = 1;
                                break block11;
                            }
                            if (((Segment)s).tryIncPointers$kotlinx_coroutines_core()) break block12;
                            n = 0;
                            break block11;
                        }
                        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m((AtomicReferenceFieldUpdater)object3, this, segment, s)) break block13;
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                        n = 1;
                    }
                    if (n == 0) continue block0;
                    break block0;
                }
                if (!((Segment)s).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)s).remove();
            }
            break;
        }
        semaphoreSegment = (SemaphoreSegment)SegmentOrClosed.getSegment-impl(object);
        semaphoreSegment.cleanPrev();
        if (semaphoreSegment.id > l2) {
            return false;
        }
        int n3 = (int)(l % (long)SemaphoreKt.access$getSEGMENT_SIZE$p());
        object2 = SemaphoreKt.access$getPERMIT$p();
        object2 = semaphoreSegment.getAcquirers().getAndSet(n3, object2);
        if (object2 == null) {
            int n4 = SemaphoreKt.access$getMAX_SPIN_CYCLES$p();
            for (n = n2; n < n4; ++n) {
                if (semaphoreSegment.getAcquirers().get(n3) != SemaphoreKt.access$getTAKEN$p()) continue;
                return true;
            }
            object3 = SemaphoreKt.access$getPERMIT$p();
            object2 = SemaphoreKt.access$getBROKEN$p();
            return ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(semaphoreSegment.getAcquirers(), n3, object3, object2) ^ true;
        }
        if (object2 == SemaphoreKt.access$getCANCELLED$p()) {
            return false;
        }
        return this.tryResumeAcquire(object2);
    }

    @Override
    public Object acquire(Continuation<? super Unit> continuation) {
        return SemaphoreImpl.acquire$suspendImpl(this, continuation);
    }

    protected final void acquire(CancellableContinuation<? super Unit> cancellableContinuation) {
        do {
            if (this.decPermits() > 0) {
                cancellableContinuation.resume((Unit)Unit.INSTANCE, this.onCancellationRelease);
                break;
            }
            Intrinsics.checkNotNull(cancellableContinuation, (String)"null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        } while (!this.addAcquireToQueue((Waiter)((Object)cancellableContinuation)));
    }

    @Override
    public int getAvailablePermits() {
        return Math.max(_availablePermits$FU.get(this), 0);
    }

    protected final void onAcquireRegFunction(SelectInstance<?> selectInstance, Object object) {
        do {
            if (this.decPermits() > 0) {
                selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
                break;
            }
            Intrinsics.checkNotNull(selectInstance, (String)"null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        } while (!this.addAcquireToQueue((Waiter)((Object)selectInstance)));
    }

    @Override
    public void release() {
        int n;
        while ((n = _availablePermits$FU.getAndIncrement(this)) < this.permits) {
            if (n >= 0) {
                return;
            }
            if (!this.tryResumeNextFromQueue()) continue;
            return;
        }
        this.coerceAvailablePermitsAtMaximum();
        throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
    }

    @Override
    public boolean tryAcquire() {
        while (true) {
            int n;
            if ((n = _availablePermits$FU.get(this)) > this.permits) {
                this.coerceAvailablePermitsAtMaximum();
                continue;
            }
            if (n <= 0) {
                return false;
            }
            if (_availablePermits$FU.compareAndSet(this, n, n - 1)) break;
        }
        return true;
    }
}

