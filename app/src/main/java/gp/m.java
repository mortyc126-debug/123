package gp;

import az1.b2;
import f3.f2;
import hs1.d;
import lmjxuqdtp.jvm.internal.o;
import s1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class m {
    public static final l Companion = new l();
    public static final lx1.h[] d = {d.E(lx1.j.a, new f(1)), null, null};
    public final j a;
    public final boolean b;
    public final boolean c;

    public /* synthetic */ m(int i, j jVar, boolean z, boolean z2) {
        if (1 != (i & 1)) {
            b2.b(i, 1, k.a.getDescriptor());
            throw null;
        }
        this.a = jVar;
        if ((i & 2) == 0) {
            this.b = false;
        } else {
            this.b = z;
        }
        if ((i & 4) == 0) {
            this.c = true;
        } else {
            this.c = z2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return o.c(this.a, mVar.a) && this.b == mVar.b && this.c == mVar.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + a.f(this.a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Params(action=");
        sb.append(this.a);
        sb.append(", sessionExpired=");
        sb.append(this.b);
        sb.append(", showOneTapOnInit=");
        return f2.o(sb, this.c, ")");
    }

    public m(j jVar, boolean z, boolean z2) {
        this.a = jVar;
        this.b = z;
        this.c = z2;
    }
}
