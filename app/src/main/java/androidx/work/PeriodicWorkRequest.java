/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work;

import androidx.work.ListenableWorker;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.DurationApi26Impl;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0002\u0005\u0006B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0007"}, d2={"Landroidx/work/PeriodicWorkRequest;", "Landroidx/work/WorkRequest;", "builder", "Landroidx/work/PeriodicWorkRequest$Builder;", "(Landroidx/work/PeriodicWorkRequest$Builder;)V", "Builder", "Companion", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class PeriodicWorkRequest
extends WorkRequest {
    public static final Companion Companion = new Companion(null);
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000L;
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000L;

    public PeriodicWorkRequest(Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super(builder.getId$work_runtime_release(), builder.getWorkSpec$work_runtime_release(), builder.getTags$work_runtime_release());
    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0016\u0012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nB\u001f\b\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fB9\b\u0016\u0012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000fB)\b\u0017\u0012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0010J\r\u0010\u0014\u001a\u00020\u0002H\u0010\u00a2\u0006\u0002\b\u0015J\u0006\u0010\u0016\u001a\u00020\u0000J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0007R\u0014\u0010\u0011\u001a\u00020\u00008PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2={"Landroidx/work/PeriodicWorkRequest$Builder;", "Landroidx/work/WorkRequest$Builder;", "Landroidx/work/PeriodicWorkRequest;", "workerClass", "Ljava/lang/Class;", "Landroidx/work/ListenableWorker;", "repeatInterval", "", "repeatIntervalTimeUnit", "Ljava/util/concurrent/TimeUnit;", "(Ljava/lang/Class;JLjava/util/concurrent/TimeUnit;)V", "Ljava/time/Duration;", "(Ljava/lang/Class;Ljava/time/Duration;)V", "flexInterval", "flexIntervalTimeUnit", "(Ljava/lang/Class;JLjava/util/concurrent/TimeUnit;JLjava/util/concurrent/TimeUnit;)V", "(Ljava/lang/Class;Ljava/time/Duration;Ljava/time/Duration;)V", "thisObject", "getThisObject$work_runtime_release", "()Landroidx/work/PeriodicWorkRequest$Builder;", "buildInternal", "buildInternal$work_runtime_release", "clearNextScheduleTimeOverride", "setNextScheduleTimeOverride", "nextScheduleTimeOverrideMillis", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Builder
    extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        public Builder(Class<? extends ListenableWorker> clazz, long l, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(clazz, (String)"workerClass");
            Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"repeatIntervalTimeUnit");
            super(clazz);
            this.getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(l));
        }

        public Builder(Class<? extends ListenableWorker> clazz, long l, TimeUnit timeUnit, long l2, TimeUnit timeUnit2) {
            Intrinsics.checkNotNullParameter(clazz, (String)"workerClass");
            Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"repeatIntervalTimeUnit");
            Intrinsics.checkNotNullParameter((Object)((Object)timeUnit2), (String)"flexIntervalTimeUnit");
            super(clazz);
            this.getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(l), timeUnit2.toMillis(l2));
        }

        public Builder(Class<? extends ListenableWorker> clazz, Duration duration) {
            Intrinsics.checkNotNullParameter(clazz, (String)"workerClass");
            Intrinsics.checkNotNullParameter((Object)duration, (String)"repeatInterval");
            super(clazz);
            this.getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration));
        }

        public Builder(Class<? extends ListenableWorker> clazz, Duration duration, Duration duration2) {
            Intrinsics.checkNotNullParameter(clazz, (String)"workerClass");
            Intrinsics.checkNotNullParameter((Object)duration, (String)"repeatInterval");
            Intrinsics.checkNotNullParameter((Object)duration2, (String)"flexInterval");
            super(clazz);
            this.getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration), DurationApi26Impl.toMillisCompat(duration2));
        }

        @Override
        public PeriodicWorkRequest buildInternal$work_runtime_release() {
            boolean bl = !this.getBackoffCriteriaSet$work_runtime_release() || !this.getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle();
            if (bl) {
                if (this.getWorkSpec$work_runtime_release().expedited ^ true) {
                    return new PeriodicWorkRequest(this);
                }
                throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited".toString());
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job".toString());
        }

        public final Builder clearNextScheduleTimeOverride() {
            this.getWorkSpec$work_runtime_release().setNextScheduleTimeOverride(Long.MAX_VALUE);
            this.getWorkSpec$work_runtime_release().setNextScheduleTimeOverrideGeneration(1);
            return this;
        }

        @Override
        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        public final Builder setNextScheduleTimeOverride(long l) {
            boolean bl = l != Long.MAX_VALUE;
            if (bl) {
                this.getWorkSpec$work_runtime_release().setNextScheduleTimeOverride(l);
                this.getWorkSpec$work_runtime_release().setNextScheduleTimeOverrideGeneration(1);
                return this;
            }
            throw new IllegalArgumentException("Cannot set Long.MAX_VALUE as the schedule override time".toString());
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Landroidx/work/PeriodicWorkRequest$Companion;", "", "()V", "MIN_PERIODIC_FLEX_MILLIS", "", "MIN_PERIODIC_INTERVAL_MILLIS", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

