/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger;
import androidx.work.impl.constraints.trackers.BatteryChargingTrackerKt;
import androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016J\r\u0010\u0011\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\u0012R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2={"Landroidx/work/impl/constraints/trackers/BatteryChargingTracker;", "Landroidx/work/impl/constraints/trackers/BroadcastReceiverConstraintTracker;", "", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "intentFilter", "Landroid/content/IntentFilter;", "getIntentFilter", "()Landroid/content/IntentFilter;", "isBatteryChangedIntentCharging", "intent", "Landroid/content/Intent;", "onBroadcastReceive", "", "readSystemState", "()Ljava/lang/Boolean;", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class BatteryChargingTracker
extends BroadcastReceiverConstraintTracker<Boolean> {
    public BatteryChargingTracker(Context context, TaskExecutor taskExecutor) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"taskExecutor");
        super(context, taskExecutor);
    }

    private final boolean isBatteryChangedIntentCharging(Intent intent) {
        int n = intent.getIntExtra("status", -1);
        boolean bl = n == 2 || n == 5;
        return bl;
    }

    @Override
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.CHARGING");
        intentFilter.addAction("android.os.action.DISCHARGING");
        return intentFilter;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void onBroadcastReceive(Intent object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"intent");
        object = object.getAction();
        if (object == null) {
            return;
        }
        Logger.get().debug(BatteryChargingTrackerKt.access$getTAG$p(), "Received " + (String)object);
        int n = -1;
        switch (((String)object).hashCode()) {
            case 1019184907: {
                if (!((String)object).equals("android.intent.action.ACTION_POWER_CONNECTED")) break;
                n = 1;
                break;
            }
            case 948344062: {
                if (!((String)object).equals("android.os.action.CHARGING")) break;
                n = 2;
                break;
            }
            case -54942926: {
                if (!((String)object).equals("android.os.action.DISCHARGING")) break;
                n = 3;
                break;
            }
            case -1886648615: {
                if (!((String)object).equals("android.intent.action.ACTION_POWER_DISCONNECTED")) break;
                n = 4;
                break;
            }
        }
        switch (n) {
            default: {
                return;
            }
            case 1: {
                this.setState(true);
                return;
            }
            case 2: {
                this.setState(true);
                return;
            }
            case 3: {
                this.setState(false);
                return;
            }
            case 4: 
        }
        this.setState(false);
    }

    @Override
    public Boolean readSystemState() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        intentFilter = this.getAppContext().registerReceiver(null, intentFilter);
        if (intentFilter == null) {
            Logger.get().error(BatteryChargingTrackerKt.access$getTAG$p(), "getInitialState - null intent received");
            return false;
        }
        return this.isBatteryChangedIntentCharging((Intent)intentFilter);
    }
}

