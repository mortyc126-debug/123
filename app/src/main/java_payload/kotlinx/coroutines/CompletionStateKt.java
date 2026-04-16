/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u001aI\u0010\b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001a.\u0010\b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2={"recoverResult", "Lkotlin/Result;", "T", "state", "", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class CompletionStateKt {
    public static final <T> Object recoverResult(Object object, Continuation<? super T> companion) {
        if (object instanceof CompletedExceptionally) {
            Object object2 = Result.Companion;
            object2 = ((CompletedExceptionally)object).cause;
            object = object2;
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                object = !(companion instanceof CoroutineStackFrame) ? object2 : StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)object2, (CoroutineStackFrame)companion);
            }
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)object));
        } else {
            companion = Result.Companion;
            object = Result.constructor-impl((Object)object);
        }
        return object;
    }

    public static final <T> Object toState(Object object, Function1<? super Throwable, Unit> function1) {
        Object object2 = Result.exceptionOrNull-impl((Object)object);
        if (object2 == null) {
            object = object2 = object;
            if (function1 != null) {
                object = new CompletedWithCancellation(object2, function1);
            }
        } else {
            object = new CompletedExceptionally((Throwable)object2, false, 2, null);
        }
        return object;
    }

    public static final <T> Object toState(Object object, CancellableContinuation<?> cancellableContinuation) {
        Throwable throwable = Result.exceptionOrNull-impl((Object)object);
        if (throwable != null) {
            object = DebugKt.getRECOVER_STACK_TRACES() && (Continuation)cancellableContinuation instanceof CoroutineStackFrame ? StackTraceRecoveryKt.access$recoverFromStackFrame(throwable, (CoroutineStackFrame)cancellableContinuation) : throwable;
            object = new CompletedExceptionally((Throwable)object, false, 2, null);
        }
        return object;
    }

    public static /* synthetic */ Object toState$default(Object object, Function1 function1, int n, Object object2) {
        if ((n & 1) != 0) {
            function1 = null;
        }
        return CompletionStateKt.toState(object, (Function1<? super Throwable, Unit>)function1);
    }
}

