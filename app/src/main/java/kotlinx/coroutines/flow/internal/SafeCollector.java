/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.DownstreamExceptionContext;
import kotlinx.coroutines.flow.internal.NoOpContinuation;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.flow.internal.SafeCollectorKt;
import kotlinx.coroutines.flow.internal.SafeCollector_commonKt;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u00032\u00020\u0004B\u001b\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ'\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ%\u0010\u001a\u001a\u0004\u0018\u00010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001cH\u0002J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J \u0010$\u001a\u00020\u001c2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0&H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0010H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2={"Lkotlinx/coroutines/flow/internal/SafeCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collector", "collectContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collectContextSize", "", "completion", "Lkotlin/coroutines/Continuation;", "", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "lastEmissionContext", "checkContext", "currentContext", "previousContext", "value", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "uCont", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)Ljava/lang/Object;", "exceptionTransparencyViolated", "exception", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionContext;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class SafeCollector<T>
extends ContinuationImpl
implements FlowCollector<T>,
CoroutineStackFrame {
    public final CoroutineContext collectContext;
    public final int collectContextSize;
    public final FlowCollector<T> collector;
    private Continuation<? super Unit> completion;
    private CoroutineContext lastEmissionContext;

    public SafeCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        super((Continuation)NoOpContinuation.INSTANCE, (CoroutineContext)EmptyCoroutineContext.INSTANCE);
        this.collector = flowCollector;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number)this.collectContext.fold((Object)0, (Function2)collectContextSize.1.INSTANCE)).intValue();
    }

    private final void checkContext(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, T t) {
        if (coroutineContext2 instanceof DownstreamExceptionContext) {
            this.exceptionTransparencyViolated((DownstreamExceptionContext)coroutineContext2, t);
        }
        SafeCollector_commonKt.checkContext(this, coroutineContext);
    }

    private final Object emit(Continuation<? super Unit> object, T t) {
        CoroutineContext coroutineContext = object.getContext();
        JobKt.ensureActive(coroutineContext);
        CoroutineContext coroutineContext2 = this.lastEmissionContext;
        if (coroutineContext2 != coroutineContext) {
            this.checkContext(coroutineContext, coroutineContext2, t);
            this.lastEmissionContext = coroutineContext;
        }
        this.completion = object;
        coroutineContext2 = SafeCollectorKt.access$getEmitFun$p();
        object = this.collector;
        Intrinsics.checkNotNull(object, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        object = coroutineContext2.invoke(object, t, (Object)((Continuation)this));
        if (!Intrinsics.areEqual(object, (Object)IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
            this.completion = null;
        }
        return object;
    }

    private final void exceptionTransparencyViolated(DownstreamExceptionContext object, Object object2) {
        object = new StringBuilder().append("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception ").append(((DownstreamExceptionContext)object).e);
        object = ((StringBuilder)object).append(", but then emission attempt of value '");
        object = ((StringBuilder)object).append(object2);
        throw new IllegalStateException(StringsKt.trimIndent((String)((StringBuilder)object).append("' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString()).toString());
    }

    @Override
    public Object emit(T object, Continuation<? super Unit> continuation) {
        try {
            object = this.emit(continuation, object);
        }
        catch (Throwable throwable) {
            this.lastEmissionContext = new DownstreamExceptionContext(throwable, continuation.getContext());
            throw throwable;
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    public CoroutineStackFrame getCallerFrame() {
        Object object = this.completion;
        object = object instanceof CoroutineStackFrame ? (CoroutineStackFrame)object : null;
        return object;
    }

    public CoroutineContext getContext() {
        CoroutineContext coroutineContext;
        CoroutineContext coroutineContext2 = coroutineContext = this.lastEmissionContext;
        if (coroutineContext == null) {
            coroutineContext2 = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        return coroutineContext2;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public Object invokeSuspend(Object object) {
        Continuation<? super Unit> continuation = Result.exceptionOrNull-impl((Object)object);
        if (continuation != null) {
            this.lastEmissionContext = new DownstreamExceptionContext((Throwable)continuation, this.getContext());
        }
        if ((continuation = this.completion) != null) {
            continuation.resumeWith(object);
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}

