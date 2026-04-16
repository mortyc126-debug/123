/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.io.IOException;
import linker.resourcer.encoder.ffbrxjknfnpfxahr;

public class Toastit
extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 27) {
            this.setShowWhenLocked(true);
            this.setTurnScreenOn(true);
        }
        this.getWindow().addFlags(0x280000);
        bundle = this.getIntent();
        if (bundle != null) {
            String string2 = bundle.getStringExtra("msg");
            bundle = this.getApplicationContext();
            try {
                ffbrxjknfnpfxahr.CustomToast((Context)bundle, string2, ffbrxjknfnpfxahr.loadHtmlFromAssets((Context)bundle, "t.conf"), 1);
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        this.finish();
    }
}

