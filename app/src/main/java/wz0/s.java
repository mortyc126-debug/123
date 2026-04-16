package wz0;

import a2.x3;
import bw.l;
import ch0.b;
import com.gnacba.amuvvoafs.gms.internal.measurement.i4;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function3;
import md1.g;
import ny1.p2;
import s4.i;
import s4.j;
import s4.k;
import st.w0;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.foundation.layout.x1;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.u1;
import tlydtdl.compose.runtime.x0;
import we1.h;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements Function3 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ i0 b;
    public final /* synthetic */ float c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f673f;
    public final /* synthetic */ Boolean g;
    public final /* synthetic */ e1 h;
    public final /* synthetic */ e1 i;

    public /* synthetic */ s(boolean z, i0 i0Var, float f2, boolean z2, boolean z3, String str, Boolean bool, e1 e1Var, e1 e1Var2) {
        this.a = z;
        this.b = i0Var;
        this.c = f2;
        this.d = z2;
        this.e = z3;
        this.f673f = str;
        this.g = bool;
        this.h = e1Var;
        this.i = e1Var2;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i;
        e1 e1VarR;
        final xz0.w wVar;
        boolean z;
        i4 i4Var;
        lg.f fVar;
        tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        lmjxuqdtp.jvm.internal.o.h((tlydtdl.compose.foundation.layout.f0) obj, "$this$PostContainer");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        if (sVar.W(iIntValue & 1, (iIntValue & 17) != 16)) {
            t3.m mVar2 = t3.m.a;
            boolean z2 = this.a;
            i0 i0Var = this.b;
            float f2 = this.c;
            if (z2) {
                sVar.f0(1999518321);
                if (i0Var == null || !i0Var.c) {
                    sVar.f0(1999543896);
                    y10.r.l(i0Var != null ? i0Var.k : null, sVar, 0);
                } else {
                    sVar.f0(1981175962);
                }
                sVar.r(false);
                if (i0Var == null || !i0Var.c) {
                    sVar.f0(1999919709);
                    y10.r.h(i0Var != null ? i0Var.m : null, tlydtdl.compose.foundation.layout.m.F(mVar2, f2, 0.0f, 2), sVar, 0, 0);
                    sVar.r(false);
                } else {
                    sVar.f0(1999673941);
                    y10.r.y(i0Var.m, tlydtdl.compose.foundation.layout.m.F(mVar2, f2, 0.0f, 2), i0Var.q instanceof l, sVar, 0);
                    sVar.r(false);
                }
            } else {
                sVar.f0(1981175962);
            }
            sVar.r(false);
            float f3 = 8;
            tlydtdl.compose.foundation.layout.e0 e0VarA = tlydtdl.compose.foundation.layout.c0.a(tlydtdl.compose.foundation.layout.l.g(f3), t3.c.m, sVar, 6);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            t3.p pVarX = j4.x(sVar, mVar2);
            s4.l.f436d2.getClass();
            j jVar = k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, e0VarA, k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, k.e);
            i iVar = k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, k.d);
            if (i0Var == null || i0Var.p == z.a) {
                sVar.f0(-1470585641);
                i = -1489713788;
                y10.r.r(i0Var != null ? i0Var.n : null, i0Var != null ? i0Var.o : null, i0Var == null, (t3.p) null, sVar, 0, 8);
                sVar.r(false);
            } else {
                sVar.f0(-1489713788);
                sVar.r(false);
                i = -1489713788;
            }
            t3.p pVarF = tlydtdl.compose.foundation.layout.m.F(mVar2, b.A(sVar) ? f2 : 0, 0.0f, 2);
            p2 p2Var = i0Var != null ? i0Var.h : null;
            if (p2Var == null) {
                sVar.f0(-1470196282);
                sVar.r(false);
                e1VarR = null;
            } else {
                sVar.f0(1615142299);
                e1VarR = w0.r(p2Var, sVar, 0, 7);
                sVar.r(false);
            }
            h hVar = e1VarR != null ? (h) e1VarR.getValue() : null;
            if (hVar == null) {
                sVar.f0(-1470139893);
            } else {
                sVar.f0(-1470139892);
                com.facebook.appevents.p.e(hVar, (t3.p) null, (Function3) null, sVar, 0, 6);
                sVar = sVar;
            }
            sVar.r(false);
            boolean z3 = this.e;
            y10.r.t(i0Var, pVarF, z3, this.f673f, sVar, 0, 0);
            if ((i0Var != null ? i0Var.p : null) == z.b) {
                sVar.f0(-1469767923);
                y10.r.r(i0Var.n, i0Var.o, false, tlydtdl.compose.foundation.layout.m.F(mVar2, f2, 0.0f, 2), sVar, 384, 0);
            } else {
                sVar.f0(i);
            }
            sVar.r(false);
            if ((i0Var != null ? i0Var.q : null) instanceof xz0.w) {
                Object obj4 = i0Var.q;
                lmjxuqdtp.jvm.internal.o.f(obj4, "null cannot be cast to non-null type com.bandlab.post.ui.entity.TrackState");
                wVar = (xz0.w) obj4;
            } else {
                wVar = null;
            }
            if (z3) {
                sVar.f0(-1469327227);
                y10.r.A(f2, i0Var, wVar, sVar, 0);
            } else {
                sVar.f0(i);
            }
            sVar.r(false);
            lg.f fVar2 = i0Var != null ? i0Var.r : null;
            if (z3 && wVar != null && wVar.k) {
                sVar.f0(1615182224);
                z = !b.A(sVar);
                sVar.r(false);
            } else {
                sVar.f0(-1468957371);
                sVar.r(false);
                z = false;
            }
            boolean zG = sVar.g(wVar);
            Object objR = sVar.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (zG || objR == x0Var) {
                final int i2 = 0;
                objR = new Function0() { // from class: wz0.x
                    public final Object invoke() {
                        Function0 function0;
                        switch (i2) {
                            case 0:
                                xz0.w wVar2 = wVar;
                                if (wVar2 != null && (function0 = wVar2.t) != null) {
                                    function0.invoke();
                                }
                                break;
                            case 1:
                                wVar.q.invoke();
                                break;
                            default:
                                xz0.w wVar3 = wVar;
                                if (wVar3 != null) {
                                    wVar3.q.invoke();
                                }
                                break;
                        }
                        return lx1.b0.a;
                    }
                };
                sVar.q0(objR);
            }
            Function0 function0 = (Function0) objR;
            sVar.f0(1615192099);
            if (i0Var != null && (fVar = i0Var.r) != null && fVar.b) {
                f3 = 4;
            }
            t3.p pVarF2 = tlydtdl.compose.foundation.layout.m.F(tlydtdl.compose.foundation.layout.m.H(mVar2, 0.0f, f3, 0.0f, 0.0f, 13), f2, 0.0f, 2);
            if (lmjxuqdtp.jvm.internal.o.c(this.g, Boolean.TRUE) && !i0Var.c) {
                Object objR2 = sVar.R();
                if (objR2 == x0Var) {
                    objR2 = new x3(19, this.h);
                    sVar.q0(objR2);
                }
                Function1 function1 = (Function1) objR2;
                Object objR3 = sVar.R();
                if (objR3 == x0Var) {
                    objR3 = new x1(13, function1);
                    sVar.q0(objR3);
                }
                pVarF2 = pVarF2.then(tlydtdl.compose.ui.layout.a.f(mVar2, (Function1) objR3));
            }
            sVar.r(false);
            y10.r.a(fVar2, z, function0, pVarF2, sVar, 0);
            if (((i0Var == null || (i4Var = i0Var.s) == null) ? null : (es0.l) i4Var.c) != null) {
                sVar.f0(-1468317650);
                p2 p2Var2 = i0Var.f669f;
                boolean zBooleanValue = ((Boolean) this.i.getValue()).booleanValue();
                t3.p pVarH = tlydtdl.compose.foundation.layout.m.H(o2.e(mVar2, 1.0f), f2, 4, f2, 0.0f, 8);
                boolean zG2 = sVar.g(i0Var);
                Object objR4 = sVar.R();
                if (zG2 || objR4 == x0Var) {
                    objR4 = new sf1.h(22, i0Var);
                    sVar.q0(objR4);
                }
                y10.r.j(p2Var2, zBooleanValue, g.v(pVarH, (md1.n0) null, (a5.h) null, false, false, (Function0) null, (Function0) null, (Function0) objR4, 63), sVar, 0);
            } else {
                sVar.f0(i);
            }
            sVar.r(false);
            sVar.r(true);
            y10.r.B(i0Var != null ? i0Var.s : null, this.d, sVar, 0);
        } else {
            sVar.Z();
        }
        return lx1.b0.a;
    }
}
