/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package linker.resourcer.encoder;

import android.content.Context;
import linker.resourcer.encoder.ScreenCaptureService;

public final class ScreenCaptureService$1$$ExternalSyntheticLambda2
implements Runnable {
    public final ScreenCaptureService.1 f$0;
    public final Context f$1;

    public /* synthetic */ ScreenCaptureService$1$$ExternalSyntheticLambda2(ScreenCaptureService.1 var1_1, Context context) {
        this.f$0 = var1_1;
        this.f$1 = context;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onClosing$0$com-icontrol-protector-ScreenCaptureService$1(this.f$1);
    }
}

