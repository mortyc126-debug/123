package tlydtdl.compose.foundation;

import a4.a1;
import a4.d1;
import a4.y;
import lmjxuqdtp.Metadata;
import p5.f;
import q.q2;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import v1.p;
import x3.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/BorderModifierNodeElement;", "Ls4/c1;", "Lv1/p;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class BorderModifierNodeElement extends c1 {
    public final float a;
    public final d1 b;
    public final a1 c;

    public BorderModifierNodeElement(float f2, d1 d1Var, a1 a1Var) {
        this.a = f2;
        this.b = d1Var;
        this.c = a1Var;
    }

    @Override // s4.c1
    public final o create() {
        return new p(this.a, this.b, this.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderModifierNodeElement)) {
            return false;
        }
        BorderModifierNodeElement borderModifierNodeElement = (BorderModifierNodeElement) obj;
        return f.a(this.a, borderModifierNodeElement.a) && this.b.equals(borderModifierNodeElement.b) && lmjxuqdtp.jvm.internal.o.c(this.c, borderModifierNodeElement.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (Float.hashCode(this.a) * 31)) * 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("border");
        e2Var.b().c(new f(this.a), "width");
        gy1.o oVarB = e2Var.b();
        long j2 = this.b.a;
        oVarB.c(new y(j2), "color");
        e2Var.e(new y(j2));
        e2Var.b().c(this.c, "shape");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BorderModifierNodeElement(width=");
        q2.p(this.a, ", brush=", sb);
        sb.append(this.b);
        sb.append(", shape=");
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }

    @Override // s4.c1
    public final void update(o oVar) {
        p pVar = (p) oVar;
        float f2 = pVar.d;
        b bVar = pVar.g;
        float f3 = this.a;
        if (!f.a(f2, f3)) {
            pVar.d = f3;
            bVar.Q0();
        }
        d1 d1Var = pVar.e;
        d1 d1Var2 = this.b;
        if (!lmjxuqdtp.jvm.internal.o.c(d1Var, d1Var2)) {
            pVar.e = d1Var2;
            bVar.Q0();
        }
        a1 a1Var = pVar.f;
        a1 a1Var2 = this.c;
        if (lmjxuqdtp.jvm.internal.o.c(a1Var, a1Var2)) {
            return;
        }
        pVar.f = a1Var2;
        bVar.Q0();
    }
}
