/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.internal.ThreadLocalElement;
import kotlinx.coroutines.internal.ThreadLocalKey;

@Metadata(d1={"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u0002H\u0002\u00a2\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u0003H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u0003H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2={"asContextElement", "Lkotlinx/coroutines/ThreadContextElement;", "T", "Ljava/lang/ThreadLocal;", "value", "(Ljava/lang/ThreadLocal;Ljava/lang/Object;)Lkotlinx/coroutines/ThreadContextElement;", "ensurePresent", "", "(Ljava/lang/ThreadLocal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPresent", "", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class ThreadContextElementKt {
    public static final <T> ThreadContextElement<T> asContextElement(ThreadLocal<T> threadLocal, T t) {
        return new ThreadLocalElement<T>(t, threadLocal);
    }

    public static /* synthetic */ ThreadContextElement asContextElement$default(ThreadLocal threadLocal, Object object, int n, Object object2) {
        if ((n & 1) != 0) {
            object = threadLocal.get();
        }
        return ThreadContextElementKt.asContextElement(threadLocal, object);
    }

    public static final Object ensurePresent(ThreadLocal<?> threadLocal, Continuation<? super Unit> continuation) {
        boolean bl = continuation.getContext().get((CoroutineContext.Key)new ThreadLocalKey(threadLocal)) != null;
        if (bl) {
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(("ThreadLocal " + threadLocal + " is missing from context " + continuation.getContext()).toString());
    }

    private static final Object ensurePresent$$forInline(ThreadLocal<?> threadLocal, Continuation<? super Unit> continuation) {
        InlineMarker.mark((int)3);
        throw new NullPointerException();
    }

    public static final Object isPresent(ThreadLocal<?> threadLocal, Continuation<? super Boolean> continuation) {
        boolean bl = continuation.getContext().get((CoroutineContext.Key)new ThreadLocalKey(threadLocal)) != null;
        return Boxing.boxBoolean((boolean)bl);
    }

    private static final Object isPresent$$forInline(ThreadLocal<?> threadLocal, Continuation<? super Boolean> continuation) {
        InlineMarker.mark((int)3);
        throw new NullPointerException();
    }
}

