/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.app.Activity
 *  android.app.Application
 *  android.content.ComponentCallbacks
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.ContextMenu
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnCreateContextMenuListener
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.arch.core.util.Function;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.fragment.app.FragmentViewLifecycleOwner;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.SuperNotCalledException;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Fragment
implements ComponentCallbacks,
View.OnCreateContextMenuListener,
LifecycleOwner,
ViewModelStoreOwner,
HasDefaultViewModelProviderFactory,
SavedStateRegistryOwner,
ActivityResultCaller {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    AnimationInfo mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    ViewModelProvider.Factory mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    private Boolean mIsPrimaryNavigationFragment = null;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    Lifecycle.State mMaxState;
    boolean mMenuVisible = true;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<OnPreAttachedListener> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    Runnable mPostponedDurationRunnable;
    Handler mPostponedHandler;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    private final OnPreAttachedListener mSavedStateAttachListener;
    SavedStateRegistryController mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState = -1;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho = null;
    boolean mUserVisibleHint = true;
    View mView;
    FragmentViewLifecycleOwner mViewLifecycleOwner;
    MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData;
    String mWho = UUID.randomUUID().toString();

    public Fragment() {
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mPostponedDurationRunnable = new Runnable(this){
            final Fragment this$0;
            {
                this.this$0 = fragment;
            }

            @Override
            public void run() {
                this.this$0.startPostponedEnterTransition();
            }
        };
        this.mMaxState = Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new MutableLiveData();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList();
        this.mSavedStateAttachListener = new OnPreAttachedListener(this){
            final Fragment this$0;
            {
                this.this$0 = fragment;
            }

            @Override
            void onPreAttached() {
                this.this$0.mSavedStateRegistryController.performAttach();
                SavedStateHandleSupport.enableSavedStateHandles(this.this$0);
            }
        };
        this.initLifecycle();
    }

    public Fragment(int n) {
        this();
        this.mContentLayoutId = n;
    }

    private AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new AnimationInfo();
        }
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        if (this.mMaxState != Lifecycle.State.INITIALIZED && this.mParentFragment != null) {
            return Math.min(this.mMaxState.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
        }
        return this.mMaxState.ordinal();
    }

    private Fragment getTargetFragment(boolean bl) {
        if (bl) {
            FragmentStrictMode.onGetTargetFragmentUsage(this);
        }
        if (this.mTarget != null) {
            return this.mTarget;
        }
        if (this.mFragmentManager != null && this.mTargetWho != null) {
            return this.mFragmentManager.findActiveFragment(this.mTargetWho);
        }
        return null;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mDefaultFactory = null;
        if (!this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            this.registerOnPreAttachListener(this.mSavedStateAttachListener);
        }
    }

    @Deprecated
    public static Fragment instantiate(Context context, String string2) {
        return Fragment.instantiate(context, string2, null);
    }

    @Deprecated
    public static Fragment instantiate(Context object, String string2, Bundle bundle) {
        block6: {
            object = FragmentFactory.loadFragmentClass(object.getClassLoader(), string2).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle == null) break block6;
            try {
                bundle.setClassLoader(object.getClass().getClassLoader());
                ((Fragment)object).setArguments(bundle);
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new InstantiationException("Unable to instantiate fragment " + string2 + ": calling Fragment constructor caused an exception", invocationTargetException);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new InstantiationException("Unable to instantiate fragment " + string2 + ": could not find Fragment constructor", noSuchMethodException);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new InstantiationException("Unable to instantiate fragment " + string2 + ": make sure class name exists, is public, and has an empty constructor that is public", illegalAccessException);
            }
            catch (java.lang.InstantiationException instantiationException) {
                throw new InstantiationException("Unable to instantiate fragment " + string2 + ": make sure class name exists, is public, and has an empty constructor that is public", instantiationException);
            }
        }
        return object;
    }

    private <I, O> ActivityResultLauncher<I> prepareCallInternal(ActivityResultContract<I, O> activityResultContract, Function<Void, ActivityResultRegistry> function, ActivityResultCallback<O> activityResultCallback) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            this.registerOnPreAttachListener(new OnPreAttachedListener(this, function, atomicReference, activityResultContract, activityResultCallback){
                final Fragment this$0;
                final ActivityResultCallback val$callback;
                final ActivityResultContract val$contract;
                final AtomicReference val$ref;
                final Function val$registryProvider;
                {
                    this.this$0 = fragment;
                    this.val$registryProvider = function;
                    this.val$ref = atomicReference;
                    this.val$contract = activityResultContract;
                    this.val$callback = activityResultCallback;
                }

                @Override
                void onPreAttached() {
                    String string2 = this.this$0.generateActivityResultKey();
                    ActivityResultRegistry activityResultRegistry = (ActivityResultRegistry)this.val$registryProvider.apply(null);
                    this.val$ref.set(activityResultRegistry.register(string2, this.this$0, this.val$contract, this.val$callback));
                }
            });
            return new ActivityResultLauncher<I>(this, atomicReference, activityResultContract){
                final Fragment this$0;
                final ActivityResultContract val$contract;
                final AtomicReference val$ref;
                {
                    this.this$0 = fragment;
                    this.val$ref = atomicReference;
                    this.val$contract = activityResultContract;
                }

                @Override
                public ActivityResultContract<I, ?> getContract() {
                    return this.val$contract;
                }

                @Override
                public void launch(I i, ActivityOptionsCompat activityOptionsCompat) {
                    ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher)this.val$ref.get();
                    if (activityResultLauncher != null) {
                        activityResultLauncher.launch(i, activityOptionsCompat);
                        return;
                    }
                    throw new IllegalStateException("Operation cannot be started before fragment is in created state");
                }

                @Override
                public void unregister() {
                    ActivityResultLauncher activityResultLauncher = this.val$ref.getAndSet(null);
                    if (activityResultLauncher != null) {
                        activityResultLauncher.unregister();
                    }
                }
            };
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void registerOnPreAttachListener(OnPreAttachedListener onPreAttachedListener) {
        if (this.mState >= 0) {
            onPreAttachedListener.onPreAttached();
        } else {
            this.mOnPreAttachedListeners.add(onPreAttachedListener);
        }
    }

    private void restoreViewState() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d((String)"FragmentManager", (String)("moveto RESTORE_VIEW_STATE: " + this));
        }
        if (this.mView != null) {
            this.restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }

    void callStartTransitionListener(boolean bl) {
        if (this.mAnimationInfo != null) {
            this.mAnimationInfo.mEnterTransitionPostponed = false;
        }
        if (this.mView != null && this.mContainer != null && this.mFragmentManager != null) {
            SpecialEffectsController specialEffectsController = SpecialEffectsController.getOrCreateController(this.mContainer, this.mFragmentManager);
            specialEffectsController.markPostponedState();
            if (bl) {
                this.mHost.getHandler().post(new Runnable(this, specialEffectsController){
                    final Fragment this$0;
                    final SpecialEffectsController val$controller;
                    {
                        this.this$0 = fragment;
                        this.val$controller = specialEffectsController;
                    }

                    @Override
                    public void run() {
                        this.val$controller.executePendingOperations();
                    }
                });
            } else {
                specialEffectsController.executePendingOperations();
            }
            if (this.mPostponedHandler != null) {
                this.mPostponedHandler.removeCallbacks(this.mPostponedDurationRunnable);
                this.mPostponedHandler = null;
            }
        }
    }

    FragmentContainer createFragmentContainer() {
        return new FragmentContainer(this){
            final Fragment this$0;
            {
                this.this$0 = fragment;
            }

            @Override
            public View onFindViewById(int n) {
                if (this.this$0.mView != null) {
                    return this.this$0.mView.findViewById(n);
                }
                throw new IllegalStateException("Fragment " + this.this$0 + " does not have a view");
            }

            @Override
            public boolean onHasView() {
                boolean bl = this.this$0.mView != null;
                return bl;
            }
        };
    }

    public void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        Fragment fragment;
        printWriter.print(string2);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(string2);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(string2);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(string2);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(string2);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(string2);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(string2);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(string2);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(string2);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(string2);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(string2);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(string2);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        if ((fragment = this.getTargetFragment(false)) != null) {
            printWriter.print(string2);
            printWriter.print("mTarget=");
            printWriter.print(fragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(string2);
        printWriter.print("mPopDirection=");
        printWriter.println(this.getPopDirection());
        if (this.getEnterAnim() != 0) {
            printWriter.print(string2);
            printWriter.print("getEnterAnim=");
            printWriter.println(this.getEnterAnim());
        }
        if (this.getExitAnim() != 0) {
            printWriter.print(string2);
            printWriter.print("getExitAnim=");
            printWriter.println(this.getExitAnim());
        }
        if (this.getPopEnterAnim() != 0) {
            printWriter.print(string2);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(this.getPopEnterAnim());
        }
        if (this.getPopExitAnim() != 0) {
            printWriter.print(string2);
            printWriter.print("getPopExitAnim=");
            printWriter.println(this.getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(string2);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(string2);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.getAnimatingAway() != null) {
            printWriter.print(string2);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.getAnimatingAway());
        }
        if (this.getContext() != null) {
            LoaderManager.getInstance(this).dump(string2, fileDescriptor, printWriter, stringArray);
        }
        printWriter.print(string2);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.dump(string2 + "  ", fileDescriptor, printWriter, stringArray);
    }

    public final boolean equals(Object object) {
        return super.equals(object);
    }

    Fragment findFragmentByWho(String string2) {
        if (string2.equals(this.mWho)) {
            return this;
        }
        return this.mChildFragmentManager.findFragmentByWho(string2);
    }

    String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final FragmentActivity getActivity() {
        FragmentActivity fragmentActivity = this.mHost == null ? null : (FragmentActivity)this.mHost.getActivity();
        return fragmentActivity;
    }

    public boolean getAllowEnterTransitionOverlap() {
        boolean bl = this.mAnimationInfo != null && this.mAnimationInfo.mAllowEnterTransitionOverlap != null ? this.mAnimationInfo.mAllowEnterTransitionOverlap : true;
        return bl;
    }

    public boolean getAllowReturnTransitionOverlap() {
        boolean bl = this.mAnimationInfo != null && this.mAnimationInfo.mAllowReturnTransitionOverlap != null ? this.mAnimationInfo.mAllowReturnTransitionOverlap : true;
        return bl;
    }

    View getAnimatingAway() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mAnimatingAway;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        Context context = this.mHost == null ? null : this.mHost.getContext();
        return context;
    }

    @Override
    public CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        Application application2 = null;
        Object object = this.requireContext().getApplicationContext();
        while (true) {
            application = application2;
            if (!(object instanceof ContextWrapper)) break;
            if (object instanceof Application) {
                application = (Application)object;
                break;
            }
            object = ((ContextWrapper)object).getBaseContext();
        }
        if (application == null && FragmentManager.isLoggingEnabled(3)) {
            Log.d((String)"FragmentManager", (String)("Could not find Application instance from Context " + this.requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory"));
        }
        object = new MutableCreationExtras();
        if (application != null) {
            ((MutableCreationExtras)object).set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, application);
        }
        ((MutableCreationExtras)object).set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        ((MutableCreationExtras)object).set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (this.getArguments() != null) {
            ((MutableCreationExtras)object).set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, this.getArguments());
        }
        return object;
    }

    @Override
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager != null) {
            if (this.mDefaultFactory == null) {
                Application application;
                Application application2 = null;
                Context context = this.requireContext().getApplicationContext();
                while (true) {
                    application = application2;
                    if (!(context instanceof ContextWrapper)) break;
                    if (context instanceof Application) {
                        application = (Application)context;
                        break;
                    }
                    context = ((ContextWrapper)context).getBaseContext();
                }
                if (application == null && FragmentManager.isLoggingEnabled(3)) {
                    Log.d((String)"FragmentManager", (String)("Could not find Application instance from Context " + this.requireContext().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory"));
                }
                this.mDefaultFactory = new SavedStateViewModelFactory(application, this, this.getArguments());
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    int getEnterAnim() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.mEnterAnim;
    }

    public Object getEnterTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mEnterTransition;
    }

    SharedElementCallback getEnterTransitionCallback() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mEnterTransitionCallback;
    }

    int getExitAnim() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.mExitAnim;
    }

    public Object getExitTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mExitTransition;
    }

    SharedElementCallback getExitTransitionCallback() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mExitTransitionCallback;
    }

    View getFocusedView() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mFocusedView;
    }

    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        Object var1_1 = this.mHost == null ? null : this.mHost.onGetHost();
        return var1_1;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        if (this.mLayoutInflater == null) {
            return this.performGetLayoutInflater(null);
        }
        return this.mLayoutInflater;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        if (this.mHost != null) {
            bundle = this.mHost.onGetLayoutInflater();
            LayoutInflaterCompat.setFactory2((LayoutInflater)bundle, this.mChildFragmentManager.getLayoutInflaterFactory());
            return bundle;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Override
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    int getNextTransition() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.mNextTransition;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    boolean getPopDirection() {
        if (this.mAnimationInfo == null) {
            return false;
        }
        return this.mAnimationInfo.mIsPop;
    }

    int getPopEnterAnim() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.mPopEnterAnim;
    }

    int getPopExitAnim() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.mPopExitAnim;
    }

    float getPostOnViewCreatedAlpha() {
        if (this.mAnimationInfo == null) {
            return 1.0f;
        }
        return this.mAnimationInfo.mPostOnViewCreatedAlpha;
    }

    public Object getReenterTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        Object object = this.mAnimationInfo.mReenterTransition == USE_DEFAULT_TRANSITION ? this.getExitTransition() : this.mAnimationInfo.mReenterTransition;
        return object;
    }

    public final Resources getResources() {
        return this.requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        FragmentStrictMode.onGetRetainInstanceUsage(this);
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        Object object = this.mAnimationInfo.mReturnTransition == USE_DEFAULT_TRANSITION ? this.getEnterTransition() : this.mAnimationInfo.mReturnTransition;
        return object;
    }

    @Override
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public Object getSharedElementEnterTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mSharedElementEnterTransition;
    }

    public Object getSharedElementReturnTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        Object object = this.mAnimationInfo.mSharedElementReturnTransition == USE_DEFAULT_TRANSITION ? this.getSharedElementEnterTransition() : this.mAnimationInfo.mSharedElementReturnTransition;
        return object;
    }

    ArrayList<String> getSharedElementSourceNames() {
        if (this.mAnimationInfo != null && this.mAnimationInfo.mSharedElementSourceNames != null) {
            return this.mAnimationInfo.mSharedElementSourceNames;
        }
        return new ArrayList<String>();
    }

    ArrayList<String> getSharedElementTargetNames() {
        if (this.mAnimationInfo != null && this.mAnimationInfo.mSharedElementTargetNames != null) {
            return this.mAnimationInfo.mSharedElementTargetNames;
        }
        return new ArrayList<String>();
    }

    public final String getString(int n) {
        return this.getResources().getString(n);
    }

    public final String getString(int n, Object ... objectArray) {
        return this.getResources().getString(n, objectArray);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        return this.getTargetFragment(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        FragmentStrictMode.onGetTargetFragmentRequestCodeUsage(this);
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int n) {
        return this.getResources().getText(n);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public LifecycleOwner getViewLifecycleOwner() {
        if (this.mViewLifecycleOwner != null) {
            return this.mViewLifecycleOwner;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override
    public ViewModelStore getViewModelStore() {
        if (this.mFragmentManager != null) {
            if (this.getMinimumMaxLifecycleState() != Lifecycle.State.INITIALIZED.ordinal()) {
                return this.mFragmentManager.getViewModelStore(this);
            }
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void initState() {
        this.initLifecycle();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        boolean bl = this.mHost != null && this.mAdded;
        return bl;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        boolean bl = this.mHidden || this.mFragmentManager != null && this.mFragmentManager.isParentHidden(this.mParentFragment);
        return bl;
    }

    final boolean isInBackStack() {
        boolean bl = this.mBackStackNesting > 0;
        return bl;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        boolean bl = this.mMenuVisible && (this.mFragmentManager == null || this.mFragmentManager.isParentMenuVisible(this.mParentFragment));
        return bl;
    }

    boolean isPostponed() {
        if (this.mAnimationInfo == null) {
            return false;
        }
        return this.mAnimationInfo.mEnterTransitionPostponed;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        boolean bl = this.mState >= 7;
        return bl;
    }

    public final boolean isStateSaved() {
        if (this.mFragmentManager == null) {
            return false;
        }
        return this.mFragmentManager.isStateSaved();
    }

    public final boolean isVisible() {
        boolean bl = this.isAdded() && !this.isHidden() && this.mView != null && this.mView.getWindowToken() != null && this.mView.getVisibility() == 0;
        return bl;
    }

    void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int n, int n2, Intent intent) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)"FragmentManager", (String)("Fragment " + this + " received the following in onActivityResult(): requestCode: " + n + " resultCode: " + n2 + " data: " + intent));
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onAttach(Context object) {
        this.mCalled = true;
        object = this.mHost == null ? null : this.mHost.getActivity();
        if (object != null) {
            this.mCalled = false;
            this.onAttach((Activity)object);
        }
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration2) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        this.restoreChildFragmentState(bundle);
        if (!this.mChildFragmentManager.isStateAtLeast(1)) {
            this.mChildFragmentManager.dispatchCreate();
        }
    }

    public Animation onCreateAnimation(int n, boolean bl, int n2) {
        return null;
    }

    public Animator onCreateAnimator(int n, boolean bl, int n2) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mContentLayoutId != 0) {
            return layoutInflater.inflate(this.mContentLayoutId, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return this.getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean bl) {
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onInflate(Context object, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        object = this.mHost == null ? null : this.mHost.getActivity();
        if (object != null) {
            this.mCalled = false;
            this.onInflate((Activity)object, attributeSet, bundle);
        }
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean bl) {
    }

    @Deprecated
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Deprecated
    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean bl) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean bl) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int n, String[] stringArray, int[] nArray) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 3;
        this.mCalled = false;
        this.onActivityCreated(bundle);
        if (this.mCalled) {
            this.restoreViewState();
            this.mChildFragmentManager.dispatchActivityCreated();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    void performAttach() {
        Iterator<OnPreAttachedListener> iterator2 = this.mOnPreAttachedListeners.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().onPreAttached();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.attachController(this.mHost, this.createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        this.onAttach(this.mHost.getContext());
        if (this.mCalled) {
            this.mFragmentManager.dispatchOnAttachFragment(this);
            this.mChildFragmentManager.dispatchAttach();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
    }

    void performConfigurationChanged(Configuration configuration2) {
        this.onConfigurationChanged(configuration2);
    }

    boolean performContextItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (this.onContextItemSelected(menuItem)) {
                return true;
            }
            return this.mChildFragmentManager.dispatchContextItemSelected(menuItem);
        }
        return false;
    }

    void performCreate(Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.addObserver(new LifecycleEventObserver(this){
            final Fragment this$0;
            {
                this.this$0 = fragment;
            }

            @Override
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_STOP && this.this$0.mView != null) {
                    Api19Impl.cancelPendingInputEvents(this.this$0.mView);
                }
            }
        });
        this.mSavedStateRegistryController.performRestore(bundle);
        this.onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean bl = false;
        boolean bl2 = false;
        if (!this.mHidden) {
            boolean bl3 = bl2;
            if (this.mHasMenu) {
                bl3 = bl2;
                if (this.mMenuVisible) {
                    bl3 = true;
                    this.onCreateOptionsMenu(menu, menuInflater);
                }
            }
            bl = bl3 | this.mChildFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
        }
        return bl;
    }

    void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        block4: {
            block3: {
                block2: {
                    this.mChildFragmentManager.noteStateNotSaved();
                    this.mPerformedCreateView = true;
                    this.mViewLifecycleOwner = new FragmentViewLifecycleOwner(this, this.getViewModelStore());
                    this.mView = this.onCreateView(layoutInflater, viewGroup, bundle);
                    if (this.mView == null) break block2;
                    this.mViewLifecycleOwner.initialize();
                    ViewTreeLifecycleOwner.set(this.mView, this.mViewLifecycleOwner);
                    ViewTreeViewModelStoreOwner.set(this.mView, this.mViewLifecycleOwner);
                    ViewTreeSavedStateRegistryOwner.set(this.mView, this.mViewLifecycleOwner);
                    this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
                    break block3;
                }
                if (this.mViewLifecycleOwner.isInitialized()) break block4;
                this.mViewLifecycleOwner = null;
            }
            return;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    void performDestroy() {
        this.mChildFragmentManager.dispatchDestroy();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        this.onDestroy();
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void performDestroyView() {
        this.mChildFragmentManager.dispatchDestroyView();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        this.onDestroyView();
        if (this.mCalled) {
            LoaderManager.getInstance(this).markForRedelivery();
            this.mPerformedCreateView = false;
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        this.onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            if (!this.mChildFragmentManager.isDestroyed()) {
                this.mChildFragmentManager.dispatchDestroy();
                this.mChildFragmentManager = new FragmentManagerImpl();
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }

    LayoutInflater performGetLayoutInflater(Bundle bundle) {
        this.mLayoutInflater = this.onGetLayoutInflater(bundle);
        return this.mLayoutInflater;
    }

    void performLowMemory() {
        this.onLowMemory();
    }

    void performMultiWindowModeChanged(boolean bl) {
        this.onMultiWindowModeChanged(bl);
    }

    boolean performOptionsItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible && this.onOptionsItemSelected(menuItem)) {
                return true;
            }
            return this.mChildFragmentManager.dispatchOptionsItemSelected(menuItem);
        }
        return false;
    }

    void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                this.onOptionsMenuClosed(menu);
            }
            this.mChildFragmentManager.dispatchOptionsMenuClosed(menu);
        }
    }

    void performPause() {
        this.mChildFragmentManager.dispatchPause();
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        this.onPause();
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    void performPictureInPictureModeChanged(boolean bl) {
        this.onPictureInPictureModeChanged(bl);
    }

    boolean performPrepareOptionsMenu(Menu menu) {
        boolean bl = false;
        boolean bl2 = false;
        if (!this.mHidden) {
            boolean bl3 = bl2;
            if (this.mHasMenu) {
                bl3 = bl2;
                if (this.mMenuVisible) {
                    bl3 = true;
                    this.onPrepareOptionsMenu(menu);
                }
            }
            bl = bl3 | this.mChildFragmentManager.dispatchPrepareOptionsMenu(menu);
        }
        return bl;
    }

    void performPrimaryNavigationFragmentChanged() {
        boolean bl = this.mFragmentManager.isPrimaryNavigation(this);
        if (this.mIsPrimaryNavigationFragment == null || this.mIsPrimaryNavigationFragment != bl) {
            this.mIsPrimaryNavigationFragment = bl;
            this.onPrimaryNavigationFragmentChanged(bl);
            this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
        }
    }

    void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 7;
        this.mCalled = false;
        this.onResume();
        if (this.mCalled) {
            this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            if (this.mView != null) {
                this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            }
            this.mChildFragmentManager.dispatchResume();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    void performSaveInstanceState(Bundle bundle) {
        this.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.performSave(bundle);
        Bundle bundle2 = this.mChildFragmentManager.saveAllStateInternal();
        if (bundle2 != null) {
            bundle.putParcelable("android:support:fragments", (Parcelable)bundle2);
        }
    }

    void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 5;
        this.mCalled = false;
        this.onStart();
        if (this.mCalled) {
            this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
            if (this.mView != null) {
                this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_START);
            }
            this.mChildFragmentManager.dispatchStart();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    void performStop() {
        this.mChildFragmentManager.dispatchStop();
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        this.onStop();
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    void performViewCreated() {
        this.onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.dispatchViewCreated();
    }

    public void postponeEnterTransition() {
        this.ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    public final void postponeEnterTransition(long l, TimeUnit timeUnit) {
        this.ensureAnimationInfo().mEnterTransitionPostponed = true;
        if (this.mPostponedHandler != null) {
            this.mPostponedHandler.removeCallbacks(this.mPostponedDurationRunnable);
        }
        this.mPostponedHandler = this.mFragmentManager != null ? this.mFragmentManager.getHost().getHandler() : new Handler(Looper.getMainLooper());
        this.mPostponedHandler.removeCallbacks(this.mPostponedDurationRunnable);
        this.mPostponedHandler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(l));
    }

    @Override
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        return this.prepareCallInternal(activityResultContract, new Function<Void, ActivityResultRegistry>(this){
            final Fragment this$0;
            {
                this.this$0 = fragment;
            }

            @Override
            public ActivityResultRegistry apply(Void void_) {
                if (this.this$0.mHost instanceof ActivityResultRegistryOwner) {
                    return ((ActivityResultRegistryOwner)((Object)this.this$0.mHost)).getActivityResultRegistry();
                }
                return this.this$0.requireActivity().getActivityResultRegistry();
            }
        }, activityResultCallback);
    }

    @Override
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback<O> activityResultCallback) {
        return this.prepareCallInternal(activityResultContract, new Function<Void, ActivityResultRegistry>(this, activityResultRegistry){
            final Fragment this$0;
            final ActivityResultRegistry val$registry;
            {
                this.this$0 = fragment;
                this.val$registry = activityResultRegistry;
            }

            @Override
            public ActivityResultRegistry apply(Void void_) {
                return this.val$registry;
            }
        }, activityResultCallback);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener((View.OnCreateContextMenuListener)this);
    }

    @Deprecated
    public final void requestPermissions(String[] stringArray, int n) {
        if (this.mHost != null) {
            this.getParentFragmentManager().launchRequestPermissions(this, stringArray, n);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Bundle requireArguments() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            return bundle;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final Context requireContext() {
        Context context = this.getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return this.getParentFragmentManager();
    }

    public final Object requireHost() {
        Object object = this.getHost();
        if (object != null) {
            return object;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Fragment requireParentFragment() {
        Fragment fragment = this.getParentFragment();
        if (fragment == null) {
            if (this.getContext() == null) {
                throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
            }
            throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + this.getContext());
        }
        return fragment;
    }

    public final View requireView() {
        View view = this.getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    void restoreChildFragmentState(Bundle bundle) {
        if (bundle != null && (bundle = bundle.getParcelable("android:support:fragments")) != null) {
            this.mChildFragmentManager.restoreSaveStateInternal((Parcelable)bundle);
            this.mChildFragmentManager.dispatchCreate();
        }
    }

    final void restoreViewState(Bundle bundle) {
        if (this.mSavedViewState != null) {
            this.mView.restoreHierarchyState(this.mSavedViewState);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.performRestore(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        this.onViewStateRestored(bundle);
        if (this.mCalled) {
            if (this.mView != null) {
                this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public void setAllowEnterTransitionOverlap(boolean bl) {
        this.ensureAnimationInfo().mAllowEnterTransitionOverlap = bl;
    }

    public void setAllowReturnTransitionOverlap(boolean bl) {
        this.ensureAnimationInfo().mAllowReturnTransitionOverlap = bl;
    }

    void setAnimations(int n, int n2, int n3, int n4) {
        if (this.mAnimationInfo == null && n == 0 && n2 == 0 && n3 == 0 && n4 == 0) {
            return;
        }
        this.ensureAnimationInfo().mEnterAnim = n;
        this.ensureAnimationInfo().mExitAnim = n2;
        this.ensureAnimationInfo().mPopEnterAnim = n3;
        this.ensureAnimationInfo().mPopExitAnim = n4;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && this.isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.ensureAnimationInfo().mEnterTransitionCallback = sharedElementCallback;
    }

    public void setEnterTransition(Object object) {
        this.ensureAnimationInfo().mEnterTransition = object;
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.ensureAnimationInfo().mExitTransitionCallback = sharedElementCallback;
    }

    public void setExitTransition(Object object) {
        this.ensureAnimationInfo().mExitTransition = object;
    }

    void setFocusedView(View view) {
        this.ensureAnimationInfo().mFocusedView = view;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean bl) {
        if (this.mHasMenu != bl) {
            this.mHasMenu = bl;
            if (this.isAdded() && !this.isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setInitialSavedState(SavedState savedState) {
        if (this.mFragmentManager == null) {
            savedState = savedState != null && savedState.mState != null ? savedState.mState : null;
            this.mSavedFragmentState = savedState;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean bl) {
        if (this.mMenuVisible != bl) {
            this.mMenuVisible = bl;
            if (this.mHasMenu && this.isAdded() && !this.isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    void setNextTransition(int n) {
        if (this.mAnimationInfo == null && n == 0) {
            return;
        }
        this.ensureAnimationInfo();
        this.mAnimationInfo.mNextTransition = n;
    }

    void setPopDirection(boolean bl) {
        if (this.mAnimationInfo == null) {
            return;
        }
        this.ensureAnimationInfo().mIsPop = bl;
    }

    void setPostOnViewCreatedAlpha(float f) {
        this.ensureAnimationInfo().mPostOnViewCreatedAlpha = f;
    }

    public void setReenterTransition(Object object) {
        this.ensureAnimationInfo().mReenterTransition = object;
    }

    @Deprecated
    public void setRetainInstance(boolean bl) {
        FragmentStrictMode.onSetRetainInstanceUsage(this);
        this.mRetainInstance = bl;
        if (this.mFragmentManager != null) {
            if (bl) {
                this.mFragmentManager.addRetainedFragment(this);
            } else {
                this.mFragmentManager.removeRetainedFragment(this);
            }
        } else {
            this.mRetainInstanceChangedWhileDetached = true;
        }
    }

    public void setReturnTransition(Object object) {
        this.ensureAnimationInfo().mReturnTransition = object;
    }

    public void setSharedElementEnterTransition(Object object) {
        this.ensureAnimationInfo().mSharedElementEnterTransition = object;
    }

    void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.ensureAnimationInfo();
        this.mAnimationInfo.mSharedElementSourceNames = arrayList;
        this.mAnimationInfo.mSharedElementTargetNames = arrayList2;
    }

    public void setSharedElementReturnTransition(Object object) {
        this.ensureAnimationInfo().mSharedElementReturnTransition = object;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int n) {
        if (fragment != null) {
            FragmentStrictMode.onSetTargetFragmentUsage(this, fragment, n);
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        Object object = fragment != null ? fragment.mFragmentManager : null;
        if (fragmentManager != null && object != null && fragmentManager != object) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        object = fragment;
        while (object != null) {
            if (!((Fragment)object).equals(this)) {
                object = super.getTargetFragment(false);
                continue;
            }
            throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager != null && fragment.mFragmentManager != null) {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        } else {
            this.mTargetWho = null;
            this.mTarget = fragment;
        }
        this.mTargetRequestCode = n;
    }

    @Deprecated
    public void setUserVisibleHint(boolean bl) {
        FragmentStrictMode.onSetUserVisibleHint(this, bl);
        if (!this.mUserVisibleHint && bl && this.mState < 5 && this.mFragmentManager != null && this.isAdded() && this.mIsCreated) {
            this.mFragmentManager.performPendingDeferredStart(this.mFragmentManager.createOrGetFragmentStateManager(this));
        }
        this.mUserVisibleHint = bl;
        boolean bl2 = this.mState < 5 && !bl;
        this.mDeferStart = bl2;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = bl;
        }
    }

    public boolean shouldShowRequestPermissionRationale(String string2) {
        if (this.mHost != null) {
            return this.mHost.onShouldShowRequestPermissionRationale(string2);
        }
        return false;
    }

    public void startActivity(Intent intent) {
        this.startActivity(intent, null);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        if (this.mHost != null) {
            this.mHost.onStartActivityFromFragment(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int n) {
        this.startActivityForResult(intent, n, null);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int n, Bundle bundle) {
        if (this.mHost != null) {
            this.getParentFragmentManager().launchStartActivityForResult(this, intent, n, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int n, Intent intent, int n2, int n3, int n4, Bundle bundle) throws IntentSender.SendIntentException {
        if (this.mHost != null) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v((String)"FragmentManager", (String)("Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + n + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle));
            }
            this.getParentFragmentManager().launchStartIntentSenderForResult(this, intentSender, n, intent, n2, n3, n4, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo != null && this.ensureAnimationInfo().mEnterTransitionPostponed) {
            if (this.mHost == null) {
                this.ensureAnimationInfo().mEnterTransitionPostponed = false;
            } else if (Looper.myLooper() != this.mHost.getHandler().getLooper()) {
                this.mHost.getHandler().postAtFrontOfQueue(new Runnable(this){
                    final Fragment this$0;
                    {
                        this.this$0 = fragment;
                    }

                    @Override
                    public void run() {
                        this.this$0.callStartTransitionListener(false);
                    }
                });
            } else {
                this.callStartTransitionListener(true);
            }
            return;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append("{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append("}");
        stringBuilder.append(" (");
        stringBuilder.append(this.mWho);
        if (this.mFragmentId != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            stringBuilder.append(" tag=");
            stringBuilder.append(this.mTag);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    static class AnimationInfo {
        Boolean mAllowEnterTransitionOverlap;
        Boolean mAllowReturnTransitionOverlap;
        View mAnimatingAway;
        int mEnterAnim;
        Object mEnterTransition = null;
        SharedElementCallback mEnterTransitionCallback = null;
        boolean mEnterTransitionPostponed;
        int mExitAnim;
        Object mExitTransition = null;
        SharedElementCallback mExitTransitionCallback = null;
        View mFocusedView = null;
        boolean mIsPop;
        int mNextTransition;
        int mPopEnterAnim;
        int mPopExitAnim;
        float mPostOnViewCreatedAlpha = 1.0f;
        Object mReenterTransition;
        Object mReturnTransition = USE_DEFAULT_TRANSITION;
        Object mSharedElementEnterTransition = null;
        Object mSharedElementReturnTransition;
        ArrayList<String> mSharedElementSourceNames;
        ArrayList<String> mSharedElementTargetNames;

        AnimationInfo() {
            this.mReenterTransition = USE_DEFAULT_TRANSITION;
            this.mSharedElementReturnTransition = USE_DEFAULT_TRANSITION;
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static void cancelPendingInputEvents(View view) {
            view.cancelPendingInputEvents();
        }
    }

    public static class InstantiationException
    extends RuntimeException {
        public InstantiationException(String string2, Exception exception) {
            super(string2, exception);
        }
    }

    private static abstract class OnPreAttachedListener {
        private OnPreAttachedListener() {
        }

        abstract void onPreAttached();
    }

    public static class SavedState
    implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>(){

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] newArray(int n) {
                return new SavedState[n];
            }
        };
        final Bundle mState;

        SavedState(Bundle bundle) {
            this.mState = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.mState = parcel.readBundle();
            if (classLoader != null && this.mState != null) {
                this.mState.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int n) {
            parcel.writeBundle(this.mState);
        }
    }
}

