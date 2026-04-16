package tlydtdl.compose.foundation;

import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import v1.g0;
import w2.n0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/FocusableElement;", "Ls4/c1;", "Lv1/g0;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class FocusableElement extends c1 {
    public final c2.m a;

    public FocusableElement(c2.m mVar) {
        this.a = mVar;
    }

    @Override // s4.c1
    public final o create() {
        return new g0(this.a, (n0) null, 6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FocusableElement) {
            return lmjxuqdtp.jvm.internal.o.c(this.a, ((FocusableElement) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        c2.m mVar = this.a;
        if (mVar != null) {
            return mVar.hashCode();
        }
        return 0;
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("focusable");
        e2Var.b().c(Boolean.TRUE, "enabled");
        e2Var.b().c(this.a, "interactionSource");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        ((g0) oVar).V0(this.a);
    }
}
