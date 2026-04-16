package d5;

import h5.h;
import java.util.List;
import p5.n;
import q.q2;
import uc0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 {
    public final g a;
    public final q0 b;
    public final List c;
    public final int d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f72f;
    public final p5.c g;
    public final n h;
    public final h i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f73j;

    public l0(g gVar, q0 q0Var, List list, int i, boolean z, int i2, p5.c cVar, n nVar, h hVar, long j2) {
        this.a = gVar;
        this.b = q0Var;
        this.c = list;
        this.d = i;
        this.e = z;
        this.f72f = i2;
        this.g = cVar;
        this.h = nVar;
        this.i = hVar;
        this.f73j = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, l0Var.a) && lmjxuqdtp.jvm.internal.o.c(this.b, l0Var.b) && lmjxuqdtp.jvm.internal.o.c(this.c, l0Var.c) && this.d == l0Var.d && this.e == l0Var.e && this.f72f == l0Var.f72f && lmjxuqdtp.jvm.internal.o.c(this.g, l0Var.g) && this.h == l0Var.h && lmjxuqdtp.jvm.internal.o.c(this.i, l0Var.i) && p5.a.b(this.f73j, l0Var.f73j);
    }

    public final int hashCode() {
        return Long.hashCode(this.f73j) + ((this.i.hashCode() + ((this.h.hashCode() + ((this.g.hashCode() + s1.a.c(this.f72f, s1.a.f((i.d(this.c, q2.a(this.a.hashCode() * 31, 31, this.b), 31) + this.d) * 31, 31, this.e), 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "TextLayoutInput(text=" + ((Object) this.a) + ", style=" + this.b + ", placeholders=" + this.c + ", maxLines=" + this.d + ", softWrap=" + this.e + ", overflow=" + ((Object) p.O(this.f72f)) + ", density=" + this.g + ", layoutDirection=" + this.h + ", fontFamilyResolver=" + this.i + ", constraints=" + ((Object) p5.a.l(this.f73j)) + ')';
    }
}
