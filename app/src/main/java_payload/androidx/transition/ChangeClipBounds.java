/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R;
import androidx.transition.RectEvaluator;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.ViewUtils;

public class ChangeClipBounds
extends Transition {
    static final Rect NULL_SENTINEL;
    private static final String PROPNAME_BOUNDS = "android:clipBounds:bounds";
    private static final String PROPNAME_CLIP = "android:clipBounds:clip";
    private static final String[] sTransitionProperties;

    static {
        sTransitionProperties = new String[]{PROPNAME_CLIP};
        NULL_SENTINEL = new Rect();
    }

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void captureValues(TransitionValues transitionValues, boolean bl) {
        View view = transitionValues.view;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect rect = null;
        if (bl) {
            rect = (Rect)view.getTag(R.id.transition_clip);
        }
        Rect rect2 = rect;
        if (rect == null) {
            rect2 = view.getClipBounds();
        }
        rect = rect2;
        if (rect2 == NULL_SENTINEL) {
            rect = null;
        }
        transitionValues.values.put(PROPNAME_CLIP, rect);
        if (rect == null) {
            rect2 = new Rect(0, 0, view.getWidth(), view.getHeight());
            transitionValues.values.put(PROPNAME_BOUNDS, rect2);
        }
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
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues object, TransitionValues transitionValues) {
        if (object != null && transitionValues != null && ((TransitionValues)object).values.containsKey(PROPNAME_CLIP) && transitionValues.values.containsKey(PROPNAME_CLIP)) {
            Rect rect = (Rect)((TransitionValues)object).values.get(PROPNAME_CLIP);
            Rect rect2 = (Rect)transitionValues.values.get(PROPNAME_CLIP);
            if (rect == null && rect2 == null) {
                return null;
            }
            viewGroup = rect == null ? (Rect)((TransitionValues)object).values.get(PROPNAME_BOUNDS) : rect;
            if (viewGroup.equals(object = rect2 == null ? (Rect)transitionValues.values.get(PROPNAME_BOUNDS) : rect2)) {
                return null;
            }
            transitionValues.view.setClipBounds(rect);
            RectEvaluator rectEvaluator = new RectEvaluator(new Rect());
            viewGroup = ObjectAnimator.ofObject((Object)transitionValues.view, ViewUtils.CLIP_BOUNDS, (TypeEvaluator)rectEvaluator, (Object[])new Rect[]{viewGroup, object});
            object = new Listener(transitionValues.view, rect, rect2);
            viewGroup.addListener((Animator.AnimatorListener)object);
            this.addListener((Transition.TransitionListener)object);
            return viewGroup;
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
        private final Rect mEnd;
        private final Rect mStart;
        private final View mView;

        Listener(View view, Rect rect, Rect rect2) {
            this.mView = view;
            this.mStart = rect;
            this.mEnd = rect2;
        }

        public void onAnimationEnd(Animator animator2) {
            this.onAnimationEnd(animator2, false);
        }

        public void onAnimationEnd(Animator animator2, boolean bl) {
            if (!bl) {
                this.mView.setClipBounds(this.mEnd);
            } else {
                this.mView.setClipBounds(this.mStart);
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
            Rect rect = this.mView.getClipBounds();
            transition = rect;
            if (rect == null) {
                transition = NULL_SENTINEL;
            }
            this.mView.setTag(R.id.transition_clip, (Object)transition);
            this.mView.setClipBounds(this.mEnd);
        }

        @Override
        public void onTransitionResume(Transition transition) {
            transition = (Rect)this.mView.getTag(R.id.transition_clip);
            this.mView.setClipBounds((Rect)transition);
            this.mView.setTag(R.id.transition_clip, null);
        }

        @Override
        public void onTransitionStart(Transition transition) {
        }
    }
}

