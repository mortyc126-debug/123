package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.Metadata;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/layout/IntrinsicHeightElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/layout/o1;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class IntrinsicHeightElement extends s4.c1 {
    public final p1 a;

    public IntrinsicHeightElement(p1 p1Var) {
        this.a = p1Var;
    }

    @Override // s4.c1
    public final t3.o create() {
        o1 o1Var = new o1(0);
        o1Var.b = this.a;
        o1Var.c = true;
        return o1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        IntrinsicHeightElement intrinsicHeightElement = obj instanceof IntrinsicHeightElement ? (IntrinsicHeightElement) obj : null;
        return intrinsicHeightElement != null && this.a == intrinsicHeightElement.a;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + (this.a.hashCode() * 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(t4.e2 e2Var) {
    }

    @Override // s4.c1
    public final void update(t3.o oVar) {
        o1 o1Var = (o1) oVar;
        o1Var.b = this.a;
        o1Var.c = true;
    }
}
