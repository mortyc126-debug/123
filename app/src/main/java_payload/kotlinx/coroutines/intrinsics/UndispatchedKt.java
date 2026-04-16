/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0082\b\u001a>\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u001aR\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010\f\u001a\u0002H\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u001a>\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u001aY\u0010\u000f\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\f\u001a\u0002H\n2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b\u00a2\u0006\u0002\b\u0011H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u001aY\u0010\u0013\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\f\u001a\u0002H\n2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b\u00a2\u0006\u0002\b\u0011H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u001a?\u0010\u0014\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00062\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2={"startDirect", "", "T", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class UndispatchedKt {
    /*
     * Loose catch block
     */
    public static final <T> void startCoroutineUndispatched(Function1<? super Continuation<? super T>, ? extends Object> object, Continuation<? super T> coroutineContext) {
        block7: {
            Continuation continuation = DebugProbesKt.probeCoroutineCreated(coroutineContext);
            coroutineContext = coroutineContext.getContext();
            Object object2 = ThreadContextKt.updateThreadContext(coroutineContext, null);
            object = ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)object, (int)1)).invoke((Object)continuation);
            ThreadContextKt.restoreThreadContext(coroutineContext, object2);
            if (object != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                coroutineContext = Result.Companion;
                continuation.resumeWith(Result.constructor-impl((Object)object));
            }
            break block7;
            catch (Throwable throwable) {
                try {
                    ThreadContextKt.restoreThreadContext(coroutineContext, object2);
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    object = Result.Companion;
                    continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable2)));
                }
            }
        }
    }

    /*
     * Loose catch block
     */
    public static final <R, T> void startCoroutineUndispatched(Function2<? super R, ? super Continuation<? super T>, ? extends Object> object, R object2, Continuation<? super T> object3) {
        block7: {
            Continuation continuation = DebugProbesKt.probeCoroutineCreated(object3);
            CoroutineContext coroutineContext = object3.getContext();
            object3 = ThreadContextKt.updateThreadContext(coroutineContext, null);
            object = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)object, (int)2)).invoke(object2, (Object)continuation);
            ThreadContextKt.restoreThreadContext(coroutineContext, object3);
            if (object != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                object2 = Result.Companion;
                continuation.resumeWith(Result.constructor-impl((Object)object));
            }
            break block7;
            catch (Throwable throwable) {
                try {
                    ThreadContextKt.restoreThreadContext(coroutineContext, object3);
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    object = Result.Companion;
                    continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable2)));
                }
            }
        }
    }

    public static final <T> void startCoroutineUnintercepted(Function1<? super Continuation<? super T>, ? extends Object> companion, Continuation<? super T> continuation) {
        Object object;
        continuation = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            object = ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(companion, (int)1)).invoke((Object)continuation);
        }
        catch (Throwable throwable) {
            companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable)));
        }
        if (object != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl((Object)object));
        }
    }

    private static final <T> void startDirect(Continuation<? super T> continuation, Function1<? super Continuation<? super T>, ? extends Object> object) {
        continuation = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            object = object.invoke((Object)continuation);
        }
        catch (Throwable throwable) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable)));
            return;
        }
        if (object != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl(object));
        }
    }

    public static final <T, R> Object startUndispatchedOrReturn(ScopeCoroutine<? super T> object, R object2, Function2<? super R, ? super Continuation<? super T>, ? extends Object> object3) {
        try {
            object2 = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(object3, (int)2)).invoke(object2, (Object)((Continuation)object));
        }
        catch (Throwable throwable) {
            object2 = new CompletedExceptionally(throwable, false, 2, null);
        }
        if (object2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        } else if ((object2 = ((JobSupport)object).makeCompletingOnce$kotlinx_coroutines_core(object2)) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        } else {
            if (object2 instanceof CompletedExceptionally) {
                object3 = ((CompletedExceptionally)object2).cause;
                object2 = ((CompletedExceptionally)object2).cause;
                object3 = ((ScopeCoroutine)object).uCont;
                object = object2;
                if (DebugKt.getRECOVER_STACK_TRACES()) {
                    object = !(object3 instanceof CoroutineStackFrame) ? object2 : StackTraceRecoveryKt.access$recoverFromStackFrame(object2, (CoroutineStackFrame)object3);
                }
                throw object;
            }
            object = JobSupportKt.unboxState(object2);
        }
        return object;
    }

    public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(ScopeCoroutine<? super T> object, R object2, Function2<? super R, ? super Continuation<? super T>, ? extends Object> object3) {
        boolean bl = false;
        try {
            object2 = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(object3, (int)2)).invoke(object2, (Object)((Continuation)object));
        }
        catch (Throwable throwable) {
            object2 = new CompletedExceptionally(throwable, false, 2, null);
        }
        if (object2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        } else {
            Object object4 = ((JobSupport)object).makeCompletingOnce$kotlinx_coroutines_core(object2);
            if (object4 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            } else if (object4 instanceof CompletedExceptionally) {
                object3 = ((CompletedExceptionally)object4).cause;
                if (!(object3 instanceof TimeoutCancellationException) || ((TimeoutCancellationException)object3).coroutine != object) {
                    bl = true;
                }
                if (bl) {
                    object2 = ((CompletedExceptionally)object4).cause;
                    object3 = ((ScopeCoroutine)object).uCont;
                    object = object2;
                    if (DebugKt.getRECOVER_STACK_TRACES()) {
                        object = !(object3 instanceof CoroutineStackFrame) ? object2 : StackTraceRecoveryKt.access$recoverFromStackFrame(object2, (CoroutineStackFrame)object3);
                    }
                    throw object;
                }
                if (object2 instanceof CompletedExceptionally) {
                    object2 = ((CompletedExceptionally)object2).cause;
                    object3 = ((ScopeCoroutine)object).uCont;
                    object = object2;
                    if (DebugKt.getRECOVER_STACK_TRACES()) {
                        object = !(object3 instanceof CoroutineStackFrame) ? object2 : StackTraceRecoveryKt.access$recoverFromStackFrame(object2, (CoroutineStackFrame)object3);
                    }
                    throw object;
                }
                object = object2;
            } else {
                object = JobSupportKt.unboxState(object4);
            }
        }
        return object;
    }

    private static final <T> Object undispatchedResult(ScopeCoroutine<? super T> object, Function1<? super Throwable, Boolean> object2, Function0<? extends Object> object3) {
        try {
            object3 = object3.invoke();
        }
        catch (Throwable throwable) {
            object3 = new CompletedExceptionally(throwable, false, 2, null);
        }
        if (object3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object object4 = object.makeCompletingOnce$kotlinx_coroutines_core(object3);
        if (object4 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (object4 instanceof CompletedExceptionally) {
            if (((Boolean)object2.invoke((Object)((CompletedExceptionally)object4).cause)).booleanValue()) {
                object2 = ((CompletedExceptionally)object4).cause;
                object3 = object.uCont;
                object = object2;
                if (DebugKt.getRECOVER_STACK_TRACES()) {
                    object = !(object3 instanceof CoroutineStackFrame) ? object2 : StackTraceRecoveryKt.access$recoverFromStackFrame(object2, (CoroutineStackFrame)object3);
                }
                throw object;
            }
            if (object3 instanceof CompletedExceptionally) {
                object2 = ((CompletedExceptionally)object3).cause;
                object3 = object.uCont;
                object = object2;
                if (DebugKt.getRECOVER_STACK_TRACES()) {
                    object = !(object3 instanceof CoroutineStackFrame) ? object2 : StackTraceRecoveryKt.access$recoverFromStackFrame(object2, (CoroutineStackFrame)object3);
                }
                throw object;
            }
        } else {
            object3 = JobSupportKt.unboxState(object4);
        }
        return object3;
    }
}

