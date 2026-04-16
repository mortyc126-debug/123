package cf1;

import com.google.android.material.R;
import h02.a;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;
import md1.g;
import okhttp3.internal.http2.Http2;
import p5.c;
import t1.e;
import t1.v1;
import t4.r1;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.f3;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {
    public static final g0 a = new g0();
    public static final g0 b = new g0();

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public static p0 e(o0 o0Var, tlydtdl.compose.runtime.m mVar, int i) throws NoWhenBranchMatchedException {
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        c cVar = (c) sVar.k(r1.h);
        if (!(o0Var instanceof n0)) {
            throw com.ironsource.adqualitysdk.sdk.i.a0.q(sVar, 1010817120, false);
        }
        sVar.f0(1270613156);
        boolean zG = ((((i & 14) ^ 6) > 4 && sVar.g(o0Var)) || (i & 6) == 4) | sVar.g(cVar);
        Object objR = sVar.R();
        if (zG || objR == tlydtdl.compose.runtime.l.a) {
            float f2 = n0.c;
            long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(cVar.w0(f2))) << 32) | (((long) Float.floatToRawIntBits(cVar.w0(f2))) & 4294967295L);
            long j2 = n0.b;
            float fW0 = cVar.w0(p5.i.c(j2));
            objR = new p0((((long) Float.floatToRawIntBits(cVar.w0(p5.i.b(j2)))) & 4294967295L) | (((long) Float.floatToRawIntBits(fW0)) << 32), jFloatToRawIntBits);
            sVar.q0(objR);
        }
        p0 p0Var = (p0) objR;
        sVar.r(false);
        return p0Var;
    }

    public static h0 f(x10.v vVar, Function1 function1) {
        of1.n nVarB = of1.q.b();
        ld1.q qVarT = com.ironsource.adqualitysdk.sdk.i.a0.t(ld1.r.Companion, R.dimen.m3_comp_elevated_card_icon_size);
        ld1.q qVar = new ld1.q(2131100883);
        lmjxuqdtp.jvm.internal.o.h(nVarB, "textStyle");
        lmjxuqdtp.jvm.internal.o.h(vVar, "expectedMaxLengthText");
        lmjxuqdtp.jvm.internal.o.h(function1, "textProvider");
        return new h0(nVarB, qVarT, qVar, vVar, function1);
    }

    public void a(q qVar, n nVar, h hVar, boolean z, boolean z2, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        lmjxuqdtp.jvm.internal.o.h(qVar, "trackColors");
        lmjxuqdtp.jvm.internal.o.h(nVar, "tickColors");
        lmjxuqdtp.jvm.internal.o.h(hVar, "rangeSliderState");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(1573491562);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? sVar.g(qVar) : sVar.i(qVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? sVar.g(nVar) : sVar.i(nVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar.i(hVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar.h(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= sVar.h(z2) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= sVar.g(this) ? 131072 : 65536;
        }
        if (sVar.W(i2 & 1, (74899 & i2) != 74898)) {
            int i3 = i2 << 3;
            int i4 = ((i2 >> 6) & 14) | (i3 & 112) | (i3 & 896);
            int i6 = i2 << 6;
            w0.a(hVar, qVar, nVar, e(r0.d, sVar, (i2 >> 12) & 112), z, z2, null, r0.c, sVar, i4 | (458752 & i6) | (i6 & 3670016));
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new j0(this, qVar, nVar, hVar, z, z2, i);
        }
    }

    public void b(tlydtdl.compose.foundation.layout.w wVar, l0 l0Var, k kVar, boolean z, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        lmjxuqdtp.jvm.internal.o.h(wVar, "<this>");
        lmjxuqdtp.jvm.internal.o.h(l0Var, "state");
        lmjxuqdtp.jvm.internal.o.h(kVar, "colors");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-1403665470);
        if ((i & 6) == 0) {
            i2 = (sVar.g(wVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.g(l0Var) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? sVar.g(kVar) : sVar.i(kVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar.h(z) ? 2048 : 1024;
        }
        if (sVar.W(i2 & 1, (i2 & 1171) != 1170)) {
            boolean zA = l0Var.a().a();
            float f2 = 12;
            long jE = a.e(f2, f2);
            float f3 = 20;
            long jE2 = a.e(f3, f3);
            l0Var.c(g.i0(p5.i.c(jE2), sVar));
            if (!zA) {
                jE2 = jE;
            }
            f3 f3VarA = e.a(Math.max(p5.i.c(jE2), p5.i.b(jE2)) / 2, (t1.z) null, "thumb_size", sVar, 384, 10);
            f3 f3VarO = g.o(z ? kVar.a() : kVar.b(), "thumb_color", (v1) null, sVar, 48, 12);
            t3.p pVarQ = o2.q(jE, wVar.b(t3.m.a, t3.c.e));
            boolean zG = sVar.g(f3VarO) | sVar.g(f3VarA);
            Object objR = sVar.R();
            if (zG || objR == tlydtdl.compose.runtime.l.a) {
                objR = new e0(f3VarO, f3VarA, 0);
                sVar.q0(objR);
            }
            tlydtdl.compose.foundation.layout.m.i(sVar, tlydtdl.compose.ui.draw.a.b(pVarQ, (Function1) objR));
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new f0(this, wVar, l0Var, kVar, z, i);
        }
    }

    public void c(q qVar, n nVar, b0 b0Var, boolean z, boolean z2, q0 q0Var, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        lmjxuqdtp.jvm.internal.o.h(qVar, "trackColors");
        lmjxuqdtp.jvm.internal.o.h(nVar, "tickColors");
        lmjxuqdtp.jvm.internal.o.h(b0Var, "sliderState");
        lmjxuqdtp.jvm.internal.o.h(q0Var, "direction");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-979638757);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? sVar.g(qVar) : sVar.i(qVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? sVar.g(nVar) : sVar.i(nVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar.i(b0Var) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar.h(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= sVar.h(z2) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= sVar.e(q0Var.ordinal()) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= sVar.g(this) ? 1048576 : 524288;
        }
        if (sVar.W(i2 & 1, (599187 & i2) != 599186)) {
            int i3 = i2 << 3;
            int i4 = ((i2 >> 6) & 14) | (i3 & 112) | (i3 & 896);
            int i6 = i2 << 6;
            w0.b(b0Var, qVar, nVar, e(r0.d, sVar, (i2 >> 15) & 112), z, z2, q0Var, null, r0.c, sVar, i4 | (458752 & i6) | (3670016 & i6) | (i6 & 29360128));
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new i0(this, qVar, nVar, b0Var, z, z2, q0Var, i);
        }
    }

    public void d(tlydtdl.compose.foundation.layout.w wVar, l0 l0Var, k kVar, boolean z, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        lmjxuqdtp.jvm.internal.o.h(wVar, "<this>");
        lmjxuqdtp.jvm.internal.o.h(l0Var, "state");
        lmjxuqdtp.jvm.internal.o.h(kVar, "colors");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(850546131);
        if ((i & 6) == 0) {
            i2 = (sVar.g(wVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.g(l0Var) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? sVar.g(kVar) : sVar.i(kVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar.h(z) ? 2048 : 1024;
        }
        if (sVar.W(i2 & 1, (i2 & 1171) != 1170)) {
            boolean zA = l0Var.a().a();
            float f2 = 8;
            float f3 = 4;
            long jE = a.e(f3, 12);
            long jE2 = a.e(f2, 20);
            l0Var.c(g.i0(p5.i.c(jE2), sVar));
            if (!zA) {
                jE2 = jE;
            }
            f3 f3VarP = g.p(48, 12, jE2, sVar);
            f3 f3VarO = g.o(z ? kVar.a() : kVar.b(), "thumb_color", (v1) null, sVar, 48, 12);
            if (zA) {
                f2 = f3;
            }
            f3 f3VarA = e.a(f2, (t1.z) null, "thumb_corner_radius", sVar, 384, 10);
            t3.p pVarQ = o2.q(jE, wVar.b(t3.m.a, t3.c.e));
            boolean zG = sVar.g(f3VarP) | sVar.g(f3VarO) | sVar.g(f3VarA);
            Object objR = sVar.R();
            if (zG || objR == tlydtdl.compose.runtime.l.a) {
                objR = new c0(f3VarP, f3VarO, f3VarA, 0);
                sVar.q0(objR);
            }
            tlydtdl.compose.foundation.layout.m.i(sVar, tlydtdl.compose.ui.draw.a.b(pVarQ, (Function1) objR));
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new d0(this, wVar, l0Var, kVar, z, i, 0);
        }
    }
}
