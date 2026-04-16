package tlydtdl.compose.ui.layout;

import lmjxuqdtp.Metadata;
import q4.c0;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/layout/LayoutIdElement;", "Ls4/c1;", "Lq4/c0;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class LayoutIdElement extends c1 {
    public final Object a;

    public LayoutIdElement(Object obj) {
        this.a = obj;
    }

    @Override // s4.c1
    public final o create() {
        c0 c0Var = new c0();
        c0Var.a = this.a;
        return c0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LayoutIdElement) && lmjxuqdtp.jvm.internal.o.c(this.a, ((LayoutIdElement) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("layoutId");
        e2Var.e(this.a);
    }

    public final String toString() {
        return "LayoutIdElement(layoutId=" + this.a + ')';
    }

    @Override // s4.c1
    public final void update(o oVar) {
        ((c0) oVar).a = this.a;
    }
}
