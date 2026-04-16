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

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0006\u001a\u00020\u0007H\u0081\b\u001a\t\u0010\b\u001a\u00020\u0007H\u0081\b\u001a\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0081\b\u001a\t\u0010\u000e\u001a\u00020\nH\u0081\b\u001a\t\u0010\u000f\u001a\u00020\nH\u0081\b\u001a\t\u0010\u0010\u001a\u00020\nH\u0081\b\u001a\u0011\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0081\b\u001a\t\u0010\u0014\u001a\u00020\nH\u0081\b\u001a\u0019\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\n\u0010\u0018\u001a\u00060\u0016j\u0002`\u0017H\u0081\b\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0019"}, d2={"timeSource", "Lkotlinx/coroutines/AbstractTimeSource;", "getTimeSource", "()Lkotlinx/coroutines/AbstractTimeSource;", "setTimeSource", "(Lkotlinx/coroutines/AbstractTimeSource;)V", "currentTimeMillis", "", "nanoTime", "parkNanos", "", "blocker", "", "nanos", "registerTimeLoopThread", "trackTask", "unTrackTask", "unpark", "thread", "Ljava/lang/Thread;", "unregisterTimeLoopThread", "wrapTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class AbstractTimeSourceKt {
    private static AbstractTimeSource timeSource;

    private static final long currentTimeMillis() {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        long l = abstractTimeSource != null ? abstractTimeSource.currentTimeMillis() : System.currentTimeMillis();
        return l;
    }

    public static final AbstractTimeSource getTimeSource() {
        return timeSource;
    }

    private static final long nanoTime() {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        long l = abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime();
        return l;
    }

    private static final void parkNanos(Object object, long l) {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        if (abstractTimeSource != null) {
            abstractTimeSource.parkNanos(object, l);
            abstractTimeSource = Unit.INSTANCE;
        } else {
            abstractTimeSource = null;
        }
        if (abstractTimeSource == null) {
            LockSupport.parkNanos(object, l);
        }
    }

    private static final void registerTimeLoopThread() {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        if (abstractTimeSource != null) {
            abstractTimeSource.registerTimeLoopThread();
        }
    }

    public static final void setTimeSource(AbstractTimeSource abstractTimeSource) {
        timeSource = abstractTimeSource;
    }

    private static final void trackTask() {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        if (abstractTimeSource != null) {
            abstractTimeSource.trackTask();
        }
    }

    private static final void unTrackTask() {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        if (abstractTimeSource != null) {
            abstractTimeSource.unTrackTask();
        }
    }

    private static final void unpark(Thread thread) {
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

    private static final void unregisterTimeLoopThread() {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        if (abstractTimeSource != null) {
            abstractTimeSource.unregisterTimeLoopThread();
        }
    }

    private static final Runnable wrapTask(Runnable runnable2) {
        Object object;
        block3: {
            block2: {
                object = AbstractTimeSourceKt.getTimeSource();
                if (object == null) break block2;
                Runnable runnable3 = ((AbstractTimeSource)object).wrapTask(runnable2);
                object = runnable3;
                if (runnable3 != null) break block3;
            }
            object = runnable2;
        }
        return object;
    }
}

