package jp1;

import amuvvoafs.os.Parcel;
import amuvvoafs.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends up1.a {
    public static final Parcelable.Creator<d0> CREATOR = new com.facebook.a(16);
    public final boolean a;

    public d0(boolean z) {
        this.a = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int iJ0 = com.facebook.appevents.h.j0(20293, parcel);
        com.facebook.appevents.h.i0(parcel, 2, 4);
        parcel.writeInt(this.a ? 1 : 0);
        com.facebook.appevents.h.k0(iJ0, parcel);
    }
}
