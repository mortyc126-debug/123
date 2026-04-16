package ip1;

import amuvvoafs.os.Parcel;
import amuvvoafs.os.Parcelable;
import amuvvoafs.text.TextUtils;
import com.facebook.appevents.h;
import f3.f2;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;
import up1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends a {
    public static final Parcelable.Creator<j> CREATOR = new com.facebook.a(15);
    public final boolean a;
    public final String b;
    public final boolean c;
    public final i d;

    public j(boolean z, String str, boolean z2, i iVar) {
        this.a = z;
        this.b = str;
        this.c = z2;
        this.d = iVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.a == jVar.a && op1.a.d(this.b, jVar.b) && this.c == jVar.c && op1.a.d(this.d, jVar.d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.a), this.b, Boolean.valueOf(this.c), this.d});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LaunchOptions(relaunchIfRunning=");
        sb.append(this.a);
        sb.append(", language=");
        sb.append(this.b);
        sb.append(", androidReceiverCompatible: ");
        return f2.o(sb, this.c, ")");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int iJ0 = h.j0(20293, parcel);
        h.i0(parcel, 2, 4);
        parcel.writeInt(this.a ? 1 : 0);
        h.d0(parcel, 3, this.b);
        h.i0(parcel, 4, 4);
        parcel.writeInt(this.c ? 1 : 0);
        h.c0(parcel, 5, this.d, i);
        h.k0(iJ0, parcel);
    }

    public j() {
        Locale locale = Locale.getDefault();
        Pattern pattern = op1.a.a;
        StringBuilder sb = new StringBuilder(20);
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (!TextUtils.isEmpty(country)) {
            sb.append('-');
            sb.append(country);
        }
        String variant = locale.getVariant();
        if (!TextUtils.isEmpty(variant)) {
            sb.append('-');
            sb.append(variant);
        }
        this(false, sb.toString(), false, null);
    }
}
