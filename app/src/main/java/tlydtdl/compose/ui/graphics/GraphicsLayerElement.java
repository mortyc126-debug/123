package tlydtdl.compose.ui.graphics;

import a4.a1;
import a4.b1;
import a4.e0;
import a4.f1;
import a4.p;
import a4.y;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.NoWhenBranchMatchedException;
import q.q2;
import s4.c1;
import s4.g;
import s4.k1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/graphics/GraphicsLayerElement;", "Ls4/c1;", "La4/c1;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class GraphicsLayerElement extends c1 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f553f;
    public final long g;
    public final a1 h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f554j;
    public final long k;
    public final int l;

    public GraphicsLayerElement(float f2, float f3, float f4, float f5, float f7, float f8, long j2, a1 a1Var, boolean z, long j3, long j4, int i) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        this.e = f7;
        this.f553f = f8;
        this.g = j2;
        this.h = a1Var;
        this.i = z;
        this.f554j = j3;
        this.k = j4;
        this.l = i;
    }

    @Override // s4.c1
    public final o create() {
        a4.c1 c1Var = new a4.c1();
        c1Var.a = this.a;
        c1Var.b = this.b;
        c1Var.c = this.c;
        c1Var.d = this.d;
        c1Var.e = this.e;
        c1Var.f = this.f553f;
        c1Var.g = 8.0f;
        c1Var.h = this.g;
        c1Var.i = this.h;
        c1Var.j = this.i;
        c1Var.k = this.f554j;
        c1Var.l = this.k;
        c1Var.m = this.l;
        c1Var.n = 3;
        c1Var.o = new b1(0, c1Var);
        return c1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraphicsLayerElement)) {
            return false;
        }
        GraphicsLayerElement graphicsLayerElement = (GraphicsLayerElement) obj;
        return Float.compare(this.a, graphicsLayerElement.a) == 0 && Float.compare(this.b, graphicsLayerElement.b) == 0 && Float.compare(this.c, graphicsLayerElement.c) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(this.d, graphicsLayerElement.d) == 0 && Float.compare(this.e, graphicsLayerElement.e) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(this.f553f, graphicsLayerElement.f553f) == 0 && Float.compare(8.0f, 8.0f) == 0 && f1.a(this.g, graphicsLayerElement.g) && lmjxuqdtp.jvm.internal.o.c(this.h, graphicsLayerElement.h) && this.i == graphicsLayerElement.i && y.c(this.f554j, graphicsLayerElement.f554j) && y.c(this.k, graphicsLayerElement.k) && this.l == graphicsLayerElement.l;
    }

    public final int hashCode() {
        int iB = s1.a.b(8.0f, s1.a.b(this.f553f, s1.a.b(0.0f, s1.a.b(0.0f, s1.a.b(this.e, s1.a.b(this.d, s1.a.b(0.0f, s1.a.b(this.c, s1.a.b(this.b, Float.hashCode(this.a) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31);
        int i = f1.c;
        int iF = s1.a.f(q2.c(this.h, s1.a.g(iB, this.g, 31), 31), 961, this.i);
        int i2 = y.i;
        return s1.a.c(3, s1.a.c(this.l, s1.a.g(s1.a.g(iF, this.f554j, 31), this.k, 31), 31), 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("graphicsLayer");
        e2Var.b().c(Float.valueOf(this.a), "scaleX");
        e2Var.b().c(Float.valueOf(this.b), "scaleY");
        e2Var.b().c(Float.valueOf(this.c), "alpha");
        gy1.o oVarB = e2Var.b();
        Float fValueOf = Float.valueOf(0.0f);
        oVarB.c(fValueOf, "translationX");
        e2Var.b().c(Float.valueOf(this.d), "translationY");
        e2Var.b().c(Float.valueOf(this.e), "shadowElevation");
        e2Var.b().c(fValueOf, "rotationX");
        e2Var.b().c(fValueOf, "rotationY");
        e2Var.b().c(Float.valueOf(this.f553f), "rotationZ");
        e2Var.b().c(Float.valueOf(8.0f), "cameraDistance");
        e2Var.b().c(new f1(this.g), "transformOrigin");
        e2Var.b().c(this.h, "shape");
        e2Var.b().c(Boolean.valueOf(this.i), "clip");
        e2Var.b().c((Object) null, "renderEffect");
        e2Var.b().c(new y(this.f554j), "ambientShadowColor");
        e2Var.b().c(new y(this.k), "spotShadowColor");
        e2Var.b().c(new e0(this.l), "compositingStrategy");
        e2Var.b().c(new p(), "blendMode");
        e2Var.b().c((Object) null, "colorFilter");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GraphicsLayerElement(scaleX=");
        sb.append(this.a);
        sb.append(", scaleY=");
        sb.append(this.b);
        sb.append(", alpha=");
        sb.append(this.c);
        sb.append(", translationX=0.0, translationY=");
        sb.append(this.d);
        sb.append(", shadowElevation=");
        sb.append(this.e);
        sb.append(", rotationX=0.0, rotationY=0.0, rotationZ=");
        sb.append(this.f553f);
        sb.append(", cameraDistance=8.0, transformOrigin=");
        sb.append((Object) f1.d(this.g));
        sb.append(", shape=");
        sb.append(this.h);
        sb.append(", clip=");
        sb.append(this.i);
        sb.append(", renderEffect=null, ambientShadowColor=");
        q2.s(this.f554j, ", spotShadowColor=", sb);
        q2.s(this.k, ", compositingStrategy=", sb);
        sb.append((Object) e0.a(this.l));
        sb.append(", blendMode=");
        sb.append((Object) p.a(3));
        sb.append(", colorFilter=null)");
        return sb.toString();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    @Override // s4.c1
    public final void update(o oVar) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        a4.c1 c1Var = (a4.c1) oVar;
        c1Var.a = this.a;
        c1Var.b = this.b;
        c1Var.c = this.c;
        c1Var.d = this.d;
        c1Var.e = this.e;
        c1Var.f = this.f553f;
        c1Var.g = 8.0f;
        c1Var.h = this.g;
        c1Var.i = this.h;
        c1Var.j = this.i;
        c1Var.k = this.f554j;
        c1Var.l = this.k;
        c1Var.m = this.l;
        c1Var.n = 3;
        k1 k1Var = g.s(c1Var, 2).p;
        if (k1Var != null) {
            k1Var.I1(true, c1Var.o);
        }
    }
}
