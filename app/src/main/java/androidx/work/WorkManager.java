/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work;

import android.app.PendingIntent;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import kotlinx.coroutines.flow.Flow;

public abstract class WorkManager {
    protected WorkManager() {
    }

    @Deprecated
    public static WorkManager getInstance() {
        WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance();
        if (workManagerImpl != null) {
            return workManagerImpl;
        }
        throw new IllegalStateException("WorkManager is not initialized properly.  The most likely cause is that you disabled WorkManagerInitializer in your manifest but forgot to call WorkManager#initialize in your Application#onCreate or a ContentProvider.");
    }

    public static WorkManager getInstance(Context context) {
        return WorkManagerImpl.getInstance(context);
    }

    public static void initialize(Context context, Configuration configuration2) {
        WorkManagerImpl.initialize(context, configuration2);
    }

    public static boolean isInitialized() {
        return WorkManagerImpl.isInitialized();
    }

    public final WorkContinuation beginUniqueWork(String string2, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest oneTimeWorkRequest) {
        return this.beginUniqueWork(string2, existingWorkPolicy, Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract WorkContinuation beginUniqueWork(String var1, ExistingWorkPolicy var2, List<OneTimeWorkRequest> var3);

    public final WorkContinuation beginWith(OneTimeWorkRequest oneTimeWorkRequest) {
        return this.beginWith(Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract WorkContinuation beginWith(List<OneTimeWorkRequest> var1);

    public abstract Operation cancelAllWork();

    public abstract Operation cancelAllWorkByTag(String var1);

    public abstract Operation cancelUniqueWork(String var1);

    public abstract Operation cancelWorkById(UUID var1);

    public abstract PendingIntent createCancelPendingIntent(UUID var1);

    public final Operation enqueue(WorkRequest workRequest) {
        return this.enqueue(Collections.singletonList(workRequest));
    }

    public abstract Operation enqueue(List<? extends WorkRequest> var1);

    public abstract Operation enqueueUniquePeriodicWork(String var1, ExistingPeriodicWorkPolicy var2, PeriodicWorkRequest var3);

    public Operation enqueueUniqueWork(String string2, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest oneTimeWorkRequest) {
        return this.enqueueUniqueWork(string2, existingWorkPolicy, Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract Operation enqueueUniqueWork(String var1, ExistingWorkPolicy var2, List<OneTimeWorkRequest> var3);

    public abstract Configuration getConfiguration();

    public abstract ListenableFuture<Long> getLastCancelAllTimeMillis();

    public abstract LiveData<Long> getLastCancelAllTimeMillisLiveData();

    public abstract ListenableFuture<WorkInfo> getWorkInfoById(UUID var1);

    public abstract Flow<WorkInfo> getWorkInfoByIdFlow(UUID var1);

    public abstract LiveData<WorkInfo> getWorkInfoByIdLiveData(UUID var1);

    public abstract ListenableFuture<List<WorkInfo>> getWorkInfos(WorkQuery var1);

    public abstract ListenableFuture<List<WorkInfo>> getWorkInfosByTag(String var1);

    public abstract Flow<List<WorkInfo>> getWorkInfosByTagFlow(String var1);

    public abstract LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(String var1);

    public abstract Flow<List<WorkInfo>> getWorkInfosFlow(WorkQuery var1);

    public abstract ListenableFuture<List<WorkInfo>> getWorkInfosForUniqueWork(String var1);

    public abstract Flow<List<WorkInfo>> getWorkInfosForUniqueWorkFlow(String var1);

    public abstract LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(String var1);

    public abstract LiveData<List<WorkInfo>> getWorkInfosLiveData(WorkQuery var1);

    public abstract Operation pruneWork();

    public abstract ListenableFuture<UpdateResult> updateWork(WorkRequest var1);

    public static enum UpdateResult {
        NOT_APPLIED,
        APPLIED_IMMEDIATELY,
        APPLIED_FOR_NEXT_RUN;

    }
}

