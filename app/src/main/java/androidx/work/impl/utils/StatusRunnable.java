/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work.impl.utils;

import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.RawQueries;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.UUID;

public abstract class StatusRunnable<T>
implements Runnable {
    private final SettableFuture<T> mFuture = SettableFuture.create();

    public static StatusRunnable<List<WorkInfo>> forStringIds(WorkManagerImpl workManagerImpl, List<String> list) {
        return new StatusRunnable<List<WorkInfo>>(workManagerImpl, list){
            final List val$ids;
            final WorkManagerImpl val$workManager;
            {
                this.val$workManager = workManagerImpl;
                this.val$ids = list;
            }

            @Override
            public List<WorkInfo> runInternal() {
                Object object = this.val$workManager.getWorkDatabase();
                object = ((WorkDatabase)object).workSpecDao().getWorkStatusPojoForIds(this.val$ids);
                return WorkSpec.WORK_INFO_MAPPER.apply((List<WorkSpec.WorkInfoPojo>)object);
            }
        };
    }

    public static StatusRunnable<List<WorkInfo>> forTag(WorkManagerImpl workManagerImpl, String string2) {
        return new StatusRunnable<List<WorkInfo>>(workManagerImpl, string2){
            final String val$tag;
            final WorkManagerImpl val$workManager;
            {
                this.val$workManager = workManagerImpl;
                this.val$tag = string2;
            }

            @Override
            List<WorkInfo> runInternal() {
                Object object = this.val$workManager.getWorkDatabase();
                object = ((WorkDatabase)object).workSpecDao().getWorkStatusPojoForTag(this.val$tag);
                return WorkSpec.WORK_INFO_MAPPER.apply((List<WorkSpec.WorkInfoPojo>)object);
            }
        };
    }

    public static StatusRunnable<WorkInfo> forUUID(WorkManagerImpl workManagerImpl, UUID uUID) {
        return new StatusRunnable<WorkInfo>(workManagerImpl, uUID){
            final UUID val$id;
            final WorkManagerImpl val$workManager;
            {
                this.val$workManager = workManagerImpl;
                this.val$id = uUID;
            }

            @Override
            WorkInfo runInternal() {
                Object object = this.val$workManager.getWorkDatabase();
                object = (object = ((WorkDatabase)object).workSpecDao().getWorkStatusPojoForId(this.val$id.toString())) != null ? ((WorkSpec.WorkInfoPojo)object).toWorkInfo() : null;
                return object;
            }
        };
    }

    public static StatusRunnable<List<WorkInfo>> forUniqueWork(WorkManagerImpl workManagerImpl, String string2) {
        return new StatusRunnable<List<WorkInfo>>(workManagerImpl, string2){
            final String val$name;
            final WorkManagerImpl val$workManager;
            {
                this.val$workManager = workManagerImpl;
                this.val$name = string2;
            }

            @Override
            List<WorkInfo> runInternal() {
                Object object = this.val$workManager.getWorkDatabase();
                object = ((WorkDatabase)object).workSpecDao().getWorkStatusPojoForName(this.val$name);
                return WorkSpec.WORK_INFO_MAPPER.apply((List<WorkSpec.WorkInfoPojo>)object);
            }
        };
    }

    public static StatusRunnable<List<WorkInfo>> forWorkQuerySpec(WorkManagerImpl workManagerImpl, WorkQuery workQuery) {
        return new StatusRunnable<List<WorkInfo>>(workManagerImpl, workQuery){
            final WorkQuery val$querySpec;
            final WorkManagerImpl val$workManager;
            {
                this.val$workManager = workManagerImpl;
                this.val$querySpec = workQuery;
            }

            @Override
            List<WorkInfo> runInternal() {
                Object object = this.val$workManager.getWorkDatabase();
                object = ((WorkDatabase)object).rawWorkInfoDao().getWorkInfoPojos(RawQueries.toRawQuery(this.val$querySpec));
                return WorkSpec.WORK_INFO_MAPPER.apply((List<WorkSpec.WorkInfoPojo>)object);
            }
        };
    }

    public ListenableFuture<T> getFuture() {
        return this.mFuture;
    }

    @Override
    public void run() {
        try {
            T t = this.runInternal();
            this.mFuture.set(t);
        }
        catch (Throwable throwable) {
            this.mFuture.setException(throwable);
        }
    }

    abstract T runInternal();
}

