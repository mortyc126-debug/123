/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
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
 */
package kotlinx.coroutines.flow;

import kotlin.ExceptionsKt;
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
import kotlinx.coroutines.flow.FlowKt__EmittersKt;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$;
import kotlinx.coroutines.flow.ThrowingCollector;
import kotlinx.coroutines.flow.internal.SafeCollector;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0000\u001as\u0010\u0003\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00022D\u0010\u0005\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006\u00a2\u0006\u0002\b\r2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001aj\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0011\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00112D\u0010\u0005\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u001aS\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0011\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00112-\u0010\u0005\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0014\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015\u001aS\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0011\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00112-\u0010\u0005\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0014\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015\u001as\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00040\u00112D\b\u0005\u0010\u0017\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u0002\u0012\u0013\u0012\u0011H\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006\u00a2\u0006\u0002\b\rH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u001as\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00040\u00112D\b\u0005\u0010\u0017\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u0002\u0012\u0013\u0012\u0011H\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006\u00a2\u0006\u0002\b\rH\u0081\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2={"ensureActive", "", "Lkotlinx/coroutines/flow/FlowCollector;", "invokeSafely", "T", "action", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "invokeSafely$FlowKt__EmittersKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function3;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCompletion", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "onEmpty", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "onStart", "transform", "R", "value", "unsafeTransform", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__EmittersKt {
    public static final /* synthetic */ Object access$invokeSafely$FlowKt__EmittersKt(FlowCollector flowCollector, Function3 function3, Throwable throwable, Continuation continuation) {
        return FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(flowCollector, function3, throwable, (Continuation<? super Unit>)continuation);
    }

    public static final void ensureActive(FlowCollector<?> flowCollector) {
        if (!(flowCollector instanceof ThrowingCollector)) {
            return;
        }
        throw ((ThrowingCollector)flowCollector).e;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static final <T> Object invokeSafely$FlowKt__EmittersKt(FlowCollector<? super T> var0, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> var1_4, Throwable var2_5, Continuation<? super Unit> var3_6) {
        block11: {
            if (!(var3_6 /* !! */  instanceof invokeSafely.1)) ** GOTO lbl-1000
            var4_7 /* !! */  = var3_6 /* !! */ ;
            if ((var4_7 /* !! */ .label & -2147483648) != 0) {
                var4_7 /* !! */ .label += -2147483648;
                var3_6 /* !! */  = var4_7 /* !! */ ;
            } else lbl-1000:
            // 2 sources

            {
                var3_6 /* !! */  = new ContinuationImpl(var3_6 /* !! */ ){
                    Object L$0;
                    int label;
                    Object result;

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return FlowKt__EmittersKt.access$invokeSafely$FlowKt__EmittersKt(null, null, null, (Continuation)this);
                    }
                };
            }
            var4_7 /* !! */  = var3_6 /* !! */ .result;
            var5_8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var3_6 /* !! */ .label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 1: {
                    var1_4 /* !! */  = (Throwable)var3_6 /* !! */ .L$0;
                    try {
                        ResultKt.throwOnFailure((Object)var4_7 /* !! */ );
                        break;
                    }
                    catch (Throwable var0_1) {
                        break block11;
                    }
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var4_7 /* !! */ );
                    var3_6 /* !! */ .L$0 = var2_5;
                    var3_6 /* !! */ .label = 1;
                    var0 = var1_4 /* !! */ .invoke(var0, (Object)var2_5, var3_6 /* !! */ );
                    if (var0 != var5_8) break;
                    return var5_8;
                }
            }
            return Unit.INSTANCE;
            catch (Throwable var0_2) {
                var1_4 /* !! */  = var2_5;
            }
        }
        if (var1_4 /* !! */  != null && var1_4 /* !! */  != var0_3) {
            ExceptionsKt.addSuppressed((Throwable)var0_3, var1_4 /* !! */ );
        }
        throw var0_3;
    }

    public static final <T> Flow<T> onCompletion(Flow<? extends T> flow2, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new Flow<T>(flow2, function3){
            final Function3 $action$inlined;
            final Flow $this_onCompletion$inlined;
            {
                this.$this_onCompletion$inlined = flow2;
                this.$action$inlined = function3;
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public Object collect(FlowCollector<? super T> var1_1, Continuation<? super Unit> var2_2) {
                block22: {
                    block21: {
                        block20: {
                            if (!(var2_2 /* !! */  instanceof onCompletion$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
                            var3_7 = var2_2 /* !! */ ;
                            if ((var3_7.label & -2147483648) != 0) {
                                var3_7.label += -2147483648;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var3_7 = new ContinuationImpl(this, (Continuation)var2_2 /* !! */ ){
                                    Object L$0;
                                    Object L$1;
                                    int label;
                                    Object result;
                                    final onCompletion$$inlined$unsafeFlow$1 this$0;
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
                            var6_8 = var3_7.result;
                            var5_9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (var3_7.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 3: {
                                    var1_1 /* !! */  = (SafeCollector)var3_7.L$0;
                                    try {
                                        ResultKt.throwOnFailure((Object)var6_8);
                                        break block20;
                                    }
                                    catch (Throwable var2_3) {
                                        break block21;
                                    }
                                }
                                case 2: {
                                    var1_1 /* !! */  = (Throwable)var3_7.L$0;
                                    ResultKt.throwOnFailure((Object)var6_8);
                                    break block22;
                                }
                                case 1: {
                                    var4_10 = (FlowCollector)var3_7.L$1;
                                    var1_1 /* !! */  = var2_2 /* !! */  = var3_7.L$0;
                                    ResultKt.throwOnFailure((Object)var6_8);
                                    var1_1 /* !! */  = var4_10;
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)var6_8);
                                    var2_2 /* !! */  = this;
                                    var4_10 = (Continuation)var3_7;
                                    var4_10 = var1_1 /* !! */ ;
                                    var1_1 /* !! */  = var2_2 /* !! */ ;
                                    var6_8 = var2_2 /* !! */ .$this_onCompletion$inlined;
                                    var1_1 /* !! */  = var2_2 /* !! */ ;
                                    var3_7.L$0 = var2_2 /* !! */ ;
                                    var1_1 /* !! */  = var2_2 /* !! */ ;
                                    var3_7.L$1 = var4_10;
                                    var1_1 /* !! */  = var2_2 /* !! */ ;
                                    var3_7.label = 1;
                                    var1_1 /* !! */  = var2_2 /* !! */ ;
                                    var6_8 = var6_8.collect(var4_10, (Continuation<? super Unit>)var3_7);
                                    var1_1 /* !! */  = var4_10;
                                    if (var6_8 != var5_9) break;
                                    return var5_9;
                                }
                            }
                            var1_1 /* !! */  = new SafeCollector<Unit>((FlowCollector<? super Unit>)var1_1 /* !! */ , var3_7.getContext());
                            try {
                                var2_2 /* !! */  = var2_2 /* !! */ .$action$inlined;
                                var3_7.L$0 = var1_1 /* !! */ ;
                                var3_7.L$1 = null;
                                var3_7.label = 3;
                                InlineMarker.mark((int)6);
                                var2_2 /* !! */  = var2_2 /* !! */ .invoke((Object)var1_1 /* !! */ , null, (Object)var3_7);
                                InlineMarker.mark((int)7);
                                if (var2_2 /* !! */  != var5_9) break block20;
                                return var5_9;
                            }
                            catch (Throwable var2_4) {
                                // empty catch block
                            }
                        }
                        var1_1 /* !! */ .releaseIntercepted();
                        return Unit.INSTANCE;
                    }
                    var1_1 /* !! */ .releaseIntercepted();
                    throw var2_5;
                    catch (Throwable var2_6) {
                        var4_10 = new ThrowingCollector(var2_6);
                        var1_1 /* !! */  = var1_1 /* !! */ .$action$inlined;
                        var3_7.L$0 = var2_6;
                        var3_7.L$1 = null;
                        var3_7.label = 2;
                        if (FlowKt__EmittersKt.access$invokeSafely$FlowKt__EmittersKt((FlowCollector)var4_10, var1_1 /* !! */ , var2_6, (Continuation)var3_7) == var5_9) {
                            return var5_9;
                        }
                        var1_1 /* !! */  = var2_6;
                    }
                }
                throw var1_1 /* !! */ ;
            }
        };
    }

    public static final <T> Flow<T> onEmpty(Flow<? extends T> flow2, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new Flow<T>(flow2, function2){
            final Function2 $action$inlined;
            final Flow $this_onEmpty$inlined;
            {
                this.$this_onEmpty$inlined = flow2;
                this.$action$inlined = function2;
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public Object collect(FlowCollector<? super T> var1_1, Continuation<? super Unit> var2_2) {
                block13: {
                    block12: {
                        block11: {
                            if (!(var2_2 /* !! */  instanceof onEmpty$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
                            var3_5 = var2_2 /* !! */ ;
                            if ((var3_5.label & -2147483648) != 0) {
                                var3_5.label += -2147483648;
                                var2_2 /* !! */  = var3_5;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                    Object L$0;
                                    Object L$1;
                                    Object L$2;
                                    int label;
                                    Object result;
                                    final onEmpty$$inlined$unsafeFlow$1 this$0;
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
                            var6_6 = var2_2 /* !! */ .result;
                            var5_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (var2_2 /* !! */ .label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 2: {
                                    var1_1 = (SafeCollector)var2_2 /* !! */ .L$0;
                                    try {
                                        ResultKt.throwOnFailure((Object)var6_6);
                                        break block11;
                                    }
                                    catch (Throwable var2_3) {
                                        var3_5 = var1_1;
                                        var1_1 = var2_3;
                                        break block12;
                                    }
                                }
                                case 1: {
                                    var1_1 = (Ref.BooleanRef)var2_2 /* !! */ .L$2;
                                    var4_8 /* !! */  = (FlowCollector)var2_2 /* !! */ .L$1;
                                    var3_5 = var2_2 /* !! */ .L$0;
                                    ResultKt.throwOnFailure((Object)var6_6);
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)var6_6);
                                    var3_5 = this;
                                    var4_8 /* !! */  = var2_2 /* !! */ ;
                                    var4_8 /* !! */  = var1_1;
                                    var1_1 = new Ref.BooleanRef();
                                    var1_1.element = true;
                                    var7_9 = var3_5.$this_onEmpty$inlined;
                                    var6_6 = new FlowCollector((Ref.BooleanRef)var1_1, var4_8 /* !! */ ){
                                        final Ref.BooleanRef $isEmpty;
                                        final FlowCollector<T> $this_unsafeFlow;
                                        {
                                            this.$isEmpty = booleanRef;
                                            this.$this_unsafeFlow = flowCollector;
                                        }

                                        /*
                                         * Unable to fully structure code
                                         * Could not resolve type clashes
                                         */
                                        public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                                            if (!(var2_2 /* !! */  instanceof onEmpty.1.emit.1)) ** GOTO lbl-1000
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
                                                    final onEmpty.1.1<T> this$0;
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
                                                    this.$isEmpty.element = false;
                                                    var4_4 = this.$this_unsafeFlow;
                                                    var2_2 /* !! */ .label = 1;
                                                    if (var4_4.emit(var1_1, var2_2 /* !! */ ) != var3_3 /* !! */ ) break;
                                                    return var3_3 /* !! */ ;
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    var2_2 /* !! */ .L$0 = var3_5;
                                    var2_2 /* !! */ .L$1 = var4_8 /* !! */ ;
                                    var2_2 /* !! */ .L$2 = var1_1;
                                    var2_2 /* !! */ .label = 1;
                                    if (var7_9.collect(var6_6, var2_2 /* !! */ ) != var5_7) break;
                                    return var5_7;
                                }
                            }
                            if (!var1_1.element) break block13;
                            var1_1 = new SafeCollector<Unit>((FlowCollector<? super Unit>)var4_8 /* !! */ , var2_2 /* !! */ .getContext());
                            try {
                                var3_5 = var3_5.$action$inlined;
                                var2_2 /* !! */ .L$0 = var1_1;
                                var2_2 /* !! */ .L$1 = null;
                                var2_2 /* !! */ .L$2 = null;
                                var2_2 /* !! */ .label = 2;
                                InlineMarker.mark((int)6);
                                var2_2 /* !! */  = var3_5.invoke(var1_1, var2_2 /* !! */ );
                                InlineMarker.mark((int)7);
                                if (var2_2 /* !! */  != var5_7) break block11;
                                return var5_7;
                            }
                            catch (Throwable var2_4) {
                                var3_5 = var1_1;
                                var1_1 = var2_4;
                            }
                        }
                        var1_1.releaseIntercepted();
                        break block13;
                    }
                    var3_5.releaseIntercepted();
                    throw var1_1;
                }
                return Unit.INSTANCE;
            }
        };
    }

    public static final <T> Flow<T> onStart(Flow<? extends T> flow2, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new Flow<T>(function2, flow2){
            final Function2 $action$inlined;
            final Flow $this_onStart$inlined;
            {
                this.$action$inlined = function2;
                this.$this_onStart$inlined = flow2;
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public Object collect(FlowCollector<? super T> var1_1, Continuation<? super Unit> var2_2) {
                block18: {
                    if (!(var2_2 /* !! */  instanceof onStart$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
                    var3_4 = var2_2 /* !! */ ;
                    if ((var3_4.label & -2147483648) != 0) {
                        var3_4.label += -2147483648;
                        var2_2 /* !! */  = var3_4;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            int label;
                            Object result;
                            final onStart$$inlined$unsafeFlow$1 this$0;
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
                    var7_5 = var2_2 /* !! */ .result;
                    var6_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (var2_2 /* !! */ .label) {
                        default: {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        case 2: {
                            ResultKt.throwOnFailure((Object)var7_5);
                            break block18;
                        }
                        case 1: {
                            var3_4 = (SafeCollector)var2_2 /* !! */ .L$2;
                            var4_7 /* !! */  = (FlowCollector)var2_2 /* !! */ .L$1;
                            var5_8 = var2_2 /* !! */ .L$0;
                            var1_1 = var3_4;
                            ResultKt.throwOnFailure((Object)var7_5);
                            var1_1 = var3_4;
                            var3_4 = var5_8;
                            break;
                        }
                        case 0: {
                            ResultKt.throwOnFailure((Object)var7_5);
                            var3_4 = this;
                            var4_7 /* !! */  = var2_2 /* !! */ ;
                            var4_7 /* !! */  = var1_1;
                            var1_1 = var5_9 = new SafeCollector(var4_7 /* !! */ , var2_2 /* !! */ .getContext());
                            var7_5 = var3_4.$action$inlined;
                            var1_1 = var5_9;
                            var2_2 /* !! */ .L$0 = var3_4;
                            var1_1 = var5_9;
                            var2_2 /* !! */ .L$1 = var4_7 /* !! */ ;
                            var1_1 = var5_9;
                            var2_2 /* !! */ .L$2 = var5_9;
                            var1_1 = var5_9;
                            var2_2 /* !! */ .label = 1;
                            var1_1 = var5_9;
                            InlineMarker.mark((int)6);
                            var1_1 = var5_9;
                            var7_5 = var7_5.invoke(var5_9, var2_2 /* !! */ );
                            var1_1 = var5_9;
                            InlineMarker.mark((int)7);
                            var1_1 = var5_9;
                            if (var7_5 != var6_6) break;
                            return var6_6;
                        }
                    }
                    var1_1.releaseIntercepted();
                    var1_1 = var3_4.$this_onStart$inlined;
                    var2_2 /* !! */ .L$0 = null;
                    var2_2 /* !! */ .L$1 = null;
                    var2_2 /* !! */ .L$2 = null;
                    var2_2 /* !! */ .label = 2;
                    if (var1_1.collect(var4_7 /* !! */ , var2_2 /* !! */ ) == var6_6) {
                        return var6_6;
                    }
                }
                return Unit.INSTANCE;
                catch (Throwable var2_3) {
                    var1_1.releaseIntercepted();
                    throw var2_3;
                }
            }
        };
    }

    public static final <T, R> Flow<R> transform(Flow<? extends T> flow2, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(flow2, function3, null){
            final Flow<T> $this_transform;
            final Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> $transform;
            private Object L$0;
            int label;
            {
                this.$this_transform = flow2;
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
                        FlowCollector flowCollector = (FlowCollector)this.L$0;
                        flow2 = this.$this_transform;
                        flowCollector = new FlowCollector(this.$transform, flowCollector){
                            final FlowCollector<R> $$this$flow;
                            final Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> $transform;
                            {
                                this.$transform = function3;
                                this.$$this$flow = flowCollector;
                            }

                            /*
                             * Unable to fully structure code
                             * Could not resolve type clashes
                             */
                            public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                                if (!(var2_2 /* !! */  instanceof transform.emit.1)) ** GOTO lbl-1000
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
                                        final transform.1<T> this$0;
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
                                        var5_5 = this.$transform;
                                        var4_4 = this.$$this$flow;
                                        var2_2 /* !! */ .label = 1;
                                        if (var5_5.invoke(var4_4, var1_1, var2_2 /* !! */ ) != var3_3 /* !! */ ) break;
                                        return var3_3 /* !! */ ;
                                    }
                                }
                                return Unit.INSTANCE;
                            }

                            public final Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
                                InlineMarker.mark((int)4);
                                new /* invalid duplicate definition of identical inner class */;
                                InlineMarker.mark((int)5);
                                this.$transform.invoke(this.$$this$flow, t, continuation);
                                return Unit.INSTANCE;
                            }
                        };
                        Continuation continuation = (Continuation)this;
                        this.label = 1;
                        if (flow2.collect(flowCollector, (Continuation<Unit>)continuation) != object) break;
                        return object;
                    }
                }
                return Unit.INSTANCE;
            }

            public final Object invokeSuspend$$forInline(Object flow2) {
                FlowCollector flowCollector = (FlowCollector)this.L$0;
                flow2 = this.$this_transform;
                FlowCollector flowCollector2 = new /* invalid duplicate definition of identical inner class */;
                flowCollector = (Continuation)this;
                InlineMarker.mark((int)0);
                flow2.collect(flowCollector2, (Continuation<Unit>)flowCollector);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final <T, R> Flow<R> unsafeTransform(Flow<? extends T> flow2, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new Flow<R>(flow2, function3){
            final Flow $this_unsafeTransform$inlined;
            final Function3 $transform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow2;
                this.$transform$inlined = function3;
            }

            public Object collect(FlowCollector<? super R> object, Continuation<? super Unit> continuation) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new FlowCollector(this.$transform$inlined, object){
                    final FlowCollector<R> $this_unsafeFlow;
                    final Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> $transform;
                    {
                        this.$transform = function3;
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                        if (!(var2_2 /* !! */  instanceof unsafeTransform.1.emit.1)) ** GOTO lbl-1000
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
                                final unsafeTransform.1.1<T> this$0;
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
                                var5_5 = this.$transform;
                                var4_4 = this.$this_unsafeFlow;
                                var2_2 /* !! */ .label = 1;
                                if (var5_5.invoke(var4_4, var1_1, var2_2 /* !! */ ) != var3_3 /* !! */ ) break;
                                return var3_3 /* !! */ ;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    public final Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
                        InlineMarker.mark((int)4);
                        new /* invalid duplicate definition of identical inner class */;
                        InlineMarker.mark((int)5);
                        this.$transform.invoke(this.$this_unsafeFlow, t, continuation);
                        return Unit.INSTANCE;
                    }
                }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, continuation){
                    int label;
                    Object result;
                    final unsafeTransform$$inlined$unsafeFlow$1 this$0;
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
                InlineMarker.mark((int)5);
                Flow flow2 = this.$this_unsafeTransform$inlined;
                flowCollector = new /* invalid duplicate definition of identical inner class */;
                InlineMarker.mark((int)0);
                flow2.collect(flowCollector, (Continuation<Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        };
    }
}

