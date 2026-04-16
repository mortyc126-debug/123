/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J,\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Landroidx/lifecycle/LegacySavedStateHandleController;", "", "()V", "TAG_SAVED_STATE_HANDLE_CONTROLLER", "", "attachHandleIfNeeded", "", "viewModel", "Landroidx/lifecycle/ViewModel;", "registry", "Landroidx/savedstate/SavedStateRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "create", "Landroidx/lifecycle/SavedStateHandleController;", "key", "defaultArgs", "Landroid/os/Bundle;", "tryToAddRecreator", "OnRecreation", "lifecycle-viewmodel-savedstate_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class LegacySavedStateHandleController {
    public static final LegacySavedStateHandleController INSTANCE = new LegacySavedStateHandleController();
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";

    private LegacySavedStateHandleController() {
    }

    @JvmStatic
    public static final void attachHandleIfNeeded(ViewModel object, SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"viewModel");
        Intrinsics.checkNotNullParameter((Object)savedStateRegistry, (String)"registry");
        Intrinsics.checkNotNullParameter((Object)lifecycle, (String)"lifecycle");
        object = (SavedStateHandleController)((ViewModel)object).getTag(TAG_SAVED_STATE_HANDLE_CONTROLLER);
        if (object != null && !((SavedStateHandleController)object).isAttached()) {
            ((SavedStateHandleController)object).attachToLifecycle(savedStateRegistry, lifecycle);
            INSTANCE.tryToAddRecreator(savedStateRegistry, lifecycle);
        }
    }

    @JvmStatic
    public static final SavedStateHandleController create(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle, String object, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)savedStateRegistry, (String)"registry");
        Intrinsics.checkNotNullParameter((Object)lifecycle, (String)"lifecycle");
        Intrinsics.checkNotNull((Object)object);
        Bundle bundle2 = savedStateRegistry.consumeRestoredStateForKey((String)object);
        object = new SavedStateHandleController((String)object, SavedStateHandle.Companion.createHandle(bundle2, bundle));
        ((SavedStateHandleController)object).attachToLifecycle(savedStateRegistry, lifecycle);
        INSTANCE.tryToAddRecreator(savedStateRegistry, lifecycle);
        return object;
    }

    private final void tryToAddRecreator(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        Lifecycle.State state = lifecycle.getCurrentState();
        if (state != Lifecycle.State.INITIALIZED && !state.isAtLeast(Lifecycle.State.STARTED)) {
            lifecycle.addObserver(new LifecycleEventObserver(lifecycle, savedStateRegistry){
                final Lifecycle $lifecycle;
                final SavedStateRegistry $registry;
                {
                    this.$lifecycle = lifecycle;
                    this.$registry = savedStateRegistry;
                }

                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    Intrinsics.checkNotNullParameter((Object)lifecycleOwner, (String)"source");
                    Intrinsics.checkNotNullParameter((Object)((Object)event), (String)"event");
                    if (event == Lifecycle.Event.ON_START) {
                        this.$lifecycle.removeObserver(this);
                        this.$registry.runOnNextRecreation(OnRecreation.class);
                    }
                }
            });
        } else {
            savedStateRegistry.runOnNextRecreation(OnRecreation.class);
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Landroidx/lifecycle/LegacySavedStateHandleController$OnRecreation;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "()V", "onRecreated", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "lifecycle-viewmodel-savedstate_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class OnRecreation
    implements SavedStateRegistry.AutoRecreated {
        @Override
        public void onRecreated(SavedStateRegistryOwner savedStateRegistryOwner) {
            Intrinsics.checkNotNullParameter((Object)savedStateRegistryOwner, (String)"owner");
            if (savedStateRegistryOwner instanceof ViewModelStoreOwner) {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner)((Object)savedStateRegistryOwner)).getViewModelStore();
                SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
                Iterator<String> iterator2 = viewModelStore.keys().iterator();
                while (iterator2.hasNext()) {
                    ViewModel viewModel2 = viewModelStore.get(iterator2.next());
                    Intrinsics.checkNotNull((Object)viewModel2);
                    LegacySavedStateHandleController.attachHandleIfNeeded(viewModel2, savedStateRegistry, savedStateRegistryOwner.getLifecycle());
                }
                if (((Collection)viewModelStore.keys()).isEmpty() ^ true) {
                    savedStateRegistry.runOnNextRecreation(OnRecreation.class);
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
        }
    }
}

