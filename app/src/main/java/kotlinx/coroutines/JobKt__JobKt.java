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
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.DisposeOnCompletion;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobSupport;

@Metadata(d1={"\u0000B\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u001a\u0019\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007\u00a2\u0006\u0002\b\b\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0002H\u0007\u001a\u0018\u0010\f\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u001a\u001e\u0010\f\u001a\u00020\r*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a\u0015\u0010\u0014\u001a\u00020\r*\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015\u001a\f\u0010\u0016\u001a\u00020\r*\u00020\u0002H\u0007\u001a\u0018\u0010\u0016\u001a\u00020\r*\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u001c\u0010\u0016\u001a\u00020\r*\u00020\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u001a\f\u0010\u0016\u001a\u00020\r*\u00020\u0005H\u0007\u001a\u0018\u0010\u0016\u001a\u00020\r*\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u001c\u0010\u0016\u001a\u00020\r*\u00020\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u001a\u0014\u0010\u0017\u001a\u00020\u0018*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0000\u001a\n\u0010\u001a\u001a\u00020\r*\u00020\u0002\u001a\n\u0010\u001a\u001a\u00020\r*\u00020\u0005\u001a\u001b\u0010\u001b\u001a\u00020\u000f*\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u00a2\u0006\u0002\b\u001c\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2={"isActive", "", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Z", "job", "Lkotlinx/coroutines/Job;", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "Job", "Lkotlinx/coroutines/CompletableJob;", "parent", "Job0", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cancelAndJoin", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelChildren", "disposeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "handle", "ensureActive", "orCancellation", "orCancellation$JobKt__JobKt", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/JobKt")
final class JobKt__JobKt {
    public static final CompletableJob Job(Job job2) {
        return new JobImpl(job2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ Job Job(Job job2) {
        return JobKt.Job(job2);
    }

    public static /* synthetic */ CompletableJob Job$default(Job job2, int n, Object object) {
        if ((n & 1) != 0) {
            job2 = null;
        }
        return JobKt.Job(job2);
    }

    public static /* synthetic */ Job Job$default(Job job2, int n, Object object) {
        if ((n & 1) != 0) {
            job2 = null;
        }
        return JobKt.Job(job2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancel(CoroutineContext coroutineContext) {
        JobKt.cancel(coroutineContext, null);
    }

    public static final void cancel(CoroutineContext object, CancellationException cancellationException) {
        if ((object = (Job)object.get((CoroutineContext.Key)Job.Key)) != null) {
            object.cancel(cancellationException);
        }
    }

    public static final void cancel(Job job2, String string2, Throwable throwable) {
        job2.cancel(ExceptionsKt.CancellationException(string2, throwable));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean cancel(CoroutineContext object, Throwable throwable) {
        if ((object = (object = object.get((CoroutineContext.Key)Job.Key)) instanceof JobSupport ? (JobSupport)object : null) == null) {
            return false;
        }
        ((JobSupport)object).cancelInternal(JobKt__JobKt.orCancellation$JobKt__JobKt(throwable, (Job)object));
        return true;
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int n, Object object) {
        if ((n & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancel(coroutineContext, cancellationException);
    }

    public static /* synthetic */ void cancel$default(Job job2, String string2, Throwable throwable, int n, Object object) {
        if ((n & 2) != 0) {
            throwable = null;
        }
        JobKt.cancel(job2, string2, throwable);
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext coroutineContext, Throwable throwable, int n, Object object) {
        if ((n & 1) != 0) {
            throwable = null;
        }
        return JobKt.cancel(coroutineContext, throwable);
    }

    public static final Object cancelAndJoin(Job object, Continuation<? super Unit> continuation) {
        Job.DefaultImpls.cancel$default((Job)object, null, 1, null);
        object = object.join(continuation);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext coroutineContext) {
        JobKt.cancelChildren(coroutineContext, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext object2, Throwable throwable) {
        Job job2 = (Job)object2.get((CoroutineContext.Key)Job.Key);
        if (job2 == null) {
            return;
        }
        for (Object object2 : job2.getChildren()) {
            object2 = object2 instanceof JobSupport ? (JobSupport)object2 : null;
            if (object2 == null) continue;
            ((JobSupport)object2).cancelInternal(JobKt__JobKt.orCancellation$JobKt__JobKt(throwable, job2));
        }
    }

    public static final void cancelChildren(CoroutineContext object, CancellationException cancellationException) {
        if ((object = (Job)object.get((CoroutineContext.Key)Job.Key)) != null && (object = object.getChildren()) != null) {
            object = object.iterator();
            while (object.hasNext()) {
                ((Job)object.next()).cancel(cancellationException);
            }
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job job2) {
        JobKt.cancelChildren(job2, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job job2, Throwable throwable) {
        for (Job job3 : job2.getChildren()) {
            job3 = job3 instanceof JobSupport ? (JobSupport)job3 : null;
            if (job3 == null) continue;
            ((JobSupport)job3).cancelInternal(JobKt__JobKt.orCancellation$JobKt__JobKt(throwable, job2));
        }
    }

    public static final void cancelChildren(Job object, CancellationException cancellationException) {
        object = object.getChildren().iterator();
        while (object.hasNext()) {
            ((Job)object.next()).cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, Throwable throwable, int n, Object object) {
        if ((n & 1) != 0) {
            throwable = null;
        }
        JobKt.cancelChildren(coroutineContext, throwable);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException, int n, Object object) {
        if ((n & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    public static /* synthetic */ void cancelChildren$default(Job job2, Throwable throwable, int n, Object object) {
        if ((n & 1) != 0) {
            throwable = null;
        }
        JobKt.cancelChildren(job2, throwable);
    }

    public static /* synthetic */ void cancelChildren$default(Job job2, CancellationException cancellationException, int n, Object object) {
        if ((n & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(job2, cancellationException);
    }

    public static final DisposableHandle disposeOnCompletion(Job job2, DisposableHandle disposableHandle) {
        return job2.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)new DisposeOnCompletion(disposableHandle)));
    }

    public static final void ensureActive(CoroutineContext object) {
        if ((object = (Job)object.get((CoroutineContext.Key)Job.Key)) != null) {
            JobKt.ensureActive((Job)object);
        }
    }

    public static final void ensureActive(Job job2) {
        if (job2.isActive()) {
            return;
        }
        throw job2.getCancellationException();
    }

    public static final Job getJob(CoroutineContext coroutineContext) {
        Job job2 = (Job)coroutineContext.get((CoroutineContext.Key)Job.Key);
        if (job2 != null) {
            return job2;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static final boolean isActive(CoroutineContext object) {
        boolean bl = (object = (Job)object.get((CoroutineContext.Key)Job.Key)) != null ? object.isActive() : true;
        return bl;
    }

    private static final Throwable orCancellation$JobKt__JobKt(Throwable throwable, Job job2) {
        block0: {
            if (throwable != null) break block0;
            throwable = new JobCancellationException("Job was cancelled", null, job2);
        }
        return throwable;
    }
}

