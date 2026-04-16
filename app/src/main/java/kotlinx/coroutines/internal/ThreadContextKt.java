/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.ThreadState;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\" \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "updateState", "Lkotlinx/coroutines/internal/ThreadState;", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class ThreadContextKt {
    public static final Symbol NO_THREAD_ELEMENTS = new Symbol("NO_THREAD_ELEMENTS");
    private static final Function2<Object, CoroutineContext.Element, Object> countAll = countAll.1.INSTANCE;
    private static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> findOne = findOne.1.INSTANCE;
    private static final Function2<ThreadState, CoroutineContext.Element, ThreadState> updateState = updateState.1.INSTANCE;

    public static final void restoreThreadContext(CoroutineContext coroutineContext, Object object) {
        if (object == NO_THREAD_ELEMENTS) {
            return;
        }
        if (object instanceof ThreadState) {
            ((ThreadState)object).restore(coroutineContext);
        } else {
            Object object2 = coroutineContext.fold(null, findOne);
            Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((ThreadContextElement)object2).restoreThreadContext(coroutineContext, object);
        }
    }

    public static final Object threadContextElements(CoroutineContext object) {
        object = object.fold((Object)0, countAll);
        Intrinsics.checkNotNull((Object)object);
        return object;
    }

    public static final Object updateThreadContext(CoroutineContext object, Object object2) {
        if (object2 == null) {
            object2 = ThreadContextKt.threadContextElements(object);
        }
        if (object2 == Integer.valueOf(0)) {
            object = NO_THREAD_ELEMENTS;
        } else if (object2 instanceof Integer) {
            object = object.fold((Object)new ThreadState((CoroutineContext)object, ((Number)object2).intValue()), updateState);
        } else {
            Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            object = ((ThreadContextElement)object2).updateThreadContext((CoroutineContext)object);
        }
        return object;
    }
}

