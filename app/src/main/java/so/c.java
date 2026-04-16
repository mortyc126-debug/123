package so;

import az1.b2;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true)
public final class c {
    public static final b Companion = new b();
    public final Long a;
    public final String b;

    public /* synthetic */ c(int i, Long l, String str) {
        if (3 != (i & 3)) {
            b2.b(i, 3, a.a.getDescriptor());
            throw null;
        }
        this.a = l;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return o.c(this.a, cVar.a) && o.c(this.b, cVar.b);
    }

    public final int hashCode() {
        Long l = this.a;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "AuthPayload(iat=" + this.a + ", sub=" + this.b + ")";
    }
}
