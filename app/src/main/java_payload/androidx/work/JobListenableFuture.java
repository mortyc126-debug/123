/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.ListenableFuture
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work;

import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0002\u0010\u0007J)\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b2\u000e\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\n \f*\u0004\u0018\u00018\u00008\u0000H\u0096\u0001\u00a2\u0006\u0002\u0010\u0015J.\u0010\u0014\u001a\n \f*\u0004\u0018\u00018\u00008\u00002\u0006\u0010\n\u001a\u00020\u00162\u000e\u0010\r\u001a\n \f*\u0004\u0018\u00010\u00170\u0017H\u0096\u0003\u00a2\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0010H\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Landroidx/work/JobListenableFuture;", "R", "Lcom/google/common/util/concurrent/ListenableFuture;", "job", "Lkotlinx/coroutines/Job;", "underlying", "Landroidx/work/impl/utils/futures/SettableFuture;", "(Lkotlinx/coroutines/Job;Landroidx/work/impl/utils/futures/SettableFuture;)V", "addListener", "", "p0", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "p1", "Ljava/util/concurrent/Executor;", "cancel", "", "complete", "result", "(Ljava/lang/Object;)V", "get", "()Ljava/lang/Object;", "", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "isCancelled", "isDone", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class JobListenableFuture<R>
implements ListenableFuture<R> {
    private final Job job;
    private final SettableFuture<R> underlying;

    public JobListenableFuture(Job job2, SettableFuture<R> settableFuture) {
        Intrinsics.checkNotNullParameter((Object)job2, (String)"job");
        Intrinsics.checkNotNullParameter(settableFuture, (String)"underlying");
        this.job = job2;
        this.underlying = settableFuture;
        this.job.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(this){
            final JobListenableFuture<R> this$0;
            {
                this.this$0 = jobListenableFuture;
                super(1);
            }

            public final void invoke(Throwable throwable) {
                if (throwable == null) {
                    if (!this.this$0.underlying.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else if (throwable instanceof CancellationException) {
                    this.this$0.underlying.cancel(true);
                } else {
                    Throwable throwable2;
                    SettableFuture settableFuture = this.this$0.underlying;
                    Throwable throwable3 = throwable2 = throwable.getCause();
                    if (throwable2 == null) {
                        throwable3 = throwable;
                    }
                    settableFuture.setException(throwable3);
                }
            }
        }));
    }

    public /* synthetic */ JobListenableFuture(Job job2, SettableFuture settableFuture, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            settableFuture = SettableFuture.create();
            Intrinsics.checkNotNullExpressionValue(settableFuture, (String)"create()");
        }
        this(job2, settableFuture);
    }

    public void addListener(Runnable runnable2, Executor executor) {
        this.underlying.addListener(runnable2, executor);
    }

    public boolean cancel(boolean bl) {
        return this.underlying.cancel(bl);
    }

    public final void complete(R r) {
        this.underlying.set(r);
    }

    public R get() {
        return (R)this.underlying.get();
    }

    public R get(long l, TimeUnit timeUnit) {
        return (R)this.underlying.get(l, timeUnit);
    }

    public boolean isCancelled() {
        return this.underlying.isCancelled();
    }

    public boolean isDone() {
        return this.underlying.isDone();
    }
}

