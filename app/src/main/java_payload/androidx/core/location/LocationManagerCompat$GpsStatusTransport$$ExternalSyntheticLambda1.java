/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final class LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda1
implements Runnable {
    public final LocationManagerCompat.GpsStatusTransport f$0;
    public final Executor f$1;

    public /* synthetic */ LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda1(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.f$0 = gpsStatusTransport;
        this.f$1 = executor;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onGpsStatusChanged$1$androidx-core-location-LocationManagerCompat$GpsStatusTransport(this.f$1);
    }
}

