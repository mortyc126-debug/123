/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function0
 */
package androidx.work.impl;

import androidx.work.WorkRequest;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerUpdater;
import kotlin.jvm.functions.Function0;

public final class WorkerUpdater$$ExternalSyntheticLambda2
implements Runnable {
    public final WorkManagerImpl f$0;
    public final String f$1;
    public final OperationImpl f$2;
    public final Function0 f$3;
    public final WorkRequest f$4;

    public /* synthetic */ WorkerUpdater$$ExternalSyntheticLambda2(WorkManagerImpl workManagerImpl, String string2, OperationImpl operationImpl, Function0 function0, WorkRequest workRequest) {
        this.f$0 = workManagerImpl;
        this.f$1 = string2;
        this.f$2 = operationImpl;
        this.f$3 = function0;
        this.f$4 = workRequest;
    }

    @Override
    public final void run() {
        WorkerUpdater.$r8$lambda$N89sN1A-Ft8Xw-BLJ76ILDUlQ9k(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}

