/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.DistinctFlowImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__DistinctKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u0007\u001aT\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u000726\u0010\t\u001a2\u0012\u0013\u0012\u0011H\b\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u0011H\b\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\u0001\u001a6\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u000f*\b\u0012\u0004\u0012\u0002H\b0\u00072\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u000f0\u0005\u001au\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00072\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00052:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0002\u00a2\u0006\u0002\b\u0011\"$\u0010\u0000\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u001e\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"defaultAreEquivalent", "Lkotlin/Function2;", "", "", "defaultKeySelector", "Lkotlin/Function1;", "distinctUntilChanged", "Lkotlinx/coroutines/flow/Flow;", "T", "areEquivalent", "Lkotlin/ParameterName;", "name", "old", "new", "distinctUntilChangedBy", "K", "keySelector", "distinctUntilChangedBy$FlowKt__DistinctKt", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__DistinctKt {
    private static final Function2<Object, Object, Boolean> defaultAreEquivalent;
    private static final Function1<Object, Object> defaultKeySelector;

    static {
        defaultKeySelector = defaultKeySelector.1.INSTANCE;
        defaultAreEquivalent = defaultAreEquivalent.1.INSTANCE;
    }

    public static final <T> Flow<T> distinctUntilChanged(Flow<? extends T> flow2) {
        if (!(flow2 instanceof StateFlow)) {
            flow2 = FlowKt__DistinctKt.distinctUntilChangedBy$FlowKt__DistinctKt(flow2, defaultKeySelector, defaultAreEquivalent);
        }
        return flow2;
    }

    public static final <T> Flow<T> distinctUntilChanged(Flow<? extends T> flow2, Function2<? super T, ? super T, Boolean> function2) {
        Function1<Object, Object> function1 = defaultKeySelector;
        Intrinsics.checkNotNull(function2, (String)"null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        return FlowKt__DistinctKt.distinctUntilChangedBy$FlowKt__DistinctKt(flow2, function1, (Function2<Object, Object, Boolean>)((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, (int)2)));
    }

    public static final <T, K> Flow<T> distinctUntilChangedBy(Flow<? extends T> flow2, Function1<? super T, ? extends K> function1) {
        return FlowKt__DistinctKt.distinctUntilChangedBy$FlowKt__DistinctKt(flow2, function1, defaultAreEquivalent);
    }

    private static final <T> Flow<T> distinctUntilChangedBy$FlowKt__DistinctKt(Flow<? extends T> flow2, Function1<? super T, ? extends Object> function1, Function2<Object, Object, Boolean> function2) {
        if (!(flow2 instanceof DistinctFlowImpl) || ((DistinctFlowImpl)flow2).keySelector != function1 || ((DistinctFlowImpl)flow2).areEquivalent != function2) {
            flow2 = new DistinctFlowImpl<T>(flow2, function1, function2);
        }
        return flow2;
    }
}

