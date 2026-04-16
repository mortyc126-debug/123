/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.flow;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u0011\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ'\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f0\u000e2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a2\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\bR\u0011\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2={"Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "()V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "allocateLocked", "", "flow", "awaitPending", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "freeLocked", "", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class StateFlowSlot
extends AbstractSharedFlowSlot<StateFlowImpl<?>> {
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");
    @Volatile
    private volatile Object _state;

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1, Object object) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(object));
        }
    }

    @Override
    public boolean allocateLocked(StateFlowImpl<?> stateFlowImpl) {
        if (_state$FU.get(this) != null) {
            return false;
        }
        _state$FU.set(this, StateFlowKt.access$getNONE$p());
        return true;
    }

    public final Object awaitPending(Continuation<? super Unit> continuation) {
        Object object = IntrinsicsKt.intercepted(continuation);
        boolean bl = true;
        object = new CancellableContinuationImpl(object, 1);
        ((CancellableContinuationImpl)object).initCancellability();
        CancellableContinuation cancellableContinuation = (CancellableContinuation)object;
        if (DebugKt.getASSERTIONS_ENABLED() && !(StateFlowSlot._state$FU.get(this) instanceof CancellableContinuationImpl ^ true)) {
            throw new AssertionError();
        }
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(StateFlowSlot._state$FU, this, StateFlowKt.access$getNONE$p(), cancellableContinuation)) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (StateFlowSlot._state$FU.get(this) != StateFlowKt.access$getPENDING$p()) {
                    bl = false;
                }
                if (!bl) {
                    throw new AssertionError();
                }
            }
            cancellableContinuation = cancellableContinuation;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
        }
        if ((object = ((CancellableContinuationImpl)object).getResult()) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    public Continuation<Unit>[] freeLocked(StateFlowImpl<?> stateFlowImpl) {
        _state$FU.set(this, null);
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }

    public final void makePending() {
        Object object;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        while (true) {
            if ((object = atomicReferenceFieldUpdater.get(this)) == null) {
                return;
            }
            if (object == StateFlowKt.access$getPENDING$p()) {
                return;
            }
            if (object == StateFlowKt.access$getNONE$p()) {
                if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, object, StateFlowKt.access$getPENDING$p())) continue;
                return;
            }
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, object, StateFlowKt.access$getNONE$p())) break;
        }
        object = (CancellableContinuationImpl)object;
        atomicReferenceFieldUpdater = Result.Companion;
        object.resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
    }

    public final boolean takePending() {
        Symbol symbol = _state$FU.getAndSet(this, StateFlowKt.access$getNONE$p());
        Intrinsics.checkNotNull((Object)symbol);
        boolean bl = DebugKt.getASSERTIONS_ENABLED();
        boolean bl2 = true;
        if (bl && !(symbol instanceof CancellableContinuationImpl ^ true)) {
            throw new AssertionError();
        }
        if (symbol != StateFlowKt.access$getPENDING$p()) {
            bl2 = false;
        }
        return bl2;
    }
}

