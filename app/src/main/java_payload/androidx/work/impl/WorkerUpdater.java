/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.ListenableFuture
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl;

import androidx.work.Configuration;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerUpdater;
import androidx.work.impl.WorkerUpdater$$ExternalSyntheticLambda0;
import androidx.work.impl.WorkerUpdater$$ExternalSyntheticLambda1;
import androidx.work.impl.WorkerUpdater$$ExternalSyntheticLambda2;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.EnqueueRunnable;
import androidx.work.impl.utils.EnqueueUtilsKt;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007\u001a\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fH\u0002\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u00a8\u0006\u001b"}, d2={"updateWorkImpl", "Landroidx/work/WorkManager$UpdateResult;", "processor", "Landroidx/work/impl/Processor;", "workDatabase", "Landroidx/work/impl/WorkDatabase;", "configuration", "Landroidx/work/Configuration;", "schedulers", "", "Landroidx/work/impl/Scheduler;", "newWorkSpec", "Landroidx/work/impl/model/WorkSpec;", "tags", "", "", "enqueueUniquelyNamedPeriodic", "Landroidx/work/Operation;", "Landroidx/work/impl/WorkManagerImpl;", "name", "workRequest", "Landroidx/work/WorkRequest;", "failWorkTypeChanged", "", "Landroidx/work/impl/OperationImpl;", "message", "Lcom/google/common/util/concurrent/ListenableFuture;", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class WorkerUpdater {
    public static /* synthetic */ void $r8$lambda$N89sN1A-Ft8Xw-BLJ76ILDUlQ9k(WorkManagerImpl workManagerImpl, String string2, OperationImpl operationImpl, Function0 function0, WorkRequest workRequest) {
        WorkerUpdater.enqueueUniquelyNamedPeriodic$lambda$4(workManagerImpl, string2, operationImpl, function0, workRequest);
    }

    public static /* synthetic */ void $r8$lambda$h_JOXj0UWFYj1IJe7Eauuc0RSNw(SettableFuture settableFuture, WorkManagerImpl workManagerImpl, WorkRequest workRequest) {
        WorkerUpdater.updateWorkImpl$lambda$3(settableFuture, workManagerImpl, workRequest);
    }

    public static /* synthetic */ void $r8$lambda$rZYaIXP2nyFPAV1cj7a66zI-7Hs(WorkDatabase workDatabase, WorkSpec workSpec, WorkSpec workSpec2, List list, String string2, Set set, boolean bl) {
        WorkerUpdater.updateWorkImpl$lambda$2(workDatabase, workSpec, workSpec2, list, string2, set, bl);
    }

    public static final Operation enqueueUniquelyNamedPeriodic(WorkManagerImpl workManagerImpl, String string2, WorkRequest workRequest) {
        Intrinsics.checkNotNullParameter((Object)workManagerImpl, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        Intrinsics.checkNotNullParameter((Object)workRequest, (String)"workRequest");
        OperationImpl operationImpl = new OperationImpl();
        Function0 function0 = (Function0)new Function0<Unit>(workRequest, workManagerImpl, string2, operationImpl){
            final String $name;
            final OperationImpl $operation;
            final WorkManagerImpl $this_enqueueUniquelyNamedPeriodic;
            final WorkRequest $workRequest;
            {
                this.$workRequest = workRequest;
                this.$this_enqueueUniquelyNamedPeriodic = workManagerImpl;
                this.$name = string2;
                this.$operation = operationImpl;
                super(0);
            }

            public final void invoke() {
                List list = CollectionsKt.listOf((Object)this.$workRequest);
                new EnqueueRunnable(new WorkContinuationImpl(this.$this_enqueueUniquelyNamedPeriodic, this.$name, ExistingWorkPolicy.KEEP, list), this.$operation).run();
            }
        };
        workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor().execute(new WorkerUpdater$$ExternalSyntheticLambda2(workManagerImpl, string2, operationImpl, function0, workRequest));
        return operationImpl;
    }

    private static final void enqueueUniquelyNamedPeriodic$lambda$4(WorkManagerImpl list, String object, OperationImpl operationImpl, Function0 object2, WorkRequest workRequest) {
        Intrinsics.checkNotNullParameter((Object)list, (String)"$this_enqueueUniquelyNamedPeriodic");
        Intrinsics.checkNotNullParameter((Object)object, (String)"$name");
        Intrinsics.checkNotNullParameter((Object)operationImpl, (String)"$operation");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"$enqueueNew");
        Intrinsics.checkNotNullParameter((Object)workRequest, (String)"$workRequest");
        Object object3 = ((WorkManagerImpl)((Object)list)).getWorkDatabase().workSpecDao();
        Object object4 = object3.getWorkSpecIdAndStatesForName((String)object);
        if (object4.size() > 1) {
            WorkerUpdater.failWorkTypeChanged(operationImpl, "Can't apply UPDATE policy to the chains of work.");
            return;
        }
        WorkSpec.IdAndState idAndState = (WorkSpec.IdAndState)CollectionsKt.firstOrNull(object4);
        if (idAndState == null) {
            object2.invoke();
            return;
        }
        object4 = object3.getWorkSpec(idAndState.id);
        if (object4 == null) {
            list = new StringBuilder().append("WorkSpec with ").append(idAndState.id).append(", that matches a name \"");
            list = ((StringBuilder)((Object)list)).append((String)object);
            operationImpl.markState(new Operation.State.FAILURE(new IllegalStateException(((StringBuilder)((Object)list)).append("\", wasn't found").toString())));
            return;
        }
        if (!((WorkSpec)object4).isPeriodic()) {
            WorkerUpdater.failWorkTypeChanged(operationImpl, "Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.");
            return;
        }
        if (idAndState.state == WorkInfo.State.CANCELLED) {
            object3.delete(idAndState.id);
            object2.invoke();
            return;
        }
        object2 = WorkSpec.copy$default(workRequest.getWorkSpec(), idAndState.id, null, null, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, 0x7FFFFE, null);
        try {
            object3 = ((WorkManagerImpl)((Object)list)).getProcessor();
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"processor");
            object = ((WorkManagerImpl)((Object)list)).getWorkDatabase();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"workDatabase");
            object4 = ((WorkManagerImpl)((Object)list)).getConfiguration();
            Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"configuration");
            list = ((WorkManagerImpl)((Object)list)).getSchedulers();
            Intrinsics.checkNotNullExpressionValue(list, (String)"schedulers");
            WorkerUpdater.updateWorkImpl((Processor)object3, (WorkDatabase)object, (Configuration)object4, list, (WorkSpec)object2, workRequest.getTags());
            operationImpl.markState(Operation.SUCCESS);
        }
        catch (Throwable throwable) {
            operationImpl.markState(new Operation.State.FAILURE(throwable));
        }
    }

    private static final void failWorkTypeChanged(OperationImpl operationImpl, String string2) {
        operationImpl.markState(new Operation.State.FAILURE(new UnsupportedOperationException(string2)));
    }

    private static final WorkManager.UpdateResult updateWorkImpl(Processor object, WorkDatabase workDatabase, Configuration configuration2, List<? extends Scheduler> list, WorkSpec workSpec, Set<String> set) {
        String string2 = workSpec.id;
        WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(string2);
        if (workSpec2 != null) {
            if (workSpec2.state.isFinished()) {
                return WorkManager.UpdateResult.NOT_APPLIED;
            }
            if (!(workSpec2.isPeriodic() ^ workSpec.isPeriodic())) {
                boolean bl = ((Processor)object).isEnqueued(string2);
                if (!bl) {
                    object = ((Iterable)list).iterator();
                    while (object.hasNext()) {
                        ((Scheduler)object.next()).cancel(string2);
                    }
                }
                workDatabase.runInTransaction(new WorkerUpdater$$ExternalSyntheticLambda0(workDatabase, workSpec2, workSpec, list, string2, set, bl));
                if (!bl) {
                    Schedulers.schedule(configuration2, workDatabase, list);
                }
                object = bl ? WorkManager.UpdateResult.APPLIED_FOR_NEXT_RUN : WorkManager.UpdateResult.APPLIED_IMMEDIATELY;
                return object;
            }
            object = updateWorkImpl.type.1.INSTANCE;
            throw new UnsupportedOperationException("Can't update " + (String)object.invoke((Object)workSpec2) + " Worker to " + (String)object.invoke((Object)workSpec) + " Worker. Update operation must preserve worker's type.");
        }
        throw new IllegalArgumentException("Worker with " + string2 + " doesn't exist");
    }

    public static final ListenableFuture<WorkManager.UpdateResult> updateWorkImpl(WorkManagerImpl workManagerImpl, WorkRequest workRequest) {
        Intrinsics.checkNotNullParameter((Object)workManagerImpl, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)workRequest, (String)"workRequest");
        SettableFuture settableFuture = SettableFuture.create();
        workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor().execute(new WorkerUpdater$$ExternalSyntheticLambda1(settableFuture, workManagerImpl, workRequest));
        Intrinsics.checkNotNullExpressionValue(settableFuture, (String)"future");
        return settableFuture;
    }

    private static final void updateWorkImpl$lambda$2(WorkDatabase workDatabase, WorkSpec workSpec, WorkSpec workSpec2, List list, String string2, Set set, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)workDatabase, (String)"$workDatabase");
        Intrinsics.checkNotNullParameter((Object)workSpec, (String)"$oldWorkSpec");
        Intrinsics.checkNotNullParameter((Object)workSpec2, (String)"$newWorkSpec");
        Intrinsics.checkNotNullParameter((Object)list, (String)"$schedulers");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"$workSpecId");
        Intrinsics.checkNotNullParameter((Object)set, (String)"$tags");
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkTagDao workTagDao = workDatabase.workTagDao();
        WorkInfo.State state = workSpec.state;
        int n = workSpec.runAttemptCount;
        long l = workSpec.lastEnqueueTime;
        int n2 = workSpec.getGeneration();
        int n3 = workSpec.getPeriodCount();
        long l2 = workSpec.getNextScheduleTimeOverride();
        int n4 = workSpec.getNextScheduleTimeOverrideGeneration();
        workSpec = WorkSpec.copy$default(workSpec2, null, state, null, null, null, null, 0L, 0L, 0L, null, n, null, 0L, l, 0L, 0L, false, null, n3, n2 + 1, l2, n4, 0, 4447229, null);
        if (workSpec2.getNextScheduleTimeOverrideGeneration() == 1) {
            workSpec.setNextScheduleTimeOverride(workSpec2.getNextScheduleTimeOverride());
            workSpec.setNextScheduleTimeOverrideGeneration(workSpec.getNextScheduleTimeOverrideGeneration() + 1);
        }
        workSpecDao.updateWorkSpec(EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(list, workSpec));
        workTagDao.deleteByWorkSpecId(string2);
        workTagDao.insertTags(string2, set);
        if (!bl) {
            workSpecDao.markWorkSpecScheduled(string2, -1L);
            workDatabase.workProgressDao().delete(string2);
        }
    }

    private static final void updateWorkImpl$lambda$3(SettableFuture settableFuture, WorkManagerImpl object, WorkRequest workRequest) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this_updateWorkImpl");
        Intrinsics.checkNotNullParameter((Object)workRequest, (String)"$workRequest");
        if (settableFuture.isCancelled()) {
            return;
        }
        try {
            Processor processor = ((WorkManagerImpl)object).getProcessor();
            Intrinsics.checkNotNullExpressionValue((Object)processor, (String)"processor");
            WorkDatabase workDatabase = ((WorkManagerImpl)object).getWorkDatabase();
            Intrinsics.checkNotNullExpressionValue((Object)workDatabase, (String)"workDatabase");
            Configuration configuration2 = ((WorkManagerImpl)object).getConfiguration();
            Intrinsics.checkNotNullExpressionValue((Object)configuration2, (String)"configuration");
            object = ((WorkManagerImpl)object).getSchedulers();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"schedulers");
            settableFuture.set(WorkerUpdater.updateWorkImpl(processor, workDatabase, configuration2, (List<? extends Scheduler>)object, workRequest.getWorkSpec(), workRequest.getTags()));
        }
        catch (Throwable throwable) {
            settableFuture.setException(throwable);
        }
    }
}

