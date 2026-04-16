/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharedFlowSlot;
import kotlinx.coroutines.flow.SubscribedFlowCollector;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006:\u0001hB\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020,H\u0002J\u001f\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00107J\u0010\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020\u0012H\u0002J\b\u0010:\u001a\u00020\u0003H\u0014J\u001d\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e2\u0006\u0010<\u001a\u00020\bH\u0014\u00a2\u0006\u0002\u0010=J\b\u0010>\u001a\u00020,H\u0002J\u0019\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010AJ\u0019\u0010B\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010AJ\u0012\u0010C\u001a\u00020,2\b\u0010D\u001a\u0004\u0018\u00010\u000fH\u0002J1\u0010E\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0014\u0010G\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000eH\u0002\u00a2\u0006\u0002\u0010HJ&\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010N\u001a\u0004\u0018\u00010\u000f2\u0006\u0010O\u001a\u00020\u0012H\u0002J7\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0010\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\bH\u0002\u00a2\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020,H\u0016J\u0015\u0010V\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010XJ\u0015\u0010Y\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010XJ\u0015\u0010Z\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010XJ\u0010\u0010[\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0012\u0010\\\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\u0003H\u0002J(\u0010]\u001a\u00020,2\u0006\u0010^\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u0012H\u0002J%\u0010b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0006\u0010c\u001a\u00020\u0012H\u0000\u00a2\u0006\u0004\bd\u0010eJ\r\u0010f\u001a\u00020\u0012H\u0000\u00a2\u0006\u0002\bgR\u001a\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00028\u00008DX\u0084\u0004\u00a2\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u000e\u0010 \u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006i"}, d2={"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "replay", "", "bufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferEndIndex", "", "getBufferEndIndex", "()J", "bufferSize", "head", "getHead", "lastReplayedLocked", "getLastReplayedLocked$annotations", "()V", "getLastReplayedLocked", "()Ljava/lang/Object;", "minCollectorIndex", "queueEndIndex", "getQueueEndIndex", "queueSize", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "replayIndex", "replaySize", "getReplaySize", "()I", "totalSize", "getTotalSize", "awaitValue", "", "slot", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelEmitter", "emitter", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "cleanupTailLocked", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "correctCollectorIndexesOnDropOldest", "newHead", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "dropOldestLocked", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSuspend", "enqueueLocked", "item", "findSlotsToResumeLocked", "Lkotlin/coroutines/Continuation;", "resumesIn", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getPeekedValueLockedAt", "index", "growBuffer", "curBuffer", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "resetReplayCache", "tryEmit", "", "(Ljava/lang/Object;)Z", "tryEmitLocked", "tryEmitNoCollectorsLocked", "tryPeekLocked", "tryTakeValue", "updateBufferLocked", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateCollectorIndexLocked", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateNewCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "Emitter", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public class SharedFlowImpl<T>
extends AbstractSharedFlow<SharedFlowSlot>
implements MutableSharedFlow<T>,
CancellableFlow<T>,
FusibleFlow<T> {
    private Object[] buffer;
    private final int bufferCapacity;
    private int bufferSize;
    private long minCollectorIndex;
    private final BufferOverflow onBufferOverflow;
    private int queueSize;
    private final int replay;
    private long replayIndex;

    public SharedFlowImpl(int n, int n2, BufferOverflow bufferOverflow) {
        this.replay = n;
        this.bufferCapacity = n2;
        this.onBufferOverflow = bufferOverflow;
    }

    public static final /* synthetic */ Object access$awaitValue(SharedFlowImpl sharedFlowImpl, SharedFlowSlot sharedFlowSlot, Continuation continuation) {
        return sharedFlowImpl.awaitValue(sharedFlowSlot, (Continuation<Unit>)continuation);
    }

    public static final /* synthetic */ Object access$emitSuspend(SharedFlowImpl sharedFlowImpl, Object object, Continuation continuation) {
        return sharedFlowImpl.emitSuspend(object, (Continuation<Unit>)continuation);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Object awaitValue(SharedFlowSlot object, Continuation<? super Unit> continuation) {
        void var2_2;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)var2_2), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        synchronized (this) {
            if (this.tryPeekLocked((SharedFlowSlot)object) < 0L) {
                ((SharedFlowSlot)object).cont = cancellableContinuation;
                ((SharedFlowSlot)object).cont = cancellableContinuation;
            } else {
                object = cancellableContinuation;
                cancellableContinuation = Result.Companion;
                object.resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
            }
            object = Unit.INSTANCE;
        }
        object = cancellableContinuationImpl.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended((Continuation)var2_2);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final void cancelEmitter(Emitter emitter) {
        synchronized (this) {
            Object[] objectArray;
            block6: {
                block5: {
                    long l = emitter.index;
                    long l2 = this.getHead();
                    if (l >= l2) break block5;
                    return;
                }
                objectArray = this.buffer;
                Intrinsics.checkNotNull((Object)objectArray);
                Object object = SharedFlowKt.access$getBufferAt(objectArray, emitter.index);
                if (object == emitter) break block6;
                return;
            }
            SharedFlowKt.access$setBufferAt(objectArray, emitter.index, SharedFlowKt.NO_VALUE);
            this.cleanupTailLocked();
            emitter = Unit.INSTANCE;
            return;
        }
    }

    private final void cleanupTailLocked() {
        if (this.bufferCapacity == 0 && this.queueSize <= 1) {
            return;
        }
        Object[] objectArray = this.buffer;
        Intrinsics.checkNotNull((Object)objectArray);
        while (this.queueSize > 0 && SharedFlowKt.access$getBufferAt(objectArray, this.getHead() + (long)this.getTotalSize() - 1L) == SharedFlowKt.NO_VALUE) {
            --this.queueSize;
            SharedFlowKt.access$setBufferAt(objectArray, this.getHead() + (long)this.getTotalSize(), null);
        }
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ <T> Object collect$suspendImpl(SharedFlowImpl<T> var0, FlowCollector<? super T> var1_1, Continuation<?> var2_2) {
        if (!(var2_2 instanceof collect.1)) ** GOTO lbl-1000
        var8_4 = (ContinuationImpl)var2_2;
        if ((var8_4.label & -2147483648) != 0) {
            var8_4.label += -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            var8_4 = new ContinuationImpl(var0, (Continuation<? super collect.1>)var2_2){
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                Object result;
                final SharedFlowImpl<T> this$0;
                {
                    this.this$0 = sharedFlowImpl;
                    super(continuation);
                }

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return SharedFlowImpl.collect$suspendImpl(this.this$0, null, (Continuation)this);
                }
            };
        }
        var10_5 = var8_4.result;
        var9_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var8_4.label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 3: {
                var5_7 = (Job)var8_4.L$3;
                var3_8 = (SharedFlowSlot)var8_4.L$2;
                var4_9 = (FlowCollector)var8_4.L$1;
                var0 = var2_2 = (SharedFlowImpl)var8_4.L$0;
                var1_1 = var3_8;
                ResultKt.throwOnFailure((Object)var10_5);
                var1_1 = var5_7;
                var0 = var4_9;
                ** GOTO lbl167
            }
            case 2: {
                var4_9 = (Job)var8_4.L$3;
                var7_10 = (SharedFlowSlot)var8_4.L$2;
                var5_7 = (FlowCollector)var8_4.L$1;
                var0 = var6_11 = (SharedFlowImpl)var8_4.L$0;
                var1_1 = var7_10;
                ResultKt.throwOnFailure((Object)var10_5);
                ** GOTO lbl127
            }
            case 1: {
                var4_9 = (SharedFlowSlot)var8_4.L$2;
                var6_11 = (FlowCollector)var8_4.L$1;
                var0 = var3_8 = (SharedFlowImpl)var8_4.L$0;
                var1_1 = var4_9;
                ResultKt.throwOnFailure((Object)var10_5);
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var10_5);
                var2_2 = var0;
                var7_10 = var1_1;
                var5_7 = (SharedFlowSlot)var2_2.allocateSlot();
                var3_8 = var2_2;
                var6_11 = var7_10;
                var4_9 = var5_7;
                var0 = var2_2;
                var1_1 = var5_7;
                if (!(var7_10 instanceof SubscribedFlowCollector)) break;
                var0 = var2_2;
                var1_1 = var5_7;
                var10_5 = (SubscribedFlowCollector)var7_10;
                var0 = var2_2;
                var1_1 = var5_7;
                var8_4.L$0 = var2_2;
                var0 = var2_2;
                var1_1 = var5_7;
                var8_4.L$1 = var7_10;
                var0 = var2_2;
                var1_1 = var5_7;
                var8_4.L$2 = var5_7;
                var0 = var2_2;
                var1_1 = var5_7;
                var8_4.label = 1;
                var3_8 = var2_2;
                var6_11 = var7_10;
                var4_9 = var5_7;
                var0 = var2_2;
                var1_1 = var5_7;
                if (var10_5.onSubscription((Continuation<? super Unit>)var8_4) != var9_6) break;
                return var9_6;
            }
        }
        var0 = var3_8;
        var1_1 = var4_9;
        try {
            var5_7 = (Job)var8_4.getContext().get((CoroutineContext.Key)Job.Key);
            var0 = var6_11;
            var2_2 = var3_8;
            var1_1 = var5_7;
        }
        catch (Throwable var2_3) {
            var0.freeSlot((AbstractSharedFlowSlot)var1_1);
            throw var2_3;
        }
        while (true) lbl-1000:
        // 2 sources

        {
            var3_8 = var4_9;
            var4_9 = var1_1;
            var5_7 = var0;
            while (true) {
                block39: {
                    var0 = var2_2;
                    var1_1 = var3_8;
                    var6_11 = super.tryTakeValue((SharedFlowSlot)var3_8);
                    var0 = var2_2;
                    var1_1 = var3_8;
                    if (var6_11 != SharedFlowKt.NO_VALUE) break;
                    var0 = var2_2;
                    var1_1 = var3_8;
                    var8_4.L$0 = var2_2;
                    var0 = var2_2;
                    var1_1 = var3_8;
                    var8_4.L$1 = var5_7;
                    var0 = var2_2;
                    var1_1 = var3_8;
                    var8_4.L$2 = var3_8;
                    var0 = var2_2;
                    var1_1 = var3_8;
                    var8_4.L$3 = var4_9;
                    var0 = var2_2;
                    var1_1 = var3_8;
                    var8_4.label = 2;
                    var6_11 = var2_2;
                    var7_10 = var3_8;
                    var0 = var2_2;
                    var1_1 = var3_8;
                    if (super.awaitValue((SharedFlowSlot)var3_8, (Continuation<? super Unit>)var8_4) != var9_6) break block39;
                    return var9_6;
                }
                var2_2 = var6_11;
                var3_8 = var7_10;
            }
            if (var4_9 != null) {
                var0 = var2_2;
                var1_1 = var3_8;
                JobKt.ensureActive((Job)var4_9);
            }
            var0 = var2_2;
            var1_1 = var3_8;
            var8_4.L$0 = var2_2;
            var0 = var2_2;
            var1_1 = var3_8;
            break;
        }
        {
            var8_4.L$1 = var5_7;
            var0 = var2_2;
            var1_1 = var3_8;
            var8_4.L$2 = var3_8;
            var0 = var2_2;
            var1_1 = var3_8;
            var8_4.L$3 = var4_9;
            var0 = var2_2;
            var1_1 = var3_8;
            var8_4.label = 3;
            var0 = var2_2;
            var1_1 = var3_8;
            var6_11 = var5_7.emit(var6_11, (Continuation<? super Unit>)var8_4);
            if (var6_11 == var9_6) {
                return var9_6;
            }
            var1_1 = var4_9;
            var0 = var5_7;
lbl167:
            // 2 sources

            var4_9 = var3_8;
            ** while (true)
        }
    }

    private final void correctCollectorIndexesOnDropOldest(long l) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArray = (AbstractSharedFlowSlot[])this;
        if (AbstractSharedFlow.access$getNCollectors((AbstractSharedFlow)abstractSharedFlowSlotArray) != 0 && (abstractSharedFlowSlotArray = AbstractSharedFlow.access$getSlots((AbstractSharedFlow)abstractSharedFlowSlotArray)) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArray) {
                if (abstractSharedFlowSlot == null) continue;
                abstractSharedFlowSlot = (SharedFlowSlot)abstractSharedFlowSlot;
                if (((SharedFlowSlot)abstractSharedFlowSlot).index < 0L || ((SharedFlowSlot)abstractSharedFlowSlot).index >= l) continue;
                ((SharedFlowSlot)abstractSharedFlowSlot).index = l;
            }
        }
        this.minCollectorIndex = l;
    }

    private final void dropOldestLocked() {
        boolean bl;
        Object[] objectArray = this.buffer;
        Intrinsics.checkNotNull((Object)objectArray);
        SharedFlowKt.access$setBufferAt(objectArray, this.getHead(), null);
        --this.bufferSize;
        long l = this.getHead() + 1L;
        if (this.replayIndex < l) {
            this.replayIndex = l;
        }
        if (this.minCollectorIndex < l) {
            this.correctCollectorIndexesOnDropOldest(l);
        }
        if (DebugKt.getASSERTIONS_ENABLED() && !(bl = this.getHead() == l)) {
            throw new AssertionError();
        }
    }

    static /* synthetic */ <T> Object emit$suspendImpl(SharedFlowImpl<T> object, T t, Continuation<? super Unit> continuation) {
        if (((SharedFlowImpl)object).tryEmit(t)) {
            return Unit.INSTANCE;
        }
        if ((object = super.emitSuspend(t, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private final Object emitSuspend(T object, Continuation<? super Unit> continuation) {
        void var1_6;
        void emitter;
        void var2_8;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)var2_8), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        Result.Companion companion = AbstractSharedFlowKt.EMPTY_RESUMES;
        // MONITORENTER : this
        if (this.tryEmitLocked(object)) {
            Continuation continuation2 = cancellableContinuation;
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
            Continuation[] continuationArray = this.findSlotsToResumeLocked(companion);
            Object continuation22 = null;
        } else {
            long l = this.getHead();
            Emitter emitter2 = new Emitter(this, (long)this.getTotalSize() + l, object, (Continuation<? super Unit>)((Continuation)cancellableContinuation));
            this.enqueueLocked(emitter2);
            this.queueSize = this.queueSize + 1;
            Result.Companion companion3 = companion;
            if (this.bufferCapacity == 0) {
                Continuation[] continuationArray = this.findSlotsToResumeLocked(companion);
            }
        }
        // MONITOREXIT : this
        if (emitter != null) {
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuation, (DisposableHandle)emitter);
        }
        for (void var7_17 : var1_6) {
            if (var7_17 == null) continue;
            companion = Result.Companion;
            var7_17.resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
        }
        Object object2 = cancellableContinuationImpl.getResult();
        if (object2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended((Continuation)var2_8);
        }
        if (object2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) return Unit.INSTANCE;
        return object2;
    }

    private final void enqueueLocked(Object object) {
        Object[] objectArray;
        int n = this.getTotalSize();
        Object[] objectArray2 = this.buffer;
        if (objectArray2 == null) {
            objectArray = this.growBuffer(null, 0, 2);
        } else {
            objectArray = objectArray2;
            if (n >= objectArray2.length) {
                objectArray = this.growBuffer(objectArray2, n, objectArray2.length * 2);
            }
        }
        SharedFlowKt.access$setBufferAt(objectArray, this.getHead() + (long)n, object);
    }

    private final Continuation<Unit>[] findSlotsToResumeLocked(Continuation<Unit>[] continuationArray) {
        Continuation<Unit>[] continuationArray2 = continuationArray;
        int n = continuationArray.length;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArray = (AbstractSharedFlowSlot[])this;
        continuationArray = continuationArray2;
        if (AbstractSharedFlow.access$getNCollectors((AbstractSharedFlow)abstractSharedFlowSlotArray) != 0) {
            abstractSharedFlowSlotArray = AbstractSharedFlow.access$getSlots((AbstractSharedFlow)abstractSharedFlowSlotArray);
            continuationArray = continuationArray2;
            if (abstractSharedFlowSlotArray != null) {
                int n2 = abstractSharedFlowSlotArray.length;
                continuationArray = continuationArray2;
                for (int i = 0; i < n2; ++i) {
                    AbstractSharedFlowSlot abstractSharedFlowSlot = abstractSharedFlowSlotArray[i];
                    continuationArray2 = continuationArray;
                    int n3 = n;
                    if (abstractSharedFlowSlot != null) {
                        abstractSharedFlowSlot = (SharedFlowSlot)abstractSharedFlowSlot;
                        Continuation<? super Unit> continuation = ((SharedFlowSlot)abstractSharedFlowSlot).cont;
                        if (continuation == null) {
                            continuationArray2 = continuationArray;
                            n3 = n;
                        } else {
                            continuationArray2 = continuationArray;
                            n3 = n;
                            if (this.tryPeekLocked((SharedFlowSlot)abstractSharedFlowSlot) >= 0L) {
                                continuationArray2 = continuationArray;
                                if (n >= continuationArray.length) {
                                    continuationArray2 = Arrays.copyOf(continuationArray, Math.max(2, continuationArray.length * 2));
                                    Intrinsics.checkNotNullExpressionValue(continuationArray2, (String)"copyOf(this, newSize)");
                                }
                                continuationArray2[n] = continuation;
                                ((SharedFlowSlot)abstractSharedFlowSlot).cont = null;
                                n3 = n + 1;
                            }
                        }
                    }
                    continuationArray = continuationArray2;
                    n = n3;
                }
            }
        }
        return continuationArray;
    }

    private final long getBufferEndIndex() {
        return this.getHead() + (long)this.bufferSize;
    }

    private final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    protected static /* synthetic */ void getLastReplayedLocked$annotations() {
    }

    private final Object getPeekedValueLockedAt(long l) {
        Object object;
        block0: {
            object = this.buffer;
            Intrinsics.checkNotNull((Object)object);
            object = SharedFlowKt.access$getBufferAt(object, l);
            if (!(object instanceof Emitter)) break block0;
            object = ((Emitter)object).value;
        }
        return object;
    }

    private final long getQueueEndIndex() {
        return this.getHead() + (long)this.bufferSize + (long)this.queueSize;
    }

    private final int getReplaySize() {
        return (int)(this.getHead() + (long)this.bufferSize - this.replayIndex);
    }

    private final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    private final Object[] growBuffer(Object[] objectArray, int n, int n2) {
        boolean bl = n2 > 0;
        if (bl) {
            Object[] objectArray2 = new Object[n2];
            this.buffer = objectArray2;
            if (objectArray == null) {
                return objectArray2;
            }
            long l = this.getHead();
            for (n2 = 0; n2 < n; ++n2) {
                SharedFlowKt.access$setBufferAt(objectArray2, (long)n2 + l, SharedFlowKt.access$getBufferAt(objectArray, (long)n2 + l));
            }
            return objectArray2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    private final boolean tryEmitLocked(T t) {
        if (this.getNCollectors() == 0) {
            return this.tryEmitNoCollectorsLocked(t);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            BufferOverflow bufferOverflow = this.onBufferOverflow;
            switch (WhenMappings.$EnumSwitchMapping$0[bufferOverflow.ordinal()]) {
                default: {
                    break;
                }
                case 2: {
                    return true;
                }
                case 1: {
                    return false;
                }
            }
        }
        this.enqueueLocked(t);
        ++this.bufferSize;
        if (this.bufferSize > this.bufferCapacity) {
            this.dropOldestLocked();
        }
        if (this.getReplaySize() > this.replay) {
            this.updateBufferLocked(this.replayIndex + 1L, this.minCollectorIndex, this.getBufferEndIndex(), this.getQueueEndIndex());
        }
        return true;
    }

    private final boolean tryEmitNoCollectorsLocked(T t) {
        boolean bl;
        if (DebugKt.getASSERTIONS_ENABLED() && !(bl = this.getNCollectors() == 0)) {
            throw new AssertionError();
        }
        if (this.replay == 0) {
            return true;
        }
        this.enqueueLocked(t);
        ++this.bufferSize;
        if (this.bufferSize > this.replay) {
            this.dropOldestLocked();
        }
        this.minCollectorIndex = this.getHead() + (long)this.bufferSize;
        return true;
    }

    private final long tryPeekLocked(SharedFlowSlot sharedFlowSlot) {
        long l = sharedFlowSlot.index;
        if (l < this.getBufferEndIndex()) {
            return l;
        }
        if (this.bufferCapacity > 0) {
            return -1L;
        }
        if (l > this.getHead()) {
            return -1L;
        }
        if (this.queueSize == 0) {
            return -1L;
        }
        return l;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Object tryTakeValue(SharedFlowSlot continuationArray) {
        Symbol symbol;
        Object object = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            long l = this.tryPeekLocked((SharedFlowSlot)continuationArray);
            if (l < 0L) {
                symbol = SharedFlowKt.NO_VALUE;
                continuationArray = object;
                object = symbol;
            } else {
                long l2 = continuationArray.index;
                object = this.getPeekedValueLockedAt(l);
                continuationArray.index = 1L + l;
                continuationArray = this.updateCollectorIndexLocked$kotlinx_coroutines_core(l2);
            }
        }
        int n = continuationArray.length;
        int n2 = 0;
        while (n2 < n) {
            Continuation<Unit> continuation = continuationArray[n2];
            if (continuation != null) {
                symbol = Result.Companion;
                continuation.resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
            }
            ++n2;
        }
        return object;
    }

    private final void updateBufferLocked(long l, long l2, long l3, long l4) {
        boolean bl;
        long l5 = Math.min(l2, l);
        boolean bl2 = DebugKt.getASSERTIONS_ENABLED();
        boolean bl3 = true;
        if (bl2 && !(bl = l5 >= this.getHead())) {
            throw new AssertionError();
        }
        for (long i = this.getHead(); i < l5; ++i) {
            Object[] objectArray = this.buffer;
            Intrinsics.checkNotNull((Object)objectArray);
            SharedFlowKt.access$setBufferAt(objectArray, i, null);
        }
        this.replayIndex = l;
        this.minCollectorIndex = l2;
        this.bufferSize = (int)(l3 - l5);
        this.queueSize = (int)(l4 - l3);
        if (DebugKt.getASSERTIONS_ENABLED() && !(bl = this.bufferSize >= 0)) {
            throw new AssertionError();
        }
        if (DebugKt.getASSERTIONS_ENABLED() && !(bl = this.queueSize >= 0)) {
            throw new AssertionError();
        }
        if (DebugKt.getASSERTIONS_ENABLED() && !(bl = this.replayIndex <= this.getHead() + (long)this.bufferSize ? bl3 : false)) {
            throw new AssertionError();
        }
    }

    @Override
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return SharedFlowImpl.collect$suspendImpl(this, flowCollector, continuation);
    }

    @Override
    protected SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    protected SharedFlowSlot[] createSlotArray(int n) {
        return new SharedFlowSlot[n];
    }

    @Override
    public Object emit(T t, Continuation<? super Unit> continuation) {
        return SharedFlowImpl.emit$suspendImpl(this, t, continuation);
    }

    @Override
    public Flow<T> fuse(CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, coroutineContext, n, bufferOverflow);
    }

    protected final T getLastReplayedLocked() {
        Object[] objectArray = this.buffer;
        Intrinsics.checkNotNull((Object)objectArray);
        return (T)SharedFlowKt.access$getBufferAt(objectArray, this.replayIndex + (long)this.getReplaySize() - 1L);
    }

    @Override
    public List<T> getReplayCache() {
        synchronized (this) {
            int n;
            block7: {
                n = this.getReplaySize();
                if (n != 0) break block7;
                List list = CollectionsKt.emptyList();
                return list;
            }
            ArrayList arrayList = new ArrayList(n);
            Object[] objectArray = this.buffer;
            Intrinsics.checkNotNull((Object)objectArray);
            for (int i = 0; i < n; ++i) {
                ((Collection)arrayList).add(SharedFlowKt.access$getBufferAt(objectArray, this.replayIndex + (long)i));
                continue;
            }
            return arrayList;
        }
    }

    @Override
    public void resetReplayCache() {
        synchronized (this) {
            this.updateBufferLocked(this.getBufferEndIndex(), this.minCollectorIndex, this.getBufferEndIndex(), this.getQueueEndIndex());
            Unit unit = Unit.INSTANCE;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean tryEmit(T object) {
        int n;
        boolean bl;
        Object object2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            bl = this.tryEmitLocked(object);
            n = 0;
            if (bl) {
                object = this.findSlotsToResumeLocked((Continuation<Unit>[])object2);
                bl = true;
            } else {
                bl = false;
                object = object2;
            }
        }
        int n2 = ((Object)object).length;
        while (n < n2) {
            object2 = object[n];
            if (object2 != null) {
                Result.Companion companion = Result.Companion;
                object2.resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
            }
            ++n;
        }
        return bl;
    }

    public final Continuation<Unit>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long l) {
        Object object;
        int n;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArray;
        long l2;
        int n2;
        if (DebugKt.getASSERTIONS_ENABLED() && (n2 = l >= this.minCollectorIndex ? 1 : 0) == 0) {
            throw new AssertionError();
        }
        if (l > this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long l3 = this.getHead();
        l = l2 = (long)this.bufferSize + l3;
        if (this.bufferCapacity == 0) {
            l = l2;
            if (this.queueSize > 0) {
                l = l2 + 1L;
            }
        }
        if (AbstractSharedFlow.access$getNCollectors((AbstractSharedFlow)(abstractSharedFlowSlotArray = (AbstractSharedFlowSlot[])this)) != 0) {
            if ((abstractSharedFlowSlotArray = AbstractSharedFlow.access$getSlots((AbstractSharedFlow)abstractSharedFlowSlotArray)) != null) {
                n = abstractSharedFlowSlotArray.length;
                for (n2 = 0; n2 < n; ++n2) {
                    object = abstractSharedFlowSlotArray[n2];
                    if (object == null) continue;
                    object = (SharedFlowSlot)object;
                    l2 = l;
                    if (object.index >= 0L) {
                        l2 = l;
                        if (object.index < l) {
                            l2 = object.index;
                        }
                    }
                    l = l2;
                }
                l2 = l3;
            } else {
                l2 = l3;
            }
            l3 = l;
        } else {
            l2 = l3;
            l3 = l;
        }
        if (DebugKt.getASSERTIONS_ENABLED() && (n2 = l3 >= this.minCollectorIndex ? 1 : 0) == 0) {
            throw new AssertionError();
        }
        if (l3 <= this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        l = this.getBufferEndIndex();
        if (this.getNCollectors() > 0) {
            n2 = (int)(l - l3);
            n2 = Math.min(this.queueSize, this.bufferCapacity - n2);
        } else {
            n2 = this.queueSize;
        }
        abstractSharedFlowSlotArray = AbstractSharedFlowKt.EMPTY_RESUMES;
        long l4 = l + (long)this.queueSize;
        if (n2 > 0) {
            abstractSharedFlowSlotArray = new Continuation[n2];
            n = 0;
            Object[] objectArray = this.buffer;
            Intrinsics.checkNotNull((Object)objectArray);
            for (long i = l; i < l4; ++i) {
                object = SharedFlowKt.access$getBufferAt(objectArray, i);
                if (object == SharedFlowKt.NO_VALUE) continue;
                Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                Emitter emitter = (Emitter)object;
                int n3 = n + 1;
                abstractSharedFlowSlotArray[n] = ((Emitter)object).cont;
                SharedFlowKt.access$setBufferAt(objectArray, i, SharedFlowKt.NO_VALUE);
                SharedFlowKt.access$setBufferAt(objectArray, l, ((Emitter)object).value);
                ++l;
                if (n3 >= n2) break;
                n = n3;
            }
        }
        n2 = (int)(l - l2);
        if (this.getNCollectors() == 0) {
            l3 = l;
        }
        l2 = Math.max(this.replayIndex, l - (long)Math.min(this.replay, n2));
        if (this.bufferCapacity == 0 && l2 < l4) {
            object = this.buffer;
            Intrinsics.checkNotNull((Object)object);
            if (Intrinsics.areEqual((Object)SharedFlowKt.access$getBufferAt(object, l2), (Object)SharedFlowKt.NO_VALUE)) {
                ++l;
                ++l2;
            }
        }
        this.updateBufferLocked(l2, l3, l, l4);
        this.cleanupTailLocked();
        n2 = abstractSharedFlowSlotArray.length == 0 ? 1 : 0;
        object = abstractSharedFlowSlotArray;
        if ((n2 ^ 1) != 0) {
            object = this.findSlotsToResumeLocked((Continuation<Unit>[])abstractSharedFlowSlotArray);
        }
        return object;
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long l = this.replayIndex;
        if (l < this.minCollectorIndex) {
            this.minCollectorIndex = l;
        }
        return l;
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "index", "", "value", "", "cont", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private static final class Emitter
    implements DisposableHandle {
        public final Continuation<Unit> cont;
        public final SharedFlowImpl<?> flow;
        public long index;
        public final Object value;

        public Emitter(SharedFlowImpl<?> sharedFlowImpl, long l, Object object, Continuation<? super Unit> continuation) {
            this.flow = sharedFlowImpl;
            this.index = l;
            this.value = object;
            this.cont = continuation;
        }

        @Override
        public void dispose() {
            ((SharedFlowImpl)this.flow).cancelEmitter(this);
        }
    }

    @Metadata(k=3, mv={1, 8, 0}, xi=48)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[BufferOverflow.values().length];
            try {
                nArray[BufferOverflow.SUSPEND.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

