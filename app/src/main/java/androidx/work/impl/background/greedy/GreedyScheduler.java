/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package androidx.work.impl.background.greedy;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.background.greedy.DelayedWorkTracker;
import androidx.work.impl.background.greedy.TimeLimiter;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlinx.coroutines.Job;

public class GreedyScheduler
implements Scheduler,
OnConstraintsStateChangedListener,
ExecutionListener {
    private static final int NON_THROTTLE_RUN_ATTEMPT_COUNT = 5;
    private static final String TAG = Logger.tagWithPrefix("GreedyScheduler");
    private final Configuration mConfiguration;
    private final Map<WorkGenerationalId, Job> mConstrainedWorkSpecs = new HashMap<WorkGenerationalId, Job>();
    private final WorkConstraintsTracker mConstraintsTracker;
    private final Context mContext;
    private DelayedWorkTracker mDelayedWorkTracker;
    private final Map<WorkGenerationalId, AttemptData> mFirstRunAttempts;
    Boolean mInDefaultProcess;
    private final Object mLock = new Object();
    private final Processor mProcessor;
    private boolean mRegisteredExecutionListener;
    private final StartStopTokens mStartStopTokens = new StartStopTokens();
    private final TaskExecutor mTaskExecutor;
    private final TimeLimiter mTimeLimiter;
    private final WorkLauncher mWorkLauncher;

    public GreedyScheduler(Context object, Configuration configuration2, Trackers trackers, Processor processor, WorkLauncher workLauncher, TaskExecutor taskExecutor) {
        this.mFirstRunAttempts = new HashMap<WorkGenerationalId, AttemptData>();
        this.mContext = object;
        object = configuration2.getRunnableScheduler();
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, (RunnableScheduler)object, configuration2.getClock());
        this.mTimeLimiter = new TimeLimiter((RunnableScheduler)object, workLauncher);
        this.mTaskExecutor = taskExecutor;
        this.mConstraintsTracker = new WorkConstraintsTracker(trackers);
        this.mConfiguration = configuration2;
        this.mProcessor = processor;
        this.mWorkLauncher = workLauncher;
    }

    private void checkDefaultProcess() {
        this.mInDefaultProcess = ProcessUtils.isDefaultProcess(this.mContext, this.mConfiguration);
    }

    private void registerExecutionListenerIfNeeded() {
        if (!this.mRegisteredExecutionListener) {
            this.mProcessor.addExecutionListener(this);
            this.mRegisteredExecutionListener = true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void removeConstraintTrackingFor(WorkGenerationalId workGenerationalId) {
        Object object = this.mLock;
        // MONITORENTER : object
        Job job2 = this.mConstrainedWorkSpecs.remove(workGenerationalId);
        // MONITOREXIT : object
        if (job2 == null) return;
        Logger.get().debug(TAG, "Stopping tracking for " + workGenerationalId);
        job2.cancel(null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private long throttleIfNeeded(WorkSpec workSpec) {
        Object object = this.mLock;
        synchronized (object) {
            AttemptData attemptData;
            WorkGenerationalId workGenerationalId = WorkSpecKt.generationalId(workSpec);
            AttemptData attemptData2 = attemptData = this.mFirstRunAttempts.get(workGenerationalId);
            if (attemptData == null) {
                attemptData2 = new AttemptData(workSpec.runAttemptCount, this.mConfiguration.getClock().currentTimeMillis());
                this.mFirstRunAttempts.put(workGenerationalId, attemptData2);
            }
            long l = attemptData2.mTimeStamp;
            long l2 = Math.max(workSpec.runAttemptCount - attemptData2.mRunAttemptCount - 5, 0);
            return l + l2 * 30000L;
        }
    }

    @Override
    public void cancel(String object2) {
        if (this.mInDefaultProcess == null) {
            this.checkDefaultProcess();
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in non-main process");
            return;
        }
        this.registerExecutionListenerIfNeeded();
        Logger.get().debug(TAG, "Cancelling work ID " + (String)object2);
        if (this.mDelayedWorkTracker != null) {
            this.mDelayedWorkTracker.unschedule((String)object2);
        }
        for (StartStopToken startStopToken : this.mStartStopTokens.remove((String)object2)) {
            this.mTimeLimiter.cancel(startStopToken);
            this.mWorkLauncher.stopWork(startStopToken);
        }
    }

    @Override
    public boolean hasLimitedSchedulingSlots() {
        return false;
    }

    @Override
    public void onConstraintsStateChanged(WorkSpec object, ConstraintsState constraintsState) {
        object = WorkSpecKt.generationalId((WorkSpec)object);
        if (constraintsState instanceof ConstraintsState.ConstraintsMet) {
            if (!this.mStartStopTokens.contains((WorkGenerationalId)object)) {
                Logger.get().debug(TAG, "Constraints met: Scheduling work ID " + object);
                object = this.mStartStopTokens.tokenFor((WorkGenerationalId)object);
                this.mTimeLimiter.track((StartStopToken)object);
                this.mWorkLauncher.startWork((StartStopToken)object);
            }
        } else {
            Logger.get().debug(TAG, "Constraints not met: Cancelling work ID " + object);
            object = this.mStartStopTokens.remove((WorkGenerationalId)object);
            if (object != null) {
                this.mTimeLimiter.cancel((StartStopToken)object);
                int n = ((ConstraintsState.ConstraintsNotMet)constraintsState).getReason();
                this.mWorkLauncher.stopWorkWithReason((StartStopToken)object, n);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onExecuted(WorkGenerationalId workGenerationalId, boolean bl) {
        Object object = this.mStartStopTokens.remove(workGenerationalId);
        if (object != null) {
            this.mTimeLimiter.cancel((StartStopToken)object);
        }
        this.removeConstraintTrackingFor(workGenerationalId);
        if (bl) return;
        object = this.mLock;
        synchronized (object) {
            this.mFirstRunAttempts.remove(workGenerationalId);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void schedule(WorkSpec ... object) {
        Object object2;
        if (this.mInDefaultProcess == null) {
            this.checkDefaultProcess();
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in a secondary process");
            return;
        }
        this.registerExecutionListenerIfNeeded();
        Object object3 = new HashSet();
        Iterator<String> iterator2 = new HashSet();
        for (Object object4 : object) {
            object2 = WorkSpecKt.generationalId((WorkSpec)object4);
            if (this.mStartStopTokens.contains((WorkGenerationalId)object2)) continue;
            long l = this.throttleIfNeeded((WorkSpec)object4);
            long l2 = Math.max(((WorkSpec)object4).calculateNextRunTime(), l);
            l = this.mConfiguration.getClock().currentTimeMillis();
            if (((WorkSpec)object4).state != WorkInfo.State.ENQUEUED) continue;
            if (l < l2) {
                if (this.mDelayedWorkTracker == null) continue;
                this.mDelayedWorkTracker.schedule((WorkSpec)object4, l2);
                continue;
            }
            if (((WorkSpec)object4).hasConstraints()) {
                if (((WorkSpec)object4).constraints.requiresDeviceIdle()) {
                    Logger.get().debug(TAG, "Ignoring " + object4 + ". Requires device idle.");
                    continue;
                }
                if (((WorkSpec)object4).constraints.hasContentUriTriggers()) {
                    Logger.get().debug(TAG, "Ignoring " + object4 + ". Requires ContentUri triggers.");
                    continue;
                }
                object3.add(object4);
                iterator2.add(((WorkSpec)object4).id);
                continue;
            }
            if (this.mStartStopTokens.contains(WorkSpecKt.generationalId((WorkSpec)object4))) continue;
            Logger.get().debug(TAG, "Starting work for " + ((WorkSpec)object4).id);
            object4 = this.mStartStopTokens.tokenFor((WorkSpec)object4);
            this.mTimeLimiter.track((StartStopToken)object4);
            this.mWorkLauncher.startWork((StartStopToken)object4);
        }
        object = this.mLock;
        synchronized (object) {
            if (!object3.isEmpty()) {
                Object object4;
                iterator2 = TextUtils.join((CharSequence)",", iterator2);
                object4 = Logger.get();
                String string2 = TAG;
                object2 = new StringBuilder();
                ((Logger)object4).debug(string2, ((StringBuilder)object2).append("Starting tracking for ").append((String)((Object)iterator2)).toString());
                iterator2 = object3.iterator();
                while (iterator2.hasNext()) {
                    object4 = (WorkSpec)iterator2.next();
                    object3 = WorkSpecKt.generationalId((WorkSpec)object4);
                    if (this.mConstrainedWorkSpecs.containsKey(object3)) continue;
                    object4 = WorkConstraintsTrackerKt.listen(this.mConstraintsTracker, (WorkSpec)object4, this.mTaskExecutor.getTaskCoroutineDispatcher(), this);
                    this.mConstrainedWorkSpecs.put((WorkGenerationalId)object3, (Job)object4);
                }
            }
            return;
        }
    }

    public void setDelayedWorkTracker(DelayedWorkTracker delayedWorkTracker) {
        this.mDelayedWorkTracker = delayedWorkTracker;
    }

    private static class AttemptData {
        final int mRunAttemptCount;
        final long mTimeStamp;

        private AttemptData(int n, long l) {
            this.mRunAttemptCount = n;
            this.mTimeStamp = l;
        }
    }
}

