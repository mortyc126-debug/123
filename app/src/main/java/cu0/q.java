package cu0;

import ak.g3;
import d10.j;
import dg1.c;
import hu0.i;
import ju0.a;
import ky1.a0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import ny1.b2;
import ny1.j2;
import ny1.o2;
import ny1.z;
import qx1.d;
import rz.j0;
import ur.t;
import ut0.f;
import yr.w1;
import zj.u2;
import zj.v1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q {
    public final v1 a;
    public final u2 b;
    public final a0 c;
    public final f d;
    public final t e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w1 f66f;
    public final eu0.k g;
    public final ny1.l h;
    public final b2 i;

    public q(v1 v1Var, u2 u2Var, a0 a0Var, f fVar, t tVar, w1 w1Var, eu0.k kVar, com.gnacba.firebase.messaging.a0 a0Var2, i iVar) {
        this.a = v1Var;
        this.b = u2Var;
        this.c = a0Var;
        this.d = fVar;
        this.e = tVar;
        this.f66f = w1Var;
        this.g = kVar;
        g3 g3Var = new g3(fVar.k, 13);
        ny1.l lVarU = z.u(new n(g3Var, 0));
        this.h = lVarU;
        n nVar = new n(g3Var, 1);
        j0 j0VarW = com.facebook.appevents.p.w(nVar, u2Var.h, z.U(lVarU, new k(null, a0Var2, 0)), z.U(lVarU, new l(null, iVar, 0)), z.U(new j(z.U(lVarU, new b((d) null, this, 0)), new g(nVar, 1), new ao0.h(3, 4, (d) null), 9), new e(null, this, 1)), z.m(z.U(lVarU, new e(null, this, 0)), u2Var.h, new g(nVar, 0), new h(this, null)), new p(0, null));
        o2 o2VarA = j2.a(3);
        dg1.d.a.getClass();
        this.i = z.R(j0VarW, a0Var, o2VarA, new du0.g(null, c.b, new a(false, (dg1.i) null), null, true, null));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public static final du0.f a(q qVar, js0.p pVar) throws NoWhenBranchMatchedException {
        int i = a.$EnumSwitchMapping$1[pVar.ordinal()];
        if (i == 1) {
            return du0.f.a;
        }
        if (i == 2) {
            return du0.f.c;
        }
        if (i == 3) {
            return du0.f.b;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void b(du0.h hVar) throws NoWhenBranchMatchedException {
        du0.h hVar2 = ((du0.g) this.i.a.getValue()).a;
        f fVar = this.d;
        if (hVar2 == hVar) {
            if (((Boolean) this.b.h.getValue()).booleanValue()) {
                return;
            }
            fVar.a();
            return;
        }
        int iOrdinal = hVar.ordinal();
        if (iOrdinal == 0) {
            fVar.c();
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            f.b(fVar, ((Boolean) fVar.l.getValue()).booleanValue() ? zg0.j0.c : zg0.j0.b);
        }
    }
}
