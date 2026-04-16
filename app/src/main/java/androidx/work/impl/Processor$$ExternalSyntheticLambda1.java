/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work.impl;

import androidx.work.impl.Processor;
import androidx.work.impl.WorkerWrapper;
import com.google.common.util.concurrent.ListenableFuture;

public final class Processor$$ExternalSyntheticLambda1
implements Runnable {
    public final Processor f$0;
    public final ListenableFuture f$1;
    public final WorkerWrapper f$2;

    public /* synthetic */ Processor$$ExternalSyntheticLambda1(Processor processor, ListenableFuture listenableFuture, WorkerWrapper workerWrapper) {
        this.f$0 = processor;
        this.f$1 = listenableFuture;
        this.f$2 = workerWrapper;
    }

    @Override
    public final void run() {
        this.f$0.lambda$startWork$1$androidx-work-impl-Processor(this.f$1, this.f$2);
    }
}

