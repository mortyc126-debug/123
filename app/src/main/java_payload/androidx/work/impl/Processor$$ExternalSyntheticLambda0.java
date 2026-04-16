/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl;

import androidx.work.impl.Processor;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public final class Processor$$ExternalSyntheticLambda0
implements Callable {
    public final Processor f$0;
    public final ArrayList f$1;
    public final String f$2;

    public /* synthetic */ Processor$$ExternalSyntheticLambda0(Processor processor, ArrayList arrayList, String string2) {
        this.f$0 = processor;
        this.f$1 = arrayList;
        this.f$2 = string2;
    }

    public final Object call() {
        return this.f$0.lambda$startWork$0$androidx-work-impl-Processor(this.f$1, this.f$2);
    }
}

