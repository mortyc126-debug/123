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
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Ref$IntRef
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__CountKt;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004\u001aE\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2={"count", "", "T", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__CountKt {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T> Object count(Flow<? extends T> var0, Continuation<? super Integer> var1_1) {
        if (!(var1_1 /* !! */  instanceof count.1)) ** GOTO lbl-1000
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
                    return FlowKt.count(null, (Continuation<? super Integer>)((Continuation)this));
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
                var0 = (Ref.IntRef)var1_1 /* !! */ .L$0;
                ResultKt.throwOnFailure((Object)var2_2 /* !! */ );
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var2_2 /* !! */ );
                var2_2 /* !! */  = new Ref.IntRef();
                var4_4 = new FlowCollector((Ref.IntRef)var2_2 /* !! */ ){
                    final Ref.IntRef $i;
                    {
                        this.$i = intRef;
                    }

                    public final Object emit(T t, Continuation<? super Unit> continuation) {
                        ++this.$i.element;
                        int n = this.$i.element;
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
        return Boxing.boxInt((int)var0.element);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T> Object count(Flow<? extends T> var0, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> var1_1, Continuation<? super Integer> var2_2) {
        if (!(var2_2 /* !! */  instanceof count.3)) ** GOTO lbl-1000
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
                    return FlowKt.count(null, null, (Continuation<? super Integer>)((Continuation)this));
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
                var0 = (Ref.IntRef)var2_2 /* !! */ .L$0;
                ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                var3_3 /* !! */  = new Ref.IntRef();
                var1_1 /* !! */  = new FlowCollector(var1_1 /* !! */ , (Ref.IntRef)var3_3 /* !! */ ){
                    final Ref.IntRef $i;
                    final Function2<T, Continuation<? super Boolean>, Object> $predicate;
                    {
                        this.$predicate = function2;
                        this.$i = intRef;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                        if (!(var2_2 /* !! */  instanceof count.emit.1)) ** GOTO lbl-1000
                        var4_3 /* !! */  = var2_2 /* !! */ ;
                        if ((var4_3 /* !! */ .label & -2147483648) != 0) {
                            var4_3 /* !! */ .label += -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var4_3 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                Object L$0;
                                int label;
                                Object result;
                                final count.4<T> this$0;
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
                        var5_4 = var4_3 /* !! */ .result;
                        var6_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (var4_3 /* !! */ .label) {
                            default: {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            case 1: {
                                var2_2 /* !! */  = var4_3 /* !! */ .L$0;
                                ResultKt.throwOnFailure((Object)var5_4);
                                var1_1 /* !! */  = var5_4;
                                break;
                            }
                            case 0: {
                                ResultKt.throwOnFailure((Object)var5_4);
                                var2_2 /* !! */  = this;
                                var5_4 = var2_2 /* !! */ .$predicate;
                                var4_3 /* !! */ .L$0 = var2_2 /* !! */ ;
                                var4_3 /* !! */ .label = 1;
                                var4_3 /* !! */  = var5_4.invoke(var1_1 /* !! */ , (Object)var4_3 /* !! */ );
                                var1_1 /* !! */  = var4_3 /* !! */ ;
                                if (var4_3 /* !! */  != var6_5) break;
                                return var6_5;
                            }
                        }
                        if (((Boolean)var1_1 /* !! */ ).booleanValue()) {
                            ++var2_2 /* !! */ .$i.element;
                            var3_6 = var2_2 /* !! */ .$i.element;
                        }
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
        return Boxing.boxInt((int)var0.element);
    }
}

