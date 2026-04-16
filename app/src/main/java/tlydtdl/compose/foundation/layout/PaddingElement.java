package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/layout/PaddingElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/layout/d2;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class PaddingElement extends s4.c1 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final Function1 e;

    public PaddingElement(float f2, float f3, float f4, float f5, Function1 function1) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        this.e = function1;
        boolean z = true;
        boolean z2 = (f2 >= 0.0f || Float.isNaN(f2)) & (f3 >= 0.0f || Float.isNaN(f3)) & (f4 >= 0.0f || Float.isNaN(f4));
        if (f5 < 0.0f && !Float.isNaN(f5)) {
            z = false;
        }
        if (!z2 || !z) {
            e2.a.a("Padding must be non-negative");
        }
    }

    @Override // s4.c1
    public final t3.o create() {
        d2 d2Var = new d2();
        d2Var.a = this.a;
        d2Var.b = this.b;
        d2Var.c = this.c;
        d2Var.d = this.d;
        d2Var.e = true;
        return d2Var;
    }

    public final boolean equals(Object obj) {
        PaddingElement paddingElement = obj instanceof PaddingElement ? (PaddingElement) obj : null;
        return paddingElement != null && p5.f.a(this.a, paddingElement.a) && p5.f.a(this.b, paddingElement.b) && p5.f.a(this.c, paddingElement.c) && p5.f.a(this.d, paddingElement.d);
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + s1.a.b(this.d, s1.a.b(this.c, s1.a.b(this.b, Float.hashCode(this.a) * 31, 31), 31), 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(t4.e2 e2Var) {
        this.e.invoke(e2Var);
    }

    @Override // s4.c1
    public final void update(t3.o oVar) {
        d2 d2Var = (d2) oVar;
        d2Var.a = this.a;
        d2Var.b = this.b;
        d2Var.c = this.c;
        d2Var.d = this.d;
        d2Var.e = true;
    }
}
