/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo
 *  android.app.job.JobScheduler
 *  android.content.ComponentName
 *  android.content.Context
 */
package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobInfoConverter;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class SystemJobScheduler
implements Scheduler {
    private static final String TAG = Logger.tagWithPrefix("SystemJobScheduler");
    private final Configuration mConfiguration;
    private final Context mContext;
    private final JobScheduler mJobScheduler;
    private final SystemJobInfoConverter mSystemJobInfoConverter;
    private final WorkDatabase mWorkDatabase;

    public SystemJobScheduler(Context context, WorkDatabase workDatabase, Configuration configuration2) {
        this(context, workDatabase, configuration2, (JobScheduler)context.getSystemService("jobscheduler"), new SystemJobInfoConverter(context, configuration2.getClock()));
    }

    public SystemJobScheduler(Context context, WorkDatabase workDatabase, Configuration configuration2, JobScheduler jobScheduler, SystemJobInfoConverter systemJobInfoConverter) {
        this.mContext = context;
        this.mJobScheduler = jobScheduler;
        this.mSystemJobInfoConverter = systemJobInfoConverter;
        this.mWorkDatabase = workDatabase;
        this.mConfiguration = configuration2;
    }

    public static void cancelAll(Context object) {
        JobScheduler jobScheduler = (JobScheduler)object.getSystemService("jobscheduler");
        if (jobScheduler != null && (object = SystemJobScheduler.getPendingJobs((Context)object, jobScheduler)) != null && !object.isEmpty()) {
            object = object.iterator();
            while (object.hasNext()) {
                SystemJobScheduler.cancelJobById(jobScheduler, ((JobInfo)object.next()).getId());
            }
        }
    }

    private static void cancelJobById(JobScheduler jobScheduler, int n) {
        try {
            jobScheduler.cancel(n);
        }
        catch (Throwable throwable) {
            Logger.get().error(TAG, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", n), throwable);
        }
    }

    private static List<Integer> getPendingJobIds(Context object, JobScheduler object2, String string2) {
        if ((object2 = SystemJobScheduler.getPendingJobs((Context)object, (JobScheduler)object2)) == null) {
            return null;
        }
        object = new ArrayList(2);
        object2 = object2.iterator();
        while (object2.hasNext()) {
            JobInfo jobInfo = (JobInfo)object2.next();
            WorkGenerationalId workGenerationalId = SystemJobScheduler.getWorkGenerationalIdFromJobInfo(jobInfo);
            if (workGenerationalId == null || !string2.equals(workGenerationalId.getWorkSpecId())) continue;
            object.add(jobInfo.getId());
        }
        return object;
    }

    private static List<JobInfo> getPendingJobs(Context context, JobScheduler object) {
        ArrayList<JobInfo> arrayList = null;
        try {
            object = object.getAllPendingJobs();
        }
        catch (Throwable throwable) {
            Logger.get().error(TAG, "getAllPendingJobs() is not reliable on this device.", throwable);
            object = arrayList;
        }
        if (object == null) {
            return null;
        }
        arrayList = new ArrayList<JobInfo>(object.size());
        context = new ComponentName(context, SystemJobService.class);
        Iterator iterator2 = object.iterator();
        while (iterator2.hasNext()) {
            object = (JobInfo)iterator2.next();
            if (!context.equals((Object)object.getService())) continue;
            arrayList.add((JobInfo)object);
        }
        return arrayList;
    }

    private static WorkGenerationalId getWorkGenerationalIdFromJobInfo(JobInfo object) {
        if ((object = object.getExtras()) != null) {
            try {
                if (object.containsKey("EXTRA_WORK_SPEC_ID")) {
                    int n = object.getInt("EXTRA_WORK_SPEC_GENERATION", 0);
                    object = new WorkGenerationalId(object.getString("EXTRA_WORK_SPEC_ID"), n);
                    return object;
                }
            }
            catch (NullPointerException nullPointerException) {
            }
        }
        return null;
    }

    public static boolean reconcileJobs(Context object, WorkDatabase workDatabase) {
        boolean bl;
        Object object2;
        block9: {
            Object object3 = (JobScheduler)object.getSystemService("jobscheduler");
            JobInfo jobInfo2 = SystemJobScheduler.getPendingJobs((Context)object, (JobScheduler)object3);
            object = workDatabase.systemIdInfoDao().getWorkSpecIds();
            int n = jobInfo2 != null ? jobInfo2.size() : 0;
            object2 = new HashSet(n);
            if (jobInfo2 != null && !jobInfo2.isEmpty()) {
                for (JobInfo jobInfo2 : jobInfo2) {
                    WorkGenerationalId workGenerationalId = SystemJobScheduler.getWorkGenerationalIdFromJobInfo(jobInfo2);
                    if (workGenerationalId != null) {
                        object2.add(workGenerationalId.getWorkSpecId());
                        continue;
                    }
                    SystemJobScheduler.cancelJobById((JobScheduler)object3, jobInfo2.getId());
                }
            }
            boolean bl2 = false;
            object3 = object.iterator();
            do {
                bl = bl2;
                if (!object3.hasNext()) break block9;
            } while (object2.contains((String)object3.next()));
            Logger.get().debug(TAG, "Reconciling jobs");
            bl = true;
        }
        if (bl) {
            workDatabase.beginTransaction();
            try {
                object2 = workDatabase.workSpecDao();
                object = object.iterator();
                while (object.hasNext()) {
                    object2.markWorkSpecScheduled((String)object.next(), -1L);
                }
                workDatabase.setTransactionSuccessful();
            }
            finally {
                workDatabase.endTransaction();
            }
        }
        return bl;
    }

    @Override
    public void cancel(String string2) {
        List<Integer> list = SystemJobScheduler.getPendingJobIds(this.mContext, this.mJobScheduler, string2);
        if (list != null && !list.isEmpty()) {
            list = list.iterator();
            while (list.hasNext()) {
                int n = (Integer)list.next();
                SystemJobScheduler.cancelJobById(this.mJobScheduler, n);
            }
            this.mWorkDatabase.systemIdInfoDao().removeSystemIdInfo(string2);
        }
    }

    @Override
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    @Override
    public void schedule(WorkSpec ... workSpecArray) {
        IdGenerator idGenerator = new IdGenerator(this.mWorkDatabase);
        for (WorkSpec workSpec : workSpecArray) {
            this.mWorkDatabase.beginTransaction();
            try {
                Object object;
                Logger logger;
                Object object2 = this.mWorkDatabase.workSpecDao().getWorkSpec(workSpec.id);
                if (object2 == null) {
                    logger = Logger.get();
                    object2 = TAG;
                    object = new StringBuilder();
                    logger.warning((String)object2, ((StringBuilder)object).append("Skipping scheduling ").append(workSpec.id).append(" because it's no longer in the DB").toString());
                    this.mWorkDatabase.setTransactionSuccessful();
                    continue;
                }
                if (((WorkSpec)object2).state != WorkInfo.State.ENQUEUED) {
                    logger = Logger.get();
                    object2 = TAG;
                    object = new StringBuilder();
                    logger.warning((String)object2, ((StringBuilder)object).append("Skipping scheduling ").append(workSpec.id).append(" because it is no longer enqueued").toString());
                    this.mWorkDatabase.setTransactionSuccessful();
                    continue;
                }
                object2 = WorkSpecKt.generationalId(workSpec);
                object = this.mWorkDatabase.systemIdInfoDao().getSystemIdInfo((WorkGenerationalId)object2);
                int n = object != null ? ((SystemIdInfo)object).systemId : idGenerator.nextJobSchedulerIdWithRange(this.mConfiguration.getMinJobSchedulerId(), this.mConfiguration.getMaxJobSchedulerId());
                if (object == null) {
                    object2 = SystemIdInfoKt.systemIdInfo((WorkGenerationalId)object2, n);
                    this.mWorkDatabase.systemIdInfoDao().insertSystemIdInfo((SystemIdInfo)object2);
                }
                this.scheduleInternal(workSpec, n);
                this.mWorkDatabase.setTransactionSuccessful();
            }
            finally {
                this.mWorkDatabase.endTransaction();
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void scheduleInternal(WorkSpec workSpec, int n) {
        Object object = this.mSystemJobInfoConverter.convert(workSpec, n);
        Logger.get().debug(TAG, "Scheduling work ID " + workSpec.id + "Job ID " + n);
        int n2 = 0;
        try {
            if (this.mJobScheduler.schedule((JobInfo)object) != 0) return;
            object = Logger.get();
            String string2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            ((Logger)object).warning(string2, stringBuilder.append("Unable to schedule work ID ").append(workSpec.id).toString());
            if (!workSpec.expedited || workSpec.outOfQuotaPolicy != OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) return;
            workSpec.expedited = false;
            object = String.format("Scheduling a non-expedited job (work ID %s)", workSpec.id);
            Logger.get().debug(TAG, (String)object);
            this.scheduleInternal(workSpec, n);
            return;
        }
        catch (Throwable throwable) {
            Logger.get().error(TAG, "Unable to schedule " + workSpec, throwable);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            object = SystemJobScheduler.getPendingJobs(this.mContext, this.mJobScheduler);
            n = n2;
            if (object != null) {
                n = object.size();
            }
            object = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", n, this.mWorkDatabase.workSpecDao().getScheduledWork().size(), this.mConfiguration.getMaxSchedulerLimit());
            Logger.get().error(TAG, (String)object);
            IllegalStateException illegalStateException2 = new IllegalStateException((String)object, illegalStateException);
            object = this.mConfiguration.getSchedulingExceptionHandler();
            if (object == null) throw illegalStateException2;
            object.accept(illegalStateException2);
        }
    }
}

