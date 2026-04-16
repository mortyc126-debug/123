/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.PopupWindow
 */
package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PopupWindowCompat {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(PopupWindow popupWindow) {
        return Api23Impl.getOverlapAnchor(popupWindow);
    }

    public static int getWindowLayoutType(PopupWindow popupWindow) {
        return Api23Impl.getWindowLayoutType(popupWindow);
    }

    public static void setOverlapAnchor(PopupWindow popupWindow, boolean bl) {
        Api23Impl.setOverlapAnchor(popupWindow, bl);
    }

    public static void setWindowLayoutType(PopupWindow popupWindow, int n) {
        Api23Impl.setWindowLayoutType(popupWindow, n);
    }

    public static void showAsDropDown(PopupWindow popupWindow, View view, int n, int n2, int n3) {
        popupWindow.showAsDropDown(view, n, n2, n3);
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static boolean getOverlapAnchor(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        static int getWindowLayoutType(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        static void setOverlapAnchor(PopupWindow popupWindow, boolean bl) {
            popupWindow.setOverlapAnchor(bl);
        }

        static void setWindowLayoutType(PopupWindow popupWindow, int n) {
            popupWindow.setWindowLayoutType(n);
        }
    }
}

