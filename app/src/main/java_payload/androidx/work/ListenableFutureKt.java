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
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 */
package androidx.work;

import androidx.work.DirectExecutor;
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
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1={"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0087H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0004"}, d2={"await", "R", "Lcom/google/common/util/concurrent/ListenableFuture;", "(Lcom/google/common/util/concurrent/ListenableFuture;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class ListenableFutureKt {
    public static final <R> Object await(ListenableFuture<R> object, Continuation<? super R> object2) {
        if (object.isDone()) {
            try {
                object = object.get();
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
        return object;
    }

    private static final <R> Object await$$forInline(ListenableFuture<R> object, Continuation<? super R> continuation) {
        if (object.isDone()) {
            try {
                object = object.get();
                return object;
            }
            catch (ExecutionException executionException) {
                object = executionException.getCause();
                if (object == null) {
                    object = executionException;
                }
                throw object;
            }
        }
        InlineMarker.mark((int)0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        object.addListener(new /* invalid duplicate definition of identical inner class */, (Executor)DirectExecutor.INSTANCE);
        cancellableContinuation.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)new /* invalid duplicate definition of identical inner class */));
        object = Unit.INSTANCE;
        object = cancellableContinuationImpl.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark((int)1);
        return object;
    }
}

