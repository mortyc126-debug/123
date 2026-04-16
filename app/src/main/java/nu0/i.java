package nu0;

import f3.f2;
import x10.r;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements k {
    public final dg1.g a;
    public final r b;
    public final boolean c;

    public i(dg1.g gVar, r rVar, boolean z) {
        this.a = gVar;
        this.b = rVar;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.a.equals(iVar.a) && this.b.equals(iVar.b) && this.c == iVar.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + s1.a.c(this.b.e, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Click(icon=");
        sb.append(this.a);
        sb.append(", contentDescription=");
        sb.append(this.b);
        sb.append(", enabled=");
        return f2.o(sb, this.c, ")");
    }
}
