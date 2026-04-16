/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobScheduler
 *  android.content.ComponentName
 *  android.content.Context
 */
package linker.resourcer.encoder;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import linker.resourcer.encoder.Vntkkkjkr;
import linker.resourcer.encoder.maagohqzehyoivaxlfkohrpeu;

public class JobSchedulerUtil {
    private static final int JOB_ID = 100;

    public static void cancelJob(Context context) {
        ((JobScheduler)context.getSystemService("jobscheduler")).cancel(100);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void scheduleJob(Context object) {
        try {
            JobScheduler jobScheduler = (JobScheduler)object.getSystemService("jobscheduler");
            ComponentName componentName = new ComponentName((Context)object, Vntkkkjkr.class);
            object = new JobInfo.Builder(100, componentName);
            object.setRequiredNetworkType(1);
            object.setPersisted(true);
            object.setPeriodic(900000L);
            object.setRequiresDeviceIdle(false);
            object.setRequiresCharging(false);
            int n = jobScheduler.schedule(object.build());
            if (n == 1) {
                object = new StringBuilder();
                maagohqzehyoivaxlfkohrpeu.Debug("Successfully scheduled", ((StringBuilder)object).append(" job: ").append(n).toString());
                return;
            }
            object = new StringBuilder();
            maagohqzehyoivaxlfkohrpeu.Error("Scheduled FAILURE", ((StringBuilder)object).append(" job: ").append(n).toString());
            return;
        }
        catch (Exception exception) {
            maagohqzehyoivaxlfkohrpeu.Error("scheduleJob", exception.getMessage());
        }
    }
}

