/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0006\u0010\r\u001a\u00020\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Landroidx/room/TransactionExecutor;", "Ljava/util/concurrent/Executor;", "executor", "(Ljava/util/concurrent/Executor;)V", "active", "Ljava/lang/Runnable;", "syncLock", "", "tasks", "Ljava/util/ArrayDeque;", "execute", "", "command", "scheduleNext", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class TransactionExecutor
implements Executor {
    private Runnable active;
    private final Executor executor;
    private final Object syncLock;
    private final ArrayDeque<Runnable> tasks;

    public static /* synthetic */ void $r8$lambda$AympDHYBb78s7_N_9gRsXF0sHiw(Runnable runnable2, TransactionExecutor transactionExecutor) {
        TransactionExecutor.execute$lambda$1$lambda$0(runnable2, transactionExecutor);
    }

    public TransactionExecutor(Executor executor) {
        Intrinsics.checkNotNullParameter((Object)executor, (String)"executor");
        this.executor = executor;
        this.tasks = new ArrayDeque();
        this.syncLock = new Object();
    }

    private static final void execute$lambda$1$lambda$0(Runnable runnable2, TransactionExecutor transactionExecutor) {
        Intrinsics.checkNotNullParameter((Object)runnable2, (String)"$command");
        Intrinsics.checkNotNullParameter((Object)transactionExecutor, (String)"this$0");
        try {
            runnable2.run();
            return;
        }
        finally {
            transactionExecutor.scheduleNext();
        }
    }

    @Override
    public void execute(Runnable runnable2) {
        Intrinsics.checkNotNullParameter((Object)runnable2, (String)"command");
        Object object = this.syncLock;
        synchronized (object) {
            ArrayDeque<Runnable> arrayDeque = this.tasks;
            TransactionExecutor$$ExternalSyntheticLambda0 transactionExecutor$$ExternalSyntheticLambda0 = new TransactionExecutor$$ExternalSyntheticLambda0(runnable2, this);
            arrayDeque.offer(transactionExecutor$$ExternalSyntheticLambda0);
            if (this.active == null) {
                this.scheduleNext();
            }
            runnable2 = Unit.INSTANCE;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void scheduleNext() {
        Object object = this.syncLock;
        synchronized (object) {
            Runnable runnable2;
            this.active = runnable2 = this.tasks.poll();
            if (runnable2 != null) {
                this.executor.execute(this.active);
            }
            runnable2 = Unit.INSTANCE;
            return;
        }
    }
}

