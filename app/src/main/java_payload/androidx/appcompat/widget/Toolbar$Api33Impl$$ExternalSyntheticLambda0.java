/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.window.OnBackInvokedCallback
 */
package androidx.appcompat.widget;

import android.window.OnBackInvokedCallback;

public final class Toolbar$Api33Impl$$ExternalSyntheticLambda0
implements OnBackInvokedCallback {
    public final Runnable f$0;

    public /* synthetic */ Toolbar$Api33Impl$$ExternalSyntheticLambda0(Runnable runnable2) {
        this.f$0 = runnable2;
    }

    public final void onBackInvoked() {
        this.f$0.run();
    }
}

