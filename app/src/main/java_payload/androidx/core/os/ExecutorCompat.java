/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.core.os;

import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class ExecutorCompat {
    private ExecutorCompat() {
    }

    public static Executor create(Handler handler) {
        return new HandlerExecutor(handler);
    }

    private static class HandlerExecutor
    implements Executor {
        private final Handler mHandler;

        HandlerExecutor(Handler handler) {
            this.mHandler = Preconditions.checkNotNull(handler);
        }

        @Override
        public void execute(Runnable runnable2) {
            if (this.mHandler.post(Preconditions.checkNotNull(runnable2))) {
                return;
            }
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }
}

