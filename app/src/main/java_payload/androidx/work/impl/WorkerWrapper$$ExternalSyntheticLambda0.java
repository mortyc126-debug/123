/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work.impl;

import androidx.work.impl.WorkerWrapper;
import com.google.common.util.concurrent.ListenableFuture;

public final class WorkerWrapper$$ExternalSyntheticLambda0
implements Runnable {
    public final WorkerWrapper f$0;
    public final ListenableFuture f$1;

    public /* synthetic */ WorkerWrapper$$ExternalSyntheticLambda0(WorkerWrapper workerWrapper, ListenableFuture listenableFuture) {
        this.f$0 = workerWrapper;
        this.f$1 = listenableFuture;
    }

    @Override
    public final void run() {
        this.f$0.lambda$runWorker$0$androidx-work-impl-WorkerWrapper(this.f$1);
    }
}

