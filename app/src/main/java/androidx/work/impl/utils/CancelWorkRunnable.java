/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.utils;

import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PreferenceUtils;
import java.util.AbstractCollection;
import java.util.LinkedList;
import java.util.UUID;

public abstract class CancelWorkRunnable
implements Runnable {
    private final OperationImpl mOperation = new OperationImpl();

    public static CancelWorkRunnable forAll(WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable(workManagerImpl){
            final WorkManagerImpl val$workManagerImpl;
            {
                this.val$workManagerImpl = workManagerImpl;
            }

            @Override
            void runInternal() {
                WorkDatabase workDatabase = this.val$workManagerImpl.getWorkDatabase();
                workDatabase.beginTransaction();
                try {
                    for (String object2 : workDatabase.workSpecDao().getAllUnfinishedWork()) {
                        this.cancel(this.val$workManagerImpl, object2);
                    }
                    PreferenceUtils preferenceUtils = new PreferenceUtils(this.val$workManagerImpl.getWorkDatabase());
                    preferenceUtils.setLastCancelAllTimeMillis(this.val$workManagerImpl.getConfiguration().getClock().currentTimeMillis());
                    workDatabase.setTransactionSuccessful();
                    return;
                }
                finally {
                    workDatabase.endTransaction();
                }
            }
        };
    }

    public static CancelWorkRunnable forId(UUID uUID, WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable(workManagerImpl, uUID){
            final UUID val$id;
            final WorkManagerImpl val$workManagerImpl;
            {
                this.val$workManagerImpl = workManagerImpl;
                this.val$id = uUID;
            }

            @Override
            void runInternal() {
                WorkDatabase workDatabase = this.val$workManagerImpl.getWorkDatabase();
                workDatabase.beginTransaction();
                try {
                    this.cancel(this.val$workManagerImpl, this.val$id.toString());
                    workDatabase.setTransactionSuccessful();
                    this.reschedulePendingWorkers(this.val$workManagerImpl);
                    return;
                }
                finally {
                    workDatabase.endTransaction();
                }
            }
        };
    }

    public static CancelWorkRunnable forName(String string2, WorkManagerImpl workManagerImpl, boolean bl) {
        return new CancelWorkRunnable(workManagerImpl, string2, bl){
            final boolean val$allowReschedule;
            final String val$name;
            final WorkManagerImpl val$workManagerImpl;
            {
                this.val$workManagerImpl = workManagerImpl;
                this.val$name = string2;
                this.val$allowReschedule = bl;
            }

            @Override
            void runInternal() {
                WorkDatabase workDatabase;
                block4: {
                    workDatabase = this.val$workManagerImpl.getWorkDatabase();
                    workDatabase.beginTransaction();
                    for (String string2 : workDatabase.workSpecDao().getUnfinishedWorkWithName(this.val$name)) {
                        this.cancel(this.val$workManagerImpl, string2);
                    }
                    workDatabase.setTransactionSuccessful();
                    if (!this.val$allowReschedule) break block4;
                    this.reschedulePendingWorkers(this.val$workManagerImpl);
                }
                return;
                finally {
                    workDatabase.endTransaction();
                }
            }
        };
    }

    public static CancelWorkRunnable forTag(String string2, WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable(workManagerImpl, string2){
            final String val$tag;
            final WorkManagerImpl val$workManagerImpl;
            {
                this.val$workManagerImpl = workManagerImpl;
                this.val$tag = string2;
            }

            @Override
            void runInternal() {
                WorkDatabase workDatabase = this.val$workManagerImpl.getWorkDatabase();
                workDatabase.beginTransaction();
                try {
                    for (String string2 : workDatabase.workSpecDao().getUnfinishedWorkWithTag(this.val$tag)) {
                        this.cancel(this.val$workManagerImpl, string2);
                    }
                    workDatabase.setTransactionSuccessful();
                    this.reschedulePendingWorkers(this.val$workManagerImpl);
                    return;
                }
                finally {
                    workDatabase.endTransaction();
                }
            }
        };
    }

    private void iterativelyCancelWorkAndDependents(WorkDatabase object, String object2) {
        WorkSpecDao workSpecDao = ((WorkDatabase)object).workSpecDao();
        DependencyDao dependencyDao = ((WorkDatabase)object).dependencyDao();
        object = new LinkedList();
        ((LinkedList)object).add(object2);
        while (!((AbstractCollection)object).isEmpty()) {
            String string2 = (String)((LinkedList)object).remove();
            object2 = workSpecDao.getState(string2);
            if (object2 != WorkInfo.State.SUCCEEDED && object2 != WorkInfo.State.FAILED) {
                workSpecDao.setCancelledState(string2);
            }
            ((LinkedList)object).addAll(dependencyDao.getDependentWorkIds(string2));
        }
    }

    void cancel(WorkManagerImpl object, String string2) {
        this.iterativelyCancelWorkAndDependents(((WorkManagerImpl)object).getWorkDatabase(), string2);
        ((WorkManagerImpl)object).getProcessor().stopAndCancelWork(string2, 1);
        object = ((WorkManagerImpl)object).getSchedulers().iterator();
        while (object.hasNext()) {
            ((Scheduler)object.next()).cancel(string2);
        }
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    void reschedulePendingWorkers(WorkManagerImpl workManagerImpl) {
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    @Override
    public void run() {
        try {
            this.runInternal();
            this.mOperation.markState(Operation.SUCCESS);
        }
        catch (Throwable throwable) {
            this.mOperation.markState(new Operation.State.FAILURE(throwable));
        }
    }

    abstract void runInternal();
}

