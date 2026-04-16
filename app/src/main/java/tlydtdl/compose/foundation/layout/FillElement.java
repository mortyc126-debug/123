package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.Metadata;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/layout/FillElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/layout/m0;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class FillElement extends s4.c1 {
    public final k0 a;
    public final float b;
    public final String c;

    public FillElement(k0 k0Var, float f2, String str) {
        this.a = k0Var;
        this.b = f2;
        this.c = str;
    }

    @Override // s4.c1
    public final t3.o create() {
        m0 m0Var = new m0();
        m0Var.a = this.a;
        m0Var.b = this.b;
        return m0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FillElement)) {
            return false;
        }
        FillElement fillElement = (FillElement) obj;
        return this.a == fillElement.a && this.b == fillElement.b;
    }

    public final int hashCode() {
        return Float.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(t4.e2 e2Var) {
        e2Var.d(this.c);
        e2Var.b().c(Float.valueOf(this.b), "fraction");
    }

    @Override // s4.c1
    public final void update(t3.o oVar) {
        m0 m0Var = (m0) oVar;
        m0Var.a = this.a;
        m0Var.b = this.b;
    }
}
