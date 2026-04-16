/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.fragment.app;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.savedstate.SavedStateRegistry;

public final class FragmentActivity$$ExternalSyntheticLambda0
implements SavedStateRegistry.SavedStateProvider {
    public final FragmentActivity f$0;

    public /* synthetic */ FragmentActivity$$ExternalSyntheticLambda0(FragmentActivity fragmentActivity) {
        this.f$0 = fragmentActivity;
    }

    @Override
    public final Bundle saveState() {
        return this.f$0.lambda$init$0$androidx-fragment-app-FragmentActivity();
    }
}

