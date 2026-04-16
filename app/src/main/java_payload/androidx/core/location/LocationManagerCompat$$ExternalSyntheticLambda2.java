/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.CancellationSignal$OnCancelListener
 */
package androidx.core.location;

import android.os.CancellationSignal;
import androidx.core.location.LocationManagerCompat;

public final class LocationManagerCompat$$ExternalSyntheticLambda2
implements CancellationSignal.OnCancelListener {
    public final LocationManagerCompat.CancellableLocationListener f$0;

    public /* synthetic */ LocationManagerCompat$$ExternalSyntheticLambda2(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.f$0 = cancellableLocationListener;
    }

    public final void onCancel() {
        this.f$0.cancel();
    }
}

