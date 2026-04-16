/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0002\u0010\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002R\t\u0010\b\u001a\u00020\tX\u0082\u0004\u00a8\u0006\u0013"}, d2={"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "_decision", "Lkotlinx/atomicfu/AtomicInt;", "afterCompletion", "", "state", "", "afterResume", "getResult", "tryResume", "", "trySuspend", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class DispatchedCoroutine<T>
extends ScopeCoroutine<T> {
    private static final AtomicIntegerFieldUpdater _decision$FU = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision");
    @Volatile
    private volatile int _decision;

    public DispatchedCoroutine(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Unit> function1, Object object) {
        while (true) {
            function1.invoke((Object)atomicIntegerFieldUpdater.get(object));
        }
    }

    private final boolean tryResume() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decision$FU;
        do {
            switch (atomicIntegerFieldUpdater.get(this)) {
                default: {
                    throw new IllegalStateException("Already resumed".toString());
                }
                case 1: {
                    return false;
                }
                case 0: 
            }
        } while (!_decision$FU.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean trySuspend() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decision$FU;
        do {
            switch (atomicIntegerFieldUpdater.get(this)) {
                default: {
                    throw new IllegalStateException("Already suspended".toString());
                }
                case 2: {
                    return false;
                }
                case 0: 
            }
        } while (!_decision$FU.compareAndSet(this, 0, 1));
        return true;
    }

    @Override
    protected void afterCompletion(Object object) {
        this.afterResume(object);
    }

    @Override
    protected void afterResume(Object object) {
        if (this.tryResume()) {
            return;
        }
        DispatchedContinuationKt.resumeCancellableWith$default(IntrinsicsKt.intercepted((Continuation)this.uCont), CompletionStateKt.recoverResult(object, this.uCont), null, 2, null);
    }

    public final Object getResult() {
        if (this.trySuspend()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object object = JobSupportKt.unboxState(this.getState$kotlinx_coroutines_core());
        if (!(object instanceof CompletedExceptionally)) {
            return object;
        }
        throw ((CompletedExceptionally)object).cause;
    }
}

