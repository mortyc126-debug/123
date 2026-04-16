/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.location.LocationListener
 *  android.os.Bundle
 */
package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.List;

public interface LocationListenerCompat
extends LocationListener {
    default public void onFlushComplete(int n) {
    }

    default public void onLocationChanged(List<Location> list) {
        int n = list.size();
        for (int i = 0; i < n; ++i) {
            this.onLocationChanged(list.get(i));
        }
    }

    default public void onProviderDisabled(String string2) {
    }

    default public void onProviderEnabled(String string2) {
    }

    default public void onStatusChanged(String string2, int n, Bundle bundle) {
    }
}

