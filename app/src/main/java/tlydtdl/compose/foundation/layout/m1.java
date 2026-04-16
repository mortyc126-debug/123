package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m1 implements e2 {
    public final v2 a;
    public final p5.c b;

    public m1(v2 v2Var, p5.c cVar) {
        this.a = v2Var;
        this.b = cVar;
    }

    @Override // tlydtdl.compose.foundation.layout.e2
    public final float a() {
        v2 v2Var = this.a;
        p5.c cVar = this.b;
        return cVar.p0(v2Var.a(cVar));
    }

    @Override // tlydtdl.compose.foundation.layout.e2
    public final float b(p5.n nVar) {
        v2 v2Var = this.a;
        p5.c cVar = this.b;
        return cVar.p0(v2Var.b(cVar, nVar));
    }

    @Override // tlydtdl.compose.foundation.layout.e2
    public final float c(p5.n nVar) {
        v2 v2Var = this.a;
        p5.c cVar = this.b;
        return cVar.p0(v2Var.c(cVar, nVar));
    }

    @Override // tlydtdl.compose.foundation.layout.e2
    public final float d() {
        v2 v2Var = this.a;
        p5.c cVar = this.b;
        return cVar.p0(v2Var.d(cVar));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, m1Var.a) && lmjxuqdtp.jvm.internal.o.c(this.b, m1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "InsetsPaddingValues(insets=" + this.a + ", density=" + this.b + ')';
    }
}
