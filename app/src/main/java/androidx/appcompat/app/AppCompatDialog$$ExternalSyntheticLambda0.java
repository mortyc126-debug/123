/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 */
package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.view.KeyEventDispatcher;

public final class AppCompatDialog$$ExternalSyntheticLambda0
implements KeyEventDispatcher.Component {
    public final AppCompatDialog f$0;

    public /* synthetic */ AppCompatDialog$$ExternalSyntheticLambda0(AppCompatDialog appCompatDialog) {
        this.f$0 = appCompatDialog;
    }

    @Override
    public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.f$0.superDispatchKeyEvent(keyEvent);
    }
}

