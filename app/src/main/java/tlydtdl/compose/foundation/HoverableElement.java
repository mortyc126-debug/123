package tlydtdl.compose.foundation;

import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import v1.o0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/HoverableElement;", "Ls4/c1;", "Lv1/o0;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class HoverableElement extends c1 {
    public final c2.m a;

    public HoverableElement(c2.m mVar) {
        this.a = mVar;
    }

    @Override // s4.c1
    public final o create() {
        o0 o0Var = new o0();
        o0Var.a = this.a;
        return o0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HoverableElement) && lmjxuqdtp.jvm.internal.o.c(((HoverableElement) obj).a, this.a);
    }

    public final int hashCode() {
        return this.a.hashCode() * 31;
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("hoverable");
        e2Var.b().c(this.a, "interactionSource");
        e2Var.b().c(Boolean.TRUE, "enabled");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        o0 o0Var = (o0) oVar;
        c2.m mVar = o0Var.a;
        c2.m mVar2 = this.a;
        if (lmjxuqdtp.jvm.internal.o.c(mVar, mVar2)) {
            return;
        }
        o0Var.S0();
        o0Var.a = mVar2;
    }
}
