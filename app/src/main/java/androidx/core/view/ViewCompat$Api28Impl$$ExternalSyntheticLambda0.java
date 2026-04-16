/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnUnhandledKeyEventListener
 */
package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.ViewCompat;

public final class ViewCompat$Api28Impl$$ExternalSyntheticLambda0
implements View.OnUnhandledKeyEventListener {
    public final ViewCompat.OnUnhandledKeyEventListenerCompat f$0;

    public /* synthetic */ ViewCompat$Api28Impl$$ExternalSyntheticLambda0(ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        this.f$0 = onUnhandledKeyEventListenerCompat;
    }

    public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.f$0.onUnhandledKeyEvent(view, keyEvent);
    }
}

