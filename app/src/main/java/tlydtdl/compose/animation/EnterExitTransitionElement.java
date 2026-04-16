package tlydtdl.compose.animation;

import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function0;
import s1.i0;
import s1.w0;
import s1.x0;
import s1.y0;
import s4.c1;
import t1.k1;
import t1.q1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/animation/EnterExitTransitionElement;", "Ls4/c1;", "Ls1/w0;", "animation"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class EnterExitTransitionElement extends c1 {
    public final q1 a;
    public final k1 b;
    public final k1 c;
    public final k1 d;
    public final x0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y0 f479f;
    public final Function0 g;
    public final i0 h;

    public EnterExitTransitionElement(q1 q1Var, k1 k1Var, k1 k1Var2, k1 k1Var3, x0 x0Var, y0 y0Var, Function0 function0, i0 i0Var) {
        this.a = q1Var;
        this.b = k1Var;
        this.c = k1Var2;
        this.d = k1Var3;
        this.e = x0Var;
        this.f479f = y0Var;
        this.g = function0;
        this.h = i0Var;
    }

    @Override // s4.c1
    public final o create() {
        return new w0(this.a, this.b, this.c, this.d, this.e, this.f479f, this.g, this.h);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnterExitTransitionElement)) {
            return false;
        }
        EnterExitTransitionElement enterExitTransitionElement = (EnterExitTransitionElement) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, enterExitTransitionElement.a) && lmjxuqdtp.jvm.internal.o.c(this.b, enterExitTransitionElement.b) && lmjxuqdtp.jvm.internal.o.c(this.c, enterExitTransitionElement.c) && lmjxuqdtp.jvm.internal.o.c(this.d, enterExitTransitionElement.d) && lmjxuqdtp.jvm.internal.o.c(this.e, enterExitTransitionElement.e) && lmjxuqdtp.jvm.internal.o.c(this.f479f, enterExitTransitionElement.f479f) && lmjxuqdtp.jvm.internal.o.c(this.g, enterExitTransitionElement.g) && lmjxuqdtp.jvm.internal.o.c(this.h, enterExitTransitionElement.h);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        k1 k1Var = this.b;
        int iHashCode2 = (iHashCode + (k1Var == null ? 0 : k1Var.hashCode())) * 31;
        k1 k1Var2 = this.c;
        int iHashCode3 = (iHashCode2 + (k1Var2 == null ? 0 : k1Var2.hashCode())) * 31;
        k1 k1Var3 = this.d;
        return this.h.hashCode() + s1.a.e((this.f479f.hashCode() + ((this.e.hashCode() + ((iHashCode3 + (k1Var3 != null ? k1Var3.hashCode() : 0)) * 31)) * 31)) * 31, 31, this.g);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("enterExitTransition");
        e2Var.b().c(this.a, "transition");
        e2Var.b().c(this.b, "sizeAnimation");
        e2Var.b().c(this.c, "offsetAnimation");
        e2Var.b().c(this.d, "slideAnimation");
        e2Var.b().c(this.e, "enter");
        e2Var.b().c(this.f479f, "exit");
        e2Var.b().c(this.h, "graphicsLayerBlock");
    }

    public final String toString() {
        return "EnterExitTransitionElement(transition=" + this.a + ", sizeAnimation=" + this.b + ", offsetAnimation=" + this.c + ", slideAnimation=" + this.d + ", enter=" + this.e + ", exit=" + this.f479f + ", isEnabled=" + this.g + ", graphicsLayerBlock=" + this.h + ')';
    }

    @Override // s4.c1
    public final void update(o oVar) {
        w0 w0Var = (w0) oVar;
        w0Var.b = this.a;
        w0Var.c = this.b;
        w0Var.d = this.c;
        w0Var.e = this.d;
        w0Var.f = this.e;
        w0Var.g = this.f479f;
        w0Var.h = this.g;
        w0Var.i = this.h;
    }
}
