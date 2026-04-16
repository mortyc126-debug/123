package mf1;

import dg1.d;
import dg1.g;
import lmjxuqdtp.jvm.internal.o;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public final v a;
    public final d b;
    public final Long c;
    public final boolean d;

    public l(v vVar, g gVar, Long l, boolean z, int i) {
        gVar = (i & 2) != 0 ? null : gVar;
        l = (i & 4) != 0 ? null : l;
        z = (i & 8) != 0 ? false : z;
        this.a = vVar;
        this.b = gVar;
        this.c = l;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return o.c(this.a, lVar.a) && o.c(this.b, lVar.b) && o.c(this.c, lVar.c) && this.d == lVar.d;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        d dVar = this.b;
        int iHashCode2 = (iHashCode + (dVar == null ? 0 : dVar.hashCode())) * 31;
        Long l = this.c;
        return Boolean.hashCode(this.d) + ((iHashCode2 + (l != null ? l.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "TabState(text=" + this.a + ", icon=" + this.b + ", counter=" + this.c + ", showNotificationDot=" + this.d + ")";
    }
}
