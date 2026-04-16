/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.widget.ListPopupWindow
 */
package androidx.core.widget;

import android.view.View;
import android.widget.ListPopupWindow;

public final class ListPopupWindowCompat {
    private ListPopupWindowCompat() {
    }

    public static View.OnTouchListener createDragToOpenListener(ListPopupWindow listPopupWindow, View view) {
        return listPopupWindow.createDragToOpenListener(view);
    }

    @Deprecated
    public static View.OnTouchListener createDragToOpenListener(Object object, View view) {
        return ListPopupWindowCompat.createDragToOpenListener((ListPopupWindow)object, view);
    }
}

