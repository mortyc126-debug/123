/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SubscribedFlowCollector;
import kotlinx.coroutines.flow.SubscribedSharedFlow;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BE\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005\u00a2\u0006\u0002\b\n\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014R:\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005\u00a2\u0006\u0002\b\nX\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2={"Lkotlinx/coroutines/flow/SubscribedSharedFlow;", "T", "Lkotlinx/coroutines/flow/SharedFlow;", "sharedFlow", "action", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "collect", "", "collector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class SubscribedSharedFlow<T>
implements SharedFlow<T> {
    private final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> action;
    private final SharedFlow<T> sharedFlow;

    public SubscribedSharedFlow(SharedFlow<? extends T> sharedFlow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.sharedFlow = sharedFlow;
        this.action = function2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public Object collect(FlowCollector<? super T> var1_1, Continuation<?> var2_2) {
        if (!(var2_2 /* !! */  instanceof collect.1)) ** GOTO lbl-1000
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
                final SubscribedSharedFlow<T> this$0;
                {
                    this.this$0 = subscribedSharedFlow;
                    super(continuation);
                }

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.collect(null, (Continuation<?>)((Continuation)this));
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
                var4_4 = this.sharedFlow;
                var1_1 = new SubscribedFlowCollector<T>(var1_1, this.action);
                var2_2 /* !! */ .label = 1;
                if (var4_4.collect((FlowCollector<T>)var1_1, var2_2 /* !! */ ) != var3_3 /* !! */ ) break;
                return var3_3 /* !! */ ;
            }
        }
        throw new KotlinNothingValueException();
    }

    @Override
    public List<T> getReplayCache() {
        return this.sharedFlow.getReplayCache();
    }
}

