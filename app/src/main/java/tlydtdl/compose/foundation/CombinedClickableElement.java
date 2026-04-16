package tlydtdl.compose.foundation;

import a5.h;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function0;
import m4.k0;
import s4.c1;
import s4.g;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import v1.t0;
import v1.y;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/CombinedClickableElement;", "Ls4/c1;", "Lv1/y;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class CombinedClickableElement extends c1 {
    public final c2.m a;
    public final t0 b;
    public final boolean c;
    public final h d;
    public final Function0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0 f480f;
    public final Function0 g;

    public CombinedClickableElement(h hVar, c2.m mVar, Function0 function0, Function0 function02, Function0 function03, t0 t0Var, boolean z) {
        this.a = mVar;
        this.b = t0Var;
        this.c = z;
        this.d = hVar;
        this.e = function0;
        this.f480f = function02;
        this.g = function03;
    }

    @Override // s4.c1
    public final o create() {
        return new y(this.d, this.a, this.e, this.f480f, this.g, this.b, this.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CombinedClickableElement.class != obj.getClass()) {
            return false;
        }
        CombinedClickableElement combinedClickableElement = (CombinedClickableElement) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, combinedClickableElement.a) && lmjxuqdtp.jvm.internal.o.c(this.b, combinedClickableElement.b) && this.c == combinedClickableElement.c && lmjxuqdtp.jvm.internal.o.c(this.d, combinedClickableElement.d) && this.e == combinedClickableElement.e && this.f480f == combinedClickableElement.f480f && this.g == combinedClickableElement.g;
    }

    public final int hashCode() {
        c2.m mVar = this.a;
        int iHashCode = (mVar != null ? mVar.hashCode() : 0) * 31;
        t0 t0Var = this.b;
        int iF = s1.a.f(s1.a.f((iHashCode + (t0Var != null ? t0Var.hashCode() : 0)) * 31, 31, false), 961, this.c);
        h hVar = this.d;
        int iE = s1.a.e((iF + (hVar != null ? Integer.hashCode(hVar.a) : 0)) * 31, 961, this.e);
        Function0 function0 = this.f480f;
        int iHashCode2 = (iE + (function0 != null ? function0.hashCode() : 0)) * 31;
        Function0 function02 = this.g;
        return Boolean.hashCode(true) + ((iHashCode2 + (function02 != null ? function02.hashCode() : 0)) * 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("combinedClickable");
        e2Var.b().c(this.b, "indicationNodeFactory");
        e2Var.b().c(this.a, "interactionSource");
        e2Var.b().c(Boolean.valueOf(this.c), "enabled");
        e2Var.b().c((Object) null, "onClickLabel");
        e2Var.b().c(this.d, "role");
        e2Var.b().c(this.e, "onClick");
        e2Var.b().c(this.g, "onDoubleClick");
        e2Var.b().c(this.f480f, "onLongClick");
        e2Var.b().c((Object) null, "onLongClickLabel");
        e2Var.b().c(Boolean.TRUE, "hapticFeedbackEnabled");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        boolean z;
        k0 k0Var;
        y yVar = (y) oVar;
        yVar.y = true;
        boolean z2 = yVar.w == null;
        Function0 function0 = this.f480f;
        if (z2 != (function0 == null)) {
            yVar.W0();
            g.u(yVar).G();
            z = true;
        } else {
            z = false;
        }
        yVar.w = function0;
        boolean z3 = yVar.x == null;
        Function0 function02 = this.g;
        if (z3 != (function02 == null)) {
            z = true;
        }
        yVar.x = function02;
        boolean z4 = ((v1.g) yVar).h;
        boolean z5 = this.c;
        boolean z6 = z4 == z5 ? z : true;
        yVar.c1(this.a, this.b, false, z5, (String) null, this.d, this.e);
        if (!z6 || (k0Var = ((v1.g) yVar).l) == null) {
            return;
        }
        k0Var.R0();
    }
}
