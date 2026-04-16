/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewParent
 */
package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewUtilsApi19 {
    private static final String TAG = "ViewUtilsApi19";
    private static final int VISIBILITY_MASK = 12;
    private static boolean sSetFrameFetched;
    private static Method sSetFrameMethod;
    private static boolean sTryHiddenTransitionAlpha;
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;
    private float[] mMatrixValues;

    static {
        sTryHiddenTransitionAlpha = true;
    }

    ViewUtilsApi19() {
    }

    private void fetchSetFrame() {
        if (!sSetFrameFetched) {
            try {
                sSetFrameMethod = View.class.getDeclaredMethod("setFrame", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                sSetFrameMethod.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)TAG, (String)"Failed to retrieve setFrame method", (Throwable)noSuchMethodException);
            }
            sSetFrameFetched = true;
        }
    }

    public void clearNonTransitionAlpha(View view) {
    }

    public float getTransitionAlpha(View view) {
        if (sTryHiddenTransitionAlpha) {
            try {
                float f = Api29Impl.getTransitionAlpha(view);
                return f;
            }
            catch (NoSuchMethodError noSuchMethodError) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        return view.getAlpha();
    }

    public void saveNonTransitionAlpha(View view) {
    }

    public void setAnimationMatrix(View view, Matrix matrix) {
        if (matrix != null && !matrix.isIdentity()) {
            float[] fArray;
            float[] fArray2 = fArray = this.mMatrixValues;
            if (fArray == null) {
                fArray2 = fArray = new float[9];
                this.mMatrixValues = fArray;
            }
            matrix.getValues(fArray2);
            float f = fArray2[3];
            float f2 = (float)Math.sqrt(1.0f - f * f);
            int n = fArray2[0] < 0.0f ? -1 : 1;
            float f3 = f2 * (float)n;
            f = (float)Math.toDegrees(Math.atan2(f, f3));
            f2 = fArray2[0] / f3;
            f3 = fArray2[4] / f3;
            float f4 = fArray2[2];
            float f5 = fArray2[5];
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setTranslationX(f4);
            view.setTranslationY(f5);
            view.setRotation(f);
            view.setScaleX(f2);
            view.setScaleY(f3);
        } else {
            view.setPivotX((float)(view.getWidth() / 2));
            view.setPivotY((float)(view.getHeight() / 2));
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
        }
    }

    public void setLeftTopRightBottom(View view, int n, int n2, int n3, int n4) {
        this.fetchSetFrame();
        if (sSetFrameMethod != null) {
            try {
                sSetFrameMethod.invoke((Object)view, n, n2, n3, n4);
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new RuntimeException(invocationTargetException.getCause());
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
    }

    public void setTransitionAlpha(View view, float f) {
        if (sTryHiddenTransitionAlpha) {
            try {
                Api29Impl.setTransitionAlpha(view, f);
                return;
            }
            catch (NoSuchMethodError noSuchMethodError) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        view.setAlpha(f);
    }

    public void setTransitionVisibility(View view, int n) {
        if (!sViewFlagsFieldFetched) {
            try {
                sViewFlagsField = View.class.getDeclaredField("mViewFlags");
                sViewFlagsField.setAccessible(true);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                Log.i((String)TAG, (String)"fetchViewFlagsField: ");
            }
            sViewFlagsFieldFetched = true;
        }
        if (sViewFlagsField != null) {
            try {
                int n2 = sViewFlagsField.getInt(view);
                sViewFlagsField.setInt(view, n2 & 0xFFFFFFF3 | n);
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
    }

    public void transformMatrixToGlobal(View view, Matrix matrix) {
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof View) {
            viewParent = (View)viewParent;
            this.transformMatrixToGlobal((View)viewParent, matrix);
            matrix.preTranslate((float)(-viewParent.getScrollX()), (float)(-viewParent.getScrollY()));
        }
        matrix.preTranslate((float)view.getLeft(), (float)view.getTop());
        view = view.getMatrix();
        if (!view.isIdentity()) {
            matrix.preConcat((Matrix)view);
        }
    }

    public void transformMatrixToLocal(View view, Matrix matrix) {
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof View) {
            viewParent = (View)viewParent;
            this.transformMatrixToLocal((View)viewParent, matrix);
            matrix.postTranslate((float)viewParent.getScrollX(), (float)viewParent.getScrollY());
        }
        matrix.postTranslate((float)(-view.getLeft()), (float)(-view.getTop()));
        view = view.getMatrix();
        if (!view.isIdentity() && view.invert((Matrix)(viewParent = new Matrix()))) {
            matrix.postConcat((Matrix)viewParent);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static float getTransitionAlpha(View view) {
            return view.getTransitionAlpha();
        }

        static void setTransitionAlpha(View view, float f) {
            view.setTransitionAlpha(f);
        }
    }
}

