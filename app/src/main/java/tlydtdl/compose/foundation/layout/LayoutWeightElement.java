package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.Metadata;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/layout/LayoutWeightElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/layout/u1;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class LayoutWeightElement extends s4.c1 {
    public final float a;
    public final boolean b;

    public LayoutWeightElement(float f2, boolean z) {
        this.a = f2;
        this.b = z;
    }

    @Override // s4.c1
    public final t3.o create() {
        u1 u1Var = new u1();
        u1Var.a = this.a;
        u1Var.b = this.b;
        return u1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        LayoutWeightElement layoutWeightElement = obj instanceof LayoutWeightElement ? (LayoutWeightElement) obj : null;
        return layoutWeightElement != null && this.a == layoutWeightElement.a && this.b == layoutWeightElement.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (Float.hashCode(this.a) * 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(t4.e2 e2Var) {
        e2Var.d("weight");
        float f2 = this.a;
        e2Var.e(Float.valueOf(f2));
        e2Var.b().c(Float.valueOf(f2), "weight");
        e2Var.b().c(Boolean.valueOf(this.b), "fill");
    }

    @Override // s4.c1
    public final void update(t3.o oVar) {
        u1 u1Var = (u1) oVar;
        u1Var.a = this.a;
        u1Var.b = this.b;
    }
}
