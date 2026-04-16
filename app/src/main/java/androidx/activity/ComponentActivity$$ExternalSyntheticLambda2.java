/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.activity;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.savedstate.SavedStateRegistry;

public final class ComponentActivity$$ExternalSyntheticLambda2
implements SavedStateRegistry.SavedStateProvider {
    public final ComponentActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda2(ComponentActivity componentActivity) {
        this.f$0 = componentActivity;
    }

    @Override
    public final Bundle saveState() {
        return this.f$0.lambda$new$1$androidx-activity-ComponentActivity();
    }
}

