/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl;

import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerUpdater;
import androidx.work.impl.utils.futures.SettableFuture;

public final class WorkerUpdater$$ExternalSyntheticLambda1
implements Runnable {
    public final SettableFuture f$0;
    public final WorkManagerImpl f$1;
    public final WorkRequest f$2;

    public /* synthetic */ WorkerUpdater$$ExternalSyntheticLambda1(SettableFuture settableFuture, WorkManagerImpl workManagerImpl, WorkRequest workRequest) {
        this.f$0 = settableFuture;
        this.f$1 = workManagerImpl;
        this.f$2 = workRequest;
    }

    @Override
    public final void run() {
        WorkerUpdater.$r8$lambda$h_JOXj0UWFYj1IJe7Eauuc0RSNw(this.f$0, this.f$1, this.f$2);
    }
}

