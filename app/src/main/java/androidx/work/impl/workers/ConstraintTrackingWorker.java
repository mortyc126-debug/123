/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  com.google.common.util.concurrent.ListenableFuture
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.workers.ConstraintTrackingWorker$$ExternalSyntheticLambda0;
import androidx.work.impl.workers.ConstraintTrackingWorker$$ExternalSyntheticLambda1;
import androidx.work.impl.workers.ConstraintTrackingWorker$$ExternalSyntheticLambda2;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001dH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00018G@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR2\u0010\u000e\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u000f0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Landroidx/work/impl/workers/ConstraintTrackingWorker;", "Landroidx/work/ListenableWorker;", "Landroidx/work/impl/constraints/OnConstraintsStateChangedListener;", "appContext", "Landroid/content/Context;", "workerParameters", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "areConstraintsUnmet", "", "<set-?>", "delegate", "getDelegate", "()Landroidx/work/ListenableWorker;", "future", "Landroidx/work/impl/utils/futures/SettableFuture;", "Landroidx/work/ListenableWorker$Result;", "kotlin.jvm.PlatformType", "lock", "", "onConstraintsStateChanged", "", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "state", "Landroidx/work/impl/constraints/ConstraintsState;", "onStopped", "setupAndRunConstraintTrackingWork", "startWork", "Lcom/google/common/util/concurrent/ListenableFuture;", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class ConstraintTrackingWorker
extends ListenableWorker
implements OnConstraintsStateChangedListener {
    private volatile boolean areConstraintsUnmet;
    private ListenableWorker delegate;
    private final SettableFuture<ListenableWorker.Result> future;
    private final Object lock;
    private final WorkerParameters workerParameters;

    public static /* synthetic */ void $r8$lambda$8l9einNrCv7f87OtAovLYk3Kx6Y(Job job2) {
        ConstraintTrackingWorker.setupAndRunConstraintTrackingWork$lambda$1(job2);
    }

    public static /* synthetic */ void $r8$lambda$RTKLpcwRu-iaj_5GXB0ZJoqSLng(ConstraintTrackingWorker constraintTrackingWorker, ListenableFuture listenableFuture) {
        ConstraintTrackingWorker.setupAndRunConstraintTrackingWork$lambda$3(constraintTrackingWorker, listenableFuture);
    }

    public static /* synthetic */ void $r8$lambda$wxwWb1SPyd6YmyhjXwGT_lgVTZk(ConstraintTrackingWorker constraintTrackingWorker) {
        ConstraintTrackingWorker.startWork$lambda$0(constraintTrackingWorker);
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"appContext");
        Intrinsics.checkNotNullParameter((Object)workerParameters, (String)"workerParameters");
        super(context, workerParameters);
        this.workerParameters = workerParameters;
        this.lock = new Object();
        this.future = SettableFuture.create();
    }

    private final void setupAndRunConstraintTrackingWork() {
        if (this.future.isCancelled()) {
            return;
        }
        Object object = this.getInputData().getString("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        SettableFuture<ListenableWorker.Result> settableFuture = Logger.get();
        Intrinsics.checkNotNullExpressionValue((Object)settableFuture, (String)"get()");
        ListenableFuture<ListenableWorker.Result> listenableFuture = (CharSequence)object;
        boolean bl = listenableFuture == null || listenableFuture.length() == 0;
        if (bl) {
            ((Logger)((Object)settableFuture)).error(ConstraintTrackingWorkerKt.access$getTAG$p(), "No worker to delegate to.");
            settableFuture = this.future;
            Intrinsics.checkNotNullExpressionValue((Object)settableFuture, (String)"future");
            ConstraintTrackingWorkerKt.access$setFailed(settableFuture);
            return;
        }
        this.delegate = this.getWorkerFactory().createWorkerWithDefaultFallback(this.getApplicationContext(), (String)object, this.workerParameters);
        if (this.delegate == null) {
            ((Logger)((Object)settableFuture)).debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "No worker to delegate to.");
            settableFuture = this.future;
            Intrinsics.checkNotNullExpressionValue(settableFuture, (String)"future");
            ConstraintTrackingWorkerKt.access$setFailed(settableFuture);
            return;
        }
        Object object2 = WorkManagerImpl.getInstance(this.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"getInstance(applicationContext)");
        listenableFuture = object2.getWorkDatabase().workSpecDao();
        Object object3 = this.getId().toString();
        Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"id.toString()");
        listenableFuture = listenableFuture.getWorkSpec((String)object3);
        if (listenableFuture == null) {
            settableFuture = this.future;
            Intrinsics.checkNotNullExpressionValue(settableFuture, (String)"future");
            ConstraintTrackingWorkerKt.access$setFailed(settableFuture);
            return;
        }
        object3 = object2.getTrackers();
        Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"workManagerImpl.trackers");
        object3 = new WorkConstraintsTracker((Trackers)object3);
        object2 = object2.getWorkTaskExecutor().getTaskCoroutineDispatcher();
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"workManagerImpl.workTask\u2026r.taskCoroutineDispatcher");
        object2 = WorkConstraintsTrackerKt.listen((WorkConstraintsTracker)object3, (WorkSpec)listenableFuture, (CoroutineDispatcher)((Object)object2), this);
        this.future.addListener(new ConstraintTrackingWorker$$ExternalSyntheticLambda1((Job)object2), new SynchronousExecutor());
        if (((WorkConstraintsTracker)object3).areAllConstraintsMet((WorkSpec)listenableFuture)) {
            ((Logger)((Object)settableFuture)).debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "Constraints met for delegate " + (String)object);
            try {
                listenableFuture = this.delegate;
                Intrinsics.checkNotNull((Object)listenableFuture);
                listenableFuture = listenableFuture.startWork();
                Intrinsics.checkNotNullExpressionValue(listenableFuture, (String)"delegate!!.startWork()");
                object2 = new ConstraintTrackingWorker$$ExternalSyntheticLambda2(this, listenableFuture);
                listenableFuture.addListener((Runnable)object2, this.getBackgroundExecutor());
            }
            catch (Throwable throwable) {
                ((Logger)((Object)settableFuture)).debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "Delegated worker " + (String)object + " threw exception in startWork.", throwable);
                object = this.lock;
                synchronized (object) {
                    if (this.areConstraintsUnmet) {
                        ((Logger)((Object)settableFuture)).debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "Constraints were unmet, Retrying.");
                        settableFuture = this.future;
                        Intrinsics.checkNotNullExpressionValue(settableFuture, (String)"future");
                        ConstraintTrackingWorkerKt.access$setRetry(settableFuture);
                    } else {
                        settableFuture = this.future;
                        Intrinsics.checkNotNullExpressionValue(settableFuture, (String)"future");
                        ConstraintTrackingWorkerKt.access$setFailed(settableFuture);
                    }
                }
            }
        } else {
            ((Logger)((Object)settableFuture)).debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "Constraints not met for delegate " + (String)object + ". Requesting retry.");
            settableFuture = this.future;
            Intrinsics.checkNotNullExpressionValue(settableFuture, (String)"future");
            ConstraintTrackingWorkerKt.access$setRetry(settableFuture);
        }
    }

    private static final void setupAndRunConstraintTrackingWork$lambda$1(Job job2) {
        Intrinsics.checkNotNullParameter((Object)job2, (String)"$job");
        job2.cancel(null);
    }

    private static final void setupAndRunConstraintTrackingWork$lambda$3(ConstraintTrackingWorker object, ListenableFuture listenableFuture) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)listenableFuture, (String)"$innerFuture");
        Object object2 = ((ConstraintTrackingWorker)object).lock;
        synchronized (object2) {
            if (((ConstraintTrackingWorker)object).areConstraintsUnmet) {
                object = ((ConstraintTrackingWorker)object).future;
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"future");
                ConstraintTrackingWorkerKt.access$setRetry((SettableFuture)object);
            } else {
                ((ConstraintTrackingWorker)object).future.setFuture((ListenableFuture<ListenableWorker.Result>)listenableFuture);
            }
            object = Unit.INSTANCE;
            return;
        }
    }

    private static final void startWork$lambda$0(ConstraintTrackingWorker constraintTrackingWorker) {
        Intrinsics.checkNotNullParameter((Object)constraintTrackingWorker, (String)"this$0");
        constraintTrackingWorker.setupAndRunConstraintTrackingWork();
    }

    public final ListenableWorker getDelegate() {
        return this.delegate;
    }

    @Override
    public void onConstraintsStateChanged(WorkSpec object, ConstraintsState constraintsState) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"workSpec");
        Intrinsics.checkNotNullParameter((Object)constraintsState, (String)"state");
        Logger.get().debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "Constraints changed for " + object);
        if (constraintsState instanceof ConstraintsState.ConstraintsNotMet) {
            object = this.lock;
            synchronized (object) {
                this.areConstraintsUnmet = true;
                constraintsState = Unit.INSTANCE;
            }
        }
    }

    @Override
    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.delegate;
        if (listenableWorker != null && !listenableWorker.isStopped()) {
            int n = Build.VERSION.SDK_INT >= 31 ? this.getStopReason() : 0;
            listenableWorker.stop(n);
        }
    }

    @Override
    public ListenableFuture<ListenableWorker.Result> startWork() {
        this.getBackgroundExecutor().execute(new ConstraintTrackingWorker$$ExternalSyntheticLambda0(this));
        SettableFuture<ListenableWorker.Result> settableFuture = this.future;
        Intrinsics.checkNotNullExpressionValue(settableFuture, (String)"future");
        return settableFuture;
    }
}

