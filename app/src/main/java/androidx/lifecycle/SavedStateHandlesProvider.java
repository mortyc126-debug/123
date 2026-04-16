/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateHandlesVM;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\nH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2={"Landroidx/lifecycle/SavedStateHandlesProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/savedstate/SavedStateRegistry;Landroidx/lifecycle/ViewModelStoreOwner;)V", "restored", "", "restoredState", "Landroid/os/Bundle;", "viewModel", "Landroidx/lifecycle/SavedStateHandlesVM;", "getViewModel", "()Landroidx/lifecycle/SavedStateHandlesVM;", "viewModel$delegate", "Lkotlin/Lazy;", "consumeRestoredStateForKey", "key", "", "performRestore", "", "saveState", "lifecycle-viewmodel-savedstate_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class SavedStateHandlesProvider
implements SavedStateRegistry.SavedStateProvider {
    private boolean restored;
    private Bundle restoredState;
    private final SavedStateRegistry savedStateRegistry;
    private final Lazy viewModel$delegate;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry, ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter((Object)savedStateRegistry, (String)"savedStateRegistry");
        Intrinsics.checkNotNullParameter((Object)viewModelStoreOwner, (String)"viewModelStoreOwner");
        this.savedStateRegistry = savedStateRegistry;
        this.viewModel$delegate = LazyKt.lazy((Function0)((Function0)new Function0<SavedStateHandlesVM>(viewModelStoreOwner){
            final ViewModelStoreOwner $viewModelStoreOwner;
            {
                this.$viewModelStoreOwner = viewModelStoreOwner;
                super(0);
            }

            public final SavedStateHandlesVM invoke() {
                return SavedStateHandleSupport.getSavedStateHandlesVM(this.$viewModelStoreOwner);
            }
        }));
    }

    private final SavedStateHandlesVM getViewModel() {
        return (SavedStateHandlesVM)this.viewModel$delegate.getValue();
    }

    public final Bundle consumeRestoredStateForKey(String string2) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)string2, (String)"key");
        this.performRestore();
        Object object = this.restoredState;
        object = object != null ? object.getBundle(string2) : null;
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            bundle.remove(string2);
        }
        string2 = this.restoredState;
        boolean bl2 = bl = false;
        if (string2 != null) {
            bl2 = bl;
            if (string2.isEmpty()) {
                bl2 = true;
            }
        }
        if (bl2) {
            this.restoredState = null;
        }
        return object;
    }

    public final void performRestore() {
        if (!this.restored) {
            Bundle bundle = this.savedStateRegistry.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = this.restoredState;
            if (bundle3 != null) {
                bundle2.putAll(bundle3);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            this.restoredState = bundle2;
            this.restored = true;
            this.getViewModel();
        }
    }

    @Override
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        if (this.restoredState != null) {
            bundle.putAll(this.restoredState);
        }
        for (Map.Entry<String, SavedStateHandle> entry : this.getViewModel().getHandles().entrySet()) {
            String string2 = entry.getKey();
            Bundle bundle2 = entry.getValue().savedStateProvider().saveState();
            if (Intrinsics.areEqual((Object)bundle2, (Object)Bundle.EMPTY)) continue;
            bundle.putBundle(string2, bundle2);
        }
        this.restored = false;
        return bundle;
    }
}

