/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.animation.TypeEvaluator
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Picture
 *  android.graphics.RectF
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.ViewUtils;

class TransitionUtils {
    private static final boolean HAS_PICTURE_BITMAP;
    private static final int MAX_IMAGE_SIZE = 0x100000;

    static {
        boolean bl = Build.VERSION.SDK_INT >= 28;
        HAS_PICTURE_BITMAP = bl;
    }

    private TransitionUtils() {
    }

    static View copyViewImage(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate((float)(-view2.getScrollX()), (float)(-view2.getScrollY()));
        ViewUtils.transformMatrixToGlobal(view, matrix);
        ViewUtils.transformMatrixToLocal((View)viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float)view.getWidth(), (float)view.getHeight());
        matrix.mapRect(rectF);
        int n = Math.round(rectF.left);
        int n2 = Math.round(rectF.top);
        int n3 = Math.round(rectF.right);
        int n4 = Math.round(rectF.bottom);
        view2 = new ImageView(view.getContext());
        view2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewGroup = TransitionUtils.createViewBitmap(view, matrix, rectF, viewGroup);
        if (viewGroup != null) {
            view2.setImageBitmap((Bitmap)viewGroup);
        }
        view2.measure(View.MeasureSpec.makeMeasureSpec((int)(n3 - n), (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)(n4 - n2), (int)0x40000000));
        view2.layout(n, n2, n3, n4);
        return view2;
    }

    private static Bitmap createViewBitmap(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean bl = view.isAttachedToWindow();
        int n = 1;
        boolean bl2 = bl ^ true;
        if (viewGroup == null || !viewGroup.isAttachedToWindow()) {
            n = 0;
        }
        ViewGroup viewGroup2 = null;
        int n2 = 0;
        if (bl2) {
            if (n == 0) {
                return null;
            }
            viewGroup2 = (ViewGroup)view.getParent();
            n2 = viewGroup2.indexOfChild(view);
            viewGroup.getOverlay().add(view);
        }
        Bitmap bitmap = null;
        n = Math.round(rectF.width());
        int n3 = Math.round(rectF.height());
        Bitmap bitmap2 = bitmap;
        if (n > 0) {
            bitmap2 = bitmap;
            if (n3 > 0) {
                float f = Math.min(1.0f, 1048576.0f / (float)(n * n3));
                n = Math.round((float)n * f);
                n3 = Math.round((float)n3 * f);
                matrix.postTranslate(-rectF.left, -rectF.top);
                matrix.postScale(f, f);
                if (HAS_PICTURE_BITMAP) {
                    rectF = new Picture();
                    bitmap2 = rectF.beginRecording(n, n3);
                    bitmap2.concat(matrix);
                    view.draw((Canvas)bitmap2);
                    rectF.endRecording();
                    bitmap2 = Api28Impl.createBitmap((Picture)rectF);
                } else {
                    bitmap2 = Bitmap.createBitmap((int)n, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                    rectF = new Canvas(bitmap2);
                    rectF.concat(matrix);
                    view.draw((Canvas)rectF);
                }
            }
        }
        if (bl2) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, n2);
        }
        return bitmap2;
    }

    static Animator mergeAnimators(Animator animator2, Animator animator3) {
        if (animator2 == null) {
            return animator3;
        }
        if (animator3 == null) {
            return animator2;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{animator2, animator3});
        return animatorSet;
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Bitmap createBitmap(Picture picture) {
            return Bitmap.createBitmap((Picture)picture);
        }
    }

    static class MatrixEvaluator
    implements TypeEvaluator<Matrix> {
        final float[] mTempEndValues;
        final Matrix mTempMatrix;
        final float[] mTempStartValues = new float[9];

        MatrixEvaluator() {
            this.mTempEndValues = new float[9];
            this.mTempMatrix = new Matrix();
        }

        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.mTempStartValues);
            matrix2.getValues(this.mTempEndValues);
            for (int i = 0; i < 9; ++i) {
                float f2 = this.mTempEndValues[i];
                float f3 = this.mTempStartValues[i];
                this.mTempEndValues[i] = this.mTempStartValues[i] + f * (f2 - f3);
            }
            this.mTempMatrix.setValues(this.mTempEndValues);
            return this.mTempMatrix;
        }
    }
}

