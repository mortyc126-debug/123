package dh1;

import d81.l0;
import hs1.d;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class c {
    public static final b Companion = new b();
    public static final lx1.h[] e;
    public final List a;
    public final List b;
    public final List c;
    public final f d;

    static {
        lx1.j jVar = lx1.j.a;
        e = new lx1.h[]{d.E(jVar, new l0(8)), d.E(jVar, new l0(9)), d.E(jVar, new l0(10)), null};
    }

    public /* synthetic */ c(int i, List list, List list2, List list3, f fVar) {
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = list;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = list2;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = list3;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = fVar;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, cVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, cVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, cVar.c) && lmjxuqdtp.jvm.internal.o.c(this.d, cVar.d);
    }

    public final int hashCode() {
        List list = this.a;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List list2 = this.b;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List list3 = this.c;
        int iHashCode3 = (iHashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        f fVar = this.d;
        return iHashCode3 + (fVar != null ? fVar.hashCode() : 0);
    }

    public final String toString() {
        return "CollabPreferencesLookingFor(skills=" + this.a + ", genres=" + this.b + ", inspiredBy=" + this.c + ", place=" + this.d + ")";
    }
}
