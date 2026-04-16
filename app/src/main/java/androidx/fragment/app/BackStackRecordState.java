/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  android.util.Log
 */
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Map;

final class BackStackRecordState
implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new Parcelable.Creator<BackStackRecordState>(){

        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        public BackStackRecordState[] newArray(int n) {
            return new BackStackRecordState[n];
        }
    };
    private static final String TAG = "FragmentManager";
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int[] mCurrentMaxLifecycleStates;
    final ArrayList<String> mFragmentWhos;
    final int mIndex;
    final String mName;
    final int[] mOldMaxLifecycleStates;
    final int[] mOps;
    final boolean mReorderingAllowed;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;

    BackStackRecordState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mFragmentWhos = parcel.createStringArrayList();
        this.mOldMaxLifecycleStates = parcel.createIntArray();
        this.mCurrentMaxLifecycleStates = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
        boolean bl = parcel.readInt() != 0;
        this.mReorderingAllowed = bl;
    }

    BackStackRecordState(BackStackRecord backStackRecord) {
        int n = backStackRecord.mOps.size();
        this.mOps = new int[n * 6];
        if (backStackRecord.mAddToBackStack) {
            this.mFragmentWhos = new ArrayList(n);
            this.mOldMaxLifecycleStates = new int[n];
            this.mCurrentMaxLifecycleStates = new int[n];
            int n2 = 0;
            int n3 = 0;
            while (n3 < n) {
                FragmentTransaction.Op op = (FragmentTransaction.Op)backStackRecord.mOps.get(n3);
                Object object = this.mOps;
                int n4 = n2 + 1;
                object[n2] = op.mCmd;
                ArrayList<String> arrayList = this.mFragmentWhos;
                object = op.mFragment != null ? (Object)op.mFragment.mWho : null;
                arrayList.add((String)object);
                object = this.mOps;
                n2 = n4 + 1;
                object[n4] = op.mFromExpandedOp ? 1 : 0;
                object = this.mOps;
                n4 = n2 + 1;
                object[n2] = op.mEnterAnim;
                object = this.mOps;
                int n5 = n4 + 1;
                object[n4] = op.mExitAnim;
                object = this.mOps;
                n2 = n5 + 1;
                object[n5] = op.mPopEnterAnim;
                this.mOps[n2] = op.mPopExitAnim;
                this.mOldMaxLifecycleStates[n3] = op.mOldMaxState.ordinal();
                this.mCurrentMaxLifecycleStates[n3] = op.mCurrentMaxState.ordinal();
                ++n3;
                ++n2;
            }
            this.mTransition = backStackRecord.mTransition;
            this.mName = backStackRecord.mName;
            this.mIndex = backStackRecord.mIndex;
            this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
            this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
            this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
            this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
            this.mSharedElementSourceNames = backStackRecord.mSharedElementSourceNames;
            this.mSharedElementTargetNames = backStackRecord.mSharedElementTargetNames;
            this.mReorderingAllowed = backStackRecord.mReorderingAllowed;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    private void fillInBackStackRecord(BackStackRecord backStackRecord) {
        int n = 0;
        int n2 = 0;
        while (true) {
            int n3 = this.mOps.length;
            boolean bl = true;
            if (n >= n3) break;
            FragmentTransaction.Op op = new FragmentTransaction.Op();
            int[] nArray = this.mOps;
            n3 = n + 1;
            op.mCmd = nArray[n];
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v((String)TAG, (String)("Instantiate " + backStackRecord + " op #" + n2 + " base fragment #" + this.mOps[n3]));
            }
            op.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[n2]];
            op.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[n2]];
            nArray = this.mOps;
            int n4 = n3 + 1;
            if (nArray[n3] == 0) {
                bl = false;
            }
            op.mFromExpandedOp = bl;
            nArray = this.mOps;
            n = n4 + 1;
            op.mEnterAnim = nArray[n4];
            nArray = this.mOps;
            n3 = n + 1;
            op.mExitAnim = nArray[n];
            nArray = this.mOps;
            n = n3 + 1;
            op.mPopEnterAnim = nArray[n3];
            op.mPopExitAnim = this.mOps[n];
            backStackRecord.mEnterAnim = op.mEnterAnim;
            backStackRecord.mExitAnim = op.mExitAnim;
            backStackRecord.mPopEnterAnim = op.mPopEnterAnim;
            backStackRecord.mPopExitAnim = op.mPopExitAnim;
            backStackRecord.addOp(op);
            ++n2;
            ++n;
        }
        backStackRecord.mTransition = this.mTransition;
        backStackRecord.mName = this.mName;
        backStackRecord.mAddToBackStack = true;
        backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        backStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
        backStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
        backStackRecord.mReorderingAllowed = this.mReorderingAllowed;
    }

    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManager fragmentManager) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        this.fillInBackStackRecord(backStackRecord);
        backStackRecord.mIndex = this.mIndex;
        for (int i = 0; i < this.mFragmentWhos.size(); ++i) {
            String string2 = this.mFragmentWhos.get(i);
            if (string2 == null) continue;
            ((FragmentTransaction.Op)backStackRecord.mOps.get((int)i)).mFragment = fragmentManager.findActiveFragment(string2);
        }
        backStackRecord.bumpBackStackNesting(1);
        return backStackRecord;
    }

    public BackStackRecord instantiate(FragmentManager object, Map<String, Fragment> map2) {
        object = new BackStackRecord((FragmentManager)object);
        this.fillInBackStackRecord((BackStackRecord)object);
        for (int i = 0; i < this.mFragmentWhos.size(); ++i) {
            String string2 = this.mFragmentWhos.get(i);
            if (string2 == null) continue;
            Fragment fragment = map2.get(string2);
            if (fragment != null) {
                ((FragmentTransaction.Op)((BackStackRecord)object).mOps.get((int)i)).mFragment = fragment;
                continue;
            }
            throw new IllegalStateException("Restoring FragmentTransaction " + this.mName + " failed due to missing saved state for Fragment (" + string2 + ")");
        }
        return object;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeIntArray(this.mOps);
        parcel.writeStringList(this.mFragmentWhos);
        parcel.writeIntArray(this.mOldMaxLifecycleStates);
        parcel.writeIntArray(this.mCurrentMaxLifecycleStates);
        parcel.writeInt(this.mTransition);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel((CharSequence)this.mBreadCrumbTitleText, (Parcel)parcel, (int)0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel((CharSequence)this.mBreadCrumbShortTitleText, (Parcel)parcel, (int)0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
        parcel.writeInt(this.mReorderingAllowed ? 1 : 0);
    }
}

