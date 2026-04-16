/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.background.greedy;

import androidx.work.Clock;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

public class DelayedWorkTracker {
    static final String TAG = Logger.tagWithPrefix("DelayedWorkTracker");
    private final Clock mClock;
    final Scheduler mImmediateScheduler;
    private final RunnableScheduler mRunnableScheduler;
    private final Map<String, Runnable> mRunnables;

    public DelayedWorkTracker(Scheduler scheduler, RunnableScheduler runnableScheduler, Clock clock) {
        this.mImmediateScheduler = scheduler;
        this.mRunnableScheduler = runnableScheduler;
        this.mClock = clock;
        this.mRunnables = new HashMap<String, Runnable>();
    }

    public void schedule(WorkSpec workSpec, long l) {
        Runnable runnable2 = this.mRunnables.remove(workSpec.id);
        if (runnable2 != null) {
            this.mRunnableScheduler.cancel(runnable2);
        }
        runnable2 = new Runnable(){
            final DelayedWorkTracker this$0;
            final WorkSpec val$workSpec;
            {
                this.this$0 = delayedWorkTracker;
                this.val$workSpec = workSpec;
            }

            @Override
            public void run() {
                Logger.get().debug(TAG, "Scheduling work " + this.val$workSpec.id);
                this.this$0.mImmediateScheduler.schedule(this.val$workSpec);
            }
        };
        this.mRunnables.put(workSpec.id, runnable2);
        long l2 = this.mClock.currentTimeMillis();
        this.mRunnableScheduler.scheduleWithDelay(l - l2, runnable2);
    }

    public void unschedule(String object) {
        if ((object = this.mRunnables.remove(object)) != null) {
            this.mRunnableScheduler.cancel((Runnable)object);
        }
    }
}

