/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0001\u00a2\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0019J,\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u00002\u0014\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\r0\u001dH\u0086\b\u00a2\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0017J0\u0010 \u001a\u0004\u0018\u00018\u00002!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\r0\u001d\u00a2\u0006\u0002\u0010$J\u000f\u0010%\u001a\u0004\u0018\u00018\u0000H\u0001\u00a2\u0006\u0002\u0010&J\r\u0010'\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010&J\u0015\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\nH\u0002\u00a2\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000\u00a2\u0006\u0002\u0010+J\u0015\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u00020\u0010H\u0001\u00a2\u0006\u0002\u0010.J$\u0010/\u001a\u0004\u0018\u00018\u00002\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u001dH\u0086\b\u00a2\u0006\u0002\u0010$J\r\u00100\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010&J\u0011\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0010H\u0082\u0010J\u0011\u00103\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0010H\u0082\u0010J\u0018\u00104\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u0010H\u0002R\t\u0010\u0007\u001a\u00020\bX\u0082\u0004R\u001a\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@BX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u00066"}, d2={"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "T", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "()V", "_size", "Lkotlinx/atomicfu/AtomicInt;", "a", "", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "", "()Z", "value", "", "size", "getSize", "()I", "setSize", "(I)V", "addImpl", "", "node", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "addLastIf", "cond", "Lkotlin/Function1;", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "find", "predicate", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "removeAtImpl", "index", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstIf", "removeFirstOrNull", "siftDownFrom", "i", "siftUpFrom", "swap", "j", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private static final AtomicIntegerFieldUpdater _size$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size");
    @Volatile
    private volatile int _size;
    private T[] a;

    private final T[] realloc() {
        Object[] objectArray;
        block1: {
            block0: {
                objectArray = this.a;
                if (objectArray != null) break block0;
                this.a = objectArray = new ThreadSafeHeapNode[4];
                break block1;
            }
            if (this.getSize() < objectArray.length) break block1;
            objectArray = Arrays.copyOf(objectArray, this.getSize() * 2);
            Intrinsics.checkNotNullExpressionValue(objectArray, (String)"copyOf(this, newSize)");
            this.a = (ThreadSafeHeapNode[])objectArray;
            objectArray = (ThreadSafeHeapNode[])objectArray;
        }
        return objectArray;
    }

    private final void setSize(int n) {
        _size$FU.set(this, n);
    }

    private final void siftDownFrom(int n) {
        int n2 = n;
        int n3;
        while ((n3 = n2 * 2 + 1) < this.getSize()) {
            Object object;
            Object object2 = this.a;
            Intrinsics.checkNotNull(object2);
            n = n3;
            if (n3 + 1 < this.getSize()) {
                object = object2[n3 + 1];
                Intrinsics.checkNotNull(object);
                object = (Comparable)object;
                T t = object2[n3];
                Intrinsics.checkNotNull(t);
                n = n3;
                if (object.compareTo(t) < 0) {
                    n = n3 + 1;
                }
            }
            object = object2[n2];
            Intrinsics.checkNotNull(object);
            object = (Comparable)object;
            object2 = object2[n];
            Intrinsics.checkNotNull(object2);
            if (object.compareTo(object2) <= 0) {
                return;
            }
            this.swap(n2, n);
            n2 = n;
        }
        return;
    }

    private final void siftUpFrom(int n) {
        while (n > 0) {
            Object object = this.a;
            Intrinsics.checkNotNull(object);
            int n2 = (n - 1) / 2;
            Object object2 = object[n2];
            Intrinsics.checkNotNull(object2);
            object2 = (Comparable)object2;
            object = object[n];
            Intrinsics.checkNotNull(object);
            if (object2.compareTo(object) <= 0) {
                return;
            }
            this.swap(n, n2);
            n = n2;
        }
        return;
    }

    private final void swap(int n, int n2) {
        T[] TArray = this.a;
        Intrinsics.checkNotNull(TArray);
        T t = TArray[n2];
        Intrinsics.checkNotNull(t);
        T t2 = TArray[n];
        Intrinsics.checkNotNull(t2);
        TArray[n] = t;
        TArray[n2] = t2;
        t.setIndex(n);
        t2.setIndex(n2);
    }

    public final void addImpl(T t) {
        int n;
        if (DebugKt.getASSERTIONS_ENABLED() && (n = t.getHeap() == null ? 1 : 0) == 0) {
            throw new AssertionError();
        }
        t.setHeap(this);
        ThreadSafeHeapNode[] threadSafeHeapNodeArray = this.realloc();
        n = this.getSize();
        this.setSize(n + 1);
        threadSafeHeapNodeArray[n] = t;
        t.setIndex(n);
        this.siftUpFrom(n);
    }

    public final void addLast(T object) {
        synchronized (this) {
            this.addImpl(object);
            object = Unit.INSTANCE;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean addLastIf(T t, Function1<? super T, Boolean> function1) {
        synchronized (this) {
            try {
                boolean bl;
                if (((Boolean)function1.invoke(this.firstImpl())).booleanValue()) {
                    this.addImpl(t);
                    bl = true;
                    return bl;
                } else {
                    bl = false;
                }
                return bl;
            }
            finally {
                InlineMarker.finallyStart((int)1);
                // MONITOREXIT @DISABLED, blocks:[1, 3] lbl11 : MonitorExitStatement: MONITOREXIT : this
                InlineMarker.finallyEnd((int)1);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void clear() {
        synchronized (this) {
            Unit unit = this.a;
            if (unit != null) {
                ArraysKt.fill$default((Object[])unit, null, (int)0, (int)0, (int)6, null);
            }
            _size$FU.set(this, 0);
            unit = Unit.INSTANCE;
            return;
        }
    }

    public final T find(Function1<? super T, Boolean> function1) {
        synchronized (this) {
            Object object;
            block8: {
                T[] TArray;
                int n = 0;
                int n2 = this.getSize();
                while (true) {
                    block7: {
                        TArray = null;
                        object = null;
                        if (n >= n2) break;
                        TArray = this.a;
                        if (TArray == null) break block7;
                        object = TArray[n];
                    }
                    Intrinsics.checkNotNull(object);
                    boolean bl = (Boolean)function1.invoke(object);
                    if (!bl) {
                        ++n;
                        continue;
                    }
                    break block8;
                    break;
                }
                object = TArray;
            }
            return (T)object;
        }
    }

    public final T firstImpl() {
        Object object = this.a;
        object = object != null ? object[0] : null;
        return (T)object;
    }

    public final int getSize() {
        return _size$FU.get(this);
    }

    public final boolean isEmpty() {
        boolean bl = this.getSize() == 0;
        return bl;
    }

    public final T peek() {
        synchronized (this) {
            T t = this.firstImpl();
            return t;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean remove(T object) {
        synchronized (this) {
            ThreadSafeHeap<?> threadSafeHeap = object.getHeap();
            boolean bl = false;
            boolean bl2 = false;
            if (threadSafeHeap != null) {
                int n = object.getIndex();
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (n >= 0) {
                        bl2 = true;
                    }
                    if (!bl2) {
                        AssertionError assertionError = new AssertionError();
                        throw assertionError;
                    }
                }
                this.removeAtImpl(n);
                return true;
            }
            return bl;
        }
    }

    /*
     * Unable to fully structure code
     */
    public final T removeAtImpl(int var1_1) {
        block6: {
            var4_2 = DebugKt.getASSERTIONS_ENABLED();
            var3_3 = 0;
            if (var4_2 && (var2_4 = this.getSize() > 0 ? 1 : 0) == 0) {
                throw new AssertionError();
            }
            var5_5 = this.a;
            Intrinsics.checkNotNull(var5_5);
            this.setSize(this.getSize() - 1);
            if (var1_1 >= this.getSize()) break block6;
            this.swap(var1_1, this.getSize());
            var2_4 = (var1_1 - 1) / 2;
            if (var1_1 <= 0) ** GOTO lbl-1000
            var6_6 = var5_5[var1_1];
            Intrinsics.checkNotNull(var6_6);
            var6_6 = (Comparable)var6_6;
            var7_7 = var5_5[var2_4];
            Intrinsics.checkNotNull(var7_7);
            if (var6_6.compareTo(var7_7) < 0) {
                this.swap(var1_1, var2_4);
                this.siftUpFrom(var2_4);
            } else lbl-1000:
            // 2 sources

            {
                this.siftDownFrom(var1_1);
            }
        }
        var6_6 = var5_5[this.getSize()];
        Intrinsics.checkNotNull(var6_6);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            var1_1 = var3_3;
            if (var6_6.getHeap() == this) {
                var1_1 = 1;
            }
            if (var1_1 == 0) {
                throw new AssertionError();
            }
        }
        var6_6.setHeap(null);
        var6_6.setIndex(-1);
        var5_5[this.getSize()] = null;
        return (T)var6_6;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final T removeFirstIf(Function1<? super T, Boolean> object) {
        Object var2_7;
        T t;
        block7: {
            // MONITORENTER : this
            t = this.firstImpl();
            var2_7 = null;
            if (t != null) break block7;
            InlineMarker.finallyStart((int)2);
            // MONITOREXIT : this
            InlineMarker.finallyEnd((int)2);
            return null;
        }
        try {
            void var1_4;
            if (((Boolean)object.invoke(t)).booleanValue()) {
                T t2 = this.removeAtImpl(0);
                return var1_4;
            } else {
                Object var1_3 = var2_7;
            }
            return var1_4;
        }
        finally {
            InlineMarker.finallyStart((int)1);
        }
    }

    public final T removeFirstOrNull() {
        synchronized (this) {
            T t = this.getSize() > 0 ? (T)this.removeAtImpl(0) : null;
            return t;
        }
    }
}

