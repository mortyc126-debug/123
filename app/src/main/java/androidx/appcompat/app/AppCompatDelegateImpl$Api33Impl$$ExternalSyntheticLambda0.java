/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.window.OnBackInvokedCallback
 */
package androidx.appcompat.app;

import android.window.OnBackInvokedCallback;
import androidx.appcompat.app.AppCompatDelegateImpl;

public final class AppCompatDelegateImpl$Api33Impl$$ExternalSyntheticLambda0
implements OnBackInvokedCallback {
    public final AppCompatDelegateImpl f$0;

    public /* synthetic */ AppCompatDelegateImpl$Api33Impl$$ExternalSyntheticLambda0(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f$0 = appCompatDelegateImpl;
    }

    public final void onBackInvoked() {
        this.f$0.onBackPressed();
    }
}

