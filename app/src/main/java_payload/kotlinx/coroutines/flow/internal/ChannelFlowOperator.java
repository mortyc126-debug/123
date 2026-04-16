/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.ContinuationInterceptor
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import kotlinx.coroutines.flow.internal.SendingCollector;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J'\u0010\u0016\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H\u00a4@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0004X\u0085\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "S", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectWithContextUndispatched", "newContext", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flowCollect", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class ChannelFlowOperator<S, T>
extends ChannelFlow<T> {
    protected final Flow<S> flow;

    public ChannelFlowOperator(Flow<? extends S> flow2, CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        super(coroutineContext, n, bufferOverflow);
        this.flow = flow2;
    }

    public static final /* synthetic */ Object access$collectWithContextUndispatched(ChannelFlowOperator channelFlowOperator, FlowCollector flowCollector, CoroutineContext coroutineContext, Continuation continuation) {
        return channelFlowOperator.collectWithContextUndispatched(flowCollector, coroutineContext, (Continuation<Unit>)continuation);
    }

    static /* synthetic */ <S, T> Object collect$suspendImpl(ChannelFlowOperator<S, T> object, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        if (((ChannelFlowOperator)object).capacity == -3) {
            CoroutineContext coroutineContext = continuation.getContext();
            CoroutineContext coroutineContext2 = coroutineContext.plus(((ChannelFlowOperator)object).context);
            if (Intrinsics.areEqual((Object)coroutineContext2, (Object)coroutineContext)) {
                if ((object = ((ChannelFlowOperator)object).flowCollect(flowCollector, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
            if (Intrinsics.areEqual((Object)coroutineContext2.get((CoroutineContext.Key)ContinuationInterceptor.Key), (Object)coroutineContext.get((CoroutineContext.Key)ContinuationInterceptor.Key))) {
                if ((object = super.collectWithContextUndispatched(flowCollector, coroutineContext2, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        }
        if ((object = super.collect(flowCollector, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ <S, T> Object collectTo$suspendImpl(ChannelFlowOperator<S, T> object, ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        if ((object = ((ChannelFlowOperator)object).flowCollect(new SendingCollector((SendChannel)producerScope), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final Object collectWithContextUndispatched(FlowCollector<? super T> object, CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        if ((object = ChannelFlowKt.withContextUndispatched$default(coroutineContext, ChannelFlowKt.access$withUndispatchedContextCollector(object, continuation.getContext()), null, new Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object>(this, null){
            Object L$0;
            int label;
            final ChannelFlowOperator<S, T> this$0;
            {
                this.this$0 = channelFlowOperator;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
                return (this.create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)object);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        FlowCollector flowCollector = (FlowCollector)this.L$0;
                        ChannelFlowOperator<S, T> channelFlowOperator = this.this$0;
                        object = (Continuation)this;
                        this.label = 1;
                        if (channelFlowOperator.flowCollect(flowCollector, (Continuation<Unit>)object) != object2) break;
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }
        }, continuation, 4, null)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return ChannelFlowOperator.collect$suspendImpl(this, flowCollector, continuation);
    }

    @Override
    protected Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return ChannelFlowOperator.collectTo$suspendImpl(this, producerScope, continuation);
    }

    protected abstract Object flowCollect(FlowCollector<? super T> var1, Continuation<? super Unit> var2);

    @Override
    public String toString() {
        return this.flow + " -> " + super.toString();
    }
}

