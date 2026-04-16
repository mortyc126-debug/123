/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.IdGenerator$$ExternalSyntheticLambda0;
import androidx.work.impl.utils.IdGenerator$$ExternalSyntheticLambda1;
import androidx.work.impl.utils.IdGeneratorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Landroidx/work/impl/utils/IdGenerator;", "", "workDatabase", "Landroidx/work/impl/WorkDatabase;", "(Landroidx/work/impl/WorkDatabase;)V", "nextAlarmManagerId", "", "nextJobSchedulerIdWithRange", "minInclusive", "maxInclusive", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class IdGenerator {
    private final WorkDatabase workDatabase;

    public static /* synthetic */ Integer $r8$lambda$LyUC9fmKDw6AhARQq6V7VCdkafU(IdGenerator idGenerator, int n, int n2) {
        return IdGenerator.nextJobSchedulerIdWithRange$lambda$0(idGenerator, n, n2);
    }

    public static /* synthetic */ Integer $r8$lambda$fIl4yTd4RSvtLPTyoZbhi4q3Rnk(IdGenerator idGenerator) {
        return IdGenerator.nextAlarmManagerId$lambda$1(idGenerator);
    }

    public IdGenerator(WorkDatabase workDatabase) {
        Intrinsics.checkNotNullParameter((Object)workDatabase, (String)"workDatabase");
        this.workDatabase = workDatabase;
    }

    private static final Integer nextAlarmManagerId$lambda$1(IdGenerator idGenerator) {
        Intrinsics.checkNotNullParameter((Object)idGenerator, (String)"this$0");
        return IdGeneratorKt.access$nextId(idGenerator.workDatabase, "next_alarm_manager_id");
    }

    private static final Integer nextJobSchedulerIdWithRange$lambda$0(IdGenerator idGenerator, int n, int n2) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)idGenerator, (String)"this$0");
        int n3 = IdGeneratorKt.access$nextId(idGenerator.workDatabase, "next_job_scheduler_id");
        boolean bl2 = bl = false;
        if (n <= n3) {
            bl2 = bl;
            if (n3 <= n2) {
                bl2 = true;
            }
        }
        n2 = n3;
        if (!bl2) {
            IdGeneratorKt.access$updatePreference(idGenerator.workDatabase, "next_job_scheduler_id", n + 1);
            n2 = n;
        }
        return n2;
    }

    public final int nextAlarmManagerId() {
        Object v = this.workDatabase.runInTransaction(new IdGenerator$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(v, (String)"workDatabase.runInTransa\u2026ANAGER_ID_KEY)\n        })");
        return ((Number)v).intValue();
    }

    public final int nextJobSchedulerIdWithRange(int n, int n2) {
        Object v = this.workDatabase.runInTransaction(new IdGenerator$$ExternalSyntheticLambda1(this, n, n2));
        Intrinsics.checkNotNullExpressionValue(v, (String)"workDatabase.runInTransa\u2026            id\n        })");
        return ((Number)v).intValue();
    }
}

