/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkCapabilities
 *  android.net.NetworkInfo
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.constraints.trackers.NetworkStateTracker24;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi23;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\n*\u00020\u00048@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u0012"}, d2={"TAG", "", "activeNetworkState", "Landroidx/work/impl/constraints/NetworkState;", "Landroid/net/ConnectivityManager;", "getActiveNetworkState$annotations", "(Landroid/net/ConnectivityManager;)V", "getActiveNetworkState", "(Landroid/net/ConnectivityManager;)Landroidx/work/impl/constraints/NetworkState;", "isActiveNetworkValidated", "", "(Landroid/net/ConnectivityManager;)Z", "NetworkStateTracker", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class NetworkStateTrackerKt {
    private static final String TAG;

    static {
        String string2 = Logger.tagWithPrefix("NetworkStateTracker");
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"tagWithPrefix(\"NetworkStateTracker\")");
        TAG = string2;
    }

    public static final ConstraintTracker<NetworkState> NetworkStateTracker(Context context, TaskExecutor taskExecutor) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"taskExecutor");
        return new NetworkStateTracker24(context, taskExecutor);
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }

    public static final NetworkState getActiveNetworkState(ConnectivityManager connectivityManager) {
        Intrinsics.checkNotNullParameter((Object)connectivityManager, (String)"<this>");
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean bl = true;
        boolean bl2 = networkInfo != null && networkInfo.isConnected();
        boolean bl3 = NetworkStateTrackerKt.isActiveNetworkValidated(connectivityManager);
        boolean bl4 = ConnectivityManagerCompat.isActiveNetworkMetered(connectivityManager);
        if (networkInfo == null || networkInfo.isRoaming()) {
            bl = false;
        }
        return new NetworkState(bl2, bl3, bl4, bl);
    }

    public static /* synthetic */ void getActiveNetworkState$annotations(ConnectivityManager connectivityManager) {
    }

    public static final boolean isActiveNetworkValidated(ConnectivityManager connectivityManager) {
        boolean bl;
        block3: {
            Intrinsics.checkNotNullParameter((Object)connectivityManager, (String)"<this>");
            boolean bl2 = false;
            connectivityManager = NetworkApi21.getNetworkCapabilitiesCompat(connectivityManager, NetworkApi23.getActiveNetworkCompat(connectivityManager));
            bl = bl2;
            if (connectivityManager == null) break block3;
            try {
                bl = NetworkApi21.hasCapabilityCompat((NetworkCapabilities)connectivityManager, 16);
            }
            catch (SecurityException securityException) {
                Logger.get().error(TAG, "Unable to validate active network", securityException);
                bl = bl2;
            }
        }
        return bl;
    }
}

