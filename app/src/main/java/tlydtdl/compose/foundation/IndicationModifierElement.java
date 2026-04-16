package tlydtdl.compose.foundation;

import lmjxuqdtp.Metadata;
import s4.c1;
import s4.n;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import v1.s0;
import v1.t0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/IndicationModifierElement;", "Ls4/c1;", "Lv1/s0;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class IndicationModifierElement extends c1 {
    public final c2.m a;
    public final t0 b;

    public IndicationModifierElement(c2.m mVar, t0 t0Var) {
        this.a = mVar;
        this.b = t0Var;
    }

    @Override // s4.c1
    public final o create() {
        n nVarA = this.b.a(this.a);
        s0 s0Var = new s0();
        s0Var.c = nVarA;
        s0Var.Q0(nVarA);
        return s0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndicationModifierElement)) {
            return false;
        }
        IndicationModifierElement indicationModifierElement = (IndicationModifierElement) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, indicationModifierElement.a) && lmjxuqdtp.jvm.internal.o.c(this.b, indicationModifierElement.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("indication");
        e2Var.b().c(this.a, "interactionSource");
        e2Var.b().c(this.b, "indication");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        s0 s0Var = (s0) oVar;
        n nVarA = this.b.a(this.a);
        s0Var.R0(s0Var.c);
        s0Var.c = nVarA;
        s0Var.Q0(nVarA);
    }
}
