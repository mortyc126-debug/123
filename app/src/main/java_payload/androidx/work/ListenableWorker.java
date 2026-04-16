/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Network
 *  android.net.Uri
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.work.Data;
import androidx.work.ForegroundInfo;
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class ListenableWorker {
    private Context mAppContext;
    private volatile int mStopReason = -256;
    private boolean mUsed;
    private WorkerParameters mWorkerParams;

    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context != null) {
            if (workerParameters != null) {
                this.mAppContext = context;
                this.mWorkerParams = workerParameters;
                return;
            }
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        throw new IllegalArgumentException("Application Context is null");
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.getBackgroundExecutor();
    }

    public ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        SettableFuture<ForegroundInfo> settableFuture = SettableFuture.create();
        settableFuture.setException(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return settableFuture;
    }

    public final UUID getId() {
        return this.mWorkerParams.getId();
    }

    public final Data getInputData() {
        return this.mWorkerParams.getInputData();
    }

    public final Network getNetwork() {
        return this.mWorkerParams.getNetwork();
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.getRunAttemptCount();
    }

    public final int getStopReason() {
        return this.mStopReason;
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.getTags();
    }

    public TaskExecutor getTaskExecutor() {
        return this.mWorkerParams.getTaskExecutor();
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.getTriggeredContentAuthorities();
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.getTriggeredContentUris();
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerParams.getWorkerFactory();
    }

    public final boolean isStopped() {
        boolean bl = this.mStopReason != -256;
        return bl;
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public void onStopped() {
    }

    public final ListenableFuture<Void> setForegroundAsync(ForegroundInfo foregroundInfo) {
        return this.mWorkerParams.getForegroundUpdater().setForegroundAsync(this.getApplicationContext(), this.getId(), foregroundInfo);
    }

    public ListenableFuture<Void> setProgressAsync(Data data) {
        return this.mWorkerParams.getProgressUpdater().updateProgress(this.getApplicationContext(), this.getId(), data);
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public abstract ListenableFuture<Result> startWork();

    public final void stop(int n) {
        this.mStopReason = n;
        this.onStopped();
    }

    public static abstract class Result {
        Result() {
        }

        public static Result failure() {
            return new Failure();
        }

        public static Result failure(Data data) {
            return new Failure(data);
        }

        public static Result retry() {
            return new Retry();
        }

        public static Result success() {
            return new Success();
        }

        public static Result success(Data data) {
            return new Success(data);
        }

        public abstract Data getOutputData();

        public static final class Failure
        extends Result {
            private final Data mOutputData;

            public Failure() {
                this(Data.EMPTY);
            }

            public Failure(Data data) {
                this.mOutputData = data;
            }

            public boolean equals(Object object) {
                if (this == object) {
                    return true;
                }
                if (object != null && this.getClass() == object.getClass()) {
                    object = (Failure)object;
                    return this.mOutputData.equals(((Failure)object).mOutputData);
                }
                return false;
            }

            @Override
            public Data getOutputData() {
                return this.mOutputData;
            }

            public int hashCode() {
                return Failure.class.getName().hashCode() * 31 + this.mOutputData.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.mOutputData + '}';
            }
        }

        public static final class Retry
        extends Result {
            public boolean equals(Object object) {
                boolean bl = true;
                if (this == object) {
                    return true;
                }
                if (object == null || this.getClass() != object.getClass()) {
                    bl = false;
                }
                return bl;
            }

            @Override
            public Data getOutputData() {
                return Data.EMPTY;
            }

            public int hashCode() {
                return Retry.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        public static final class Success
        extends Result {
            private final Data mOutputData;

            public Success() {
                this(Data.EMPTY);
            }

            public Success(Data data) {
                this.mOutputData = data;
            }

            public boolean equals(Object object) {
                if (this == object) {
                    return true;
                }
                if (object != null && this.getClass() == object.getClass()) {
                    object = (Success)object;
                    return this.mOutputData.equals(((Success)object).mOutputData);
                }
                return false;
            }

            @Override
            public Data getOutputData() {
                return this.mOutputData;
            }

            public int hashCode() {
                return Success.class.getName().hashCode() * 31 + this.mOutputData.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.mOutputData + '}';
            }
        }
    }
}

