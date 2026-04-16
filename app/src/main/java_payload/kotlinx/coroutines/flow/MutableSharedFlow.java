/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\nH'J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0010R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2={"Lkotlinx/coroutines/flow/MutableSharedFlow;", "T", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/FlowCollector;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetReplayCache", "tryEmit", "", "(Ljava/lang/Object;)Z", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public interface MutableSharedFlow<T>
extends SharedFlow<T>,
FlowCollector<T> {
    @Override
    public Object emit(T var1, Continuation<? super Unit> var2);

    public StateFlow<Integer> getSubscriptionCount();

    public void resetReplayCache();

    public boolean tryEmit(T var1);
}

