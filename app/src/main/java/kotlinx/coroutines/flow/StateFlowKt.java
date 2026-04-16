/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u0005\u00a2\u0006\u0002\u0010\u0007\u001a6\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a2\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00050\u0013H\u0086\b\u00a2\u0006\u0002\u0010\u0014\u001a-\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00050\u0013H\u0086\b\u001a2\u0010\u0017\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00050\u0013H\u0086\b\u00a2\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"NONE", "Lkotlinx/coroutines/internal/Symbol;", "PENDING", "MutableStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "T", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "fuseStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/StateFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "getAndUpdate", "function", "Lkotlin/Function1;", "(Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "update", "", "updateAndGet", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class StateFlowKt {
    private static final Symbol NONE = new Symbol("NONE");
    private static final Symbol PENDING = new Symbol("PENDING");

    public static final <T> MutableStateFlow<T> MutableStateFlow(T object) {
        if (object == null) {
            object = NullSurrogateKt.NULL;
        }
        return new StateFlowImpl(object);
    }

    public static final /* synthetic */ Symbol access$getNONE$p() {
        return NONE;
    }

    public static final /* synthetic */ Symbol access$getPENDING$p() {
        return PENDING;
    }

    public static final <T> Flow<T> fuseStateFlow(StateFlow<? extends T> stateFlow, CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        boolean bl;
        boolean bl2 = DebugKt.getASSERTIONS_ENABLED();
        boolean bl3 = true;
        if (bl2 && !(bl = n != -1)) {
            throw new AssertionError();
        }
        bl = n >= 0 && n < 2 ? bl3 : false;
        if ((bl || n == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) {
            return stateFlow;
        }
        return SharedFlowKt.fuseSharedFlow((SharedFlow)stateFlow, coroutineContext, n, bufferOverflow);
    }

    public static final <T> T getAndUpdate(MutableStateFlow<T> mutableStateFlow, Function1<? super T, ? extends T> function1) {
        T t;
        while (!mutableStateFlow.compareAndSet(t = mutableStateFlow.getValue(), function1.invoke(t))) {
        }
        return t;
    }

    public static final <T> void update(MutableStateFlow<T> mutableStateFlow, Function1<? super T, ? extends T> function1) {
        T t;
        while (!mutableStateFlow.compareAndSet(t = mutableStateFlow.getValue(), function1.invoke(t))) {
        }
    }

    public static final <T> T updateAndGet(MutableStateFlow<T> mutableStateFlow, Function1<? super T, ? extends T> function1) {
        Object object;
        T t;
        while (!mutableStateFlow.compareAndSet(t = mutableStateFlow.getValue(), object = function1.invoke(t))) {
        }
        return (T)object;
    }
}

