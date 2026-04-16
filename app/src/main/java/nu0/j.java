package nu0;

import f3.f2;
import java.util.Iterator;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;
import x10.r;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements k {
    public final dg1.d a;
    public final v b;
    public final boolean c;
    public final v d;
    public final boolean e;

    public j(dg1.g gVar, v vVar, boolean z, v vVar2, boolean z2) {
        this.a = gVar;
        this.b = vVar;
        this.c = z;
        this.d = vVar2;
        this.e = z2;
        List listC = ct1.b.C(new Object[]{gVar, vVar});
        if (!listC.isEmpty()) {
            Iterator it = listC.iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    v vVar3 = this.b;
                    if (vVar3 != null && !bn1.c.z(vVar3)) {
                        throw new IllegalStateException("Check failed.");
                    }
                    return;
                }
            }
        }
        throw new IllegalStateException("Check failed.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return o.c(this.a, jVar.a) && o.c(this.b, jVar.b) && this.c == jVar.c && o.c(this.d, jVar.d) && this.e == jVar.e;
    }

    public final int hashCode() {
        dg1.d dVar = this.a;
        int iHashCode = (dVar == null ? 0 : dVar.hashCode()) * 31;
        v vVar = this.b;
        int iF = s1.a.f((iHashCode + (vVar == null ? 0 : vVar.hashCode())) * 31, 31, this.c);
        v vVar2 = this.d;
        return Boolean.hashCode(this.e) + ((iF + (vVar2 != null ? vVar2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Toggle(icon=");
        sb.append(this.a);
        sb.append(", text=");
        sb.append(this.b);
        sb.append(", selected=");
        sb.append(this.c);
        sb.append(", iconDescription=");
        sb.append(this.d);
        sb.append(", enabled=");
        return f2.o(sb, this.e, ")");
    }

    public /* synthetic */ j(dg1.g gVar, boolean z, r rVar, int i) {
        this(gVar, null, z, (i & 8) != 0 ? null : rVar, true);
    }
}
