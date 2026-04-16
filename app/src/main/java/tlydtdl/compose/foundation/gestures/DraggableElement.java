package tlydtdl.compose.foundation.gestures;

import a2.k2;
import a2.o1;
import a2.p1;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function3;
import s1.a;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/gestures/DraggableElement;", "Ls4/c1;", "La2/o1;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class DraggableElement extends c1 {
    public static final a10.b i = new a10.b(2);
    public final p1 a;
    public final k2 b;
    public final boolean c;
    public final c2.m d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function3 f482f;
    public final Function3 g;
    public final boolean h;

    public DraggableElement(p1 p1Var, k2 k2Var, boolean z, c2.m mVar, boolean z2, Function3 function3, Function3 function32, boolean z3) {
        this.a = p1Var;
        this.b = k2Var;
        this.c = z;
        this.d = mVar;
        this.e = z2;
        this.f482f = function3;
        this.g = function32;
        this.h = z3;
    }

    @Override // s4.c1
    public final o create() {
        a10.b bVar = i;
        boolean z = this.c;
        c2.m mVar = this.d;
        k2 k2Var = this.b;
        o1 o1Var = new o1(bVar, z, mVar, k2Var);
        o1Var.l = this.a;
        o1Var.m = k2Var;
        o1Var.n = this.e;
        o1Var.o = this.f482f;
        o1Var.p = this.g;
        o1Var.q = this.h;
        return o1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DraggableElement.class != obj.getClass()) {
            return false;
        }
        DraggableElement draggableElement = (DraggableElement) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, draggableElement.a) && this.b == draggableElement.b && this.c == draggableElement.c && lmjxuqdtp.jvm.internal.o.c(this.d, draggableElement.d) && this.e == draggableElement.e && lmjxuqdtp.jvm.internal.o.c(this.f482f, draggableElement.f482f) && lmjxuqdtp.jvm.internal.o.c(this.g, draggableElement.g) && this.h == draggableElement.h;
    }

    public final int hashCode() {
        int iF = a.f((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31, this.c);
        c2.m mVar = this.d;
        return Boolean.hashCode(this.h) + ((this.g.hashCode() + ((this.f482f.hashCode() + a.f((iF + (mVar != null ? mVar.hashCode() : 0)) * 31, 31, this.e)) * 31)) * 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("draggable");
        e2Var.b().c(this.b, "orientation");
        e2Var.b().c(Boolean.valueOf(this.c), "enabled");
        e2Var.b().c(Boolean.valueOf(this.h), "reverseDirection");
        e2Var.b().c(this.d, "interactionSource");
        e2Var.b().c(Boolean.valueOf(this.e), "startDragImmediately");
        e2Var.b().c(this.f482f, "onDragStarted");
        e2Var.b().c(this.g, "onDragStopped");
        e2Var.b().c(this.a, "state");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        boolean z;
        boolean z2;
        o1 o1Var = (o1) oVar;
        p1 p1Var = o1Var.l;
        p1 p1Var2 = this.a;
        if (lmjxuqdtp.jvm.internal.o.c(p1Var, p1Var2)) {
            z = false;
        } else {
            o1Var.l = p1Var2;
            z = true;
        }
        k2 k2Var = o1Var.m;
        k2 k2Var2 = this.b;
        if (k2Var != k2Var2) {
            o1Var.m = k2Var2;
            z = true;
        }
        boolean z3 = o1Var.q;
        boolean z4 = this.h;
        if (z3 != z4) {
            o1Var.q = z4;
            z2 = true;
        } else {
            z2 = z;
        }
        o1Var.o = this.f482f;
        o1Var.p = this.g;
        o1Var.n = this.e;
        o1Var.b1(i, this.c, this.d, k2Var2, z2);
    }
}
