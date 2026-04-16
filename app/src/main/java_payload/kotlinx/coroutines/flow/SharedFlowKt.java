/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a0\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t\u001a6\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000b\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0000\u001a#\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u00a2\u0006\u0002\u0010\u0015\u001a+\u0010\u0016\u001a\u00020\u0017*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0002\u00a2\u0006\u0002\u0010\u0019\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"NO_VALUE", "Lkotlinx/coroutines/internal/Symbol;", "MutableSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "T", "replay", "", "extraBufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "fuseSharedFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharedFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getBufferAt", "", "", "index", "", "([Ljava/lang/Object;J)Ljava/lang/Object;", "setBufferAt", "", "item", "([Ljava/lang/Object;JLjava/lang/Object;)V", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class SharedFlowKt {
    public static final Symbol NO_VALUE = new Symbol("NO_VALUE");

    public static final <T> MutableSharedFlow<T> MutableSharedFlow(int n, int n2, BufferOverflow bufferOverflow) {
        boolean bl = true;
        boolean bl2 = n >= 0;
        if (bl2) {
            bl2 = n2 >= 0;
            if (bl2) {
                bl2 = bl;
                if (n <= 0) {
                    bl2 = bl;
                    if (n2 <= 0) {
                        bl2 = bufferOverflow == BufferOverflow.SUSPEND ? bl : false;
                    }
                }
                if (bl2) {
                    if ((n2 = n + n2) < 0) {
                        n2 = Integer.MAX_VALUE;
                    }
                    return new SharedFlowImpl(n, n2, bufferOverflow);
                }
                throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + (Object)((Object)bufferOverflow)).toString());
            }
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + n2).toString());
        }
        throw new IllegalArgumentException(("replay cannot be negative, but was " + n).toString());
    }

    public static /* synthetic */ MutableSharedFlow MutableSharedFlow$default(int n, int n2, BufferOverflow bufferOverflow, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        if ((n3 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return SharedFlowKt.MutableSharedFlow(n, n2, bufferOverflow);
    }

    public static final /* synthetic */ Object access$getBufferAt(Object[] objectArray, long l) {
        return SharedFlowKt.getBufferAt(objectArray, l);
    }

    public static final /* synthetic */ void access$setBufferAt(Object[] objectArray, long l, Object object) {
        SharedFlowKt.setBufferAt(objectArray, l, object);
    }

    public static final <T> Flow<T> fuseSharedFlow(SharedFlow<? extends T> sharedFlow, CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        if ((n == 0 || n == -3) && bufferOverflow == BufferOverflow.SUSPEND) {
            return sharedFlow;
        }
        return new ChannelFlowOperatorImpl(sharedFlow, coroutineContext, n, bufferOverflow);
    }

    private static final Object getBufferAt(Object[] objectArray, long l) {
        return objectArray[(int)l & objectArray.length - 1];
    }

    private static final void setBufferAt(Object[] objectArray, long l, Object object) {
        objectArray[(int)l & objectArray.length - 1] = object;
    }
}

