package po1;

import jn1.r;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final int a;
    public final long b;

    public a(int i, long j2) {
        if (i == 0) {
            throw new NullPointerException("Null status");
        }
        this.a = i;
        this.b = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return p.b(this.a, aVar.a) && this.b == aVar.b;
    }

    public final int hashCode() {
        int iK = (p.k(this.a) ^ 1000003) * 1000003;
        long j2 = this.b;
        return iK ^ ((int) ((j2 >>> 32) ^ j2));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        sb.append(r.F(this.a));
        sb.append(", nextRequestWaitMillis=");
        return i.i(this.b, "}", sb);
    }
}
