package gp;

import az1.b2;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class e implements j {
    public static final d Companion = new d();
    public final bp.g a;

    public /* synthetic */ e(int i, bp.g gVar) {
        if (1 == (i & 1)) {
            this.a = gVar;
        } else {
            b2.b(i, 1, c.a.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && o.c(this.a, ((e) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Login(authRequest=" + this.a + ")";
    }

    public e(bp.g gVar) {
        this.a = gVar;
    }
}
