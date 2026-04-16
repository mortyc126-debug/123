package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.Metadata;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/layout/OffsetPxElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/layout/a2;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class OffsetPxElement extends s4.c1 {
    public final Function1 a;
    public final x1 b;

    public OffsetPxElement(Function1 function1, x1 x1Var) {
        this.a = function1;
        this.b = x1Var;
    }

    @Override // s4.c1
    public final t3.o create() {
        a2 a2Var = new a2();
        a2Var.a = this.a;
        a2Var.b = true;
        return a2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        OffsetPxElement offsetPxElement = obj instanceof OffsetPxElement ? (OffsetPxElement) obj : null;
        return offsetPxElement != null && this.a == offsetPxElement.a;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + (this.a.hashCode() * 31);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    @Override // s4.c1
    public final void inspectableProperties(t4.e2 e2Var) throws NoWhenBranchMatchedException {
        this.b.invoke(e2Var);
    }

    public final String toString() {
        return "OffsetPxModifier(offset=" + this.a + ", rtlAware=true)";
    }

    @Override // s4.c1
    public final void update(t3.o oVar) {
        a2 a2Var = (a2) oVar;
        Function1 function1 = a2Var.a;
        Function1 function12 = this.a;
        if (function1 != function12 || !a2Var.b) {
            s4.g.u(a2Var).X(false);
        }
        a2Var.a = function12;
        a2Var.b = true;
    }
}
