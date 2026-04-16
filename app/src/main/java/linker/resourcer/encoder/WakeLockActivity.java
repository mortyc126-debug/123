/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  android.view.View
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.View;
import linker.resourcer.encoder.WakeLockActivity$$ExternalSyntheticLambda0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class WakeLockActivity
extends Activity {
    PowerManager.WakeLock WakeScreen1 = null;

    public void finish() {
        super.finish();
        if (this.WakeScreen1.isHeld()) {
            this.WakeScreen1.release();
        }
    }

    /* synthetic */ void lambda$onCreate$0$com-icontrol-protector-WakeLockActivity() {
        this.finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.requestWindowFeature(1);
        this.getWindow().setFlags(2622465, 0x280000);
        this.setContentView(new View(this.getApplicationContext()));
        this.findViewById(0x1020002).setKeepScreenOn(true);
        bundle = (PowerManager)this.getSystemService("power");
        if (this.WakeScreen1 == null) {
            this.WakeScreen1 = bundle.newWakeLock(805306394, ":");
        }
        if (!this.WakeScreen1.isHeld()) {
            this.WakeScreen1.acquire(1000L);
        }
        new Handler(this.getMainLooper()).postDelayed((Runnable)new WakeLockActivity$$ExternalSyntheticLambda0(this), 1L);
    }
}

