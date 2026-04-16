/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.constraints.controllers;

import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2={"Landroidx/work/impl/constraints/controllers/NetworkNotRoamingController;", "Landroidx/work/impl/constraints/controllers/ConstraintController;", "Landroidx/work/impl/constraints/NetworkState;", "tracker", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "(Landroidx/work/impl/constraints/trackers/ConstraintTracker;)V", "reason", "", "getReason", "()I", "hasConstraint", "", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "isConstrained", "value", "Companion", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class NetworkNotRoamingController
extends ConstraintController<NetworkState> {
    public static final Companion Companion = new Companion(null);
    private static final String TAG;
    private final int reason;

    static {
        String string2 = Logger.tagWithPrefix("NetworkNotRoamingCtrlr");
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"tagWithPrefix(\"NetworkNotRoamingCtrlr\")");
        TAG = string2;
    }

    public NetworkNotRoamingController(ConstraintTracker<NetworkState> constraintTracker) {
        Intrinsics.checkNotNullParameter(constraintTracker, (String)"tracker");
        super(constraintTracker);
        this.reason = 7;
    }

    @Override
    public int getReason() {
        return this.reason;
    }

    @Override
    public boolean hasConstraint(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter((Object)workSpec, (String)"workSpec");
        boolean bl = workSpec.constraints.getRequiredNetworkType() == NetworkType.NOT_ROAMING;
        return bl;
    }

    @Override
    public boolean isConstrained(NetworkState networkState) {
        Intrinsics.checkNotNullParameter((Object)networkState, (String)"value");
        boolean bl = !networkState.isConnected() || !networkState.isNotRoaming();
        return bl;
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Landroidx/work/impl/constraints/controllers/NetworkNotRoamingController$Companion;", "", "()V", "TAG", "", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

