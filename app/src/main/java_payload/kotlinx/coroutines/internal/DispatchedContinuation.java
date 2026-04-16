/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1={"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u001f\u001a\u00020 J\u001f\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010#\u001a\u00020$H\u0010\u00a2\u0006\u0002\b%J\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cJ\u001f\u0010'\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010(\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\n\u0018\u00010,j\u0004\u0018\u0001`-H\u0016J\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020/2\u0006\u0010#\u001a\u00020$J\u0006\u00101\u001a\u00020 JF\u00102\u001a\u00020 2\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000042%\b\b\u00105\u001a\u001f\u0012\u0013\u0012\u00110$\u00a2\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020 \u0018\u000106H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020/2\b\u0010;\u001a\u0004\u0018\u00010\fH\u0086\bJ\u001f\u0010<\u001a\u00020 2\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010=J\u001e\u0010>\u001a\u00020 2\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010=J\u000f\u0010?\u001a\u0004\u0018\u00010\fH\u0010\u00a2\u0006\u0002\b@J\b\u0010A\u001a\u00020BH\u0016J\u0014\u0010C\u001a\u0004\u0018\u00010$2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030DR\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004R\u001a\u0010\r\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0081\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\f8\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006E"}, d2={"Lkotlinx/coroutines/internal/DispatchedContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "_reusableCancellableContinuation", "Lkotlinx/atomicfu/AtomicRef;", "", "_state", "get_state$kotlinx_coroutines_core$annotations", "()V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "countOrElement", "delegate", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "reusableCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "getReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "awaitReusability", "", "cancelCompletedResult", "takenState", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "claimReusableCancellableContinuation", "dispatchYield", "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "isReusable", "", "postponeCancellation", "release", "resumeCancellableWith", "result", "Lkotlin/Result;", "onCancellation", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeCancelled", "state", "resumeUndispatchedWith", "(Ljava/lang/Object;)V", "resumeWith", "takeState", "takeState$kotlinx_coroutines_core", "toString", "", "tryReleaseClaimedContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class DispatchedContinuation<T>
extends DispatchedTask<T>
implements CoroutineStackFrame,
Continuation<T> {
    private static final AtomicReferenceFieldUpdater _reusableCancellableContinuation$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    @Volatile
    private volatile Object _reusableCancellableContinuation;
    public Object _state;
    public final Continuation<T> continuation;
    public final Object countOrElement;
    public final CoroutineDispatcher dispatcher;

    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher, Continuation<? super T> continuation) {
        super(-1);
        this.dispatcher = coroutineDispatcher;
        this.continuation = continuation;
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        this.countOrElement = ThreadContextKt.threadContextElements(this.getContext());
    }

    private final CancellableContinuationImpl<?> getReusableCancellableContinuation() {
        Object object = _reusableCancellableContinuation$FU.get(this);
        object = object instanceof CancellableContinuationImpl ? (CancellableContinuationImpl)object : null;
        return object;
    }

    public static /* synthetic */ void get_state$kotlinx_coroutines_core$annotations() {
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1, Object object) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(object));
        }
    }

    public final void awaitReusability() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _reusableCancellableContinuation$FU;
        while (atomicReferenceFieldUpdater.get(this) == DispatchedContinuationKt.REUSABLE_CLAIMED) {
        }
    }

    @Override
    public void cancelCompletedResult$kotlinx_coroutines_core(Object object, Throwable throwable) {
        if (object instanceof CompletedWithCancellation) {
            ((CompletedWithCancellation)object).onCancellation.invoke((Object)throwable);
        }
    }

    public final CancellableContinuationImpl<T> claimReusableCancellableContinuation() {
        Object v;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _reusableCancellableContinuation$FU;
        while (true) {
            if ((v = atomicReferenceFieldUpdater.get(this)) == null) {
                _reusableCancellableContinuation$FU.set(this, DispatchedContinuationKt.REUSABLE_CLAIMED);
                return null;
            }
            if (v instanceof CancellableContinuationImpl) {
                if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_reusableCancellableContinuation$FU, this, v, DispatchedContinuationKt.REUSABLE_CLAIMED)) continue;
                return (CancellableContinuationImpl)v;
            }
            if (v != DispatchedContinuationKt.REUSABLE_CLAIMED && !(v instanceof Throwable)) break;
        }
        throw new IllegalStateException(("Inconsistent state " + v).toString());
    }

    public final void dispatchYield$kotlinx_coroutines_core(CoroutineContext coroutineContext, T t) {
        this._state = t;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(coroutineContext, this);
    }

    public CoroutineStackFrame getCallerFrame() {
        Object object = this.continuation;
        object = object instanceof CoroutineStackFrame ? (CoroutineStackFrame)object : null;
        return object;
    }

    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    @Override
    public Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final boolean isReusable() {
        boolean bl = _reusableCancellableContinuation$FU.get(this) != null;
        return bl;
    }

    public final boolean postponeCancellation(Throwable throwable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _reusableCancellableContinuation$FU;
        while (true) {
            Object v;
            if (Intrinsics.areEqual(v = atomicReferenceFieldUpdater.get(this), (Object)DispatchedContinuationKt.REUSABLE_CLAIMED)) {
                if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_reusableCancellableContinuation$FU, this, DispatchedContinuationKt.REUSABLE_CLAIMED, throwable)) continue;
                return true;
            }
            if (v instanceof Throwable) {
                return true;
            }
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_reusableCancellableContinuation$FU, this, v, null)) break;
        }
        return false;
    }

    public final void release() {
        this.awaitReusability();
        CancellableContinuationImpl<?> cancellableContinuationImpl = this.getReusableCancellableContinuation();
        if (cancellableContinuationImpl != null) {
            cancellableContinuationImpl.detachChild$kotlinx_coroutines_core();
        }
    }

    /*
     * Exception decompiling
     */
    public final void resumeCancellableWith(Object var1_1, Function1<? super Throwable, Unit> var2_10) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
         *     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
         *     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
         *     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
         *     at java.base/java.util.Objects.checkIndex(Objects.java:385)
         *     at java.base/java.util.ArrayList.get(ArrayList.java:427)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.EclipseLoops.eclipseLoopPass(EclipseLoops.java:51)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Op03Rewriters.eclipseLoopPass(Op03Rewriters.java:121)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:676)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public final boolean resumeCancelled(Object object) {
        Object object2 = (Job)this.getContext().get((CoroutineContext.Key)Job.Key);
        if (object2 != null && !object2.isActive()) {
            object2 = object2.getCancellationException();
            this.cancelCompletedResult$kotlinx_coroutines_core(object, (Throwable)object2);
            Continuation continuation = this;
            object = Result.Companion;
            continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)((Throwable)object2))));
            return true;
        }
        return false;
    }

    public final void resumeUndispatchedWith(Object object) {
        Continuation<T> continuation = this.continuation;
        Object object2 = this.countOrElement;
        CoroutineContext coroutineContext = continuation.getContext();
        object2 = ThreadContextKt.updateThreadContext(coroutineContext, object2);
        continuation = object2 != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation, coroutineContext, object2) : null;
        try {
            this.continuation.resumeWith(object);
            object = Unit.INSTANCE;
            return;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            if (continuation == null || continuation.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(coroutineContext, object2);
            }
            InlineMarker.finallyEnd((int)1);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void resumeWith(Object object) {
        Object object2;
        CoroutineContext coroutineContext;
        Object object3 = this.continuation.getContext();
        Object object4 = CompletionStateKt.toState$default(object, null, 1, null);
        if (this.dispatcher.isDispatchNeeded((CoroutineContext)object3)) {
            this._state = object4;
            this.resumeMode = 0;
            this.dispatcher.dispatch((CoroutineContext)object3, this);
            return;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            // empty if block
        }
        if (((EventLoop)((Object)(object3 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core()))).isUnconfinedLoopActive()) {
            this._state = object4;
            this.resumeMode = 0;
            ((EventLoop)((Object)object3)).dispatchUnconfined(this);
            return;
        }
        object4 = this;
        ((EventLoop)((Object)object3)).incrementUseCount(true);
        try {
            coroutineContext = this.getContext();
            object2 = ThreadContextKt.updateThreadContext(coroutineContext, this.countOrElement);
        }
        catch (Throwable throwable) {
            try {
                ((DispatchedTask)object4).handleFatalException(throwable, null);
                return;
            }
            finally {
                ((EventLoop)((Object)object3)).decrementUseCount(true);
            }
        }
        try {
            this.continuation.resumeWith(object);
            object = Unit.INSTANCE;
        }
        finally {
            ThreadContextKt.restoreThreadContext(coroutineContext, object2);
        }
        {
            while (((EventLoop)((Object)object3)).processUnconfinedEvent()) {
            }
            return;
        }
    }

    @Override
    public Object takeState$kotlinx_coroutines_core() {
        boolean bl;
        Object object = this._state;
        if (DebugKt.getASSERTIONS_ENABLED() && !(bl = object != DispatchedContinuationKt.access$getUNDEFINED$p())) {
            throw new AssertionError();
        }
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        return object;
    }

    public String toString() {
        return "DispatchedContinuation[" + (Object)((Object)this.dispatcher) + ", " + DebugStringsKt.toDebugString(this.continuation) + ']';
    }

    public final Throwable tryReleaseClaimedContinuation(CancellableContinuation<?> cancellableContinuation) {
        Object v;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _reusableCancellableContinuation$FU;
        while ((v = atomicReferenceFieldUpdater.get(this)) == DispatchedContinuationKt.REUSABLE_CLAIMED) {
            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_reusableCancellableContinuation$FU, this, DispatchedContinuationKt.REUSABLE_CLAIMED, cancellableContinuation)) continue;
            return null;
        }
        if (v instanceof Throwable) {
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_reusableCancellableContinuation$FU, this, v, null)) {
                return (Throwable)v;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalStateException(("Inconsistent state " + v).toString());
    }
}

