/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final class LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda1
implements Runnable {
    public final LocationManagerCompat.LocationListenerTransport f$0;
    public final int f$1;

    public /* synthetic */ LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda1(LocationManagerCompat.LocationListenerTransport locationListenerTransport, int n) {
        this.f$0 = locationListenerTransport;
        this.f$1 = n;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onFlushComplete$2$androidx-core-location-LocationManagerCompat$LocationListenerTransport(this.f$1);
    }
}

