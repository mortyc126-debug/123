/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__FutureKt;
import kotlinx.coroutines.JobKt__JobKt;

@Metadata(d1={"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k=4, mv={1, 8, 0}, xi=48)
public final class JobKt {
    public static final CompletableJob Job(Job job2) {
        return JobKt__JobKt.Job(job2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ Job Job(Job job2) {
        return JobKt__JobKt.Job(job2);
    }

    public static /* synthetic */ CompletableJob Job$default(Job job2, int n, Object object) {
        return JobKt__JobKt.Job$default(job2, n, object);
    }

    public static /* synthetic */ Job Job$default(Job job2, int n, Object object) {
        return JobKt__JobKt.Job$default(job2, n, object);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancel(CoroutineContext coroutineContext) {
        JobKt__JobKt.cancel(coroutineContext);
    }

    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        JobKt__JobKt.cancel(coroutineContext, cancellationException);
    }

    public static final void cancel(Job job2, String string2, Throwable throwable) {
        JobKt__JobKt.cancel(job2, string2, throwable);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean cancel(CoroutineContext coroutineContext, Throwable throwable) {
        return JobKt__JobKt.cancel(coroutineContext, throwable);
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int n, Object object) {
        JobKt__JobKt.cancel$default(coroutineContext, cancellationException, n, object);
    }

    public static /* synthetic */ void cancel$default(Job job2, String string2, Throwable throwable, int n, Object object) {
        JobKt__JobKt.cancel$default(job2, string2, throwable, n, object);
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext coroutineContext, Throwable throwable, int n, Object object) {
        return JobKt__JobKt.cancel$default(coroutineContext, throwable, n, object);
    }

    public static final Object cancelAndJoin(Job job2, Continuation<? super Unit> continuation) {
        return JobKt__JobKt.cancelAndJoin(job2, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext coroutineContext) {
        JobKt__JobKt.cancelChildren(coroutineContext);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext coroutineContext, Throwable throwable) {
        JobKt__JobKt.cancelChildren(coroutineContext, throwable);
    }

    public static final void cancelChildren(CoroutineContext coroutineContext, CancellationException cancellationException) {
        JobKt__JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job job2) {
        JobKt__JobKt.cancelChildren(job2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job job2, Throwable throwable) {
        JobKt__JobKt.cancelChildren(job2, throwable);
    }

    public static final void cancelChildren(Job job2, CancellationException cancellationException) {
        JobKt__JobKt.cancelChildren(job2, cancellationException);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, Throwable throwable, int n, Object object) {
        JobKt__JobKt.cancelChildren$default(coroutineContext, throwable, n, object);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException, int n, Object object) {
        JobKt__JobKt.cancelChildren$default(coroutineContext, cancellationException, n, object);
    }

    public static /* synthetic */ void cancelChildren$default(Job job2, Throwable throwable, int n, Object object) {
        JobKt__JobKt.cancelChildren$default(job2, throwable, n, object);
    }

    public static /* synthetic */ void cancelChildren$default(Job job2, CancellationException cancellationException, int n, Object object) {
        JobKt__JobKt.cancelChildren$default(job2, cancellationException, n, object);
    }

    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        JobKt__FutureKt.cancelFutureOnCancellation(cancellableContinuation, future);
    }

    public static final DisposableHandle cancelFutureOnCompletion(Job job2, Future<?> future) {
        return JobKt__FutureKt.cancelFutureOnCompletion(job2, future);
    }

    public static final DisposableHandle disposeOnCompletion(Job job2, DisposableHandle disposableHandle) {
        return JobKt__JobKt.disposeOnCompletion(job2, disposableHandle);
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        JobKt__JobKt.ensureActive(coroutineContext);
    }

    public static final void ensureActive(Job job2) {
        JobKt__JobKt.ensureActive(job2);
    }

    public static final Job getJob(CoroutineContext coroutineContext) {
        return JobKt__JobKt.getJob(coroutineContext);
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        return JobKt__JobKt.isActive(coroutineContext);
    }
}

