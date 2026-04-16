package l8;

import amuvvoafs.os.Bundle;
import com.gnacba.common.collect.f1;
import java.util.ArrayList;
import java.util.Arrays;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Http2;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f301f;
    public static final String g;
    public final int a;
    public final String b;
    public final int c;
    public final s[] d;
    public int e;

    static {
        int i = o8.f0.a;
        f301f = Integer.toString(0, 36);
        g = Integer.toString(1, 36);
    }

    public l1(String str, s... sVarArr) {
        o8.b.c(sVarArr.length > 0);
        this.b = str;
        this.d = sVarArr;
        this.a = sVarArr.length;
        int iH = q0.h(sVarArr[0].n);
        this.c = iH == -1 ? q0.h(sVarArr[0].m) : iH;
        String str2 = sVarArr[0].d;
        str2 = (str2 == null || str2.equals("und")) ? HttpUrl.FRAGMENT_ENCODE_SET : str2;
        int i = sVarArr[0].f | Http2.INITIAL_MAX_FRAME_SIZE;
        for (int i2 = 1; i2 < sVarArr.length; i2++) {
            String str3 = sVarArr[i2].d;
            if (!str2.equals((str3 == null || str3.equals("und")) ? HttpUrl.FRAGMENT_ENCODE_SET : str3)) {
                c(i2, "languages", sVarArr[0].d, sVarArr[i2].d);
                return;
            } else {
                if (i != (sVarArr[i2].f | Http2.INITIAL_MAX_FRAME_SIZE)) {
                    c(i2, "role flags", Integer.toBinaryString(sVarArr[0].f), Integer.toBinaryString(sVarArr[i2].f));
                    return;
                }
            }
        }
    }

    public static l1 a(Bundle bundle) {
        f1 f1VarS;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f301f);
        if (parcelableArrayList == null) {
            com.gnacba.common.collect.h0 h0Var = com.gnacba.common.collect.k0.b;
            f1VarS = f1.e;
        } else {
            f1VarS = o8.d.s(parcelableArrayList, new k(8));
        }
        return new l1(bundle.getString(g, HttpUrl.FRAGMENT_ENCODE_SET), (s[]) f1VarS.toArray(new s[0]));
    }

    public static void c(int i, String str, String str2, String str3) {
        StringBuilder sbJ = p.j("Different ", str, " combined in one TrackGroup: '", str2, "' (track 0) and '");
        sbJ.append(str3);
        sbJ.append("' (track ");
        sbJ.append(i);
        sbJ.append(")");
        o8.b.n("TrackGroup", HttpUrl.FRAGMENT_ENCODE_SET, new IllegalStateException(sbJ.toString()));
    }

    public final int b(s sVar) {
        int i = 0;
        while (true) {
            s[] sVarArr = this.d;
            if (i >= sVarArr.length) {
                return -1;
            }
            if (sVar == sVarArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final Bundle d() {
        Bundle bundle = new Bundle();
        s[] sVarArr = this.d;
        ArrayList arrayList = new ArrayList(sVarArr.length);
        for (s sVar : sVarArr) {
            arrayList.add(sVar.c());
        }
        bundle.putParcelableArrayList(f301f, arrayList);
        bundle.putString(g, this.b);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l1.class == obj.getClass()) {
            l1 l1Var = (l1) obj;
            if (this.b.equals(l1Var.b) && Arrays.equals(this.d, l1Var.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.e == 0) {
            this.e = Arrays.hashCode(this.d) + s1.a.d(527, 31, this.b);
        }
        return this.e;
    }

    public final String toString() {
        return this.b + ": " + Arrays.toString(this.d);
    }
}
