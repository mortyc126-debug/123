package wg0;

import a2.q1;
import a4.a1;
import a4.w0;
import com.facebook.appevents.l;
import com.gnacba.amuvvoafs.gms.internal.measurement.b4;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import com.google.android.material.R;
import e2.a;
import java.util.List;
import java.util.Map;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.telnet.TelnetCommand;
import q4.u0;
import rd1.k0;
import rd1.n0;
import rd1.q0;
import rd1.t0;
import rd1.v0;
import s4.i;
import sf1.s0;
import t3.p;
import t5.g0;
import tlydtdl.compose.foundation.layout.LayoutWeightElement;
import tlydtdl.compose.foundation.layout.e0;
import tlydtdl.compose.foundation.layout.f2;
import tlydtdl.compose.foundation.layout.j2;
import tlydtdl.compose.foundation.layout.l2;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.foundation.layout.v2;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.u1;
import tlydtdl.datastore.preferences.protobuf.j1;
import u51.d0;
import uq0.f0;
import v1.p1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c0 {
    public static final float a = 50;

    static {
        new y(ct1.b.C(new r[]{new r("1", "Voice 1", HttpUrl.FRAGMENT_ENCODE_SET, true, true, null), new r("1", "Voice 2", HttpUrl.FRAGMENT_ENCODE_SET, false, false, null)}), 0, 7, true, true, new x(ct1.b.C(new w[]{new w("1", "Voice 1", "Deep and full of emotion. Perfect for blues, indie, and spoken word performances.", HttpUrl.FRAGMENT_ENCODE_SET, ct1.b.C(new String[]{"regular", "italic", "bold", "intense", "unstoppable", "one", "more"})), new w("2", "Voice 2", "Futuristic, ethereal, and commanding. Great for synthwave, electronic, and cyberpunk vibes. And some more text to see how 3 lines looks.", HttpUrl.FRAGMENT_ENCODE_SET, ct1.b.C(new String[]{"bold", "intense", "unstoppable"}))}), false));
    }

    public static final void a(boolean z, vg0.e eVar, tlydtdl.compose.runtime.m mVar, int i) {
        s sVar = (s) mVar;
        sVar.h0(851376755);
        int i2 = (sVar.h(z) ? 4 : 2) | i | (sVar.i(eVar) ? 32 : 16);
        if (sVar.W(i2 & 1, (i2 & 19) != 18)) {
            t3.g gVar = t3.c.k;
            float f2 = 16;
            p pVarH = tlydtdl.compose.foundation.layout.m.H(o2.e(t3.m.a, 1.0f), f2, 32, f2, 0.0f, 8);
            ld1.d dVar = ld1.r.Companion;
            p pVarF = tlydtdl.compose.foundation.layout.m.F(l.o(pVarH, i.e(2131100882, 0, sVar, dVar), l2.f.b(8)), 12, 0.0f, 2);
            l2 l2VarA = j2.a(tlydtdl.compose.foundation.layout.l.a, gVar, sVar, 48);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, pVarF);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, l2VarA, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            i iVar = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
            x10.r rVarW = com.ironsource.adqualitysdk.sdk.i.a0.w(x10.v.Companion, 2132020595, dVar);
            ld1.q qVar = new ld1.q(R.dimen.m3_comp_fab_primary_pressed_container_elevation);
            of1.n nVarB = of1.q.b();
            if (1.0f <= 0.0d) {
                a.a("invalid weight; must be greater than zero");
            }
            z10.d.h(rVarW, qVar, nVarB, new LayoutWeightElement(1.0f, true), false, (of1.e) null, 0, (Function1) null, sVar, 0, 240);
            sVar = sVar;
            com.facebook.appevents.p.f(z, eVar, (p) null, (bf1.k) null, false, sVar, i2 & WebSocketProtocol.PAYLOAD_SHORT, 28);
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new eb.a(z, eVar, i, 17);
        }
    }

    public static final void b(j jVar, f0 f0Var, tlydtdl.compose.runtime.m mVar, int i) {
        s sVar;
        s sVar2 = (s) mVar;
        sVar2.h0(-951986577);
        int i2 = (sVar2.g(jVar) ? 4 : 2) | i | (sVar2.i(f0Var) ? 32 : 16);
        if (sVar2.W(i2 & 1, (i2 & 19) != 18)) {
            sVar = sVar2;
            qk0.a.m(o2.f(o2.e(t3.m.a, 1.0f), 400), dg1.j.z, com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132019504), jVar.a, new jd1.b(new x10.r(2132019964), (dg1.g) null, jVar.b, f0Var, 6), (jd1.b) null, (rd1.s) null, (rd1.s) null, (wf1.k) null, (wf1.h) null, sVar, 54, 992);
        } else {
            sVar = sVar2;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new w50.f(jVar, f0Var, i, 12);
        }
    }

    public static final void c(m mVar, tlydtdl.compose.runtime.m mVar2, int i) {
        p pVar;
        s sVar = (s) mVar2;
        sVar.h0(-1683300405);
        int i2 = (sVar.g(mVar) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            float f2 = 16;
            float f3 = 32;
            p pVar2 = t3.m.a;
            p pVarH = tlydtdl.compose.foundation.layout.m.H(pVar2, 0.0f, f2, 0.0f, f3, 5);
            e0 e0VarA = tlydtdl.compose.foundation.layout.c0.a(tlydtdl.compose.foundation.layout.l.c, t3.c.m, sVar, 0);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, pVarH);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            i iVar = s4.k.f435f;
            tlydtdl.compose.runtime.a0.y(sVar, e0VarA, iVar);
            i iVar2 = s4.k.e;
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, iVar2);
            i iVar3 = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar3);
            }
            i iVar4 = s4.k.d;
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, iVar4);
            tlydtdl.compose.foundation.layout.j jVarJ = tlydtdl.compose.foundation.layout.d.j(12);
            p pVarH2 = tlydtdl.compose.foundation.layout.m.H(pVar2, f2, 0.0f, 0.0f, 0.0f, 14);
            l2 l2VarA = j2.a(jVarJ, t3.c.j, sVar, 6);
            int iHashCode2 = Long.hashCode(sVar.T);
            u1 u1VarM2 = sVar.m();
            p pVarX2 = j4.x(sVar, pVarH2);
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, l2VarA, iVar);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM2, iVar2);
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode2))) {
                i.x(iHashCode2, sVar, iHashCode2, iVar3);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX2, iVar4);
            sVar.f0(-2111041188);
            for (int i3 = 0; i3 < 6; i3++) {
                e0 e0VarA2 = tlydtdl.compose.foundation.layout.c0.a(tlydtdl.compose.foundation.layout.l.c, t3.c.n, sVar, 48);
                int iHashCode3 = Long.hashCode(sVar.T);
                u1 u1VarM3 = sVar.m();
                p pVarX3 = j4.x(sVar, pVar2);
                s4.l.f436d2.getClass();
                s4.j jVar2 = s4.k.b;
                sVar.j0();
                if (sVar.S) {
                    sVar.l(jVar2);
                } else {
                    sVar.t0();
                }
                tlydtdl.compose.runtime.a0.y(sVar, e0VarA2, s4.k.f435f);
                tlydtdl.compose.runtime.a0.y(sVar, u1VarM3, s4.k.e);
                i iVar5 = s4.k.g;
                if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode3))) {
                    i.x(iHashCode3, sVar, iHashCode3, iVar5);
                }
                tlydtdl.compose.runtime.a0.y(sVar, pVarX3, s4.k.d);
                float f4 = 96;
                p pVarP = o2.p(pVar2, f4);
                ld1.d dVar = ld1.r.Companion;
                float f5 = 8;
                tlydtdl.compose.foundation.layout.s.a(l.o(pVarP, i.e(2131100892, 0, sVar, dVar), l2.f.b(f5)), sVar, 0);
                tlydtdl.compose.foundation.layout.s.a(l.o(o2.r(tlydtdl.compose.foundation.layout.m.H(pVar2, 0.0f, f5, 0.0f, 0.0f, 13), f4, f2), i.e(2131100892, 0, sVar, dVar), l2.f.a), sVar, 0);
                sVar.r(true);
            }
            sVar.r(false);
            sVar.r(true);
            p pVarF = o2.f(o2.e(tlydtdl.compose.foundation.layout.m.H(pVar2, f2, 64, f2, 0.0f, 8), 1.0f), 56);
            ld1.d dVar2 = ld1.r.Companion;
            tlydtdl.compose.foundation.layout.s.a(l.o(pVarF, i.e(2131100892, 0, sVar, dVar2), l2.f.b(8)), sVar, 0);
            if (mVar.a) {
                sVar.f0(-1344848540);
                pVar = pVar2;
                tlydtdl.compose.foundation.layout.s.a(l.o(o2.f(o2.e(tlydtdl.compose.foundation.layout.m.H(pVar2, f2, f3, f2, 0.0f, 8), 1.0f), 48), i.e(2131100892, 0, sVar, dVar2), l2.f.b(4)), sVar, 0);
                sVar.r(false);
            } else {
                pVar = pVar2;
                sVar.f0(-1344535936);
                tlydtdl.compose.foundation.layout.m.i(sVar, o2.f(pVar, f2));
                sVar.r(false);
            }
            t3.g gVar = t3.c.k;
            tlydtdl.compose.foundation.layout.j jVarG = tlydtdl.compose.foundation.layout.l.g(f2);
            p pVarH3 = tlydtdl.compose.foundation.layout.m.H(o2.e(pVar, 1.0f), f2, f2, f2, 0.0f, 8);
            l2 l2VarA2 = j2.a(jVarG, gVar, sVar, 54);
            int iHashCode4 = Long.hashCode(sVar.T);
            u1 u1VarM4 = sVar.m();
            p pVarX4 = j4.x(sVar, pVarH3);
            s4.l.f436d2.getClass();
            s4.j jVar3 = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar3);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, l2VarA2, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM4, s4.k.e);
            i iVar6 = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode4))) {
                i.x(iHashCode4, sVar, iHashCode4, iVar6);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX4, s4.k.d);
            float f7 = 48;
            p pVarP2 = o2.p(pVar, f7);
            long jE = i.e(2131100892, 0, sVar, dVar2);
            l2.e eVar = l2.f.a;
            tlydtdl.compose.foundation.layout.s.a(l.o(pVarP2, jE, eVar), sVar, 0);
            if (1.0f <= 0.0d) {
                a.a("invalid weight; must be greater than zero");
            }
            p pVarF2 = o2.f(new LayoutWeightElement(1.0f, true), f7);
            dVar2.getClass();
            tlydtdl.compose.foundation.layout.s.a(l.o(pVarF2, md1.g.y(new ld1.q(2131100892), sVar, 0), eVar), sVar, 0);
            sVar.r(true);
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new vz0.a(mVar, i, 10);
        }
    }

    public static final void d(y yVar, kd1.g gVar, v0 v0Var, b60.z zVar, tlydtdl.compose.runtime.m mVar, int i) {
        s sVar;
        char c;
        s sVar2 = (s) mVar;
        sVar2.h0(-1744175822);
        int i2 = i | (sVar2.g(yVar) ? 4 : 2) | (sVar2.g(gVar) ? 32 : 16) | (sVar2.g(v0Var) ? 256 : 128) | (sVar2.g(zVar) ? 2048 : 1024);
        if (sVar2.W(i2 & 1, (i2 & 1171) != 1170)) {
            p1 p1VarD = uz1.g.D(sVar2);
            t3.m mVar2 = t3.m.a;
            float f2 = 16;
            float f3 = 32;
            p pVarH = tlydtdl.compose.foundation.layout.m.H(uz1.g.H(mVar2, p1VarD, 14), 0.0f, f2, 0.0f, f3, 5);
            e0 e0VarA = tlydtdl.compose.foundation.layout.c0.a(tlydtdl.compose.foundation.layout.l.c, t3.c.m, sVar2, 0);
            int iHashCode = Long.hashCode(sVar2.T);
            u1 u1VarM = sVar2.m();
            p pVarX = j4.x(sVar2, pVarH);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar2.j0();
            if (sVar2.S) {
                sVar2.l(jVar);
            } else {
                sVar2.t0();
            }
            i iVar = s4.k.f435f;
            tlydtdl.compose.runtime.a0.y(sVar2, e0VarA, iVar);
            i iVar2 = s4.k.e;
            tlydtdl.compose.runtime.a0.y(sVar2, u1VarM, iVar2);
            i iVar3 = s4.k.g;
            if (sVar2.S || !lmjxuqdtp.jvm.internal.o.c(sVar2.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar2, iHashCode, iVar3);
            }
            i iVar4 = s4.k.d;
            tlydtdl.compose.runtime.a0.y(sVar2, pVarX, iVar4);
            tlydtdl.compose.foundation.layout.j jVarJ = tlydtdl.compose.foundation.layout.d.j(8);
            f2 f2VarF = tlydtdl.compose.foundation.layout.m.f(f2, 0.0f, 2);
            int i3 = i2 & 14;
            boolean z = ((i2 & 7168) == 2048) | (i3 == 4);
            Object objR = sVar2.R();
            if (z || objR == tlydtdl.compose.runtime.l.a) {
                c = 14;
                objR = new d0(14, yVar, zVar);
                sVar2.q0(objR);
            } else {
                c = 14;
            }
            b4.f((p) null, (f2.a0) null, f2VarF, jVarJ, (t3.g) null, (q1) null, false, (v2) null, false, (Function1) objR, sVar2, 24960, 0, 1003);
            z10.d.h(com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132020593), i.u(ld1.r.Companion, R.dimen.m3_comp_fab_primary_pressed_container_elevation), of1.q.a(), tlydtdl.compose.foundation.layout.m.H(mVar2, f2, f3, 0.0f, 0.0f, 12), false, (of1.e) null, 0, (Function1) null, sVar2, 0, 240);
            f(yVar, v0Var, (vg0.e) zVar.d, gVar, o2.e(tlydtdl.compose.foundation.layout.m.H(mVar2, f2, 12, f2, 0.0f, 8), 1.0f), sVar2, i3 | ((i2 >> 3) & 112) | ((i2 << 6) & 7168));
            boolean z2 = yVar.d;
            boolean z3 = yVar.e;
            if (z2) {
                sVar2.f0(1166808388);
                a(z3, (vg0.e) zVar.e, sVar2, 0);
                sVar2.r(false);
            } else {
                sVar2.f0(1167002789);
                tlydtdl.compose.foundation.layout.m.i(sVar2, o2.f(mVar2, f2));
                sVar2.r(false);
            }
            t3.g gVar2 = t3.c.k;
            tlydtdl.compose.foundation.layout.j jVarG = tlydtdl.compose.foundation.layout.l.g(f2);
            p pVarH2 = tlydtdl.compose.foundation.layout.m.H(o2.e(mVar2, 1.0f), f2, f2, f2, 0.0f, 8);
            l2 l2VarA = j2.a(jVarG, gVar2, sVar2, 54);
            int iHashCode2 = Long.hashCode(sVar2.T);
            u1 u1VarM2 = sVar2.m();
            p pVarX2 = j4.x(sVar2, pVarH2);
            sVar2.j0();
            if (sVar2.S) {
                sVar2.l(jVar);
            } else {
                sVar2.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar2, l2VarA, iVar);
            tlydtdl.compose.runtime.a0.y(sVar2, u1VarM2, iVar2);
            if (sVar2.S || !lmjxuqdtp.jvm.internal.o.c(sVar2.R(), Integer.valueOf(iHashCode2))) {
                i.x(iHashCode2, sVar2, iHashCode2, iVar3);
            }
            tlydtdl.compose.runtime.a0.y(sVar2, pVarX2, iVar4);
            p pVarP = o2.p(mVar2, 48);
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.a, false);
            int iHashCode3 = Long.hashCode(sVar2.T);
            u1 u1VarM3 = sVar2.m();
            p pVarX3 = j4.x(sVar2, pVarP);
            sVar2.j0();
            if (sVar2.S) {
                sVar2.l(jVar);
            } else {
                sVar2.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar2, u0VarD, iVar);
            tlydtdl.compose.runtime.a0.y(sVar2, u1VarM3, iVar2);
            if (sVar2.S || !lmjxuqdtp.jvm.internal.o.c(sVar2.R(), Integer.valueOf(iHashCode3))) {
                i.x(iHashCode3, sVar2, iHashCode3, iVar3);
            }
            tlydtdl.compose.runtime.a0.y(sVar2, pVarX3, iVar4);
            com.facebook.appevents.p.c(v0Var, n0.a, t0.a, (p) null, sVar2, (i2 >> 6) & 14, 8);
            sVar2.r(true);
            x10.r rVar = z3 ? new x10.r(2132020590) : yVar.d ? new x10.r(2132020589) : new x10.r(2132017331);
            rd1.n nVar = rd1.n.a;
            rd1.a0.a.getClass();
            rd1.y yVar2 = rd1.w.b;
            f0 f0Var = (f0) zVar.f24f;
            if (1.0f <= 0.0d) {
                a.a("invalid weight; must be greater than zero");
            }
            by1.b.b(rVar, nVar, yVar2, new LayoutWeightElement(1.0f, true), false, false, (dg1.d) null, (dg1.d) null, f0Var, sVar2, 0, 240);
            sVar = sVar2;
            sVar.r(true);
            sVar.r(true);
        } else {
            sVar = sVar2;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new tn.a(yVar, gVar, v0Var, zVar, i, 10);
        }
    }

    public static final void e(r rVar, Function1 function1, tlydtdl.compose.runtime.m mVar, int i) {
        dg1.h hVar;
        String str;
        a1 a1Var;
        boolean z;
        boolean z2;
        s sVar = (s) mVar;
        sVar.h0(571245002);
        int i2 = i | (sVar.g(rVar) ? 4 : 2) | (sVar.i(function1) ? 32 : 16);
        if (sVar.W(i2 & 1, (i2 & 19) != 18)) {
            e0 e0VarA = tlydtdl.compose.foundation.layout.c0.a(tlydtdl.compose.foundation.layout.l.c, t3.c.n, sVar, 48);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            p pVar = t3.m.a;
            p pVarX = j4.x(sVar, pVar);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            i iVar = s4.k.f435f;
            tlydtdl.compose.runtime.a0.y(sVar, e0VarA, iVar);
            i iVar2 = s4.k.e;
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, iVar2);
            i iVar3 = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar3);
            }
            i iVar4 = s4.k.d;
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, iVar4);
            boolean z3 = ((i2 & 14) == 4) | ((i2 & 112) == 32);
            Object objR = sVar.R();
            if (z3 || objR == tlydtdl.compose.runtime.l.a) {
                objR = new vy0.f(10, function1, rVar);
                sVar.q0(objR);
            }
            p pVarV = md1.g.v(pVar, (md1.n0) null, (a5.h) null, false, false, (Function0) null, (Function0) null, (Function0) objR, 63);
            t3.d dVar = t3.c.a;
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(dVar, false);
            int iHashCode2 = Long.hashCode(sVar.T);
            u1 u1VarM2 = sVar.m();
            p pVarX2 = j4.x(sVar, pVarV);
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, u0VarD, iVar);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM2, iVar2);
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode2))) {
                i.x(iHashCode2, sVar, iHashCode2, iVar3);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX2, iVar4);
            String str2 = rVar.c;
            boolean z4 = rVar.d;
            dg1.d.a.getClass();
            dg1.g gVar = dg1.c.b;
            dg1.h hVarJ = com.ironsource.adqualitysdk.sdk.i.a0.j(gVar, "placeholder", str2, gVar, false);
            String str3 = rVar.b;
            float f2 = 8;
            a1 a1VarB = l2.f.b(f2);
            sVar.f0(1454455871);
            t3.d dVar2 = t3.c.e;
            tlydtdl.compose.foundation.layout.x xVar = tlydtdl.compose.foundation.layout.x.a;
            p pVarP = o2.p(xVar.b(pVar, dVar2), 96);
            if (z4) {
                hVar = hVarJ;
                str = str3;
                a1Var = a1VarB;
                z = false;
                pVarP = pVarP.then(com.facebook.appevents.p.j(pVar, 2, i.e(R.dimen.m3_comp_fab_primary_large_icon_size, 0, sVar, ld1.r.Companion), l2.f.b(f2)));
            } else {
                hVar = hVarJ;
                str = str3;
                a1Var = a1VarB;
                z = false;
            }
            sVar.r(z);
            fe1.f.a(hVar, str, a1Var, pVarP, (t3.d) null, (q4.m) null, 0.0f, (a4.z) null, (Function0) null, false, (md1.n0) null, (fe1.j) null, (fe1.g) null, false, (Function3) null, (fe1.k) null, sVar, 0, 0, 65520);
            if (rVar.e) {
                sVar.f0(2138783768);
                h02.a.a(com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132019389), qd1.b.a, qd1.l.a, tlydtdl.compose.foundation.layout.m.D(xVar.b(pVar, dVar), 6), false, sVar, qd1.l.d << 6, 16);
                z2 = false;
            } else {
                z2 = false;
                sVar.f0(2125196220);
            }
            sVar.r(z2);
            sVar.r(true);
            x10.c cVar = x10.v.Companion;
            String str4 = rVar.b;
            cVar.getClass();
            z10.d.h(x10.c.d(str4), z4 ? i.u(ld1.r.Companion, R.dimen.m3_comp_fab_primary_large_icon_size) : i.u(ld1.r.Companion, R.dimen.m3_comp_fab_primary_pressed_container_elevation), of1.q.h(), tlydtdl.compose.foundation.layout.m.H(pVar, 0.0f, f2, 0.0f, 0.0f, 13), false, (of1.e) null, 0, (Function1) null, sVar, 3072, 240);
            sVar = sVar;
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new w50.f(rVar, function1, i, 11);
        }
    }

    public static final void f(y yVar, v0 v0Var, vg0.e eVar, kd1.g gVar, p pVar, tlydtdl.compose.runtime.m mVar, int i) {
        kd1.g gVar2;
        s sVar = (s) mVar;
        sVar.h0(1082829328);
        int i2 = (sVar.g(yVar) ? 4 : 2) | i;
        if ((i & 48) == 0) {
            i2 |= sVar.g(v0Var) ? 32 : 16;
        }
        int i3 = i2 | (sVar.i(eVar) ? 256 : 128);
        if ((i & 3072) == 0) {
            gVar2 = gVar;
            i3 |= sVar.g(gVar2) ? 2048 : 1024;
        } else {
            gVar2 = gVar;
        }
        int i4 = i3 | (sVar.g(pVar) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192);
        if (sVar.W(i4 & 1, (i4 & 9363) != 9362)) {
            e0 e0VarA = tlydtdl.compose.foundation.layout.c0.a(tlydtdl.compose.foundation.layout.l.c, t3.c.m, sVar, 0);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, pVar);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            i iVar = s4.k.f435f;
            tlydtdl.compose.runtime.a0.y(sVar, e0VarA, iVar);
            i iVar2 = s4.k.e;
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, iVar2);
            i iVar3 = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar3);
            }
            i iVar4 = s4.k.d;
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, iVar4);
            tf1.s.b(gVar2, (p) null, (Function0) null, tf1.d.g, 0L, 0.0f, 0.0f, 0.0f, (ld1.r) null, (ld1.r) null, (g0) null, 0, q3.p.d(-1002686245, new v50.o(yVar, v0Var, eVar, 14), sVar), sVar, ((i4 >> 9) & 14) | 3072, 384, 4086);
            sVar = sVar;
            p pVar2 = t3.m.a;
            p pVarE = o2.e(pVar2, 1.0f);
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.a, false);
            int iHashCode2 = Long.hashCode(sVar.T);
            u1 u1VarM2 = sVar.m();
            p pVarX2 = j4.x(sVar, pVarE);
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, u0VarD, iVar);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM2, iVar2);
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode2))) {
                i.x(iHashCode2, sVar, iHashCode2, iVar3);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX2, iVar4);
            x10.r rVarV = com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132020592);
            ld1.d dVar = ld1.r.Companion;
            ld1.q qVarU = i.u(dVar, R.dimen.m3_comp_fab_primary_pressed_state_layer_opacity);
            of1.n nVarH = of1.q.h();
            t3.d dVar2 = t3.c.d;
            tlydtdl.compose.foundation.layout.x xVar = tlydtdl.compose.foundation.layout.x.a;
            z10.d.h(rVarV, qVarU, nVarH, xVar.b(pVar2, dVar2), false, (of1.e) null, 0, (Function1) null, sVar, 0, 240);
            z10.d.h(f3.f2.u(2132020591, dVar), new ld1.q(R.dimen.m3_comp_fab_primary_pressed_state_layer_opacity), of1.q.h(), xVar.b(pVar2, t3.c.f), false, (of1.e) null, 0, (Function1) null, sVar, 0, 240);
            sVar.r(true);
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new tlydtdl.compose.foundation.layout.u0(yVar, v0Var, eVar, gVar, pVar, i, 15);
        }
    }

    public static final void g(f0 f0Var, boolean z, f0 f0Var2, tlydtdl.compose.runtime.m mVar, int i) {
        s sVar = (s) mVar;
        sVar.h0(-1833542278);
        int i2 = i | (sVar.i(f0Var) ? 4 : 2) | (sVar.h(z) ? 32 : 16) | (sVar.i(f0Var2) ? 256 : 128);
        if (sVar.W(i2 & 1, (i2 & 147) != 146)) {
            tlydtdl.compose.foundation.layout.f fVar = tlydtdl.compose.foundation.layout.l.g;
            t3.g gVar = t3.c.k;
            t3.m mVar2 = t3.m.a;
            p pVarF = o2.f(o2.e(mVar2, 1.0f), 56);
            l2 l2VarA = j2.a(fVar, gVar, sVar, 54);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, pVarF);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, l2VarA, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            i iVar = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            dg1.g gVarG = i.g(sVar, pVarX, s4.k.d, 2131231834, false);
            rd1.r rVar = rd1.r.a;
            rd1.a0.a.getClass();
            rd1.y yVar = rd1.w.b;
            com.facebook.appevents.h.c(gVarG, rVar, yVar, (p) null, false, false, f0Var, sVar, (i2 << 21) & 29360128, FTPReply.SERVICE_NOT_READY);
            x10.r rVarV = com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132019141);
            ld1.q qVarU = i.u(ld1.r.Companion, R.dimen.m3_comp_fab_primary_large_icon_size);
            of1.n nVarL = of1.q.l();
            if (1.0f <= 0.0d) {
                a.a("invalid weight; must be greater than zero");
            }
            z10.d.h(rVarV, qVarU, nVarL, new LayoutWeightElement(1.0f, true), false, (of1.e) null, 3, (Function1) null, sVar, 0, 176);
            sVar = sVar;
            if (z) {
                com.facebook.appevents.h.c(o6.c.g(sVar, 1760214494, 2131231743, false), rVar, yVar, (p) null, false, false, f0Var2, sVar, (i2 << 15) & 29360128, FTPReply.SERVICE_NOT_READY);
                sVar.r(false);
            } else {
                sVar.f0(1760474181);
                tlydtdl.compose.foundation.layout.m.i(sVar, o2.p(mVar2, 48));
                sVar.r(false);
            }
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new dp0.b(f0Var, z, f0Var2, i, 23);
        }
    }

    public static final void h(w wVar, Function0 function0, v0 v0Var, tlydtdl.compose.runtime.m mVar, int i) {
        w wVar2;
        boolean z;
        boolean z2;
        s sVar = (s) mVar;
        sVar.h0(-103971099);
        int i2 = i | (sVar.g(wVar) ? 4 : 2) | (sVar.i(function0) ? 32 : 16) | (sVar.g(v0Var) ? 256 : 128);
        if (sVar.W(i2 & 1, (i2 & 147) != 146)) {
            p pVar = t3.m.a;
            p pVarF = tlydtdl.compose.foundation.layout.m.F(md1.g.v(o2.e(pVar, 1.0f), (md1.n0) null, (a5.h) null, false, false, (Function0) null, (Function0) null, function0, 63), 16, 0.0f, 2);
            l2 l2VarA = j2.a(tlydtdl.compose.foundation.layout.l.a, t3.c.j, sVar, 0);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, pVarF);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            i iVar = s4.k.f435f;
            tlydtdl.compose.runtime.a0.y(sVar, l2VarA, iVar);
            i iVar2 = s4.k.e;
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, iVar2);
            i iVar3 = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar3);
            }
            i iVar4 = s4.k.d;
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, iVar4);
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.a, false);
            int iHashCode2 = Long.hashCode(sVar.T);
            u1 u1VarM2 = sVar.m();
            p pVarX2 = j4.x(sVar, pVar);
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, u0VarD, iVar);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM2, iVar2);
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode2))) {
                i.x(iHashCode2, sVar, iHashCode2, iVar3);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX2, iVar4);
            String str = wVar.d;
            String str2 = wVar.c;
            dg1.d.a.getClass();
            dg1.g gVar = dg1.c.b;
            float f2 = 8;
            fe1.f.a(com.ironsource.adqualitysdk.sdk.i.a0.j(gVar, "placeholder", str, gVar, false), wVar.b, l2.f.b(f2), o2.p(pVar, 80), (t3.d) null, (q4.m) null, 0.0f, (a4.z) null, (Function0) null, false, (md1.n0) null, (fe1.j) null, (fe1.g) null, false, (Function3) null, (fe1.k) null, sVar, 3072, 0, 65520);
            if (v0Var != null) {
                sVar.f0(-1711722563);
                com.facebook.appevents.p.c(v0Var, k0.a, q0.a, tlydtdl.compose.foundation.layout.m.D(tlydtdl.compose.foundation.layout.x.a.b(pVar, t3.c.g), f2), sVar, (i2 >> 6) & 14, 0);
                z = false;
            } else {
                z = false;
                sVar.f0(-1719773325);
            }
            sVar.r(z);
            sVar.r(true);
            p pVarH = tlydtdl.compose.foundation.layout.m.H(pVar, 12, 0.0f, 0.0f, 0.0f, 14);
            e0 e0VarA = tlydtdl.compose.foundation.layout.c0.a(tlydtdl.compose.foundation.layout.l.c, t3.c.m, sVar, 0);
            int iHashCode3 = Long.hashCode(sVar.T);
            u1 u1VarM3 = sVar.m();
            p pVarX3 = j4.x(sVar, pVarH);
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, e0VarA, iVar);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM3, iVar2);
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode3))) {
                i.x(iHashCode3, sVar, iHashCode3, iVar3);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX3, iVar4);
            x10.c cVar = x10.v.Companion;
            wVar2 = wVar;
            String str3 = wVar2.b;
            cVar.getClass();
            x10.l lVarD = x10.c.d(str3);
            ld1.d dVar = ld1.r.Companion;
            z10.d.h(lVarD, i.u(dVar, R.dimen.m3_comp_fab_primary_large_icon_size), of1.q.c(), (p) null, false, (of1.e) null, 0, (Function1) null, sVar, 0, TelnetCommand.EL);
            float f3 = 4;
            tlydtdl.compose.foundation.layout.m.e(tlydtdl.compose.foundation.layout.m.H(pVar, 0.0f, f3, 0.0f, 0.0f, 13), tlydtdl.compose.foundation.layout.l.g(f3), tlydtdl.compose.foundation.layout.l.g(f3), null, 0, 0, q3.p.d(1695712676, new rr0.n(27, wVar2), sVar), sVar, 1573302, 56);
            sVar = sVar;
            if (str2 != null) {
                sVar.f0(562257095);
                x10.l lVarD2 = x10.c.d(str2);
                dVar.getClass();
                z10.d.h(lVarD2, new ld1.q(R.dimen.m3_comp_fab_primary_pressed_container_elevation), of1.q.h(), tlydtdl.compose.foundation.layout.m.H(pVar, 0.0f, f2, 0.0f, 0.0f, 13), false, (of1.e) null, 0, (Function1) null, sVar, 3072, 240);
                z2 = false;
            } else {
                z2 = false;
                sVar.f0(552845123);
            }
            sVar.r(z2);
            sVar.r(true);
            sVar.r(true);
        } else {
            wVar2 = wVar;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new v50.o(i, 15, wVar2, function0, v0Var);
        }
    }

    public static final void i(final a0 a0Var, final Map map, final v0 v0Var, final kd1.g gVar, final b60.z zVar, tlydtdl.compose.runtime.m mVar, final int i) {
        a2 a2VarV;
        Function2 function2;
        x xVar;
        lmjxuqdtp.jvm.internal.o.h(a0Var, "state");
        lmjxuqdtp.jvm.internal.o.h(map, "genericPreviewPlayerButtonStates");
        lmjxuqdtp.jvm.internal.o.h(v0Var, "transferredPreviewPlayerButtonState");
        lmjxuqdtp.jvm.internal.o.h(gVar, "tooltip");
        lmjxuqdtp.jvm.internal.o.h(zVar, "actions");
        s sVar = (s) mVar;
        sVar.h0(1445966031);
        int i2 = i | (sVar.g(a0Var) ? 4 : 2) | (sVar.g(map) ? 32 : 16) | (sVar.g(v0Var) ? 256 : 128) | (sVar.g(gVar) ? 2048 : 1024) | (sVar.g(zVar) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192);
        if (!sVar.W(i2 & 1, (i2 & 9363) != 9362)) {
            sVar.Z();
        } else {
            if (a0Var instanceof z) {
                a2VarV = sVar.v();
                if (a2VarV != null) {
                    final int i3 = 0;
                    function2 = new Function2(a0Var, map, v0Var, gVar, zVar, i, i3) { // from class: wg0.b0
                        public final /* synthetic */ int a;
                        public final /* synthetic */ a0 b;
                        public final /* synthetic */ Map c;
                        public final /* synthetic */ v0 d;
                        public final /* synthetic */ kd1.g e;

                        /* JADX INFO: renamed from: f, reason: collision with root package name */
                        public final /* synthetic */ b60.z f656f;

                        {
                            this.a = i3;
                        }

                        public final Object invoke(Object obj, Object obj2) {
                            switch (this.a) {
                                case 0:
                                    ((Integer) obj2).getClass();
                                    int iB = tlydtdl.compose.runtime.a0.B(1);
                                    c0.i(this.b, this.c, this.d, this.e, this.f656f, (tlydtdl.compose.runtime.m) obj, iB);
                                    break;
                                default:
                                    ((Integer) obj2).getClass();
                                    int iB2 = tlydtdl.compose.runtime.a0.B(1);
                                    c0.i(this.b, this.c, this.d, this.e, this.f656f, (tlydtdl.compose.runtime.m) obj, iB2);
                                    break;
                            }
                            return lx1.b0.a;
                        }
                    };
                    a2VarV.d = function2;
                }
                return;
            }
            p pVarD = o2.d(t3.m.a, 1.0f);
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.a, false);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, pVarD);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, u0VarD, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            i iVar = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
            y yVar = a0Var instanceof y ? (y) a0Var : null;
            if (yVar == null || (xVar = yVar.f659f) == null || !xVar.b) {
                sVar.f0(-611908852);
                Object objR = sVar.R();
                if (objR == tlydtdl.compose.runtime.l.a) {
                    objR = new vb.z(18);
                    sVar.q0(objR);
                }
                com.bandlab.uikit.compose.bottomsheet.l.a(new com.bandlab.uikit.compose.bottomsheet.e(true, false, (Function0) objR), (p) null, 0L, (com.bandlab.uikit.compose.bottomsheet.s) null, false, false, (v2) null, (Function2) null, q3.p.d(924987167, new com.bandlab.uikit.compose.bottomsheet.b(zVar, a0Var, gVar, v0Var, 8), sVar), sVar, 100663302, TelnetCommand.DONT);
                sVar.r(false);
            } else {
                sVar.f0(-612162091);
                j(((y) a0Var).f659f, map, zVar, sVar, ((i2 >> 6) & 896) | (i2 & 112));
                sVar.r(false);
            }
            sVar.r(true);
        }
        a2VarV = sVar.v();
        if (a2VarV != null) {
            final int i4 = 1;
            function2 = new Function2(a0Var, map, v0Var, gVar, zVar, i, i4) { // from class: wg0.b0
                public final /* synthetic */ int a;
                public final /* synthetic */ a0 b;
                public final /* synthetic */ Map c;
                public final /* synthetic */ v0 d;
                public final /* synthetic */ kd1.g e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                public final /* synthetic */ b60.z f656f;

                {
                    this.a = i4;
                }

                public final Object invoke(Object obj, Object obj2) {
                    switch (this.a) {
                        case 0:
                            ((Integer) obj2).getClass();
                            int iB = tlydtdl.compose.runtime.a0.B(1);
                            c0.i(this.b, this.c, this.d, this.e, this.f656f, (tlydtdl.compose.runtime.m) obj, iB);
                            break;
                        default:
                            ((Integer) obj2).getClass();
                            int iB2 = tlydtdl.compose.runtime.a0.B(1);
                            c0.i(this.b, this.c, this.d, this.e, this.f656f, (tlydtdl.compose.runtime.m) obj, iB2);
                            break;
                    }
                    return lx1.b0.a;
                }
            };
            a2VarV.d = function2;
        }
    }

    public static final void j(x xVar, Map map, b60.z zVar, tlydtdl.compose.runtime.m mVar, int i) {
        s sVar = (s) mVar;
        sVar.h0(1907865399);
        int i2 = (sVar.g(xVar) ? 4 : 2) | i | (sVar.g(map) ? 32 : 16);
        if ((i & 384) == 0) {
            i2 |= sVar.g(zVar) ? 256 : 128;
        }
        if (sVar.W(i2 & 1, (i2 & 147) != 146)) {
            j1.a(0, 1, sVar, (f0) zVar.h, false);
            p pVarO = l.o(o2.d(t3.m.a, 1.0f), i.e(2131100890, 0, sVar, ld1.r.Companion), w0.a);
            e0 e0VarA = tlydtdl.compose.foundation.layout.c0.a(tlydtdl.compose.foundation.layout.l.c, t3.c.m, sVar, 0);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, pVarO);
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
            i iVar = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
            sf1.q.g(com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132020596), new s0((ld1.r) null, (f0) zVar.h, 3), (ld1.r) null, ch0.b.z(), (ld1.r) null, (sf1.u0) null, (List) null, sVar, 0, 116);
            tlydtdl.compose.foundation.layout.j jVarJ = tlydtdl.compose.foundation.layout.d.j(12);
            f2 f2VarH = tlydtdl.compose.foundation.layout.m.h(0.0f, 16, 0.0f, 32, 5);
            boolean z = ((i2 & 896) == 256) | ((i2 & 14) == 4) | ((i2 & 112) == 32);
            Object objR = sVar.R();
            if (z || objR == tlydtdl.compose.runtime.l.a) {
                objR = new v00.d(xVar, zVar, map, 4);
                sVar.q0(objR);
            }
            b4.e((p) null, (f2.a0) null, f2VarH, false, jVarJ, (t3.f) null, (q1) null, false, (v2) null, (Function1) objR, sVar, 24960, 491);
            sVar = sVar;
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new rb1.a(i, 13, xVar, map, zVar);
        }
    }
}
