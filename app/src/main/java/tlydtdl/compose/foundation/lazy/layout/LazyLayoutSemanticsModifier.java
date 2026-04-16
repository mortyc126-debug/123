package tlydtdl.compose.foundation.lazy.layout;

import a2.k2;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function0;
import s4.c1;
import t3.o;
import t4.e2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/lazy/layout/LazyLayoutSemanticsModifier;", "Ls4/c1;", "Ltlydtdl/compose/foundation/lazy/layout/j1;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = tlydtdl.compose.foundation.layout.m.g)
final class LazyLayoutSemanticsModifier extends c1 {
    public final Function0 a;
    public final g1 b;
    public final k2 c;
    public final boolean d;
    public final boolean e;

    public LazyLayoutSemanticsModifier(Function0 function0, g1 g1Var, k2 k2Var, boolean z, boolean z2) {
        this.a = function0;
        this.b = g1Var;
        this.c = k2Var;
        this.d = z;
        this.e = z2;
    }

    @Override // s4.c1
    public final o create() {
        return new j1(this.a, this.b, this.c, this.d, this.e);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyLayoutSemanticsModifier)) {
            return false;
        }
        LazyLayoutSemanticsModifier lazyLayoutSemanticsModifier = (LazyLayoutSemanticsModifier) obj;
        return this.a == lazyLayoutSemanticsModifier.a && lmjxuqdtp.jvm.internal.o.c(this.b, lazyLayoutSemanticsModifier.b) && this.c == lazyLayoutSemanticsModifier.c && this.d == lazyLayoutSemanticsModifier.d && this.e == lazyLayoutSemanticsModifier.e;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.e) + s1.a.f((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31, 31, this.d);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
    }

    @Override // s4.c1
    public final void update(o oVar) {
        j1 j1Var = (j1) oVar;
        j1Var.a = this.a;
        j1Var.b = this.b;
        k2 k2Var = j1Var.c;
        k2 k2Var2 = this.c;
        if (k2Var != k2Var2) {
            j1Var.c = k2Var2;
            s4.g.u(j1Var).G();
        }
        boolean z = j1Var.d;
        boolean z2 = this.d;
        boolean z3 = this.e;
        if (z == z2 && j1Var.e == z3) {
            return;
        }
        j1Var.d = z2;
        j1Var.e = z3;
        j1Var.Q0();
        s4.g.u(j1Var).G();
    }
}
