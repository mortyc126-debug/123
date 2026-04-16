package q10;

import hs1.d;
import lx1.j;
import ow.a;
import wy1.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@f
public final class v extends i0 {
    public static final v INSTANCE = new v();
    public static final /* synthetic */ Object b = d.E(j.a, new a(23));

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof v);
    }

    public final int hashCode() {
        return 152710532;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, lx1.h] */
    public final wy1.a serializer() {
        return (wy1.a) b.getValue();
    }

    public final String toString() {
        return "PeopleToFollow";
    }
}
