/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.AbstractMutableMap
 *  kotlin.collections.AbstractMutableSet
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMutableIterator
 *  kotlin.jvm.internal.markers.KMutableMap$Entry
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines.debug.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.ChannelSegment$$ExternalSyntheticBackportWithForwarding0;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt;
import kotlinx.coroutines.debug.internal.HashedWeakRef;
import kotlinx.coroutines.debug.internal.Marked;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0003()*B\u000f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0018\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010!J\u001f\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010$J!\u0010%\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u00002\b\u0010#\u001a\u0004\u0018\u00018\u0001H\u0002\u00a2\u0006\u0002\u0010$J\u0017\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010!J\u0006\u0010'\u001a\u00020\u001aR\t\u0010\b\u001a\u00020\tX\u0082\u0004R\u001f\u0010\n\u001a\u0018\u0012\u0014\u0012\u00120\fR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u000bX\u0082\u0004R&\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f0\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2={"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "K", "", "V", "Lkotlin/collections/AbstractMutableMap;", "weakRefQueue", "", "(Z)V", "_size", "Lkotlinx/atomicfu/AtomicInt;", "core", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "Ljava/lang/ref/ReferenceQueue;", "cleanWeakRef", "", "w", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "clear", "decrementSize", "get", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putSynchronized", "remove", "runWeakRefQueueCleaningLoopUntilInterrupted", "Core", "Entry", "KeyValueSet", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class ConcurrentWeakMap<K, V>
extends AbstractMutableMap<K, V> {
    private static final AtomicIntegerFieldUpdater _size$FU = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
    private static final AtomicReferenceFieldUpdater core$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, "core");
    @Volatile
    private volatile int _size;
    @Volatile
    private volatile Object core;
    private final ReferenceQueue<K> weakRefQueue;

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    public ConcurrentWeakMap(boolean bl) {
        this.core = new Core(this, 16);
        ReferenceQueue referenceQueue = bl ? new ReferenceQueue() : null;
        this.weakRefQueue = referenceQueue;
    }

    public /* synthetic */ ConcurrentWeakMap(boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            bl = false;
        }
        this(bl);
    }

    private final void cleanWeakRef(HashedWeakRef<?> hashedWeakRef) {
        ((Core)core$FU.get(this)).cleanWeakRef(hashedWeakRef);
    }

    private final void decrementSize() {
        _size$FU.decrementAndGet(this);
    }

    private final V putSynchronized(K k, V v) {
        synchronized (this) {
            Object object;
            Core core = (Core)core$FU.get(this);
            while (true) {
                Symbol symbol;
                if ((object = Core.putImpl$default(core, k, v, null, 4, null)) == (symbol = ConcurrentWeakMapKt.access$getREHASH$p())) break block5;
                break;
            }
            {
                block5: {
                    return (V)object;
                }
                core = core.rehash();
                core$FU.set(this, core);
                continue;
            }
        }
    }

    public void clear() {
        Iterator iterator2 = this.keySet().iterator();
        while (iterator2.hasNext()) {
            this.remove(iterator2.next());
        }
    }

    public V get(Object object) {
        if (object == null) {
            return null;
        }
        return ((Core)core$FU.get(this)).getImpl(object);
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return (Set)((Object)new KeyValueSet(this, entries.1.INSTANCE));
    }

    public Set<K> getKeys() {
        return (Set)((Object)new KeyValueSet(this, keys.1.INSTANCE));
    }

    public int getSize() {
        return _size$FU.get(this);
    }

    public V put(K k, V v) {
        Object object;
        Object object2 = object = Core.putImpl$default((Core)core$FU.get(this), k, v, null, 4, null);
        if (object == ConcurrentWeakMapKt.access$getREHASH$p()) {
            object2 = this.putSynchronized(k, v);
        }
        if (object2 == null) {
            _size$FU.incrementAndGet(this);
        }
        return (V)object2;
    }

    public V remove(Object object) {
        Object object2;
        if (object == null) {
            return null;
        }
        Object object3 = object2 = Core.putImpl$default((Core)core$FU.get(this), object, null, null, 4, null);
        if (object2 == ConcurrentWeakMapKt.access$getREHASH$p()) {
            object3 = this.putSynchronized(object, null);
        }
        if (object3 != null) {
            _size$FU.decrementAndGet(this);
        }
        return (V)object3;
    }

    public final void runWeakRefQueueCleaningLoopUntilInterrupted() {
        boolean bl = this.weakRefQueue != null;
        if (bl) {
            try {
                while (true) {
                    Reference<K> reference = this.weakRefQueue.remove();
                    Intrinsics.checkNotNull(reference, (String)"null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                    this.cleanWeakRef((HashedWeakRef)reference);
                }
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
    }

    @Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0015\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0016\"\u0004\b\u0002\u0010\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u00170\u0019J1\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00028\u00002\b\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001fJ\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00070\u0006X\u0082\u0004R\t\u0010\b\u001a\u00020\tX\u0082\u0004R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004\u00a8\u0006\""}, d2={"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "", "allocated", "", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;I)V", "keys", "Lkotlinx/atomicfu/AtomicArray;", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "load", "Lkotlinx/atomicfu/AtomicInt;", "shift", "threshold", "values", "cleanWeakRef", "", "weakRef", "getImpl", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "index", "hash", "keyValueIterator", "", "E", "factory", "Lkotlin/Function2;", "putImpl", "value", "weakKey0", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/HashedWeakRef;)Ljava/lang/Object;", "rehash", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "removeCleanedAt", "KeyValueIterator", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private final class Core {
        private static final AtomicIntegerFieldUpdater load$FU = AtomicIntegerFieldUpdater.newUpdater(Core.class, "load");
        private final int allocated;
        private final AtomicReferenceArray keys;
        @Volatile
        private volatile int load;
        private final int shift;
        final ConcurrentWeakMap<K, V> this$0;
        private final int threshold;
        private final AtomicReferenceArray values;

        public Core(ConcurrentWeakMap concurrentWeakMap, int n) {
            this.this$0 = concurrentWeakMap;
            this.allocated = n;
            this.shift = Integer.numberOfLeadingZeros(this.allocated) + 1;
            this.threshold = this.allocated * 2 / 3;
            this.keys = new AtomicReferenceArray(this.allocated);
            this.values = new AtomicReferenceArray(this.allocated);
        }

        private final int index(int n) {
            return -1640531527 * n >>> this.shift;
        }

        public static /* synthetic */ Object putImpl$default(Core core, Object object, Object object2, HashedWeakRef hashedWeakRef, int n, Object object3) {
            if ((n & 4) != 0) {
                hashedWeakRef = null;
            }
            return core.putImpl(object, object2, hashedWeakRef);
        }

        private final void removeCleanedAt(int n) {
            Object e;
            do {
                if ((e = this.values.get(n)) == null) {
                    return;
                }
                if (!(e instanceof Marked)) continue;
                return;
            } while (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this.values, n, e, null));
            this.this$0.decrementSize();
        }

        private final void update$atomicfu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Integer> function1, Object object) {
            int n;
            while (!atomicIntegerFieldUpdater.compareAndSet(object, n = atomicIntegerFieldUpdater.get(object), ((Number)function1.invoke((Object)n)).intValue())) {
            }
        }

        public final void cleanWeakRef(HashedWeakRef<?> hashedWeakRef) {
            int n = this.index(hashedWeakRef.hash);
            HashedWeakRef hashedWeakRef2;
            while ((hashedWeakRef2 = (HashedWeakRef)this.keys.get(n)) != null) {
                if (hashedWeakRef2 == hashedWeakRef) {
                    this.removeCleanedAt(n);
                    return;
                }
                int n2 = n;
                if (n == 0) {
                    n2 = this.allocated;
                }
                n = n2 - 1;
            }
            return;
        }

        public final V getImpl(K object) {
            int n = this.index(object.hashCode());
            HashedWeakRef hashedWeakRef;
            while ((hashedWeakRef = (HashedWeakRef)this.keys.get(n)) != null) {
                if (Intrinsics.areEqual(object, (Object)(hashedWeakRef = hashedWeakRef.get()))) {
                    object = this.values.get(n);
                    if (object instanceof Marked) {
                        object = ((Marked)object).ref;
                    }
                    return object;
                }
                if (hashedWeakRef == null) {
                    this.removeCleanedAt(n);
                }
                int n2 = n;
                if (n == 0) {
                    n2 = this.allocated;
                }
                n = n2 - 1;
            }
            return null;
        }

        public final <E> Iterator<E> keyValueIterator(Function2<? super K, ? super V, ? extends E> function2) {
            return new KeyValueIterator<E>(this, function2);
        }

        public final Object putImpl(K object, V v, HashedWeakRef<K> hashedWeakRef) {
            int n = this.index(object.hashCode());
            int n2 = 0;
            while (true) {
                int n3;
                HashedWeakRef hashedWeakRef2;
                block16: {
                    block15: {
                        block14: {
                            if ((hashedWeakRef2 = (HashedWeakRef)this.keys.get(n)) != null) break block14;
                            if (v == null) {
                                return null;
                            }
                            n3 = n2;
                            if (n2 == 0) {
                                hashedWeakRef2 = load$FU;
                                do {
                                    if ((n2 = ((AtomicIntegerFieldUpdater)((Object)hashedWeakRef2)).get((Core)this)) < this.threshold) continue;
                                    return ConcurrentWeakMapKt.access$getREHASH$p();
                                } while (!((AtomicIntegerFieldUpdater)((Object)hashedWeakRef2)).compareAndSet((Core)this, n2, n2 + 1));
                                n3 = 1;
                            }
                            hashedWeakRef2 = hashedWeakRef;
                            if (hashedWeakRef == null) {
                                hashedWeakRef2 = new HashedWeakRef(object, this.this$0.weakRefQueue);
                            }
                            if (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this.keys, n, null, hashedWeakRef2)) {
                                n2 = n3;
                                hashedWeakRef = hashedWeakRef2;
                                continue;
                            }
                            break block15;
                        }
                        if (!Intrinsics.areEqual(object, (Object)(hashedWeakRef2 = hashedWeakRef2.get()))) break block16;
                        if (n2 != 0) {
                            load$FU.decrementAndGet(this);
                        }
                    }
                    do {
                        if (!((object = this.values.get(n)) instanceof Marked)) continue;
                        return ConcurrentWeakMapKt.access$getREHASH$p();
                    } while (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this.values, n, object, v));
                    return object;
                }
                if (hashedWeakRef2 == null) {
                    this.removeCleanedAt(n);
                }
                n3 = n;
                if (n == 0) {
                    n3 = this.allocated;
                }
                n = n3 - 1;
            }
        }

        public final Core rehash() {
            Core core;
            block0: while (true) {
                int n = Integer.highestOneBit(RangesKt.coerceAtLeast((int)this.this$0.size(), (int)4));
                core = new Core(this.this$0, n * 4);
                int n2 = this.allocated;
                for (n = 0; n < n2; ++n) {
                    Object object;
                    HashedWeakRef hashedWeakRef = (HashedWeakRef)this.keys.get(n);
                    Object object2 = hashedWeakRef != null ? (Object)hashedWeakRef.get() : null;
                    if (hashedWeakRef != null && object2 == null) {
                        this.removeCleanedAt(n);
                    }
                    do {
                        if (!((object = this.values.get(n)) instanceof Marked)) continue;
                        object = ((Marked)object).ref;
                        break;
                    } while (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this.values, n, object, ConcurrentWeakMapKt.access$mark(object)));
                    if (object2 == null || object == null) continue;
                    if ((object2 = core.putImpl(object2, object, hashedWeakRef)) == ConcurrentWeakMapKt.access$getREHASH$p()) continue block0;
                    boolean bl = object2 == null;
                    if (!bl) {
                        throw new AssertionError((Object)"Assertion failed");
                    }
                }
                break;
            }
            return core;
        }

        @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u000e\u0010\u000f\u001a\u00028\u0002H\u0096\u0002\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00028\u0000X\u0082.\u00a2\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00028\u0001X\u0082.\u00a2\u0006\u0004\n\u0002\u0010\t\u00a8\u0006\u0013"}, d2={"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator;", "E", "", "factory", "Lkotlin/Function2;", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;Lkotlin/jvm/functions/Function2;)V", "index", "", "key", "Ljava/lang/Object;", "value", "findNext", "", "hasNext", "", "next", "()Ljava/lang/Object;", "remove", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
        private final class KeyValueIterator<E>
        implements Iterator<E>,
        KMutableIterator {
            private final Function2<K, V, E> factory;
            private int index;
            private K key;
            final Core this$0;
            private V value;

            public KeyValueIterator(Core core, Function2<? super K, ? super V, ? extends E> function2) {
                this.this$0 = core;
                this.factory = function2;
                this.index = -1;
                this.findNext();
            }

            private final void findNext() {
                block2: {
                    Object object;
                    while (true) {
                        ++this.index;
                        if (this.index >= this.this$0.allocated) break block2;
                        object = (HashedWeakRef)this.this$0.keys.get(this.index);
                        if (object == null || (object = ((Reference)object).get()) == null) continue;
                        this.key = object;
                        Object e = this.this$0.values.get(this.index);
                        object = e;
                        if (e instanceof Marked) {
                            object = ((Marked)e).ref;
                        }
                        if (object != null) break;
                    }
                    this.value = object;
                    return;
                }
            }

            @Override
            public boolean hasNext() {
                boolean bl = this.index < this.this$0.allocated;
                return bl;
            }

            @Override
            public E next() {
                if (this.index < this.this$0.allocated) {
                    Object object;
                    Function2 function2 = this.factory;
                    Object object2 = object = this.key;
                    if (object == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)"key");
                        object2 = Unit.INSTANCE;
                    }
                    Object v = this.value;
                    object = v;
                    if (v == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)"value");
                        object = Unit.INSTANCE;
                    }
                    object2 = function2.invoke(object2, object);
                    this.findNext();
                    return (E)object2;
                }
                throw new NoSuchElementException();
            }

            public Void remove() {
                ConcurrentWeakMapKt.access$noImpl();
                throw new KotlinNothingValueException();
            }
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u000b\u001a\u00028\u00032\u0006\u0010\f\u001a\u00028\u0003H\u0016\u00a2\u0006\u0002\u0010\rR\u0016\u0010\u0004\u001a\u00028\u0002X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00028\u0003X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Entry;", "K", "V", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private static final class Entry<K, V>
    implements Map.Entry<K, V>,
    KMutableMap.Entry {
        private final K key;
        private final V value;

        public Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V v) {
            ConcurrentWeakMapKt.access$noImpl();
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010)\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0002H\u0016\u00a2\u0006\u0002\u0010\rJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u000fH\u0096\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2={"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$KeyValueSet;", "E", "Lkotlin/collections/AbstractMutableSet;", "factory", "Lkotlin/Function2;", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;Lkotlin/jvm/functions/Function2;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private final class KeyValueSet<E>
    extends AbstractMutableSet<E> {
        private final Function2<K, V, E> factory;
        final ConcurrentWeakMap<K, V> this$0;

        public KeyValueSet(ConcurrentWeakMap concurrentWeakMap, Function2<? super K, ? super V, ? extends E> function2) {
            this.this$0 = concurrentWeakMap;
            this.factory = function2;
        }

        public boolean add(E e) {
            ConcurrentWeakMapKt.access$noImpl();
            throw new KotlinNothingValueException();
        }

        public int getSize() {
            return this.this$0.size();
        }

        public Iterator<E> iterator() {
            return ((Core)core$FU.get(this.this$0)).keyValueIterator(this.factory);
        }
    }
}

