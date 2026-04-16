/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.collection;

import androidx.collection.LruCache;
import androidx.collection.LruCacheKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001a\u00f8\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000628\b\u0006\u0010\u0007\u001a2\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b2%\b\u0006\u0010\r\u001a\u001f\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u000e2d\b\u0006\u0010\u000f\u001a^\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u0001H\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\u0086\b\u00a8\u0006\u0016"}, d2={"lruCache", "Landroidx/collection/LruCache;", "K", "V", "", "maxSize", "", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", "create", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "", "collection-ktx"}, k=2, mv={1, 1, 13})
public final class LruCacheKt {
    public static final <K, V> LruCache<K, V> lruCache(int n, Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4) {
        Intrinsics.checkParameterIsNotNull(function2, (String)"sizeOf");
        Intrinsics.checkParameterIsNotNull(function1, (String)"create");
        Intrinsics.checkParameterIsNotNull(function4, (String)"onEntryRemoved");
        return new LruCache<K, V>(function2, function1, function4, n, n){
            final Function1 $create;
            final int $maxSize;
            final Function4 $onEntryRemoved;
            final Function2 $sizeOf;
            {
                this.$sizeOf = function2;
                this.$create = function1;
                this.$onEntryRemoved = function4;
                this.$maxSize = n;
                super(n2);
            }

            protected V create(K k) {
                Intrinsics.checkParameterIsNotNull(k, (String)"key");
                return (V)this.$create.invoke(k);
            }

            protected void entryRemoved(boolean bl, K k, V v, V v2) {
                Intrinsics.checkParameterIsNotNull(k, (String)"key");
                Intrinsics.checkParameterIsNotNull(v, (String)"oldValue");
                this.$onEntryRemoved.invoke((Object)bl, k, v, v2);
            }

            protected int sizeOf(K k, V v) {
                Intrinsics.checkParameterIsNotNull(k, (String)"key");
                Intrinsics.checkParameterIsNotNull(v, (String)"value");
                return ((Number)this.$sizeOf.invoke(k, v)).intValue();
            }
        };
    }

    public static /* synthetic */ LruCache lruCache$default(int n, Function2 function2, Function1 function1, Function4 function4, int n2, Object object) {
        if ((n2 & 2) != 0) {
            function2 = lruCache.1.INSTANCE;
        }
        if ((n2 & 4) != 0) {
            function1 = lruCache.2.INSTANCE;
        }
        if ((n2 & 8) != 0) {
            function4 = lruCache.3.INSTANCE;
        }
        Intrinsics.checkParameterIsNotNull((Object)function2, (String)"sizeOf");
        Intrinsics.checkParameterIsNotNull((Object)function1, (String)"create");
        Intrinsics.checkParameterIsNotNull((Object)function4, (String)"onEntryRemoved");
        return new /* invalid duplicate definition of identical inner class */;
    }
}

