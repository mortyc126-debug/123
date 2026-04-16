package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/layout/WrapContentElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/layout/d3;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class WrapContentElement extends s4.c1 {
    public final k0 a;
    public final boolean b;
    public final Function2 c;
    public final Object d;
    public final String e;

    public WrapContentElement(k0 k0Var, boolean z, Function2 function2, Object obj, String str) {
        this.a = k0Var;
        this.b = z;
        this.c = function2;
        this.d = obj;
        this.e = str;
    }

    @Override // s4.c1
    public final t3.o create() {
        d3 d3Var = new d3();
        d3Var.a = this.a;
        d3Var.b = this.b;
        d3Var.c = this.c;
        return d3Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WrapContentElement.class != obj.getClass()) {
            return false;
        }
        WrapContentElement wrapContentElement = (WrapContentElement) obj;
        return this.a == wrapContentElement.a && this.b == wrapContentElement.b && lmjxuqdtp.jvm.internal.o.c(this.d, wrapContentElement.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + s1.a.f(this.a.hashCode() * 31, 31, this.b);
    }

    @Override // s4.c1
    public final void inspectableProperties(t4.e2 e2Var) {
        e2Var.d(this.e);
        e2Var.b().c(this.d, "align");
        e2Var.b().c(Boolean.valueOf(this.b), "unbounded");
    }

    @Override // s4.c1
    public final void update(t3.o oVar) {
        d3 d3Var = (d3) oVar;
        d3Var.a = this.a;
        d3Var.b = this.b;
        d3Var.c = this.c;
    }
}
