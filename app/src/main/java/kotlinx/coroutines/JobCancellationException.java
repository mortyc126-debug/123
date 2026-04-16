/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0010\u0010\b\u001a\u00020\t8\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "createCopy", "equals", "", "other", "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class JobCancellationException
extends CancellationException
implements CopyableThrowable<JobCancellationException> {
    public final transient Job job;

    public JobCancellationException(String string2, Throwable throwable, Job job2) {
        super(string2);
        this.job = job2;
        if (throwable != null) {
            this.initCause(throwable);
        }
    }

    @Override
    public JobCancellationException createCopy() {
        if (DebugKt.getDEBUG()) {
            String string2 = this.getMessage();
            Intrinsics.checkNotNull((Object)string2);
            return new JobCancellationException(string2, this, this.job);
        }
        return null;
    }

    public boolean equals(Object object) {
        boolean bl = object == this || object instanceof JobCancellationException && Intrinsics.areEqual((Object)((JobCancellationException)object).getMessage(), (Object)this.getMessage()) && Intrinsics.areEqual((Object)((JobCancellationException)object).job, (Object)this.job) && Intrinsics.areEqual((Object)((JobCancellationException)object).getCause(), (Object)this.getCause());
        return bl;
    }

    @Override
    public Throwable fillInStackTrace() {
        if (DebugKt.getDEBUG()) {
            return super.fillInStackTrace();
        }
        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        Object object = this.getMessage();
        Intrinsics.checkNotNull((Object)object);
        int n = ((String)object).hashCode();
        int n2 = this.job.hashCode();
        object = this.getCause();
        int n3 = object != null ? object.hashCode() : 0;
        return (n * 31 + n2) * 31 + n3;
    }

    @Override
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }
}

