/*
 * Decompiled with CFR 0.152.
 */
package androidx.activity;

import androidx.activity.ComponentActivity;

public final class ComponentActivity$$ExternalSyntheticLambda0
implements Runnable {
    public final ComponentActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda0(ComponentActivity componentActivity) {
        this.f$0 = componentActivity;
    }

    @Override
    public final void run() {
        this.f$0.invalidateMenu();
    }
}

