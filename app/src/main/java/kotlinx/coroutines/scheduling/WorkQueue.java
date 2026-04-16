/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.internal.Ref$ObjectRef
 */
package kotlinx.coroutines.scheduling;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.ChannelSegment$$ExternalSyntheticBackportWithForwarding0;
import kotlinx.coroutines.scheduling.GlobalQueue;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TasksKt;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0016\u0010#\u001a\u0004\u0018\u00010\u00072\n\u0010$\u001a\u00060\tj\u0002`%H\u0002J\u001a\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\"\u0010(\u001a\u00020)2\n\u0010$\u001a\u00060\tj\u0002`%2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070+J$\u0010,\u001a\u00020)2\n\u0010$\u001a\u00060\tj\u0002`%2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070+H\u0002J\u000e\u0010-\u001a\u00020\u0018*\u0004\u0018\u00010\u0007H\u0002R\t\u0010\u0003\u001a\u00020\u0004X\u0082\u0004R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\t\u0010\f\u001a\u00020\u0004X\u0082\u0004R\u0011\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eX\u0082\u0004R\t\u0010\u000f\u001a\u00020\u0004X\u0082\u0004R\u0014\u0010\u0010\u001a\u00020\t8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b\u00a8\u0006."}, d2={"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "()V", "blockingTasksInBuffer", "Lkotlinx/atomicfu/AtomicInt;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Lkotlinx/coroutines/scheduling/Task;", "bufferSize", "", "getBufferSize", "()I", "consumerIndex", "lastScheduledTask", "Lkotlinx/atomicfu/AtomicRef;", "producerIndex", "size", "getSize$kotlinx_coroutines_core", "add", "task", "fair", "", "addLast", "offloadAllWorkTo", "", "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "poll", "pollBlocking", "pollBuffer", "pollCpu", "pollTo", "queue", "pollWithExclusiveMode", "onlyBlocking", "stealWithExclusiveMode", "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "tryExtractFromTheMiddle", "index", "trySteal", "", "stolenTaskRef", "Lkotlin/jvm/internal/Ref$ObjectRef;", "tryStealLastScheduled", "decrementIfBlocking", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class WorkQueue {
    private static final AtomicIntegerFieldUpdater blockingTasksInBuffer$FU;
    private static final AtomicIntegerFieldUpdater consumerIndex$FU;
    private static final AtomicReferenceFieldUpdater lastScheduledTask$FU;
    private static final AtomicIntegerFieldUpdater producerIndex$FU;
    @Volatile
    private volatile int blockingTasksInBuffer;
    private final AtomicReferenceArray<Task> buffer = new AtomicReferenceArray(128);
    @Volatile
    private volatile int consumerIndex;
    @Volatile
    private volatile Object lastScheduledTask;
    @Volatile
    private volatile int producerIndex;

    static {
        lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");
        producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
        consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
        blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");
    }

    public static /* synthetic */ Task add$default(WorkQueue workQueue, Task task, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return workQueue.add(task, bl);
    }

    private final Task addLast(Task task) {
        if (this.getBufferSize() == 127) {
            return task;
        }
        int n = task.taskContext.getTaskMode();
        int n2 = 1;
        if (n != 1) {
            n2 = 0;
        }
        if (n2 != 0) {
            blockingTasksInBuffer$FU.incrementAndGet(this);
        }
        n2 = producerIndex$FU.get(this) & 0x7F;
        while (this.buffer.get(n2) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(n2, task);
        producerIndex$FU.incrementAndGet(this);
        return null;
    }

    private final void decrementIfBlocking(Task task) {
        if (task != null) {
            int n = task.taskContext.getTaskMode();
            int n2 = 0;
            if ((n = n == 1 ? 1 : 0) != 0) {
                int n3 = blockingTasksInBuffer$FU.decrementAndGet(this);
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    n = n2;
                    if (n3 >= 0) {
                        n = 1;
                    }
                    if (n == 0) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    private final int getBufferSize() {
        return producerIndex$FU.get(this) - consumerIndex$FU.get(this);
    }

    private final Task pollBuffer() {
        Task task;
        int n;
        do {
            if ((n = consumerIndex$FU.get(this)) - producerIndex$FU.get(this) != 0) continue;
            return null;
        } while (!consumerIndex$FU.compareAndSet(this, n, n + 1) || (task = (Task)this.buffer.getAndSet(n & 0x7F, null)) == null);
        this.decrementIfBlocking(task);
        return task;
    }

    private final boolean pollTo(GlobalQueue globalQueue) {
        Task task = this.pollBuffer();
        if (task == null) {
            return false;
        }
        globalQueue.addLast(task);
        return true;
    }

    private final Task pollWithExclusiveMode(boolean bl) {
        int n;
        Task task;
        while ((task = (Task)lastScheduledTask$FU.get(this)) != null) {
            n = task.taskContext.getTaskMode();
            boolean bl2 = true;
            if (n != 1) {
                bl2 = false;
            }
            if (bl2 != bl) break;
            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(lastScheduledTask$FU, this, task, null)) continue;
            return task;
        }
        int n2 = consumerIndex$FU.get(this);
        n = producerIndex$FU.get(this);
        while (n2 != n) {
            if (bl && blockingTasksInBuffer$FU.get(this) == 0) {
                return null;
            }
            if ((task = this.tryExtractFromTheMiddle(--n, bl)) == null) continue;
            return task;
        }
        return null;
    }

    private final Task stealWithExclusiveMode(int n) {
        int n2 = consumerIndex$FU.get(this);
        int n3 = producerIndex$FU.get(this);
        boolean bl = true;
        if (n == 1) {
            n = n2;
        } else {
            bl = false;
            n = n2;
        }
        while (n != n3) {
            if (bl && blockingTasksInBuffer$FU.get(this) == 0) {
                return null;
            }
            Task task = this.tryExtractFromTheMiddle(n, bl);
            if (task == null) {
                ++n;
                continue;
            }
            return task;
        }
        return null;
    }

    private final Task tryExtractFromTheMiddle(int n, boolean bl) {
        Task task = this.buffer.get(n &= 0x7F);
        if (task != null) {
            int n2 = task.taskContext.getTaskMode();
            boolean bl2 = true;
            if (n2 != 1) {
                bl2 = false;
            }
            if (bl2 == bl && ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this.buffer, n, task, null)) {
                if (bl) {
                    blockingTasksInBuffer$FU.decrementAndGet(this);
                }
                return task;
            }
        }
        return null;
    }

    private final long tryStealLastScheduled(int n, Ref.ObjectRef<Task> objectRef) {
        Task task;
        do {
            if ((task = (Task)lastScheduledTask$FU.get(this)) == null) {
                return -2L;
            }
            int n2 = task.taskContext.getTaskMode();
            int n3 = 1;
            n2 = n2 == 1 ? 1 : 0;
            if (((n2 = n2 != 0 ? n3 : 2) & n) == 0) {
                return -2L;
            }
            long l = TasksKt.schedulerTimeSource.nanoTime() - task.submissionTime;
            if (l >= TasksKt.WORK_STEALING_TIME_RESOLUTION_NS) continue;
            return TasksKt.WORK_STEALING_TIME_RESOLUTION_NS - l;
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(lastScheduledTask$FU, this, task, null));
        objectRef.element = task;
        return -1L;
    }

    public final Task add(Task task, boolean bl) {
        if (bl) {
            return this.addLast(task);
        }
        if ((task = lastScheduledTask$FU.getAndSet(this, task)) == null) {
            return null;
        }
        return this.addLast(task);
    }

    public final int getSize$kotlinx_coroutines_core() {
        int n = lastScheduledTask$FU.get(this) != null ? this.getBufferSize() + 1 : this.getBufferSize();
        return n;
    }

    public final void offloadAllWorkTo(GlobalQueue globalQueue) {
        Task task = lastScheduledTask$FU.getAndSet(this, null);
        if (task != null) {
            globalQueue.addLast(task);
        }
        while (this.pollTo(globalQueue)) {
        }
    }

    public final Task poll() {
        Task task;
        Task task2 = task = (Task)lastScheduledTask$FU.getAndSet(this, null);
        if (task == null) {
            task2 = this.pollBuffer();
        }
        return task2;
    }

    public final Task pollBlocking() {
        return this.pollWithExclusiveMode(true);
    }

    public final Task pollCpu() {
        return this.pollWithExclusiveMode(false);
    }

    public final long trySteal(int n, Ref.ObjectRef<Task> objectRef) {
        Task task = n == 3 ? this.pollBuffer() : this.stealWithExclusiveMode(n);
        if (task != null) {
            objectRef.element = task;
            return -1L;
        }
        return this.tryStealLastScheduled(n, objectRef);
    }
}

