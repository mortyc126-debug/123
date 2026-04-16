/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines.internal;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.CtorCache;
import kotlinx.coroutines.internal.ExceptionsConstructorKt;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J*\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\tj\u0002`\n2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R4\u0010\u0005\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\tj\u0002`\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lkotlinx/coroutines/internal/WeakMapCtorCache;", "Lkotlinx/coroutines/internal/CtorCache;", "()V", "cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "get", "key", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class WeakMapCtorCache
extends CtorCache {
    public static final WeakMapCtorCache INSTANCE = new WeakMapCtorCache();
    private static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionCtors = new WeakHashMap();

    private WeakMapCtorCache() {
    }

    /*
     * Loose catch block
     */
    @Override
    public Function1<Throwable, Throwable> get(Class<? extends Throwable> clazz) {
        Function1 function1;
        int n;
        int n2;
        Object object;
        ReentrantReadWriteLock.ReadLock readLock;
        block10: {
            readLock = cacheLock.readLock();
            readLock.lock();
            object = exceptionCtors.get(clazz);
            if (object != null) {
                readLock.unlock();
                return object;
            }
            readLock.unlock();
            object = cacheLock;
            readLock = ((ReentrantReadWriteLock)object).readLock();
            n2 = ((ReentrantReadWriteLock)object).getWriteHoldCount();
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            n2 = n2 == 0 ? ((ReentrantReadWriteLock)object).getReadHoldCount() : 0;
            for (n = 0; n < n2; ++n) {
                readLock.unlock();
            }
            object = ((ReentrantReadWriteLock)object).writeLock();
            ((ReentrantReadWriteLock.WriteLock)object).lock();
            function1 = exceptionCtors.get(clazz);
            if (function1 == null) break block10;
            for (n = n5; n < n2; ++n) {
                readLock.lock();
            }
            ((ReentrantReadWriteLock.WriteLock)object).unlock();
            return function1;
        }
        try {
            function1 = ExceptionsConstructorKt.access$createConstructor(clazz);
            ((Map)exceptionCtors).put(clazz, function1);
        }
        catch (Throwable throwable) {
            for (n = n4; n < n2; ++n) {
                readLock.lock();
            }
            ((ReentrantReadWriteLock.WriteLock)object).unlock();
            throw throwable;
        }
        for (n = n3; n < n2; ++n) {
            readLock.lock();
        }
        ((ReentrantReadWriteLock.WriteLock)object).unlock();
        return function1;
        catch (Throwable throwable) {
            readLock.unlock();
            throw throwable;
        }
    }
}

