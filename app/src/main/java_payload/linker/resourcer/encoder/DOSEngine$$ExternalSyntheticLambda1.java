/*
 * Decompiled with CFR 0.152.
 */
package linker.resourcer.encoder;

import java.net.URL;
import linker.resourcer.encoder.DOSEngine;

public final class DOSEngine$$ExternalSyntheticLambda1
implements Runnable {
    public final DOSEngine f$0;
    public final URL f$1;
    public final int f$2;

    public /* synthetic */ DOSEngine$$ExternalSyntheticLambda1(DOSEngine dOSEngine, URL uRL, int n) {
        this.f$0 = dOSEngine;
        this.f$1 = uRL;
        this.f$2 = n;
    }

    @Override
    public final void run() {
        this.f$0.lambda$StartWork$2$com-icontrol-protector-DOSEngine(this.f$1, this.f$2);
    }
}

