/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsetsController
 *  android.view.WindowInsetsController$OnControllableInsetsChangedListener
 */
package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.WindowInsetsControllerCompat;

public final class WindowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda0
implements WindowInsetsController.OnControllableInsetsChangedListener {
    public final WindowInsetsControllerCompat.Impl30 f$0;
    public final WindowInsetsControllerCompat.OnControllableInsetsChangedListener f$1;

    public /* synthetic */ WindowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda0(WindowInsetsControllerCompat.Impl30 impl30, WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.f$0 = impl30;
        this.f$1 = onControllableInsetsChangedListener;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int n) {
        this.f$0.lambda$addOnControllableInsetsChangedListener$0$androidx-core-view-WindowInsetsControllerCompat$Impl30(this.f$1, windowInsetsController, n);
    }
}

