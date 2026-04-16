package fu;

import az1.b2;
import hs1.d;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;
import lx1.h;
import lx1.j;
import m10.j0;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true)
public final class c {
    public static final b Companion = new b();
    public static final h[] h = {null, null, null, null, null, d.E(j.a, new fl1.a(8)), null};
    public final String a;
    public final String b;
    public final String c;
    public final j0 d;
    public final Integer e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f134f;
    public final Boolean g;

    public /* synthetic */ c(int i, String str, String str2, String str3, j0 j0Var, Integer num, List list, Boolean bool) {
        if (127 != (i & 127)) {
            b2.b(i, 127, a.a.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j0Var;
        this.e = num;
        this.f134f = list;
        this.g = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return o.c(this.a, cVar.a) && o.c(this.b, cVar.b) && o.c(this.c, cVar.c) && o.c(this.d, cVar.d) && o.c(this.e, cVar.e) && o.c(this.f134f, cVar.f134f) && o.c(this.g, cVar.g);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        j0 j0Var = this.d;
        int iHashCode4 = (iHashCode3 + (j0Var == null ? 0 : j0Var.hashCode())) * 31;
        Integer num = this.e;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        List list = this.f134f;
        int iHashCode6 = (iHashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.g;
        return iHashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbJ = p.j("BeatsCollection(id=", this.a, ", name=", this.b, ", description=");
        sbJ.append(this.c);
        sbJ.append(", picture=");
        sbJ.append(this.d);
        sbJ.append(", beatsCount=");
        sbJ.append(this.e);
        sbJ.append(", beats=");
        sbJ.append(this.f134f);
        sbJ.append(", hasBeatsOnSale=");
        sbJ.append(this.g);
        sbJ.append(")");
        return sbJ.toString();
    }
}
