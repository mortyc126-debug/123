/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.SendingCollector;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B?\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0014J\u001f\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\u0011\u001a\u00020\u0017H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "concurrency", "", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "additionalToStringProps", "", "collectTo", "", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class ChannelFlowMerge<T>
extends ChannelFlow<T> {
    private final int concurrency;
    private final Flow<Flow<T>> flow;

    public ChannelFlowMerge(Flow<? extends Flow<? extends T>> flow2, int n, CoroutineContext coroutineContext, int n2, BufferOverflow bufferOverflow) {
        super(coroutineContext, n2, bufferOverflow);
        this.flow = flow2;
        this.concurrency = n;
    }

    public /* synthetic */ ChannelFlowMerge(Flow flow2, int n, CoroutineContext coroutineContext, int n2, BufferOverflow bufferOverflow, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 4) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n3 & 8) != 0) {
            n2 = -2;
        }
        if ((n3 & 0x10) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        this(flow2, n, coroutineContext, n2, bufferOverflow);
    }

    @Override
    protected String additionalToStringProps() {
        return "concurrency=" + this.concurrency;
    }

    @Override
    protected Object collectTo(ProducerScope<? super T> object, Continuation<? super Unit> continuation) {
        Semaphore semaphore = SemaphoreKt.Semaphore$default(this.concurrency, 0, 2, null);
        SendingCollector sendingCollector = new SendingCollector((SendChannel)object);
        Job job2 = (Job)continuation.getContext().get((CoroutineContext.Key)Job.Key);
        object = this.flow.collect(new FlowCollector(job2, semaphore, object, sendingCollector){
            final SendingCollector<T> $collector;
            final Job $job;
            final ProducerScope<T> $scope;
            final Semaphore $semaphore;
            {
                this.$job = job2;
                this.$semaphore = semaphore;
                this.$scope = producerScope;
                this.$collector = sendingCollector;
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object emit(Flow<? extends T> var1_1, Continuation<? super Unit> var2_2) {
                if (!(var2_2 /* !! */  instanceof collectTo.emit.1)) ** GOTO lbl-1000
                var3_3 /* !! */  = var2_2 /* !! */ ;
                if ((var3_3 /* !! */ .label & -2147483648) != 0) {
                    var3_3 /* !! */ .label += -2147483648;
                    var2_2 /* !! */  = var3_3 /* !! */ ;
                } else lbl-1000:
                // 2 sources

                {
                    var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                        Object L$0;
                        Object L$1;
                        int label;
                        Object result;
                        final collectTo.2<T> this$0;
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
                var4_4 = var2_2 /* !! */ .result;
                var3_3 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (var2_2 /* !! */ .label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        var1_1 = (Flow)var2_2 /* !! */ .L$1;
                        var2_2 /* !! */  = var2_2 /* !! */ .L$0;
                        ResultKt.throwOnFailure((Object)var4_4);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)var4_4);
                        var4_4 = this.$job;
                        if (var4_4 != null) {
                            JobKt.ensureActive((Job)var4_4);
                        }
                        var4_4 = this.$semaphore;
                        var2_2 /* !! */ .L$0 = this;
                        var2_2 /* !! */ .L$1 = var1_1;
                        var2_2 /* !! */ .label = 1;
                        if (var4_4.acquire(var2_2 /* !! */ ) == var3_3 /* !! */ ) {
                            return var3_3 /* !! */ ;
                        }
                        var2_2 /* !! */  = this;
                    }
                }
                BuildersKt.launch$default(var2_2 /* !! */ .$scope, null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(var1_1, var2_2 /* !! */ .$collector, var2_2 /* !! */ .$semaphore, null){
                    final SendingCollector<T> $collector;
                    final Flow<T> $inner;
                    final Semaphore $semaphore;
                    int label;
                    {
                        this.$inner = flow2;
                        this.$collector = sendingCollector;
                        this.$semaphore = semaphore;
                        super(2, continuation);
                    }

                    public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                        return (Continuation)new /* invalid duplicate definition of identical inner class */;
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /*
                     * Loose catch block
                     * WARNING - void declaration
                     */
                    public final Object invokeSuspend(Object object) {
                        void var1_4;
                        block8: {
                            Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 1: {
                                    try {
                                        ResultKt.throwOnFailure((Object)object);
                                        break;
                                    }
                                    catch (Throwable throwable) {
                                        break block8;
                                    }
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)object);
                                    Flow<T> flow2 = this.$inner;
                                    FlowCollector flowCollector = this.$collector;
                                    object = (Continuation)this;
                                    this.label = 1;
                                    object = flow2.collect(flowCollector, (Continuation<Unit>)object);
                                    if (object != object2) break;
                                    return object2;
                                }
                            }
                            this.$semaphore.release();
                            return Unit.INSTANCE;
                            catch (Throwable throwable) {
                                // empty catch block
                            }
                        }
                        this.$semaphore.release();
                        throw var1_4;
                    }
                }, 3, null);
                return Unit.INSTANCE;
            }
        }, continuation);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    protected ChannelFlow<T> create(CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        return new ChannelFlowMerge<T>(this.flow, this.concurrency, coroutineContext, n, bufferOverflow);
    }

    @Override
    public ReceiveChannel<T> produceImpl(CoroutineScope coroutineScope) {
        return ProduceKt.produce(coroutineScope, this.context, this.capacity, this.getCollectToFun$kotlinx_coroutines_core());
    }
}

