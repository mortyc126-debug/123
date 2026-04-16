/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl;

import androidx.work.impl.Processor;
import androidx.work.impl.model.WorkGenerationalId;

public final class Processor$$ExternalSyntheticLambda2
implements Runnable {
    public final Processor f$0;
    public final WorkGenerationalId f$1;
    public final boolean f$2;

    public /* synthetic */ Processor$$ExternalSyntheticLambda2(Processor processor, WorkGenerationalId workGenerationalId, boolean bl) {
        this.f$0 = processor;
        this.f$1 = workGenerationalId;
        this.f$2 = bl;
    }

    @Override
    public final void run() {
        this.f$0.lambda$runOnExecuted$2$androidx-work-impl-Processor(this.f$1, this.f$2);
    }
}

