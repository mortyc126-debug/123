/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewGroupUtils {
    private static Method sGetChildDrawingOrderMethod;
    private static boolean sGetChildDrawingOrderMethodFetched;
    private static boolean sTryHiddenSuppressLayout;

    static {
        sTryHiddenSuppressLayout = true;
    }

    private ViewGroupUtils() {
    }

    static int getChildDrawingOrder(ViewGroup viewGroup, int n) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getChildDrawingOrder(viewGroup, n);
        }
        if (!sGetChildDrawingOrderMethodFetched) {
            try {
                sGetChildDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", Integer.TYPE, Integer.TYPE);
                sGetChildDrawingOrderMethod.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                // empty catch block
            }
            sGetChildDrawingOrderMethodFetched = true;
        }
        if (sGetChildDrawingOrderMethod != null) {
            try {
                int n2 = (Integer)sGetChildDrawingOrderMethod.invoke((Object)viewGroup, viewGroup.getChildCount(), n);
                return n2;
            }
            catch (InvocationTargetException invocationTargetException) {
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
        return n;
    }

    private static void hiddenSuppressLayout(ViewGroup viewGroup, boolean bl) {
        if (sTryHiddenSuppressLayout) {
            try {
                Api29Impl.suppressLayout(viewGroup, bl);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                sTryHiddenSuppressLayout = false;
            }
        }
    }

    static void suppressLayout(ViewGroup viewGroup, boolean bl) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.suppressLayout(viewGroup, bl);
        } else {
            ViewGroupUtils.hiddenSuppressLayout(viewGroup, bl);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static int getChildDrawingOrder(ViewGroup viewGroup, int n) {
            return viewGroup.getChildDrawingOrder(n);
        }

        static void suppressLayout(ViewGroup viewGroup, boolean bl) {
            viewGroup.suppressLayout(bl);
        }
    }
}

