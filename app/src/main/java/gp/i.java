package gp;

import az1.b2;
import hs1.d;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class i implements j {
    public static final h Companion = new h();
    public static final lx1.h[] b = {d.E(lx1.j.a, new f(0))};
    public final o0 a;

    public /* synthetic */ i(int i, o0 o0Var) {
        if (1 == (i & 1)) {
            this.a = o0Var;
        } else {
            b2.b(i, 1, g.a.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && o.c(this.a, ((i) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Redirect(startDestination=" + this.a + ")";
    }

    public i(o0 o0Var) {
        o.h(o0Var, "startDestination");
        this.a = o0Var;
    }
}
