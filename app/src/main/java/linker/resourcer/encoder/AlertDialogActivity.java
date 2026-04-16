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
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import java.util.Locale;
import linker.resourcer.encoder.AlertDialogActivity$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.UtilityHelper;
import linker.resourcer.encoder.AppLauncherActivity;
import linker.resourcer.encoder.SharedPreferencesManager;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class AlertDialogActivity
extends Activity {
    private static int Type;
    private static String toopen;

    /* synthetic */ void lambda$onCreate$0$com-icontrol-protector-AlertDialogActivity(Context context, DialogInterface dialogInterface, int n) {
        Intent intent = null;
        switch (Type) {
            default: {
                dialogInterface.dismiss();
                break;
            }
            case 2: {
                intent = new Intent(context, AppLauncherActivity.class);
                if (!toopen.startsWith("http://") && !toopen.startsWith("https://")) {
                    toopen = "http://" + toopen;
                }
                intent.putExtra("type", "link");
                intent.putExtra("tolunch", toopen);
                break;
            }
            case 1: {
                intent = new Intent(context, AppLauncherActivity.class);
                intent.putExtra("type", "app");
                intent.putExtra("tolunch", toopen);
            }
        }
        if (intent != null) {
            intent.addFlags(0x10000000);
            intent.addFlags(0x800000);
            intent.addFlags(0x40000000);
            dialogInterface.dismiss();
            context.startActivity(intent);
        }
        this.finish();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onCreate(Bundle object) {
        block21: {
            void var3_10;
            void var4_28;
            super.onCreate((Bundle)object);
            Object var7_4 = null;
            object = null;
            Drawable drawable2 = null;
            Object var3_6 = null;
            int n = -1;
            Type = -1;
            toopen = null;
            Context context = this.getApplicationContext();
            String string2 = SharedPreferencesManager.Read(context, "alert_ico", null);
            Object var4_14 = var7_4;
            Drawable drawable3 = drawable2;
            try {
                void var3_8;
                Intent intent = this.getIntent();
                Object var4_15 = var7_4;
                drawable3 = drawable2;
                if (intent.hasExtra("Title")) {
                    Object var4_16 = var7_4;
                    drawable3 = drawable2;
                    object = intent.getStringExtra("Title");
                }
                Object object2 = object;
                drawable3 = drawable2;
                if (intent.hasExtra("Msg")) {
                    Object object3 = object;
                    drawable3 = drawable2;
                    String string3 = intent.getStringExtra("Msg");
                }
                Object object4 = object;
                drawable3 = var3_8;
                if (intent.hasExtra("Type")) {
                    Object object5 = object;
                    drawable3 = var3_8;
                    Type = intent.getIntExtra("Type", 0);
                }
                Object object6 = object;
                drawable3 = var3_8;
                if (intent.hasExtra("toopen")) {
                    Object object7 = object;
                    drawable3 = var3_8;
                    toopen = intent.getStringExtra("toopen");
                }
                Object object8 = object;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                Type = -1;
                toopen = null;
                Drawable drawable4 = drawable3;
            }
            if (toopen == null || Type == -1) break block21;
            this.requestWindowFeature(1);
            this.getWindow().setFlags(1024, 1024);
            try {
                drawable3 = UtilityHelper.getDrawableFromBase64(string2, context);
            }
            catch (Exception exception) {
                drawable3 = null;
            }
            object = Locale.getDefault().getLanguage();
            switch (((String)object).hashCode()) {
                case 3886: {
                    if (!((String)object).equals("zh")) break;
                    n = 2;
                    break;
                }
                case 3710: {
                    if (!((String)object).equals("tr")) break;
                    n = 3;
                    break;
                }
                case 3241: {
                    if (!((String)object).equals("en")) break;
                    n = 0;
                    break;
                }
                case 3121: {
                    if (!((String)object).equals("ar")) break;
                    n = 1;
                }
            }
            switch (n) {
                default: {
                    object = "OK";
                    break;
                }
                case 3: {
                    object = "Tamam";
                    break;
                }
                case 2: {
                    object = "\u597d\u7684";
                    break;
                }
                case 1: {
                    object = "\u0645\u0648\u0627\u0641\u0642";
                    break;
                }
                case 0: {
                    object = "ok";
                }
            }
            object = new AlertDialog.Builder((Context)this, 16974545).setTitle((CharSequence)var4_28).setMessage((CharSequence)var3_10).setPositiveButton((CharSequence)object, (DialogInterface.OnClickListener)new AlertDialogActivity$$ExternalSyntheticLambda0(this, context));
            if (drawable3 != null) {
                object.setIcon(drawable3);
            }
            object.show();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}

