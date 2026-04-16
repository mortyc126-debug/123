package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.Metadata;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/layout/VerticalAlignElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/layout/u2;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class VerticalAlignElement extends s4.c1 {
    public final t3.g a;

    public VerticalAlignElement(t3.g gVar) {
        this.a = gVar;
    }

    @Override // s4.c1
    public final t3.o create() {
        u2 u2Var = new u2();
        u2Var.a = this.a;
        return u2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        VerticalAlignElement verticalAlignElement = obj instanceof VerticalAlignElement ? (VerticalAlignElement) obj : null;
        if (verticalAlignElement == null) {
            return false;
        }
        return this.a.equals(verticalAlignElement.a);
    }

    public final int hashCode() {
        return Float.hashCode(this.a.a);
    }

    @Override // s4.c1
    public final void inspectableProperties(t4.e2 e2Var) {
        e2Var.d("align");
        e2Var.e(this.a);
    }

    @Override // s4.c1
    public final void update(t3.o oVar) {
        ((u2) oVar).a = this.a;
    }
}
