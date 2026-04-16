/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.LocationManager
 */
package androidx.core.location;

import android.location.LocationManager;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Callable;

public final class LocationManagerCompat$$ExternalSyntheticLambda0
implements Callable {
    public final LocationManager f$0;
    public final LocationManagerCompat.GpsStatusTransport f$1;

    public /* synthetic */ LocationManagerCompat$$ExternalSyntheticLambda0(LocationManager locationManager, LocationManagerCompat.GpsStatusTransport gpsStatusTransport) {
        this.f$0 = locationManager;
        this.f$1 = gpsStatusTransport;
    }

    public final Object call() {
        return LocationManagerCompat.lambda$registerGnssStatusCallback$1(this.f$0, this.f$1);
    }
}

