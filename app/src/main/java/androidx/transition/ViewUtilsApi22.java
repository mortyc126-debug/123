/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.transition;

import android.view.View;
import androidx.transition.ViewUtilsApi21;

class ViewUtilsApi22
extends ViewUtilsApi21 {
    private static boolean sTryHiddenSetLeftTopRightBottom = true;

    ViewUtilsApi22() {
    }

    @Override
    public void setLeftTopRightBottom(View view, int n, int n2, int n3, int n4) {
        if (sTryHiddenSetLeftTopRightBottom) {
            try {
                Api29Impl.setLeftTopRightBottom(view, n, n2, n3, n4);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                sTryHiddenSetLeftTopRightBottom = false;
            }
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setLeftTopRightBottom(View view, int n, int n2, int n3, int n4) {
            view.setLeftTopRightBottom(n, n2, n3, n4);
        }
    }
}

