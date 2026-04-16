/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000\u00a2\u0006\u0002\b\u0012J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\t\u0010\u0014\u001a\u00020\u0004H\u0082\bJ\r\u0010\u0015\u001a\u00020\r*\u00020\u0004H\u0082\bR\t\u0010\b\u001a\u00020\tX\u0082\u0004R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bX\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lkotlinx/coroutines/internal/OnDemandAllocatingPool;", "T", "", "maxCapacity", "", "create", "Lkotlin/Function1;", "(ILkotlin/jvm/functions/Function1;)V", "controlState", "Lkotlinx/atomicfu/AtomicInt;", "elements", "Lkotlinx/atomicfu/AtomicArray;", "allocate", "", "close", "", "stateRepresentation", "", "stateRepresentation$kotlinx_coroutines_core", "toString", "tryForbidNewElements", "isClosed", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class OnDemandAllocatingPool<T> {
    private static final AtomicIntegerFieldUpdater controlState$FU = AtomicIntegerFieldUpdater.newUpdater(OnDemandAllocatingPool.class, "controlState");
    @Volatile
    private volatile int controlState;
    private final Function1<Integer, T> create;
    private final AtomicReferenceArray elements;
    private final int maxCapacity;

    public OnDemandAllocatingPool(int n, Function1<? super Integer, ? extends T> function1) {
        this.maxCapacity = n;
        this.create = function1;
        this.elements = new AtomicReferenceArray(this.maxCapacity);
    }

    private final boolean isClosed(int n) {
        boolean bl = (Integer.MIN_VALUE & n) != 0;
        return bl;
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Unit> function1, Object object) {
        while (true) {
            function1.invoke((Object)atomicIntegerFieldUpdater.get(object));
        }
    }

    private final int tryForbidNewElements() {
        int n;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = controlState$FU;
        do {
            boolean bl;
            if (!(bl = ((n = atomicIntegerFieldUpdater.get(this)) & Integer.MIN_VALUE) != 0)) continue;
            return 0;
        } while (!controlState$FU.compareAndSet(this, n, n | Integer.MIN_VALUE));
        return n;
    }

    public final boolean allocate() {
        int n;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = controlState$FU;
        do {
            boolean bl;
            if (bl = (Integer.MIN_VALUE & (n = atomicIntegerFieldUpdater.get(this))) != 0) {
                return false;
            }
            if (n < this.maxCapacity) continue;
            return true;
        } while (!controlState$FU.compareAndSet(this, n, n + 1));
        this.elements.set(n, this.create.invoke((Object)n));
        return true;
    }

    public final List<T> close() {
        int n;
        Object object;
        block3: {
            int n2;
            object = controlState$FU;
            do {
                if ((n = ((n2 = ((AtomicIntegerFieldUpdater)object).get(this)) & Integer.MIN_VALUE) != 0 ? 1 : 0) == 0) continue;
                n = 0;
                break block3;
            } while (!controlState$FU.compareAndSet(this, n2, n2 | Integer.MIN_VALUE));
            n = n2;
        }
        Iterable iterable = (Iterable)RangesKt.until((int)0, (int)n);
        object = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
        Iterator iterator2 = iterable.iterator();
        while (iterator2.hasNext()) {
            n = ((IntIterator)iterator2).nextInt();
            while ((iterable = this.elements.getAndSet(n, null)) == null) {
            }
            object.add(iterable);
        }
        object = (List)object;
        return object;
    }

    public final String stateRepresentation$kotlinx_coroutines_core() {
        int n = controlState$FU.get(this);
        boolean bl = false;
        Object object = (Iterable)RangesKt.until((int)0, (int)(Integer.MAX_VALUE & n));
        Object object2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object, (int)10));
        object = object.iterator();
        while (object.hasNext()) {
            int n2 = ((IntIterator)object).nextInt();
            object2.add(this.elements.get(n2));
        }
        object2 = (List)object2;
        object = object2.toString();
        if ((Integer.MIN_VALUE & n) != 0) {
            bl = true;
        }
        object2 = bl ? "[closed]" : "";
        return (String)object + (String)object2;
    }

    public String toString() {
        return "OnDemandAllocatingPool(" + this.stateRepresentation$kotlinx_coroutines_core() + ')';
    }
}

