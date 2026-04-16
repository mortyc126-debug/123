/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseLongArray
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.IntIterator
 *  kotlin.collections.LongIterator
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 */
package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\b\u001aE\u0010\f\u001a\u00020\r*\u00020\u000226\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\r0\u000fH\u0086\b\u001a\u001d\u0010\u0012\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000bH\u0086\b\u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\n\u0010\u0018\u001a\u00020\u0019*\u00020\u0002\u001a\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u001c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u001a\u0010\u001d\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\u001a\u001d\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0086\n\u001a\n\u0010\u001f\u001a\u00020 *\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006!"}, d2={"size", "", "Landroid/util/SparseLongArray;", "getSize", "(Landroid/util/SparseLongArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/LongIterator;", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class SparseLongArrayKt {
    public static final boolean contains(SparseLongArray sparseLongArray, int n) {
        boolean bl = sparseLongArray.indexOfKey(n) >= 0;
        return bl;
    }

    public static final boolean containsKey(SparseLongArray sparseLongArray, int n) {
        boolean bl = sparseLongArray.indexOfKey(n) >= 0;
        return bl;
    }

    public static final boolean containsValue(SparseLongArray sparseLongArray, long l) {
        boolean bl = sparseLongArray.indexOfValue(l) >= 0;
        return bl;
    }

    public static final void forEach(SparseLongArray sparseLongArray, Function2<? super Integer, ? super Long, Unit> function2) {
        int n = sparseLongArray.size();
        for (int i = 0; i < n; ++i) {
            function2.invoke((Object)sparseLongArray.keyAt(i), (Object)sparseLongArray.valueAt(i));
        }
    }

    public static final long getOrDefault(SparseLongArray sparseLongArray, int n, long l) {
        return sparseLongArray.get(n, l);
    }

    public static final long getOrElse(SparseLongArray sparseLongArray, int n, Function0<Long> function0) {
        long l = (n = sparseLongArray.indexOfKey(n)) >= 0 ? sparseLongArray.valueAt(n) : ((Number)function0.invoke()).longValue();
        return l;
    }

    public static final int getSize(SparseLongArray sparseLongArray) {
        return sparseLongArray.size();
    }

    public static final boolean isEmpty(SparseLongArray sparseLongArray) {
        boolean bl = sparseLongArray.size() == 0;
        return bl;
    }

    public static final boolean isNotEmpty(SparseLongArray sparseLongArray) {
        boolean bl = sparseLongArray.size() != 0;
        return bl;
    }

    public static final IntIterator keyIterator(SparseLongArray sparseLongArray) {
        return new IntIterator(sparseLongArray){
            final SparseLongArray $this_keyIterator;
            private int index;
            {
                this.$this_keyIterator = sparseLongArray;
            }

            public final int getIndex() {
                return this.index;
            }

            public boolean hasNext() {
                boolean bl = this.index < this.$this_keyIterator.size();
                return bl;
            }

            public int nextInt() {
                SparseLongArray sparseLongArray = this.$this_keyIterator;
                int n = this.index;
                this.index = n + 1;
                return sparseLongArray.keyAt(n);
            }

            public final void setIndex(int n) {
                this.index = n;
            }
        };
    }

    public static final SparseLongArray plus(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        SparseLongArrayKt.putAll(sparseLongArray3, sparseLongArray);
        SparseLongArrayKt.putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    public static final void putAll(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        int n = sparseLongArray2.size();
        for (int i = 0; i < n; ++i) {
            sparseLongArray.put(sparseLongArray2.keyAt(i), sparseLongArray2.valueAt(i));
        }
    }

    public static final boolean remove(SparseLongArray sparseLongArray, int n, long l) {
        if ((n = sparseLongArray.indexOfKey(n)) >= 0 && l == sparseLongArray.valueAt(n)) {
            sparseLongArray.removeAt(n);
            return true;
        }
        return false;
    }

    public static final void set(SparseLongArray sparseLongArray, int n, long l) {
        sparseLongArray.put(n, l);
    }

    public static final LongIterator valueIterator(SparseLongArray sparseLongArray) {
        return new LongIterator(sparseLongArray){
            final SparseLongArray $this_valueIterator;
            private int index;
            {
                this.$this_valueIterator = sparseLongArray;
            }

            public final int getIndex() {
                return this.index;
            }

            public boolean hasNext() {
                boolean bl = this.index < this.$this_valueIterator.size();
                return bl;
            }

            public long nextLong() {
                SparseLongArray sparseLongArray = this.$this_valueIterator;
                int n = this.index;
                this.index = n + 1;
                return sparseLongArray.valueAt(n);
            }

            public final void setIndex(int n) {
                this.index = n;
            }
        };
    }
}

