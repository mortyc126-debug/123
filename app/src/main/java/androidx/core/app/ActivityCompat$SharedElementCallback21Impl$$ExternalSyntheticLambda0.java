/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.SharedElementCallback$OnSharedElementsReadyListener
 */
package androidx.core.app;

import android.app.SharedElementCallback;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;

public final class ActivityCompat$SharedElementCallback21Impl$$ExternalSyntheticLambda0
implements SharedElementCallback.OnSharedElementsReadyListener {
    public final SharedElementCallback.OnSharedElementsReadyListener f$0;

    public /* synthetic */ ActivityCompat$SharedElementCallback21Impl$$ExternalSyntheticLambda0(SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.f$0 = onSharedElementsReadyListener;
    }

    @Override
    public final void onSharedElementsReady() {
        ActivityCompat.SharedElementCallback21Impl.lambda$onSharedElementsArrived$0(this.f$0);
    }
}

