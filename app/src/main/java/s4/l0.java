package s4;

import a4.u0;
import a4.z;
import java.util.ArrayList;
import lmjxuqdtp.KotlinNothingValueException;
import q4.m1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 implements c4.d {
    public final c4.b a = new c4.b();
    public q b;

    public final void A0(u0 u0Var, float f2, long j2) {
        this.a.A0(u0Var, f2, j2);
    }

    public final void C(long j2, long j3, long j4, long j5, c4.e eVar, float f2, int i) {
        this.a.C(j2, j3, j4, j5, eVar, f2, i);
    }

    public final void D(a4.u uVar, long j2, long j3, float f2, float f3) {
        this.a.D(uVar, j2, j3, f2, f3);
    }

    public final void E(long j2, long j3, long j4, float f2, int i, a4.t0 t0Var, float f3) {
        this.a.E(j2, j3, j4, f2, i, t0Var, f3);
    }

    public final void E0(ArrayList arrayList, long j2, float f2) {
        this.a.E0(arrayList, j2, f2);
    }

    public final void F0(a4.h hVar, long j2, z zVar) {
        this.a.F0(hVar, j2, zVar);
    }

    public final void H(a4.h hVar, long j2, long j3, long j4, float f2, z zVar, int i, int i2) {
        this.a.H(hVar, j2, j3, j4, f2, zVar, i, i2);
    }

    public final long H0() {
        return this.a.H0();
    }

    public final long J0(long j2) {
        return this.a.J0(j2);
    }

    public final void L(long j2, float f2, float f3, boolean z, long j3, long j4, float f4, c4.e eVar) {
        this.a.L(j2, f2, f3, z, j3, j4, f4, eVar);
    }

    public final void L0(long j2, long j3, long j4, float f2, c4.e eVar, int i) {
        this.a.L0(j2, j3, j4, f2, eVar, i);
    }

    public final int O(float f2) {
        return this.a.O(f2);
    }

    public final void P(a4.k kVar, long j2, float f2, c4.e eVar) {
        this.a.P(kVar, j2, f2, eVar);
    }

    public final void P0(a4.u uVar, long j2, long j3, float f2, c4.e eVar, int i) {
        this.a.P0(uVar, j2, j3, f2, eVar, i);
    }

    public final float U(long j2) {
        return this.a.U(j2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    public final void b() throws KotlinNothingValueException {
        c4.b bVar = this.a;
        a4.w wVarJ = bVar.b.j();
        t3.o oVar = this.b;
        if (oVar == null) {
            throw s1.a.q("Attempting to drawContent for a `null` node. This usually means that a call to ContentDrawScope#drawContent() has been captured inside a lambda, and is being invoked outside of the draw pass. Capturing the scope this way is unsupported - if you are trying to record drawContent with graphicsLayer.record(), make sure you are using the GraphicsLayer#record function within DrawScope, instead of the member function on GraphicsLayer.");
        }
        t3.o oVar2 = oVar;
        t3.o child$ui_release = oVar2.getNode().getChild$ui_release();
        if (child$ui_release == null || (child$ui_release.getAggregateChildKindSet$ui_release() & 4) == 0) {
            child$ui_release = null;
        } else {
            while (child$ui_release != null && (child$ui_release.getKindSet$ui_release() & 2) == 0) {
                if ((child$ui_release.getKindSet$ui_release() & 4) != 0) {
                    break;
                } else {
                    child$ui_release = child$ui_release.getChild$ui_release();
                }
            }
            child$ui_release = null;
        }
        if (child$ui_release == null) {
            k1 k1VarS = g.s(oVar, 4);
            if (k1VarS.j1() == oVar2.getNode()) {
                k1VarS = k1VarS.p;
                lmjxuqdtp.jvm.internal.o.e(k1VarS);
            }
            k1VarS.y1(wVarJ, (d4.c) bVar.b.b);
            return;
        }
        k3.e eVar = null;
        while (child$ui_release != null) {
            if (child$ui_release instanceof q) {
                q qVar = (q) child$ui_release;
                d4.c cVar = (d4.c) bVar.b.b;
                k1 k1VarS2 = g.s(qVar, 4);
                long jP = ln1.e.P(((m1) k1VarS2).c);
                j0 j0Var = k1VarS2.o;
                j0Var.getClass();
                m0.a(j0Var).getSharedDrawScope().c(wVarJ, jP, k1VarS2, qVar, cVar);
            } else if ((child$ui_release.getKindSet$ui_release() & 4) != 0 && (child$ui_release instanceof o)) {
                int i = 0;
                for (t3.o child$ui_release2 = ((o) child$ui_release).b; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild$ui_release()) {
                    if ((child$ui_release2.getKindSet$ui_release() & 4) != 0) {
                        i++;
                        if (i == 1) {
                            child$ui_release = child$ui_release2;
                        } else {
                            if (eVar == null) {
                                eVar = new k3.e(0, new t3.o[16]);
                            }
                            if (child$ui_release != null) {
                                eVar.d(child$ui_release);
                                child$ui_release = null;
                            }
                            eVar.d(child$ui_release2);
                        }
                    }
                }
                if (i == 1) {
                }
            }
            child$ui_release = g.e(eVar);
        }
    }

    public final void c(a4.w wVar, long j2, k1 k1Var, q qVar, d4.c cVar) {
        q qVar2 = this.b;
        this.b = qVar;
        p5.n nVar = k1Var.o.y;
        c4.b bVar = this.a;
        tlydtdl.compose.foundation.lazy.layout.r1 r1Var = bVar.b;
        c4.a aVar = ((c4.b) r1Var.d).a;
        p5.c cVar2 = aVar.a;
        p5.n nVar2 = aVar.b;
        a4.w wVarJ = r1Var.j();
        tlydtdl.compose.foundation.lazy.layout.r1 r1Var2 = bVar.b;
        long jO = r1Var2.o();
        d4.c cVar3 = (d4.c) r1Var2.b;
        r1Var2.v(k1Var);
        r1Var2.x(nVar);
        r1Var2.u(wVar);
        r1Var2.y(j2);
        r1Var2.b = cVar;
        wVar.o();
        try {
            qVar.g(this);
            wVar.k();
            r1Var2.v(cVar2);
            r1Var2.x(nVar2);
            r1Var2.u(wVarJ);
            r1Var2.y(jO);
            r1Var2.b = cVar3;
            this.b = qVar2;
        } catch (Throwable th) {
            wVar.k();
            r1Var2.v(cVar2);
            r1Var2.x(nVar2);
            r1Var2.u(wVarJ);
            r1Var2.y(jO);
            r1Var2.b = cVar3;
            throw th;
        }
    }

    public final float e() {
        return this.a.e();
    }

    public final p5.n getLayoutDirection() {
        return this.a.a.b;
    }

    public final long h() {
        return this.a.h();
    }

    public final void h0(long j2, float f2, long j3, float f3, c4.e eVar, int i) {
        this.a.h0(j2, f2, j3, f3, eVar, i);
    }

    public final void i0(long j2, long j3, int i) {
        this.a.i0(j2, j3, i);
    }

    public final long o(float f2) {
        return this.a.o(f2);
    }

    public final long p(long j2) {
        return this.a.p(j2);
    }

    public final float p0(int i) {
        return this.a.p0(i);
    }

    public final float q(long j2) {
        return this.a.q(j2);
    }

    public final float q0(float f2) {
        return f2 / this.a.e();
    }

    public final void t(a4.u uVar, long j2, long j3, long j4, float f2, c4.e eVar) {
        this.a.t(uVar, j2, j3, j4, f2, eVar);
    }

    public final float u0() {
        return this.a.u0();
    }

    public final float w0(float f2) {
        return this.a.e() * f2;
    }

    public final tlydtdl.compose.foundation.lazy.layout.r1 x0() {
        return this.a.b;
    }

    public final long y(float f2) {
        return this.a.y(f2);
    }

    public final void z0(a4.k kVar, a4.u uVar, float f2, c4.e eVar, int i) {
        this.a.z0(kVar, uVar, f2, eVar, i);
    }
}
