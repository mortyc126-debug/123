package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.Metadata;
import t3.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/layout/BoxChildDataElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/layout/p;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class BoxChildDataElement extends s4.c1 {
    public final d a;
    public final boolean b;

    public BoxChildDataElement(d dVar, boolean z) {
        this.a = dVar;
        this.b = z;
    }

    @Override // s4.c1
    public final t3.o create() {
        p pVar = new p();
        pVar.a = this.a;
        pVar.b = this.b;
        return pVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        BoxChildDataElement boxChildDataElement = obj instanceof BoxChildDataElement ? (BoxChildDataElement) obj : null;
        return boxChildDataElement != null && lmjxuqdtp.jvm.internal.o.c(this.a, boxChildDataElement.a) && this.b == boxChildDataElement.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(t4.e2 e2Var) {
    }

    @Override // s4.c1
    public final void update(t3.o oVar) {
        p pVar = (p) oVar;
        pVar.a = this.a;
        pVar.b = this.b;
    }
}
