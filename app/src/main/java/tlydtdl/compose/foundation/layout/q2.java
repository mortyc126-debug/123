package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q2 implements v2 {
    public final v2 a;
    public final v2 b;

    public q2(v2 v2Var, v2 v2Var2) {
        this.a = v2Var;
        this.b = v2Var2;
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int a(p5.c cVar) {
        return Math.max(this.a.a(cVar), this.b.a(cVar));
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int b(p5.c cVar, p5.n nVar) {
        return Math.max(this.a.b(cVar, nVar), this.b.b(cVar, nVar));
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int c(p5.c cVar, p5.n nVar) {
        return Math.max(this.a.c(cVar, nVar), this.b.c(cVar, nVar));
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int d(p5.c cVar) {
        return Math.max(this.a.d(cVar), this.b.d(cVar));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q2)) {
            return false;
        }
        q2 q2Var = (q2) obj;
        return lmjxuqdtp.jvm.internal.o.c(q2Var.a, this.a) && lmjxuqdtp.jvm.internal.o.c(q2Var.b, this.b);
    }

    public final int hashCode() {
        return (this.b.hashCode() * 31) + this.a.hashCode();
    }

    public final String toString() {
        return "(" + this.a + " ∪ " + this.b + ')';
    }
}
