package wg0;

import az1.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class j implements a0 {
    public static final i Companion = new i();
    public static final lx1.h[] c = {hs1.d.E(lx1.j.a, new vq0.j(15)), null};
    public final x10.v a;
    public final boolean b;

    public /* synthetic */ j(int i, x10.v vVar, boolean z) {
        if (3 != (i & 3)) {
            b2.b(i, 3, h.a.getDescriptor());
            throw null;
        }
        this.a = vVar;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, jVar.a) && this.b == jVar.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Error(message=" + this.a + ", canRetry=" + this.b + ")";
    }

    public j(x10.v vVar, boolean z) {
        lmjxuqdtp.jvm.internal.o.h(vVar, "message");
        this.a = vVar;
        this.b = z;
    }
}
