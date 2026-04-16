/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.content.res.Configuration
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver$OnDrawListener
 *  android.window.OnBackInvokedDispatcher
 *  kotlin.Unit
 */
package androidx.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda0;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda1;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda2;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda3;
import androidx.activity.ComponentActivity$ReportFullyDrawnExecutorApi16Impl$$ExternalSyntheticLambda0;
import androidx.activity.FullyDrawnReporter;
import androidx.activity.FullyDrawnReporterOwner;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeFullyDrawnReporterOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ComponentActivity
extends androidx.core.app.ComponentActivity
implements ContextAware,
LifecycleOwner,
ViewModelStoreOwner,
HasDefaultViewModelProviderFactory,
SavedStateRegistryOwner,
OnBackPressedDispatcherOwner,
ActivityResultRegistryOwner,
ActivityResultCaller,
OnConfigurationChangedProvider,
OnTrimMemoryProvider,
OnNewIntentProvider,
OnMultiWindowModeChangedProvider,
OnPictureInPictureModeChangedProvider,
MenuHost,
FullyDrawnReporterOwner {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final ContextAwareHelper mContextAwareHelper = new ContextAwareHelper();
    private ViewModelProvider.Factory mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged = false;
    private boolean mDispatchingOnPictureInPictureModeChanged = false;
    final FullyDrawnReporter mFullyDrawnReporter;
    private final LifecycleRegistry mLifecycleRegistry;
    private final MenuHostHelper mMenuHostHelper = new MenuHostHelper(new ComponentActivity$$ExternalSyntheticLambda0(this));
    private final AtomicInteger mNextLocalRequestCode;
    private OnBackPressedDispatcher mOnBackPressedDispatcher = null;
    private final CopyOnWriteArrayList<Consumer<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Integer>> mOnTrimMemoryListeners;
    final ReportFullyDrawnExecutor mReportFullyDrawnExecutor;
    final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    public ComponentActivity() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mReportFullyDrawnExecutor = this.createFullyDrawnExecutor();
        this.mFullyDrawnReporter = new FullyDrawnReporter(this.mReportFullyDrawnExecutor, new ComponentActivity$$ExternalSyntheticLambda1(this));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new ActivityResultRegistry(this){
            final ComponentActivity this$0;
            {
                this.this$0 = componentActivity;
            }

            /*
             * WARNING - void declaration
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public <I, O> void onLaunch(int n, ActivityResultContract<I, O> object, I object2, ActivityOptionsCompat object3) {
                void var2_5;
                block11: {
                    int n3;
                    int n2;
                    ComponentActivity componentActivity = this.this$0;
                    IntentSender intentSender = ((ActivityResultContract)object).getSynchronousResult((Context)componentActivity, object2);
                    if (intentSender != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable(){
                            final 1 this$1;
                            final int val$requestCode;
                            final ActivityResultContract.SynchronousResult val$synchronousResult;
                            {
                                this.this$1 = var1_1;
                                this.val$requestCode = n;
                                this.val$synchronousResult = synchronousResult;
                            }

                            @Override
                            public void run() {
                                this.this$1.dispatchResult(this.val$requestCode, this.val$synchronousResult.getValue());
                            }
                        });
                        return;
                    }
                    if ((object2 = ((ActivityResultContract)object).createIntent((Context)componentActivity, object2)).getExtras() != null && object2.getExtras().getClassLoader() == null) {
                        object2.setExtrasClassLoader(componentActivity.getClassLoader());
                    }
                    if (object2.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                        object = object2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                        object2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    } else {
                        object = object3 != null ? ((ActivityOptionsCompat)object3).toBundle() : null;
                    }
                    if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(object2.getAction())) {
                        object = object2 = object2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                        if (object2 == null) {
                            object = new String[]{};
                        }
                        ActivityCompat.requestPermissions(componentActivity, (String[])object, n);
                        return;
                    }
                    if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(object2.getAction())) {
                        ActivityCompat.startActivityForResult(componentActivity, (Intent)object2, n, (Bundle)object);
                        return;
                    }
                    object3 = (IntentSenderRequest)object2.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                    try {
                        intentSender = ((IntentSenderRequest)object3).getIntentSender();
                        object2 = ((IntentSenderRequest)object3).getFillInIntent();
                        n2 = ((IntentSenderRequest)object3).getFlagsMask();
                        n3 = ((IntentSenderRequest)object3).getFlagsValues();
                    }
                    catch (IntentSender.SendIntentException sendIntentException) {
                        // empty catch block
                        break block11;
                    }
                    try {
                        ActivityCompat.startIntentSenderForResult(componentActivity, intentSender, n, (Intent)object2, n2, n3, 0, (Bundle)object);
                        return;
                    }
                    catch (IntentSender.SendIntentException sendIntentException) {}
                }
                new Handler(Looper.getMainLooper()).post(new Runnable(){
                    final 1 this$1;
                    final IntentSender.SendIntentException val$e;
                    final int val$requestCode;
                    {
                        this.this$1 = var1_1;
                        this.val$requestCode = n;
                        this.val$e = sendIntentException;
                    }

                    @Override
                    public void run() {
                        this.this$1.dispatchResult(this.val$requestCode, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (Serializable)this.val$e));
                    }
                });
            }
        };
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        if (this.getLifecycle() != null) {
            this.getLifecycle().addObserver(new LifecycleEventObserver(this){
                final ComponentActivity this$0;
                {
                    this.this$0 = componentActivity;
                }

                @Override
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_STOP && (lifecycleOwner = (lifecycleOwner = this.this$0.getWindow()) != null ? lifecycleOwner.peekDecorView() : null) != null) {
                        Api19Impl.cancelPendingInputEvents((View)lifecycleOwner);
                    }
                }
            });
            this.getLifecycle().addObserver(new LifecycleEventObserver(this){
                final ComponentActivity this$0;
                {
                    this.this$0 = componentActivity;
                }

                @Override
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        this.this$0.mContextAwareHelper.clearAvailableContext();
                        if (!this.this$0.isChangingConfigurations()) {
                            this.this$0.getViewModelStore().clear();
                        }
                        this.this$0.mReportFullyDrawnExecutor.activityDestroyed();
                    }
                }
            });
            this.getLifecycle().addObserver(new LifecycleEventObserver(this){
                final ComponentActivity this$0;
                {
                    this.this$0 = componentActivity;
                }

                @Override
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    this.this$0.ensureViewModelStore();
                    this.this$0.getLifecycle().removeObserver(this);
                }
            });
            this.mSavedStateRegistryController.performAttach();
            SavedStateHandleSupport.enableSavedStateHandles(this);
            this.getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, new ComponentActivity$$ExternalSyntheticLambda2(this));
            this.addOnContextAvailableListener(new ComponentActivity$$ExternalSyntheticLambda3(this));
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public ComponentActivity(int n) {
        this();
        this.mContentLayoutId = n;
    }

    private ReportFullyDrawnExecutor createFullyDrawnExecutor() {
        return new ReportFullyDrawnExecutorApi16Impl(this);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(this.getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override
    public void addMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.addMenuProvider(menuProvider);
    }

    @Override
    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        this.mMenuHostHelper.addMenuProvider(menuProvider, lifecycleOwner);
    }

    @Override
    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        this.mMenuHostHelper.addMenuProvider(menuProvider, lifecycleOwner, state);
    }

    @Override
    public final void addOnConfigurationChangedListener(Consumer<Configuration> consumer) {
        this.mOnConfigurationChangedListeners.add(consumer);
    }

    @Override
    public final void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        this.mContextAwareHelper.addOnContextAvailableListener(onContextAvailableListener);
    }

    @Override
    public final void addOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> consumer) {
        this.mOnMultiWindowModeChangedListeners.add(consumer);
    }

    @Override
    public final void addOnNewIntentListener(Consumer<Intent> consumer) {
        this.mOnNewIntentListeners.add(consumer);
    }

    @Override
    public final void addOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.mOnPictureInPictureModeChangedListeners.add(consumer);
    }

    @Override
    public final void addOnTrimMemoryListener(Consumer<Integer> consumer) {
        this.mOnTrimMemoryListeners.add(consumer);
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances)this.getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                this.mViewModelStore = nonConfigurationInstances.viewModelStore;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new ViewModelStore();
            }
        }
    }

    @Override
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override
    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (this.getApplication() != null) {
            mutableCreationExtras.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, this.getApplication());
        }
        mutableCreationExtras.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        mutableCreationExtras.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (this.getIntent() != null && this.getIntent().getExtras() != null) {
            mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, this.getIntent().getExtras());
        }
        return mutableCreationExtras;
    }

    @Override
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            Application application = this.getApplication();
            Bundle bundle = this.getIntent() != null ? this.getIntent().getExtras() : null;
            this.mDefaultFactory = new SavedStateViewModelFactory(application, this, bundle);
        }
        return this.mDefaultFactory;
    }

    @Override
    public FullyDrawnReporter getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        Object object = (NonConfigurationInstances)this.getLastNonConfigurationInstance();
        object = object != null ? ((NonConfigurationInstances)object).custom : null;
        return object;
    }

    @Override
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable(this){
                final ComponentActivity this$0;
                {
                    this.this$0 = componentActivity;
                }

                @Override
                public void run() {
                    IllegalStateException illegalStateException2;
                    block4: {
                        try {
                            ComponentActivity.super.onBackPressed();
                        }
                        catch (NullPointerException nullPointerException) {
                            if (!TextUtils.equals((CharSequence)nullPointerException.getMessage(), (CharSequence)"Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                                throw nullPointerException;
                            }
                        }
                        catch (IllegalStateException illegalStateException2) {
                            if (!TextUtils.equals((CharSequence)illegalStateException2.getMessage(), (CharSequence)"Can not perform this action after onSaveInstanceState")) break block4;
                        }
                        return;
                    }
                    throw illegalStateException2;
                }
            });
            this.getLifecycle().addObserver(new LifecycleEventObserver(this){
                final ComponentActivity this$0;
                {
                    this.this$0 = componentActivity;
                }

                @Override
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_CREATE && Build.VERSION.SDK_INT >= 33) {
                        this.this$0.mOnBackPressedDispatcher.setOnBackInvokedDispatcher(Api33Impl.getOnBackInvokedDispatcher((ComponentActivity)lifecycleOwner));
                    }
                }
            });
        }
        return this.mOnBackPressedDispatcher;
    }

    @Override
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Override
    public ViewModelStore getViewModelStore() {
        if (this.getApplication() != null) {
            this.ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void initializeViewTreeOwners() {
        ViewTreeLifecycleOwner.set(this.getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(this.getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.set(this.getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.set(this.getWindow().getDecorView(), this);
        ViewTreeFullyDrawnReporterOwner.set(this.getWindow().getDecorView(), this);
    }

    @Override
    public void invalidateMenu() {
        this.invalidateOptionsMenu();
    }

    /* synthetic */ Unit lambda$new$0$androidx-activity-ComponentActivity() {
        this.reportFullyDrawn();
        return null;
    }

    /* synthetic */ Bundle lambda$new$1$androidx-activity-ComponentActivity() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.onSaveInstanceState(bundle);
        return bundle;
    }

    /* synthetic */ void lambda$new$2$androidx-activity-ComponentActivity(Context context) {
        context = this.getSavedStateRegistry().consumeRestoredStateForKey(ACTIVITY_RESULT_TAG);
        if (context != null) {
            this.mActivityResultRegistry.onRestoreInstanceState((Bundle)context);
        }
    }

    @Deprecated
    protected void onActivityResult(int n, int n2, Intent intent) {
        if (!this.mActivityResultRegistry.dispatchResult(n, n2, intent)) {
            super.onActivityResult(n, n2, intent);
        }
    }

    @Deprecated
    public void onBackPressed() {
        this.getOnBackPressedDispatcher().onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration2) {
        super.onConfigurationChanged(configuration2);
        Iterator<Consumer<Configuration>> iterator2 = this.mOnConfigurationChangedListeners.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().accept(configuration2);
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.performRestore(bundle);
        this.mContextAwareHelper.dispatchOnContextAvailable((Context)this);
        super.onCreate(bundle);
        ReportFragment.injectIfNeededIn(this);
        if (this.mContentLayoutId != 0) {
            this.setContentView(this.mContentLayoutId);
        }
    }

    public boolean onCreatePanelMenu(int n, Menu menu) {
        if (n == 0) {
            super.onCreatePanelMenu(n, menu);
            this.mMenuHostHelper.onCreateMenu(menu, this.getMenuInflater());
        }
        return true;
    }

    public boolean onMenuItemSelected(int n, MenuItem menuItem) {
        if (super.onMenuItemSelected(n, menuItem)) {
            return true;
        }
        if (n == 0) {
            return this.mMenuHostHelper.onMenuItemSelected(menuItem);
        }
        return false;
    }

    public void onMultiWindowModeChanged(boolean bl) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<Consumer<MultiWindowModeChangedInfo>> iterator2 = this.mOnMultiWindowModeChangedListeners.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().accept(new MultiWindowModeChangedInfo(bl));
        }
    }

    public void onMultiWindowModeChanged(boolean bl, Configuration configuration2) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        super.onMultiWindowModeChanged(bl, configuration2);
        Iterator<Consumer<MultiWindowModeChangedInfo>> iterator2 = this.mOnMultiWindowModeChangedListeners.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().accept(new MultiWindowModeChangedInfo(bl, configuration2));
        }
        return;
        finally {
            this.mDispatchingOnMultiWindowModeChanged = false;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<Consumer<Intent>> iterator2 = this.mOnNewIntentListeners.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().accept(intent);
        }
    }

    public void onPanelClosed(int n, Menu menu) {
        this.mMenuHostHelper.onMenuClosed(menu);
        super.onPanelClosed(n, menu);
    }

    public void onPictureInPictureModeChanged(boolean bl) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<Consumer<PictureInPictureModeChangedInfo>> iterator2 = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().accept(new PictureInPictureModeChangedInfo(bl));
        }
    }

    public void onPictureInPictureModeChanged(boolean bl, Configuration configuration2) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        super.onPictureInPictureModeChanged(bl, configuration2);
        Iterator<Consumer<PictureInPictureModeChangedInfo>> iterator2 = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().accept(new PictureInPictureModeChangedInfo(bl, configuration2));
        }
        return;
        finally {
            this.mDispatchingOnPictureInPictureModeChanged = false;
        }
    }

    public boolean onPreparePanel(int n, View view, Menu menu) {
        if (n == 0) {
            super.onPreparePanel(n, view, menu);
            this.mMenuHostHelper.onPrepareMenu(menu);
        }
        return true;
    }

    @Deprecated
    public void onRequestPermissionsResult(int n, String[] stringArray, int[] nArray) {
        if (!this.mActivityResultRegistry.dispatchResult(n, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", stringArray).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", nArray))) {
            super.onRequestPermissionsResult(n, stringArray, nArray);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        Object object = this.onRetainCustomNonConfigurationInstance();
        Object object2 = this.mViewModelStore;
        ViewModelStore viewModelStore = object2;
        if (object2 == null) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances)this.getLastNonConfigurationInstance();
            viewModelStore = object2;
            if (nonConfigurationInstances != null) {
                viewModelStore = nonConfigurationInstances.viewModelStore;
            }
        }
        if (viewModelStore == null && object == null) {
            return null;
        }
        object2 = new NonConfigurationInstances();
        ((NonConfigurationInstances)object2).custom = object;
        ((NonConfigurationInstances)object2).viewModelStore = viewModelStore;
        return object2;
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = this.getLifecycle();
        if (lifecycle instanceof LifecycleRegistry) {
            ((LifecycleRegistry)lifecycle).setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.performSave(bundle);
    }

    public void onTrimMemory(int n) {
        super.onTrimMemory(n);
        Iterator<Consumer<Integer>> iterator2 = this.mOnTrimMemoryListeners.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().accept(n);
        }
    }

    @Override
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.peekAvailableContext();
    }

    @Override
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        return this.registerForActivityResult(activityResultContract, this.mActivityResultRegistry, activityResultCallback);
    }

    @Override
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback<O> activityResultCallback) {
        return activityResultRegistry.register("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, activityResultContract, activityResultCallback);
    }

    @Override
    public void removeMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.removeMenuProvider(menuProvider);
    }

    @Override
    public final void removeOnConfigurationChangedListener(Consumer<Configuration> consumer) {
        this.mOnConfigurationChangedListeners.remove(consumer);
    }

    @Override
    public final void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        this.mContextAwareHelper.removeOnContextAvailableListener(onContextAvailableListener);
    }

    @Override
    public final void removeOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> consumer) {
        this.mOnMultiWindowModeChangedListeners.remove(consumer);
    }

    @Override
    public final void removeOnNewIntentListener(Consumer<Intent> consumer) {
        this.mOnNewIntentListeners.remove(consumer);
    }

    @Override
    public final void removeOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.mOnPictureInPictureModeChangedListeners.remove(consumer);
    }

    @Override
    public final void removeOnTrimMemoryListener(Consumer<Integer> consumer) {
        this.mOnTrimMemoryListeners.remove(consumer);
    }

    public void reportFullyDrawn() {
        try {
            if (Trace.isEnabled()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.mFullyDrawnReporter.fullyDrawnReported();
            return;
        }
        finally {
            Trace.endSection();
        }
    }

    public void setContentView(int n) {
        this.initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(this.getWindow().getDecorView());
        super.setContentView(n);
    }

    public void setContentView(View view) {
        this.initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(this.getWindow().getDecorView());
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(this.getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int n) {
        super.startActivityForResult(intent, n);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int n, Bundle bundle) {
        super.startActivityForResult(intent, n, bundle);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int n, Intent intent, int n2, int n3, int n4) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int n, Intent intent, int n2, int n3, int n4, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4, bundle);
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static void cancelPendingInputEvents(View view) {
            view.cancelPendingInputEvents();
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    static final class NonConfigurationInstances {
        Object custom;
        ViewModelStore viewModelStore;

        NonConfigurationInstances() {
        }
    }

    private static interface ReportFullyDrawnExecutor
    extends Executor {
        public void activityDestroyed();

        public void viewCreated(View var1);
    }

    static class ReportFullyDrawnExecutorApi1
    implements ReportFullyDrawnExecutor {
        final Handler mHandler = this.createHandler();

        ReportFullyDrawnExecutorApi1() {
        }

        private Handler createHandler() {
            Looper looper = Looper.myLooper();
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            return new Handler(looper);
        }

        @Override
        public void activityDestroyed() {
        }

        @Override
        public void execute(Runnable runnable2) {
            this.mHandler.postAtFrontOfQueue(runnable2);
        }

        @Override
        public void viewCreated(View view) {
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    class ReportFullyDrawnExecutorApi16Impl
    implements ReportFullyDrawnExecutor,
    ViewTreeObserver.OnDrawListener,
    Runnable {
        final long mEndWatchTimeMillis;
        boolean mOnDrawScheduled;
        Runnable mRunnable;
        final ComponentActivity this$0;

        ReportFullyDrawnExecutorApi16Impl(ComponentActivity componentActivity) {
            this.this$0 = componentActivity;
            this.mEndWatchTimeMillis = SystemClock.uptimeMillis() + 10000L;
            this.mOnDrawScheduled = false;
        }

        @Override
        public void activityDestroyed() {
            this.this$0.getWindow().getDecorView().removeCallbacks((Runnable)this);
            this.this$0.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener((ViewTreeObserver.OnDrawListener)this);
        }

        @Override
        public void execute(Runnable runnable2) {
            this.mRunnable = runnable2;
            runnable2 = this.this$0.getWindow().getDecorView();
            if (this.mOnDrawScheduled) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    runnable2.invalidate();
                } else {
                    runnable2.postInvalidate();
                }
            } else {
                runnable2.postOnAnimation(new ComponentActivity$ReportFullyDrawnExecutorApi16Impl$$ExternalSyntheticLambda0(this));
            }
        }

        /* synthetic */ void lambda$execute$0$androidx-activity-ComponentActivity$ReportFullyDrawnExecutorApi16Impl() {
            if (this.mRunnable != null) {
                this.mRunnable.run();
                this.mRunnable = null;
            }
        }

        public void onDraw() {
            Runnable runnable2 = this.mRunnable;
            if (runnable2 != null) {
                runnable2.run();
                this.mRunnable = null;
                if (this.this$0.mFullyDrawnReporter.isFullyDrawnReported()) {
                    this.mOnDrawScheduled = false;
                    this.this$0.getWindow().getDecorView().post((Runnable)this);
                }
            } else if (SystemClock.uptimeMillis() > this.mEndWatchTimeMillis) {
                this.mOnDrawScheduled = false;
                this.this$0.getWindow().getDecorView().post((Runnable)this);
            }
        }

        @Override
        public void run() {
            this.this$0.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener((ViewTreeObserver.OnDrawListener)this);
        }

        @Override
        public void viewCreated(View view) {
            if (!this.mOnDrawScheduled) {
                this.mOnDrawScheduled = true;
                view.getViewTreeObserver().addOnDrawListener((ViewTreeObserver.OnDrawListener)this);
            }
        }
    }
}

