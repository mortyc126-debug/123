/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl;

import androidx.work.Configuration;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.List;

public final class Schedulers$$ExternalSyntheticLambda0
implements Runnable {
    public final List f$0;
    public final WorkGenerationalId f$1;
    public final Configuration f$2;
    public final WorkDatabase f$3;

    public /* synthetic */ Schedulers$$ExternalSyntheticLambda0(List list, WorkGenerationalId workGenerationalId, Configuration configuration2, WorkDatabase workDatabase) {
        this.f$0 = list;
        this.f$1 = workGenerationalId;
        this.f$2 = configuration2;
        this.f$3 = workDatabase;
    }

    @Override
    public final void run() {
        Schedulers.lambda$registerRescheduling$0(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

