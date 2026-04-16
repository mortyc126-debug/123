/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.room.RoomDatabase;
import androidx.work.Clock;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.Alarms;
import androidx.work.impl.background.systemalarm.ConstraintsCommandHandler;
import androidx.work.impl.background.systemalarm.DelayMetCommandHandler;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandHandler
implements ExecutionListener {
    static final String ACTION_CONSTRAINTS_CHANGED = "ACTION_CONSTRAINTS_CHANGED";
    static final String ACTION_DELAY_MET = "ACTION_DELAY_MET";
    static final String ACTION_EXECUTION_COMPLETED = "ACTION_EXECUTION_COMPLETED";
    static final String ACTION_RESCHEDULE = "ACTION_RESCHEDULE";
    static final String ACTION_SCHEDULE_WORK = "ACTION_SCHEDULE_WORK";
    static final String ACTION_STOP_WORK = "ACTION_STOP_WORK";
    private static final String KEY_NEEDS_RESCHEDULE = "KEY_NEEDS_RESCHEDULE";
    private static final String KEY_WORKSPEC_GENERATION = "KEY_WORKSPEC_GENERATION";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    private static final String TAG = Logger.tagWithPrefix("CommandHandler");
    static final long WORK_PROCESSING_TIME_IN_MS = 600000L;
    private final Clock mClock;
    private final Context mContext;
    private final Object mLock;
    private final Map<WorkGenerationalId, DelayMetCommandHandler> mPendingDelayMet;
    private final StartStopTokens mStartStopTokens;

    CommandHandler(Context context, Clock clock, StartStopTokens startStopTokens) {
        this.mContext = context;
        this.mClock = clock;
        this.mStartStopTokens = startStopTokens;
        this.mPendingDelayMet = new HashMap<WorkGenerationalId, DelayMetCommandHandler>();
        this.mLock = new Object();
    }

    static Intent createConstraintsChangedIntent(Context context) {
        context = new Intent(context, SystemAlarmService.class);
        context.setAction(ACTION_CONSTRAINTS_CHANGED);
        return context;
    }

    static Intent createDelayMetIntent(Context context, WorkGenerationalId workGenerationalId) {
        context = new Intent(context, SystemAlarmService.class);
        context.setAction(ACTION_DELAY_MET);
        return CommandHandler.writeWorkGenerationalId((Intent)context, workGenerationalId);
    }

    static Intent createExecutionCompletedIntent(Context context, WorkGenerationalId workGenerationalId, boolean bl) {
        context = new Intent(context, SystemAlarmService.class);
        context.setAction(ACTION_EXECUTION_COMPLETED);
        context.putExtra(KEY_NEEDS_RESCHEDULE, bl);
        return CommandHandler.writeWorkGenerationalId((Intent)context, workGenerationalId);
    }

    static Intent createRescheduleIntent(Context context) {
        context = new Intent(context, SystemAlarmService.class);
        context.setAction(ACTION_RESCHEDULE);
        return context;
    }

    static Intent createScheduleWorkIntent(Context context, WorkGenerationalId workGenerationalId) {
        context = new Intent(context, SystemAlarmService.class);
        context.setAction(ACTION_SCHEDULE_WORK);
        return CommandHandler.writeWorkGenerationalId((Intent)context, workGenerationalId);
    }

    static Intent createStopWorkIntent(Context context, WorkGenerationalId workGenerationalId) {
        context = new Intent(context, SystemAlarmService.class);
        context.setAction(ACTION_STOP_WORK);
        return CommandHandler.writeWorkGenerationalId((Intent)context, workGenerationalId);
    }

    static Intent createStopWorkIntent(Context context, String string2) {
        context = new Intent(context, SystemAlarmService.class);
        context.setAction(ACTION_STOP_WORK);
        context.putExtra(KEY_WORKSPEC_ID, string2);
        return context;
    }

    private void handleConstraintsChanged(Intent intent, int n, SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.get().debug(TAG, "Handling constraints changed " + intent);
        new ConstraintsCommandHandler(this.mContext, this.mClock, n, systemAlarmDispatcher).handleConstraintsChanged();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void handleDelayMet(Intent object, int n, SystemAlarmDispatcher object2) {
        Object object3 = this.mLock;
        synchronized (object3) {
            object = CommandHandler.readWorkGenerationalId(object);
            Object object4 = Logger.get();
            CharSequence charSequence = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            ((Logger)object4).debug((String)charSequence, stringBuilder.append("Handing delay met for ").append(object).toString());
            if (!this.mPendingDelayMet.containsKey(object)) {
                object4 = new DelayMetCommandHandler(this.mContext, n, (SystemAlarmDispatcher)object2, this.mStartStopTokens.tokenFor((WorkGenerationalId)object));
                this.mPendingDelayMet.put((WorkGenerationalId)object, (DelayMetCommandHandler)object4);
                ((DelayMetCommandHandler)object4).handleProcessWork();
            } else {
                object2 = Logger.get();
                object4 = TAG;
                charSequence = new StringBuilder();
                ((Logger)object2).debug((String)object4, ((StringBuilder)charSequence).append("WorkSpec ").append(object).append(" is is already being handled for ACTION_DELAY_MET").toString());
            }
            return;
        }
    }

    private void handleExecutionCompleted(Intent intent, int n) {
        WorkGenerationalId workGenerationalId = CommandHandler.readWorkGenerationalId(intent);
        boolean bl = intent.getExtras().getBoolean(KEY_NEEDS_RESCHEDULE);
        Logger.get().debug(TAG, "Handling onExecutionCompleted " + intent + ", " + n);
        this.onExecuted(workGenerationalId, bl);
    }

    private void handleReschedule(Intent intent, int n, SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.get().debug(TAG, "Handling reschedule " + intent + ", " + n);
        systemAlarmDispatcher.getWorkManager().rescheduleEligibleWork();
    }

    private void handleScheduleWorkIntent(Intent object, int n, SystemAlarmDispatcher object2) {
        WorkGenerationalId workGenerationalId = CommandHandler.readWorkGenerationalId((Intent)object);
        Logger.get().debug(TAG, "Handling schedule work for " + workGenerationalId);
        object = ((SystemAlarmDispatcher)object2).getWorkManager().getWorkDatabase();
        ((RoomDatabase)object).beginTransaction();
        try {
            Object object3 = ((WorkDatabase)object).workSpecDao().getWorkSpec(workGenerationalId.getWorkSpecId());
            if (object3 == null) {
                Logger logger = Logger.get();
                object3 = TAG;
                object2 = new StringBuilder();
                logger.warning((String)object3, ((StringBuilder)object2).append("Skipping scheduling ").append(workGenerationalId).append(" because it's no longer in the DB").toString());
                return;
            }
            if (((WorkSpec)object3).state.isFinished()) {
                object3 = Logger.get();
                object2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                ((Logger)object3).warning((String)object2, stringBuilder.append("Skipping scheduling ").append(workGenerationalId).append("because it is finished.").toString());
                return;
            }
            long l = ((WorkSpec)object3).calculateNextRunTime();
            boolean bl = ((WorkSpec)object3).hasConstraints();
            if (!bl) {
                object3 = Logger.get();
                String string2 = TAG;
                object2 = new StringBuilder();
                ((Logger)object3).debug(string2, ((StringBuilder)object2).append("Setting up Alarms for ").append(workGenerationalId).append("at ").append(l).toString());
                Alarms.setAlarm(this.mContext, (WorkDatabase)object, workGenerationalId, l);
            } else {
                Logger logger = Logger.get();
                object3 = TAG;
                Object object4 = new StringBuilder();
                logger.debug((String)object3, ((StringBuilder)object4).append("Opportunistically setting an alarm for ").append(workGenerationalId).append("at ").append(l).toString());
                Alarms.setAlarm(this.mContext, (WorkDatabase)object, workGenerationalId, l);
                workGenerationalId = CommandHandler.createConstraintsChangedIntent(this.mContext);
                object4 = ((SystemAlarmDispatcher)object2).getTaskExecutor().getMainThreadExecutor();
                object3 = new SystemAlarmDispatcher.AddRunnable((SystemAlarmDispatcher)object2, (Intent)workGenerationalId, n);
                object4.execute((Runnable)object3);
            }
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            ((RoomDatabase)object).endTransaction();
        }
    }

    private void handleStopWork(Intent object, SystemAlarmDispatcher systemAlarmDispatcher) {
        StartStopToken startStopToken;
        object = object.getExtras();
        String string2 = object.getString(KEY_WORKSPEC_ID);
        if (object.containsKey(KEY_WORKSPEC_GENERATION)) {
            int n = object.getInt(KEY_WORKSPEC_GENERATION);
            object = new ArrayList(1);
            startStopToken = this.mStartStopTokens.remove(new WorkGenerationalId(string2, n));
            if (startStopToken != null) {
                object.add(startStopToken);
            }
        } else {
            object = this.mStartStopTokens.remove(string2);
        }
        object = object.iterator();
        while (object.hasNext()) {
            startStopToken = (StartStopToken)object.next();
            Logger.get().debug(TAG, "Handing stopWork work for " + string2);
            systemAlarmDispatcher.getWorkerLauncher().stopWork(startStopToken);
            Alarms.cancelAlarm(this.mContext, systemAlarmDispatcher.getWorkManager().getWorkDatabase(), startStopToken.getId());
            systemAlarmDispatcher.onExecuted(startStopToken.getId(), false);
        }
    }

    private static boolean hasKeys(Bundle bundle, String ... stringArray) {
        if (bundle != null && !bundle.isEmpty()) {
            int n = stringArray.length;
            for (int i = 0; i < n; ++i) {
                if (bundle.get(stringArray[i]) != null) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    static WorkGenerationalId readWorkGenerationalId(Intent intent) {
        return new WorkGenerationalId(intent.getStringExtra(KEY_WORKSPEC_ID), intent.getIntExtra(KEY_WORKSPEC_GENERATION, 0));
    }

    private static Intent writeWorkGenerationalId(Intent intent, WorkGenerationalId workGenerationalId) {
        intent.putExtra(KEY_WORKSPEC_ID, workGenerationalId.getWorkSpecId());
        intent.putExtra(KEY_WORKSPEC_GENERATION, workGenerationalId.getGeneration());
        return intent;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    boolean hasPendingCommands() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mPendingDelayMet.isEmpty()) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onExecuted(WorkGenerationalId workGenerationalId, boolean bl) {
        Object object = this.mLock;
        synchronized (object) {
            DelayMetCommandHandler delayMetCommandHandler = this.mPendingDelayMet.remove(workGenerationalId);
            this.mStartStopTokens.remove(workGenerationalId);
            if (delayMetCommandHandler != null) {
                delayMetCommandHandler.onExecuted(bl);
            }
            return;
        }
    }

    void onHandleIntent(Intent intent, int n, SystemAlarmDispatcher systemAlarmDispatcher) {
        String string2 = intent.getAction();
        if (ACTION_CONSTRAINTS_CHANGED.equals(string2)) {
            this.handleConstraintsChanged(intent, n, systemAlarmDispatcher);
        } else if (ACTION_RESCHEDULE.equals(string2)) {
            this.handleReschedule(intent, n, systemAlarmDispatcher);
        } else if (!CommandHandler.hasKeys(intent.getExtras(), KEY_WORKSPEC_ID)) {
            Logger.get().error(TAG, "Invalid request for " + string2 + " , requires " + KEY_WORKSPEC_ID + " .");
        } else if (ACTION_SCHEDULE_WORK.equals(string2)) {
            this.handleScheduleWorkIntent(intent, n, systemAlarmDispatcher);
        } else if (ACTION_DELAY_MET.equals(string2)) {
            this.handleDelayMet(intent, n, systemAlarmDispatcher);
        } else if (ACTION_STOP_WORK.equals(string2)) {
            this.handleStopWork(intent, systemAlarmDispatcher);
        } else if (ACTION_EXECUTION_COMPLETED.equals(string2)) {
            this.handleExecutionCompleted(intent, n);
        } else {
            Logger.get().warning(TAG, "Ignoring intent " + intent);
        }
    }
}

