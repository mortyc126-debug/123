/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver$PendingResult
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work.impl;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImplExtKt;
import androidx.work.impl.WorkerUpdater;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.RawWorkInfoDaoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDaoKt;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.PruneWorkRunnable;
import androidx.work.impl.utils.RawQueries;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.multiprocess.RemoteWorkManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import kotlinx.coroutines.flow.Flow;

public class WorkManagerImpl
extends WorkManager {
    public static final int CONTENT_URI_TRIGGER_API_LEVEL = 24;
    public static final int MAX_PRE_JOB_SCHEDULER_API_LEVEL = 22;
    public static final int MIN_JOB_SCHEDULER_API_LEVEL = 23;
    public static final String REMOTE_WORK_MANAGER_CLIENT = "androidx.work.multiprocess.RemoteWorkManagerClient";
    private static final String TAG = Logger.tagWithPrefix("WorkManagerImpl");
    private static WorkManagerImpl sDefaultInstance;
    private static WorkManagerImpl sDelegatedInstance;
    private static final Object sLock;
    private Configuration mConfiguration;
    private Context mContext;
    private boolean mForceStopRunnableCompleted = false;
    private PreferenceUtils mPreferenceUtils;
    private Processor mProcessor;
    private volatile RemoteWorkManager mRemoteWorkManager;
    private BroadcastReceiver.PendingResult mRescheduleReceiverResult;
    private List<Scheduler> mSchedulers;
    private final Trackers mTrackers;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;

    static {
        sDelegatedInstance = null;
        sDefaultInstance = null;
        sLock = new Object();
    }

    public WorkManagerImpl(Context context, Configuration configuration2, TaskExecutor taskExecutor, WorkDatabase workDatabase, List<Scheduler> list, Processor processor, Trackers trackers) {
        context = context.getApplicationContext();
        if (!Api24Impl.isDeviceProtectedStorage(context)) {
            Logger.setLogger(new Logger.LogcatLogger(configuration2.getMinimumLoggingLevel()));
            this.mContext = context;
            this.mWorkTaskExecutor = taskExecutor;
            this.mWorkDatabase = workDatabase;
            this.mProcessor = processor;
            this.mTrackers = trackers;
            this.mConfiguration = configuration2;
            this.mSchedulers = list;
            this.mPreferenceUtils = new PreferenceUtils(this.mWorkDatabase);
            Schedulers.registerRescheduling(list, this.mProcessor, taskExecutor.getSerialTaskExecutor(), this.mWorkDatabase, configuration2);
            this.mWorkTaskExecutor.executeOnTaskThread(new ForceStopRunnable(context, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Deprecated
    public static WorkManagerImpl getInstance() {
        Object object = sLock;
        synchronized (object) {
            if (sDelegatedInstance == null) return sDefaultInstance;
            return sDelegatedInstance;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static WorkManagerImpl getInstance(Context object) {
        Object object2 = sLock;
        synchronized (object2) {
            WorkManagerImpl workManagerImpl;
            WorkManagerImpl workManagerImpl2 = workManagerImpl = WorkManagerImpl.getInstance();
            if (workManagerImpl != null) return workManagerImpl2;
            if (!((object = object.getApplicationContext()) instanceof Configuration.Provider)) {
                object = new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                throw object;
            }
            WorkManagerImpl.initialize(object, ((Configuration.Provider)object).getWorkManagerConfiguration());
            return WorkManagerImpl.getInstance(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void initialize(Context object, Configuration configuration2) {
        Object object2 = sLock;
        synchronized (object2) {
            if (sDelegatedInstance != null && sDefaultInstance != null) {
                object = new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                throw object;
            }
            if (sDelegatedInstance == null) {
                object = object.getApplicationContext();
                if (sDefaultInstance == null) {
                    sDefaultInstance = WorkManagerImplExtKt.createWorkManager(object, configuration2);
                }
                sDelegatedInstance = sDefaultInstance;
            }
            return;
        }
    }

    public static boolean isInitialized() {
        boolean bl = WorkManagerImpl.getInstance() != null;
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void setDelegate(WorkManagerImpl workManagerImpl) {
        Object object = sLock;
        synchronized (object) {
            sDelegatedInstance = workManagerImpl;
            return;
        }
    }

    private void tryInitializeMultiProcessSupport() {
        try {
            this.mRemoteWorkManager = (RemoteWorkManager)Class.forName(REMOTE_WORK_MANAGER_CLIENT).getConstructor(Context.class, WorkManagerImpl.class).newInstance(this.mContext, this);
        }
        catch (Throwable throwable) {
            Logger.get().debug(TAG, "Unable to initialize multi-process support", throwable);
        }
    }

    @Override
    public WorkContinuation beginUniqueWork(String string2, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, string2, existingWorkPolicy, list);
        }
        throw new IllegalArgumentException("beginUniqueWork needs at least one OneTimeWorkRequest.");
    }

    @Override
    public WorkContinuation beginWith(List<OneTimeWorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, list);
        }
        throw new IllegalArgumentException("beginWith needs at least one OneTimeWorkRequest.");
    }

    @Override
    public Operation cancelAllWork() {
        CancelWorkRunnable cancelWorkRunnable = CancelWorkRunnable.forAll(this);
        this.mWorkTaskExecutor.executeOnTaskThread(cancelWorkRunnable);
        return cancelWorkRunnable.getOperation();
    }

    @Override
    public Operation cancelAllWorkByTag(String object) {
        object = CancelWorkRunnable.forTag((String)object, this);
        this.mWorkTaskExecutor.executeOnTaskThread((Runnable)object);
        return ((CancelWorkRunnable)object).getOperation();
    }

    @Override
    public Operation cancelUniqueWork(String object) {
        object = CancelWorkRunnable.forName((String)object, this, true);
        this.mWorkTaskExecutor.executeOnTaskThread((Runnable)object);
        return ((CancelWorkRunnable)object).getOperation();
    }

    @Override
    public Operation cancelWorkById(UUID object) {
        object = CancelWorkRunnable.forId((UUID)object, this);
        this.mWorkTaskExecutor.executeOnTaskThread((Runnable)object);
        return ((CancelWorkRunnable)object).getOperation();
    }

    @Override
    public PendingIntent createCancelPendingIntent(UUID uUID) {
        uUID = SystemForegroundDispatcher.createCancelWorkIntent(this.mContext, uUID.toString());
        int n = 0x8000000;
        if (Build.VERSION.SDK_INT >= 31) {
            n = 0x8000000 | 0x2000000;
        }
        return PendingIntent.getService((Context)this.mContext, (int)0, (Intent)uUID, (int)n);
    }

    public WorkContinuationImpl createWorkContinuationForUniquePeriodicWork(String string2, ExistingPeriodicWorkPolicy enum_, PeriodicWorkRequest periodicWorkRequest) {
        enum_ = enum_ == ExistingPeriodicWorkPolicy.KEEP ? ExistingWorkPolicy.KEEP : ExistingWorkPolicy.REPLACE;
        return new WorkContinuationImpl(this, string2, (ExistingWorkPolicy)enum_, Collections.singletonList(periodicWorkRequest));
    }

    @Override
    public Operation enqueue(List<? extends WorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, list).enqueue();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    @Override
    public Operation enqueueUniquePeriodicWork(String string2, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest) {
        if (existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.UPDATE) {
            return WorkerUpdater.enqueueUniquelyNamedPeriodic(this, string2, periodicWorkRequest);
        }
        return this.createWorkContinuationForUniquePeriodicWork(string2, existingPeriodicWorkPolicy, periodicWorkRequest).enqueue();
    }

    @Override
    public Operation enqueueUniqueWork(String string2, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list) {
        return new WorkContinuationImpl(this, string2, existingWorkPolicy, list).enqueue();
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    @Override
    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    @Override
    public ListenableFuture<Long> getLastCancelAllTimeMillis() {
        SettableFuture<Long> settableFuture = SettableFuture.create();
        PreferenceUtils preferenceUtils = this.mPreferenceUtils;
        this.mWorkTaskExecutor.executeOnTaskThread(new Runnable(){
            final WorkManagerImpl this$0;
            final SettableFuture val$future;
            final PreferenceUtils val$preferenceUtils;
            {
                this.this$0 = workManagerImpl;
                this.val$future = settableFuture;
                this.val$preferenceUtils = preferenceUtils;
            }

            @Override
            public void run() {
                try {
                    this.val$future.set(this.val$preferenceUtils.getLastCancelAllTimeMillis());
                }
                catch (Throwable throwable) {
                    this.val$future.setException(throwable);
                }
            }
        });
        return settableFuture;
    }

    @Override
    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return this.mPreferenceUtils.getLastCancelAllTimeMillisLiveData();
    }

    public PreferenceUtils getPreferenceUtils() {
        return this.mPreferenceUtils;
    }

    public Processor getProcessor() {
        return this.mProcessor;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public RemoteWorkManager getRemoteWorkManager() {
        if (this.mRemoteWorkManager != null) return this.mRemoteWorkManager;
        Object object = sLock;
        synchronized (object) {
            if (this.mRemoteWorkManager != null) return this.mRemoteWorkManager;
            this.tryInitializeMultiProcessSupport();
            if (this.mRemoteWorkManager != null) return this.mRemoteWorkManager;
            if (TextUtils.isEmpty((CharSequence)this.mConfiguration.getDefaultProcessName())) {
                return this.mRemoteWorkManager;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");
            throw illegalStateException;
        }
    }

    public List<Scheduler> getSchedulers() {
        return this.mSchedulers;
    }

    public Trackers getTrackers() {
        return this.mTrackers;
    }

    public WorkDatabase getWorkDatabase() {
        return this.mWorkDatabase;
    }

    @Override
    public ListenableFuture<WorkInfo> getWorkInfoById(UUID object) {
        object = StatusRunnable.forUUID(this, (UUID)object);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute((Runnable)object);
        return ((StatusRunnable)object).getFuture();
    }

    @Override
    public Flow<WorkInfo> getWorkInfoByIdFlow(UUID uUID) {
        return WorkSpecDaoKt.getWorkStatusPojoFlowDataForIds(this.getWorkDatabase().workSpecDao(), uUID);
    }

    @Override
    public LiveData<WorkInfo> getWorkInfoByIdLiveData(UUID uUID) {
        WorkSpecDao workSpecDao = this.mWorkDatabase.workSpecDao();
        return LiveDataUtils.dedupedMappedLiveDataFor(workSpecDao.getWorkStatusPojoLiveDataForIds(Collections.singletonList(uUID.toString())), new Function<List<WorkSpec.WorkInfoPojo>, WorkInfo>(this){
            final WorkManagerImpl this$0;
            {
                this.this$0 = workManagerImpl;
            }

            @Override
            public WorkInfo apply(List<WorkSpec.WorkInfoPojo> list) {
                WorkInfo workInfo;
                WorkInfo workInfo2 = workInfo = null;
                if (list != null) {
                    workInfo2 = workInfo;
                    if (list.size() > 0) {
                        workInfo2 = list.get(0).toWorkInfo();
                    }
                }
                return workInfo2;
            }
        }, this.mWorkTaskExecutor);
    }

    @Override
    public ListenableFuture<List<WorkInfo>> getWorkInfos(WorkQuery object) {
        object = StatusRunnable.forWorkQuerySpec(this, (WorkQuery)object);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute((Runnable)object);
        return ((StatusRunnable)object).getFuture();
    }

    LiveData<List<WorkInfo>> getWorkInfosById(List<String> list) {
        WorkSpecDao workSpecDao = this.mWorkDatabase.workSpecDao();
        return LiveDataUtils.dedupedMappedLiveDataFor(workSpecDao.getWorkStatusPojoLiveDataForIds(list), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override
    public ListenableFuture<List<WorkInfo>> getWorkInfosByTag(String object) {
        object = StatusRunnable.forTag(this, (String)object);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute((Runnable)object);
        return ((StatusRunnable)object).getFuture();
    }

    @Override
    public Flow<List<WorkInfo>> getWorkInfosByTagFlow(String string2) {
        return WorkSpecDaoKt.getWorkStatusPojoFlowForTag(this.mWorkDatabase.workSpecDao(), this.mWorkTaskExecutor.getTaskCoroutineDispatcher(), string2);
    }

    @Override
    public LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(String string2) {
        WorkSpecDao workSpecDao = this.mWorkDatabase.workSpecDao();
        return LiveDataUtils.dedupedMappedLiveDataFor(workSpecDao.getWorkStatusPojoLiveDataForTag(string2), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override
    public Flow<List<WorkInfo>> getWorkInfosFlow(WorkQuery workQuery) {
        return RawWorkInfoDaoKt.getWorkInfoPojosFlow(this.mWorkDatabase.rawWorkInfoDao(), this.mWorkTaskExecutor.getTaskCoroutineDispatcher(), RawQueries.toRawQuery(workQuery));
    }

    @Override
    public ListenableFuture<List<WorkInfo>> getWorkInfosForUniqueWork(String object) {
        object = StatusRunnable.forUniqueWork(this, (String)object);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute((Runnable)object);
        return ((StatusRunnable)object).getFuture();
    }

    @Override
    public Flow<List<WorkInfo>> getWorkInfosForUniqueWorkFlow(String string2) {
        return WorkSpecDaoKt.getWorkStatusPojoFlowForName(this.mWorkDatabase.workSpecDao(), this.mWorkTaskExecutor.getTaskCoroutineDispatcher(), string2);
    }

    @Override
    public LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(String string2) {
        WorkSpecDao workSpecDao = this.mWorkDatabase.workSpecDao();
        return LiveDataUtils.dedupedMappedLiveDataFor(workSpecDao.getWorkStatusPojoLiveDataForName(string2), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override
    public LiveData<List<WorkInfo>> getWorkInfosLiveData(WorkQuery workQuery) {
        RawWorkInfoDao rawWorkInfoDao = this.mWorkDatabase.rawWorkInfoDao();
        return LiveDataUtils.dedupedMappedLiveDataFor(rawWorkInfoDao.getWorkInfoPojosLiveData(RawQueries.toRawQuery(workQuery)), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    public TaskExecutor getWorkTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onForceStopRunnableCompleted() {
        Object object = sLock;
        synchronized (object) {
            this.mForceStopRunnableCompleted = true;
            if (this.mRescheduleReceiverResult != null) {
                this.mRescheduleReceiverResult.finish();
                this.mRescheduleReceiverResult = null;
            }
            return;
        }
    }

    @Override
    public Operation pruneWork() {
        PruneWorkRunnable pruneWorkRunnable = new PruneWorkRunnable(this);
        this.mWorkTaskExecutor.executeOnTaskThread(pruneWorkRunnable);
        return pruneWorkRunnable.getOperation();
    }

    public void rescheduleEligibleWork() {
        SystemJobScheduler.cancelAll(this.getApplicationContext());
        this.getWorkDatabase().workSpecDao().resetScheduledState();
        Schedulers.schedule(this.getConfiguration(), this.getWorkDatabase(), this.getSchedulers());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setReschedulePendingResult(BroadcastReceiver.PendingResult pendingResult) {
        Object object = sLock;
        synchronized (object) {
            if (this.mRescheduleReceiverResult != null) {
                this.mRescheduleReceiverResult.finish();
            }
            this.mRescheduleReceiverResult = pendingResult;
            if (this.mForceStopRunnableCompleted) {
                this.mRescheduleReceiverResult.finish();
                this.mRescheduleReceiverResult = null;
            }
            return;
        }
    }

    public void stopForegroundWork(WorkGenerationalId workGenerationalId) {
        this.mWorkTaskExecutor.executeOnTaskThread(new StopWorkRunnable(this.mProcessor, new StartStopToken(workGenerationalId), true));
    }

    @Override
    public ListenableFuture<WorkManager.UpdateResult> updateWork(WorkRequest workRequest) {
        return WorkerUpdater.updateWorkImpl(this, workRequest);
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean isDeviceProtectedStorage(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }
}

