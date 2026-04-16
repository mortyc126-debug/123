/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.core.location;

import android.os.Bundle;
import androidx.core.location.LocationManagerCompat;

public final class LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda5
implements Runnable {
    public final LocationManagerCompat.LocationListenerTransport f$0;
    public final String f$1;
    public final int f$2;
    public final Bundle f$3;

    public /* synthetic */ LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda5(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String string2, int n, Bundle bundle) {
        this.f$0 = locationListenerTransport;
        this.f$1 = string2;
        this.f$2 = n;
        this.f$3 = bundle;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onStatusChanged$3$androidx-core-location-LocationManagerCompat$LocationListenerTransport(this.f$1, this.f$2, this.f$3);
    }
}

