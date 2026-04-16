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
import androidx.work.Clock;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.CommandHandler;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.ArrayList;

class ConstraintsCommandHandler {
    private static final String TAG = Logger.tagWithPrefix("ConstraintsCmdHandler");
    private final Clock mClock;
    private final Context mContext;
    private final SystemAlarmDispatcher mDispatcher;
    private final int mStartId;
    private final WorkConstraintsTracker mWorkConstraintsTracker;

    ConstraintsCommandHandler(Context context, Clock clock, int n, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.mContext = context;
        this.mClock = clock;
        this.mStartId = n;
        this.mDispatcher = systemAlarmDispatcher;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(this.mDispatcher.getWorkManager().getTrackers());
    }

    void handleConstraintsChanged() {
        WorkSpec workSpec;
        Object object = this.mDispatcher.getWorkManager().getWorkDatabase().workSpecDao().getScheduledWork();
        ConstraintProxy.updateAll(this.mContext, object);
        Object object2 = new ArrayList(object.size());
        long l = this.mClock.currentTimeMillis();
        object = object.iterator();
        while (object.hasNext()) {
            workSpec = (WorkSpec)object.next();
            if (l < workSpec.calculateNextRunTime() || workSpec.hasConstraints() && !this.mWorkConstraintsTracker.areAllConstraintsMet(workSpec)) continue;
            object2.add(workSpec);
        }
        object2 = object2.iterator();
        while (object2.hasNext()) {
            workSpec = (WorkSpec)object2.next();
            object = workSpec.id;
            workSpec = CommandHandler.createDelayMetIntent(this.mContext, WorkSpecKt.generationalId(workSpec));
            Logger.get().debug(TAG, "Creating a delay_met command for workSpec with id (" + (String)object + ")");
            this.mDispatcher.getTaskExecutor().getMainThreadExecutor().execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, (Intent)workSpec, this.mStartId));
        }
    }
}

