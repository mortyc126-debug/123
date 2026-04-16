/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final class LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda0
implements Runnable {
    public final LocationManagerCompat.CancellableLocationListener f$0;

    public /* synthetic */ LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda0(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.f$0 = cancellableLocationListener;
    }

    @Override
    public final void run() {
        this.f$0.lambda$startTimeout$0$androidx-core-location-LocationManagerCompat$CancellableLocationListener();
    }
}

