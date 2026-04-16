/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.work.impl;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.work.Clock;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers$$ExternalSyntheticLambda0;
import androidx.work.impl.Schedulers$$ExternalSyntheticLambda1;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class Schedulers {
    public static final String GCM_SCHEDULER = "androidx.work.impl.background.gcm.GcmScheduler";
    private static final String TAG = Logger.tagWithPrefix("Schedulers");

    private Schedulers() {
    }

    static Scheduler createBestAvailableBackgroundScheduler(Context context, WorkDatabase object, Configuration configuration2) {
        object = new SystemJobScheduler(context, (WorkDatabase)object, configuration2);
        PackageManagerHelper.setComponentEnabled(context, SystemJobService.class, true);
        Logger.get().debug(TAG, "Created SystemJobScheduler and enabled SystemJobService");
        return object;
    }

    static /* synthetic */ void lambda$registerRescheduling$0(List list, WorkGenerationalId workGenerationalId, Configuration configuration2, WorkDatabase workDatabase) {
        Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            ((Scheduler)iterator2.next()).cancel(workGenerationalId.getWorkSpecId());
        }
        Schedulers.schedule(configuration2, workDatabase, list);
    }

    static /* synthetic */ void lambda$registerRescheduling$1(Executor executor, List list, Configuration configuration2, WorkDatabase workDatabase, WorkGenerationalId workGenerationalId, boolean bl) {
        executor.execute(new Schedulers$$ExternalSyntheticLambda0(list, workGenerationalId, configuration2, workDatabase));
    }

    private static void markScheduled(WorkSpecDao workSpecDao, Clock object, List<WorkSpec> list) {
        if (list.size() > 0) {
            long l = object.currentTimeMillis();
            object = list.iterator();
            while (object.hasNext()) {
                workSpecDao.markWorkSpecScheduled(((WorkSpec)object.next()).id, l);
            }
        }
    }

    public static void registerRescheduling(List<Scheduler> list, Processor processor, Executor executor, WorkDatabase workDatabase, Configuration configuration2) {
        processor.addExecutionListener(new Schedulers$$ExternalSyntheticLambda1(executor, list, configuration2, workDatabase));
    }

    public static void schedule(Configuration workSpecArray, WorkDatabase object, List<Scheduler> object2) {
        if (object2 != null && object2.size() != 0) {
            block9: {
                WorkSpecDao workSpecDao = ((WorkDatabase)object).workSpecDao();
                ((RoomDatabase)object).beginTransaction();
                Object object3 = workSpecDao.getEligibleWorkForSchedulingWithContentUris();
                Schedulers.markScheduled(workSpecDao, workSpecArray.getClock(), object3);
                Object object4 = workSpecDao.getEligibleWorkForScheduling(workSpecArray.getMaxSchedulerLimit());
                Schedulers.markScheduled(workSpecDao, workSpecArray.getClock(), object4);
                if (object3 != null) {
                    object4.addAll(object3);
                }
                workSpecArray = workSpecDao.getAllEligibleWorkSpecsForScheduling(200);
                ((RoomDatabase)object).setTransactionSuccessful();
                if (object4.size() <= 0) break block9;
                object = new WorkSpec[object4.size()];
                object = object4.toArray((T[])object);
                object3 = object2.iterator();
                while (object3.hasNext()) {
                    object4 = (Scheduler)object3.next();
                    if (!object4.hasLimitedSchedulingSlots()) continue;
                    object4.schedule((WorkSpec[])object);
                }
            }
            if (workSpecArray.size() > 0) {
                workSpecArray = workSpecArray.toArray(new WorkSpec[workSpecArray.size()]);
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    object = (Scheduler)object2.next();
                    if (object.hasLimitedSchedulingSlots()) continue;
                    object.schedule(workSpecArray);
                }
            }
            return;
            finally {
                ((RoomDatabase)object).endTransaction();
            }
        }
    }

    private static Scheduler tryCreateGcmBasedScheduler(Context object, Clock clock) {
        try {
            object = (Scheduler)Class.forName(GCM_SCHEDULER).getConstructor(Context.class, Clock.class).newInstance(object, clock);
            Logger.get().debug(TAG, "Created androidx.work.impl.background.gcm.GcmScheduler");
            return object;
        }
        catch (Throwable throwable) {
            Logger.get().debug(TAG, "Unable to create GCM Scheduler", throwable);
            return null;
        }
    }
}

