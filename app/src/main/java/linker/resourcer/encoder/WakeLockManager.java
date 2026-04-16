/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.wifi.WifiManager
 *  android.net.wifi.WifiManager$WifiLock
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.PowerManager;

public class WakeLockManager {
    private PowerManager.WakeLock wakeLock;
    private WifiManager.WifiLock wifiLock;

    public void acquire(Context context, boolean bl, boolean bl2) {
        block9: {
            block7: {
                int n;
                PowerManager powerManager;
                block8: {
                    if (this.wakeLock != null && this.wakeLock.isHeld() || (powerManager = (PowerManager)context.getSystemService("power")) == null) break block7;
                    n = 0x20000001;
                    if (!bl) break block8;
                    n = 805306394;
                }
                try {
                    this.wakeLock = powerManager.newWakeLock(n, "App:IncomingCall");
                    this.wakeLock.acquire();
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            if (bl2) {
                if (this.wifiLock != null && this.wifiLock.isHeld() || (context = (WifiManager)context.getApplicationContext().getSystemService("wifi")) == null) break block9;
                try {
                    this.wifiLock = context.createWifiLock(3, "p:WifiLock");
                    this.wifiLock.acquire();
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
    }

    public void release() {
        try {
            if (this.wakeLock != null && this.wakeLock.isHeld()) {
                this.wakeLock.release();
                this.wakeLock = null;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            if (this.wifiLock != null && this.wifiLock.isHeld()) {
                this.wifiLock.release();
                this.wifiLock = null;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

