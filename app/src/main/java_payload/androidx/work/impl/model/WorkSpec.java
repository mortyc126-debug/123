/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 */
package androidx.work.impl.model;

import androidx.arch.core.util.Function;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.OverwritingInputMerger;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 W2\u00020\u0001:\u0003WXYB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0000\u00a2\u0006\u0002\u0010\bB\u00e7\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0003\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020\u0017\u0012\b\b\u0002\u0010#\u001a\u00020\u0017\u0012\b\b\u0002\u0010$\u001a\u00020\u0011\u0012\b\b\u0002\u0010%\u001a\u00020\u0017\u0012\b\b\u0002\u0010&\u001a\u00020\u0017\u00a2\u0006\u0002\u0010'J\u0006\u00107\u001a\u00020\u0011J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\u0015H\u00c6\u0003J\t\u0010:\u001a\u00020\u0017H\u00c6\u0003J\t\u0010;\u001a\u00020\u0019H\u00c6\u0003J\t\u0010<\u001a\u00020\u0011H\u00c6\u0003J\t\u0010=\u001a\u00020\u0011H\u00c6\u0003J\t\u0010>\u001a\u00020\u0011H\u00c6\u0003J\t\u0010?\u001a\u00020\u0011H\u00c6\u0003J\t\u0010@\u001a\u00020\u001fH\u00c6\u0003J\t\u0010A\u001a\u00020!H\u00c6\u0003J\t\u0010B\u001a\u00020\u0017H\u00c6\u0003J\t\u0010C\u001a\u00020\nH\u00c6\u0003J\t\u0010D\u001a\u00020\u0017H\u00c6\u0003J\t\u0010E\u001a\u00020\u0011H\u00c6\u0003J\t\u0010F\u001a\u00020\u0017H\u00c6\u0003J\t\u0010G\u001a\u00020\u0017H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\u0003H\u00c6\u0003J\t\u0010J\u001a\u00020\u000eH\u00c6\u0003J\t\u0010K\u001a\u00020\u000eH\u00c6\u0003J\t\u0010L\u001a\u00020\u0011H\u00c6\u0003J\t\u0010M\u001a\u00020\u0011H\u00c6\u0003J\t\u0010N\u001a\u00020\u0011H\u00c6\u0003J\u00ef\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0003\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00172\b\b\u0002\u0010#\u001a\u00020\u00172\b\b\u0002\u0010$\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00172\b\b\u0002\u0010&\u001a\u00020\u0017H\u00c6\u0001J\u0013\u0010P\u001a\u00020\u001f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010Q\u001a\u00020\u001fJ\t\u0010R\u001a\u00020\u0017H\u00d6\u0001J\u000e\u0010S\u001a\u00020T2\u0006\u0010\u001a\u001a\u00020\u0011J\u000e\u0010U\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010U\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011J\b\u0010V\u001a\u00020\u0003H\u0016R\u0012\u0010\u001a\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u00020\u00178\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010+R\u0012\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u0010%\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010)\"\u0004\b2\u00103R\u0012\u0010 \u001a\u00020!8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010)\"\u0004\b5\u00103R\u0012\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010&\u001a\u00020\u00178\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010)R\u0012\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006Z"}, d2={"Landroidx/work/impl/model/WorkSpec;", "", "id", "", "workerClassName_", "(Ljava/lang/String;Ljava/lang/String;)V", "newId", "other", "(Ljava/lang/String;Landroidx/work/impl/model/WorkSpec;)V", "state", "Landroidx/work/WorkInfo$State;", "workerClassName", "inputMergerClassName", "input", "Landroidx/work/Data;", "output", "initialDelay", "", "intervalDuration", "flexDuration", "constraints", "Landroidx/work/Constraints;", "runAttemptCount", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "backoffDelayDuration", "lastEnqueueTime", "minimumRetentionDuration", "scheduleRequestedAt", "expedited", "", "outOfQuotaPolicy", "Landroidx/work/OutOfQuotaPolicy;", "periodCount", "generation", "nextScheduleTimeOverride", "nextScheduleTimeOverrideGeneration", "stopReason", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Ljava/lang/String;Ljava/lang/String;Landroidx/work/Data;Landroidx/work/Data;JJJLandroidx/work/Constraints;ILandroidx/work/BackoffPolicy;JJJJZLandroidx/work/OutOfQuotaPolicy;IIJII)V", "getGeneration", "()I", "isBackedOff", "()Z", "isPeriodic", "getNextScheduleTimeOverride", "()J", "setNextScheduleTimeOverride", "(J)V", "getNextScheduleTimeOverrideGeneration", "setNextScheduleTimeOverrideGeneration", "(I)V", "getPeriodCount", "setPeriodCount", "getStopReason", "calculateNextRunTime", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "hasConstraints", "hashCode", "setBackoffDelayDuration", "", "setPeriodic", "toString", "Companion", "IdAndState", "WorkInfoPojo", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class WorkSpec {
    public static final Companion Companion = new Companion(null);
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1L;
    private static final String TAG;
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER;
    public long backoffDelayDuration;
    public BackoffPolicy backoffPolicy;
    public Constraints constraints;
    public boolean expedited;
    public long flexDuration;
    private final int generation;
    public final String id;
    public long initialDelay;
    public Data input;
    public String inputMergerClassName;
    public long intervalDuration;
    public long lastEnqueueTime;
    public long minimumRetentionDuration;
    private long nextScheduleTimeOverride;
    private int nextScheduleTimeOverrideGeneration;
    public OutOfQuotaPolicy outOfQuotaPolicy;
    public Data output;
    private int periodCount;
    public int runAttemptCount;
    public long scheduleRequestedAt;
    public WorkInfo.State state;
    private final int stopReason;
    public String workerClassName;

    public static /* synthetic */ List $r8$lambda$y9atJMoLCgYQy678LpcIhQEVh6Q(List list) {
        return WorkSpec.WORK_INFO_MAPPER$lambda$1(list);
    }

    static {
        String string2 = Logger.tagWithPrefix("WorkSpec");
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"tagWithPrefix(\"WorkSpec\")");
        TAG = string2;
        WORK_INFO_MAPPER = new WorkSpec$$ExternalSyntheticLambda0();
    }

    public WorkSpec(String string2, WorkInfo.State state, String string3, String string4, Data data, Data data2, long l, long l2, long l3, Constraints constraints, int n, BackoffPolicy backoffPolicy, long l4, long l5, long l6, long l7, boolean bl, OutOfQuotaPolicy outOfQuotaPolicy, int n2, int n3, long l8, int n4, int n5) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"workerClassName");
        Intrinsics.checkNotNullParameter((Object)string4, (String)"inputMergerClassName");
        Intrinsics.checkNotNullParameter((Object)data, (String)"input");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"output");
        Intrinsics.checkNotNullParameter((Object)constraints, (String)"constraints");
        Intrinsics.checkNotNullParameter((Object)((Object)backoffPolicy), (String)"backoffPolicy");
        Intrinsics.checkNotNullParameter((Object)((Object)outOfQuotaPolicy), (String)"outOfQuotaPolicy");
        this.id = string2;
        this.state = state;
        this.workerClassName = string3;
        this.inputMergerClassName = string4;
        this.input = data;
        this.output = data2;
        this.initialDelay = l;
        this.intervalDuration = l2;
        this.flexDuration = l3;
        this.constraints = constraints;
        this.runAttemptCount = n;
        this.backoffPolicy = backoffPolicy;
        this.backoffDelayDuration = l4;
        this.lastEnqueueTime = l5;
        this.minimumRetentionDuration = l6;
        this.scheduleRequestedAt = l7;
        this.expedited = bl;
        this.outOfQuotaPolicy = outOfQuotaPolicy;
        this.periodCount = n2;
        this.generation = n3;
        this.nextScheduleTimeOverride = l8;
        this.nextScheduleTimeOverrideGeneration = n4;
        this.stopReason = n5;
    }

    public /* synthetic */ WorkSpec(String string2, WorkInfo.State state, String string3, String string4, Data data, Data data2, long l, long l2, long l3, Constraints constraints, int n, BackoffPolicy backoffPolicy, long l4, long l5, long l6, long l7, boolean bl, OutOfQuotaPolicy outOfQuotaPolicy, int n2, int n3, long l8, int n4, int n5, int n6, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n6 & 2) != 0) {
            state = WorkInfo.State.ENQUEUED;
        }
        if ((n6 & 8) != 0) {
            string4 = OverwritingInputMerger.class.getName();
            Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"OverwritingInputMerger::class.java.name");
        }
        if ((n6 & 0x10) != 0) {
            data = Data.EMPTY;
            Intrinsics.checkNotNullExpressionValue((Object)data, (String)"EMPTY");
        }
        if ((n6 & 0x20) != 0) {
            data2 = Data.EMPTY;
            Intrinsics.checkNotNullExpressionValue((Object)data2, (String)"EMPTY");
        }
        if ((n6 & 0x40) != 0) {
            l = 0L;
        }
        if ((n6 & 0x80) != 0) {
            l2 = 0L;
        }
        if ((n6 & 0x100) != 0) {
            l3 = 0L;
        }
        if ((n6 & 0x200) != 0) {
            constraints = Constraints.NONE;
        }
        if ((n6 & 0x400) != 0) {
            n = 0;
        }
        if ((n6 & 0x800) != 0) {
            backoffPolicy = BackoffPolicy.EXPONENTIAL;
        }
        if ((n6 & 0x1000) != 0) {
            l4 = 30000L;
        }
        if ((n6 & 0x2000) != 0) {
            l5 = -1L;
        }
        if ((n6 & 0x4000) != 0) {
            l6 = 0L;
        }
        if ((0x8000 & n6) != 0) {
            l7 = -1L;
        }
        if ((0x10000 & n6) != 0) {
            bl = false;
        }
        if ((0x20000 & n6) != 0) {
            outOfQuotaPolicy = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        }
        if ((0x40000 & n6) != 0) {
            n2 = 0;
        }
        if ((0x80000 & n6) != 0) {
            n3 = 0;
        }
        if ((0x100000 & n6) != 0) {
            l8 = Long.MAX_VALUE;
        }
        if ((0x200000 & n6) != 0) {
            n4 = 0;
        }
        if ((n6 & 0x400000) != 0) {
            n5 = -256;
        }
        this(string2, state, string3, string4, data, data2, l, l2, l3, constraints, n, backoffPolicy, l4, l5, l6, l7, bl, outOfQuotaPolicy, n2, n3, l8, n4, n5);
    }

    public WorkSpec(String string2, WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"newId");
        Intrinsics.checkNotNullParameter((Object)workSpec, (String)"other");
        String string3 = workSpec.workerClassName;
        WorkInfo.State state = workSpec.state;
        String string4 = workSpec.inputMergerClassName;
        Data data = new Data(workSpec.input);
        Data data2 = new Data(workSpec.output);
        long l = workSpec.initialDelay;
        long l2 = workSpec.intervalDuration;
        long l3 = workSpec.flexDuration;
        Constraints constraints = new Constraints(workSpec.constraints);
        int n = workSpec.runAttemptCount;
        BackoffPolicy backoffPolicy = workSpec.backoffPolicy;
        long l4 = workSpec.backoffDelayDuration;
        long l5 = workSpec.lastEnqueueTime;
        long l6 = workSpec.minimumRetentionDuration;
        long l7 = workSpec.scheduleRequestedAt;
        boolean bl = workSpec.expedited;
        OutOfQuotaPolicy outOfQuotaPolicy = workSpec.outOfQuotaPolicy;
        int n2 = workSpec.periodCount;
        long l8 = workSpec.nextScheduleTimeOverride;
        int n3 = workSpec.nextScheduleTimeOverrideGeneration;
        int n4 = workSpec.stopReason;
        this(string2, state, string3, string4, data, data2, l, l2, l3, constraints, n, backoffPolicy, l4, l5, l6, l7, bl, outOfQuotaPolicy, n2, 0, l8, n3, n4, 524288, null);
    }

    public WorkSpec(String string2, String string3) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"workerClassName_");
        this(string2, null, string3, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, 0x7FFFFA, null);
    }

    private static final List WORK_INFO_MAPPER$lambda$1(List collection) {
        if (collection != null) {
            Object object = collection;
            collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object, (int)10));
            object = object.iterator();
            while (object.hasNext()) {
                collection.add(((WorkInfoPojo)object.next()).toWorkInfo());
            }
        } else {
            collection = null;
        }
        return collection;
    }

    public static /* synthetic */ WorkSpec copy$default(WorkSpec workSpec, String string2, WorkInfo.State state, String string3, String string4, Data data, Data data2, long l, long l2, long l3, Constraints constraints, int n, BackoffPolicy backoffPolicy, long l4, long l5, long l6, long l7, boolean bl, OutOfQuotaPolicy outOfQuotaPolicy, int n2, int n3, long l8, int n4, int n5, int n6, Object object) {
        block22: {
            if ((n6 & 1) != 0) {
                string2 = workSpec.id;
            }
            if ((n6 & 2) != 0) {
                state = workSpec.state;
            }
            if ((n6 & 4) != 0) {
                string3 = workSpec.workerClassName;
            }
            if ((n6 & 8) != 0) {
                string4 = workSpec.inputMergerClassName;
            }
            if ((n6 & 0x10) != 0) {
                data = workSpec.input;
            }
            if ((n6 & 0x20) != 0) {
                data2 = workSpec.output;
            }
            if ((n6 & 0x40) != 0) {
                l = workSpec.initialDelay;
            }
            if ((n6 & 0x80) != 0) {
                l2 = workSpec.intervalDuration;
            }
            if ((n6 & 0x100) != 0) {
                l3 = workSpec.flexDuration;
            }
            if ((n6 & 0x200) != 0) {
                constraints = workSpec.constraints;
            }
            if ((n6 & 0x400) != 0) {
                n = workSpec.runAttemptCount;
            }
            if ((n6 & 0x800) != 0) {
                backoffPolicy = workSpec.backoffPolicy;
            }
            if ((n6 & 0x1000) != 0) {
                l4 = workSpec.backoffDelayDuration;
            }
            if ((n6 & 0x2000) != 0) {
                l5 = workSpec.lastEnqueueTime;
            }
            if ((n6 & 0x4000) != 0) {
                l6 = workSpec.minimumRetentionDuration;
            }
            if ((n6 & 0x8000) != 0) {
                l7 = workSpec.scheduleRequestedAt;
            }
            if ((n6 & 0x10000) != 0) {
                bl = workSpec.expedited;
            }
            if ((0x20000 & n6) != 0) {
                outOfQuotaPolicy = workSpec.outOfQuotaPolicy;
            }
            if ((n6 & 0x40000) != 0) {
                n2 = workSpec.periodCount;
            }
            if ((n6 & 0x80000) != 0) {
                n3 = workSpec.generation;
            }
            if ((n6 & 0x100000) != 0) {
                l8 = workSpec.nextScheduleTimeOverride;
            }
            if ((n6 & 0x200000) != 0) {
                n4 = workSpec.nextScheduleTimeOverrideGeneration;
            }
            if ((n6 & 0x400000) == 0) break block22;
            n5 = workSpec.stopReason;
        }
        return workSpec.copy(string2, state, string3, string4, data, data2, l, l2, l3, constraints, n, backoffPolicy, l4, l5, l6, l7, bl, outOfQuotaPolicy, n2, n3, l8, n4, n5);
    }

    public final long calculateNextRunTime() {
        return Companion.calculateNextRunTime(this.isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, this.isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
    }

    public final String component1() {
        return this.id;
    }

    public final Constraints component10() {
        return this.constraints;
    }

    public final int component11() {
        return this.runAttemptCount;
    }

    public final BackoffPolicy component12() {
        return this.backoffPolicy;
    }

    public final long component13() {
        return this.backoffDelayDuration;
    }

    public final long component14() {
        return this.lastEnqueueTime;
    }

    public final long component15() {
        return this.minimumRetentionDuration;
    }

    public final long component16() {
        return this.scheduleRequestedAt;
    }

    public final boolean component17() {
        return this.expedited;
    }

    public final OutOfQuotaPolicy component18() {
        return this.outOfQuotaPolicy;
    }

    public final int component19() {
        return this.periodCount;
    }

    public final WorkInfo.State component2() {
        return this.state;
    }

    public final int component20() {
        return this.generation;
    }

    public final long component21() {
        return this.nextScheduleTimeOverride;
    }

    public final int component22() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    public final int component23() {
        return this.stopReason;
    }

    public final String component3() {
        return this.workerClassName;
    }

    public final String component4() {
        return this.inputMergerClassName;
    }

    public final Data component5() {
        return this.input;
    }

    public final Data component6() {
        return this.output;
    }

    public final long component7() {
        return this.initialDelay;
    }

    public final long component8() {
        return this.intervalDuration;
    }

    public final long component9() {
        return this.flexDuration;
    }

    public final WorkSpec copy(String string2, WorkInfo.State state, String string3, String string4, Data data, Data data2, long l, long l2, long l3, Constraints constraints, int n, BackoffPolicy backoffPolicy, long l4, long l5, long l6, long l7, boolean bl, OutOfQuotaPolicy outOfQuotaPolicy, int n2, int n3, long l8, int n4, int n5) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"workerClassName");
        Intrinsics.checkNotNullParameter((Object)string4, (String)"inputMergerClassName");
        Intrinsics.checkNotNullParameter((Object)data, (String)"input");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"output");
        Intrinsics.checkNotNullParameter((Object)constraints, (String)"constraints");
        Intrinsics.checkNotNullParameter((Object)((Object)backoffPolicy), (String)"backoffPolicy");
        Intrinsics.checkNotNullParameter((Object)((Object)outOfQuotaPolicy), (String)"outOfQuotaPolicy");
        return new WorkSpec(string2, state, string3, string4, data, data2, l, l2, l3, constraints, n, backoffPolicy, l4, l5, l6, l7, bl, outOfQuotaPolicy, n2, n3, l8, n4, n5);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof WorkSpec)) {
            return false;
        }
        object = (WorkSpec)object;
        if (!Intrinsics.areEqual((Object)this.id, (Object)((WorkSpec)object).id)) {
            return false;
        }
        if (this.state != ((WorkSpec)object).state) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.workerClassName, (Object)((WorkSpec)object).workerClassName)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.inputMergerClassName, (Object)((WorkSpec)object).inputMergerClassName)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.input, (Object)((WorkSpec)object).input)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.output, (Object)((WorkSpec)object).output)) {
            return false;
        }
        if (this.initialDelay != ((WorkSpec)object).initialDelay) {
            return false;
        }
        if (this.intervalDuration != ((WorkSpec)object).intervalDuration) {
            return false;
        }
        if (this.flexDuration != ((WorkSpec)object).flexDuration) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.constraints, (Object)((WorkSpec)object).constraints)) {
            return false;
        }
        if (this.runAttemptCount != ((WorkSpec)object).runAttemptCount) {
            return false;
        }
        if (this.backoffPolicy != ((WorkSpec)object).backoffPolicy) {
            return false;
        }
        if (this.backoffDelayDuration != ((WorkSpec)object).backoffDelayDuration) {
            return false;
        }
        if (this.lastEnqueueTime != ((WorkSpec)object).lastEnqueueTime) {
            return false;
        }
        if (this.minimumRetentionDuration != ((WorkSpec)object).minimumRetentionDuration) {
            return false;
        }
        if (this.scheduleRequestedAt != ((WorkSpec)object).scheduleRequestedAt) {
            return false;
        }
        if (this.expedited != ((WorkSpec)object).expedited) {
            return false;
        }
        if (this.outOfQuotaPolicy != ((WorkSpec)object).outOfQuotaPolicy) {
            return false;
        }
        if (this.periodCount != ((WorkSpec)object).periodCount) {
            return false;
        }
        if (this.generation != ((WorkSpec)object).generation) {
            return false;
        }
        if (this.nextScheduleTimeOverride != ((WorkSpec)object).nextScheduleTimeOverride) {
            return false;
        }
        if (this.nextScheduleTimeOverrideGeneration != ((WorkSpec)object).nextScheduleTimeOverrideGeneration) {
            return false;
        }
        return this.stopReason == ((WorkSpec)object).stopReason;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final long getNextScheduleTimeOverride() {
        return this.nextScheduleTimeOverride;
    }

    public final int getNextScheduleTimeOverrideGeneration() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final int getStopReason() {
        return this.stopReason;
    }

    public final boolean hasConstraints() {
        return Intrinsics.areEqual((Object)Constraints.NONE, (Object)this.constraints) ^ true;
    }

    public int hashCode() {
        int n;
        int n2 = this.id.hashCode();
        int n3 = this.state.hashCode();
        int n4 = this.workerClassName.hashCode();
        int n5 = this.inputMergerClassName.hashCode();
        int n6 = this.input.hashCode();
        int n7 = this.output.hashCode();
        int n8 = Long.hashCode(this.initialDelay);
        int n9 = Long.hashCode(this.intervalDuration);
        int n10 = Long.hashCode(this.flexDuration);
        int n11 = this.constraints.hashCode();
        int n12 = Integer.hashCode(this.runAttemptCount);
        int n13 = this.backoffPolicy.hashCode();
        int n14 = Long.hashCode(this.backoffDelayDuration);
        int n15 = Long.hashCode(this.lastEnqueueTime);
        int n16 = Long.hashCode(this.minimumRetentionDuration);
        int n17 = Long.hashCode(this.scheduleRequestedAt);
        int n18 = n = this.expedited;
        if (n != 0) {
            n18 = 1;
        }
        return (((((((((((((((((((((n2 * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n9) * 31 + n10) * 31 + n11) * 31 + n12) * 31 + n13) * 31 + n14) * 31 + n15) * 31 + n16) * 31 + n17) * 31 + n18) * 31 + this.outOfQuotaPolicy.hashCode()) * 31 + Integer.hashCode(this.periodCount)) * 31 + Integer.hashCode(this.generation)) * 31 + Long.hashCode(this.nextScheduleTimeOverride)) * 31 + Integer.hashCode(this.nextScheduleTimeOverrideGeneration)) * 31 + Integer.hashCode(this.stopReason);
    }

    public final boolean isBackedOff() {
        boolean bl = this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
        return bl;
    }

    public final boolean isPeriodic() {
        boolean bl = this.intervalDuration != 0L;
        return bl;
    }

    public final void setBackoffDelayDuration(long l) {
        if (l > 18000000L) {
            Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value");
        }
        if (l < 10000L) {
            Logger.get().warning(TAG, "Backoff delay duration less than minimum value");
        }
        this.backoffDelayDuration = RangesKt.coerceIn((long)l, (long)10000L, (long)18000000L);
    }

    public final void setNextScheduleTimeOverride(long l) {
        this.nextScheduleTimeOverride = l;
    }

    public final void setNextScheduleTimeOverrideGeneration(int n) {
        this.nextScheduleTimeOverrideGeneration = n;
    }

    public final void setPeriodCount(int n) {
        this.periodCount = n;
    }

    public final void setPeriodic(long l) {
        if (l < 900000L) {
            Logger logger = Logger.get();
            String string2 = TAG;
            logger.warning(string2, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        this.setPeriodic(RangesKt.coerceAtLeast((long)l, (long)900000L), RangesKt.coerceAtLeast((long)l, (long)900000L));
    }

    public final void setPeriodic(long l, long l2) {
        String string2;
        Logger logger;
        if (l < 900000L) {
            logger = Logger.get();
            string2 = TAG;
            logger.warning(string2, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        this.intervalDuration = RangesKt.coerceAtLeast((long)l, (long)900000L);
        if (l2 < 300000L) {
            logger = Logger.get();
            string2 = TAG;
            logger.warning(string2, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (l2 > this.intervalDuration) {
            Logger.get().warning(TAG, "Flex duration greater than interval duration; Changed to " + l);
        }
        this.flexDuration = RangesKt.coerceIn((long)l2, (long)300000L, (long)this.intervalDuration);
    }

    public String toString() {
        return "{WorkSpec: " + this.id + '}';
    }

    @Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J^\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Landroidx/work/impl/model/WorkSpec$Companion;", "", "()V", "SCHEDULE_NOT_REQUESTED_YET", "", "TAG", "", "WORK_INFO_MAPPER", "Landroidx/arch/core/util/Function;", "", "Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "Landroidx/work/WorkInfo;", "calculateNextRunTime", "isBackedOff", "", "runAttemptCount", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "backoffDelayDuration", "lastEnqueueTime", "periodCount", "isPeriodic", "initialDelay", "flexDuration", "intervalDuration", "nextScheduleTimeOverride", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long calculateNextRunTime(boolean bl, int n, BackoffPolicy backoffPolicy, long l, long l2, int n2, boolean bl2, long l3, long l4, long l5, long l6) {
            Intrinsics.checkNotNullParameter((Object)((Object)backoffPolicy), (String)"backoffPolicy");
            long l7 = Long.MAX_VALUE;
            if (l6 != Long.MAX_VALUE && bl2) {
                l = n2 == 0 ? l6 : RangesKt.coerceAtLeast((long)l6, (long)(l2 + 900000L));
                return l;
            }
            int n3 = 0;
            int n4 = 0;
            if (bl) {
                n2 = n4;
                if (backoffPolicy == BackoffPolicy.LINEAR) {
                    n2 = 1;
                }
                l = n2 != 0 ? (long)n * l : (long)Math.scalb(l, n - 1);
                l = l2 + RangesKt.coerceAtMost((long)l, (long)18000000L);
            } else if (bl2) {
                l2 = n2 == 0 ? (l2 += l3) : (l2 += l5);
                n = n3;
                if (l4 != l5) {
                    n = 1;
                }
                l = l2;
                if (n != 0) {
                    l = l2;
                    if (n2 == 0) {
                        l = l2 + (l5 - l4);
                    }
                }
            } else {
                l = l2 == -1L ? l7 : l2 + l3;
            }
            return l;
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Landroidx/work/impl/model/WorkSpec$IdAndState;", "", "id", "", "state", "Landroidx/work/WorkInfo$State;", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class IdAndState {
        public String id;
        public WorkInfo.State state;

        public IdAndState(String string2, WorkInfo.State state) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"id");
            Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
            this.id = string2;
            this.state = state;
        }

        public static /* synthetic */ IdAndState copy$default(IdAndState idAndState, String string2, WorkInfo.State state, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = idAndState.id;
            }
            if ((n & 2) != 0) {
                state = idAndState.state;
            }
            return idAndState.copy(string2, state);
        }

        public final String component1() {
            return this.id;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final IdAndState copy(String string2, WorkInfo.State state) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"id");
            Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
            return new IdAndState(string2, state);
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof IdAndState)) {
                return false;
            }
            object = (IdAndState)object;
            if (!Intrinsics.areEqual((Object)this.id, (Object)((IdAndState)object).id)) {
                return false;
            }
            return this.state == ((IdAndState)object).state;
        }

        public int hashCode() {
            return this.id.hashCode() * 31 + this.state.hashCode();
        }

        public String toString() {
            return "IdAndState(id=" + this.id + ", state=" + (Object)((Object)this.state) + ')';
        }
    }

    @Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u00a7\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019\u00a2\u0006\u0002\u0010\u001bJ\b\u0010@\u001a\u00020\tH\u0002J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\tH\u00c6\u0003J\t\u0010C\u001a\u00020\tH\u00c6\u0003J\t\u0010D\u001a\u00020\u000fH\u00c6\u0003J\t\u0010E\u001a\u00020\u000fH\u00c6\u0003J\t\u0010F\u001a\u00020\tH\u00c6\u0003J\t\u0010G\u001a\u00020\u000fH\u00c6\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H\u00c6\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u00c6\u0003J\t\u0010J\u001a\u00020\u0005H\u00c6\u0003J\t\u0010K\u001a\u00020\u0007H\u00c6\u0003J\t\u0010L\u001a\u00020\tH\u00c6\u0003J\t\u0010M\u001a\u00020\tH\u00c6\u0003J\t\u0010N\u001a\u00020\tH\u00c6\u0003J\t\u0010O\u001a\u00020\rH\u00c6\u0003J\t\u0010P\u001a\u00020\u000fH\u00c6\u0003J\t\u0010Q\u001a\u00020\u0011H\u00c6\u0003J\u00bf\u0001\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u00c6\u0001J\u0013\u0010S\u001a\u00020.2\b\u0010T\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010U\u001a\u0004\u0018\u00010VH\u0002J\t\u0010W\u001a\u00020\u000fH\u00d6\u0001J\t\u0010X\u001a\u00020\u0003H\u00d6\u0001J\u0006\u0010Y\u001a\u00020ZR\u001e\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0016\u0010\u0015\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010-\u001a\u00020.8F\u00a2\u0006\u0006\u001a\u0004\b-\u0010/R\u0011\u00100\u001a\u00020.8F\u00a2\u0006\u0006\u001a\u0004\b0\u0010/R\u001e\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR\u0016\u0010\u0016\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001dR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001e\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010(\"\u0004\b7\u00108R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010(R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0016\u0010\u0017\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010(R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010:\u00a8\u0006["}, d2={"Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "", "id", "", "state", "Landroidx/work/WorkInfo$State;", "output", "Landroidx/work/Data;", "initialDelay", "", "intervalDuration", "flexDuration", "constraints", "Landroidx/work/Constraints;", "runAttemptCount", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "backoffDelayDuration", "lastEnqueueTime", "periodCount", "generation", "nextScheduleTimeOverride", "stopReason", "tags", "", "progress", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Landroidx/work/Data;JJJLandroidx/work/Constraints;ILandroidx/work/BackoffPolicy;JJIIJILjava/util/List;Ljava/util/List;)V", "getBackoffDelayDuration", "()J", "setBackoffDelayDuration", "(J)V", "getBackoffPolicy", "()Landroidx/work/BackoffPolicy;", "setBackoffPolicy", "(Landroidx/work/BackoffPolicy;)V", "getConstraints", "()Landroidx/work/Constraints;", "getFlexDuration", "getGeneration", "()I", "getId", "()Ljava/lang/String;", "getInitialDelay", "getIntervalDuration", "isBackedOff", "", "()Z", "isPeriodic", "getLastEnqueueTime", "setLastEnqueueTime", "getNextScheduleTimeOverride", "getOutput", "()Landroidx/work/Data;", "getPeriodCount", "setPeriodCount", "(I)V", "getProgress", "()Ljava/util/List;", "getRunAttemptCount", "getState", "()Landroidx/work/WorkInfo$State;", "getStopReason", "getTags", "calculateNextRunTimeMillis", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getPeriodicityOrNull", "Landroidx/work/WorkInfo$PeriodicityInfo;", "hashCode", "toString", "toWorkInfo", "Landroidx/work/WorkInfo;", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class WorkInfoPojo {
        private long backoffDelayDuration;
        private BackoffPolicy backoffPolicy;
        private final Constraints constraints;
        private final long flexDuration;
        private final int generation;
        private final String id;
        private final long initialDelay;
        private final long intervalDuration;
        private long lastEnqueueTime;
        private final long nextScheduleTimeOverride;
        private final Data output;
        private int periodCount;
        private final List<Data> progress;
        private final int runAttemptCount;
        private final WorkInfo.State state;
        private final int stopReason;
        private final List<String> tags;

        public WorkInfoPojo(String string2, WorkInfo.State state, Data data, long l, long l2, long l3, Constraints constraints, int n, BackoffPolicy backoffPolicy, long l4, long l5, int n2, int n3, long l6, int n4, List<String> list, List<Data> list2) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"id");
            Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
            Intrinsics.checkNotNullParameter((Object)data, (String)"output");
            Intrinsics.checkNotNullParameter((Object)constraints, (String)"constraints");
            Intrinsics.checkNotNullParameter((Object)((Object)backoffPolicy), (String)"backoffPolicy");
            Intrinsics.checkNotNullParameter(list, (String)"tags");
            Intrinsics.checkNotNullParameter(list2, (String)"progress");
            this.id = string2;
            this.state = state;
            this.output = data;
            this.initialDelay = l;
            this.intervalDuration = l2;
            this.flexDuration = l3;
            this.constraints = constraints;
            this.runAttemptCount = n;
            this.backoffPolicy = backoffPolicy;
            this.backoffDelayDuration = l4;
            this.lastEnqueueTime = l5;
            this.periodCount = n2;
            this.generation = n3;
            this.nextScheduleTimeOverride = l6;
            this.stopReason = n4;
            this.tags = list;
            this.progress = list2;
        }

        public /* synthetic */ WorkInfoPojo(String string2, WorkInfo.State state, Data data, long l, long l2, long l3, Constraints constraints, int n, BackoffPolicy backoffPolicy, long l4, long l5, int n2, int n3, long l6, int n4, List list, List list2, int n5, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n5 & 8) != 0) {
                l = 0L;
            }
            if ((n5 & 0x10) != 0) {
                l2 = 0L;
            }
            if ((n5 & 0x20) != 0) {
                l3 = 0L;
            }
            if ((n5 & 0x100) != 0) {
                backoffPolicy = BackoffPolicy.EXPONENTIAL;
            }
            if ((n5 & 0x200) != 0) {
                l4 = 30000L;
            }
            if ((n5 & 0x400) != 0) {
                l5 = 0L;
            }
            if ((n5 & 0x800) != 0) {
                n2 = 0;
            }
            this(string2, state, data, l, l2, l3, constraints, n, backoffPolicy, l4, l5, n2, n3, l6, n4, list, list2);
        }

        private final long calculateNextRunTimeMillis() {
            long l = this.state == WorkInfo.State.ENQUEUED ? Companion.calculateNextRunTime(this.isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, this.isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride) : Long.MAX_VALUE;
            return l;
        }

        public static /* synthetic */ WorkInfoPojo copy$default(WorkInfoPojo workInfoPojo, String string2, WorkInfo.State state, Data data, long l, long l2, long l3, Constraints constraints, int n, BackoffPolicy backoffPolicy, long l4, long l5, int n2, int n3, long l6, int n4, List list, List list2, int n5, Object object) {
            block16: {
                if ((n5 & 1) != 0) {
                    string2 = workInfoPojo.id;
                }
                if ((n5 & 2) != 0) {
                    state = workInfoPojo.state;
                }
                if ((n5 & 4) != 0) {
                    data = workInfoPojo.output;
                }
                if ((n5 & 8) != 0) {
                    l = workInfoPojo.initialDelay;
                }
                if ((n5 & 0x10) != 0) {
                    l2 = workInfoPojo.intervalDuration;
                }
                if ((n5 & 0x20) != 0) {
                    l3 = workInfoPojo.flexDuration;
                }
                if ((n5 & 0x40) != 0) {
                    constraints = workInfoPojo.constraints;
                }
                if ((n5 & 0x80) != 0) {
                    n = workInfoPojo.runAttemptCount;
                }
                if ((n5 & 0x100) != 0) {
                    backoffPolicy = workInfoPojo.backoffPolicy;
                }
                if ((n5 & 0x200) != 0) {
                    l4 = workInfoPojo.backoffDelayDuration;
                }
                if ((n5 & 0x400) != 0) {
                    l5 = workInfoPojo.lastEnqueueTime;
                }
                if ((n5 & 0x800) != 0) {
                    n2 = workInfoPojo.periodCount;
                }
                if ((n5 & 0x1000) != 0) {
                    n3 = workInfoPojo.generation;
                }
                if ((n5 & 0x2000) != 0) {
                    l6 = workInfoPojo.nextScheduleTimeOverride;
                }
                if ((n5 & 0x4000) != 0) {
                    n4 = workInfoPojo.stopReason;
                }
                if ((0x8000 & n5) != 0) {
                    list = workInfoPojo.tags;
                }
                if ((n5 & 0x10000) == 0) break block16;
                list2 = workInfoPojo.progress;
            }
            return workInfoPojo.copy(string2, state, data, l, l2, l3, constraints, n, backoffPolicy, l4, l5, n2, n3, l6, n4, list, list2);
        }

        private final WorkInfo.PeriodicityInfo getPeriodicityOrNull() {
            WorkInfo.PeriodicityInfo periodicityInfo = this.intervalDuration != 0L ? new WorkInfo.PeriodicityInfo(this.intervalDuration, this.flexDuration) : null;
            return periodicityInfo;
        }

        public final String component1() {
            return this.id;
        }

        public final long component10() {
            return this.backoffDelayDuration;
        }

        public final long component11() {
            return this.lastEnqueueTime;
        }

        public final int component12() {
            return this.periodCount;
        }

        public final int component13() {
            return this.generation;
        }

        public final long component14() {
            return this.nextScheduleTimeOverride;
        }

        public final int component15() {
            return this.stopReason;
        }

        public final List<String> component16() {
            return this.tags;
        }

        public final List<Data> component17() {
            return this.progress;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final Data component3() {
            return this.output;
        }

        public final long component4() {
            return this.initialDelay;
        }

        public final long component5() {
            return this.intervalDuration;
        }

        public final long component6() {
            return this.flexDuration;
        }

        public final Constraints component7() {
            return this.constraints;
        }

        public final int component8() {
            return this.runAttemptCount;
        }

        public final BackoffPolicy component9() {
            return this.backoffPolicy;
        }

        public final WorkInfoPojo copy(String string2, WorkInfo.State state, Data data, long l, long l2, long l3, Constraints constraints, int n, BackoffPolicy backoffPolicy, long l4, long l5, int n2, int n3, long l6, int n4, List<String> list, List<Data> list2) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"id");
            Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
            Intrinsics.checkNotNullParameter((Object)data, (String)"output");
            Intrinsics.checkNotNullParameter((Object)constraints, (String)"constraints");
            Intrinsics.checkNotNullParameter((Object)((Object)backoffPolicy), (String)"backoffPolicy");
            Intrinsics.checkNotNullParameter(list, (String)"tags");
            Intrinsics.checkNotNullParameter(list2, (String)"progress");
            return new WorkInfoPojo(string2, state, data, l, l2, l3, constraints, n, backoffPolicy, l4, l5, n2, n3, l6, n4, list, list2);
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof WorkInfoPojo)) {
                return false;
            }
            object = (WorkInfoPojo)object;
            if (!Intrinsics.areEqual((Object)this.id, (Object)((WorkInfoPojo)object).id)) {
                return false;
            }
            if (this.state != ((WorkInfoPojo)object).state) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.output, (Object)((WorkInfoPojo)object).output)) {
                return false;
            }
            if (this.initialDelay != ((WorkInfoPojo)object).initialDelay) {
                return false;
            }
            if (this.intervalDuration != ((WorkInfoPojo)object).intervalDuration) {
                return false;
            }
            if (this.flexDuration != ((WorkInfoPojo)object).flexDuration) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.constraints, (Object)((WorkInfoPojo)object).constraints)) {
                return false;
            }
            if (this.runAttemptCount != ((WorkInfoPojo)object).runAttemptCount) {
                return false;
            }
            if (this.backoffPolicy != ((WorkInfoPojo)object).backoffPolicy) {
                return false;
            }
            if (this.backoffDelayDuration != ((WorkInfoPojo)object).backoffDelayDuration) {
                return false;
            }
            if (this.lastEnqueueTime != ((WorkInfoPojo)object).lastEnqueueTime) {
                return false;
            }
            if (this.periodCount != ((WorkInfoPojo)object).periodCount) {
                return false;
            }
            if (this.generation != ((WorkInfoPojo)object).generation) {
                return false;
            }
            if (this.nextScheduleTimeOverride != ((WorkInfoPojo)object).nextScheduleTimeOverride) {
                return false;
            }
            if (this.stopReason != ((WorkInfoPojo)object).stopReason) {
                return false;
            }
            if (!Intrinsics.areEqual(this.tags, ((WorkInfoPojo)object).tags)) {
                return false;
            }
            return Intrinsics.areEqual(this.progress, ((WorkInfoPojo)object).progress);
        }

        public final long getBackoffDelayDuration() {
            return this.backoffDelayDuration;
        }

        public final BackoffPolicy getBackoffPolicy() {
            return this.backoffPolicy;
        }

        public final Constraints getConstraints() {
            return this.constraints;
        }

        public final long getFlexDuration() {
            return this.flexDuration;
        }

        public final int getGeneration() {
            return this.generation;
        }

        public final String getId() {
            return this.id;
        }

        public final long getInitialDelay() {
            return this.initialDelay;
        }

        public final long getIntervalDuration() {
            return this.intervalDuration;
        }

        public final long getLastEnqueueTime() {
            return this.lastEnqueueTime;
        }

        public final long getNextScheduleTimeOverride() {
            return this.nextScheduleTimeOverride;
        }

        public final Data getOutput() {
            return this.output;
        }

        public final int getPeriodCount() {
            return this.periodCount;
        }

        public final List<Data> getProgress() {
            return this.progress;
        }

        public final int getRunAttemptCount() {
            return this.runAttemptCount;
        }

        public final WorkInfo.State getState() {
            return this.state;
        }

        public final int getStopReason() {
            return this.stopReason;
        }

        public final List<String> getTags() {
            return this.tags;
        }

        public int hashCode() {
            return (((((((((((((((this.id.hashCode() * 31 + this.state.hashCode()) * 31 + this.output.hashCode()) * 31 + Long.hashCode(this.initialDelay)) * 31 + Long.hashCode(this.intervalDuration)) * 31 + Long.hashCode(this.flexDuration)) * 31 + this.constraints.hashCode()) * 31 + Integer.hashCode(this.runAttemptCount)) * 31 + this.backoffPolicy.hashCode()) * 31 + Long.hashCode(this.backoffDelayDuration)) * 31 + Long.hashCode(this.lastEnqueueTime)) * 31 + Integer.hashCode(this.periodCount)) * 31 + Integer.hashCode(this.generation)) * 31 + Long.hashCode(this.nextScheduleTimeOverride)) * 31 + Integer.hashCode(this.stopReason)) * 31 + ((Object)this.tags).hashCode()) * 31 + ((Object)this.progress).hashCode();
        }

        public final boolean isBackedOff() {
            boolean bl = this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
            return bl;
        }

        public final boolean isPeriodic() {
            boolean bl = this.intervalDuration != 0L;
            return bl;
        }

        public final void setBackoffDelayDuration(long l) {
            this.backoffDelayDuration = l;
        }

        public final void setBackoffPolicy(BackoffPolicy backoffPolicy) {
            Intrinsics.checkNotNullParameter((Object)((Object)backoffPolicy), (String)"<set-?>");
            this.backoffPolicy = backoffPolicy;
        }

        public final void setLastEnqueueTime(long l) {
            this.lastEnqueueTime = l;
        }

        public final void setPeriodCount(int n) {
            this.periodCount = n;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("WorkInfoPojo(id=").append(this.id).append(", state=").append((Object)this.state).append(", output=").append(this.output).append(", initialDelay=").append(this.initialDelay).append(", intervalDuration=").append(this.intervalDuration).append(", flexDuration=").append(this.flexDuration).append(", constraints=").append(this.constraints).append(", runAttemptCount=").append(this.runAttemptCount).append(", backoffPolicy=").append((Object)this.backoffPolicy).append(", backoffDelayDuration=").append(this.backoffDelayDuration).append(", lastEnqueueTime=").append(this.lastEnqueueTime).append(", periodCount=");
            stringBuilder.append(this.periodCount).append(", generation=").append(this.generation).append(", nextScheduleTimeOverride=").append(this.nextScheduleTimeOverride).append(", stopReason=").append(this.stopReason).append(", tags=").append(this.tags).append(", progress=").append(this.progress).append(')');
            return stringBuilder.toString();
        }

        public final WorkInfo toWorkInfo() {
            Data data = ((Collection)this.progress).isEmpty() ^ true ? this.progress.get(0) : Data.EMPTY;
            UUID uUID = UUID.fromString(this.id);
            Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"fromString(id)");
            WorkInfo.State state = this.state;
            Set set = new HashSet(this.tags);
            Data data2 = this.output;
            Intrinsics.checkNotNullExpressionValue((Object)data, (String)"progress");
            return new WorkInfo(uUID, state, set, data2, data, this.runAttemptCount, this.generation, this.constraints, this.initialDelay, this.getPeriodicityOrNull(), this.calculateNextRunTimeMillis(), this.stopReason);
        }
    }
}

