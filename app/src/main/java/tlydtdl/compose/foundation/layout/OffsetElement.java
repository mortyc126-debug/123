package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.Metadata;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/layout/OffsetElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/layout/z1;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class OffsetElement extends s4.c1 {
    public final float a;
    public final float b;
    public final y1 c;

    public OffsetElement(float f2, float f3, y1 y1Var) {
        this.a = f2;
        this.b = f3;
        this.c = y1Var;
    }

    @Override // s4.c1
    public final t3.o create() {
        z1 z1Var = new z1();
        z1Var.a = this.a;
        z1Var.b = this.b;
        z1Var.c = true;
        return z1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        OffsetElement offsetElement = obj instanceof OffsetElement ? (OffsetElement) obj : null;
        return offsetElement != null && p5.f.a(this.a, offsetElement.a) && p5.f.a(this.b, offsetElement.b);
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + s1.a.b(this.b, Float.hashCode(this.a) * 31, 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(t4.e2 e2Var) {
        this.c.invoke(e2Var);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OffsetModifierElement(x=");
        q.q2.p(this.a, ", y=", sb);
        sb.append((Object) p5.f.b(this.b));
        sb.append(", rtlAware=true)");
        return sb.toString();
    }

    @Override // s4.c1
    public final void update(t3.o oVar) {
        z1 z1Var = (z1) oVar;
        float f2 = z1Var.a;
        float f3 = this.a;
        boolean zA = p5.f.a(f2, f3);
        float f4 = this.b;
        if (!zA || !p5.f.a(z1Var.b, f4) || !z1Var.c) {
            s4.g.u(z1Var).X(false);
        }
        z1Var.a = f3;
        z1Var.b = f4;
        z1Var.c = true;
    }
}
