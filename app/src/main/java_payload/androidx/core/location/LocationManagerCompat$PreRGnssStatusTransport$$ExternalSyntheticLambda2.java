/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final class LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda2
implements Runnable {
    public final LocationManagerCompat.PreRGnssStatusTransport f$0;
    public final Executor f$1;
    public final int f$2;

    public /* synthetic */ LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda2(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int n) {
        this.f$0 = preRGnssStatusTransport;
        this.f$1 = executor;
        this.f$2 = n;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onFirstFix$2$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport(this.f$1, this.f$2);
    }
}

