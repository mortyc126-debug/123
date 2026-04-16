/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.BatteryChargingTracker;
import androidx.work.impl.constraints.trackers.BatteryNotLowTracker;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.constraints.trackers.NetworkStateTrackerKt;
import androidx.work.impl.constraints.trackers.StorageNotLowTracker;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010\u00a8\u0006\u0015"}, d2={"Landroidx/work/impl/constraints/trackers/Trackers;", "", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "batteryChargingTracker", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "", "batteryNotLowTracker", "Landroidx/work/impl/constraints/trackers/BatteryNotLowTracker;", "networkStateTracker", "Landroidx/work/impl/constraints/NetworkState;", "storageNotLowTracker", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;Landroidx/work/impl/constraints/trackers/ConstraintTracker;Landroidx/work/impl/constraints/trackers/BatteryNotLowTracker;Landroidx/work/impl/constraints/trackers/ConstraintTracker;Landroidx/work/impl/constraints/trackers/ConstraintTracker;)V", "getBatteryChargingTracker", "()Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "getBatteryNotLowTracker", "()Landroidx/work/impl/constraints/trackers/BatteryNotLowTracker;", "getNetworkStateTracker", "getStorageNotLowTracker", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class Trackers {
    private final ConstraintTracker<Boolean> batteryChargingTracker;
    private final BatteryNotLowTracker batteryNotLowTracker;
    private final ConstraintTracker<NetworkState> networkStateTracker;
    private final ConstraintTracker<Boolean> storageNotLowTracker;

    public Trackers(Context context, TaskExecutor taskExecutor) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"taskExecutor");
        this(context, taskExecutor, null, null, null, null, 60, null);
    }

    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"taskExecutor");
        Intrinsics.checkNotNullParameter(constraintTracker, (String)"batteryChargingTracker");
        this(context, taskExecutor, constraintTracker, null, null, null, 56, null);
    }

    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker, BatteryNotLowTracker batteryNotLowTracker) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"taskExecutor");
        Intrinsics.checkNotNullParameter(constraintTracker, (String)"batteryChargingTracker");
        Intrinsics.checkNotNullParameter((Object)batteryNotLowTracker, (String)"batteryNotLowTracker");
        this(context, taskExecutor, constraintTracker, batteryNotLowTracker, null, null, 48, null);
    }

    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker, BatteryNotLowTracker batteryNotLowTracker, ConstraintTracker<NetworkState> constraintTracker2) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"taskExecutor");
        Intrinsics.checkNotNullParameter(constraintTracker, (String)"batteryChargingTracker");
        Intrinsics.checkNotNullParameter((Object)batteryNotLowTracker, (String)"batteryNotLowTracker");
        Intrinsics.checkNotNullParameter(constraintTracker2, (String)"networkStateTracker");
        this(context, taskExecutor, constraintTracker, batteryNotLowTracker, constraintTracker2, null, 32, null);
    }

    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker, BatteryNotLowTracker batteryNotLowTracker, ConstraintTracker<NetworkState> constraintTracker2, ConstraintTracker<Boolean> constraintTracker3) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"taskExecutor");
        Intrinsics.checkNotNullParameter(constraintTracker, (String)"batteryChargingTracker");
        Intrinsics.checkNotNullParameter((Object)batteryNotLowTracker, (String)"batteryNotLowTracker");
        Intrinsics.checkNotNullParameter(constraintTracker2, (String)"networkStateTracker");
        Intrinsics.checkNotNullParameter(constraintTracker3, (String)"storageNotLowTracker");
        this.batteryChargingTracker = constraintTracker;
        this.batteryNotLowTracker = batteryNotLowTracker;
        this.networkStateTracker = constraintTracker2;
        this.storageNotLowTracker = constraintTracker3;
    }

    public /* synthetic */ Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker constraintTracker, BatteryNotLowTracker batteryNotLowTracker, ConstraintTracker constraintTracker2, ConstraintTracker constraintTracker3, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            constraintTracker = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue((Object)constraintTracker, (String)"context.applicationContext");
            constraintTracker = new BatteryChargingTracker((Context)constraintTracker, taskExecutor);
        }
        if ((n & 8) != 0) {
            batteryNotLowTracker = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue((Object)batteryNotLowTracker, (String)"context.applicationContext");
            batteryNotLowTracker = new BatteryNotLowTracker((Context)batteryNotLowTracker, taskExecutor);
        }
        if ((n & 0x10) != 0) {
            constraintTracker2 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue((Object)constraintTracker2, (String)"context.applicationContext");
            constraintTracker2 = NetworkStateTrackerKt.NetworkStateTracker((Context)constraintTracker2, taskExecutor);
        }
        if ((n & 0x20) != 0) {
            constraintTracker3 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue((Object)constraintTracker3, (String)"context.applicationContext");
            constraintTracker3 = new StorageNotLowTracker((Context)constraintTracker3, taskExecutor);
        }
        this(context, taskExecutor, constraintTracker, batteryNotLowTracker, constraintTracker2, constraintTracker3);
    }

    public final ConstraintTracker<Boolean> getBatteryChargingTracker() {
        return this.batteryChargingTracker;
    }

    public final BatteryNotLowTracker getBatteryNotLowTracker() {
        return this.batteryNotLowTracker;
    }

    public final ConstraintTracker<NetworkState> getNetworkStateTracker() {
        return this.networkStateTracker;
    }

    public final ConstraintTracker<Boolean> getStorageNotLowTracker() {
        return this.storageNotLowTracker;
    }
}

