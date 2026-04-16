/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.ContinuationInterceptor
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DeferredCoroutine;
import kotlinx.coroutines.DispatchedCoroutine;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.LazyDeferredCoroutine;
import kotlinx.coroutines.LazyStandaloneCoroutine;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.UndispatchedCoroutine;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aU\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u00a2\u0006\u0002\b\rH\u0086@\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0002\u0010\u000e\u001a[\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0010\"\u0004\b\u0000\u0010\u0005*\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u001aF\u0010\u0014\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\u00020\u00152)\b\b\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u00a2\u0006\u0002\b\rH\u0086J\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\u001aO\u0010\u0017\u001a\u00020\u0018*\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2={"RESUMED", "", "SUSPENDED", "UNDECIDED", "withContext", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "async", "Lkotlinx/coroutines/Deferred;", "start", "Lkotlinx/coroutines/CoroutineStart;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "invoke", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launch", "Lkotlinx/coroutines/Job;", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/BuildersKt")
final class BuildersKt__Builders_commonKt {
    private static final int RESUMED = 2;
    private static final int SUSPENDED = 1;
    private static final int UNDECIDED = 0;

    public static final <T> Deferred<T> async(CoroutineScope deferredCoroutine, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        deferredCoroutine = CoroutineContextKt.newCoroutineContext(deferredCoroutine, coroutineContext);
        deferredCoroutine = coroutineStart.isLazy() ? (DeferredCoroutine)new LazyDeferredCoroutine((CoroutineContext)deferredCoroutine, function2) : new DeferredCoroutine((CoroutineContext)deferredCoroutine, true);
        deferredCoroutine.start(coroutineStart, deferredCoroutine, function2);
        return deferredCoroutine;
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int n, Object object) {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.async(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final <T> Object invoke(CoroutineDispatcher coroutineDispatcher, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return BuildersKt.withContext((CoroutineContext)coroutineDispatcher, function2, continuation);
    }

    private static final <T> Object invoke$$forInline(CoroutineDispatcher object, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        object = (CoroutineContext)object;
        InlineMarker.mark((int)0);
        object = BuildersKt.withContext((CoroutineContext)object, function2, continuation);
        InlineMarker.mark((int)1);
        return object;
    }

    public static final Job launch(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        coroutineScope = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        coroutineScope = coroutineStart.isLazy() ? (StandaloneCoroutine)new LazyStandaloneCoroutine((CoroutineContext)coroutineScope, function2) : new StandaloneCoroutine((CoroutineContext)coroutineScope, true);
        ((AbstractCoroutine)coroutineScope).start(coroutineStart, coroutineScope, function2);
        return (Job)((Object)coroutineScope);
    }

    public static /* synthetic */ Job launch$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int n, Object object) {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.launch(coroutineScope, coroutineContext, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>)function2);
    }

    public static final <T> Object withContext(CoroutineContext object, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Object object2 = continuation.getContext();
        object = CoroutineContextKt.newCoroutineContext(object2, (CoroutineContext)object);
        JobKt.ensureActive((CoroutineContext)object);
        if (object == object2) {
            object = new ScopeCoroutine<T>((CoroutineContext)object, continuation);
            object = UndispatchedKt.startUndispatchedOrReturn(object, object, function2);
        } else if (Intrinsics.areEqual((Object)object.get((CoroutineContext.Key)ContinuationInterceptor.Key), (Object)object2.get((CoroutineContext.Key)ContinuationInterceptor.Key))) {
            object = new UndispatchedCoroutine<T>((CoroutineContext)object, continuation);
            CoroutineContext coroutineContext = ((AbstractCoroutine)object).getContext();
            object2 = ThreadContextKt.updateThreadContext(coroutineContext, null);
            try {
                object = UndispatchedKt.startUndispatchedOrReturn((ScopeCoroutine)object, object, function2);
            }
            finally {
                ThreadContextKt.restoreThreadContext(coroutineContext, object2);
            }
        } else {
            object = new DispatchedCoroutine<T>((CoroutineContext)object, continuation);
            CancellableKt.startCoroutineCancellable$default(function2, object, (Continuation)object, null, 4, null);
            object = ((DispatchedCoroutine)object).getResult();
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return object;
    }
}

