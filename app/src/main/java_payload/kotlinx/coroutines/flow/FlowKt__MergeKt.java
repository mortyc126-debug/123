/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$;
import kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b2\u001e\u0010\f\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u000b0\n0\r\"\b\u0012\u0004\u0012\u0002H\u000b0\n\u00a2\u0006\u0002\u0010\u000e\u001ae\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u000b0\n27\u0010\u0011\u001a3\b\u0001\u0012\u0013\u0012\u0011H\u000b\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\u001ah\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u000b0\n29\b\u0005\u0010\u0011\u001a3\b\u0001\u0012\u0013\u0012\u0011H\u000b\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\u001ao\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u000b0\n2\b\b\u0002\u0010\u001b\u001a\u00020\u000127\u0010\u0011\u001a3\b\u0001\u0012\u0013\u0012\u0011H\u000b\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001a$\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\n0\nH\u0007\u001a.\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\n0\n2\b\b\u0002\u0010\u001b\u001a\u00020\u0001H\u0007\u001aa\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u000b0\n23\b\u0001\u0010\u0011\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u000b\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\u001a\"\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\n0 \u001ar\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u000b0\n2D\b\u0001\u0010\u0011\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100#\u0012\u0013\u0012\u0011H\u000b\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\"\u00a2\u0006\u0002\b%H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&\"\u001c\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087T\u00a2\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006'"}, d2={"DEFAULT_CONCURRENCY", "", "getDEFAULT_CONCURRENCY$annotations", "()V", "getDEFAULT_CONCURRENCY", "()I", "DEFAULT_CONCURRENCY_PROPERTY_NAME", "", "getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations", "merge", "Lkotlinx/coroutines/flow/Flow;", "T", "flows", "", "([Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "flatMapConcat", "R", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flatMapLatest", "flatMapMerge", "concurrency", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flattenConcat", "flattenMerge", "mapLatest", "", "transformLatest", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__MergeKt {
    private static final int DEFAULT_CONCURRENCY = SystemPropsKt.systemProp("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);

    public static final <T, R> Flow<R> flatMapConcat(Flow<? extends T> flow2, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        flow2 = new Flow<Flow<? extends R>>(flow2, function2){
            final Flow $this_unsafeTransform$inlined;
            final Function2 $transform$inlined$1;
            {
                this.$this_unsafeTransform$inlined = flow2;
                this.$transform$inlined$1 = function2;
            }

            public Object collect(FlowCollector object, Continuation continuation) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new FlowCollector((FlowCollector)object, this.$transform$inlined$1){
                    final FlowCollector $this_unsafeFlow;
                    final Function2 $transform$inlined;
                    {
                        this.$this_unsafeFlow = flowCollector;
                        this.$transform$inlined = function2;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Object var1_1, Continuation var2_2) {
                        block9: {
                            if (!(var2_2 /* !! */  instanceof flatMapConcat$$inlined$map$1$2$1)) ** GOTO lbl-1000
                            var3_3 /* !! */  = var2_2 /* !! */ ;
                            if ((var3_3 /* !! */ .label & -2147483648) != 0) {
                                var3_3 /* !! */ .label += -2147483648;
                                var2_2 /* !! */  = var3_3 /* !! */ ;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                    Object L$0;
                                    int label;
                                    Object result;
                                    final flatMapConcat$$inlined$map$1$2 this$0;
                                    {
                                        this.this$0 = var1_1;
                                        super(continuation);
                                    }

                                    public final Object invokeSuspend(Object object) {
                                        this.result = object;
                                        this.label |= Integer.MIN_VALUE;
                                        return this.this$0.emit((Object)null, (Continuation)this);
                                    }
                                };
                            }
                            var3_3 /* !! */  = var2_2 /* !! */ .result;
                            var5_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (var2_2 /* !! */ .label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 2: {
                                    ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                                    break block9;
                                }
                                case 1: {
                                    var1_1 /* !! */  = (FlowCollector)var2_2 /* !! */ .L$0;
                                    ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                                    var3_3 /* !! */  = this.$this_unsafeFlow;
                                    var4_5 /* !! */  = this.$transform$inlined;
                                    var2_2 /* !! */ .L$0 = var3_3 /* !! */ ;
                                    var2_2 /* !! */ .label = 1;
                                    var4_5 /* !! */  = var4_5 /* !! */ .invoke(var1_1 /* !! */ , (Object)var2_2 /* !! */ );
                                    if (var4_5 /* !! */  == var5_4) {
                                        return var5_4;
                                    }
                                    var1_1 /* !! */  = var3_3 /* !! */ ;
                                    var3_3 /* !! */  = var4_5 /* !! */ ;
                                }
                            }
                            var2_2 /* !! */ .L$0 = null;
                            var2_2 /* !! */ .label = 2;
                            if (var1_1 /* !! */ .emit(var3_3 /* !! */ , (Continuation<? super Unit>)var2_2 /* !! */ ) == var5_4) {
                                return var5_4;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
        return FlowKt.flattenConcat(flow2);
    }

    public static final <T, R> Flow<R> flatMapLatest(Flow<? extends T> flow2, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.transformLatest(flow2, (Function3)new Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object>(function2, null){
            final Function2<T, Continuation<? super Flow<? extends R>>, Object> $transform;
            private Object L$0;
            Object L$1;
            int label;
            {
                this.$transform = function2;
                super(3, continuation);
            }

            public final Object invoke(FlowCollector<? super R> flowCollector, T t, Continuation<? super Unit> object) {
                object = new /* invalid duplicate definition of identical inner class */;
                object.L$0 = flowCollector;
                object.L$1 = t;
                return object.invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                block6: {
                    Continuation continuation;
                    FlowCollector flowCollector;
                    Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        default: {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        case 2: {
                            ResultKt.throwOnFailure((Object)object);
                            break block6;
                        }
                        case 1: {
                            flowCollector = (FlowCollector)this.L$0;
                            ResultKt.throwOnFailure((Object)object);
                            break;
                        }
                        case 0: {
                            ResultKt.throwOnFailure((Object)object);
                            flowCollector = (FlowCollector)this.L$0;
                            object = this.L$1;
                            continuation = this.$transform;
                            this.L$0 = flowCollector;
                            this.label = 1;
                            object = continuation.invoke(object, (Object)((Object)this));
                            if (object != object2) break;
                            return object2;
                        }
                    }
                    object = (Flow)object;
                    continuation = (Continuation)this;
                    this.L$0 = null;
                    this.label = 2;
                    if (FlowKt.emitAll(flowCollector, object, (Continuation<? super Unit>)continuation) == object2) {
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }

            public final Object invokeSuspend$$forInline(Object object) {
                object = (FlowCollector)this.L$0;
                Object object2 = this.L$1;
                Flow flow2 = (Flow)this.$transform.invoke(object2, (Object)((Object)this));
                object2 = (Continuation)this;
                InlineMarker.mark((int)0);
                FlowKt.emitAll(object, flow2, (Continuation<? super Unit>)object2);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final <T, R> Flow<R> flatMapMerge(Flow<? extends T> flow2, int n, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        flow2 = new Flow<Flow<? extends R>>(flow2, function2){
            final Flow $this_unsafeTransform$inlined;
            final Function2 $transform$inlined$1;
            {
                this.$this_unsafeTransform$inlined = flow2;
                this.$transform$inlined$1 = function2;
            }

            public Object collect(FlowCollector object, Continuation continuation) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new FlowCollector((FlowCollector)object, this.$transform$inlined$1){
                    final FlowCollector $this_unsafeFlow;
                    final Function2 $transform$inlined;
                    {
                        this.$this_unsafeFlow = flowCollector;
                        this.$transform$inlined = function2;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Object var1_1, Continuation var2_2) {
                        block8: {
                            if (!(var2_2 /* !! */  instanceof flatMapMerge$$inlined$map$1$2$1)) ** GOTO lbl-1000
                            var3_3 = var2_2 /* !! */ ;
                            if ((var3_3.label & -2147483648) != 0) {
                                var3_3.label += -2147483648;
                                var2_2 /* !! */  = var3_3;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                    Object L$0;
                                    int label;
                                    Object result;
                                    final flatMapMerge$$inlined$map$1$2 this$0;
                                    {
                                        this.this$0 = var1_1;
                                        super(continuation);
                                    }

                                    public final Object invokeSuspend(Object object) {
                                        this.result = object;
                                        this.label |= Integer.MIN_VALUE;
                                        return this.this$0.emit((Object)null, (Continuation)this);
                                    }
                                };
                            }
                            var3_3 = var2_2 /* !! */ .result;
                            var5_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (var2_2 /* !! */ .label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 2: {
                                    ResultKt.throwOnFailure((Object)var3_3);
                                    break block8;
                                }
                                case 1: {
                                    var4_5 = (FlowCollector)var2_2 /* !! */ .L$0;
                                    ResultKt.throwOnFailure((Object)var3_3);
                                    var1_1 /* !! */  = var3_3;
                                    var3_3 = var4_5;
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)var3_3);
                                    var3_3 = this.$this_unsafeFlow;
                                    var4_6 = this.$transform$inlined;
                                    var2_2 /* !! */ .L$0 = var3_3;
                                    var2_2 /* !! */ .label = 1;
                                    var1_1 /* !! */  = var4_6.invoke(var1_1 /* !! */ , (Object)var2_2 /* !! */ );
                                    if (var1_1 /* !! */  != var5_4) break;
                                    return var5_4;
                                }
                            }
                            var2_2 /* !! */ .L$0 = null;
                            var2_2 /* !! */ .label = 2;
                            if (var3_3.emit(var1_1 /* !! */ , (Continuation<? super Unit>)var2_2 /* !! */ ) == var5_4) {
                                return var5_4;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
        return FlowKt.flattenMerge(flow2, n);
    }

    public static /* synthetic */ Flow flatMapMerge$default(Flow flow2, int n, Function2 function2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = DEFAULT_CONCURRENCY;
        }
        return FlowKt.flatMapMerge(flow2, n, function2);
    }

    public static final <T> Flow<T> flattenConcat(Flow<? extends Flow<? extends T>> flow2) {
        return new Flow<T>(flow2){
            final Flow $this_flattenConcat$inlined;
            {
                this.$this_flattenConcat$inlined = flow2;
            }

            public Object collect(FlowCollector<? super T> object, Continuation<? super Unit> continuation) {
                if ((object = this.$this_flattenConcat$inlined.collect(new FlowCollector(object){
                    final FlowCollector<T> $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Flow<? extends T> var1_1, Continuation<? super Unit> var2_2) {
                        if (!(var2_2 /* !! */  instanceof flattenConcat.1.emit.1)) ** GOTO lbl-1000
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
                                final flattenConcat.1.1<T> this$0;
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
                                var4_4 = this.$this_unsafeFlow;
                                var2_2 /* !! */ .label = 1;
                                if (FlowKt.emitAll(var4_4, var1_1, var2_2 /* !! */ ) != var3_3 /* !! */ ) break;
                                return var3_3 /* !! */ ;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }

    public static final <T> Flow<T> flattenMerge(Flow<? extends Flow<? extends T>> flow2, int n) {
        boolean bl = n > 0;
        if (bl) {
            flow2 = n == 1 ? FlowKt.flattenConcat(flow2) : (Flow)new ChannelFlowMerge(flow2, n, null, 0, null, 28, null);
            return flow2;
        }
        throw new IllegalArgumentException(("Expected positive concurrency level, but had " + n).toString());
    }

    public static /* synthetic */ Flow flattenMerge$default(Flow flow2, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = DEFAULT_CONCURRENCY;
        }
        return FlowKt.flattenMerge(flow2, n);
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return DEFAULT_CONCURRENCY;
    }

    public static /* synthetic */ void getDEFAULT_CONCURRENCY$annotations() {
    }

    public static /* synthetic */ void getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations() {
    }

    public static final <T, R> Flow<R> mapLatest(Flow<? extends T> flow2, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt.transformLatest(flow2, (Function3)new Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object>(function2, null){
            final Function2<T, Continuation<? super R>, Object> $transform;
            private Object L$0;
            Object L$1;
            int label;
            {
                this.$transform = function2;
                super(3, continuation);
            }

            public final Object invoke(FlowCollector<? super R> flowCollector, T t, Continuation<? super Unit> object) {
                object = new /* invalid duplicate definition of identical inner class */;
                object.L$0 = flowCollector;
                object.L$1 = t;
                return object.invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                block6: {
                    Object object2;
                    FlowCollector flowCollector;
                    Object object3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        default: {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        case 2: {
                            ResultKt.throwOnFailure((Object)object);
                            break block6;
                        }
                        case 1: {
                            flowCollector = (FlowCollector)this.L$0;
                            ResultKt.throwOnFailure((Object)object);
                            break;
                        }
                        case 0: {
                            ResultKt.throwOnFailure((Object)object);
                            flowCollector = (FlowCollector)this.L$0;
                            object2 = this.L$1;
                            object = this.$transform;
                            this.L$0 = flowCollector;
                            this.label = 1;
                            object = object.invoke(object2, (Object)((Object)this));
                            if (object != object3) break;
                            return object3;
                        }
                    }
                    object2 = (Continuation)this;
                    this.L$0 = null;
                    this.label = 2;
                    if (flowCollector.emit(object, (Continuation<Unit>)object2) == object3) {
                        return object3;
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    public static final <T> Flow<T> merge(Iterable<? extends Flow<? extends T>> iterable) {
        return new ChannelLimitedFlowMerge(iterable, null, 0, null, 14, null);
    }

    public static final <T> Flow<T> merge(Flow<? extends T> ... flowArray) {
        return FlowKt.merge(ArraysKt.asIterable((Object[])flowArray));
    }

    public static final <T, R> Flow<R> transformLatest(Flow<? extends T> flow2, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new ChannelFlowTransformLatest(function3, flow2, null, 0, null, 28, null);
    }
}

