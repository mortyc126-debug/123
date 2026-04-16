package ip1;

import amuvvoafs.os.Parcel;
import amuvvoafs.os.Parcelable;
import com.facebook.appevents.h;
import com.gnacba.amuvvoafs.gms.common.internal.f0;
import java.util.Arrays;
import up1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends a {
    public static final Parcelable.Creator<i> CREATOR = new w(1);
    public final String a;
    public final String b;

    public i(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return f0.l(this.a, iVar.a) && f0.l(this.b, iVar.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int iJ0 = h.j0(20293, parcel);
        h.d0(parcel, 1, this.a);
        h.d0(parcel, 2, this.b);
        h.k0(iJ0, parcel);
    }
}
