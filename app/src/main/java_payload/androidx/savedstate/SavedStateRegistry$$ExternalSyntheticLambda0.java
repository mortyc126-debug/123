/*
 * Decompiled with CFR 0.152.
 */
package androidx.savedstate;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;

public final class SavedStateRegistry$$ExternalSyntheticLambda0
implements LifecycleEventObserver {
    public final SavedStateRegistry f$0;

    public /* synthetic */ SavedStateRegistry$$ExternalSyntheticLambda0(SavedStateRegistry savedStateRegistry) {
        this.f$0 = savedStateRegistry;
    }

    @Override
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        SavedStateRegistry.$r8$lambda$AUDDdpkzZrJMhBj0r-_9pI-j6hA(this.f$0, lifecycleOwner, event);
    }
}

