/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.location.LocationManager
 *  android.util.Log
 */
package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.appcompat.app.TwilightCalculator;
import androidx.core.content.PermissionChecker;
import java.util.Calendar;

class TwilightManager {
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private static TwilightManager sInstance;
    private final Context mContext;
    private final LocationManager mLocationManager;
    private final TwilightState mTwilightState = new TwilightState();

    TwilightManager(Context context, LocationManager locationManager) {
        this.mContext = context;
        this.mLocationManager = locationManager;
    }

    static TwilightManager getInstance(Context context) {
        if (sInstance == null) {
            context = context.getApplicationContext();
            sInstance = new TwilightManager(context, (LocationManager)context.getSystemService("location"));
        }
        return sInstance;
    }

    private Location getLastKnownLocation() {
        Location location;
        block4: {
            location = null;
            Location location2 = null;
            if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                location = this.getLastKnownLocationForProvider("network");
            }
            if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                location2 = this.getLastKnownLocationForProvider("gps");
            }
            if (location2 != null && location != null) {
                if (location2.getTime() > location.getTime()) {
                    location = location2;
                }
                return location;
            }
            if (location2 == null) break block4;
            location = location2;
        }
        return location;
    }

    private Location getLastKnownLocationForProvider(String string2) {
        try {
            if (this.mLocationManager.isProviderEnabled(string2)) {
                string2 = this.mLocationManager.getLastKnownLocation(string2);
                return string2;
            }
        }
        catch (Exception exception) {
            Log.d((String)TAG, (String)"Failed to get last known location", (Throwable)exception);
        }
        return null;
    }

    private boolean isStateValid() {
        boolean bl = this.mTwilightState.nextUpdate > System.currentTimeMillis();
        return bl;
    }

    static void setInstance(TwilightManager twilightManager) {
        sInstance = twilightManager;
    }

    private void updateState(Location location) {
        TwilightState twilightState = this.mTwilightState;
        long l = System.currentTimeMillis();
        TwilightCalculator twilightCalculator = TwilightCalculator.getInstance();
        twilightCalculator.calculateTwilight(l - 86400000L, location.getLatitude(), location.getLongitude());
        twilightCalculator.calculateTwilight(l, location.getLatitude(), location.getLongitude());
        int n = twilightCalculator.state;
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        long l2 = twilightCalculator.sunrise;
        long l3 = twilightCalculator.sunset;
        twilightCalculator.calculateTwilight(l + 86400000L, location.getLatitude(), location.getLongitude());
        long l4 = twilightCalculator.sunrise;
        if (l2 != -1L && l3 != -1L) {
            l4 = l > l3 ? 0L + l4 : (l > l2 ? 0L + l3 : 0L + l2);
            l4 += 60000L;
        } else {
            l4 = l + 43200000L;
        }
        twilightState.isNight = bl;
        twilightState.nextUpdate = l4;
    }

    boolean isNight() {
        TwilightState twilightState = this.mTwilightState;
        if (this.isStateValid()) {
            return twilightState.isNight;
        }
        Location location = this.getLastKnownLocation();
        if (location != null) {
            this.updateState(location);
            return twilightState.isNight;
        }
        Log.i((String)TAG, (String)"Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int n = Calendar.getInstance().get(11);
        boolean bl = n < 6 || n >= 22;
        return bl;
    }

    private static class TwilightState {
        boolean isNight;
        long nextUpdate;

        TwilightState() {
        }
    }
}

