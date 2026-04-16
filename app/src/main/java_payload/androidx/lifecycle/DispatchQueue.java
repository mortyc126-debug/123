/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import androidx.lifecycle.DispatchQueue$$ExternalSyntheticLambda0;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0004H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0007J\b\u0010\u0010\u001a\u00020\fH\u0007J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\tH\u0003J\b\u0010\u0012\u001a\u00020\fH\u0007J\b\u0010\u0013\u001a\u00020\fH\u0007J\b\u0010\u0014\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Landroidx/lifecycle/DispatchQueue;", "", "()V", "finished", "", "isDraining", "paused", "queue", "Ljava/util/Queue;", "Ljava/lang/Runnable;", "canRun", "dispatchAndEnqueue", "", "context", "Lkotlin/coroutines/CoroutineContext;", "runnable", "drainQueue", "enqueue", "finish", "pause", "resume", "lifecycle-common"}, k=1, mv={1, 8, 0}, xi=48)
public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused = true;
    private final Queue<Runnable> queue = new ArrayDeque();

    public static /* synthetic */ void $r8$lambda$1ME-FmJywCV2uxhp8ajM5a9C_oI(DispatchQueue dispatchQueue, Runnable runnable2) {
        DispatchQueue.dispatchAndEnqueue$lambda$2$lambda$1(dispatchQueue, runnable2);
    }

    private static final void dispatchAndEnqueue$lambda$2$lambda$1(DispatchQueue dispatchQueue, Runnable runnable2) {
        Intrinsics.checkNotNullParameter((Object)dispatchQueue, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)runnable2, (String)"$runnable");
        dispatchQueue.enqueue(runnable2);
    }

    private final void enqueue(Runnable runnable2) {
        if (this.queue.offer(runnable2)) {
            this.drainQueue();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }

    public final boolean canRun() {
        boolean bl = this.finished || !this.paused;
        return bl;
    }

    public final void dispatchAndEnqueue(CoroutineContext coroutineContext, Runnable runnable2) {
        Intrinsics.checkNotNullParameter((Object)coroutineContext, (String)"context");
        Intrinsics.checkNotNullParameter((Object)runnable2, (String)"runnable");
        MainCoroutineDispatcher mainCoroutineDispatcher = Dispatchers.getMain().getImmediate();
        if (!mainCoroutineDispatcher.isDispatchNeeded(coroutineContext) && !this.canRun()) {
            this.enqueue(runnable2);
        } else {
            mainCoroutineDispatcher.dispatch(coroutineContext, new DispatchQueue$$ExternalSyntheticLambda0(this, runnable2));
        }
    }

    public final void drainQueue() {
        if (this.isDraining) {
            return;
        }
        try {
            this.isDraining = true;
            while (((Collection)this.queue).isEmpty() ^ true) {
                if (!this.canRun()) {
                    break;
                }
                Runnable runnable2 = this.queue.poll();
                if (runnable2 == null) continue;
                runnable2.run();
            }
            return;
        }
        finally {
            this.isDraining = false;
        }
    }

    public final void finish() {
        this.finished = true;
        this.drainQueue();
    }

    public final void pause() {
        this.paused = true;
    }

    public final void resume() {
        if (!this.paused) {
            return;
        }
        if (this.finished ^ true) {
            this.paused = false;
            this.drainQueue();
            return;
        }
        throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
    }
}

