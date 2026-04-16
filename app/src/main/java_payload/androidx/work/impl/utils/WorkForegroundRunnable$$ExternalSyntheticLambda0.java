/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.utils;

import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.futures.SettableFuture;

public final class WorkForegroundRunnable$$ExternalSyntheticLambda0
implements Runnable {
    public final WorkForegroundRunnable f$0;
    public final SettableFuture f$1;

    public /* synthetic */ WorkForegroundRunnable$$ExternalSyntheticLambda0(WorkForegroundRunnable workForegroundRunnable, SettableFuture settableFuture) {
        this.f$0 = workForegroundRunnable;
        this.f$1 = settableFuture;
    }

    @Override
    public final void run() {
        this.f$0.lambda$run$0$androidx-work-impl-utils-WorkForegroundRunnable(this.f$1);
    }
}

