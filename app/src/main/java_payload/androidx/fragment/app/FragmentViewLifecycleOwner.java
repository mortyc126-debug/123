/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.ContextWrapper
 *  android.os.Bundle
 */
package androidx.fragment.app;

import android.app.Application;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

class FragmentViewLifecycleOwner
implements HasDefaultViewModelProviderFactory,
SavedStateRegistryOwner,
ViewModelStoreOwner {
    private ViewModelProvider.Factory mDefaultFactory;
    private final Fragment mFragment;
    private LifecycleRegistry mLifecycleRegistry = null;
    private SavedStateRegistryController mSavedStateRegistryController = null;
    private final ViewModelStore mViewModelStore;

    FragmentViewLifecycleOwner(Fragment fragment, ViewModelStore viewModelStore) {
        this.mFragment = fragment;
        this.mViewModelStore = viewModelStore;
    }

    @Override
    public CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        Application application2 = null;
        Object object = this.mFragment.requireContext().getApplicationContext();
        while (true) {
            application = application2;
            if (!(object instanceof ContextWrapper)) break;
            if (object instanceof Application) {
                application = (Application)object;
                break;
            }
            object = ((ContextWrapper)object).getBaseContext();
        }
        object = new MutableCreationExtras();
        if (application != null) {
            ((MutableCreationExtras)object).set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, application);
        }
        ((MutableCreationExtras)object).set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this.mFragment);
        ((MutableCreationExtras)object).set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (this.mFragment.getArguments() != null) {
            ((MutableCreationExtras)object).set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, this.mFragment.getArguments());
        }
        return object;
    }

    @Override
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        ViewModelProvider.Factory factory2 = this.mFragment.getDefaultViewModelProviderFactory();
        if (!factory2.equals(this.mFragment.mDefaultFactory)) {
            this.mDefaultFactory = factory2;
            return factory2;
        }
        if (this.mDefaultFactory == null) {
            Application application;
            Application application2 = null;
            factory2 = this.mFragment.requireContext().getApplicationContext();
            while (true) {
                application = application2;
                if (!(factory2 instanceof ContextWrapper)) break;
                if (factory2 instanceof Application) {
                    application = (Application)factory2;
                    break;
                }
                factory2 = ((ContextWrapper)factory2).getBaseContext();
            }
            this.mDefaultFactory = new SavedStateViewModelFactory(application, this.mFragment, this.mFragment.getArguments());
        }
        return this.mDefaultFactory;
    }

    @Override
    public Lifecycle getLifecycle() {
        this.initialize();
        return this.mLifecycleRegistry;
    }

    @Override
    public SavedStateRegistry getSavedStateRegistry() {
        this.initialize();
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Override
    public ViewModelStore getViewModelStore() {
        this.initialize();
        return this.mViewModelStore;
    }

    void handleLifecycleEvent(Lifecycle.Event event) {
        this.mLifecycleRegistry.handleLifecycleEvent(event);
    }

    void initialize() {
        if (this.mLifecycleRegistry == null) {
            this.mLifecycleRegistry = new LifecycleRegistry(this);
            this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
            this.mSavedStateRegistryController.performAttach();
        }
    }

    boolean isInitialized() {
        boolean bl = this.mLifecycleRegistry != null;
        return bl;
    }

    void performRestore(Bundle bundle) {
        this.mSavedStateRegistryController.performRestore(bundle);
    }

    void performSave(Bundle bundle) {
        this.mSavedStateRegistryController.performSave(bundle);
    }

    void setCurrentState(Lifecycle.State state) {
        this.mLifecycleRegistry.setCurrentState(state);
    }
}

