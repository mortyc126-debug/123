/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.AccountManager
 *  android.app.ActivityManager
 *  android.app.AlarmManager
 *  android.app.AppOpsManager
 *  android.app.DownloadManager
 *  android.app.KeyguardManager
 *  android.app.NotificationManager
 *  android.app.SearchManager
 *  android.app.UiModeManager
 *  android.app.WallpaperManager
 *  android.app.admin.DevicePolicyManager
 *  android.app.job.JobScheduler
 *  android.app.usage.UsageStatsManager
 *  android.appwidget.AppWidgetManager
 *  android.bluetooth.BluetoothManager
 *  android.content.BroadcastReceiver
 *  android.content.ClipboardManager
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.RestrictionsManager
 *  android.content.pm.LauncherApps
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.hardware.ConsumerIrManager
 *  android.hardware.SensorManager
 *  android.hardware.camera2.CameraManager
 *  android.hardware.display.DisplayManager
 *  android.hardware.input.InputManager
 *  android.hardware.usb.UsbManager
 *  android.location.LocationManager
 *  android.media.AudioManager
 *  android.media.MediaRouter
 *  android.media.projection.MediaProjectionManager
 *  android.media.session.MediaSessionManager
 *  android.media.tv.TvInputManager
 *  android.net.ConnectivityManager
 *  android.net.nsd.NsdManager
 *  android.net.wifi.WifiManager
 *  android.net.wifi.p2p.WifiP2pManager
 *  android.nfc.NfcManager
 *  android.os.BatteryManager
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.DropBoxManager
 *  android.os.Handler
 *  android.os.PowerManager
 *  android.os.Process
 *  android.os.UserManager
 *  android.os.Vibrator
 *  android.os.storage.StorageManager
 *  android.print.PrintManager
 *  android.telecom.TelecomManager
 *  android.telephony.SubscriptionManager
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.Display
 *  android.view.LayoutInflater
 *  android.view.WindowManager
 *  android.view.accessibility.AccessibilityManager
 *  android.view.accessibility.CaptioningManager
 *  android.view.inputmethod.InputMethodManager
 *  android.view.textservice.TextServicesManager
 */
package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.core.app.LocaleManagerCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.PermissionChecker;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.concurrent.Executor;

public class ContextCompat {
    private static final String DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    public static final int RECEIVER_VISIBLE_TO_INSTANT_APPS = 1;
    private static final String TAG = "ContextCompat";
    private static final Object sSync = new Object();

    protected ContextCompat() {
    }

    public static int checkSelfPermission(Context context, String string2) {
        ObjectsCompat.requireNonNull(string2, "permission must be non-null");
        if (Build.VERSION.SDK_INT < 33 && TextUtils.equals((CharSequence)"android.permission.POST_NOTIFICATIONS", (CharSequence)string2)) {
            int n = NotificationManagerCompat.from(context).areNotificationsEnabled() ? 0 : -1;
            return n;
        }
        return context.checkPermission(string2, Process.myPid(), Process.myUid());
    }

