/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.common.util.concurrent.ListenableFuture
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work;

import android.content.Context;
import androidx.work.CoroutineWorker$$ExternalSyntheticLambda0;
import androidx.work.Data;
import androidx.work.DirectExecutor;
import androidx.work.ForegroundInfo;
import androidx.work.JobListenableFuture;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0016\u001a\u00020\u000fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u0019H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0019\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bR\u001c\u0010\u0007\u001a\u00020\b8\u0016X\u0097\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2={"Landroidx/work/CoroutineWorker;", "Landroidx/work/ListenableWorker;", "appContext", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "coroutineContext", "Lkotlinx/coroutines/CoroutineDispatcher;", "getCoroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlinx/coroutines/CoroutineDispatcher;", "future", "Landroidx/work/impl/utils/futures/SettableFuture;", "Landroidx/work/ListenableWorker$Result;", "getFuture$work_runtime_release", "()Landroidx/work/impl/utils/futures/SettableFuture;", "job", "Lkotlinx/coroutines/CompletableJob;", "getJob$work_runtime_release", "()Lkotlinx/coroutines/CompletableJob;", "doWork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getForegroundInfo", "Landroidx/work/ForegroundInfo;", "getForegroundInfoAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "onStopped", "", "setForeground", "foregroundInfo", "(Landroidx/work/ForegroundInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setProgress", "data", "Landroidx/work/Data;", "(Landroidx/work/Data;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startWork", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class CoroutineWorker
extends ListenableWorker {
    private final CoroutineDispatcher coroutineContext;
    private final SettableFuture<ListenableWorker.Result> future;
    private final CompletableJob job;

    public static /* synthetic */ void $r8$lambda$vS4ut6uACXh9vB8D1LtSlAShhGE(CoroutineWorker coroutineWorker) {
        CoroutineWorker._init_$lambda$0(coroutineWorker);
    }

    public CoroutineWorker(Context object, WorkerParameters workerParameters) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"appContext");
        Intrinsics.checkNotNullParameter((Object)workerParameters, (String)"params");
        super((Context)object, workerParameters);
        this.job = JobKt.Job$default(null, 1, null);
        object = SettableFuture.create();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"create()");
        this.future = object;
        this.future.addListener(new CoroutineWorker$$ExternalSyntheticLambda0(this), this.getTaskExecutor().getSerialTaskExecutor());
        this.coroutineContext = Dispatchers.getDefault();
    }

    private static final void _init_$lambda$0(CoroutineWorker coroutineWorker) {
        Intrinsics.checkNotNullParameter((Object)coroutineWorker, (String)"this$0");
        if (coroutineWorker.future.isCancelled()) {
            Job.DefaultImpls.cancel$default((Job)coroutineWorker.job, null, 1, null);
        }
    }

    @Deprecated(message="use withContext(...) inside doWork() instead.")
    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker, Continuation<? super ForegroundInfo> continuation) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract Object doWork(Continuation<? super ListenableWorker.Result> var1);

    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    public Object getForegroundInfo(Continuation<? super ForegroundInfo> continuation) {
        return CoroutineWorker.getForegroundInfo$suspendImpl(this, continuation);
    }

    @Override
    public final ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        Object object = JobKt.Job$default(null, 1, null);
        CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(this.getCoroutineContext().plus((CoroutineContext)object));
        object = new JobListenableFuture((Job)object, null, 2, null);
        BuildersKt.launch$default(coroutineScope, null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>((JobListenableFuture<ForegroundInfo>)object, this, null){
            final JobListenableFuture<ForegroundInfo> $jobFuture;
            Object L$0;
            int label;
            final CoroutineWorker this$0;
            {
                this.$jobFuture = jobListenableFuture;
                this.this$0 = coroutineWorker;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                JobListenableFuture<ForegroundInfo> jobListenableFuture;
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        jobListenableFuture = (JobListenableFuture<ForegroundInfo>)this.L$0;
                        ResultKt.throwOnFailure((Object)object);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        jobListenableFuture = this.$jobFuture;
                        object = this.this$0;
                        Continuation continuation = (Continuation)this;
                        this.L$0 = jobListenableFuture;
                        this.label = 1;
                        object = ((CoroutineWorker)object).getForegroundInfo((Continuation<? super ForegroundInfo>)continuation);
                        if (object != object2) break;
                        return object2;
                    }
                }
                jobListenableFuture.complete((ForegroundInfo)object);
                return Unit.INSTANCE;
            }
        }, 3, null);
        return (ListenableFuture)object;
    }

    public final SettableFuture<ListenableWorker.Result> getFuture$work_runtime_release() {
        return this.future;
    }

    public final CompletableJob getJob$work_runtime_release() {
        return this.job;
    }

    @Override
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    public final Object setForeground(ForegroundInfo object, Continuation<? super Unit> object2) {
        object = this.setForegroundAsync((ForegroundInfo)object);
        Intrinsics.checkNotNullExpressionValue(object, (String)"setForegroundAsync(foregroundInfo)");
        if (object.isDone()) {
            try {
                object.get();
            }
            catch (ExecutionException executionException) {
                object2 = executionException.getCause();
                object = object2;
                if (object2 == null) {
                    object = executionException;
                }
                throw object;
            }
        } else {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(object2), 1);
            cancellableContinuationImpl.initCancellability();
            CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
            object.addListener(new Runnable(cancellableContinuation, object){
                final CancellableContinuation<R> $cancellableContinuation;
                final ListenableFuture<R> $this_await;
                {
                    this.$cancellableContinuation = cancellableContinuation;
                    this.$this_await = listenableFuture;
                }

                public final void run() {
                    try {
                        Continuation continuation = this.$cancellableContinuation;
                        Result.Companion companion = Result.Companion;
                        continuation.resumeWith(Result.constructor-impl((Object)this.$this_await.get()));
                    }
                    catch (Throwable throwable) {
                        Throwable throwable2;
                        Throwable throwable3 = throwable2 = throwable.getCause();
                        if (throwable2 == null) {
                            throwable3 = throwable;
                        }
                        if (throwable instanceof CancellationException) {
                            this.$cancellableContinuation.cancel(throwable3);
                        }
                        throwable2 = this.$cancellableContinuation;
                        Result.Companion companion = Result.Companion;
                        throwable2.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable3)));
                    }
                }
            }, (Executor)DirectExecutor.INSTANCE);
            cancellableContinuation.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(object){
                final ListenableFuture<R> $this_await;
                {
                    this.$this_await = listenableFuture;
                    super(1);
                }

                public final void invoke(Throwable throwable) {
                    this.$this_await.cancel(false);
                }
            }));
            object = cancellableContinuationImpl.getResult();
            if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(object2);
            }
            if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return object;
            }
        }
        return Unit.INSTANCE;
    }

    public final Object setProgress(Data object, Continuation<? super Unit> object2) {
        ListenableFuture<Void> listenableFuture = this.setProgressAsync((Data)object);
        Intrinsics.checkNotNullExpressionValue(listenableFuture, (String)"setProgressAsync(data)");
        if (listenableFuture.isDone()) {
            try {
                listenableFuture.get();
            }
            catch (ExecutionException executionException) {
                object = object2 = executionException.getCause();
                if (object2 == null) {
                    object = executionException;
                }
                throw object;
            }
        } else {
            object = new CancellableContinuationImpl(IntrinsicsKt.intercepted(object2), 1);
            ((CancellableContinuationImpl)object).initCancellability();
            CancellableContinuation cancellableContinuation = (CancellableContinuation)object;
            listenableFuture.addListener(new /* invalid duplicate definition of identical inner class */, (Executor)DirectExecutor.INSTANCE);
            cancellableContinuation.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)new /* invalid duplicate definition of identical inner class */));
            object = ((CancellableContinuationImpl)object).getResult();
            if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended((Continuation)object2);
            }
            if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return object;
            }
        }
        return Unit.INSTANCE;
    }

    @Override
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(this.getCoroutineContext().plus((CoroutineContext)this.job)), null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final CoroutineWorker this$0;
            {
                this.this$0 = coroutineWorker;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Loose catch block
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object object) {
                block11: {
                    void var3_6;
                    Object object2;
                    block10: {
                        Object object3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            default: {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            case 1: {
                                object2 = this;
                                try {
                                    ResultKt.throwOnFailure((Object)object);
                                    object2 = object;
                                    break;
                                }
                                catch (Throwable throwable) {
                                    break block10;
                                }
                            }
                            case 0: {
                                ResultKt.throwOnFailure((Object)object);
                                object2 = this.this$0;
                                Continuation continuation = (Continuation)this;
                                this.label = 1;
                                object2 = ((CoroutineWorker)object2).doWork((Continuation<? super ListenableWorker.Result>)continuation);
                                if (object2 != object3) break;
                                return object3;
                            }
                        }
                        try {
                            object2 = (ListenableWorker.Result)object2;
                            this.this$0.getFuture$work_runtime_release().set((ListenableWorker.Result)object2);
                            break block11;
                        }
                        catch (Throwable throwable) {
                            object2 = this;
                            break block10;
                        }
                        catch (Throwable throwable) {
                            object2 = this;
                        }
                    }
                    object2.this$0.getFuture$work_runtime_release().setException((Throwable)var3_6);
                }
                return Unit.INSTANCE;
            }
        }, 3, null);
        return this.future;
    }
}

