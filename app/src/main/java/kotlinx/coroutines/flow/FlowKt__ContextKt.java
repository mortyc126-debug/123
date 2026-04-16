/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.CancellableFlowImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u00a2\u0006\u0002\b\u0004\u001a(\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a0\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0006\u001a\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0006\u001a$\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010\u0002\u001a\u00020\u0003\u00a8\u0006\u000f"}, d2={"checkFlowContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "checkFlowContext$FlowKt__ContextKt", "buffer", "Lkotlinx/coroutines/flow/Flow;", "T", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "cancellable", "conflate", "flowOn", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ContextKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ Flow buffer(Flow flow2, int n) {
        return FlowKt.buffer$default(flow2, n, null, 2, null);
    }

    public static final <T> Flow<T> buffer(Flow<? extends T> flow2, int n, BufferOverflow bufferOverflow) {
        block5: {
            int n2;
            block7: {
                block6: {
                    int n3 = 0;
                    n2 = n < 0 && n != -2 && n != -1 ? 0 : 1;
                    if (n2 == 0) break block5;
                    if (n != -1) break block6;
                    n2 = n3;
                    if (bufferOverflow != BufferOverflow.SUSPEND) break block7;
                }
                n2 = 1;
            }
            if (n2 != 0) {
                n2 = n;
                if (n == -1) {
                    n2 = 0;
                    bufferOverflow = BufferOverflow.DROP_OLDEST;
                }
                flow2 = flow2 instanceof FusibleFlow ? FusibleFlow.DefaultImpls.fuse$default((FusibleFlow)flow2, null, n2, bufferOverflow, 1, null) : (Flow)new ChannelFlowOperatorImpl(flow2, null, n2, bufferOverflow, 2, null);
                return flow2;
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + n).toString());
    }

    public static /* synthetic */ Flow buffer$default(Flow flow2, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = -2;
        }
        return FlowKt.buffer(flow2, n);
    }

    public static /* synthetic */ Flow buffer$default(Flow flow2, int n, BufferOverflow bufferOverflow, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = -2;
        }
        if ((n2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return FlowKt.buffer(flow2, n, bufferOverflow);
    }

    public static final <T> Flow<T> cancellable(Flow<? extends T> flow2) {
        if (!(flow2 instanceof CancellableFlow)) {
            flow2 = new CancellableFlowImpl<T>(flow2);
        }
        return flow2;
    }

    private static final void checkFlowContext$FlowKt__ContextKt(CoroutineContext coroutineContext) {
        boolean bl = coroutineContext.get((CoroutineContext.Key)Job.Key) == null;
        if (bl) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
    }

    public static final <T> Flow<T> conflate(Flow<? extends T> flow2) {
        return FlowKt.buffer$default(flow2, -1, null, 2, null);
    }

    public static final <T> Flow<T> flowOn(Flow<? extends T> flow2, CoroutineContext coroutineContext) {
        FlowKt__ContextKt.checkFlowContext$FlowKt__ContextKt(coroutineContext);
        if (!Intrinsics.areEqual((Object)coroutineContext, (Object)EmptyCoroutineContext.INSTANCE)) {
            flow2 = flow2 instanceof FusibleFlow ? FusibleFlow.DefaultImpls.fuse$default((FusibleFlow)flow2, coroutineContext, 0, null, 6, null) : (Flow)new ChannelFlowOperatorImpl(flow2, coroutineContext, 0, null, 12, null);
        }
        return flow2;
    }
}

