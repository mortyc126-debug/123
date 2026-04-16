package tlydtdl.compose.ui.draw;

import a4.z;
import f4.b;
import lmjxuqdtp.Metadata;
import s4.c1;
import s4.g;
import t3.d;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import x3.h;
import z3.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/draw/PainterElement;", "Ls4/c1;", "Lx3/h;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class PainterElement extends c1 {
    public final b a;
    public final d b;
    public final q4.m c;
    public final float d;
    public final z e;

    public PainterElement(b bVar, d dVar, q4.m mVar, float f2, z zVar) {
        this.a = bVar;
        this.b = dVar;
        this.c = mVar;
        this.d = f2;
        this.e = zVar;
    }

    @Override // s4.c1
    public final o create() {
        h hVar = new h();
        hVar.a = this.a;
        hVar.b = true;
        hVar.c = this.b;
        hVar.d = this.c;
        hVar.e = this.d;
        hVar.f = this.e;
        return hVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PainterElement)) {
            return false;
        }
        PainterElement painterElement = (PainterElement) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, painterElement.a) && lmjxuqdtp.jvm.internal.o.c(this.b, painterElement.b) && lmjxuqdtp.jvm.internal.o.c(this.c, painterElement.c) && Float.compare(this.d, painterElement.d) == 0 && lmjxuqdtp.jvm.internal.o.c(this.e, painterElement.e);
    }

    public final int hashCode() {
        int iB = s1.a.b(this.d, (this.c.hashCode() + ((this.b.hashCode() + s1.a.f(this.a.hashCode() * 31, 31, true)) * 31)) * 31, 31);
        z zVar = this.e;
        return iB + (zVar == null ? 0 : zVar.hashCode());
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("paint");
        e2Var.b().c(this.a, "painter");
        e2Var.b().c(Boolean.TRUE, "sizeToIntrinsics");
        e2Var.b().c(this.b, "alignment");
        e2Var.b().c(this.c, "contentScale");
        e2Var.b().c(Float.valueOf(this.d), "alpha");
        e2Var.b().c(this.e, "colorFilter");
    }

    public final String toString() {
        return "PainterElement(painter=" + this.a + ", sizeToIntrinsics=true, alignment=" + this.b + ", contentScale=" + this.c + ", alpha=" + this.d + ", colorFilter=" + this.e + ')';
    }

    @Override // s4.c1
    public final void update(o oVar) {
        h hVar = (h) oVar;
        boolean z = hVar.b;
        b bVar = this.a;
        boolean z2 = (z && e.b(hVar.a.getIntrinsicSize-NH-jbRc(), bVar.getIntrinsicSize-NH-jbRc())) ? false : true;
        hVar.a = bVar;
        hVar.b = true;
        hVar.c = this.b;
        hVar.d = this.c;
        hVar.e = this.d;
        hVar.f = this.e;
        if (z2) {
            g.u(hVar).E();
        }
        g.l(hVar);
    }
}
