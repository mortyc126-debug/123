/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.DecelerateInterpolator
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.transition.CircularPropagation;
import androidx.transition.R;
import androidx.transition.TransitionValues;
import androidx.transition.TranslationAnimationCreator;
import androidx.transition.Visibility;

public class Explode
extends Visibility {
    private static final String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
    private static final TimeInterpolator sAccelerate;
    private static final TimeInterpolator sDecelerate;
    private int[] mTempLoc = new int[2];

    static {
        sDecelerate = new DecelerateInterpolator();
        sAccelerate = new AccelerateInterpolator();
    }

    public Explode() {
        this.setPropagation(new CircularPropagation());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setPropagation(new CircularPropagation());
    }

    private static float calculateDistance(float f, float f2) {
        return (float)Math.sqrt(f * f + f2 * f2);
    }

    private static float calculateMaxDistance(View view, int n, int n2) {
        n = Math.max(n, view.getWidth() - n);
        n2 = Math.max(n2, view.getHeight() - n2);
        return Explode.calculateDistance(n, n2);
    }

    private void calculateOut(View view, Rect rect, int[] nArray) {
        int n;
        int n2;
        view.getLocationOnScreen(this.mTempLoc);
        int n3 = this.mTempLoc[0];
        int n4 = this.mTempLoc[1];
        Rect rect2 = this.getEpicenter();
        if (rect2 == null) {
            n2 = view.getWidth() / 2 + n3 + Math.round(view.getTranslationX());
            n = view.getHeight() / 2 + n4 + Math.round(view.getTranslationY());
        } else {
            n2 = rect2.centerX();
            n = rect2.centerY();
        }
        int n5 = rect.centerX();
        int n6 = rect.centerY();
        float f = n5 - n2;
        float f2 = n6 - n;
        if (f == 0.0f && f2 == 0.0f) {
            f = (float)(Math.random() * 2.0) - 1.0f;
            f2 = (float)(Math.random() * 2.0) - 1.0f;
        }
        float f3 = Explode.calculateDistance(f, f2);
        f /= f3;
        f2 /= f3;
        f3 = Explode.calculateMaxDistance(view, n2 - n3, n - n4);
        nArray[0] = Math.round(f3 * f);
        nArray[1] = Math.round(f3 * f2);
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        view.getLocationOnScreen(this.mTempLoc);
        int n = this.mTempLoc[0];
        int n2 = this.mTempLoc[1];
        int n3 = view.getWidth();
        int n4 = view.getHeight();
        transitionValues.values.put(PROPNAME_SCREEN_BOUNDS, new Rect(n, n2, n3 + n, n4 + n2));
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        this.captureValues(transitionValues);
    }

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        this.captureValues(transitionValues);
    }

    @Override
    public boolean isSeekingSupported() {
        return true;
    }

    @Override
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        transitionValues = (Rect)transitionValues2.values.get(PROPNAME_SCREEN_BOUNDS);
        float f = view.getTranslationX();
        float f2 = view.getTranslationY();
        this.calculateOut((View)viewGroup, (Rect)transitionValues, this.mTempLoc);
        float f3 = this.mTempLoc[0];
        float f4 = this.mTempLoc[1];
        return TranslationAnimationCreator.createAnimation(view, transitionValues2, ((Rect)transitionValues).left, ((Rect)transitionValues).top, f + f3, f2 + f4, f, f2, sDecelerate, this);
    }

    @Override
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        transitionValues2 = (Rect)transitionValues.values.get(PROPNAME_SCREEN_BOUNDS);
        int n = ((Rect)transitionValues2).left;
        int n2 = ((Rect)transitionValues2).top;
        float f = view.getTranslationX();
        float f2 = view.getTranslationY();
        float f3 = f;
        float f4 = f2;
        int[] nArray = (int[])transitionValues.view.getTag(R.id.transition_position);
        float f5 = f3;
        float f6 = f4;
        if (nArray != null) {
            f5 = f3 + (float)(nArray[0] - ((Rect)transitionValues2).left);
            f6 = f4 + (float)(nArray[1] - ((Rect)transitionValues2).top);
            transitionValues2.offsetTo(nArray[0], nArray[1]);
        }
        this.calculateOut((View)viewGroup, (Rect)transitionValues2, this.mTempLoc);
        return TranslationAnimationCreator.createAnimation(view, transitionValues, n, n2, f, f2, f5 + (float)this.mTempLoc[0], f6 + (float)this.mTempLoc[1], sAccelerate, this);
    }
}

