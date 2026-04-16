/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker$$ExternalSyntheticLambda0;
import androidx.work.impl.constraints.trackers.ConstraintTrackerKt;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fJ\r\u0010\u001a\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0014J\u0014\u0010\u001b\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fJ\b\u0010\u001c\u001a\u00020\u0018H&J\b\u0010\u001d\u001a\u00020\u0018H&R\u0014\u0010\b\u001a\u00020\u0004X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00008F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "T", "", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "appContext", "getAppContext", "()Landroid/content/Context;", "currentState", "Ljava/lang/Object;", "listeners", "Ljava/util/LinkedHashSet;", "Landroidx/work/impl/constraints/ConstraintListener;", "lock", "newState", "state", "getState", "()Ljava/lang/Object;", "setState", "(Ljava/lang/Object;)V", "addListener", "", "listener", "readSystemState", "removeListener", "startTracking", "stopTracking", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class ConstraintTracker<T> {
    private final Context appContext;
    private T currentState;
    private final LinkedHashSet<ConstraintListener<T>> listeners;
    private final Object lock;
    private final TaskExecutor taskExecutor;

    public static /* synthetic */ void $r8$lambda$RK0TULesrSgb2ZBnJ6LX6irCfZ4(List list, ConstraintTracker constraintTracker) {
        ConstraintTracker._set_state_$lambda$4$lambda$3(list, constraintTracker);
    }

    protected ConstraintTracker(Context context, TaskExecutor taskExecutor) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"taskExecutor");
        this.taskExecutor = taskExecutor;
        context = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue((Object)context, (String)"context.applicationContext");
        this.appContext = context;
        this.lock = new Object();
        this.listeners = new LinkedHashSet();
    }

    private static final void _set_state_$lambda$4$lambda$3(List object, ConstraintTracker constraintTracker) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$listenersList");
        Intrinsics.checkNotNullParameter((Object)constraintTracker, (String)"this$0");
        object = ((Iterable)object).iterator();
        while (object.hasNext()) {
            ((ConstraintListener)object.next()).onConstraintChanged(constraintTracker.currentState);
        }
    }

    public final void addListener(ConstraintListener<T> unit) {
        Intrinsics.checkNotNullParameter(unit, (String)"listener");
        Object object = this.lock;
        synchronized (object) {
            if (this.listeners.add((ConstraintListener<T>)unit)) {
                if (this.listeners.size() == 1) {
                    this.currentState = this.readSystemState();
                    Logger logger = Logger.get();
                    String string2 = ConstraintTrackerKt.access$getTAG$p();
                    StringBuilder stringBuilder = new StringBuilder();
                    logger.debug(string2, stringBuilder.append(this.getClass().getSimpleName()).append(": initial state = ").append(this.currentState).toString());
                    this.startTracking();
                }
                unit.onConstraintChanged(this.currentState);
            }
            unit = Unit.INSTANCE;
            return;
        }
    }

    protected final Context getAppContext() {
        return this.appContext;
    }

    public final T getState() {
        T t;
        T t2 = t = this.currentState;
        if (t == null) {
            t2 = this.readSystemState();
        }
        return t2;
    }

    public abstract T readSystemState();

    public final void removeListener(ConstraintListener<T> unit) {
        Intrinsics.checkNotNullParameter(unit, (String)"listener");
        Object object = this.lock;
        synchronized (object) {
            if (this.listeners.remove(unit) && this.listeners.isEmpty()) {
                this.stopTracking();
            }
            unit = Unit.INSTANCE;
            return;
        }
    }

    public final void setState(T object) {
        Object object2 = this.lock;
        synchronized (object2) {
            block4: {
                boolean bl;
                if (this.currentState == null || !(bl = Intrinsics.areEqual(this.currentState, object))) break block4;
                return;
            }
            this.currentState = object;
            object = CollectionsKt.toList((Iterable)this.listeners);
            Executor executor = this.taskExecutor.getMainThreadExecutor();
            ConstraintTracker$$ExternalSyntheticLambda0 constraintTracker$$ExternalSyntheticLambda0 = new ConstraintTracker$$ExternalSyntheticLambda0((List)object, this);
            executor.execute(constraintTracker$$ExternalSyntheticLambda0);
            object = Unit.INSTANCE;
            return;
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}

