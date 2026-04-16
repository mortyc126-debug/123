/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package linker.resourcer.encoder;

import android.content.Context;
import linker.resourcer.encoder.ScreenCaptureService;

public final class ScreenCaptureService$$ExternalSyntheticLambda0
implements Runnable {
    public final ScreenCaptureService f$0;
    public final Context f$1;

    public /* synthetic */ ScreenCaptureService$$ExternalSyntheticLambda0(ScreenCaptureService jcavdzvncdstlcwvoszkepac2, Context context) {
        this.f$0 = jcavdzvncdstlcwvoszkepac2;
        this.f$1 = context;
    }

    @Override
    public final void run() {
        this.f$0.lambda$startOrientationWatcher$1$com-icontrol-protector-ScreenCaptureService(this.f$1);
    }
}

