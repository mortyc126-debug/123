/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a#\u0010\u0006\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0082\b\u001a\u001e\u0010\t\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00032\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0000\u001a>\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u000b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u001ay\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u000b*\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00102\u0006\u0010\u0011\u001a\u0002H\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00032%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2={"dispatcherFailure", "", "completion", "Lkotlin/coroutines/Continuation;", "e", "", "runSafely", "block", "Lkotlin/Function0;", "startCoroutineCancellable", "fatalCompletion", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "onCancellation", "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class CancellableKt {
    private static final void dispatcherFailure(Continuation<?> continuation, Throwable throwable) {
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable)));
        throw throwable;
    }

    private static final void runSafely(Continuation<?> continuation, Function0<Unit> function0) {
        try {
            function0.invoke();
        }
        catch (Throwable throwable) {
            CancellableKt.dispatcherFailure(continuation, throwable);
        }
    }

    public static final void startCoroutineCancellable(Continuation<? super Unit> companion, Continuation<?> continuation) {
        try {
            Continuation continuation2 = IntrinsicsKt.intercepted(companion);
            companion = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith$default(continuation2, Result.constructor-impl((Object)Unit.INSTANCE), null, 2, null);
        }
        catch (Throwable throwable) {
            CancellableKt.dispatcherFailure(continuation, throwable);
        }
    }

    public static final <T> void startCoroutineCancellable(Function1<? super Continuation<? super T>, ? extends Object> companion, Continuation<? super T> continuation) {
        try {
            Continuation continuation2 = IntrinsicsKt.intercepted((Continuation)IntrinsicsKt.createCoroutineUnintercepted(companion, continuation));
            companion = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith$default(continuation2, Result.constructor-impl((Object)Unit.INSTANCE), null, 2, null);
        }
        catch (Throwable throwable) {
            CancellableKt.dispatcherFailure(continuation, throwable);
        }
    }

    public static final <R, T> void startCoroutineCancellable(Function2<? super R, ? super Continuation<? super T>, ? extends Object> companion, R object, Continuation<? super T> continuation, Function1<? super Throwable, Unit> function1) {
        try {
            object = IntrinsicsKt.intercepted((Continuation)IntrinsicsKt.createCoroutineUnintercepted(companion, object, continuation));
            companion = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith(object, Result.constructor-impl((Object)Unit.INSTANCE), function1);
        }
        catch (Throwable throwable) {
            CancellableKt.dispatcherFailure(continuation, throwable);
        }
    }

    public static /* synthetic */ void startCoroutineCancellable$default(Function2 function2, Object object, Continuation continuation, Function1 function1, int n, Object object2) {
        if ((n & 4) != 0) {
            function1 = null;
        }
        CancellableKt.startCoroutineCancellable(function2, object, continuation, (Function1<? super Throwable, Unit>)function1);
    }
}

