package u10;

import a2.x3;
import a4.v0;
import a4.w0;
import cf1.l0;
import com.gnacba.amuvvoafs.gms.internal.measurement.b4;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import com.google.android.material.R;
import fk1.v;
import java.util.WeakHashMap;
import ld1.d;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import ny1.p2;
import okhttp3.internal.http2.Http2;
import q4.u0;
import qu0.u;
import s4.l;
import t10.t;
import t5.g0;
import tlydtdl.compose.foundation.a;
import tlydtdl.compose.foundation.layout.b2;
import tlydtdl.compose.foundation.layout.c0;
import tlydtdl.compose.foundation.layout.e;
import tlydtdl.compose.foundation.layout.e0;
import tlydtdl.compose.foundation.layout.f2;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.foundation.layout.v1;
import tlydtdl.compose.foundation.layout.x;
import tlydtdl.compose.foundation.layout.x2;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.u1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    public static final float a = (float) 0.5d;

    public static final void a(float f2, t3.p pVar, q3.k kVar, tlydtdl.compose.runtime.m mVar, int i) {
        t3.p pVar2;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-222400556);
        int i2 = i | 48;
        if (sVar.W(i2 & 1, (i2 & 147) != 146)) {
            t3.h hVar = t3.c.a;
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(hVar, false);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            pVar2 = t3.m.a;
            t3.p pVarX = j4.x(sVar, pVar2);
            l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            s4.i iVar = s4.k.f435f;
            a0.y(sVar, u0VarD, iVar);
            s4.i iVar2 = s4.k.e;
            a0.y(sVar, u1VarM, iVar2);
            s4.i iVar3 = s4.k.g;
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar3);
            }
            s4.i iVar4 = s4.k.d;
            a0.y(sVar, pVarX, iVar4);
            d dVar = ld1.r.Companion;
            long jE = i.e(2131100890, 0, sVar, dVar);
            v0 v0Var = w0.a;
            t3.p pVarV = md1.g.V(o2.u(a.c(pVar2, jE, v0Var), f2));
            u0 u0VarD2 = tlydtdl.compose.foundation.layout.s.d(hVar, false);
            int iHashCode2 = Long.hashCode(sVar.T);
            u1 u1VarM2 = sVar.m();
            t3.p pVarX2 = j4.x(sVar, pVarV);
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            a0.y(sVar, u0VarD2, iVar);
            a0.y(sVar, u1VarM2, iVar2);
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode2))) {
                i.x(iHashCode2, sVar, iHashCode2, iVar3);
            }
            a0.y(sVar, pVarX2, iVar4);
            kVar.invoke(sVar, 6);
            t3.p pVarC = o2.c(o2.u(pVar2, a), 1.0f);
            dVar.getClass();
            t3.p pVarC2 = a.c(pVarC, md1.g.y(new ld1.q(R.dimen.abc_dropdownitem_text_padding_right), sVar, 0), v0Var);
            t3.d dVar2 = t3.c.f;
            x xVar = x.a;
            tlydtdl.compose.foundation.layout.m.i(sVar, xVar.b(pVarC2, dVar2));
            sVar.r(true);
            m8.d.h(0, 0, sVar, xVar.b(tlydtdl.compose.foundation.layout.m.H(pVar2, l.a, 0.0f, 0.0f, 0.0f, 14), t3.c.i));
            sVar.r(true);
        } else {
            sVar.Z();
            pVar2 = pVar;
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new v(f2, pVar2, kVar, i);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean, int] */
    public static final void b(final t30.m mVar, u uVar, Function0 function0, t3.p pVar, t10.o oVar, final cd1.g gVar, q3.k kVar, tlydtdl.compose.runtime.m mVar2, int i) throws NoWhenBranchMatchedException {
        int i2;
        u uVar2;
        final cd1.g gVar2;
        tlydtdl.compose.runtime.s sVar;
        b4 b4Var;
        Object obj;
        ?? r2;
        tlydtdl.compose.runtime.s sVar2;
        Function0 function02;
        f2 f2VarH;
        ny1.l lVar;
        float f2;
        s4.i iVar;
        boolean z;
        tlydtdl.compose.runtime.s sVar3;
        boolean z2;
        tlydtdl.compose.runtime.s sVar4;
        b4 b4Var2 = oVar.a;
        o.h(function0, "onPopupDismiss");
        tlydtdl.compose.runtime.s sVar5 = (tlydtdl.compose.runtime.s) mVar2;
        sVar5.h0(388874682);
        if ((i & 6) == 0) {
            i2 = (sVar5.g(mVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar5.g(uVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar5.i(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar5.g(pVar) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= sVar5.g(oVar) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= sVar5.i(gVar) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i2 |= sVar5.i(kVar) ? 1048576 : 524288;
        }
        int i3 = i2;
        if (sVar5.W(i3 & 1, (i3 & 599187) != 599186)) {
            sVar5.b0();
            if ((i & 1) != 0 && !sVar5.D()) {
                sVar5.Z();
            }
            sVar5.s();
            e1 e1VarR = st.w0.r((p2) mVar.a, sVar5, 0, 7);
            me1.m mVarH = me1.a.h(sVar5);
            sVar5.f0(46432493);
            q qVar = (q) e1VarR.getValue();
            Object obj2 = tlydtdl.compose.runtime.l.a;
            if (qVar != null) {
                t10.c cVar = qVar.c;
                if (!qVar.a || cVar == null) {
                    b4Var = b4Var2;
                    obj = obj2;
                    z2 = false;
                    tlydtdl.compose.runtime.s sVar6 = sVar5;
                    sVar6.f0(-482118867);
                    sVar4 = sVar6;
                } else {
                    sVar5.f0(-478057433);
                    int i4 = cVar.b;
                    int i6 = cVar.d;
                    Object objR = sVar5.R();
                    if (objR == obj2) {
                        objR = new o(oVar, i4, i6, cVar);
                        sVar5.q0(objR);
                    }
                    mVarH.b();
                    b4Var = b4Var2;
                    tlydtdl.compose.runtime.s sVar7 = sVar5;
                    obj = obj2;
                    z2 = false;
                    me1.a.a(new me1.h(qVar.b), (t3.p) null, mVarH, 0L, (g0) null, 0L, (o) objR, function0, 0.0f, (Function3) null, sVar7, ((i3 << 18) & 234881024) | 1572864, 0, 1722);
                    sVar4 = sVar7;
                }
                sVar4.r(z2);
                r2 = z2;
                sVar2 = sVar4;
            } else {
                b4Var = b4Var2;
                obj = obj2;
                r2 = 0;
                sVar2 = sVar5;
            }
            sVar2.r(r2);
            int i7 = i3 >> 9;
            t3.h hVar = t3.c.a;
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(hVar, r2);
            int iHashCode = Long.hashCode(sVar2.T);
            u1 u1VarM = sVar2.m();
            t3.p pVarX = j4.x(sVar2, pVar);
            l.f436d2.getClass();
            Function0 function03 = s4.k.b;
            sVar2.j0();
            if (sVar2.S) {
                sVar2.l(function03);
            } else {
                sVar2.t0();
            }
            s4.i iVar2 = s4.k.f435f;
            a0.y(sVar2, u0VarD, iVar2);
            s4.i iVar3 = s4.k.e;
            a0.y(sVar2, u1VarM, iVar3);
            s4.i iVar4 = s4.k.g;
            if (sVar2.S || !o.c(sVar2.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar2, iHashCode, iVar4);
            }
            s4.i iVar5 = s4.k.d;
            a0.y(sVar2, pVarX, iVar5);
            Object objR2 = sVar2.R();
            if (objR2 == obj) {
                objR2 = a0.t(new p5.f((float) r2));
                sVar2.q0(objR2);
            }
            e1 e1Var = (e1) objR2;
            t tVar = t.c;
            b4 b4Var3 = b4Var;
            boolean zEquals = b4Var3.equals(tVar);
            t10.s sVar8 = t10.s.c;
            t10.u uVar3 = t10.u.c;
            if (zEquals) {
                function02 = function03;
                f2VarH = tlydtdl.compose.foundation.layout.m.h(l.b, 0.0f, 0.0f, 0.0f, 14);
            } else {
                function02 = function03;
                if (b4Var3.equals(uVar3)) {
                    f2VarH = tlydtdl.compose.foundation.layout.m.h(l.a, 0.0f, 0.0f, 0.0f, 14);
                } else {
                    if (!b4Var3.equals(sVar8)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    f2VarH = tlydtdl.compose.foundation.layout.m.h(0.0f, 0.0f, 0.0f, c.a + ((p5.f) e1Var.getValue()).a, 7);
                }
            }
            Integer numValueOf = Integer.valueOf(((i3 >> 12) & 896) | 6);
            x xVar = x.a;
            kVar.invoke(xVar, f2VarH, sVar2, numValueOf);
            if (b4Var3.equals(tVar)) {
                sVar2.f0(-4192336);
                final int i8 = 0;
                a(l.b, null, q3.p.d(1619703009, new Function2() { // from class: u10.m
                    public final Object invoke(Object obj3, Object obj4) {
                        int i9 = i8;
                        tlydtdl.compose.runtime.m mVar3 = (tlydtdl.compose.runtime.m) obj3;
                        int iIntValue = ((Integer) obj4).intValue();
                        switch (i9) {
                            case 0:
                                tlydtdl.compose.runtime.s sVar9 = (tlydtdl.compose.runtime.s) mVar3;
                                if (sVar9.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                                    d.a(mVar, (t3.p) null, gVar, sVar9, 0);
                                } else {
                                    sVar9.Z();
                                }
                                break;
                            default:
                                tlydtdl.compose.runtime.s sVar10 = (tlydtdl.compose.runtime.s) mVar3;
                                if (sVar10.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                                    d.c(mVar, (t3.p) null, gVar, sVar10, 0);
                                } else {
                                    sVar10.Z();
                                }
                                break;
                        }
                        return b0.a;
                    }
                }, sVar2), sVar2, 390);
                sVar2.r(false);
                uVar2 = uVar;
                gVar2 = gVar;
                z = true;
                sVar3 = sVar2;
            } else {
                gVar2 = gVar;
                if (b4Var3.equals(uVar3)) {
                    sVar2.f0(-4186080);
                    float f3 = l.a;
                    z = true;
                    final boolean z3 = true ? 1 : 0;
                    a(f3, null, q3.p.d(-117515304, new Function2() { // from class: u10.m
                        public final Object invoke(Object obj3, Object obj4) {
                            int i9 = z3;
                            tlydtdl.compose.runtime.m mVar3 = (tlydtdl.compose.runtime.m) obj3;
                            int iIntValue = ((Integer) obj4).intValue();
                            switch (i9) {
                                case 0:
                                    tlydtdl.compose.runtime.s sVar9 = (tlydtdl.compose.runtime.s) mVar3;
                                    if (sVar9.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                                        d.a(mVar, (t3.p) null, gVar2, sVar9, 0);
                                    } else {
                                        sVar9.Z();
                                    }
                                    break;
                                default:
                                    tlydtdl.compose.runtime.s sVar10 = (tlydtdl.compose.runtime.s) mVar3;
                                    if (sVar10.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                                        d.c(mVar, (t3.p) null, gVar2, sVar10, 0);
                                    } else {
                                        sVar10.Z();
                                    }
                                    break;
                            }
                            return b0.a;
                        }
                    }, sVar2), sVar2, 390);
                    sVar2.r(false);
                    uVar2 = uVar;
                    sVar3 = sVar2;
                } else {
                    if (!b4Var3.equals(sVar8)) {
                        throw com.ironsource.adqualitysdk.sdk.i.a0.q(sVar2, -4192227, false);
                    }
                    sVar2.f0(-129527856);
                    WeakHashMap weakHashMap = x2.v;
                    v1 v1Var = new v1(e.e(sVar2).k, 32);
                    float fA = c.a + tlydtdl.compose.foundation.layout.m.l(v1Var, sVar2).a();
                    p2 p2Var = (p2) uVar.c;
                    boolean zD = sVar2.d(fA);
                    Object objR3 = sVar2.R();
                    if (zD || objR3 == obj) {
                        objR3 = new b2(3, fA);
                        sVar2.q0(objR3);
                    }
                    final e1 e1VarR2 = st.w0.r(st.w0.o0(p2Var, (Function1) objR3), sVar2, 0, 7);
                    ny1.l lVar2 = (d10.j) uVar.d;
                    Object objR4 = sVar2.R();
                    if (objR4 == obj) {
                        lVar = lVar2;
                        objR4 = new x3(14, e1Var);
                        sVar2.q0(objR4);
                    } else {
                        lVar = lVar2;
                    }
                    Function1 function1 = (Function1) objR4;
                    t3.h hVar2 = t3.c.h;
                    t3.m mVar3 = t3.m.a;
                    t3.p pVarB = xVar.b(mVar3, hVar2);
                    boolean zG = sVar2.g(e1VarR2);
                    Object objR5 = sVar2.R();
                    if (zG || objR5 == obj) {
                        f2 = fA;
                        final int i9 = 0;
                        objR5 = new Function1() { // from class: u10.n
                            public final Object invoke(Object obj3) {
                                switch (i9) {
                                    case 0:
                                        p5.c cVar2 = (p5.c) obj3;
                                        o.h(cVar2, "$this$offset");
                                        return new p5.k((((long) 0) << 32) | (((long) cVar2.O(((p5.f) e1VarR2.getValue()).a)) & 4294967295L));
                                    case 1:
                                        p5.c cVar3 = (p5.c) obj3;
                                        o.h(cVar3, "$this$offset");
                                        return new p5.k((((long) 0) << 32) | (((long) cVar3.O(((p5.f) e1VarR2.getValue()).a)) & 4294967295L));
                                    case 2:
                                        l0 l0Var = (l0) obj3;
                                        o.h(l0Var, "sliderState");
                                        return (x10.v) ((un0.x) e1VarR2.getValue()).d.invoke(Float.valueOf(l0Var.b()));
                                    default:
                                        o.h((p5.c) obj3, "$this$offset");
                                        return new p5.k(((p5.k) e1VarR2.getValue()).a);
                                }
                            }
                        };
                        sVar2.q0(objR5);
                    } else {
                        f2 = fA;
                    }
                    tlydtdl.compose.runtime.s sVar9 = sVar2;
                    Function0 function04 = function02;
                    uc0.p.g(lVar, f2, function1, tlydtdl.compose.foundation.layout.m.z(pVarB, (Function1) objR5), sVar9, 384, 0);
                    tlydtdl.compose.runtime.s sVar10 = sVar9;
                    t3.p pVarB2 = xVar.b(mVar3, hVar2);
                    boolean zG2 = sVar10.g(e1VarR2);
                    Object objR6 = sVar10.R();
                    if (zG2 || objR6 == obj) {
                        final int i10 = 1;
                        objR6 = new Function1() { // from class: u10.n
                            public final Object invoke(Object obj3) {
                                switch (i10) {
                                    case 0:
                                        p5.c cVar2 = (p5.c) obj3;
                                        o.h(cVar2, "$this$offset");
                                        return new p5.k((((long) 0) << 32) | (((long) cVar2.O(((p5.f) e1VarR2.getValue()).a)) & 4294967295L));
                                    case 1:
                                        p5.c cVar3 = (p5.c) obj3;
                                        o.h(cVar3, "$this$offset");
                                        return new p5.k((((long) 0) << 32) | (((long) cVar3.O(((p5.f) e1VarR2.getValue()).a)) & 4294967295L));
                                    case 2:
                                        l0 l0Var = (l0) obj3;
                                        o.h(l0Var, "sliderState");
                                        return (x10.v) ((un0.x) e1VarR2.getValue()).d.invoke(Float.valueOf(l0Var.b()));
                                    default:
                                        o.h((p5.c) obj3, "$this$offset");
                                        return new p5.k(((p5.k) e1VarR2.getValue()).a);
                                }
                            }
                        };
                        sVar10.q0(objR6);
                    }
                    t3.p pVarZ = tlydtdl.compose.foundation.layout.m.z(pVarB2, (Function1) objR6);
                    u0 u0VarD2 = tlydtdl.compose.foundation.layout.s.d(hVar, false);
                    int iHashCode2 = Long.hashCode(sVar10.T);
                    u1 u1VarM2 = sVar10.m();
                    t3.p pVarX2 = j4.x(sVar10, pVarZ);
                    sVar10.j0();
                    if (sVar10.S) {
                        sVar10.l(function04);
                    } else {
                        sVar10.t0();
                    }
                    a0.y(sVar10, u0VarD2, iVar2);
                    a0.y(sVar10, u1VarM2, iVar3);
                    if (sVar10.S || !o.c(sVar10.R(), Integer.valueOf(iHashCode2))) {
                        iVar = iVar4;
                        i.x(iHashCode2, sVar10, iHashCode2, iVar);
                    } else {
                        iVar = iVar4;
                    }
                    a0.y(sVar10, pVarX2, iVar5);
                    e0 e0VarA = c0.a(tlydtdl.compose.foundation.layout.l.c, t3.c.m, sVar10, 0);
                    int iHashCode3 = Long.hashCode(sVar10.T);
                    u1 u1VarM3 = sVar10.m();
                    t3.p pVarX3 = j4.x(sVar10, mVar3);
                    sVar10.j0();
                    if (sVar10.S) {
                        sVar10.l(function04);
                    } else {
                        sVar10.t0();
                    }
                    a0.y(sVar10, e0VarA, iVar2);
                    a0.y(sVar10, u1VarM3, iVar3);
                    if (sVar10.S || !o.c(sVar10.R(), Integer.valueOf(iHashCode3))) {
                        i.x(iHashCode3, sVar10, iHashCode3, iVar);
                    }
                    a0.y(sVar10, pVarX3, iVar5);
                    m8.d.h(0, 1, sVar10, null);
                    d dVar = ld1.r.Companion;
                    long jE = i.e(2131100890, 0, sVar10, dVar);
                    v0 v0Var = w0.a;
                    uVar2 = uVar;
                    gVar2 = gVar;
                    c.a(uVar2, tlydtdl.compose.foundation.layout.m.O(a.c(mVar3, jE, v0Var), v1Var), gVar2, sVar10, ((i3 >> 3) & 14) | (i7 & 896));
                    sVar10.r(true);
                    t3.p pVarE = o2.e(o2.f(mVar3, a), 1.0f);
                    dVar.getClass();
                    tlydtdl.compose.foundation.layout.m.i(sVar10, xVar.b(a.c(pVarE, md1.g.y(new ld1.q(R.dimen.abc_dropdownitem_text_padding_right), sVar10, 0), v0Var), t3.c.b));
                    z = true;
                    sVar10.r(true);
                    sVar10.r(false);
                    sVar3 = sVar10;
                }
            }
            sVar3.r(z);
            sVar = sVar3;
        } else {
            uVar2 = uVar;
            gVar2 = gVar;
            tlydtdl.compose.runtime.s sVar11 = sVar5;
            sVar11.Z();
            sVar = sVar11;
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new jb.e(mVar, uVar2, function0, pVar, oVar, gVar2, kVar, i);
        }
    }
}
