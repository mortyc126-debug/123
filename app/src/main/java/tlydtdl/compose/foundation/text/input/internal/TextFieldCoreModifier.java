package tlydtdl.compose.foundation.text.input.internal;

import a2.k2;
import a3.r;
import a4.u;
import java.util.concurrent.CancellationException;
import ky1.f1;
import ky1.t1;
import lmjxuqdtp.Metadata;
import s2.g;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import v1.p1;
import w2.i0;
import w2.y0;
import x2.y;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/text/input/internal/TextFieldCoreModifier;", "Ls4/c1;", "Lw2/i0;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class TextFieldCoreModifier extends c1 {
    public final boolean a;
    public final boolean b;
    public final y0 c;
    public final w2.c1 d;
    public final y e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f514f;
    public final boolean g;
    public final p1 h;
    public final k2 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g f515j;
    public final r k;

    public TextFieldCoreModifier(boolean z, boolean z2, y0 y0Var, w2.c1 c1Var, y yVar, u uVar, boolean z3, p1 p1Var, k2 k2Var, g gVar, r rVar) {
        this.a = z;
        this.b = z2;
        this.c = y0Var;
        this.d = c1Var;
        this.e = yVar;
        this.f514f = uVar;
        this.g = z3;
        this.h = p1Var;
        this.i = k2Var;
        this.f515j = gVar;
        this.k = rVar;
    }

    @Override // s4.c1
    public final o create() {
        return new i0(this.a, this.b, this.c, this.d, this.e, this.f514f, this.g, this.h, this.i, this.f515j, this.k);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldCoreModifier)) {
            return false;
        }
        TextFieldCoreModifier textFieldCoreModifier = (TextFieldCoreModifier) obj;
        return this.a == textFieldCoreModifier.a && this.b == textFieldCoreModifier.b && lmjxuqdtp.jvm.internal.o.c(this.c, textFieldCoreModifier.c) && lmjxuqdtp.jvm.internal.o.c(this.d, textFieldCoreModifier.d) && lmjxuqdtp.jvm.internal.o.c(this.e, textFieldCoreModifier.e) && lmjxuqdtp.jvm.internal.o.c(this.f514f, textFieldCoreModifier.f514f) && this.g == textFieldCoreModifier.g && lmjxuqdtp.jvm.internal.o.c(this.h, textFieldCoreModifier.h) && this.i == textFieldCoreModifier.i && lmjxuqdtp.jvm.internal.o.c(this.f515j, textFieldCoreModifier.f515j) && lmjxuqdtp.jvm.internal.o.c(this.k, textFieldCoreModifier.k);
    }

    public final int hashCode() {
        int iHashCode = (this.f515j.hashCode() + ((this.i.hashCode() + ((this.h.hashCode() + s1.a.f((this.f514f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + s1.a.f(Boolean.hashCode(this.a) * 31, 31, this.b)) * 31)) * 31)) * 31)) * 31, 31, this.g)) * 31)) * 31)) * 31;
        r rVar = this.k;
        return iHashCode + (rVar == null ? 0 : rVar.hashCode());
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
    }

    public final String toString() {
        return "TextFieldCoreModifier(isFocused=" + this.a + ", isDragHovered=" + this.b + ", textLayoutState=" + this.c + ", textFieldState=" + this.d + ", textFieldSelectionState=" + this.e + ", cursorBrush=" + this.f514f + ", writeable=" + this.g + ", scrollState=" + this.h + ", orientation=" + this.i + ", toolbarRequester=" + this.f515j + ", platformSelectionBehaviors=" + this.k + ')';
    }

    @Override // s4.c1
    public final void update(o oVar) {
        f1 f1Var;
        i0 i0Var = (i0) oVar;
        boolean zT0 = i0Var.T0();
        boolean z = i0Var.c;
        w2.c1 c1Var = i0Var.f;
        y0 y0Var = i0Var.e;
        y yVar = i0Var.g;
        p1 p1Var = i0Var.j;
        boolean z2 = this.a;
        i0Var.c = z2;
        boolean z3 = this.b;
        i0Var.d = z3;
        y0 y0Var2 = this.c;
        i0Var.e = y0Var2;
        w2.c1 c1Var2 = this.d;
        i0Var.f = c1Var2;
        y yVar2 = this.e;
        i0Var.g = yVar2;
        i0Var.h = this.f514f;
        i0Var.i = this.g;
        p1 p1Var2 = this.h;
        i0Var.j = p1Var2;
        i0Var.k = this.i;
        i0Var.l = this.f515j;
        i0Var.m = this.k;
        i0Var.t.T0(c1Var2, yVar2, y0Var2, z2 || z3);
        if (!i0Var.T0()) {
            t1 t1Var = i0Var.o;
            if (t1Var != null) {
                t1Var.a((CancellationException) null);
            }
            i0Var.o = null;
            w2.o oVar2 = i0Var.n;
            if (oVar2 != null && (f1Var = (f1) oVar2.b.getAndSet(null)) != null) {
                f1Var.a((CancellationException) null);
            }
        } else if (!z || !lmjxuqdtp.jvm.internal.o.c(c1Var, c1Var2) || !zT0) {
            i0Var.U0();
        }
        if (lmjxuqdtp.jvm.internal.o.c(c1Var, c1Var2) && lmjxuqdtp.jvm.internal.o.c(y0Var, y0Var2) && lmjxuqdtp.jvm.internal.o.c(yVar, yVar2) && lmjxuqdtp.jvm.internal.o.c(p1Var, p1Var2)) {
            return;
        }
        s4.g.u(i0Var).E();
    }
}
