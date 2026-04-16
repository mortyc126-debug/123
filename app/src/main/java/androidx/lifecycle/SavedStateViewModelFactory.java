/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.os.Bundle
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactoryKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0003B\u0019\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB#\b\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ%\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0015H\u0016\u00a2\u0006\u0002\u0010\u0016J-\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016\u00a2\u0006\u0002\u0010\u0019J+\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0015\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013H\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Landroidx/lifecycle/SavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "()V", "application", "Landroid/app/Application;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;)V", "defaultArgs", "Landroid/os/Bundle;", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "factory", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "key", "", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "onRequery", "", "viewModel", "lifecycle-viewmodel-savedstate_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class SavedStateViewModelFactory
extends ViewModelProvider.OnRequeryFactory
implements ViewModelProvider.Factory {
    private Application application;
    private Bundle defaultArgs;
    private final ViewModelProvider.Factory factory;
    private Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;

    public SavedStateViewModelFactory() {
        this.factory = new ViewModelProvider.AndroidViewModelFactory();
    }

    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.checkNotNullParameter((Object)savedStateRegistryOwner, (String)"owner");
        this(application, savedStateRegistryOwner, null);
    }

    public SavedStateViewModelFactory(Application object, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)savedStateRegistryOwner, (String)"owner");
        this.savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.lifecycle = savedStateRegistryOwner.getLifecycle();
        this.defaultArgs = bundle;
        this.application = object;
        object = object != null ? (ViewModelProvider.Factory)ViewModelProvider.AndroidViewModelFactory.Companion.getInstance((Application)object) : (ViewModelProvider.Factory)new ViewModelProvider.AndroidViewModelFactory();
        this.factory = object;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"modelClass");
        String string2 = clazz.getCanonicalName();
        if (string2 != null) {
            return this.create(string2, clazz);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override
    public <T extends ViewModel> T create(Class<T> clazz, CreationExtras creationExtras) {
        block4: {
            block7: {
                block6: {
                    Constructor<T> constructor;
                    block5: {
                        Intrinsics.checkNotNullParameter(clazz, (String)"modelClass");
                        Intrinsics.checkNotNullParameter((Object)creationExtras, (String)"extras");
                        constructor = creationExtras.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
                        if (constructor == null) break block4;
                        if (creationExtras.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) == null || creationExtras.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) == null) break block5;
                        Application application = creationExtras.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
                        boolean bl = AndroidViewModel.class.isAssignableFrom(clazz);
                        constructor = bl && application != null ? SavedStateViewModelFactoryKt.findMatchingConstructor(clazz, SavedStateViewModelFactoryKt.access$getANDROID_VIEWMODEL_SIGNATURE$p()) : SavedStateViewModelFactoryKt.findMatchingConstructor(clazz, SavedStateViewModelFactoryKt.access$getVIEWMODEL_SIGNATURE$p());
                        if (constructor == null) {
                            return this.factory.create(clazz, creationExtras);
                        }
                        clazz = bl && application != null ? SavedStateViewModelFactoryKt.newInstance(clazz, constructor, application, SavedStateHandleSupport.createSavedStateHandle(creationExtras)) : SavedStateViewModelFactoryKt.newInstance(clazz, constructor, SavedStateHandleSupport.createSavedStateHandle(creationExtras));
                        break block6;
                    }
                    if (this.lifecycle == null) break block7;
                    clazz = this.create((String)((Object)constructor), clazz);
                }
                return (T)clazz;
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    public final <T extends ViewModel> T create(String string2, Class<T> clazz) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"key");
        Intrinsics.checkNotNullParameter(clazz, (String)"modelClass");
        Object object = this.lifecycle;
        if (object != null) {
            boolean bl = AndroidViewModel.class.isAssignableFrom(clazz);
            Constructor<T> constructor = bl && this.application != null ? SavedStateViewModelFactoryKt.findMatchingConstructor(clazz, SavedStateViewModelFactoryKt.access$getANDROID_VIEWMODEL_SIGNATURE$p()) : SavedStateViewModelFactoryKt.findMatchingConstructor(clazz, SavedStateViewModelFactoryKt.access$getVIEWMODEL_SIGNATURE$p());
            if (constructor == null) {
                string2 = this.application != null ? this.factory.create(clazz) : ViewModelProvider.NewInstanceFactory.Companion.getInstance().create(clazz);
                return (T)string2;
            }
            SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
            Intrinsics.checkNotNull((Object)savedStateRegistry);
            object = LegacySavedStateHandleController.create(savedStateRegistry, (Lifecycle)object, string2, this.defaultArgs);
            if (bl && this.application != null) {
                string2 = this.application;
                Intrinsics.checkNotNull((Object)string2);
                string2 = SavedStateViewModelFactoryKt.newInstance(clazz, constructor, string2, ((SavedStateHandleController)object).getHandle());
            } else {
                string2 = SavedStateViewModelFactoryKt.newInstance(clazz, constructor, ((SavedStateHandleController)object).getHandle());
            }
            ((ViewModel)((Object)string2)).setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", object);
            return (T)string2;
        }
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override
    public void onRequery(ViewModel viewModel2) {
        Intrinsics.checkNotNullParameter((Object)viewModel2, (String)"viewModel");
        if (this.lifecycle != null) {
            SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
            Intrinsics.checkNotNull((Object)savedStateRegistry);
            Lifecycle lifecycle = this.lifecycle;
            Intrinsics.checkNotNull((Object)lifecycle);
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel2, savedStateRegistry, lifecycle);
        }
    }
}

