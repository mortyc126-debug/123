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
 *  kotlin.jvm.internal.Ref$ObjectRef
 */
package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
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
import kotlinx.coroutines.flow.FlowKt__ReduceKt;
import kotlinx.coroutines.flow.FlowKt__ReduceKt$first$;
import kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata(d1={"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a!\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0003\u001aE\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u001a#\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0003\u001aG\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u001ay\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\r\u001a\u0002H\f2H\b\u0004\u0010\u000e\u001aB\b\u0001\u0012\u0013\u0012\u0011H\f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0001\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014\u001a!\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0003\u001a#\u0010\u0016\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0003\u001as\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u0018\"\b\b\u0001\u0010\u0001*\u0002H\u0018*\b\u0012\u0004\u0012\u0002H\u00010\u00022F\u0010\u000e\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0018\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u0001\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001a\u001a!\u0010\u001b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0003\u001a#\u0010\u001c\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2={"first", "T", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "acc", "value", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastOrNull", "reduce", "S", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "single", "singleOrNull", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ReduceKt {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T> Object first(Flow<? extends T> var0, Continuation<? super T> var1_2) {
        block12: {
            if (!(var1_2 instanceof first.1)) ** GOTO lbl-1000
            var2_4 /* !! */  = (ContinuationImpl)var1_2;
            if ((var2_4 /* !! */ .label & -2147483648) != 0) {
                var2_4 /* !! */ .label += -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                var2_4 /* !! */  = new ContinuationImpl((Continuation<? super first.1>)var1_2){
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return FlowKt.first(null, (Continuation)this);
                    }
                };
            }
            var1_2 = var2_4 /* !! */ .result;
            var4_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var2_4 /* !! */ .label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 1: {
                    var3_6 = var2_4 /* !! */ .L$1;
                    var0 = (Ref.ObjectRef)var2_4 /* !! */ .L$0;
                    try {
                        ResultKt.throwOnFailure((Object)var1_2);
                        break block12;
                    }
                    catch (AbortFlowException var1_3) {
                        var2_4 /* !! */  = var3_6;
                        var3_6 = var1_3;
                        break;
                    }
                }
                case 0: {
                    ResultKt.throwOnFailure(var1_2);
                    var1_2 = new Ref.ObjectRef();
                    var1_2.element = NullSurrogateKt.NULL;
                    var3_6 = new FlowCollector<T>(var1_2){
                        final Ref.ObjectRef $result$inlined;
                        {
                            this.$result$inlined = objectRef;
                        }

                        public Object emit(T t, Continuation<? super Unit> continuation) {
                            this.$result$inlined.element = t;
                            throw new AbortFlowException(this);
                        }
                    };
                    try {
                        var5_7 = (FlowCollector)var3_6;
                        var2_4 /* !! */ .L$0 = var1_2;
                        var2_4 /* !! */ .L$1 = var3_6;
                        var2_4 /* !! */ .label = 1;
                        var0 = var0.collect(var5_7, (Continuation<? super Unit>)var2_4 /* !! */ );
                        if (var0 == var4_5) {
                            return var4_5;
                        }
                        var0 = var1_2;
                        break block12;
                    }
                    catch (AbortFlowException var0_1) {
                        var2_4 /* !! */  = var3_6;
                        var3_6 = var0_1;
                        var0 = var1_2;
                    }
                }
            }
            FlowExceptions_commonKt.checkOwnership((AbortFlowException)var3_6, (FlowCollector)var2_4 /* !! */ );
        }
        if (var0.element != NullSurrogateKt.NULL) {
            return var0.element;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T> Object first(Flow<? extends T> var0, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> var1_1, Continuation<? super T> var2_2) {
        block12: {
            if (!(var2_2 /* !! */  instanceof first.3)) ** GOTO lbl-1000
            var3_3 /* !! */  = var2_2 /* !! */ ;
            if ((var3_3 /* !! */ .label & -2147483648) != 0) {
                var3_3 /* !! */ .label += -2147483648;
                var2_2 /* !! */  = var3_3 /* !! */ ;
            } else lbl-1000:
            // 2 sources

            {
                var2_2 /* !! */  = new ContinuationImpl(var2_2 /* !! */ ){
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return FlowKt.first(null, null, (Continuation)this);
                    }
                };
            }
            var3_3 /* !! */  = var2_2 /* !! */ .result;
            var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var2_2 /* !! */ .label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 1: {
                    var4_7 = var2_2 /* !! */ .L$2;
                    var0 = (Ref.ObjectRef)var2_2 /* !! */ .L$1;
                    var1_1 = (Function2)var2_2 /* !! */ .L$0;
                    try {
                        ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                        break block12;
                    }
                    catch (AbortFlowException var3_4) {
                        var2_2 /* !! */  = var4_7;
                        break;
                    }
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                    var3_3 /* !! */  = new Ref.ObjectRef();
                    var3_3 /* !! */ .element = NullSurrogateKt.NULL;
                    var4_8 = new FlowCollector<T>(var1_1, (Ref.ObjectRef)var3_3 /* !! */ ){
                        final Function2 $predicate$inlined;
                        final Ref.ObjectRef $result$inlined;
                        {
                            this.$predicate$inlined = function2;
                            this.$result$inlined = objectRef;
                        }

                        /*
                         * Unable to fully structure code
                         * Could not resolve type clashes
                         */
                        public Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                            if (!(var2_2 /* !! */  instanceof first$$inlined$collectWhile$2$1)) ** GOTO lbl-1000
                            var5_3 /* !! */  = var2_2 /* !! */ ;
                            if ((var5_3 /* !! */ .label & -2147483648) != 0) {
                                var5_3 /* !! */ .label += -2147483648;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var5_3 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                    Object L$0;
                                    Object L$1;
                                    int label;
                                    Object result;
                                    final first$$inlined$collectWhile$2 this$0;
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
                            var2_2 /* !! */  = var5_3 /* !! */ .result;
                            var7_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            var4_5 = var5_3 /* !! */ .label;
                            var3_6 = true;
                            switch (var4_5) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 1: {
                                    var7_4 = var5_3 /* !! */ .L$1;
                                    var6_7 = var5_3 /* !! */ .L$0;
                                    ResultKt.throwOnFailure(var2_2 /* !! */ );
                                    var1_1 /* !! */  = var2_2 /* !! */ ;
                                    var5_3 /* !! */  = var7_4;
                                    var2_2 /* !! */  = var6_7;
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure(var2_2 /* !! */ );
                                    var2_2 /* !! */  = this;
                                    var6_8 /* !! */  = (Continuation)var5_3 /* !! */ ;
                                    var6_8 /* !! */  = var2_2 /* !! */ .$predicate$inlined;
                                    var5_3 /* !! */ .L$0 = var2_2 /* !! */ ;
                                    var5_3 /* !! */ .L$1 = var1_1 /* !! */ ;
                                    var5_3 /* !! */ .label = 1;
                                    InlineMarker.mark((int)6);
                                    var6_8 /* !! */  = var6_8 /* !! */ .invoke(var1_1 /* !! */ , (Object)var5_3 /* !! */ );
                                    InlineMarker.mark((int)7);
                                    if (var6_8 /* !! */  == var7_4) {
                                        return var7_4;
                                    }
                                    var5_3 /* !! */  = var1_1 /* !! */ ;
                                    var1_1 /* !! */  = var6_8 /* !! */ ;
                                }
                            }
                            if (((Boolean)var1_1 /* !! */ ).booleanValue()) {
                                var2_2 /* !! */ .$result$inlined.element = var5_3 /* !! */ ;
                                var3_6 = false;
                            }
                            if (var3_6) {
                                return Unit.INSTANCE;
                            }
                            throw new AbortFlowException((FlowCollector)var2_2 /* !! */ );
                        }
                    };
                    try {
                        var6_9 = var4_8;
                        var2_2 /* !! */ .L$0 = var1_1;
                        var2_2 /* !! */ .L$1 = var3_3 /* !! */ ;
                        var2_2 /* !! */ .L$2 = var4_8;
                        var2_2 /* !! */ .label = 1;
                        var0 = var0.collect(var6_9, var2_2 /* !! */ );
                        if (var0 == var5_5) {
                            return var5_5;
                        }
                        var0 = var3_3 /* !! */ ;
                        break block12;
                    }
                    catch (AbortFlowException var5_6) {
                        var0 = var3_3 /* !! */ ;
                        var2_2 /* !! */  = var4_8;
                        var3_3 /* !! */  = var5_6;
                    }
                }
            }
            FlowExceptions_commonKt.checkOwnership((AbortFlowException)var3_3 /* !! */ , (FlowCollector)var2_2 /* !! */ );
        }
        if (var0.element != NullSurrogateKt.NULL) {
            return var0.element;
        }
        throw new NoSuchElementException("Expected at least one element matching the predicate " + var1_1);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T> Object firstOrNull(Flow<? extends T> var0, Continuation<? super T> var1_2) {
        block11: {
            if (!(var1_2 instanceof firstOrNull.1)) ** GOTO lbl-1000
            var2_3 /* !! */  = var1_2;
            if ((var2_3 /* !! */ .label & -2147483648) != 0) {
                var2_3 /* !! */ .label += -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                var2_3 /* !! */  = new ContinuationImpl((Continuation<? super firstOrNull.1>)var1_2){
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return FlowKt.firstOrNull(null, (Continuation)this);
                    }
                };
            }
            var3_4 = var2_3 /* !! */ .result;
            var4_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var2_3 /* !! */ .label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 1: {
                    var1_2 = var2_3 /* !! */ .L$1;
                    var0 = (Ref.ObjectRef)var2_3 /* !! */ .L$0;
                    try {
                        ResultKt.throwOnFailure((Object)var3_4);
                        break block11;
                    }
                    catch (AbortFlowException var3_5) {
                        var2_3 /* !! */  = var1_2;
                        break;
                    }
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var3_4);
                    var1_2 = new Ref.ObjectRef();
                    var3_4 = new FlowCollector<T>((Ref.ObjectRef)var1_2){
                        final Ref.ObjectRef $result$inlined;
                        {
                            this.$result$inlined = objectRef;
                        }

                        public Object emit(T t, Continuation<? super Unit> continuation) {
                            this.$result$inlined.element = t;
                            throw new AbortFlowException(this);
                        }
                    };
                    try {
                        var5_7 = (FlowCollector)var3_4;
                        var2_3 /* !! */ .L$0 = var1_2;
                        var2_3 /* !! */ .L$1 = var3_4;
                        var2_3 /* !! */ .label = 1;
                        var0 = var0.collect(var5_7, (Continuation<? super Unit>)var2_3 /* !! */ );
                        if (var0 == var4_6) {
                            return var4_6;
                        }
                        var0 = var1_2;
                        break block11;
                    }
                    catch (AbortFlowException var0_1) {
                        var2_3 /* !! */  = var3_4;
                        var3_4 = var0_1;
                        var0 = var1_2;
                    }
                }
            }
            FlowExceptions_commonKt.checkOwnership((AbortFlowException)var3_4, (FlowCollector)var2_3 /* !! */ );
        }
        return var0.element;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T> Object firstOrNull(Flow<? extends T> var0, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> var1_1, Continuation<? super T> var2_3) {
        block11: {
            if (!(var2_3 instanceof firstOrNull.3)) ** GOTO lbl-1000
            var3_4 = (ContinuationImpl)var2_3;
            if ((var3_4.label & -2147483648) != 0) {
                var3_4.label += -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                var3_4 = new ContinuationImpl((Continuation<? super firstOrNull.3>)var2_3){
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return FlowKt.firstOrNull(null, null, (Continuation)this);
                    }
                };
            }
            var5_6 = var3_4.result;
            var4_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var3_4.label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 1: {
                    var2_3 = var3_4.L$1;
                    var0 = (Ref.ObjectRef)var3_4.L$0;
                    try {
                        ResultKt.throwOnFailure((Object)var5_6);
                    }
                    catch (AbortFlowException var1_2) {
                        break;
                    }
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var5_6);
                    var2_3 = new Object();
                    var1_1 /* !! */  = new FlowCollector<T>(var1_1 /* !! */ , (Ref.ObjectRef)var2_3){
                        final Function2 $predicate$inlined;
                        final Ref.ObjectRef $result$inlined;
                        {
                            this.$predicate$inlined = function2;
                            this.$result$inlined = objectRef;
                        }

                        /*
                         * Unable to fully structure code
                         * Could not resolve type clashes
                         */
                        public Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                            if (!(var2_2 /* !! */  instanceof firstOrNull$$inlined$collectWhile$2$1)) ** GOTO lbl-1000
                            var5_3 /* !! */  = var2_2 /* !! */ ;
                            if ((var5_3 /* !! */ .label & -2147483648) != 0) {
                                var5_3 /* !! */ .label += -2147483648;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var5_3 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                    Object L$0;
                                    Object L$1;
                                    int label;
                                    Object result;
                                    final firstOrNull$$inlined$collectWhile$2 this$0;
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
                            var2_2 /* !! */  = var5_3 /* !! */ .result;
                            var6_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            var4_5 = var5_3 /* !! */ .label;
                            var3_6 = true;
                            switch (var4_5) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 1: {
                                    var1_1 /* !! */  = var5_3 /* !! */ .L$1;
                                    var6_4 = var5_3 /* !! */ .L$0;
                                    ResultKt.throwOnFailure(var2_2 /* !! */ );
                                    var5_3 /* !! */  = var2_2 /* !! */ ;
                                    var2_2 /* !! */  = var6_4;
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure(var2_2 /* !! */ );
                                    var2_2 /* !! */  = this;
                                    var7_7 = (Continuation)var5_3 /* !! */ ;
                                    var7_7 = var2_2 /* !! */ .$predicate$inlined;
                                    var5_3 /* !! */ .L$0 = var2_2 /* !! */ ;
                                    var5_3 /* !! */ .L$1 = var1_1 /* !! */ ;
                                    var5_3 /* !! */ .label = 1;
                                    InlineMarker.mark((int)6);
                                    var5_3 /* !! */  = var7_7.invoke(var1_1 /* !! */ , var5_3 /* !! */ );
                                    InlineMarker.mark((int)7);
                                    if (var5_3 /* !! */  != var6_4) break;
                                    return var6_4;
                                }
                            }
                            if (((Boolean)var5_3 /* !! */ ).booleanValue()) {
                                var2_2 /* !! */ .$result$inlined.element = var1_1 /* !! */ ;
                                var3_6 = false;
                            }
                            if (var3_6) {
                                return Unit.INSTANCE;
                            }
                            throw new AbortFlowException((FlowCollector)var2_2 /* !! */ );
                        }
                    };
                    try {
                        var5_6 = (FlowCollector)var1_1 /* !! */ ;
                        var3_4.L$0 = var2_3;
                        var3_4.L$1 = var1_1 /* !! */ ;
                        var3_4.label = 1;
                        var0 = var0.collect(var5_6, (Continuation<Unit>)var3_4);
                        if (var0 == var4_7) {
                            return var4_7;
                        }
                        var0 = var2_3;
                        break block11;
                    }
                    catch (AbortFlowException var3_5) {
                        var0 = var2_3;
                        var2_3 = var1_1 /* !! */ ;
                        var1_1 /* !! */  = var3_5;
                    }
                }
            }
            FlowExceptions_commonKt.checkOwnership(var1_1 /* !! */ , (FlowCollector)var2_3);
        }
        return var0.element;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T, R> Object fold(Flow<? extends T> var0, R var1_1, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> var2_2, Continuation<? super R> var3_3) {
        if (!(var3_3 /* !! */  instanceof fold.1)) ** GOTO lbl-1000
        var4_4 /* !! */  = var3_3 /* !! */ ;
        if ((var4_4 /* !! */ .label & -2147483648) != 0) {
            var4_4 /* !! */ .label += -2147483648;
            var3_3 /* !! */  = var4_4 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var3_3 /* !! */  = new ContinuationImpl(var3_3 /* !! */ ){
                Object L$0;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return FlowKt__ReduceKt.fold(null, null, null, (Continuation)this);
                }
            };
        }
        var4_4 /* !! */  = var3_3 /* !! */ .result;
        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var3_3 /* !! */ .label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var0 = (Ref.ObjectRef)var3_3 /* !! */ .L$0;
                ResultKt.throwOnFailure((Object)var4_4 /* !! */ );
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var4_4 /* !! */ );
                var4_4 /* !! */  = new Ref.ObjectRef();
                var4_4 /* !! */ .element = var1_1 /* !! */ ;
                var1_1 /* !! */  = new FlowCollector(var4_4 /* !! */ , var2_2){
                    final Ref.ObjectRef<R> $accumulator;
                    final Function3<R, T, Continuation<? super R>, Object> $operation;
                    {
                        this.$accumulator = objectRef;
                        this.$operation = function3;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof fold.emit.1)) ** GOTO lbl-1000
                        var3_3 = var2_2;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label += -2147483648;
                            var2_2 = var3_3;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var2_2 = new ContinuationImpl(this, (Continuation<? super fold.emit.1>)var2_2){
                                Object L$0;
                                int label;
                                Object result;
                                final fold.2<T> this$0;
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
                        var3_3 = var2_2.result;
                        var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (var2_2.label) {
                            default: {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            case 1: {
                                var2_2 = (Ref.ObjectRef<R>)var2_2.L$0;
                                ResultKt.throwOnFailure((Object)var3_3);
                                var1_1 /* !! */  = var3_3;
                                break;
                            }
                            case 0: {
                                ResultKt.throwOnFailure((Object)var3_3);
                                var3_3 = this.$accumulator;
                                var6_5 = this.$operation;
                                var5_6 = this.$accumulator.element;
                                var2_2.L$0 = var3_3;
                                var2_2.label = 1;
                                var1_1 /* !! */  = var6_5.invoke(var5_6, var1_1 /* !! */ , (Object)var2_2);
                                if (var1_1 /* !! */  == var4_4) {
                                    return var4_4;
                                }
                                var2_2 = var3_3;
                            }
                        }
                        var2_2.element = var1_1 /* !! */ ;
                        return Unit.INSTANCE;
                    }

                    public final Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
                        InlineMarker.mark((int)4);
                        new /* invalid duplicate definition of identical inner class */;
                        InlineMarker.mark((int)5);
                        this.$accumulator.element = this.$operation.invoke(this.$accumulator.element, t, continuation);
                        return Unit.INSTANCE;
                    }
                };
                var3_3 /* !! */ .L$0 = var4_4 /* !! */ ;
                var3_3 /* !! */ .label = 1;
                if (var0.collect(var1_1 /* !! */ , (Continuation<? super Unit>)var3_3 /* !! */ ) == var5_5) {
                    return var5_5;
                }
                var0 = var4_4 /* !! */ ;
            }
        }
        return var0.element;
    }

    private static final <T, R> Object fold$$forInline(Flow<? extends T> flow2, R object, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = object;
        object = new /* invalid duplicate definition of identical inner class */;
        InlineMarker.mark((int)0);
        flow2.collect((FlowCollector<T>)object, (Continuation<Unit>)continuation);
        InlineMarker.mark((int)1);
        return objectRef.element;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T> Object last(Flow<? extends T> var0, Continuation<? super T> var1_1) {
        if (!(var1_1 /* !! */  instanceof last.1)) ** GOTO lbl-1000
        var2_2 /* !! */  = var1_1 /* !! */ ;
        if ((var2_2 /* !! */ .label & -2147483648) != 0) {
            var2_2 /* !! */ .label += -2147483648;
            var1_1 /* !! */  = var2_2 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 /* !! */  = new ContinuationImpl(var1_1 /* !! */ ){
                Object L$0;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return FlowKt.last(null, (Continuation)this);
                }
            };
        }
        var2_2 /* !! */  = var1_1 /* !! */ .result;
        var3_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var1_1 /* !! */ .label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var0 = (Ref.ObjectRef)var1_1 /* !! */ .L$0;
                ResultKt.throwOnFailure((Object)var2_2 /* !! */ );
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var2_2 /* !! */ );
                var2_2 /* !! */  = new Ref.ObjectRef();
                var2_2 /* !! */ .element = NullSurrogateKt.NULL;
                var4_4 = new FlowCollector((Ref.ObjectRef<Object>)var2_2 /* !! */ ){
                    final Ref.ObjectRef<Object> $result;
                    {
                        this.$result = objectRef;
                    }

                    public final Object emit(T t, Continuation<? super Unit> continuation) {
                        this.$result.element = t;
                        return Unit.INSTANCE;
                    }
                };
                var1_1 /* !! */ .L$0 = var2_2 /* !! */ ;
                var1_1 /* !! */ .label = 1;
                if (var0.collect(var4_4, var1_1 /* !! */ ) == var3_3) {
                    return var3_3;
                }
                var0 = var2_2 /* !! */ ;
            }
        }
        if (var0.element != NullSurrogateKt.NULL) {
            return var0.element;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T> Object lastOrNull(Flow<? extends T> var0, Continuation<? super T> var1_1) {
        if (!(var1_1 /* !! */  instanceof lastOrNull.1)) ** GOTO lbl-1000
        var2_2 /* !! */  = var1_1 /* !! */ ;
        if ((var2_2 /* !! */ .label & -2147483648) != 0) {
            var2_2 /* !! */ .label += -2147483648;
            var1_1 /* !! */  = var2_2 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 /* !! */  = new ContinuationImpl(var1_1 /* !! */ ){
                Object L$0;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return FlowKt.lastOrNull(null, (Continuation)this);
                }
            };
        }
        var2_2 /* !! */  = var1_1 /* !! */ .result;
        var3_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var1_1 /* !! */ .label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var0 = (Ref.ObjectRef)var1_1 /* !! */ .L$0;
                ResultKt.throwOnFailure((Object)var2_2 /* !! */ );
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var2_2 /* !! */ );
                var2_2 /* !! */  = new Ref.ObjectRef();
                var4_4 = new FlowCollector(var2_2 /* !! */ ){
                    final Ref.ObjectRef<T> $result;
                    {
                        this.$result = objectRef;
                    }

                    public final Object emit(T t, Continuation<? super Unit> continuation) {
                        this.$result.element = t;
                        return Unit.INSTANCE;
                    }
                };
                var1_1 /* !! */ .L$0 = var2_2 /* !! */ ;
                var1_1 /* !! */ .label = 1;
                if (var0.collect(var4_4, var1_1 /* !! */ ) == var3_3) {
                    return var3_3;
                }
                var0 = var2_2 /* !! */ ;
            }
        }
        return var0.element;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <S, T extends S> Object reduce(Flow<? extends T> var0, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> var1_1, Continuation<? super S> var2_2) {
        if (!(var2_2 /* !! */  instanceof reduce.1)) ** GOTO lbl-1000
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
                    return FlowKt.reduce(null, null, (Continuation)this);
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
                var0 = (Ref.ObjectRef)var2_2 /* !! */ .L$0;
                ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                var3_3 /* !! */  = new Ref.ObjectRef();
                var3_3 /* !! */ .element = NullSurrogateKt.NULL;
                var1_1 /* !! */  = new FlowCollector((Ref.ObjectRef<Object>)var3_3 /* !! */ , var1_1 /* !! */ ){
                    final Ref.ObjectRef<Object> $accumulator;
                    final Function3<S, T, Continuation<? super S>, Object> $operation;
                    {
                        this.$accumulator = objectRef;
                        this.$operation = function3;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                        if (!(var2_2 /* !! */  instanceof reduce.emit.1)) ** GOTO lbl-1000
                        var3_3 = var2_2 /* !! */ ;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label += -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var3_3 = new ContinuationImpl(this, var2_2 /* !! */ ){
                                Object L$0;
                                int label;
                                Object result;
                                final reduce.2<T> this$0;
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
                        var2_2 /* !! */  = var3_3.result;
                        var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (var3_3.label) {
                            default: {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            case 1: {
                                var3_3 = (Ref.ObjectRef)var3_3.L$0;
                                ResultKt.throwOnFailure(var2_2 /* !! */ );
                                var1_1 /* !! */  = var2_2 /* !! */ ;
                                var2_2 /* !! */  = var3_3;
                                break;
                            }
                            case 0: {
                                ResultKt.throwOnFailure(var2_2 /* !! */ );
                                var2_2 /* !! */  = this.$accumulator;
                                if (this.$accumulator.element == NullSurrogateKt.NULL) break;
                                var6_5 = this.$operation;
                                var5_6 = this.$accumulator.element;
                                var3_3.L$0 = var2_2 /* !! */ ;
                                var3_3.label = 1;
                                if ((var1_1 /* !! */  = var6_5.invoke(var5_6, var1_1 /* !! */ , (Object)var3_3)) != var4_4) break;
                                return var4_4;
                            }
                        }
                        var2_2 /* !! */ .element = var1_1 /* !! */ ;
                        return Unit.INSTANCE;
                    }
                };
                var2_2 /* !! */ .L$0 = var3_3 /* !! */ ;
                var2_2 /* !! */ .label = 1;
                if (var0.collect(var1_1 /* !! */ , (Continuation<? super Unit>)var2_2 /* !! */ ) == var4_4) {
                    return var4_4;
                }
                var0 = var3_3 /* !! */ ;
            }
        }
        if (var0.element != NullSurrogateKt.NULL) {
            return var0.element;
        }
        throw new NoSuchElementException("Empty flow can't be reduced");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T> Object single(Flow<? extends T> var0, Continuation<? super T> var1_1) {
        if (!(var1_1 /* !! */  instanceof single.1)) ** GOTO lbl-1000
        var2_2 /* !! */  = var1_1 /* !! */ ;
        if ((var2_2 /* !! */ .label & -2147483648) != 0) {
            var2_2 /* !! */ .label += -2147483648;
            var1_1 /* !! */  = var2_2 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 /* !! */  = new ContinuationImpl(var1_1 /* !! */ ){
                Object L$0;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return FlowKt.single(null, (Continuation)this);
                }
            };
        }
        var2_2 /* !! */  = var1_1 /* !! */ .result;
        var3_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var1_1 /* !! */ .label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var0 = (Ref.ObjectRef)var1_1 /* !! */ .L$0;
                ResultKt.throwOnFailure((Object)var2_2 /* !! */ );
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var2_2 /* !! */ );
                var2_2 /* !! */  = new Ref.ObjectRef();
                var2_2 /* !! */ .element = NullSurrogateKt.NULL;
                var4_4 = new FlowCollector((Ref.ObjectRef<Object>)var2_2 /* !! */ ){
                    final Ref.ObjectRef<Object> $result;
                    {
                        this.$result = objectRef;
                    }

                    public final Object emit(T t, Continuation<? super Unit> continuation) {
                        boolean bl = this.$result.element == NullSurrogateKt.NULL;
                        if (bl) {
                            this.$result.element = t;
                            return Unit.INSTANCE;
                        }
                        throw new IllegalArgumentException("Flow has more than one element".toString());
                    }
                };
                var1_1 /* !! */ .L$0 = var2_2 /* !! */ ;
                var1_1 /* !! */ .label = 1;
                if (var0.collect(var4_4, var1_1 /* !! */ ) == var3_3) {
                    return var3_3;
                }
                var0 = var2_2 /* !! */ ;
            }
        }
        if (var0.element != NullSurrogateKt.NULL) {
            return var0.element;
        }
        throw new NoSuchElementException("Flow is empty");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T> Object singleOrNull(Flow<? extends T> var0, Continuation<? super T> var1_2) {
        block11: {
            if (!(var1_2 /* !! */  instanceof singleOrNull.1)) ** GOTO lbl-1000
            var2_4 /* !! */  = (ContinuationImpl)var1_2 /* !! */ ;
            if ((var2_4 /* !! */ .label & -2147483648) != 0) {
                var2_4 /* !! */ .label += -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                var2_4 /* !! */  = new ContinuationImpl((Continuation<? super singleOrNull.1>)var1_2 /* !! */ ){
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return FlowKt.singleOrNull(null, (Continuation)this);
                    }
                };
            }
            var1_2 /* !! */  = var2_4 /* !! */ .result;
            var4_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var2_4 /* !! */ .label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 1: {
                    var3_6 = var2_4 /* !! */ .L$1;
                    var0 = (Ref.ObjectRef)var2_4 /* !! */ .L$0;
                    try {
                        ResultKt.throwOnFailure((Object)var1_2 /* !! */ );
                        break block11;
                    }
                    catch (AbortFlowException var1_3) {
                        var2_4 /* !! */  = var3_6;
                        var3_6 = var1_3;
                        break;
                    }
                }
                case 0: {
                    ResultKt.throwOnFailure(var1_2 /* !! */ );
                    var1_2 /* !! */  = new Ref.ObjectRef();
                    var1_2 /* !! */ .element = NullSurrogateKt.NULL;
                    var3_6 = new FlowCollector<T>(var1_2 /* !! */ ){
                        final Ref.ObjectRef $result$inlined;
                        {
                            this.$result$inlined = objectRef;
                        }

                        public Object emit(T t, Continuation<? super Unit> continuation) {
                            boolean bl;
                            if (this.$result$inlined.element == NullSurrogateKt.NULL) {
                                this.$result$inlined.element = t;
                                bl = true;
                            } else {
                                this.$result$inlined.element = NullSurrogateKt.NULL;
                                bl = false;
                            }
                            if (bl) {
                                return Unit.INSTANCE;
                            }
                            throw new AbortFlowException(this);
                        }
                    };
                    try {
                        var5_7 = (FlowCollector)var3_6;
                        var2_4 /* !! */ .L$0 = var1_2 /* !! */ ;
                        var2_4 /* !! */ .L$1 = var3_6;
                        var2_4 /* !! */ .label = 1;
                        var0 = var0.collect(var5_7, (Continuation<? super Unit>)var2_4 /* !! */ );
                        if (var0 == var4_5) {
                            return var4_5;
                        }
                        var0 = var1_2 /* !! */ ;
                        break block11;
                    }
                    catch (AbortFlowException var0_1) {
                        var2_4 /* !! */  = var3_6;
                        var3_6 = var0_1;
                        var0 = var1_2 /* !! */ ;
                    }
                }
            }
            FlowExceptions_commonKt.checkOwnership((AbortFlowException)var3_6, (FlowCollector)var2_4 /* !! */ );
        }
        var0 = var0.element == NullSurrogateKt.NULL ? null : var0.element;
        return var0;
    }
}

