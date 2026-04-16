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
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.CancellableFlowImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2={"Lkotlinx/coroutines/flow/CancellableFlowImpl;", "T", "Lkotlinx/coroutines/flow/CancellableFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;)V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class CancellableFlowImpl<T>
implements CancellableFlow<T> {
    private final Flow<T> flow;

    public CancellableFlowImpl(Flow<? extends T> flow2) {
        this.flow = flow2;
    }

    @Override
    public Object collect(FlowCollector<? super T> object, Continuation<? super Unit> continuation) {
        if ((object = this.flow.collect(new FlowCollector(object){
            final FlowCollector<T> $collector;
            {
                this.$collector = flowCollector;
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                if (!(var2_2 /* !! */  instanceof collect.emit.1)) ** GOTO lbl-1000
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
                        final collect.2<T> this$0;
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
                        JobKt.ensureActive(var2_2 /* !! */ .getContext());
                        var4_4 = this.$collector;
                        var2_2 /* !! */ .label = 1;
                        if (var4_4.emit(var1_1, var2_2 /* !! */ ) != var3_3 /* !! */ ) break;
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
}

