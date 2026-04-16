/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  kotlin.jvm.internal.Ref$IntRef
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__LimitKt;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$;
import kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$;
import kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$;
import kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aV\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000323\b\u0004\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005H\u0080H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u001a$\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f\u001aH\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001a+\u0010\u0012\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00132\u0006\u0010\b\u001a\u0002H\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a$\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f\u001aH\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001ap\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0019*\b\u0012\u0004\u0012\u0002H\u00020\u00032D\b\u0001\u0010\u001a\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190\u0013\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001b\u00a2\u0006\u0002\b\u001c\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2={"collectWhile", "", "T", "Lkotlinx/coroutines/flow/Flow;", "predicate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drop", "count", "", "dropWhile", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "emitAbort", "Lkotlinx/coroutines/flow/FlowCollector;", "emitAbort$FlowKt__LimitKt", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "take", "takeWhile", "transformWhile", "R", "transform", "Lkotlin/Function3;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__LimitKt {
    public static final /* synthetic */ Object access$emitAbort$FlowKt__LimitKt(FlowCollector flowCollector, Object object, Continuation continuation) {
        return FlowKt__LimitKt.emitAbort$FlowKt__LimitKt(flowCollector, object, (Continuation<? super Unit>)continuation);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T> Object collectWhile(Flow<? extends T> var0, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> var1_4, Continuation<? super Unit> var2_5) {
        block11: {
            if (!(var2_5 /* !! */  instanceof collectWhile.1)) ** GOTO lbl-1000
            var3_6 /* !! */  = var2_5 /* !! */ ;
            if ((var3_6 /* !! */ .label & -2147483648) != 0) {
                var3_6 /* !! */ .label += -2147483648;
                var2_5 /* !! */  = var3_6 /* !! */ ;
            } else lbl-1000:
            // 2 sources

            {
                var2_5 /* !! */  = new ContinuationImpl(var2_5 /* !! */ ){
                    Object L$0;
                    int label;
                    Object result;

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return FlowKt__LimitKt.collectWhile(null, null, (Continuation<? super Unit>)((Continuation)this));
                    }
                };
            }
            var4_7 = var2_5 /* !! */ .result;
            var3_6 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var2_5 /* !! */ .label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 1: {
                    var1_4 /* !! */  = var2_5 /* !! */ .L$0;
                    try {
                        ResultKt.throwOnFailure((Object)var4_7);
                    }
                    catch (AbortFlowException var0_1) {
                        break;
                    }
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var4_7);
                    var1_4 /* !! */  = new FlowCollector<T>(var1_4 /* !! */ ){
                        final Function2<T, Continuation<? super Boolean>, Object> $predicate;
                        {
                            this.$predicate = function2;
                        }

                        /*
                         * Unable to fully structure code
                         * Could not resolve type clashes
                         */
                        public Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                            if (!(var2_2 /* !! */  instanceof collectWhile.collector.emit.1)) ** GOTO lbl-1000
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
                                    final collectWhile.collector.1<T> this$0;
                                    {
                                        this.this$0 = var1_1;
                                        super(continuation);
                                    }

                                    public final Object invokeSuspend(Object object) {
                                        this.result = object;
                                        this.label |= Integer.MIN_VALUE;
                                        return this.this$0.emit(null, (Continuation<? super Unit>)((Continuation)this));
                                    }
                                };
                            }
                            var4_4 = var2_2 /* !! */ .result;
                            var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (var2_2 /* !! */ .label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 1: {
                                    var3_3 /* !! */  = var2_2 /* !! */ .L$0;
                                    ResultKt.throwOnFailure((Object)var4_4);
                                    var1_1 /* !! */  = var4_4;
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)var4_4);
                                    var3_3 /* !! */  = this;
                                    var4_4 = var3_3 /* !! */ .$predicate;
                                    var2_2 /* !! */ .L$0 = var3_3 /* !! */ ;
                                    var2_2 /* !! */ .label = 1;
                                    var2_2 /* !! */  = var4_4.invoke(var1_1 /* !! */ , var2_2 /* !! */ );
                                    var1_1 /* !! */  = var2_2 /* !! */ ;
                                    if (var2_2 /* !! */  != var5_5) break;
                                    return var5_5;
                                }
                            }
                            if (((Boolean)var1_1 /* !! */ ).booleanValue()) {
                                return Unit.INSTANCE;
                            }
                            throw new AbortFlowException((FlowCollector)var3_3 /* !! */ );
                        }

                        public Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
                            InlineMarker.mark((int)4);
                            new /* invalid duplicate definition of identical inner class */;
                            InlineMarker.mark((int)5);
                            if (((Boolean)this.$predicate.invoke(t, continuation)).booleanValue()) {
                                return Unit.INSTANCE;
                            }
                            throw new AbortFlowException(this);
                        }
                    };
                    try {
                        var4_7 = (FlowCollector)var1_4 /* !! */ ;
                        var2_5 /* !! */ .L$0 = var1_4 /* !! */ ;
                        var2_5 /* !! */ .label = 1;
                        var0 = var0.collect(var4_7, var2_5 /* !! */ );
                        if (var0 == var3_6 /* !! */ ) {
                            return var3_6 /* !! */ ;
                        }
                        break block11;
                    }
                    catch (AbortFlowException var0_2) {
                        // empty catch block
                    }
                }
            }
            FlowExceptions_commonKt.checkOwnership((AbortFlowException)var0_3, (FlowCollector)var1_4 /* !! */ );
        }
        return Unit.INSTANCE;
    }

    private static final <T> Object collectWhile$$forInline(Flow<? extends T> flow2, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> object, Continuation<? super Unit> continuation) {
        object = new /* invalid duplicate definition of identical inner class */;
        try {
            FlowCollector flowCollector = (FlowCollector)object;
            InlineMarker.mark((int)0);
            flow2.collect(flowCollector, continuation);
            InlineMarker.mark((int)1);
        }
        catch (AbortFlowException abortFlowException) {
            FlowExceptions_commonKt.checkOwnership(abortFlowException, (FlowCollector)object);
        }
        return Unit.INSTANCE;
    }

    public static final <T> Flow<T> drop(Flow<? extends T> flow2, int n) {
        boolean bl = n >= 0;
        if (bl) {
            return new Flow<T>(flow2, n){
                final int $count$inlined;
                final Flow $this_drop$inlined;
                {
                    this.$this_drop$inlined = flow2;
                    this.$count$inlined = n;
                }

                public Object collect(FlowCollector<? super T> object, Continuation<? super Unit> continuation) {
                    Ref.IntRef intRef = new Ref.IntRef();
                    if ((object = this.$this_drop$inlined.collect(new FlowCollector(intRef, this.$count$inlined, object){
                        final int $count;
                        final Ref.IntRef $skipped;
                        final FlowCollector<T> $this_unsafeFlow;
                        {
                            this.$skipped = intRef;
                            this.$count = n;
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /*
                         * Unable to fully structure code
                         * Could not resolve type clashes
                         */
                        public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                            block7: {
                                if (!(var2_2 /* !! */  instanceof drop.2.emit.1)) ** GOTO lbl-1000
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
                                        final drop.2.1<T> this$0;
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
                                        if (this.$skipped.element >= this.$count) {
                                            var5_4 = this.$this_unsafeFlow;
                                            var2_2 /* !! */ .label = 1;
                                            if (var5_4.emit(var1_1, var2_2 /* !! */ ) != var4_3 /* !! */ ) break;
                                            return var4_3 /* !! */ ;
                                        }
                                        break block7;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                            ++this.$skipped.element;
                            var3_5 = this.$skipped.element;
                            return Unit.INSTANCE;
                        }
                    }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return object;
                    }
                    return Unit.INSTANCE;
                }
            };
        }
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + n).toString());
    }

    public static final <T> Flow<T> dropWhile(Flow<? extends T> flow2, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new Flow<T>(flow2, function2){
            final Function2 $predicate$inlined;
            final Flow $this_dropWhile$inlined;
            {
                this.$this_dropWhile$inlined = flow2;
                this.$predicate$inlined = function2;
            }

            public Object collect(FlowCollector<? super T> object, Continuation<? super Unit> continuation) {
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                if ((object = this.$this_dropWhile$inlined.collect(new FlowCollector(booleanRef, object, this.$predicate$inlined){
                    final Ref.BooleanRef $matched;
                    final Function2<T, Continuation<? super Boolean>, Object> $predicate;
                    final FlowCollector<T> $this_unsafeFlow;
                    {
                        this.$matched = booleanRef;
                        this.$this_unsafeFlow = flowCollector;
                        this.$predicate = function2;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                        block10: {
                            block11: {
                                if (!(var2_2 /* !! */  instanceof dropWhile.1.emit.1)) ** GOTO lbl-1000
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
                                        final dropWhile.1.1<T> this$0;
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
                                var6_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (var2_2 /* !! */ .label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 2: {
                                        var1_1 /* !! */  = var2_2 /* !! */ .L$1;
                                        var3_3 = var2_2 /* !! */ .L$0;
                                        ResultKt.throwOnFailure((Object)var4_4 /* !! */ );
                                        break block10;
                                    }
                                    case 1: 
                                    case 3: {
                                        ResultKt.throwOnFailure((Object)var4_4 /* !! */ );
                                        break;
                                    }
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)var4_4 /* !! */ );
                                        var3_3 = this;
                                        if (var3_3.$matched.element) {
                                            var3_3 = var3_3.$this_unsafeFlow;
                                            var2_2 /* !! */ .label = 1;
                                            if (var3_3.emit(var1_1 /* !! */ , var2_2 /* !! */ ) != var6_5) break;
                                            return var6_5;
                                        }
                                        break block11;
                                    }
                                }
lbl30:
                                // 4 sources

                                return Unit.INSTANCE;
                            }
                            var4_4 /* !! */  = var3_3.$predicate;
                            var2_2 /* !! */ .L$0 = var3_3;
                            var2_2 /* !! */ .L$1 = var1_1 /* !! */ ;
                            var2_2 /* !! */ .label = 2;
                            var5_6 = var4_4 /* !! */ .invoke(var1_1 /* !! */ , var2_2 /* !! */ );
                            var4_4 /* !! */  = var5_6;
                            if (var5_6 == var6_5) {
                                return var6_5;
                            }
                        }
                        if (((Boolean)var4_4 /* !! */ ).booleanValue()) ** GOTO lbl30
                        var3_3.$matched.element = true;
                        var3_3 = var3_3.$this_unsafeFlow;
                        var2_2 /* !! */ .L$0 = null;
                        var2_2 /* !! */ .L$1 = null;
                        var2_2 /* !! */ .label = 3;
                        if (var3_3.emit(var1_1 /* !! */ , var2_2 /* !! */ ) == var6_5) ** break;
                        ** while (true)
                        return var6_5;
                    }
                }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static final <T> Object emitAbort$FlowKt__LimitKt(FlowCollector<? super T> var0, T var1_1, Continuation<? super Unit> var2_2) {
        if (!(var2_2 /* !! */  instanceof emitAbort.1)) ** GOTO lbl-1000
        var3_3 /* !! */  = var2_2 /* !! */ ;
        if ((var3_3 /* !! */ .label & -2147483648) != 0) {
            var3_3 /* !! */ .label += -2147483648;
            var2_2 /* !! */  = var3_3 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var2_2 /* !! */  = new ContinuationImpl(var2_2 /* !! */ ){
                Object L$0;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return FlowKt__LimitKt.access$emitAbort$FlowKt__LimitKt(null, null, (Continuation)this);
                }
            };
        }
        var5_4 = var2_2 /* !! */ .result;
        var4_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var2_2 /* !! */ .label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var3_3 /* !! */  = (FlowCollector)var2_2 /* !! */ .L$0;
                ResultKt.throwOnFailure((Object)var5_4);
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var5_4);
                var2_2 /* !! */ .L$0 = var0;
                var2_2 /* !! */ .label = 1;
                var3_3 /* !! */  = var0;
                if (var0.emit(var1_1, var2_2 /* !! */ ) != var4_5) break;
                return var4_5;
            }
        }
        throw new AbortFlowException((FlowCollector<?>)var3_3 /* !! */ );
    }

    public static final <T> Flow<T> take(Flow<? extends T> flow2, int n) {
        boolean bl = n > 0;
        if (bl) {
            return new Flow<T>(flow2, n){
                final int $count$inlined;
                final Flow $this_take$inlined;
                {
                    this.$this_take$inlined = flow2;
                    this.$count$inlined = n;
                }

                /*
                 * Unable to fully structure code
                 * Could not resolve type clashes
                 */
                public Object collect(FlowCollector<? super T> var1_1, Continuation<? super Unit> var2_2) {
                    block11: {
                        if (!(var2_2 /* !! */  instanceof take$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
                        var3_6 /* !! */  = var2_2 /* !! */ ;
                        if ((var3_6 /* !! */ .label & -2147483648) != 0) {
                            var3_6 /* !! */ .label += -2147483648;
                            var2_2 /* !! */  = var3_6 /* !! */ ;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                Object L$0;
                                int label;
                                Object result;
                                final take$$inlined$unsafeFlow$1 this$0;
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
                        var4_7 = var2_2 /* !! */ .result;
                        var3_6 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (var2_2 /* !! */ .label) {
                            default: {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            case 1: {
                                var1_1 = (FlowCollector)var2_2 /* !! */ .L$0;
                                try {
                                    ResultKt.throwOnFailure(var4_7);
                                }
                                catch (AbortFlowException var2_3) {
                                    break;
                                }
                            }
                            case 0: {
                                ResultKt.throwOnFailure((Object)var4_7);
                                var4_7 = var2_2 /* !! */ ;
                                var5_8 /* !! */  = new Ref.IntRef();
                                try {
                                    var4_7 = this.$this_take$inlined;
                                    var6_9 = new FlowCollector(var5_8 /* !! */ , this.$count$inlined, var1_1){
                                        final Ref.IntRef $consumed;
                                        final int $count;
                                        final FlowCollector<T> $this_unsafeFlow;
                                        {
                                            this.$consumed = intRef;
                                            this.$count = n;
                                            this.$this_unsafeFlow = flowCollector;
                                        }

                                        /*
                                         * Unable to fully structure code
                                         * Could not resolve type clashes
                                         */
                                        public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                                            block8: {
                                                if (!(var2_2 /* !! */  instanceof take.2.emit.1)) ** GOTO lbl-1000
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
                                                        final take.2.1<T> this$0;
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
                                                    case 1: 
                                                    case 2: {
                                                        ResultKt.throwOnFailure((Object)var4_4);
                                                        break;
                                                    }
                                                    case 0: {
                                                        ResultKt.throwOnFailure((Object)var4_4);
                                                        ++this.$consumed.element;
                                                        if (this.$consumed.element < this.$count) {
                                                            var4_4 = this.$this_unsafeFlow;
                                                            var2_2 /* !! */ .label = 1;
                                                            if (var4_4.emit(var1_1, var2_2 /* !! */ ) != var3_3 /* !! */ ) break;
                                                            return var3_3 /* !! */ ;
                                                        }
                                                        break block8;
                                                    }
                                                }
lbl25:
                                                // 3 sources

                                                return Unit.INSTANCE;
                                            }
                                            var4_4 = this.$this_unsafeFlow;
                                            var2_2 /* !! */ .label = 2;
                                            ** while (FlowKt__LimitKt.access$emitAbort$FlowKt__LimitKt(var4_4, var1_1, var2_2 /* !! */ ) != var3_3 /* !! */ )
lbl31:
                                            // 1 sources

                                            return var3_3 /* !! */ ;
                                        }
                                    };
                                    var5_8 /* !! */  = var6_9;
                                    var2_2 /* !! */ .L$0 = var1_1;
                                    var2_2 /* !! */ .label = 1;
                                    var2_2 /* !! */  = var4_7.collect((FlowCollector<? super Unit>)var5_8 /* !! */ , var2_2 /* !! */ );
                                    if (var2_2 /* !! */  == var3_6 /* !! */ ) {
                                        return var3_6 /* !! */ ;
                                    }
                                    break block11;
                                }
                                catch (AbortFlowException var2_4) {
                                    // empty catch block
                                }
                            }
                        }
                        FlowExceptions_commonKt.checkOwnership((AbortFlowException)var2_5, var1_1);
                    }
                    return Unit.INSTANCE;
                }
            };
        }
        throw new IllegalArgumentException(("Requested element count " + n + " should be positive").toString());
    }

    public static final <T> Flow<T> takeWhile(Flow<? extends T> flow2, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new Flow<T>(flow2, function2){
            final Function2 $predicate$inlined;
            final Flow $this_takeWhile$inlined;
            {
                this.$this_takeWhile$inlined = flow2;
                this.$predicate$inlined = function2;
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public Object collect(FlowCollector<? super T> var1_1, Continuation<? super Unit> var2_3) {
                block11: {
                    if (!(var2_3 /* !! */  instanceof takeWhile$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
                    var3_4 /* !! */  = var2_3 /* !! */ ;
                    if ((var3_4 /* !! */ .label & -2147483648) != 0) {
                        var3_4 /* !! */ .label += -2147483648;
                        var2_3 /* !! */  = var3_4 /* !! */ ;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var2_3 /* !! */  = new ContinuationImpl(this, var2_3 /* !! */ ){
                            Object L$0;
                            int label;
                            Object result;
                            final takeWhile$$inlined$unsafeFlow$1 this$0;
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
                    var4_6 = var2_3 /* !! */ .result;
                    var3_4 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (var2_3 /* !! */ .label) {
                        default: {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        case 1: {
                            var2_3 /* !! */  = var2_3 /* !! */ .L$0;
                            try {
                                ResultKt.throwOnFailure(var4_6);
                                break block11;
                            }
                            catch (AbortFlowException var1_2) {
                                var3_4 /* !! */  = var1_2;
                                break;
                            }
                        }
                        case 0: {
                            ResultKt.throwOnFailure((Object)var4_6);
                            var4_6 = var2_3 /* !! */ ;
                            var4_6 = this.$this_takeWhile$inlined;
                            var1_1 = new FlowCollector<T>(this.$predicate$inlined, var1_1){
                                final Function2 $predicate$inlined;
                                final FlowCollector $this_unsafeFlow$inlined;
                                {
                                    this.$predicate$inlined = function2;
                                    this.$this_unsafeFlow$inlined = flowCollector;
                                }

                                /*
                                 * Unable to fully structure code
                                 * Could not resolve type clashes
                                 */
                                public Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                                    block12: {
                                        if (!(var2_2 /* !! */  instanceof takeWhile$lambda$6$$inlined$collectWhile$1$1)) ** GOTO lbl-1000
                                        var5_3 = var2_2 /* !! */ ;
                                        if ((var5_3.label & -2147483648) != 0) {
                                            var5_3.label += -2147483648;
                                            var2_2 /* !! */  = var5_3;
                                        } else lbl-1000:
                                        // 2 sources

                                        {
                                            var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                                Object L$0;
                                                Object L$1;
                                                int label;
                                                Object result;
                                                final takeWhile$lambda$6$$inlined$collectWhile$1 this$0;
                                                {
                                                    this.this$0 = var1_1;
                                                    super(continuation);
                                                }

                                                public final Object invokeSuspend(Object object) {
                                                    this.result = object;
                                                    this.label |= Integer.MIN_VALUE;
                                                    return this.this$0.emit(null, (Continuation<? super Unit>)((Continuation)this));
                                                }
                                            };
                                        }
                                        var5_3 = var2_2 /* !! */ .result;
                                        var8_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        var4_5 = var2_2 /* !! */ .label;
                                        var3_6 = true;
                                        switch (var4_5) {
                                            default: {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            case 2: {
                                                var1_1 /* !! */  = var2_2 /* !! */ .L$0;
                                                ResultKt.throwOnFailure((Object)var5_3);
                                                break block12;
                                            }
                                            case 1: {
                                                var6_7 /* !! */  = var2_2 /* !! */ .L$1;
                                                var1_1 /* !! */  = var2_2 /* !! */ .L$0;
                                                ResultKt.throwOnFailure((Object)var5_3);
                                                var7_8 /* !! */  = var5_3;
                                                break;
                                            }
                                            case 0: {
                                                ResultKt.throwOnFailure((Object)var5_3);
                                                var5_3 = this;
                                                var6_7 /* !! */  = var2_2 /* !! */ ;
                                                var6_7 /* !! */  = var5_3.$predicate$inlined;
                                                var2_2 /* !! */ .L$0 = var5_3;
                                                var2_2 /* !! */ .L$1 = var1_1 /* !! */ ;
                                                var2_2 /* !! */ .label = 1;
                                                InlineMarker.mark((int)6);
                                                var7_8 /* !! */  = var6_7 /* !! */ .invoke(var1_1 /* !! */ , var2_2 /* !! */ );
                                                InlineMarker.mark((int)7);
                                                if (var7_8 /* !! */  == var8_4) {
                                                    return var8_4;
                                                }
                                                var6_7 /* !! */  = var1_1 /* !! */ ;
                                                var1_1 /* !! */  = var5_3;
                                            }
                                        }
                                        if (((Boolean)var7_8 /* !! */ ).booleanValue()) {
                                            var5_3 = var1_1 /* !! */ .$this_unsafeFlow$inlined;
                                            var2_2 /* !! */ .L$0 = var1_1 /* !! */ ;
                                            var2_2 /* !! */ .L$1 = null;
                                            var2_2 /* !! */ .label = 2;
                                            if (var5_3.emit(var6_7 /* !! */ , var2_2 /* !! */ ) == var8_4) {
                                                return var8_4;
                                            }
                                        } else {
                                            var3_6 = false;
                                        }
                                    }
                                    if (var3_6) {
                                        return Unit.INSTANCE;
                                    }
                                    throw new AbortFlowException((FlowCollector)var1_1 /* !! */ );
                                }
                            };
                            try {
                                var5_7 = var1_1;
                                var2_3 /* !! */ .L$0 = var1_1;
                                var2_3 /* !! */ .label = 1;
                                var2_3 /* !! */  = var4_6.collect(var5_7, var2_3 /* !! */ );
                                if (var2_3 /* !! */  == var3_4 /* !! */ ) {
                                    return var3_4 /* !! */ ;
                                }
                                break block11;
                            }
                            catch (AbortFlowException var3_5) {
                                var2_3 /* !! */  = var1_1;
                            }
                        }
                    }
                    FlowExceptions_commonKt.checkOwnership((AbortFlowException)var3_4 /* !! */ , (FlowCollector)var2_3 /* !! */ );
                }
                return Unit.INSTANCE;
            }
        };
    }

    public static final <T, R> Flow<R> transformWhile(Flow<? extends T> flow2, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(flow2, function3, null){
            final Flow<T> $this_transformWhile;
            final Function3<FlowCollector<? super R>, T, Continuation<? super Boolean>, Object> $transform;
            private Object L$0;
            int label;
            {
                this.$this_transformWhile = flow2;
                this.$transform = function3;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
                return (this.create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                block9: {
                    Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        default: {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        case 1: {
                            object2 = this.L$0;
                            try {
                                ResultKt.throwOnFailure((Object)object);
                                break block9;
                            }
                            catch (AbortFlowException abortFlowException) {
                                object = object2;
                                object2 = abortFlowException;
                                break;
                            }
                        }
                        case 0: {
                            ResultKt.throwOnFailure((Object)object);
                            FlowCollector flowCollector = (FlowCollector)this.L$0;
                            object = this.$this_transformWhile;
                            flowCollector = new FlowCollector<T>(this.$transform, flowCollector){
                                final FlowCollector $$this$flow$inlined;
                                final Function3 $transform$inlined;
                                {
                                    this.$transform$inlined = function3;
                                    this.$$this$flow$inlined = flowCollector;
                                }

                                /*
                                 * Unable to fully structure code
                                 * Could not resolve type clashes
                                 */
                                public Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                                    if (!(var2_2 /* !! */  instanceof transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1)) ** GOTO lbl-1000
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
                                            final transformWhile$1$invokeSuspend$$inlined$collectWhile$1 this$0;
                                            {
                                                this.this$0 = var1_1;
                                                super(continuation);
                                            }

                                            public final Object invokeSuspend(Object object) {
                                                this.result = object;
                                                this.label |= Integer.MIN_VALUE;
                                                return this.this$0.emit(null, (Continuation<? super Unit>)((Continuation)this));
                                            }
                                        };
                                    }
                                    var3_3 = var2_2 /* !! */ .result;
                                    var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (var2_2 /* !! */ .label) {
                                        default: {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        case 1: {
                                            var1_1 /* !! */  = var2_2 /* !! */ .L$0;
                                            ResultKt.throwOnFailure((Object)var3_3);
                                            var2_2 /* !! */  = var3_3;
                                            break;
                                        }
                                        case 0: {
                                            ResultKt.throwOnFailure((Object)var3_3);
                                            var3_3 = var2_2 /* !! */ ;
                                            var3_3 = this.$transform$inlined;
                                            var5_5 = this.$$this$flow$inlined;
                                            var2_2 /* !! */ .L$0 = this;
                                            var2_2 /* !! */ .label = 1;
                                            InlineMarker.mark((int)6);
                                            var2_2 /* !! */  = var3_3.invoke((Object)var5_5, var1_1 /* !! */ , var2_2 /* !! */ );
                                            InlineMarker.mark((int)7);
                                            if (var2_2 /* !! */  == var4_4) {
                                                return var4_4;
                                            }
                                            var1_1 /* !! */  = this;
                                        }
                                    }
                                    if (((Boolean)var2_2 /* !! */ ).booleanValue()) {
                                        return Unit.INSTANCE;
                                    }
                                    throw new AbortFlowException((FlowCollector)var1_1 /* !! */ );
                                }
                            };
                            try {
                                FlowCollector flowCollector2 = flowCollector;
                                Continuation continuation = (Continuation)this;
                                this.L$0 = flowCollector;
                                this.label = 1;
                                object = object.collect(flowCollector2, (Continuation<? super Unit>)continuation);
                                if (object == object2) {
                                    return object2;
                                }
                                break block9;
                            }
                            catch (AbortFlowException abortFlowException) {
                                object2 = abortFlowException;
                                object = flowCollector;
                            }
                        }
                    }
                    FlowExceptions_commonKt.checkOwnership((AbortFlowException)object2, (FlowCollector)object);
                }
                return Unit.INSTANCE;
            }
        });
    }
}

