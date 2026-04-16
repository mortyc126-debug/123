/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build
 *  android.util.Log
 */
package linker.resourcer.encoder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import linker.resourcer.encoder.BatteryOptimizationSetupActivity;

public class MIUIAutoStart {
    private static final String BRAND_ASUS = "asus";
    private static final String BRAND_HONOR = "honor";
    private static final String BRAND_HUAWEI = "huawei";
    private static final String BRAND_LETV = "letv";
    private static final String BRAND_MEIZU = "meizu";
    private static final String BRAND_NOKIA = "nokia";
    private static final String BRAND_ONE_PLUS = "oneplus";
    private static final String BRAND_OPPO = "oppo";
    private static final String BRAND_SAMSUNG = "samsung";
    private static final String BRAND_ULONG = "ulong";
    private static final String BRAND_VIVO = "vivo";
    private static final String BRAND_XIAOMI = "xiaomi";
    private static final String BRAND_XIAOMI_POCO = "poco";
    private static final String BRAND_XIAOMI_REDMI = "redmi";
    private static final List<String> PACKAGES_TO_CHECK_FOR_PERMISSION;
    private static final String PACKAGE_ASUS_COMPONENT = "com.asus.mobilemanager.powersaver.PowerSaverSettings";
    private static final String PACKAGE_ASUS_COMPONENT_FALLBACK = "com.asus.mobilemanager.autostart.AutoStartActivity";
    private static final String PACKAGE_ASUS_MAIN = "com.asus.mobilemanager";
    private static final String PACKAGE_HONOR_COMPONENT = "com.huawei.systemmanager.optimize.process.ProtectActivity";
    private static final String PACKAGE_HONOR_MAIN = "com.huawei.systemmanager";
    private static final String PACKAGE_HUAWEI_COMPONENT = "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity";
    private static final String PACKAGE_HUAWEI_COMPONENT_FALLBACK = "com.huawei.systemmanager.optimize.process.ProtectActivity";
    private static final String PACKAGE_HUAWEI_COMPONENT_FALLBACK_A = "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity";
    private static final String PACKAGE_HUAWEI_COMPONENT_FALLBACK_B = "com.huawei.systemmanager.optimize.bootstart.BootStartActivity";
    private static final String PACKAGE_HUAWEI_COMPONENT_FALLBACK_C = "com.huawei.systemmanager.startupmgr.ui.StartupAwakedAppListActivity";
    private static final String PACKAGE_HUAWEI_COMPONENT_FALLBACK_D = "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity";
    private static final String PACKAGE_HUAWEI_MAIN = "com.huawei.systemmanager";
    private static final String PACKAGE_LETV_COMPONENT = "com.letv.android.letvsafe.AutobootManageActivity";
    private static final String PACKAGE_LETV_COMPONENT_A = "com.letv.android.permissionautoboot";
    private static final String PACKAGE_LETV_MAIN = "com.letv.android.letvsafe";
    private static final String PACKAGE_MEIZU_COMPONENT = "com.meizu.safe.permission.SmartBGActivity";
    private static final String PACKAGE_MEIZU_MAIN = "com.meizu.safe";
    private static final String PACKAGE_NOKIA_COMPONENT = "com.evenwell.powersaving.g3.exception.PowerSaverExceptionActivity";
    private static final String PACKAGE_NOKIA_MAIN = "com.evenwell.powersaving.g3";
    private static final String PACKAGE_ONE_PLUS_ACTION = "com.android.settings.action.BACKGROUND_OPTIMIZE";
    private static final String PACKAGE_ONE_PLUS_COMPONENT = "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity";
    private static final String PACKAGE_ONE_PLUS_COMPONENT_FALLBACK = "com.oplus.securitypermission.startup.StartupAppListActivity";
    private static final String PACKAGE_ONE_PLUS_COMPONENT_FALLBACK_A = "com.oneplus.security.startupapp.StartupAppListActivity";
    private static final String PACKAGE_ONE_PLUS_COMPONENT_FALLBACK_A_B = "com.oplus.powermanager.fuelgaue.PowerControlActivity";
    private static final String PACKAGE_ONE_PLUS_FALLBACK = "com.oplus.securitypermission";
    private static final String PACKAGE_ONE_PLUS_MAIN = "com.oneplus.security";
    private static final String PACKAGE_ONE_PLUS_MAIN_A = "com.oplus.battery";
    private static final String PACKAGE_OPPO_COMPONENT = "com.coloros.safecenter.permission.startup.StartupAppListActivity";
    private static final String PACKAGE_OPPO_COMPONENT_FALLBACK = "com.oppo.safe.permission.startup.StartupAppListActivity";
    private static final String PACKAGE_OPPO_COMPONENT_FALLBACK_A = "com.coloros.safecenter.startupapp.StartupAppListActivity";
    private static final String PACKAGE_OPPO_COMPONENT_FALLBACK_A_A = "com.coloros.powermanager.fuelgaue.PowerUsageModelActivity";
    private static final String PACKAGE_OPPO_FALLBACK = "com.oppo.safe";
    private static final String PACKAGE_OPPO_MAIN = "com.coloros.safecenter";
    private static final String PACKAGE_SAMSUNG_COMPONENT = "com.samsung.android.sm.ui.battery.BatteryActivity";
    private static final String PACKAGE_SAMSUNG_COMPONENT_2 = "com.samsung.android.sm.battery.ui.usage.CheckableAppListActivity";
    private static final String PACKAGE_SAMSUNG_COMPONENT_3 = "com.samsung.android.sm.battery.ui.BatteryActivity";
    private static final String PACKAGE_SAMSUNG_MAIN = "com.samsung.android.lool";
    private static final String PACKAGE_ULONG_COMPONENT = "com.yulong.android.coolsafe.ui.activity.autorun.AutoRunListActivity";
    private static final String PACKAGE_ULONG_MAIN = "com.yulong.android.coolsafe";
    private static final String PACKAGE_VIVO_COMPONENT = "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity";
    private static final String PACKAGE_VIVO_COMPONENT_FALLBACK = "com.vivo.permissionmanager.activity.BgStartUpManagerActivity";
    private static final String PACKAGE_VIVO_COMPONENT_FALLBACK_A = "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager";
    private static final String PACKAGE_VIVO_COMPONENT_FALLBACK_A_A = "com.vivo.applicationbehaviorengine.ui.ExcessivePowerManager";
    private static final String PACKAGE_VIVO_COMPONENT_FALLBACK_A_A_A = "com.vivo.permissionmanager.activity.PurviewTabActivity";
    private static final String PACKAGE_VIVO_COMPONENT_FALLBACK_A_B = "com.iqoo.powersaving.PowerSavingManagerActivity";
    private static final String PACKAGE_VIVO_FALLBACK = "com.vivo.permissionmanager";
    private static final String PACKAGE_VIVO_MAIN = "com.iqoo.secure";
    private static final String PACKAGE_VIVO_MAIN_A_A = "com.vivo.abe";
    private static final String PACKAGE_VIVO_MAIN_B = "com.iqoo.powersaving";
    private static final String PACKAGE_XIAOMI_COMPONENT = "com.miui.permcenter.autostart.AutoStartManagementActivity";
    private static final String PACKAGE_XIAOMI_COMPONENT_FALLBACK_A = "com.miui.powerkeeper.ui.HiddenAppsConfigActivity";
    private static final String PACKAGE_XIAOMI_MAIN = "com.miui.securitycenter";
    private static volatile MIUIAutoStart instance;

