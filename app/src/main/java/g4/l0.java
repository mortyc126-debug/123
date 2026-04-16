package g4;

import tlydtdl.compose.foundation.lazy.layout.r1;
import tlydtdl.compose.runtime.k1;
import tlydtdl.compose.runtime.n1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 extends f4.b {
    public final n1 a = tlydtdl.compose.runtime.a0.t(new z3.e(0));
    public final n1 b = tlydtdl.compose.runtime.a0.t(Boolean.FALSE);
    public final g0 c;
    public final k1 d;
    public float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a4.z f169f;
    public int g;

    public l0(c cVar) {
        g0 g0Var = new g0(cVar);
        g0Var.f161f = new b5.b(2, this);
        this.c = g0Var;
        this.d = new k1(0);
        this.e = 1.0f;
        this.g = -1;
    }

    public final boolean applyAlpha(float f2) {
        this.e = f2;
        return true;
    }

    public final boolean applyColorFilter(a4.z zVar) {
        this.f169f = zVar;
        return true;
    }

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public final long m133getIntrinsicSizeNHjbRc() {
        return ((z3.e) this.a.getValue()).a;
    }

    public final void onDraw(c4.d dVar) {
        a4.z zVar = this.f169f;
        g0 g0Var = this.c;
        if (zVar == null) {
            zVar = (a4.z) g0Var.g.getValue();
        }
        if (((Boolean) this.b.getValue()).booleanValue() && dVar.getLayoutDirection() == p5.n.b) {
            long jH0 = dVar.H0();
            r1 r1VarX0 = dVar.x0();
            long jO = r1VarX0.o();
            r1VarX0.j().o();
            try {
                ((ru1.c) r1VarX0.c).t(jH0, -1.0f, 1.0f);
                g0Var.e(dVar, this.e, zVar);
            } finally {
                s1.a.v(r1VarX0, jO);
            }
        } else {
            g0Var.e(dVar, this.e, zVar);
        }
        this.g = this.d.h();
    }
}
