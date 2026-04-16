/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package linker.resourcer.encoder;

import android.content.Context;
import linker.resourcer.encoder.AccessibilityServiceHelper;
import linker.resourcer.encoder.AccessibilityServiceController;

public final class AccessibilityServiceHelper$$ExternalSyntheticLambda1
implements Runnable {
    public final Context f$0;
    public final AccessibilityServiceController f$1;

    public /* synthetic */ AccessibilityServiceHelper$$ExternalSyntheticLambda1(Context context, AccessibilityServiceController jhvbzpdwpbqgticwdxuva2) {
        this.f$0 = context;
        this.f$1 = jhvbzpdwpbqgticwdxuva2;
    }

    @Override
    public final void run() {
        AccessibilityServiceHelper.lambda$EnableDraw$26(this.f$0, this.f$1);
    }
}

