package v2;

import d5.p0;
import hy1.x;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements CharSequence {
    public final List a;
    public final List b;
    public final CharSequence c;
    public final long d;
    public final p0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final lx1.l f624f;

    public i(CharSequence charSequence, long j2, p0 p0Var, lx1.l lVar, List list, List list2, int i) {
        p0Var = (i & 4) != 0 ? null : p0Var;
        lVar = (i & 8) != 0 ? null : lVar;
        list = (i & 16) != 0 ? null : list;
        list2 = (i & 32) != 0 ? null : list2;
        this.a = list;
        this.b = list2;
        this.c = charSequence instanceof i ? ((i) charSequence).c : charSequence;
        this.d = uc0.p.o(charSequence.length(), j2);
        this.e = p0Var != null ? new p0(uc0.p.o(charSequence.length(), p0Var.a)) : null;
        this.f624f = lVar != null ? new lx1.l(lVar.a, new p0(uc0.p.o(charSequence.length(), ((p0) lVar.b).a))) : null;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.c.charAt(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (p0.c(this.d, iVar.d) && o.c(this.e, iVar.e) && o.c(this.f624f, iVar.f624f) && o.c(this.a, iVar.a)) {
            return x.i0(this.c, iVar.c);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.c.hashCode() * 31;
        int i = p0.c;
        int iG = s1.a.g(iHashCode, this.d, 31);
        p0 p0Var = this.e;
        int iHashCode2 = (iG + (p0Var != null ? Long.hashCode(p0Var.a) : 0)) * 31;
        lx1.l lVar = this.f624f;
        int iHashCode3 = (iHashCode2 + (lVar != null ? lVar.hashCode() : 0)) * 31;
        List list = this.a;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.c.length();
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return this.c.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.c.toString();
    }
}
