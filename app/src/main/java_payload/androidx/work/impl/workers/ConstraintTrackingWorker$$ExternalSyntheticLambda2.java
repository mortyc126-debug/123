/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work.impl.workers;

import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.common.util.concurrent.ListenableFuture;

public final class ConstraintTrackingWorker$$ExternalSyntheticLambda2
implements Runnable {
    public final ConstraintTrackingWorker f$0;
    public final ListenableFuture f$1;

    public /* synthetic */ ConstraintTrackingWorker$$ExternalSyntheticLambda2(ConstraintTrackingWorker constraintTrackingWorker, ListenableFuture listenableFuture) {
        this.f$0 = constraintTrackingWorker;
        this.f$1 = listenableFuture;
    }

    @Override
    public final void run() {
        ConstraintTrackingWorker.$r8$lambda$RTKLpcwRu-iaj_5GXB0ZJoqSLng(this.f$0, this.f$1);
    }
}

