package tlydtdl.compose.foundation.layout;

import a2.p3;
import t3.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o2 {
    public static final FillElement a;
    public static final FillElement b;
    public static final FillElement c;
    public static final WrapContentElement d;
    public static final WrapContentElement e;

    /* JADX INFO: renamed from: f */
    public static final WrapContentElement f491f;
    public static final WrapContentElement g;
    public static final WrapContentElement h;
    public static final WrapContentElement i;

    static {
        k0 k0Var = k0.b;
        a = new FillElement(k0Var, 1.0f, "fillMaxWidth");
        k0 k0Var2 = k0.a;
        b = new FillElement(k0Var2, 1.0f, "fillMaxHeight");
        k0 k0Var3 = k0.c;
        c = new FillElement(k0Var3, 1.0f, "fillMaxSize");
        t3.f fVar = t3.c.n;
        d = new WrapContentElement(k0Var, false, new b(fVar, 1), fVar, "wrapContentWidth");
        t3.f fVar2 = t3.c.m;
        e = new WrapContentElement(k0Var, false, new b(fVar2, 1), fVar2, "wrapContentWidth");
        t3.g gVar = t3.c.k;
        f491f = new WrapContentElement(k0Var2, false, new c(gVar, 1), gVar, "wrapContentHeight");
        t3.g gVar2 = t3.c.j;
        g = new WrapContentElement(k0Var2, false, new c(gVar2, 1), gVar2, "wrapContentHeight");
        t3.h hVar = t3.c.e;
        h = new WrapContentElement(k0Var3, false, new p3(3, hVar), hVar, "wrapContentSize");
        t3.h hVar2 = t3.c.a;
        i = new WrapContentElement(k0Var3, false, new p3(3, hVar2), hVar2, "wrapContentSize");
    }

    public static /* synthetic */ t3.p A(t3.p pVar, t3.h hVar, int i2) {
        if ((i2 & 1) != 0) {
            hVar = t3.c.e;
        }
        return z(pVar, hVar, false);
    }

    public static t3.p B(t3.p pVar) {
        t3.f fVar = t3.c.n;
        return pVar.then(lmjxuqdtp.jvm.internal.o.c(fVar, fVar) ? d : lmjxuqdtp.jvm.internal.o.c(fVar, t3.c.m) ? e : new WrapContentElement(k0.b, false, new b(fVar, 1), fVar, "wrapContentWidth"));
    }

    public static final t3.p a(t3.p pVar, float f2, float f3) {
        return pVar.then(new UnspecifiedConstraintsElement(f2, f3));
    }

    public static /* synthetic */ t3.p b(t3.p pVar, float f2, float f3, int i2) {
        if ((i2 & 1) != 0) {
            f2 = Float.NaN;
        }
        if ((i2 & 2) != 0) {
            f3 = Float.NaN;
        }
        return a(pVar, f2, f3);
    }

    public static final t3.p c(t3.p pVar, float f2) {
        return pVar.then(f2 == 1.0f ? b : new FillElement(k0.a, f2, "fillMaxHeight"));
    }

    public static final t3.p d(t3.p pVar, float f2) {
        return pVar.then(f2 == 1.0f ? c : new FillElement(k0.c, f2, "fillMaxSize"));
    }

    public static final t3.p e(t3.p pVar, float f2) {
        return pVar.then(f2 == 1.0f ? a : new FillElement(k0.b, f2, "fillMaxWidth"));
    }

    public static final t3.p f(t3.p pVar, float f2) {
        return pVar.then(new SizeElement(0.0f, f2, 0.0f, f2, true, 5));
    }

    public static final t3.p g(t3.p pVar, float f2, float f3) {
        return pVar.then(new SizeElement(0.0f, f2, 0.0f, f3, true, 5));
    }

    public static /* synthetic */ t3.p h(t3.p pVar, float f2, float f3, int i2) {
        if ((i2 & 1) != 0) {
            f2 = Float.NaN;
        }
        if ((i2 & 2) != 0) {
            f3 = Float.NaN;
        }
        return g(pVar, f2, f3);
    }

    public static final t3.p i(t3.p pVar, float f2) {
        return pVar.then(new SizeElement(0.0f, f2, 0.0f, f2, false, 5));
    }

    public static t3.p j(t3.p pVar, float f2) {
        return pVar.then(new SizeElement(0.0f, f2, 0.0f, Float.NaN, false, 5));
    }

    public static final t3.p k(float f2) {
        return new SizeElement(f2, f2, f2, f2, false);
    }

    public static final t3.p l(t3.p pVar, float f2, float f3) {
        return pVar.then(new SizeElement(f2, f3, f2, f3, false));
    }

    public static t3.p m(t3.p pVar, float f2, float f3, float f4, float f5, int i2) {
        return pVar.then(new SizeElement(f2, (i2 & 2) != 0 ? Float.NaN : f3, (i2 & 4) != 0 ? Float.NaN : f4, (i2 & 8) != 0 ? Float.NaN : f5, false));
    }

    public static final t3.p n(t3.p pVar, float f2) {
        return pVar.then(new SizeElement(f2, 0.0f, f2, 0.0f, false, 10));
    }

    public static t3.p o(float f2) {
        return new SizeElement(f2, 0.0f, Float.NaN, 0.0f, false, 10);
    }

    public static final t3.p p(t3.p pVar, float f2) {
        return pVar.then(new SizeElement(f2, f2, f2, f2, true));
    }

    public static final t3.p q(long j2, t3.p pVar) {
        return r(pVar, p5.i.c(j2), p5.i.b(j2));
    }

    public static final t3.p r(t3.p pVar, float f2, float f3) {
        return pVar.then(new SizeElement(f2, f3, f2, f3, true));
    }

    public static final t3.p s(t3.p pVar, float f2, float f3, float f4, float f5) {
        return pVar.then(new SizeElement(f2, f3, f4, f5, true));
    }

    public static /* synthetic */ t3.p t(t3.p pVar, float f2, float f3, float f4, float f5, int i2) {
        if ((i2 & 1) != 0) {
            f2 = Float.NaN;
        }
        if ((i2 & 2) != 0) {
            f3 = Float.NaN;
        }
        if ((i2 & 4) != 0) {
            f4 = Float.NaN;
        }
        if ((i2 & 8) != 0) {
            f5 = Float.NaN;
        }
        return s(pVar, f2, f3, f4, f5);
    }

    public static final t3.p u(t3.p pVar, float f2) {
        return pVar.then(new SizeElement(f2, 0.0f, f2, 0.0f, true, 10));
    }

    public static final t3.p v(t3.p pVar, float f2, float f3) {
        return pVar.then(new SizeElement(f2, 0.0f, f3, 0.0f, true, 10));
    }

    public static /* synthetic */ t3.p w(t3.p pVar, float f2, float f3, int i2) {
        if ((i2 & 1) != 0) {
            f2 = Float.NaN;
        }
        if ((i2 & 2) != 0) {
            f3 = Float.NaN;
        }
        return v(pVar, f2, f3);
    }

    public static final t3.p x(t3.p pVar, t3.g gVar, boolean z) {
        return pVar.then((!lmjxuqdtp.jvm.internal.o.c(gVar, t3.c.k) || z) ? (!lmjxuqdtp.jvm.internal.o.c(gVar, t3.c.j) || z) ? new WrapContentElement(k0.a, z, new c(gVar, 1), gVar, "wrapContentHeight") : g : f491f);
    }

    public static /* synthetic */ t3.p y(t3.p pVar, t3.g gVar, int i2) {
        if ((i2 & 1) != 0) {
            gVar = t3.c.k;
        }
        return x(pVar, gVar, false);
    }

    public static final t3.p z(t3.p pVar, d dVar, boolean z) {
        return pVar.then((!lmjxuqdtp.jvm.internal.o.c(dVar, t3.c.e) || z) ? (!lmjxuqdtp.jvm.internal.o.c(dVar, t3.c.a) || z) ? new WrapContentElement(k0.c, z, new p3(3, dVar), dVar, "wrapContentSize") : i : h);
    }
}
