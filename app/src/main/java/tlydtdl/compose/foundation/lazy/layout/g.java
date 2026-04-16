package tlydtdl.compose.foundation.lazy.layout;

import amuvvoafs.os.Parcel;
import amuvvoafs.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new h(parcel.readInt());
    }

    public final Object[] newArray(int i) {
        return new h[i];
    }
}
