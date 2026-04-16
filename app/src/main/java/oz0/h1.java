package oz0;

import aj.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class h1 {
    public static final g1 Companion = new g1();
    public final long a;
    public final long b;
    public final Long c;
    public final long d;

    public /* synthetic */ h1(int i, long j2, long j3, Long l, long j4) {
        if ((i & 1) == 0) {
            this.a = 0L;
        } else {
            this.a = j2;
        }
        if ((i & 2) == 0) {
            this.b = 0L;
        } else {
            this.b = j3;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = l;
        }
        if ((i & 8) == 0) {
            this.d = 0L;
        } else {
            this.d = j4;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h1)) {
            return false;
        }
        h1 h1Var = (h1) obj;
        return this.a == h1Var.a && this.b == h1Var.b && lmjxuqdtp.jvm.internal.o.c(this.c, h1Var.c) && this.d == h1Var.d;
    }

    public final int hashCode() {
        int iG = s1.a.g(Long.hashCode(this.a) * 31, this.b, 31);
        Long l = this.c;
        return Long.hashCode(this.d) + ((iG + (l == null ? 0 : l.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder sbM = s1.a.m(this.a, "PostCounters(likes=", ", comments=");
        sbM.append(this.b);
        sbM.append(", plays=");
        sbM.append(this.c);
        sbM.append(", reactions=");
        sbM.append(this.d);
        sbM.append(")");
        return sbM.toString();
    }
}
