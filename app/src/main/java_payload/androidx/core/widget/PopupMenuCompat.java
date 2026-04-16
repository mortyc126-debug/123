/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View$OnTouchListener
 *  android.widget.PopupMenu
 */
package androidx.core.widget;

import android.view.View;
import android.widget.PopupMenu;

public final class PopupMenuCompat {
    private PopupMenuCompat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object object) {
        return ((PopupMenu)object).getDragToOpenListener();
    }
}

