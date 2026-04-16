/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelSegment$$ExternalSyntheticBackportWithForwarding0;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a8\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00050\tH\u0082\b\u001a!\u0010\r\u001a\u0002H\u000e\"\u000e\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f*\u0002H\u000eH\u0000\u00a2\u0006\u0002\u0010\u0010\u001av\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\b\u0012\u0004\u0012\u0002H\u00130\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u0002H\u001328\b\b\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u0011H\u0013\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00130\u001aH\u0080\b\u00f8\u0001\u0000\u001aj\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\u0002H\u00132\u0006\u0010\u0016\u001a\u00020\u001726\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u0011H\u0013\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00130\u001aH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001d\u001a+\u0010\u001e\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\b\u0012\u0004\u0012\u0002H\u00130\u00152\u0006\u0010\u001f\u001a\u0002H\u0013H\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2={"CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "POINTERS_SHIFT", "", "addConditionally", "", "Lkotlinx/atomicfu/AtomicInt;", "delta", "condition", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cur", "close", "N", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "findSegmentAndMoveForward", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "S", "Lkotlinx/coroutines/internal/Segment;", "Lkotlinx/atomicfu/AtomicRef;", "id", "", "startFrom", "createNewSegment", "Lkotlin/Function2;", "prev", "findSegmentInternal", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "moveForward", "to", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class ConcurrentLinkedListKt {
    private static final Symbol CLOSED = new Symbol("CLOSED");
    private static final int POINTERS_SHIFT = 16;

    private static final boolean addConditionally$atomicfu(Object object, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, int n, Function1<? super Integer, Boolean> function1) {
        int n2;
        do {
            if (((Boolean)function1.invoke((Object)(n2 = atomicIntegerFieldUpdater.get(object)))).booleanValue()) continue;
            return false;
        } while (!atomicIntegerFieldUpdater.compareAndSet(object, n2, n2 + n));
        return true;
    }

    private static final boolean addConditionally$atomicfu$array(Object object, AtomicIntegerArray atomicIntegerArray, int n, int n2, Function1<? super Integer, Boolean> function1) {
        int n3;
        do {
            if (((Boolean)function1.invoke((Object)(n3 = atomicIntegerArray.get(n)))).booleanValue()) continue;
            return false;
        } while (!atomicIntegerArray.compareAndSet(n, n3, n3 + n2));
        return true;
    }

    public static final <N extends ConcurrentLinkedListNode<N>> N close(N object) {
        Object object2;
        while ((object2 = ConcurrentLinkedListNode.access$getNextOrClosed(object)) != ConcurrentLinkedListKt.CLOSED) {
            if ((object2 = (ConcurrentLinkedListNode)object2) == null) {
                if (!object.markAsClosed()) continue;
                return object;
            }
            object = object2;
        }
        return object;
    }

    public static final Object findSegmentAndMoveForward$atomicfu(Object object, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, long l, S s, Function2<? super Long, ? super S, ? extends S> function2) {
        Object object2;
        boolean bl = false;
        block0: while (!SegmentOrClosed.isClosed-impl(object2 = ConcurrentLinkedListKt.findSegmentInternal(s, l, function2))) {
            Object s2 = SegmentOrClosed.getSegment-impl(object2);
            while (true) {
                block8: {
                    boolean bl2;
                    block6: {
                        Segment segment;
                        block7: {
                            segment = (Segment)atomicReferenceFieldUpdater.get(object);
                            long l2 = segment.id;
                            long l3 = ((Segment)s2).id;
                            bl2 = true;
                            if (l2 >= l3) break block6;
                            if (((Segment)s2).tryIncPointers$kotlinx_coroutines_core()) break block7;
                            bl2 = false;
                            break block6;
                        }
                        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, object, segment, s2)) break block8;
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    }
                    if (!bl2) continue block0;
                    break block0;
                }
                if (!((Segment)s2).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)s2).remove();
            }
        }
        return object2;
    }

    public static final Object findSegmentAndMoveForward$atomicfu$array(Object object, AtomicReferenceArray atomicReferenceArray, int n, long l, S s, Function2<? super Long, ? super S, ? extends S> function2) {
        Object object2;
        block0: while (!SegmentOrClosed.isClosed-impl(object2 = ConcurrentLinkedListKt.findSegmentInternal(s, l, function2))) {
            object = SegmentOrClosed.getSegment-impl(object2);
            while (true) {
                block8: {
                    boolean bl;
                    block6: {
                        Segment segment;
                        block7: {
                            segment = (Segment)atomicReferenceArray.get(n);
                            long l2 = segment.id;
                            long l3 = ((Segment)object).id;
                            bl = true;
                            if (l2 >= l3) break block6;
                            if (((Segment)object).tryIncPointers$kotlinx_coroutines_core()) break block7;
                            bl = false;
                            break block6;
                        }
                        if (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, n, segment, object)) break block8;
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    }
                    if (!bl) continue block0;
                    break block0;
                }
                if (!((Segment)object).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)object).remove();
            }
        }
        return object2;
    }

    public static final <S extends Segment<S>> Object findSegmentInternal(S object, long l, Function2<? super Long, ? super S, ? extends S> function2) {
        while (((Segment)object).id < l || ((Segment)object).isRemoved()) {
            Object object2 = ConcurrentLinkedListNode.access$getNextOrClosed((ConcurrentLinkedListNode)object);
            if (object2 == ConcurrentLinkedListKt.CLOSED) {
                return SegmentOrClosed.constructor-impl(CLOSED);
            }
            object2 = (ConcurrentLinkedListNode)object2;
            if ((object2 = (Segment)object2) != null) {
                object = object2;
                continue;
            }
            object2 = (Segment)function2.invoke((Object)(((Segment)object).id + 1L), object);
            if (!((ConcurrentLinkedListNode)object).trySetNext((ConcurrentLinkedListNode)((ConcurrentLinkedListNode)object2))) continue;
            if (((Segment)object).isRemoved()) {
                ((ConcurrentLinkedListNode)object).remove();
            }
            object = object2;
        }
        return SegmentOrClosed.constructor-impl(object);
    }

    private static final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1, Object object) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(object));
        }
    }

    private static final void loop$atomicfu$array(AtomicReferenceArray atomicReferenceArray, int n, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceArray.get(n));
        }
    }

    public static final boolean moveForward$atomicfu(Object object, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, S s) {
        while (true) {
            Segment segment = (Segment)atomicReferenceFieldUpdater.get(object);
            if (segment.id >= ((Segment)s).id) {
                return true;
            }
            if (!((Segment)s).tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, object, segment, s)) {
                if (segment.decPointers$kotlinx_coroutines_core()) {
                    segment.remove();
                }
                return true;
            }
            if (!((Segment)s).decPointers$kotlinx_coroutines_core()) continue;
            ((ConcurrentLinkedListNode)s).remove();
        }
    }

    public static final boolean moveForward$atomicfu$array(Object object, AtomicReferenceArray atomicReferenceArray, int n, S s) {
        while (true) {
            object = (Segment)atomicReferenceArray.get(n);
            if (((Segment)object).id >= ((Segment)s).id) {
                return true;
            }
            if (!((Segment)s).tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, n, object, s)) {
                if (((Segment)object).decPointers$kotlinx_coroutines_core()) {
                    ((ConcurrentLinkedListNode)object).remove();
                }
                return true;
            }
            if (!((Segment)s).decPointers$kotlinx_coroutines_core()) continue;
            ((ConcurrentLinkedListNode)s).remove();
        }
    }
}

