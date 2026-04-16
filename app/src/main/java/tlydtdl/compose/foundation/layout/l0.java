package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 implements v2 {
    public final v2 a;
    public final v2 b;

    public l0(v2 v2Var, v2 v2Var2) {
        this.a = v2Var;
        this.b = v2Var2;
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int a(p5.c cVar) {
        int iA = this.a.a(cVar) - this.b.a(cVar);
        if (iA < 0) {
            return 0;
        }
        return iA;
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int b(p5.c cVar, p5.n nVar) {
        int iB = this.a.b(cVar, nVar) - this.b.b(cVar, nVar);
        if (iB < 0) {
            return 0;
        }
        return iB;
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int c(p5.c cVar, p5.n nVar) {
        int iC = this.a.c(cVar, nVar) - this.b.c(cVar, nVar);
        if (iC < 0) {
            return 0;
        }
        return iC;
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int d(p5.c cVar) {
        int iD = this.a.d(cVar) - this.b.d(cVar);
        if (iD < 0) {
            return 0;
        }
        return iD;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return lmjxuqdtp.jvm.internal.o.c(l0Var.a, this.a) && lmjxuqdtp.jvm.internal.o.c(l0Var.b, this.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "(" + this.a + " - " + this.b + ')';
    }
}
