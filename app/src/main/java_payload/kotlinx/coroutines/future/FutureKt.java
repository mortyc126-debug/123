/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines.future;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.future.CompletableFutureCoroutine;
import kotlinx.coroutines.future.ContinuationHandler;
import kotlinx.coroutines.future.FutureKt$$ExternalSyntheticLambda0;
import kotlinx.coroutines.future.FutureKt$$ExternalSyntheticLambda1;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a!\u0010\b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u001a[\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2'\u0010\u0010\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011\u00a2\u0006\u0002\b\u0014\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015\u001a\u0018\u0010\u0016\u001a\u00020\u0004*\u00020\u00052\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2={"asCompletableFuture", "Ljava/util/concurrent/CompletableFuture;", "T", "Lkotlinx/coroutines/Deferred;", "", "Lkotlinx/coroutines/Job;", "asDeferred", "Ljava/util/concurrent/CompletionStage;", "await", "(Ljava/util/concurrent/CompletionStage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "future", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Ljava/util/concurrent/CompletableFuture;", "setupCancellation", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class FutureKt {
    public static /* synthetic */ Object $r8$lambda$cMgNW2d0OUgIe_VSg9ZnIbI9BYk(Function2 function2, Object object, Throwable throwable) {
        return FutureKt.asDeferred$lambda$4(function2, object, throwable);
    }

    public static /* synthetic */ Unit $r8$lambda$fyhs1ohzwEwbEqWUL9pjUeRyd8k(Job job2, Object object, Throwable throwable) {
        return FutureKt.setupCancellation$lambda$2(job2, object, throwable);
    }

    public static final <T> CompletableFuture<T> asCompletableFuture(Deferred<? extends T> deferred) {
        CompletableFuture completableFuture = new CompletableFuture();
        FutureKt.setupCancellation(deferred, completableFuture);
        deferred.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(completableFuture, deferred){
            final CompletableFuture<T> $future;
            final Deferred<T> $this_asCompletableFuture;
            {
                this.$future = completableFuture;
                this.$this_asCompletableFuture = deferred;
                super(1);
            }

            public final void invoke(Throwable throwable) {
                try {
                    this.$future.complete(this.$this_asCompletableFuture.getCompleted());
                }
                catch (Throwable throwable2) {
                    this.$future.completeExceptionally(throwable2);
                }
            }
        }));
        return completableFuture;
    }

    public static final CompletableFuture<Unit> asCompletableFuture(Job job2) {
        CompletableFuture<Unit> completableFuture = new CompletableFuture<Unit>();
        FutureKt.setupCancellation(job2, completableFuture);
        job2.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(completableFuture){
            final CompletableFuture<Unit> $future;
            {
                this.$future = completableFuture;
                super(1);
            }

            public final void invoke(Throwable throwable) {
                if (throwable == null) {
                    this.$future.complete(Unit.INSTANCE);
                } else {
                    this.$future.completeExceptionally(throwable);
                }
            }
        }));
        return completableFuture;
    }

    public static final <T> Deferred<T> asDeferred(CompletionStage<T> object) {
        CompletableFuture<T> completableFuture;
        block4: {
            completableFuture = object.toCompletableFuture();
            if (!completableFuture.isDone()) break block4;
            try {
                object = CompletableDeferredKt.CompletableDeferred(completableFuture.get());
            }
            catch (Throwable throwable) {
                block6: {
                    block5: {
                        object = throwable instanceof ExecutionException ? (ExecutionException)throwable : null;
                        if (object == null) break block5;
                        Throwable throwable2 = ((Throwable)object).getCause();
                        object = throwable2;
                        if (throwable2 != null) break block6;
                    }
                    object = throwable;
                }
                CompletableDeferred completableDeferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                completableDeferred.completeExceptionally((Throwable)object);
                object = completableDeferred;
            }
            return object;
        }
        CompletableDeferred completableDeferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        object.handle(new FutureKt$$ExternalSyntheticLambda0(new Function2<T, Throwable, Object>(completableDeferred){
            final CompletableDeferred<T> $result;
            {
                this.$result = completableDeferred;
                super(2);
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object invoke(T var1_1, Throwable var2_3) {
                block5: {
                    block4: {
                        if (var2_3 != null) ** GOTO lbl5
                        var3_4 = this.$result.complete(var1_1 /* !! */ );
                        ** GOTO lbl17
lbl5:
                        // 1 sources

                        var5_5 = this.$result;
                        var1_1 /* !! */  = var2_3 instanceof CompletionException != false ? (CompletionException)var2_3 : null;
                        if (var1_1 /* !! */  == null) break block4;
                        var4_6 = var1_1 /* !! */ .getCause();
                        var1_1 /* !! */  = var4_6;
                        if (var4_6 != null) break block5;
                    }
                    var1_1 /* !! */  = var2_3;
                }
                try {
                    var3_4 = var5_5.completeExceptionally((Throwable)var1_1 /* !! */ );
lbl17:
                    // 2 sources

                    var1_1 /* !! */  = var3_4;
                }
                catch (Throwable var1_2) {
                    CoroutineExceptionHandlerKt.handleCoroutineException((CoroutineContext)EmptyCoroutineContext.INSTANCE, var1_2);
                    var1_1 /* !! */  = Unit.INSTANCE;
                }
                return var1_1 /* !! */ ;
            }
        }));
        JobKt.cancelFutureOnCompletion(completableDeferred, (Future)completableFuture);
        return completableDeferred;
    }

    private static final Object asDeferred$lambda$4(Function2 function2, Object object, Throwable throwable) {
        return function2.invoke(object, (Object)throwable);
    }

    public static final <T> Object await(CompletionStage<T> object, Continuation<? super T> object2) {
        CompletableFuture<T> completableFuture = object.toCompletableFuture();
        if (completableFuture.isDone()) {
            try {
                object = completableFuture.get();
                return object;
            }
            catch (ExecutionException executionException) {
                object2 = executionException.getCause();
                object = object2;
                if (object2 == null) {
                    object = executionException;
                }
                throw object;
            }
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(object2), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        ContinuationHandler continuationHandler = new ContinuationHandler(cancellableContinuation);
        object.handle(continuationHandler);
        cancellableContinuation.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(completableFuture, continuationHandler){
            final ContinuationHandler<T> $consumer;
            final CompletableFuture<T> $future;
            {
                this.$future = completableFuture;
                this.$consumer = continuationHandler;
                super(1);
            }

            public final void invoke(Throwable throwable) {
                this.$future.cancel(false);
                this.$consumer.cont = null;
            }
        }));
        object = cancellableContinuationImpl.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(object2);
        }
        return object;
    }

    public static final <T> CompletableFuture<T> future(CoroutineScope object, CoroutineContext object2, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        if (coroutineStart.isLazy() ^ true) {
            object2 = CoroutineContextKt.newCoroutineContext((CoroutineScope)object, (CoroutineContext)object2);
            object = new CompletableFuture();
            object2 = new CompletableFutureCoroutine((CoroutineContext)object2, object);
            ((CompletableFuture)object).handle((BiFunction)object2);
            ((AbstractCoroutine)object2).start(coroutineStart, object2, function2);
            return object;
        }
        throw new IllegalArgumentException(((Object)((Object)coroutineStart) + " start is not supported").toString());
    }

    public static /* synthetic */ CompletableFuture future$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int n, Object object) {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return FutureKt.future(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    private static final void setupCancellation(Job job2, CompletableFuture<?> completableFuture) {
        completableFuture.handle((BiFunction)new FutureKt$$ExternalSyntheticLambda1(job2));
    }

    private static final Unit setupCancellation$lambda$2(Job job2, Object object, Throwable throwable) {
        object = null;
        CancellationException cancellationException = null;
        if (throwable != null) {
            if (throwable instanceof CancellationException) {
                cancellationException = (CancellationException)throwable;
            }
            object = cancellationException;
            if (cancellationException == null) {
                object = ExceptionsKt.CancellationException("CompletableFuture was completed exceptionally", throwable);
            }
        }
        job2.cancel((CancellationException)object);
        return Unit.INSTANCE;
    }
}

