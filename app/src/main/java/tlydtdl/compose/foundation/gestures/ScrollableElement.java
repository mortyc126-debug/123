package tlydtdl.compose.foundation.gestures;

import a2.e;
import a2.k2;
import a2.q1;
import a2.v3;
import a2.w3;
import lmjxuqdtp.Metadata;
import s1.a;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import v1.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/gestures/ScrollableElement;", "Ls4/c1;", "La2/v3;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class ScrollableElement extends c1 {
    public final w3 a;
    public final k2 b;
    public final boolean c;
    public final boolean d;
    public final c2.m e;

    public ScrollableElement(w3 w3Var, k2 k2Var, boolean z, boolean z2, c2.m mVar) {
        this.a = w3Var;
        this.b = k2Var;
        this.c = z;
        this.d = z2;
        this.e = mVar;
    }

    @Override // s4.c1
    public final o create() {
        return new v3((e) null, (q1) null, this.b, this.a, this.e, (i) null, this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScrollableElement)) {
            return false;
        }
        ScrollableElement scrollableElement = (ScrollableElement) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, scrollableElement.a) && this.b == scrollableElement.b && this.c == scrollableElement.c && this.d == scrollableElement.d && lmjxuqdtp.jvm.internal.o.c(this.e, scrollableElement.e);
    }

    public final int hashCode() {
        int iF = a.f(a.f((this.b.hashCode() + (this.a.hashCode() * 31)) * 961, 31, this.c), 961, this.d);
        c2.m mVar = this.e;
        return (iF + (mVar != null ? mVar.hashCode() : 0)) * 31;
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("scrollable");
        e2Var.b().c(this.b, "orientation");
        e2Var.b().c(this.a, "state");
        e2Var.b().c((Object) null, "overscrollEffect");
        e2Var.b().c(Boolean.valueOf(this.c), "enabled");
        e2Var.b().c(Boolean.valueOf(this.d), "reverseDirection");
        e2Var.b().c((Object) null, "flingBehavior");
        e2Var.b().c(this.e, "interactionSource");
        e2Var.b().c((Object) null, "bringIntoViewSpec");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        ((v3) oVar).c1((e) null, (q1) null, this.b, this.a, this.e, (i) null, this.c, this.d);
    }
}
