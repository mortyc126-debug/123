/*
 * Decompiled with CFR 0.152.
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.Toolbar;

public final class Toolbar$$ExternalSyntheticLambda0
implements Runnable {
    public final Toolbar f$0;

    public /* synthetic */ Toolbar$$ExternalSyntheticLambda0(Toolbar toolbar) {
        this.f$0 = toolbar;
    }

    @Override
    public final void run() {
        this.f$0.invalidateMenu();
    }
}

