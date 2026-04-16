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
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SubscribedFlowCollector;
import kotlinx.coroutines.flow.internal.SafeCollector;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BE\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00a2\u0006\u0002\b\t\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R:\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00a2\u0006\u0002\b\tX\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2={"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSubscription", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class SubscribedFlowCollector<T>
implements FlowCollector<T> {
    private final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> action;
    private final FlowCollector<T> collector;

    public SubscribedFlowCollector(FlowCollector<? super T> flowCollector, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.collector = flowCollector;
        this.action = function2;
    }

    @Override
    public Object emit(T t, Continuation<? super Unit> continuation) {
        return this.collector.emit(t, continuation);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final Object onSubscription(Continuation<? super Unit> var1_1) {
        block16: {
            if (!(var1_1 /* !! */  instanceof onSubscription.1)) ** GOTO lbl-1000
            var2_3 = var1_1 /* !! */ ;
            if ((var2_3.label & -2147483648) != 0) {
                var2_3.label += -2147483648;
                var1_1 /* !! */  = var2_3;
            } else lbl-1000:
            // 2 sources

            {
                var1_1 /* !! */  = new ContinuationImpl(this, var1_1 /* !! */ ){
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;
                    final SubscribedFlowCollector<T> this$0;
                    {
                        this.this$0 = subscribedFlowCollector;
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.onSubscription((Continuation<Unit>)((Continuation)this));
                    }
                };
            }
            var6_4 /* !! */  = var1_1 /* !! */ .result;
            var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var1_1 /* !! */ .label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 2: {
                    ResultKt.throwOnFailure((Object)var6_4 /* !! */ );
                    break block16;
                }
                case 1: {
                    var3_6 /* !! */  = (SafeCollector)var1_1 /* !! */ .L$1;
                    var4_7 = (SubscribedFlowCollector)var1_1 /* !! */ .L$0;
                    var2_3 = var3_6 /* !! */ ;
                    ResultKt.throwOnFailure((Object)var6_4 /* !! */ );
                    var2_3 = var3_6 /* !! */ ;
                    var3_6 /* !! */  = var4_7;
                    break;
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var6_4 /* !! */ );
                    var3_6 /* !! */  = this;
                    var4_8 = new SafeCollector<T>(var3_6 /* !! */ .collector, var1_1 /* !! */ .getContext());
                    var2_3 = var4_8;
                    var6_4 /* !! */  = var3_6 /* !! */ .action;
                    var2_3 = var4_8;
                    var1_1 /* !! */ .L$0 = var3_6 /* !! */ ;
                    var2_3 = var4_8;
                    var1_1 /* !! */ .L$1 = var4_8;
                    var2_3 = var4_8;
                    var1_1 /* !! */ .label = 1;
                    var2_3 = var4_8;
                    var6_4 /* !! */  = var6_4 /* !! */ .invoke(var4_8, var1_1 /* !! */ );
                    var2_3 = var4_8;
                    if (var6_4 /* !! */  != var5_5) break;
                    return var5_5;
                }
            }
            var2_3.releaseIntercepted();
            if (var3_6 /* !! */ .collector instanceof SubscribedFlowCollector) {
                var2_3 = (SubscribedFlowCollector)var3_6 /* !! */ .collector;
                var1_1 /* !! */ .L$0 = null;
                var1_1 /* !! */ .L$1 = null;
                var1_1 /* !! */ .label = 2;
                if (var2_3.onSubscription(var1_1 /* !! */ ) == var5_5) {
                    return var5_5;
                }
            }
        }
        return Unit.INSTANCE;
        catch (Throwable var1_2) {
            var2_3.releaseIntercepted();
            throw var1_2;
        }
    }
}

