/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.background.systemalarm.CommandHandler;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

abstract class ConstraintProxy
extends BroadcastReceiver {
    private static final String TAG = Logger.tagWithPrefix("ConstraintProxy");

    ConstraintProxy() {
    }

    static void updateAll(Context context, List<WorkSpec> object) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        block1: {
            boolean bl5;
            Constraints constraints;
            boolean bl6 = false;
            boolean bl7 = false;
            boolean bl8 = false;
            boolean bl9 = false;
            object = object.iterator();
            do {
                bl4 = bl6;
                bl3 = bl7;
                bl2 = bl8;
                bl = bl9;
                if (!object.hasNext()) break block1;
                constraints = ((WorkSpec)object.next()).constraints;
                bl5 = constraints.getRequiredNetworkType() != NetworkType.NOT_REQUIRED;
            } while (!(bl6 |= constraints.requiresBatteryNotLow()) || !(bl7 |= constraints.requiresCharging()) || !(bl8 |= constraints.requiresStorageNotLow()) || !(bl9 |= bl5));
            bl4 = bl6;
            bl3 = bl7;
            bl2 = bl8;
            bl = bl9;
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.newConstraintProxyUpdateIntent(context, bl4, bl3, bl2, bl));
    }

    public void onReceive(Context context, Intent intent) {
        Logger.get().debug(TAG, "onReceive : " + intent);
        context.startService(CommandHandler.createConstraintsChangedIntent(context));
    }

    public static class BatteryChargingProxy
    extends ConstraintProxy {
    }

    public static class BatteryNotLowProxy
    extends ConstraintProxy {
    }

    public static class NetworkStateProxy
    extends ConstraintProxy {
    }

    public static class StorageNotLowProxy
    extends ConstraintProxy {
    }
}

