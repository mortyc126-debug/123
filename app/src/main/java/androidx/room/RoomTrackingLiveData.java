/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationLiveDataContainer;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomTrackingLiveData$$ExternalSyntheticLambda0;
import androidx.room.RoomTrackingLiveData$$ExternalSyntheticLambda1;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\u00a2\u0006\u0002\u0010\u000eJ\b\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020,H\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 \u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0011\u0010)\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0014\u00a8\u0006."}, d2={"Landroidx/room/RoomTrackingLiveData;", "T", "Landroidx/lifecycle/LiveData;", "database", "Landroidx/room/RoomDatabase;", "container", "Landroidx/room/InvalidationLiveDataContainer;", "inTransaction", "", "computeFunction", "Ljava/util/concurrent/Callable;", "tableNames", "", "", "(Landroidx/room/RoomDatabase;Landroidx/room/InvalidationLiveDataContainer;ZLjava/util/concurrent/Callable;[Ljava/lang/String;)V", "getComputeFunction", "()Ljava/util/concurrent/Callable;", "computing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getComputing", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getDatabase", "()Landroidx/room/RoomDatabase;", "getInTransaction", "()Z", "invalid", "getInvalid", "invalidationRunnable", "Ljava/lang/Runnable;", "getInvalidationRunnable", "()Ljava/lang/Runnable;", "observer", "Landroidx/room/InvalidationTracker$Observer;", "getObserver", "()Landroidx/room/InvalidationTracker$Observer;", "queryExecutor", "Ljava/util/concurrent/Executor;", "getQueryExecutor", "()Ljava/util/concurrent/Executor;", "refreshRunnable", "getRefreshRunnable", "registeredObserver", "getRegisteredObserver", "onActive", "", "onInactive", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class RoomTrackingLiveData<T>
extends LiveData<T> {
    private final Callable<T> computeFunction;
    private final AtomicBoolean computing;
    private final InvalidationLiveDataContainer container;
    private final RoomDatabase database;
    private final boolean inTransaction;
    private final AtomicBoolean invalid;
    private final Runnable invalidationRunnable;
    private final InvalidationTracker.Observer observer;
    private final Runnable refreshRunnable;
    private final AtomicBoolean registeredObserver;

    public static /* synthetic */ void $r8$lambda$PhMGW5zFk4QWazERd2lfEeLZqW0(RoomTrackingLiveData roomTrackingLiveData) {
        RoomTrackingLiveData.refreshRunnable$lambda$0(roomTrackingLiveData);
    }

    public static /* synthetic */ void $r8$lambda$lxd4mQgIWH-4QOUl4ygLPSFohKk(RoomTrackingLiveData roomTrackingLiveData) {
        RoomTrackingLiveData.invalidationRunnable$lambda$1(roomTrackingLiveData);
    }

    public RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean bl, Callable<T> callable, String[] stringArray) {
        Intrinsics.checkNotNullParameter((Object)roomDatabase, (String)"database");
        Intrinsics.checkNotNullParameter((Object)invalidationLiveDataContainer, (String)"container");
        Intrinsics.checkNotNullParameter(callable, (String)"computeFunction");
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"tableNames");
        this.database = roomDatabase;
        this.container = invalidationLiveDataContainer;
        this.inTransaction = bl;
        this.computeFunction = callable;
        this.observer = new InvalidationTracker.Observer(stringArray, this){
            final RoomTrackingLiveData<T> this$0;
            {
                this.this$0 = roomTrackingLiveData;
                super(stringArray);
            }

            public void onInvalidated(Set<String> set) {
                Intrinsics.checkNotNullParameter(set, (String)"tables");
                ArchTaskExecutor.getInstance().executeOnMainThread(this.this$0.getInvalidationRunnable());
            }
        };
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.registeredObserver = new AtomicBoolean(false);
        this.refreshRunnable = new RoomTrackingLiveData$$ExternalSyntheticLambda0(this);
        this.invalidationRunnable = new RoomTrackingLiveData$$ExternalSyntheticLambda1(this);
    }

    private static final void invalidationRunnable$lambda$1(RoomTrackingLiveData roomTrackingLiveData) {
        Intrinsics.checkNotNullParameter((Object)roomTrackingLiveData, (String)"this$0");
        boolean bl = roomTrackingLiveData.hasActiveObservers();
        if (roomTrackingLiveData.invalid.compareAndSet(false, true) && bl) {
            roomTrackingLiveData.getQueryExecutor().execute(roomTrackingLiveData.refreshRunnable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final void refreshRunnable$lambda$0(RoomTrackingLiveData roomTrackingLiveData) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)roomTrackingLiveData, (String)"this$0");
        if (roomTrackingLiveData.registeredObserver.compareAndSet(false, true)) {
            roomTrackingLiveData.database.getInvalidationTracker().addWeakObserver(roomTrackingLiveData.observer);
        }
        do {
            bl = false;
            boolean bl2 = false;
            if (!roomTrackingLiveData.computing.compareAndSet(false, true)) continue;
            Object t = null;
            bl = bl2;
            try {
                boolean bl3;
                while (bl3 = roomTrackingLiveData.invalid.compareAndSet(true, false)) {
                    bl = true;
                    try {
                        t = roomTrackingLiveData.computeFunction.call();
                    }
                    catch (Exception exception) {
                        RuntimeException runtimeException = new RuntimeException("Exception while computing database live data.", exception);
                        throw runtimeException;
                    }
                }
                if (!bl) continue;
                roomTrackingLiveData.postValue(t);
            }
            finally {
                roomTrackingLiveData.computing.set(false);
            }
        } while (bl && roomTrackingLiveData.invalid.get());
    }

    public final Callable<T> getComputeFunction() {
        return this.computeFunction;
    }

    public final AtomicBoolean getComputing() {
        return this.computing;
    }

    public final RoomDatabase getDatabase() {
        return this.database;
    }

    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    public final AtomicBoolean getInvalid() {
        return this.invalid;
    }

    public final Runnable getInvalidationRunnable() {
        return this.invalidationRunnable;
    }

    public final InvalidationTracker.Observer getObserver() {
        return this.observer;
    }

    public final Executor getQueryExecutor() {
        Executor executor = this.inTransaction ? this.database.getTransactionExecutor() : this.database.getQueryExecutor();
        return executor;
    }

    public final Runnable getRefreshRunnable() {
        return this.refreshRunnable;
    }

    public final AtomicBoolean getRegisteredObserver() {
        return this.registeredObserver;
    }

    @Override
    protected void onActive() {
        super.onActive();
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.container;
        Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        invalidationLiveDataContainer.onActive(this);
        this.getQueryExecutor().execute(this.refreshRunnable);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.container;
        Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        invalidationLiveDataContainer.onInactive(this);
    }
}

