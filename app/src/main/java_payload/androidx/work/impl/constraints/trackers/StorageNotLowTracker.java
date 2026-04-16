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
import androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker;
import androidx.work.impl.constraints.trackers.StorageNotLowTrackerKt;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\r\u0010\u0010\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\u0011R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2={"Landroidx/work/impl/constraints/trackers/StorageNotLowTracker;", "Landroidx/work/impl/constraints/trackers/BroadcastReceiverConstraintTracker;", "", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "intentFilter", "Landroid/content/IntentFilter;", "getIntentFilter", "()Landroid/content/IntentFilter;", "onBroadcastReceive", "", "intent", "Landroid/content/Intent;", "readSystemState", "()Ljava/lang/Boolean;", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class StorageNotLowTracker
extends BroadcastReceiverConstraintTracker<Boolean> {
    public StorageNotLowTracker(Context context, TaskExecutor taskExecutor) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"taskExecutor");
        super(context, taskExecutor);
    }

    @Override
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
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
        Logger.get().debug(StorageNotLowTrackerKt.access$getTAG$p(), "Received " + object.getAction());
        object = object.getAction();
        if (object == null) return;
        int n = -1;
        switch (((String)object).hashCode()) {
            case -730838620: {
                if (!((String)object).equals("android.intent.action.DEVICE_STORAGE_OK")) break;
                n = 1;
                break;
            }
            case -1181163412: {
                if (!((String)object).equals("android.intent.action.DEVICE_STORAGE_LOW")) break;
                n = 2;
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
            case 2: 
        }
        this.setState(false);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public Boolean readSystemState() {
        Object object = this.getAppContext().registerReceiver(null, this.getIntentFilter());
        boolean bl = true;
        if (object == null) return bl;
        if (object.getAction() == null) {
            return bl;
        }
        if ((object = object.getAction()) != null) {
            int n = -1;
            switch (((String)object).hashCode()) {
                case -730838620: {
                    if (!((String)object).equals("android.intent.action.DEVICE_STORAGE_OK")) break;
                    n = 1;
                    break;
                }
                case -1181163412: {
                    if (!((String)object).equals("android.intent.action.DEVICE_STORAGE_LOW")) break;
                    n = 2;
                    break;
                }
            }
            switch (n) {
                default: {
                    break;
                }
                case 1: {
                    return bl;
                }
                case 2: {
                    bl = false;
                    return bl;
                }
            }
        }
        bl = false;
        return bl;
    }
}

