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

public final class AccessibilityServiceHelper$$ExternalSyntheticLambda3
implements Runnable {
    public final AccessibilityServiceController f$0;
    public final Context f$1;

    public /* synthetic */ AccessibilityServiceHelper$$ExternalSyntheticLambda3(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2, Context context) {
        this.f$0 = jhvbzpdwpbqgticwdxuva2;
        this.f$1 = context;
    }

    @Override
    public final void run() {
        AccessibilityServiceHelper.lambda$EnableDraw$30(this.f$0, this.f$1);
    }
}

