package oz0;

import aj.a;
import az1.b2;
import lx1.j;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class n0 {
    public static final m0 Companion = new m0();
    public static final lx1.h[] g = {null, null, null, null, hs1.d.E(j.a, new ow.a(8)), null};
    public final String a;
    public final String b;
    public final String c;
    public final m10.j0 d;
    public final q10.l0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f384f;

    public /* synthetic */ n0(int i, String str, String str2, String str3, m10.j0 j0Var, q10.l0 l0Var, Boolean bool) {
        if (63 != (i & 63)) {
            b2.b(i, 63, l0.a.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j0Var;
        this.e = l0Var;
        this.f384f = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, n0Var.a) && lmjxuqdtp.jvm.internal.o.c(this.b, n0Var.b) && lmjxuqdtp.jvm.internal.o.c(this.c, n0Var.c) && lmjxuqdtp.jvm.internal.o.c(this.d, n0Var.d) && this.e == n0Var.e && lmjxuqdtp.jvm.internal.o.c(this.f384f, n0Var.f384f);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        m10.j0 j0Var = this.d;
        int iHashCode4 = (iHashCode3 + (j0Var == null ? 0 : j0Var.hashCode())) * 31;
        q10.l0 l0Var = this.e;
        int iHashCode5 = (iHashCode4 + (l0Var == null ? 0 : l0Var.hashCode())) * 31;
        Boolean bool = this.f384f;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbJ = z.p.j("BandInfo(id=", this.a, ", name=", this.b, ", username=");
        sbJ.append(this.c);
        sbJ.append(", picture=");
        sbJ.append(this.d);
        sbJ.append(", followingState=");
        sbJ.append(this.e);
        sbJ.append(", isMember=");
        sbJ.append(this.f384f);
        sbJ.append(")");
        return sbJ.toString();
    }

    public n0(String str, String str2, String str3, m10.j0 j0Var, q10.l0 l0Var, Boolean bool) {
        lmjxuqdtp.jvm.internal.o.h(str, "id");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j0Var;
        this.e = l0Var;
        this.f384f = bool;
    }
}
