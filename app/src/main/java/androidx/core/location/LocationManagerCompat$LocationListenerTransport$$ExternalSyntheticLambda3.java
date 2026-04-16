/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final class LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda3
implements Runnable {
    public final LocationManagerCompat.LocationListenerTransport f$0;
    public final String f$1;

    public /* synthetic */ LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda3(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String string2) {
        this.f$0 = locationListenerTransport;
        this.f$1 = string2;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onProviderDisabled$5$androidx-core-location-LocationManagerCompat$LocationListenerTransport(this.f$1);
    }
}

