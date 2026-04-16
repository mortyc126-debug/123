/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.Animator$AnimatorPauseListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.Property
 *  android.view.ViewGroup
 *  android.widget.ImageView
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.ImageViewUtils;
import androidx.transition.MatrixUtils;
import androidx.transition.R;
import androidx.transition.Transition;
import androidx.transition.TransitionUtils;
import androidx.transition.TransitionValues;
import java.util.Map;

public class ChangeImageTransform
extends Transition {
    private static final Property<ImageView, Matrix> ANIMATED_TRANSFORM_PROPERTY;
    private static final TypeEvaluator<Matrix> NULL_MATRIX_EVALUATOR;
    private static final String PROPNAME_BOUNDS = "android:changeImageTransform:bounds";
    private static final String PROPNAME_MATRIX = "android:changeImageTransform:matrix";
    private static final String[] sTransitionProperties;

    static {
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_BOUNDS};
        NULL_MATRIX_EVALUATOR = new TypeEvaluator<Matrix>(){

            public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
                return null;
            }
        };
        ANIMATED_TRANSFORM_PROPERTY = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform"){

            public Matrix get(ImageView imageView) {
                return null;
            }

            public void set(ImageView imageView, Matrix matrix) {
                ImageViewUtils.animateTransform(imageView, matrix);
            }
        };
    }

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void captureValues(TransitionValues transitionValues, boolean bl) {
        Object object = transitionValues.view;
        if (object instanceof ImageView && object.getVisibility() == 0) {
            ImageView imageView = (ImageView)object;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map2 = transitionValues.values;
            map2.put(PROPNAME_BOUNDS, new Rect(object.getLeft(), object.getTop(), object.getRight(), object.getBottom()));
            transitionValues = null;
            if (bl) {
                transitionValues = (Matrix)imageView.getTag(R.id.transition_image_transform);
            }
            object = transitionValues;
            if (transitionValues == null) {
                object = ChangeImageTransform.copyImageMatrix(imageView);
            }
            map2.put(PROPNAME_MATRIX, object);
            return;
        }
    }

    private static Matrix centerCropMatrix(ImageView imageView) {
        Drawable drawable2 = imageView.getDrawable();
        int n = drawable2.getIntrinsicWidth();
        int n2 = imageView.getWidth();
        float f = (float)n2 / (float)n;
        int n3 = drawable2.getIntrinsicHeight();
        int n4 = imageView.getHeight();
        float f2 = Math.max(f, (float)n4 / (float)n3);
        f = n;
        float f3 = n3;
        n2 = Math.round(((float)n2 - f * f2) / 2.0f);
        n4 = Math.round(((float)n4 - f3 * f2) / 2.0f);
        imageView = new Matrix();
        imageView.postScale(f2, f2);
        imageView.postTranslate((float)n2, (float)n4);
        return imageView;
    }

    private static Matrix copyImageMatrix(ImageView imageView) {
        Drawable drawable2 = imageView.getDrawable();
        if (drawable2.getIntrinsicWidth() > 0 && drawable2.getIntrinsicHeight() > 0) {
            switch (3.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()]) {
                default: {
                    return new Matrix(imageView.getImageMatrix());
                }
                case 2: {
                    return ChangeImageTransform.centerCropMatrix(imageView);
                }
                case 1: 
            }
            return ChangeImageTransform.fitXYMatrix(imageView);
        }
        return new Matrix(imageView.getImageMatrix());
    }

    private ObjectAnimator createMatrixAnimator(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject((Object)imageView, ANIMATED_TRANSFORM_PROPERTY, (TypeEvaluator)new TransitionUtils.MatrixEvaluator(), (Object[])new Matrix[]{matrix, matrix2});
    }

    private ObjectAnimator createNullAnimator(ImageView imageView) {
        return ObjectAnimator.ofObject((Object)imageView, ANIMATED_TRANSFORM_PROPERTY, NULL_MATRIX_EVALUATOR, (Object[])new Matrix[]{MatrixUtils.IDENTITY_MATRIX, MatrixUtils.IDENTITY_MATRIX});
    }

    private static Matrix fitXYMatrix(ImageView imageView) {
        Drawable drawable2 = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale((float)imageView.getWidth() / (float)drawable2.getIntrinsicWidth(), (float)imageView.getHeight() / (float)drawable2.getIntrinsicHeight());
        return matrix;
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues, false);
    }

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues, true);
    }

    @Override
    public Animator createAnimator(ViewGroup object, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues != null && transitionValues2 != null) {
            object = (Rect)transitionValues.values.get(PROPNAME_BOUNDS);
            Rect rect = (Rect)transitionValues2.values.get(PROPNAME_BOUNDS);
            if (object != null && rect != null) {
                transitionValues = (Matrix)transitionValues.values.get(PROPNAME_MATRIX);
                Matrix matrix = (Matrix)transitionValues2.values.get(PROPNAME_MATRIX);
                int n = transitionValues == null && matrix == null || transitionValues != null && transitionValues.equals(matrix) ? 1 : 0;
                if (object.equals((Object)rect) && n != 0) {
                    return null;
                }
                rect = (ImageView)transitionValues2.view;
                object = rect.getDrawable();
                n = object.getIntrinsicWidth();
                int n2 = object.getIntrinsicHeight();
                if (n > 0 && n2 > 0) {
                    object = transitionValues;
                    if (transitionValues == null) {
                        object = MatrixUtils.IDENTITY_MATRIX;
                    }
                    transitionValues = matrix;
                    if (matrix == null) {
                        transitionValues = MatrixUtils.IDENTITY_MATRIX;
                    }
                    ANIMATED_TRANSFORM_PROPERTY.set((Object)rect, object);
                    transitionValues2 = this.createMatrixAnimator((ImageView)rect, (Matrix)object, (Matrix)transitionValues);
                    object = new Listener((ImageView)rect, (Matrix)object, (Matrix)transitionValues);
                    transitionValues2.addListener((Animator.AnimatorListener)object);
                    transitionValues2.addPauseListener((Animator.AnimatorPauseListener)object);
                    this.addListener((Transition.TransitionListener)object);
                    object = transitionValues2;
                } else {
                    object = this.createNullAnimator((ImageView)rect);
                }
                return object;
            }
            return null;
        }
        return null;
    }

    @Override
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override
    public boolean isSeekingSupported() {
        return true;
    }

    private static class Listener
    extends AnimatorListenerAdapter
    implements Transition.TransitionListener {
        private final Matrix mEndMatrix;
        private final ImageView mImageView;
        private boolean mIsBeforeAnimator = true;
        private final Matrix mStartMatrix;

        Listener(ImageView imageView, Matrix matrix, Matrix matrix2) {
            this.mImageView = imageView;
            this.mStartMatrix = matrix;
            this.mEndMatrix = matrix2;
        }

        private void restoreMatrix() {
            Matrix matrix = (Matrix)this.mImageView.getTag(R.id.transition_image_transform);
            if (matrix != null) {
                ImageViewUtils.animateTransform(this.mImageView, matrix);
                this.mImageView.setTag(R.id.transition_image_transform, null);
            }
        }

        private void saveMatrix(Matrix matrix) {
            this.mImageView.setTag(R.id.transition_image_transform, (Object)matrix);
            ImageViewUtils.animateTransform(this.mImageView, this.mEndMatrix);
        }

        public void onAnimationEnd(Animator animator2) {
            this.mIsBeforeAnimator = false;
        }

        public void onAnimationEnd(Animator animator2, boolean bl) {
            this.mIsBeforeAnimator = bl;
        }

        public void onAnimationPause(Animator animator2) {
            this.saveMatrix((Matrix)((ObjectAnimator)animator2).getAnimatedValue());
        }

        public void onAnimationResume(Animator animator2) {
            this.restoreMatrix();
        }

        public void onAnimationStart(Animator animator2) {
            this.mIsBeforeAnimator = false;
        }

        public void onAnimationStart(Animator animator2, boolean bl) {
            this.mIsBeforeAnimator = false;
        }

        @Override
        public void onTransitionCancel(Transition transition) {
        }

        @Override
        public void onTransitionEnd(Transition transition) {
        }

        @Override
        public void onTransitionPause(Transition transition) {
            if (this.mIsBeforeAnimator) {
                this.saveMatrix(this.mStartMatrix);
            }
        }

        @Override
        public void onTransitionResume(Transition transition) {
            this.restoreMatrix();
        }

        @Override
        public void onTransitionStart(Transition transition) {
        }
    }
}

