/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package androidx.core.view;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.DragStartHelper;

public final class DragStartHelper$$ExternalSyntheticLambda1
implements View.OnTouchListener {
    public final DragStartHelper f$0;

    public /* synthetic */ DragStartHelper$$ExternalSyntheticLambda1(DragStartHelper dragStartHelper) {
        this.f$0 = dragStartHelper;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f$0.onTouch(view, motionEvent);
    }
}

