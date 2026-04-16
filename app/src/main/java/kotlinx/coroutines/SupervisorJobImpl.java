/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2={"Lkotlinx/coroutines/SupervisorJobImpl;", "Lkotlinx/coroutines/JobImpl;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "childCancelled", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class SupervisorJobImpl
extends JobImpl {
    public SupervisorJobImpl(Job job2) {
        super(job2);
    }

    @Override
    public boolean childCancelled(Throwable throwable) {
        return false;
    }
}

