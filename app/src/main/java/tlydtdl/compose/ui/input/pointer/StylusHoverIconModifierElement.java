package tlydtdl.compose.ui.input.pointer;

import lmjxuqdtp.Metadata;
import m2.k1;
import m4.a;
import m4.d0;
import m4.f;
import s4.c1;
import s4.p;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/input/pointer/StylusHoverIconModifierElement;", "Ls4/c1;", "Lm4/d0;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class StylusHoverIconModifierElement extends c1 {
    public final p a;

    public StylusHoverIconModifierElement(p pVar) {
        this.a = pVar;
    }

    @Override // s4.c1
    public final o create() {
        return new d0(k1.b, this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StylusHoverIconModifierElement)) {
            return false;
        }
        StylusHoverIconModifierElement stylusHoverIconModifierElement = (StylusHoverIconModifierElement) obj;
        a aVar = k1.b;
        return aVar.equals(aVar) && lmjxuqdtp.jvm.internal.o.c(this.a, stylusHoverIconModifierElement.a);
    }

    public final int hashCode() {
        int iF = s1.a.f(1022 * 31, 31, false);
        p pVar = this.a;
        return iF + (pVar != null ? pVar.hashCode() : 0);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("stylusHoverIcon");
        e2Var.b().c(k1.b, "icon");
        e2Var.b().c(Boolean.FALSE, "overrideDescendants");
        e2Var.b().c(this.a, "touchBoundsExpansion");
    }

    public final String toString() {
        return "StylusHoverIconModifierElement(icon=" + k1.b + ", overrideDescendants=false, touchBoundsExpansion=" + this.a + ')';
    }

    @Override // s4.c1
    public final void update(o oVar) {
        d0 d0Var = (d0) oVar;
        a aVar = k1.b;
        if (!lmjxuqdtp.jvm.internal.o.c(((f) d0Var).b, aVar)) {
            ((f) d0Var).b = aVar;
            if (((f) d0Var).c) {
                d0Var.S0();
            }
        }
        ((f) d0Var).a = this.a;
    }
}
