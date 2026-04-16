/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.net.Network
 *  android.net.Uri
 *  android.os.Build$VERSION
 */
package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService
extends JobService
implements ExecutionListener {
    private static final String TAG = Logger.tagWithPrefix("SystemJobService");
    private final Map<WorkGenerationalId, JobParameters> mJobParameters = new HashMap<WorkGenerationalId, JobParameters>();
    private final StartStopTokens mStartStopTokens = new StartStopTokens();
    private WorkLauncher mWorkLauncher;
    private WorkManagerImpl mWorkManagerImpl;

    static int stopReason(int n) {
        switch (n) {
            default: {
                n = -512;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
        }
        return n;
    }

    private static WorkGenerationalId workGenerationalIdFromJobParameters(JobParameters object) {
        block4: {
            object = object.getExtras();
            if (object == null) break block4;
            try {
                if (object.containsKey("EXTRA_WORK_SPEC_ID")) {
                    object = new WorkGenerationalId(object.getString("EXTRA_WORK_SPEC_ID"), object.getInt("EXTRA_WORK_SPEC_GENERATION"));
                    return object;
                }
            }
            catch (NullPointerException nullPointerException) {
                // empty catch block
            }
        }
        return null;
    }

    public void onCreate() {
        IllegalStateException illegalStateException2;
        block2: {
            super.onCreate();
            try {
                this.mWorkManagerImpl = WorkManagerImpl.getInstance(this.getApplicationContext());
                Processor processor = this.mWorkManagerImpl.getProcessor();
                WorkLauncherImpl workLauncherImpl = new WorkLauncherImpl(processor, this.mWorkManagerImpl.getWorkTaskExecutor());
                this.mWorkLauncher = workLauncherImpl;
                processor.addExecutionListener(this);
            }
            catch (IllegalStateException illegalStateException2) {
                if (!Application.class.equals(this.getApplication().getClass())) break block2;
                Logger.get().warning(TAG, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
            }
            return;
        }
        throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", illegalStateException2);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.mWorkManagerImpl != null) {
            this.mWorkManagerImpl.getProcessor().removeExecutionListener(this);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onExecuted(WorkGenerationalId workGenerationalId, boolean bl) {
        JobParameters jobParameters;
        Logger.get().debug(TAG, workGenerationalId.getWorkSpecId() + " executed on JobScheduler");
        Map<WorkGenerationalId, JobParameters> map2 = this.mJobParameters;
        synchronized (map2) {
            jobParameters = this.mJobParameters.remove(workGenerationalId);
        }
        this.mStartStopTokens.remove(workGenerationalId);
        if (jobParameters != null) {
            this.jobFinished(jobParameters, bl);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean onStartJob(JobParameters object) {
        if (this.mWorkManagerImpl == null) {
            Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.");
            this.jobFinished((JobParameters)object, true);
            return false;
        }
        WorkGenerationalId workGenerationalId = SystemJobService.workGenerationalIdFromJobParameters((JobParameters)object);
        if (workGenerationalId == null) {
            Logger.get().error(TAG, "WorkSpec id not found!");
            return false;
        }
        Object object2 = this.mJobParameters;
        synchronized (object2) {
            if (this.mJobParameters.containsKey(workGenerationalId)) {
                object = Logger.get();
                String string2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                ((Logger)object).debug(string2, stringBuilder.append("Job is already being executed by SystemJobService: ").append(workGenerationalId).toString());
                return false;
            }
            Logger logger = Logger.get();
            String string3 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            logger.debug(string3, stringBuilder.append("onStartJob for ").append(workGenerationalId).toString());
            this.mJobParameters.put(workGenerationalId, (JobParameters)object);
        }
        object2 = new WorkerParameters.RuntimeExtras();
        if (Api24Impl.getTriggeredContentUris((JobParameters)object) != null) {
            ((WorkerParameters.RuntimeExtras)object2).triggeredContentUris = Arrays.asList(Api24Impl.getTriggeredContentUris((JobParameters)object));
        }
        if (Api24Impl.getTriggeredContentAuthorities((JobParameters)object) != null) {
            ((WorkerParameters.RuntimeExtras)object2).triggeredContentAuthorities = Arrays.asList(Api24Impl.getTriggeredContentAuthorities((JobParameters)object));
        }
        if (Build.VERSION.SDK_INT >= 28) {
            ((WorkerParameters.RuntimeExtras)object2).network = Api28Impl.getNetwork((JobParameters)object);
        }
        this.mWorkLauncher.startWork(this.mStartStopTokens.tokenFor(workGenerationalId), (WorkerParameters.RuntimeExtras)object2);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean onStopJob(JobParameters jobParameters) {
        if (this.mWorkManagerImpl == null) {
            Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        WorkGenerationalId workGenerationalId = SystemJobService.workGenerationalIdFromJobParameters(jobParameters);
        if (workGenerationalId == null) {
            Logger.get().error(TAG, "WorkSpec id not found!");
            return false;
        }
        Logger.get().debug(TAG, "onStopJob for " + workGenerationalId);
        Object object = this.mJobParameters;
        synchronized (object) {
            this.mJobParameters.remove(workGenerationalId);
        }
        object = this.mStartStopTokens.remove(workGenerationalId);
        if (object != null) {
            int n = Build.VERSION.SDK_INT >= 31 ? Api31Impl.getStopReason(jobParameters) : -512;
            this.mWorkLauncher.stopWorkWithReason((StartStopToken)object, n);
        }
        return true ^ this.mWorkManagerImpl.getProcessor().isCancelled(workGenerationalId.getWorkSpecId());
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static String[] getTriggeredContentAuthorities(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentAuthorities();
        }

        static Uri[] getTriggeredContentUris(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentUris();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Network getNetwork(JobParameters jobParameters) {
            return jobParameters.getNetwork();
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static int getStopReason(JobParameters jobParameters) {
            return SystemJobService.stopReason(jobParameters.getStopReason());
        }
    }
}

