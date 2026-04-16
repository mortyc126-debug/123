package tlydtdl.compose.ui.layout;

import amuvvoafs.annotation.SuppressLint;
import lmjxuqdtp.Metadata;
import q4.u;
import q4.u1;
import s4.c1;
import s4.g;
import s4.j0;
import t3.o;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ModifierNodeInspectableProperties"})
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/layout/RulerProviderModifierElement;", "Ls4/c1;", "Lq4/u1;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class RulerProviderModifierElement extends c1 {
    public final u a;

    public RulerProviderModifierElement(u uVar) {
        this.a = uVar;
    }

    @Override // s4.c1
    public final o create() {
        return new u1(this.a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        RulerProviderModifierElement rulerProviderModifierElement = obj instanceof RulerProviderModifierElement ? (RulerProviderModifierElement) obj : null;
        return (rulerProviderModifierElement != null ? rulerProviderModifierElement.a : null) == this.a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // s4.c1
    public final void update(o oVar) {
        u1 u1Var = (u1) oVar;
        u uVar = u1Var.a;
        u uVar2 = this.a;
        if (uVar != uVar2) {
            u1Var.a = uVar2;
            j0.Y(g.u(u1Var), false, 7);
        }
    }
}
