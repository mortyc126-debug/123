/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.IntIterator
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.collection;

import androidx.collection.SparseArrayCompat;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000@\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001aQ\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\n0\fH\u0086\b\u001a.\u0010\u0010\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u0002H\u0002H\u0086\b\u00a2\u0006\u0002\u0010\u0012\u001a4\u0010\u0013\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0014H\u0086\b\u00a2\u0006\u0002\u0010\u0015\u001a\u0019\u0010\u0016\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0016\u0010\u0017\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a-\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001a-\u0010\u001b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u0002H\u0002H\u0007\u00a2\u0006\u0002\u0010\u001c\u001a.\u0010\u001d\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u0002H\u0002H\u0086\n\u00a2\u0006\u0002\u0010\u001e\u001a\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020 \"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006!"}, d2={"size", "", "T", "Landroidx/collection/SparseArrayCompat;", "getSize", "(Landroidx/collection/SparseArrayCompat;)I", "contains", "", "key", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "getOrDefault", "defaultValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroidx/collection/SparseArrayCompat;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "remove", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Z", "set", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)V", "valueIterator", "", "collection-ktx"}, k=2, mv={1, 1, 13})
public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArrayCompat<T> sparseArrayCompat, int n) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, (String)"receiver$0");
        return sparseArrayCompat.containsKey(n);
    }

    public static final <T> void forEach(SparseArrayCompat<T> sparseArrayCompat, Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, (String)"receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, (String)"action");
        int n = sparseArrayCompat.size();
        for (int i = 0; i < n; ++i) {
            function2.invoke((Object)sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> sparseArrayCompat, int n, T t) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, (String)"receiver$0");
        return sparseArrayCompat.get(n, t);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> object, int n, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(object, (String)"receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, (String)"defaultValue");
        object = ((SparseArrayCompat)object).get(n);
        if (object == null) {
            object = function0.invoke();
        }
        return (T)object;
    }

    public static final <T> int getSize(SparseArrayCompat<T> sparseArrayCompat) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, (String)"receiver$0");
        return sparseArrayCompat.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> sparseArrayCompat) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, (String)"receiver$0");
        return sparseArrayCompat.isEmpty() ^ true;
    }

    public static final <T> IntIterator keyIterator(SparseArrayCompat<T> sparseArrayCompat) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, (String)"receiver$0");
        return new IntIterator(sparseArrayCompat){
            final SparseArrayCompat $this_keyIterator;
            private int index;
            {
                this.$this_keyIterator = sparseArrayCompat;
            }

            public final int getIndex() {
                return this.index;
            }

            public boolean hasNext() {
                boolean bl = this.index < this.$this_keyIterator.size();
                return bl;
            }

            public int nextInt() {
                SparseArrayCompat sparseArrayCompat = this.$this_keyIterator;
                int n = this.index;
                this.index = n + 1;
                return sparseArrayCompat.keyAt(n);
            }

            public final void setIndex(int n) {
                this.index = n;
            }
        };
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> sparseArrayCompat, SparseArrayCompat<T> sparseArrayCompat2) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, (String)"receiver$0");
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat2, (String)"other");
        SparseArrayCompat<T> sparseArrayCompat3 = new SparseArrayCompat<T>(sparseArrayCompat.size() + sparseArrayCompat2.size());
        sparseArrayCompat3.putAll(sparseArrayCompat);
        sparseArrayCompat3.putAll(sparseArrayCompat2);
        return sparseArrayCompat3;
    }

    @Deprecated(message="Replaced with member function. Remove extension import!")
    public static final <T> boolean remove(SparseArrayCompat<T> sparseArrayCompat, int n, T t) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, (String)"receiver$0");
        return sparseArrayCompat.remove(n, t);
    }

    public static final <T> void set(SparseArrayCompat<T> sparseArrayCompat, int n, T t) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, (String)"receiver$0");
        sparseArrayCompat.put(n, t);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> sparseArrayCompat) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, (String)"receiver$0");
        return new Iterator<T>(sparseArrayCompat){
            final SparseArrayCompat $this_valueIterator;
            private int index;
            {
                this.$this_valueIterator = sparseArrayCompat;
            }

            public final int getIndex() {
                return this.index;
            }

            public boolean hasNext() {
                boolean bl = this.index < this.$this_valueIterator.size();
                return bl;
            }

            public T next() {
                SparseArrayCompat sparseArrayCompat = this.$this_valueIterator;
                int n = this.index;
                this.index = n + 1;
                return (T)sparseArrayCompat.valueAt(n);
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

