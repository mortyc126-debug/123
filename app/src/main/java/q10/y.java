package q10;

import az1.b2;
import hs1.d;
import lx1.h;
import lx1.j;
import o10.a4;
import ow.a;
import wy1.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@f
public final class y extends i0 {
    public static final x Companion = new x();
    public static final h[] c = {d.E(j.a, new a(24))};
    public final a4 b;

    public /* synthetic */ y(int i, a4 a4Var) {
        if (1 == (i & 1)) {
            this.b = a4Var;
        } else {
            b2.b(i, 1, w.a.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof y) && this.b == ((y) obj).b;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "Post(source=" + this.b + ")";
    }

    public y(a4 a4Var) {
        lmjxuqdtp.jvm.internal.o.h(a4Var, "source");
        this.b = a4Var;
    }
}
