/*
 * Decompiled with CFR 0.152.
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleController;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlinx.coroutines.Job;

public final class LifecycleController$$ExternalSyntheticLambda0
implements LifecycleEventObserver {
    public final LifecycleController f$0;
    public final Job f$1;

    public /* synthetic */ LifecycleController$$ExternalSyntheticLambda0(LifecycleController lifecycleController, Job job2) {
        this.f$0 = lifecycleController;
        this.f$1 = job2;
    }

    @Override
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleController.$r8$lambda$INWMOb0xmlhb_ycZo7uXu7mUdSw(this.f$0, this.f$1, lifecycleOwner, event);
    }
}

