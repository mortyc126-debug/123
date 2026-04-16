/*
 * Decompiled with CFR 0.152.
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.TooltipCompatHandler;

public final class TooltipCompatHandler$$ExternalSyntheticLambda1
implements Runnable {
    public final TooltipCompatHandler f$0;

    public /* synthetic */ TooltipCompatHandler$$ExternalSyntheticLambda1(TooltipCompatHandler tooltipCompatHandler) {
        this.f$0 = tooltipCompatHandler;
    }

    @Override
    public final void run() {
        this.f$0.hide();
    }
}

