/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work;

import androidx.work.ListenableWorker;
import androidx.work.PeriodicWorkRequest;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0087\b\u001a%\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\b\u001a%\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086\b\u001a5\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0086\b\u00a8\u0006\u000b"}, d2={"PeriodicWorkRequestBuilder", "Landroidx/work/PeriodicWorkRequest$Builder;", "W", "Landroidx/work/ListenableWorker;", "repeatInterval", "Ljava/time/Duration;", "flexTimeInterval", "", "repeatIntervalTimeUnit", "Ljava/util/concurrent/TimeUnit;", "flexTimeIntervalUnit", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class PeriodicWorkRequestKt {
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long l, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"repeatIntervalTimeUnit");
        Intrinsics.reifiedOperationMarker((int)4, (String)"W");
        Class<ListenableWorker> clazz = ListenableWorker.class;
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, l, timeUnit);
    }

    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long l, TimeUnit timeUnit, long l2, TimeUnit timeUnit2) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"repeatIntervalTimeUnit");
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit2), (String)"flexTimeIntervalUnit");
        Intrinsics.reifiedOperationMarker((int)4, (String)"W");
        Class<ListenableWorker> clazz = ListenableWorker.class;
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, l, timeUnit, l2, timeUnit2);
    }

    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration duration) {
        Intrinsics.checkNotNullParameter((Object)duration, (String)"repeatInterval");
        Intrinsics.reifiedOperationMarker((int)4, (String)"W");
        Class<ListenableWorker> clazz = ListenableWorker.class;
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, duration);
    }

    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration duration, Duration duration2) {
        Intrinsics.checkNotNullParameter((Object)duration, (String)"repeatInterval");
        Intrinsics.checkNotNullParameter((Object)duration2, (String)"flexTimeInterval");
        Intrinsics.reifiedOperationMarker((int)4, (String)"W");
        Class<ListenableWorker> clazz = ListenableWorker.class;
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, duration, duration2);
    }
}

