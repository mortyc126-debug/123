/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.Network
 *  android.net.NetworkCapabilities
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.constraints.trackers.NetworkStateTracker24;
import androidx.work.impl.constraints.trackers.NetworkStateTrackerKt;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi24;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\f\u00a8\u0006\u0011"}, d2={"Landroidx/work/impl/constraints/trackers/NetworkStateTracker24;", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "Landroidx/work/impl/constraints/NetworkState;", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "networkCallback", "androidx/work/impl/constraints/trackers/NetworkStateTracker24$networkCallback$1", "Landroidx/work/impl/constraints/trackers/NetworkStateTracker24$networkCallback$1;", "readSystemState", "startTracking", "", "stopTracking", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class NetworkStateTracker24
extends ConstraintTracker<NetworkState> {
    private final ConnectivityManager connectivityManager;
    private final networkCallback.1 networkCallback;

    public NetworkStateTracker24(Context object, TaskExecutor taskExecutor) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"context");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"taskExecutor");
        super((Context)object, taskExecutor);
        object = this.getAppContext().getSystemService("connectivity");
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager)object;
        this.networkCallback = new ConnectivityManager.NetworkCallback(this){
            final NetworkStateTracker24 this$0;
            {
                this.this$0 = networkStateTracker24;
            }

            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                Intrinsics.checkNotNullParameter((Object)network, (String)"network");
                Intrinsics.checkNotNullParameter((Object)networkCapabilities, (String)"capabilities");
                Logger.get().debug(NetworkStateTrackerKt.access$getTAG$p(), "Network capabilities changed: " + networkCapabilities);
                this.this$0.setState(NetworkStateTrackerKt.getActiveNetworkState(NetworkStateTracker24.access$getConnectivityManager$p(this.this$0)));
            }

            public void onLost(Network network) {
                Intrinsics.checkNotNullParameter((Object)network, (String)"network");
                Logger.get().debug(NetworkStateTrackerKt.access$getTAG$p(), "Network connection lost");
                this.this$0.setState(NetworkStateTrackerKt.getActiveNetworkState(NetworkStateTracker24.access$getConnectivityManager$p(this.this$0)));
            }
        };
    }

    public static final /* synthetic */ ConnectivityManager access$getConnectivityManager$p(NetworkStateTracker24 networkStateTracker24) {
        return networkStateTracker24.connectivityManager;
    }

    @Override
    public NetworkState readSystemState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }

    @Override
    public void startTracking() {
        try {
            Logger.get().debug(NetworkStateTrackerKt.access$getTAG$p(), "Registering network callback");
            NetworkApi24.registerDefaultNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        }
        catch (SecurityException securityException) {
            Logger.get().error(NetworkStateTrackerKt.access$getTAG$p(), "Received exception while registering network callback", securityException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            Logger.get().error(NetworkStateTrackerKt.access$getTAG$p(), "Received exception while registering network callback", illegalArgumentException);
        }
    }

    @Override
    public void stopTracking() {
        try {
            Logger.get().debug(NetworkStateTrackerKt.access$getTAG$p(), "Unregistering network callback");
            NetworkApi21.unregisterNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        }
        catch (SecurityException securityException) {
            Logger.get().error(NetworkStateTrackerKt.access$getTAG$p(), "Received exception while unregistering network callback", securityException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            Logger.get().error(NetworkStateTrackerKt.access$getTAG$p(), "Received exception while unregistering network callback", illegalArgumentException);
        }
    }
}

