/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;

public final class ResolvableFuture<V>
extends AbstractResolvableFuture<V> {
    private ResolvableFuture() {
    }

    public static <V> ResolvableFuture<V> create() {
        return new ResolvableFuture<V>();
    }

    @Override
    public boolean set(V v) {
        return super.set(v);
    }

    @Override
    public boolean setException(Throwable throwable) {
        return super.setException(throwable);
    }

    @Override
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        return super.setFuture(listenableFuture);
    }
}

