/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Active;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancelledContinuation;
import kotlinx.coroutines.ChildContinuation;
import kotlinx.coroutines.CompletedContinuation;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.DispatchedTaskKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InvokeOnCancel;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u00052\u00020\u0006B\u001b\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103J;\u0010.\u001a\u00020/2'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u000103\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/04j\u0002`72\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0017\u00108\u001a\u00020/2\f\u00109\u001a\b\u0012\u0004\u0012\u00020/0:H\u0082\bJ1\u0010;\u001a\u00020/2!\u0010<\u001a\u001d\u0012\u0013\u0012\u001103\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/042\u0006\u00102\u001a\u000203J\u001e\u0010=\u001a\u00020/2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030?2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0012\u0010@\u001a\u00020\u001d2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001f\u0010A\u001a\u00020/2\b\u0010B\u001a\u0004\u0018\u00010\u00122\u0006\u00102\u001a\u000203H\u0010\u00a2\u0006\u0002\bCJ\u0010\u0010D\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0002J\u0010\u0010E\u001a\u00020/2\u0006\u0010F\u001a\u00020\u0012H\u0016J\r\u0010G\u001a\u00020/H\u0000\u00a2\u0006\u0002\bHJ\b\u0010I\u001a\u00020/H\u0002J\u0010\u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020\nH\u0002J\u0010\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020NH\u0016J\u0019\u0010O\u001a\u0004\u0018\u0001032\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0010\u00a2\u0006\u0002\bPJ\n\u0010Q\u001a\u0004\u0018\u00010\u0012H\u0001J\u0010\u0010R\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`TH\u0016J\u001f\u0010U\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0010\u00a2\u0006\u0004\bV\u0010WJ\b\u0010X\u001a\u00020/H\u0016J\n\u0010Y\u001a\u0004\u0018\u00010\u0010H\u0002J1\u0010Z\u001a\u00020/2'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u000103\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/04j\u0002`7H\u0016J\u001c\u0010Z\u001a\u00020/2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030?2\u0006\u0010[\u001a\u00020\nH\u0016J\u0010\u0010\\\u001a\u00020/2\u0006\u00100\u001a\u00020\u0012H\u0002J\b\u0010]\u001a\u00020\u001dH\u0002J1\u0010^\u001a\u0002012'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u000103\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/04j\u0002`7H\u0002J\u001a\u0010_\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010`\u001a\u00020(H\u0014J\u0015\u0010a\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0000\u00a2\u0006\u0002\bbJ\r\u0010c\u001a\u00020/H\u0000\u00a2\u0006\u0002\bdJ\b\u0010e\u001a\u00020\u001dH\u0001J:\u0010f\u001a\u00020/2\u0006\u0010g\u001a\u00028\u00002#\u0010<\u001a\u001f\u0012\u0013\u0012\u001103\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u000104H\u0016\u00a2\u0006\u0002\u0010hJA\u0010i\u001a\u00020/2\b\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2%\b\u0002\u0010<\u001a\u001f\u0012\u0013\u0012\u001103\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u000104H\u0002J\u001e\u0010j\u001a\u00020/2\f\u0010k\u001a\b\u0012\u0004\u0012\u00028\u00000lH\u0016\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010mJS\u0010n\u001a\u0004\u0018\u00010\u00122\u0006\u0010$\u001a\u00020o2\b\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2#\u0010<\u001a\u001f\u0012\u0013\u0012\u001103\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u0001042\b\u0010p\u001a\u0004\u0018\u00010\u0012H\u0002J\u000f\u0010q\u001a\u0004\u0018\u00010\u0012H\u0010\u00a2\u0006\u0002\brJ\b\u0010s\u001a\u00020(H\u0016J\b\u0010t\u001a\u00020\u001dH\u0002J!\u0010t\u001a\u0004\u0018\u00010\u00122\u0006\u0010g\u001a\u00028\u00002\b\u0010p\u001a\u0004\u0018\u00010\u0012H\u0016\u00a2\u0006\u0002\u0010uJF\u0010t\u001a\u0004\u0018\u00010\u00122\u0006\u0010g\u001a\u00028\u00002\b\u0010p\u001a\u0004\u0018\u00010\u00122#\u0010<\u001a\u001f\u0012\u0013\u0012\u001103\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u000104H\u0016\u00a2\u0006\u0002\u0010vJC\u0010w\u001a\u0004\u0018\u00010x2\b\u0010-\u001a\u0004\u0018\u00010\u00122\b\u0010p\u001a\u0004\u0018\u00010\u00122#\u0010<\u001a\u001f\u0012\u0013\u0012\u001103\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u000104H\u0002J\u0012\u0010y\u001a\u0004\u0018\u00010\u00122\u0006\u0010z\u001a\u000203H\u0016J\b\u0010{\u001a\u00020\u001dH\u0002J\u0019\u0010|\u001a\u00020/*\u00020}2\u0006\u0010g\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010~J\u0014\u0010\u007f\u001a\u00020/*\u00020}2\u0006\u0010z\u001a\u000203H\u0016R\t\u0010\f\u001a\u00020\rX\u0082\u0004R\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004R\u0011\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000fX\u0082\u0004R\u001c\u0010\u0013\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010\u00128@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0080\u0001"}, d2={"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/Waiter;", "delegate", "Lkotlin/coroutines/Continuation;", "resumeMode", "", "(Lkotlin/coroutines/Continuation;I)V", "_decisionAndIndex", "Lkotlinx/atomicfu/AtomicInt;", "_parentHandle", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/DisposableHandle;", "_state", "", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "", "()Z", "isCancelled", "isCompleted", "parentHandle", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "stateDebugRepresentation", "", "getStateDebugRepresentation", "()Ljava/lang/String;", "alreadyResumedError", "", "proposedUpdate", "callCancelHandler", "", "handler", "Lkotlinx/coroutines/CancelHandler;", "cause", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "callCancelHandlerSafely", "block", "Lkotlin/Function0;", "callOnCancellation", "onCancellation", "callSegmentOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "cancel", "cancelCompletedResult", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "cancelLater", "completeResume", "token", "detachChild", "detachChild$kotlinx_coroutines_core", "detachChildIfNonResuable", "dispatchResume", "mode", "getContinuationCancellationCause", "parent", "Lkotlinx/coroutines/Job;", "getExceptionalResult", "getExceptionalResult$kotlinx_coroutines_core", "getResult", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "initCancellability", "installParentHandle", "invokeOnCancellation", "index", "invokeOnCancellationImpl", "isReusable", "makeCancelHandler", "multipleHandlersError", "nameString", "parentCancelled", "parentCancelled$kotlinx_coroutines_core", "releaseClaimedReusableContinuation", "releaseClaimedReusableContinuation$kotlinx_coroutines_core", "resetStateReusable", "resume", "value", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeImpl", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "resumedState", "Lkotlinx/coroutines/NotCompleted;", "idempotent", "takeState", "takeState$kotlinx_coroutines_core", "toString", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tryResumeImpl", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeWithException", "exception", "trySuspend", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public class CancellableContinuationImpl<T>
extends DispatchedTask<T>
implements CancellableContinuation<T>,
CoroutineStackFrame,
Waiter {
    private static final AtomicIntegerFieldUpdater _decisionAndIndex$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decisionAndIndex");
    private static final AtomicReferenceFieldUpdater _parentHandle$FU;
    private static final AtomicReferenceFieldUpdater _state$FU;
    @Volatile
    private volatile int _decisionAndIndex;
    @Volatile
    private volatile Object _parentHandle;
    @Volatile
    private volatile Object _state;
    private final CoroutineContext context;
    private final Continuation<T> delegate;

    static {
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
        _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_parentHandle");
    }

    public CancellableContinuationImpl(Continuation<? super T> continuation, int n) {
        super(n);
        this.delegate = continuation;
        if (DebugKt.getASSERTIONS_ENABLED() && (n = n != -1 ? 1 : 0) == 0) {
            throw new AssertionError();
        }
        this.context = this.delegate.getContext();
        this._decisionAndIndex = (0 << 29) + 0x1FFFFFFF;
        this._state = Active.INSTANCE;
    }

    private final Void alreadyResumedError(Object object) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + object).toString());
    }

    private final void callCancelHandler(Function1<? super Throwable, Unit> function1, Throwable throwable) {
        try {
            function1.invoke((Object)throwable);
        }
        catch (Throwable throwable2) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, throwable2));
        }
    }

    private final void callCancelHandlerSafely(Function0<Unit> function0) {
        try {
            function0.invoke();
        }
        catch (Throwable throwable) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, throwable));
        }
    }

    private final void callSegmentOnCancellation(Segment<?> segment, Throwable throwable) {
        int n = _decisionAndIndex$FU.get(this) & 0x1FFFFFFF;
        boolean bl = n != 0x1FFFFFFF;
        if (bl) {
            try {
                segment.onCancellation(n, throwable, this.getContext());
            }
            catch (Throwable throwable2) {
                CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, throwable2));
            }
            return;
        }
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
    }

    private final boolean cancelLater(Throwable throwable) {
        if (!this.isReusable()) {
            return false;
        }
        Continuation<T> continuation = this.delegate;
        Intrinsics.checkNotNull(continuation, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((DispatchedContinuation)continuation).postponeCancellation(throwable);
    }

    private final void detachChildIfNonResuable() {
        if (!this.isReusable()) {
            this.detachChild$kotlinx_coroutines_core();
        }
    }

    private final void dispatchResume(int n) {
        if (this.tryResume()) {
            return;
        }
        DispatchedTaskKt.dispatch(this, n);
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle)_parentHandle$FU.get(this);
    }

    private final String getStateDebugRepresentation() {
        Object object = this.getState$kotlinx_coroutines_core();
        object = object instanceof NotCompleted ? "Active" : (object instanceof CancelledContinuation ? "Cancelled" : "Completed");
        return object;
    }

    private final DisposableHandle installParentHandle() {
        Object object = (Job)this.getContext().get((CoroutineContext.Key)Job.Key);
        if (object == null) {
            return null;
        }
        object = Job.DefaultImpls.invokeOnCompletion$default((Job)object, true, false, new ChildContinuation(this), 2, null);
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_parentHandle$FU, this, null, object);
        return object;
    }

    private final void invokeOnCancellationImpl(Object object) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = object instanceof CancelHandler || object instanceof Segment;
            if (!bl) {
                throw new AssertionError();
            }
        }
        Object object2 = _state$FU;
        while (true) {
            Object object3;
            Object object4;
            if ((object4 = ((AtomicReferenceFieldUpdater)object2).get(this)) instanceof Active) {
                if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, object4, object)) continue;
                return;
            }
            boolean bl = object4 instanceof CancelHandler ? true : object4 instanceof Segment;
            if (bl) {
                this.multipleHandlersError(object, object4);
                continue;
            }
            if (object4 instanceof CompletedExceptionally) {
                if (!((CompletedExceptionally)object4).makeHandled()) {
                    this.multipleHandlersError(object, object4);
                }
                if (object4 instanceof CancelledContinuation) {
                    bl = object4 instanceof CompletedExceptionally;
                    object2 = null;
                    object4 = bl ? (CompletedExceptionally)object4 : null;
                    if (object4 != null) {
                        object2 = ((CompletedExceptionally)object4).cause;
                    }
                    if (object instanceof CancelHandler) {
                        this.callCancelHandler((CancelHandler)object, (Throwable)object2);
                    } else {
                        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        this.callSegmentOnCancellation((Segment)object, (Throwable)object2);
                    }
                }
                return;
            }
            if (object4 instanceof CompletedContinuation) {
                if (((CompletedContinuation)object4).cancelHandler != null) {
                    this.multipleHandlersError(object, object4);
                }
                if (object instanceof Segment) {
                    return;
                }
                Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                object3 = (CancelHandler)object;
                if (((CompletedContinuation)object4).getCancelled()) {
                    this.callCancelHandler((CancelHandler)object, ((CompletedContinuation)object4).cancelCause);
                    return;
                }
                object3 = CompletedContinuation.copy$default((CompletedContinuation)object4, null, (CancelHandler)object, null, null, null, 29, null);
                if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, object4, object3)) continue;
                return;
            }
            if (object instanceof Segment) {
                return;
            }
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
            object3 = (CancelHandler)object;
            object3 = new CompletedContinuation(object4, (CancelHandler)object, null, null, null, 28, null);
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, object4, object3)) break;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean isReusable() {
        if (!DispatchedTaskKt.isReusableMode(this.resumeMode)) return false;
        Continuation<T> continuation = this.delegate;
        Intrinsics.checkNotNull(continuation, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        if (!((DispatchedContinuation)continuation).isReusable()) return false;
        return true;
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Unit> function1, Object object) {
        while (true) {
            function1.invoke((Object)atomicIntegerFieldUpdater.get(object));
        }
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1, Object object) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(object));
        }
    }

    private final CancelHandler makeCancelHandler(Function1<? super Throwable, Unit> cancelHandler) {
        cancelHandler = cancelHandler instanceof CancelHandler ? (CancelHandler)cancelHandler : (CancelHandler)new InvokeOnCancel(cancelHandler);
        return cancelHandler;
    }

    private final void multipleHandlersError(Object object, Object object2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + object + ", already has " + object2).toString());
    }

    private final void resumeImpl(Object object, int n, Function1<? super Throwable, Unit> function1) {
        Object v;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        while ((v = atomicReferenceFieldUpdater.get(this)) instanceof NotCompleted) {
            Object object2 = this.resumedState((NotCompleted)v, object, n, function1, null);
            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, v, object2)) continue;
            this.detachChildIfNonResuable();
            this.dispatchResume(n);
            return;
        }
        if (v instanceof CancelledContinuation && ((CancelledContinuation)v).makeResumed()) {
            if (function1 != null) {
                this.callOnCancellation(function1, ((CancelledContinuation)v).cause);
            }
            return;
        }
        this.alreadyResumedError(object);
        throw new KotlinNothingValueException();
    }

    static /* synthetic */ void resumeImpl$default(CancellableContinuationImpl cancellableContinuationImpl, Object object, int n, Function1 function1, int n2, Object object2) {
        if (object2 == null) {
            if ((n2 & 4) != 0) {
                function1 = null;
            }
            cancellableContinuationImpl.resumeImpl(object, n, (Function1<Throwable, Unit>)function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final Object resumedState(NotCompleted object, Object object2, int n, Function1<? super Throwable, Unit> function1, Object object3) {
        if (!(object2 instanceof CompletedExceptionally)) {
            if (!DispatchedTaskKt.isCancellableMode(n) && object3 == null) return object2;
            if (function1 == null && !(object instanceof CancelHandler)) {
                if (object3 == null) return object2;
            }
        } else {
            boolean bl = DebugKt.getASSERTIONS_ENABLED();
            int n2 = 1;
            if (bl) {
                n = object3 == null ? 1 : 0;
                if (n == 0) throw new AssertionError();
            }
            if (!DebugKt.getASSERTIONS_ENABLED()) return object2;
            n = function1 == null ? n2 : 0;
            if (n == 0) throw new AssertionError();
            return object2;
        }
        object = object instanceof CancelHandler ? (CancelHandler)object : null;
        return new CompletedContinuation(object2, (CancelHandler)object, function1, object3, null, 16, null);
    }

    private final boolean tryResume() {
        int n;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = _decisionAndIndex$FU;
        do {
            n = atomicIntegerFieldUpdater2.get(this);
            switch (n >> 29) {
                default: {
                    throw new IllegalStateException("Already resumed".toString());
                }
                case 1: {
                    return false;
                }
                case 0: 
            }
        } while (!(atomicIntegerFieldUpdater = _decisionAndIndex$FU).compareAndSet(this, n, (2 << 29) + (n & 0x1FFFFFFF)));
        return true;
    }

    private final Symbol tryResumeImpl(Object object, Object object2, Function1<? super Throwable, Unit> function1) {
        Object v;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        while ((v = atomicReferenceFieldUpdater.get(this)) instanceof NotCompleted) {
            Object object3 = this.resumedState((NotCompleted)v, object, this.resumeMode, function1, object2);
            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, v, object3)) continue;
            this.detachChildIfNonResuable();
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }
        boolean bl = v instanceof CompletedContinuation;
        function1 = null;
        if (bl) {
            if (object2 != null && ((CompletedContinuation)v).idempotentResume == object2) {
                if (DebugKt.getASSERTIONS_ENABLED() && !Intrinsics.areEqual((Object)((CompletedContinuation)v).result, object)) {
                    throw new AssertionError();
                }
                object = CancellableContinuationImplKt.RESUME_TOKEN;
            } else {
                object = function1;
            }
            return object;
        }
        return null;
    }

    private final boolean trySuspend() {
        int n;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = _decisionAndIndex$FU;
        do {
            n = atomicIntegerFieldUpdater2.get(this);
            switch (n >> 29) {
                default: {
                    throw new IllegalStateException("Already suspended".toString());
                }
                case 2: {
                    return false;
                }
                case 0: 
            }
        } while (!(atomicIntegerFieldUpdater = _decisionAndIndex$FU).compareAndSet(this, n, (1 << 29) + (n & 0x1FFFFFFF)));
        return true;
    }

    private final void update$atomicfu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Integer> function1, Object object) {
        int n;
        while (!atomicIntegerFieldUpdater.compareAndSet(object, n = atomicIntegerFieldUpdater.get(object), ((Number)function1.invoke((Object)n)).intValue())) {
        }
    }

    public final void callCancelHandler(CancelHandler cancelHandler, Throwable throwable) {
        try {
            cancelHandler.invoke(throwable);
        }
        catch (Throwable throwable2) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, throwable2));
        }
    }

    public final void callOnCancellation(Function1<? super Throwable, Unit> function1, Throwable throwable) {
        try {
            function1.invoke((Object)throwable);
        }
        catch (Throwable throwable2) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, throwable2));
        }
    }

    @Override
    public boolean cancel(Throwable throwable) {
        boolean bl;
        Object object;
        Object v;
        Object object2 = _state$FU;
        do {
            v = ((AtomicReferenceFieldUpdater)object2).get(this);
            boolean bl2 = v instanceof NotCompleted;
            bl = false;
            if (!bl2) {
                return false;
            }
            object = this;
            if (!(v instanceof CancelHandler) && !(v instanceof Segment)) continue;
            bl = true;
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, v, object = new CancelledContinuation((Continuation<?>)object, throwable, bl)));
        object2 = (NotCompleted)v;
        if (object2 instanceof CancelHandler) {
            this.callCancelHandler((CancelHandler)v, throwable);
        } else if (object2 instanceof Segment) {
            this.callSegmentOnCancellation((Segment)v, throwable);
        }
        this.detachChildIfNonResuable();
        this.dispatchResume(this.resumeMode);
        return true;
    }

    @Override
    public void cancelCompletedResult$kotlinx_coroutines_core(Object object, Throwable throwable) {
        Object v;
        object = _state$FU;
        while (!((v = ((AtomicReferenceFieldUpdater)object).get(this)) instanceof NotCompleted)) {
            if (v instanceof CompletedExceptionally) {
                return;
            }
            if (v instanceof CompletedContinuation) {
                if (((CompletedContinuation)v).getCancelled() ^ true) {
                    CompletedContinuation completedContinuation = CompletedContinuation.copy$default((CompletedContinuation)v, null, null, null, null, throwable, 15, null);
                    if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, v, completedContinuation)) continue;
                    ((CompletedContinuation)v).invokeHandlers(this, throwable);
                    return;
                }
                throw new IllegalStateException("Must be called at most once".toString());
            }
            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, v, new CompletedContinuation(v, null, null, null, throwable, 14, null))) continue;
            return;
        }
        throw new IllegalStateException("Not completed".toString());
    }

    @Override
    public void completeResume(Object object) {
        boolean bl;
        if (DebugKt.getASSERTIONS_ENABLED() && !(bl = object == CancellableContinuationImplKt.RESUME_TOKEN)) {
            throw new AssertionError();
        }
        this.dispatchResume(this.resumeMode);
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle disposableHandle = this.getParentHandle();
        if (disposableHandle == null) {
            return;
        }
        disposableHandle.dispose();
        _parentHandle$FU.set(this, NonDisposableHandle.INSTANCE);
    }

    public CoroutineStackFrame getCallerFrame() {
        Object object = this.delegate;
        object = object instanceof CoroutineStackFrame ? (CoroutineStackFrame)object : null;
        return object;
    }

    public CoroutineContext getContext() {
        return this.context;
    }

    public Throwable getContinuationCancellationCause(Job job2) {
        return job2.getCancellationException();
    }

    @Override
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override
    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object object) {
        if ((object = super.getExceptionalResult$kotlinx_coroutines_core(object)) != null) {
            Continuation<T> continuation = this.delegate;
            if (DebugKt.getRECOVER_STACK_TRACES() && continuation instanceof CoroutineStackFrame) {
                object = StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)object, (CoroutineStackFrame)continuation);
            }
        } else {
            object = null;
        }
        return object;
    }

    public final Object getResult() {
        Object object;
        Object object2;
        boolean bl = this.isReusable();
        if (this.trySuspend()) {
            if (this.getParentHandle() == null) {
                this.installParentHandle();
            }
            if (bl) {
                this.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            }
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (bl) {
            this.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        }
        if ((object2 = this.getState$kotlinx_coroutines_core()) instanceof CompletedExceptionally) {
            Throwable throwable = ((CompletedExceptionally)object2).cause;
            object2 = throwable;
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                object2 = !((Continuation)this instanceof CoroutineStackFrame) ? throwable : StackTraceRecoveryKt.access$recoverFromStackFrame(throwable, (CoroutineStackFrame)((Continuation)this));
            }
            throw object2;
        }
        if (DispatchedTaskKt.isCancellableMode(this.resumeMode) && (object = (Job)this.getContext().get((CoroutineContext.Key)Job.Key)) != null && !object.isActive()) {
            object = object.getCancellationException();
            this.cancelCompletedResult$kotlinx_coroutines_core(object2, (Throwable)object);
            object2 = DebugKt.getRECOVER_STACK_TRACES() && (Continuation)this instanceof CoroutineStackFrame ? StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)object, (CoroutineStackFrame)((Continuation)this)) : (Throwable)object;
            throw object2;
        }
        return this.getSuccessfulResult$kotlinx_coroutines_core(object2);
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final Object getState$kotlinx_coroutines_core() {
        return _state$FU.get(this);
    }

    @Override
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object object) {
        block0: {
            if (!(object instanceof CompletedContinuation)) break block0;
            object = ((CompletedContinuation)object).result;
        }
        return (T)object;
    }

    @Override
    public void initCancellability() {
        DisposableHandle disposableHandle = this.installParentHandle();
        if (disposableHandle == null) {
            return;
        }
        if (this.isCompleted()) {
            disposableHandle.dispose();
            _parentHandle$FU.set(this, NonDisposableHandle.INSTANCE);
        }
    }

    @Override
    public void invokeOnCancellation(Function1<? super Throwable, Unit> function1) {
        this.invokeOnCancellationImpl(this.makeCancelHandler(function1));
    }

    @Override
    public void invokeOnCancellation(Segment<?> segment, int n) {
        int n2;
        boolean bl;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$FU;
        while (bl = ((n2 = atomicIntegerFieldUpdater.get(this)) & 0x1FFFFFFF) == 0x1FFFFFFF) {
            if (!atomicIntegerFieldUpdater.compareAndSet(this, n2, (n2 >> 29 << 29) + n)) continue;
            this.invokeOnCancellationImpl(segment);
            return;
        }
        throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
    }

    @Override
    public boolean isActive() {
        return this.getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    @Override
    public boolean isCancelled() {
        return this.getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
    }

    @Override
    public boolean isCompleted() {
        return this.getState$kotlinx_coroutines_core() instanceof NotCompleted ^ true;
    }

    protected String nameString() {
        return "CancellableContinuation";
    }

    public final void parentCancelled$kotlinx_coroutines_core(Throwable throwable) {
        if (this.cancelLater(throwable)) {
            return;
        }
        this.cancel(throwable);
        this.detachChildIfNonResuable();
    }

    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        DispatchedContinuation dispatchedContinuation = this.delegate;
        dispatchedContinuation = dispatchedContinuation instanceof DispatchedContinuation ? (DispatchedContinuation)dispatchedContinuation : null;
        if (dispatchedContinuation != null && (dispatchedContinuation = dispatchedContinuation.tryReleaseClaimedContinuation(this)) != null) {
            this.detachChild$kotlinx_coroutines_core();
            this.cancel((Throwable)((Object)dispatchedContinuation));
            return;
        }
    }

    public final boolean resetStateReusable() {
        boolean bl;
        if (DebugKt.getASSERTIONS_ENABLED() && !(bl = this.resumeMode == 2)) {
            throw new AssertionError();
        }
        if (DebugKt.getASSERTIONS_ENABLED() && !(bl = this.getParentHandle() != NonDisposableHandle.INSTANCE)) {
            throw new AssertionError();
        }
        Object v = _state$FU.get(this);
        if (DebugKt.getASSERTIONS_ENABLED() && !(v instanceof NotCompleted ^ true)) {
            throw new AssertionError();
        }
        if (v instanceof CompletedContinuation && ((CompletedContinuation)v).idempotentResume != null) {
            this.detachChild$kotlinx_coroutines_core();
            return false;
        }
        _decisionAndIndex$FU.set(this, (0 << 29) + 0x1FFFFFFF);
        _state$FU.set(this, Active.INSTANCE);
        return true;
    }

    @Override
    public void resume(T t, Function1<? super Throwable, Unit> function1) {
        this.resumeImpl(t, this.resumeMode, function1);
    }

    @Override
    public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, T t) {
        DispatchedContinuation dispatchedContinuation = this.delegate;
        boolean bl = dispatchedContinuation instanceof DispatchedContinuation;
        CoroutineDispatcher coroutineDispatcher2 = null;
        dispatchedContinuation = bl ? (DispatchedContinuation)dispatchedContinuation : null;
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        }
        int n = coroutineDispatcher2 == coroutineDispatcher ? 4 : this.resumeMode;
        CancellableContinuationImpl.resumeImpl$default(this, t, n, null, 4, null);
    }

    @Override
    public void resumeUndispatchedWithException(CoroutineDispatcher coroutineDispatcher, Throwable object) {
        DispatchedContinuation dispatchedContinuation = this.delegate;
        boolean bl = dispatchedContinuation instanceof DispatchedContinuation;
        Object var6_5 = null;
        dispatchedContinuation = bl ? (DispatchedContinuation)dispatchedContinuation : null;
        CompletedExceptionally completedExceptionally = new CompletedExceptionally((Throwable)object, false, 2, null);
        object = var6_5;
        if (dispatchedContinuation != null) {
            object = dispatchedContinuation.dispatcher;
        }
        int n = object == coroutineDispatcher ? 4 : this.resumeMode;
        CancellableContinuationImpl.resumeImpl$default(this, completedExceptionally, n, null, 4, null);
    }

    public void resumeWith(Object object) {
        CancellableContinuationImpl.resumeImpl$default(this, CompletionStateKt.toState(object, this), this.resumeMode, null, 4, null);
    }

    @Override
    public Object takeState$kotlinx_coroutines_core() {
        return this.getState$kotlinx_coroutines_core();
    }

    public String toString() {
        return this.nameString() + '(' + DebugStringsKt.toDebugString(this.delegate) + "){" + this.getStateDebugRepresentation() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    @Override
    public Object tryResume(T t, Object object) {
        return this.tryResumeImpl(t, object, null);
    }

    @Override
    public Object tryResume(T t, Object object, Function1<? super Throwable, Unit> function1) {
        return this.tryResumeImpl(t, object, function1);
    }

    @Override
    public Object tryResumeWithException(Throwable throwable) {
        return this.tryResumeImpl(new CompletedExceptionally(throwable, false, 2, null), null, null);
    }
}

