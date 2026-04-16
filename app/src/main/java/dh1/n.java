package dh1;

import az1.b2;
import m10.j0;
import st1.t1;
import vu0.d;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class n implements d {
    public static final m Companion = new m();
    public final String a;
    public final String b;
    public final j0 c;

    public /* synthetic */ n(int i, String str, String str2, j0 j0Var) {
        if (3 != (i & 3)) {
            b2.b(i, 3, l.a.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = j0Var;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, nVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, nVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, nVar.c);
    }

    public final String getId() {
        return this.a;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        j0 j0Var = this.c;
        return iHashCode2 + (j0Var != null ? j0Var.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbJ = p.j("InspiredArtist(id=", this.a, ", name=", this.b, ", pictureFromApi=");
        sbJ.append(this.c);
        sbJ.append(")");
        return sbJ.toString();
    }

    public final j0 y() {
        j0.Companion.getClass();
        j0 j0Var = this.c;
        if (j0Var == null) {
            return null;
        }
        return t1.D(j0Var.e()) ? j0.b(j0Var, Boolean.TRUE) : (j0Var.d == null && j0Var.e == null && j0Var.f == null && j0Var.g == null) ? j0Var : j0.b(j0Var, Boolean.FALSE);
    }

    public n(String str, String str2, j0 j0Var) {
        lmjxuqdtp.jvm.internal.o.h(str, "id");
        this.a = str;
        this.b = str2;
        this.c = j0Var;
    }
}
