package tlydtdl.compose.foundation.lazy.layout;

import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0083\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/lazy/layout/TraversablePrefetchStateModifierElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/lazy/layout/x1;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = tlydtdl.compose.foundation.layout.m.g)
final class TraversablePrefetchStateModifierElement extends c1 {
    public final z0 a;

    public TraversablePrefetchStateModifierElement(z0 z0Var) {
        this.a = z0Var;
    }

    @Override // s4.c1
    public final o create() {
        x1 x1Var = new x1();
        x1Var.a = this.a;
        return x1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TraversablePrefetchStateModifierElement) && lmjxuqdtp.jvm.internal.o.c(this.a, ((TraversablePrefetchStateModifierElement) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("traversablePrefetchState");
        e2Var.e(this.a);
    }

    public final String toString() {
        return "TraversablePrefetchStateModifierElement(prefetchState=" + this.a + ')';
    }

    @Override // s4.c1
    public final void update(o oVar) {
        ((x1) oVar).a = this.a;
    }
}
