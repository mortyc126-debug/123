package wg0;

import az1.b2;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class x {
    public static final t Companion = new t();
    public static final lx1.h[] c = {hs1.d.E(lx1.j.a, new vb.z(15)), null};
    public final List a;
    public final boolean b;

    public /* synthetic */ x(int i, boolean z, List list) {
        if (3 != (i & 3)) {
            b2.b(i, 3, s.a.getDescriptor());
            throw null;
        }
        this.a = list;
        this.b = z;
    }

    public static x a(x xVar, boolean z) {
        List list = xVar.a;
        xVar.getClass();
        lmjxuqdtp.jvm.internal.o.h(list, "voices");
        return new x(list, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, xVar.a) && this.b == xVar.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "VoicesGenericPreview(voices=" + this.a + ", isDisplayed=" + this.b + ")";
    }

    public x(List list, boolean z) {
        this.a = list;
        this.b = z;
    }
}
