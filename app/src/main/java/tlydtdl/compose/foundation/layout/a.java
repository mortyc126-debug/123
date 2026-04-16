package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements v2 {
    public final int a;
    public final String b;
    public final tlydtdl.compose.runtime.n1 c = tlydtdl.compose.runtime.a0.t(i6.c.e);
    public final tlydtdl.compose.runtime.n1 d = tlydtdl.compose.runtime.a0.t(Boolean.TRUE);

    public a(int i, String str) {
        this.a = i;
        this.b = str;
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int a(p5.c cVar) {
        return e().d;
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int b(p5.c cVar, p5.n nVar) {
        return e().a;
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int c(p5.c cVar, p5.n nVar) {
        return e().c;
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int d(p5.c cVar) {
        return e().b;
    }

    public final i6.c e() {
        return (i6.c) this.c.getValue();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return this.a == ((a) obj).a;
        }
        return false;
    }

    public final void f(r6.z1 z1Var, int i) {
        int i2 = this.a;
        if (i == 0 || (i & i2) != 0) {
            this.c.setValue(z1Var.a.g(i2));
            this.d.setValue(Boolean.valueOf(z1Var.a.q(i2)));
        }
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append('(');
        sb.append(e().a);
        sb.append(", ");
        sb.append(e().b);
        sb.append(", ");
        sb.append(e().c);
        sb.append(", ");
        return f3.f2.l(sb, e().d, ')');
    }
}
