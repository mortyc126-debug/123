/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work;

import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.DurationApi26Impl;
import java.time.Duration;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\r\b&\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\b8G\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u00020\u00058\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2={"Landroidx/work/WorkRequest;", "", "id", "Ljava/util/UUID;", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "tags", "", "", "(Ljava/util/UUID;Landroidx/work/impl/model/WorkSpec;Ljava/util/Set;)V", "getId", "()Ljava/util/UUID;", "stringId", "getStringId", "()Ljava/lang/String;", "getTags", "()Ljava/util/Set;", "getWorkSpec", "()Landroidx/work/impl/model/WorkSpec;", "Builder", "Companion", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class WorkRequest {
    public static final Companion Companion = new Companion(null);
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000L;
    public static final long MAX_BACKOFF_MILLIS = 18000000L;
    public static final long MIN_BACKOFF_MILLIS = 10000L;
    private final UUID id;
    private final Set<String> tags;
    private final WorkSpec workSpec;

    public WorkRequest(UUID uUID, WorkSpec workSpec, Set<String> set) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"id");
        Intrinsics.checkNotNullParameter((Object)workSpec, (String)"workSpec");
        Intrinsics.checkNotNullParameter(set, (String)"tags");
        this.id = uUID;
        this.workSpec = workSpec;
        this.tags = set;
    }

    public UUID getId() {
        return this.id;
    }

    public final String getStringId() {
        String string2 = this.getId().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"id.toString()");
        return string2;
    }

    public final Set<String> getTags() {
        return this.tags;
    }

    public final WorkSpec getWorkSpec() {
        return this.workSpec;
    }

    @Metadata(d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0012\b\u0000\u0010\u0001*\f\u0012\u0004\u0012\u0002H\u0001\u0012\u0002\b\u00030\u0000*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B\u0017\b\u0000\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0013\u0010%\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\u0017\u00a2\u0006\u0002\u0010'J\u000b\u0010(\u001a\u00028\u0001\u00a2\u0006\u0002\u0010)J\u000f\u0010*\u001a\u00028\u0001H \u00a2\u0006\u0004\b+\u0010)J\u0015\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u00020.H\u0007\u00a2\u0006\u0002\u0010/J\u001b\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u0002002\u0006\u00101\u001a\u000202\u00a2\u0006\u0002\u00103J\u001d\u00104\u001a\u00028\u00002\u0006\u00105\u001a\u0002062\u0006\u0010-\u001a\u00020.H\u0007\u00a2\u0006\u0002\u00107J#\u00104\u001a\u00028\u00002\u0006\u00105\u001a\u0002062\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u000202\u00a2\u0006\u0002\u00109J\u0013\u0010:\u001a\u00028\u00002\u0006\u0010;\u001a\u00020<\u00a2\u0006\u0002\u0010=J\u0015\u0010>\u001a\u00028\u00002\u0006\u0010?\u001a\u00020@H\u0017\u00a2\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010CJ\u0015\u0010D\u001a\u00028\u00002\u0006\u0010-\u001a\u00020.H\u0017\u00a2\u0006\u0002\u0010/J\u001d\u0010D\u001a\u00028\u00002\u0006\u0010-\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016\u00a2\u0006\u0002\u00103J\u0015\u0010E\u001a\u00028\u00002\u0006\u0010F\u001a\u00020GH\u0007\u00a2\u0006\u0002\u0010HJ\u0015\u0010I\u001a\u00028\u00002\u0006\u0010J\u001a\u00020KH\u0007\u00a2\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00028\u00002\u0006\u0010N\u001a\u00020O\u00a2\u0006\u0002\u0010PJ\u001d\u0010Q\u001a\u00028\u00002\u0006\u0010R\u001a\u0002002\u0006\u00101\u001a\u000202H\u0007\u00a2\u0006\u0002\u00103J\u001d\u0010S\u001a\u00028\u00002\u0006\u0010T\u001a\u0002002\u0006\u00101\u001a\u000202H\u0007\u00a2\u0006\u0002\u00103R\u001a\u0010\t\u001a\u00020\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00028\u0000X\u00a0\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u00a8\u0006U"}, d2={"Landroidx/work/WorkRequest$Builder;", "B", "W", "Landroidx/work/WorkRequest;", "", "workerClass", "Ljava/lang/Class;", "Landroidx/work/ListenableWorker;", "(Ljava/lang/Class;)V", "backoffCriteriaSet", "", "getBackoffCriteriaSet$work_runtime_release", "()Z", "setBackoffCriteriaSet$work_runtime_release", "(Z)V", "id", "Ljava/util/UUID;", "getId$work_runtime_release", "()Ljava/util/UUID;", "setId$work_runtime_release", "(Ljava/util/UUID;)V", "tags", "", "", "getTags$work_runtime_release", "()Ljava/util/Set;", "thisObject", "getThisObject$work_runtime_release", "()Landroidx/work/WorkRequest$Builder;", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "getWorkSpec$work_runtime_release", "()Landroidx/work/impl/model/WorkSpec;", "setWorkSpec$work_runtime_release", "(Landroidx/work/impl/model/WorkSpec;)V", "getWorkerClass$work_runtime_release", "()Ljava/lang/Class;", "addTag", "tag", "(Ljava/lang/String;)Landroidx/work/WorkRequest$Builder;", "build", "()Landroidx/work/WorkRequest;", "buildInternal", "buildInternal$work_runtime_release", "keepResultsForAtLeast", "duration", "Ljava/time/Duration;", "(Ljava/time/Duration;)Landroidx/work/WorkRequest$Builder;", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Landroidx/work/WorkRequest$Builder;", "setBackoffCriteria", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "(Landroidx/work/BackoffPolicy;Ljava/time/Duration;)Landroidx/work/WorkRequest$Builder;", "backoffDelay", "(Landroidx/work/BackoffPolicy;JLjava/util/concurrent/TimeUnit;)Landroidx/work/WorkRequest$Builder;", "setConstraints", "constraints", "Landroidx/work/Constraints;", "(Landroidx/work/Constraints;)Landroidx/work/WorkRequest$Builder;", "setExpedited", "policy", "Landroidx/work/OutOfQuotaPolicy;", "(Landroidx/work/OutOfQuotaPolicy;)Landroidx/work/WorkRequest$Builder;", "setId", "(Ljava/util/UUID;)Landroidx/work/WorkRequest$Builder;", "setInitialDelay", "setInitialRunAttemptCount", "runAttemptCount", "", "(I)Landroidx/work/WorkRequest$Builder;", "setInitialState", "state", "Landroidx/work/WorkInfo$State;", "(Landroidx/work/WorkInfo$State;)Landroidx/work/WorkRequest$Builder;", "setInputData", "inputData", "Landroidx/work/Data;", "(Landroidx/work/Data;)Landroidx/work/WorkRequest$Builder;", "setLastEnqueueTime", "lastEnqueueTime", "setScheduleRequestedAt", "scheduleRequestedAt", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static abstract class Builder<B extends Builder<B, ?>, W extends WorkRequest> {
        private boolean backoffCriteriaSet;
        private UUID id;
        private final Set<String> tags;
        private WorkSpec workSpec;
        private final Class<? extends ListenableWorker> workerClass;

        public Builder(Class<? extends ListenableWorker> object) {
            Intrinsics.checkNotNullParameter(object, (String)"workerClass");
            this.workerClass = object;
            object = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(object, (String)"randomUUID()");
            this.id = object;
            object = this.id.toString();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"id.toString()");
            String string2 = this.workerClass.getName();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"workerClass.name");
            this.workSpec = new WorkSpec((String)object, string2);
            object = this.workerClass.getName();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"workerClass.name");
            this.tags = SetsKt.mutableSetOf((Object[])new String[]{object});
        }

        public final B addTag(String string2) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"tag");
            this.tags.add(string2);
            return this.getThisObject$work_runtime_release();
        }

        public final W build() {
            W w = this.buildInternal$work_runtime_release();
            Object object = this.workSpec.constraints;
            boolean bl = ((Constraints)object).hasContentUriTriggers();
            boolean bl2 = false;
            boolean bl3 = bl || ((Constraints)object).requiresBatteryNotLow() || ((Constraints)object).requiresCharging() || ((Constraints)object).requiresDeviceIdle();
            if (this.workSpec.expedited) {
                if (bl3 = !bl3) {
                    bl3 = bl2;
                    if (this.workSpec.initialDelay <= 0L) {
                        bl3 = true;
                    }
                    if (!bl3) {
                        throw new IllegalArgumentException("Expedited jobs cannot be delayed".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints".toString());
                }
            }
            object = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"randomUUID()");
            this.setId((UUID)object);
            return w;
        }

        public abstract W buildInternal$work_runtime_release();

        public final boolean getBackoffCriteriaSet$work_runtime_release() {
            return this.backoffCriteriaSet;
        }

        public final UUID getId$work_runtime_release() {
            return this.id;
        }

        public final Set<String> getTags$work_runtime_release() {
            return this.tags;
        }

        public abstract B getThisObject$work_runtime_release();

        public final WorkSpec getWorkSpec$work_runtime_release() {
            return this.workSpec;
        }

        public final Class<? extends ListenableWorker> getWorkerClass$work_runtime_release() {
            return this.workerClass;
        }

        public final B keepResultsForAtLeast(long l, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"timeUnit");
            this.workSpec.minimumRetentionDuration = timeUnit.toMillis(l);
            return this.getThisObject$work_runtime_release();
        }

        public final B keepResultsForAtLeast(Duration duration) {
            Intrinsics.checkNotNullParameter((Object)duration, (String)"duration");
            this.workSpec.minimumRetentionDuration = DurationApi26Impl.toMillisCompat(duration);
            return this.getThisObject$work_runtime_release();
        }

        public final B setBackoffCriteria(BackoffPolicy backoffPolicy, long l, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter((Object)((Object)backoffPolicy), (String)"backoffPolicy");
            Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"timeUnit");
            this.backoffCriteriaSet = true;
            this.workSpec.backoffPolicy = backoffPolicy;
            this.workSpec.setBackoffDelayDuration(timeUnit.toMillis(l));
            return this.getThisObject$work_runtime_release();
        }

        public final B setBackoffCriteria(BackoffPolicy backoffPolicy, Duration duration) {
            Intrinsics.checkNotNullParameter((Object)((Object)backoffPolicy), (String)"backoffPolicy");
            Intrinsics.checkNotNullParameter((Object)duration, (String)"duration");
            this.backoffCriteriaSet = true;
            this.workSpec.backoffPolicy = backoffPolicy;
            this.workSpec.setBackoffDelayDuration(DurationApi26Impl.toMillisCompat(duration));
            return this.getThisObject$work_runtime_release();
        }

        public final void setBackoffCriteriaSet$work_runtime_release(boolean bl) {
            this.backoffCriteriaSet = bl;
        }

        public final B setConstraints(Constraints constraints) {
            Intrinsics.checkNotNullParameter((Object)constraints, (String)"constraints");
            this.workSpec.constraints = constraints;
            return this.getThisObject$work_runtime_release();
        }

        public B setExpedited(OutOfQuotaPolicy outOfQuotaPolicy) {
            Intrinsics.checkNotNullParameter((Object)((Object)outOfQuotaPolicy), (String)"policy");
            this.workSpec.expedited = true;
            this.workSpec.outOfQuotaPolicy = outOfQuotaPolicy;
            return this.getThisObject$work_runtime_release();
        }

        public final B setId(UUID object) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"id");
            this.id = object;
            object = ((UUID)object).toString();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"id.toString()");
            this.workSpec = new WorkSpec((String)object, this.workSpec);
            return this.getThisObject$work_runtime_release();
        }

        public final void setId$work_runtime_release(UUID uUID) {
            Intrinsics.checkNotNullParameter((Object)uUID, (String)"<set-?>");
            this.id = uUID;
        }

        public B setInitialDelay(long l, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"timeUnit");
            this.workSpec.initialDelay = timeUnit.toMillis(l);
            boolean bl = Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay;
            if (bl) {
                return this.getThisObject$work_runtime_release();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!".toString());
        }

        public B setInitialDelay(Duration duration) {
            Intrinsics.checkNotNullParameter((Object)duration, (String)"duration");
            this.workSpec.initialDelay = DurationApi26Impl.toMillisCompat(duration);
            boolean bl = Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay;
            if (bl) {
                return this.getThisObject$work_runtime_release();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!".toString());
        }

        public final B setInitialRunAttemptCount(int n) {
            this.workSpec.runAttemptCount = n;
            return this.getThisObject$work_runtime_release();
        }

        public final B setInitialState(WorkInfo.State state) {
            Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
            this.workSpec.state = state;
            return this.getThisObject$work_runtime_release();
        }

        public final B setInputData(Data data) {
            Intrinsics.checkNotNullParameter((Object)data, (String)"inputData");
            this.workSpec.input = data;
            return this.getThisObject$work_runtime_release();
        }

        public final B setLastEnqueueTime(long l, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"timeUnit");
            this.workSpec.lastEnqueueTime = timeUnit.toMillis(l);
            return this.getThisObject$work_runtime_release();
        }

        public final B setScheduleRequestedAt(long l, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"timeUnit");
            this.workSpec.scheduleRequestedAt = timeUnit.toMillis(l);
            return this.getThisObject$work_runtime_release();
        }

        public final void setWorkSpec$work_runtime_release(WorkSpec workSpec) {
            Intrinsics.checkNotNullParameter((Object)workSpec, (String)"<set-?>");
            this.workSpec = workSpec;
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Landroidx/work/WorkRequest$Companion;", "", "()V", "DEFAULT_BACKOFF_DELAY_MILLIS", "", "MAX_BACKOFF_MILLIS", "MIN_BACKOFF_MILLIS", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

