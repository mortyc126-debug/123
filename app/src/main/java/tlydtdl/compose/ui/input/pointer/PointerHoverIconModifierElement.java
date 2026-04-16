package tlydtdl.compose.ui.input.pointer;

import lmjxuqdtp.Metadata;
import m4.f;
import m4.n;
import m4.p;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/input/pointer/PointerHoverIconModifierElement;", "Ls4/c1;", "Lm4/n;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class PointerHoverIconModifierElement extends c1 {
    public final p a;

    public PointerHoverIconModifierElement(p pVar) {
        this.a = pVar;
    }

    @Override // s4.c1
    public final o create() {
        return new n(this.a, (s4.p) null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PointerHoverIconModifierElement) && lmjxuqdtp.jvm.internal.o.c(this.a, ((PointerHoverIconModifierElement) obj).a);
    }

    public final int hashCode() {
        return Boolean.hashCode(false) + (this.a.b * 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("pointerHoverIcon");
        e2Var.b().c(this.a, "icon");
        e2Var.b().c(Boolean.FALSE, "overrideDescendants");
    }

    public final String toString() {
        return "PointerHoverIconModifierElement(icon=" + this.a + ", overrideDescendants=false)";
    }

    @Override // s4.c1
    public final void update(o oVar) {
        n nVar = (n) oVar;
        p pVar = ((f) nVar).b;
        p pVar2 = this.a;
        if (lmjxuqdtp.jvm.internal.o.c(pVar, pVar2)) {
            return;
        }
        ((f) nVar).b = pVar2;
        if (((f) nVar).c) {
            nVar.S0();
        }
    }
}
