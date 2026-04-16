/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.LogWriter;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord
extends FragmentTransaction
implements FragmentManager.BackStackEntry,
FragmentManager.OpGenerator {
    private static final String TAG = "FragmentManager";
    boolean mBeingSaved;
    boolean mCommitted;
    int mIndex;
    final FragmentManager mManager;

    BackStackRecord(BackStackRecord backStackRecord) {
        FragmentFactory fragmentFactory = backStackRecord.mManager.getFragmentFactory();
        ClassLoader classLoader = backStackRecord.mManager.getHost() != null ? backStackRecord.mManager.getHost().getContext().getClassLoader() : null;
        super(fragmentFactory, classLoader, backStackRecord);
        this.mIndex = -1;
        this.mBeingSaved = false;
        this.mManager = backStackRecord.mManager;
        this.mCommitted = backStackRecord.mCommitted;
        this.mIndex = backStackRecord.mIndex;
        this.mBeingSaved = backStackRecord.mBeingSaved;
    }

    BackStackRecord(FragmentManager fragmentManager) {
        FragmentFactory fragmentFactory = fragmentManager.getFragmentFactory();
        ClassLoader classLoader = fragmentManager.getHost() != null ? fragmentManager.getHost().getContext().getClassLoader() : null;
        super(fragmentFactory, classLoader);
        this.mIndex = -1;
        this.mBeingSaved = false;
        this.mManager = fragmentManager;
    }

    void bumpBackStackNesting(int n) {
        if (!this.mAddToBackStack) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)TAG, (String)("Bump nesting in " + this + " by " + n));
        }
        int n2 = this.mOps.size();
        for (int i = 0; i < n2; ++i) {
            FragmentTransaction.Op op = (FragmentTransaction.Op)this.mOps.get(i);
            if (op.mFragment == null) continue;
            Fragment fragment = op.mFragment;
            fragment.mBackStackNesting += n;
            if (!FragmentManager.isLoggingEnabled(2)) continue;
            Log.v((String)TAG, (String)("Bump nesting of " + op.mFragment + " to " + op.mFragment.mBackStackNesting));
        }
    }

    void collapseOps() {
        int n = this.mOps.size() - 1;
        while (n >= 0) {
            int n2;
            FragmentTransaction.Op op = (FragmentTransaction.Op)this.mOps.get(n);
            if (!op.mFromExpandedOp) {
                n2 = n;
            } else if (op.mCmd == 8) {
                op.mFromExpandedOp = false;
                this.mOps.remove(n - 1);
                n2 = n - 1;
            } else {
                int n3 = op.mFragment.mContainerId;
                op.mCmd = 2;
                op.mFromExpandedOp = false;
                int n4 = n - 1;
                while (true) {
                    n2 = n;
                    if (n4 < 0) break;
                    op = (FragmentTransaction.Op)this.mOps.get(n4);
                    n2 = n;
                    if (op.mFromExpandedOp) {
                        n2 = n;
                        if (op.mFragment.mContainerId == n3) {
                            this.mOps.remove(n4);
                            n2 = n - 1;
                        }
                    }
                    --n4;
                    n = n2;
                }
            }
            n = n2 - 1;
        }
    }

    @Override
    public int commit() {
        return this.commitInternal(false);
    }

    @Override
    public int commitAllowingStateLoss() {
        return this.commitInternal(true);
    }

    int commitInternal(boolean bl) {
        if (!this.mCommitted) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v((String)TAG, (String)("Commit: " + this));
                PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
                this.dump("  ", printWriter);
                printWriter.close();
            }
            this.mCommitted = true;
            this.mIndex = this.mAddToBackStack ? this.mManager.allocBackStackIndex() : -1;
            this.mManager.enqueueAction(this, bl);
            return this.mIndex;
        }
        throw new IllegalStateException("commit already called");
    }

    @Override
    public void commitNow() {
        this.disallowAddToBackStack();
        this.mManager.execSingleAction(this, false);
    }

    @Override
    public void commitNowAllowingStateLoss() {
        this.disallowAddToBackStack();
        this.mManager.execSingleAction(this, true);
    }

    @Override
    public FragmentTransaction detach(Fragment fragment) {
        if (fragment.mFragmentManager != null && fragment.mFragmentManager != this.mManager) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.detach(fragment);
    }

    @Override
    void doAddOp(int n, Fragment fragment, String string2, int n2) {
        super.doAddOp(n, fragment, string2, n2);
        fragment.mFragmentManager = this.mManager;
    }

    public void dump(String string2, PrintWriter printWriter) {
        this.dump(string2, printWriter, true);
    }

    public void dump(String string2, PrintWriter printWriter, boolean bl) {
        if (bl) {
            printWriter.print(string2);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(string2);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
            }
            if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                printWriter.print(string2);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                printWriter.print(string2);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                printWriter.print(string2);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                printWriter.print(string2);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (!this.mOps.isEmpty()) {
            printWriter.print(string2);
            printWriter.println("Operations:");
            int n = this.mOps.size();
            for (int i = 0; i < n; ++i) {
                String string3;
                FragmentTransaction.Op op = (FragmentTransaction.Op)this.mOps.get(i);
                switch (op.mCmd) {
                    default: {
                        string3 = "cmd=" + op.mCmd;
                        break;
                    }
                    case 10: {
                        string3 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    }
                    case 9: {
                        string3 = "UNSET_PRIMARY_NAV";
                        break;
                    }
                    case 8: {
                        string3 = "SET_PRIMARY_NAV";
                        break;
                    }
                    case 7: {
                        string3 = "ATTACH";
                        break;
                    }
                    case 6: {
                        string3 = "DETACH";
                        break;
                    }
                    case 5: {
                        string3 = "SHOW";
                        break;
                    }
                    case 4: {
                        string3 = "HIDE";
                        break;
                    }
                    case 3: {
                        string3 = "REMOVE";
                        break;
                    }
                    case 2: {
                        string3 = "REPLACE";
                        break;
                    }
                    case 1: {
                        string3 = "ADD";
                        break;
                    }
                    case 0: {
                        string3 = "NULL";
                    }
                }
                printWriter.print(string2);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(string3);
                printWriter.print(" ");
                printWriter.println(op.mFragment);
                if (!bl) continue;
                if (op.mEnterAnim != 0 || op.mExitAnim != 0) {
                    printWriter.print(string2);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(op.mEnterAnim));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(op.mExitAnim));
                }
                if (op.mPopEnterAnim == 0 && op.mPopExitAnim == 0) continue;
                printWriter.print(string2);
                printWriter.print("popEnterAnim=#");
                printWriter.print(Integer.toHexString(op.mPopEnterAnim));
                printWriter.print(" popExitAnim=#");
                printWriter.println(Integer.toHexString(op.mPopExitAnim));
            }
        }
    }

    void executeOps() {
        int n = this.mOps.size();
        block11: for (int i = 0; i < n; ++i) {
            FragmentTransaction.Op op = (FragmentTransaction.Op)this.mOps.get(i);
            Fragment fragment = op.mFragment;
            if (fragment != null) {
                fragment.mBeingSaved = this.mBeingSaved;
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.mTransition);
                fragment.setSharedElementNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames);
            }
            switch (op.mCmd) {
                default: {
                    throw new IllegalArgumentException("Unknown cmd: " + op.mCmd);
                }
                case 10: {
                    this.mManager.setMaxLifecycle(fragment, op.mCurrentMaxState);
                    continue block11;
                }
                case 9: {
                    this.mManager.setPrimaryNavigationFragment(null);
                    continue block11;
                }
                case 8: {
                    this.mManager.setPrimaryNavigationFragment(fragment);
                    continue block11;
                }
                case 7: {
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    this.mManager.attachFragment(fragment);
                    continue block11;
                }
                case 6: {
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    this.mManager.detachFragment(fragment);
                    continue block11;
                }
                case 5: {
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    this.mManager.showFragment(fragment);
                    continue block11;
                }
                case 4: {
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    this.mManager.hideFragment(fragment);
                    continue block11;
                }
                case 3: {
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    this.mManager.removeFragment(fragment);
                    continue block11;
                }
                case 1: {
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    this.mManager.addFragment(fragment);
                }
            }
        }
    }

    void executePopOps() {
        block11: for (int i = this.mOps.size() - 1; i >= 0; --i) {
            FragmentTransaction.Op op = (FragmentTransaction.Op)this.mOps.get(i);
            Fragment fragment = op.mFragment;
            if (fragment != null) {
                fragment.mBeingSaved = this.mBeingSaved;
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.reverseTransit(this.mTransition));
                fragment.setSharedElementNames(this.mSharedElementTargetNames, this.mSharedElementSourceNames);
            }
            switch (op.mCmd) {
                default: {
                    throw new IllegalArgumentException("Unknown cmd: " + op.mCmd);
                }
                case 10: {
                    this.mManager.setMaxLifecycle(fragment, op.mOldMaxState);
                    continue block11;
                }
                case 9: {
                    this.mManager.setPrimaryNavigationFragment(fragment);
                    continue block11;
                }
                case 8: {
                    this.mManager.setPrimaryNavigationFragment(null);
                    continue block11;
                }
                case 7: {
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, true);
                    this.mManager.detachFragment(fragment);
                    continue block11;
                }
                case 6: {
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    this.mManager.attachFragment(fragment);
                    continue block11;
                }
                case 5: {
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, true);
                    this.mManager.hideFragment(fragment);
                    continue block11;
                }
                case 4: {
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    this.mManager.showFragment(fragment);
                    continue block11;
                }
                case 3: {
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    this.mManager.addFragment(fragment);
                    continue block11;
                }
                case 1: {
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, true);
                    this.mManager.removeFragment(fragment);
                }
            }
        }
    }

    Fragment expandOps(ArrayList<Fragment> arrayList, Fragment object) {
        int n = 0;
        Fragment fragment = object;
        while (n < this.mOps.size()) {
            int n2;
            FragmentTransaction.Op op = (FragmentTransaction.Op)this.mOps.get(n);
            switch (op.mCmd) {
                default: {
                    n2 = n;
                    object = fragment;
                    break;
                }
                case 8: {
                    this.mOps.add(n, new FragmentTransaction.Op(9, fragment, true));
                    op.mFromExpandedOp = true;
                    n2 = n + 1;
                    object = op.mFragment;
                    break;
                }
                case 3: 
                case 6: {
                    arrayList.remove(op.mFragment);
                    n2 = n;
                    object = fragment;
                    if (op.mFragment != fragment) break;
                    this.mOps.add(n, new FragmentTransaction.Op(9, op.mFragment));
                    n2 = n + 1;
                    object = null;
                    break;
                }
                case 2: {
                    Fragment fragment2 = op.mFragment;
                    int n3 = fragment2.mContainerId;
                    boolean bl = false;
                    object = fragment;
                    for (n2 = arrayList.size() - 1; n2 >= 0; --n2) {
                        Fragment fragment3 = arrayList.get(n2);
                        int n4 = n;
                        boolean bl2 = bl;
                        fragment = object;
                        if (fragment3.mContainerId == n3) {
                            if (fragment3 == fragment2) {
                                bl2 = true;
                                n4 = n;
                                fragment = object;
                            } else {
                                n4 = n;
                                fragment = object;
                                if (fragment3 == object) {
                                    this.mOps.add(n, new FragmentTransaction.Op(9, fragment3, true));
                                    n4 = n + 1;
                                    fragment = null;
                                }
                                object = new FragmentTransaction.Op(3, fragment3, true);
                                ((FragmentTransaction.Op)object).mEnterAnim = op.mEnterAnim;
                                ((FragmentTransaction.Op)object).mPopEnterAnim = op.mPopEnterAnim;
                                ((FragmentTransaction.Op)object).mExitAnim = op.mExitAnim;
                                ((FragmentTransaction.Op)object).mPopExitAnim = op.mPopExitAnim;
                                this.mOps.add(n4, object);
                                arrayList.remove(fragment3);
                                bl2 = bl;
                            }
                        }
                        n = ++n4;
                        bl = bl2;
                        object = fragment;
                    }
                    if (bl) {
                        this.mOps.remove(n);
                        --n;
                    } else {
                        op.mCmd = 1;
                        op.mFromExpandedOp = true;
                        arrayList.add(fragment2);
                    }
                    n2 = n;
                    break;
                }
                case 1: 
                case 7: {
                    arrayList.add(op.mFragment);
                    object = fragment;
                    n2 = n;
                }
            }
            n = n2 + 1;
            fragment = object;
        }
        return fragment;
    }

    @Override
    public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)TAG, (String)("Run: " + this));
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (this.mAddToBackStack) {
            this.mManager.addBackStackState(this);
        }
        return true;
    }

    @Override
    public CharSequence getBreadCrumbShortTitle() {
        if (this.mBreadCrumbShortTitleRes != 0) {
            return this.mManager.getHost().getContext().getText(this.mBreadCrumbShortTitleRes);
        }
        return this.mBreadCrumbShortTitleText;
    }

    @Override
    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    @Override
    public CharSequence getBreadCrumbTitle() {
        if (this.mBreadCrumbTitleRes != 0) {
            return this.mManager.getHost().getContext().getText(this.mBreadCrumbTitleRes);
        }
        return this.mBreadCrumbTitleText;
    }

    @Override
    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    @Override
    public int getId() {
        return this.mIndex;
    }

    @Override
    public String getName() {
        return this.mName;
    }

    @Override
    public FragmentTransaction hide(Fragment fragment) {
        if (fragment.mFragmentManager != null && fragment.mFragmentManager != this.mManager) {
            throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.hide(fragment);
    }

    @Override
    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    @Override
    public FragmentTransaction remove(Fragment fragment) {
        if (fragment.mFragmentManager != null && fragment.mFragmentManager != this.mManager) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.remove(fragment);
    }

    public void runOnCommitRunnables() {
        if (this.mCommitRunnables != null) {
            for (int i = 0; i < this.mCommitRunnables.size(); ++i) {
                ((Runnable)this.mCommitRunnables.get(i)).run();
            }
            this.mCommitRunnables = null;
        }
    }

    @Override
    public FragmentTransaction setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager == this.mManager) {
            if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
                throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + (Object)((Object)state) + " after the Fragment has been created");
            }
            if (state != Lifecycle.State.DESTROYED) {
                return super.setMaxLifecycle(fragment, state);
            }
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + (Object)((Object)state) + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.mManager);
    }

    @Override
    public FragmentTransaction setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment != null && fragment.mFragmentManager != null && fragment.mFragmentManager != this.mManager) {
            throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.setPrimaryNavigationFragment(fragment);
    }

    @Override
    public FragmentTransaction show(Fragment fragment) {
        if (fragment.mFragmentManager != null && fragment.mFragmentManager != this.mManager) {
            throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.show(fragment);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.mName != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.mName);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    Fragment trackAddedFragmentsInPop(ArrayList<Fragment> arrayList, Fragment fragment) {
        block7: for (int i = this.mOps.size() - 1; i >= 0; --i) {
            FragmentTransaction.Op op = (FragmentTransaction.Op)this.mOps.get(i);
            switch (op.mCmd) {
                default: {
                    continue block7;
                }
                case 10: {
                    op.mCurrentMaxState = op.mOldMaxState;
                    continue block7;
                }
                case 9: {
                    fragment = op.mFragment;
                    continue block7;
                }
                case 8: {
                    fragment = null;
                    continue block7;
                }
                case 3: 
                case 6: {
                    arrayList.add(op.mFragment);
                    continue block7;
                }
                case 1: 
                case 7: {
                    arrayList.remove(op.mFragment);
                }
            }
        }
        return fragment;
    }
}

