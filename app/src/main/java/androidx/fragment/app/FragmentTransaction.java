/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class FragmentTransaction {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SET_MAX_LIFECYCLE = 10;
    static final int OP_SET_PRIMARY_NAV = 8;
    static final int OP_SHOW = 5;
    static final int OP_UNSET_PRIMARY_NAV = 9;
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE = 8197;
    public static final int TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN = 4100;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack = true;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    private final ClassLoader mClassLoader;
    ArrayList<Runnable> mCommitRunnables;
    int mEnterAnim;
    int mExitAnim;
    private final FragmentFactory mFragmentFactory;
    String mName;
    ArrayList<Op> mOps = new ArrayList();
    int mPopEnterAnim;
    int mPopExitAnim;
    boolean mReorderingAllowed = false;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    int mTransition;

    @Deprecated
    public FragmentTransaction() {
        this.mFragmentFactory = null;
        this.mClassLoader = null;
    }

    FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        this.mFragmentFactory = fragmentFactory;
        this.mClassLoader = classLoader;
    }

    /*
     * WARNING - void declaration
     */
    FragmentTransaction(FragmentFactory object, ClassLoader object22, FragmentTransaction fragmentTransaction) {
        this((FragmentFactory)((Object)object), (ClassLoader)object22);
        void var3_5;
        for (Op op : var3_5.mOps) {
            this.mOps.add(new Op(op));
        }
        this.mEnterAnim = var3_5.mEnterAnim;
        this.mExitAnim = var3_5.mExitAnim;
        this.mPopEnterAnim = var3_5.mPopEnterAnim;
        this.mPopExitAnim = var3_5.mPopExitAnim;
        this.mTransition = var3_5.mTransition;
        this.mAddToBackStack = var3_5.mAddToBackStack;
        this.mAllowAddToBackStack = var3_5.mAllowAddToBackStack;
        this.mName = var3_5.mName;
        this.mBreadCrumbShortTitleRes = var3_5.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = var3_5.mBreadCrumbShortTitleText;
        this.mBreadCrumbTitleRes = var3_5.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = var3_5.mBreadCrumbTitleText;
        if (var3_5.mSharedElementSourceNames != null) {
            this.mSharedElementSourceNames = new ArrayList();
            this.mSharedElementSourceNames.addAll(var3_5.mSharedElementSourceNames);
        }
        if (var3_5.mSharedElementTargetNames != null) {
            this.mSharedElementTargetNames = new ArrayList();
            this.mSharedElementTargetNames.addAll(var3_5.mSharedElementTargetNames);
        }
        this.mReorderingAllowed = var3_5.mReorderingAllowed;
    }

    private Fragment createFragment(Class<? extends Fragment> object, Bundle bundle) {
        if (this.mFragmentFactory != null) {
            if (this.mClassLoader != null) {
                object = this.mFragmentFactory.instantiate(this.mClassLoader, ((Class)object).getName());
                if (bundle != null) {
                    ((Fragment)object).setArguments(bundle);
                }
                return object;
            }
            throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }
        throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
    }

    public FragmentTransaction add(int n, Fragment fragment) {
        this.doAddOp(n, fragment, null, 1);
        return this;
    }

    public FragmentTransaction add(int n, Fragment fragment, String string2) {
        this.doAddOp(n, fragment, string2, 1);
        return this;
    }

    public final FragmentTransaction add(int n, Class<? extends Fragment> clazz, Bundle bundle) {
        return this.add(n, this.createFragment(clazz, bundle));
    }

    public final FragmentTransaction add(int n, Class<? extends Fragment> clazz, Bundle bundle, String string2) {
        return this.add(n, this.createFragment(clazz, bundle), string2);
    }

    FragmentTransaction add(ViewGroup viewGroup, Fragment fragment, String string2) {
        fragment.mContainer = viewGroup;
        return this.add(viewGroup.getId(), fragment, string2);
    }

    public FragmentTransaction add(Fragment fragment, String string2) {
        this.doAddOp(0, fragment, string2, 1);
        return this;
    }

    public final FragmentTransaction add(Class<? extends Fragment> clazz, Bundle bundle, String string2) {
        return this.add(this.createFragment(clazz, bundle), string2);
    }

    void addOp(Op op) {
        this.mOps.add(op);
        op.mEnterAnim = this.mEnterAnim;
        op.mExitAnim = this.mExitAnim;
        op.mPopEnterAnim = this.mPopEnterAnim;
        op.mPopExitAnim = this.mPopExitAnim;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public FragmentTransaction addSharedElement(View object, String string2) {
        void var2_3;
        if (!FragmentTransition.supportsTransition()) return this;
        String string3 = ViewCompat.getTransitionName(object);
        if (string3 == null) throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
        if (this.mSharedElementSourceNames == null) {
            this.mSharedElementSourceNames = new ArrayList();
            this.mSharedElementTargetNames = new ArrayList();
        } else {
            if (this.mSharedElementTargetNames.contains(var2_3)) throw new IllegalArgumentException("A shared element with the target name '" + (String)var2_3 + "' has already been added to the transaction.");
            if (this.mSharedElementSourceNames.contains(string3)) throw new IllegalArgumentException("A shared element with the source name '" + string3 + "' has already been added to the transaction.");
        }
        this.mSharedElementSourceNames.add(string3);
        this.mSharedElementTargetNames.add((String)var2_3);
        return this;
    }

    public FragmentTransaction addToBackStack(String string2) {
        if (this.mAllowAddToBackStack) {
            this.mAddToBackStack = true;
            this.mName = string2;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public FragmentTransaction attach(Fragment fragment) {
        this.addOp(new Op(7, fragment));
        return this;
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    public FragmentTransaction detach(Fragment fragment) {
        this.addOp(new Op(6, fragment));
        return this;
    }

    public FragmentTransaction disallowAddToBackStack() {
        if (!this.mAddToBackStack) {
            this.mAllowAddToBackStack = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    void doAddOp(int n, Fragment fragment, String string2, int n2) {
        if (fragment.mPreviousWho != null) {
            FragmentStrictMode.onFragmentReuse(fragment, fragment.mPreviousWho);
        }
        Class<?> clazz = fragment.getClass();
        int n3 = clazz.getModifiers();
        if (!clazz.isAnonymousClass() && Modifier.isPublic(n3) && (!clazz.isMemberClass() || Modifier.isStatic(n3))) {
            if (string2 != null) {
                if (fragment.mTag != null && !string2.equals(fragment.mTag)) {
                    throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + string2);
                }
                fragment.mTag = string2;
            }
            if (n != 0) {
                if (n != -1) {
                    if (fragment.mFragmentId != 0 && fragment.mFragmentId != n) {
                        throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + n);
                    }
                    fragment.mFragmentId = n;
                    fragment.mContainerId = n;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + string2 + " to container view with no id");
                }
            }
            this.addOp(new Op(n2, fragment));
            return;
        }
        throw new IllegalStateException("Fragment " + clazz.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public FragmentTransaction hide(Fragment fragment) {
        this.addOp(new Op(4, fragment));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    public FragmentTransaction remove(Fragment fragment) {
        this.addOp(new Op(3, fragment));
        return this;
    }

    public FragmentTransaction replace(int n, Fragment fragment) {
        return this.replace(n, fragment, null);
    }

    public FragmentTransaction replace(int n, Fragment fragment, String string2) {
        if (n != 0) {
            this.doAddOp(n, fragment, string2, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public final FragmentTransaction replace(int n, Class<? extends Fragment> clazz, Bundle bundle) {
        return this.replace(n, clazz, bundle, null);
    }

    public final FragmentTransaction replace(int n, Class<? extends Fragment> clazz, Bundle bundle, String string2) {
        return this.replace(n, this.createFragment(clazz, bundle), string2);
    }

    public FragmentTransaction runOnCommit(Runnable runnable2) {
        this.disallowAddToBackStack();
        if (this.mCommitRunnables == null) {
            this.mCommitRunnables = new ArrayList();
        }
        this.mCommitRunnables.add(runnable2);
        return this;
    }

    @Deprecated
    public FragmentTransaction setAllowOptimization(boolean bl) {
        return this.setReorderingAllowed(bl);
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(int n) {
        this.mBreadCrumbShortTitleRes = n;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = charSequence;
        return this;
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(int n) {
        this.mBreadCrumbTitleRes = n;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = charSequence;
        return this;
    }

    public FragmentTransaction setCustomAnimations(int n, int n2) {
        return this.setCustomAnimations(n, n2, 0, 0);
    }

    public FragmentTransaction setCustomAnimations(int n, int n2, int n3, int n4) {
        this.mEnterAnim = n;
        this.mExitAnim = n2;
        this.mPopEnterAnim = n3;
        this.mPopExitAnim = n4;
        return this;
    }

    public FragmentTransaction setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        this.addOp(new Op(10, fragment, state));
        return this;
    }

    public FragmentTransaction setPrimaryNavigationFragment(Fragment fragment) {
        this.addOp(new Op(8, fragment));
        return this;
    }

    public FragmentTransaction setReorderingAllowed(boolean bl) {
        this.mReorderingAllowed = bl;
        return this;
    }

    public FragmentTransaction setTransition(int n) {
        this.mTransition = n;
        return this;
    }

    @Deprecated
    public FragmentTransaction setTransitionStyle(int n) {
        return this;
    }

    public FragmentTransaction show(Fragment fragment) {
        this.addOp(new Op(5, fragment));
        return this;
    }

    static final class Op {
        int mCmd;
        Lifecycle.State mCurrentMaxState;
        int mEnterAnim;
        int mExitAnim;
        Fragment mFragment;
        boolean mFromExpandedOp;
        Lifecycle.State mOldMaxState;
        int mPopEnterAnim;
        int mPopExitAnim;

        Op() {
        }

        Op(int n, Fragment fragment) {
            this.mCmd = n;
            this.mFragment = fragment;
            this.mFromExpandedOp = false;
            this.mOldMaxState = Lifecycle.State.RESUMED;
            this.mCurrentMaxState = Lifecycle.State.RESUMED;
        }

        Op(int n, Fragment fragment, Lifecycle.State state) {
            this.mCmd = n;
            this.mFragment = fragment;
            this.mFromExpandedOp = false;
            this.mOldMaxState = fragment.mMaxState;
            this.mCurrentMaxState = state;
        }

        Op(int n, Fragment fragment, boolean bl) {
            this.mCmd = n;
            this.mFragment = fragment;
            this.mFromExpandedOp = bl;
            this.mOldMaxState = Lifecycle.State.RESUMED;
            this.mCurrentMaxState = Lifecycle.State.RESUMED;
        }

        Op(Op op) {
            this.mCmd = op.mCmd;
            this.mFragment = op.mFragment;
            this.mFromExpandedOp = op.mFromExpandedOp;
            this.mEnterAnim = op.mEnterAnim;
            this.mExitAnim = op.mExitAnim;
            this.mPopEnterAnim = op.mPopEnterAnim;
            this.mPopExitAnim = op.mPopExitAnim;
            this.mOldMaxState = op.mOldMaxState;
            this.mCurrentMaxState = op.mCurrentMaxState;
        }
    }
}