    public static Context createAttributionContext(Context context, String string2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.createAttributionContext(context, string2);
        }
        return context;
    }

    public static Context createDeviceProtectedStorageContext(Context context) {
        return Api24Impl.createDeviceProtectedStorageContext(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static File createFilesDir(File file) {
        Object object = sSync;
        synchronized (object) {
            if (!file.exists()) {
                if (file.mkdirs()) {
                    return file;
                }
                StringBuilder stringBuilder = new StringBuilder();
                Log.w((String)TAG, (String)stringBuilder.append("Unable to create files subdir ").append(file.getPath()).toString());
            }
            return file;
        }
    }

    public static String getAttributionTag(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getAttributionTag(context);
        }
        return null;
    }

    public static File getCodeCacheDir(Context context) {
        return Api21Impl.getCodeCacheDir(context);
    }

    public static int getColor(Context context, int n) {
        return Api23Impl.getColor(context, n);
    }

    public static ColorStateList getColorStateList(Context context, int n) {
        return ResourcesCompat.getColorStateList(context.getResources(), n, context.getTheme());
    }

    public static Context getContextForLanguage(Context context) {
        LocaleListCompat localeListCompat = LocaleManagerCompat.getApplicationLocales(context);
        if (Build.VERSION.SDK_INT <= 32 && !localeListCompat.isEmpty()) {
            Configuration configuration2 = new Configuration(context.getResources().getConfiguration());
            ConfigurationCompat.setLocales(configuration2, localeListCompat);
            return context.createConfigurationContext(configuration2);
        }
        return context;
    }

    public static File getDataDir(Context context) {
        return Api24Impl.getDataDir(context);
    }

    public static Display getDisplayOrDefault(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getDisplayOrDefault(context);
        }
        return ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
    }

    public static Drawable getDrawable(Context context, int n) {
        return Api21Impl.getDrawable(context, n);
    }

    public static File[] getExternalCacheDirs(Context context) {
        return context.getExternalCacheDirs();
    }

    public static File[] getExternalFilesDirs(Context context, String string2) {
        return context.getExternalFilesDirs(string2);
    }

    public static Executor getMainExecutor(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getMainExecutor(context);
        }
        return ExecutorCompat.create(new Handler(context.getMainLooper()));
    }

    public static File getNoBackupFilesDir(Context context) {
        return Api21Impl.getNoBackupFilesDir(context);
    }

    public static File[] getObbDirs(Context context) {
        return context.getObbDirs();
    }

    public static String getString(Context context, int n) {
        return ContextCompat.getContextForLanguage(context).getString(n);
    }

    public static <T> T getSystemService(Context context, Class<T> clazz) {
        return Api23Impl.getSystemService(context, clazz);
    }

    public static String getSystemServiceName(Context context, Class<?> clazz) {
        return Api23Impl.getSystemServiceName(context, clazz);
    }

    public static boolean isDeviceProtectedStorage(Context context) {
        return Api24Impl.isDeviceProtectedStorage(context);
    }

    static String obtainAndCheckReceiverPermission(Context context) {
        String string2 = context.getPackageName() + DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX;
        if (PermissionChecker.checkSelfPermission(context, string2) == 0) {
            return string2;
        }
        throw new RuntimeException("Permission " + string2 + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver2, IntentFilter intentFilter, int n) {
        return ContextCompat.registerReceiver(context, broadcastReceiver2, intentFilter, null, null, n);
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver2, IntentFilter intentFilter, String string2, Handler handler, int n) {
        if ((n & 1) != 0 && (n & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
        }
        int n2 = n;
        if ((n & 1) != 0) {
            n2 = n | 2;
        }
        if ((n2 & 2) == 0 && (n2 & 4) == 0) {
            throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
        }
        if ((n2 & 2) != 0 && (n2 & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.registerReceiver(context, broadcastReceiver2, intentFilter, string2, handler, n2);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.registerReceiver(context, broadcastReceiver2, intentFilter, string2, handler, n2);
        }
        if ((n2 & 4) != 0 && string2 == null) {
            return context.registerReceiver(broadcastReceiver2, intentFilter, ContextCompat.obtainAndCheckReceiverPermission(context), handler);
        }
        return context.registerReceiver(broadcastReceiver2, intentFilter, string2, handler);
    }

    public static boolean startActivities(Context context, Intent[] intentArray) {
        return ContextCompat.startActivities(context, intentArray, null);
    }

    public static boolean startActivities(Context context, Intent[] intentArray, Bundle bundle) {
        context.startActivities(intentArray, bundle);
        return true;
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    public static void startForegroundService(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.startForegroundService(context, intent);
        } else {
            context.startService(intent);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static File getCodeCacheDir(Context context) {
            return context.getCodeCacheDir();
        }

        static Drawable getDrawable(Context context, int n) {
            return context.getDrawable(n);
        }

        static File getNoBackupFilesDir(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static int getColor(Context context, int n) {
            return context.getColor(n);
        }

        static <T> T getSystemService(Context context, Class<T> clazz) {
            return (T)context.getSystemService(clazz);
        }

        static String getSystemServiceName(Context context, Class<?> clazz) {
            return context.getSystemServiceName(clazz);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static Context createDeviceProtectedStorageContext(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        static File getDataDir(Context context) {
            return context.getDataDir();
        }

        static boolean isDeviceProtectedStorage(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver2, IntentFilter intentFilter, String string2, Handler handler, int n) {
            if ((n & 4) != 0 && string2 == null) {
                return context.registerReceiver(broadcastReceiver2, intentFilter, ContextCompat.obtainAndCheckReceiverPermission(context), handler);
            }
            return context.registerReceiver(broadcastReceiver2, intentFilter, string2, handler, n & 1);
        }

        static ComponentName startForegroundService(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Executor getMainExecutor(Context context) {
            return context.getMainExecutor();
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static Context createAttributionContext(Context context, String string2) {
            return context.createAttributionContext(string2);
        }

        static String getAttributionTag(Context context) {
            return context.getAttributionTag();
        }

        static Display getDisplayOrDefault(Context context) {
            try {
                Display display = context.getDisplay();
                return display;
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                Log.w((String)ContextCompat.TAG, (String)("The context:" + context + " is not associated with any display. Return a fallback display instead."));
                return ((DisplayManager)context.getSystemService(DisplayManager.class)).getDisplay(0);
            }
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver2, IntentFilter intentFilter, String string2, Handler handler, int n) {
            return context.registerReceiver(broadcastReceiver2, intentFilter, string2, handler, n);
        }
    }

    private static final class LegacyServiceMapHolder {
        static final HashMap<Class<?>, String> SERVICES = new HashMap();

        static {
            SERVICES.put(SubscriptionManager.class, "telephony_subscription_service");
            SERVICES.put(UsageStatsManager.class, "usagestats");
            SERVICES.put(AppWidgetManager.class, "appwidget");
            SERVICES.put(BatteryManager.class, "batterymanager");
            SERVICES.put(CameraManager.class, "camera");
            SERVICES.put(JobScheduler.class, "jobscheduler");
            SERVICES.put(LauncherApps.class, "launcherapps");
            SERVICES.put(MediaProjectionManager.class, "media_projection");
            SERVICES.put(MediaSessionManager.class, "media_session");
            SERVICES.put(RestrictionsManager.class, "restrictions");
            SERVICES.put(TelecomManager.class, "telecom");
            SERVICES.put(TvInputManager.class, "tv_input");
            SERVICES.put(AppOpsManager.class, "appops");
            SERVICES.put(CaptioningManager.class, "captioning");
            SERVICES.put(ConsumerIrManager.class, "consumer_ir");
            SERVICES.put(PrintManager.class, "print");
            SERVICES.put(BluetoothManager.class, "bluetooth");
            SERVICES.put(DisplayManager.class, "display");
            SERVICES.put(UserManager.class, "user");
            SERVICES.put(InputManager.class, "input");
            SERVICES.put(MediaRouter.class, "media_router");
            SERVICES.put(NsdManager.class, "servicediscovery");
            SERVICES.put(AccessibilityManager.class, "accessibility");
            SERVICES.put(AccountManager.class, "account");
            SERVICES.put(ActivityManager.class, "activity");
            SERVICES.put(AlarmManager.class, "alarm");
            SERVICES.put(AudioManager.class, "audio");
            SERVICES.put(ClipboardManager.class, "clipboard");
            SERVICES.put(ConnectivityManager.class, "connectivity");
            SERVICES.put(DevicePolicyManager.class, "device_policy");
            SERVICES.put(DownloadManager.class, "download");
            SERVICES.put(DropBoxManager.class, "dropbox");
            SERVICES.put(InputMethodManager.class, "input_method");
            SERVICES.put(KeyguardManager.class, "keyguard");
            SERVICES.put(LayoutInflater.class, "layout_inflater");
            SERVICES.put(LocationManager.class, "location");
            SERVICES.put(NfcManager.class, "nfc");
            SERVICES.put(NotificationManager.class, "notification");
            SERVICES.put(PowerManager.class, "power");
            SERVICES.put(SearchManager.class, "search");
            SERVICES.put(SensorManager.class, "sensor");
            SERVICES.put(StorageManager.class, "storage");
            SERVICES.put(TelephonyManager.class, "phone");
            SERVICES.put(TextServicesManager.class, "textservices");
            SERVICES.put(UiModeManager.class, "uimode");
            SERVICES.put(UsbManager.class, "usb");
            SERVICES.put(Vibrator.class, "vibrator");
            SERVICES.put(WallpaperManager.class, "wallpaper");
            SERVICES.put(WifiP2pManager.class, "wifip2p");
            SERVICES.put(WifiManager.class, "wifi");
            SERVICES.put(WindowManager.class, "window");
        }

        private LegacyServiceMapHolder() {
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface RegisterReceiverFlags {
    }
}

