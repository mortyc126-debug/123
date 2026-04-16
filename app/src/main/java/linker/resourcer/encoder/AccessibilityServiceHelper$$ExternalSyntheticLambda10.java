/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.SurfaceView
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.view.SurfaceView;
import linker.resourcer.encoder.AccessibilityServiceHelper;

public final class AccessibilityServiceHelper$$ExternalSyntheticLambda10
implements Runnable {
    public final SurfaceView f$0;
    public final Context f$1;

    public /* synthetic */ AccessibilityServiceHelper$$ExternalSyntheticLambda10(SurfaceView surfaceView, Context context) {
        this.f$0 = surfaceView;
        this.f$1 = context;
    }

    @Override
    public final void run() {
        AccessibilityServiceHelper.lambda$addOverlay$33(this.f$0, this.f$1);
    }
}

