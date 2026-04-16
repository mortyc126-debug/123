package tlydtdl.compose.ui.layout;

import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function3;
import q4.f0;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/layout/LayoutElement;", "Ls4/c1;", "Lq4/f0;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class LayoutElement extends c1 {
    public final Function3 a;

    public LayoutElement(Function3 function3) {
        this.a = function3;
    }

    @Override // s4.c1
    public final o create() {
        f0 f0Var = new f0();
        f0Var.a = this.a;
        return f0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LayoutElement) {
            return this.a == ((LayoutElement) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("layout");
        e2Var.b().c(this.a, "measure");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        ((f0) oVar).a = this.a;
    }
}
