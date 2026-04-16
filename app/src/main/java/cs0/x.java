package cs0;

import ak.g3;
import com.gnacba.amuvvoafs.gms.internal.ads.cy;
import d10.j;
import hy1.w;
import ky1.a0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;
import lx1.b0;
import ny1.b2;
import ny1.j2;
import ny1.r2;
import ny1.z;
import qx1.d;
import s02.b;
import st.w0;
import tlydtdl.compose.foundation.lazy.layout.r1;
import wm.g0;
import zj.u2;
import zj.v1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements k {
    public final zj.n a;
    public final a0 b;
    public final i c;
    public final cy d = new cy(new a80.g(0, this, x.class, "measureBpmBetweenTaps", "measureBpmBetweenTaps()V", 0, 17), new a80.g(0, this, x.class, "onPressDecrement", "onPressDecrement()V", 0, 18), new a80.g(0, this, x.class, "onPressIncrement", "onPressIncrement()V", 0, 19), new a80.g(0, this, x.class, "onReleaseButtons", "onReleaseButtons()V", 0, 20), 17);
    public final r1 e = new r1(new a80.g(0, this, x.class, "onInputBackspace", "onInputBackspace()V", 0, 21), new a80.g(0, this, x.class, "onTextInputDone", "onTextInputDone()V", 0, 22), new bn0.i(1, this, x.class, "onFocusChange", "onFocusChange(Z)V", 0, 4), 14);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v2.p f53f;
    public final r2 g;
    public final b2 h;

    public x(zj.n nVar, a0 a0Var, i iVar) {
        this.a = nVar;
        this.b = a0Var;
        this.c = iVar;
        float f2 = ((a21.e) c().x.getValue()).g.a;
        v2.p pVar = new v2.p((String) null, 3);
        b(pVar, f2);
        this.f53f = pVar;
        r2 r2VarC = z.c(new g(f2, !d().e()));
        this.g = r2VarC;
        this.h = z.R(new am.p(7, r2VarC, this), a0Var, j2.a(3), i((h) r2VarC.getValue()));
        z.J(a0Var, new j(z.u(new g3(c().x, 12)), d().h, new l(this, null), 9));
        z.J(a0Var, z.K(new ah.o(this, (d) null, 9), new j(d().h, z.u(new au0.y(2, r2VarC)), m.a, 9)));
        z.J(a0Var, new am.p(20, z.s(z.u(new t(0, new au0.y(1, r2VarC))), y.g), new n(this, null)));
    }

    public static final Object a(x xVar, u2 u2Var, float f2, sx1.i iVar) {
        xVar.getClass();
        boolean zBooleanValue = ((Boolean) u2Var.h.getValue()).booleanValue();
        b0 b0Var = b0.a;
        if (!zBooleanValue) {
            b bVar = s02.d.a;
            String str = "Metro:: saving new tempo: " + hg1.b.b(f2);
            bVar.getClass();
            b.t(str);
            v1 v1VarC = xVar.c();
            a21.a aVar = new a21.a(1, f2);
            v1VarC.getClass();
            Object objH = v1VarC.h(new g0(aVar, v1VarC, (d) null, 18), iVar);
            rx1.a aVar2 = rx1.a.a;
            if (objH != aVar2) {
                objH = b0Var;
            }
            if (objH == aVar2) {
                return objH;
            }
        }
        return b0Var;
    }

    public static void b(v2.p pVar, float f2) {
        v2.h hVarF = pVar.f();
        try {
            hVarF.c(0, hVarF.c.length(), String.valueOf(by1.b.P(f2)));
            pVar.b(hVarF);
        } finally {
            pVar.e(false);
        }
    }

    public final v1 c() {
        return this.a.a;
    }

    public final u2 d() {
        return this.a.c;
    }

    public final hg1.b e() {
        if (w.g0(this.f53f.c().c.toString()) != null) {
            return new hg1.b(w0.i(by1.b.P(r0.floatValue()), y.a, y.b));
        }
        return null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final h f(h hVar, v1 v1Var, u2 u2Var, boolean z) throws NoWhenBranchMatchedException {
        float f2 = ((a21.e) v1Var.x.getValue()).g.a;
        boolean z2 = !u2Var.e();
        b(this.f53f, f2);
        if (hVar instanceof a) {
            return new a(f2, ((a) hVar).b, z2);
        }
        if (!(hVar instanceof f)) {
            if (hVar instanceof g) {
                return new g(f2, z2);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!z) {
            f fVar = (f) hVar;
            if (fVar.c) {
                return fVar;
            }
        }
        return new f(f2, z2, false);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final a g(h hVar, e eVar, Function1 function1) throws NoWhenBranchMatchedException {
        boolean z = hVar instanceof g;
        v2.p pVar = this.f53f;
        if (z) {
            g gVar = (g) hVar;
            float fI = w0.i(((hg1.b) function1.invoke(new hg1.b(gVar.a))).a, y.a, y.b);
            b(pVar, fI);
            return new a(fI, eVar, gVar.b);
        }
        if (hVar instanceof a) {
            a aVar = (a) hVar;
            float fI2 = w0.i(((hg1.b) function1.invoke(new hg1.b(aVar.a))).a, y.a, y.b);
            b(pVar, fI2);
            boolean z2 = aVar.c;
            lmjxuqdtp.jvm.internal.o.h(eVar, "pressed");
            return new a(fI2, eVar, z2);
        }
        if (!(hVar instanceof f)) {
            throw new NoWhenBranchMatchedException();
        }
        hg1.b bVarE = e();
        float f2 = ((hg1.b) function1.invoke(new hg1.b(bVarE != null ? bVarE.a : ((f) hVar).a))).a;
        float f3 = y.a;
        float f4 = y.b;
        float fI3 = w0.i(f2, f3, f4);
        b(pVar, fI3);
        return new a(w0.i(fI3, f3, f4), eVar, ((f) hVar).b);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final f h(h hVar, String str) throws NoWhenBranchMatchedException {
        if (str != null) {
            v2.p pVar = this.f53f;
            v2.h hVarF = pVar.f();
            try {
                hVarF.d(0, hVarF.c.length(), str, 0, str.length());
                pVar.b(hVarF);
            } finally {
                pVar.e(false);
            }
        }
        if (hVar instanceof g) {
            g gVar = (g) hVar;
            return new f(gVar.a, gVar.b, false);
        }
        if (hVar instanceof a) {
            a aVar = (a) hVar;
            return new f(aVar.a, aVar.c, false);
        }
        if (!(hVar instanceof f)) {
            throw new NoWhenBranchMatchedException();
        }
        f fVar = (f) hVar;
        return new f(fVar.a, fVar.b, false);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final ds0.l i(h hVar) throws NoWhenBranchMatchedException {
        if (hVar instanceof g) {
            g gVar = (g) hVar;
            return new ds0.l(gVar.a, gVar.b, this.f53f, this.d, this.e);
        }
        if (hVar instanceof a) {
            a aVar = (a) hVar;
            return new ds0.l(aVar.a, aVar.c, this.f53f, this.d, this.e);
        }
        if (!(hVar instanceof f)) {
            throw new NoWhenBranchMatchedException();
        }
        f fVar = (f) hVar;
        return new ds0.l(fVar.a, fVar.b, this.f53f, this.d, this.e);
    }
}
