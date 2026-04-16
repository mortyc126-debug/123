package x2;

import a5.k;
import amuvvoafs.os.Build;
import java.util.concurrent.CancellationException;
import ky1.c0;
import ky1.t1;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import p5.c;
import p5.i;
import s4.k1;
import s4.l0;
import s4.m;
import sm.a;
import t1.b;
import t4.r1;
import tlydtdl.compose.runtime.g3;
import tlydtdl.compose.runtime.n1;
import v1.h1;
import v1.j1;
import v1.v0;
import v1.w0;
import w2.c1;
import w2.y0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends f implements m {
    public c1 c;
    public y d;
    public y0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f678f;
    public final n1 g;
    public final b h;
    public final v0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public t1 f679j;

    public h(c1 c1Var, y yVar, y0 y0Var, boolean z) {
        this.c = c1Var;
        this.d = yVar;
        this.e = y0Var;
        this.f678f = z;
        n1 n1VarT = tlydtdl.compose.runtime.a0.t(new p5.m(0L));
        this.g = n1VarT;
        this.h = new b(new z3.b(ch0.b.k(this.c, this.d, this.e, ((p5.m) n1VarT.getValue()).a)), a3.y0.b, new z3.b(a3.y0.c), 8);
        final int i = 0;
        Function1 function1 = new Function1(this) { // from class: x2.g
            public final /* synthetic */ h b;

            {
                this.b = this;
            }

            public final Object invoke(Object obj) {
                switch (i) {
                    case 0:
                        return (z3.b) this.b.h.d();
                    default:
                        i iVar = (i) obj;
                        g3 g3Var = r1.h;
                        h hVar = this.b;
                        c cVar = (c) s4.g.h(hVar, g3Var);
                        hVar.g.setValue(new p5.m((((long) cVar.O(i.c(iVar.a))) << 32) | (((long) cVar.O(i.b(iVar.a))) & 4294967295L)));
                        return b0.a;
                }
            }
        };
        final int i2 = 1;
        Function1 function12 = new Function1(this) { // from class: x2.g
            public final /* synthetic */ h b;

            {
                this.b = this;
            }

            public final Object invoke(Object obj) {
                switch (i2) {
                    case 0:
                        return (z3.b) this.b.h.d();
                    default:
                        i iVar = (i) obj;
                        g3 g3Var = r1.h;
                        h hVar = this.b;
                        c cVar = (c) s4.g.h(hVar, g3Var);
                        hVar.g.setValue(new p5.m((((long) cVar.O(i.c(iVar.a))) << 32) | (((long) cVar.O(i.b(iVar.a))) & 4294967295L)));
                        return b0.a;
                }
            }
        };
        if (!w0.a()) {
            throw new UnsupportedOperationException("Magnifier is only supported on API level 28 and higher.");
        }
        v0 v0Var = new v0(function1, function12, Build.VERSION.SDK_INT == 28 ? h1.a : j1.a);
        Q0(v0Var);
        this.i = v0Var;
    }

    @Override // x2.f
    public final void T0(c1 c1Var, y yVar, y0 y0Var, boolean z) {
        c1 c1Var2 = this.c;
        y yVar2 = this.d;
        y0 y0Var2 = this.e;
        boolean z2 = this.f678f;
        this.c = c1Var;
        this.d = yVar;
        this.e = y0Var;
        this.f678f = z;
        if (o.c(c1Var, c1Var2) && o.c(yVar, yVar2) && o.c(y0Var, y0Var2) && z == z2) {
            return;
        }
        U0();
    }

    public final void U0() {
        t1 t1Var = this.f679j;
        if (t1Var != null) {
            t1Var.a((CancellationException) null);
        }
        this.f679j = null;
        if (w0.a()) {
            this.f679j = c0.F(getCoroutineScope(), (qx1.i) null, (ky1.b0) null, new a(this, (qx1.d) null, 22), 3);
        }
    }

    @Override // x2.f, s4.b2
    public final void b(k kVar) {
        this.i.b(kVar);
    }

    @Override // x2.f
    public final void d(k1 k1Var) {
        this.i.d(k1Var);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    @Override // x2.f, s4.q
    public final void g(l0 l0Var) throws KotlinNothingValueException {
        l0Var.b();
        this.i.g(l0Var);
    }

    public final void onAttach() {
        U0();
    }
}
