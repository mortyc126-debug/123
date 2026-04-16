package tlydtdl.compose.ui.draw;

import a4.a1;
import a4.b1;
import a4.t;
import a4.y;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.NoWhenBranchMatchedException;
import p5.f;
import q.q2;
import s4.c1;
import s4.g;
import s4.k1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/draw/ShadowGraphicsLayerElement;", "Ls4/c1;", "La4/t;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class ShadowGraphicsLayerElement extends c1 {
    public final float a;
    public final a1 b;
    public final boolean c;
    public final long d;
    public final long e;

    public ShadowGraphicsLayerElement(float f2, a1 a1Var, boolean z, long j2, long j3) {
        this.a = f2;
        this.b = a1Var;
        this.c = z;
        this.d = j2;
        this.e = j3;
    }

    @Override // s4.c1
    public final o create() {
        return new t(new b1(26, this));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShadowGraphicsLayerElement)) {
            return false;
        }
        ShadowGraphicsLayerElement shadowGraphicsLayerElement = (ShadowGraphicsLayerElement) obj;
        return f.a(this.a, shadowGraphicsLayerElement.a) && lmjxuqdtp.jvm.internal.o.c(this.b, shadowGraphicsLayerElement.b) && this.c == shadowGraphicsLayerElement.c && y.c(this.d, shadowGraphicsLayerElement.d) && y.c(this.e, shadowGraphicsLayerElement.e);
    }

    public final int hashCode() {
        int iF = s1.a.f(q2.c(this.b, Float.hashCode(this.a) * 31, 31), 31, this.c);
        int i = y.i;
        return Long.hashCode(this.e) + s1.a.g(iF, this.d, 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("shadow");
        e2Var.b().c(new f(this.a), "elevation");
        e2Var.b().c(this.b, "shape");
        e2Var.b().c(Boolean.valueOf(this.c), "clip");
        e2Var.b().c(new y(this.d), "ambientColor");
        e2Var.b().c(new y(this.e), "spotColor");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ShadowGraphicsLayerElement(elevation=");
        q2.p(this.a, ", shape=", sb);
        sb.append(this.b);
        sb.append(", clip=");
        sb.append(this.c);
        sb.append(", ambientColor=");
        q2.s(this.d, ", spotColor=", sb);
        sb.append((Object) y.i(this.e));
        sb.append(')');
        return sb.toString();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    @Override // s4.c1
    public final void update(o oVar) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        t tVar = (t) oVar;
        tVar.a = new b1(26, this);
        k1 k1Var = g.s(tVar, 2).p;
        if (k1Var != null) {
            k1Var.I1(true, tVar.a);
        }
    }
}