    static {
        instance = null;
        PACKAGES_TO_CHECK_FOR_PERMISSION = Arrays.asList(PACKAGE_ASUS_MAIN, PACKAGE_XIAOMI_MAIN, PACKAGE_LETV_MAIN, PACKAGE_ULONG_MAIN, "com.huawei.systemmanager", PACKAGE_MEIZU_MAIN, PACKAGE_OPPO_MAIN, PACKAGE_OPPO_FALLBACK, PACKAGE_VIVO_MAIN, PACKAGE_VIVO_FALLBACK, PACKAGE_NOKIA_MAIN, "com.huawei.systemmanager", PACKAGE_ONE_PLUS_MAIN, PACKAGE_ONE_PLUS_MAIN_A, PACKAGE_ONE_PLUS_FALLBACK);
    }

    private MIUIAutoStart() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean autoStartAsus(Context context) {
        if (!this.isPackageExists(context, PACKAGE_ASUS_MAIN)) return false;
        try {
            this.startIntent(context, PACKAGE_ASUS_MAIN, PACKAGE_ASUS_COMPONENT);
            return true;
        }
        catch (Exception exception) {
            Log.e((String)"MIUIAutoStart", (String)"Error in Asus auto start", (Throwable)exception);
            try {
                this.startIntent(context, PACKAGE_ASUS_MAIN, PACKAGE_ASUS_COMPONENT_FALLBACK);
                return true;
            }
            catch (Exception exception2) {
                Log.e((String)"MIUIAutoStart", (String)"Error in Asus fallback auto start", (Throwable)exception2);
                return false;
            }
        }
    }

