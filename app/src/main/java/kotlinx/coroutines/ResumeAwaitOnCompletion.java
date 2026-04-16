/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.JobSupportKt;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class ResumeAwaitOnCompletion<T>
extends JobNode {
    private final CancellableContinuationImpl<T> continuation;

    public ResumeAwaitOnCompletion(CancellableContinuationImpl<? super T> cancellableContinuationImpl) {
        this.continuation = cancellableContinuationImpl;
    }

    @Override
    public void invoke(Throwable object) {
        object = this.getJob().getState$kotlinx_coroutines_core();
        if (DebugKt.getASSERTIONS_ENABLED() && !(object instanceof Incomplete ^ true)) {
            throw new AssertionError();
        }
        if (object instanceof CompletedExceptionally) {
            Continuation continuation = this.continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)((CompletedExceptionally)object).cause)));
        } else {
            Continuation continuation = this.continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl((Object)JobSupportKt.unboxState(object)));
        }
    }
}

