/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ChannelsKt;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u001f\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0018\u001a\u00020 H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\t\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2={"Lkotlinx/coroutines/flow/ChannelAsFlow;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "channel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "consume", "", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "consumed", "Lkotlinx/atomicfu/AtomicBoolean;", "additionalToStringProps", "", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "dropChannelOperators", "Lkotlinx/coroutines/flow/Flow;", "markConsumed", "produceImpl", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class ChannelAsFlow<T>
extends ChannelFlow<T> {
    private static final AtomicIntegerFieldUpdater consumed$FU = AtomicIntegerFieldUpdater.newUpdater(ChannelAsFlow.class, "consumed");
    private final ReceiveChannel<T> channel;
    private final boolean consume;
    @Volatile
    private volatile int consumed;

    public ChannelAsFlow(ReceiveChannel<? extends T> receiveChannel, boolean bl, CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        super(coroutineContext, n, bufferOverflow);
        this.channel = receiveChannel;
        this.consume = bl;
        this.consumed = 0;
    }

    public /* synthetic */ ChannelAsFlow(ReceiveChannel receiveChannel, boolean bl, CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n2 & 8) != 0) {
            n = -3;
        }
        if ((n2 & 0x10) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        this(receiveChannel, bl, coroutineContext, n, bufferOverflow);
    }

    private final void markConsumed() {
        if (this.consume) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = consumed$FU;
            boolean bl = true;
            if (atomicIntegerFieldUpdater.getAndSet(this, 1) != 0) {
                bl = false;
            }
            if (!bl) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    @Override
    protected String additionalToStringProps() {
        return "channel=" + this.channel;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Object collect(FlowCollector<? super T> object, Continuation<? super Unit> continuation) {
        if (this.capacity == -3) {
            this.markConsumed();
            object = FlowKt__ChannelsKt.access$emitAllImpl$FlowKt__ChannelsKt((FlowCollector)object, this.channel, this.consume, continuation);
            if (object != IntrinsicsKt.getCOROUTINE_SUSPENDED()) return Unit.INSTANCE;
            return object;
        }
        if ((object = super.collect(object, continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) return Unit.INSTANCE;
        return object;
    }

    @Override
    protected Object collectTo(ProducerScope<? super T> object, Continuation<? super Unit> continuation) {
        if ((object = FlowKt__ChannelsKt.access$emitAllImpl$FlowKt__ChannelsKt(new SendingCollector((SendChannel)object), this.channel, this.consume, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    protected ChannelFlow<T> create(CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        return new ChannelAsFlow<T>(this.channel, this.consume, coroutineContext, n, bufferOverflow);
    }

    @Override
    public Flow<T> dropChannelOperators() {
        return new ChannelAsFlow<T>(this.channel, this.consume, null, 0, null, 28, null);
    }

    @Override
    public ReceiveChannel<T> produceImpl(CoroutineScope receiveChannel) {
        this.markConsumed();
        receiveChannel = this.capacity == -3 ? this.channel : super.produceImpl((CoroutineScope)((Object)receiveChannel));
        return receiveChannel;
    }
}

