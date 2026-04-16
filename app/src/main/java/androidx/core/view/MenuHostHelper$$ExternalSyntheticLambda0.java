/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.view;

import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final class MenuHostHelper$$ExternalSyntheticLambda0
implements LifecycleEventObserver {
    public final MenuHostHelper f$0;
    public final MenuProvider f$1;

    public /* synthetic */ MenuHostHelper$$ExternalSyntheticLambda0(MenuHostHelper menuHostHelper, MenuProvider menuProvider) {
        this.f$0 = menuHostHelper;
        this.f$1 = menuProvider;
    }

    @Override
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f$0.lambda$addMenuProvider$0$androidx-core-view-MenuHostHelper(this.f$1, lifecycleOwner, event);
    }
}

