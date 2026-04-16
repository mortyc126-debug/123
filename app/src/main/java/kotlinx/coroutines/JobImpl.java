/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.ChildHandleNode;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.JobSupport;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0003R\u0014\u0010\u0006\u001a\u00020\u0007X\u0090\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u0010"}, d2={"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "handlesException", "", "getHandlesException$kotlinx_coroutines_core", "()Z", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "complete", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public class JobImpl
extends JobSupport
implements CompletableJob {
    private final boolean handlesException;

    public JobImpl(Job job2) {
        super(true);
        this.initParentJob(job2);
        this.handlesException = this.handlesException();
    }

    private final boolean handlesException() {
        Object object = this.getParentHandle$kotlinx_coroutines_core();
        object = object instanceof ChildHandleNode ? (ChildHandleNode)object : null;
        if (object != null) {
            JobSupport jobSupport = ((JobNode)object).getJob();
            object = jobSupport;
            if (jobSupport != null) {
                do {
                    if (((JobSupport)object).getHandlesException$kotlinx_coroutines_core()) {
                        return true;
                    }
                    object = (object = ((JobSupport)object).getParentHandle$kotlinx_coroutines_core()) instanceof ChildHandleNode ? (ChildHandleNode)object : null;
                } while (object != null && (object = ((JobNode)object).getJob()) != null);
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean complete() {
        return this.makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
    }

    @Override
    public boolean completeExceptionally(Throwable throwable) {
        return this.makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(throwable, false, 2, null));
    }

    @Override
    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.handlesException;
    }

    @Override
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}

