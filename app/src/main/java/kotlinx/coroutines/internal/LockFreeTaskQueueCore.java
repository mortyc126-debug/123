/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 ,*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002,-B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0013\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\u0006J1\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0006J&\u0010!\u001a\b\u0012\u0004\u0012\u0002H#0\"\"\u0004\b\u0001\u0010#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H#0%J\b\u0010&\u001a\u00020\u001aH\u0002J\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\b\u0010(\u001a\u0004\u0018\u00010\u0002J,\u0010)\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0002R#\u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n0\tX\u0082\u0004R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u0011\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000eX\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006."}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "E", "", "capacity", "", "singleConsumer", "", "(IZ)V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/Core;", "_state", "Lkotlinx/atomicfu/AtomicLong;", "array", "Lkotlinx/atomicfu/AtomicArray;", "isEmpty", "()Z", "mask", "size", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)I", "allocateNextCopy", "state", "", "allocateOrGetNextCopy", "close", "fillPlaceholder", "index", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "map", "", "R", "transform", "Lkotlin/Function1;", "markFrozen", "next", "removeFirstOrNull", "removeSlowPath", "oldHead", "newHead", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class LockFreeTaskQueueCore<E> {
    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    public static final int CAPACITY_BITS = 30;
    public static final long CLOSED_MASK = 0x2000000000000000L;
    public static final int CLOSED_SHIFT = 61;
    public static final Companion Companion = new Companion(null);
    public static final long FROZEN_MASK = 0x1000000000000000L;
    public static final int FROZEN_SHIFT = 60;
    public static final long HEAD_MASK = 0x3FFFFFFFL;
    public static final int HEAD_SHIFT = 0;
    public static final int INITIAL_CAPACITY = 8;
    public static final int MAX_CAPACITY_MASK = 0x3FFFFFFF;
    public static final int MIN_ADD_SPIN_CAPACITY = 1024;
    public static final Symbol REMOVE_FROZEN;
    public static final long TAIL_MASK = 0xFFFFFFFC0000000L;
    public static final int TAIL_SHIFT = 30;
    private static final AtomicReferenceFieldUpdater _next$FU;
    private static final AtomicLongFieldUpdater _state$FU;
    @Volatile
    private volatile Object _next;
    @Volatile
    private volatile long _state;
    private final AtomicReferenceArray array;
    private final int capacity;
    private final int mask;
    private final boolean singleConsumer;

    static {
        _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");
        _state$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");
        REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
    }

    public LockFreeTaskQueueCore(int n, boolean bl) {
        this.capacity = n;
        this.singleConsumer = bl;
        n = this.capacity;
        int n2 = 1;
        this.mask = n - 1;
        this.array = new AtomicReferenceArray(this.capacity);
        n = this.mask <= 0x3FFFFFFF ? 1 : 0;
        if (n != 0) {
            n = (this.capacity & this.mask) == 0 ? n2 : 0;
            if (n != 0) {
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final LockFreeTaskQueueCore<E> allocateNextCopy(long l) {
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = new LockFreeTaskQueueCore<E>(this.capacity * 2, this.singleConsumer);
        Object object = Companion;
        int n = (int)((0x3FFFFFFFL & l) >> 0);
        int n2 = (int)((0xFFFFFFFC0000000L & l) >> 30);
        while ((this.mask & n) != (this.mask & n2)) {
            Object e = this.array.get(this.mask & n);
            object = e;
            if (e == null) {
                object = new Placeholder(n);
            }
            lockFreeTaskQueueCore.array.set(lockFreeTaskQueueCore.mask & n, object);
            ++n;
        }
        _state$FU.set(lockFreeTaskQueueCore, Companion.wo(l, 0x1000000000000000L));
        return lockFreeTaskQueueCore;
    }

    private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long l) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        LockFreeTaskQueueCore lockFreeTaskQueueCore;
        while ((lockFreeTaskQueueCore = (LockFreeTaskQueueCore)atomicReferenceFieldUpdater.get(this)) == null) {
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_next$FU, this, null, this.allocateNextCopy(l));
        }
        return lockFreeTaskQueueCore;
    }

    private final LockFreeTaskQueueCore<E> fillPlaceholder(int n, E e) {
        Object e2 = this.array.get(this.mask & n);
        if (e2 instanceof Placeholder && ((Placeholder)e2).index == n) {
            this.array.set(this.mask & n, e);
            return this;
        }
        return null;
    }

    private final void loop$atomicfu(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function1, Object object) {
        while (true) {
            function1.invoke((Object)atomicLongFieldUpdater.get(object));
        }
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1, Object object) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(object));
        }
    }

    private final long markFrozen() {
        long l;
        long l2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
        do {
            if (((l2 = atomicLongFieldUpdater.get(this)) & 0x1000000000000000L) == 0L) continue;
            return l2;
        } while (!atomicLongFieldUpdater.compareAndSet(this, l2, l = 0x1000000000000000L | l2));
        return l;
    }

    private final LockFreeTaskQueueCore<E> removeSlowPath(int n, int n2) {
        int n3;
        long l;
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
        do {
            l = atomicLongFieldUpdater.get(this);
            Companion companion = Companion;
            boolean bl = false;
            n3 = (int)((0x3FFFFFFFL & l) >> 0);
            int n4 = (int)((0xFFFFFFFC0000000L & l) >> 30);
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (n3 == n) {
                    bl = true;
                }
                if (!bl) {
                    throw new AssertionError();
                }
            }
            if ((l & 0x1000000000000000L) == 0L) continue;
            return this.next();
        } while (!_state$FU.compareAndSet(this, l, Companion.updateHead(l, n2)));
        this.array.set(n3 & this.mask, null);
        return null;
    }

    private final void update$atomicfu(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1, Object object) {
        long l;
        while (!atomicLongFieldUpdater.compareAndSet(object, l = atomicLongFieldUpdater.get(object), ((Number)function1.invoke((Object)l)).longValue())) {
        }
    }

    private final long updateAndGet$atomicfu(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1, Object object) {
        Number number;
        long l;
        while (!atomicLongFieldUpdater.compareAndSet(object, l = atomicLongFieldUpdater.get(object), (number = (Number)function1.invoke((Object)l)).longValue())) {
        }
        return number.longValue();
    }

    public final int addLast(E e) {
        int n;
        int n2;
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore;
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
        while (true) {
            long l;
            if ((0x3000000000000000L & (l = atomicLongFieldUpdater.get(this))) != 0L) {
                return Companion.addFailReason(l);
            }
            lockFreeTaskQueueCore = Companion;
            n2 = (int)((l & 0xFFFFFFFC0000000L) >> 30);
            n = this.mask;
            int n3 = (int)((l & 0x3FFFFFFFL) >> 0);
            if ((n2 + 2 & n) == (n3 & n)) {
                return 1;
            }
            if (!this.singleConsumer && this.array.get(n2 & n) != null) {
                if (this.capacity >= 1024 && (n2 - n3 & 0x3FFFFFFF) <= this.capacity >> 1) continue;
                return 1;
            }
            if (_state$FU.compareAndSet(this, l, Companion.updateTail(l, n2 + 1 & 0x3FFFFFFF))) break;
        }
        this.array.set(n2 & n, e);
        lockFreeTaskQueueCore = this;
        while ((_state$FU.get(lockFreeTaskQueueCore) & 0x1000000000000000L) != 0L && (lockFreeTaskQueueCore = super.fillPlaceholder(n2, e)) != null) {
        }
        return 0;
    }

    public final boolean close() {
        long l;
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
        do {
            if (((l = atomicLongFieldUpdater.get(this)) & 0x2000000000000000L) != 0L) {
                return true;
            }
            if ((l & 0x1000000000000000L) == 0L) continue;
            return false;
        } while (!atomicLongFieldUpdater.compareAndSet(this, l, l | 0x2000000000000000L));
        return true;
    }

    public final int getSize() {
        Companion companion = Companion;
        long l = _state$FU.get(this);
        int n = (int)((0x3FFFFFFFL & l) >> 0);
        int n2 = (int)((0xFFFFFFFC0000000L & l) >> 30);
        return n2 - n & 0x3FFFFFFF;
    }

    public final boolean isClosed() {
        boolean bl = (_state$FU.get(this) & 0x2000000000000000L) != 0L;
        return bl;
    }

    public final boolean isEmpty() {
        Companion companion = Companion;
        long l = _state$FU.get(this);
        boolean bl = false;
        if ((int)((0x3FFFFFFFL & l) >> 0) == (int)((0xFFFFFFFC0000000L & l) >> 30)) {
            bl = true;
        }
        return bl;
    }

    public final <R> List<R> map(Function1<? super E, ? extends R> function1) {
        ArrayList<Object> arrayList = new ArrayList<Object>(this.capacity);
        Companion companion = Companion;
        long l = _state$FU.get(this);
        int n = (int)((0x3FFFFFFFL & l) >> 0);
        int n2 = (int)((0xFFFFFFFC0000000L & l) >> 30);
        while ((this.mask & n) != (this.mask & n2)) {
            companion = this.array.get(this.mask & n);
            if (companion != null && !(companion instanceof Placeholder)) {
                arrayList.add(function1.invoke((Object)companion));
            }
            ++n;
        }
        return arrayList;
    }

    public final LockFreeTaskQueueCore<E> next() {
        return this.allocateOrGetNextCopy(this.markFrozen());
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final Object removeFirstOrNull() {
        var6_1 = LockFreeTaskQueueCore._state$FU;
        var7_2 = this;
        var3_3 = false;
        do lbl-1000:
        // 3 sources

        {
            block5: {
                if ((0x1000000000000000L & (var4_6 = var6_1.get(this))) != 0L) {
                    return LockFreeTaskQueueCore.REMOVE_FROZEN;
                }
                var8_7 /* !! */  = LockFreeTaskQueueCore.Companion;
                var1_4 = (int)((0x3FFFFFFFL & var4_6) >> 0);
                if (((int)((0xFFFFFFFC0000000L & var4_6) >> 30) & this.mask) == (this.mask & var1_4)) {
                    return null;
                }
                var8_7 /* !! */  = this.array.get(this.mask & var1_4);
                if (var8_7 /* !! */  != null) break block5;
                if (!this.singleConsumer) ** GOTO lbl-1000
                return null;
            }
            if (var8_7 /* !! */  instanceof Placeholder) {
                return null;
            }
            var2_5 = var1_4 + 1 & 0x3FFFFFFF;
            if (!LockFreeTaskQueueCore._state$FU.compareAndSet(this, var4_6, LockFreeTaskQueueCore.Companion.updateHead(var4_6, var2_5))) continue;
            this.array.set(this.mask & var1_4, null);
            return var8_7 /* !! */ ;
        } while (!this.singleConsumer);
        var6_1 = this;
        while ((var6_1 = super.removeSlowPath(var1_4, var2_5)) != null) {
        }
        return var8_7 /* !! */ ;
    }

    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\b\u00a2\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0086\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int addFailReason(long l) {
            int n = (0x2000000000000000L & l) != 0L ? 2 : 1;
            return n;
        }

        public final long updateHead(long l, int n) {
            return this.wo(l, 0x3FFFFFFFL) | (long)n << 0;
        }

        public final long updateTail(long l, int n) {
            return this.wo(l, 0xFFFFFFFC0000000L) | (long)n << 30;
        }

        public final <T> T withState(long l, Function2<? super Integer, ? super Integer, ? extends T> function2) {
            return (T)function2.invoke((Object)((int)((0x3FFFFFFFL & l) >> 0)), (Object)((int)((0xFFFFFFFC0000000L & l) >> 30)));
        }

        public final long wo(long l, long l2) {
            return (l2 ^ 0xFFFFFFFFFFFFFFFFL) & l;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Placeholder {
        public final int index;

        public Placeholder(int n) {
            this.index = n;
        }
    }
}

