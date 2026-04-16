package tlydtdl.compose.ui.input.nestedscroll;

import b5.b;
import l4.d;
import l4.g;
import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/input/nestedscroll/NestedScrollElement;", "Ls4/c1;", "Ll4/g;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class NestedScrollElement extends c1 {
    public final l4.a a;
    public final d b;

    public NestedScrollElement(l4.a aVar, d dVar) {
        this.a = aVar;
        this.b = dVar;
    }

    @Override // s4.c1
    public final o create() {
        return new g(this.a, this.b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof NestedScrollElement)) {
            return false;
        }
        NestedScrollElement nestedScrollElement = (NestedScrollElement) obj;
        return lmjxuqdtp.jvm.internal.o.c(nestedScrollElement.a, this.a) && lmjxuqdtp.jvm.internal.o.c(nestedScrollElement.b, this.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        d dVar = this.b;
        return iHashCode + (dVar != null ? dVar.hashCode() : 0);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("nestedScroll");
        e2Var.b().c(this.a, "connection");
        e2Var.b().c(this.b, "dispatcher");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        g gVar = (g) oVar;
        gVar.a = this.a;
        d dVar = gVar.b;
        if (dVar.a == gVar) {
            dVar.a = null;
        }
        d dVar2 = this.b;
        if (dVar2 == null) {
            gVar.b = new d();
        } else if (!dVar2.equals(dVar)) {
            gVar.b = dVar2;
        }
        if (gVar.isAttached()) {
            d dVar3 = gVar.b;
            dVar3.a = gVar;
            dVar3.b = null;
            gVar.c = null;
            dVar3.c = new b(9, gVar);
            dVar3.d = gVar.getCoroutineScope();
        }
    }
}
