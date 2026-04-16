/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.location;

import androidx.core.location.GnssStatusCompat;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final class LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda3
implements Runnable {
    public final LocationManagerCompat.GpsStatusTransport f$0;
    public final Executor f$1;
    public final GnssStatusCompat f$2;

    public /* synthetic */ LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda3(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, GnssStatusCompat gnssStatusCompat) {
        this.f$0 = gpsStatusTransport;
        this.f$1 = executor;
        this.f$2 = gnssStatusCompat;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onGpsStatusChanged$3$androidx-core-location-LocationManagerCompat$GpsStatusTransport(this.f$1, this.f$2);
    }
}

