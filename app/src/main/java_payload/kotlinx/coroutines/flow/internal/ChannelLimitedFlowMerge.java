/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B7\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010\u000f\u001a\u00020\u0015H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2={"Lkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flows", "", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Ljava/lang/Iterable;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collectTo", "", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class ChannelLimitedFlowMerge<T>
extends ChannelFlow<T> {
    private final Iterable<Flow<T>> flows;

    public ChannelLimitedFlowMerge(Iterable<? extends Flow<? extends T>> iterable, CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        super(coroutineContext, n, bufferOverflow);
        this.flows = iterable;
    }

    public /* synthetic */ ChannelLimitedFlowMerge(Iterable iterable, CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n2 & 4) != 0) {
            n = -2;
        }
        if ((n2 & 8) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        this(iterable, coroutineContext, n, bufferOverflow);
    }

    @Override
    protected Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> object) {
        SendingCollector sendingCollector = new SendingCollector((SendChannel)producerScope);
        for (Flow flow2 : this.flows) {
            BuildersKt.launch$default(producerScope, null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(flow2, sendingCollector, null){
                final SendingCollector<T> $collector;
                final Flow<T> $flow;
                int label;
                {
                    this.$flow = flow2;
                    this.$collector = sendingCollector;
                    super(2, continuation);
                }

                public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object flow2) {
                    Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        default: {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        case 1: {
                            ResultKt.throwOnFailure((Object)flow2);
                            break;
                        }
                        case 0: {
                            ResultKt.throwOnFailure((Object)flow2);
                            flow2 = this.$flow;
                            FlowCollector flowCollector = this.$collector;
                            Continuation continuation = (Continuation)this;
                            this.label = 1;
                            if (flow2.collect(flowCollector, (Continuation<Unit>)continuation) != object) break;
                            return object;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, 3, null);
        }
        return Unit.INSTANCE;
    }

    @Override
    protected ChannelFlow<T> create(CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        return new ChannelLimitedFlowMerge<T>(this.flows, coroutineContext, n, bufferOverflow);
    }

    @Override
    public ReceiveChannel<T> produceImpl(CoroutineScope coroutineScope) {
        return ProduceKt.produce(coroutineScope, this.context, this.capacity, this.getCollectToFun$kotlinx_coroutines_core());
    }
}

