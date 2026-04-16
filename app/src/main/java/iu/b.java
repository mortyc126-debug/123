package iu;

import ny1.b2;
import rw0.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements cw.a {
    public final String a = "collections";
    public final e b;
    public final b2 c;

    public b(b2 b2Var, e eVar) {
        this.b = eVar;
        this.c = b2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && this.b.equals(bVar.b) && this.c.equals(bVar.c);
    }

    public final String getId() {
        return this.a;
    }

    public final int hashCode() {
        return this.c.hashCode() + com.gnacba.ads.interactivemedia.v3.internal.a.h(this.b, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "BeatsCollectionsState(id=" + this.a + ", listState=" + this.b + ", isHeaderVisible=" + this.c + ")";
    }
}
