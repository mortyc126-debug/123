/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.LruCache
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function4
 */
package androidx.core.util;

import android.util.LruCache;
import androidx.core.util.LruCacheKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001a\u00f8\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000628\b\u0006\u0010\u0007\u001a2\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b2%\b\u0006\u0010\r\u001a\u001f\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u000e2d\b\u0006\u0010\u000f\u001a^\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u0001H\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\u0086\b\u00a8\u0006\u0016"}, d2={"lruCache", "Landroid/util/LruCache;", "K", "V", "", "maxSize", "", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", "create", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class LruCacheKt {
    public static final <K, V> LruCache<K, V> lruCache(int n, Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4) {
        return new LruCache<K, V>(n, function2, function1, function4){
            final Function1<K, V> $create;
            final Function4<Boolean, K, V, V, Unit> $onEntryRemoved;
            final Function2<K, V, Integer> $sizeOf;
            {
                this.$sizeOf = function2;
                this.$create = function1;
                this.$onEntryRemoved = function4;
                super(n);
            }

            protected V create(K k) {
                return (V)this.$create.invoke(k);
            }

            protected void entryRemoved(boolean bl, K k, V v, V v2) {
                this.$onEntryRemoved.invoke((Object)bl, k, v, v2);
            }

            protected int sizeOf(K k, V v) {
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
        return new /* invalid duplicate definition of identical inner class */;
    }
}

