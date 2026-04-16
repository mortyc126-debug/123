/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.EventLoopImplBase;
import kotlinx.coroutines.ThreadLocalEventLoop;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\u0014\u0010 \u001a\u00020\u001e2\n\u0010!\u001a\u00060\u0002j\u0002`\u0003H\u0016J\r\u0010\"\u001a\u00020\u001eH\u0000\u00a2\u0006\u0002\b#J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\b2\n\u0010'\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0015H\u0002J\u0018\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\b\u00101\u001a\u00020\u001eH\u0002J\u000e\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0004R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00158@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00118TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u00064"}, d2={"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE_MS", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", "", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "debugStatus", "isShutDown", "", "()Z", "isShutdownRequested", "isThreadPresent", "isThreadPresent$kotlinx_coroutines_core", "thread", "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "enqueue", "task", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "context", "Lkotlin/coroutines/CoroutineContext;", "notifyStartup", "reschedule", "now", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "run", "shutdown", "shutdownError", "shutdownForTests", "timeout", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class DefaultExecutor
extends EventLoopImplBase
implements Runnable {
    private static final int ACTIVE = 1;
    private static final long DEFAULT_KEEP_ALIVE_MS = 1000L;
    private static final int FRESH = 0;
    public static final DefaultExecutor INSTANCE;
    private static final long KEEP_ALIVE_NANOS;
    private static final int SHUTDOWN = 4;
    private static final int SHUTDOWN_ACK = 3;
    private static final int SHUTDOWN_REQ = 2;
    public static final String THREAD_NAME = "kotlinx.coroutines.DefaultExecutor";
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        Long l;
        INSTANCE = new DefaultExecutor();
        EventLoop.incrementUseCount$default(INSTANCE, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        }
        catch (SecurityException securityException) {
            l = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l);
    }

    private DefaultExecutor() {
    }

    private final void acknowledgeShutdownIfNeeded() {
        synchronized (this) {
            block4: {
                boolean bl = this.isShutdownRequested();
                if (bl) break block4;
                return;
            }
            debugStatus = 3;
            this.resetAll();
            Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type java.lang.Object");
            ((Object)this).notifyAll();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Thread createThreadSync() {
        synchronized (this) {
            Thread thread;
            Thread thread2 = thread = _thread;
            if (thread == null) {
                _thread = thread2 = new Thread((Runnable)this, THREAD_NAME);
                thread2.setDaemon(true);
                thread2.start();
            }
            return thread2;
        }
    }

    private static /* synthetic */ void get_thread$annotations() {
    }

    private final boolean isShutDown() {
        boolean bl = debugStatus == 4;
        return bl;
    }

    private final boolean isShutdownRequested() {
        int n = debugStatus;
        boolean bl = n == 2 || n == 3;
        return bl;
    }

    private final boolean notifyStartup() {
        synchronized (this) {
            block4: {
                boolean bl = this.isShutdownRequested();
                if (!bl) break block4;
                return false;
            }
            debugStatus = 1;
            Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type java.lang.Object");
            ((Object)this).notifyAll();
            return true;
        }
    }

    private final void shutdownError() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override
    public void enqueue(Runnable runnable2) {
        if (this.isShutDown()) {
            this.shutdownError();
        }
        super.enqueue(runnable2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void ensureStarted$kotlinx_coroutines_core() {
        synchronized (this) {
            boolean bl;
            boolean bl2 = DebugKt.getASSERTIONS_ENABLED();
            boolean bl3 = true;
            if (bl2 && !(bl = _thread == null)) {
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                bl = bl3;
                if (debugStatus != 0) {
                    bl = debugStatus == 3 ? bl3 : false;
                }
                if (!bl) {
                    AssertionError assertionError = new AssertionError();
                    throw assertionError;
                }
            }
            debugStatus = 0;
            this.createThreadSync();
            while (debugStatus == 0) {
                Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type java.lang.Object");
                ((Object)this).wait();
            }
            return;
        }
    }

    @Override
    protected Thread getThread() {
        Thread thread;
        Thread thread2 = thread = _thread;
        if (thread == null) {
            thread2 = this.createThreadSync();
        }
        return thread2;
    }

    @Override
    public DisposableHandle invokeOnTimeout(long l, Runnable runnable2, CoroutineContext coroutineContext) {
        return this.scheduleInvokeOnTimeout(l, runnable2);
    }

    public final boolean isThreadPresent$kotlinx_coroutines_core() {
        boolean bl = _thread != null;
        return bl;
    }

    @Override
    protected void reschedule(long l, EventLoopImplBase.DelayedTask delayedTask) {
        this.shutdownError();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void run() {
        block22: {
            ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core(this);
            var10_1 = AbstractTimeSourceKt.getTimeSource();
            if (var10_1 != null) {
                var10_1.registerTimeLoopThread();
            }
            var2_3 = 0x7FFFFFFFFFFFFFFFL;
            try {
                var1_4 = this.notifyStartup();
                if (var1_4) break block22;
                DefaultExecutor._thread = null;
                this.acknowledgeShutdownIfNeeded();
            }
            catch (Throwable var10_2) {
                DefaultExecutor._thread = null;
                this.acknowledgeShutdownIfNeeded();
                var11_8 = AbstractTimeSourceKt.getTimeSource();
                if (var11_8 != null) {
                    var11_8.unregisterTimeLoopThread();
                }
                if (!this.isEmpty()) {
                    this.getThread();
                }
                throw var10_2;
            }
            var10_1 = AbstractTimeSourceKt.getTimeSource();
            if (var10_1 != null) {
                var10_1.unregisterTimeLoopThread();
            }
            if (!this.isEmpty()) {
                this.getThread();
            }
            return;
        }
        while (true) {
            Thread.interrupted();
            var8_7 = this.processNextEvent();
            if (var8_7 != 0x7FFFFFFFFFFFFFFFL) break block23;
            break;
        }
        {
            block28: {
                block27: {
                    block26: {
                        block25: {
                            block23: {
                                block24: {
                                    block29: {
                                        var10_1 = AbstractTimeSourceKt.getTimeSource();
                                        if (var10_1 == null) ** GOTO lbl41
                                        var6_6 = var10_1.nanoTime();
                                        break block29;
lbl41:
                                        // 1 sources

                                        var6_6 = System.nanoTime();
                                    }
                                    var4_5 = var2_3;
                                    if (var2_3 != 0x7FFFFFFFFFFFFFFFL) break block24;
                                    var2_3 = DefaultExecutor.KEEP_ALIVE_NANOS;
                                    var4_5 = var6_6 + var2_3;
                                }
                                if ((var2_3 = var4_5 - var6_6) <= 0L) {
                                    DefaultExecutor._thread = null;
                                    this.acknowledgeShutdownIfNeeded();
                                    var10_1 = AbstractTimeSourceKt.getTimeSource();
                                    if (var10_1 != null) {
                                        var10_1.unregisterTimeLoopThread();
                                    }
                                    if (!this.isEmpty()) {
                                        this.getThread();
                                    }
                                    return;
                                }
                                var6_6 = RangesKt.coerceAtMost((long)var8_7, (long)var2_3);
                                break block25;
                            }
                            var4_5 = 0x7FFFFFFFFFFFFFFFL;
                            var6_6 = var8_7;
                        }
                        var2_3 = var4_5;
                        if (var6_6 <= 0L) continue;
                        var1_4 = this.isShutdownRequested();
                        if (!var1_4) break block26;
                        DefaultExecutor._thread = null;
                        this.acknowledgeShutdownIfNeeded();
                        var10_1 = AbstractTimeSourceKt.getTimeSource();
                        if (var10_1 != null) {
                            var10_1.unregisterTimeLoopThread();
                        }
                        if (!this.isEmpty()) {
                            this.getThread();
                        }
                        return;
                    }
                    var10_1 = AbstractTimeSourceKt.getTimeSource();
                    if (var10_1 == null) break block27;
                    var10_1.parkNanos(this, var6_6);
                    var10_1 = Unit.INSTANCE;
                    break block28;
                }
                var10_1 = null;
            }
            var2_3 = var4_5;
            if (var10_1 != null) continue;
            LockSupport.parkNanos(this, var6_6);
            var2_3 = var4_5;
            continue;
        }
    }

    @Override
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void shutdownForTests(long l) {
        synchronized (this) {
            long l2 = System.currentTimeMillis();
            if (!this.isShutdownRequested()) {
                debugStatus = 2;
            }
            while (debugStatus != 3 && _thread != null) {
                Thread thread = _thread;
                if (thread != null) {
                    AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
                    if (abstractTimeSource != null) {
                        abstractTimeSource.unpark(thread);
                        abstractTimeSource = Unit.INSTANCE;
                    } else {
                        abstractTimeSource = null;
                    }
                    if (abstractTimeSource == null) {
                        LockSupport.unpark(thread);
                    }
                }
                if (l2 + l - System.currentTimeMillis() <= 0L) break;
                Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type java.lang.Object");
                ((Object)this).wait(l);
            }
            debugStatus = 0;
            return;
        }
    }
}

