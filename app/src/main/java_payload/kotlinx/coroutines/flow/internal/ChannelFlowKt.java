/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.NopCollector;
import kotlinx.coroutines.flow.internal.SendingCollector;
import kotlinx.coroutines.flow.internal.StackFrameContinuation;
import kotlinx.coroutines.flow.internal.UndispatchedContextCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1={"\u00000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a[\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00072\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\tH\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00010\r\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u000eH\u0000\u001a&\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2={"withContextUndispatched", "T", "V", "newContext", "Lkotlin/coroutines/CoroutineContext;", "value", "countOrElement", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asChannelFlow", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/Flow;", "withUndispatchedContextCollector", "Lkotlinx/coroutines/flow/FlowCollector;", "emitContext", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class ChannelFlowKt {
    public static final /* synthetic */ FlowCollector access$withUndispatchedContextCollector(FlowCollector flowCollector, CoroutineContext coroutineContext) {
        return ChannelFlowKt.withUndispatchedContextCollector(flowCollector, coroutineContext);
    }

    public static final <T> ChannelFlow<T> asChannelFlow(Flow<? extends T> flow2) {
        ChannelFlow channelFlow = flow2 instanceof ChannelFlow ? (ChannelFlow)flow2 : null;
        ChannelFlow channelFlow2 = channelFlow;
        if (channelFlow == null) {
            channelFlow2 = new ChannelFlowOperatorImpl(flow2, null, 0, null, 14, null);
        }
        return channelFlow2;
    }

    public static final <T, V> Object withContextUndispatched(CoroutineContext coroutineContext, V object, Object object2, Function2<? super V, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        block3: {
            object2 = ThreadContextKt.updateThreadContext(coroutineContext, object2);
            Continuation continuation2 = new StackFrameContinuation(continuation, coroutineContext);
            continuation2 = continuation2;
            object = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, (int)2)).invoke(object, (Object)continuation2);
            if (object != IntrinsicsKt.getCOROUTINE_SUSPENDED()) break block3;
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return object;
        finally {
            ThreadContextKt.restoreThreadContext(coroutineContext, object2);
        }
    }

    public static /* synthetic */ Object withContextUndispatched$default(CoroutineContext coroutineContext, Object object, Object object2, Function2 function2, Continuation continuation, int n, Object object3) {
        if ((n & 4) != 0) {
            object2 = ThreadContextKt.threadContextElements(coroutineContext);
        }
        return ChannelFlowKt.withContextUndispatched(coroutineContext, object, object2, function2, continuation);
    }

    private static final <T> FlowCollector<T> withUndispatchedContextCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        boolean bl = flowCollector instanceof SendingCollector ? true : flowCollector instanceof NopCollector;
        if (!bl) {
            flowCollector = new UndispatchedContextCollector<T>(flowCollector, coroutineContext);
        }
        return flowCollector;
    }
}

