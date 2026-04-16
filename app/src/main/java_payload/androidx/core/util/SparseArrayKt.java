/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.IntIterator
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a!\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0086\b\u001a&\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000b\u001a\u0002H\u0002H\u0086\b\u00a2\u0006\u0002\u0010\f\u001aQ\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001a.\u0010\u0013\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002H\u0002H\u0086\b\u00a2\u0006\u0002\u0010\u0015\u001a4\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0086\b\u00a2\u0006\u0002\u0010\u0018\u001a\u0019\u0010\u0019\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0019\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0016\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a-\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001a$\u0010\u001f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a+\u0010 \u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u0002\u00a2\u0006\u0002\u0010!\u001a.\u0010\"\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u0002H\u0086\n\u00a2\u0006\u0002\u0010#\u001a\u001c\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020%\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006&"}, d2={"size", "", "T", "Landroid/util/SparseArray;", "getSize", "(Landroid/util/SparseArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "(Landroid/util/SparseArray;Ljava/lang/Object;)Z", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "(Landroid/util/SparseArray;ILjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/SparseArray;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "(Landroid/util/SparseArray;ILjava/lang/Object;)Z", "set", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "valueIterator", "", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArray<T> sparseArray, int n) {
        boolean bl = sparseArray.indexOfKey(n) >= 0;
        return bl;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int n) {
        boolean bl = sparseArray.indexOfKey(n) >= 0;
        return bl;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t) {
        boolean bl = sparseArray.indexOfValue(t) >= 0;
        return bl;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, Function2<? super Integer, ? super T, Unit> function2) {
        int n = sparseArray.size();
        for (int i = 0; i < n; ++i) {
            function2.invoke((Object)sparseArray.keyAt(i), sparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> object, int n, T t) {
        Object object2 = object.get(n);
        object = object2;
        if (object2 == null) {
            object = t;
        }
        return (T)object;
    }

    public static final <T> T getOrElse(SparseArray<T> object, int n, Function0<? extends T> function0) {
        Object object2 = object.get(n);
        object = object2;
        if (object2 == null) {
            object = function0.invoke();
        }
        return (T)object;
    }

    public static final <T> int getSize(SparseArray<T> sparseArray) {
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        boolean bl = sparseArray.size() == 0;
        return bl;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        boolean bl = sparseArray.size() != 0;
        return bl;
    }

    public static final <T> IntIterator keyIterator(SparseArray<T> sparseArray) {
        return new IntIterator(sparseArray){
            final SparseArray<T> $this_keyIterator;
            private int index;
            {
                this.$this_keyIterator = sparseArray;
            }

            public final int getIndex() {
                return this.index;
            }

            public boolean hasNext() {
                boolean bl = this.index < this.$this_keyIterator.size();
                return bl;
            }

            public int nextInt() {
                SparseArray<T> sparseArray = this.$this_keyIterator;
                int n = this.index;
                this.index = n + 1;
                return sparseArray.keyAt(n);
            }

            public final void setIndex(int n) {
                this.index = n;
            }
        };
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        SparseArray sparseArray3 = new SparseArray(sparseArray.size() + sparseArray2.size());
        SparseArrayKt.putAll(sparseArray3, sparseArray);
        SparseArrayKt.putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        int n = sparseArray2.size();
        for (int i = 0; i < n; ++i) {
            sparseArray.put(sparseArray2.keyAt(i), sparseArray2.valueAt(i));
        }
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int n, T t) {
        if ((n = sparseArray.indexOfKey(n)) >= 0 && Intrinsics.areEqual(t, (Object)sparseArray.valueAt(n))) {
            sparseArray.removeAt(n);
            return true;
        }
        return false;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int n, T t) {
        sparseArray.put(n, t);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> sparseArray) {
        return new Iterator<T>(sparseArray){
            final SparseArray<T> $this_valueIterator;
            private int index;
            {
                this.$this_valueIterator = sparseArray;
            }

            public final int getIndex() {
                return this.index;
            }

            public boolean hasNext() {
                boolean bl = this.index < this.$this_valueIterator.size();
                return bl;
            }

            public T next() {
                SparseArray<T> sparseArray = this.$this_valueIterator;
                int n = this.index;
                this.index = n + 1;
                return (T)sparseArray.valueAt(n);
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

