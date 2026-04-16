package lx0;

import hs1.d;
import lx1.j;
import wy1.a;
import wy1.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@f
public final class n extends u {
    public static final n INSTANCE = new n();
    public static final /* synthetic */ Object b = d.E(j.a, new ls0.t(4));

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof n);
    }

    public final int hashCode() {
        return 1696108022;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, lx1.h] */
    public final a serializer() {
        return (a) b.getValue();
    }

    public final String toString() {
        return "Misc";
    }
}
