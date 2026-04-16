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
import androidx.work.impl.constraints.trackers.BatteryNotLowTrackerKt;
import androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\r\u0010\u0010\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\u0011R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2={"Landroidx/work/impl/constraints/trackers/BatteryNotLowTracker;", "Landroidx/work/impl/constraints/trackers/BroadcastReceiverConstraintTracker;", "", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "intentFilter", "Landroid/content/IntentFilter;", "getIntentFilter", "()Landroid/content/IntentFilter;", "onBroadcastReceive", "", "intent", "Landroid/content/Intent;", "readSystemState", "()Ljava/lang/Boolean;", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class BatteryNotLowTracker
extends BroadcastReceiverConstraintTracker<Boolean> {
    public BatteryNotLowTracker(Context context, TaskExecutor taskExecutor) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"taskExecutor");
        super(context, taskExecutor);
    }

    @Override
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void onBroadcastReceive(Intent object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"intent");
        if (object.getAction() == null) {
            return;
        }
        Logger.get().debug(BatteryNotLowTrackerKt.access$getTAG$p(), "Received " + object.getAction());
        object = object.getAction();
        if (object == null) return;
        int n = -1;
        switch (((String)object).hashCode()) {
            case 490310653: {
                if (!((String)object).equals("android.intent.action.BATTERY_LOW")) break;
                n = 1;
                break;
            }
            case -1980154005: {
                if (!((String)object).equals("android.intent.action.BATTERY_OKAY")) break;
                n = 2;
                break;
            }
        }
        switch (n) {
            default: {
                return;
            }
            case 1: {
                this.setState(false);
                return;
            }
            case 2: 
        }
        this.setState(true);
    }

    @Override
    public Boolean readSystemState() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        intentFilter = this.getAppContext().registerReceiver(null, intentFilter);
        boolean bl = false;
        if (intentFilter == null) {
            Logger.get().error(BatteryNotLowTrackerKt.access$getTAG$p(), "getInitialState - null intent received");
            return false;
        }
        int n = intentFilter.getIntExtra("status", -1);
        int n2 = intentFilter.getIntExtra("level", -1);
        int n3 = intentFilter.getIntExtra("scale", -1);
        float f = (float)n2 / (float)n3;
        if (n == 1 || f > 0.15f) {
            bl = true;
        }
        return bl;
    }
}

