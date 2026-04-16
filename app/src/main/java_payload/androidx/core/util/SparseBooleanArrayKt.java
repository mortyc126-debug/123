/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseBooleanArray
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.BooleanIterator
 *  kotlin.collections.IntIterator
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 */
package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.BooleanIterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0086\b\u001aE\u0010\u000b\u001a\u00020\f*\u00020\u000226\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f0\u000eH\u0086\b\u001a\u001d\u0010\u0011\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0006H\u0086\b\u001a#\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0086\b\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u001b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u001a\u0010\u001c\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006\u001a\u001d\u0010\u001d\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0086\n\u001a\n\u0010\u001e\u001a\u00020\u001f*\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006 "}, d2={"size", "", "Landroid/util/SparseBooleanArray;", "getSize", "(Landroid/util/SparseBooleanArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/BooleanIterator;", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray sparseBooleanArray, int n) {
        boolean bl = sparseBooleanArray.indexOfKey(n) >= 0;
        return bl;
    }

    public static final boolean containsKey(SparseBooleanArray sparseBooleanArray, int n) {
        boolean bl = sparseBooleanArray.indexOfKey(n) >= 0;
        return bl;
    }

    public static final boolean containsValue(SparseBooleanArray sparseBooleanArray, boolean bl) {
        bl = sparseBooleanArray.indexOfValue(bl) >= 0;
        return bl;
    }

    public static final void forEach(SparseBooleanArray sparseBooleanArray, Function2<? super Integer, ? super Boolean, Unit> function2) {
        int n = sparseBooleanArray.size();
        for (int i = 0; i < n; ++i) {
            function2.invoke((Object)sparseBooleanArray.keyAt(i), (Object)sparseBooleanArray.valueAt(i));
        }
    }

    public static final boolean getOrDefault(SparseBooleanArray sparseBooleanArray, int n, boolean bl) {
        return sparseBooleanArray.get(n, bl);
    }

    public static final boolean getOrElse(SparseBooleanArray sparseBooleanArray, int n, Function0<Boolean> function0) {
        boolean bl = (n = sparseBooleanArray.indexOfKey(n)) >= 0 ? sparseBooleanArray.valueAt(n) : ((Boolean)function0.invoke()).booleanValue();
        return bl;
    }

    public static final int getSize(SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(SparseBooleanArray sparseBooleanArray) {
        boolean bl = sparseBooleanArray.size() == 0;
        return bl;
    }

    public static final boolean isNotEmpty(SparseBooleanArray sparseBooleanArray) {
        boolean bl = sparseBooleanArray.size() != 0;
        return bl;
    }

    public static final IntIterator keyIterator(SparseBooleanArray sparseBooleanArray) {
        return new IntIterator(sparseBooleanArray){
            final SparseBooleanArray $this_keyIterator;
            private int index;
            {
                this.$this_keyIterator = sparseBooleanArray;
            }

            public final int getIndex() {
                return this.index;
            }

            public boolean hasNext() {
                boolean bl = this.index < this.$this_keyIterator.size();
                return bl;
            }

            public int nextInt() {
                SparseBooleanArray sparseBooleanArray = this.$this_keyIterator;
                int n = this.index;
                this.index = n + 1;
                return sparseBooleanArray.keyAt(n);
            }

            public final void setIndex(int n) {
                this.index = n;
            }
        };
    }

    public static final SparseBooleanArray plus(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
        SparseBooleanArrayKt.putAll(sparseBooleanArray3, sparseBooleanArray);
        SparseBooleanArrayKt.putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        int n = sparseBooleanArray2.size();
        for (int i = 0; i < n; ++i) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i), sparseBooleanArray2.valueAt(i));
        }
    }

    public static final boolean remove(SparseBooleanArray sparseBooleanArray, int n, boolean bl) {
        int n2 = sparseBooleanArray.indexOfKey(n);
        if (n2 >= 0 && bl == sparseBooleanArray.valueAt(n2)) {
            sparseBooleanArray.delete(n);
            return true;
        }
        return false;
    }

    public static final void set(SparseBooleanArray sparseBooleanArray, int n, boolean bl) {
        sparseBooleanArray.put(n, bl);
    }

    public static final BooleanIterator valueIterator(SparseBooleanArray sparseBooleanArray) {
        return new BooleanIterator(sparseBooleanArray){
            final SparseBooleanArray $this_valueIterator;
            private int index;
            {
                this.$this_valueIterator = sparseBooleanArray;
            }

            public final int getIndex() {
                return this.index;
            }

            public boolean hasNext() {
                boolean bl = this.index < this.$this_valueIterator.size();
                return bl;
            }

            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray = this.$this_valueIterator;
                int n = this.index;
                this.index = n + 1;
                return sparseBooleanArray.valueAt(n);
            }

            public final void setIndex(int n) {
                this.index = n;
            }
        };
    }
}

