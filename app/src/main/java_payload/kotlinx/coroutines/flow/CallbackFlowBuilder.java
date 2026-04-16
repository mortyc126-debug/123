/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.CallbackFlowBuilder;
import kotlinx.coroutines.flow.ChannelFlowBuilder;
import kotlinx.coroutines.flow.internal.ChannelFlow;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BU\u0012-\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004\u00a2\u0006\u0002\b\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R:\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004\u00a2\u0006\u0002\b\tX\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\n\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2={"Lkotlinx/coroutines/flow/CallbackFlowBuilder;", "T", "Lkotlinx/coroutines/flow/ChannelFlowBuilder;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlin/jvm/functions/Function2;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class CallbackFlowBuilder<T>
extends ChannelFlowBuilder<T> {
    private final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> block;

    public CallbackFlowBuilder(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2, CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        super(function2, coroutineContext, n, bufferOverflow);
        this.block = function2;
    }

    public /* synthetic */ CallbackFlowBuilder(Function2 function2, CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n2 & 4) != 0) {
            n = -2;
        }
        if ((n2 & 8) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        this(function2, coroutineContext, n, bufferOverflow);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    protected Object collectTo(ProducerScope<? super T> var1_1, Continuation<? super Unit> var2_2) {
        if (!(var2_2 /* !! */  instanceof collectTo.1)) ** GOTO lbl-1000
        var3_3 = var2_2 /* !! */ ;
        if ((var3_3.label & -2147483648) != 0) {
            var3_3.label += -2147483648;
            var2_2 /* !! */  = var3_3;
        } else lbl-1000:
        // 2 sources

        {
            var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                Object L$0;
                int label;
                Object result;
                final CallbackFlowBuilder<T> this$0;
                {
                    this.this$0 = callbackFlowBuilder;
                    super(continuation);
                }

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.collectTo(null, (Continuation<Unit>)((Continuation)this));
                }
            };
        }
        var5_4 = var2_2 /* !! */ .result;
        var4_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var2_2 /* !! */ .label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var3_3 = (ProducerScope)var2_2 /* !! */ .L$0;
                ResultKt.throwOnFailure((Object)var5_4);
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var5_4);
                var2_2 /* !! */ .L$0 = var1_1;
                var2_2 /* !! */ .label = 1;
                var3_3 = var1_1;
                if (super.collectTo(var1_1, var2_2 /* !! */ ) != var4_5) break;
                return var4_5;
            }
        }
        if (var3_3.isClosedForSend()) {
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    }

    @Override
    protected ChannelFlow<T> create(CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        return new CallbackFlowBuilder<T>(this.block, coroutineContext, n, bufferOverflow);
    }
}

