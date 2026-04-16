package tlydtdl.compose.ui.input.rotary;

import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;
import t4.q;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/input/rotary/RotaryInputElement;", "Ls4/c1;", "Lo4/a;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class RotaryInputElement extends c1 {
    @Override // s4.c1
    public final o create() {
        q qVar = q.e;
        o4.a aVar = new o4.a();
        aVar.a = qVar;
        return aVar;
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof RotaryInputElement);
    }

    public final int hashCode() {
        return q.e.hashCode() * 31;
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        q qVar = q.e;
        e2Var.d("onRotaryScrollEvent");
        e2Var.b().c(qVar, "onRotaryScrollEvent");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        ((o4.a) oVar).a = q.e;
    }
}
