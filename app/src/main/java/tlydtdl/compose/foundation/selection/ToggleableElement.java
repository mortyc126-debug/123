package tlydtdl.compose.foundation.selection;

import a5.h;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function1;
import s1.a;
import s4.c1;
import s4.g;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import v1.t0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/selection/ToggleableElement;", "Ls4/c1;", "Lk2/c;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class ToggleableElement extends c1 {
    public final boolean a;
    public final c2.m b;
    public final boolean c;
    public final h d;
    public final Function1 e;

    public ToggleableElement(boolean z, c2.m mVar, boolean z2, h hVar, Function1 function1) {
        this.a = z;
        this.b = mVar;
        this.c = z2;
        this.d = hVar;
        this.e = function1;
    }

    @Override // s4.c1
    public final o create() {
        return new k2.c(this.a, this.b, this.c, this.d, this.e);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ToggleableElement.class != obj.getClass()) {
            return false;
        }
        ToggleableElement toggleableElement = (ToggleableElement) obj;
        return this.a == toggleableElement.a && lmjxuqdtp.jvm.internal.o.c(this.b, toggleableElement.b) && this.c == toggleableElement.c && this.d.equals(toggleableElement.d) && this.e == toggleableElement.e;
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.a) * 31;
        c2.m mVar = this.b;
        return this.e.hashCode() + a.c(this.d.a, a.f(a.f((iHashCode + (mVar != null ? mVar.hashCode() : 0)) * 961, 31, false), 31, this.c), 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("toggleable");
        e2Var.b().c(e2Var.c(), "value");
        e2Var.b().c(this.b, "interactionSource");
        e2Var.b().c((Object) null, "indicationNodeFactory");
        e2Var.b().c(Boolean.valueOf(this.c), "enabled");
        e2Var.b().c(this.d, "role");
        e2Var.b().c(this.e, "onValueChange");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        k2.c cVar = (k2.c) oVar;
        boolean z = cVar.x;
        boolean z2 = this.a;
        if (z != z2) {
            cVar.x = z2;
            g.u(cVar).G();
        }
        cVar.y = this.e;
        cVar.c1(this.b, (t0) null, false, this.c, (String) null, this.d, cVar.z);
    }
}
