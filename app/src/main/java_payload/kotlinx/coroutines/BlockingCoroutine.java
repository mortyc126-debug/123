/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.JobSupportKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u000b\u0010\u0011\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0013"}, d2={"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "isScopedCoroutine", "", "()Z", "afterCompletion", "", "state", "", "joinBlocking", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class BlockingCoroutine<T>
extends AbstractCoroutine<T> {
    private final Thread blockedThread;
    private final EventLoop eventLoop;

    public BlockingCoroutine(CoroutineContext coroutineContext, Thread thread, EventLoop eventLoop) {
        super(coroutineContext, true, true);
        this.blockedThread = thread;
        this.eventLoop = eventLoop;
    }

    @Override
    protected void afterCompletion(Object object) {
        if (!Intrinsics.areEqual((Object)Thread.currentThread(), (Object)this.blockedThread)) {
            Thread thread = this.blockedThread;
            object = AbstractTimeSourceKt.getTimeSource();
            if (object != null) {
                ((AbstractTimeSource)object).unpark(thread);
                object = Unit.INSTANCE;
            } else {
                object = null;
            }
            if (object == null) {
                LockSupport.unpark(thread);
            }
        }
    }

    @Override
    protected boolean isScopedCoroutine() {
        return true;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final T joinBlocking() {
        block20: {
            void var3_13;
            Object var4_19;
            block23: {
                block19: {
                    AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
                    if (abstractTimeSource != null) {
                        abstractTimeSource.registerTimeLoopThread();
                    }
                    EventLoop eventLoop = this.eventLoop;
                    var4_19 = null;
                    if (eventLoop == null) break block19;
                    EventLoop.incrementUseCount$default(eventLoop, false, 1, null);
                }
                while (true) {
                    void var3_8;
                    long l;
                    block22: {
                        block21: {
                            if (Thread.interrupted()) break block20;
                            EventLoop eventLoop = this.eventLoop;
                            if (eventLoop == null) break block21;
                            l = eventLoop.processNextEvent();
                        }
                        l = Long.MAX_VALUE;
                        if (this.isCompleted()) break;
                        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
                        if (abstractTimeSource == null) break block22;
                        abstractTimeSource.parkNanos(this, l);
                        Unit unit = Unit.INSTANCE;
                    }
                    Object var3_7 = null;
                    if (var3_8 != null) continue;
                    LockSupport.parkNanos(this, l);
                    continue;
                    break;
                }
                EventLoop eventLoop = this.eventLoop;
                if (eventLoop == null) break block23;
                {
                    catch (Throwable throwable) {
                        throw throwable;
                    }
                }
                EventLoop.decrementUseCount$default(eventLoop, false, 1, null);
            }
            Object object = JobSupportKt.unboxState(this.getState$kotlinx_coroutines_core());
            Object var3_11 = var4_19;
            if (object instanceof CompletedExceptionally) {
                CompletedExceptionally completedExceptionally = (CompletedExceptionally)object;
            }
            if (var3_13 != null) throw var3_13.cause;
            return (T)object;
        }
        try {
            InterruptedException interruptedException = new InterruptedException();
            this.cancelCoroutine(interruptedException);
            throw (Throwable)interruptedException;
        }
        catch (Throwable throwable) {
            EventLoop eventLoop = this.eventLoop;
            if (eventLoop == null) throw throwable;
            EventLoop.decrementUseCount$default(eventLoop, false, 1, null);
            throw throwable;
        }
        finally {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
            if (abstractTimeSource != null) {
                abstractTimeSource.unregisterTimeLoopThread();
            }
        }
    }
}

