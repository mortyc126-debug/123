package tlydtdl.compose.material3;

import f3.r3;
import lmjxuqdtp.Metadata;
import s4.c1;
import s4.g;
import t1.b1;
import t1.c;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/material3/ThumbElement;", "Ls4/c1;", "Lf3/r3;", "material3"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class ThumbElement extends c1 {
    public final c2.m a;
    public final boolean b;
    public final b1 c;

    public ThumbElement(c2.m mVar, boolean z, b1 b1Var) {
        this.a = mVar;
        this.b = z;
        this.c = b1Var;
    }

    @Override // s4.c1
    public final o create() {
        r3 r3Var = new r3();
        r3Var.a = this.a;
        r3Var.b = this.b;
        r3Var.c = this.c;
        r3Var.g = Float.NaN;
        r3Var.h = Float.NaN;
        return r3Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThumbElement)) {
            return false;
        }
        ThumbElement thumbElement = (ThumbElement) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, thumbElement.a) && this.b == thumbElement.b && this.c.equals(thumbElement.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + s1.a.f(this.a.hashCode() * 31, 31, this.b);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("switchThumb");
        e2Var.b().c(this.a, "interactionSource");
        e2Var.b().c(Boolean.valueOf(this.b), "checked");
        e2Var.b().c(this.c, "animationSpec");
    }

    public final String toString() {
        return "ThumbElement(interactionSource=" + this.a + ", checked=" + this.b + ", animationSpec=" + this.c + ')';
    }

    @Override // s4.c1
    public final void update(o oVar) {
        r3 r3Var = (r3) oVar;
        r3Var.a = this.a;
        boolean z = r3Var.b;
        boolean z2 = this.b;
        if (z != z2) {
            g.u(r3Var).E();
        }
        r3Var.b = z2;
        r3Var.c = this.c;
        if (r3Var.f == null && !Float.isNaN(r3Var.h)) {
            r3Var.f = c.a(r3Var.h);
        }
        if (r3Var.e != null || Float.isNaN(r3Var.g)) {
            return;
        }
        r3Var.e = c.a(r3Var.g);
    }
}
