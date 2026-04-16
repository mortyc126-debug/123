/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.collection;

import androidx.collection.ArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0086\b\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0004\"\u0002H\u0002\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2={"arraySetOf", "Landroidx/collection/ArraySet;", "T", "values", "", "([Ljava/lang/Object;)Landroidx/collection/ArraySet;", "collection-ktx"}, k=2, mv={1, 1, 13})
public final class ArraySetKt {
    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet();
    }

    public static final <T> ArraySet<T> arraySetOf(T ... TArray) {
        Intrinsics.checkParameterIsNotNull(TArray, (String)"values");
        ArraySet<T> arraySet = new ArraySet<T>(TArray.length);
        int n = TArray.length;
        for (int i = 0; i < n; ++i) {
            arraySet.add(TArray[i]);
        }
        return arraySet;
    }
}

