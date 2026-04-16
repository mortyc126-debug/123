package mf1;

import a4.a1;
import a4.q;
import a4.y;
import c4.d;
import c4.h;
import com.gnacba.amuvvoafs.gms.internal.measurement.b4;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import com.google.android.material.R;
import ld1.r;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import md1.g;
import md1.n0;
import okhttp3.internal.http2.Http2;
import org.apache.commons.net.telnet.TelnetCommand;
import p5.n;
import t1.v1;
import t3.p;
import t4.r1;
import tlydtdl.compose.foundation.layout.f2;
import tlydtdl.compose.foundation.layout.j2;
import tlydtdl.compose.foundation.layout.l2;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.f3;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.u1;
import tlydtdl.compose.runtime.x0;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final c a = new c();

    public static Function3 b(tlydtdl.compose.runtime.m mVar, int i) {
        final long jY = g.y(i.u(r.Companion, R.dimen.m3_comp_fab_primary_large_icon_size), mVar, (i >> 3) & 14);
        final float fI0 = g.i0(2, mVar);
        s sVar = (s) mVar;
        p5.c cVar = (p5.c) sVar.k(r1.h);
        n nVar = (n) sVar.k(r1.n);
        float f2 = 12;
        f2 f2Var = new f2(f2, f2, f2, f2);
        boolean zG = sVar.g(cVar) | sVar.e(nVar.ordinal()) | sVar.g(f2Var);
        Object objR = sVar.R();
        x0 x0Var = tlydtdl.compose.runtime.l.a;
        if (zG || objR == x0Var) {
            objR = new lx1.l(Float.valueOf(cVar.w0(tlydtdl.compose.foundation.layout.m.o(f2Var, nVar))), Float.valueOf(cVar.w0(tlydtdl.compose.foundation.layout.m.n(f2Var, nVar))));
            sVar.q0(objR);
        }
        lx1.l lVar = (lx1.l) objR;
        final float fFloatValue = ((Number) lVar.a).floatValue();
        final float fFloatValue2 = ((Number) lVar.b).floatValue();
        boolean zF = sVar.f(jY) | sVar.d(fI0) | sVar.d(fFloatValue) | sVar.d(fFloatValue2);
        Object objR2 = sVar.R();
        if (zF || objR2 == x0Var) {
            Function3 function3 = new Function3() { // from class: mf1.a
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    long j2 = jY;
                    float f3 = fFloatValue2;
                    d dVar = (d) obj;
                    float fFloatValue3 = ((Float) obj2).floatValue();
                    float fFloatValue4 = ((Float) obj3).floatValue();
                    o.h(dVar, "$this$remember");
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (dVar.h() & 4294967295L));
                    float f4 = fI0;
                    float f5 = fIntBitsToFloat - f4;
                    float f7 = fFloatValue;
                    float f8 = fFloatValue4 + f7;
                    ((ru1.c) dVar.x0().c).v(f8, f5);
                    try {
                        d.s(dVar, j2, 0L, (((long) Float.floatToRawIntBits(fFloatValue3 - (f7 + f3))) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L), 0.0f, (h) null, 122);
                        ((ru1.c) dVar.x0().c).v(-f8, -f5);
                        return b0.a;
                    } catch (Throwable th) {
                        ((ru1.c) dVar.x0().c).v(-f8, -f5);
                        throw th;
                    }
                }
            };
            sVar.q0(function3);
            objR2 = function3;
        }
        return (Function3) objR2;
    }

    public final void a(final v vVar, final boolean z, p pVar, dg1.d dVar, Long l, boolean z2, final Function0 function0, tlydtdl.compose.runtime.m mVar, final int i, final int i2) {
        p pVar2;
        int i3;
        dg1.d dVar2;
        int i4;
        Long l2;
        int i6;
        boolean z3;
        int i7;
        final p pVar3;
        final dg1.d dVar3;
        final Long l4;
        final boolean z4;
        int i8;
        tlydtdl.compose.foundation.layout.j jVar;
        t3.g gVar;
        boolean z5;
        p pVarThen;
        ld1.d dVar4;
        int i9;
        dg1.d dVar5;
        boolean z6;
        boolean z7;
        o.h(function0, "onClick");
        s sVar = (s) mVar;
        sVar.h0(-5175680);
        int i10 = i | (sVar.g(vVar) ? 4 : 2) | (sVar.h(z) ? 32 : 16) | (sVar.g(m.a) ? 256 : 128);
        int i11 = i2 & 8;
        if (i11 != 0) {
            i3 = i10 | 3072;
            pVar2 = pVar;
        } else {
            pVar2 = pVar;
            i3 = i10 | (sVar.g(pVar2) ? 2048 : 1024);
        }
        int i12 = i2 & 16;
        if (i12 != 0) {
            i4 = i3 | 24576;
            dVar2 = dVar;
        } else {
            dVar2 = dVar;
            i4 = i3 | (sVar.g(dVar2) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192);
        }
        int i13 = i2 & 32;
        if (i13 != 0) {
            i6 = i4 | 196608;
            l2 = l;
        } else {
            l2 = l;
            i6 = i4 | (sVar.g(l2) ? 131072 : 65536);
        }
        int i14 = i2 & 64;
        if (i14 != 0) {
            i7 = i6 | 1572864;
            z3 = z2;
        } else {
            z3 = z2;
            i7 = i6 | (sVar.h(z3) ? 1048576 : 524288);
        }
        int i15 = i7 | (sVar.i(function0) ? 8388608 : 4194304);
        if (sVar.W(i15 & 1, (4793491 & i15) != 4793490)) {
            p pVar4 = t3.m.a;
            if (i11 != 0) {
                pVar2 = pVar4;
            }
            dg1.d dVar6 = i12 != 0 ? null : dVar2;
            Long l6 = i13 == 0 ? l2 : null;
            boolean z8 = i14 != 0 ? false : z3;
            float f2 = 8;
            tlydtdl.compose.foundation.layout.j jVarG = tlydtdl.compose.foundation.layout.l.g(f2);
            t3.g gVar2 = t3.c.k;
            sVar.f0(-678845966);
            if (z8) {
                float f3 = 0;
                i8 = i15;
                jVar = jVarG;
                gVar = gVar2;
                p pVarN = q30.n.N(3, f3, (((long) Float.floatToRawIntBits(g.i0(f3, sVar))) << 32) | (((long) Float.floatToRawIntBits(g.i0(f2, sVar))) & 4294967295L), sVar, 438, 4);
                sVar = sVar;
                pVarThen = pVar2.then(pVarN);
                z5 = false;
            } else {
                i8 = i15;
                jVar = jVarG;
                gVar = gVar2;
                z5 = false;
                pVarThen = pVar2;
            }
            sVar.r(z5);
            float f4 = 12;
            p pVarC = tlydtdl.compose.foundation.layout.m.C(b4.K(pVarThen, z, new a5.h(4), function0, 28), new f2(f4, f4, f4, f4));
            l2 l2VarA = j2.a(jVar, gVar, sVar, 54);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, pVarC);
            s4.l.f436d2.getClass();
            s4.j jVar2 = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar2);
            } else {
                sVar.t0();
            }
            a0.y(sVar, l2VarA, s4.k.f435f);
            a0.y(sVar, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            a0.y(sVar, pVarX, s4.k.d);
            if (z) {
                dVar4 = r.Companion;
                i9 = R.dimen.m3_comp_fab_primary_large_icon_size;
            } else {
                dVar4 = r.Companion;
                i9 = R.dimen.m3_comp_fab_primary_pressed_container_elevation;
            }
            f3 f3VarO = g.o(i.u(dVar4, i9), (String) null, (v1) null, sVar, 0, 14);
            if (dVar6 != null) {
                sVar.f0(836985770);
                s sVar2 = sVar;
                dg1.d dVar7 = dVar6;
                fe1.f.a(dVar7, (String) null, (a1) null, o2.p(pVar4, 24), (t3.d) null, (q4.m) null, 0.0f, new q(((y) f3VarO.getValue()).a, 5), (Function0) null, false, (n0) null, (fe1.j) null, (fe1.g) null, false, (Function3) null, (fe1.k) null, sVar2, ((i8 >> 12) & 14) | 432, 0, 65392);
                dVar5 = dVar7;
                sVar = sVar2;
                z6 = false;
            } else {
                dVar5 = dVar6;
                z6 = false;
                sVar.f0(824429406);
            }
            sVar.r(z6);
            s sVar3 = sVar;
            z10.d.h(vVar, g.x(r.Companion, ((y) f3VarO.getValue()).a), of1.q.c(), (p) null, false, (of1.e) null, 0, (Function1) null, sVar3, i8 & 14, TelnetCommand.EL);
            sVar = sVar3;
            if (l6 != null) {
                sVar.f0(837472594);
                z10.d.a(l6.longValue(), ud1.i.a, z ? ud1.e.a : ud1.f.a, (p) null, sVar, (i8 >> 15) & 14, 8);
                sVar = sVar;
                z7 = false;
            } else {
                z7 = false;
                sVar.f0(824429406);
            }
            sVar.r(z7);
            sVar.r(true);
            p pVar5 = pVar2;
            l4 = l6;
            pVar3 = pVar5;
            dVar3 = dVar5;
            z4 = z8;
        } else {
            sVar.Z();
            pVar3 = pVar2;
            dVar3 = dVar2;
            l4 = l2;
            z4 = z3;
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new Function2() { // from class: mf1.b
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    this.a.a(vVar, z, pVar3, dVar3, l4, z4, function0, (tlydtdl.compose.runtime.m) obj, a0.B(i | 1), i2);
                    return b0.a;
                }
            };
        }
    }
}
