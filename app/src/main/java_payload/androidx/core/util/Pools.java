/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0006"}, d2={"Landroidx/core/util/Pools;", "", "()V", "Pool", "SimplePool", "SynchronizedPool", "core_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class Pools {
    private Pools() {
    }

    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\t\u00c0\u0006\u0001"}, d2={"Landroidx/core/util/Pools$Pool;", "T", "", "acquire", "()Ljava/lang/Object;", "release", "", "instance", "(Ljava/lang/Object;)Z", "core_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static interface Pool<T> {
        public T acquire();

        public boolean release(T var1);
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000f\u0010\u000b\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0010R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Landroidx/core/util/Pools$SimplePool;", "T", "", "Landroidx/core/util/Pools$Pool;", "maxPoolSize", "", "(I)V", "pool", "", "[Ljava/lang/Object;", "poolSize", "acquire", "()Ljava/lang/Object;", "isInPool", "", "instance", "(Ljava/lang/Object;)Z", "release", "core_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class SimplePool<T>
    implements Pool<T> {
        private final Object[] pool;
        private int poolSize;

        public SimplePool(int n) {
            boolean bl = n > 0;
            if (bl) {
                this.pool = new Object[n];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0".toString());
        }

        private final boolean isInPool(T t) {
            int n = this.poolSize;
            for (int i = 0; i < n; ++i) {
                if (this.pool[i] != t) continue;
                return true;
            }
            return false;
        }

        @Override
        public T acquire() {
            if (this.poolSize > 0) {
                int n = this.poolSize - 1;
                Object object = this.pool[n];
                Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
                this.pool[n] = null;
                --this.poolSize;
                return (T)object;
            }
            return null;
        }

        @Override
        public boolean release(T t) {
            Intrinsics.checkNotNullParameter(t, (String)"instance");
            if (this.isInPool(t) ^ true) {
                if (this.poolSize < this.pool.length) {
                    this.pool[this.poolSize] = t;
                    ++this.poolSize;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("Already in the pool!".toString());
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000f\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Landroidx/core/util/Pools$SynchronizedPool;", "T", "", "Landroidx/core/util/Pools$SimplePool;", "maxPoolSize", "", "(I)V", "lock", "acquire", "()Ljava/lang/Object;", "release", "", "instance", "(Ljava/lang/Object;)Z", "core_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class SynchronizedPool<T>
    extends SimplePool<T> {
        private final Object lock = new Object();

        public SynchronizedPool(int n) {
            super(n);
        }

        @Override
        public T acquire() {
            Object object = this.lock;
            synchronized (object) {
                Object t = super.acquire();
                return t;
            }
        }

        @Override
        public boolean release(T t) {
            Intrinsics.checkNotNullParameter(t, (String)"instance");
            Object object = this.lock;
            synchronized (object) {
                boolean bl = super.release(t);
                return bl;
            }
        }
    }
}

