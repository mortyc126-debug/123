package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.Metadata;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/layout/UnspecifiedConstraintsElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/layout/s2;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class UnspecifiedConstraintsElement extends s4.c1 {
    public final float a;
    public final float b;

    public UnspecifiedConstraintsElement(float f2, float f3) {
        this.a = f2;
        this.b = f3;
    }

    @Override // s4.c1
    public final t3.o create() {
        s2 s2Var = new s2();
        s2Var.a = this.a;
        s2Var.b = this.b;
        return s2Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof UnspecifiedConstraintsElement)) {
            return false;
        }
        UnspecifiedConstraintsElement unspecifiedConstraintsElement = (UnspecifiedConstraintsElement) obj;
        return p5.f.a(this.a, unspecifiedConstraintsElement.a) && p5.f.a(this.b, unspecifiedConstraintsElement.b);
    }

    public final int hashCode() {
        return Float.hashCode(this.b) + (Float.hashCode(this.a) * 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(t4.e2 e2Var) {
        e2Var.d("defaultMinSize");
        e2Var.b().c(new p5.f(this.a), "minWidth");
        e2Var.b().c(new p5.f(this.b), "minHeight");
    }

    @Override // s4.c1
    public final void update(t3.o oVar) {
        s2 s2Var = (s2) oVar;
        s2Var.a = this.a;
        s2Var.b = this.b;
    }
}
