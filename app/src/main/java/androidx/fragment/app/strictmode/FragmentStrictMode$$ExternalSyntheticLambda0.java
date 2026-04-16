/*
 * Decompiled with CFR 0.152.
 */
package androidx.fragment.app.strictmode;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

public final class FragmentStrictMode$$ExternalSyntheticLambda0
implements Runnable {
    public final FragmentStrictMode.Policy f$0;
    public final Violation f$1;

    public /* synthetic */ FragmentStrictMode$$ExternalSyntheticLambda0(FragmentStrictMode.Policy policy, Violation violation) {
        this.f$0 = policy;
        this.f$1 = violation;
    }

    @Override
    public final void run() {
        FragmentStrictMode.$r8$lambda$3GEKar9k4mm28McDHO-XTHzF5lU(this.f$0, this.f$1);
    }
}

