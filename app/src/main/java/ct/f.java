package ct;

import lmjxuqdtp.jvm.internal.o;
import oz0.d1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public final d1 a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    public f(d1 d1Var, boolean z, boolean z2, boolean z3) {
        this.a = d1Var;
        this.b = z;
        this.c = z2;
        this.d = z3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return o.c(this.a, fVar.a) && this.b == fVar.b && this.c == fVar.c && this.d == fVar.d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.d) + s1.a.f(s1.a.f(this.a.hashCode() * 31, 31, this.b), 31, this.c);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PostModel(post=");
        sb.append(this.a);
        sb.append(", isFirst=");
        sb.append(this.b);
        sb.append(", isRecent=");
        return o6.c.q(sb, this.c, ", isNativeAd=", this.d, ")");
    }
}
