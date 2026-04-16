package xp;

import az1.b2;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;
import lx1.h;
import lx1.j;
import mx1.t;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class d {
    public static final c Companion = new c();
    public static final h[] c = {hs1.d.E(j.a, new x1.a(26)), null};
    public final List a;
    public final Integer b;

    public d() {
        this.a = t.a;
        this.b = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return o.c(this.a, dVar.a) && o.c(this.b, dVar.b);
    }

    public final int hashCode() {
        List list = this.a;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.b;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        return "AgeRestrictionRequirement(requirements=" + this.a + ", ageLimit=" + this.b + ")";
    }

    public /* synthetic */ d(int i, Integer num, List list) {
        if (3 != (i & 3)) {
            b2.b(i, 3, b.a.getDescriptor());
            throw null;
        }
        this.a = list;
        this.b = num;
    }
}
