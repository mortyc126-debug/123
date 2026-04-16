/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancelFutureOnCancel;
import kotlinx.coroutines.CancelFutureOnCompletion;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007\u00a8\u0006\b"}, d2={"cancelFutureOnCancellation", "", "Lkotlinx/coroutines/CancellableContinuation;", "future", "Ljava/util/concurrent/Future;", "cancelFutureOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/JobKt")
final class JobKt__FutureKt {
    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        cancellableContinuation.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)new CancelFutureOnCancel(future)));
    }

    public static final DisposableHandle cancelFutureOnCompletion(Job job2, Future<?> future) {
        return job2.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)new CancelFutureOnCompletion(future)));
    }
}

