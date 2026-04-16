package gp;

import bv0.a;
import hs1.d;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class e0 implements o0 {
    public static final e0 INSTANCE = new e0();
    public static final Set a = di0.z.V(a.a);
    public static final /* synthetic */ Object b = d.E(lx1.j.a, new f(3));

    public final Set b() {
        return a;
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof e0);
    }

    public final int hashCode() {
        return 1296438736;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, lx1.h] */
    public final wy1.a serializer() {
        return (wy1.a) b.getValue();
    }

    public final String toString() {
        return "ErrorScreen";
    }
}
