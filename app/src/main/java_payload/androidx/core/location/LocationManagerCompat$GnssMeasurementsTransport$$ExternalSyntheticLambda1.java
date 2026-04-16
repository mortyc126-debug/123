/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final class LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda1
implements Runnable {
    public final LocationManagerCompat.GnssMeasurementsTransport f$0;
    public final Executor f$1;
    public final int f$2;

    public /* synthetic */ LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda1(LocationManagerCompat.GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, int n) {
        this.f$0 = gnssMeasurementsTransport;
        this.f$1 = executor;
        this.f$2 = n;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onStatusChanged$1$androidx-core-location-LocationManagerCompat$GnssMeasurementsTransport(this.f$1, this.f$2);
    }
}