    private boolean autoStartHonor(Context context) {
        if (this.isPackageExists(context, "com.huawei.systemmanager")) {
            try {
                this.startIntent(context, "com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity");
                return true;
            }
            catch (Exception exception) {
                Log.e((String)"MIUIAutoStart", (String)"Error in Honor auto start", (Throwable)exception);
                return false;
            }
        }
        return false;
    }

    private boolean autoStartHuawei(Context context) {
        if (this.isPackageExists(context, "com.huawei.systemmanager")) {
            try {
                this.startIntent(context, "com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
                return true;
            }
            catch (Exception exception) {
                Log.e((String)"MIUIAutoStart", (String)"Error in Huawei auto start", (Throwable)exception);
                try {
                    this.startIntent(context, "com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity");
                    return true;
                }
                catch (Exception exception2) {
                    Log.e((String)"MIUIAutoStart", (String)"Error in Huawei fallback auto start", (Throwable)exception2);
                    try {
                        this.startIntent(context, "com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
                        return true;
                    }
                    catch (Exception exception3) {
                        Log.e((String)"MIUIAutoStart", (String)"Error in Huawei fallback A auto start", (Throwable)exception3);
                        try {
                            this.startIntent(context, "com.huawei.systemmanager", PACKAGE_HUAWEI_COMPONENT_FALLBACK_B);
                            return true;
                        }
                        catch (Exception exception4) {
                            Log.e((String)"MIUIAutoStart", (String)"Error in Huawei fallback B auto start", (Throwable)exception4);
                            try {
                                this.startIntent(context, "com.huawei.systemmanager", PACKAGE_HUAWEI_COMPONENT_FALLBACK_C);
                                return true;
                            }
                            catch (Exception exception5) {
                                Log.e((String)"MIUIAutoStart", (String)"Error in Huawei fallback C auto start", (Throwable)exception5);
                                try {
                                    this.startIntent(context, "com.huawei.systemmanager", PACKAGE_HUAWEI_COMPONENT_FALLBACK_D);
                                    return true;
                                }
                                catch (Exception exception6) {
                                    Log.e((String)"MIUIAutoStart", (String)"Error in Huawei fallback D auto start", (Throwable)exception6);
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean autoStartLetv(Context context) {
        if (this.isPackageExists(context, PACKAGE_LETV_MAIN)) {
            try {
                this.startIntent(context, PACKAGE_LETV_MAIN, PACKAGE_LETV_COMPONENT);
                return true;
            }
            catch (Exception exception) {
                Log.e((String)"MIUIAutoStart", (String)"Error in Letv auto start", (Throwable)exception);
                return false;
            }
        }
        return false;
    }

    private boolean autoStartMeizu(Context context) {
        if (this.isPackageExists(context, PACKAGE_MEIZU_MAIN)) {
            try {
                this.startIntent(context, PACKAGE_MEIZU_MAIN, PACKAGE_MEIZU_COMPONENT);
                return true;
            }
            catch (Exception exception) {
                Log.e((String)"MIUIAutoStart", (String)"Error in Meizu auto start", (Throwable)exception);
                return false;
            }
        }
        return false;
    }

    private boolean autoStartNokia(Context context) {
        if (this.isPackageExists(context, PACKAGE_NOKIA_MAIN)) {
            try {
                this.startIntent(context, PACKAGE_NOKIA_MAIN, PACKAGE_NOKIA_COMPONENT);
                return true;
            }
            catch (Exception exception) {
                Log.e((String)"MIUIAutoStart", (String)"Error in Nokia auto start", (Throwable)exception);
                return false;
            }
        }
        return false;
    }

    private boolean autoStartOnePlus(Context context) {
        boolean bl;
        if (!(this.isPackageExists(context, PACKAGE_ONE_PLUS_MAIN) || this.isPackageExists(context, PACKAGE_ONE_PLUS_FALLBACK) || this.isPackageExists(context, PACKAGE_ONE_PLUS_MAIN_A))) {
            bl = false;
        } else {
            try {
                this.startIntent(context, PACKAGE_ONE_PLUS_MAIN, PACKAGE_ONE_PLUS_COMPONENT);
                bl = true;
            }
            catch (Exception exception) {
                Log.e((String)"MIUIAutoStart", (String)"Error in OnePlus auto start", (Throwable)exception);
                try {
                    this.startIntent(context, PACKAGE_ONE_PLUS_FALLBACK, PACKAGE_ONE_PLUS_COMPONENT_FALLBACK);
                    bl = true;
                }
                catch (Exception exception2) {
                    Log.e((String)"MIUIAutoStart", (String)"Error in OnePlus fallback auto start", (Throwable)exception2);
                    try {
                        this.startIntent(context, PACKAGE_ONE_PLUS_MAIN, PACKAGE_ONE_PLUS_COMPONENT_FALLBACK_A);
                        bl = true;
                    }
                    catch (Exception exception3) {
                        Log.e((String)"MIUIAutoStart", (String)"Error in OnePlus fallback A auto start", (Throwable)exception3);
                        try {
                            this.startAction(context, PACKAGE_ONE_PLUS_ACTION);
                            bl = true;
                        }
                        catch (Exception exception4) {
                            Log.e((String)"MIUIAutoStart", (String)"Error in OnePlus action auto start", (Throwable)exception4);
                            try {
                                this.startIntent(context, PACKAGE_ONE_PLUS_MAIN_A, PACKAGE_ONE_PLUS_COMPONENT_FALLBACK_A_B);
                                bl = true;
                            }
                            catch (Exception exception5) {
                                Log.e((String)"MIUIAutoStart", (String)"Error in OnePlus fallback B auto start", (Throwable)exception5);
                                bl = false;
                            }
                        }
                    }
                }
            }
        }
        return bl;
    }

    private boolean autoStartOppo(Context context) {
        boolean bl = false;
        if (this.isPackageExists(context, PACKAGE_OPPO_MAIN) || this.isPackageExists(context, PACKAGE_OPPO_FALLBACK) || this.isPackageExists(context, "com.coloros.oppoguardelf")) {
            try {
                this.startIntent(context, PACKAGE_OPPO_MAIN, PACKAGE_OPPO_COMPONENT);
                bl = true;
            }
            catch (Exception exception) {
                Log.e((String)"MIUIAutoStart", (String)"Error in Oppo auto start", (Throwable)exception);
                try {
                    this.startIntent(context, PACKAGE_OPPO_FALLBACK, PACKAGE_OPPO_COMPONENT_FALLBACK);
                    bl = true;
                }
                catch (Exception exception2) {
                    Log.e((String)"MIUIAutoStart", (String)"Error in Oppo fallback auto start", (Throwable)exception2);
                    try {
                        this.startIntent(context, PACKAGE_OPPO_MAIN, PACKAGE_OPPO_COMPONENT_FALLBACK_A);
                        bl = true;
                    }
                    catch (Exception exception3) {
                        Log.e((String)"MIUIAutoStart", (String)"Error in Oppo fallback A auto start", (Throwable)exception3);
                        try {
                            this.startIntent(context, "com.coloros.oppoguardelf", PACKAGE_OPPO_COMPONENT_FALLBACK_A_A);
                            bl = true;
                        }
                        catch (Exception exception4) {
                            Log.e((String)"MIUIAutoStart", (String)"Error in Oppo fallback A_A auto start", (Throwable)exception4);
                            bl = false;
                        }
                    }
                }
            }
        }
        boolean bl2 = bl;
        if (!bl) {
            Intent intent = new Intent(context, BatteryOptimizationSetupActivity.class);
            intent.addFlags(0x10000000);
            context.startActivity(intent);
            bl2 = true;
        }
        return bl2;
    }

    private boolean autoStartUlong(Context context) {
        if (this.isPackageExists(context, PACKAGE_ULONG_MAIN)) {
            try {
                this.startIntent(context, PACKAGE_ULONG_MAIN, PACKAGE_ULONG_COMPONENT);
                return true;
            }
            catch (Exception exception) {
                Log.e((String)"MIUIAutoStart", (String)"Error in Ulong auto start", (Throwable)exception);
                return false;
            }
        }
        return false;
    }

    private boolean autoStartVivo(Context context) {
        if (!(this.isPackageExists(context, PACKAGE_VIVO_MAIN) || this.isPackageExists(context, PACKAGE_VIVO_FALLBACK) || this.isPackageExists(context, PACKAGE_VIVO_MAIN_B) || this.isPackageExists(context, PACKAGE_VIVO_MAIN_A_A))) {
            return false;
        }
        try {
            this.startIntent(context, PACKAGE_VIVO_MAIN, PACKAGE_VIVO_COMPONENT);
            return true;
        }
        catch (Exception exception) {
            Log.e((String)"MIUIAutoStart", (String)"Error in Vivo auto start", (Throwable)exception);
            try {
                this.startIntent(context, PACKAGE_VIVO_FALLBACK, PACKAGE_VIVO_COMPONENT_FALLBACK);
                return true;
            }
            catch (Exception exception2) {
                Log.e((String)"MIUIAutoStart", (String)"Error in Vivo fallback auto start", (Throwable)exception2);
                try {
                    this.startIntent(context, PACKAGE_VIVO_MAIN, PACKAGE_VIVO_COMPONENT_FALLBACK_A);
                    return true;
                }
                catch (Exception exception3) {
                    Log.e((String)"MIUIAutoStart", (String)"Error in Vivo fallback A auto start", (Throwable)exception3);
                    try {
                        this.startIntent(context, PACKAGE_VIVO_MAIN_A_A, PACKAGE_VIVO_COMPONENT_FALLBACK_A_A);
                        return true;
                    }
                    catch (Exception exception4) {
                        Log.e((String)"MIUIAutoStart", (String)"Error in Vivo fallback A_A auto start", (Throwable)exception4);
                        try {
                            this.startIntent(context, PACKAGE_VIVO_FALLBACK, PACKAGE_VIVO_COMPONENT_FALLBACK_A_A_A);
                            return true;
                        }
                        catch (Exception exception5) {
                            Log.e((String)"MIUIAutoStart", (String)"Error in Vivo fallback A_A_A auto start", (Throwable)exception5);
                            return false;
                        }
                    }
                }
            }
        }
    }

    private boolean autoStartXiaomi(Context context) {
        if (this.isPackageExists(context, PACKAGE_XIAOMI_MAIN) || this.isPackageExists(context, "com.miui.powerkeeper")) {
            try {
                this.startIntent(context, PACKAGE_XIAOMI_MAIN, PACKAGE_XIAOMI_COMPONENT);
                return true;
            }
            catch (Exception exception) {
                Log.e((String)"MIUIAutoStart", (String)"Error in Xiaomi auto start", (Throwable)exception);
                try {
                    this.startIntent(context, "com.miui.powerkeeper", PACKAGE_XIAOMI_COMPONENT_FALLBACK_A);
                    return true;
                }
                catch (Exception exception2) {
                    Log.e((String)"MIUIAutoStart", (String)"Error in Xiaomi auto start 2", (Throwable)exception);
                }
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MIUIAutoStart getInstance() {
        if (instance != null) return instance;
        synchronized (MIUIAutoStart.class) {
            MIUIAutoStart mIUIAutoStart;
            if (instance != null) return instance;
            instance = mIUIAutoStart = new MIUIAutoStart();
            return instance;
        }
    }

    public static boolean isOppoOrOnePlus() {
        String string2 = Build.BRAND.toLowerCase(Locale.ROOT);
        boolean bl = string2.equals(BRAND_OPPO) || string2.equals(BRAND_ONE_PLUS);
        return bl;
    }

    private boolean isPackageExists(Context context, String string2) {
        context = context.getPackageManager();
        try {
            context.getPackageInfo(string2, 1);
            return true;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return false;
        }
    }

    public static boolean isSamsung() {
        return Build.BRAND.toLowerCase(Locale.ROOT).equals(BRAND_SAMSUNG);
    }

    public static boolean isXiaomi() {
        String string2 = Build.BRAND.toLowerCase(Locale.ROOT);
        boolean bl = string2.equals(BRAND_XIAOMI) || string2.equals(BRAND_XIAOMI_POCO) || string2.equals(BRAND_XIAOMI_REDMI);
        return bl;
    }

    private void startAction(Context context, String string2) {
        try {
            Intent intent = new Intent();
            intent.setAction(string2);
            intent.addFlags(0x10000000);
            context.startActivity(intent);
        }
        catch (Exception exception) {
            Log.e((String)"MIUIAutoStart", (String)"Error starting action", (Throwable)exception);
        }
    }

    private void startIntent(Context context, String string2, String string3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(string2, string3));
        intent.addFlags(0x10000000);
        context.startActivity(intent);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean getAutoStartPermission(Context context) {
        int n;
        block28: {
            String string2 = Build.BRAND.toLowerCase(Locale.ROOT);
            switch (string2.hashCode()) {
                case 111379569: {
                    if (!string2.equals(BRAND_ULONG)) break;
                    n = 5;
                    break block28;
                }
                case 108389869: {
                    if (!string2.equals(BRAND_XIAOMI_REDMI)) break;
                    n = 3;
                    break block28;
                }
                case 105000290: {
                    if (!string2.equals(BRAND_NOKIA)) break;
                    n = 12;
                    break block28;
                }
                case 103777484: {
                    if (!string2.equals(BRAND_MEIZU)) break;
                    n = 4;
                    break block28;
                }
                case 99462250: {
                    if (!string2.equals(BRAND_HONOR)) break;
                    n = 7;
                    break block28;
                }
                case 3620012: {
                    if (!string2.equals(BRAND_VIVO)) break;
                    n = 11;
                    break block28;
                }
                case 3446443: {
                    if (!string2.equals(BRAND_XIAOMI_POCO)) break;
                    n = 2;
                    break block28;
                }
                case 3418016: {
                    if (!string2.equals(BRAND_OPPO)) break;
                    n = 9;
                    break block28;
                }
                case 3318203: {
                    if (!string2.equals(BRAND_LETV)) break;
                    n = 6;
                    break block28;
                }
                case 3003984: {
                    if (!string2.equals(BRAND_ASUS)) break;
                    n = 0;
                    break block28;
                }
                case -759499589: {
                    if (!string2.equals(BRAND_XIAOMI)) break;
                    n = 1;
                    break block28;
                }
                case -1206476313: {
                    if (!string2.equals(BRAND_HUAWEI)) break;
                    n = 8;
                    break block28;
                }
                case -1320380160: {
                    if (!string2.equals(BRAND_ONE_PLUS)) break;
                    n = 10;
                    break block28;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return false;
            }
            case 12: {
                return this.autoStartNokia(context);
            }
            case 11: {
                return this.autoStartVivo(context);
            }
            case 10: {
                return this.autoStartOnePlus(context);
            }
            case 9: {
                return this.autoStartOppo(context);
            }
            case 8: {
                return this.autoStartHuawei(context);
            }
            case 7: {
                return this.autoStartHonor(context);
            }
            case 6: {
                return this.autoStartLetv(context);
            }
            case 5: {
                return this.autoStartUlong(context);
            }
            case 4: {
                return this.autoStartMeizu(context);
            }
            case 1: 
            case 2: 
            case 3: {
                return this.autoStartXiaomi(context);
            }
            case 0: 
        }
        return this.autoStartAsus(context);
    }

    public boolean isAutoStartPermissionAvailable(Context context2) {
        for (Context context2 : context2.getPackageManager().getInstalledApplications(0)) {
            if (!PACKAGES_TO_CHECK_FOR_PERMISSION.contains(context2.packageName)) continue;
            return true;
        }
        return false;
    }
}

