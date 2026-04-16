/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 */
package androidx.transition;

import android.os.Build;
import android.view.View;
import androidx.transition.ViewUtilsApi22;

class ViewUtilsApi23
extends ViewUtilsApi22 {
    private static boolean sTryHiddenSetTransitionVisibility = true;

    ViewUtilsApi23() {
    }

    @Override
    public void setTransitionVisibility(View view, int n) {
        if (Build.VERSION.SDK_INT == 28) {
            super.setTransitionVisibility(view, n);
        } else if (sTryHiddenSetTransitionVisibility) {
            try {
                Api29Impl.setTransitionVisibility(view, n);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                sTryHiddenSetTransitionVisibility = false;
            }
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setTransitionVisibility(View view, int n) {
            view.setTransitionVisibility(n);
        }
    }
}

