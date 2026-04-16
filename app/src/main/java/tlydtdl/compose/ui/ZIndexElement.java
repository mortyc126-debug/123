package tlydtdl.compose.ui;

import lmjxuqdtp.Metadata;
import q.q2;
import s4.c1;
import t3.o;
import t3.s;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/ZIndexElement;", "Ls4/c1;", "Lt3/s;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class ZIndexElement extends c1 {
    public final float a;

    public ZIndexElement(float f2) {
        this.a = f2;
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
        return (obj instanceof ZIndexElement) && Float.compare(this.a, ((ZIndexElement) obj).a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("zIndex");
        e2Var.b().c(Float.valueOf(this.a), "zIndex");
    }

    public final String toString() {
        return q2.l(new StringBuilder("ZIndexElement(zIndex="), this.a, ')');
    }

    @Override // s4.c1
    public final void update(o oVar) {
        ((s) oVar).a = this.a;
    }
}
