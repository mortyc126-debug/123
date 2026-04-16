/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobInfo$TriggerContentUri
 *  android.content.ComponentName
 *  android.content.Context
 *  android.net.NetworkRequest$Builder
 *  android.os.Build$VERSION
 *  android.os.PersistableBundle
 */
package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.BackoffPolicy;
import androidx.work.Clock;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkSpec;

class SystemJobInfoConverter {
    static final String EXTRA_IS_PERIODIC = "EXTRA_IS_PERIODIC";
    static final String EXTRA_WORK_SPEC_GENERATION = "EXTRA_WORK_SPEC_GENERATION";
    static final String EXTRA_WORK_SPEC_ID = "EXTRA_WORK_SPEC_ID";
    private static final String TAG = Logger.tagWithPrefix("SystemJobInfoConverter");
    private final Clock mClock;
    private final ComponentName mWorkServiceComponent;

    SystemJobInfoConverter(Context context, Clock clock) {
        this.mClock = clock;
        this.mWorkServiceComponent = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    private static JobInfo.TriggerContentUri convertContentUriTrigger(Constraints.ContentUriTrigger contentUriTrigger) {
        int n = contentUriTrigger.isTriggeredForDescendants() ? 1 : 0;
        return new JobInfo.TriggerContentUri(contentUriTrigger.getUri(), n);
    }

    static int convertNetworkType(NetworkType networkType) {
        switch (1.$SwitchMap$androidx$work$NetworkType[networkType.ordinal()]) {
            default: {
                break;
            }
            case 5: {
                if (Build.VERSION.SDK_INT < 26) break;
                return 4;
            }
            case 4: {
                return 3;
            }
            case 3: {
                return 2;
            }
            case 2: {
                return 1;
            }
            case 1: {
                return 0;
            }
        }
        Logger.get().debug(TAG, "API version too low. Cannot convert network type value " + (Object)((Object)networkType));
        return 1;
    }

    static void setRequiredNetwork(JobInfo.Builder builder, NetworkType networkType) {
        if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        } else {
            builder.setRequiredNetworkType(SystemJobInfoConverter.convertNetworkType(networkType));
        }
    }

    JobInfo convert(WorkSpec workSpec, int n) {
        Constraints constraints = workSpec.constraints;
        Object object = new PersistableBundle();
        object.putString(EXTRA_WORK_SPEC_ID, workSpec.id);
        object.putInt(EXTRA_WORK_SPEC_GENERATION, workSpec.getGeneration());
        object.putBoolean(EXTRA_IS_PERIODIC, workSpec.isPeriodic());
        JobInfo.Builder builder = new JobInfo.Builder(n, this.mWorkServiceComponent).setRequiresCharging(constraints.requiresCharging()).setRequiresDeviceIdle(constraints.requiresDeviceIdle()).setExtras((PersistableBundle)object);
        SystemJobInfoConverter.setRequiredNetwork(builder, constraints.getRequiredNetworkType());
        if (!constraints.requiresDeviceIdle()) {
            n = workSpec.backoffPolicy == BackoffPolicy.LINEAR ? 0 : 1;
            builder.setBackoffCriteria(workSpec.backoffDelayDuration, n);
        }
        long l = Math.max(workSpec.calculateNextRunTime() - this.mClock.currentTimeMillis(), 0L);
        if (Build.VERSION.SDK_INT <= 28) {
            builder.setMinimumLatency(l);
        } else if (l > 0L) {
            builder.setMinimumLatency(l);
        } else if (!workSpec.expedited) {
            builder.setImportantWhileForeground(true);
        }
        if (constraints.hasContentUriTriggers()) {
            object = constraints.getContentUriTriggers().iterator();
            while (object.hasNext()) {
                builder.addTriggerContentUri(SystemJobInfoConverter.convertContentUriTrigger((Constraints.ContentUriTrigger)object.next()));
            }
            builder.setTriggerContentUpdateDelay(constraints.getContentTriggerUpdateDelayMillis());
            builder.setTriggerContentMaxDelay(constraints.getContentTriggerMaxDelayMillis());
        }
        boolean bl = false;
        builder.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setRequiresBatteryNotLow(constraints.requiresBatteryNotLow());
            builder.setRequiresStorageNotLow(constraints.requiresStorageNotLow());
        }
        n = workSpec.runAttemptCount > 0 ? 1 : 0;
        if (l > 0L) {
            bl = true;
        }
        if (Build.VERSION.SDK_INT >= 31 && workSpec.expedited && n == 0 && !bl) {
            builder.setExpedited(true);
        }
        return builder.build();
    }
}

