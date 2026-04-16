package tlydtdl.fragment.app;

import a2.n3;
import amuvvoafs.animation.Animator;
import amuvvoafs.annotation.SuppressLint;
import amuvvoafs.app.Activity;
import amuvvoafs.app.Application;
import amuvvoafs.content.ComponentCallbacks;
import amuvvoafs.content.Context;
import amuvvoafs.content.ContextWrapper;
import amuvvoafs.content.Intent;
import amuvvoafs.content.IntentSender;
import amuvvoafs.content.res.Configuration;
import amuvvoafs.content.res.Resources;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.Handler;
import amuvvoafs.os.Looper;
import amuvvoafs.os.Parcelable;
import amuvvoafs.util.AttributeSet;
import amuvvoafs.util.Log;
import amuvvoafs.util.SparseArray;
import amuvvoafs.view.ContextMenu;
import amuvvoafs.view.LayoutInflater;
import amuvvoafs.view.Menu;
import amuvvoafs.view.MenuInflater;
import amuvvoafs.view.MenuItem;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import amuvvoafs.view.animation.Animation;
import cc.e;
import cc.g;
import i.c;
import i.d;
import i.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import lmjxuqdtp.jvm.internal.o;
import tlydtdl.fragment.app.Fragment;
import tlydtdl.lifecycle.i0;
import tlydtdl.lifecycle.i1;
import tlydtdl.lifecycle.p0;
import tlydtdl.lifecycle.q;
import tlydtdl.lifecycle.r1;
import tlydtdl.lifecycle.t0;
import tlydtdl.lifecycle.z;
import u7.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k0 implements ComponentCallbacks, View.OnCreateContextMenuListener, tlydtdl.lifecycle.g0, tlydtdl.lifecycle.w1, q, g, c {
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
    g0 mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    r1 mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    k1 mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    s0 mHost;
    boolean mInDynamicContainer;
    boolean mInLayout;
    boolean mIsCreated;
    LayoutInflater mLayoutInflater;
    i0 mLifecycleRegistry;
    k0 mParentFragment;
    boolean mPerformedCreateView;
    Handler mPostponedHandler;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    cc.f mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    k0 mTarget;
    int mTargetRequestCode;
    boolean mTransitioning;
    View mView;
    f2 mViewLifecycleOwner;
    int mState = -1;
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;
    k1 mChildFragmentManager = new l1();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Runnable mPostponedDurationRunnable = new a0(0, this);
    tlydtdl.lifecycle.y mMaxState = tlydtdl.lifecycle.y.e;
    t0 mViewLifecycleOwnerLiveData = new t0();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<h0> mOnPreAttachedListeners = new ArrayList<>();
    private final h0 mSavedStateAttachListener = new b0(this);

    public k0() {
        j();
    }

    @Deprecated
    public static k0 instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public void callStartTransitionListener(boolean z) {
        ViewGroup viewGroup;
        k1 k1Var;
        g0 g0Var = this.mAnimationInfo;
        if (g0Var != null) {
            g0Var.s = false;
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (k1Var = this.mFragmentManager) == null) {
            return;
        }
        r rVarJ = r.j(viewGroup, k1Var);
        rVarJ.l();
        if (z) {
            this.mHost.c.post(new s(2, rVarJ));
        } else {
            rVarJ.e();
        }
        Handler handler = this.mPostponedHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mPostponedDurationRunnable);
            this.mPostponedHandler = null;
        }
    }

    public q0 createFragmentContainer() {
        return new c0(this);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        k0 k0VarI = i(false);
        if (k0VarI != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(k0VarI);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            f8.a.a(this).b(str, printWriter);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.w(f3.f2.C(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Activity f() {
        return getActivity();
    }

    public k0 findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.c.c(str);
    }

    public final g0 g() {
        if (this.mAnimationInfo == null) {
            g0 g0Var = new g0();
            g0Var.i = null;
            Object obj = USE_DEFAULT_TRANSITION;
            g0Var.f584j = obj;
            g0Var.k = null;
            g0Var.l = obj;
            g0Var.m = null;
            g0Var.n = obj;
            g0Var.q = 1.0f;
            g0Var.r = null;
            this.mAnimationInfo = g0Var;
        }
        return this.mAnimationInfo;
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final FragmentActivity getActivity() {
        s0 s0Var = this.mHost;
        if (s0Var == null) {
            return null;
        }
        return s0Var.a;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null || (bool = g0Var.p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null || (bool = g0Var.o) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return null;
        }
        g0Var.getClass();
        return null;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final k1 getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(i.m("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        s0 s0Var = this.mHost;
        if (s0Var == null) {
            return null;
        }
        return s0Var.b;
    }

    @Override // tlydtdl.lifecycle.q
    public b8.c getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && k1.N(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        b8.f fVar = new b8.f(0);
        LinkedHashMap linkedHashMap = fVar.a;
        if (application != null) {
            linkedHashMap.put(tlydtdl.lifecycle.q1.d, application);
        }
        linkedHashMap.put(i1.a, this);
        linkedHashMap.put(i1.b, this);
        if (getArguments() != null) {
            linkedHashMap.put(i1.c, getArguments());
        }
        return fVar;
    }

    @Override // tlydtdl.lifecycle.q
    public r1 getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && k1.N(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new tlydtdl.lifecycle.l1(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    public int getEnterAnim() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return 0;
        }
        return g0Var.b;
    }

    public Object getEnterTransition() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return null;
        }
        return g0Var.i;
    }

    public tlydtdl.core.app.u0 getEnterTransitionCallback() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return null;
        }
        g0Var.getClass();
        return null;
    }

    public int getExitAnim() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return 0;
        }
        return g0Var.c;
    }

    public Object getExitTransition() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return null;
        }
        return g0Var.k;
    }

    public tlydtdl.core.app.u0 getExitTransitionCallback() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return null;
        }
        g0Var.getClass();
        return null;
    }

    public View getFocusedView() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return null;
        }
        return g0Var.r;
    }

    @Deprecated
    public final k1 getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        s0 s0Var = this.mHost;
        if (s0Var == null) {
            return null;
        }
        return ((o0) s0Var).e;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // tlydtdl.lifecycle.g0
    public z getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public f8.a getLoaderManager() {
        return f8.a.a(this);
    }

    public int getNextTransition() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return 0;
        }
        return g0Var.f583f;
    }

    public final k0 getParentFragment() {
        return this.mParentFragment;
    }

    public final k1 getParentFragmentManager() {
        k1 k1Var = this.mFragmentManager;
        if (k1Var != null) {
            return k1Var;
        }
        throw new IllegalStateException(i.m("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return false;
        }
        return g0Var.a;
    }

    public int getPopEnterAnim() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return 0;
        }
        return g0Var.d;
    }

    public int getPopExitAnim() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return 0;
        }
        return g0Var.e;
    }

    public float getPostOnViewCreatedAlpha() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return 1.0f;
        }
        return g0Var.q;
    }

    public Object getReenterTransition() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return null;
        }
        Object obj = g0Var.l;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        b.e(this);
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return null;
        }
        Object obj = g0Var.f584j;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    public final e getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b;
    }

    public Object getSharedElementEnterTransition() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return null;
        }
        return g0Var.m;
    }

    public Object getSharedElementReturnTransition() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return null;
        }
        Object obj = g0Var.n;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        g0 g0Var = this.mAnimationInfo;
        return (g0Var == null || (arrayList = g0Var.g) == null) ? new ArrayList<>() : arrayList;
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        g0 g0Var = this.mAnimationInfo;
        return (g0Var == null || (arrayList = g0Var.h) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final k0 getTargetFragment() {
        return i(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        b.f(this);
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public tlydtdl.lifecycle.g0 getViewLifecycleOwner() {
        g gVar = this.mViewLifecycleOwner;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException(i.m("Can't access the Fragment View's LifecycleOwner for ", this, " when getView() is null i.e., before onCreateView() or after onDestroyView()"));
    }

    public p0 getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // tlydtdl.lifecycle.w1
    public tlydtdl.lifecycle.v1 getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        int iH = h();
        tlydtdl.lifecycle.y yVar = tlydtdl.lifecycle.y.a;
        if (iH == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap map = this.mFragmentManager.P.d;
        tlydtdl.lifecycle.v1 v1Var = (tlydtdl.lifecycle.v1) map.get(this.mWho);
        if (v1Var != null) {
            return v1Var;
        }
        tlydtdl.lifecycle.v1 v1Var2 = new tlydtdl.lifecycle.v1();
        map.put(this.mWho, v1Var2);
        return v1Var2;
    }

    public final int h() {
        tlydtdl.lifecycle.y yVar = this.mMaxState;
        return (yVar == tlydtdl.lifecycle.y.b || this.mParentFragment == null) ? yVar.ordinal() : Math.min(yVar.ordinal(), this.mParentFragment.h());
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final k0 i(boolean z) {
        String str;
        if (z) {
            b.g(this);
        }
        k0 k0Var = this.mTarget;
        if (k0Var != null) {
            return k0Var;
        }
        k1 k1Var = this.mFragmentManager;
        if (k1Var == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return k1Var.c.b(str);
    }

    public void initState() {
        j();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new l1();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        if (this.mHidden) {
            return true;
        }
        k1 k1Var = this.mFragmentManager;
        if (k1Var != null) {
            k0 k0Var = this.mParentFragment;
            k1Var.getClass();
            if (k0Var == null ? false : k0Var.isHidden()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        if (!this.mMenuVisible) {
            return false;
        }
        if (this.mFragmentManager != null) {
            k0 k0Var = this.mParentFragment;
            if (!(k0Var == null ? true : k0Var.isMenuVisible())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPostponed() {
        g0 g0Var = this.mAnimationInfo;
        if (g0Var == null) {
            return false;
        }
        return g0Var.s;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        k1 k1Var = this.mFragmentManager;
        if (k1Var == null) {
            return false;
        }
        return k1Var.R();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public final void j() {
        this.mLifecycleRegistry = new i0(this, true);
        this.mSavedStateRegistryController = new cc.f(new ec.b(this, new n3(8, this)));
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            return;
        }
        h0 h0Var = this.mSavedStateAttachListener;
        if (this.mState >= 0) {
            h0Var.a();
        } else {
            this.mOnPreAttachedListeners.add(h0Var);
        }
    }

    public final z k(j.a aVar, t.a aVar2, i.b bVar) {
        if (this.mState > 1) {
            throw new IllegalStateException(i.m("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
        }
        AtomicReference atomicReference = new AtomicReference();
        h0 f0Var = new f0(this, aVar2, atomicReference, aVar, bVar);
        if (this.mState >= 0) {
            f0Var.a();
        } else {
            this.mOnPreAttachedListeners.add(f0Var);
        }
        return new z(atomicReference);
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.T();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        if (k1.N(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i + " resultCode: " + i2 + " data: " + intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        s0 s0Var = this.mHost;
        FragmentActivity fragmentActivity = s0Var == null ? null : s0Var.a;
        if (fragmentActivity != null) {
            this.mCalled = false;
            onAttach(fragmentActivity);
        }
    }

    @Deprecated
    public void onAttachFragment(k0 k0Var) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState();
        k1 k1Var = this.mChildFragmentManager;
        if (k1Var.w >= 1) {
            return;
        }
        k1Var.I = false;
        k1Var.J = false;
        k1Var.P.g = false;
        k1Var.v(1);
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
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
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        s0 s0Var = this.mHost;
        FragmentActivity fragmentActivity = s0Var == null ? null : s0Var.a;
        if (fragmentActivity != null) {
            this.mCalled = false;
            onInflate(fragmentActivity, attributeSet, bundle);
        }
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
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

    public void onPictureInPictureModeChanged(boolean z) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
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

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    public void performActivityCreated(Bundle bundle) throws SuperNotCalledException {
        this.mChildFragmentManager.T();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException(i.m("Fragment ", this, " did not call through to super.onActivityCreated()"));
        }
        if (k1.N(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            Bundle bundle2 = this.mSavedFragmentState;
            restoreViewState(bundle2 != null ? bundle2.getBundle("savedInstanceState") : null);
        }
        this.mSavedFragmentState = null;
        k1 k1Var = this.mChildFragmentManager;
        k1Var.I = false;
        k1Var.J = false;
        k1Var.P.g = false;
        k1Var.v(4);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    public void performAttach() throws SuperNotCalledException {
        Iterator<h0> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.b(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach((Context) this.mHost.b);
        if (!this.mCalled) {
            throw new SuperNotCalledException(i.m("Fragment ", this, " did not call through to super.onAttach()"));
        }
        Iterator it2 = this.mFragmentManager.q.iterator();
        while (it2.hasNext()) {
            ((p1) it2.next()).a(this);
        }
        k1 k1Var = this.mChildFragmentManager;
        k1Var.I = false;
        k1Var.J = false;
        k1Var.P.g = false;
        k1Var.v(0);
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.k(menuItem);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    public void performCreate(Bundle bundle) throws SuperNotCalledException {
        this.mChildFragmentManager.T();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new d0(this));
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new SuperNotCalledException(i.m("Fragment ", this, " did not call through to super.onCreate()"));
        }
        this.mLifecycleRegistry.g(tlydtdl.lifecycle.x.ON_CREATE);
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z = true;
        }
        return this.mChildFragmentManager.l(menu, menuInflater) | z;
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.T();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new f2(this, getViewModelStore(), new y(this));
        View viewOnCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = viewOnCreateView;
        if (viewOnCreateView == null) {
            if (this.mViewLifecycleOwner.e != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
            return;
        }
        this.mViewLifecycleOwner.b();
        if (k1.N(3)) {
            Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.mView + " for Fragment " + this);
        }
        i1.j(this.mView, this.mViewLifecycleOwner);
        i1.k(this.mView, this.mViewLifecycleOwner);
        y10.r.n0(this.mView, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.j(this.mViewLifecycleOwner);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    public void performDestroy() throws Exception {
        this.mChildFragmentManager.m();
        this.mLifecycleRegistry.g(tlydtdl.lifecycle.x.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new SuperNotCalledException(i.m("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    public void performDestroyView() throws SuperNotCalledException {
        this.mChildFragmentManager.v(1);
        if (this.mView != null) {
            f2 f2Var = this.mViewLifecycleOwner;
            f2Var.b();
            if (f2Var.e.d.compareTo(tlydtdl.lifecycle.y.c) >= 0) {
                this.mViewLifecycleOwner.a(tlydtdl.lifecycle.x.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new SuperNotCalledException(i.m("Fragment ", this, " did not call through to super.onDestroyView()"));
        }
        f8.a.a(this).c();
        this.mPerformedCreateView = false;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    public void performDetach() throws Exception {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new SuperNotCalledException(i.m("Fragment ", this, " did not call through to super.onDetach()"));
        }
        k1 k1Var = this.mChildFragmentManager;
        if (k1Var.K) {
            return;
        }
        k1Var.m();
        this.mChildFragmentManager = new l1();
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
        return layoutInflaterOnGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
    }

    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.q(menuItem);
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.r(menu);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    public void performPause() throws SuperNotCalledException {
        this.mChildFragmentManager.v(5);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(tlydtdl.lifecycle.x.ON_PAUSE);
        }
        this.mLifecycleRegistry.g(tlydtdl.lifecycle.x.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new SuperNotCalledException(i.m("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z = true;
        }
        return this.mChildFragmentManager.u(menu) | z;
    }

    public void performPrimaryNavigationFragmentChanged() {
        this.mFragmentManager.getClass();
        boolean zQ = k1.Q(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != zQ) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(zQ);
            onPrimaryNavigationFragmentChanged(zQ);
            k1 k1Var = this.mChildFragmentManager;
            k1Var.n0();
            k1Var.s(k1Var.A);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    public void performResume() throws SuperNotCalledException {
        this.mChildFragmentManager.T();
        this.mChildFragmentManager.A(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new SuperNotCalledException(i.m("Fragment ", this, " did not call through to super.onResume()"));
        }
        i0 i0Var = this.mLifecycleRegistry;
        tlydtdl.lifecycle.x xVar = tlydtdl.lifecycle.x.ON_RESUME;
        i0Var.g(xVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.e.g(xVar);
        }
        k1 k1Var = this.mChildFragmentManager;
        k1Var.I = false;
        k1Var.J = false;
        k1Var.P.g = false;
        k1Var.v(7);
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    public void performStart() throws SuperNotCalledException {
        this.mChildFragmentManager.T();
        this.mChildFragmentManager.A(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new SuperNotCalledException(i.m("Fragment ", this, " did not call through to super.onStart()"));
        }
        i0 i0Var = this.mLifecycleRegistry;
        tlydtdl.lifecycle.x xVar = tlydtdl.lifecycle.x.ON_START;
        i0Var.g(xVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.e.g(xVar);
        }
        k1 k1Var = this.mChildFragmentManager;
        k1Var.I = false;
        k1Var.J = false;
        k1Var.P.g = false;
        k1Var.v(5);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    public void performStop() throws SuperNotCalledException {
        k1 k1Var = this.mChildFragmentManager;
        k1Var.J = true;
        k1Var.P.g = true;
        k1Var.v(4);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(tlydtdl.lifecycle.x.ON_STOP);
        }
        this.mLifecycleRegistry.g(tlydtdl.lifecycle.x.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new SuperNotCalledException(i.m("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        Bundle bundle = this.mSavedFragmentState;
        onViewCreated(this.mView, bundle != null ? bundle.getBundle("savedInstanceState") : null);
        this.mChildFragmentManager.v(2);
    }

    public void postponeEnterTransition() {
        g().s = true;
    }

    public final <I, O> d registerForActivityResult(j.a aVar, i.b bVar) {
        return k(aVar, new e0(0, this), bVar);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i) {
        if (this.mHost == null) {
            throw new IllegalStateException(i.m("Fragment ", this, " not attached to Activity"));
        }
        k1 parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.F == null) {
            parentFragmentManager.x.getClass();
            o.h(strArr, "permissions");
        } else {
            parentFragmentManager.G.addLast(new e1(this.mWho, i));
            parentFragmentManager.F.a(strArr);
        }
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException(i.m("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(i.m("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(i.m("Fragment ", this, " not attached to a context."));
    }

    @Deprecated
    public final k1 requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(i.m("Fragment ", this, " not attached to a host."));
    }

    public final k0 requireParentFragment() {
        k0 parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException(i.m("Fragment ", this, " is not attached to any Fragment or host"));
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(i.m("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState() {
        Bundle bundle;
        Bundle bundle2 = this.mSavedFragmentState;
        if (bundle2 == null || (bundle = bundle2.getBundle("childFragmentManager")) == null) {
            return;
        }
        this.mChildFragmentManager.b0(bundle);
        k1 k1Var = this.mChildFragmentManager;
        k1Var.I = false;
        k1Var.J = false;
        k1Var.P.g = false;
        k1Var.v(1);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    public final void restoreViewState(Bundle bundle) throws SuperNotCalledException {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException(i.m("Fragment ", this, " did not call through to super.onViewStateRestored()"));
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(tlydtdl.lifecycle.x.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        g().p = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        g().o = Boolean.valueOf(z);
    }

    public void setAnimations(int i, int i2, int i3, int i4) {
        if (this.mAnimationInfo == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        g().b = i;
        g().c = i2;
        g().d = i3;
        g().e = i4;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(tlydtdl.core.app.u0 u0Var) {
        g().getClass();
    }

    public void setEnterTransition(Object obj) {
        g().i = obj;
    }

    public void setExitSharedElementCallback(tlydtdl.core.app.u0 u0Var) {
        g().getClass();
    }

    public void setExitTransition(Object obj) {
        g().k = obj;
    }

    public void setFocusedView(View view) {
        g().r = view;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            ((o0) this.mHost).e.invalidateMenu();
        }
    }

    public void setInitialSavedState(j0 j0Var) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (j0Var == null || (bundle = j0Var.a) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                ((o0) this.mHost).e.invalidateMenu();
            }
        }
    }

    public void setNextTransition(int i) {
        if (this.mAnimationInfo == null && i == 0) {
            return;
        }
        g();
        this.mAnimationInfo.f583f = i;
    }

    public void setPopDirection(boolean z) {
        if (this.mAnimationInfo == null) {
            return;
        }
        g().a = z;
    }

    public void setPostOnViewCreatedAlpha(float f2) {
        g().q = f2;
    }

    public void setReenterTransition(Object obj) {
        g().l = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        b.h(this);
        this.mRetainInstance = z;
        k1 k1Var = this.mFragmentManager;
        if (k1Var == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            k1Var.P.e(this);
        } else {
            k1Var.P.i(this);
        }
    }

    public void setReturnTransition(Object obj) {
        g().f584j = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        g().m = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        g();
        g0 g0Var = this.mAnimationInfo;
        g0Var.g = arrayList;
        g0Var.h = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        g().n = obj;
    }

    @Deprecated
    public void setTargetFragment(k0 k0Var, int i) {
        if (k0Var != null) {
            b.i(this, k0Var, i);
        }
        k1 k1Var = this.mFragmentManager;
        k1 k1Var2 = k0Var != null ? k0Var.mFragmentManager : null;
        if (k1Var != null && k1Var2 != null && k1Var != k1Var2) {
            throw new IllegalArgumentException(i.m("Fragment ", k0Var, " must share the same FragmentManager to be set as a target fragment"));
        }
        for (k0 k0VarI = k0Var; k0VarI != null; k0VarI = k0VarI.i(false)) {
            if (k0VarI.equals(this)) {
                throw new IllegalArgumentException("Setting " + k0Var + " as the target of " + this + " would create a target cycle");
            }
        }
        if (k0Var == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || k0Var.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = k0Var;
        } else {
            this.mTargetWho = k0Var.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        b.j(this, z);
        boolean z2 = false;
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            k1 k1Var = this.mFragmentManager;
            t1 t1VarH = k1Var.h(this);
            k0 k0Var = t1VarH.c;
            if (k0Var.mDeferStart) {
                if (k1Var.b) {
                    k1Var.L = true;
                } else {
                    k0Var.mDeferStart = false;
                    t1VarH.k();
                }
            }
        }
        this.mUserVisibleHint = z;
        if (this.mState < 5 && !z) {
            z2 = true;
        }
        this.mDeferStart = z2;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        s0 s0Var = this.mHost;
        if (s0Var != null) {
            return tlydtdl.core.app.b.g(((o0) s0Var).e, str);
        }
        return false;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (this.mHost == null) {
            throw new IllegalStateException(i.m("Fragment ", this, " not attached to Activity"));
        }
        if (k1.N(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        k1 parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.E == null) {
            s0 s0Var = parentFragmentManager.x;
            s0Var.getClass();
            o.h(intentSender, "intent");
            if (i != -1) {
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
            FragmentActivity fragmentActivity = s0Var.a;
            if (fragmentActivity == null) {
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
            fragmentActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent = new Intent();
                intent.putExtra("tlydtdl.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (k1.N(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent + " for fragment " + this);
            }
            intent.putExtra("tlydtdl.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        bs1.p pVar = new bs1.p(intentSender);
        pVar.m(intent);
        pVar.n(i3, i2);
        i.k kVarA = pVar.a();
        parentFragmentManager.G.addLast(new e1(this.mWho, i));
        if (k1.N(2)) {
            Log.v("FragmentManager", "Fragment " + this + "is launching an IntentSender for result ");
        }
        parentFragmentManager.E.a(kVarA);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !g().s) {
            return;
        }
        if (this.mHost == null) {
            g().s = false;
        } else if (Looper.myLooper() != this.mHost.c.getLooper()) {
            this.mHost.c.postAtFrontOfQueue(new s(1, this));
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener((View.OnCreateContextMenuListener) null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.Fragment$InstantiationException */
    @Deprecated
    public static k0 instantiate(Context context, String str, Bundle bundle) throws Fragment.InstantiationException {
        try {
            k0 k0Var = (k0) a1.b(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle == null) {
                return k0Var;
            }
            bundle.setClassLoader(k0Var.getClass().getClassLoader());
            k0Var.setArguments(bundle);
            return k0Var;
        } catch (IllegalAccessException e) {
            throw new Fragment.InstantiationException(i.n("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (InstantiationException e2) {
            throw new Fragment.InstantiationException(i.n("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new Fragment.InstantiationException(i.n("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new Fragment.InstantiationException(i.n("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final void postponeEnterTransition(long j2, TimeUnit timeUnit) {
        g().s = true;
        Handler handler = this.mPostponedHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mPostponedDurationRunnable);
        }
        k1 k1Var = this.mFragmentManager;
        if (k1Var != null) {
            this.mPostponedHandler = k1Var.x.c;
        } else {
            this.mPostponedHandler = new Handler(Looper.getMainLooper());
        }
        this.mPostponedHandler.removeCallbacks(this.mPostponedDurationRunnable);
        this.mPostponedHandler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j2));
    }

    public final <I, O> d registerForActivityResult(j.a aVar, i iVar, i.b bVar) {
        return k(aVar, new e0(1, iVar), bVar);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        s0 s0Var = this.mHost;
        if (s0Var == null) {
            throw new IllegalStateException(i.m("Fragment ", this, " not attached to Activity"));
        }
        o.h(intent, "intent");
        s0Var.b.startActivity(intent, bundle);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException(i.m("Fragment ", this, " not attached to Activity"));
        }
        k1 parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.D != null) {
            parentFragmentManager.G.addLast(new e1(this.mWho, i));
            if (bundle != null) {
                intent.putExtra("tlydtdl.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            parentFragmentManager.D.a(intent);
            return;
        }
        s0 s0Var = parentFragmentManager.x;
        s0Var.getClass();
        o.h(intent, "intent");
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        s0Var.b.startActivity(intent, bundle);
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        s0 s0Var = this.mHost;
        if (s0Var != null) {
            FragmentActivity fragmentActivity = ((o0) s0Var).e;
            LayoutInflater layoutInflaterCloneInContext = fragmentActivity.getLayoutInflater().cloneInContext(fragmentActivity);
            layoutInflaterCloneInContext.setFactory2(this.mChildFragmentManager.f587f);
            return layoutInflaterCloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }
}
