/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.R;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.ViewUtils;
import androidx.transition.Visibility;
import org.xmlpull.v1.XmlPullParser;

public class Fade
extends Visibility {
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";

    public Fade() {
    }

    public Fade(int n) {
        this.setMode(n);
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, Styleable.FADE);
        this.setMode(TypedArrayUtils.getNamedInt((TypedArray)context, (XmlPullParser)((XmlResourceParser)attributeSet), "fadingMode", 0, this.getMode()));
        context.recycle();
    }

    private Animator createAnimation(View object, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ViewUtils.setTransitionAlpha(object, f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)object, ViewUtils.TRANSITION_ALPHA, (float[])new float[]{f2});
        object = new FadeAnimatorListener((View)object);
        objectAnimator.addListener((Animator.AnimatorListener)object);
        this.getRootTransition().addListener((Transition.TransitionListener)object);
        return objectAnimator;
    }

    private static float getStartAlpha(TransitionValues object, float f) {
        float f2;
        f = f2 = f;
        if (object != null) {
            object = (Float)((TransitionValues)object).values.get(PROPNAME_TRANSITION_ALPHA);
            f = f2;
            if (object != null) {
                f = ((Float)object).floatValue();
            }
        }
        return f;
    }

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        Float f;
        super.captureStartValues(transitionValues);
        Float f2 = f = (Float)transitionValues.view.getTag(R.id.transition_pause_alpha);
        if (f == null) {
            f2 = transitionValues.view.getVisibility() == 0 ? Float.valueOf(ViewUtils.getTransitionAlpha(transitionValues.view)) : Float.valueOf(0.0f);
        }
        transitionValues.values.put(PROPNAME_TRANSITION_ALPHA, f2);
    }

    @Override
    public boolean isSeekingSupported() {
        return true;
    }

    @Override
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.saveNonTransitionAlpha(view);
        return this.createAnimation(view, Fade.getStartAlpha(transitionValues, 0.0f), 1.0f);
    }

    @Override
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.saveNonTransitionAlpha(view);
        viewGroup = this.createAnimation(view, Fade.getStartAlpha(transitionValues, 1.0f), 0.0f);
        if (viewGroup == null) {
            ViewUtils.setTransitionAlpha(view, Fade.getStartAlpha(transitionValues2, 1.0f));
        }
        return viewGroup;
    }

    private static class FadeAnimatorListener
    extends AnimatorListenerAdapter
    implements Transition.TransitionListener {
        private boolean mLayerTypeChanged = false;
        private final View mView;

        FadeAnimatorListener(View view) {
            this.mView = view;
        }

        public void onAnimationCancel(Animator animator2) {
            ViewUtils.setTransitionAlpha(this.mView, 1.0f);
        }

        public void onAnimationEnd(Animator animator2) {
            this.onAnimationEnd(animator2, false);
        }

        public void onAnimationEnd(Animator animator2, boolean bl) {
            if (this.mLayerTypeChanged) {
                this.mView.setLayerType(0, null);
            }
            if (!bl) {
                ViewUtils.setTransitionAlpha(this.mView, 1.0f);
                ViewUtils.clearNonTransitionAlpha(this.mView);
            }
        }

        public void onAnimationStart(Animator animator2) {
            if (this.mView.hasOverlappingRendering() && this.mView.getLayerType() == 0) {
                this.mLayerTypeChanged = true;
                this.mView.setLayerType(2, null);
            }
        }

        @Override
        public void onTransitionCancel(Transition transition) {
        }

        @Override
        public void onTransitionEnd(Transition transition) {
        }

        @Override
        public void onTransitionPause(Transition transition) {
            float f = this.mView.getVisibility() == 0 ? ViewUtils.getTransitionAlpha(this.mView) : 0.0f;
            this.mView.setTag(R.id.transition_pause_alpha, (Object)Float.valueOf(f));
        }

        @Override
        public void onTransitionResume(Transition transition) {
            this.mView.setTag(R.id.transition_pause_alpha, null);
        }

        @Override
        public void onTransitionStart(Transition transition) {
        }

        @Override
        public void onTransitionStart(Transition transition, boolean bl) {
        }
    }
}

