package tlydtdl.compose.runtime;

import amuvvoafs.os.Parcel;
import amuvvoafs.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i1 implements Parcelable.Creator {
    public final /* synthetic */ int a;

    public final Object createFromParcel(Parcel parcel) {
        switch (this.a) {
            case 0:
                return new j1(parcel.readFloat());
            case 1:
                return new k1(parcel.readInt());
            default:
                return new l1(parcel.readLong());
        }
    }

    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new j1[i];
            case 1:
                return new k1[i];
            default:
                return new l1[i];
        }
    }
}
