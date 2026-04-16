/*
 * Decompiled with CFR 0.152.
 */
package androidx.transition;

import androidx.core.os.CancellationSignal;
import androidx.transition.FragmentTransitionSupport;
import androidx.transition.Transition;

public final class FragmentTransitionSupport$$ExternalSyntheticLambda0
implements CancellationSignal.OnCancelListener {
    public final Runnable f$0;
    public final Transition f$1;
    public final Runnable f$2;

    public /* synthetic */ FragmentTransitionSupport$$ExternalSyntheticLambda0(Runnable runnable2, Transition transition, Runnable runnable3) {
        this.f$0 = runnable2;
        this.f$1 = transition;
        this.f$2 = runnable3;
    }

    @Override
    public final void onCancel() {
        FragmentTransitionSupport.lambda$setListenerForTransitionEnd$0(this.f$0, this.f$1, this.f$2);
    }
}

