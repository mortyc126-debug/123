/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work;

import androidx.work.Constraints;
import androidx.work.Data;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u0003123B\u0081\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u00a2\u0006\u0002\u0010\u0017J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010/\u001a\u00020\rH\u0016J\b\u00100\u001a\u00020\bH\u0016R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0013\u0010\f\u001a\u00020\r8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0016\u001a\u00020\r8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+\u00a8\u00064"}, d2={"Landroidx/work/WorkInfo;", "", "id", "Ljava/util/UUID;", "state", "Landroidx/work/WorkInfo$State;", "tags", "", "", "outputData", "Landroidx/work/Data;", "progress", "runAttemptCount", "", "generation", "constraints", "Landroidx/work/Constraints;", "initialDelayMillis", "", "periodicityInfo", "Landroidx/work/WorkInfo$PeriodicityInfo;", "nextScheduleTimeMillis", "stopReason", "(Ljava/util/UUID;Landroidx/work/WorkInfo$State;Ljava/util/Set;Landroidx/work/Data;Landroidx/work/Data;IILandroidx/work/Constraints;JLandroidx/work/WorkInfo$PeriodicityInfo;JI)V", "getConstraints", "()Landroidx/work/Constraints;", "getGeneration", "()I", "getId", "()Ljava/util/UUID;", "getInitialDelayMillis", "()J", "getNextScheduleTimeMillis", "getOutputData", "()Landroidx/work/Data;", "getPeriodicityInfo", "()Landroidx/work/WorkInfo$PeriodicityInfo;", "getProgress", "getRunAttemptCount", "getState", "()Landroidx/work/WorkInfo$State;", "getStopReason", "getTags", "()Ljava/util/Set;", "equals", "", "other", "hashCode", "toString", "Companion", "PeriodicityInfo", "State", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class WorkInfo {
    public static final Companion Companion = new Companion(null);
    public static final int STOP_REASON_APP_STANDBY = 12;
    public static final int STOP_REASON_BACKGROUND_RESTRICTION = 11;
    public static final int STOP_REASON_CANCELLED_BY_APP = 1;
    public static final int STOP_REASON_CONSTRAINT_BATTERY_NOT_LOW = 5;
    public static final int STOP_REASON_CONSTRAINT_CHARGING = 6;
    public static final int STOP_REASON_CONSTRAINT_CONNECTIVITY = 7;
    public static final int STOP_REASON_CONSTRAINT_DEVICE_IDLE = 8;
    public static final int STOP_REASON_CONSTRAINT_STORAGE_NOT_LOW = 9;
    public static final int STOP_REASON_DEVICE_STATE = 4;
    public static final int STOP_REASON_ESTIMATED_APP_LAUNCH_TIME_CHANGED = 15;
    public static final int STOP_REASON_NOT_STOPPED = -256;
    public static final int STOP_REASON_PREEMPT = 2;
    public static final int STOP_REASON_QUOTA = 10;
    public static final int STOP_REASON_SYSTEM_PROCESSING = 14;
    public static final int STOP_REASON_TIMEOUT = 3;
    public static final int STOP_REASON_UNKNOWN = -512;
    public static final int STOP_REASON_USER = 13;
    private final Constraints constraints;
    private final int generation;
    private final UUID id;
    private final long initialDelayMillis;
    private final long nextScheduleTimeMillis;
    private final Data outputData;
    private final PeriodicityInfo periodicityInfo;
    private final Data progress;
    private final int runAttemptCount;
    private final State state;
    private final int stopReason;
    private final Set<String> tags;

    public WorkInfo(UUID uUID, State state, Set<String> set) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"id");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        Intrinsics.checkNotNullParameter(set, (String)"tags");
        this(uUID, state, set, null, null, 0, 0, null, 0L, null, 0L, 0, 4088, null);
    }

    public WorkInfo(UUID uUID, State state, Set<String> set, Data data) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"id");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        Intrinsics.checkNotNullParameter(set, (String)"tags");
        Intrinsics.checkNotNullParameter((Object)data, (String)"outputData");
        this(uUID, state, set, data, null, 0, 0, null, 0L, null, 0L, 0, 4080, null);
    }

    public WorkInfo(UUID uUID, State state, Set<String> set, Data data, Data data2) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"id");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        Intrinsics.checkNotNullParameter(set, (String)"tags");
        Intrinsics.checkNotNullParameter((Object)data, (String)"outputData");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"progress");
        this(uUID, state, set, data, data2, 0, 0, null, 0L, null, 0L, 0, 4064, null);
    }

    public WorkInfo(UUID uUID, State state, Set<String> set, Data data, Data data2, int n) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"id");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        Intrinsics.checkNotNullParameter(set, (String)"tags");
        Intrinsics.checkNotNullParameter((Object)data, (String)"outputData");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"progress");
        this(uUID, state, set, data, data2, n, 0, null, 0L, null, 0L, 0, 4032, null);
    }

    public WorkInfo(UUID uUID, State state, Set<String> set, Data data, Data data2, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"id");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        Intrinsics.checkNotNullParameter(set, (String)"tags");
        Intrinsics.checkNotNullParameter((Object)data, (String)"outputData");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"progress");
        this(uUID, state, set, data, data2, n, n2, null, 0L, null, 0L, 0, 3968, null);
    }

    public WorkInfo(UUID uUID, State state, Set<String> set, Data data, Data data2, int n, int n2, Constraints constraints) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"id");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        Intrinsics.checkNotNullParameter(set, (String)"tags");
        Intrinsics.checkNotNullParameter((Object)data, (String)"outputData");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"progress");
        Intrinsics.checkNotNullParameter((Object)constraints, (String)"constraints");
        this(uUID, state, set, data, data2, n, n2, constraints, 0L, null, 0L, 0, 3840, null);
    }

    public WorkInfo(UUID uUID, State state, Set<String> set, Data data, Data data2, int n, int n2, Constraints constraints, long l) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"id");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        Intrinsics.checkNotNullParameter(set, (String)"tags");
        Intrinsics.checkNotNullParameter((Object)data, (String)"outputData");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"progress");
        Intrinsics.checkNotNullParameter((Object)constraints, (String)"constraints");
        this(uUID, state, set, data, data2, n, n2, constraints, l, null, 0L, 0, 3584, null);
    }

    public WorkInfo(UUID uUID, State state, Set<String> set, Data data, Data data2, int n, int n2, Constraints constraints, long l, PeriodicityInfo periodicityInfo) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"id");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        Intrinsics.checkNotNullParameter(set, (String)"tags");
        Intrinsics.checkNotNullParameter((Object)data, (String)"outputData");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"progress");
        Intrinsics.checkNotNullParameter((Object)constraints, (String)"constraints");
        this(uUID, state, set, data, data2, n, n2, constraints, l, periodicityInfo, 0L, 0, 3072, null);
    }

    public WorkInfo(UUID uUID, State state, Set<String> set, Data data, Data data2, int n, int n2, Constraints constraints, long l, PeriodicityInfo periodicityInfo, long l2) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"id");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        Intrinsics.checkNotNullParameter(set, (String)"tags");
        Intrinsics.checkNotNullParameter((Object)data, (String)"outputData");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"progress");
        Intrinsics.checkNotNullParameter((Object)constraints, (String)"constraints");
        this(uUID, state, set, data, data2, n, n2, constraints, l, periodicityInfo, l2, 0, 2048, null);
    }

    public WorkInfo(UUID uUID, State state, Set<String> set, Data data, Data data2, int n, int n2, Constraints constraints, long l, PeriodicityInfo periodicityInfo, long l2, int n3) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"id");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        Intrinsics.checkNotNullParameter(set, (String)"tags");
        Intrinsics.checkNotNullParameter((Object)data, (String)"outputData");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"progress");
        Intrinsics.checkNotNullParameter((Object)constraints, (String)"constraints");
        this.id = uUID;
        this.state = state;
        this.tags = set;
        this.outputData = data;
        this.progress = data2;
        this.runAttemptCount = n;
        this.generation = n2;
        this.constraints = constraints;
        this.initialDelayMillis = l;
        this.periodicityInfo = periodicityInfo;
        this.nextScheduleTimeMillis = l2;
        this.stopReason = n3;
    }

    public /* synthetic */ WorkInfo(UUID uUID, State state, Set set, Data data, Data data2, int n, int n2, Constraints constraints, long l, PeriodicityInfo periodicityInfo, long l2, int n3, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 8) != 0) {
            data = Data.EMPTY;
            Intrinsics.checkNotNullExpressionValue((Object)data, (String)"EMPTY");
        }
        if ((n4 & 0x10) != 0) {
            data2 = Data.EMPTY;
            Intrinsics.checkNotNullExpressionValue((Object)data2, (String)"EMPTY");
        }
        if ((n4 & 0x20) != 0) {
            n = 0;
        }
        if ((n4 & 0x40) != 0) {
            n2 = 0;
        }
        if ((n4 & 0x80) != 0) {
            constraints = Constraints.NONE;
        }
        if ((n4 & 0x100) != 0) {
            l = 0L;
        }
        if ((n4 & 0x200) != 0) {
            periodicityInfo = null;
        }
        if ((n4 & 0x400) != 0) {
            l2 = Long.MAX_VALUE;
        }
        if ((n4 & 0x800) != 0) {
            n3 = -256;
        }
        this(uUID, state, set, data, data2, n, n2, constraints, l, periodicityInfo, l2, n3);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl = false;
        if (object != null && Intrinsics.areEqual(this.getClass(), object.getClass())) {
            object = (WorkInfo)object;
            if (this.runAttemptCount != ((WorkInfo)object).runAttemptCount) {
                return false;
            }
            if (this.generation != ((WorkInfo)object).generation) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.id, (Object)((WorkInfo)object).id)) {
                return false;
            }
            if (this.state != ((WorkInfo)object).state) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.outputData, (Object)((WorkInfo)object).outputData)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.constraints, (Object)((WorkInfo)object).constraints)) {
                return false;
            }
            if (this.initialDelayMillis != ((WorkInfo)object).initialDelayMillis) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.periodicityInfo, (Object)((WorkInfo)object).periodicityInfo)) {
                return false;
            }
            if (this.nextScheduleTimeMillis != ((WorkInfo)object).nextScheduleTimeMillis) {
                return false;
            }
            if (this.stopReason != ((WorkInfo)object).stopReason) {
                return false;
            }
            if (Intrinsics.areEqual(this.tags, ((WorkInfo)object).tags)) {
                bl = Intrinsics.areEqual((Object)this.progress, (Object)((WorkInfo)object).progress);
            }
            return bl;
        }
        return false;
    }

    public final Constraints getConstraints() {
        return this.constraints;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final UUID getId() {
        return this.id;
    }

    public final long getInitialDelayMillis() {
        return this.initialDelayMillis;
    }

    public final long getNextScheduleTimeMillis() {
        return this.nextScheduleTimeMillis;
    }

    public final Data getOutputData() {
        return this.outputData;
    }

    public final PeriodicityInfo getPeriodicityInfo() {
        return this.periodicityInfo;
    }

    public final Data getProgress() {
        return this.progress;
    }

    public final int getRunAttemptCount() {
        return this.runAttemptCount;
    }

    public final State getState() {
        return this.state;
    }

    public final int getStopReason() {
        return this.stopReason;
    }

    public final Set<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int n = this.id.hashCode();
        int n2 = this.state.hashCode();
        int n3 = this.outputData.hashCode();
        int n4 = ((Object)this.tags).hashCode();
        int n5 = this.progress.hashCode();
        int n6 = this.runAttemptCount;
        int n7 = this.generation;
        int n8 = this.constraints.hashCode();
        int n9 = Long.hashCode(this.initialDelayMillis);
        PeriodicityInfo periodicityInfo = this.periodicityInfo;
        int n10 = periodicityInfo != null ? ((Object)periodicityInfo).hashCode() : 0;
        return ((((((((((n * 31 + n2) * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n9) * 31 + n10) * 31 + Long.hashCode(this.nextScheduleTimeMillis)) * 31 + Integer.hashCode(this.stopReason);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = stringBuilder.append("WorkInfo{id='").append(this.id).append("', state=").append((Object)this.state).append(", outputData=").append(this.outputData);
        stringBuilder2 = stringBuilder2.append(", tags=").append(this.tags);
        stringBuilder2 = stringBuilder2.append(", progress=").append(this.progress);
        stringBuilder2 = stringBuilder2.append(", runAttemptCount=").append(this.runAttemptCount);
        stringBuilder2 = stringBuilder2.append(", generation=").append(this.generation);
        stringBuilder2 = stringBuilder2.append(", constraints=").append(this.constraints);
        stringBuilder2 = stringBuilder2.append(", initialDelayMillis=").append(this.initialDelayMillis);
        stringBuilder2 = stringBuilder2.append(", periodicityInfo=").append(this.periodicityInfo);
        stringBuilder2 = stringBuilder2.append(", nextScheduleTimeMillis=").append(this.nextScheduleTimeMillis);
        stringBuilder2.append("}, stopReason=");
        stringBuilder.append(this.stopReason);
        return stringBuilder.toString();
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Landroidx/work/WorkInfo$Companion;", "", "()V", "STOP_REASON_APP_STANDBY", "", "STOP_REASON_BACKGROUND_RESTRICTION", "STOP_REASON_CANCELLED_BY_APP", "STOP_REASON_CONSTRAINT_BATTERY_NOT_LOW", "STOP_REASON_CONSTRAINT_CHARGING", "STOP_REASON_CONSTRAINT_CONNECTIVITY", "STOP_REASON_CONSTRAINT_DEVICE_IDLE", "STOP_REASON_CONSTRAINT_STORAGE_NOT_LOW", "STOP_REASON_DEVICE_STATE", "STOP_REASON_ESTIMATED_APP_LAUNCH_TIME_CHANGED", "STOP_REASON_NOT_STOPPED", "STOP_REASON_PREEMPT", "STOP_REASON_QUOTA", "STOP_REASON_SYSTEM_PROCESSING", "STOP_REASON_TIMEOUT", "STOP_REASON_UNKNOWN", "STOP_REASON_USER", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0010"}, d2={"Landroidx/work/WorkInfo$PeriodicityInfo;", "", "repeatIntervalMillis", "", "flexIntervalMillis", "(JJ)V", "getFlexIntervalMillis", "()J", "getRepeatIntervalMillis", "equals", "", "other", "hashCode", "", "toString", "", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class PeriodicityInfo {
        private final long flexIntervalMillis;
        private final long repeatIntervalMillis;

        public PeriodicityInfo(long l, long l2) {
            this.repeatIntervalMillis = l;
            this.flexIntervalMillis = l2;
        }

        public boolean equals(Object object) {
            boolean bl = true;
            if (this == object) {
                return true;
            }
            if (object != null && Intrinsics.areEqual(this.getClass(), object.getClass())) {
                object = (PeriodicityInfo)object;
                if (((PeriodicityInfo)object).repeatIntervalMillis != this.repeatIntervalMillis || ((PeriodicityInfo)object).flexIntervalMillis != this.flexIntervalMillis) {
                    bl = false;
                }
                return bl;
            }
            return false;
        }

        public final long getFlexIntervalMillis() {
            return this.flexIntervalMillis;
        }

        public final long getRepeatIntervalMillis() {
            return this.repeatIntervalMillis;
        }

        public int hashCode() {
            return Long.hashCode(this.repeatIntervalMillis) * 31 + Long.hashCode(this.flexIntervalMillis);
        }

        public String toString() {
            return "PeriodicityInfo{repeatIntervalMillis=" + this.repeatIntervalMillis + ", flexIntervalMillis=" + this.flexIntervalMillis + '}';
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Landroidx/work/WorkInfo$State;", "", "(Ljava/lang/String;I)V", "isFinished", "", "()Z", "ENQUEUED", "RUNNING", "SUCCEEDED", "FAILED", "BLOCKED", "CANCELLED", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;


        public final boolean isFinished() {
            boolean bl = this == SUCCEEDED || this == FAILED || this == CANCELLED;
            return bl;
        }
    }
}

