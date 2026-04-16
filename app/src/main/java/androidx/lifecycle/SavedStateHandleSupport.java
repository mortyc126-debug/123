/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 */
package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleAttacher;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateHandlesProvider;
import androidx.lifecycle.SavedStateHandlesVM;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0018H\u0007\u001a\u001f\u0010\u0019\u001a\u00020\u001a\"\f\b\u0000\u0010\u001b*\u00020\u0006*\u00020\t*\u0002H\u001bH\u0007\u00a2\u0006\u0002\u0010\u001c\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00018\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00018\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\u00068@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\t8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2={"DEFAULT_ARGS_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "Landroid/os/Bundle;", "SAVED_STATE_KEY", "", "SAVED_STATE_REGISTRY_OWNER_KEY", "Landroidx/savedstate/SavedStateRegistryOwner;", "VIEWMODEL_KEY", "VIEW_MODEL_STORE_OWNER_KEY", "Landroidx/lifecycle/ViewModelStoreOwner;", "savedStateHandlesProvider", "Landroidx/lifecycle/SavedStateHandlesProvider;", "getSavedStateHandlesProvider", "(Landroidx/savedstate/SavedStateRegistryOwner;)Landroidx/lifecycle/SavedStateHandlesProvider;", "savedStateHandlesVM", "Landroidx/lifecycle/SavedStateHandlesVM;", "getSavedStateHandlesVM", "(Landroidx/lifecycle/ViewModelStoreOwner;)Landroidx/lifecycle/SavedStateHandlesVM;", "createSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "savedStateRegistryOwner", "viewModelStoreOwner", "key", "defaultArgs", "Landroidx/lifecycle/viewmodel/CreationExtras;", "enableSavedStateHandles", "", "T", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "lifecycle-viewmodel-savedstate_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class SavedStateHandleSupport {
    public static final CreationExtras.Key<Bundle> DEFAULT_ARGS_KEY;
    private static final String SAVED_STATE_KEY = "androidx.lifecycle.internal.SavedStateHandlesProvider";
    public static final CreationExtras.Key<SavedStateRegistryOwner> SAVED_STATE_REGISTRY_OWNER_KEY;
    private static final String VIEWMODEL_KEY = "androidx.lifecycle.internal.SavedStateHandlesVM";
    public static final CreationExtras.Key<ViewModelStoreOwner> VIEW_MODEL_STORE_OWNER_KEY;

    static {
        SAVED_STATE_REGISTRY_OWNER_KEY = new CreationExtras.Key<SavedStateRegistryOwner>(){};
        VIEW_MODEL_STORE_OWNER_KEY = new CreationExtras.Key<ViewModelStoreOwner>(){};
        DEFAULT_ARGS_KEY = new CreationExtras.Key<Bundle>(){};
    }

    public static final SavedStateHandle createSavedStateHandle(CreationExtras object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        SavedStateRegistryOwner savedStateRegistryOwner = ((CreationExtras)object).get(SAVED_STATE_REGISTRY_OWNER_KEY);
        if (savedStateRegistryOwner != null) {
            ViewModelStoreOwner viewModelStoreOwner = ((CreationExtras)object).get(VIEW_MODEL_STORE_OWNER_KEY);
            if (viewModelStoreOwner != null) {
                Bundle bundle = ((CreationExtras)object).get(DEFAULT_ARGS_KEY);
                if ((object = ((CreationExtras)object).get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY)) != null) {
                    return SavedStateHandleSupport.createSavedStateHandle(savedStateRegistryOwner, viewModelStoreOwner, (String)object, bundle);
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    private static final SavedStateHandle createSavedStateHandle(SavedStateRegistryOwner object, ViewModelStoreOwner object2, String string2, Bundle bundle) {
        SavedStateHandlesProvider savedStateHandlesProvider = SavedStateHandleSupport.getSavedStateHandlesProvider((SavedStateRegistryOwner)object);
        SavedStateHandlesVM savedStateHandlesVM2 = SavedStateHandleSupport.getSavedStateHandlesVM((ViewModelStoreOwner)object2);
        object = object2 = savedStateHandlesVM2.getHandles().get(string2);
        if (object2 == null) {
            object = SavedStateHandle.Companion.createHandle(savedStateHandlesProvider.consumeRestoredStateForKey(string2), bundle);
            savedStateHandlesVM2.getHandles().put(string2, (SavedStateHandle)object);
        }
        return object;
    }

    public static final <T extends SavedStateRegistryOwner & ViewModelStoreOwner> void enableSavedStateHandles(T t) {
        Intrinsics.checkNotNullParameter(t, (String)"<this>");
        Object object = t.getLifecycle().getCurrentState();
        boolean bl = object == Lifecycle.State.INITIALIZED || object == Lifecycle.State.CREATED;
        if (bl) {
            if (t.getSavedStateRegistry().getSavedStateProvider(SAVED_STATE_KEY) == null) {
                object = new SavedStateHandlesProvider(t.getSavedStateRegistry(), t);
                t.getSavedStateRegistry().registerSavedStateProvider(SAVED_STATE_KEY, (SavedStateRegistry.SavedStateProvider)object);
                t.getLifecycle().addObserver(new SavedStateHandleAttacher((SavedStateHandlesProvider)object));
            }
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final SavedStateHandlesProvider getSavedStateHandlesProvider(SavedStateRegistryOwner object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        object = object.getSavedStateRegistry().getSavedStateProvider(SAVED_STATE_KEY);
        object = object instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider)object : null;
        if (object != null) {
            return object;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final SavedStateHandlesVM getSavedStateHandlesVM(ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter((Object)viewModelStoreOwner, (String)"<this>");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        Function1 function1 = savedStateHandlesVM.1.1.INSTANCE;
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(SavedStateHandlesVM.class), function1);
        return new ViewModelProvider(viewModelStoreOwner, initializerViewModelFactoryBuilder.build()).get(VIEWMODEL_KEY, SavedStateHandlesVM.class);
    }
}

