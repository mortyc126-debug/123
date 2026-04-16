/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancelHandlerBase;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletionHandlerBase;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobNode;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\r\u000eB\u001b\u0012\u0014\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\t\u0010\b\u001a\u00020\tX\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2={"Lkotlinx/coroutines/AwaitAll;", "T", "", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;)V", "[Lkotlinx/coroutines/Deferred;", "notCompletedCount", "Lkotlinx/atomicfu/AtomicInt;", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class AwaitAll<T> {
    private static final AtomicIntegerFieldUpdater notCompletedCount$FU = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount");
    private final Deferred<T>[] deferreds;
    @Volatile
    private volatile int notCompletedCount;

    public AwaitAll(Deferred<? extends T>[] deferredArray) {
        this.deferreds = deferredArray;
        this.notCompletedCount = this.deferreds.length;
    }

    public final Object await(Continuation<? super List<? extends T>> continuation) {
        Object object;
        int n;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Object object2 = cancellableContinuationImpl;
        int n2 = this.deferreds.length;
        AwaitAllNode[] awaitAllNodeArray = new AwaitAllNode[n2];
        int n3 = 0;
        for (n = 0; n < n2; ++n) {
            Deferred deferred = this.deferreds[n];
            deferred.start();
            object = new AwaitAllNode(this, object2);
            ((AwaitAllNode)object).setHandle(deferred.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)((CompletionHandlerBase)object))));
            deferred = Unit.INSTANCE;
            awaitAllNodeArray[n] = object;
        }
        object = new DisposeHandlersOnCancel(this, awaitAllNodeArray);
        n2 = awaitAllNodeArray.length;
        for (n = n3; n < n2; ++n) {
            awaitAllNodeArray[n].setDisposer((DisposeHandlersOnCancel)object);
        }
        if (object2.isCompleted()) {
            ((DisposeHandlersOnCancel)object).disposeAll();
        } else {
            object2.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)((CancelHandlerBase)object)));
        }
        object2 = cancellableContinuationImpl.getResult();
        if (object2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return object2;
    }

    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002R\u001b\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0018\u00010\bR\b\u0012\u0004\u0012\u00028\u00000\t0\u0007X\u0082\u0004R\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R<\u0010\u000b\u001a\u000e\u0018\u00010\bR\b\u0012\u0004\u0012\u00028\u00000\t2\u0012\u0010\n\u001a\u000e\u0018\u00010\bR\b\u0012\u0004\u0012\u00028\u00000\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2={"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;)V", "_disposer", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "disposer", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private final class AwaitAllNode
    extends JobNode {
        private static final AtomicReferenceFieldUpdater _disposer$FU = AtomicReferenceFieldUpdater.newUpdater(AwaitAllNode.class, Object.class, "_disposer");
        @Volatile
        private volatile Object _disposer;
        private final CancellableContinuation<List<? extends T>> continuation;
        public DisposableHandle handle;
        final AwaitAll<T> this$0;

        public AwaitAllNode(AwaitAll awaitAll, CancellableContinuation<? super List<? extends T>> cancellableContinuation) {
            this.this$0 = awaitAll;
            this.continuation = cancellableContinuation;
        }

        public final DisposeHandlersOnCancel getDisposer() {
            return (DisposeHandlersOnCancel)_disposer$FU.get(this);
        }

        public final DisposableHandle getHandle() {
            DisposableHandle disposableHandle = this.handle;
            if (disposableHandle != null) {
                return disposableHandle;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"handle");
            return null;
        }

        @Override
        public void invoke(Throwable object) {
            if (object != null) {
                if ((object = this.continuation.tryResumeWithException((Throwable)object)) != null) {
                    this.continuation.completeResume(object);
                    object = this.getDisposer();
                    if (object != null) {
                        ((DisposeHandlersOnCancel)object).disposeAll();
                    }
                }
            } else if (notCompletedCount$FU.decrementAndGet(this.this$0) == 0) {
                object = this.continuation;
                Result.Companion companion = this.this$0.deferreds;
                Collection collection = new ArrayList(((Deferred[])companion).length);
                int n = ((Deferred[])companion).length;
                for (int i = 0; i < n; ++i) {
                    collection.add(companion[i].getCompleted());
                }
                collection = (List)collection;
                companion = Result.Companion;
                object.resumeWith(Result.constructor-impl((Object)collection));
            }
        }

        public final void setDisposer(DisposeHandlersOnCancel disposeHandlersOnCancel) {
            _disposer$FU.set(this, disposeHandlersOnCancel);
        }

        public final void setHandle(DisposableHandle disposableHandle) {
            this.handle = disposableHandle;
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\b\u001a\u00020\tJ\u0013\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007\u00a8\u0006\u000f"}, d2={"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private final class DisposeHandlersOnCancel
    extends CancelHandler {
        private final AwaitAllNode[] nodes;
        final AwaitAll<T> this$0;

        public DisposeHandlersOnCancel(AwaitAll awaitAll, AwaitAllNode[] awaitAllNodeArray) {
            this.this$0 = awaitAll;
            this.nodes = awaitAllNodeArray;
        }

        public final void disposeAll() {
            AwaitAllNode[] awaitAllNodeArray = this.nodes;
            int n = awaitAllNodeArray.length;
            for (int i = 0; i < n; ++i) {
                awaitAllNodeArray[i].getHandle().dispose();
            }
        }

        @Override
        public void invoke(Throwable throwable) {
            this.disposeAll();
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.nodes + ']';
        }
    }
}

