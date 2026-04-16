package tlydtdl.compose.foundation;

import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import v1.n1;
import v1.p1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/ScrollingLayoutElement;", "Ls4/c1;", "Lv1/n1;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class ScrollingLayoutElement extends c1 {
    public final p1 a;
    public final boolean b;

    public ScrollingLayoutElement(p1 p1Var, boolean z) {
        this.a = p1Var;
        this.b = z;
    }

    @Override // s4.c1
    public final o create() {
        n1 n1Var = new n1();
        n1Var.a = this.a;
        n1Var.b = this.b;
        return n1Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ScrollingLayoutElement)) {
            return false;
        }
        ScrollingLayoutElement scrollingLayoutElement = (ScrollingLayoutElement) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, scrollingLayoutElement.a) && this.b == scrollingLayoutElement.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + s1.a.f(this.a.hashCode() * 31, 31, false);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("scroll");
        e2Var.b().c(this.a, "state");
        e2Var.b().c(Boolean.FALSE, "reverseScrolling");
        e2Var.b().c(Boolean.valueOf(this.b), "isVertical");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        n1 n1Var = (n1) oVar;
        n1Var.a = this.a;
        n1Var.b = this.b;
    }
}
