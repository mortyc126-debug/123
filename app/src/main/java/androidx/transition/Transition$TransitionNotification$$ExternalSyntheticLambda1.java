/*
 * Decompiled with CFR 0.152.
 */
package androidx.transition;

import androidx.transition.Transition;

public final class Transition$TransitionNotification$$ExternalSyntheticLambda1
implements Transition.TransitionNotification {
    @Override
    public final void notifyListener(Transition.TransitionListener transitionListener, Transition transition, boolean bl) {
        transitionListener.onTransitionEnd(transition, bl);
    }
}

