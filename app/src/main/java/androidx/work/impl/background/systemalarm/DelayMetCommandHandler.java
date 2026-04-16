/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.PowerManager$WakeLock
 */
package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.Logger;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.background.systemalarm.CommandHandler;
import androidx.work.impl.background.systemalarm.DelayMetCommandHandler$$ExternalSyntheticLambda0;
import androidx.work.impl.background.systemalarm.DelayMetCommandHandler$$ExternalSyntheticLambda1;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import java.util.concurrent.Executor;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;

public class DelayMetCommandHandler
implements OnConstraintsStateChangedListener,
WorkTimer.TimeLimitExceededListener {
    private static final int STATE_INITIAL = 0;
    private static final int STATE_START_REQUESTED = 1;
    private static final int STATE_STOP_REQUESTED = 2;
    private static final String TAG = Logger.tagWithPrefix("DelayMetCommandHandler");
    private final Context mContext;
    private final CoroutineDispatcher mCoroutineDispatcher;
    private int mCurrentState;
    private final SystemAlarmDispatcher mDispatcher;
    private boolean mHasConstraints;
    private volatile Job mJob;
    private final Object mLock;
    private final Executor mMainThreadExecutor;
    private final Executor mSerialExecutor;
    private final int mStartId;
    private final StartStopToken mToken;
    private PowerManager.WakeLock mWakeLock;
    private final WorkConstraintsTracker mWorkConstraintsTracker;
    private final WorkGenerationalId mWorkGenerationalId;

    public static /* synthetic */ void $r8$lambda$eO2qKQGv6m2bOk3OWPYOjoDKq0o(DelayMetCommandHandler delayMetCommandHandler) {
        delayMetCommandHandler.startWork();
    }

    public static /* synthetic */ void $r8$lambda$zaVpSTkR_s413bgOQo09yONkKkY(DelayMetCommandHandler delayMetCommandHandler) {
        delayMetCommandHandler.stopWork();
    }

    DelayMetCommandHandler(Context object, int n, SystemAlarmDispatcher systemAlarmDispatcher, StartStopToken startStopToken) {
        this.mContext = object;
        this.mStartId = n;
        this.mDispatcher = systemAlarmDispatcher;
        this.mWorkGenerationalId = startStopToken.getId();
        this.mToken = startStopToken;
        object = systemAlarmDispatcher.getWorkManager().getTrackers();
        this.mSerialExecutor = systemAlarmDispatcher.getTaskExecutor().getSerialTaskExecutor();
        this.mMainThreadExecutor = systemAlarmDispatcher.getTaskExecutor().getMainThreadExecutor();
        this.mCoroutineDispatcher = systemAlarmDispatcher.getTaskExecutor().getTaskCoroutineDispatcher();
        this.mWorkConstraintsTracker = new WorkConstraintsTracker((Trackers)object);
        this.mHasConstraints = false;
        this.mCurrentState = 0;
        this.mLock = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void cleanUp() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mJob != null) {
                this.mJob.cancel(null);
            }
            this.mDispatcher.getWorkTimer().stopTimer(this.mWorkGenerationalId);
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                Logger logger = Logger.get();
                String string2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                logger.debug(string2, stringBuilder.append("Releasing wakelock ").append(this.mWakeLock).append("for WorkSpec ").append(this.mWorkGenerationalId).toString());
                this.mWakeLock.release();
            }
            return;
        }
    }

    private void startWork() {
        if (this.mCurrentState == 0) {
            this.mCurrentState = 1;
            Logger.get().debug(TAG, "onAllConstraintsMet for " + this.mWorkGenerationalId);
            if (this.mDispatcher.getProcessor().startWork(this.mToken)) {
                this.mDispatcher.getWorkTimer().startTimer(this.mWorkGenerationalId, 600000L, this);
            } else {
                this.cleanUp();
            }
        } else {
            Logger.get().debug(TAG, "Already started work for " + this.mWorkGenerationalId);
        }
    }

    private void stopWork() {
        String string2 = this.mWorkGenerationalId.getWorkSpecId();
        if (this.mCurrentState < 2) {
            this.mCurrentState = 2;
            Logger.get().debug(TAG, "Stopping work for WorkSpec " + string2);
            Intent intent = CommandHandler.createStopWorkIntent(this.mContext, this.mWorkGenerationalId);
            this.mMainThreadExecutor.execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, intent, this.mStartId));
            if (this.mDispatcher.getProcessor().isEnqueued(this.mWorkGenerationalId.getWorkSpecId())) {
                Logger.get().debug(TAG, "WorkSpec " + string2 + " needs to be rescheduled");
                string2 = CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkGenerationalId);
                this.mMainThreadExecutor.execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, (Intent)string2, this.mStartId));
            } else {
                Logger.get().debug(TAG, "Processor does not have WorkSpec " + string2 + ". No need to reschedule");
            }
        } else {
            Logger.get().debug(TAG, "Already stopped work for " + string2);
        }
    }

    void handleProcessWork() {
        String string2 = this.mWorkGenerationalId.getWorkSpecId();
        this.mWakeLock = WakeLocks.newWakeLock(this.mContext, string2 + " (" + this.mStartId + ")");
        Logger.get().debug(TAG, "Acquiring wakelock " + this.mWakeLock + "for WorkSpec " + string2);
        this.mWakeLock.acquire();
        WorkSpec workSpec = this.mDispatcher.getWorkManager().getWorkDatabase().workSpecDao().getWorkSpec(string2);
        if (workSpec == null) {
            this.mSerialExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(this));
            return;
        }
        this.mHasConstraints = workSpec.hasConstraints();
        if (!this.mHasConstraints) {
            Logger.get().debug(TAG, "No constraints for " + string2);
            this.mSerialExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda1(this));
        } else {
            this.mJob = WorkConstraintsTrackerKt.listen(this.mWorkConstraintsTracker, workSpec, this.mCoroutineDispatcher, this);
        }
    }

    @Override
    public void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState constraintsState) {
        if (constraintsState instanceof ConstraintsState.ConstraintsMet) {
            this.mSerialExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda1(this));
        } else {
            this.mSerialExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(this));
        }
    }

    void onExecuted(boolean bl) {
        Intent intent;
        Logger.get().debug(TAG, "onExecuted " + this.mWorkGenerationalId + ", " + bl);
        this.cleanUp();
        if (bl) {
            intent = CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkGenerationalId);
            this.mMainThreadExecutor.execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, intent, this.mStartId));
        }
        if (this.mHasConstraints) {
            intent = CommandHandler.createConstraintsChangedIntent(this.mContext);
            this.mMainThreadExecutor.execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, intent, this.mStartId));
        }
    }

    @Override
    public void onTimeLimitExceeded(WorkGenerationalId workGenerationalId) {
        Logger.get().debug(TAG, "Exceeded time limits on execution for " + workGenerationalId);
        this.mSerialExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(this));
    }
}

