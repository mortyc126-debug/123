package s4;

import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import q4.u0;
import tlydtdl.compose.runtime.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g1 extends lmjxuqdtp.jvm.internal.p implements Function2 {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g1(int i, Object obj, Object obj2) {
        super(2);
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final Object invoke(Object obj, Object obj2) {
        int i = this.c;
        lx1.b0 b0Var = lx1.b0.a;
        Object obj3 = this.e;
        Object obj4 = this.d;
        switch (i) {
            case 0:
                a4.w wVar = (a4.w) obj;
                d4.c cVar = (d4.c) obj2;
                k1 k1Var = (k1) obj4;
                j0 j0Var = k1Var.o;
                if (!j0Var.J()) {
                    k1Var.H = true;
                } else {
                    k1Var.E = wVar;
                    k1Var.D = cVar;
                    u1 snapshotObserver = m0.a(j0Var).getSnapshotObserver();
                    a4.x0 x0Var = k1.K;
                    snapshotObserver.a(k1Var, f.f429f, (h1) obj3);
                    k1Var.H = false;
                }
                break;
            case 1:
                ((Number) obj2).intValue();
                t4.r0.a((t4.x) obj4, (Function2) obj3, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(1));
                break;
            default:
                tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj;
                int iIntValue = ((Number) obj2).intValue();
                t5.c0 c0Var = (t5.c0) obj4;
                s sVar = (s) mVar;
                if (!sVar.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                    sVar.Z();
                } else {
                    Object objR = sVar.R();
                    tlydtdl.compose.runtime.x0 x0Var2 = tlydtdl.compose.runtime.l.a;
                    if (objR == x0Var2) {
                        objR = t5.k.f;
                        sVar.q0(objR);
                    }
                    t3.p pVarC = a5.m.c(t3.m.a, false, (Function1) objR);
                    boolean zI = sVar.i(c0Var);
                    Object objR2 = sVar.R();
                    if (zI || objR2 == x0Var2) {
                        objR2 = new t5.l(c0Var, 1);
                        sVar.q0(objR2);
                    }
                    t3.p pVarF = com.facebook.internal.t0.f(tlydtdl.compose.ui.layout.a.g(pVarC, (Function1) objR2), c0Var.getCanCalculatePosition() ? 1.0f : 0.0f);
                    Function2 function2 = (Function2) ((tlydtdl.compose.runtime.e1) obj3).getValue();
                    Object objR3 = sVar.R();
                    if (objR3 == x0Var2) {
                        objR3 = t5.n.a;
                        sVar.q0(objR3);
                    }
                    u0 u0Var = (u0) objR3;
                    int iHashCode = Long.hashCode(sVar.T);
                    tlydtdl.compose.runtime.u1 u1VarM = sVar.m();
                    t3.p pVarX = j4.x(sVar, pVarF);
                    l.f436d2.getClass();
                    j jVar = k.b;
                    sVar.j0();
                    if (sVar.S) {
                        sVar.l(jVar);
                    } else {
                        sVar.t0();
                    }
                    tlydtdl.compose.runtime.a0.y(sVar, u0Var, k.f435f);
                    tlydtdl.compose.runtime.a0.y(sVar, u1VarM, k.e);
                    i iVar = k.g;
                    if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                        i.x(iHashCode, sVar, iHashCode, iVar);
                    }
                    tlydtdl.compose.runtime.a0.y(sVar, pVarX, k.d);
                    i.y(0, function2, sVar, true);
                }
                break;
        }
        return b0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g1(t4.x xVar, Function2 function2, int i) {
        super(2);
        this.c = 1;
        this.d = xVar;
        this.e = function2;
    }
}
