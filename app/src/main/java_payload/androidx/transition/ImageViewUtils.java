/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.os.Build$VERSION
 *  android.widget.ImageView
 */
package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

class ImageViewUtils {
    private static Field sDrawMatrixField;
    private static boolean sDrawMatrixFieldFetched;
    private static boolean sTryHiddenAnimateTransform;

    static {
        sTryHiddenAnimateTransform = true;
    }

    private ImageViewUtils() {
    }

    static void animateTransform(ImageView imageView, Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.animateTransform(imageView, matrix);
        } else if (matrix == null) {
            matrix = imageView.getDrawable();
            if (matrix != null) {
                matrix.setBounds(0, 0, imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight(), imageView.getHeight() - imageView.getPaddingTop() - imageView.getPaddingBottom());
                imageView.invalidate();
            }
        } else {
            ImageViewUtils.hiddenAnimateTransform(imageView, matrix);
        }
    }

    private static void fetchDrawMatrixField() {
        if (!sDrawMatrixFieldFetched) {
            try {
                sDrawMatrixField = ImageView.class.getDeclaredField("mDrawMatrix");
                sDrawMatrixField.setAccessible(true);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                // empty catch block
            }
            sDrawMatrixFieldFetched = true;
        }
    }

    private static void hiddenAnimateTransform(ImageView imageView, Matrix matrix) {
        if (sTryHiddenAnimateTransform) {
            try {
                Api29Impl.animateTransform(imageView, matrix);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                sTryHiddenAnimateTransform = false;
            }
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void animateTransform(ImageView imageView, Matrix matrix) {
            imageView.animateTransform(matrix);
        }
    }
}

