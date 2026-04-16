/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.os.Looper
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.Log
 *  android.view.LayoutInflater$Factory2
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.R;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.BackStackRecordState;
import androidx.fragment.app.BackStackState;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentLayoutInflaterFactory;
import androidx.fragment.app.FragmentLifecycleCallbacksDispatcher;
import androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0;
import androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1;
import androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda2;
import androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda3;
import androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda4;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.fragment.app.FragmentManagerState;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentResultOwner;
import androidx.fragment.app.FragmentState;
import androidx.fragment.app.FragmentStateManager;
import androidx.fragment.app.FragmentStore;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.LogWriter;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.SpecialEffectsControllerFactory;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class FragmentManager
implements FragmentResultOwner {
    private static boolean DEBUG = false;
    private static final String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    static final String FRAGMENT_MANAGER_STATE_TAG = "state";
    static final String FRAGMENT_NAME_PREFIX = "fragment_";
    static final String FRAGMENT_STATE_TAG = "state";
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    static final String RESULT_NAME_PREFIX = "result_";
    static final String SAVED_STATE_TAG = "android:support:fragments";
    public static final String TAG = "FragmentManager";
    ArrayList<BackStackRecord> mBackStack;
    private ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    private final AtomicInteger mBackStackIndex;
    private final Map<String, BackStackState> mBackStackStates;
    private FragmentContainer mContainer;
    private ArrayList<Fragment> mCreatedMenus;
    int mCurState = -1;
    private SpecialEffectsControllerFactory mDefaultSpecialEffectsControllerFactory;
    private boolean mDestroyed;
    private Runnable mExecCommit;
    private boolean mExecutingActions;
    private FragmentFactory mFragmentFactory = null;
    private final FragmentStore mFragmentStore;
    private boolean mHavePendingDeferredStart;
    private FragmentHostCallback<?> mHost;
    private FragmentFactory mHostFragmentFactory;
    ArrayDeque<LaunchedFragmentInfo> mLaunchedFragments;
    private final FragmentLayoutInflaterFactory mLayoutInflaterFactory;
    private final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher;
    private final MenuProvider mMenuProvider;
    private boolean mNeedMenuInvalidate;
    private FragmentManagerViewModel mNonConfig;
    private final CopyOnWriteArrayList<FragmentOnAttachListener> mOnAttachListeners;
    private final OnBackPressedCallback mOnBackPressedCallback;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final Consumer<Configuration> mOnConfigurationChangedListener;
    private final Consumer<MultiWindowModeChangedInfo> mOnMultiWindowModeChangedListener;
    private final Consumer<PictureInPictureModeChangedInfo> mOnPictureInPictureModeChangedListener;
    private final Consumer<Integer> mOnTrimMemoryListener;
    private Fragment mParent;
    private final ArrayList<OpGenerator> mPendingActions = new ArrayList();
    Fragment mPrimaryNav;
    private ActivityResultLauncher<String[]> mRequestPermissions;
    private final Map<String, LifecycleAwareResultListener> mResultListeners;
    private final Map<String, Bundle> mResults;
    private SpecialEffectsControllerFactory mSpecialEffectsControllerFactory = null;
    private ActivityResultLauncher<Intent> mStartActivityForResult;
    private ActivityResultLauncher<IntentSenderRequest> mStartIntentSenderForResult;
    private boolean mStateSaved;
    private boolean mStopped;
    private FragmentStrictMode.Policy mStrictModePolicy;
    private ArrayList<Fragment> mTmpAddedFragments;
    private ArrayList<Boolean> mTmpIsPop;
    private ArrayList<BackStackRecord> mTmpRecords;

    static {
        DEBUG = false;
    }

    public FragmentManager() {
        this.mFragmentStore = new FragmentStore();
        this.mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
        this.mOnBackPressedCallback = new OnBackPressedCallback(this, false){
            final FragmentManager this$0;
            {
                this.this$0 = fragmentManager;
                super(bl);
            }

            @Override
            public void handleOnBackPressed() {
                this.this$0.handleOnBackPressed();
            }
        };
        this.mBackStackIndex = new AtomicInteger();
        this.mBackStackStates = Collections.synchronizedMap(new HashMap());
        this.mResults = Collections.synchronizedMap(new HashMap());
        this.mResultListeners = Collections.synchronizedMap(new HashMap());
        this.mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
        this.mOnAttachListeners = new CopyOnWriteArrayList();
        this.mOnConfigurationChangedListener = new FragmentManager$$ExternalSyntheticLambda0(this);
        this.mOnTrimMemoryListener = new FragmentManager$$ExternalSyntheticLambda1(this);
        this.mOnMultiWindowModeChangedListener = new FragmentManager$$ExternalSyntheticLambda2(this);
        this.mOnPictureInPictureModeChangedListener = new FragmentManager$$ExternalSyntheticLambda3(this);
        this.mMenuProvider = new MenuProvider(this){
            final FragmentManager this$0;
            {
                this.this$0 = fragmentManager;
            }

            @Override
            public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
                this.this$0.dispatchCreateOptionsMenu(menu, menuInflater);
            }

            @Override
            public void onMenuClosed(Menu menu) {
                this.this$0.dispatchOptionsMenuClosed(menu);
            }

            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                return this.this$0.dispatchOptionsItemSelected(menuItem);
            }

            @Override
            public void onPrepareMenu(Menu menu) {
                this.this$0.dispatchPrepareOptionsMenu(menu);
            }
        };
        this.mHostFragmentFactory = new FragmentFactory(this){
            final FragmentManager this$0;
            {
                this.this$0 = fragmentManager;
            }

            @Override
            public Fragment instantiate(ClassLoader classLoader, String string2) {
                return this.this$0.getHost().instantiate(this.this$0.getHost().getContext(), string2, null);
            }
        };
        this.mDefaultSpecialEffectsControllerFactory = new SpecialEffectsControllerFactory(this){
            final FragmentManager this$0;
            {
                this.this$0 = fragmentManager;
            }

            @Override
            public SpecialEffectsController createController(ViewGroup viewGroup) {
                return new DefaultSpecialEffectsController(viewGroup);
            }
        };
        this.mLaunchedFragments = new ArrayDeque();
        this.mExecCommit = new Runnable(this){
            final FragmentManager this$0;
            {
                this.this$0 = fragmentManager;
            }

            @Override
            public void run() {
                this.this$0.execPendingActions(true);
            }
        };
    }

    private void checkStateLoss() {
        if (!this.isStateSaved()) {
            return;
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    private void clearBackStackStateViewModels() {
        boolean bl = this.mHost instanceof ViewModelStoreOwner ? this.mFragmentStore.getNonConfig().isCleared() : (this.mHost.getContext() instanceof Activity ? ((Activity)this.mHost.getContext()).isChangingConfigurations() ^ true : true);
        if (bl) {
            Iterator<BackStackState> iterator2 = this.mBackStackStates.values().iterator();
            while (iterator2.hasNext()) {
                for (String string2 : iterator2.next().mFragments) {
                    this.mFragmentStore.getNonConfig().clearNonConfigState(string2);
                }
            }
        }
    }

    private Set<SpecialEffectsController> collectAllSpecialEffectsController() {
        HashSet<SpecialEffectsController> hashSet = new HashSet<SpecialEffectsController>();
        Iterator<FragmentStateManager> iterator2 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while (iterator2.hasNext()) {
            ViewGroup viewGroup = iterator2.next().getFragment().mContainer;
            if (viewGroup == null) continue;
            hashSet.add(SpecialEffectsController.getOrCreateController(viewGroup, this.getSpecialEffectsControllerFactory()));
        }
        return hashSet;
    }

    private Set<SpecialEffectsController> collectChangedControllers(ArrayList<BackStackRecord> arrayList, int n, int n2) {
        HashSet<SpecialEffectsController> hashSet = new HashSet<SpecialEffectsController>();
        while (n < n2) {
            Iterator iterator2 = arrayList.get((int)n).mOps.iterator();
            while (iterator2.hasNext()) {
                Fragment fragment = ((FragmentTransaction.Op)iterator2.next()).mFragment;
                if (fragment == null || (fragment = fragment.mContainer) == null) continue;
                hashSet.add(SpecialEffectsController.getOrCreateController((ViewGroup)fragment, this));
            }
            ++n;
        }
        return hashSet;
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(Fragment fragment) {
        if (fragment != null && fragment.equals(this.findActiveFragment(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    private void dispatchStateChange(int n) {
        this.mExecutingActions = true;
        this.mFragmentStore.dispatchStateChange(n);
        this.moveToState(n, false);
        Iterator<SpecialEffectsController> iterator2 = this.collectAllSpecialEffectsController().iterator();
        while (iterator2.hasNext()) {
            iterator2.next().forceCompleteAllOperations();
        }
        this.execPendingActions(true);
        return;
        finally {
            this.mExecutingActions = false;
        }
    }

    private void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            this.startPendingDeferredFragments();
        }
    }

    @Deprecated
    public static void enableDebugLogging(boolean bl) {
        DEBUG = bl;
    }

    private void endAnimatingAwayFragments() {
        Iterator<SpecialEffectsController> iterator2 = this.collectAllSpecialEffectsController().iterator();
        while (iterator2.hasNext()) {
            iterator2.next().forceCompleteAllOperations();
        }
    }

    private void ensureExecReady(boolean bl) {
        if (!this.mExecutingActions) {
            if (this.mHost == null) {
                if (this.mDestroyed) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            if (Looper.myLooper() == this.mHost.getHandler().getLooper()) {
                if (!bl) {
                    this.checkStateLoss();
                }
                if (this.mTmpRecords == null) {
                    this.mTmpRecords = new ArrayList();
                    this.mTmpIsPop = new ArrayList();
                }
                return;
            }
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    private static void executeOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int n, int n2) {
        while (n < n2) {
            BackStackRecord backStackRecord = arrayList.get(n);
            if (arrayList2.get(n).booleanValue()) {
                backStackRecord.bumpBackStackNesting(-1);
                backStackRecord.executePopOps();
            } else {
                backStackRecord.bumpBackStackNesting(1);
                backStackRecord.executeOps();
            }
            ++n;
        }
    }

    private void executeOpsTogether(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int n, int n2) {
        int n3;
        boolean bl = arrayList.get((int)n).mReorderingAllowed;
        int n4 = 0;
        if (this.mTmpAddedFragments == null) {
            this.mTmpAddedFragments = new ArrayList();
        } else {
            this.mTmpAddedFragments.clear();
        }
        this.mTmpAddedFragments.addAll(this.mFragmentStore.getFragments());
        Object object2 = this.getPrimaryNavigationFragment();
        int n5 = n;
        while (true) {
            int n6 = 1;
            if (n5 >= n2) break;
            BackStackRecord object3 = arrayList.get(n5);
            object2 = arrayList2.get(n5) == false ? object3.expandOps(this.mTmpAddedFragments, (Fragment)object2) : object3.trackAddedFragmentsInPop(this.mTmpAddedFragments, (Fragment)object2);
            n3 = n6;
            if (n4 == 0) {
                n3 = object3.mAddToBackStack ? n6 : 0;
            }
            ++n5;
            n4 = n3;
        }
        this.mTmpAddedFragments.clear();
        if (!bl && this.mCurState >= 1) {
            for (n3 = n; n3 < n2; ++n3) {
                object2 = arrayList.get((int)n3).mOps.iterator();
                while (object2.hasNext()) {
                    Fragment fragment = ((FragmentTransaction.Op)object2.next()).mFragment;
                    if (fragment == null || fragment.mFragmentManager == null) continue;
                    FragmentStateManager fragmentStateManager = this.createOrGetFragmentStateManager(fragment);
                    this.mFragmentStore.makeActive(fragmentStateManager);
                }
            }
        }
        FragmentManager.executeOps(arrayList, arrayList2, n, n2);
        bl = arrayList2.get(n2 - 1);
        for (n3 = n; n3 < n2; ++n3) {
            BackStackRecord backStackRecord = arrayList.get(n3);
            if (bl) {
                for (n5 = backStackRecord.mOps.size() - 1; n5 >= 0; --n5) {
                    object2 = ((FragmentTransaction.Op)backStackRecord.mOps.get((int)n5)).mFragment;
                    if (object2 == null) continue;
                    this.createOrGetFragmentStateManager((Fragment)object2).moveToExpectedState();
                }
                continue;
            }
            object2 = backStackRecord.mOps.iterator();
            while (object2.hasNext()) {
                Fragment fragment = ((FragmentTransaction.Op)object2.next()).mFragment;
                if (fragment == null) continue;
                this.createOrGetFragmentStateManager(fragment).moveToExpectedState();
            }
        }
        this.moveToState(this.mCurState, true);
        for (SpecialEffectsController specialEffectsController : this.collectChangedControllers(arrayList, n, n2)) {
            specialEffectsController.updateOperationDirection(bl);
            specialEffectsController.markPostponedState();
            specialEffectsController.executePendingOperations();
        }
        while (n < n2) {
            object2 = arrayList.get(n);
            if (arrayList2.get(n).booleanValue() && ((BackStackRecord)object2).mIndex >= 0) {
                ((BackStackRecord)object2).mIndex = -1;
            }
            ((BackStackRecord)object2).runOnCommitRunnables();
            ++n;
        }
        if (n4 != 0) {
            this.reportBackStackChanged();
        }
    }

    private int findBackStackIndex(String string2, int n, boolean bl) {
        if (this.mBackStack != null && !this.mBackStack.isEmpty()) {
            int n2;
            block9: {
                BackStackRecord backStackRecord;
                int n3;
                if (string2 == null && n < 0) {
                    if (bl) {
                        return 0;
                    }
                    return this.mBackStack.size() - 1;
                }
                for (n3 = this.mBackStack.size() - 1; n3 >= 0; --n3) {
                    backStackRecord = this.mBackStack.get(n3);
                    if (string2 != null && string2.equals(backStackRecord.getName()) || n >= 0 && n == backStackRecord.mIndex) break;
                }
                if (n3 < 0) {
                    return n3;
                }
                if (bl) {
                    while (true) {
                        n2 = --n3;
                        if (n3 <= 0) break block9;
                        backStackRecord = this.mBackStack.get(n3 - 1);
                        if (string2 != null && string2.equals(backStackRecord.getName())) continue;
                        n2 = n3;
                        if (n < 0) break block9;
                        n2 = n3;
                        if (n != backStackRecord.mIndex) break block9;
                    }
                }
                if (n3 == this.mBackStack.size() - 1) {
                    return -1;
                }
                n2 = n3 + 1;
            }
            return n2;
        }
        return -1;
    }

    public static <F extends Fragment> F findFragment(View view) {
        Fragment fragment = FragmentManager.findViewFragment(view);
        if (fragment != null) {
            return (F)fragment;
        }
        throw new IllegalStateException("View " + view + " does not have a Fragment set");
    }

    static FragmentManager findFragmentManager(View object) {
        block8: {
            block7: {
                FragmentActivity fragmentActivity;
                Fragment fragment;
                block5: {
                    block6: {
                        fragment = FragmentManager.findViewFragment(object);
                        if (fragment == null) break block5;
                        if (!fragment.isAdded()) break block6;
                        object = fragment.getChildFragmentManager();
                        break block7;
                    }
                    throw new IllegalStateException("The Fragment " + fragment + " that owns View " + object + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
                }
                fragment = object.getContext();
                FragmentActivity fragmentActivity2 = null;
                while (true) {
                    fragmentActivity = fragmentActivity2;
                    if (!(fragment instanceof ContextWrapper)) break;
                    if (fragment instanceof FragmentActivity) {
                        fragmentActivity = (FragmentActivity)((Object)fragment);
                        break;
                    }
                    fragment = ((ContextWrapper)fragment).getBaseContext();
                }
                if (fragmentActivity == null) break block8;
                object = fragmentActivity.getSupportFragmentManager();
            }
            return object;
        }
        throw new IllegalStateException("View " + object + " is not within a subclass of FragmentActivity.");
    }

    private static Fragment findViewFragment(View view) {
        while (true) {
            Object var1_1 = null;
            if (view == null) break;
            Fragment fragment = FragmentManager.getViewFragment(view);
            if (fragment != null) {
                return fragment;
            }
            fragment = view.getParent();
            view = var1_1;
            if (!(fragment instanceof View)) continue;
            view = (View)fragment;
        }
        return null;
    }

    private void forcePostponedTransactions() {
        Iterator<SpecialEffectsController> iterator2 = this.collectAllSpecialEffectsController().iterator();
        while (iterator2.hasNext()) {
            iterator2.next().forcePostponedExecutePendingOperations();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean generateOpsForPendingActions(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        boolean bl = false;
        ArrayList<OpGenerator> arrayList3 = this.mPendingActions;
        synchronized (arrayList3) {
            if (this.mPendingActions.isEmpty()) {
                return false;
            }
            try {
                boolean bl2;
                int n = this.mPendingActions.size();
                for (int i = 0; i < n; bl |= bl2, ++i) {
                    bl2 = this.mPendingActions.get(i).generateOps(arrayList, arrayList2);
                }
                this.mPendingActions.clear();
            }
            catch (Throwable throwable) {
                this.mPendingActions.clear();
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                throw throwable;
            }
            this.mHost.getHandler().removeCallbacks(this.mExecCommit);
            return bl;
        }
    }

    private FragmentManagerViewModel getChildNonConfig(Fragment fragment) {
        return this.mNonConfig.getChildNonConfig(fragment);
    }

    private ViewGroup getFragmentContainer(Fragment fragment) {
        if (fragment.mContainer != null) {
            return fragment.mContainer;
        }
        if (fragment.mContainerId <= 0) {
            return null;
        }
        if (this.mContainer.onHasView() && (fragment = this.mContainer.onFindViewById(fragment.mContainerId)) instanceof ViewGroup) {
            return (ViewGroup)fragment;
        }
        return null;
    }

    static Fragment getViewFragment(View object) {
        if ((object = object.getTag(R.id.fragment_container_view_tag)) instanceof Fragment) {
            return (Fragment)object;
        }
        return null;
    }

    public static boolean isLoggingEnabled(int n) {
        boolean bl = DEBUG || Log.isLoggable((String)TAG, (int)n);
        return bl;
    }

    private boolean isMenuAvailable(Fragment fragment) {
        boolean bl = fragment.mHasMenu && fragment.mMenuVisible || fragment.mChildFragmentManager.checkForMenus();
        return bl;
    }

    private boolean isParentAdded() {
        Fragment fragment = this.mParent;
        boolean bl = true;
        if (fragment == null) {
            return true;
        }
        if (!this.mParent.isAdded() || !this.mParent.getParentFragmentManager().isParentAdded()) {
            bl = false;
        }
        return bl;
    }

    private boolean popBackStackImmediate(String string2, int n, int n2) {
        this.execPendingActions(false);
        this.ensureExecReady(true);
        if (this.mPrimaryNav != null && n < 0 && string2 == null && this.mPrimaryNav.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean bl = this.popBackStackState(this.mTmpRecords, this.mTmpIsPop, string2, n, n2);
        if (bl) {
            this.mExecutingActions = true;
            try {
                this.removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            }
            finally {
                this.cleanupExec();
            }
        }
        this.updateOnBackPressedCallbackEnabled();
        this.doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return bl;
    }

    private void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() == arrayList2.size()) {
            int n = arrayList.size();
            int n2 = 0;
            int n3 = 0;
            while (n3 < n) {
                int n4 = n2;
                int n5 = n3;
                if (!arrayList.get((int)n3).mReorderingAllowed) {
                    if (n2 != n3) {
                        this.executeOpsTogether(arrayList, arrayList2, n2, n3);
                    }
                    n4 = n5 = n3 + 1;
                    if (arrayList2.get(n3).booleanValue()) {
                        while (true) {
                            n4 = n5;
                            if (n5 >= n) break;
                            n4 = n5;
                            if (!arrayList2.get(n5).booleanValue()) break;
                            n4 = n5;
                            if (arrayList.get((int)n5).mReorderingAllowed) break;
                            ++n5;
                        }
                    }
                    this.executeOpsTogether(arrayList, arrayList2, n3, n4);
                    n3 = n4;
                    n5 = n4 - 1;
                    n4 = n3;
                }
                n3 = n5 + 1;
                n2 = n4;
            }
            if (n2 != n) {
                this.executeOpsTogether(arrayList, arrayList2, n2, n);
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }

    private void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i = 0; i < this.mBackStackChangeListeners.size(); ++i) {
                this.mBackStackChangeListeners.get(i).onBackStackChanged();
            }
        }
    }

    static int reverseTransit(int n) {
        int n2 = 0;
        switch (n) {
            default: {
                n = n2;
                break;
            }
            case 8197: {
                n = 4100;
                break;
            }
            case 8194: {
                n = 4097;
                break;
            }
            case 4100: {
                n = 8197;
                break;
            }
            case 4099: {
                n = 4099;
                break;
            }
            case 4097: {
                n = 8194;
            }
        }
        return n;
    }

    private void setVisibleRemovingFragment(Fragment fragment) {
        ViewGroup viewGroup = this.getFragmentContainer(fragment);
        if (viewGroup != null && fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() > 0) {
            if (viewGroup.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                viewGroup.setTag(R.id.visible_removing_fragment_view_tag, (Object)fragment);
            }
            ((Fragment)viewGroup.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
        }
    }

    private void startPendingDeferredFragments() {
        Iterator<FragmentStateManager> iterator2 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while (iterator2.hasNext()) {
            this.performPendingDeferredStart(iterator2.next());
        }
    }

    private void throwException(RuntimeException runtimeException) {
        Log.e((String)TAG, (String)runtimeException.getMessage());
        Log.e((String)TAG, (String)"Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
        if (this.mHost != null) {
            try {
                this.mHost.onDump("  ", null, printWriter, new String[0]);
            }
            catch (Exception exception) {
                Log.e((String)TAG, (String)"Failed dumping state", (Throwable)exception);
            }
        } else {
            try {
                this.dump("  ", null, printWriter, new String[0]);
            }
            catch (Exception exception) {
                Log.e((String)TAG, (String)"Failed dumping state", (Throwable)exception);
            }
        }
        throw runtimeException;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void updateOnBackPressedCallbackEnabled() {
        ArrayList<OpGenerator> arrayList = this.mPendingActions;
        synchronized (arrayList) {
            boolean bl = this.mPendingActions.isEmpty();
            boolean bl2 = true;
            if (!bl) {
                this.mOnBackPressedCallback.setEnabled(true);
                return;
            }
            OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
            if (this.getBackStackEntryCount() <= 0 || !this.isPrimaryNavigation(this.mParent)) {
                bl2 = false;
            }
            onBackPressedCallback.setEnabled(bl2);
            return;
        }
    }

    void addBackStackState(BackStackRecord backStackRecord) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList();
        }
        this.mBackStack.add(backStackRecord);
    }

    FragmentStateManager addFragment(Fragment fragment) {
        if (fragment.mPreviousWho != null) {
            FragmentStrictMode.onFragmentReuse(fragment, fragment.mPreviousWho);
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)TAG, (String)("add: " + fragment));
        }
        FragmentStateManager fragmentStateManager = this.createOrGetFragmentStateManager(fragment);
        fragment.mFragmentManager = this;
        this.mFragmentStore.makeActive(fragmentStateManager);
        if (!fragment.mDetached) {
            this.mFragmentStore.addFragment(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (this.isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
        return fragmentStateManager;
    }

    public void addFragmentOnAttachListener(FragmentOnAttachListener fragmentOnAttachListener) {
        this.mOnAttachListeners.add(fragmentOnAttachListener);
    }

    public void addOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList();
        }
        this.mBackStackChangeListeners.add(onBackStackChangedListener);
    }

    void addRetainedFragment(Fragment fragment) {
        this.mNonConfig.addRetainedFragment(fragment);
    }

    int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    void attachController(FragmentHostCallback<?> object, FragmentContainer object2, Fragment fragment) {
        if (this.mHost == null) {
            this.mHost = object;
            this.mContainer = object2;
            this.mParent = fragment;
            if (this.mParent != null) {
                this.addFragmentOnAttachListener(new FragmentOnAttachListener(this, fragment){
                    final FragmentManager this$0;
                    final Fragment val$parent;
                    {
                        this.this$0 = fragmentManager;
                        this.val$parent = fragment;
                    }

                    @Override
                    public void onAttachFragment(FragmentManager fragmentManager, Fragment fragment) {
                        this.val$parent.onAttachFragment(fragment);
                    }
                });
            } else if (object instanceof FragmentOnAttachListener) {
                this.addFragmentOnAttachListener((FragmentOnAttachListener)object);
            }
            if (this.mParent != null) {
                this.updateOnBackPressedCallbackEnabled();
            }
            if (object instanceof OnBackPressedDispatcherOwner) {
                object2 = (OnBackPressedDispatcherOwner)object;
                this.mOnBackPressedDispatcher = object2.getOnBackPressedDispatcher();
                if (fragment != null) {
                    object2 = fragment;
                }
                this.mOnBackPressedDispatcher.addCallback((LifecycleOwner)object2, this.mOnBackPressedCallback);
            }
            this.mNonConfig = fragment != null ? fragment.mFragmentManager.getChildNonConfig(fragment) : (object instanceof ViewModelStoreOwner ? FragmentManagerViewModel.getInstance(((ViewModelStoreOwner)object).getViewModelStore()) : new FragmentManagerViewModel(false));
            this.mNonConfig.setIsStateSaved(this.isStateSaved());
            this.mFragmentStore.setNonConfig(this.mNonConfig);
            if (this.mHost instanceof SavedStateRegistryOwner && fragment == null) {
                object = ((SavedStateRegistryOwner)((Object)this.mHost)).getSavedStateRegistry();
                ((SavedStateRegistry)object).registerSavedStateProvider(SAVED_STATE_TAG, new FragmentManager$$ExternalSyntheticLambda4(this));
                object = ((SavedStateRegistry)object).consumeRestoredStateForKey(SAVED_STATE_TAG);
                if (object != null) {
                    this.restoreSaveStateInternal((Parcelable)object);
                }
            }
            if (this.mHost instanceof ActivityResultRegistryOwner) {
                object2 = ((ActivityResultRegistryOwner)((Object)this.mHost)).getActivityResultRegistry();
                object = fragment != null ? fragment.mWho + ":" : "";
                object = "FragmentManager:" + (String)object;
                this.mStartActivityForResult = ((ActivityResultRegistry)object2).register((String)object + "StartActivityForResult", new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>(this){
                    final FragmentManager this$0;
                    {
                        this.this$0 = fragmentManager;
                    }

                    @Override
                    public void onActivityResult(ActivityResult activityResult) {
                        Object object = this.this$0.mLaunchedFragments.pollFirst();
                        if (object == null) {
                            Log.w((String)FragmentManager.TAG, (String)("No Activities were started for result for " + this));
                            return;
                        }
                        String string2 = ((LaunchedFragmentInfo)object).mWho;
                        int n = ((LaunchedFragmentInfo)object).mRequestCode;
                        object = this.this$0.mFragmentStore.findFragmentByWho(string2);
                        if (object == null) {
                            Log.w((String)FragmentManager.TAG, (String)("Activity result delivered for unknown Fragment " + string2));
                            return;
                        }
                        ((Fragment)object).onActivityResult(n, activityResult.getResultCode(), activityResult.getData());
                    }
                });
                this.mStartIntentSenderForResult = ((ActivityResultRegistry)object2).register((String)object + "StartIntentSenderForResult", new FragmentIntentSenderContract(), new ActivityResultCallback<ActivityResult>(this){
                    final FragmentManager this$0;
                    {
                        this.this$0 = fragmentManager;
                    }

                    @Override
                    public void onActivityResult(ActivityResult activityResult) {
                        Object object = this.this$0.mLaunchedFragments.pollFirst();
                        if (object == null) {
                            Log.w((String)FragmentManager.TAG, (String)("No IntentSenders were started for " + this));
                            return;
                        }
                        String string2 = ((LaunchedFragmentInfo)object).mWho;
                        int n = ((LaunchedFragmentInfo)object).mRequestCode;
                        object = this.this$0.mFragmentStore.findFragmentByWho(string2);
                        if (object == null) {
                            Log.w((String)FragmentManager.TAG, (String)("Intent Sender result delivered for unknown Fragment " + string2));
                            return;
                        }
                        ((Fragment)object).onActivityResult(n, activityResult.getResultCode(), activityResult.getData());
                    }
                });
                this.mRequestPermissions = ((ActivityResultRegistry)object2).register((String)object + "RequestPermissions", new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>(this){
                    final FragmentManager this$0;
                    {
                        this.this$0 = fragmentManager;
                    }

                    @Override
                    public void onActivityResult(Map<String, Boolean> object) {
                        int n;
                        String[] stringArray = object.keySet().toArray(new String[0]);
                        Object object2 = new ArrayList<Boolean>(object.values());
                        object = new int[((ArrayList)object2).size()];
                        for (n = 0; n < ((ArrayList)object2).size(); ++n) {
                            int n2 = ((ArrayList)object2).get(n) != false ? 0 : -1;
                            object[n] = n2;
                        }
                        Object object3 = this.this$0.mLaunchedFragments.pollFirst();
                        if (object3 == null) {
                            Log.w((String)FragmentManager.TAG, (String)("No permissions were requested for " + this));
                            return;
                        }
                        object2 = ((LaunchedFragmentInfo)object3).mWho;
                        n = ((LaunchedFragmentInfo)object3).mRequestCode;
                        object3 = this.this$0.mFragmentStore.findFragmentByWho((String)object2);
                        if (object3 == null) {
                            Log.w((String)FragmentManager.TAG, (String)("Permission request result delivered for unknown Fragment " + (String)object2));
                            return;
                        }
                        ((Fragment)object3).onRequestPermissionsResult(n, stringArray, (int[])object);
                    }
                });
            }
            if (this.mHost instanceof OnConfigurationChangedProvider) {
                ((OnConfigurationChangedProvider)((Object)this.mHost)).addOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
            }
            if (this.mHost instanceof OnTrimMemoryProvider) {
                ((OnTrimMemoryProvider)((Object)this.mHost)).addOnTrimMemoryListener(this.mOnTrimMemoryListener);
            }
            if (this.mHost instanceof OnMultiWindowModeChangedProvider) {
                ((OnMultiWindowModeChangedProvider)((Object)this.mHost)).addOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
            }
            if (this.mHost instanceof OnPictureInPictureModeChangedProvider) {
                ((OnPictureInPictureModeChangedProvider)((Object)this.mHost)).addOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
            }
            if (this.mHost instanceof MenuHost && fragment == null) {
                ((MenuHost)((Object)this.mHost)).addMenuProvider(this.mMenuProvider);
            }
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    void attachFragment(Fragment fragment) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)TAG, (String)("attach: " + fragment));
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.mFragmentStore.addFragment(fragment);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v((String)TAG, (String)("add from attach: " + fragment));
                }
                if (this.isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
            }
        }
    }

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    boolean checkForMenus() {
        boolean bl = false;
        for (Fragment fragment : this.mFragmentStore.getActiveFragments()) {
            if (fragment != null) {
                bl = this.isMenuAvailable(fragment);
            }
            if (!bl) continue;
            return true;
        }
        return false;
    }

    public void clearBackStack(String string2) {
        this.enqueueAction(new ClearBackStackState(this, string2), false);
    }

    boolean clearBackStackState(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String string2) {
        if (!this.restoreBackStackState(arrayList, arrayList2, string2)) {
            return false;
        }
        return this.popBackStackState(arrayList, arrayList2, string2, -1, 1);
    }

    @Override
    public final void clearFragmentResult(String string2) {
        this.mResults.remove(string2);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)TAG, (String)("Clearing fragment result with key " + string2));
        }
    }

    @Override
    public final void clearFragmentResultListener(String string2) {
        LifecycleAwareResultListener lifecycleAwareResultListener = this.mResultListeners.remove(string2);
        if (lifecycleAwareResultListener != null) {
            lifecycleAwareResultListener.removeObserver();
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)TAG, (String)("Clearing FragmentResultListener for key " + string2));
        }
    }

    FragmentStateManager createOrGetFragmentStateManager(Fragment object) {
        FragmentStateManager fragmentStateManager = this.mFragmentStore.getFragmentStateManager(((Fragment)object).mWho);
        if (fragmentStateManager != null) {
            return fragmentStateManager;
        }
        object = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, (Fragment)object);
        ((FragmentStateManager)object).restoreState(this.mHost.getContext().getClassLoader());
        ((FragmentStateManager)object).setFragmentManagerState(this.mCurState);
        return object;
    }

    void detachFragment(Fragment fragment) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)TAG, (String)("detach: " + fragment));
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v((String)TAG, (String)("remove from detach: " + fragment));
                }
                this.mFragmentStore.removeFragment(fragment);
                if (this.isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
                this.setVisibleRemovingFragment(fragment);
            }
        }
    }

    void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(4);
    }

    void dispatchAttach() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(0);
    }

    void dispatchConfigurationChanged(Configuration configuration2, boolean bl) {
        if (bl && this.mHost instanceof OnConfigurationChangedProvider) {
            this.throwException(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment == null) continue;
            fragment.performConfigurationChanged(configuration2);
            if (!bl) continue;
            fragment.mChildFragmentManager.dispatchConfigurationChanged(configuration2, true);
        }
    }

    boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment == null || !fragment.performContextItemSelected(menuItem)) continue;
            return true;
        }
        return false;
    }

    void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(1);
    }

    boolean dispatchCreateOptionsMenu(Menu object, MenuInflater menuInflater) {
        if (this.mCurState < 1) {
            return false;
        }
        boolean bl = false;
        ArrayList<Fragment> arrayList = null;
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            boolean bl2 = bl;
            ArrayList<Fragment> arrayList2 = arrayList;
            if (fragment != null) {
                bl2 = bl;
                arrayList2 = arrayList;
                if (this.isParentMenuVisible(fragment)) {
                    bl2 = bl;
                    arrayList2 = arrayList;
                    if (fragment.performCreateOptionsMenu((Menu)object, menuInflater)) {
                        bl2 = true;
                        arrayList2 = arrayList;
                        if (arrayList == null) {
                            arrayList2 = new ArrayList<Fragment>();
                        }
                        arrayList2.add(fragment);
                    }
                }
            }
            bl = bl2;
            arrayList = arrayList2;
        }
        if (this.mCreatedMenus != null) {
            for (int i = 0; i < this.mCreatedMenus.size(); ++i) {
                object = this.mCreatedMenus.get(i);
                if (arrayList != null && arrayList.contains(object)) continue;
                ((Fragment)object).onDestroyOptionsMenu();
            }
        }
        this.mCreatedMenus = arrayList;
        return bl;
    }

    void dispatchDestroy() {
        this.mDestroyed = true;
        this.execPendingActions(true);
        this.endAnimatingAwayFragments();
        this.clearBackStackStateViewModels();
        this.dispatchStateChange(-1);
        if (this.mHost instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider)((Object)this.mHost)).removeOnTrimMemoryListener(this.mOnTrimMemoryListener);
        }
        if (this.mHost instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider)((Object)this.mHost)).removeOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
        }
        if (this.mHost instanceof OnMultiWindowModeChangedProvider) {
            ((OnMultiWindowModeChangedProvider)((Object)this.mHost)).removeOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
        }
        if (this.mHost instanceof OnPictureInPictureModeChangedProvider) {
            ((OnPictureInPictureModeChangedProvider)((Object)this.mHost)).removeOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
        }
        if (this.mHost instanceof MenuHost && this.mParent == null) {
            ((MenuHost)((Object)this.mHost)).removeMenuProvider(this.mMenuProvider);
        }
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher != null) {
            this.mOnBackPressedCallback.remove();
            this.mOnBackPressedDispatcher = null;
        }
        if (this.mStartActivityForResult != null) {
            this.mStartActivityForResult.unregister();
            this.mStartIntentSenderForResult.unregister();
            this.mRequestPermissions.unregister();
        }
    }

    void dispatchDestroyView() {
        this.dispatchStateChange(1);
    }

    void dispatchLowMemory(boolean bl) {
        if (bl && this.mHost instanceof OnTrimMemoryProvider) {
            this.throwException(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment == null) continue;
            fragment.performLowMemory();
            if (!bl) continue;
            fragment.mChildFragmentManager.dispatchLowMemory(true);
        }
    }

    void dispatchMultiWindowModeChanged(boolean bl, boolean bl2) {
        if (bl2 && this.mHost instanceof OnMultiWindowModeChangedProvider) {
            this.throwException(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment == null) continue;
            fragment.performMultiWindowModeChanged(bl);
            if (!bl2) continue;
            fragment.mChildFragmentManager.dispatchMultiWindowModeChanged(bl, true);
        }
    }

    void dispatchOnAttachFragment(Fragment fragment) {
        Iterator<FragmentOnAttachListener> iterator2 = this.mOnAttachListeners.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().onAttachFragment(this, fragment);
        }
    }

    void dispatchOnHiddenChanged() {
        for (Fragment fragment : this.mFragmentStore.getActiveFragments()) {
            if (fragment == null) continue;
            fragment.onHiddenChanged(fragment.isHidden());
            fragment.mChildFragmentManager.dispatchOnHiddenChanged();
        }
    }

    boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment == null || !fragment.performOptionsItemSelected(menuItem)) continue;
            return true;
        }
        return false;
    }

    void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mCurState < 1) {
            return;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment == null) continue;
            fragment.performOptionsMenuClosed(menu);
        }
    }

    void dispatchPause() {
        this.dispatchStateChange(5);
    }

    void dispatchPictureInPictureModeChanged(boolean bl, boolean bl2) {
        if (bl2 && this.mHost instanceof OnPictureInPictureModeChangedProvider) {
            this.throwException(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment == null) continue;
            fragment.performPictureInPictureModeChanged(bl);
            if (!bl2) continue;
            fragment.mChildFragmentManager.dispatchPictureInPictureModeChanged(bl, true);
        }
    }

    boolean dispatchPrepareOptionsMenu(Menu menu) {
        if (this.mCurState < 1) {
            return false;
        }
        boolean bl = false;
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            boolean bl2 = bl;
            if (fragment != null) {
                bl2 = bl;
                if (this.isParentMenuVisible(fragment)) {
                    bl2 = bl;
                    if (fragment.performPrepareOptionsMenu(menu)) {
                        bl2 = true;
                    }
                }
            }
            bl = bl2;
        }
        return bl;
    }

    void dispatchPrimaryNavigationFragmentChanged() {
        this.updateOnBackPressedCallbackEnabled();
        this.dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(7);
    }

    void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(5);
    }

    void dispatchStop() {
        this.mStopped = true;
        this.mNonConfig.setIsStateSaved(true);
        this.dispatchStateChange(4);
    }

    void dispatchViewCreated() {
        this.dispatchStateChange(2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void dump(String string2, FileDescriptor object, PrintWriter printWriter, String[] object2) {
        int n;
        int n2;
        String string3 = string2 + "    ";
        this.mFragmentStore.dump(string2, (FileDescriptor)object, printWriter, (String[])object2);
        if (this.mCreatedMenus != null && (n2 = this.mCreatedMenus.size()) > 0) {
            printWriter.print(string2);
            printWriter.println("Fragments Created Menus:");
            for (n = 0; n < n2; ++n) {
                object = this.mCreatedMenus.get(n);
                printWriter.print(string2);
                printWriter.print("  #");
                printWriter.print(n);
                printWriter.print(": ");
                printWriter.println(((Fragment)object).toString());
            }
        }
        if (this.mBackStack != null && (n2 = this.mBackStack.size()) > 0) {
            printWriter.print(string2);
            printWriter.println("Back Stack:");
            for (n = 0; n < n2; ++n) {
                object = this.mBackStack.get(n);
                printWriter.print(string2);
                printWriter.print("  #");
                printWriter.print(n);
                printWriter.print(": ");
                printWriter.println(((BackStackRecord)object).toString());
                ((BackStackRecord)object).dump(string3, printWriter);
            }
        }
        printWriter.print(string2);
        printWriter.println("Back Stack Index: " + this.mBackStackIndex.get());
        object = this.mPendingActions;
        synchronized (object) {
            n2 = this.mPendingActions.size();
            if (n2 > 0) {
                printWriter.print(string2);
                printWriter.println("Pending Actions:");
                for (n = 0; n < n2; ++n) {
                    object2 = this.mPendingActions.get(n);
                    printWriter.print(string2);
                    printWriter.print("  #");
                    printWriter.print(n);
                    printWriter.print(": ");
                    printWriter.println(object2);
                }
            }
        }
        printWriter.print(string2);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(string2);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(string2);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(string2);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(string2);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(string2);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void enqueueAction(OpGenerator object, boolean bl) {
        if (!bl) {
            if (this.mHost == null) {
                if (this.mDestroyed) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            this.checkStateLoss();
        }
        ArrayList<OpGenerator> arrayList = this.mPendingActions;
        synchronized (arrayList) {
            if (this.mHost != null) {
                this.mPendingActions.add((OpGenerator)object);
                this.scheduleCommit();
                return;
            }
            if (bl) {
                return;
            }
            object = new IllegalStateException("Activity has been destroyed");
            throw object;
        }
    }

    boolean execPendingActions(boolean bl) {
        this.ensureExecReady(bl);
        bl = false;
        while (this.generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                this.removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                bl = true;
            }
            finally {
                this.cleanupExec();
            }
        }
        this.updateOnBackPressedCallbackEnabled();
        this.doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return bl;
    }

    void execSingleAction(OpGenerator opGenerator, boolean bl) {
        if (bl && (this.mHost == null || this.mDestroyed)) {
            return;
        }
        this.ensureExecReady(bl);
        if (opGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                this.removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            }
            finally {
                this.cleanupExec();
            }
        }
        this.updateOnBackPressedCallbackEnabled();
        this.doPendingDeferredStart();
        this.mFragmentStore.burpActive();
    }

    public boolean executePendingTransactions() {
        boolean bl = this.execPendingActions(true);
        this.forcePostponedTransactions();
        return bl;
    }

    Fragment findActiveFragment(String string2) {
        return this.mFragmentStore.findActiveFragment(string2);
    }

    public Fragment findFragmentById(int n) {
        return this.mFragmentStore.findFragmentById(n);
    }

    public Fragment findFragmentByTag(String string2) {
        return this.mFragmentStore.findFragmentByTag(string2);
    }

    Fragment findFragmentByWho(String string2) {
        return this.mFragmentStore.findFragmentByWho(string2);
    }

    int getActiveFragmentCount() {
        return this.mFragmentStore.getActiveFragmentCount();
    }

    List<Fragment> getActiveFragments() {
        return this.mFragmentStore.getActiveFragments();
    }

    public BackStackEntry getBackStackEntryAt(int n) {
        return this.mBackStack.get(n);
    }

    public int getBackStackEntryCount() {
        int n = this.mBackStack != null ? this.mBackStack.size() : 0;
        return n;
    }

    FragmentContainer getContainer() {
        return this.mContainer;
    }

    public Fragment getFragment(Bundle object, String string2) {
        String string3 = object.getString(string2);
        if (string3 == null) {
            return null;
        }
        object = this.findActiveFragment(string3);
        if (object == null) {
            this.throwException(new IllegalStateException("Fragment no longer exists for key " + string2 + ": unique id " + string3));
        }
        return object;
    }

    public FragmentFactory getFragmentFactory() {
        if (this.mFragmentFactory != null) {
            return this.mFragmentFactory;
        }
        if (this.mParent != null) {
            return this.mParent.mFragmentManager.getFragmentFactory();
        }
        return this.mHostFragmentFactory;
    }

    FragmentStore getFragmentStore() {
        return this.mFragmentStore;
    }

    public List<Fragment> getFragments() {
        return this.mFragmentStore.getFragments();
    }

    public FragmentHostCallback<?> getHost() {
        return this.mHost;
    }

    LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }

    FragmentLifecycleCallbacksDispatcher getLifecycleCallbacksDispatcher() {
        return this.mLifecycleCallbacksDispatcher;
    }

    Fragment getParent() {
        return this.mParent;
    }

    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    SpecialEffectsControllerFactory getSpecialEffectsControllerFactory() {
        if (this.mSpecialEffectsControllerFactory != null) {
            return this.mSpecialEffectsControllerFactory;
        }
        if (this.mParent != null) {
            return this.mParent.mFragmentManager.getSpecialEffectsControllerFactory();
        }
        return this.mDefaultSpecialEffectsControllerFactory;
    }

    public FragmentStrictMode.Policy getStrictModePolicy() {
        return this.mStrictModePolicy;
    }

    ViewModelStore getViewModelStore(Fragment fragment) {
        return this.mNonConfig.getViewModelStore(fragment);
    }

    void handleOnBackPressed() {
        this.execPendingActions(true);
        if (this.mOnBackPressedCallback.isEnabled()) {
            this.popBackStackImmediate();
        } else {
            this.mOnBackPressedDispatcher.onBackPressed();
        }
    }

    void hideFragment(Fragment fragment) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)TAG, (String)("hide: " + fragment));
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            this.setVisibleRemovingFragment(fragment);
        }
    }

    void invalidateMenuForFragment(Fragment fragment) {
        if (fragment.mAdded && this.isMenuAvailable(fragment)) {
            this.mNeedMenuInvalidate = true;
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    boolean isParentHidden(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    boolean isParentMenuVisible(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    boolean isPrimaryNavigation(Fragment fragment) {
        boolean bl = true;
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (!fragment.equals(fragmentManager.getPrimaryNavigationFragment()) || !this.isPrimaryNavigation(fragmentManager.mParent)) {
            bl = false;
        }
        return bl;
    }

    boolean isStateAtLeast(int n) {
        boolean bl = this.mCurState >= n;
        return bl;
    }

    public boolean isStateSaved() {
        boolean bl = this.mStateSaved || this.mStopped;
        return bl;
    }

    /* synthetic */ Bundle lambda$attachController$4$androidx-fragment-app-FragmentManager() {
        return this.saveAllStateInternal();
    }

    /* synthetic */ void lambda$new$0$androidx-fragment-app-FragmentManager(Configuration configuration2) {
        if (this.isParentAdded()) {
            this.dispatchConfigurationChanged(configuration2, false);
        }
    }

    /* synthetic */ void lambda$new$1$androidx-fragment-app-FragmentManager(Integer n) {
        if (this.isParentAdded() && n == 80) {
            this.dispatchLowMemory(false);
        }
    }

    /* synthetic */ void lambda$new$2$androidx-fragment-app-FragmentManager(MultiWindowModeChangedInfo multiWindowModeChangedInfo) {
        if (this.isParentAdded()) {
            this.dispatchMultiWindowModeChanged(multiWindowModeChangedInfo.isInMultiWindowMode(), false);
        }
    }

    /* synthetic */ void lambda$new$3$androidx-fragment-app-FragmentManager(PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo) {
        if (this.isParentAdded()) {
            this.dispatchPictureInPictureModeChanged(pictureInPictureModeChangedInfo.isInPictureInPictureMode(), false);
        }
    }

    void launchRequestPermissions(Fragment object, String[] stringArray, int n) {
        if (this.mRequestPermissions != null) {
            object = new LaunchedFragmentInfo(((Fragment)object).mWho, n);
            this.mLaunchedFragments.addLast((LaunchedFragmentInfo)object);
            this.mRequestPermissions.launch(stringArray);
        } else {
            this.mHost.onRequestPermissionsFromFragment((Fragment)object, stringArray, n);
        }
    }

    void launchStartActivityForResult(Fragment object, Intent intent, int n, Bundle bundle) {
        if (this.mStartActivityForResult != null) {
            object = new LaunchedFragmentInfo(((Fragment)object).mWho, n);
            this.mLaunchedFragments.addLast((LaunchedFragmentInfo)object);
            if (intent != null && bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.mStartActivityForResult.launch(intent);
        } else {
            this.mHost.onStartActivityFromFragment((Fragment)object, intent, n, bundle);
        }
    }

    void launchStartIntentSenderForResult(Fragment fragment, IntentSender object, int n, Intent object2, int n2, int n3, int n4, Bundle bundle) throws IntentSender.SendIntentException {
        if (this.mStartIntentSenderForResult != null) {
            if (bundle != null) {
                if (object2 == null) {
                    object2 = new Intent();
                    object2.putExtra(EXTRA_CREATED_FILLIN_INTENT, true);
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v((String)TAG, (String)("ActivityOptions " + bundle + " were added to fillInIntent " + object2 + " for fragment " + fragment));
                }
                object2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            object2 = new IntentSenderRequest.Builder((IntentSender)object).setFillInIntent((Intent)object2).setFlags(n3, n2).build();
            object = new LaunchedFragmentInfo(fragment.mWho, n);
            this.mLaunchedFragments.addLast((LaunchedFragmentInfo)object);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v((String)TAG, (String)("Fragment " + fragment + "is launching an IntentSender for result "));
            }
            this.mStartIntentSenderForResult.launch((IntentSenderRequest)object2);
        } else {
            this.mHost.onStartIntentSenderFromFragment(fragment, (IntentSender)object, n, (Intent)object2, n2, n3, n4, bundle);
        }
    }

    void moveToState(int n, boolean bl) {
        if (this.mHost == null && n != -1) {
            throw new IllegalStateException("No activity");
        }
        if (!bl && n == this.mCurState) {
            return;
        }
        this.mCurState = n;
        this.mFragmentStore.moveToExpectedState();
        this.startPendingDeferredFragments();
        if (this.mNeedMenuInvalidate && this.mHost != null && this.mCurState == 7) {
            this.mHost.onSupportInvalidateOptionsMenu();
            this.mNeedMenuInvalidate = false;
        }
    }

    void noteStateNotSaved() {
        if (this.mHost == null) {
            return;
        }
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment == null) continue;
            fragment.noteStateNotSaved();
        }
    }

    void onContainerAvailable(FragmentContainerView fragmentContainerView) {
        for (FragmentStateManager fragmentStateManager : this.mFragmentStore.getActiveFragmentStateManagers()) {
            Fragment fragment = fragmentStateManager.getFragment();
            if (fragment.mContainerId != fragmentContainerView.getId() || fragment.mView == null || fragment.mView.getParent() != null) continue;
            fragment.mContainer = fragmentContainerView;
            fragmentStateManager.addViewToContainer();
        }
    }

    @Deprecated
    public FragmentTransaction openTransaction() {
        return this.beginTransaction();
    }

    void performPendingDeferredStart(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.getFragment();
        if (fragment.mDeferStart) {
            if (this.mExecutingActions) {
                this.mHavePendingDeferredStart = true;
                return;
            }
            fragment.mDeferStart = false;
            fragmentStateManager.moveToExpectedState();
        }
    }

    public void popBackStack() {
        this.enqueueAction(new PopBackStackState(this, null, -1, 0), false);
    }

    public void popBackStack(int n, int n2) {
        this.popBackStack(n, n2, false);
    }

    void popBackStack(int n, int n2, boolean bl) {
        if (n >= 0) {
            this.enqueueAction(new PopBackStackState(this, null, n, n2), bl);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + n);
    }

    public void popBackStack(String string2, int n) {
        this.enqueueAction(new PopBackStackState(this, string2, -1, n), false);
    }

    public boolean popBackStackImmediate() {
        return this.popBackStackImmediate(null, -1, 0);
    }

    public boolean popBackStackImmediate(int n, int n2) {
        if (n >= 0) {
            return this.popBackStackImmediate(null, n, n2);
        }
        throw new IllegalArgumentException("Bad id: " + n);
    }

    public boolean popBackStackImmediate(String string2, int n) {
        return this.popBackStackImmediate(string2, -1, n);
    }

    boolean popBackStackState(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String string2, int n, int n2) {
        boolean bl = (n2 & 1) != 0;
        if ((n2 = this.findBackStackIndex(string2, n, bl)) < 0) {
            return false;
        }
        for (n = this.mBackStack.size() - 1; n >= n2; --n) {
            arrayList.add(this.mBackStack.remove(n));
            arrayList2.add(true);
        }
        return true;
    }

    public void putFragment(Bundle bundle, String string2, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            this.throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(string2, fragment.mWho);
    }

    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean bl) {
        this.mLifecycleCallbacksDispatcher.registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks, bl);
    }

    void removeFragment(Fragment fragment) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)TAG, (String)("remove: " + fragment + " nesting=" + fragment.mBackStackNesting));
        }
        boolean bl = fragment.isInBackStack();
        if (!fragment.mDetached || bl ^ true) {
            this.mFragmentStore.removeFragment(fragment);
            if (this.isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mRemoving = true;
            this.setVisibleRemovingFragment(fragment);
        }
    }

    public void removeFragmentOnAttachListener(FragmentOnAttachListener fragmentOnAttachListener) {
        this.mOnAttachListeners.remove(fragmentOnAttachListener);
    }

    public void removeOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners != null) {
            this.mBackStackChangeListeners.remove(onBackStackChangedListener);
        }
    }

    void removeRetainedFragment(Fragment fragment) {
        this.mNonConfig.removeRetainedFragment(fragment);
    }

    void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (this.mHost instanceof ViewModelStoreOwner) {
            this.throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }
        this.mNonConfig.restoreFromSnapshot(fragmentManagerNonConfig);
        this.restoreSaveStateInternal(parcelable);
    }

    public void restoreBackStack(String string2) {
        this.enqueueAction(new RestoreBackStackState(this, string2), false);
    }

    boolean restoreBackStackState(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String object) {
        BackStackState backStackState = this.mBackStackStates.remove(object);
        if (backStackState == null) {
            return false;
        }
        object = new HashMap<String, Fragment>();
        for (BackStackRecord backStackRecord : arrayList) {
            if (!backStackRecord.mBeingSaved) continue;
            for (FragmentTransaction.Op op : backStackRecord.mOps) {
                if (op.mFragment == null) continue;
                ((HashMap)((Object)object)).put(op.mFragment.mWho, op.mFragment);
            }
        }
        object = backStackState.instantiate(this, (Map<String, Fragment>)((Object)object));
        boolean bl = false;
        object = object.iterator();
        while (object.hasNext()) {
            if (!((BackStackRecord)object.next()).generateOps(arrayList, arrayList2) && !bl) {
                bl = false;
                continue;
            }
            bl = true;
        }
        return bl;
    }

    void restoreSaveState(Parcelable parcelable) {
        if (this.mHost instanceof SavedStateRegistryOwner) {
            this.throwException(new IllegalStateException("You cannot use restoreSaveState when your FragmentHostCallback implements SavedStateRegistryOwner."));
        }
        this.restoreSaveStateInternal(parcelable);
    }

    /*
     * WARNING - void declaration
     */
    void restoreSaveStateInternal(Parcelable object5) {
        ArrayList<String> arrayList;
        int n;
        Object object;
        Object object22;
        if (object5 == null) {
            return;
        }
        Bundle bundle = (Bundle)object5;
        for (Object object22 : bundle.keySet()) {
            if (!((String)object22).startsWith(RESULT_NAME_PREFIX) || (object = bundle.getBundle((String)object22)) == null) continue;
            object.setClassLoader(this.mHost.getContext().getClassLoader());
            object22 = ((String)object22).substring(RESULT_NAME_PREFIX.length());
            this.mResults.put((String)object22, (Bundle)object);
        }
        object = new ArrayList();
        for (Object object22 : bundle.keySet()) {
            if (!((String)object22).startsWith(FRAGMENT_NAME_PREFIX) || (object22 = bundle.getBundle((String)object22)) == null) continue;
            object22.setClassLoader(this.mHost.getContext().getClassLoader());
            ((ArrayList)object).add((FragmentState)object22.getParcelable("state"));
        }
        this.mFragmentStore.restoreSaveState((ArrayList<FragmentState>)object);
        object = (FragmentManagerState)bundle.getParcelable("state");
        if (object == null) {
            return;
        }
        this.mFragmentStore.resetActiveFragments();
        for (String string2 : ((FragmentManagerState)object).mActive) {
            void var1_8;
            FragmentState fragmentState = this.mFragmentStore.setSavedState(string2, null);
            if (fragmentState == null) continue;
            object22 = this.mNonConfig.findRetainedFragmentByWho(fragmentState.mWho);
            if (object22 != null) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v((String)TAG, (String)("restoreSaveState: re-attaching retained " + object22));
                }
                FragmentStateManager fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, (Fragment)object22, fragmentState);
            } else {
                FragmentStateManager fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.getContext().getClassLoader(), this.getFragmentFactory(), fragmentState);
            }
            object22 = var1_8.getFragment();
            ((Fragment)object22).mFragmentManager = this;
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v((String)TAG, (String)("restoreSaveState: active (" + ((Fragment)object22).mWho + "): " + object22));
            }
            var1_8.restoreState(this.mHost.getContext().getClassLoader());
            this.mFragmentStore.makeActive((FragmentStateManager)var1_8);
            var1_8.setFragmentManagerState(this.mCurState);
        }
        for (Object object3 : this.mNonConfig.getRetainedFragments()) {
            if (this.mFragmentStore.containsActiveFragment(((Fragment)object3).mWho)) continue;
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v((String)TAG, (String)("Discarding retained Fragment " + object3 + " that was not found in the set of active Fragments " + ((FragmentManagerState)object).mActive));
            }
            this.mNonConfig.removeRetainedFragment((Fragment)object3);
            ((Fragment)object3).mFragmentManager = this;
            object22 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, (Fragment)object3);
            ((FragmentStateManager)object22).setFragmentManagerState(1);
            ((FragmentStateManager)object22).moveToExpectedState();
            ((Fragment)object3).mRemoving = true;
            ((FragmentStateManager)object22).moveToExpectedState();
        }
        this.mFragmentStore.restoreAddedFragments(((FragmentManagerState)object).mAdded);
        if (((FragmentManagerState)object).mBackStack != null) {
            this.mBackStack = new ArrayList(((FragmentManagerState)object).mBackStack.length);
            for (n = 0; n < ((FragmentManagerState)object).mBackStack.length; ++n) {
                Object object3;
                object3 = ((FragmentManagerState)object).mBackStack[n].instantiate(this);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v((String)TAG, (String)("restoreAllState: back stack #" + n + " (index " + ((BackStackRecord)object3).mIndex + "): " + object3));
                    PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
                    ((BackStackRecord)object3).dump("  ", printWriter, false);
                    printWriter.close();
                }
                this.mBackStack.add((BackStackRecord)object3);
            }
        } else {
            this.mBackStack = null;
        }
        this.mBackStackIndex.set(((FragmentManagerState)object).mBackStackIndex);
        if (((FragmentManagerState)object).mPrimaryNavActiveWho != null) {
            this.mPrimaryNav = this.findActiveFragment(((FragmentManagerState)object).mPrimaryNavActiveWho);
            this.dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
        }
        if ((arrayList = ((FragmentManagerState)object).mBackStackStateKeys) != null) {
            for (n = 0; n < arrayList.size(); ++n) {
                this.mBackStackStates.put(arrayList.get(n), ((FragmentManagerState)object).mBackStackStates.get(n));
            }
        }
        this.mLaunchedFragments = new ArrayDeque<LaunchedFragmentInfo>(((FragmentManagerState)object).mLaunchedFragments);
    }

    @Deprecated
    FragmentManagerNonConfig retainNonConfig() {
        if (this.mHost instanceof ViewModelStoreOwner) {
            this.throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        }
        return this.mNonConfig.getSnapshot();
    }

    Parcelable saveAllState() {
        Bundle bundle;
        block1: {
            if (this.mHost instanceof SavedStateRegistryOwner) {
                this.throwException(new IllegalStateException("You cannot use saveAllState when your FragmentHostCallback implements SavedStateRegistryOwner."));
            }
            if (!(bundle = this.saveAllStateInternal()).isEmpty()) break block1;
            bundle = null;
        }
        return bundle;
    }

    Bundle saveAllStateInternal() {
        Bundle bundle = new Bundle();
        this.forcePostponedTransactions();
        this.endAnimatingAwayFragments();
        this.execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.setIsStateSaved(true);
        ArrayList<String> arrayList = this.mFragmentStore.saveActiveFragments();
        Object object = this.mFragmentStore.getAllSavedState();
        if (((ArrayList)object).isEmpty()) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v((String)TAG, (String)"saveAllState: no fragments!");
            }
        } else {
            ArrayList<String> arrayList2 = this.mFragmentStore.saveAddedFragments();
            BackStackRecordState[] bundle22 = null;
            Object object2 = bundle22;
            if (this.mBackStack != null) {
                int n = this.mBackStack.size();
                object2 = bundle22;
                if (n > 0) {
                    BackStackRecordState[] backStackRecordStateArray = new BackStackRecordState[n];
                    int n2 = 0;
                    while (true) {
                        object2 = backStackRecordStateArray;
                        if (n2 >= n) break;
                        backStackRecordStateArray[n2] = new BackStackRecordState(this.mBackStack.get(n2));
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v((String)TAG, (String)("saveAllState: adding back stack #" + n2 + ": " + this.mBackStack.get(n2)));
                        }
                        ++n2;
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.mActive = arrayList;
            fragmentManagerState.mAdded = arrayList2;
            fragmentManagerState.mBackStack = object2;
            fragmentManagerState.mBackStackIndex = this.mBackStackIndex.get();
            if (this.mPrimaryNav != null) {
                fragmentManagerState.mPrimaryNavActiveWho = this.mPrimaryNav.mWho;
            }
            fragmentManagerState.mBackStackStateKeys.addAll(this.mBackStackStates.keySet());
            fragmentManagerState.mBackStackStates.addAll(this.mBackStackStates.values());
            fragmentManagerState.mLaunchedFragments = new ArrayList<LaunchedFragmentInfo>(this.mLaunchedFragments);
            bundle.putParcelable("state", (Parcelable)fragmentManagerState);
            for (String string2 : this.mResults.keySet()) {
                bundle.putBundle(RESULT_NAME_PREFIX + string2, this.mResults.get(string2));
            }
            object2 = ((ArrayList)object).iterator();
            while (object2.hasNext()) {
                object = (FragmentState)object2.next();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", (Parcelable)object);
                bundle.putBundle(FRAGMENT_NAME_PREFIX + ((FragmentState)object).mWho, bundle2);
            }
        }
        return bundle;
    }

    public void saveBackStack(String string2) {
        this.enqueueAction(new SaveBackStackState(this, string2), false);
    }

    boolean saveBackStackState(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String string2) {
        Serializable serializable;
        Object object2;
        Object object3;
        int n;
        int n2 = this.findBackStackIndex(string2, -1, true);
        if (n2 < 0) {
            return false;
        }
        for (n = n2; n < this.mBackStack.size(); ++n) {
            object3 = this.mBackStack.get(n);
            if (((BackStackRecord)object3).mReorderingAllowed) continue;
            this.throwException(new IllegalArgumentException("saveBackStack(\"" + string2 + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + object3 + " that did not use setReorderingAllowed(true)."));
        }
        Object object4 = new HashSet<Fragment>();
        for (n = n2; n < this.mBackStack.size(); ++n) {
            object2 = this.mBackStack.get(n);
            object3 = new HashSet();
            serializable = new HashSet();
            for (FragmentTransaction.Op op : ((BackStackRecord)object2).mOps) {
                Fragment fragment = op.mFragment;
                if (fragment == null) continue;
                if (!op.mFromExpandedOp || op.mCmd == 1 || op.mCmd == 2 || op.mCmd == 8) {
                    ((HashSet)object4).add(fragment);
                    ((HashSet)object3).add(fragment);
                }
                if (op.mCmd != 1 && op.mCmd != 2) continue;
                ((HashSet)serializable).add(fragment);
            }
            ((AbstractSet)object3).removeAll((Collection<?>)((Object)serializable));
            if (((HashSet)object3).isEmpty()) continue;
            StringBuilder stringBuilder = new StringBuilder().append("saveBackStack(\"").append(string2).append("\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
            object3 = ((HashSet)object3).size() == 1 ? " " + ((HashSet)object3).iterator().next() : "s " + object3;
            this.throwException(new IllegalArgumentException(stringBuilder.append((String)object3).append(" in ").append(object2).append(" that were previously added to the FragmentManager through a separate FragmentTransaction.").toString()));
        }
        object2 = new ArrayDeque(object4);
        while (!((ArrayDeque)object2).isEmpty()) {
            Fragment fragment = (Fragment)((ArrayDeque)object2).removeFirst();
            if (fragment.mRetainInstance) {
                serializable = new StringBuilder().append("saveBackStack(\"").append(string2).append("\") must not contain retained fragments. Found ");
                object3 = ((HashSet)object4).contains(fragment) ? "direct reference to retained " : "retained child ";
                this.throwException(new IllegalArgumentException(((StringBuilder)serializable).append((String)object3).append("fragment ").append(fragment).toString()));
            }
            for (Fragment fragment2 : fragment.mChildFragmentManager.getActiveFragments()) {
                if (fragment2 == null) continue;
                ((ArrayDeque)object2).addLast((Fragment)fragment2);
            }
        }
        object2 = new ArrayList<String>();
        object3 = ((HashSet)object4).iterator();
        while (object3.hasNext()) {
            ((ArrayList)object2).add(((Fragment)object3.next()).mWho);
        }
        object3 = new ArrayList(this.mBackStack.size() - n2);
        for (n = n2; n < this.mBackStack.size(); ++n) {
            ((ArrayList)object3).add(null);
        }
        BackStackState backStackState = new BackStackState((List<String>)object2, (List<BackStackRecordState>)object3);
        for (n = this.mBackStack.size() - 1; n >= n2; --n) {
            object2 = this.mBackStack.remove(n);
            object4 = new BackStackRecord((BackStackRecord)object2);
            ((BackStackRecord)object4).collapseOps();
            ((ArrayList)object3).set(n - n2, new BackStackRecordState((BackStackRecord)object4));
            ((BackStackRecord)object2).mBeingSaved = true;
            arrayList.add((BackStackRecord)object2);
            arrayList2.add(true);
        }
        this.mBackStackStates.put(string2, backStackState);
        return true;
    }

    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        FragmentStateManager fragmentStateManager = this.mFragmentStore.getFragmentStateManager(fragment.mWho);
        if (fragmentStateManager == null || !fragmentStateManager.getFragment().equals(fragment)) {
            this.throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return fragmentStateManager.saveInstanceState();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void scheduleCommit() {
        ArrayList<OpGenerator> arrayList = this.mPendingActions;
        synchronized (arrayList) {
            int n = this.mPendingActions.size();
            boolean bl = true;
            if (n != 1) return;
            if (!bl) return;
            this.mHost.getHandler().removeCallbacks(this.mExecCommit);
            this.mHost.getHandler().post(this.mExecCommit);
            this.updateOnBackPressedCallbackEnabled();
            return;
        }
    }

    void setExitAnimationOrder(Fragment fragment, boolean bl) {
        if ((fragment = this.getFragmentContainer(fragment)) != null && fragment instanceof FragmentContainerView) {
            ((FragmentContainerView)((Object)fragment)).setDrawDisappearingViewsLast(bl ^ true);
        }
    }

    public void setFragmentFactory(FragmentFactory fragmentFactory) {
        this.mFragmentFactory = fragmentFactory;
    }

    @Override
    public final void setFragmentResult(String string2, Bundle bundle) {
        LifecycleAwareResultListener lifecycleAwareResultListener = this.mResultListeners.get(string2);
        if (lifecycleAwareResultListener != null && lifecycleAwareResultListener.isAtLeast(Lifecycle.State.STARTED)) {
            lifecycleAwareResultListener.onFragmentResult(string2, bundle);
        } else {
            this.mResults.put(string2, bundle);
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)TAG, (String)("Setting fragment result with key " + string2 + " and result " + bundle));
        }
    }

    @Override
    public final void setFragmentResultListener(String string2, LifecycleOwner object, FragmentResultListener fragmentResultListener) {
        if (((Lifecycle)(object = object.getLifecycle())).getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver(this, string2, fragmentResultListener, (Lifecycle)object){
            final FragmentManager this$0;
            final Lifecycle val$lifecycle;
            final FragmentResultListener val$listener;
            final String val$requestKey;
            {
                this.this$0 = fragmentManager;
                this.val$requestKey = string2;
                this.val$listener = fragmentResultListener;
                this.val$lifecycle = lifecycle;
            }

            @Override
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_START && (lifecycleOwner = (Bundle)this.this$0.mResults.get(this.val$requestKey)) != null) {
                    this.val$listener.onFragmentResult(this.val$requestKey, (Bundle)lifecycleOwner);
                    this.this$0.clearFragmentResult(this.val$requestKey);
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    this.val$lifecycle.removeObserver(this);
                    this.this$0.mResultListeners.remove(this.val$requestKey);
                }
            }
        };
        LifecycleAwareResultListener lifecycleAwareResultListener = this.mResultListeners.put(string2, new LifecycleAwareResultListener((Lifecycle)object, fragmentResultListener, lifecycleEventObserver));
        if (lifecycleAwareResultListener != null) {
            lifecycleAwareResultListener.removeObserver();
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)TAG, (String)("Setting FragmentResultListener with key " + string2 + " lifecycleOwner " + object + " and listener " + fragmentResultListener));
        }
        ((Lifecycle)object).addObserver(lifecycleEventObserver);
    }

    void setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(this.findActiveFragment(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment != null && (!fragment.equals(this.findActiveFragment(fragment.mWho)) || fragment.mHost != null && fragment.mFragmentManager != this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        Fragment fragment2 = this.mPrimaryNav;
        this.mPrimaryNav = fragment;
        this.dispatchParentPrimaryNavigationFragmentChanged(fragment2);
        this.dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    void setSpecialEffectsControllerFactory(SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        this.mSpecialEffectsControllerFactory = specialEffectsControllerFactory;
    }

    public void setStrictModePolicy(FragmentStrictMode.Policy policy) {
        this.mStrictModePolicy = policy;
    }

    void showFragment(Fragment fragment) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)TAG, (String)("show: " + fragment));
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged ^= true;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.mParent != null) {
            stringBuilder.append(this.mParent.getClass().getSimpleName());
            stringBuilder.append("{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this.mParent)));
            stringBuilder.append("}");
        } else if (this.mHost != null) {
            stringBuilder.append(this.mHost.getClass().getSimpleName());
            stringBuilder.append("{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this.mHost)));
            stringBuilder.append("}");
        } else {
            stringBuilder.append("null");
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.mLifecycleCallbacksDispatcher.unregisterFragmentLifecycleCallbacks(fragmentLifecycleCallbacks);
    }

    public static interface BackStackEntry {
        @Deprecated
        public CharSequence getBreadCrumbShortTitle();

        @Deprecated
        public int getBreadCrumbShortTitleRes();

        @Deprecated
        public CharSequence getBreadCrumbTitle();

        @Deprecated
        public int getBreadCrumbTitleRes();

        public int getId();

        public String getName();
    }

    private class ClearBackStackState
    implements OpGenerator {
        private final String mName;
        final FragmentManager this$0;

        ClearBackStackState(FragmentManager fragmentManager, String string2) {
            this.this$0 = fragmentManager;
            this.mName = string2;
        }

        @Override
        public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            return this.this$0.clearBackStackState(arrayList, arrayList2, this.mName);
        }
    }

    static class FragmentIntentSenderContract
    extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        FragmentIntentSenderContract() {
        }

        @Override
        public Intent createIntent(Context object, IntentSenderRequest intentSenderRequest) {
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intent2 = intentSenderRequest.getFillInIntent();
            object = intentSenderRequest;
            if (intent2 != null) {
                Bundle bundle = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                object = intentSenderRequest;
                if (bundle != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
                    intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    object = intentSenderRequest;
                    if (intent2.getBooleanExtra(FragmentManager.EXTRA_CREATED_FILLIN_INTENT, false)) {
                        object = new IntentSenderRequest.Builder(intentSenderRequest.getIntentSender()).setFillInIntent(null).setFlags(intentSenderRequest.getFlagsValues(), intentSenderRequest.getFlagsMask()).build();
                    }
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", (Parcelable)object);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v((String)FragmentManager.TAG, (String)("CreateIntent created the following intent: " + intent));
            }
            return intent;
        }

        @Override
        public ActivityResult parseResult(int n, Intent intent) {
            return new ActivityResult(n, intent);
        }
    }

    public static abstract class FragmentLifecycleCallbacks {
        @Deprecated
        public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }

        public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }
    }

    static class LaunchedFragmentInfo
    implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new Parcelable.Creator<LaunchedFragmentInfo>(){

            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            public LaunchedFragmentInfo[] newArray(int n) {
                return new LaunchedFragmentInfo[n];
            }
        };
        int mRequestCode;
        String mWho;

        LaunchedFragmentInfo(Parcel parcel) {
            this.mWho = parcel.readString();
            this.mRequestCode = parcel.readInt();
        }

        LaunchedFragmentInfo(String string2, int n) {
            this.mWho = string2;
            this.mRequestCode = n;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int n) {
            parcel.writeString(this.mWho);
            parcel.writeInt(this.mRequestCode);
        }
    }

    private static class LifecycleAwareResultListener
    implements FragmentResultListener {
        private final Lifecycle mLifecycle;
        private final FragmentResultListener mListener;
        private final LifecycleEventObserver mObserver;

        LifecycleAwareResultListener(Lifecycle lifecycle, FragmentResultListener fragmentResultListener, LifecycleEventObserver lifecycleEventObserver) {
            this.mLifecycle = lifecycle;
            this.mListener = fragmentResultListener;
            this.mObserver = lifecycleEventObserver;
        }

        public boolean isAtLeast(Lifecycle.State state) {
            return this.mLifecycle.getCurrentState().isAtLeast(state);
        }

        @Override
        public void onFragmentResult(String string2, Bundle bundle) {
            this.mListener.onFragmentResult(string2, bundle);
        }

        public void removeObserver() {
            this.mLifecycle.removeObserver(this.mObserver);
        }
    }

    public static interface OnBackStackChangedListener {
        public void onBackStackChanged();
    }

    static interface OpGenerator {
        public boolean generateOps(ArrayList<BackStackRecord> var1, ArrayList<Boolean> var2);
    }

    private class PopBackStackState
    implements OpGenerator {
        final int mFlags;
        final int mId;
        final String mName;
        final FragmentManager this$0;

        PopBackStackState(FragmentManager fragmentManager, String string2, int n, int n2) {
            this.this$0 = fragmentManager;
            this.mName = string2;
            this.mId = n;
            this.mFlags = n2;
        }

        @Override
        public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            if (this.this$0.mPrimaryNav != null && this.mId < 0 && this.mName == null && this.this$0.mPrimaryNav.getChildFragmentManager().popBackStackImmediate()) {
                return false;
            }
            return this.this$0.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
        }
    }

    private class RestoreBackStackState
    implements OpGenerator {
        private final String mName;
        final FragmentManager this$0;

        RestoreBackStackState(FragmentManager fragmentManager, String string2) {
            this.this$0 = fragmentManager;
            this.mName = string2;
        }

        @Override
        public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            return this.this$0.restoreBackStackState(arrayList, arrayList2, this.mName);
        }
    }

    private class SaveBackStackState
    implements OpGenerator {
        private final String mName;
        final FragmentManager this$0;

        SaveBackStackState(FragmentManager fragmentManager, String string2) {
            this.this$0 = fragmentManager;
            this.mName = string2;
        }

        @Override
        public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            return this.this$0.saveBackStackState(arrayList, arrayList2, this.mName);
        }
    }
}

