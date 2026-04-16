/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.flow;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.StateFlowSlot;
import kotlinx.coroutines.flow.SubscribedFlowCollector;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0003H\u0014J\u001d\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030$2\u0006\u0010%\u001a\u00020\u0011H\u0014\u00a2\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020(2\u0006\u0010\u0012\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J&\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020(H\u0016J\u0015\u00102\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00103J\u001a\u00104\u001a\u00020\u001e2\b\u00105\u001a\u0004\u0018\u00010\b2\u0006\u00106\u001a\u00020\bH\u0002R\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00008V@VX\u0096\u000e\u00a2\u0006\u0012\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00067"}, d2={"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "initialState", "", "(Ljava/lang/Object;)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "sequence", "", "value", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "setValue", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compareAndSet", "", "expect", "update", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "createSlot", "createSlotArray", "", "size", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "emit", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "resetReplayCache", "tryEmit", "(Ljava/lang/Object;)Z", "updateState", "expectedState", "newState", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class StateFlowImpl<T>
extends AbstractSharedFlow<StateFlowSlot>
implements MutableStateFlow<T>,
CancellableFlow<T>,
FusibleFlow<T> {
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");
    @Volatile
    private volatile Object _state;
    private int sequence;

    public StateFlowImpl(Object object) {
        this._state = object;
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final boolean updateState(Object abstractSharedFlowSlotArray, Object object) {
        int n;
        synchronized (this) {
            void var2_2;
            boolean bl;
            Object v = _state$FU.get(this);
            if (abstractSharedFlowSlotArray != null && !(bl = Intrinsics.areEqual(v, (Object)abstractSharedFlowSlotArray))) {
                return false;
            }
            bl = Intrinsics.areEqual(v, (Object)var2_2);
            if (bl) {
                return true;
            }
            _state$FU.set(this, var2_2);
            n = this.sequence;
            if ((n & 1) != 0) {
                this.sequence = n + 2;
                return true;
            }
            this.sequence = ++n;
            abstractSharedFlowSlotArray = this.getSlots();
            Unit unit = Unit.INSTANCE;
        }
        while (true) {
            if ((abstractSharedFlowSlotArray = (StateFlowSlot[])abstractSharedFlowSlotArray) != null) {
                for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArray) {
                    if (abstractSharedFlowSlot == null) continue;
                    ((StateFlowSlot)abstractSharedFlowSlot).makePending();
                }
            }
            synchronized (this) {
                if (this.sequence == n) {
                    this.sequence = n + 1;
                    return true;
                }
                n = this.sequence;
                abstractSharedFlowSlotArray = this.getSlots();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public Object collect(FlowCollector<? super T> var1_1, Continuation<?> var2_3) {
        block42: {
            if (!(var2_3 /* !! */  instanceof collect.1)) ** GOTO lbl-1000
            var13_4 = var2_3 /* !! */ ;
            if ((var13_4.label & -2147483648) != 0) {
                var13_4.label += -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                var13_4 = new ContinuationImpl(this, var2_3 /* !! */ ){
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    Object result;
                    final StateFlowImpl<T> this$0;
                    {
                        this.this$0 = stateFlowImpl;
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect(null, (Continuation<?>)((Continuation)this));
                    }
                };
            }
            var8_5 = var13_4.result;
            var15_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var13_4.label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 3: {
                    var10_7 = var13_4.L$4;
                    var5_8 = (Job)var13_4.L$3;
                    var1_1 = (StateFlowSlot)var13_4.L$2;
                    var6_9 = (FlowCollector)var13_4.L$1;
                    var4_10 = (StateFlowImpl)var13_4.L$0;
                    var2_3 /* !! */  = var1_1;
                    var3_11 /* !! */  = var4_10;
                    ResultKt.throwOnFailure((Object)var8_5);
                    ** GOTO lbl200
                }
                case 2: {
                    var6_9 = var13_4.L$4;
                    var5_8 = (Job)var13_4.L$3;
                    var1_1 = (StateFlowSlot)var13_4.L$2;
                    var7_12 = (FlowCollector)var13_4.L$1;
                    var4_10 = (StateFlowImpl)var13_4.L$0;
                    var2_3 /* !! */  = var1_1;
                    var3_11 /* !! */  = var4_10;
                    ResultKt.throwOnFailure((Object)var8_5);
                    var2_3 /* !! */  = var7_12;
                    var3_11 /* !! */  = var6_9;
                    ** GOTO lbl151
                }
                case 1: {
                    var5_8 = (StateFlowSlot)var13_4.L$2;
                    var1_1 = (FlowCollector)var13_4.L$1;
                    var4_10 = (StateFlowImpl)var13_4.L$0;
                    var2_3 /* !! */  = var5_8;
                    var3_11 /* !! */  = var4_10;
                    ResultKt.throwOnFailure((Object)var8_5);
                    break;
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var8_5);
                    var6_9 = this;
                    var5_8 = var8_5 = (StateFlowSlot)var6_9.allocateSlot();
                    var4_10 = var6_9;
                    var7_12 = var1_1;
                    var2_3 /* !! */  = var8_5;
                    var3_11 /* !! */  = var6_9;
                    if (!(var1_1 instanceof SubscribedFlowCollector)) break block42;
                    var2_3 /* !! */  = var8_5;
                    var3_11 /* !! */  = var6_9;
                    var7_12 = (SubscribedFlowCollector)var1_1;
                    var2_3 /* !! */  = var8_5;
                    var3_11 /* !! */  = var6_9;
                    var13_4.L$0 = var6_9;
                    var2_3 /* !! */  = var8_5;
                    var3_11 /* !! */  = var6_9;
                    var13_4.L$1 = var1_1;
                    var2_3 /* !! */  = var8_5;
                    var3_11 /* !! */  = var6_9;
                    var13_4.L$2 = var8_5;
                    var2_3 /* !! */  = var8_5;
                    var3_11 /* !! */  = var6_9;
                    var13_4.label = 1;
                    var5_8 = var8_5;
                    var4_10 = var6_9;
                    var2_3 /* !! */  = var8_5;
                    var3_11 /* !! */  = var6_9;
                    if (var7_12.onSubscription((Continuation<? super Unit>)var13_4) != var15_6) break;
                    return var15_6;
                }
            }
            var7_12 = var1_1;
        }
        var2_3 /* !! */  = var5_8;
        var3_11 /* !! */  = var4_10;
        try {
            var8_5 = (Job)var13_4.getContext().get((CoroutineContext.Key)Job.Key);
            var11_13 = null;
            var6_9 = var7_12;
            var1_1 = var5_8;
            var5_8 = var8_5;
        }
        catch (Throwable var1_2) {
            var3_11 /* !! */ .freeSlot((AbstractSharedFlowSlot)var2_3 /* !! */ );
            throw var1_2;
        }
        while (true) lbl-1000:
        // 3 sources

        {
            var2_3 /* !! */  = var1_1;
            var3_11 /* !! */  = var4_10;
            var14_16 = StateFlowImpl._state$FU.get(var4_10);
            if (var5_8 == null) break block43;
            var2_3 /* !! */  = var1_1;
            var3_11 /* !! */  = var4_10;
            break;
        }
        {
            block45: {
                block44: {
                    block43: {
                        JobKt.ensureActive((Job)var5_8);
                    }
                    if (var11_13 != null) {
                        var12_15 = var5_8;
                        var8_5 = var1_1;
                        var10_7 = var11_13;
                        var7_12 = var4_10;
                        var9_14 = var6_9;
                        var2_3 /* !! */  = var1_1;
                        var3_11 /* !! */  = var4_10;
                        if (Intrinsics.areEqual((Object)var11_13, var14_16)) break block44;
                    }
                    var2_3 /* !! */  = var1_1;
                    var3_11 /* !! */  = var4_10;
                    var7_12 = var14_16 == NullSurrogateKt.NULL ? null : var14_16;
                    var2_3 /* !! */  = var1_1;
                    var3_11 /* !! */  = var4_10;
                    var13_4.L$0 = var4_10;
                    var2_3 /* !! */  = var1_1;
                    var3_11 /* !! */  = var4_10;
                    var13_4.L$1 = var6_9;
                    var2_3 /* !! */  = var1_1;
                    var3_11 /* !! */  = var4_10;
                    var13_4.L$2 = var1_1;
                    var2_3 /* !! */  = var1_1;
                    var3_11 /* !! */  = var4_10;
                    var13_4.L$3 = var5_8;
                    var2_3 /* !! */  = var1_1;
                    var3_11 /* !! */  = var4_10;
                    var13_4.L$4 = var14_16;
                    var2_3 /* !! */  = var1_1;
                    var3_11 /* !! */  = var4_10;
                    var13_4.label = 2;
                    var2_3 /* !! */  = var1_1;
                    var3_11 /* !! */  = var4_10;
                    if (var6_9.emit((Object)var7_12, (Continuation<Unit>)var13_4) == var15_6) {
                        return var15_6;
                    }
                    var2_3 /* !! */  = var6_9;
                    var3_11 /* !! */  = var14_16;
lbl151:
                    // 2 sources

                    var9_14 = var2_3 /* !! */ ;
                    var7_12 = var4_10;
                    var10_7 = var3_11 /* !! */ ;
                    var8_5 = var1_1;
                    var12_15 = var5_8;
                }
                var5_8 = var12_15;
                var1_1 = var8_5;
                var11_13 = var10_7;
                var4_10 = var7_12;
                var6_9 = var9_14;
                var2_3 /* !! */  = var8_5;
                var3_11 /* !! */  = var7_12;
                if (var8_5.takePending()) continue;
                var2_3 /* !! */  = var8_5;
                var3_11 /* !! */  = var7_12;
                var13_4.L$0 = var7_12;
                var2_3 /* !! */  = var8_5;
                var3_11 /* !! */  = var7_12;
                var13_4.L$1 = var9_14;
                var2_3 /* !! */  = var8_5;
                var3_11 /* !! */  = var7_12;
                var13_4.L$2 = var8_5;
                var2_3 /* !! */  = var8_5;
                var3_11 /* !! */  = var7_12;
                var13_4.L$3 = var12_15;
                var2_3 /* !! */  = var8_5;
                var3_11 /* !! */  = var7_12;
                var13_4.L$4 = var10_7;
                var2_3 /* !! */  = var8_5;
                var3_11 /* !! */  = var7_12;
                var13_4.label = 3;
                var2_3 /* !! */  = var8_5;
                var3_11 /* !! */  = var7_12;
                var11_13 = var8_5.awaitPending((Continuation<? super Unit>)var13_4);
                var5_8 = var12_15;
                var1_1 = var8_5;
                var4_10 = var7_12;
                var6_9 = var9_14;
                if (var11_13 != var15_6) break block45;
                return var15_6;
            }
            var11_13 = var10_7;
            ** while (true)
        }
    }

    @Override
    public boolean compareAndSet(T object, T object2) {
        block1: {
            if (object == null) {
                object = NullSurrogateKt.NULL;
            }
            if (object2 != null) break block1;
            object2 = NullSurrogateKt.NULL;
        }
        return this.updateState(object, object2);
    }

    @Override
    protected StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    protected StateFlowSlot[] createSlotArray(int n) {
        return new StateFlowSlot[n];
    }

    @Override
    public Object emit(T t, Continuation<? super Unit> continuation) {
        this.setValue(t);
        return Unit.INSTANCE;
    }

    @Override
    public Flow<T> fuse(CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, coroutineContext, n, bufferOverflow);
    }

    @Override
    public List<T> getReplayCache() {
        return CollectionsKt.listOf(this.getValue());
    }

    @Override
    public T getValue() {
        Object v;
        Symbol symbol = NullSurrogateKt.NULL;
        Object v2 = v = _state$FU.get(this);
        if (v == symbol) {
            v2 = null;
        }
        return (T)v2;
    }

    @Override
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override
    public void setValue(T object) {
        if (object == null) {
            object = NullSurrogateKt.NULL;
        }
        this.updateState(null, object);
    }

    @Override
    public boolean tryEmit(T t) {
        this.setValue(t);
        return true;
    }
}

