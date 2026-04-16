/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannelKt;
import kotlinx.coroutines.channels.ChannelSegment$$ExternalSyntheticBackportWithForwarding0;
import kotlinx.coroutines.channels.WaiterEB;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ)\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0000\u00a2\u0006\u0002\b\u0019J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\tH\u0000\u00a2\u0006\u0002\b\u001cJ!\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0000\u00a2\u0006\u0002\b\u001fJ\u0017\u0010 \u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\tH\u0000\u00a2\u0006\u0002\b$J\"\u0010%\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0016J\u0016\u0010*\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0015J\u0017\u0010,\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b-\u0010\"J\u001a\u0010.\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u0010H\u0002J\u001f\u00100\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u0010H\u0000\u00a2\u0006\u0002\b1J\u001f\u00102\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u00103\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b4\u00105R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004R\u0014\u0010\u0011\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u00066"}, d2={"Lkotlinx/coroutines/channels/ChannelSegment;", "E", "Lkotlinx/coroutines/internal/Segment;", "id", "", "prev", "channel", "Lkotlinx/coroutines/channels/BufferedChannel;", "pointers", "", "(JLkotlinx/coroutines/channels/ChannelSegment;Lkotlinx/coroutines/channels/BufferedChannel;I)V", "_channel", "getChannel", "()Lkotlinx/coroutines/channels/BufferedChannel;", "data", "Lkotlinx/atomicfu/AtomicArray;", "", "numberOfSlots", "getNumberOfSlots", "()I", "casState", "", "index", "from", "to", "casState$kotlinx_coroutines_core", "cleanElement", "", "cleanElement$kotlinx_coroutines_core", "getAndSetState", "update", "getAndSetState$kotlinx_coroutines_core", "getElement", "getElement$kotlinx_coroutines_core", "(I)Ljava/lang/Object;", "getState", "getState$kotlinx_coroutines_core", "onCancellation", "cause", "", "context", "Lkotlin/coroutines/CoroutineContext;", "onCancelledRequest", "receiver", "retrieveElement", "retrieveElement$kotlinx_coroutines_core", "setElementLazy", "value", "setState", "setState$kotlinx_coroutines_core", "storeElement", "element", "storeElement$kotlinx_coroutines_core", "(ILjava/lang/Object;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class ChannelSegment<E>
extends Segment<ChannelSegment<E>> {
    private final BufferedChannel<E> _channel;
    private final AtomicReferenceArray data;

    public ChannelSegment(long l, ChannelSegment<E> channelSegment, BufferedChannel<E> bufferedChannel, int n) {
        super(l, (Segment)channelSegment, n);
        this._channel = bufferedChannel;
        this.data = new AtomicReferenceArray(BufferedChannelKt.SEGMENT_SIZE * 2);
    }

    private final void setElementLazy(int n, Object object) {
        this.data.lazySet(n * 2, object);
    }

    public final boolean casState$kotlinx_coroutines_core(int n, Object object, Object object2) {
        return ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this.data, n * 2 + 1, object, object2);
    }

    public final void cleanElement$kotlinx_coroutines_core(int n) {
        this.setElementLazy(n, null);
    }

    public final Object getAndSetState$kotlinx_coroutines_core(int n, Object object) {
        return this.data.getAndSet(n * 2 + 1, object);
    }

    public final BufferedChannel<E> getChannel() {
        BufferedChannel<E> bufferedChannel = this._channel;
        Intrinsics.checkNotNull(bufferedChannel);
        return bufferedChannel;
    }

    public final E getElement$kotlinx_coroutines_core(int n) {
        return this.data.get(n * 2);
    }

    @Override
    public int getNumberOfSlots() {
        return BufferedChannelKt.SEGMENT_SIZE;
    }

    public final Object getState$kotlinx_coroutines_core(int n) {
        return this.data.get(n * 2 + 1);
    }

    @Override
    public void onCancellation(int n, Throwable object, CoroutineContext coroutineContext) {
        int n2 = BufferedChannelKt.SEGMENT_SIZE;
        boolean bl = true;
        if ((n2 = n >= n2 ? 1 : 0) != 0) {
            n -= BufferedChannelKt.SEGMENT_SIZE;
        }
        E e = this.getElement$kotlinx_coroutines_core(n);
        while (true) {
            Object object2;
            if (!((object2 = this.getState$kotlinx_coroutines_core(n)) instanceof Waiter) && !(object2 instanceof WaiterEB)) {
                if (object2 != BufferedChannelKt.access$getINTERRUPTED_SEND$p() && object2 != BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                    if (object2 == BufferedChannelKt.access$getRESUMING_BY_EB$p() || object2 == BufferedChannelKt.access$getRESUMING_BY_RCV$p()) continue;
                    if (object2 != BufferedChannelKt.access$getDONE_RCV$p() && object2 != BufferedChannelKt.BUFFERED) {
                        if (object2 == BufferedChannelKt.getCHANNEL_CLOSED()) {
                            return;
                        }
                        throw new IllegalStateException(("unexpected state: " + object2).toString());
                    }
                    return;
                }
                this.cleanElement$kotlinx_coroutines_core(n);
                if (n2 != 0 && (object = this.getChannel().onUndeliveredElement) != null) {
                    OnUndeliveredElementKt.callUndeliveredElement(object, e, coroutineContext);
                }
                return;
            }
            object = n2 != 0 ? BufferedChannelKt.access$getINTERRUPTED_SEND$p() : BufferedChannelKt.access$getINTERRUPTED_RCV$p();
            if (this.casState$kotlinx_coroutines_core(n, object2, object)) break;
        }
        this.cleanElement$kotlinx_coroutines_core(n);
        if (n2 != 0) {
            bl = false;
        }
        this.onCancelledRequest(n, bl);
        if (n2 != 0 && (object = this.getChannel().onUndeliveredElement) != null) {
            OnUndeliveredElementKt.callUndeliveredElement(object, e, coroutineContext);
        }
    }

    public final void onCancelledRequest(int n, boolean bl) {
        if (bl) {
            this.getChannel().waitExpandBufferCompletion$kotlinx_coroutines_core(this.id * (long)BufferedChannelKt.SEGMENT_SIZE + (long)n);
        }
        this.onSlotCleaned();
    }

    public final E retrieveElement$kotlinx_coroutines_core(int n) {
        E e = this.getElement$kotlinx_coroutines_core(n);
        this.cleanElement$kotlinx_coroutines_core(n);
        return e;
    }

    public final void setState$kotlinx_coroutines_core(int n, Object object) {
        this.data.set(n * 2 + 1, object);
    }

    public final void storeElement$kotlinx_coroutines_core(int n, E e) {
        this.setElementLazy(n, e);
    }
}

