/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.res.Resources$NotFoundException
 *  android.os.Bundle
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentLifecycleCallbacksDispatcher;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentState;
import androidx.fragment.app.FragmentStore;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.ViewModelStoreOwner;

class FragmentStateManager {
    private static final String TAG = "FragmentManager";
    private static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    private static final String TARGET_STATE_TAG = "android:target_state";
    private static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    private static final String VIEW_REGISTRY_STATE_TAG = "android:view_registry_state";
    private static final String VIEW_STATE_TAG = "android:view_state";
    private final FragmentLifecycleCallbacksDispatcher mDispatcher;
    private final Fragment mFragment;
    private int mFragmentManagerState = -1;
    private final FragmentStore mFragmentStore;
    private boolean mMovingToState = false;

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
    }

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher object, FragmentStore object2, Fragment fragment, FragmentState fragmentState) {
        this.mDispatcher = object;
        this.mFragmentStore = object2;
        this.mFragment = fragment;
        this.mFragment.mSavedViewState = null;
        this.mFragment.mSavedViewRegistryState = null;
        this.mFragment.mBackStackNesting = 0;
        this.mFragment.mInLayout = false;
        this.mFragment.mAdded = false;
        object2 = this.mFragment;
        object = this.mFragment.mTarget != null ? this.mFragment.mTarget.mWho : null;
        ((Fragment)object2).mTargetWho = object;
        this.mFragment.mTarget = null;
        this.mFragment.mSavedFragmentState = fragmentState.mSavedFragmentState != null ? fragmentState.mSavedFragmentState : new Bundle();
    }

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, ClassLoader classLoader, FragmentFactory fragmentFactory, FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragmentState.instantiate(fragmentFactory, classLoader);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)TAG, (String)("Instantiated fragment " + this.mFragment));
        }
    }

    private boolean isFragmentViewChild(View view) {
        if (view == this.mFragment.mView) {
            return true;
        }
        for (view = view.getParent(); view != null; view = view.getParent()) {
            if (view != this.mFragment.mView) continue;
            return true;
        }
        return false;
    }

    private Bundle saveBasicState() {
        Bundle bundle = new Bundle();
        this.mFragment.performSaveInstanceState(bundle);
        this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, bundle, false);
        Bundle bundle2 = bundle;
        if (bundle.isEmpty()) {
            bundle2 = null;
        }
        if (this.mFragment.mView != null) {
            this.saveViewState();
        }
        bundle = bundle2;
        if (this.mFragment.mSavedViewState != null) {
            bundle = bundle2;
            if (bundle2 == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(VIEW_STATE_TAG, this.mFragment.mSavedViewState);
        }
        bundle2 = bundle;
        if (this.mFragment.mSavedViewRegistryState != null) {
            bundle2 = bundle;
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            bundle2.putBundle(VIEW_REGISTRY_STATE_TAG, this.mFragment.mSavedViewRegistryState);
        }
        bundle = bundle2;
        if (!this.mFragment.mUserVisibleHint) {
            bundle = bundle2;
            if (bundle2 == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(USER_VISIBLE_HINT_TAG, this.mFragment.mUserVisibleHint);
        }
        return bundle;
    }

    void activityCreated() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d((String)TAG, (String)("moveto ACTIVITY_CREATED: " + this.mFragment));
        }
        this.mFragment.performActivityCreated(this.mFragment.mSavedFragmentState);
        this.mDispatcher.dispatchOnFragmentActivityCreated(this.mFragment, this.mFragment.mSavedFragmentState, false);
    }

    void addViewToContainer() {
        int n = this.mFragmentStore.findFragmentIndexInContainer(this.mFragment);
        this.mFragment.mContainer.addView(this.mFragment.mView, n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    void attach() {
        FragmentStateManager fragmentStateManager;
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d((String)TAG, (String)("moveto ATTACHED: " + this.mFragment));
        }
        if (this.mFragment.mTarget != null) {
            fragmentStateManager = this.mFragmentStore.getFragmentStateManager(this.mFragment.mTarget.mWho);
            if (fragmentStateManager == null) throw new IllegalStateException("Fragment " + this.mFragment + " declared target fragment " + this.mFragment.mTarget + " that does not belong to this FragmentManager!");
            this.mFragment.mTargetWho = this.mFragment.mTarget.mWho;
            this.mFragment.mTarget = null;
        } else if (this.mFragment.mTargetWho != null) {
            fragmentStateManager = this.mFragmentStore.getFragmentStateManager(this.mFragment.mTargetWho);
            if (fragmentStateManager == null) {
                throw new IllegalStateException("Fragment " + this.mFragment + " declared target fragment " + this.mFragment.mTargetWho + " that does not belong to this FragmentManager!");
            }
        } else {
            fragmentStateManager = null;
        }
        if (fragmentStateManager != null) {
            fragmentStateManager.moveToExpectedState();
        }
        this.mFragment.mHost = this.mFragment.mFragmentManager.getHost();
        this.mFragment.mParentFragment = this.mFragment.mFragmentManager.getParent();
        this.mDispatcher.dispatchOnFragmentPreAttached(this.mFragment, false);
        this.mFragment.performAttach();
        this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, false);
    }

    int computeExpectedState() {
        if (this.mFragment.mFragmentManager == null) {
            return this.mFragment.mState;
        }
        int n = this.mFragmentManagerState;
        switch (2.$SwitchMap$androidx$lifecycle$Lifecycle$State[this.mFragment.mMaxState.ordinal()]) {
            default: {
                n = Math.min(n, -1);
                break;
            }
            case 4: {
                n = Math.min(n, 0);
                break;
            }
            case 3: {
                n = Math.min(n, 1);
                break;
            }
            case 2: {
                n = Math.min(n, 5);
            }
            case 1: 
        }
        int n2 = n;
        if (this.mFragment.mFromLayout) {
            if (this.mFragment.mInLayout) {
                n2 = n = Math.max(this.mFragmentManagerState, 2);
                if (this.mFragment.mView != null) {
                    n2 = n;
                    if (this.mFragment.mView.getParent() == null) {
                        n2 = Math.min(n, 2);
                    }
                }
            } else {
                n2 = this.mFragmentManagerState < 4 ? Math.min(n, this.mFragment.mState) : Math.min(n, 1);
            }
        }
        n = n2;
        if (!this.mFragment.mAdded) {
            n = Math.min(n2, 1);
        }
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact = null;
        if (this.mFragment.mContainer != null) {
            lifecycleImpact = SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager()).getAwaitingCompletionLifecycleImpact(this);
        }
        if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            n2 = Math.min(n, 6);
        } else if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            n2 = Math.max(n, 3);
        } else {
            n2 = n;
            if (this.mFragment.mRemoving) {
                n2 = this.mFragment.isInBackStack() ? Math.min(n, 1) : Math.min(n, -1);
            }
        }
        n = n2;
        if (this.mFragment.mDeferStart) {
            n = n2;
            if (this.mFragment.mState < 5) {
                n = Math.min(n2, 4);
            }
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)TAG, (String)("computeExpectedState() of " + n + " for " + this.mFragment));
        }
        return n;
    }

    void create() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d((String)TAG, (String)("moveto CREATED: " + this.mFragment));
        }
        if (!this.mFragment.mIsCreated) {
            this.mDispatcher.dispatchOnFragmentPreCreated(this.mFragment, this.mFragment.mSavedFragmentState, false);
            this.mFragment.performCreate(this.mFragment.mSavedFragmentState);
            this.mDispatcher.dispatchOnFragmentCreated(this.mFragment, this.mFragment.mSavedFragmentState, false);
        } else {
            this.mFragment.restoreChildFragmentState(this.mFragment.mSavedFragmentState);
            this.mFragment.mState = 1;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void createView() {
        void var3_11;
        LayoutInflater layoutInflater;
        block19: {
            if (this.mFragment.mFromLayout) {
                return;
            }
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d((String)TAG, (String)("moveto CREATE_VIEW: " + this.mFragment));
            }
            layoutInflater = this.mFragment.performGetLayoutInflater(this.mFragment.mSavedFragmentState);
            Object var3_2 = null;
            if (this.mFragment.mContainer != null) {
                ViewGroup viewGroup = this.mFragment.mContainer;
            } else if (this.mFragment.mContainerId != 0) {
                if (this.mFragment.mContainerId == -1) throw new IllegalArgumentException("Cannot create fragment " + this.mFragment + " for a container view with no id");
                ViewGroup viewGroup = (ViewGroup)this.mFragment.mFragmentManager.getContainer().onFindViewById(this.mFragment.mContainerId);
                if (viewGroup == null) {
                    if (this.mFragment.mRestored) {
                        ViewGroup viewGroup2 = viewGroup;
                        break block19;
                    } else {
                        void var3_8;
                        try {
                            String string2 = this.mFragment.getResources().getResourceName(this.mFragment.mContainerId);
                            throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.mFragment.mContainerId) + " (" + (String)var3_8 + ") for fragment " + this.mFragment);
                        }
                        catch (Resources.NotFoundException notFoundException) {
                            String string3 = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.mFragment.mContainerId) + " (" + (String)var3_8 + ") for fragment " + this.mFragment);
                    }
                }
                ViewGroup viewGroup3 = viewGroup;
                if (!(viewGroup instanceof FragmentContainerView)) {
                    FragmentStrictMode.onWrongFragmentContainer(this.mFragment, viewGroup);
                    ViewGroup viewGroup4 = viewGroup;
                }
            }
        }
        this.mFragment.mContainer = var3_11;
        this.mFragment.performCreateView(layoutInflater, (ViewGroup)var3_11, this.mFragment.mSavedFragmentState);
        if (this.mFragment.mView != null) {
            this.mFragment.mView.setSaveFromParentEnabled(false);
            this.mFragment.mView.setTag(R.id.fragment_container_view_tag, (Object)this.mFragment);
            if (var3_11 != null) {
                this.addViewToContainer();
            }
            if (this.mFragment.mHidden) {
                this.mFragment.mView.setVisibility(8);
            }
            if (ViewCompat.isAttachedToWindow(this.mFragment.mView)) {
                ViewCompat.requestApplyInsets(this.mFragment.mView);
            } else {
                View view = this.mFragment.mView;
                view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this, view){
                    final FragmentStateManager this$0;
                    final View val$fragmentView;
                    {
                        this.this$0 = fragmentStateManager;
                        this.val$fragmentView = view;
                    }

                    public void onViewAttachedToWindow(View view) {
                        this.val$fragmentView.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
                        ViewCompat.requestApplyInsets(this.val$fragmentView);
                    }

                    public void onViewDetachedFromWindow(View view) {
                    }
                });
            }
            this.mFragment.performViewCreated();
            this.mDispatcher.dispatchOnFragmentViewCreated(this.mFragment, this.mFragment.mView, this.mFragment.mSavedFragmentState, false);
            int n = this.mFragment.mView.getVisibility();
            float f = this.mFragment.mView.getAlpha();
            this.mFragment.setPostOnViewCreatedAlpha(f);
            if (this.mFragment.mContainer != null && n == 0) {
                View view = this.mFragment.mView.findFocus();
                if (view != null) {
                    this.mFragment.setFocusedView(view);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v((String)TAG, (String)("requestFocus: Saved focused view " + view + " for Fragment " + this.mFragment));
                    }
                }
                this.mFragment.mView.setAlpha(0.0f);
            }
        }
        this.mFragment.mState = 2;
    }

    void destroy() {
        boolean bl;
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d((String)TAG, (String)("movefrom CREATED: " + this.mFragment));
        }
        if ((bl = this.mFragment.mRemoving && !this.mFragment.isInBackStack()) && !this.mFragment.mBeingSaved) {
            this.mFragmentStore.setSavedState(this.mFragment.mWho, null);
        }
        boolean bl2 = bl || this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment);
        if (bl2) {
            FragmentHostCallback<?> fragmentHostCallback = this.mFragment.mHost;
            boolean bl3 = fragmentHostCallback instanceof ViewModelStoreOwner ? this.mFragmentStore.getNonConfig().isCleared() : (fragmentHostCallback.getContext() instanceof Activity ? true ^ ((Activity)fragmentHostCallback.getContext()).isChangingConfigurations() : true);
            if (bl && !this.mFragment.mBeingSaved || bl3) {
                this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment);
            }
            this.mFragment.performDestroy();
            this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
            for (FragmentStateManager fragmentStateManager : this.mFragmentStore.getActiveFragmentStateManagers()) {
                if (fragmentStateManager == null) continue;
                Fragment fragment = fragmentStateManager.getFragment();
                if (!this.mFragment.mWho.equals(fragment.mTargetWho)) continue;
                fragment.mTarget = this.mFragment;
                fragment.mTargetWho = null;
            }
            if (this.mFragment.mTargetWho != null) {
                this.mFragment.mTarget = this.mFragmentStore.findActiveFragment(this.mFragment.mTargetWho);
            }
            this.mFragmentStore.makeInactive(this);
        } else {
            Fragment fragment;
            if (this.mFragment.mTargetWho != null && (fragment = this.mFragmentStore.findActiveFragment(this.mFragment.mTargetWho)) != null && fragment.mRetainInstance) {
                this.mFragment.mTarget = fragment;
            }
            this.mFragment.mState = 0;
        }
    }

    void destroyFragmentView() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d((String)TAG, (String)("movefrom CREATE_VIEW: " + this.mFragment));
        }
        if (this.mFragment.mContainer != null && this.mFragment.mView != null) {
            this.mFragment.mContainer.removeView(this.mFragment.mView);
        }
        this.mFragment.performDestroyView();
        this.mDispatcher.dispatchOnFragmentViewDestroyed(this.mFragment, false);
        this.mFragment.mContainer = null;
        this.mFragment.mView = null;
        this.mFragment.mViewLifecycleOwner = null;
        this.mFragment.mViewLifecycleOwnerLiveData.setValue(null);
        this.mFragment.mInLayout = false;
    }

    void detach() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d((String)TAG, (String)("movefrom ATTACHED: " + this.mFragment));
        }
        this.mFragment.performDetach();
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
        Fragment fragment = this.mFragment;
        boolean bl = false;
        fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentDetached(fragment, false);
        this.mFragment.mState = -1;
        this.mFragment.mHost = null;
        this.mFragment.mParentFragment = null;
        this.mFragment.mFragmentManager = null;
        boolean bl2 = bl;
        if (this.mFragment.mRemoving) {
            bl2 = bl;
            if (!this.mFragment.isInBackStack()) {
                bl2 = true;
            }
        }
        if (bl2 || this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment)) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d((String)TAG, (String)("initState called for fragment: " + this.mFragment));
            }
            this.mFragment.initState();
        }
    }

    void ensureInflatedView() {
        if (this.mFragment.mFromLayout && this.mFragment.mInLayout && !this.mFragment.mPerformedCreateView) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d((String)TAG, (String)("moveto CREATE_VIEW: " + this.mFragment));
            }
            this.mFragment.performCreateView(this.mFragment.performGetLayoutInflater(this.mFragment.mSavedFragmentState), null, this.mFragment.mSavedFragmentState);
            if (this.mFragment.mView != null) {
                this.mFragment.mView.setSaveFromParentEnabled(false);
                this.mFragment.mView.setTag(R.id.fragment_container_view_tag, (Object)this.mFragment);
                if (this.mFragment.mHidden) {
                    this.mFragment.mView.setVisibility(8);
                }
                this.mFragment.performViewCreated();
                this.mDispatcher.dispatchOnFragmentViewCreated(this.mFragment, this.mFragment.mView, this.mFragment.mSavedFragmentState, false);
                this.mFragment.mState = 2;
            }
        }
    }

    Fragment getFragment() {
        return this.mFragment;
    }

    void moveToExpectedState() {
        if (this.mMovingToState) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v((String)TAG, (String)("Ignoring re-entrant call to moveToExpectedState() for " + this.getFragment()));
            }
            return;
        }
        try {
            Object object;
            int n;
            this.mMovingToState = true;
            boolean bl = false;
            block26: while ((n = this.computeExpectedState()) != this.mFragment.mState) {
                bl = true;
                if (n > this.mFragment.mState) {
                    switch (this.mFragment.mState + 1) {
                        default: {
                            continue block26;
                        }
                        case 7: {
                            this.resume();
                            continue block26;
                        }
                        case 6: {
                            this.mFragment.mState = 6;
                            continue block26;
                        }
                        case 5: {
                            this.start();
                            continue block26;
                        }
                        case 4: {
                            if (this.mFragment.mView != null && this.mFragment.mContainer != null) {
                                object = SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager());
                                n = this.mFragment.mView.getVisibility();
                                ((SpecialEffectsController)object).enqueueAdd(SpecialEffectsController.Operation.State.from(n), this);
                            }
                            this.mFragment.mState = 4;
                            continue block26;
                        }
                        case 3: {
                            this.activityCreated();
                            continue block26;
                        }
                        case 2: {
                            this.ensureInflatedView();
                            this.createView();
                            continue block26;
                        }
                        case 1: {
                            this.create();
                            continue block26;
                        }
                        case 0: 
                    }
                    this.attach();
                    continue;
                }
                switch (this.mFragment.mState - 1) {
                    default: {
                        continue block26;
                    }
                    case 6: {
                        this.pause();
                        continue block26;
                    }
                    case 5: {
                        this.mFragment.mState = 5;
                        continue block26;
                    }
                    case 4: {
                        this.stop();
                        continue block26;
                    }
                    case 3: {
                        if (FragmentManager.isLoggingEnabled(3)) {
                            object = new StringBuilder();
                            Log.d((String)TAG, (String)((StringBuilder)object).append("movefrom ACTIVITY_CREATED: ").append(this.mFragment).toString());
                        }
                        if (this.mFragment.mBeingSaved) {
                            this.saveState();
                        } else if (this.mFragment.mView != null && this.mFragment.mSavedViewState == null) {
                            this.saveViewState();
                        }
                        if (this.mFragment.mView != null && this.mFragment.mContainer != null) {
                            SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager()).enqueueRemove(this);
                        }
                        this.mFragment.mState = 3;
                        continue block26;
                    }
                    case 2: {
                        this.mFragment.mInLayout = false;
                        this.mFragment.mState = 2;
                        continue block26;
                    }
                    case 1: {
                        this.destroyFragmentView();
                        this.mFragment.mState = 1;
                        continue block26;
                    }
                    case 0: {
                        if (this.mFragment.mBeingSaved && this.mFragmentStore.getSavedState(this.mFragment.mWho) == null) {
                            this.saveState();
                        }
                        this.destroy();
                        continue block26;
                    }
                    case -1: 
                }
                this.detach();
            }
            if (!bl && this.mFragment.mState == -1 && this.mFragment.mRemoving && !this.mFragment.isInBackStack() && !this.mFragment.mBeingSaved) {
                if (FragmentManager.isLoggingEnabled(3)) {
                    object = new StringBuilder();
                    Log.d((String)TAG, (String)((StringBuilder)object).append("Cleaning up state of never attached fragment: ").append(this.mFragment).toString());
                }
                this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment);
                this.mFragmentStore.makeInactive(this);
                if (FragmentManager.isLoggingEnabled(3)) {
                    object = new StringBuilder();
                    Log.d((String)TAG, (String)((StringBuilder)object).append("initState called for fragment: ").append(this.mFragment).toString());
                }
                this.mFragment.initState();
            }
            if (this.mFragment.mHiddenChanged) {
                if (this.mFragment.mView != null && this.mFragment.mContainer != null) {
                    object = SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager());
                    if (this.mFragment.mHidden) {
                        ((SpecialEffectsController)object).enqueueHide(this);
                    } else {
                        ((SpecialEffectsController)object).enqueueShow(this);
                    }
                }
                if (this.mFragment.mFragmentManager != null) {
                    this.mFragment.mFragmentManager.invalidateMenuForFragment(this.mFragment);
                }
                this.mFragment.mHiddenChanged = false;
                this.mFragment.onHiddenChanged(this.mFragment.mHidden);
                this.mFragment.mChildFragmentManager.dispatchOnHiddenChanged();
            }
            return;
        }
        finally {
            this.mMovingToState = false;
        }
    }

    void pause() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d((String)TAG, (String)("movefrom RESUMED: " + this.mFragment));
        }
        this.mFragment.performPause();
        this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
    }

    void restoreState(ClassLoader classLoader) {
        if (this.mFragment.mSavedFragmentState == null) {
            return;
        }
        this.mFragment.mSavedFragmentState.setClassLoader(classLoader);
        this.mFragment.mSavedViewState = this.mFragment.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
        this.mFragment.mSavedViewRegistryState = this.mFragment.mSavedFragmentState.getBundle(VIEW_REGISTRY_STATE_TAG);
        this.mFragment.mTargetWho = this.mFragment.mSavedFragmentState.getString(TARGET_STATE_TAG);
        if (this.mFragment.mTargetWho != null) {
            this.mFragment.mTargetRequestCode = this.mFragment.mSavedFragmentState.getInt(TARGET_REQUEST_CODE_STATE_TAG, 0);
        }
        if (this.mFragment.mSavedUserVisibleHint != null) {
            this.mFragment.mUserVisibleHint = this.mFragment.mSavedUserVisibleHint;
            this.mFragment.mSavedUserVisibleHint = null;
        } else {
            this.mFragment.mUserVisibleHint = this.mFragment.mSavedFragmentState.getBoolean(USER_VISIBLE_HINT_TAG, true);
        }
        if (!this.mFragment.mUserVisibleHint) {
            this.mFragment.mDeferStart = true;
        }
    }

    void resume() {
        Object object;
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d((String)TAG, (String)("moveto RESUMED: " + this.mFragment));
        }
        if ((object = this.mFragment.getFocusedView()) != null && this.isFragmentViewChild((View)object)) {
            boolean bl = object.requestFocus();
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder stringBuilder = new StringBuilder().append("requestFocus: Restoring focused view ").append(object).append(" ");
                object = bl ? "succeeded" : "failed";
                Log.v((String)TAG, (String)stringBuilder.append((String)object).append(" on Fragment ").append(this.mFragment).append(" resulting in focused view ").append(this.mFragment.mView.findFocus()).toString());
            }
        }
        this.mFragment.setFocusedView(null);
        this.mFragment.performResume();
        this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
        this.mFragment.mSavedFragmentState = null;
        this.mFragment.mSavedViewState = null;
        this.mFragment.mSavedViewRegistryState = null;
    }

    Fragment.SavedState saveInstanceState() {
        int n = this.mFragment.mState;
        Fragment.SavedState savedState = null;
        if (n > -1) {
            Bundle bundle = this.saveBasicState();
            if (bundle != null) {
                savedState = new Fragment.SavedState(bundle);
            }
            return savedState;
        }
        return null;
    }

    void saveState() {
        FragmentState fragmentState = new FragmentState(this.mFragment);
        if (this.mFragment.mState > -1 && fragmentState.mSavedFragmentState == null) {
            fragmentState.mSavedFragmentState = this.saveBasicState();
            if (this.mFragment.mTargetWho != null) {
                if (fragmentState.mSavedFragmentState == null) {
                    fragmentState.mSavedFragmentState = new Bundle();
                }
                fragmentState.mSavedFragmentState.putString(TARGET_STATE_TAG, this.mFragment.mTargetWho);
                if (this.mFragment.mTargetRequestCode != 0) {
                    fragmentState.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, this.mFragment.mTargetRequestCode);
                }
            }
        } else {
            fragmentState.mSavedFragmentState = this.mFragment.mSavedFragmentState;
        }
        this.mFragmentStore.setSavedState(this.mFragment.mWho, fragmentState);
    }

    void saveViewState() {
        if (this.mFragment.mView == null) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)TAG, (String)("Saving view state for fragment " + this.mFragment + " with view " + this.mFragment.mView));
        }
        SparseArray sparseArray = new SparseArray();
        this.mFragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.mFragment.mSavedViewState = sparseArray;
        }
        sparseArray = new Bundle();
        this.mFragment.mViewLifecycleOwner.performSave((Bundle)sparseArray);
        if (!sparseArray.isEmpty()) {
            this.mFragment.mSavedViewRegistryState = sparseArray;
        }
    }

    void setFragmentManagerState(int n) {
        this.mFragmentManagerState = n;
    }

    void start() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d((String)TAG, (String)("moveto STARTED: " + this.mFragment));
        }
        this.mFragment.performStart();
        this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
    }

    void stop() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d((String)TAG, (String)("movefrom STARTED: " + this.mFragment));
        }
        this.mFragment.performStop();
        this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
    }
}

