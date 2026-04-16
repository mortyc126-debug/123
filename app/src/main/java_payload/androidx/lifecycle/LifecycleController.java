/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import androidx.lifecycle.DispatchQueue;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleController$$ExternalSyntheticLambda0;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0007J\u0011\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0082\bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Landroidx/lifecycle/LifecycleController;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "minState", "Landroidx/lifecycle/Lifecycle$State;", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "parentJob", "Lkotlinx/coroutines/Job;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/Job;)V", "observer", "Landroidx/lifecycle/LifecycleEventObserver;", "finish", "", "handleDestroy", "lifecycle-common"}, k=1, mv={1, 8, 0}, xi=48)
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public static /* synthetic */ void $r8$lambda$INWMOb0xmlhb_ycZo7uXu7mUdSw(LifecycleController lifecycleController, Job job2, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleController.observer$lambda$0(lifecycleController, job2, lifecycleOwner, event);
    }

    public LifecycleController(Lifecycle lifecycle, Lifecycle.State state, DispatchQueue dispatchQueue, Job job2) {
        Intrinsics.checkNotNullParameter((Object)lifecycle, (String)"lifecycle");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"minState");
        Intrinsics.checkNotNullParameter((Object)dispatchQueue, (String)"dispatchQueue");
        Intrinsics.checkNotNullParameter((Object)job2, (String)"parentJob");
        this.lifecycle = lifecycle;
        this.minState = state;
        this.dispatchQueue = dispatchQueue;
        this.observer = new LifecycleController$$ExternalSyntheticLambda0(this, job2);
        if (this.lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            Job.DefaultImpls.cancel$default(job2, null, 1, null);
            this.finish();
        } else {
            this.lifecycle.addObserver(this.observer);
        }
    }

    private final void handleDestroy(Job job2) {
        Job.DefaultImpls.cancel$default(job2, null, 1, null);
        this.finish();
    }

    private static final void observer$lambda$0(LifecycleController lifecycleController, Job job2, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter((Object)lifecycleController, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)job2, (String)"$parentJob");
        Intrinsics.checkNotNullParameter((Object)lifecycleOwner, (String)"source");
        Intrinsics.checkNotNullParameter((Object)((Object)event), (String)"<anonymous parameter 1>");
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            Job.DefaultImpls.cancel$default(job2, null, 1, null);
            lifecycleController.finish();
        } else if (lifecycleOwner.getLifecycle().getCurrentState().compareTo((Enum)lifecycleController.minState) < 0) {
            lifecycleController.dispatchQueue.pause();
        } else {
            lifecycleController.dispatchQueue.resume();
        }
    }

    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}

