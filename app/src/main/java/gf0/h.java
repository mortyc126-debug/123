package gf0;

import lmjxuqdtp.jvm.internal.o;
import s1.a;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends j {
    public final String a;
    public final String b;
    public final String c;

    public h(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return o.c(this.a, hVar.a) && o.c(this.b, hVar.b) && o.c(this.c, hVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + a.d(this.a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        return i.p(p.j("Device(product=", this.a, ", name=", this.b, ", ver="), this.c, ")");
    }
}
