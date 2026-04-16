/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.random.Random
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.scheduling.GlobalQueue;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;
import kotlinx.coroutines.scheduling.TaskImpl;
import kotlinx.coroutines.scheduling.TasksKt;
import kotlinx.coroutines.scheduling.WorkQueue;

@Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\u0000\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0003IJKB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0011\u0010\r\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0086\bJ\u0011\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0082\bJ\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0004H\u0002J\u001a\u0010&\u001a\u00020 2\n\u0010'\u001a\u00060(j\u0002`)2\u0006\u0010*\u001a\u00020+J\u0011\u0010\u0012\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0082\bJ\u000e\u0010,\u001a\b\u0018\u00010\u001dR\u00020\u0000H\u0002J\t\u0010-\u001a\u00020$H\u0082\bJ\t\u0010.\u001a\u00020\u0004H\u0082\bJ&\u0010/\u001a\u00020$2\n\u0010'\u001a\u00060(j\u0002`)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00100\u001a\u00020\u0018J\u0014\u00101\u001a\u00020$2\n\u00102\u001a\u00060(j\u0002`)H\u0016J\t\u00103\u001a\u00020\u0007H\u0082\bJ\t\u00104\u001a\u00020\u0004H\u0082\bJ\u0014\u00105\u001a\u00020\u00042\n\u00106\u001a\u00060\u001dR\u00020\u0000H\u0002J\u000e\u00107\u001a\b\u0018\u00010\u001dR\u00020\u0000H\u0002J\u0012\u00108\u001a\u00020\u00182\n\u00106\u001a\u00060\u001dR\u00020\u0000J\"\u00109\u001a\u00020$2\n\u00106\u001a\u00060\u001dR\u00020\u00002\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0004J\t\u0010<\u001a\u00020\u0007H\u0082\bJ\u000e\u0010=\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020\u0007J\u0018\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0018H\u0002J\u0006\u0010C\u001a\u00020$J\b\u0010D\u001a\u00020\tH\u0016J\t\u0010E\u001a\u00020\u0018H\u0082\bJ\u0012\u0010F\u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0007H\u0002J\b\u0010G\u001a\u00020\u0018H\u0002J$\u0010H\u001a\u0004\u0018\u00010 *\b\u0018\u00010\u001dR\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u00100\u001a\u00020\u0018H\u0002R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u0015\u0010\r\u001a\u00020\u00048\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\t\u0010\u0010\u001a\u00020\u0011X\u0082\u0004R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u0012\u001a\u00020\u00048\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0010\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\t\u0010\u001a\u001a\u00020\u0011X\u0082\u0004R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u001dR\u00020\u00000\u001c8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006L"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "(IIJLjava/lang/String;)V", "_isTerminated", "Lkotlinx/atomicfu/AtomicBoolean;", "availableCpuPermits", "getAvailableCpuPermits", "()I", "controlState", "Lkotlinx/atomicfu/AtomicLong;", "createdWorkers", "getCreatedWorkers", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "isTerminated", "", "()Z", "parkedWorkersStack", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "addToGlobalQueue", "task", "Lkotlinx/coroutines/scheduling/Task;", "state", "blockingTasks", "close", "", "createNewWorker", "createTask", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "currentWorker", "decrementBlockingTasks", "decrementCreatedWorkers", "dispatch", "tailDispatch", "execute", "command", "incrementBlockingTasks", "incrementCreatedWorkers", "parkedWorkersStackNextIndex", "worker", "parkedWorkersStackPop", "parkedWorkersStackPush", "parkedWorkersStackTopUpdate", "oldIndex", "newIndex", "releaseCpuPermit", "runSafely", "shutdown", "timeout", "signalBlockingWork", "stateSnapshot", "skipUnpark", "signalCpuWork", "toString", "tryAcquireCpuPermit", "tryCreateWorker", "tryUnpark", "submitToLocalQueue", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class CoroutineScheduler
implements Executor,
Closeable {
    private static final long BLOCKING_MASK = 4398044413952L;
    private static final int BLOCKING_SHIFT = 21;
    private static final int CLAIMED = 0;
    private static final long CPU_PERMITS_MASK = 9223367638808264704L;
    private static final int CPU_PERMITS_SHIFT = 42;
    private static final long CREATED_MASK = 0x1FFFFFL;
    public static final Companion Companion = new Companion(null);
    public static final int MAX_SUPPORTED_POOL_SIZE = 0x1FFFFE;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    public static final Symbol NOT_IN_STACK;
    private static final int PARKED = -1;
    private static final long PARKED_INDEX_MASK = 0x1FFFFFL;
    private static final long PARKED_VERSION_INC = 0x200000L;
    private static final long PARKED_VERSION_MASK = -2097152L;
    private static final int TERMINATED = 1;
    private static final AtomicIntegerFieldUpdater _isTerminated$FU;
    private static final AtomicLongFieldUpdater controlState$FU;
    private static final AtomicLongFieldUpdater parkedWorkersStack$FU;
    @Volatile
    private volatile int _isTerminated;
    @Volatile
    private volatile long controlState;
    public final int corePoolSize;
    public final GlobalQueue globalBlockingQueue;
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    @Volatile
    private volatile long parkedWorkersStack;
    public final String schedulerName;
    public final ResizableAtomicArray<Worker> workers;

    static {
        parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
        controlState$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
        _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
        NOT_IN_STACK = new Symbol("NOT_IN_STACK");
    }

    public CoroutineScheduler(int n, int n2, long l, String string2) {
        this.corePoolSize = n;
        this.maxPoolSize = n2;
        this.idleWorkerKeepAliveNs = l;
        this.schedulerName = string2;
        n = this.corePoolSize >= 1 ? 1 : 0;
        if (n != 0) {
            n = this.maxPoolSize >= this.corePoolSize ? 1 : 0;
            if (n != 0) {
                n = this.maxPoolSize <= 0x1FFFFE ? 1 : 0;
                if (n != 0) {
                    n = this.idleWorkerKeepAliveNs > 0L ? 1 : 0;
                    if (n != 0) {
                        this.globalCpuQueue = new GlobalQueue();
                        this.globalBlockingQueue = new GlobalQueue();
                        this.workers = new ResizableAtomicArray((this.corePoolSize + 1) * 2);
                        this.controlState = (long)this.corePoolSize << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + this.idleWorkerKeepAliveNs + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + this.maxPoolSize + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + this.maxPoolSize + " should be greater than or equals to core pool size " + this.corePoolSize).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + this.corePoolSize + " should be at least 1").toString());
    }

    public /* synthetic */ CoroutineScheduler(int n, int n2, long l, String string2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 4) != 0) {
            l = TasksKt.IDLE_WORKER_KEEP_ALIVE_NS;
        }
        if ((n3 & 8) != 0) {
            string2 = TasksKt.DEFAULT_SCHEDULER_NAME;
        }
        this(n, n2, l, string2);
    }

    private final boolean addToGlobalQueue(Task task) {
        int n = task.taskContext.getTaskMode();
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        boolean bl2 = bl ? this.globalBlockingQueue.addLast(task) : this.globalCpuQueue.addLast(task);
        return bl2;
    }

    private final int blockingTasks(long l) {
        return (int)((0x3FFFFE00000L & l) >> 21);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final int createNewWorker() {
        var8_1 = this.workers;
        synchronized (var8_1) {
            block16: {
                block15: {
                    var4_2 = this.isTerminated();
                    if (var4_2) {
                        return -1;
                    }
                    var5_3 = CoroutineScheduler.controlState$FU.get(this);
                    var1_4 = (int)(var5_3 & 0x1FFFFFL);
                    var2_5 = (int)((4398044413952L & var5_3) >> 21);
                    if ((var2_5 = RangesKt.coerceAtLeast((int)(var1_4 - var2_5), (int)0)) >= (var3_6 = this.corePoolSize)) {
                        return 0;
                    }
                    var3_6 = this.maxPoolSize;
                    if (var1_4 >= var3_6) {
                        return 0;
                    }
                    var5_3 = CoroutineScheduler.access$getControlState$FU$p().get(this);
                    var3_6 = (int)(var5_3 & 0x1FFFFFL) + 1;
                    if (var3_6 <= 0) ** GOTO lbl-1000
                    try {
                        if (this.workers.get(var3_6) == null) {
                            var1_4 = 1;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var1_4 = 0;
                        }
                        if (var1_4 == 0) break block15;
                        var7_8 = new Worker(this, var3_6);
                        this.workers.setSynchronized(var3_6, (Worker)var7_8);
                        var5_3 = CoroutineScheduler.controlState$FU.incrementAndGet(this);
                    }
                    catch (Throwable var7_7) {}
                    var1_4 = (int)(var5_3 & 0x1FFFFFL);
                    var1_4 = var3_6 == var1_4 ? 1 : 0;
                    if (var1_4 != 0) {
                        // MONITOREXIT @DISABLED, blocks:[7, 9] lbl32 : MonitorExitStatement: MONITOREXIT : var8_1
                        var7_8.start();
                        return var2_5 + 1;
                    }
                    var7_8 = new IllegalArgumentException("Failed requirement.".toString());
                    throw var7_8;
                    break block16;
                }
                var7_9 = new IllegalArgumentException("Failed requirement.".toString());
                throw var7_9;
            }
            throw var7_7;
        }
    }

    private final int createdWorkers(long l) {
        return (int)(0x1FFFFFL & l);
    }

    private final Worker currentWorker() {
        Thread thread = Thread.currentThread();
        boolean bl = thread instanceof Worker;
        Thread thread2 = null;
        thread = bl ? (Worker)thread : null;
        Thread thread3 = thread2;
        if (thread != null) {
            thread3 = thread2;
            if (Intrinsics.areEqual((Object)((Worker)thread).this$0, (Object)this)) {
                thread3 = thread;
            }
        }
        return thread3;
    }

    private final void decrementBlockingTasks() {
        CoroutineScheduler.controlState$FU.addAndGet(this, -2097152L);
    }

    private final int decrementCreatedWorkers() {
        return (int)(0x1FFFFFL & CoroutineScheduler.controlState$FU.getAndDecrement(this));
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable2, TaskContext taskContext, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            taskContext = TasksKt.NonBlockingContext;
        }
        if ((n & 4) != 0) {
            bl = false;
        }
        coroutineScheduler.dispatch(runnable2, taskContext, bl);
    }

    private final int getAvailableCpuPermits() {
        return (int)((0x7FFFFC0000000000L & controlState$FU.get(this)) >> 42);
    }

    private final int getCreatedWorkers() {
        return (int)(CoroutineScheduler.controlState$FU.get(this) & 0x1FFFFFL);
    }

    private final long incrementBlockingTasks() {
        return controlState$FU.addAndGet(this, 0x200000L);
    }

    private final int incrementCreatedWorkers() {
        return (int)(0x1FFFFFL & controlState$FU.incrementAndGet(this));
    }

    private final void loop$atomicfu(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function1, Object object) {
        while (true) {
            function1.invoke((Object)atomicLongFieldUpdater.get(object));
        }
    }

    private final int parkedWorkersStackNextIndex(Worker object) {
        object = ((Worker)object).getNextParkedWorker();
        while (object != NOT_IN_STACK) {
            if (object == null) {
                return 0;
            }
            int n = ((Worker)(object = (Worker)object)).getIndexInArray();
            if (n != 0) {
                return n;
            }
            object = ((Worker)object).getNextParkedWorker();
        }
        return -1;
    }

    private final Worker parkedWorkersStackPop() {
        long l;
        Worker worker;
        int n;
        AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$FU;
        do {
            if ((worker = this.workers.get(n = (int)(0x1FFFFFL & (l = atomicLongFieldUpdater.get(this))))) != null) continue;
            return null;
        } while ((n = this.parkedWorkersStackNextIndex(worker)) < 0 || !parkedWorkersStack$FU.compareAndSet(this, l, 0x200000L + l & 0xFFFFFFFFFFE00000L | (long)n));
        worker.setNextParkedWorker(NOT_IN_STACK);
        return worker;
    }

    private final long releaseCpuPermit() {
        return CoroutineScheduler.controlState$FU.addAndGet(this, 0x40000000000L);
    }

    private final void signalBlockingWork(long l, boolean bl) {
        if (bl) {
            return;
        }
        if (this.tryUnpark()) {
            return;
        }
        if (this.tryCreateWorker(l)) {
            return;
        }
        this.tryUnpark();
    }

    private final Task submitToLocalQueue(Worker worker, Task task, boolean bl) {
        if (worker == null) {
            return task;
        }
        if (worker.state == WorkerState.TERMINATED) {
            return task;
        }
        if (task.taskContext.getTaskMode() == 0 && worker.state == WorkerState.BLOCKING) {
            return task;
        }
        worker.mayHaveLocalTasks = true;
        return worker.localQueue.add(task, bl);
    }

    private final boolean tryAcquireCpuPermit() {
        long l;
        AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.controlState$FU;
        do {
            if ((int)((0x7FFFFC0000000000L & (l = atomicLongFieldUpdater.get(this))) >> 42) != 0) continue;
            return false;
        } while (!CoroutineScheduler.controlState$FU.compareAndSet(this, l, l - 0x40000000000L));
        return true;
    }

    private final boolean tryCreateWorker(long l) {
        int n = (int)(0x1FFFFFL & l);
        int n2 = (int)((0x3FFFFE00000L & l) >> 21);
        if (RangesKt.coerceAtLeast((int)(n - n2), (int)0) < this.corePoolSize) {
            n2 = this.createNewWorker();
            if (n2 == 1 && this.corePoolSize > 1) {
                this.createNewWorker();
            }
            if (n2 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean tryCreateWorker$default(CoroutineScheduler coroutineScheduler, long l, int n, Object object) {
        if ((n & 1) != 0) {
            l = controlState$FU.get(coroutineScheduler);
        }
        return coroutineScheduler.tryCreateWorker(l);
    }

    private final boolean tryUnpark() {
        Worker worker;
        do {
            if ((worker = this.parkedWorkersStackPop()) != null) continue;
            return false;
        } while (!Worker.getWorkerCtl$FU().compareAndSet(worker, -1, 0));
        LockSupport.unpark(worker);
        return true;
    }

    public final int availableCpuPermits(long l) {
        return (int)((0x7FFFFC0000000000L & l) >> 42);
    }

    @Override
    public void close() {
        this.shutdown(10000L);
    }

    public final Task createTask(Runnable runnable2, TaskContext taskContext) {
        long l = TasksKt.schedulerTimeSource.nanoTime();
        if (runnable2 instanceof Task) {
            ((Task)runnable2).submissionTime = l;
            ((Task)runnable2).taskContext = taskContext;
            return (Task)runnable2;
        }
        return new TaskImpl(runnable2, l, taskContext);
    }

    public final void dispatch(Runnable runnable2, TaskContext object, boolean bl) {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        if (abstractTimeSource != null) {
            abstractTimeSource.trackTask();
        }
        object = this.createTask(runnable2, (TaskContext)object);
        int n = ((Task)object).taskContext.getTaskMode();
        boolean bl2 = false;
        n = n == 1 ? 1 : 0;
        long l = n != 0 ? controlState$FU.addAndGet(this, 0x200000L) : 0L;
        runnable2 = this.currentWorker();
        object = this.submitToLocalQueue((Worker)runnable2, (Task)object, bl);
        if (object != null && !this.addToGlobalQueue((Task)object)) {
            throw new RejectedExecutionException(this.schedulerName + " was terminated");
        }
        boolean bl3 = bl2;
        if (bl) {
            bl3 = bl2;
            if (runnable2 != null) {
                bl3 = true;
            }
        }
        if (n != 0) {
            this.signalBlockingWork(l, bl3);
        } else {
            if (bl3) {
                return;
            }
            this.signalCpuWork();
        }
    }

    @Override
    public void execute(Runnable runnable2) {
        CoroutineScheduler.dispatch$default(this, runnable2, null, false, 6, null);
    }

    public final boolean isTerminated() {
        boolean bl = _isTerminated$FU.get(this) != 0;
        return bl;
    }

    public final boolean parkedWorkersStackPush(Worker worker) {
        int n;
        long l;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$FU;
        do {
            boolean bl;
            l = atomicLongFieldUpdater.get(this);
            int n2 = (int)(0x1FFFFFL & l);
            n = worker.getIndexInArray();
            if (DebugKt.getASSERTIONS_ENABLED() && !(bl = n != 0)) {
                throw new AssertionError();
            }
            worker.setNextParkedWorker(this.workers.get(n2));
        } while (!parkedWorkersStack$FU.compareAndSet(this, l, 0x200000L + l & 0xFFFFFFFFFFE00000L | (long)n));
        return true;
    }

    public final void parkedWorkersStackTopUpdate(Worker worker, int n, int n2) {
        long l;
        int n3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$FU;
        do {
            if ((n3 = (int)(0x1FFFFFL & (l = atomicLongFieldUpdater.get(this)))) != n) continue;
            n3 = n2 == 0 ? this.parkedWorkersStackNextIndex(worker) : n2;
        } while (n3 < 0 || !parkedWorkersStack$FU.compareAndSet(this, l, 0x200000L + l & 0xFFFFFFFFFFE00000L | (long)n3));
    }

    /*
     * Unable to fully structure code
     */
    public final void runSafely(Task var1_1) {
        try {
            var1_1.run();
        }
        catch (Throwable var1_2) {
            var2_4 = Thread.currentThread();
            var2_4.getUncaughtExceptionHandler().uncaughtException(var2_4, var1_2);
            var1_1 = AbstractTimeSourceKt.getTimeSource();
            if (var1_1 != null) ** continue;
        }
        var1_1 = AbstractTimeSourceKt.getTimeSource();
        if (var1_1 != null) {
            while (true) {
                var1_1.unTrackTask();
                break;
            }
        }
        return;
        {
            catch (Throwable var1_3) {
                var2_5 = AbstractTimeSourceKt.getTimeSource();
                if (var2_5 != null) {
                    var2_5.unTrackTask();
                }
                throw var1_3;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void shutdown(long l) {
        int n;
        Runnable runnable2;
        int n2;
        Object object = _isTerminated$FU;
        int n3 = 0;
        if (!((AtomicIntegerFieldUpdater)object).compareAndSet(this, 0, 1)) {
            return;
        }
        Worker worker = this.currentWorker();
        object = this.workers;
        synchronized (object) {
            long l2 = CoroutineScheduler.controlState$FU.get(this);
            n2 = (int)(l2 & 0x1FFFFFL);
        }
        int n4 = 1;
        if (1 <= n2) {
            while (true) {
                object = this.workers.get(n4);
                Intrinsics.checkNotNull((Object)object);
                runnable2 = (Worker)object;
                if (runnable2 != worker) {
                    while (((Thread)runnable2).isAlive()) {
                        LockSupport.unpark((Thread)runnable2);
                        ((Thread)runnable2).join(l);
                    }
                    object = ((Worker)runnable2).state;
                    if (DebugKt.getASSERTIONS_ENABLED() && (n = object == WorkerState.TERMINATED ? 1 : 0) == 0) {
                        throw new AssertionError();
                    }
                    ((Worker)runnable2).localQueue.offloadAllWorkTo(this.globalBlockingQueue);
                }
                if (n4 == n2) break;
                ++n4;
            }
        }
        this.globalBlockingQueue.close();
        this.globalCpuQueue.close();
        while (true) {
            block19: {
                block18: {
                    if (worker == null) break block18;
                    runnable2 = worker.findTask(true);
                    object = runnable2;
                    if (runnable2 != null) break block19;
                }
                runnable2 = (Task)this.globalCpuQueue.removeFirstOrNull();
                object = runnable2;
                if (runnable2 == null) {
                    runnable2 = (Task)this.globalBlockingQueue.removeFirstOrNull();
                    object = runnable2;
                    if (runnable2 == null) {
                        if (worker != null) {
                            worker.tryReleaseCpu(WorkerState.TERMINATED);
                        }
                        if (DebugKt.getASSERTIONS_ENABLED()) {
                            n = (int)((0x7FFFFC0000000000L & controlState$FU.get(this)) >> 42);
                            n4 = n3;
                            if (n == this.corePoolSize) {
                                n4 = 1;
                            }
                            if (n4 == 0) {
                                throw new AssertionError();
                            }
                        }
                        parkedWorkersStack$FU.set(this, 0L);
                        controlState$FU.set(this, 0L);
                        return;
                    }
                }
            }
            this.runSafely((Task)object);
        }
    }

    public final void signalCpuWork() {
        if (this.tryUnpark()) {
            return;
        }
        if (CoroutineScheduler.tryCreateWorker$default(this, 0L, 1, null)) {
            return;
        }
        this.tryUnpark();
    }

    public String toString() {
        Object object;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        Serializable serializable = new ArrayList();
        int n6 = this.workers.currentLength();
        for (int i = 1; i < n6; ++i) {
            int n7;
            int n8;
            int n9;
            int n10;
            object = this.workers.get(i);
            if (object == null) {
                n10 = n;
                n9 = n2;
                n8 = n3;
                n7 = n5;
            } else {
                int n11 = ((Worker)object).localQueue.getSize$kotlinx_coroutines_core();
                object = ((Worker)object).state;
                switch (WhenMappings.$EnumSwitchMapping$0[((Enum)object).ordinal()]) {
                    default: {
                        n10 = n;
                        n9 = n2;
                        n8 = n3;
                        n7 = n5;
                        break;
                    }
                    case 5: {
                        n7 = n5 + 1;
                        n10 = n;
                        n9 = n2;
                        n8 = n3;
                        break;
                    }
                    case 4: {
                        int n12 = n4 + 1;
                        n10 = n;
                        n9 = n2;
                        n8 = n3;
                        n4 = n12;
                        n7 = n5;
                        if (n11 <= 0) break;
                        ((Collection)((Object)serializable)).add("" + n11 + 'd');
                        n10 = n;
                        n9 = n2;
                        n8 = n3;
                        n4 = n12;
                        n7 = n5;
                        break;
                    }
                    case 3: {
                        n8 = n3 + 1;
                        ((Collection)((Object)serializable)).add("" + n11 + 'c');
                        n10 = n;
                        n9 = n2;
                        n7 = n5;
                        break;
                    }
                    case 2: {
                        n9 = n2 + 1;
                        ((Collection)((Object)serializable)).add("" + n11 + 'b');
                        n10 = n;
                        n8 = n3;
                        n7 = n5;
                        break;
                    }
                    case 1: {
                        n10 = n + 1;
                        n7 = n5;
                        n8 = n3;
                        n9 = n2;
                    }
                }
            }
            n = n10;
            n2 = n9;
            n3 = n8;
            n5 = n7;
        }
        long l = controlState$FU.get(this);
        object = new StringBuilder();
        StringBuilder stringBuilder = ((StringBuilder)object).append(this.schedulerName).append('@').append(DebugStringsKt.getHexAddress(this)).append("[Pool Size {core = ").append(this.corePoolSize);
        stringBuilder = stringBuilder.append(", max = ").append(this.maxPoolSize);
        stringBuilder = stringBuilder.append("}, Worker States {CPU = ");
        stringBuilder = stringBuilder.append(n3);
        stringBuilder = stringBuilder.append(", blocking = ");
        stringBuilder = stringBuilder.append(n2);
        stringBuilder = stringBuilder.append(", parked = ");
        stringBuilder = stringBuilder.append(n);
        stringBuilder = stringBuilder.append(", dormant = ");
        stringBuilder = stringBuilder.append(n4);
        stringBuilder = stringBuilder.append(", terminated = ");
        stringBuilder = stringBuilder.append(n5);
        stringBuilder = stringBuilder.append("}, running workers queues = ");
        serializable = stringBuilder.append(serializable);
        serializable = ((StringBuilder)serializable).append(", global CPU queue size = ").append(this.globalCpuQueue.getSize());
        ((StringBuilder)serializable).append(", global blocking queue size = ").append(this.globalBlockingQueue.getSize());
        serializable = ((StringBuilder)object).append(", Control State {created workers= ").append((int)(0x1FFFFFL & l));
        serializable = ((StringBuilder)serializable).append(", blocking tasks = ").append((int)((0x3FFFFE00000L & l) >> 21));
        serializable = ((StringBuilder)serializable).append(", CPUs acquired = ").append(this.corePoolSize - (int)((0x7FFFFC0000000000L & l) >> 42));
        ((StringBuilder)serializable).append("}]");
        return ((StringBuilder)object).toString();
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0080T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k=3, mv={1, 8, 0}, xi=48)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[WorkerState.values().length];
            try {
                nArray[WorkerState.PARKING.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkerState.BLOCKING.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkerState.DORMANT.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkerState.TERMINATED.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }

    @Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020 H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010+\u001a\u00020\u000eH\u0002J\n\u0010,\u001a\u0004\u0018\u00010 H\u0002J\n\u0010-\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010.\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u0003H\u0002J\b\u00101\u001a\u00020\u000eH\u0002J\u0006\u00102\u001a\u00020\u000eJ\u000e\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003J\b\u00105\u001a\u00020%H\u0002J\n\u00106\u001a\u0004\u0018\u00010 H\u0002J\b\u00107\u001a\u00020%H\u0016J\u0006\u00108\u001a\u00020\u0010J\b\u00109\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020\u000eH\u0002J\b\u0010;\u001a\u00020%H\u0002J\u000e\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u001dJ\u0016\u0010>\u001a\u0004\u0018\u00010 2\n\u0010?\u001a\u00060\u0003j\u0002`@H\u0002J\b\u0010A\u001a\u00020%H\u0002R$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0006\u0010\"\u001a\u00020#\u00a8\u0006B"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "index", "", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "indexInArray", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "", "minDelayUntilStealableTaskNs", "", "nextParkedWorker", "", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "scheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "stolenTask", "Lkotlin/jvm/internal/Ref$ObjectRef;", "Lkotlinx/coroutines/scheduling/Task;", "terminationDeadline", "workerCtl", "Lkotlinx/atomicfu/AtomicInt;", "afterTask", "", "taskMode", "beforeTask", "executeTask", "task", "findAnyTask", "scanLocalQueue", "findBlockingTask", "findCpuTask", "findTask", "idleReset", "mode", "inStack", "isIo", "nextInt", "upperBound", "park", "pollGlobalQueues", "run", "runSingleTask", "runWorker", "tryAcquireCpuPermit", "tryPark", "tryReleaseCpu", "newState", "trySteal", "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "tryTerminateWorker", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    public final class Worker
    extends Thread {
        private static final AtomicIntegerFieldUpdater workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        private volatile int indexInArray;
        public final WorkQueue localQueue;
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        private int rngState;
        public WorkerState state;
        private final Ref.ObjectRef<Task> stolenTask;
        private long terminationDeadline;
        final CoroutineScheduler this$0;
        @Volatile
        private volatile int workerCtl;

        private Worker(CoroutineScheduler coroutineScheduler) {
            this.this$0 = coroutineScheduler;
            this.setDaemon(true);
            this.localQueue = new WorkQueue();
            this.stolenTask = new Ref.ObjectRef();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = NOT_IN_STACK;
            this.rngState = Random.Default.nextInt();
        }

        public Worker(CoroutineScheduler coroutineScheduler, int n) {
            this(coroutineScheduler);
            this.setIndexInArray(n);
        }

        private final void afterTask(int n) {
            if (n == 0) {
                return;
            }
            Object object = this.this$0;
            controlState$FU.addAndGet(object, -2097152L);
            object = this.state;
            if (object != WorkerState.TERMINATED) {
                if (DebugKt.getASSERTIONS_ENABLED() && (n = object == WorkerState.BLOCKING ? 1 : 0) == 0) {
                    throw new AssertionError();
                }
                this.state = WorkerState.DORMANT;
            }
        }

        private final void beforeTask(int n) {
            if (n == 0) {
                return;
            }
            if (this.tryReleaseCpu(WorkerState.BLOCKING)) {
                this.this$0.signalCpuWork();
            }
        }

        private final void executeTask(Task task) {
            int n = task.taskContext.getTaskMode();
            this.idleReset(n);
            this.beforeTask(n);
            this.this$0.runSafely(task);
            this.afterTask(n);
        }

        private final Task findAnyTask(boolean bl) {
            if (bl) {
                Task task;
                boolean bl2 = this.nextInt(this.this$0.corePoolSize * 2) == 0;
                if (bl2 && (task = this.pollGlobalQueues()) != null) {
                    return task;
                }
                task = this.localQueue.poll();
                if (task != null) {
                    return task;
                }
                if (!bl2 && (task = this.pollGlobalQueues()) != null) {
                    return task;
                }
            } else {
                Task task = this.pollGlobalQueues();
                if (task != null) {
                    return task;
                }
            }
            return this.trySteal(3);
        }

        private final Task findBlockingTask() {
            Task task;
            Task task2 = task = this.localQueue.pollBlocking();
            if (task == null) {
                task2 = task = (Task)this.this$0.globalBlockingQueue.removeFirstOrNull();
                if (task == null) {
                    task2 = this.trySteal(1);
                }
            }
            return task2;
        }

        private final Task findCpuTask() {
            Task task;
            Task task2 = task = this.localQueue.pollCpu();
            if (task == null) {
                task2 = task = (Task)this.this$0.globalBlockingQueue.removeFirstOrNull();
                if (task == null) {
                    task2 = this.trySteal(2);
                }
            }
            return task2;
        }

        public static final AtomicIntegerFieldUpdater getWorkerCtl$FU() {
            return workerCtl$FU;
        }

        private final void idleReset(int n) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    int n2 = 1;
                    if ((n = n == 1 ? n2 : 0) == 0) {
                        throw new AssertionError();
                    }
                }
                this.state = WorkerState.BLOCKING;
            }
        }

        private final boolean inStack() {
            boolean bl = this.nextParkedWorker != NOT_IN_STACK;
            return bl;
        }

        private final void park() {
            if (this.terminationDeadline == 0L) {
                this.terminationDeadline = System.nanoTime() + this.this$0.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(this.this$0.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0L) {
                this.terminationDeadline = 0L;
                this.tryTerminateWorker();
            }
        }

        private final Task pollGlobalQueues() {
            if (this.nextInt(2) == 0) {
                Task task = (Task)this.this$0.globalCpuQueue.removeFirstOrNull();
                if (task != null) {
                    return task;
                }
                return (Task)this.this$0.globalBlockingQueue.removeFirstOrNull();
            }
            Task task = (Task)this.this$0.globalBlockingQueue.removeFirstOrNull();
            if (task != null) {
                return task;
            }
            return (Task)this.this$0.globalCpuQueue.removeFirstOrNull();
        }

        private final void runWorker() {
            boolean bl = false;
            while (!this.this$0.isTerminated() && this.state != WorkerState.TERMINATED) {
                Task task = this.findTask(this.mayHaveLocalTasks);
                if (task != null) {
                    bl = false;
                    this.minDelayUntilStealableTaskNs = 0L;
                    this.executeTask(task);
                    continue;
                }
                this.mayHaveLocalTasks = false;
                if (this.minDelayUntilStealableTaskNs != 0L) {
                    if (!bl) {
                        bl = true;
                        continue;
                    }
                    bl = false;
                    this.tryReleaseCpu(WorkerState.PARKING);
                    Thread.interrupted();
                    LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                    this.minDelayUntilStealableTaskNs = 0L;
                    continue;
                }
                this.tryPark();
            }
            this.tryReleaseCpu(WorkerState.TERMINATED);
        }

        private final boolean tryAcquireCpuPermit() {
            Object object = this.state;
            Object object2 = WorkerState.CPU_ACQUIRED;
            boolean bl = true;
            if (object != object2) {
                boolean bl2;
                block4: {
                    long l;
                    object2 = this.this$0;
                    object = controlState$FU;
                    do {
                        if ((int)((0x7FFFFC0000000000L & (l = ((AtomicLongFieldUpdater)object).get(object2))) >> 42) != 0) continue;
                        bl2 = false;
                        break block4;
                    } while (!controlState$FU.compareAndSet(object2, l, l - 0x40000000000L));
                    bl2 = true;
                }
                if (bl2) {
                    this.state = WorkerState.CPU_ACQUIRED;
                } else {
                    bl = false;
                }
            }
            return bl;
        }

        private final void tryPark() {
            if (!this.inStack()) {
                this.this$0.parkedWorkersStackPush(this);
                return;
            }
            workerCtl$FU.set(this, -1);
            while (this.inStack() && workerCtl$FU.get(this) == -1 && !this.this$0.isTerminated() && this.state != WorkerState.TERMINATED) {
                this.tryReleaseCpu(WorkerState.PARKING);
                Thread.interrupted();
                this.park();
            }
        }

        private final Task trySteal(int n) {
            long l;
            Object object = this.this$0;
            int n2 = (int)(controlState$FU.get(object) & 0x1FFFFFL);
            if (n2 < 2) {
                return null;
            }
            int n3 = this.nextInt(n2);
            long l2 = Long.MAX_VALUE;
            CoroutineScheduler coroutineScheduler = this.this$0;
            int n4 = 0;
            while (true) {
                int n5;
                l = 0L;
                if (n4 >= n2) break;
                n3 = n5 = n3 + 1;
                if (n5 > n2) {
                    n3 = 1;
                }
                if ((object = coroutineScheduler.workers.get(n3)) != null && object != this) {
                    long l3 = ((Worker)object).localQueue.trySteal(n, this.stolenTask);
                    if (l3 == -1L) {
                        object = (Task)this.stolenTask.element;
                        this.stolenTask.element = null;
                        return object;
                    }
                    l = l2;
                    if (l3 > 0L) {
                        l = Math.min(l2, l3);
                    }
                } else {
                    l = l2;
                }
                ++n4;
                l2 = l;
            }
            if (l2 != Long.MAX_VALUE) {
                l = l2;
            }
            this.minDelayUntilStealableTaskNs = l;
            return null;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private final void tryTerminateWorker() {
            ResizableAtomicArray<Worker> resizableAtomicArray = this.this$0.workers;
            CoroutineScheduler coroutineScheduler = this.this$0;
            synchronized (resizableAtomicArray) {
                int n;
                boolean bl = coroutineScheduler.isTerminated();
                if (bl) {
                    return;
                }
                int n2 = (int)(controlState$FU.get(coroutineScheduler) & 0x1FFFFFL);
                if (n2 <= (n = coroutineScheduler.corePoolSize)) {
                    return;
                }
                bl = workerCtl$FU.compareAndSet(this, -1, 1);
                if (!bl) {
                    return;
                }
                n2 = this.indexInArray;
                this.setIndexInArray(0);
                coroutineScheduler.parkedWorkersStackTopUpdate(this, n2, 0);
                n = (int)(0x1FFFFFL & controlState$FU.getAndDecrement(coroutineScheduler));
                if (n != n2) {
                    Worker worker = coroutineScheduler.workers.get(n);
                    Intrinsics.checkNotNull((Object)worker);
                    coroutineScheduler.workers.setSynchronized(n2, worker);
                    worker.setIndexInArray(n2);
                    coroutineScheduler.parkedWorkersStackTopUpdate(worker, n, n2);
                }
                coroutineScheduler.workers.setSynchronized(n, null);
                coroutineScheduler = Unit.INSTANCE;
            }
            this.state = WorkerState.TERMINATED;
        }

        public final Task findTask(boolean bl) {
            if (this.tryAcquireCpuPermit()) {
                return this.findAnyTask(bl);
            }
            return this.findBlockingTask();
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final CoroutineScheduler getScheduler() {
            return this.this$0;
        }

        public final int getWorkerCtl() {
            return this.workerCtl;
        }

        public final boolean isIo() {
            boolean bl = this.state == WorkerState.BLOCKING;
            return bl;
        }

        public final int nextInt(int n) {
            int n2 = this.rngState;
            n2 ^= n2 << 13;
            n2 ^= n2 >> 17;
            n2 ^= n2 << 5;
            this.rngState = n2;
            int n3 = n - 1;
            if ((n3 & n) == 0) {
                return n2 & n3;
            }
            return (Integer.MAX_VALUE & n2) % n;
        }

        @Override
        public void run() {
            this.runWorker();
        }

        public final long runSingleTask() {
            WorkerState workerState = this.state;
            Object object = this.state;
            WorkerState workerState2 = WorkerState.CPU_ACQUIRED;
            boolean bl = true;
            boolean bl2 = object == workerState2;
            if ((object = bl2 ? this.findCpuTask() : this.findBlockingTask()) == null) {
                if (this.minDelayUntilStealableTaskNs == 0L) {
                    return -1L;
                }
                return this.minDelayUntilStealableTaskNs;
            }
            this.this$0.runSafely((Task)object);
            if (!bl2) {
                object = this.this$0;
                controlState$FU.addAndGet(object, -2097152L);
            }
            if (DebugKt.getASSERTIONS_ENABLED() && !(bl2 = this.state == workerState ? bl : false)) {
                throw new AssertionError();
            }
            return 0L;
        }

        public final void setIndexInArray(int n) {
            StringBuilder stringBuilder = new StringBuilder().append(this.this$0.schedulerName).append("-worker-");
            String string2 = n == 0 ? "TERMINATED" : String.valueOf(n);
            this.setName(stringBuilder.append(string2).toString());
            this.indexInArray = n;
        }

        public final void setNextParkedWorker(Object object) {
            this.nextParkedWorker = object;
        }

        public final boolean tryReleaseCpu(WorkerState workerState) {
            WorkerState workerState2 = this.state;
            boolean bl = workerState2 == WorkerState.CPU_ACQUIRED;
            if (bl) {
                CoroutineScheduler coroutineScheduler = this.this$0;
                controlState$FU.addAndGet(coroutineScheduler, 0x40000000000L);
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return bl;
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    public static enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED;

    }
}

