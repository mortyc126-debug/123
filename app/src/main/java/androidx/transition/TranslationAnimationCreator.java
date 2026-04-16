/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TimeInterpolator
 *  android.util.Property
 *  android.view.View
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import androidx.transition.R;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;

class TranslationAnimationCreator {
    private TranslationAnimationCreator() {
    }

    static Animator createAnimation(View object, TransitionValues transitionValues, int n, int n2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator, Transition transition) {
        float f5 = object.getTranslationX();
        float f6 = object.getTranslationY();
        Object object2 = (int[])transitionValues.view.getTag(R.id.transition_position);
        if (object2 != null) {
            f = (float)(object2[0] - n) + f5;
            f2 = (float)(object2[1] - n2) + f6;
        }
        object.setTranslationX(f);
        object.setTranslationY(f2);
        if (f == f3 && f2 == f4) {
            return null;
        }
        object2 = ObjectAnimator.ofPropertyValuesHolder((Object)object, (PropertyValuesHolder[])new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat((Property)View.TRANSLATION_X, (float[])new float[]{f, f3}), PropertyValuesHolder.ofFloat((Property)View.TRANSLATION_Y, (float[])new float[]{f2, f4})});
        object = new TransitionPositionListener((View)object, transitionValues.view, f5, f6);
        transition.addListener((Transition.TransitionListener)object);
        object2.addListener((Animator.AnimatorListener)object);
        object2.setInterpolator(timeInterpolator);
        return object2;
    }

    private static class TransitionPositionListener
    extends AnimatorListenerAdapter
    implements Transition.TransitionListener {
        private boolean mIsTransitionCanceled;
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        TransitionPositionListener(View view, View view2, float f, float f2) {
            this.mMovingView = view;
            this.mViewInHierarchy = view2;
            this.mTerminalX = f;
            this.mTerminalY = f2;
            this.mTransitionPosition = (int[])this.mViewInHierarchy.getTag(R.id.transition_position);
            if (this.mTransitionPosition != null) {
                this.mViewInHierarchy.setTag(R.id.transition_position, null);
            }
        }

        private void setInterruptedPosition() {
            if (this.mTransitionPosition == null) {
                this.mTransitionPosition = new int[2];
            }
            this.mMovingView.getLocationOnScreen(this.mTransitionPosition);
            this.mViewInHierarchy.setTag(R.id.transition_position, (Object)this.mTransitionPosition);
        }

        public void onAnimationCancel(Animator animator2) {
            this.mIsTransitionCanceled = true;
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        public void onAnimationEnd(Animator animator2) {
            this.onAnimationEnd(animator2, false);
        }

        public void onAnimationEnd(Animator animator2, boolean bl) {
            if (!bl) {
                this.mMovingView.setTranslationX(this.mTerminalX);
                this.mMovingView.setTranslationY(this.mTerminalY);
            }
        }

        @Override
        public void onTransitionCancel(Transition transition) {
            this.mIsTransitionCanceled = true;
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override
        public void onTransitionEnd(Transition transition) {
            this.onTransitionEnd(transition, false);
        }

        @Override
        public void onTransitionEnd(Transition transition, boolean bl) {
            if (!this.mIsTransitionCanceled) {
                this.mViewInHierarchy.setTag(R.id.transition_position, null);
            }
        }

        @Override
        public void onTransitionPause(Transition transition) {
            this.setInterruptedPosition();
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override
        public void onTransitionResume(Transition transition) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        @Override
        public void onTransitionStart(Transition transition) {
        }
    }
}

