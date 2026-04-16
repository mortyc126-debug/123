package oz0;

import aj.a;
import az1.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class h {
    public static final g Companion = new g();
    public final Long a;
    public final Long b;
    public final Integer c;

    public /* synthetic */ h(int i, Long l, Long l2, Integer num) {
        if (7 != (i & 7)) {
            b2.b(i, 7, f.a.getDescriptor());
            throw null;
        }
        this.a = l;
        this.b = l2;
        this.c = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, hVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, hVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, hVar.c);
    }

    public final int hashCode() {
        Long l = this.a;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.b;
        int iHashCode2 = (iHashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num = this.c;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Counters(likes=");
        sb.append(this.a);
        sb.append(", comments=");
        sb.append(this.b);
        sb.append(", posts=");
        return jn1.r.n(sb, this.c, ")");
    }
}
