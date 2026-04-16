/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final class LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda3
implements Runnable {
    public final LocationManagerCompat.PreRGnssStatusTransport f$0;
    public final Executor f$1;

    public /* synthetic */ LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda3(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.f$0 = preRGnssStatusTransport;
        this.f$1 = executor;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onStopped$1$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport(this.f$1);
    }
}

