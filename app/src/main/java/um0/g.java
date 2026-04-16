package um0;

import com.facebook.appevents.p;
import cu0.k;
import dg1.c;
import hu0.i;
import ju0.a;
import ky1.a0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import ny1.b2;
import ny1.j2;
import ny1.l;
import ny1.o2;
import ny1.z;
import qu0.u;
import rz.j0;
import vm0.e;
import zg0.y1;
import zj.u2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public final u2 a;
    public final ut0.f b;
    public final a0 c;
    public final u d;
    public final b2 e;

    public g(com.gnacba.firebase.messaging.a0 a0Var, i iVar, u2 u2Var, ut0.f fVar, a0 a0Var2, u uVar) {
        this.a = u2Var;
        this.b = fVar;
        this.c = a0Var2;
        this.d = uVar;
        nc0.g gVar = new nc0.g(fVar.k, 15);
        l lVarU = z.u(new d(gVar, 0));
        j0 j0VarW = p.w(new d(gVar, 1), z.U(lVarU, new k(null, a0Var, 3)), z.U(lVarU, new cu0.l(null, iVar, 3)), (nc0.g) uVar.c, u2Var.h, fVar.l, new f(null));
        o2 o2VarA = j2.a(3);
        dg1.d.a.getClass();
        this.e = z.R(j0VarW, a0Var2, o2VarA, new vm0.d((e) null, c.b, new a(true, (dg1.i) null), (vm0.c) null));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void a(e eVar) throws NoWhenBranchMatchedException {
        e eVar2 = ((vm0.d) this.e.a.getValue()).a;
        ut0.f fVar = this.b;
        if (eVar2 == eVar) {
            if (((Boolean) this.a.h.getValue()).booleanValue()) {
                return;
            }
            fVar.a();
            return;
        }
        int iOrdinal = eVar.ordinal();
        if (iOrdinal == 0) {
            fVar.c();
            return;
        }
        if (iOrdinal == 1) {
            ut0.f.b(fVar, ((Boolean) fVar.l.getValue()).booleanValue() ? zg0.j0.c : zg0.j0.b);
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            fVar.e.d(y1.a);
            fVar.d();
        }
    }
}
