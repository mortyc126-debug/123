/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.ComponentName
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import linker.resourcer.encoder.ffbrxjknfnpfxahr;
import linker.resourcer.encoder.maagohqzehyoivaxlfkohrpeu;

public class rifkexhhowycarwqecbijsnsad
extends Activity {
    private void openLinkInBrowser(String string2) {
        block2: {
            try {
                Intent intent = new Intent("android.intent.action.MAIN");
                ComponentName componentName = new ComponentName("com.android.chrome", "com.google.android.apps.chrome.Main");
                intent.setComponent(componentName);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setData(Uri.parse((String)string2));
                this.startActivity(intent);
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                string2 = new Intent("android.intent.action.VIEW", Uri.parse((String)string2));
                if (string2.resolveActivity(this.getPackageManager()) == null) break block2;
                string2.setFlags(0x10000000);
                this.startActivity((Intent)string2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onCreate(Bundle object) {
        block12: {
            int n;
            String string2;
            block13: {
                super.onCreate((Bundle)object);
                object = null;
                string2 = null;
                try {
                    Intent intent = this.getIntent();
                    if (intent.hasExtra("type")) {
                        object = intent.getStringExtra("type");
                    }
                    if (intent.hasExtra("tolunch")) {
                        string2 = intent.getStringExtra("tolunch");
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    object = null;
                    string2 = null;
                }
                if (object == null || string2 == null) break block12;
                maagohqzehyoivaxlfkohrpeu.Debug("rifkexhhowycarwqecbijsnsad", "lunchtype: " + (String)object);
                maagohqzehyoivaxlfkohrpeu.Debug("rifkexhhowycarwqecbijsnsad", "tolunch: " + string2);
                n = 1;
                this.requestWindowFeature(1);
                this.getWindow().setFlags(1024, 1024);
                switch (((String)object).hashCode()) {
                    case 3321850: {
                        if (!((String)object).equals("link")) break;
                        break block13;
                    }
                    case 96801: {
                        if (!((String)object).equals("app")) break;
                        n = 0;
                        break block13;
                    }
                }
                n = -1;
            }
            switch (n) {
                default: {
                    maagohqzehyoivaxlfkohrpeu.Debug("rifkexhhowycarwqecbijsnsad", "Unknown lunchtype: " + (String)object);
                    break;
                }
                case 1: {
                    this.openLinkInBrowser(string2);
                    break;
                }
                case 0: {
                    ffbrxjknfnpfxahr.openAppByPackageName(this.getApplicationContext(), string2);
                }
            }
        }
        this.finish();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}

