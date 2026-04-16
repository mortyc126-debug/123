/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.Gravity
 */
package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

public final class GravityCompat {
    public static final int END = 0x800005;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 0x800007;
    public static final int RELATIVE_LAYOUT_DIRECTION = 0x800000;
    public static final int START = 0x800003;

    private GravityCompat() {
    }

    public static void apply(int n, int n2, int n3, Rect rect, int n4, int n5, Rect rect2, int n6) {
        Gravity.apply((int)n, (int)n2, (int)n3, (Rect)rect, (int)n4, (int)n5, (Rect)rect2, (int)n6);
    }

    public static void apply(int n, int n2, int n3, Rect rect, Rect rect2, int n4) {
        Gravity.apply((int)n, (int)n2, (int)n3, (Rect)rect, (Rect)rect2, (int)n4);
    }

    public static void applyDisplay(int n, Rect rect, Rect rect2, int n2) {
        Gravity.applyDisplay((int)n, (Rect)rect, (Rect)rect2, (int)n2);
    }

    public static int getAbsoluteGravity(int n, int n2) {
        return Gravity.getAbsoluteGravity((int)n, (int)n2);
    }
}

