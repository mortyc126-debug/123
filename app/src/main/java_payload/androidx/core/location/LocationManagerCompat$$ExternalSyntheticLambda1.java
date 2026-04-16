/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;
import androidx.core.util.Consumer;

public final class LocationManagerCompat$$ExternalSyntheticLambda1
implements Runnable {
    public final Consumer f$0;
    public final Location f$1;

    public /* synthetic */ LocationManagerCompat$$ExternalSyntheticLambda1(Consumer consumer, Location location) {
        this.f$0 = consumer;
        this.f$1 = location;
    }

    @Override
    public final void run() {
        LocationManagerCompat.lambda$getCurrentLocation$0(this.f$0, this.f$1);
    }
}

