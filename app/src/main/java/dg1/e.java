package dg1;

import f3.f2;
import lmjxuqdtp.jvm.internal.o;
import m10.j0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements f {
    public final j0 b;
    public final d c;
    public final boolean d;

    public e(j0 j0Var, d dVar, boolean z) {
        o.h(dVar, "placeholder");
        this.b = j0Var;
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
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return o.c(this.b, eVar.b) && o.c(this.c, eVar.c) && this.d == eVar.d;
    }

    public final int hashCode() {
        j0 j0Var = this.b;
        return Boolean.hashCode(this.d) + ((this.c.hashCode() + ((j0Var == null ? 0 : j0Var.hashCode()) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Picture(picture=");
        sb.append(this.b);
        sb.append(", placeholder=");
        sb.append(this.c);
        sb.append(", notTintable=");
        return f2.o(sb, this.d, ")");
    }
}
