/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.ListenableFuture
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work;

import androidx.work.DirectExecutor;
import androidx.work.Operation;
import androidx.work.OperationKt;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0004"}, d2={"await", "Landroidx/work/Operation$State$SUCCESS;", "Landroidx/work/Operation;", "(Landroidx/work/Operation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class OperationKt {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final Object await(Operation var0, Continuation<? super Operation.State.SUCCESS> var1_1) {
        if (!(var1_1 /* !! */  instanceof await.1)) ** GOTO lbl-1000
        var2_2 = var1_1 /* !! */ ;
        if ((var2_2.label & -2147483648) != 0) {
            var2_2.label += -2147483648;
            var1_1 /* !! */  = var2_2;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 /* !! */  = new ContinuationImpl(var1_1 /* !! */ ){
                Object L$0;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return OperationKt.await(null, (Continuation<? super Operation.State.SUCCESS>)((Continuation)this));
                }
            };
        }
        var2_2 = var1_1 /* !! */ .result;
        var3_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var1_1 /* !! */ .label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var0 = (ListenableFuture)var1_1 /* !! */ .L$0;
                ResultKt.throwOnFailure((Object)var2_2);
                var0 = var2_2;
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var2_2);
                var0 = var0.getResult();
                Intrinsics.checkNotNullExpressionValue(var0, (String)"result");
                if (var0.isDone()) {
                    try {
                        var0 = var0.get();
                        break;
                    }
                    catch (ExecutionException var2_3) {
                        var1_1 /* !! */  = var2_3.getCause();
                        var0 = var1_1 /* !! */ ;
                        if (var1_1 /* !! */  == null) {
                            var0 = var2_3;
                        }
                        throw var0;
                    }
                }
                var1_1 /* !! */ .L$0 = var0;
                var1_1 /* !! */ .label = 1;
                var2_2 = new CancellableContinuationImpl<T>(IntrinsicsKt.intercepted(var1_1 /* !! */ ), 1);
                var2_2.initCancellability();
                var4_5 = (CancellableContinuation)var2_2;
                var0.addListener(new Runnable(var4_5, var0){
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
                var4_5.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(var0){
                    final ListenableFuture<R> $this_await;
                    {
                        this.$this_await = listenableFuture;
                        super(1);
                    }

                    public final void invoke(Throwable throwable) {
                        this.$this_await.cancel(false);
                    }
                }));
                var0 = var2_2.getResult();
                if (var0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(var1_1 /* !! */ );
                }
                if (var0 != var3_4) break;
                return var3_4;
            }
        }
        Intrinsics.checkNotNullExpressionValue(var0, (String)"result.await()");
        return var0;
    }

    private static final Object await$$forInline(Operation object, Continuation<? super Operation.State.SUCCESS> continuation) {
        object = object.getResult();
        Intrinsics.checkNotNullExpressionValue(object, (String)"result");
        ListenableFuture<Operation.State.SUCCESS> listenableFuture = object;
        if (listenableFuture.isDone()) {
            try {
                object = listenableFuture.get();
            }
            catch (ExecutionException executionException) {
                object = executionException.getCause();
                if (object == null) {
                    object = executionException;
                }
                throw object;
            }
        } else {
            InlineMarker.mark((int)0);
            object = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            ((CancellableContinuationImpl)object).initCancellability();
            CancellableContinuation cancellableContinuation = (CancellableContinuation)object;
            listenableFuture.addListener(new /* invalid duplicate definition of identical inner class */, (Executor)DirectExecutor.INSTANCE);
            cancellableContinuation.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)new /* invalid duplicate definition of identical inner class */));
            cancellableContinuation = Unit.INSTANCE;
            object = ((CancellableContinuationImpl)object).getResult();
            if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            InlineMarker.mark((int)1);
        }
        Intrinsics.checkNotNullExpressionValue(object, (String)"result.await()");
        return object;
    }
}

