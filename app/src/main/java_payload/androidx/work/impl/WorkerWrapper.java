/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work.impl;

import android.content.Context;
import androidx.work.Clock;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkerWrapper$$ExternalSyntheticLambda0;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class WorkerWrapper
implements Runnable {
    static final String TAG = Logger.tagWithPrefix("WorkerWrapper");
    Context mAppContext;
    private Clock mClock;
    private Configuration mConfiguration;
    private DependencyDao mDependencyDao;
    private ForegroundProcessor mForegroundProcessor;
    SettableFuture<Boolean> mFuture;
    private volatile int mInterrupted = -256;
    ListenableWorker.Result mResult = ListenableWorker.Result.failure();
    private WorkerParameters.RuntimeExtras mRuntimeExtras;
    private List<String> mTags;
    private WorkDatabase mWorkDatabase;
    private String mWorkDescription;
    WorkSpec mWorkSpec;
    private WorkSpecDao mWorkSpecDao;
    private final String mWorkSpecId;
    TaskExecutor mWorkTaskExecutor;
    ListenableWorker mWorker;
    final SettableFuture<ListenableWorker.Result> mWorkerResultFuture;

    WorkerWrapper(Builder builder) {
        this.mFuture = SettableFuture.create();
        this.mWorkerResultFuture = SettableFuture.create();
        this.mAppContext = builder.mAppContext;
        this.mWorkTaskExecutor = builder.mWorkTaskExecutor;
        this.mForegroundProcessor = builder.mForegroundProcessor;
        this.mWorkSpec = builder.mWorkSpec;
        this.mWorkSpecId = this.mWorkSpec.id;
        this.mRuntimeExtras = builder.mRuntimeExtras;
        this.mWorker = builder.mWorker;
        this.mConfiguration = builder.mConfiguration;
        this.mClock = builder.mConfiguration.getClock();
        this.mWorkDatabase = builder.mWorkDatabase;
        this.mWorkSpecDao = this.mWorkDatabase.workSpecDao();
        this.mDependencyDao = this.mWorkDatabase.dependencyDao();
        this.mTags = builder.mTags;
    }

    private String createWorkDescription(List<String> object) {
        StringBuilder stringBuilder = new StringBuilder("Work [ id=").append(this.mWorkSpecId).append(", tags={ ");
        boolean bl = true;
        object = object.iterator();
        while (object.hasNext()) {
            String string2 = (String)object.next();
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(string2);
        }
        stringBuilder.append(" } ]");
        return stringBuilder.toString();
    }

    private void handleResult(ListenableWorker.Result result2) {
        if (result2 instanceof ListenableWorker.Result.Success) {
            Logger.get().info(TAG, "Worker result SUCCESS for " + this.mWorkDescription);
            if (this.mWorkSpec.isPeriodic()) {
                this.resetPeriodicAndResolve();
            } else {
                this.setSucceededAndResolve();
            }
        } else if (result2 instanceof ListenableWorker.Result.Retry) {
            Logger.get().info(TAG, "Worker result RETRY for " + this.mWorkDescription);
            this.rescheduleAndResolve();
        } else {
            Logger.get().info(TAG, "Worker result FAILURE for " + this.mWorkDescription);
            if (this.mWorkSpec.isPeriodic()) {
                this.resetPeriodicAndResolve();
            } else {
                this.setFailedAndResolve();
            }
        }
    }

    private void iterativelyFailWorkAndDependents(String string2) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add(string2);
        while (!linkedList.isEmpty()) {
            string2 = (String)linkedList.remove();
            if (this.mWorkSpecDao.getState(string2) != WorkInfo.State.CANCELLED) {
                this.mWorkSpecDao.setState(WorkInfo.State.FAILED, string2);
            }
            linkedList.addAll(this.mDependencyDao.getDependentWorkIds(string2));
        }
    }

    private void rescheduleAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
            this.mWorkSpecDao.setLastEnqueueTime(this.mWorkSpecId, this.mClock.currentTimeMillis());
            this.mWorkSpecDao.resetWorkSpecNextScheduleTimeOverride(this.mWorkSpecId, this.mWorkSpec.getNextScheduleTimeOverrideGeneration());
            this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1L);
            this.mWorkDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            this.mWorkDatabase.endTransaction();
            this.resolve(true);
        }
    }

    private void resetPeriodicAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.mWorkSpecDao.setLastEnqueueTime(this.mWorkSpecId, this.mClock.currentTimeMillis());
            this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
            this.mWorkSpecDao.resetWorkSpecRunAttemptCount(this.mWorkSpecId);
            this.mWorkSpecDao.resetWorkSpecNextScheduleTimeOverride(this.mWorkSpecId, this.mWorkSpec.getNextScheduleTimeOverrideGeneration());
            this.mWorkSpecDao.incrementPeriodCount(this.mWorkSpecId);
            this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1L);
            this.mWorkDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            this.mWorkDatabase.endTransaction();
            this.resolve(false);
        }
    }

    private void resolve(boolean bl) {
        this.mWorkDatabase.beginTransaction();
        if (!this.mWorkDatabase.workSpecDao().hasUnfinishedWork()) {
            PackageManagerHelper.setComponentEnabled(this.mAppContext, RescheduleReceiver.class, false);
        }
        if (bl) {
            this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
            this.mWorkSpecDao.setStopReason(this.mWorkSpecId, this.mInterrupted);
            this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1L);
        }
        this.mWorkDatabase.setTransactionSuccessful();
        this.mFuture.set(bl);
        return;
        finally {
            this.mWorkDatabase.endTransaction();
        }
    }

    private void resolveIncorrectStatus() {
        WorkInfo.State state = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (state == WorkInfo.State.RUNNING) {
            Logger.get().debug(TAG, "Status for " + this.mWorkSpecId + " is RUNNING; not doing any work and rescheduling for later execution");
            this.resolve(true);
        } else {
            Logger.get().debug(TAG, "Status for " + this.mWorkSpecId + " is " + (Object)((Object)state) + " ; not doing any work");
            this.resolve(false);
        }
    }

    private void runWorker() {
        Object object;
        block16: {
            if (this.tryCheckForInterruptionAndResolve()) {
                return;
            }
            this.mWorkDatabase.beginTransaction();
            if (this.mWorkSpec.state != WorkInfo.State.ENQUEUED) {
                this.resolveIncorrectStatus();
                this.mWorkDatabase.setTransactionSuccessful();
                Logger logger = Logger.get();
                String string2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                logger.debug(string2, stringBuilder.append(this.mWorkSpec.workerClassName).append(" is not in ENQUEUED state. Nothing more to do").toString());
                return;
            }
            if ((this.mWorkSpec.isPeriodic() || this.mWorkSpec.isBackedOff()) && this.mClock.currentTimeMillis() < this.mWorkSpec.calculateNextRunTime()) {
                Logger.get().debug(TAG, String.format("Delaying execution for %s because it is being executed before schedule.", this.mWorkSpec.workerClassName));
                this.resolve(true);
                this.mWorkDatabase.setTransactionSuccessful();
                return;
            }
            this.mWorkDatabase.setTransactionSuccessful();
            if (this.mWorkSpec.isPeriodic()) {
                object = this.mWorkSpec.input;
                break block16;
            }
            object = this.mConfiguration.getInputMergerFactory();
            Object object2 = this.mWorkSpec.inputMergerClassName;
            if ((object2 = object.createInputMergerWithDefaultFallback((String)object2)) == null) {
                Logger.get().error(TAG, "Could not create Input Merger " + this.mWorkSpec.inputMergerClassName);
                this.setFailedAndResolve();
                return;
            }
            object = new ArrayList<Data>();
            object.add((Void)((Object)this.mWorkSpec.input));
            object.addAll(this.mWorkSpecDao.getInputsFromPrerequisites(this.mWorkSpecId));
            object = ((InputMerger)object2).merge((List<Data>)object);
        }
        object = new WorkerParameters(UUID.fromString(this.mWorkSpecId), (Data)object, (Collection<String>)this.mTags, this.mRuntimeExtras, this.mWorkSpec.runAttemptCount, this.mWorkSpec.getGeneration(), this.mConfiguration.getExecutor(), this.mWorkTaskExecutor, this.mConfiguration.getWorkerFactory(), new WorkProgressUpdater(this.mWorkDatabase, this.mWorkTaskExecutor), new WorkForegroundUpdater(this.mWorkDatabase, this.mForegroundProcessor, this.mWorkTaskExecutor));
        if (this.mWorker == null) {
            this.mWorker = this.mConfiguration.getWorkerFactory().createWorkerWithDefaultFallback(this.mAppContext, this.mWorkSpec.workerClassName, (WorkerParameters)object);
        }
        if (this.mWorker == null) {
            Logger.get().error(TAG, "Could not create Worker " + this.mWorkSpec.workerClassName);
            this.setFailedAndResolve();
            return;
        }
        if (this.mWorker.isUsed()) {
            Logger.get().error(TAG, "Received an already-used Worker " + this.mWorkSpec.workerClassName + "; Worker Factory should return new instances");
            this.setFailedAndResolve();
            return;
        }
        this.mWorker.setUsed();
        if (this.trySetRunning()) {
            if (this.tryCheckForInterruptionAndResolve()) {
                return;
            }
            object = new WorkForegroundRunnable(this.mAppContext, this.mWorkSpec, this.mWorker, object.getForegroundUpdater(), this.mWorkTaskExecutor);
            this.mWorkTaskExecutor.getMainThreadExecutor().execute((Runnable)object);
            object = object.getFuture();
            this.mWorkerResultFuture.addListener(new WorkerWrapper$$ExternalSyntheticLambda0(this, (ListenableFuture)object), new SynchronousExecutor());
            object.addListener(new Runnable(){
                final WorkerWrapper this$0;
                final ListenableFuture val$runExpedited;
                {
                    this.this$0 = workerWrapper;
                    this.val$runExpedited = listenableFuture;
                }

                @Override
                public void run() {
                    if (this.this$0.mWorkerResultFuture.isCancelled()) {
                        return;
                    }
                    try {
                        this.val$runExpedited.get();
                        Logger logger = Logger.get();
                        String string2 = TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        logger.debug(string2, stringBuilder.append("Starting work for ").append(this.this$0.mWorkSpec.workerClassName).toString());
                        this.this$0.mWorkerResultFuture.setFuture(this.this$0.mWorker.startWork());
                    }
                    catch (Throwable throwable) {
                        this.this$0.mWorkerResultFuture.setException(throwable);
                    }
                }
            }, this.mWorkTaskExecutor.getMainThreadExecutor());
            object = this.mWorkDescription;
            this.mWorkerResultFuture.addListener(new Runnable(){
                final WorkerWrapper this$0;
                final String val$workDescription;
                {
                    this.this$0 = workerWrapper;
                    this.val$workDescription = string2;
                }

                /*
                 * WARNING - void declaration
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                @Override
                public void run() {
                    Throwable throwable2;
                    block10: {
                        block8: {
                            void var1_9;
                            try {
                                try {
                                    Object object = (ListenableWorker.Result)this.this$0.mWorkerResultFuture.get();
                                    if (object == null) {
                                        Logger logger = Logger.get();
                                        String string2 = TAG;
                                        object = new StringBuilder();
                                        logger.error(string2, ((StringBuilder)object).append(this.this$0.mWorkSpec.workerClassName).append(" returned a null result. Treating it as a failure.").toString());
                                        break block8;
                                    } else {
                                        Logger logger = Logger.get();
                                        String string3 = TAG;
                                        StringBuilder stringBuilder = new StringBuilder();
                                        logger.debug(string3, stringBuilder.append(this.this$0.mWorkSpec.workerClassName).append(" returned a ").append(object).append(".").toString());
                                        this.this$0.mResult = object;
                                    }
                                    break block8;
                                }
                                catch (ExecutionException executionException) {
                                }
                                catch (InterruptedException interruptedException) {
                                    // empty catch block
                                }
                                catch (CancellationException cancellationException) {
                                    Logger logger = Logger.get();
                                    String string4 = TAG;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    logger.info(string4, stringBuilder.append(this.val$workDescription).append(" was cancelled").toString(), cancellationException);
                                    break block8;
                                }
                            }
                            catch (Throwable throwable2) {
                                break block10;
                            }
                            Logger logger = Logger.get();
                            String string5 = TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            logger.error(string5, stringBuilder.append(this.val$workDescription).append(" failed because it threw an exception/error").toString(), (Throwable)var1_9);
                        }
                        this.this$0.onWorkFinished();
                        return;
                    }
                    this.this$0.onWorkFinished();
                    throw throwable2;
                }
            }, this.mWorkTaskExecutor.getSerialTaskExecutor());
        } else {
            this.resolveIncorrectStatus();
        }
        return;
        finally {
            this.mWorkDatabase.endTransaction();
        }
    }

    private void setSucceededAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.mWorkSpecDao.setState(WorkInfo.State.SUCCEEDED, this.mWorkSpecId);
            Object object = ((ListenableWorker.Result.Success)this.mResult).getOutputData();
            this.mWorkSpecDao.setOutput(this.mWorkSpecId, (Data)object);
            long l = this.mClock.currentTimeMillis();
            for (String string2 : this.mDependencyDao.getDependentWorkIds(this.mWorkSpecId)) {
                if (this.mWorkSpecDao.getState(string2) != WorkInfo.State.BLOCKED || !this.mDependencyDao.hasCompletedAllPrerequisites(string2)) continue;
                Logger logger = Logger.get();
                object = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                logger.info((String)object, stringBuilder.append("Setting status to enqueued for ").append(string2).toString());
                this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, string2);
                this.mWorkSpecDao.setLastEnqueueTime(string2, l);
            }
            this.mWorkDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            this.mWorkDatabase.endTransaction();
            this.resolve(false);
        }
    }

    private boolean tryCheckForInterruptionAndResolve() {
        if (this.mInterrupted != -256) {
            Logger.get().debug(TAG, "Work interrupted for " + this.mWorkDescription);
            WorkInfo.State state = this.mWorkSpecDao.getState(this.mWorkSpecId);
            if (state == null) {
                this.resolve(false);
            } else {
                this.resolve(state.isFinished() ^ true);
            }
            return true;
        }
        return false;
    }

    private boolean trySetRunning() {
        boolean bl = false;
        this.mWorkDatabase.beginTransaction();
        try {
            if (this.mWorkSpecDao.getState(this.mWorkSpecId) == WorkInfo.State.ENQUEUED) {
                this.mWorkSpecDao.setState(WorkInfo.State.RUNNING, this.mWorkSpecId);
                this.mWorkSpecDao.incrementWorkSpecRunAttemptCount(this.mWorkSpecId);
                this.mWorkSpecDao.setStopReason(this.mWorkSpecId, -256);
                bl = true;
            }
            this.mWorkDatabase.setTransactionSuccessful();
            return bl;
        }
        finally {
            this.mWorkDatabase.endTransaction();
        }
    }

    public ListenableFuture<Boolean> getFuture() {
        return this.mFuture;
    }

    public WorkGenerationalId getWorkGenerationalId() {
        return WorkSpecKt.generationalId(this.mWorkSpec);
    }

    public WorkSpec getWorkSpec() {
        return this.mWorkSpec;
    }

    public void interrupt(int n) {
        this.mInterrupted = n;
        this.tryCheckForInterruptionAndResolve();
        this.mWorkerResultFuture.cancel(true);
        if (this.mWorker != null && this.mWorkerResultFuture.isCancelled()) {
            this.mWorker.stop(n);
        } else {
            String string2 = "WorkSpec " + this.mWorkSpec + " is already done. Not interrupting.";
            Logger.get().debug(TAG, string2);
        }
    }

    /* synthetic */ void lambda$runWorker$0$androidx-work-impl-WorkerWrapper(ListenableFuture listenableFuture) {
        if (this.mWorkerResultFuture.isCancelled()) {
            listenableFuture.cancel(true);
        }
    }

    void onWorkFinished() {
        if (!this.tryCheckForInterruptionAndResolve()) {
            this.mWorkDatabase.beginTransaction();
            try {
                WorkInfo.State state = this.mWorkSpecDao.getState(this.mWorkSpecId);
                this.mWorkDatabase.workProgressDao().delete(this.mWorkSpecId);
                if (state == null) {
                    this.resolve(false);
                } else if (state == WorkInfo.State.RUNNING) {
                    this.handleResult(this.mResult);
                } else if (!state.isFinished()) {
                    this.mInterrupted = -512;
                    this.rescheduleAndResolve();
                }
                this.mWorkDatabase.setTransactionSuccessful();
            }
            finally {
                this.mWorkDatabase.endTransaction();
            }
        }
    }

    @Override
    public void run() {
        this.mWorkDescription = this.createWorkDescription(this.mTags);
        this.runWorker();
    }

    void setFailedAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.iterativelyFailWorkAndDependents(this.mWorkSpecId);
            Data data = ((ListenableWorker.Result.Failure)this.mResult).getOutputData();
            this.mWorkSpecDao.resetWorkSpecNextScheduleTimeOverride(this.mWorkSpecId, this.mWorkSpec.getNextScheduleTimeOverrideGeneration());
            this.mWorkSpecDao.setOutput(this.mWorkSpecId, data);
            this.mWorkDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            this.mWorkDatabase.endTransaction();
            this.resolve(false);
        }
    }

    public static class Builder {
        Context mAppContext;
        Configuration mConfiguration;
        ForegroundProcessor mForegroundProcessor;
        WorkerParameters.RuntimeExtras mRuntimeExtras = new WorkerParameters.RuntimeExtras();
        private final List<String> mTags;
        WorkDatabase mWorkDatabase;
        WorkSpec mWorkSpec;
        TaskExecutor mWorkTaskExecutor;
        ListenableWorker mWorker;

        public Builder(Context context, Configuration configuration2, TaskExecutor taskExecutor, ForegroundProcessor foregroundProcessor, WorkDatabase workDatabase, WorkSpec workSpec, List<String> list) {
            this.mAppContext = context.getApplicationContext();
            this.mWorkTaskExecutor = taskExecutor;
            this.mForegroundProcessor = foregroundProcessor;
            this.mConfiguration = configuration2;
            this.mWorkDatabase = workDatabase;
            this.mWorkSpec = workSpec;
            this.mTags = list;
        }

        public WorkerWrapper build() {
            return new WorkerWrapper(this);
        }

        public Builder withRuntimeExtras(WorkerParameters.RuntimeExtras runtimeExtras) {
            if (runtimeExtras != null) {
                this.mRuntimeExtras = runtimeExtras;
            }
            return this;
        }

        public Builder withWorker(ListenableWorker listenableWorker) {
            this.mWorker = listenableWorker;
            return this;
        }
    }
}

