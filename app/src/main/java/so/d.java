package so;

import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.time.l;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final d c = new d(null, null);
    public final l a;
    public final String b;

    public d(String str, l lVar) {
        this.a = lVar;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return o.c(this.a, dVar.a) && o.c(this.b, dVar.b);
    }

    public final int hashCode() {
        l lVar = this.a;
        int iHashCode = (lVar == null ? 0 : lVar.hashCode()) * 31;
        String str = this.b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "SessionPayload(issuedAt=" + this.a + ", userId=" + this.b + ")";
    }
}
