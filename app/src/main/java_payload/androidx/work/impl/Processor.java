/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.PowerManager$WakeLock
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work.impl;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor$$ExternalSyntheticLambda0;
import androidx.work.impl.Processor$$ExternalSyntheticLambda1;
import androidx.work.impl.Processor$$ExternalSyntheticLambda2;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Processor
implements ForegroundProcessor {
    private static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    private static final String TAG = Logger.tagWithPrefix("Processor");
    private Context mAppContext;
    private Set<String> mCancelledIds;
    private Configuration mConfiguration;
    private Map<String, WorkerWrapper> mEnqueuedWorkMap;
    private PowerManager.WakeLock mForegroundLock;
    private Map<String, WorkerWrapper> mForegroundWorkMap;
    private final Object mLock;
    private final List<ExecutionListener> mOuterListeners;
    private WorkDatabase mWorkDatabase;
    private Map<String, Set<StartStopToken>> mWorkRuns;
    private TaskExecutor mWorkTaskExecutor;

    public Processor(Context context, Configuration configuration2, TaskExecutor taskExecutor, WorkDatabase workDatabase) {
        this.mAppContext = context;
        this.mConfiguration = configuration2;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mEnqueuedWorkMap = new HashMap<String, WorkerWrapper>();
        this.mForegroundWorkMap = new HashMap<String, WorkerWrapper>();
        this.mCancelledIds = new HashSet<String>();
        this.mOuterListeners = new ArrayList<ExecutionListener>();
        this.mForegroundLock = null;
        this.mLock = new Object();
        this.mWorkRuns = new HashMap<String, Set<StartStopToken>>();
    }

    private WorkerWrapper cleanUpWorkerUnsafe(String string2) {
        WorkerWrapper workerWrapper = this.mForegroundWorkMap.remove(string2);
        boolean bl = workerWrapper != null;
        if (!bl) {
            workerWrapper = this.mEnqueuedWorkMap.remove(string2);
        }
        this.mWorkRuns.remove(string2);
        if (bl) {
            this.stopForegroundService();
        }
        return workerWrapper;
    }

    private WorkerWrapper getWorkerWrapperUnsafe(String string2) {
        WorkerWrapper workerWrapper;
        WorkerWrapper workerWrapper2 = workerWrapper = this.mForegroundWorkMap.get(string2);
        if (workerWrapper == null) {
            workerWrapper2 = this.mEnqueuedWorkMap.get(string2);
        }
        return workerWrapper2;
    }

    private static boolean interrupt(String string2, WorkerWrapper workerWrapper, int n) {
        if (workerWrapper != null) {
            workerWrapper.interrupt(n);
            Logger.get().debug(TAG, "WorkerWrapper interrupted for " + string2);
            return true;
        }
        Logger.get().debug(TAG, "WorkerWrapper could not be found for " + string2);
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onExecuted(WorkerWrapper iterator2, boolean bl) {
        Object object = this.mLock;
        synchronized (object) {
            WorkGenerationalId workGenerationalId = ((WorkerWrapper)((Object)iterator2)).getWorkGenerationalId();
            String string2 = workGenerationalId.getWorkSpecId();
            if (this.getWorkerWrapperUnsafe(string2) == iterator2) {
                this.cleanUpWorkerUnsafe(string2);
            }
            Logger logger = Logger.get();
            iterator2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            logger.debug((String)((Object)iterator2), stringBuilder.append(this.getClass().getSimpleName()).append(" ").append(string2).append(" executed; reschedule = ").append(bl).toString());
            iterator2 = this.mOuterListeners.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().onExecuted(workGenerationalId, bl);
            }
            return;
        }
    }

    private void runOnExecuted(WorkGenerationalId workGenerationalId, boolean bl) {
        this.mWorkTaskExecutor.getMainThreadExecutor().execute(new Processor$$ExternalSyntheticLambda2(this, workGenerationalId, bl));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void stopForegroundService() {
        Object object = this.mLock;
        synchronized (object) {
            if (!(this.mForegroundWorkMap.isEmpty() ^ true)) {
                Intent intent = SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext);
                try {
                    this.mAppContext.startService(intent);
                }
                catch (Throwable throwable) {
                    Logger.get().error(TAG, "Unable to stop foreground service", throwable);
                }
                if (this.mForegroundLock != null) {
                    this.mForegroundLock.release();
                    this.mForegroundLock = null;
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addExecutionListener(ExecutionListener executionListener) {
        Object object = this.mLock;
        synchronized (object) {
            this.mOuterListeners.add(executionListener);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public WorkSpec getRunningWorkSpec(String object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            object = this.getWorkerWrapperUnsafe((String)object);
            if (object == null) return null;
            return ((WorkerWrapper)object).getWorkSpec();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasWork() {
        Object object = this.mLock;
        synchronized (object) {
            if (!this.mEnqueuedWorkMap.isEmpty()) return true;
            if (this.mForegroundWorkMap.isEmpty()) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isCancelled(String string2) {
        Object object = this.mLock;
        synchronized (object) {
            return this.mCancelledIds.contains(string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isEnqueued(String string2) {
        Object object = this.mLock;
        synchronized (object) {
            if (this.getWorkerWrapperUnsafe(string2) == null) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    /* synthetic */ void lambda$runOnExecuted$2$androidx-work-impl-Processor(WorkGenerationalId workGenerationalId, boolean bl) {
        Object object = this.mLock;
        synchronized (object) {
            Iterator<ExecutionListener> iterator2 = this.mOuterListeners.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().onExecuted(workGenerationalId, bl);
            }
            return;
        }
    }

    /* synthetic */ WorkSpec lambda$startWork$0$androidx-work-impl-Processor(ArrayList arrayList, String string2) throws Exception {
        arrayList.addAll(this.mWorkDatabase.workTagDao().getTagsForWorkSpecId(string2));
        return this.mWorkDatabase.workSpecDao().getWorkSpec(string2);
    }

    /* synthetic */ void lambda$startWork$1$androidx-work-impl-Processor(ListenableFuture listenableFuture, WorkerWrapper workerWrapper) {
        boolean bl;
        block3: {
            try {
                bl = (Boolean)listenableFuture.get();
                break block3;
            }
            catch (ExecutionException executionException) {
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            bl = true;
        }
        this.onExecuted(workerWrapper, bl);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeExecutionListener(ExecutionListener executionListener) {
        Object object = this.mLock;
        synchronized (object) {
            this.mOuterListeners.remove(executionListener);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void startForeground(String string2, ForegroundInfo foregroundInfo) {
        Object object = this.mLock;
        synchronized (object) {
            Logger logger = Logger.get();
            String string3 = TAG;
            Object object2 = new StringBuilder();
            logger.info(string3, ((StringBuilder)object2).append("Moving WorkSpec (").append(string2).append(") to the foreground").toString());
            object2 = this.mEnqueuedWorkMap.remove(string2);
            if (object2 != null) {
                if (this.mForegroundLock == null) {
                    this.mForegroundLock = WakeLocks.newWakeLock(this.mAppContext, FOREGROUND_WAKELOCK_TAG);
                    this.mForegroundLock.acquire();
                }
                this.mForegroundWorkMap.put(string2, (WorkerWrapper)object2);
                string2 = SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, ((WorkerWrapper)object2).getWorkGenerationalId(), foregroundInfo);
                ContextCompat.startForegroundService(this.mAppContext, (Intent)string2);
            }
            return;
        }
    }

    public boolean startWork(StartStopToken startStopToken) {
        return this.startWork(startStopToken, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public boolean startWork(StartStopToken object, WorkerParameters.RuntimeExtras set) {
        Set<StartStopToken> set2;
        ArrayList<String> arrayList = new ArrayList<String>();
        WorkGenerationalId workGenerationalId = ((StartStopToken)object).getId();
        CharSequence charSequence = workGenerationalId.getWorkSpecId();
        Object object2 = (WorkSpec)this.mWorkDatabase.runInTransaction(new Processor$$ExternalSyntheticLambda0(this, arrayList, (String)charSequence));
        if (object2 == null) {
            Logger.get().warning(TAG, "Didn't find WorkSpec for id " + workGenerationalId);
            this.runOnExecuted(workGenerationalId, false);
            return false;
        }
        Object object3 = this.mLock;
        // MONITORENTER : object3
        if (this.isEnqueued((String)charSequence)) {
            set2 = this.mWorkRuns.get(charSequence);
            if (set2.iterator().next().getId().getGeneration() == workGenerationalId.getGeneration()) {
                set2.add((StartStopToken)object);
                set2 = Logger.get();
                object = TAG;
                charSequence = new StringBuilder();
                ((Logger)((Object)set2)).debug((String)object, ((StringBuilder)charSequence).append("Work ").append(workGenerationalId).append(" is already enqueued for processing").toString());
                return false;
            }
            this.runOnExecuted(workGenerationalId, false);
            // MONITOREXIT : object3
            return false;
        }
        if (((WorkSpec)object2).getGeneration() != workGenerationalId.getGeneration()) {
            this.runOnExecuted(workGenerationalId, false);
            // MONITOREXIT : object3
            return false;
        }
        object2 = new WorkerWrapper.Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, this, this.mWorkDatabase, (WorkSpec)object2, arrayList);
        set2 = ((WorkerWrapper.Builder)object2).withRuntimeExtras((WorkerParameters.RuntimeExtras)((Object)set2)).build();
        object2 = ((WorkerWrapper)((Object)set2)).getFuture();
        arrayList = new Processor$$ExternalSyntheticLambda1(this, object2, (WorkerWrapper)((Object)set2));
        object2.addListener((Runnable)((Object)arrayList), this.mWorkTaskExecutor.getMainThreadExecutor());
        this.mEnqueuedWorkMap.put((String)charSequence, (WorkerWrapper)((Object)set2));
        object2 = new HashSet();
        ((HashSet)object2).add((Object)object);
        this.mWorkRuns.put((String)charSequence, (Set<StartStopToken>)object2);
        // MONITOREXIT : object3
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute((Runnable)((Object)set2));
        Logger.get().debug(TAG, this.getClass().getSimpleName() + ": processing " + workGenerationalId);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean stopAndCancelWork(String string2, int n) {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = Logger.get();
            String string3 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            ((Logger)object2).debug(string3, stringBuilder.append("Processor cancelling ").append(string2).toString());
            this.mCancelledIds.add(string2);
            object2 = this.cleanUpWorkerUnsafe(string2);
            return Processor.interrupt(string2, (WorkerWrapper)object2, n);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean stopForegroundWork(StartStopToken object, int n) {
        String string2 = ((StartStopToken)object).getId().getWorkSpecId();
        object = this.mLock;
        synchronized (object) {
            WorkerWrapper workerWrapper = this.cleanUpWorkerUnsafe(string2);
            return Processor.interrupt(string2, workerWrapper, n);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean stopWork(StartStopToken object, int n) {
        String string2 = ((StartStopToken)object).getId().getWorkSpecId();
        Object object2 = this.mLock;
        synchronized (object2) {
            if (this.mForegroundWorkMap.get(string2) != null) {
                Logger logger = Logger.get();
                object = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                logger.debug((String)object, stringBuilder.append("Ignored stopWork. WorkerWrapper ").append(string2).append(" is in foreground").toString());
                return false;
            }
            Set<StartStopToken> set = this.mWorkRuns.get(string2);
            if (set != null && set.contains(object)) {
                object = this.cleanUpWorkerUnsafe(string2);
                return Processor.interrupt(string2, (WorkerWrapper)object, n);
            }
            return false;
        }
    }
}

