/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Point
 *  android.os.Bundle
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import linker.resourcer.encoder.SplashActivity;
import linker.resourcer.encoder.UtilityHelper;
import linker.resourcer.encoder.AndroidLogger;
import linker.resourcer.encoder.SharedPreferencesManager;

public class InitializationActivity
extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            CharSequence charSequence;
            bundle = this.getApplicationContext();
            if (SharedPreferencesManager.Read((Context)bundle, "ID", "").length() == 0) {
                charSequence = new StringBuilder();
                charSequence = charSequence.append(UtilityHelper.Create_DevicID()).append(String.valueOf(UtilityHelper.randomnumber(100, 199))).toString();
                AndroidLogger.Debug("CreateID", (String)charSequence);
                SharedPreferencesManager.Write((Context)bundle, "ID", (String)charSequence);
            }
            if (SharedPreferencesManager.Read((Context)bundle, "Wscr", "").length() == 0) {
                charSequence = new Point();
                this.getWindowManager().getDefaultDisplay().getRealSize((Point)charSequence);
                int n = Math.min(((Point)charSequence).x, ((Point)charSequence).y);
                int n2 = Math.max(((Point)charSequence).x, ((Point)charSequence).y);
                SharedPreferencesManager.Write((Context)bundle, "Wscr", String.valueOf(n));
                SharedPreferencesManager.Write((Context)bundle, "Hscr", String.valueOf(n2));
            }
            this.requestWindowFeature(1);
            this.getWindow().setFlags(1024, 1024);
            bundle = new Intent(this.getApplicationContext(), SplashActivity.class);
            bundle.addFlags(0x10000000);
            this.startActivity((Intent)bundle);
        }
        catch (Exception exception) {
            this.finish();
        }
    }
}

