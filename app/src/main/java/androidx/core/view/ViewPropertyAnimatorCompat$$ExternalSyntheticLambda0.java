/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 */
package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;

public final class ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0
implements ValueAnimator.AnimatorUpdateListener {
    public final ViewPropertyAnimatorUpdateListener f$0;
    public final View f$1;

    public /* synthetic */ ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
        this.f$0 = viewPropertyAnimatorUpdateListener;
        this.f$1 = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ViewPropertyAnimatorCompat.lambda$setUpdateListener$0(this.f$0, this.f$1, valueAnimator);
    }
}

