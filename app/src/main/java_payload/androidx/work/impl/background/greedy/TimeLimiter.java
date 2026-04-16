/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.background.greedy;

import androidx.work.RunnableScheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.background.greedy.TimeLimiter$$ExternalSyntheticLambda0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Landroidx/work/impl/background/greedy/TimeLimiter;", "", "runnableScheduler", "Landroidx/work/RunnableScheduler;", "launcher", "Landroidx/work/impl/WorkLauncher;", "timeoutMs", "", "(Landroidx/work/RunnableScheduler;Landroidx/work/impl/WorkLauncher;J)V", "lock", "tracked", "", "Landroidx/work/impl/StartStopToken;", "Ljava/lang/Runnable;", "cancel", "", "token", "track", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class TimeLimiter {
    private final WorkLauncher launcher;
    private final Object lock;
    private final RunnableScheduler runnableScheduler;
    private final long timeoutMs;
    private final Map<StartStopToken, Runnable> tracked;

    public static /* synthetic */ void $r8$lambda$-vpfYFCUMjLBVsa47nEhUzlZ9xY(TimeLimiter timeLimiter, StartStopToken startStopToken) {
        TimeLimiter.track$lambda$0(timeLimiter, startStopToken);
    }

    public TimeLimiter(RunnableScheduler runnableScheduler, WorkLauncher workLauncher) {
        Intrinsics.checkNotNullParameter((Object)runnableScheduler, (String)"runnableScheduler");
        Intrinsics.checkNotNullParameter((Object)workLauncher, (String)"launcher");
        this(runnableScheduler, workLauncher, 0L, 4, null);
    }

    public TimeLimiter(RunnableScheduler runnableScheduler, WorkLauncher workLauncher, long l) {
        Intrinsics.checkNotNullParameter((Object)runnableScheduler, (String)"runnableScheduler");
        Intrinsics.checkNotNullParameter((Object)workLauncher, (String)"launcher");
        this.runnableScheduler = runnableScheduler;
        this.launcher = workLauncher;
        this.timeoutMs = l;
        this.lock = new Object();
        this.tracked = new LinkedHashMap();
    }

    public /* synthetic */ TimeLimiter(RunnableScheduler runnableScheduler, WorkLauncher workLauncher, long l, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            l = TimeUnit.MINUTES.toMillis(90L);
        }
        this(runnableScheduler, workLauncher, l);
    }

    private static final void track$lambda$0(TimeLimiter timeLimiter, StartStopToken startStopToken) {
        Intrinsics.checkNotNullParameter((Object)timeLimiter, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)startStopToken, (String)"$token");
        timeLimiter.launcher.stopWork(startStopToken, 3);
    }

    public final void cancel(StartStopToken object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"token");
        Object object2 = this.lock;
        synchronized (object2) {
            object = this.tracked.remove(object);
            // MONITOREXIT @DISABLED, blocks:[0, 1] lbl6 : MonitorExitStatement: MONITOREXIT : var2_3
            if (object != null) {
                this.runnableScheduler.cancel((Runnable)object);
            }
            return;
        }
    }

    public final void track(StartStopToken object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"token");
        TimeLimiter$$ExternalSyntheticLambda0 timeLimiter$$ExternalSyntheticLambda0 = new TimeLimiter$$ExternalSyntheticLambda0(this, (StartStopToken)object);
        Object object2 = this.lock;
        synchronized (object2) {
            object = this.tracked.put((StartStopToken)object, timeLimiter$$ExternalSyntheticLambda0);
            // MONITOREXIT @DISABLED, blocks:[0, 1] lbl7 : MonitorExitStatement: MONITOREXIT : var2_4
            this.runnableScheduler.scheduleWithDelay(this.timeoutMs, timeLimiter$$ExternalSyntheticLambda0);
            return;
        }
    }
}

