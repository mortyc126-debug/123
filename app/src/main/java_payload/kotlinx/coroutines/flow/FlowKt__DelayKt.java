/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.time.Duration
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__DelayKt;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectImplementation;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0007\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\b\b\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0007\u001a3\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a7\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u00a2\u0006\u0002\b\r\u001a$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0005H\u0000\u001a&\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0005H\u0007\u001a3\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0007H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\n\u001a3\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\n\u001a3\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001b"}, d2={"debounce", "Lkotlinx/coroutines/flow/Flow;", "T", "timeoutMillis", "Lkotlin/Function1;", "", "timeout", "Lkotlin/time/Duration;", "debounceDuration", "debounce-HG0u8IE", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "debounceInternal", "timeoutMillisSelector", "debounceInternal$FlowKt__DelayKt", "fixedPeriodTicker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "Lkotlinx/coroutines/CoroutineScope;", "delayMillis", "initialDelayMillis", "sample", "periodMillis", "period", "sample-HG0u8IE", "timeout-HG0u8IE", "timeoutInternal", "timeoutInternal-HG0u8IE$FlowKt__DelayKt", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__DelayKt {
    public static final <T> Flow<T> debounce(Flow<? extends T> flow2, long l) {
        boolean bl = l >= 0L;
        if (bl) {
            if (l == 0L) {
                return flow2;
            }
            return FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt(flow2, (Function1)new Function1<T, Long>(l){
                final long $timeoutMillis;
                {
                    this.$timeoutMillis = l;
                    super(1);
                }

                public final Long invoke(T t) {
                    return this.$timeoutMillis;
                }
            });
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    }

    public static final <T> Flow<T> debounce(Flow<? extends T> flow2, Function1<? super T, Long> function1) {
        return FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt(flow2, function1);
    }

    public static final <T> Flow<T> debounce-HG0u8IE(Flow<? extends T> flow2, long l) {
        return FlowKt.debounce(flow2, DelayKt.toDelayMillis-LRDsOJo(l));
    }

    public static final <T> Flow<T> debounceDuration(Flow<? extends T> flow2, Function1<? super T, Duration> function1) {
        return FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt(flow2, (Function1)new Function1<T, Long>(function1){
            final Function1<T, Duration> $timeout;
            {
                this.$timeout = function1;
                super(1);
            }

            public final Long invoke(T t) {
                return DelayKt.toDelayMillis-LRDsOJo(((Duration)this.$timeout.invoke(t)).unbox-impl());
            }
        });
    }

    private static final <T> Flow<T> debounceInternal$FlowKt__DelayKt(Flow<? extends T> flow2, Function1<? super T, Long> function1) {
        return FlowCoroutineKt.scopedFlow((Function3)new Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object>(function1, flow2, null){
            final Flow<T> $this_debounceInternal;
            final Function1<T, Long> $timeoutMillisSelector;
            private Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            {
                this.$timeoutMillisSelector = function1;
                this.$this_debounceInternal = flow2;
                super(3, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> object) {
                object = new /* invalid duplicate definition of identical inner class */;
                object.L$0 = coroutineScope;
                object.L$1 = flowCollector;
                return object.invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[SWITCH], 4[CASE]], but top level block is 5[WHILELOOP]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.CastExpression.dumpInner(CastExpression.java:114)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.dump(StructuredReturn.java:60)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }
        });
    }

    public static final ReceiveChannel<Unit> fixedPeriodTicker(CoroutineScope coroutineScope, long l, long l2) {
        boolean bl = true;
        boolean bl2 = l >= 0L;
        if (bl2) {
            bl2 = l2 >= 0L ? bl : false;
            if (bl2) {
                return ProduceKt.produce$default(coroutineScope, null, 0, (Function2)new Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object>(l2, l, null){
                    final long $delayMillis;
                    final long $initialDelayMillis;
                    private Object L$0;
                    int label;
                    {
                        this.$initialDelayMillis = l;
                        this.$delayMillis = l2;
                        super(2, continuation);
                    }

                    public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                        object2 = new /* invalid duplicate definition of identical inner class */;
                        object2.L$0 = object;
                        return object2;
                    }

                    public final Object invoke(ProducerScope<? super Unit> producerScope, Continuation<? super Unit> continuation) {
                        return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /*
                     * Handled impossible loop by duplicating code
                     * WARNING - void declaration
                     * Enabled aggressive block sorting
                     */
                    public final Object invokeSuspend(Object object) {
                        long l;
                        void var1_7;
                        ProducerScope producerScope;
                        Object object2;
                        Object object3;
                        block9: {
                            object3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 3: {
                                    object2 = this;
                                    producerScope = (ProducerScope)object2.L$0;
                                    ResultKt.throwOnFailure((Object)object);
                                    Object object4 = object2;
                                    object2 = producerScope;
                                    break block9;
                                }
                                case 2: {
                                    object2 = this;
                                    producerScope = (ProducerScope)object2.L$0;
                                    ResultKt.throwOnFailure((Object)object);
                                    Object object5 = object2;
                                    object2 = producerScope;
                                    l = var1_7.$delayMillis;
                                    producerScope = (Continuation)var1_7;
                                    var1_7.L$0 = object2;
                                    var1_7.label = 3;
                                    if (DelayKt.delay(l, (Continuation<? super Unit>)producerScope) == object3) {
                                        return object3;
                                    }
                                    break block9;
                                }
                                case 1: {
                                    object2 = (ProducerScope)this.L$0;
                                    ResultKt.throwOnFailure((Object)object);
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)object);
                                    object2 = (ProducerScope)this.L$0;
                                    l = this.$initialDelayMillis;
                                    Continuation continuation = (Continuation)this;
                                    this.L$0 = object2;
                                    this.label = 1;
                                    if (DelayKt.delay(l, (Continuation<? super Unit>)continuation) != object3) break;
                                    return object3;
                                }
                            }
                            fixedPeriodTicker.3 var1_6 = this;
                        }
                        do {
                            SendChannel<Unit> sendChannel = object2.getChannel();
                            Unit unit = Unit.INSTANCE;
                            producerScope = (Continuation)var1_7;
                            var1_7.L$0 = object2;
                            var1_7.label = 2;
                            if (sendChannel.send(unit, (Continuation<Unit>)producerScope) == object3) {
                                return object3;
                            }
                            l = var1_7.$delayMillis;
                            producerScope = (Continuation)var1_7;
                            var1_7.L$0 = object2;
                            var1_7.label = 3;
                        } while (DelayKt.delay(l, (Continuation<? super Unit>)producerScope) != object3);
                        return object3;
                    }
                }, 1, null);
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + l2 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + l + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel fixedPeriodTicker$default(CoroutineScope coroutineScope, long l, long l2, int n, Object object) {
        if ((n & 2) != 0) {
            l2 = l;
        }
        return FlowKt.fixedPeriodTicker(coroutineScope, l, l2);
    }

    public static final <T> Flow<T> sample(Flow<? extends T> flow2, long l) {
        boolean bl = l > 0L;
        if (bl) {
            return FlowCoroutineKt.scopedFlow((Function3)new Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object>(l, flow2, null){
                final long $periodMillis;
                final Flow<T> $this_sample;
                private Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                {
                    this.$periodMillis = l;
                    this.$this_sample = flow2;
                    super(3, continuation);
                }

                public final Object invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> object) {
                    object = new /* invalid duplicate definition of identical inner class */;
                    object.L$0 = coroutineScope;
                    object.L$1 = flowCollector;
                    return object.invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object object) {
                    FlowCollector flowCollector;
                    ReceiveChannel receiveChannel;
                    Ref.ObjectRef objectRef;
                    Object object2;
                    Object object3;
                    Object object4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        default: {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        case 1: {
                            object3 = this;
                            object2 = (ReceiveChannel)object3.L$3;
                            objectRef = (Ref.ObjectRef)object3.L$2;
                            receiveChannel = (ReceiveChannel)object3.L$1;
                            flowCollector = (FlowCollector)object3.L$0;
                            ResultKt.throwOnFailure((Object)object);
                            object = object3;
                            object3 = object2;
                            break;
                        }
                        case 0: {
                            ResultKt.throwOnFailure((Object)object);
                            object = this;
                            object3 = (CoroutineScope)object.L$0;
                            flowCollector = (FlowCollector)object.L$1;
                            receiveChannel = ProduceKt.produce$default((CoroutineScope)object3, null, -1, (Function2)new Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object>(object.$this_sample, null){
                                final Flow<T> $this_sample;
                                private Object L$0;
                                int label;
                                {
                                    this.$this_sample = flow2;
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
                                            Object object2 = (ProducerScope)this.L$0;
                                            flow2 = this.$this_sample;
                                            object2 = new FlowCollector((ProducerScope<Object>)object2){
                                                final ProducerScope<Object> $$this$produce;
                                                {
                                                    this.$$this$produce = producerScope;
                                                }

                                                /*
                                                 * Unable to fully structure code
                                                 * Could not resolve type clashes
                                                 */
                                                public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                                                    if (!(var2_2 /* !! */  instanceof sample.values.emit.1)) ** GOTO lbl-1000
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
                                                            final sample.values.1<T> this$0;
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
                                                            var5_5 = this.$$this$produce;
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
                                            Continuation continuation = (Continuation)this;
                                            this.label = 1;
                                            if (flow2.collect((FlowCollector<T>)object2, (Continuation<Unit>)continuation) != object) break;
                                            return object;
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, 1, null);
                            objectRef = new Ref.ObjectRef();
                            object3 = FlowKt.fixedPeriodTicker$default((CoroutineScope)object3, object.$periodMillis, 0L, 2, null);
                        }
                    }
                    while (objectRef.element != NullSurrogateKt.DONE) {
                        object2 = new SelectImplementation<R>(object.getContext());
                        SelectBuilder selectBuilder = (SelectBuilder)object2;
                        selectBuilder.invoke(receiveChannel.getOnReceiveCatching(), (Function2)new Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object>((Ref.ObjectRef<Object>)objectRef, (ReceiveChannel<Unit>)object3, null){
                            final Ref.ObjectRef<Object> $lastValue;
                            final ReceiveChannel<Unit> $ticker;
                            Object L$0;
                            int label;
                            {
                                this.$lastValue = objectRef;
                                this.$ticker = receiveChannel;
                                super(2, continuation);
                            }

                            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                                object2 = new /* invalid duplicate definition of identical inner class */;
                                object2.L$0 = object;
                                return object2;
                            }

                            public final Object invoke-WpGqRn0(Object object, Continuation<? super Unit> continuation) {
                                return (this.create(ChannelResult.box-impl(object), continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object object) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 0: 
                                }
                                ResultKt.throwOnFailure((Object)object);
                                object = ((ChannelResult)this.L$0).unbox-impl();
                                Object object2 = this.$lastValue;
                                if (!(object instanceof ChannelResult.Failed)) {
                                    ((Ref.ObjectRef)object2).element = object;
                                }
                                object2 = this.$ticker;
                                Ref.ObjectRef<Object> objectRef = this.$lastValue;
                                if (object instanceof ChannelResult.Failed) {
                                    if ((object = ChannelResult.exceptionOrNull-impl(object)) == null) {
                                        object2.cancel(new ChildCancelledException());
                                        objectRef.element = NullSurrogateKt.DONE;
                                    } else {
                                        throw object;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        selectBuilder.invoke(object3.getOnReceive(), (Function2)new Function2<Unit, Continuation<? super Unit>, Object>((Ref.ObjectRef<Object>)objectRef, flowCollector, null){
                            final FlowCollector<T> $downstream;
                            final Ref.ObjectRef<Object> $lastValue;
                            int label;
                            {
                                this.$lastValue = objectRef;
                                this.$downstream = flowCollector;
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
                                        Object object3 = this.$lastValue.element;
                                        if (object3 == null) {
                                            return Unit.INSTANCE;
                                        }
                                        this.$lastValue.element = null;
                                        FlowCollector<Object> flowCollector = this.$downstream;
                                        object = object3;
                                        if (object3 == NullSurrogateKt.NULL) {
                                            object = null;
                                        }
                                        object3 = (Continuation)this;
                                        this.label = 1;
                                        if (flowCollector.emit(object, (Continuation<Unit>)object3) != object2) break;
                                        return object2;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        object.L$0 = flowCollector;
                        object.L$1 = receiveChannel;
                        object.L$2 = objectRef;
                        object.L$3 = object3;
                        object.label = 1;
                        if (((SelectImplementation)object2).doSelect(object) != object4) continue;
                        return object4;
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        throw new IllegalArgumentException("Sample period should be positive".toString());
    }

    public static final <T> Flow<T> sample-HG0u8IE(Flow<? extends T> flow2, long l) {
        return FlowKt.sample(flow2, DelayKt.toDelayMillis-LRDsOJo(l));
    }

    public static final <T> Flow<T> timeout-HG0u8IE(Flow<? extends T> flow2, long l) {
        return FlowKt__DelayKt.timeoutInternal-HG0u8IE$FlowKt__DelayKt(flow2, l);
    }

    private static final <T> Flow<T> timeoutInternal-HG0u8IE$FlowKt__DelayKt(Flow<? extends T> flow2, long l) {
        return FlowCoroutineKt.scopedFlow((Function3)new Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object>(l, flow2, null){
            final Flow<T> $this_timeoutInternal;
            final long $timeout;
            long J$0;
            private Object L$0;
            Object L$1;
            int label;
            {
                this.$timeout = l;
                this.$this_timeoutInternal = flow2;
                super(3, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> object) {
                object = new /* invalid duplicate definition of identical inner class */;
                object.L$0 = coroutineScope;
                object.L$1 = flowCollector;
                return object.invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             */
            public final Object invokeSuspend(Object var1_1) {
                var9_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        var7_3 = this;
                        var4_4 /* !! */  = var1_1;
                        var2_5 = var7_3.J$0;
                        var6_6 = (ReceiveChannel)var7_3.L$1;
                        var5_7 = (FlowCollector)var7_3.L$0;
                        ResultKt.throwOnFailure((Object)var4_4 /* !! */ );
                        var1_1 = var4_4 /* !! */ ;
                        var8_8 = var4_4 /* !! */ ;
                        ** break;
                    }
                    case 0: 
                }
                ResultKt.throwOnFailure((Object)var1_1);
                var4_4 /* !! */  = this;
                var6_6 = (CoroutineScope)var4_4 /* !! */ .L$0;
                var5_7 = (FlowCollector)var4_4 /* !! */ .L$1;
                if (Duration.compareTo-LRDsOJo((long)var4_4 /* !! */ .$timeout, (long)Duration.Companion.getZERO-UwyO8pc()) <= 0) {
                    throw new TimeoutCancellationException("Timed out immediately");
                }
                var6_6 = FlowKt.produceIn(FlowKt.buffer$default(var4_4 /* !! */ .$this_timeoutInternal, 0, null, 2, null), (CoroutineScope)var6_6);
                var2_5 = var4_4 /* !! */ .$timeout;
                while (true) {
                    var7_3 = new SelectImplementation<R>(var4_4 /* !! */ .getContext());
                    var8_8 = (SelectBuilder)var7_3;
                    var8_8.invoke(var6_6.getOnReceiveCatching(), (Function2)new Function2<ChannelResult<? extends T>, Continuation<? super Boolean>, Object>(var5_7, null){
                        final FlowCollector<T> $downStream;
                        Object L$0;
                        int label;
                        {
                            this.$downStream = flowCollector;
                            super(2, continuation);
                        }

                        public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                            object2 = new /* invalid duplicate definition of identical inner class */;
                            object2.L$0 = object;
                            return object2;
                        }

                        public final Object invoke-WpGqRn0(Object object, Continuation<? super Boolean> continuation) {
                            return (this.create(ChannelResult.box-impl(object), continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object object) {
                            Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 1: {
                                    Object object3 = this.L$0;
                                    ResultKt.throwOnFailure((Object)object);
                                    object = object3;
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)object);
                                    Object object4 = ((ChannelResult)this.L$0).unbox-impl();
                                    FlowCollector<Object> flowCollector = this.$downStream;
                                    object = object4;
                                    if (object4 instanceof ChannelResult.Failed) break;
                                    this.L$0 = object4;
                                    this.label = 1;
                                    if (flowCollector.emit(object4, (Continuation<Unit>)this) == object2) {
                                        return object2;
                                    }
                                    object = object4;
                                }
                            }
                            if (object instanceof ChannelResult.Closed) {
                                ChannelResult.exceptionOrNull-impl(object);
                                return Boxing.boxBoolean((boolean)false);
                            }
                            return Boxing.boxBoolean((boolean)true);
                        }
                    });
                    OnTimeoutKt.onTimeout-8Mi8wO0(var8_8, var2_5, (Function1)new Function1<Continuation<?>, Object>(var2_5, null){
                        final long $timeout;
                        int label;
                        {
                            this.$timeout = l;
                            super(1, continuation);
                        }

                        public final Continuation<Unit> create(Continuation<?> continuation) {
                            return (Continuation)new /* invalid duplicate definition of identical inner class */;
                        }

                        public final Object invoke(Continuation<?> continuation) {
                            return (this.create(continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object object) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 0: 
                            }
                            ResultKt.throwOnFailure((Object)object);
                            throw new TimeoutCancellationException("Timed out waiting for " + Duration.toString-impl((long)this.$timeout));
                        }
                    });
                    var4_4 /* !! */ .L$0 = var5_7;
                    var4_4 /* !! */ .L$1 = var6_6;
                    var4_4 /* !! */ .J$0 = var2_5;
                    var4_4 /* !! */ .label = 1;
                    var8_8 = var7_3.doSelect(var4_4 /* !! */ );
                    if (var8_8 == var9_2) {
                        return var9_2;
                    }
                    var7_3 = var4_4 /* !! */ ;
lbl37:
                    // 2 sources

                    if (!((Boolean)var8_8).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    var4_4 /* !! */  = var7_3;
                }
            }
        });
    }
}

