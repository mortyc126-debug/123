/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Reflection
 */
package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelSegment;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\"\b\u0002\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n\u00a2\u0006\u0002\u0010\u000bJ\u001e\u0010\u000f\u001a\u00020\t2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0019\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00028\u0000H\u0090@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0015J\r\u0010\u0018\u001a\u00020\rH\u0010\u00a2\u0006\u0002\b\u0019J&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ.\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0002\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!J&\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u0000H\u0002\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010\u001dJ.\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0002\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006&"}, d2={"Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "isConflatedDropOldest", "", "()Z", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "element", "", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySendDropLatest", "isSendOp", "trySendDropLatest-Mj0NB7M", "(Ljava/lang/Object;Z)Ljava/lang/Object;", "trySendDropOldest", "trySendDropOldest-JP2dKIU", "trySendImpl", "trySendImpl-Mj0NB7M", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public class ConflatedBufferedChannel<E>
extends BufferedChannel<E> {
    private final int capacity;
    private final BufferOverflow onBufferOverflow;

    public ConflatedBufferedChannel(int n, BufferOverflow bufferOverflow, Function1<? super E, Unit> object) {
        super(n, object);
        this.capacity = n;
        this.onBufferOverflow = bufferOverflow;
        object = this.onBufferOverflow;
        bufferOverflow = BufferOverflow.SUSPEND;
        int n2 = 0;
        n = object != bufferOverflow ? 1 : 0;
        if (n != 0) {
            n = n2;
            if (this.capacity >= 1) {
                n = 1;
            }
            if (n != 0) {
                return;
            }
            throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + this.capacity + " was specified").toString());
        }
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead").toString());
    }

    public /* synthetic */ ConflatedBufferedChannel(int n, BufferOverflow bufferOverflow, Function1 function1, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            function1 = null;
        }
        this(n, bufferOverflow, function1);
    }

    static /* synthetic */ <E> Object send$suspendImpl(ConflatedBufferedChannel<E> conflatedBufferedChannel, E object, Continuation<? super Unit> object2) {
        object2 = super.trySendImpl-Mj0NB7M(object, true);
        if (object2 instanceof ChannelResult.Closed) {
            ChannelResult.exceptionOrNull-impl(object2);
            object2 = conflatedBufferedChannel.onUndeliveredElement;
            if (object2 != null && (object = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(object2, object, null, 2, null)) != null) {
                ExceptionsKt.addSuppressed((Throwable)((Throwable)object), (Throwable)conflatedBufferedChannel.getSendException());
                throw object;
            }
            throw conflatedBufferedChannel.getSendException();
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ <E> Object sendBroadcast$suspendImpl(ConflatedBufferedChannel<E> object, E e, Continuation<? super Boolean> continuation) {
        if (!((object = super.trySendImpl-Mj0NB7M(e, true)) instanceof ChannelResult.Failed)) {
            object = (Unit)object;
            return Boxing.boxBoolean((boolean)true);
        }
        return Boxing.boxBoolean((boolean)false);
    }

    private final Object trySendDropLatest-Mj0NB7M(E object, boolean bl) {
        Object object2 = super.trySend-JP2dKIU(object);
        if (!ChannelResult.isSuccess-impl(object2) && !ChannelResult.isClosed-impl(object2)) {
            if (bl && (object2 = this.onUndeliveredElement) != null && (object = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default((Function1)object2, object, null, 2, null)) != null) {
                throw object;
            }
            return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
        }
        return object2;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final Object trySendDropOldest-JP2dKIU(E object) {
        Symbol symbol = BufferedChannelKt.BUFFERED;
        boolean bl = false;
        ChannelSegment channelSegment = (ChannelSegment)BufferedChannel.access$getSendSegment$FU$p().get((BufferedChannel)this);
        block8: while (true) {
            long l = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement((BufferedChannel)this);
            long l2 = l & 0xFFFFFFFFFFFFFFFL;
            boolean bl2 = BufferedChannel.access$isClosedForSend0(this, l);
            l = l2 / (long)BufferedChannelKt.SEGMENT_SIZE;
            int n = (int)(l2 % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id != l) {
                ChannelSegment channelSegment2 = BufferedChannel.access$findSegmentSend(this, l, channelSegment);
                if (channelSegment2 == null) {
                    if (!bl2) continue;
                    return ChannelResult.Companion.closed-JP2dKIU(this.getSendException());
                }
                channelSegment = channelSegment2;
            }
            switch (BufferedChannel.access$updateCellSend(this, channelSegment, n, object, l2, symbol, bl2)) {
                default: {
                    continue block8;
                }
                case 5: {
                    channelSegment.cleanPrev();
                    continue block8;
                }
                case 4: {
                    if (l2 < ((BufferedChannel)this).getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    return ChannelResult.Companion.closed-JP2dKIU(this.getSendException());
                }
                case 3: {
                    throw new IllegalStateException("unexpected".toString());
                }
                case 2: {
                    void var1_4;
                    if (bl2) {
                        channelSegment.onSlotCleaned();
                        return ChannelResult.Companion.closed-JP2dKIU(this.getSendException());
                    }
                    if (symbol instanceof Waiter) {
                        Waiter waiter = (Waiter)((Object)symbol);
                    } else {
                        Object var1_3 = null;
                    }
                    if (var1_4 != null) {
                        BufferedChannel.access$prepareSenderForSuspension(this, (Waiter)var1_4, channelSegment, n);
                    }
                    this.dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(channelSegment.id * (long)BufferedChannelKt.SEGMENT_SIZE + (long)n);
                    return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
                }
                case 1: {
                    return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
                }
                case 0: 
            }
            break;
        }
        channelSegment.cleanPrev();
        return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
    }

    private final Object trySendImpl-Mj0NB7M(E object, boolean bl) {
        object = this.onBufferOverflow == BufferOverflow.DROP_LATEST ? this.trySendDropLatest-Mj0NB7M(object, bl) : this.trySendDropOldest-JP2dKIU(object);
        return object;
    }

    @Override
    protected boolean isConflatedDropOldest() {
        boolean bl = this.onBufferOverflow == BufferOverflow.DROP_OLDEST;
        return bl;
    }

    @Override
    protected void registerSelectForSend(SelectInstance<?> selectInstance, Object object) {
        if (!((object = this.trySend-JP2dKIU(object)) instanceof ChannelResult.Failed)) {
            object = (Unit)object;
            selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
            return;
        }
        if (object instanceof ChannelResult.Closed) {
            ChannelResult.exceptionOrNull-impl(object);
            selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
            return;
        }
        throw new IllegalStateException("unreachable".toString());
    }

    @Override
    public Object send(E e, Continuation<? super Unit> continuation) {
        return ConflatedBufferedChannel.send$suspendImpl(this, e, continuation);
    }

    @Override
    public Object sendBroadcast$kotlinx_coroutines_core(E e, Continuation<? super Boolean> continuation) {
        return ConflatedBufferedChannel.sendBroadcast$suspendImpl(this, e, continuation);
    }

    @Override
    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return false;
    }

    @Override
    public Object trySend-JP2dKIU(E e) {
        return this.trySendImpl-Mj0NB7M(e, false);
    }
}

