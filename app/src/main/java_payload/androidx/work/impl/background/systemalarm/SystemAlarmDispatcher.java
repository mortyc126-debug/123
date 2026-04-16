/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Looper
 *  android.os.PowerManager$WakeLock
 *  android.text.TextUtils
 */
package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.CommandHandler;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SystemAlarmDispatcher
implements ExecutionListener {
    private static final int DEFAULT_START_ID = 0;
    private static final String KEY_START_ID = "KEY_START_ID";
    private static final String PROCESS_COMMAND_TAG = "ProcessCommand";
    static final String TAG = Logger.tagWithPrefix("SystemAlarmDispatcher");
    final CommandHandler mCommandHandler;
    private CommandsCompletedListener mCompletedListener;
    final Context mContext;
    Intent mCurrentIntent;
    final List<Intent> mIntents;
    private final Processor mProcessor;
    private StartStopTokens mStartStopTokens;
    final TaskExecutor mTaskExecutor;
    private final WorkLauncher mWorkLauncher;
    private final WorkManagerImpl mWorkManager;
    private final WorkTimer mWorkTimer;

    SystemAlarmDispatcher(Context context) {
        this(context, null, null, null);
    }

    SystemAlarmDispatcher(Context context, Processor processor, WorkManagerImpl workManagerImpl, WorkLauncher workLauncher) {
        this.mContext = context.getApplicationContext();
        this.mStartStopTokens = new StartStopTokens();
        if (workManagerImpl == null) {
            workManagerImpl = WorkManagerImpl.getInstance(context);
        }
        this.mWorkManager = workManagerImpl;
        this.mCommandHandler = new CommandHandler(this.mContext, this.mWorkManager.getConfiguration().getClock(), this.mStartStopTokens);
        this.mWorkTimer = new WorkTimer(this.mWorkManager.getConfiguration().getRunnableScheduler());
        if (processor == null) {
            processor = this.mWorkManager.getProcessor();
        }
        this.mProcessor = processor;
        this.mTaskExecutor = this.mWorkManager.getWorkTaskExecutor();
        if (workLauncher == null) {
            workLauncher = new WorkLauncherImpl(this.mProcessor, this.mTaskExecutor);
        }
        this.mWorkLauncher = workLauncher;
        this.mProcessor.addExecutionListener(this);
        this.mIntents = new ArrayList<Intent>();
        this.mCurrentIntent = null;
    }

    private void assertMainThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        throw new IllegalStateException("Needs to be invoked on the main thread.");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean hasIntentWithAction(String string2) {
        this.assertMainThread();
        List<Intent> list = this.mIntents;
        synchronized (list) {
            Iterator<Intent> iterator2 = this.mIntents.iterator();
            do {
                if (iterator2.hasNext()) continue;
                return false;
            } while (!string2.equals(iterator2.next().getAction()));
            return true;
        }
    }

    private void processCommand() {
        this.assertMainThread();
        PowerManager.WakeLock wakeLock = WakeLocks.newWakeLock(this.mContext, PROCESS_COMMAND_TAG);
        try {
            wakeLock.acquire();
            TaskExecutor taskExecutor = this.mWorkManager.getWorkTaskExecutor();
            Runnable runnable2 = new Runnable(this){
                final SystemAlarmDispatcher this$0;
                {
                    this.this$0 = systemAlarmDispatcher;
                }

                /*
                 * Unable to fully structure code
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                @Override
                public void run() {
                    var2_1 = this.this$0.mIntents;
                    synchronized (var2_1) {
                        this.this$0.mCurrentIntent = this.this$0.mIntents.get(0);
                    }
                    if (this.this$0.mCurrentIntent == null) return;
                    var2_1 = this.this$0.mCurrentIntent.getAction();
                    var1_2 = this.this$0.mCurrentIntent.getIntExtra("KEY_START_ID", 0);
                    Logger.get().debug(SystemAlarmDispatcher.TAG, "Processing command " + this.this$0.mCurrentIntent + ", " + var1_2);
                    var3_3 /* !! */  = WakeLocks.newWakeLock(this.this$0.mContext, (String)var2_1 + " (" + var1_2 + ")");
                    try {
                        var6_4 = Logger.get();
                        var4_5 = SystemAlarmDispatcher.TAG;
                        var5_8 = new StringBuilder();
                        var6_4.debug(var4_5, var5_8.append("Acquiring operation wake lock (").append((String)var2_1).append(") ").append(var3_3 /* !! */ ).toString());
                        var3_3 /* !! */ .acquire();
                        this.this$0.mCommandHandler.onHandleIntent(this.this$0.mCurrentIntent, var1_2, this.this$0);
                        Logger.get().debug(SystemAlarmDispatcher.TAG, "Releasing operation wake lock (" + (String)var2_1 + ") " + var3_3 /* !! */ );
                        ** GOTO lbl28
                    }
                    catch (Throwable var4_6) {
                        try {
                            Logger.get().error(SystemAlarmDispatcher.TAG, "Unexpected error in onHandleIntent", var4_6);
                            Logger.get().debug(SystemAlarmDispatcher.TAG, "Releasing operation wake lock (" + (String)var2_1 + ") " + var3_3 /* !! */ );
                        }
                        catch (Throwable var4_7) {
                            Logger.get().debug(SystemAlarmDispatcher.TAG, "Releasing operation wake lock (" + (String)var2_1 + ") " + var3_3 /* !! */ );
                            var3_3 /* !! */ .release();
                            this.this$0.mTaskExecutor.getMainThreadExecutor().execute(new DequeueAndCheckForCompletion(this.this$0));
                            throw var4_7;
                        }
lbl28:
                        // 1 sources

                        var3_3 /* !! */ .release();
                        var2_1 = this.this$0.mTaskExecutor.getMainThreadExecutor();
                        var3_3 /* !! */  = new DequeueAndCheckForCompletion(this.this$0);
                        var3_3 /* !! */ .release();
                        var2_1 = this.this$0.mTaskExecutor.getMainThreadExecutor();
                        var3_3 /* !! */  = new DequeueAndCheckForCompletion(this.this$0);
                    }
                    var2_1.execute((Runnable)var3_3 /* !! */ );
                }
            };
            taskExecutor.executeOnTaskThread(runnable2);
            return;
        }
        finally {
            wakeLock.release();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean add(Intent intent, int n) {
        Logger.get().debug(TAG, "Adding command " + intent + " (" + n + ")");
        this.assertMainThread();
        Object object = intent.getAction();
        boolean bl = TextUtils.isEmpty((CharSequence)object);
        int n2 = 0;
        if (bl) {
            Logger.get().warning(TAG, "Unknown command. Ignoring");
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(object) && this.hasIntentWithAction("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        }
        intent.putExtra(KEY_START_ID, n);
        object = this.mIntents;
        synchronized (object) {
            n = n2;
            if (!this.mIntents.isEmpty()) {
                n = 1;
            }
            this.mIntents.add(intent);
            if (n == 0) {
                this.processCommand();
            }
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void dequeueAndCheckForCompletion() {
        Logger.get().debug(TAG, "Checking if commands are complete.");
        this.assertMainThread();
        List<Intent> list = this.mIntents;
        synchronized (list) {
            Object object;
            if (this.mCurrentIntent != null) {
                object = Logger.get();
                String string2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                ((Logger)object).debug(string2, stringBuilder.append("Removing command ").append(this.mCurrentIntent).toString());
                if (!this.mIntents.remove(0).equals(this.mCurrentIntent)) {
                    object = new IllegalStateException("Dequeue-d command is not the first.");
                    throw object;
                }
                this.mCurrentIntent = null;
            }
            object = this.mTaskExecutor.getSerialTaskExecutor();
            if (!this.mCommandHandler.hasPendingCommands() && this.mIntents.isEmpty() && !object.hasPendingTasks()) {
                Logger.get().debug(TAG, "No more commands & intents.");
                if (this.mCompletedListener != null) {
                    this.mCompletedListener.onAllCommandsCompleted();
                }
            } else if (!this.mIntents.isEmpty()) {
                this.processCommand();
            }
            return;
        }
    }

    Processor getProcessor() {
        return this.mProcessor;
    }

    TaskExecutor getTaskExecutor() {
        return this.mTaskExecutor;
    }

    WorkManagerImpl getWorkManager() {
        return this.mWorkManager;
    }

    WorkTimer getWorkTimer() {
        return this.mWorkTimer;
    }

    WorkLauncher getWorkerLauncher() {
        return this.mWorkLauncher;
    }

    void onDestroy() {
        Logger.get().debug(TAG, "Destroying SystemAlarmDispatcher");
        this.mProcessor.removeExecutionListener(this);
        this.mCompletedListener = null;
    }

    @Override
    public void onExecuted(WorkGenerationalId workGenerationalId, boolean bl) {
        this.mTaskExecutor.getMainThreadExecutor().execute(new AddRunnable(this, CommandHandler.createExecutionCompletedIntent(this.mContext, workGenerationalId, bl), 0));
    }

    void setCompletedListener(CommandsCompletedListener commandsCompletedListener) {
        if (this.mCompletedListener != null) {
            Logger.get().error(TAG, "A completion listener for SystemAlarmDispatcher already exists.");
            return;
        }
        this.mCompletedListener = commandsCompletedListener;
    }

    static class AddRunnable
    implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;
        private final Intent mIntent;
        private final int mStartId;

        AddRunnable(SystemAlarmDispatcher systemAlarmDispatcher, Intent intent, int n) {
            this.mDispatcher = systemAlarmDispatcher;
            this.mIntent = intent;
            this.mStartId = n;
        }

        @Override
        public void run() {
            this.mDispatcher.add(this.mIntent, this.mStartId);
        }
    }

    static interface CommandsCompletedListener {
        public void onAllCommandsCompleted();
    }

    static class DequeueAndCheckForCompletion
    implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;

        DequeueAndCheckForCompletion(SystemAlarmDispatcher systemAlarmDispatcher) {
            this.mDispatcher = systemAlarmDispatcher;
        }

        @Override
        public void run() {
            this.mDispatcher.dequeueAndCheckForCompletion();
        }
    }
}

