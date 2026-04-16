/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;

@Deprecated(level=DeprecationLevel.ERROR, message="This is internal API and may be removed in the future releases")
@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H'\u00a8\u0006\u0005"}, d2={"Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/Job;", "getChildJobCancellationCause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public interface ParentJob
extends Job {
    public CancellationException getChildJobCancellationCause();

    @Metadata(k=3, mv={1, 8, 0}, xi=48)
    public static final class DefaultImpls {
        @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public static /* synthetic */ void cancel(ParentJob parentJob) {
            Job.DefaultImpls.cancel(parentJob);
        }

        public static <R> R fold(ParentJob parentJob, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return Job.DefaultImpls.fold(parentJob, r, function2);
        }

        public static <E extends CoroutineContext.Element> E get(ParentJob parentJob, CoroutineContext.Key<E> key) {
            return Job.DefaultImpls.get(parentJob, key);
        }

        public static CoroutineContext minusKey(ParentJob parentJob, CoroutineContext.Key<?> key) {
            return Job.DefaultImpls.minusKey(parentJob, key);
        }

        public static CoroutineContext plus(ParentJob parentJob, CoroutineContext coroutineContext) {
            return Job.DefaultImpls.plus((Job)parentJob, coroutineContext);
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static Job plus(ParentJob parentJob, Job job2) {
            return Job.DefaultImpls.plus((Job)parentJob, job2);
        }
    }
}

