/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2={"flowWithLifecycle", "Lkotlinx/coroutines/flow/Flow;", "T", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "minActiveState", "Landroidx/lifecycle/Lifecycle$State;", "lifecycle-runtime-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class FlowExtKt {
    public static final <T> Flow<T> flowWithLifecycle(Flow<? extends T> flow2, Lifecycle lifecycle, Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(flow2, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)lifecycle, (String)"lifecycle");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"minActiveState");
        return FlowKt.callbackFlow((Function2)new Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object>(lifecycle, state, flow2, null){
            final Lifecycle $lifecycle;
            final Lifecycle.State $minActiveState;
            final Flow<T> $this_flowWithLifecycle;
            private Object L$0;
            int label;
            {
                this.$lifecycle = lifecycle;
                this.$minActiveState = state;
                this.$this_flowWithLifecycle = flow2;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        object2 = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)object);
                        object = object2;
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        object = (ProducerScope)this.L$0;
                        Lifecycle lifecycle = this.$lifecycle;
                        Lifecycle.State state = this.$minActiveState;
                        Function2 function2 = (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this.$this_flowWithLifecycle, object, null){
                            final ProducerScope<T> $$this$callbackFlow;
                            final Flow<T> $this_flowWithLifecycle;
                            int label;
                            {
                                this.$this_flowWithLifecycle = flow2;
                                this.$$this$callbackFlow = producerScope;
                                super(2, continuation);
                            }

                            public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                                return (Continuation)new /* invalid duplicate definition of identical inner class */;
                            }

                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object object) {
                                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)object);
                                        break;
                                    }
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)object);
                                        Flow<T> flow2 = this.$this_flowWithLifecycle;
                                        FlowCollector flowCollector = new FlowCollector(this.$$this$callbackFlow){
                                            final ProducerScope<T> $$this$callbackFlow;
                                            {
                                                this.$$this$callbackFlow = producerScope;
                                            }

                                            public final Object emit(T object, Continuation<? super Unit> continuation) {
                                                if ((object = this.$$this$callbackFlow.send(object, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                    return object;
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        object = (Continuation)this;
                                        this.label = 1;
                                        if (flow2.collect(flowCollector, (Continuation<Unit>)object) != object2) break;
                                        return object2;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        Continuation continuation = (Continuation)this;
                        this.L$0 = object;
                        this.label = 1;
                        if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>)function2, (Continuation<? super Unit>)continuation) != object2) break;
                        return object2;
                    }
                }
                SendChannel.DefaultImpls.close$default((SendChannel)object, null, 1, null);
                return Unit.INSTANCE;
            }
        });
    }

    public static /* synthetic */ Flow flowWithLifecycle$default(Flow flow2, Lifecycle lifecycle, Lifecycle.State state, int n, Object object) {
        if ((n & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return FlowExtKt.flowWithLifecycle(flow2, lifecycle, state);
    }
}

