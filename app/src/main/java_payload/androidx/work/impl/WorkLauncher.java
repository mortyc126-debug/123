/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl;

import androidx.work.WorkerParameters;
import androidx.work.impl.StartStopToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\f\u00c0\u0006\u0001"}, d2={"Landroidx/work/impl/WorkLauncher;", "", "startWork", "", "workSpecId", "Landroidx/work/impl/StartStopToken;", "runtimeExtras", "Landroidx/work/WorkerParameters$RuntimeExtras;", "stopWork", "reason", "", "stopWorkWithReason", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public interface WorkLauncher {
    default public void startWork(StartStopToken startStopToken) {
        Intrinsics.checkNotNullParameter((Object)startStopToken, (String)"workSpecId");
        this.startWork(startStopToken, null);
    }

    public void startWork(StartStopToken var1, WorkerParameters.RuntimeExtras var2);

    default public void stopWork(StartStopToken startStopToken) {
        Intrinsics.checkNotNullParameter((Object)startStopToken, (String)"workSpecId");
        this.stopWork(startStopToken, -512);
    }

    public void stopWork(StartStopToken var1, int var2);

    default public void stopWorkWithReason(StartStopToken startStopToken, int n) {
        Intrinsics.checkNotNullParameter((Object)startStopToken, (String)"workSpecId");
        this.stopWork(startStopToken, n);
    }
}

