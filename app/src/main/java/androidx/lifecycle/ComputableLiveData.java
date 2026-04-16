/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.ComputableLiveData$$ExternalSyntheticLambda0;
import androidx.lifecycle.ComputableLiveData$$ExternalSyntheticLambda1;
import androidx.lifecycle.LiveData;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\r\u0010\u0019\u001a\u00028\u0000H%\u00a2\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\tX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u00118\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00118\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u00a8\u0006\u001d"}, d2={"Landroidx/lifecycle/ComputableLiveData;", "T", "", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "_liveData", "Landroidx/lifecycle/LiveData;", "computing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getComputing$lifecycle_livedata_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getExecutor$lifecycle_livedata_release", "()Ljava/util/concurrent/Executor;", "invalid", "getInvalid$lifecycle_livedata_release", "invalidationRunnable", "Ljava/lang/Runnable;", "getInvalidationRunnable$lifecycle_livedata_release$annotations", "()V", "liveData", "getLiveData", "()Landroidx/lifecycle/LiveData;", "refreshRunnable", "getRefreshRunnable$lifecycle_livedata_release$annotations", "compute", "()Ljava/lang/Object;", "invalidate", "", "lifecycle-livedata_release"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class ComputableLiveData<T> {
    private final LiveData<T> _liveData;
    private final AtomicBoolean computing;
    private final Executor executor;
    private final AtomicBoolean invalid;
    public final Runnable invalidationRunnable;
    private final LiveData<T> liveData;
    public final Runnable refreshRunnable;

    public static /* synthetic */ void $r8$lambda$5eX8YRZhf-92-7ktc4Rs00cwiRw(ComputableLiveData computableLiveData) {
        ComputableLiveData.refreshRunnable$lambda$0(computableLiveData);
    }

    public static /* synthetic */ void $r8$lambda$Z8umybky1QMyXLhEFEx8n57LwT0(ComputableLiveData computableLiveData) {
        ComputableLiveData.invalidationRunnable$lambda$1(computableLiveData);
    }

    public ComputableLiveData() {
        this(null, 1, null);
    }

    public ComputableLiveData(Executor executor) {
        Intrinsics.checkNotNullParameter((Object)executor, (String)"executor");
        this.executor = executor;
        this._liveData = new LiveData<T>(this){
            final ComputableLiveData<T> this$0;
            {
                this.this$0 = computableLiveData;
            }

            protected void onActive() {
                this.this$0.getExecutor$lifecycle_livedata_release().execute(this.this$0.refreshRunnable);
            }
        };
        this.liveData = this._liveData;
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.refreshRunnable = new ComputableLiveData$$ExternalSyntheticLambda0(this);
        this.invalidationRunnable = new ComputableLiveData$$ExternalSyntheticLambda1(this);
    }

    public /* synthetic */ ComputableLiveData(Executor executor, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            executor = ArchTaskExecutor.getIOThreadExecutor();
            Intrinsics.checkNotNullExpressionValue((Object)executor, (String)"getIOThreadExecutor()");
        }
        this(executor);
    }

    public static /* synthetic */ void getInvalidationRunnable$lifecycle_livedata_release$annotations() {
    }

    public static /* synthetic */ void getRefreshRunnable$lifecycle_livedata_release$annotations() {
    }

    private static final void invalidationRunnable$lambda$1(ComputableLiveData computableLiveData) {
        Intrinsics.checkNotNullParameter((Object)computableLiveData, (String)"this$0");
        boolean bl = computableLiveData.getLiveData().hasActiveObservers();
        if (computableLiveData.invalid.compareAndSet(false, true) && bl) {
            computableLiveData.executor.execute(computableLiveData.refreshRunnable);
        }
    }

    private static final void refreshRunnable$lambda$0(ComputableLiveData computableLiveData) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)computableLiveData, (String)"this$0");
        do {
            bl = false;
            boolean bl2 = false;
            if (!computableLiveData.computing.compareAndSet(false, true)) continue;
            Object t = null;
            bl = bl2;
            while (true) {
                if (!computableLiveData.invalid.compareAndSet(true, false)) break;
                bl = true;
                t = computableLiveData.compute();
                continue;
                break;
            }
            if (!bl) continue;
            try {
                computableLiveData.getLiveData().postValue(t);
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
                computableLiveData.computing.set(false);
            }
        } while (bl && computableLiveData.invalid.get());
    }

    protected abstract T compute();

    public final AtomicBoolean getComputing$lifecycle_livedata_release() {
        return this.computing;
    }

    public final Executor getExecutor$lifecycle_livedata_release() {
        return this.executor;
    }

    public final AtomicBoolean getInvalid$lifecycle_livedata_release() {
        return this.invalid;
    }

    public LiveData<T> getLiveData() {
        return this.liveData;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.invalidationRunnable);
    }
}

