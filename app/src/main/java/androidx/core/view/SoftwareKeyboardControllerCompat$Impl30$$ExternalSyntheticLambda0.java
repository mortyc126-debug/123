/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsetsController
 *  android.view.WindowInsetsController$OnControllableInsetsChangedListener
 */
package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0
implements WindowInsetsController.OnControllableInsetsChangedListener {
    public final AtomicBoolean f$0;

    public /* synthetic */ SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0(AtomicBoolean atomicBoolean) {
        this.f$0 = atomicBoolean;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int n) {
        SoftwareKeyboardControllerCompat.Impl30.lambda$hide$0(this.f$0, windowInsetsController, n);
    }
}

