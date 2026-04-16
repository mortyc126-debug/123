/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.background.systemalarm.CommandHandler;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;

public class SystemAlarmScheduler
implements Scheduler {
    private static final String TAG = Logger.tagWithPrefix("SystemAlarmScheduler");
    private final Context mContext;

    public SystemAlarmScheduler(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private void scheduleWorkSpec(WorkSpec workSpec) {
        Logger.get().debug(TAG, "Scheduling work with workSpecId " + workSpec.id);
        workSpec = CommandHandler.createScheduleWorkIntent(this.mContext, WorkSpecKt.generationalId(workSpec));
        this.mContext.startService((Intent)workSpec);
    }

    @Override
    public void cancel(String string2) {
        string2 = CommandHandler.createStopWorkIntent(this.mContext, string2);
        this.mContext.startService((Intent)string2);
    }

    @Override
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    @Override
    public void schedule(WorkSpec ... workSpecArray) {
        int n = workSpecArray.length;
        for (int i = 0; i < n; ++i) {
            this.scheduleWorkSpec(workSpecArray[i]);
        }
    }
}

