package gg;

import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.Map;
import lx1.l;
import mx1.u;
import mx1.z;
import org.apache.http.HttpHeaders;
import s1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final Object d = z.T(new l[]{new l("Content-Type", "application/json; charset=utf-8"), new l(HttpHeaders.ACCEPT, "application/json")});
    public final String a;
    public final Map b;
    public final String c;

    public d(String str, String str2) {
        c cVar = c.a;
        this.a = str;
        this.b = u.a;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.a.equals(dVar.a)) {
            return false;
        }
        c cVar = c.a;
        return this.b.equals(dVar.b) && this.c.equals(dVar.c);
    }

    public final int hashCode() {
        return Integer.hashCode(20000) + a.c(15000, a.d(a0.c((c.a.hashCode() + (this.a.hashCode() * 31)) * 31, this.b, 31), 31, this.c), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request(url=");
        sb.append(this.a);
        sb.append(", method=");
        sb.append(c.a);
        sb.append(", headers=");
        sb.append(this.b);
        sb.append(", body=");
        return i.p(sb, this.c, ", connectTimeoutMs=15000, readTimeoutMs=20000)");
    }
}
