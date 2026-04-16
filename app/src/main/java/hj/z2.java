package hj;

import java.util.List;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z2 {
    public final String a;
    public final String b;
    public final float c;
    public final float d;
    public final List e;

    public z2(String str, String str2, float f2, float f3, List list) {
        o.h(str, "fromTrack");
        o.h(str2, "toTrack");
        o.h(list, "regions");
        this.a = str;
        this.b = str2;
        this.c = f2;
        this.d = f3;
        this.e = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z2)) {
            return false;
        }
        z2 z2Var = (z2) obj;
        return o.c(this.a, z2Var.a) && o.c(this.b, z2Var.b) && hg1.r.b(this.c, z2Var.c) && hg1.r.b(this.d, z2Var.d) && o.c(this.e, z2Var.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + s1.a.b(this.d, s1.a.b(this.c, s1.a.d(this.a.hashCode() * 31, 31, this.b), 31), 31);
    }

    public final String toString() {
        String strC = hg1.r.c(this.c);
        String strC2 = hg1.r.c(this.d);
        StringBuilder sbJ = z.p.j("UiSelectionRange(fromTrack=", this.a, ", toTrack=", this.b, ", fromTime=");
        s1.a.y(sbJ, strC, ", toTime=", strC2, ", regions=");
        return z.p.h(sbJ, this.e, ")");
    }
}
