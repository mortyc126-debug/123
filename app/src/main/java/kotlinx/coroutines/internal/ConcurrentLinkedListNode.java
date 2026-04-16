/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u000eJ\u001e\u0010\u001a\u001a\u0004\u0018\u00018\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0086\b\u00a2\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0018J\u0013\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\"R\u0011\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0082\u0004R\u0011\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006X\u0082\u0004R\u0016\u0010\b\u001a\u0004\u0018\u00018\u00008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00028\u00008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0012\u0010\r\u001a\u00020\u000eX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0003\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\n\u00a8\u0006#"}, d2={"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "", "prev", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "aliveSegmentLeft", "getAliveSegmentLeft", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "aliveSegmentRight", "getAliveSegmentRight", "isRemoved", "", "()Z", "isTail", "next", "getNext", "nextOrClosed", "getNextOrClosed", "()Ljava/lang/Object;", "getPrev", "cleanPrev", "", "markAsClosed", "nextOrIfClosed", "onClosedAction", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "remove", "trySetNext", "value", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {
    private static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next");
    private static final AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev");
    @Volatile
    private volatile Object _next;
    @Volatile
    private volatile Object _prev;

    public ConcurrentLinkedListNode(N n) {
        this._prev = n;
    }

    private final N getAliveSegmentLeft() {
        Object object = this.getPrev();
        while (object != null && ((ConcurrentLinkedListNode)object).isRemoved()) {
            object = (ConcurrentLinkedListNode)_prev$FU.get(object);
        }
        return object;
    }

    private final N getAliveSegmentRight() {
        if (DebugKt.getASSERTIONS_ENABLED() && !(this.isTail() ^ true)) {
            throw new AssertionError();
        }
        N n = this.getNext();
        Intrinsics.checkNotNull(n);
        while (((ConcurrentLinkedListNode)n).isRemoved()) {
            N n2 = ((ConcurrentLinkedListNode)n).getNext();
            if (n2 == null) {
                return n;
            }
            n = n2;
        }
        return n;
    }

    private final Object getNextOrClosed() {
        return _next$FU.get(this);
    }

    private final void update$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1, Object object) {
        Object v;
        while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, object, v = atomicReferenceFieldUpdater.get(object), function1.invoke(v))) {
        }
    }

    public final void cleanPrev() {
        _prev$FU.lazySet(this, null);
    }

    public final N getNext() {
        Object object = this.getNextOrClosed();
        if (object == ConcurrentLinkedListKt.access$getCLOSED$p()) {
            return null;
        }
        object = (ConcurrentLinkedListNode)object;
        return (N)object;
    }

    public final N getPrev() {
        return (N)((ConcurrentLinkedListNode)_prev$FU.get(this));
    }

    public abstract boolean isRemoved();

    public final boolean isTail() {
        boolean bl = this.getNext() == null;
        return bl;
    }

    public final boolean markAsClosed() {
        return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_next$FU, this, null, ConcurrentLinkedListKt.access$getCLOSED$p());
    }

    public final N nextOrIfClosed(Function0 object) {
        Object object2 = this.getNextOrClosed();
        if (object2 != ConcurrentLinkedListKt.access$getCLOSED$p()) {
            object = (ConcurrentLinkedListNode)object2;
            return (N)object;
        }
        object.invoke();
        throw new KotlinNothingValueException();
    }

    public final void remove() {
        N n;
        N n2;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = this.isRemoved() || this.isTail();
            if (!bl) {
                throw new AssertionError();
            }
        }
        if (this.isTail()) {
            return;
        }
        do {
            Object var2_2;
            Object v;
            n = this.getAliveSegmentLeft();
            n2 = this.getAliveSegmentRight();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _prev$FU;
            while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, n2, v, var2_2 = (ConcurrentLinkedListNode)(v = atomicReferenceFieldUpdater.get(n2)) == null ? null : n)) {
            }
            if (n == null) continue;
            _next$FU.set(n, n2);
        } while (((ConcurrentLinkedListNode)n2).isRemoved() && !((ConcurrentLinkedListNode)n2).isTail() || n != null && ((ConcurrentLinkedListNode)n).isRemoved());
    }

    public final boolean trySetNext(N n) {
        return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_next$FU, this, null, n);
    }
}

