/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.IndexedValue
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.reflect.KClass
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filter$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNot$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$map$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001aM\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\b\u0004\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u001a\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0006\b\u0000\u0010\n\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0086\b\u001a,\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\n*\u00020\u0007*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f\u001aM\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\b\u0004\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u001a\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0007*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\u001ab\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u000123\b\u0004\u0010\u0010\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u001ah\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\n*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u000125\b\u0004\u0010\u0010\u001a/\b\u0001\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\n0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u001aH\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\"\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u001a|\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0019\u001a\u0002H\n2H\b\u0001\u0010\u001a\u001aB\b\u0001\u0012\u0013\u0012\u0011H\n\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001d\u001al\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012F\u0010\u001a\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001f\u001a|\u0010 \u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0019\u001a\u0002H\n2H\b\u0001\u0010\u001a\u001aB\b\u0001\u0012\u0013\u0012\u0011H\n\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001d\u001a\"\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\"0\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2={"filter", "Lkotlinx/coroutines/flow/Flow;", "T", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "filterIsInstance", "R", "klass", "Lkotlin/reflect/KClass;", "filterNot", "filterNotNull", "map", "transform", "Lkotlin/ParameterName;", "name", "value", "mapNotNull", "onEach", "action", "", "runningFold", "initial", "operation", "Lkotlin/Function3;", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "runningReduce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "scan", "withIndex", "Lkotlin/collections/IndexedValue;", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__TransformKt {
    public static final <T> Flow<T> filter(Flow<? extends T> flow2, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        flow2 = new Flow<T>(flow2, function2){
            final Function2 $predicate$inlined;
            final Flow $this_unsafeTransform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow2;
                this.$predicate$inlined = function2;
            }

            public Object collect(FlowCollector object, Continuation continuation) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new FlowCollector((FlowCollector)object, this.$predicate$inlined){
                    final Function2 $predicate$inlined;
                    final FlowCollector $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = flowCollector;
                        this.$predicate$inlined = function2;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                        block9: {
                            if (!(var2_2 /* !! */  instanceof filter$$inlined$unsafeTransform$1$2$1)) ** GOTO lbl-1000
                            var3_3 = var2_2 /* !! */ ;
                            if ((var3_3.label & -2147483648) != 0) {
                                var3_3.label += -2147483648;
                                var2_2 /* !! */  = var3_3;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                    Object L$0;
                                    Object L$1;
                                    int label;
                                    Object result;
                                    final filter$$inlined$unsafeTransform$1$2 this$0;
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
                            var4_4 /* !! */  = var2_2 /* !! */ .result;
                            var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (var2_2 /* !! */ .label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 2: {
                                    ResultKt.throwOnFailure((Object)var4_4 /* !! */ );
                                    break block9;
                                }
                                case 1: {
                                    var3_3 = (FlowCollector)var2_2 /* !! */ .L$1;
                                    var1_1 /* !! */  = var2_2 /* !! */ .L$0;
                                    ResultKt.throwOnFailure(var4_4 /* !! */ );
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)var4_4 /* !! */ );
                                    var3_3 = this.$this_unsafeFlow;
                                    var4_4 /* !! */  = var2_2 /* !! */ ;
                                    var4_4 /* !! */  = this.$predicate$inlined;
                                    var2_2 /* !! */ .L$0 = var1_1 /* !! */ ;
                                    var2_2 /* !! */ .L$1 = var3_3;
                                    var2_2 /* !! */ .label = 1;
                                    var4_4 /* !! */  = var4_4 /* !! */ .invoke(var1_1 /* !! */ , var2_2 /* !! */ );
                                    if (var4_4 /* !! */  != var5_5) break;
                                    return var5_5;
                                }
                            }
                            if (((Boolean)var4_4 /* !! */ ).booleanValue()) {
                                var2_2 /* !! */ .L$0 = null;
                                var2_2 /* !! */ .L$1 = null;
                                var2_2 /* !! */ .label = 2;
                                if (var3_3.emit(var1_1 /* !! */ , var2_2 /* !! */ ) == var5_5) {
                                    return var5_5;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    public final Object emit$$forInline(Object object, Continuation continuation) {
                        block0: {
                            InlineMarker.mark((int)4);
                            new /* invalid duplicate definition of identical inner class */;
                            InlineMarker.mark((int)5);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            if (!((Boolean)this.$predicate$inlined.invoke(object, (Object)continuation)).booleanValue()) break block0;
                            InlineMarker.mark((int)0);
                            flowCollector.emit(object, (Continuation<Unit>)continuation);
                            InlineMarker.mark((int)1);
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, continuation){
                    int label;
                    Object result;
                    final filter$$inlined$unsafeTransform$1 this$0;
                    {
                        this.this$0 = var1_1;
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect((FlowCollector)null, (Continuation)this);
                    }
                };
                InlineMarker.mark((int)5);
                Flow flow2 = this.$this_unsafeTransform$inlined;
                flowCollector = new /* invalid duplicate definition of identical inner class */;
                InlineMarker.mark((int)0);
                flow2.collect(flowCollector, (Continuation<Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        };
        return flow2;
    }

    public static final /* synthetic */ <R> Flow<R> filterIsInstance(Flow<?> flow2) {
        Intrinsics.needClassReification();
        flow2 = new Flow<Object>(flow2){
            final Flow $this_unsafeTransform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow2;
            }

            public Object collect(FlowCollector object, Continuation continuation) {
                Flow flow2 = this.$this_unsafeTransform$inlined;
                Intrinsics.needClassReification();
                object = flow2.collect(new FlowCollector((FlowCollector)object){
                    final FlowCollector $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Object var1_1, Continuation var2_2) {
                        if (!(var2_2 /* !! */  instanceof filterIsInstance$$inlined$filter$1$2$1)) ** GOTO lbl-1000
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
                                final filterIsInstance$$inlined$filter$1$2 this$0;
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
                                var5_5 = this.$this_unsafeFlow;
                                var4_4 = var2_2 /* !! */ ;
                                Intrinsics.reifiedOperationMarker((int)3, (String)"R");
                                if (!(var1_1 instanceof Object)) break;
                                var2_2 /* !! */ .label = 1;
                                if (var5_5.emit(var1_1, (Continuation<Unit>)var2_2 /* !! */ ) != var3_3 /* !! */ ) break;
                                return var3_3 /* !! */ ;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    public final Object emit$$forInline(Object object, Continuation continuation) {
                        block0: {
                            InlineMarker.mark((int)4);
                            new /* invalid duplicate definition of identical inner class */;
                            InlineMarker.mark((int)5);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            Continuation continuation2 = continuation;
                            Intrinsics.reifiedOperationMarker((int)3, (String)"R");
                            if (!(object instanceof Object)) break block0;
                            InlineMarker.mark((int)0);
                            flowCollector.emit(object, (Continuation<Unit>)continuation);
                            InlineMarker.mark((int)1);
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)continuation);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, continuation){
                    int label;
                    Object result;
                    final filterIsInstance$$inlined$filter$1 this$0;
                    {
                        this.this$0 = var1_1;
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect((FlowCollector)null, (Continuation)this);
                    }
                };
                InlineMarker.mark((int)5);
                Flow flow2 = this.$this_unsafeTransform$inlined;
                Intrinsics.needClassReification();
                flowCollector = new /* invalid duplicate definition of identical inner class */;
                InlineMarker.mark((int)0);
                flow2.collect(flowCollector, (Continuation<Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        };
        return flow2;
    }

    public static final <R> Flow<R> filterIsInstance(Flow<?> flow2, KClass<R> kClass) {
        flow2 = new Flow<Object>(flow2, kClass){
            final KClass $klass$inlined;
            final Flow $this_unsafeTransform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow2;
                this.$klass$inlined = kClass;
            }

            public Object collect(FlowCollector object, Continuation continuation) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new FlowCollector((FlowCollector)object, this.$klass$inlined){
                    final KClass $klass$inlined;
                    final FlowCollector $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = flowCollector;
                        this.$klass$inlined = kClass;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Object var1_1, Continuation var2_2) {
                        if (!(var2_2 /* !! */  instanceof filterIsInstance$$inlined$filter$2$2$1)) ** GOTO lbl-1000
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
                                final filterIsInstance$$inlined$filter$2$2 this$0;
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
                                var5_5 /* !! */  = var2_2 /* !! */ ;
                                if (!this.$klass$inlined.isInstance(var1_1)) break;
                                var2_2 /* !! */ .label = 1;
                                if (var4_4.emit(var1_1, (Continuation<? super Unit>)var2_2 /* !! */ ) != var3_3 /* !! */ ) break;
                                return var3_3 /* !! */ ;
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
        return flow2;
    }

    public static final <T> Flow<T> filterNot(Flow<? extends T> flow2, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        flow2 = new Flow<T>(flow2, function2){
            final Function2 $predicate$inlined;
            final Flow $this_unsafeTransform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow2;
                this.$predicate$inlined = function2;
            }

            public Object collect(FlowCollector object, Continuation continuation) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new FlowCollector((FlowCollector)object, this.$predicate$inlined){
                    final Function2 $predicate$inlined;
                    final FlowCollector $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = flowCollector;
                        this.$predicate$inlined = function2;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                        block9: {
                            if (!(var2_2 /* !! */  instanceof filterNot$$inlined$unsafeTransform$1$2$1)) ** GOTO lbl-1000
                            var3_3 = var2_2 /* !! */ ;
                            if ((var3_3.label & -2147483648) != 0) {
                                var3_3.label += -2147483648;
                                var2_2 /* !! */  = var3_3;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                    Object L$0;
                                    Object L$1;
                                    int label;
                                    Object result;
                                    final filterNot$$inlined$unsafeTransform$1$2 this$0;
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
                            var4_4 /* !! */  = var2_2 /* !! */ .result;
                            var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (var2_2 /* !! */ .label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 2: {
                                    ResultKt.throwOnFailure((Object)var4_4 /* !! */ );
                                    break block9;
                                }
                                case 1: {
                                    var3_3 = (FlowCollector)var2_2 /* !! */ .L$1;
                                    var1_1 /* !! */  = var2_2 /* !! */ .L$0;
                                    ResultKt.throwOnFailure(var4_4 /* !! */ );
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)var4_4 /* !! */ );
                                    var3_3 = this.$this_unsafeFlow;
                                    var4_4 /* !! */  = var2_2 /* !! */ ;
                                    var4_4 /* !! */  = this.$predicate$inlined;
                                    var2_2 /* !! */ .L$0 = var1_1 /* !! */ ;
                                    var2_2 /* !! */ .L$1 = var3_3;
                                    var2_2 /* !! */ .label = 1;
                                    var4_4 /* !! */  = var4_4 /* !! */ .invoke(var1_1 /* !! */ , var2_2 /* !! */ );
                                    if (var4_4 /* !! */  != var5_5) break;
                                    return var5_5;
                                }
                            }
                            if (!((Boolean)var4_4 /* !! */ ).booleanValue()) {
                                var2_2 /* !! */ .L$0 = null;
                                var2_2 /* !! */ .L$1 = null;
                                var2_2 /* !! */ .label = 2;
                                if (var3_3.emit(var1_1 /* !! */ , var2_2 /* !! */ ) == var5_5) {
                                    return var5_5;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    public final Object emit$$forInline(Object object, Continuation continuation) {
                        block0: {
                            InlineMarker.mark((int)4);
                            new /* invalid duplicate definition of identical inner class */;
                            InlineMarker.mark((int)5);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            if (((Boolean)this.$predicate$inlined.invoke(object, (Object)continuation)).booleanValue()) break block0;
                            InlineMarker.mark((int)0);
                            flowCollector.emit(object, (Continuation<Unit>)continuation);
                            InlineMarker.mark((int)1);
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, continuation){
                    int label;
                    Object result;
                    final filterNot$$inlined$unsafeTransform$1 this$0;
                    {
                        this.this$0 = var1_1;
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect((FlowCollector)null, (Continuation)this);
                    }
                };
                InlineMarker.mark((int)5);
                Flow flow2 = this.$this_unsafeTransform$inlined;
                flowCollector = new /* invalid duplicate definition of identical inner class */;
                InlineMarker.mark((int)0);
                flow2.collect(flowCollector, (Continuation<Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        };
        return flow2;
    }

    public static final <T> Flow<T> filterNotNull(Flow<? extends T> flow2) {
        flow2 = new Flow<T>(flow2){
            final Flow $this_unsafeTransform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow2;
            }

            public Object collect(FlowCollector object, Continuation continuation) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new FlowCollector((FlowCollector)object){
                    final FlowCollector $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                        if (!(var2_2 /* !! */  instanceof filterNotNull$$inlined$unsafeTransform$1$2$1)) ** GOTO lbl-1000
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
                                final filterNotNull$$inlined$unsafeTransform$1$2 this$0;
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
                                var5_5 /* !! */  = var2_2 /* !! */ ;
                                if (var1_1 == null) break;
                                var2_2 /* !! */ .label = 1;
                                if (var4_4.emit(var1_1, var2_2 /* !! */ ) != var3_3 /* !! */ ) break;
                                return var3_3 /* !! */ ;
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
        return flow2;
    }

    public static final <T, R> Flow<R> map(Flow<? extends T> flow2, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        flow2 = new Flow<R>(flow2, function2){
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
                    public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                        block9: {
                            if (!(var2_2 /* !! */  instanceof map$$inlined$unsafeTransform$1$2$1)) ** GOTO lbl-1000
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
                                    final map$$inlined$unsafeTransform$1$2 this$0;
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
                                    var4_5 /* !! */  = var2_2 /* !! */ ;
                                    var4_5 /* !! */  = this.$transform$inlined;
                                    var2_2 /* !! */ .L$0 = var3_3 /* !! */ ;
                                    var2_2 /* !! */ .label = 1;
                                    var4_5 /* !! */  = var4_5 /* !! */ .invoke((Object)var1_1 /* !! */ , var2_2 /* !! */ );
                                    if (var4_5 /* !! */  == var5_4) {
                                        return var5_4;
                                    }
                                    var1_1 /* !! */  = var3_3 /* !! */ ;
                                    var3_3 /* !! */  = var4_5 /* !! */ ;
                                }
                            }
                            var2_2 /* !! */ .L$0 = null;
                            var2_2 /* !! */ .label = 2;
                            if (var1_1 /* !! */ .emit(var3_3 /* !! */ , var2_2 /* !! */ ) == var5_4) {
                                return var5_4;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    public final Object emit$$forInline(Object object, Continuation continuation) {
                        InlineMarker.mark((int)4);
                        new /* invalid duplicate definition of identical inner class */;
                        InlineMarker.mark((int)5);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        object = this.$transform$inlined.invoke(object, (Object)continuation);
                        InlineMarker.mark((int)0);
                        flowCollector.emit(object, (Continuation<Unit>)continuation);
                        InlineMarker.mark((int)1);
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, continuation){
                    int label;
                    Object result;
                    final map$$inlined$unsafeTransform$1 this$0;
                    {
                        this.this$0 = var1_1;
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect((FlowCollector)null, (Continuation)this);
                    }
                };
                InlineMarker.mark((int)5);
                Flow flow2 = this.$this_unsafeTransform$inlined;
                flowCollector = new /* invalid duplicate definition of identical inner class */;
                InlineMarker.mark((int)0);
                flow2.collect(flowCollector, (Continuation<Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        };
        return flow2;
    }

    public static final <T, R> Flow<R> mapNotNull(Flow<? extends T> flow2, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        flow2 = new Flow<R>(flow2, function2){
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
                    public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                        block10: {
                            if (!(var2_2 /* !! */  instanceof mapNotNull$$inlined$unsafeTransform$1$2$1)) ** GOTO lbl-1000
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
                                    final mapNotNull$$inlined$unsafeTransform$1$2 this$0;
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
                            var5_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (var2_2 /* !! */ .label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 2: {
                                    ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                                    break block10;
                                }
                                case 1: {
                                    var4_5 /* !! */  = (Continuation<? super Unit>)var2_2 /* !! */ .L$0;
                                    ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                                    var1_1 /* !! */  = var3_3 /* !! */ ;
                                    var3_3 /* !! */  = var1_1 /* !! */ ;
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                                    var3_3 /* !! */  = this.$this_unsafeFlow;
                                    var4_5 /* !! */  = var2_2 /* !! */ ;
                                    var4_5 /* !! */  = this.$transform$inlined;
                                    var2_2 /* !! */ .L$0 = var3_3 /* !! */ ;
                                    var2_2 /* !! */ .label = 1;
                                    var4_5 /* !! */  = var4_5 /* !! */ .invoke(var1_1 /* !! */ , var2_2 /* !! */ );
                                    if (var4_5 /* !! */  == var5_4) {
                                        return var5_4;
                                    }
                                    var1_1 /* !! */  = var3_3 /* !! */ ;
                                    var3_3 /* !! */  = var4_5 /* !! */ ;
                                    var4_5 /* !! */  = var1_1 /* !! */ ;
                                }
                            }
                            if (var3_3 /* !! */  != null) {
                                var2_2 /* !! */ .L$0 = null;
                                var2_2 /* !! */ .label = 2;
                                if (var4_5 /* !! */ .emit(var3_3 /* !! */ , var2_2 /* !! */ ) == var5_4) {
                                    return var5_4;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    public final Object emit$$forInline(Object object, Continuation continuation) {
                        InlineMarker.mark((int)4);
                        new /* invalid duplicate definition of identical inner class */;
                        InlineMarker.mark((int)5);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        object = this.$transform$inlined.invoke(object, (Object)continuation);
                        if (object != null) {
                            InlineMarker.mark((int)0);
                            flowCollector.emit(object, (Continuation<Unit>)continuation);
                            InlineMarker.mark((int)1);
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, continuation){
                    int label;
                    Object result;
                    final mapNotNull$$inlined$unsafeTransform$1 this$0;
                    {
                        this.this$0 = var1_1;
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect((FlowCollector)null, (Continuation)this);
                    }
                };
                InlineMarker.mark((int)5);
                Flow flow2 = this.$this_unsafeTransform$inlined;
                flowCollector = new /* invalid duplicate definition of identical inner class */;
                InlineMarker.mark((int)0);
                flow2.collect(flowCollector, (Continuation<Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        };
        return flow2;
    }

    public static final <T> Flow<T> onEach(Flow<? extends T> flow2, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        flow2 = new Flow<T>(flow2, function2){
            final Function2 $action$inlined;
            final Flow $this_unsafeTransform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow2;
                this.$action$inlined = function2;
            }

            public Object collect(FlowCollector object, Continuation continuation) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new FlowCollector((FlowCollector)object, this.$action$inlined){
                    final Function2 $action$inlined;
                    final FlowCollector $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = flowCollector;
                        this.$action$inlined = function2;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                        block8: {
                            if (!(var2_2 /* !! */  instanceof onEach$$inlined$unsafeTransform$1$2$1)) ** GOTO lbl-1000
                            var3_3 = var2_2 /* !! */ ;
                            if ((var3_3.label & -2147483648) != 0) {
                                var3_3.label += -2147483648;
                                var2_2 /* !! */  = var3_3;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                    Object L$0;
                                    Object L$1;
                                    int label;
                                    Object result;
                                    final onEach$$inlined$unsafeTransform$1$2 this$0;
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
                            var5_4 /* !! */  = var2_2 /* !! */ .result;
                            var4_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (var2_2 /* !! */ .label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 2: {
                                    ResultKt.throwOnFailure((Object)var5_4 /* !! */ );
                                    break block8;
                                }
                                case 1: {
                                    var3_3 = (FlowCollector)var2_2 /* !! */ .L$1;
                                    var1_1 /* !! */  = var2_2 /* !! */ .L$0;
                                    ResultKt.throwOnFailure(var5_4 /* !! */ );
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)var5_4 /* !! */ );
                                    var3_3 = this.$this_unsafeFlow;
                                    var5_4 /* !! */  = var2_2 /* !! */ ;
                                    var5_4 /* !! */  = this.$action$inlined;
                                    var2_2 /* !! */ .L$0 = var1_1 /* !! */ ;
                                    var2_2 /* !! */ .L$1 = var3_3;
                                    var2_2 /* !! */ .label = 1;
                                    InlineMarker.mark((int)6);
                                    var5_4 /* !! */  = var5_4 /* !! */ .invoke(var1_1 /* !! */ , var2_2 /* !! */ );
                                    InlineMarker.mark((int)7);
                                    if (var5_4 /* !! */  != var4_5) break;
                                    return var4_5;
                                }
                            }
                            var2_2 /* !! */ .L$0 = null;
                            var2_2 /* !! */ .L$1 = null;
                            var2_2 /* !! */ .label = 2;
                            if (var3_3.emit(var1_1 /* !! */ , var2_2 /* !! */ ) == var4_5) {
                                return var4_5;
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
        return flow2;
    }

    public static final <T, R> Flow<R> runningFold(Flow<? extends T> flow2, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return new Flow<R>(r, flow2, function3){
            final Object $initial$inlined;
            final Function3 $operation$inlined;
            final Flow $this_runningFold$inlined;
            {
                this.$initial$inlined = object;
                this.$this_runningFold$inlined = flow2;
                this.$operation$inlined = function3;
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public Object collect(FlowCollector<? super R> var1_1, Continuation<? super Unit> var2_2) {
                block8: {
                    if (!(var2_2 /* !! */  instanceof runningFold$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
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
                            Object L$2;
                            int label;
                            Object result;
                            final runningFold$$inlined$unsafeFlow$1 this$0;
                            {
                                this.this$0 = var1_1;
                                super(continuation);
                            }

                            public final Object invokeSuspend(Object object) {
                                this.result = object;
                                this.label |= Integer.MIN_VALUE;
                                return this.this$0.collect(null, (Continuation<? super Unit>)((Continuation)this));
                            }
                        };
                    }
                    var5_4 = var2_2 /* !! */ .result;
                    var6_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (var2_2 /* !! */ .label) {
                        default: {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        case 2: {
                            ResultKt.throwOnFailure((Object)var5_4);
                            break block8;
                        }
                        case 1: {
                            var1_1 /* !! */  = (Ref.ObjectRef)var2_2 /* !! */ .L$2;
                            var4_6 /* !! */  = (FlowCollector)var2_2 /* !! */ .L$1;
                            var3_3 /* !! */  = var2_2 /* !! */ .L$0;
                            ResultKt.throwOnFailure((Object)var5_4);
                            break;
                        }
                        case 0: {
                            ResultKt.throwOnFailure((Object)var5_4);
                            var3_3 /* !! */  = this;
                            var4_6 /* !! */  = var2_2 /* !! */ ;
                            var5_4 = var1_1 /* !! */ ;
                            var1_1 /* !! */  = new Ref.ObjectRef();
                            var7_7 = var1_1 /* !! */ .element = var3_3 /* !! */ .$initial$inlined;
                            var2_2 /* !! */ .L$0 = var3_3 /* !! */ ;
                            var2_2 /* !! */ .L$1 = var5_4;
                            var2_2 /* !! */ .L$2 = var1_1 /* !! */ ;
                            var2_2 /* !! */ .label = 1;
                            var4_6 /* !! */  = var5_4;
                            if (var5_4.emit(var7_7, var2_2 /* !! */ ) != var6_5) break;
                            return var6_5;
                        }
                    }
                    var5_4 = var3_3 /* !! */ .$this_runningFold$inlined;
                    var1_1 /* !! */  = new FlowCollector(var1_1 /* !! */ , var3_3 /* !! */ .$operation$inlined, var4_6 /* !! */ ){
                        final Ref.ObjectRef<R> $accumulator;
                        final Function3<R, T, Continuation<? super R>, Object> $operation;
                        final FlowCollector<R> $this_unsafeFlow;
                        {
                            this.$accumulator = objectRef;
                            this.$operation = function3;
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /*
                         * Unable to fully structure code
                         * Could not resolve type clashes
                         */
                        public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                            block9: {
                                if (!(var2_2 /* !! */  instanceof runningFold.1.emit.1)) ** GOTO lbl-1000
                                var3_3 = var2_2 /* !! */ ;
                                if ((var3_3.label & -2147483648) != 0) {
                                    var3_3.label += -2147483648;
                                    var2_2 /* !! */  = var3_3;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                        Object L$0;
                                        Object L$1;
                                        int label;
                                        Object result;
                                        final runningFold.1.1<T> this$0;
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
                                var3_3 = var2_2 /* !! */ .result;
                                var5_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (var2_2 /* !! */ .label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 2: {
                                        ResultKt.throwOnFailure((Object)var3_3);
                                        break block9;
                                    }
                                    case 1: {
                                        var4_5 = (Ref.ObjectRef<R>)var2_2 /* !! */ .L$1;
                                        var1_1 /* !! */  = var2_2 /* !! */ .L$0;
                                        ResultKt.throwOnFailure((Object)var3_3);
                                        break;
                                    }
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)var3_3);
                                        var4_5 = this.$accumulator;
                                        var6_6 = this.$operation;
                                        var3_3 = this.$accumulator.element;
                                        var2_2 /* !! */ .L$0 = this;
                                        var2_2 /* !! */ .L$1 = var4_5;
                                        var2_2 /* !! */ .label = 1;
                                        var3_3 = var6_6.invoke(var3_3, var1_1 /* !! */ , var2_2 /* !! */ );
                                        if (var3_3 == var5_4) {
                                            return var5_4;
                                        }
                                        var1_1 /* !! */  = this;
                                    }
                                }
                                var4_5.element = var3_3;
                                var3_3 = var1_1 /* !! */ .$this_unsafeFlow;
                                var1_1 /* !! */  = var1_1 /* !! */ .$accumulator.element;
                                var2_2 /* !! */ .L$0 = null;
                                var2_2 /* !! */ .L$1 = null;
                                var2_2 /* !! */ .label = 2;
                                if (var3_3.emit(var1_1 /* !! */ , var2_2 /* !! */ ) == var5_4) {
                                    return var5_4;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    var2_2 /* !! */ .L$0 = null;
                    var2_2 /* !! */ .L$1 = null;
                    var2_2 /* !! */ .L$2 = null;
                    var2_2 /* !! */ .label = 2;
                    if (var5_4.collect(var1_1 /* !! */ , var2_2 /* !! */ ) == var6_5) {
                        return var6_5;
                    }
                }
                return Unit.INSTANCE;
            }
        };
    }

    public static final <T> Flow<T> runningReduce(Flow<? extends T> flow2, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        return new Flow<T>(flow2, function3){
            final Function3 $operation$inlined;
            final Flow $this_runningReduce$inlined;
            {
                this.$this_runningReduce$inlined = flow2;
                this.$operation$inlined = function3;
            }

            public Object collect(FlowCollector<? super T> object, Continuation<? super Unit> continuation) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = NullSurrogateKt.NULL;
                if ((object = this.$this_runningReduce$inlined.collect(new FlowCollector((Ref.ObjectRef<Object>)objectRef, this.$operation$inlined, object){
                    final Ref.ObjectRef<Object> $accumulator;
                    final Function3<T, T, Continuation<? super T>, Object> $operation;
                    final FlowCollector<T> $this_unsafeFlow;
                    {
                        this.$accumulator = objectRef;
                        this.$operation = function3;
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                        block9: {
                            block10: {
                                if (!(var2_2 /* !! */  instanceof runningReduce.1.emit.1)) ** GOTO lbl-1000
                                var4_3 = var2_2 /* !! */ ;
                                if ((var4_3.label & -2147483648) != 0) {
                                    var4_3.label += -2147483648;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    var4_3 = new ContinuationImpl(this, var2_2 /* !! */ ){
                                        Object L$0;
                                        Object L$1;
                                        int label;
                                        Object result;
                                        final runningReduce.1.1<T> this$0;
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
                                var2_2 /* !! */  = var4_3.result;
                                var6_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (var4_3.label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 2: {
                                        ResultKt.throwOnFailure(var2_2 /* !! */ );
                                        break block9;
                                    }
                                    case 1: {
                                        var3_5 = (Ref.ObjectRef<Object>)var4_3.L$1;
                                        var1_1 = var4_3.L$0;
                                        ResultKt.throwOnFailure(var2_2 /* !! */ );
                                        break;
                                    }
                                    case 0: {
                                        ResultKt.throwOnFailure(var2_2 /* !! */ );
                                        var2_2 /* !! */  = this;
                                        var3_5 = var2_2 /* !! */ .$accumulator;
                                        if (var2_2 /* !! */ .$accumulator.element == NullSurrogateKt.NULL) break block10;
                                        var7_6 = var2_2 /* !! */ .$operation;
                                        var5_7 /* !! */  = var2_2 /* !! */ .$accumulator.element;
                                        var4_3.L$0 = var2_2 /* !! */ ;
                                        var4_3.L$1 = var3_5;
                                        var4_3.label = 1;
                                        if ((var5_7 /* !! */  = var7_6.invoke(var5_7 /* !! */ , var1_1, (Object)var4_3)) == var6_4) {
                                            return var6_4;
                                        }
                                        var1_1 = var2_2 /* !! */ ;
                                        var2_2 /* !! */  = var5_7 /* !! */ ;
                                    }
                                }
                                var5_7 /* !! */  = var2_2 /* !! */ ;
                                var2_2 /* !! */  = var1_1;
                                var1_1 = var5_7 /* !! */ ;
                            }
                            var3_5.element = var1_1;
                            var1_1 = var2_2 /* !! */ .$this_unsafeFlow;
                            var2_2 /* !! */  = var2_2 /* !! */ .$accumulator.element;
                            var4_3.L$0 = null;
                            var4_3.L$1 = null;
                            var4_3.label = 2;
                            if (var1_1.emit(var2_2 /* !! */ , (Continuation<Unit>)var4_3) == var6_4) {
                                return var6_4;
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

    public static final <T, R> Flow<R> scan(Flow<? extends T> flow2, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt.runningFold(flow2, r, function3);
    }

    public static final <T> Flow<IndexedValue<T>> withIndex(Flow<? extends T> flow2) {
        return new Flow<IndexedValue<? extends T>>(flow2){
            final Flow $this_withIndex$inlined;
            {
                this.$this_withIndex$inlined = flow2;
            }

            public Object collect(FlowCollector<? super IndexedValue<? extends T>> object, Continuation<? super Unit> continuation) {
                Ref.IntRef intRef = new Ref.IntRef();
                if ((object = this.$this_withIndex$inlined.collect(new FlowCollector(object, intRef){
                    final Ref.IntRef $index;
                    final FlowCollector<IndexedValue<? extends T>> $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = flowCollector;
                        this.$index = intRef;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                        block7: {
                            if (!(var2_2 /* !! */  instanceof withIndex.1.emit.1)) ** GOTO lbl-1000
                            var4_3 /* !! */  = var2_2 /* !! */ ;
                            if ((var4_3 /* !! */ .label & -2147483648) != 0) {
                                var4_3 /* !! */ .label += -2147483648;
                                var2_2 /* !! */  = var4_3 /* !! */ ;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                    int label;
                                    Object result;
                                    final withIndex.1.1<T> this$0;
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
                            var5_4 = var2_2 /* !! */ .result;
                            var4_3 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (var2_2 /* !! */ .label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 1: {
                                    ResultKt.throwOnFailure((Object)var5_4);
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)var5_4);
                                    var5_4 = this.$this_unsafeFlow;
                                    var3_5 = this.$index.element;
                                    this.$index.element = var3_5 + 1;
                                    if (var3_5 >= 0) {
                                        var1_1 /* !! */  = new IndexedValue(var3_5, var1_1 /* !! */ );
                                        var2_2 /* !! */ .label = 1;
                                        if (var5_4.emit((IndexedValue<T>)var1_1 /* !! */ , (Continuation<Unit>)var2_2 /* !! */ ) != var4_3 /* !! */ ) break;
                                        return var4_3 /* !! */ ;
                                    }
                                    break block7;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        throw new ArithmeticException("Index overflow has happened");
                    }
                }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }
}

