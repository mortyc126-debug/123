/*
 * Decompiled with CFR 0.152.
 */
package androidx.transition;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.transition.Transition;

public final class Transition$SeekController$$ExternalSyntheticLambda0
implements DynamicAnimation.OnAnimationEndListener {
    public final Transition.SeekController f$0;

    public /* synthetic */ Transition$SeekController$$ExternalSyntheticLambda0(Transition.SeekController seekController) {
        this.f$0 = seekController;
    }

    @Override
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean bl, float f, float f2) {
        this.f$0.lambda$ensureAnimation$0$androidx-transition-Transition$SeekController(dynamicAnimation, bl, f, f2);
    }
}

