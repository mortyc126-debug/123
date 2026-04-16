package dg1;

import f3.f2;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements f {
    public final String b;
    public final d c;
    public final boolean d;

    public h(String str, d dVar, boolean z) {
        o.h(dVar, "placeholder");
        this.b = str;
        this.c = dVar;
        this.d = z;
    }

    @Override // dg1.i
    public final boolean a() {
        return this.d;
    }

    @Override // dg1.f
    public final d b() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return o.c(this.b, hVar.b) && o.c(this.c, hVar.c) && this.d == hVar.d;
    }

    public final int hashCode() {
        String str = this.b;
        return Boolean.hashCode(this.d) + ((this.c.hashCode() + ((str == null ? 0 : str.hashCode()) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Url(url=");
        sb.append(this.b);
        sb.append(", placeholder=");
        sb.append(this.c);
        sb.append(", notTintable=");
        return f2.o(sb, this.d, ")");
    }
}
