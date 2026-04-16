/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl;

import androidx.work.Configuration;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.List;
import java.util.concurrent.Executor;

public final class Schedulers$$ExternalSyntheticLambda1
implements ExecutionListener {
    public final Executor f$0;
    public final List f$1;
    public final Configuration f$2;
    public final WorkDatabase f$3;

    public /* synthetic */ Schedulers$$ExternalSyntheticLambda1(Executor executor, List list, Configuration configuration2, WorkDatabase workDatabase) {
        this.f$0 = executor;
        this.f$1 = list;
        this.f$2 = configuration2;
        this.f$3 = workDatabase;
    }

    @Override
    public final void onExecuted(WorkGenerationalId workGenerationalId, boolean bl) {
        Schedulers.lambda$registerRescheduling$1(this.f$0, this.f$1, this.f$2, this.f$3, workGenerationalId, bl);
    }
}

