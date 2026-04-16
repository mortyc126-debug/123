/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.GnssMeasurementsEvent
 */
package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final class LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda0
implements Runnable {
    public final LocationManagerCompat.GnssMeasurementsTransport f$0;
    public final Executor f$1;
    public final GnssMeasurementsEvent f$2;

    public /* synthetic */ LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda0(LocationManagerCompat.GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
        this.f$0 = gnssMeasurementsTransport;
        this.f$1 = executor;
        this.f$2 = gnssMeasurementsEvent;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onGnssMeasurementsReceived$0$androidx-core-location-LocationManagerCompat$GnssMeasurementsTransport(this.f$1, this.f$2);
    }
}

