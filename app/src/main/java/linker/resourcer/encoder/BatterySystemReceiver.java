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
import linker.resourcer.encoder.BatterySystemReceiver$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.WorkerService;
import linker.resourcer.encoder.SetupOrchestrationService;
import linker.resourcer.encoder.SystemUtilities;
import linker.resourcer.encoder.SharedPreferencesManager;

public class BatterySystemReceiver
extends BroadcastReceiver {
    static /* synthetic */ void lambda$onReceive$0(Intent intent, Context context) {
        try {
            if (intent.getAction() != null && "android.intent.action.BATTERY_LOW".equals(intent.getAction())) {
                WorkerService.MyWorker.AlertServer(context, "Battery State", "Battery is low");
            }
            SharedPreferencesManager.WriteBool(context, ConfigurationConstants.AutoStartOn, true);
            if (!SystemUtilities.isServiceRunning(context, WorkerService.class)) {
                intent = new Intent(context, WorkerService.class);
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            }
            intent = new Intent(context, SetupOrchestrationService.class);
            if (!SystemUtilities.isServiceRunning(context, SetupOrchestrationService.class)) {
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
            BatterySystemReceiver$$ExternalSyntheticLambda0 vsvtpr$$ExternalSyntheticLambda0 = new BatterySystemReceiver$$ExternalSyntheticLambda0(intent, context);
            Thread thread = new Thread(vsvtpr$$ExternalSyntheticLambda0);
            thread.start();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

