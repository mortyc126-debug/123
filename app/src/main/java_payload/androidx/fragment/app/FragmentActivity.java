/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.Window
 */
package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.core.app.ActivityCompat;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity$$ExternalSyntheticLambda0;
import androidx.fragment.app.FragmentActivity$$ExternalSyntheticLambda1;
import androidx.fragment.app.FragmentActivity$$ExternalSyntheticLambda2;
import androidx.fragment.app.FragmentActivity$$ExternalSyntheticLambda3;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class FragmentActivity
extends ComponentActivity
implements ActivityCompat.OnRequestPermissionsResultCallback,
ActivityCompat.RequestPermissionsRequestCodeValidator {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final LifecycleRegistry mFragmentLifecycleRegistry;
    final FragmentController mFragments = FragmentController.createController(new HostCallbacks(this));
    boolean mResumed;
    boolean mStopped = true;

    public FragmentActivity() {
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.init();
    }

    public FragmentActivity(int n) {
        super(n);
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.init();
    }

    private void init() {
        this.getSavedStateRegistry().registerSavedStateProvider(LIFECYCLE_TAG, new FragmentActivity$$ExternalSyntheticLambda0(this));
        this.addOnConfigurationChangedListener(new FragmentActivity$$ExternalSyntheticLambda1(this));
        this.addOnNewIntentListener(new FragmentActivity$$ExternalSyntheticLambda2(this));
        this.addOnContextAvailableListener(new FragmentActivity$$ExternalSyntheticLambda3(this));
    }

    /*
     * WARNING - void declaration
     */
    private static boolean markState(FragmentManager object2, Lifecycle.State state) {
        boolean bl = false;
        for (Fragment fragment : ((FragmentManager)object2).getFragments()) {
            void var1_3;
            if (fragment == null) continue;
            boolean bl2 = bl;
            if (fragment.getHost() != null) {
                bl2 = bl | FragmentActivity.markState(fragment.getChildFragmentManager(), (Lifecycle.State)var1_3);
            }
            bl = bl2;
            if (fragment.mViewLifecycleOwner != null) {
                bl = bl2;
                if (fragment.mViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.mViewLifecycleOwner.setCurrentState((Lifecycle.State)var1_3);
                    bl = true;
                }
            }
            if (!fragment.mLifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) continue;
            fragment.mLifecycleRegistry.setCurrentState((Lifecycle.State)var1_3);
            bl = true;
        }
        return bl;
    }

    final View dispatchFragmentsOnCreateView(View view, String string2, Context context, AttributeSet attributeSet) {
        return this.mFragments.onCreateView(view, string2, context, attributeSet);
    }

    public void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        super.dump(string2, fileDescriptor, printWriter, stringArray);
        if (!this.shouldDumpInternalState(stringArray)) {
            return;
        }
        printWriter.print(string2);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String string3 = string2 + "  ";
        printWriter.print(string3);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (this.getApplication() != null) {
            LoaderManager.getInstance(this).dump(string3, fileDescriptor, printWriter, stringArray);
        }
        this.mFragments.getSupportFragmentManager().dump(string2, fileDescriptor, printWriter, stringArray);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }

    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    /* synthetic */ Bundle lambda$init$0$androidx-fragment-app-FragmentActivity() {
        this.markFragmentsCreated();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    /* synthetic */ void lambda$init$1$androidx-fragment-app-FragmentActivity(Configuration configuration2) {
        this.mFragments.noteStateNotSaved();
    }

    /* synthetic */ void lambda$init$2$androidx-fragment-app-FragmentActivity(Intent intent) {
        this.mFragments.noteStateNotSaved();
    }

    /* synthetic */ void lambda$init$3$androidx-fragment-app-FragmentActivity(Context context) {
        this.mFragments.attachHost(null);
    }

    void markFragmentsCreated() {
        while (FragmentActivity.markState(this.getSupportFragmentManager(), Lifecycle.State.CREATED)) {
        }
    }

    @Override
    protected void onActivityResult(int n, int n2, Intent intent) {
        this.mFragments.noteStateNotSaved();
        super.onActivityResult(n, n2, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.mFragments.dispatchCreate();
    }

    public View onCreateView(View view, String string2, Context context, AttributeSet attributeSet) {
        View view2 = this.dispatchFragmentsOnCreateView(view, string2, context, attributeSet);
        if (view2 == null) {
            return super.onCreateView(view, string2, context, attributeSet);
        }
        return view2;
    }

    public View onCreateView(String string2, Context context, AttributeSet attributeSet) {
        View view = this.dispatchFragmentsOnCreateView(null, string2, context, attributeSet);
        if (view == null) {
            return super.onCreateView(string2, context, attributeSet);
        }
        return view;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mFragments.dispatchDestroy();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override
    public boolean onMenuItemSelected(int n, MenuItem menuItem) {
        if (super.onMenuItemSelected(n, menuItem)) {
            return true;
        }
        if (n == 6) {
            return this.mFragments.dispatchContextItemSelected(menuItem);
        }
        return false;
    }

    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.dispatchPause();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.onResumeFragments();
    }

    @Override
    public void onRequestPermissionsResult(int n, String[] stringArray, int[] nArray) {
        this.mFragments.noteStateNotSaved();
        super.onRequestPermissionsResult(n, stringArray, nArray);
    }

    protected void onResume() {
        this.mFragments.noteStateNotSaved();
        super.onResume();
        this.mResumed = true;
        this.mFragments.execPendingActions();
    }

    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.mFragments.dispatchResume();
    }

    protected void onStart() {
        this.mFragments.noteStateNotSaved();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.dispatchActivityCreated();
        }
        this.mFragments.execPendingActions();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.mFragments.dispatchStart();
    }

    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        this.markFragmentsCreated();
        this.mFragments.dispatchStop();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setEnterSharedElementCallback(this, sharedElementCallback);
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setExitSharedElementCallback(this, sharedElementCallback);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int n) {
        this.startActivityFromFragment(fragment, intent, n, null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int n, Bundle bundle) {
        if (n == -1) {
            ActivityCompat.startActivityForResult(this, intent, -1, bundle);
            return;
        }
        fragment.startActivityForResult(intent, n, bundle);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int n, Intent intent, int n2, int n3, int n4, Bundle bundle) throws IntentSender.SendIntentException {
        if (n == -1) {
            ActivityCompat.startIntentSenderForResult(this, intentSender, n, intent, n2, n3, n4, bundle);
            return;
        }
        fragment.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4, bundle);
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        this.invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    @Override
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int n) {
    }

    class HostCallbacks
    extends FragmentHostCallback<FragmentActivity>
    implements OnConfigurationChangedProvider,
    OnTrimMemoryProvider,
    OnMultiWindowModeChangedProvider,
    OnPictureInPictureModeChangedProvider,
    ViewModelStoreOwner,
    OnBackPressedDispatcherOwner,
    ActivityResultRegistryOwner,
    SavedStateRegistryOwner,
    FragmentOnAttachListener,
    MenuHost {
        final FragmentActivity this$0;

        public HostCallbacks(FragmentActivity fragmentActivity) {
            this.this$0 = fragmentActivity;
            super(fragmentActivity);
        }

        @Override
        public void addMenuProvider(MenuProvider menuProvider) {
            this.this$0.addMenuProvider(menuProvider);
        }

        @Override
        public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
            this.this$0.addMenuProvider(menuProvider, lifecycleOwner);
        }

        @Override
        public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
            this.this$0.addMenuProvider(menuProvider, lifecycleOwner, state);
        }

        @Override
        public void addOnConfigurationChangedListener(Consumer<Configuration> consumer) {
            this.this$0.addOnConfigurationChangedListener(consumer);
        }

        @Override
        public void addOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> consumer) {
            this.this$0.addOnMultiWindowModeChangedListener(consumer);
        }

        @Override
        public void addOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> consumer) {
            this.this$0.addOnPictureInPictureModeChangedListener(consumer);
        }

        @Override
        public void addOnTrimMemoryListener(Consumer<Integer> consumer) {
            this.this$0.addOnTrimMemoryListener(consumer);
        }

        @Override
        public ActivityResultRegistry getActivityResultRegistry() {
            return this.this$0.getActivityResultRegistry();
        }

        @Override
        public Lifecycle getLifecycle() {
            return this.this$0.mFragmentLifecycleRegistry;
        }

        @Override
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return this.this$0.getOnBackPressedDispatcher();
        }

        @Override
        public SavedStateRegistry getSavedStateRegistry() {
            return this.this$0.getSavedStateRegistry();
        }

        @Override
        public ViewModelStore getViewModelStore() {
            return this.this$0.getViewModelStore();
        }

        @Override
        public void invalidateMenu() {
            this.this$0.invalidateMenu();
        }

        @Override
        public void onAttachFragment(FragmentManager fragmentManager, Fragment fragment) {
            this.this$0.onAttachFragment(fragment);
        }

        @Override
        public void onDump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
            this.this$0.dump(string2, fileDescriptor, printWriter, stringArray);
        }

        @Override
        public View onFindViewById(int n) {
            return this.this$0.findViewById(n);
        }

        @Override
        public FragmentActivity onGetHost() {
            return this.this$0;
        }

        @Override
        public LayoutInflater onGetLayoutInflater() {
            return this.this$0.getLayoutInflater().cloneInContext((Context)this.this$0);
        }

        @Override
        public int onGetWindowAnimations() {
            Window window = this.this$0.getWindow();
            int n = window == null ? 0 : window.getAttributes().windowAnimations;
            return n;
        }

        @Override
        public boolean onHasView() {
            Window window = this.this$0.getWindow();
            boolean bl = window != null && window.peekDecorView() != null;
            return bl;
        }

        @Override
        public boolean onHasWindowAnimations() {
            boolean bl = this.this$0.getWindow() != null;
            return bl;
        }

        @Override
        public boolean onShouldSaveFragmentState(Fragment fragment) {
            return this.this$0.isFinishing() ^ true;
        }

        @Override
        public boolean onShouldShowRequestPermissionRationale(String string2) {
            return ActivityCompat.shouldShowRequestPermissionRationale(this.this$0, string2);
        }

        @Override
        public void onSupportInvalidateOptionsMenu() {
            this.invalidateMenu();
        }

        @Override
        public void removeMenuProvider(MenuProvider menuProvider) {
            this.this$0.removeMenuProvider(menuProvider);
        }

        @Override
        public void removeOnConfigurationChangedListener(Consumer<Configuration> consumer) {
            this.this$0.removeOnConfigurationChangedListener(consumer);
        }

        @Override
        public void removeOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> consumer) {
            this.this$0.removeOnMultiWindowModeChangedListener(consumer);
        }

        @Override
        public void removeOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> consumer) {
            this.this$0.removeOnPictureInPictureModeChangedListener(consumer);
        }

        @Override
        public void removeOnTrimMemoryListener(Consumer<Integer> consumer) {
            this.this$0.removeOnTrimMemoryListener(consumer);
        }
    }
}

