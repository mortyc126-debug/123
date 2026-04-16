/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.BackStackRecordState;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BackStackState
implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>(){

        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public BackStackState[] newArray(int n) {
            return new BackStackState[n];
        }
    };
    final List<String> mFragments;
    final List<BackStackRecordState> mTransactions;

    BackStackState(Parcel parcel) {
        this.mFragments = parcel.createStringArrayList();
        this.mTransactions = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    BackStackState(List<String> list, List<BackStackRecordState> list2) {
        this.mFragments = list;
        this.mTransactions = list2;
    }

    public int describeContents() {
        return 0;
    }

    List<BackStackRecord> instantiate(FragmentManager fragmentManager, Map<String, Fragment> object) {
        HashMap<String, Fragment> hashMap = new HashMap<String, Fragment>(this.mFragments.size());
        for (String string2 : this.mFragments) {
            Fragment fragment = (Fragment)object.get(string2);
            if (fragment != null) {
                hashMap.put(fragment.mWho, fragment);
                continue;
            }
            FragmentState fragmentState = fragmentManager.getFragmentStore().setSavedState(string2, null);
            if (fragmentState == null) continue;
            Fragment fragment2 = fragmentState.instantiate(fragmentManager.getFragmentFactory(), fragmentManager.getHost().getContext().getClassLoader());
            hashMap.put(fragment2.mWho, fragment2);
        }
        ArrayList arrayList = new ArrayList();
        object = this.mTransactions.iterator();
        while (object.hasNext()) {
            arrayList.add(object.next().instantiate(fragmentManager, hashMap));
        }
        return arrayList;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeStringList(this.mFragments);
        parcel.writeTypedList(this.mTransactions);
    }
}

