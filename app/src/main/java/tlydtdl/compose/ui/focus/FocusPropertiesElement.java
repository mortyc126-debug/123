package tlydtdl.compose.ui.focus;

import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import y3.q;
import y3.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/focus/FocusPropertiesElement;", "Ls4/c1;", "Ly3/s;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class FocusPropertiesElement extends c1 {
    public final q a;

    public FocusPropertiesElement(q qVar) {
        this.a = qVar;
    }

    @Override // s4.c1
    public final o create() {
        s sVar = new s();
        sVar.a = this.a;
        return sVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FocusPropertiesElement) && lmjxuqdtp.jvm.internal.o.c(this.a, ((FocusPropertiesElement) obj).a);
    }

    public final int hashCode() {
        return this.a.a.hashCode();
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("focusProperties");
        e2Var.b().c(this.a, "scope");
    }

    public final String toString() {
        return "FocusPropertiesElement(scope=" + this.a + ')';
    }

    @Override // s4.c1
    public final void update(o oVar) {
        ((s) oVar).a = this.a;
    }
}
