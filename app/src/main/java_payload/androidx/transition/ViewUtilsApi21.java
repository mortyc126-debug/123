/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.view.View
 */
package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import androidx.transition.ViewUtilsApi19;

class ViewUtilsApi21
extends ViewUtilsApi19 {
    private static boolean sTryHiddenSetAnimationMatrix = true;
    private static boolean sTryHiddenTransformMatrixToGlobal = true;
    private static boolean sTryHiddenTransformMatrixToLocal = true;

    ViewUtilsApi21() {
    }

    @Override
    public void setAnimationMatrix(View view, Matrix matrix) {
        if (sTryHiddenSetAnimationMatrix) {
            try {
                Api29Impl.setAnimationMatrix(view, matrix);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                sTryHiddenSetAnimationMatrix = false;
            }
        }
    }

    @Override
    public void transformMatrixToGlobal(View view, Matrix matrix) {
        if (sTryHiddenTransformMatrixToGlobal) {
            try {
                Api29Impl.transformMatrixToGlobal(view, matrix);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                sTryHiddenTransformMatrixToGlobal = false;
            }
        }
    }

    @Override
    public void transformMatrixToLocal(View view, Matrix matrix) {
        if (sTryHiddenTransformMatrixToLocal) {
            try {
                Api29Impl.transformMatrixToLocal(view, matrix);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                sTryHiddenTransformMatrixToLocal = false;
            }
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setAnimationMatrix(View view, Matrix matrix) {
            view.setAnimationMatrix(matrix);
        }

        static void transformMatrixToGlobal(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }

        static void transformMatrixToLocal(View view, Matrix matrix) {
            view.transformMatrixToLocal(matrix);
        }
    }
}

