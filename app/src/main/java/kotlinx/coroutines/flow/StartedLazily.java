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
 *  kotlin.jvm.internal.Ref$BooleanRef
 */
package kotlinx.coroutines.flow;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingCommand;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StartedLazily;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2={"Lkotlinx/coroutines/flow/StartedLazily;", "Lkotlinx/coroutines/flow/SharingStarted;", "()V", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class StartedLazily
implements SharingStarted {
    @Override
    public Flow<SharingCommand> command(StateFlow<Integer> stateFlow) {
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super SharingCommand>, Continuation<? super Unit>, Object>(stateFlow, null){
            final StateFlow<Integer> $subscriptionCount;
            private Object L$0;
            int label;
            {
                this.$subscriptionCount = stateFlow;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, Continuation<? super Unit> continuation) {
                return (this.create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object stateFlow) {
                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)stateFlow);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)stateFlow);
                        FlowCollector flowCollector = (FlowCollector)this.L$0;
                        Object object2 = new Ref.BooleanRef();
                        stateFlow = this.$subscriptionCount;
                        object2 = new FlowCollector((Ref.BooleanRef)object2, flowCollector){
                            final FlowCollector<SharingCommand> $$this$flow;
                            final Ref.BooleanRef $started;
                            {
                                this.$started = booleanRef;
                                this.$$this$flow = flowCollector;
                            }

                            /*
                             * Unable to fully structure code
                             * Could not resolve type clashes
                             */
                            public final Object emit(int var1_1, Continuation<? super Unit> var2_2) {
                                if (!(var2_2 /* !! */  instanceof command.emit.1)) ** GOTO lbl-1000
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
                                        final command.1<T> this$0;
                                        {
                                            this.this$0 = var1_1;
                                            super(continuation);
                                        }

                                        public final Object invokeSuspend(Object object) {
                                            this.result = object;
                                            this.label |= Integer.MIN_VALUE;
                                            return this.this$0.emit(0, (Continuation<Unit>)((Continuation)this));
                                        }
                                    };
                                }
                                var4_4 /* !! */  = var2_2 /* !! */ .result;
                                var3_3 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (var2_2 /* !! */ .label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)var4_4 /* !! */ );
                                        break;
                                    }
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)var4_4 /* !! */ );
                                        if (var1_1 <= 0 || this.$started.element) break;
                                        this.$started.element = true;
                                        var5_5 = this.$$this$flow;
                                        var4_4 /* !! */  = SharingCommand.START;
                                        var2_2 /* !! */ .label = 1;
                                        if (var5_5.emit((SharingCommand)var4_4 /* !! */ , var2_2 /* !! */ ) != var3_3 /* !! */ ) break;
                                        return var3_3 /* !! */ ;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        flowCollector = (Continuation)this;
                        this.label = 1;
                        if (stateFlow.collect((FlowCollector<Integer>)object2, (Continuation<?>)flowCollector) != object) break;
                        return object;
                    }
                }
                throw new KotlinNothingValueException();
            }
        });
    }

    public String toString() {
        return "SharingStarted.Lazily";
    }
}

