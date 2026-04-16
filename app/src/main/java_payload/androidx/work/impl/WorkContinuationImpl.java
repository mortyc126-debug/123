/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work.impl;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.work.ArrayCreatingInputMerger;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.EnqueueRunnable;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.workers.CombineContinuationsWorker;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WorkContinuationImpl
extends WorkContinuation {
    private static final String TAG = Logger.tagWithPrefix("WorkContinuationImpl");
    private final List<String> mAllIds;
    private boolean mEnqueued;
    private final ExistingWorkPolicy mExistingWorkPolicy;
    private final List<String> mIds;
    private final String mName;
    private Operation mOperation;
    private final List<WorkContinuationImpl> mParents;
    private final List<? extends WorkRequest> mWork;
    private final WorkManagerImpl mWorkManagerImpl;

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String string2, ExistingWorkPolicy existingWorkPolicy, List<? extends WorkRequest> list) {
        this(workManagerImpl, string2, existingWorkPolicy, list, null);
    }

    /*
     * WARNING - void declaration
     */
    public WorkContinuationImpl(WorkManagerImpl object3, String object2, ExistingWorkPolicy existingWorkPolicy, List<? extends WorkRequest> list, List<WorkContinuationImpl> list2) {
        void var5_9;
        void var4_8;
        void var3_7;
        Iterator iterator2;
        this.mWorkManagerImpl = object3;
        this.mName = iterator2;
        this.mExistingWorkPolicy = var3_7;
        this.mWork = var4_8;
        this.mParents = var5_9;
        this.mIds = new ArrayList<String>(this.mWork.size());
        this.mAllIds = new ArrayList<String>();
        if (var5_9 != null) {
            for (WorkContinuationImpl workContinuationImpl : var5_9) {
                this.mAllIds.addAll(workContinuationImpl.mAllIds);
            }
        }
        for (int i = 0; i < var4_8.size(); ++i) {
            if (var3_7 == ExistingWorkPolicy.REPLACE && ((WorkRequest)var4_8.get(i)).getWorkSpec().getNextScheduleTimeOverride() != Long.MAX_VALUE) {
                throw new IllegalArgumentException("Next Schedule Time Override must be used with ExistingPeriodicWorkPolicyUPDATE (preferably) or KEEP");
            }
            String string2 = ((WorkRequest)var4_8.get(i)).getStringId();
            this.mIds.add(string2);
            this.mAllIds.add(string2);
        }
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, List<? extends WorkRequest> list) {
        this(workManagerImpl, null, ExistingWorkPolicy.KEEP, list, null);
    }

    private static boolean hasCycles(WorkContinuationImpl workContinuationImpl, Set<String> set) {
        set.addAll(workContinuationImpl.getIds());
        List<WorkContinuationImpl> list = WorkContinuationImpl.prerequisitesFor(workContinuationImpl);
        Iterator<String> iterator2 = set.iterator();
        while (iterator2.hasNext()) {
            if (!list.contains(iterator2.next())) continue;
            return true;
        }
        list = workContinuationImpl.getParents();
        if (list != null && !list.isEmpty()) {
            list = list.iterator();
            while (list.hasNext()) {
                if (!WorkContinuationImpl.hasCycles((WorkContinuationImpl)list.next(), set)) continue;
                return true;
            }
        }
        set.removeAll(workContinuationImpl.getIds());
        return false;
    }

    public static Set<String> prerequisitesFor(WorkContinuationImpl iterator2) {
        HashSet<String> hashSet = new HashSet<String>();
        if ((iterator2 = ((WorkContinuationImpl)((Object)iterator2)).getParents()) != null && !iterator2.isEmpty()) {
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                hashSet.addAll(((WorkContinuationImpl)iterator2.next()).getIds());
            }
        }
        return hashSet;
    }

    @Override
    protected WorkContinuation combineInternal(List<WorkContinuation> object) {
        OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest)new OneTimeWorkRequest.Builder(CombineContinuationsWorker.class).setInputMerger(ArrayCreatingInputMerger.class).build();
        ArrayList<WorkContinuationImpl> arrayList = new ArrayList<WorkContinuationImpl>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add((WorkContinuationImpl)((WorkContinuation)object.next()));
        }
        return new WorkContinuationImpl(this.mWorkManagerImpl, null, ExistingWorkPolicy.KEEP, Collections.singletonList(oneTimeWorkRequest), arrayList);
    }

    @Override
    public Operation enqueue() {
        if (!this.mEnqueued) {
            EnqueueRunnable enqueueRunnable = new EnqueueRunnable(this);
            this.mWorkManagerImpl.getWorkTaskExecutor().executeOnTaskThread(enqueueRunnable);
            this.mOperation = enqueueRunnable.getOperation();
        } else {
            Logger.get().warning(TAG, "Already enqueued work ids (" + TextUtils.join((CharSequence)", ", this.mIds) + ")");
        }
        return this.mOperation;
    }

    public List<String> getAllIds() {
        return this.mAllIds;
    }

    public ExistingWorkPolicy getExistingWorkPolicy() {
        return this.mExistingWorkPolicy;
    }

    public List<String> getIds() {
        return this.mIds;
    }

    public String getName() {
        return this.mName;
    }

    public List<WorkContinuationImpl> getParents() {
        return this.mParents;
    }

    public List<? extends WorkRequest> getWork() {
        return this.mWork;
    }

    @Override
    public ListenableFuture<List<WorkInfo>> getWorkInfos() {
        StatusRunnable<List<WorkInfo>> statusRunnable = StatusRunnable.forStringIds(this.mWorkManagerImpl, this.mAllIds);
        this.mWorkManagerImpl.getWorkTaskExecutor().executeOnTaskThread(statusRunnable);
        return statusRunnable.getFuture();
    }

    @Override
    public LiveData<List<WorkInfo>> getWorkInfosLiveData() {
        return this.mWorkManagerImpl.getWorkInfosById(this.mAllIds);
    }

    public WorkManagerImpl getWorkManagerImpl() {
        return this.mWorkManagerImpl;
    }

    public boolean hasCycles() {
        return WorkContinuationImpl.hasCycles(this, new HashSet<String>());
    }

    public boolean isEnqueued() {
        return this.mEnqueued;
    }

    public void markEnqueued() {
        this.mEnqueued = true;
    }

    @Override
    public WorkContinuation then(List<OneTimeWorkRequest> list) {
        if (list.isEmpty()) {
            return this;
        }
        return new WorkContinuationImpl(this.mWorkManagerImpl, this.mName, ExistingWorkPolicy.KEEP, list, Collections.singletonList(this));
    }
}

