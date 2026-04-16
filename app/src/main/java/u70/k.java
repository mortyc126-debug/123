package u70;

import a2.q1;
import a2.z0;
import a3.x;
import a4.z;
import com.gnacba.amuvvoafs.gms.internal.measurement.b4;
import com.gnacba.amuvvoafs.gms.internal.measurement.i4;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import com.google.android.material.R;
import f2.a0;
import f2.c0;
import g4.d0;
import ld1.r;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.functions.Function4;
import lu0.f;
import lx1.b0;
import md1.n0;
import of1.q;
import org.apache.commons.net.ftp.FTPReply;
import rd1.w;
import rw0.m0;
import st.w0;
import tlydtdl.compose.foundation.layout.e0;
import tlydtdl.compose.foundation.layout.e2;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.foundation.layout.v2;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.u1;
import tlydtdl.compose.runtime.x0;
import wz0.i0;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static final q3.k a = new q3.k(new x(16), false, 1492886289);

    public static final void a(e eVar, tlydtdl.compose.runtime.m mVar, int i) {
        lmjxuqdtp.jvm.internal.o.h(eVar, "state");
        s sVar = (s) mVar;
        sVar.h0(568972495);
        int i2 = (sVar.g(eVar) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            e1 e1VarR = w0.r(eVar.b, sVar, 0, 7);
            a0 a0VarA = c0.a(0, 0, sVar, 3);
            int i3 = i2 & 14;
            boolean zG = sVar.g(a0VarA) | (i3 == 4);
            Object objR = sVar.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (zG || objR == x0Var) {
                ge1.d dVar = new ge1.d(a0VarA, null, null, eVar.d, 6);
                sVar.q0(dVar);
                objR = dVar;
            }
            es1.c.g((ge1.d) objR, sVar, 0);
            boolean zG2 = sVar.g(a0VarA) | (i3 == 4);
            Object objR2 = sVar.R();
            if (zG2 || objR2 == x0Var) {
                objR2 = new ah.n(eVar, a0VarA, (qx1.d) null, 15);
                sVar.q0(objR2);
            }
            tlydtdl.compose.runtime.a0.f(sVar, b0.a, (Function2) objR2);
            ze1.d.c(((Boolean) e1VarR.getValue()).booleanValue(), eVar.c, o2.d(t3.m.a, 1.0f), (t3.d) null, false, (ze1.n) null, 0.0f, q3.p.d(1771265898, new z0(20, eVar, a0VarA), sVar), sVar, 12583296, FTPReply.SERVICE_NOT_READY);
            v70.c cVar = eVar.g;
            if (cVar == null) {
                sVar.f0(-1975087105);
            } else {
                sVar.f0(-1975087104);
                z10.d.e(cVar, sVar, 0);
            }
            sVar.r(false);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new ln0.b(eVar, i, 28);
        }
    }

    public static final void b(rw0.d dVar, a0 a0Var, int i, tlydtdl.compose.runtime.m mVar, int i2) {
        int i3;
        s sVar = (s) mVar;
        sVar.h0(-447191491);
        if ((i2 & 6) == 0) {
            i3 = ((i2 & 8) == 0 ? sVar.g(dVar) : sVar.i(dVar) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 384) == 0) {
            i3 |= sVar.e(i) ? 256 : 128;
        }
        if (sVar.W(i3 & 1, (i3 & 131) != 130)) {
            v70.d dVar2 = (vu0.d) dVar.a;
            boolean z = dVar2 instanceof v70.d;
            t3.m mVar2 = t3.m.a;
            if (z) {
                sVar.f0(-254287787);
                aq1.b.d(dVar2, com.bandlab.uikit.compose.a.b(tlydtdl.compose.foundation.layout.m.C(o2.e(tlydtdl.compose.foundation.layout.m.H(mVar2, 0.0f, 8, 0.0f, 0.0f, 13), 1.0f), x10.a.j(sVar))), sVar, 0);
                sVar.r(false);
            } else if (dVar2 instanceof l) {
                sVar.f0(-254278690);
                c((l) dVar2, sVar, 0);
                sVar.r(false);
            } else {
                if (dVar2 instanceof x20.k) {
                    sVar.f0(707383306);
                    i0 i0Var = ((x20.k) dVar2).a;
                    v80.h hVar = i0Var.k;
                    x10.a.b(tlydtdl.compose.foundation.layout.m.H(mVar2, 0.0f, 8, 0.0f, 0.0f, 13), new i4(true, hVar != null ? (ny1.l) hVar.b : null, i0Var.l), (e2) null, q3.p.d(693663957, new pd1.b(dVar2, i, 1), sVar), sVar, 3078, 4);
                } else {
                    sVar.f0(702632773);
                }
                sVar.r(false);
            }
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new f(i, i2, 1, dVar, a0Var);
        }
    }

    public static final void c(final l lVar, tlydtdl.compose.runtime.m mVar, final int i) {
        s sVar = (s) mVar;
        sVar.h0(1152002197);
        int i2 = (sVar.g(lVar) ? 4 : 2) | i;
        if (!sVar.W(i2 & 1, (i2 & 3) != 2)) {
            sVar.Z();
        } else {
            if (!lVar.b) {
                a2 a2VarV = sVar.v();
                if (a2VarV != null) {
                    final int i3 = 0;
                    a2VarV.d = new Function2(lVar, i, i3) { // from class: u70.d
                        public final /* synthetic */ int a;
                        public final /* synthetic */ l b;

                        {
                            this.a = i3;
                        }

                        public final Object invoke(Object obj, Object obj2) {
                            int i4 = this.a;
                            tlydtdl.compose.runtime.m mVar2 = (tlydtdl.compose.runtime.m) obj;
                            ((Integer) obj2).getClass();
                            switch (i4) {
                                case 0:
                                    k.c(this.b, mVar2, tlydtdl.compose.runtime.a0.B(1));
                                    break;
                                default:
                                    k.c(this.b, mVar2, tlydtdl.compose.runtime.a0.B(1));
                                    break;
                            }
                            return b0.a;
                        }
                    };
                    return;
                }
                return;
            }
            float f2 = 8;
            t3.m mVar2 = t3.m.a;
            float f3 = 16;
            t3.p pVarV = b4.v(com.bandlab.uikit.compose.a.b(tlydtdl.compose.foundation.layout.m.C(o2.e(tlydtdl.compose.foundation.layout.m.H(mVar2, 0.0f, f2, 0.0f, 0.0f, 13), 1.0f), x10.a.j(sVar))), l2.f.b(f3));
            ld1.d dVar = r.Companion;
            t3.p pVarF = tlydtdl.compose.foundation.layout.m.F(com.facebook.appevents.l.m(pVarV, i.u(dVar, 2131100885), a4.w0.a), 0.0f, f3, 1);
            e0 e0VarA = tlydtdl.compose.foundation.layout.c0.a(tlydtdl.compose.foundation.layout.l.g(f2), t3.c.m, sVar, 6);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            t3.p pVarX = j4.x(sVar, pVarF);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, e0VarA, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
            z10.d.h(com.ironsource.adqualitysdk.sdk.i.a0.v(v.Companion, 2132020396), i.u(dVar, R.dimen.m3_comp_fab_primary_large_icon_size), q.i(), tlydtdl.compose.foundation.layout.m.H(mVar2, f3, 0.0f, 0.0f, 0.0f, 14), false, (of1.e) null, 0, (Function1) null, sVar, 3072, 240);
            rw0.b.d(lVar.a, a, (t3.p) null, (t3.p) null, (a0) null, tlydtdl.compose.foundation.layout.m.f(f3, 0.0f, 2), tlydtdl.compose.foundation.layout.l.g(f2), (t3.g) null, (q1) null, (v2) null, false, (Function1) null, (Function4) null, (Function4) null, (Function4) null, (m0) null, false, sVar, 12779568, 0, 0, 2096988);
            sVar = sVar;
            sVar.r(true);
        }
        a2 a2VarV2 = sVar.v();
        if (a2VarV2 != null) {
            final int i4 = 1;
            a2VarV2.d = new Function2(lVar, i, i4) { // from class: u70.d
                public final /* synthetic */ int a;
                public final /* synthetic */ l b;

                {
                    this.a = i4;
                }

                public final Object invoke(Object obj, Object obj2) {
                    int i42 = this.a;
                    tlydtdl.compose.runtime.m mVar22 = (tlydtdl.compose.runtime.m) obj;
                    ((Integer) obj2).getClass();
                    switch (i42) {
                        case 0:
                            k.c(this.b, mVar22, tlydtdl.compose.runtime.a0.B(1));
                            break;
                        default:
                            k.c(this.b, mVar22, tlydtdl.compose.runtime.a0.B(1));
                            break;
                    }
                    return b0.a;
                }
            };
        }
    }

    public static final void d(o oVar, tlydtdl.compose.runtime.m mVar, int i) {
        s sVar = (s) mVar;
        sVar.h0(-601055793);
        int i2 = i | (sVar.g(oVar) ? 4 : 2);
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            t3.m mVar2 = t3.m.a;
            t3.p pVarV = b4.v(o2.u(mVar2, 136), l2.f.b(12));
            ld1.d dVar = r.Companion;
            float f2 = 16;
            t3.p pVarD = tlydtdl.compose.foundation.layout.m.D(md1.g.v(com.facebook.appevents.l.m(pVarV, i.u(dVar, 2131100892), a4.w0.a), (n0) null, (a5.h) null, false, false, (Function0) null, (Function0) null, oVar.e, 63), f2);
            e0 e0VarA = tlydtdl.compose.foundation.layout.c0.a(tlydtdl.compose.foundation.layout.l.g(f2), t3.c.n, sVar, 54);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            t3.p pVarX = j4.x(sVar, pVarD);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, e0VarA, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
            fe1.f.a(oVar.c, (String) null, l2.f.b(8), o2.p(mVar2, 72), (t3.d) null, (q4.m) null, 0.0f, (z) null, (Function0) null, false, (n0) null, (fe1.j) null, (fe1.g) null, false, (Function3) null, (fe1.k) null, sVar, 3120, 0, 65520);
            z10.d.h(oVar.b, i.u(dVar, R.dimen.m3_comp_fab_primary_large_icon_size), q.c(), (t3.p) null, false, of1.e.f370f, 0, (Function1) null, sVar, 0, 216);
            d0 d0Var = (d0) oVar.d.b;
            jf1.a aVar = jf1.a.a;
            rd1.a0.a.getClass();
            sVar = sVar;
            by1.b.c(d0Var, jf1.g.a, aVar, (t3.p) null, w.d, sVar, 0);
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new ln0.b(oVar, i, 27);
        }
    }
}
