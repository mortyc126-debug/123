/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkerUpdater;
import androidx.work.impl.model.WorkSpec;
import java.util.List;
import java.util.Set;

public final class WorkerUpdater$$ExternalSyntheticLambda0
implements Runnable {
    public final WorkDatabase f$0;
    public final WorkSpec f$1;
    public final WorkSpec f$2;
    public final List f$3;
    public final String f$4;
    public final Set f$5;
    public final boolean f$6;

    public /* synthetic */ WorkerUpdater$$ExternalSyntheticLambda0(WorkDatabase workDatabase, WorkSpec workSpec, WorkSpec workSpec2, List list, String string2, Set set, boolean bl) {
        this.f$0 = workDatabase;
        this.f$1 = workSpec;
        this.f$2 = workSpec2;
        this.f$3 = list;
        this.f$4 = string2;
        this.f$5 = set;
        this.f$6 = bl;
    }

    @Override
    public final void run() {
        WorkerUpdater.$r8$lambda$rZYaIXP2nyFPAV1cj7a66zI-7Hs(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
    }
}

