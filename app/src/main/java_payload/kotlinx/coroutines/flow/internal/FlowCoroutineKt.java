/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 */
package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.FlowCoroutine;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(d1={"\u00000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012)\b\u0001\u0010\u0002\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u00a2\u0006\u0002\b\u0007H\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u001aS\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\n\"\u0004\b\u0000\u0010\u000125\b\u0001\u0010\u0002\u001a/\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b\u00a2\u0006\u0002\b\u0007H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2={"flowScope", "R", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scopedFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "(Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class FlowCoroutineKt {
    public static final <R> Object flowScope(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> object, Continuation<? super R> continuation) {
        FlowCoroutine<R> flowCoroutine = new FlowCoroutine<R>(continuation.getContext(), continuation);
        object = UndispatchedKt.startUndispatchedOrReturn((ScopeCoroutine)flowCoroutine, flowCoroutine, object);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return object;
    }

    public static final <R> Flow<R> scopedFlow(Function3<? super CoroutineScope, ? super FlowCollector<? super R>, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new Flow<R>(function3){
            final Function3 $block$inlined;
            {
                this.$block$inlined = function3;
            }

            public Object collect(FlowCollector<? super R> object, Continuation<? super Unit> continuation) {
                if ((object = FlowCoroutineKt.flowScope((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this.$block$inlined, object, null){
                    final Function3<CoroutineScope, FlowCollector<? super R>, Continuation<? super Unit>, Object> $block;
                    final FlowCollector<R> $this_unsafeFlow;
                    private Object L$0;
                    int label;
                    {
                        this.$block = function3;
                        this.$this_unsafeFlow = flowCollector;
                        super(2, continuation);
                    }

                    public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                        object2 = new /* invalid duplicate definition of identical inner class */;
                        object2.L$0 = object;
                        return object2;
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object function3) {
                        Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            default: {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            case 1: {
                                ResultKt.throwOnFailure((Object)function3);
                                break;
                            }
                            case 0: {
                                ResultKt.throwOnFailure((Object)function3);
                                CoroutineScope coroutineScope = (CoroutineScope)this.L$0;
                                function3 = this.$block;
                                FlowCollector<R> flowCollector = this.$this_unsafeFlow;
                                this.label = 1;
                                if (function3.invoke((Object)coroutineScope, flowCollector, (Object)((Object)this)) != object) break;
                                return object;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }
}

