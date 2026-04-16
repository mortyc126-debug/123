package ij;

import java.util.List;
import java.util.Set;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements s {
    public final List a;
    public final Set b;
    public final t c;

    public p(List list, Set set, t tVar) {
        o.h(list, "points");
        o.h(set, "selectedPoints");
        this.a = list;
        this.b = set;
        this.c = tVar;
        if (list.isEmpty()) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return o.c(this.a, pVar.a) && o.c(this.b, pVar.b) && o.c(this.c, pVar.c);
    }

    public final int hashCode() {
        int iL = bh.j.l(this.b, this.a.hashCode() * 31, 31);
        t tVar = this.c;
        return iL + (tVar == null ? 0 : tVar.hashCode());
    }

    public final String toString() {
        return "Automation(points=" + this.a + ", selectedPoints=" + this.b + ", movingPointsUiState=" + this.c + ")";
    }
}
