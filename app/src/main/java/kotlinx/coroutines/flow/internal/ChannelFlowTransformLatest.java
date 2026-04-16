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
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Ref$ObjectRef
 */
package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperator;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.SendingCollector;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003Bx\u0012B\u0010\u0004\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005\u00a2\u0006\u0002\b\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u001f\u0010\u001a\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cRO\u0010\u0004\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005\u00a2\u0006\u0002\b\rX\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\n\u0002\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest;", "T", "R", "Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "transform", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/jvm/functions/Function3;Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlin/jvm/functions/Function3;", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flowCollect", "collector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class ChannelFlowTransformLatest<T, R>
extends ChannelFlowOperator<T, R> {
    private final Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> transform;

    public ChannelFlowTransformLatest(Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, Flow<? extends T> flow2, CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        super(flow2, coroutineContext, n, bufferOverflow);
        this.transform = function3;
    }

    public /* synthetic */ ChannelFlowTransformLatest(Function3 function3, Flow flow2, CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n2 & 8) != 0) {
            n = -2;
        }
        if ((n2 & 0x10) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        this(function3, flow2, coroutineContext, n, bufferOverflow);
    }

    public static final /* synthetic */ Function3 access$getTransform$p(ChannelFlowTransformLatest channelFlowTransformLatest) {
        return channelFlowTransformLatest.transform;
    }

    @Override
    protected ChannelFlow<R> create(CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest<T, R>(this.transform, this.flow, coroutineContext, n, bufferOverflow);
    }

    @Override
    protected Object flowCollect(FlowCollector<? super R> object, Continuation<? super Unit> continuation) {
        if (DebugKt.getASSERTIONS_ENABLED() && !(object instanceof SendingCollector)) {
            throw new AssertionError();
        }
        if ((object = CoroutineScopeKt.coroutineScope((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, object, null){
            final FlowCollector<R> $collector;
            private Object L$0;
            int label;
            final ChannelFlowTransformLatest<T, R> this$0;
            {
                this.this$0 = channelFlowTransformLatest;
                this.$collector = flowCollector;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        CoroutineScope coroutineScope = (CoroutineScope)this.L$0;
                        Object object3 = new Ref.ObjectRef();
                        object = this.this$0.flow;
                        object3 = new FlowCollector((Ref.ObjectRef<Job>)object3, coroutineScope, this.this$0, this.$collector){
                            final CoroutineScope $$this$coroutineScope;
                            final FlowCollector<R> $collector;
                            final Ref.ObjectRef<Job> $previousFlow;
                            final ChannelFlowTransformLatest<T, R> this$0;
                            {
                                this.$previousFlow = objectRef;
                                this.$$this$coroutineScope = coroutineScope;
                                this.this$0 = channelFlowTransformLatest;
                                this.$collector = flowCollector;
                            }

                            /*
                             * Unable to fully structure code
                             * Could not resolve type clashes
                             */
                            public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                                block7: {
                                    if (!(var2_2 /* !! */  instanceof flowCollect.emit.1)) ** GOTO lbl-1000
                                    var3_3 = var2_2 /* !! */ ;
                                    if ((var3_3.label & -2147483648) != 0) {
                                        var3_3.label += -2147483648;
                                    } else lbl-1000:
                                    // 2 sources

                                    {
                                        var3_3 = new ContinuationImpl(this, var2_2 /* !! */ ){
                                            Object L$0;
                                            Object L$1;
                                            Object L$2;
                                            int label;
                                            Object result;
                                            final flowCollect.1<T> this$0;
                                            {
                                                this.this$0 = var1_1;
                                                super(continuation);
                                            }

                                            public final Object invokeSuspend(Object object) {
                                                this.result = object;
                                                this.label |= Integer.MIN_VALUE;
                                                return this.this$0.emit(null, (Continuation<Unit>)((Continuation)this));
                                            }
                                        };
                                    }
                                    var4_4 = var3_3.result;
                                    var6_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (var3_3.label) {
                                        default: {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        case 1: {
                                            var1_1 /* !! */  = (Job)var3_3.L$2;
                                            var1_1 /* !! */  = var3_3.L$1;
                                            var2_2 /* !! */  = var3_3.L$0;
                                            ResultKt.throwOnFailure((Object)var4_4);
                                            break;
                                        }
                                        case 0: {
                                            ResultKt.throwOnFailure((Object)var4_4);
                                            var2_2 /* !! */  = this;
                                            var7_6 = (Job)var2_2 /* !! */ .$previousFlow.element;
                                            var5_7 /* !! */  = var2_2 /* !! */ ;
                                            var4_4 = var1_1 /* !! */ ;
                                            if (var7_6 != null) {
                                                var7_6.cancel(new ChildCancelledException());
                                                var3_3.L$0 = var2_2 /* !! */ ;
                                                var3_3.L$1 = var1_1 /* !! */ ;
                                                var3_3.L$2 = var7_6;
                                                var3_3.label = 1;
                                                if (var7_6.join((Continuation<? super Unit>)var3_3) != var6_5) break;
                                                return var6_5;
                                            }
                                            break block7;
                                        }
                                    }
                                    var4_4 = var1_1 /* !! */ ;
                                    var5_7 /* !! */  = var2_2 /* !! */ ;
                                }
                                var5_7 /* !! */ .$previousFlow.element = BuildersKt.launch$default(var5_7 /* !! */ .$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(var5_7 /* !! */ .this$0, var5_7 /* !! */ .$collector, var4_4, null){
                                    final FlowCollector<R> $collector;
                                    final T $value;
                                    int label;
                                    final ChannelFlowTransformLatest<T, R> this$0;
                                    {
                                        this.this$0 = channelFlowTransformLatest;
                                        this.$collector = flowCollector;
                                        this.$value = t;
                                        super(2, continuation);
                                    }

                                    public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                                        return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                                object = ChannelFlowTransformLatest.access$getTransform$p(this.this$0);
                                                FlowCollector<R> flowCollector = this.$collector;
                                                T t = this.$value;
                                                this.label = 1;
                                                if (object.invoke(flowCollector, t, (Object)((Object)this)) != object2) break;
                                                return object2;
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, 1, null);
                                return Unit.INSTANCE;
                            }
                        };
                        coroutineScope = (Continuation)this;
                        this.label = 1;
                        if (object.collect(object3, (Continuation<? super Unit>)coroutineScope) != object2) break;
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }
        }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }
}

