/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 */
package linker.resourcer.encoder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import linker.resourcer.encoder.Vsvtpr;
import linker.resourcer.encoder.lqvpqwmhpvnnlhskxyjdwphzvsl;

public class zefvedodypkszjwfzyw {
    private BroadcastReceiver Vsvtpr;
    private Context context;
    private BroadcastReceiver screenReceiver;

    public zefvedodypkszjwfzyw(Context context) {
        this.context = context;
        this.registerojxvtmgupkcwiluv();
    }

    private void registerojxvtmgupkcwiluv() {
        BroadcastReceiver broadcastReceiver2;
        try {
            this.screenReceiver = broadcastReceiver2 = new lqvpqwmhpvnnlhskxyjdwphzvsl.ojxvtmgupkcwiluv();
            broadcastReceiver2 = new IntentFilter();
            broadcastReceiver2.addAction("android.intent.action.SCREEN_ON");
            broadcastReceiver2.addAction("android.intent.action.SCREEN_OFF");
            broadcastReceiver2.addAction("android.intent.action.PHONE_STATE");
            broadcastReceiver2.addAction("android.intent.action.USER_PRESENT");
            this.context.registerReceiver(this.screenReceiver, (IntentFilter)broadcastReceiver2);
        }
        catch (Exception exception) {
            this.screenReceiver = null;
        }
        try {
            this.Vsvtpr = broadcastReceiver2 = new Vsvtpr();
            broadcastReceiver2 = new IntentFilter();
            broadcastReceiver2.addAction("android.intent.action.AIRPLANE_MODE");
            broadcastReceiver2.addAction("android.intent.action.BATTERY_LOW");
            broadcastReceiver2.addAction("android.intent.action.BATTERY_OKAY");
            broadcastReceiver2.addAction("android.intent.action.LOCALE_CHANGED");
            broadcastReceiver2.addAction("android.intent.action.TIMEZONE_CHANGED");
            broadcastReceiver2.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            broadcastReceiver2.addAction("android.intent.action.DEVICE_STORAGE_OK");
            this.context.registerReceiver(this.Vsvtpr, (IntentFilter)broadcastReceiver2);
        }
        catch (Exception exception) {
            this.Vsvtpr = null;
        }
    }

    public void unregister() {
        if (this.screenReceiver != null) {
            this.context.unregisterReceiver(this.screenReceiver);
            this.screenReceiver = null;
        }
        if (this.Vsvtpr != null) {
            this.context.unregisterReceiver(this.Vsvtpr);
            this.Vsvtpr = null;
        }
    }
}

