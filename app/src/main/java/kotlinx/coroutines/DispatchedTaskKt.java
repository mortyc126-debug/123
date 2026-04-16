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
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a.\u0010\u0011\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0015\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000fH\u0002\u001a\u0019\u0010\u0016\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\b\u001a'\u0010\u0019\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00018\u0000X\u0081T\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u0018\u0010\b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\n\"\u0018\u0010\u000b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\n\u00a8\u0006\u001e"}, d2={"MODE_ATOMIC", "", "MODE_CANCELLABLE", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE_REUSABLE", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "isCancellableMode", "", "(I)Z", "isReusableMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "undispatched", "resumeUnconfined", "resumeWithStackTrace", "exception", "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class DispatchedTaskKt {
    public static final int MODE_ATOMIC = 0;
    public static final int MODE_CANCELLABLE = 1;
    public static final int MODE_CANCELLABLE_REUSABLE = 2;
    public static final int MODE_UNDISPATCHED = 4;
    public static final int MODE_UNINITIALIZED = -1;

    public static final <T> void dispatch(DispatchedTask<? super T> dispatchedTask, int n) {
        boolean bl;
        boolean bl2 = DebugKt.getASSERTIONS_ENABLED();
        boolean bl3 = true;
        if (bl2 && !(bl = n != -1)) {
            throw new AssertionError();
        }
        CoroutineContext coroutineContext = dispatchedTask.getDelegate$kotlinx_coroutines_core();
        if (n != 4) {
            bl3 = false;
        }
        if (!bl3 && coroutineContext instanceof DispatchedContinuation && DispatchedTaskKt.isCancellableMode(n) == DispatchedTaskKt.isCancellableMode(dispatchedTask.resumeMode)) {
            CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation)coroutineContext).dispatcher;
            if (coroutineDispatcher.isDispatchNeeded(coroutineContext = coroutineContext.getContext())) {
                coroutineDispatcher.dispatch(coroutineContext, dispatchedTask);
            } else {
                DispatchedTaskKt.resumeUnconfined(dispatchedTask);
            }
        } else {
            DispatchedTaskKt.resume(dispatchedTask, coroutineContext, bl3);
        }
    }

    public static /* synthetic */ void getMODE_CANCELLABLE$annotations() {
    }

    public static final boolean isCancellableMode(int n) {
        boolean bl;
        boolean bl2 = bl = true;
        if (n != 1) {
            bl2 = n == 2 ? bl : false;
        }
        return bl2;
    }

    public static final boolean isReusableMode(int n) {
        boolean bl = n == 2;
        return bl;
    }

    public static final <T> void resume(DispatchedTask<? super T> object, Continuation<? super T> coroutineContext, boolean bl) {
        Object object2 = object.takeState$kotlinx_coroutines_core();
        Object object3 = object.getExceptionalResult$kotlinx_coroutines_core(object2);
        Object object4 = Result.Companion;
        object = object3 != null ? ResultKt.createFailure((Throwable)object3) : object.getSuccessfulResult$kotlinx_coroutines_core(object2);
        object3 = Result.constructor-impl((Object)object);
        if (bl) {
            Intrinsics.checkNotNull(coroutineContext, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            object2 = (DispatchedContinuation)coroutineContext;
            object = ((DispatchedContinuation)object2).continuation;
            object4 = ((DispatchedContinuation)object2).countOrElement;
            coroutineContext = object.getContext();
            object4 = ThreadContextKt.updateThreadContext(coroutineContext, object4);
            object = object4 != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(object, coroutineContext, object4) : null;
            try {
                ((DispatchedContinuation)object2).continuation.resumeWith(object3);
                object3 = Unit.INSTANCE;
            }
            finally {
                if (object == null || object.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(coroutineContext, object4);
                }
            }
        } else {
            coroutineContext.resumeWith(object3);
        }
    }

    private static final void resumeUnconfined(DispatchedTask<?> dispatchedTask) {
        EventLoop eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop.isUnconfinedLoopActive()) {
            eventLoop.dispatchUnconfined(dispatchedTask);
        } else {
            eventLoop.incrementUseCount(true);
            try {
                boolean bl;
                DispatchedTaskKt.resume(dispatchedTask, dispatchedTask.getDelegate$kotlinx_coroutines_core(), true);
                while (bl = eventLoop.processUnconfinedEvent()) {
                }
            }
            catch (Throwable throwable) {
                dispatchedTask.handleFatalException(throwable, null);
            }
        }
        return;
        {
            finally {
                eventLoop.decrementUseCount(true);
            }
        }
    }

    public static final void resumeWithStackTrace(Continuation<?> continuation, Throwable throwable) {
        Result.Companion companion = Result.Companion;
        if (DebugKt.getRECOVER_STACK_TRACES() && continuation instanceof CoroutineStackFrame) {
            throwable = StackTraceRecoveryKt.access$recoverFromStackFrame(throwable, (CoroutineStackFrame)continuation);
        }
        continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable)));
    }

    public static final void runUnconfinedEventLoop(DispatchedTask<?> dispatchedTask, EventLoop eventLoop, Function0<Unit> function0) {
        eventLoop.incrementUseCount(true);
        try {
            boolean bl;
            function0.invoke();
            while (bl = eventLoop.processUnconfinedEvent()) {
            }
        }
        catch (Throwable throwable) {
            dispatchedTask.handleFatalException(throwable, null);
        }
        InlineMarker.finallyStart((int)1);
        eventLoop.decrementUseCount(true);
        InlineMarker.finallyEnd((int)1);
        return;
        {
            finally {
                InlineMarker.finallyStart((int)1);
            }
        }
    }
}

