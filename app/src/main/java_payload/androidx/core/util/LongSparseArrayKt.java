/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.LongSparseArray
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.LongIterator
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.core.util;

import android.util.LongSparseArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0086\n\u001a!\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0086\b\u001a&\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\f\u001a\u0002H\u0002H\u0086\b\u00a2\u0006\u0002\u0010\r\u001aQ\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f0\u0011H\u0086\b\u001a.\u0010\u0014\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u0002H\u0002H\u0086\b\u00a2\u0006\u0002\u0010\u0016\u001a4\u0010\u0017\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018H\u0086\b\u00a2\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0019\u0010\u001b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0016\u0010\u001c\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a-\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001a$\u0010 \u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a+\u0010!\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u0002H\u0002\u00a2\u0006\u0002\u0010\"\u001a.\u0010#\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u0002H\u0002H\u0086\n\u00a2\u0006\u0002\u0010$\u001a\u001c\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020&\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006'"}, d2={"size", "", "T", "Landroid/util/LongSparseArray;", "getSize", "(Landroid/util/LongSparseArray;)I", "contains", "", "key", "", "containsKey", "containsValue", "value", "(Landroid/util/LongSparseArray;Ljava/lang/Object;)Z", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/LongIterator;", "plus", "other", "putAll", "remove", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Z", "set", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)V", "valueIterator", "", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class LongSparseArrayKt {
    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long l) {
        boolean bl = longSparseArray.indexOfKey(l) >= 0;
        return bl;
    }

    public static final <T> boolean containsKey(LongSparseArray<T> longSparseArray, long l) {
        boolean bl = longSparseArray.indexOfKey(l) >= 0;
        return bl;
    }

    public static final <T> boolean containsValue(LongSparseArray<T> longSparseArray, T t) {
        boolean bl = longSparseArray.indexOfValue(t) >= 0;
        return bl;
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, Function2<? super Long, ? super T, Unit> function2) {
        int n = longSparseArray.size();
        for (int i = 0; i < n; ++i) {
            function2.invoke((Object)longSparseArray.keyAt(i), longSparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> object, long l, T t) {
        Object object2 = object.get(l);
        object = object2;
        if (object2 == null) {
            object = t;
        }
        return (T)object;
    }

    public static final <T> T getOrElse(LongSparseArray<T> object, long l, Function0<? extends T> function0) {
        Object object2 = object.get(l);
        object = object2;
        if (object2 == null) {
            object = function0.invoke();
        }
        return (T)object;
    }

    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        return longSparseArray.size();
    }

    public static final <T> boolean isEmpty(LongSparseArray<T> longSparseArray) {
        boolean bl = longSparseArray.size() == 0;
        return bl;
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        boolean bl = longSparseArray.size() != 0;
        return bl;
    }

    public static final <T> LongIterator keyIterator(LongSparseArray<T> longSparseArray) {
        return new LongIterator(longSparseArray){
            final LongSparseArray<T> $this_keyIterator;
            private int index;
            {
                this.$this_keyIterator = longSparseArray;
            }

            public final int getIndex() {
                return this.index;
            }

            public boolean hasNext() {
                boolean bl = this.index < this.$this_keyIterator.size();
                return bl;
            }

            public long nextLong() {
                LongSparseArray<T> longSparseArray = this.$this_keyIterator;
                int n = this.index;
                this.index = n + 1;
                return longSparseArray.keyAt(n);
            }

            public final void setIndex(int n) {
                this.index = n;
            }
        };
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        LongSparseArray longSparseArray3 = new LongSparseArray(longSparseArray.size() + longSparseArray2.size());
        LongSparseArrayKt.putAll(longSparseArray3, longSparseArray);
        LongSparseArrayKt.putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    public static final <T> void putAll(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        int n = longSparseArray2.size();
        for (int i = 0; i < n; ++i) {
            longSparseArray.put(longSparseArray2.keyAt(i), longSparseArray2.valueAt(i));
        }
    }

    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long l, T t) {
        int n = longSparseArray.indexOfKey(l);
        if (n >= 0 && Intrinsics.areEqual(t, (Object)longSparseArray.valueAt(n))) {
            longSparseArray.removeAt(n);
            return true;
        }
        return false;
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long l, T t) {
        longSparseArray.put(l, t);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        return new Iterator<T>(longSparseArray){
            final LongSparseArray<T> $this_valueIterator;
            private int index;
            {
                this.$this_valueIterator = longSparseArray;
            }

            public final int getIndex() {
                return this.index;
            }

            public boolean hasNext() {
                boolean bl = this.index < this.$this_valueIterator.size();
                return bl;
            }

            public T next() {
                LongSparseArray<T> longSparseArray = this.$this_valueIterator;
                int n = this.index;
                this.index = n + 1;
                return (T)longSparseArray.valueAt(n);
            }

            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            public final void setIndex(int n) {
                this.index = n;
            }
        };
    }
}

