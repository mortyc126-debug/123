/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.ThreadPoolDispatcherKt$$ExternalSyntheticLambda0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a8\u0006\u0007"}, d2={"newFixedThreadPoolContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "nThreads", "", "name", "", "newSingleThreadContext", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class ThreadPoolDispatcherKt {
    public static /* synthetic */ Thread $r8$lambda$riuIvi8mr1MS_Bpu-1FqJ0BJlQ8(int n, String string2, AtomicInteger atomicInteger, Runnable runnable2) {
        return ThreadPoolDispatcherKt.newFixedThreadPoolContext$lambda$1(n, string2, atomicInteger, runnable2);
    }

    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(int n, String string2) {
        boolean bl = true;
        if (n < 1) {
            bl = false;
        }
        if (bl) {
            return ExecutorsKt.from(Executors.newScheduledThreadPool(n, new ThreadPoolDispatcherKt$$ExternalSyntheticLambda0(n, string2, new AtomicInteger())));
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + n + " specified").toString());
    }

    private static final Thread newFixedThreadPoolContext$lambda$1(int n, String object, AtomicInteger atomicInteger, Runnable runnable2) {
        if (n != 1) {
            object = (String)object + '-' + atomicInteger.incrementAndGet();
        }
        object = new Thread(runnable2, (String)object);
        ((Thread)object).setDaemon(true);
        return object;
    }

    public static final ExecutorCoroutineDispatcher newSingleThreadContext(String string2) {
        return ThreadPoolDispatcherKt.newFixedThreadPoolContext(1, string2);
    }
}

