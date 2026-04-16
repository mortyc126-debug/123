/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.HashMap;
import java.util.Map;

public class WorkTimer {
    private static final String TAG = Logger.tagWithPrefix("WorkTimer");
    final Map<WorkGenerationalId, TimeLimitExceededListener> mListeners;
    final Object mLock;
    final RunnableScheduler mRunnableScheduler;
    final Map<WorkGenerationalId, WorkTimerRunnable> mTimerMap = new HashMap<WorkGenerationalId, WorkTimerRunnable>();

    public WorkTimer(RunnableScheduler runnableScheduler) {
        this.mListeners = new HashMap<WorkGenerationalId, TimeLimitExceededListener>();
        this.mLock = new Object();
        this.mRunnableScheduler = runnableScheduler;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map<WorkGenerationalId, TimeLimitExceededListener> getListeners() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mListeners;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map<WorkGenerationalId, WorkTimerRunnable> getTimerMap() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mTimerMap;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void startTimer(WorkGenerationalId workGenerationalId, long l, TimeLimitExceededListener timeLimitExceededListener) {
        Object object = this.mLock;
        synchronized (object) {
            Logger logger = Logger.get();
            String string2 = TAG;
            Object object2 = new StringBuilder();
            logger.debug(string2, ((StringBuilder)object2).append("Starting timer for ").append(workGenerationalId).toString());
            this.stopTimer(workGenerationalId);
            object2 = new WorkTimerRunnable(this, workGenerationalId);
            this.mTimerMap.put(workGenerationalId, (WorkTimerRunnable)object2);
            this.mListeners.put(workGenerationalId, timeLimitExceededListener);
            this.mRunnableScheduler.scheduleWithDelay(l, (Runnable)object2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void stopTimer(WorkGenerationalId workGenerationalId) {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mTimerMap.remove(workGenerationalId) != null) {
                Logger logger = Logger.get();
                String string2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                logger.debug(string2, stringBuilder.append("Stopping timer for ").append(workGenerationalId).toString());
                this.mListeners.remove(workGenerationalId);
            }
            return;
        }
    }

    public static interface TimeLimitExceededListener {
        public void onTimeLimitExceeded(WorkGenerationalId var1);
    }

    public static class WorkTimerRunnable
    implements Runnable {
        static final String TAG = "WrkTimerRunnable";
        private final WorkGenerationalId mWorkGenerationalId;
        private final WorkTimer mWorkTimer;

        WorkTimerRunnable(WorkTimer workTimer, WorkGenerationalId workGenerationalId) {
            this.mWorkTimer = workTimer;
            this.mWorkGenerationalId = workGenerationalId;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void run() {
            Object object = this.mWorkTimer.mLock;
            synchronized (object) {
                if (this.mWorkTimer.mTimerMap.remove(this.mWorkGenerationalId) != null) {
                    TimeLimitExceededListener timeLimitExceededListener = this.mWorkTimer.mListeners.remove(this.mWorkGenerationalId);
                    if (timeLimitExceededListener != null) {
                        timeLimitExceededListener.onTimeLimitExceeded(this.mWorkGenerationalId);
                    }
                } else {
                    Logger.get().debug(TAG, String.format("Timer with %s is already marked as complete.", this.mWorkGenerationalId));
                }
                return;
            }
        }
    }
}

