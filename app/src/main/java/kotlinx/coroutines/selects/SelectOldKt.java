/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl;

@Metadata(d1={"\u0000&\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\u001a8\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u001f\b\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0081H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u001a8\u0010\b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u001f\b\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0081H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u001a%\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u0002H\nH\u0002\u00a2\u0006\u0002\u0010\r\u001a\u0018\u0010\u000e\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2={"selectOld", "R", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUnbiasedOld", "resumeUndispatched", "T", "Lkotlinx/coroutines/CancellableContinuation;", "result", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "exception", "", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class SelectOldKt {
    public static final /* synthetic */ void access$resumeUndispatched(CancellableContinuation cancellableContinuation, Object object) {
        SelectOldKt.resumeUndispatched(cancellableContinuation, object);
    }

    public static final /* synthetic */ void access$resumeUndispatchedWithException(CancellableContinuation cancellableContinuation, Throwable throwable) {
        SelectOldKt.resumeUndispatchedWithException(cancellableContinuation, throwable);
    }

    private static final <T> void resumeUndispatched(CancellableContinuation<? super T> companion, T t) {
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher)companion.getContext().get((CoroutineContext.Key)CoroutineDispatcher.Key);
        if (coroutineDispatcher != null) {
            companion.resumeUndispatched(coroutineDispatcher, t);
        } else {
            coroutineDispatcher = (Continuation)companion;
            companion = Result.Companion;
            coroutineDispatcher.resumeWith(Result.constructor-impl(t));
        }
    }

    private static final void resumeUndispatchedWithException(CancellableContinuation<?> continuation, Throwable throwable) {
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher)continuation.getContext().get((CoroutineContext.Key)CoroutineDispatcher.Key);
        if (coroutineDispatcher != null) {
            continuation.resumeUndispatchedWithException(coroutineDispatcher, throwable);
        } else {
            continuation = continuation;
            coroutineDispatcher = Result.Companion;
            continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable)));
        }
    }

    public static final <R> Object selectOld(Function1<? super SelectBuilder<? super R>, Unit> object, Continuation<? super R> continuation) {
        SelectBuilderImpl<R> selectBuilderImpl = new SelectBuilderImpl<R>(continuation);
        try {
            object.invoke(selectBuilderImpl);
        }
        catch (Throwable throwable) {
            selectBuilderImpl.handleBuilderException(throwable);
        }
        object = selectBuilderImpl.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return object;
    }

    private static final <R> Object selectOld$$forInline(Function1<? super SelectBuilder<? super R>, Unit> object, Continuation<? super R> continuation) {
        InlineMarker.mark((int)0);
        SelectBuilderImpl<R> selectBuilderImpl = new SelectBuilderImpl<R>(continuation);
        try {
            object.invoke(selectBuilderImpl);
        }
        catch (Throwable throwable) {
            selectBuilderImpl.handleBuilderException(throwable);
        }
        object = selectBuilderImpl.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark((int)1);
        return object;
    }

    public static final <R> Object selectUnbiasedOld(Function1<? super SelectBuilder<? super R>, Unit> object, Continuation<? super R> continuation) {
        UnbiasedSelectBuilderImpl<R> unbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl<R>(continuation);
        try {
            object.invoke(unbiasedSelectBuilderImpl);
        }
        catch (Throwable throwable) {
            unbiasedSelectBuilderImpl.handleBuilderException(throwable);
        }
        object = unbiasedSelectBuilderImpl.initSelectResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return object;
    }

    private static final <R> Object selectUnbiasedOld$$forInline(Function1<? super SelectBuilder<? super R>, Unit> object, Continuation<? super R> continuation) {
        InlineMarker.mark((int)0);
        UnbiasedSelectBuilderImpl<R> unbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl<R>(continuation);
        try {
            object.invoke(unbiasedSelectBuilderImpl);
        }
        catch (Throwable throwable) {
            unbiasedSelectBuilderImpl.handleBuilderException(throwable);
        }
        object = unbiasedSelectBuilderImpl.initSelectResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark((int)1);
        return object;
    }
}

