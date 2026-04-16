/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.view;

import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final class MenuHostHelper$$ExternalSyntheticLambda1
implements LifecycleEventObserver {
    public final MenuHostHelper f$0;
    public final Lifecycle.State f$1;
    public final MenuProvider f$2;

    public /* synthetic */ MenuHostHelper$$ExternalSyntheticLambda1(MenuHostHelper menuHostHelper, Lifecycle.State state, MenuProvider menuProvider) {
        this.f$0 = menuHostHelper;
        this.f$1 = state;
        this.f$2 = menuProvider;
    }

    @Override
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f$0.lambda$addMenuProvider$1$androidx-core-view-MenuHostHelper(this.f$1, this.f$2, lifecycleOwner, event);
    }
}

