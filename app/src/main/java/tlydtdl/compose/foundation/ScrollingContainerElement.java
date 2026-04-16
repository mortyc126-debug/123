package tlydtdl.compose.foundation;

import a2.e;
import a2.k2;
import a2.q1;
import a2.w3;
import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import v1.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/ScrollingContainerElement;", "Ls4/c1;", "Lv1/q1;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class ScrollingContainerElement extends c1 {
    public final w3 a;
    public final k2 b;
    public final boolean c;
    public final boolean d;
    public final q1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c2.m f481f;
    public final e g;
    public final boolean h;
    public final i i;

    public ScrollingContainerElement(e eVar, q1 q1Var, k2 k2Var, w3 w3Var, c2.m mVar, i iVar, boolean z, boolean z2, boolean z3) {
        this.a = w3Var;
        this.b = k2Var;
        this.c = z;
        this.d = z2;
        this.e = q1Var;
        this.f481f = mVar;
        this.g = eVar;
        this.h = z3;
        this.i = iVar;
    }

    @Override // s4.c1
    public final o create() {
        v1.q1 q1Var = new v1.q1();
        q1Var.c = this.a;
        q1Var.d = this.b;
        q1Var.e = this.c;
        q1Var.f = this.d;
        q1Var.g = this.e;
        q1Var.h = this.f481f;
        q1Var.i = this.g;
        q1Var.j = this.h;
        q1Var.k = this.i;
        return q1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ScrollingContainerElement.class != obj.getClass()) {
            return false;
        }
        ScrollingContainerElement scrollingContainerElement = (ScrollingContainerElement) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, scrollingContainerElement.a) && this.b == scrollingContainerElement.b && this.c == scrollingContainerElement.c && this.d == scrollingContainerElement.d && lmjxuqdtp.jvm.internal.o.c(this.e, scrollingContainerElement.e) && lmjxuqdtp.jvm.internal.o.c(this.f481f, scrollingContainerElement.f481f) && lmjxuqdtp.jvm.internal.o.c(this.g, scrollingContainerElement.g) && this.h == scrollingContainerElement.h && lmjxuqdtp.jvm.internal.o.c(this.i, scrollingContainerElement.i);
    }

    public final int hashCode() {
        int iF = s1.a.f(s1.a.f((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31, this.c), 31, this.d);
        q1 q1Var = this.e;
        int iHashCode = (iF + (q1Var != null ? q1Var.hashCode() : 0)) * 31;
        c2.m mVar = this.f481f;
        int iHashCode2 = (iHashCode + (mVar != null ? mVar.hashCode() : 0)) * 31;
        e eVar = this.g;
        int iF2 = s1.a.f((iHashCode2 + (eVar != null ? eVar.hashCode() : 0)) * 31, 31, this.h);
        i iVar = this.i;
        return iF2 + (iVar != null ? iVar.hashCode() : 0);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("scrollingContainer");
        e2Var.b().c(this.a, "state");
        e2Var.b().c(this.b, "orientation");
        e2Var.b().c(Boolean.valueOf(this.c), "enabled");
        e2Var.b().c(Boolean.valueOf(this.d), "reverseScrolling");
        e2Var.b().c(this.e, "flingBehavior");
        e2Var.b().c(this.f481f, "interactionSource");
        e2Var.b().c(this.g, "bringIntoViewSpec");
        e2Var.b().c(Boolean.valueOf(this.h), "useLocalOverscrollFactory");
        e2Var.b().c(this.i, "overscrollEffect");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        ((v1.q1) oVar).V0(this.g, this.e, this.b, this.a, this.f481f, this.i, this.h, this.c, this.d);
    }
}
