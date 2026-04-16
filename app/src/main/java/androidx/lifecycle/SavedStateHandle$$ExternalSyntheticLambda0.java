/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;

public final class SavedStateHandle$$ExternalSyntheticLambda0
implements SavedStateRegistry.SavedStateProvider {
    public final SavedStateHandle f$0;

    public /* synthetic */ SavedStateHandle$$ExternalSyntheticLambda0(SavedStateHandle savedStateHandle) {
        this.f$0 = savedStateHandle;
    }

    @Override
    public final Bundle saveState() {
        return SavedStateHandle.$r8$lambda$aMir0GWwzPQviKVGE0DPm0kayew(this.f$0);
    }
}

