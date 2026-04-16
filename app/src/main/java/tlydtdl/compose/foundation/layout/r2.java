package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class r2 implements r4.c, r4.f {
    public final tlydtdl.compose.runtime.n1 a = tlydtdl.compose.runtime.a0.t(new o0());
    public final v2 b;

    public r2(v2 v2Var) {
        this.b = v2Var;
    }

    @Override // r4.c
    public final void V(r4.g gVar) {
        this.a.setValue(new q2(this.b, (v2) gVar.f(m.a)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r2) {
            return lmjxuqdtp.jvm.internal.o.c(((r2) obj).b, this.b);
        }
        return false;
    }

    @Override // r4.f
    public final r4.h getKey() {
        return m.a;
    }

    @Override // r4.f
    public final Object getValue() {
        return (v2) this.a.getValue();
    }

    public final int hashCode() {
        return this.b.hashCode();
    }
}
