package gg;

import java.util.Map;
import jn1.r;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final int a;
    public final String b;
    public final Object c;
    public final String d;

    public e(int i, String str, Map map, String str2) {
        this.a = i;
        this.b = str;
        this.c = map;
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && o.c(this.b, eVar.b) && this.c.equals(eVar.c) && o.c(this.d, eVar.d);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        int i = r.i((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.c);
        String str2 = this.d;
        return i + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Response(statusCode=");
        sb.append(this.a);
        sb.append(", body=");
        sb.append(this.b);
        sb.append(", headers=");
        sb.append(this.c);
        sb.append(", statusMessage=");
        return i.o(sb, this.d, ')');
    }
}
