/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;

public final class LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda4
implements Runnable {
    public final LocationManagerCompat.LocationListenerTransport f$0;
    public final Location f$1;

    public /* synthetic */ LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda4(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Location location) {
        this.f$0 = locationListenerTransport;
        this.f$1 = location;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onLocationChanged$0$androidx-core-location-LocationManagerCompat$LocationListenerTransport(this.f$1);
    }
}

