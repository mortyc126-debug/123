package tlydtdl.compose.ui.semantics;

import a5.c;
import a5.k;
import a5.l;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function1;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Ltlydtdl/compose/ui/semantics/AppendedSemanticsElement;", "Ls4/c1;", "La5/c;", "La5/l;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class AppendedSemanticsElement extends c1 implements l {
    public final boolean a;
    public final Function1 b;

    public AppendedSemanticsElement(boolean z, Function1 function1) {
        this.a = z;
        this.b = function1;
    }

    public final k O0() {
        k kVar = new k();
        kVar.c = this.a;
        this.b.invoke(kVar);
        return kVar;
    }

    @Override // s4.c1
    public final o create() {
        return new c(this.b, this.a, false);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppendedSemanticsElement)) {
            return false;
        }
        AppendedSemanticsElement appendedSemanticsElement = (AppendedSemanticsElement) obj;
        return this.a == appendedSemanticsElement.a && this.b == appendedSemanticsElement.b;
    }

    public final int hashCode() {
        return this.b.hashCode() + (Boolean.hashCode(this.a) * 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("semantics");
        e2Var.b().c(Boolean.valueOf(this.a), "mergeDescendants");
        a5.m.a(e2Var, O0());
    }

    @Override // s4.c1
    public final void update(o oVar) {
        c cVar = (c) oVar;
        cVar.a = this.a;
        cVar.c = this.b;
    }
}
