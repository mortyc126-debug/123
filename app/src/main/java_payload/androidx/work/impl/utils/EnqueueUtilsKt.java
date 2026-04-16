/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.utils;

import android.os.Build;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkRequest;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000\u001a\u001e\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u001e\u0010\u0012\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\n\u001a\u00020\tH\u0000\u00a8\u0006\u0013"}, d2={"checkContentUriTriggerWorkerLimits", "", "workDatabase", "Landroidx/work/impl/WorkDatabase;", "configuration", "Landroidx/work/Configuration;", "continuation", "Landroidx/work/impl/WorkContinuationImpl;", "tryDelegateConstrainedWorkSpec", "Landroidx/work/impl/model/WorkSpec;", "workSpec", "usesScheduler", "", "schedulers", "", "Landroidx/work/impl/Scheduler;", "className", "", "wrapInConstraintTrackingWorkerIfNeeded", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class EnqueueUtilsKt {
    public static final void checkContentUriTriggerWorkerLimits(WorkDatabase object, Configuration configuration2, WorkContinuationImpl object2) {
        int n;
        int n2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"workDatabase");
        Intrinsics.checkNotNullParameter((Object)configuration2, (String)"configuration");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"continuation");
        object2 = CollectionsKt.mutableListOf((Object[])new WorkContinuationImpl[]{object2});
        int n3 = 0;
        while (((Collection)object2).isEmpty() ^ true) {
            Object object3 = (WorkContinuationImpl)CollectionsKt.removeLast((List)object2);
            Object object4 = ((WorkContinuationImpl)object3).getWork();
            Intrinsics.checkNotNullExpressionValue(object4, (String)"current.work");
            object4 = (Iterable)object4;
            if (object4 instanceof Collection && ((Collection)object4).isEmpty()) {
                n2 = 0;
            } else {
                n2 = 0;
                object4 = object4.iterator();
                while (object4.hasNext()) {
                    if (!((WorkRequest)object4.next()).getWorkSpec().constraints.hasContentUriTriggers()) continue;
                    n2 = n = n2 + 1;
                    if (n >= 0) continue;
                    CollectionsKt.throwCountOverflow();
                    n2 = n;
                }
            }
            n3 += n2;
            if ((object3 = ((WorkContinuationImpl)object3).getParents()) == null) continue;
            object2.addAll((Collection)object3);
        }
        if (n3 == 0) {
            return;
        }
        n2 = ((WorkDatabase)object).workSpecDao().countNonFinishedContentUriTriggerWorkers();
        if (n2 + n3 <= (n = configuration2.getContentUriTriggerWorkersLimit())) {
            return;
        }
        object = new StringBuilder().append("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: ");
        object = ((StringBuilder)object).append(n);
        object = ((StringBuilder)object).append(";\nalready enqueued count: ");
        object = ((StringBuilder)object).append(n2);
        object = ((StringBuilder)object).append(";\ncurrent enqueue operation count: ");
        object = ((StringBuilder)object).append(n3);
        throw new IllegalArgumentException(((StringBuilder)object).append(".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed.").toString());
    }

    public static final WorkSpec tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter((Object)workSpec, (String)"workSpec");
        Object object = workSpec.constraints;
        Object object2 = workSpec.workerClassName;
        if (!Intrinsics.areEqual((Object)object2, (Object)ConstraintTrackingWorker.class.getName()) && (((Constraints)object).requiresBatteryNotLow() || ((Constraints)object).requiresStorageNotLow())) {
            object2 = new Data.Builder().putAll(workSpec.input).putString("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", (String)object2).build();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"Builder().putAll(workSpe\u2026ame)\n            .build()");
            object = ConstraintTrackingWorker.class.getName();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"name");
            return WorkSpec.copy$default(workSpec, null, null, (String)object, null, (Data)object2, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, 8388587, null);
        }
        return workSpec;
    }

    private static final boolean usesScheduler(List<? extends Scheduler> object, String object2) {
        boolean bl = false;
        try {
            object2 = Class.forName((String)object2);
            object = (Iterable)object;
            if (!(object instanceof Collection) || !((Collection)object).isEmpty()) {
                object = object.iterator();
                while (object.hasNext()) {
                    boolean bl2 = ((Class)object2).isAssignableFrom(((Scheduler)object.next()).getClass());
                    if (!bl2) continue;
                    bl = true;
                    break;
                }
            }
            return bl;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
    }

    public static final WorkSpec wrapInConstraintTrackingWorkerIfNeeded(List<? extends Scheduler> object, WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(object, (String)"schedulers");
        Intrinsics.checkNotNullParameter((Object)workSpec, (String)"workSpec");
        boolean bl = Build.VERSION.SDK_INT < 26;
        object = bl ? EnqueueUtilsKt.tryDelegateConstrainedWorkSpec(workSpec) : workSpec;
        return object;
    }
}

