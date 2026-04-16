/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.IndexedValue
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001an\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012(\u0010\u0007\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u001a\u0090\u0001\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u00010\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0018\u00010\u00110\u001329\u0010\u0007\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u00a2\u0006\u0002\b\u0014H\u0081@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015*\u001c\b\u0002\u0010\u0016\"\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00172\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2={"zipImpl", "Lkotlinx/coroutines/flow/Flow;", "R", "T1", "T2", "flow", "flow2", "transform", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "combineInternal", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "flows", "", "arrayFactory", "Lkotlin/Function0;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/FlowCollector;[Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Update", "Lkotlin/collections/IndexedValue;", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class CombineKt {
    public static final <R, T> Object combineInternal(FlowCollector<? super R> object, Flow<? extends T>[] flowArray, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        if ((object = FlowCoroutineKt.flowScope((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(flowArray, function0, function3, object, null){
            final Function0<T[]> $arrayFactory;
            final Flow<T>[] $flows;
            final FlowCollector<R> $this_combineInternal;
            final Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
            int I$0;
            int I$1;
            private Object L$0;
            Object L$1;
            Object L$2;
            int label;
            {
                this.$flows = flowArray;
                this.$arrayFactory = function0;
                this.$transform = function3;
                this.$this_combineInternal = flowCollector;
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

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object invokeSuspend(Object var1_1) {
                var11_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 3: {
                        var6_3 = this;
                        var2_4 = var6_3.I$1;
                        var3_5 = var6_3.I$0;
                        var7_6 = (byte[])var6_3.L$2;
                        var8_7 = (Channel)var6_3.L$1;
                        var9_8 /* !! */  = (Object[])var6_3.L$0;
                        ResultKt.throwOnFailure((Object)var1_1);
                        var1_1 = var9_8 /* !! */ ;
                        break;
                    }
                    case 2: {
                        var6_3 = this;
                        var2_4 = var6_3.I$1;
                        var3_5 = var6_3.I$0;
                        var7_6 = (byte[])var6_3.L$2;
                        var8_7 = (Channel)var6_3.L$1;
                        var9_8 /* !! */  = (Object[])var6_3.L$0;
                        ResultKt.throwOnFailure((Object)var1_1);
                        var1_1 = var9_8 /* !! */ ;
                        break;
                    }
                    case 1: {
                        var6_3 = this;
                        var2_4 = var6_3.I$1;
                        var3_5 = var6_3.I$0;
                        var7_6 = (byte[])var6_3.L$2;
                        var8_7 = (Channel)var6_3.L$1;
                        var9_8 /* !! */  = (Object[])var6_3.L$0;
                        ResultKt.throwOnFailure((Object)var1_1);
                        var10_9 /* !! */  = ((ChannelResult)var1_1).unbox-impl();
                        var1_1 = var9_8 /* !! */ ;
                        var9_8 /* !! */  = var10_9 /* !! */ ;
                        ** GOTO lbl65
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        var6_3 = this;
                        var7_6 = (CoroutineScope)var6_3.L$0;
                        var3_5 = var6_3.$flows.length;
                        if (var3_5 == 0) {
                            return Unit.INSTANCE;
                        }
                        var1_1 = new Object[var3_5];
                        ArraysKt.fill$default((Object[])var1_1, (Object)NullSurrogateKt.UNINITIALIZED, (int)0, (int)0, (int)6, null);
                        var8_7 = ChannelKt.Channel$default(var3_5, null, null, 6, null);
                        var9_8 /* !! */  = new AtomicInteger(var3_5);
                        for (var2_4 = 0; var2_4 < var3_5; ++var2_4) {
                            BuildersKt.launch$default((CoroutineScope)var7_6, null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(var6_3.$flows, var2_4, (AtomicInteger)var9_8 /* !! */ , (Channel<IndexedValue<Object>>)var8_7, null){
                                final Flow<T>[] $flows;
                                final int $i;
                                final AtomicInteger $nonClosed;
                                final Channel<IndexedValue<Object>> $resultChannel;
                                int label;
                                {
                                    this.$flows = flowArray;
                                    this.$i = n;
                                    this.$nonClosed = atomicInteger;
                                    this.$resultChannel = channel;
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
                                    block10: {
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
                                                    break block10;
                                                }
                                            }
                                            case 0: {
                                                ResultKt.throwOnFailure((Object)object);
                                                object = this.$flows[this.$i];
                                                FlowCollector flowCollector = new FlowCollector(this.$resultChannel, this.$i){
                                                    final int $i;
                                                    final Channel<IndexedValue<Object>> $resultChannel;
                                                    {
                                                        this.$resultChannel = channel;
                                                        this.$i = n;
                                                    }

                                                    /*
                                                     * Unable to fully structure code
                                                     * Could not resolve type clashes
                                                     */
                                                    public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                                                        block8: {
                                                            if (!(var2_2 /* !! */  instanceof combineInternal.emit.1)) ** GOTO lbl-1000
                                                            var3_3 /* !! */  = var2_2 /* !! */ ;
                                                            if ((var3_3 /* !! */ .label & -2147483648) != 0) {
                                                                var3_3 /* !! */ .label += -2147483648;
                                                                var2_2 /* !! */  = var3_3 /* !! */ ;
                                                            } else lbl-1000:
                                                            // 2 sources

                                                            {
                                                                var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                                                    int label;
                                                                    Object result;
                                                                    final combineInternal.1<T> this$0;
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
                                                                case 2: {
                                                                    ResultKt.throwOnFailure((Object)var4_4);
                                                                    break block8;
                                                                }
                                                                case 1: {
                                                                    ResultKt.throwOnFailure((Object)var4_4);
                                                                    break;
                                                                }
                                                                case 0: {
                                                                    ResultKt.throwOnFailure((Object)var4_4);
                                                                    var4_4 = this.$resultChannel;
                                                                    var1_1 /* !! */  = new IndexedValue(this.$i, var1_1 /* !! */ );
                                                                    var2_2 /* !! */ .label = 1;
                                                                    if (var4_4.send((IndexedValue<Object>)var1_1 /* !! */ , (Continuation<Unit>)var2_2 /* !! */ ) != var3_3 /* !! */ ) break;
                                                                    return var3_3 /* !! */ ;
                                                                }
                                                            }
                                                            var2_2 /* !! */ .label = 2;
                                                            if (YieldKt.yield(var2_2 /* !! */ ) == var3_3 /* !! */ ) {
                                                                return var3_3 /* !! */ ;
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                flowCollector = flowCollector;
                                                Continuation continuation = (Continuation)this;
                                                this.label = 1;
                                                object = object.collect(flowCollector, (Continuation<Unit>)continuation);
                                                if (object != object2) break;
                                                return object2;
                                            }
                                        }
                                        if (this.$nonClosed.decrementAndGet() == 0) {
                                            SendChannel.DefaultImpls.close$default(this.$resultChannel, null, 1, null);
                                        }
                                        return Unit.INSTANCE;
                                        catch (Throwable throwable) {
                                            // empty catch block
                                        }
                                    }
                                    if (this.$nonClosed.decrementAndGet() == 0) {
                                        SendChannel.DefaultImpls.close$default(this.$resultChannel, null, 1, null);
                                    }
                                    throw var1_4;
                                }
                            }, 3, null);
                        }
                        var7_6 = new byte[var3_5];
                        var2_4 = 0;
                    }
                }
                while (true) {
                    var2_4 = (byte)(var2_4 + 1);
                    var9_8 /* !! */  = (Continuation)var6_3;
                    var6_3.L$0 = var1_1;
                    var6_3.L$1 = var8_7;
                    var6_3.L$2 = var7_6;
                    var6_3.I$0 = var3_5;
                    var6_3.I$1 = var2_4;
                    var6_3.label = 1;
                    if ((var9_8 /* !! */  = var8_7.receiveCatching-JP2dKIU(var9_8 /* !! */ )) == var11_2) {
                        return var11_2;
                    }
lbl65:
                    // 3 sources

                    var10_9 /* !! */  = (IndexedValue)ChannelResult.getOrNull-impl(var9_8 /* !! */ );
                    var4_10 = var3_5;
                    var9_8 /* !! */  = var10_9 /* !! */ ;
                    if (var10_9 /* !! */  == null) {
                        return Unit.INSTANCE;
                    }
                    while (true) {
                        var5_11 = var9_8 /* !! */ .getIndex();
                        var10_9 /* !! */  = var1_1[var5_11];
                        var1_1[var5_11] = var9_8 /* !! */ .getValue();
                        var3_5 = var4_10;
                        if (var10_9 /* !! */  == NullSurrogateKt.UNINITIALIZED) {
                            var3_5 = var4_10 - 1;
                        }
                        if (var7_6[var5_11] == var2_4) break;
                        var7_6[var5_11] = (byte)var2_4;
                        var9_8 /* !! */  = (IndexedValue)ChannelResult.getOrNull-impl(var8_7.tryReceive-PtdJZtk());
                        if (var9_8 /* !! */  == null) break;
                        var4_10 = var3_5;
                    }
                    if (var3_5 != 0) continue;
                    var9_8 /* !! */  = (IndexedValue)var6_3.$arrayFactory.invoke();
                    if (var9_8 /* !! */  == null) {
                        var10_9 /* !! */  = var6_3.$transform;
                        var9_8 /* !! */  = var6_3.$this_combineInternal;
                        var6_3.L$0 = var1_1;
                        var6_3.L$1 = var8_7;
                        var6_3.L$2 = var7_6;
                        var6_3.I$0 = var3_5;
                        var6_3.I$1 = var2_4;
                        var6_3.label = 2;
                        if (var10_9 /* !! */ .invoke((Object)var9_8 /* !! */ , (Object)var1_1, (Object)var6_3) != var11_2) continue;
                        return var11_2;
                    }
                    ArraysKt.copyInto$default((Object[])var1_1, (Object[])var9_8 /* !! */ , (int)0, (int)0, (int)0, (int)14, null);
                    var12_12 = var6_3.$transform;
                    var10_9 /* !! */  = var6_3.$this_combineInternal;
                    var6_3.L$0 = var1_1;
                    var6_3.L$1 = var8_7;
                    var6_3.L$2 = var7_6;
                    var6_3.I$0 = var3_5;
                    var6_3.I$1 = var2_4;
                    var6_3.label = 3;
                    if (var12_12.invoke(var10_9 /* !! */ , (Object)var9_8 /* !! */ , (Object)var6_3) == var11_2) break;
                }
                return var11_2;
            }
        }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    public static final <T1, T2, R> Flow<R> zipImpl(Flow<? extends T1> flow2, Flow<? extends T2> flow3, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return new Flow<R>(flow3, flow2, function3){
            final Flow $flow$inlined;
            final Flow $flow2$inlined;
            final Function3 $transform$inlined;
            {
                this.$flow2$inlined = flow2;
                this.$flow$inlined = flow3;
                this.$transform$inlined = function3;
            }

            public Object collect(FlowCollector<? super R> object, Continuation<? super Unit> continuation) {
                if ((object = CoroutineScopeKt.coroutineScope((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(object, this.$flow2$inlined, this.$flow$inlined, this.$transform$inlined, null){
                    final Flow<T1> $flow;
                    final Flow<T2> $flow2;
                    final FlowCollector<R> $this_unsafeFlow;
                    final Function3<T1, T2, Continuation<? super R>, Object> $transform;
                    private Object L$0;
                    int label;
                    {
                        this.$this_unsafeFlow = flowCollector;
                        this.$flow2 = flow2;
                        this.$flow = flow3;
                        this.$transform = function3;
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

                    /*
                     * Unable to fully structure code
                     */
                    public final Object invokeSuspend(Object var1_1) {
                        block13: {
                            block14: {
                                var2_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 1: {
                                        var2_3 = (ReceiveChannel)this.L$0;
                                        try {
                                            ResultKt.throwOnFailure((Object)var1_1);
                                            var1_1 = var2_3;
                                            break;
                                        }
                                        catch (Throwable var1_2) {
                                            break block13;
                                        }
                                        catch (AbortFlowException var3_6) {
                                            var1_1 = var2_3;
                                            break block14;
                                        }
                                    }
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)var1_1);
                                        var4_9 = (CoroutineScope)this.L$0;
                                        var1_1 = ProduceKt.produce$default(var4_9, null, 0, (Function2)new Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object>(this.$flow2, null){
                                            final Flow<T2> $flow2;
                                            private Object L$0;
                                            int label;
                                            {
                                                this.$flow2 = flow2;
                                                super(2, continuation);
                                            }

                                            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                                                object2 = new /* invalid duplicate definition of identical inner class */;
                                                object2.L$0 = object;
                                                return object2;
                                            }

                                            public final Object invoke(ProducerScope<Object> producerScope, Continuation<? super Unit> continuation) {
                                                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                                        ProducerScope producerScope = (ProducerScope)this.L$0;
                                                        flow2 = this.$flow2;
                                                        FlowCollector flowCollector = new FlowCollector(producerScope){
                                                            final ProducerScope<Object> $$this$produce;
                                                            {
                                                                this.$$this$produce = producerScope;
                                                            }

                                                            /*
                                                             * Unable to fully structure code
                                                             * Could not resolve type clashes
                                                             */
                                                            public final Object emit(T2 var1_1, Continuation<? super Unit> var2_2) {
                                                                if (!(var2_2 /* !! */  instanceof zipImpl.1.second.emit.1)) ** GOTO lbl-1000
                                                                var3_3 /* !! */  = var2_2 /* !! */ ;
                                                                if ((var3_3 /* !! */ .label & -2147483648) != 0) {
                                                                    var3_3 /* !! */ .label += -2147483648;
                                                                    var2_2 /* !! */  = var3_3 /* !! */ ;
                                                                } else lbl-1000:
                                                                // 2 sources

                                                                {
                                                                    var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                                                        int label;
                                                                        Object result;
                                                                        final zipImpl.1.second.1<T> this$0;
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
                                                                var3_3 /* !! */  = var2_2 /* !! */ .result;
                                                                var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                switch (var2_2 /* !! */ .label) {
                                                                    default: {
                                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                    }
                                                                    case 1: {
                                                                        ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                                                                        break;
                                                                    }
                                                                    case 0: {
                                                                        ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                                                                        var5_5 = this.$$this$produce.getChannel();
                                                                        var3_3 /* !! */  = var1_1;
                                                                        if (var1_1 == null) {
                                                                            var3_3 /* !! */  = NullSurrogateKt.NULL;
                                                                        }
                                                                        var2_2 /* !! */ .label = 1;
                                                                        if (var5_5.send((Object)var3_3 /* !! */ , var2_2 /* !! */ ) != var4_4) break;
                                                                        return var4_4;
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        producerScope = (Continuation)this;
                                                        this.label = 1;
                                                        if (flow2.collect(flowCollector, (Continuation<Unit>)producerScope) != object) break;
                                                        return object;
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }, 3, null);
                                        var3_7 = JobKt.Job$default(null, 1, null);
                                        Intrinsics.checkNotNull((Object)var1_1, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
                                        ((SendChannel)var1_1).invokeOnClose((Function1<Throwable, Unit>)((Function1)new Function1<Throwable, Unit>((CompletableJob)var3_7, this.$this_unsafeFlow){
                                            final CompletableJob $collectJob;
                                            final FlowCollector<R> $this_unsafeFlow;
                                            {
                                                this.$collectJob = completableJob;
                                                this.$this_unsafeFlow = flowCollector;
                                                super(1);
                                            }

                                            public final void invoke(Throwable throwable) {
                                                if (this.$collectJob.isActive()) {
                                                    this.$collectJob.cancel(new AbortFlowException(this.$this_unsafeFlow));
                                                }
                                            }
                                        }));
                                        var5_10 = var4_9.getCoroutineContext();
                                        var6_11 = ThreadContextKt.threadContextElements(var5_10);
                                        var4_9 = var4_9.getCoroutineContext().plus((CoroutineContext)var3_7);
                                        var3_7 = Unit.INSTANCE;
                                        var7_12 = new Function2<Unit, Continuation<? super Unit>, Object>(this.$flow, var5_10, var6_11, (ReceiveChannel<? extends Object>)var1_1, this.$this_unsafeFlow, this.$transform, null){
                                            final Object $cnt;
                                            final Flow<T1> $flow;
                                            final CoroutineContext $scopeContext;
                                            final ReceiveChannel<Object> $second;
                                            final FlowCollector<R> $this_unsafeFlow;
                                            final Function3<T1, T2, Continuation<? super R>, Object> $transform;
                                            int label;
                                            {
                                                this.$flow = flow2;
                                                this.$scopeContext = coroutineContext;
                                                this.$cnt = object;
                                                this.$second = receiveChannel;
                                                this.$this_unsafeFlow = flowCollector;
                                                this.$transform = function3;
                                                super(2, continuation);
                                            }

                                            public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                                                return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
                                                return (this.create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                                        Flow<T1> flow2 = this.$flow;
                                                        FlowCollector flowCollector = new FlowCollector(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform){
                                                            final Object $cnt;
                                                            final CoroutineContext $scopeContext;
                                                            final ReceiveChannel<Object> $second;
                                                            final FlowCollector<R> $this_unsafeFlow;
                                                            final Function3<T1, T2, Continuation<? super R>, Object> $transform;
                                                            {
                                                                this.$scopeContext = coroutineContext;
                                                                this.$cnt = object;
                                                                this.$second = receiveChannel;
                                                                this.$this_unsafeFlow = flowCollector;
                                                                this.$transform = function3;
                                                            }

                                                            /*
                                                             * Unable to fully structure code
                                                             * Could not resolve type clashes
                                                             */
                                                            public final Object emit(T1 var1_1, Continuation<? super Unit> var2_2) {
                                                                if (!(var2_2 /* !! */  instanceof zipImpl.1.emit.1)) ** GOTO lbl-1000
                                                                var3_3 /* !! */  = var2_2 /* !! */ ;
                                                                if ((var3_3 /* !! */ .label & -2147483648) != 0) {
                                                                    var3_3 /* !! */ .label += -2147483648;
                                                                    var2_2 /* !! */  = var3_3 /* !! */ ;
                                                                } else lbl-1000:
                                                                // 2 sources

                                                                {
                                                                    var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                                                        int label;
                                                                        Object result;
                                                                        final zipImpl.1.1<T> this$0;
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
                                                                        ResultKt.throwOnFailure((Object)var4_4);
                                                                        break;
                                                                    }
                                                                    case 0: {
                                                                        ResultKt.throwOnFailure((Object)var4_4);
                                                                        var5_5 = this.$scopeContext;
                                                                        var4_4 = Unit.INSTANCE;
                                                                        var6_6 = this.$cnt;
                                                                        var1_1 /* !! */  = (Function2)new Function2<Unit, Continuation<? super Unit>, Object>(this.$second, this.$this_unsafeFlow, this.$transform, var1_1 /* !! */ , null){
                                                                            final ReceiveChannel<Object> $second;
                                                                            final FlowCollector<R> $this_unsafeFlow;
                                                                            final Function3<T1, T2, Continuation<? super R>, Object> $transform;
                                                                            final T1 $value;
                                                                            Object L$0;
                                                                            int label;
                                                                            {
                                                                                this.$second = receiveChannel;
                                                                                this.$this_unsafeFlow = flowCollector;
                                                                                this.$transform = function3;
                                                                                this.$value = T1;
                                                                                super(2, continuation);
                                                                            }

                                                                            public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                                                                                return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                                                            }

                                                                            public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
                                                                                return (this.create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                            }

                                                                            public final Object invokeSuspend(Object object) {
                                                                                block11: {
                                                                                    Function3<T1, T2, Continuation<? super R>, Object> function3;
                                                                                    Object object2;
                                                                                    Object object3;
                                                                                    Object object4;
                                                                                    block12: {
                                                                                        object4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                                        switch (this.label) {
                                                                                            default: {
                                                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                                            }
                                                                                            case 3: {
                                                                                                ResultKt.throwOnFailure((Object)object);
                                                                                                break block11;
                                                                                            }
                                                                                            case 2: {
                                                                                                object3 = (FlowCollector)this.L$0;
                                                                                                ResultKt.throwOnFailure((Object)object);
                                                                                                object2 = this;
                                                                                                break block12;
                                                                                            }
                                                                                            case 1: {
                                                                                                ResultKt.throwOnFailure((Object)object);
                                                                                                object = ((ChannelResult)object).unbox-impl();
                                                                                                break;
                                                                                            }
                                                                                            case 0: {
                                                                                                ResultKt.throwOnFailure((Object)object);
                                                                                                object3 = this.$second;
                                                                                                object = (Continuation)this;
                                                                                                this.label = 1;
                                                                                                object = object3 = object3.receiveCatching-JP2dKIU(object);
                                                                                                if (object3 != object4) break;
                                                                                                return object4;
                                                                                            }
                                                                                        }
                                                                                        object2 = this.$this_unsafeFlow;
                                                                                        if (object instanceof ChannelResult.Failed) {
                                                                                            object = object3 = ChannelResult.exceptionOrNull-impl(object);
                                                                                            if (object3 == null) {
                                                                                                object = new AbortFlowException((FlowCollector<?>)object2);
                                                                                            }
                                                                                            throw object;
                                                                                        }
                                                                                        object2 = this.$this_unsafeFlow;
                                                                                        function3 = this.$transform;
                                                                                        T1 T1 = this.$value;
                                                                                        object3 = object;
                                                                                        if (object == NullSurrogateKt.NULL) {
                                                                                            object3 = null;
                                                                                        }
                                                                                        this.L$0 = object2;
                                                                                        this.label = 2;
                                                                                        object = function3.invoke(T1, object3, (Object)((Object)this));
                                                                                        if (object == object4) {
                                                                                            return object4;
                                                                                        }
                                                                                        object3 = this;
                                                                                        object3 = object2;
                                                                                    }
                                                                                    object2 = this;
                                                                                    function3 = (Function3<T1, T2, Continuation<? super R>, Object>)object2;
                                                                                    object2.L$0 = null;
                                                                                    object2.label = 3;
                                                                                    if (object3.emit(object, (Continuation<? super Unit>)function3) == object4) {
                                                                                        return object4;
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        };
                                                                        var2_2 /* !! */ .label = 1;
                                                                        if (ChannelFlowKt.withContextUndispatched(var5_5, var4_4, var6_6, var1_1 /* !! */ , var2_2 /* !! */ ) != var3_3 /* !! */ ) break;
                                                                        return var3_3 /* !! */ ;
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        object = (Continuation)this;
                                                        this.label = 1;
                                                        if (flow2.collect(flowCollector, (Continuation<Unit>)object) != object2) break;
                                                        return object2;
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        var6_11 = (Function2)var7_12;
                                        var5_10 = (Continuation)this;
                                        this.L$0 = var1_1;
                                        this.label = 1;
                                        var3_7 = ChannelFlowKt.withContextUndispatched$default((CoroutineContext)var4_9, var3_7, null, (Function2)var6_11, (Continuation)var5_10, 4, null);
                                        if (var3_7 != var2_3) break;
                                        return var2_3;
                                    }
                                }
lbl36:
                                // 3 sources

                                while (true) {
                                    continue;
                                    break;
                                }
                                catch (Throwable var2_4) {
                                    var3_7 = var1_1;
                                    var1_1 = var2_4;
                                    var2_3 = var3_7;
                                    break block13;
                                }
                                catch (AbortFlowException var2_5) {
                                    var3_7 = var2_5;
                                }
                            }
                            try {
                                FlowExceptions_commonKt.checkOwnership((AbortFlowException)var3_7, this.$this_unsafeFlow);
                                ** continue;
                            }
                            catch (Throwable var3_8) {
                                var2_3 = var1_1;
                                var1_1 = var3_8;
                            }
                            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel)var1_1, null, 1, null);
                            return Unit.INSTANCE;
                        }
                        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel)var2_3, null, 1, null);
                        throw var1_1;
                    }
                }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }
}

