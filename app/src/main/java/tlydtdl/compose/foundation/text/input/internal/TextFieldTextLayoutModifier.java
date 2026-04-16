package tlydtdl.compose.foundation.text.input.internal;

import d5.q0;
import lmjxuqdtp.Metadata;
import m2.m1;
import q.q2;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import w2.v0;
import w2.w0;
import w2.x0;
import w2.y0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/text/input/internal/TextFieldTextLayoutModifier;", "Ls4/c1;", "Lw2/x0;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class TextFieldTextLayoutModifier extends c1 {
    public final y0 a;
    public final w2.c1 b;
    public final q0 c;
    public final boolean d;
    public final m1 e;

    public TextFieldTextLayoutModifier(y0 y0Var, w2.c1 c1Var, q0 q0Var, boolean z, m1 m1Var) {
        this.a = y0Var;
        this.b = c1Var;
        this.c = q0Var;
        this.d = z;
        this.e = m1Var;
    }

    @Override // s4.c1
    public final o create() {
        return new x0(this.a, this.b, this.c, this.d, this.e);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldTextLayoutModifier)) {
            return false;
        }
        TextFieldTextLayoutModifier textFieldTextLayoutModifier = (TextFieldTextLayoutModifier) obj;
        return this.d == textFieldTextLayoutModifier.d && lmjxuqdtp.jvm.internal.o.c(this.a, textFieldTextLayoutModifier.a) && lmjxuqdtp.jvm.internal.o.c(this.b, textFieldTextLayoutModifier.b) && lmjxuqdtp.jvm.internal.o.c(this.c, textFieldTextLayoutModifier.c) && this.e.equals(textFieldTextLayoutModifier.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + q2.a((this.b.hashCode() + ((this.a.hashCode() + (Boolean.hashCode(this.d) * 31)) * 31)) * 31, 961, this.c);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
    }

    @Override // s4.c1
    public final void update(o oVar) {
        x0 x0Var = (x0) oVar;
        y0 y0Var = x0Var.c;
        y0 y0Var2 = this.a;
        x0Var.c = y0Var2;
        y0Var2.getClass();
        boolean z = this.d;
        x0Var.d = z;
        boolean z2 = !z;
        w0 w0Var = y0Var2.a;
        w0Var.getClass();
        w0Var.a.setValue(new v0(this.b, this.c, z, z2, this.e.c == 4));
        if (lmjxuqdtp.jvm.internal.o.c(y0Var, y0Var2)) {
            return;
        }
        x0Var.e.Q0(y0Var2.g);
    }
}
