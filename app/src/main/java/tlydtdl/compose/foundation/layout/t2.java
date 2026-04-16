package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t2 implements v2 {
    public final String a;
    public final tlydtdl.compose.runtime.n1 b;

    public t2(n1 n1Var, String str) {
        this.a = str;
        this.b = tlydtdl.compose.runtime.a0.t(n1Var);
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

    public final n1 e() {
        return (n1) this.b.getValue();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t2) {
            return lmjxuqdtp.jvm.internal.o.c(e(), ((t2) obj).e());
        }
        return false;
    }

    public final void f(n1 n1Var) {
        this.b.setValue(n1Var);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("(left=");
        sb.append(e().a);
        sb.append(", top=");
        sb.append(e().b);
        sb.append(", right=");
        sb.append(e().c);
        sb.append(", bottom=");
        return f3.f2.l(sb, e().d, ')');
    }
}
