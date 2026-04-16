/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 */
package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.EventLoopImplBase;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\bH\u0004R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "()V", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "reschedule", "", "now", "", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "unpark", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class EventLoopImplPlatform
extends EventLoop {
    protected abstract Thread getThread();

    protected void reschedule(long l, EventLoopImplBase.DelayedTask delayedTask) {
        DefaultExecutor.INSTANCE.schedule(l, delayedTask);
    }

    protected final void unpark() {
        Thread thread = this.getThread();
        if (Thread.currentThread() != thread) {
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
    }
}

