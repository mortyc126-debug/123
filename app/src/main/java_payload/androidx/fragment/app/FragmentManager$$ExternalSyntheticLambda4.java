/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.fragment.app;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.savedstate.SavedStateRegistry;

public final class FragmentManager$$ExternalSyntheticLambda4
implements SavedStateRegistry.SavedStateProvider {
    public final FragmentManager f$0;

    public /* synthetic */ FragmentManager$$ExternalSyntheticLambda4(FragmentManager fragmentManager) {
        this.f$0 = fragmentManager;
    }

    @Override
    public final Bundle saveState() {
        return this.f$0.lambda$attachController$4$androidx-fragment-app-FragmentManager();
    }
}

