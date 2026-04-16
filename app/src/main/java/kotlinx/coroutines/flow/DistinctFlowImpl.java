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
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Ref$ObjectRef
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.DistinctFlowImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002Be\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012:\u0010\u0007\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\b\u00a2\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013RD\u0010\u0007\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2={"Lkotlinx/coroutines/flow/DistinctFlowImpl;", "T", "Lkotlinx/coroutines/flow/Flow;", "upstream", "keySelector", "Lkotlin/Function1;", "", "areEquivalent", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "old", "new", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class DistinctFlowImpl<T>
implements Flow<T> {
    public final Function2<Object, Object, Boolean> areEquivalent;
    public final Function1<T, Object> keySelector;
    private final Flow<T> upstream;

    public DistinctFlowImpl(Flow<? extends T> flow2, Function1<? super T, ? extends Object> function1, Function2<Object, Object, Boolean> function2) {
        this.upstream = flow2;
        this.keySelector = function1;
        this.areEquivalent = function2;
    }

    @Override
    public Object collect(FlowCollector<? super T> object, Continuation<? super Unit> continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = NullSurrogateKt.NULL;
        if ((object = this.upstream.collect(new FlowCollector(this, (Ref.ObjectRef<Object>)objectRef, object){
            final FlowCollector<T> $collector;
            final Ref.ObjectRef<Object> $previousKey;
            final DistinctFlowImpl<T> this$0;
            {
                this.this$0 = distinctFlowImpl;
                this.$previousKey = objectRef;
                this.$collector = flowCollector;
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object emit(T var1_1, Continuation<? super Unit> var2_2) {
                block7: {
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
                            var4_4 = this.this$0.keySelector.invoke(var1_1);
                            if (this.$previousKey.element == NullSurrogateKt.NULL || !((Boolean)this.this$0.areEquivalent.invoke(this.$previousKey.element, var4_4)).booleanValue()) break block7;
                        }
                    }
lbl20:
                    // 3 sources

                    return Unit.INSTANCE;
                }
                this.$previousKey.element = var4_4;
                var4_4 = this.$collector;
                var2_2 /* !! */ .label = 1;
                ** while (var4_4.emit(var1_1, var2_2 /* !! */ ) != var3_3 /* !! */ )
lbl27:
                // 1 sources

                return var3_3 /* !! */ ;
            }
        }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }
}

