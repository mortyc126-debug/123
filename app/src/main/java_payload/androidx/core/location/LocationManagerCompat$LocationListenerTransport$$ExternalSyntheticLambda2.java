/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.List;

public final class LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda2
implements Runnable {
    public final LocationManagerCompat.LocationListenerTransport f$0;
    public final List f$1;

    public /* synthetic */ LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda2(LocationManagerCompat.LocationListenerTransport locationListenerTransport, List list) {
        this.f$0 = locationListenerTransport;
        this.f$1 = list;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onLocationChanged$1$androidx-core-location-LocationManagerCompat$LocationListenerTransport(this.f$1);
    }
}

