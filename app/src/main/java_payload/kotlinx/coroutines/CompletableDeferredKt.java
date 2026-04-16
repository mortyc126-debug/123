/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002\u00a2\u0006\u0002\u0010\u0004\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a,\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2={"CompletableDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "T", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;", "parent", "Lkotlinx/coroutines/Job;", "completeWith", "", "result", "Lkotlin/Result;", "(Lkotlinx/coroutines/CompletableDeferred;Ljava/lang/Object;)Z", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class CompletableDeferredKt {
    public static final <T> CompletableDeferred<T> CompletableDeferred(T t) {
        CompletableDeferredImpl<T> completableDeferredImpl = new CompletableDeferredImpl<T>(null);
        completableDeferredImpl.complete(t);
        return completableDeferredImpl;
    }

    public static final <T> CompletableDeferred<T> CompletableDeferred(Job job2) {
        return new CompletableDeferredImpl(job2);
    }

    public static /* synthetic */ CompletableDeferred CompletableDeferred$default(Job job2, int n, Object object) {
        if ((n & 1) != 0) {
            job2 = null;
        }
        return CompletableDeferredKt.CompletableDeferred(job2);
    }

    public static final <T> boolean completeWith(CompletableDeferred<T> completableDeferred, Object object) {
        Throwable throwable = Result.exceptionOrNull-impl((Object)object);
        boolean bl = throwable == null ? completableDeferred.complete(object) : completableDeferred.completeExceptionally(throwable);
        return bl;
    }
}

