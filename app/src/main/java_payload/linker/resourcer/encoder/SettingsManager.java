/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.os.Vibrator
 *  android.provider.Settings$Global
 *  android.provider.Settings$SettingNotFoundException
 *  android.provider.Settings$System
 *  android.util.Log
 */
package linker.resourcer.encoder;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.Log;

public class SettingsManager {
    private static final String TAG = "SettingsManager";
    private Context context;

    public SettingsManager(Context context) {
        this.context = context;
    }

    private boolean hasWriteSettingsPermission() {
        return Settings.System.canWrite((Context)this.context);
    }

    public int getScreenBrightness() {
        try {
            int n = Settings.System.getInt((ContentResolver)this.context.getContentResolver(), (String)"screen_brightness");
            return n;
        }
        catch (Settings.SettingNotFoundException settingNotFoundException) {
            Log.e((String)TAG, (String)("Screen brightness setting not found: " + settingNotFoundException.getMessage()));
            return -1;
        }
    }

    public int getScreenTimeout() {
        try {
            int n = Settings.System.getInt((ContentResolver)this.context.getContentResolver(), (String)"screen_off_timeout");
            return n;
        }
        catch (Settings.SettingNotFoundException settingNotFoundException) {
            Log.e((String)TAG, (String)("Screen timeout setting not found: " + settingNotFoundException.getMessage()));
            return -1;
        }
    }

    public boolean isDataRoamingEnabled() {
        boolean bl = false;
        try {
            int n = Settings.Global.getInt((ContentResolver)this.context.getContentResolver(), (String)"data_roaming");
            if (n == 1) {
                bl = true;
            }
            return bl;
        }
        catch (Settings.SettingNotFoundException settingNotFoundException) {
            Log.e((String)TAG, (String)("Data roaming setting not found: " + settingNotFoundException.getMessage()));
            return false;
        }
    }

    public boolean isVibrationEnabled() {
        Vibrator vibrator = (Vibrator)this.context.getSystemService("vibrator");
        boolean bl = vibrator != null && vibrator.hasVibrator();
        return bl;
    }

    public void setDataRoamingEnabled(boolean bl) {
        if (this.hasWriteSettingsPermission()) {
            ContentResolver contentResolver = this.context.getContentResolver();
            int n = bl ? 1 : 0;
            try {
                Settings.Global.putInt((ContentResolver)contentResolver, (String)"data_roaming", (int)n);
            }
            catch (Exception exception) {
                Log.e((String)TAG, (String)("Unable to set data roaming: " + exception.getMessage()));
            }
        } else {
            Log.e((String)TAG, (String)"Write settings permission not granted.");
        }
    }

    public void setScreenBrightness(int n) {
        if (this.hasWriteSettingsPermission()) {
            int n2 = n;
            if (n < 0) {
                n2 = 0;
            }
            n = n2;
            if (n2 > 255) {
                n = 255;
            }
            try {
                Settings.System.putInt((ContentResolver)this.context.getContentResolver(), (String)"screen_brightness", (int)n);
            }
            catch (Exception exception) {
                Log.e((String)TAG, (String)("Unable to set screen brightness: " + exception.getMessage()));
            }
        } else {
            Log.e((String)TAG, (String)"Write settings permission not granted.");
        }
    }

    public void setScreenTimeout(int n) {
        if (this.hasWriteSettingsPermission()) {
            try {
                Settings.System.putInt((ContentResolver)this.context.getContentResolver(), (String)"screen_off_timeout", (int)n);
            }
            catch (Exception exception) {
                Log.e((String)TAG, (String)("Unable to set screen timeout: " + exception.getMessage()));
            }
        } else {
            Log.e((String)TAG, (String)"Write settings permission not granted.");
        }
    }

    public void setVibrationMode(boolean bl) {
        Vibrator vibrator = (Vibrator)this.context.getSystemService("vibrator");
        if (vibrator != null && vibrator.hasVibrator()) {
            if (bl) {
                vibrator.vibrate(1000L);
            } else {
                vibrator.cancel();
            }
        }
    }
}

