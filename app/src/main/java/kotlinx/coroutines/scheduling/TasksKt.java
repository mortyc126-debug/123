/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.scheduling.NanoTimeSource;
import kotlinx.coroutines.scheduling.SchedulerTimeSource;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;
import kotlinx.coroutines.scheduling.TaskContextImpl;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0080T\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\u00078\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u0012\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0002\n\u0000\"\u0019\u0010\u000f\u001a\u00020\u0010*\u00020\u00118\u00c0\u0002X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0013"}, d2={"BlockingContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "CORE_POOL_SIZE", "", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "NonBlockingContext", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class TasksKt {
    public static final TaskContext BlockingContext;
    public static final int CORE_POOL_SIZE;
    public static final String DEFAULT_SCHEDULER_NAME;
    public static final long IDLE_WORKER_KEEP_ALIVE_NS;
    public static final int MAX_POOL_SIZE;
    public static final TaskContext NonBlockingContext;
    public static final int TASK_NON_BLOCKING = 0;
    public static final int TASK_PROBABLY_BLOCKING = 1;
    public static final long WORK_STEALING_TIME_RESOLUTION_NS;
    public static SchedulerTimeSource schedulerTimeSource;

    static {
        DEFAULT_SCHEDULER_NAME = SystemPropsKt.systemProp("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");
        WORK_STEALING_TIME_RESOLUTION_NS = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        CORE_POOL_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.coerceAtLeast((int)SystemPropsKt.getAVAILABLE_PROCESSORS(), (int)2), 1, 0, 8, null);
        MAX_POOL_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", 0x1FFFFE, 0, 0x1FFFFE, 4, null);
        IDLE_WORKER_KEEP_ALIVE_NS = TimeUnit.SECONDS.toNanos(SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null));
        schedulerTimeSource = NanoTimeSource.INSTANCE;
        NonBlockingContext = new TaskContextImpl(0);
        BlockingContext = new TaskContextImpl(1);
    }

    public static final boolean isBlocking(Task task) {
        int n = task.taskContext.getTaskMode();
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        return bl;
    }
}

