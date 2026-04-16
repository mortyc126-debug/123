package jp1;

import amuvvoafs.os.Parcel;
import amuvvoafs.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends up1.a {
    public static final Parcelable.Creator<e0> CREATOR = new com.facebook.a(17);
    public final int a;

    public e0(int i) {
        this.a = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int iJ0 = com.facebook.appevents.h.j0(20293, parcel);
        com.facebook.appevents.h.i0(parcel, 2, 4);
        parcel.writeInt(this.a);
        com.facebook.appevents.h.k0(iJ0, parcel);
    }
}
