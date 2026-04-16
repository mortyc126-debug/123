package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.Metadata;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/layout/HorizontalAlignElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/layout/i1;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class HorizontalAlignElement extends s4.c1 {
    public final t3.f a;

    public HorizontalAlignElement(t3.f fVar) {
        this.a = fVar;
    }

    @Override // s4.c1
    public final t3.o create() {
        i1 i1Var = new i1();
        i1Var.a = this.a;
        return i1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        HorizontalAlignElement horizontalAlignElement = obj instanceof HorizontalAlignElement ? (HorizontalAlignElement) obj : null;
        if (horizontalAlignElement == null) {
            return false;
        }
        return this.a.equals(horizontalAlignElement.a);
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
        ((i1) oVar).a = this.a;
    }
}
