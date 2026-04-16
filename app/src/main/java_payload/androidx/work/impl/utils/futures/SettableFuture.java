/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work.impl.utils.futures;

import androidx.work.impl.utils.futures.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;

public final class SettableFuture<V>
extends AbstractFuture<V> {
    private SettableFuture() {
    }

    public static <V> SettableFuture<V> create() {
        return new SettableFuture<V>();
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

