/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.EnqueueUtilsKt;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EnqueueRunnable
implements Runnable {
    private static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    private final OperationImpl mOperation;
    private final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this(workContinuationImpl, new OperationImpl());
    }

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl, OperationImpl operationImpl) {
        this.mWorkContinuation = workContinuationImpl;
        this.mOperation = operationImpl;
    }

    private static boolean enqueueContinuation(WorkContinuationImpl workContinuationImpl) {
        Set<String> set = WorkContinuationImpl.prerequisitesFor(workContinuationImpl);
        boolean bl = EnqueueRunnable.enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), set.toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return bl;
    }

    private static boolean enqueueWorkWithPrerequisites(WorkManagerImpl workManagerImpl, List<? extends WorkRequest> stringArray, String[] object, String string2, ExistingWorkPolicy object2) {
        Object object32;
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        WorkDatabase workDatabase;
        long l;
        boolean bl;
        block28: {
            block26: {
                int n6;
                int n7;
                block29: {
                    Object object4;
                    block30: {
                        Object object5;
                        block27: {
                            bl = false;
                            l = workManagerImpl.getConfiguration().getClock().currentTimeMillis();
                            workDatabase = workManagerImpl.getWorkDatabase();
                            n5 = object != null && ((String[])object).length > 0 ? 1 : 0;
                            n7 = 1;
                            n4 = 1;
                            n6 = 0;
                            n3 = 0;
                            n2 = 0;
                            n = 0;
                            if (n5 != 0) {
                                n2 = ((String[])object).length;
                                for (n7 = 0; n7 < n2; ++n7) {
                                    object32 = object[n7];
                                    object4 = workDatabase.workSpecDao().getWorkSpec((String)object32);
                                    if (object4 == null) {
                                        Logger.get().error(TAG, "Prerequisite " + object32 + " doesn't exist; not enqueuing");
                                        return false;
                                    }
                                    object32 = ((WorkSpec)object4).state;
                                    n6 = object32 == WorkInfo.State.SUCCEEDED ? 1 : 0;
                                    n4 &= n6;
                                    if (object32 == WorkInfo.State.FAILED) {
                                        n6 = 1;
                                    } else {
                                        n6 = n3;
                                        if (object32 == WorkInfo.State.CANCELLED) {
                                            n = 1;
                                            n6 = n3;
                                        }
                                    }
                                    n3 = n6;
                                }
                            } else {
                                bl = false;
                                n = n2;
                                n3 = n6;
                                n4 = n7;
                            }
                            if ((n7 = (n2 = TextUtils.isEmpty((CharSequence)string2) ^ 1) != 0 && n5 == 0 ? 1 : 0) == 0 || (object5 = workDatabase.workSpecDao().getWorkSpecIdAndStatesForName(string2)).isEmpty()) break block26;
                            if (object2 == ExistingWorkPolicy.APPEND || object2 == ExistingWorkPolicy.APPEND_OR_REPLACE) break block27;
                            if (object2 == ExistingWorkPolicy.KEEP) {
                                object2 = object5.iterator();
                                while (object2.hasNext()) {
                                    object32 = (WorkSpec.IdAndState)object2.next();
                                    if (((WorkSpec.IdAndState)object32).state != WorkInfo.State.ENQUEUED && ((WorkSpec.IdAndState)object32).state != WorkInfo.State.RUNNING) continue;
                                    return false;
                                }
                            }
                            CancelWorkRunnable.forName(string2, workManagerImpl, false).run();
                            bl = true;
                            object2 = workDatabase.workSpecDao();
                            object32 = object5.iterator();
                            while (object32.hasNext()) {
                                object2.delete(((WorkSpec.IdAndState)object32.next()).id);
                            }
                            object2 = object;
                            break block28;
                        }
                        object32 = workDatabase.dependencyDao();
                        object4 = new ArrayList();
                        object5 = object5.iterator();
                        n7 = n5;
                        while (object5.hasNext()) {
                            WorkSpec.IdAndState idAndState = (WorkSpec.IdAndState)object5.next();
                            if (!object32.hasDependents(idAndState.id)) {
                                n6 = idAndState.state == WorkInfo.State.SUCCEEDED ? 1 : 0;
                                if (idAndState.state == WorkInfo.State.FAILED) {
                                    n5 = 1;
                                } else {
                                    n5 = n3;
                                    if (idAndState.state == WorkInfo.State.CANCELLED) {
                                        n = 1;
                                        n5 = n3;
                                    }
                                }
                                object4.add((String)idAndState.id);
                                n4 = n6 & n4;
                            } else {
                                n5 = n3;
                            }
                            n3 = n5;
                        }
                        n6 = n3;
                        n7 = n;
                        object32 = object4;
                        if (object2 != ExistingWorkPolicy.APPEND_OR_REPLACE) break block29;
                        if (n != 0) break block30;
                        n6 = n3;
                        n7 = n;
                        object32 = object4;
                        if (n3 == 0) break block29;
                    }
                    object32 = workDatabase.workSpecDao();
                    object2 = object32.getWorkSpecIdAndStatesForName(string2);
                    object4 = object2.iterator();
                    while (object4.hasNext()) {
                        object32.delete(((WorkSpec.IdAndState)object4.next()).id);
                    }
                    object32 = Collections.emptyList();
                    n7 = 0;
                    n6 = 0;
                }
                n5 = ((Object)(object2 = (String[])object32.toArray((T[])object))).length > 0 ? 1 : 0;
                n3 = n6;
                n = n7;
                break block28;
            }
            object2 = object;
        }
        object = stringArray.iterator();
        stringArray = object2;
        while (object.hasNext()) {
            object2 = (WorkRequest)object.next();
            object32 = ((WorkRequest)object2).getWorkSpec();
            if (n5 != 0 && n4 == 0) {
                ((WorkSpec)object32).state = n3 != 0 ? WorkInfo.State.FAILED : (n != 0 ? WorkInfo.State.CANCELLED : WorkInfo.State.BLOCKED);
            } else {
                ((WorkSpec)object32).lastEnqueueTime = l;
            }
            if (((WorkSpec)object32).state == WorkInfo.State.ENQUEUED) {
                bl = true;
            }
            workDatabase.workSpecDao().insertWorkSpec(EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(workManagerImpl.getSchedulers(), (WorkSpec)object32));
            if (n5 != 0) {
                for (Object object32 : stringArray) {
                    object32 = new Dependency(((WorkRequest)object2).getStringId(), (String)object32);
                    workDatabase.dependencyDao().insertDependency((Dependency)object32);
                }
            }
            workDatabase.workTagDao().insertTags(((WorkRequest)object2).getStringId(), ((WorkRequest)object2).getTags());
            if (n2 == 0) continue;
            workDatabase.workNameDao().insert(new WorkName(string2, ((WorkRequest)object2).getStringId()));
        }
        return bl;
    }

    private static boolean processContinuation(WorkContinuationImpl workContinuationImpl) {
        boolean bl = false;
        boolean bl2 = false;
        Object object = workContinuationImpl.getParents();
        if (object != null) {
            Iterator<WorkContinuationImpl> iterator2 = object.iterator();
            while (true) {
                bl = bl2;
                if (!iterator2.hasNext()) break;
                object = iterator2.next();
                if (!((WorkContinuationImpl)object).isEnqueued()) {
                    bl2 |= EnqueueRunnable.processContinuation((WorkContinuationImpl)object);
                    continue;
                }
                Logger.get().warning(TAG, "Already enqueued work ids (" + TextUtils.join((CharSequence)", ", ((WorkContinuationImpl)object).getIds()) + ")");
            }
        }
        return bl | EnqueueRunnable.enqueueContinuation(workContinuationImpl);
    }

    public boolean addToDatabase() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            EnqueueUtilsKt.checkContentUriTriggerWorkerLimits(workDatabase, workManagerImpl.getConfiguration(), this.mWorkContinuation);
            boolean bl = EnqueueRunnable.processContinuation(this.mWorkContinuation);
            workDatabase.setTransactionSuccessful();
            return bl;
        }
        finally {
            workDatabase.endTransaction();
        }
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    @Override
    public void run() {
        try {
            if (!this.mWorkContinuation.hasCycles()) {
                if (this.addToDatabase()) {
                    PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                    this.scheduleWorkInBackground();
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("WorkContinuation has cycles (").append(this.mWorkContinuation).append(")").toString());
                throw illegalStateException;
            }
            this.mOperation.markState(Operation.SUCCESS);
        }
        catch (Throwable throwable) {
            this.mOperation.markState(new Operation.State.FAILURE(throwable));
        }
    }

    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }
}

