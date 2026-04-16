/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.content.res;

import androidx.core.content.res.ResourcesCompat;

public final class ResourcesCompat$FontCallback$$ExternalSyntheticLambda1
implements Runnable {
    public final ResourcesCompat.FontCallback f$0;
    public final int f$1;

    public /* synthetic */ ResourcesCompat$FontCallback$$ExternalSyntheticLambda1(ResourcesCompat.FontCallback fontCallback, int n) {
        this.f$0 = fontCallback;
        this.f$1 = n;
    }

    @Override
    public final void run() {
        this.f$0.lambda$callbackFailAsync$1$androidx-core-content-res-ResourcesCompat$FontCallback(this.f$1);
    }
}

