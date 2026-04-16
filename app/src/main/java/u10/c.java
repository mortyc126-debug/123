package u10;

import a4.a1;
import a4.w0;
import com.gnacba.amuvvoafs.gms.internal.measurement.b4;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import com.google.android.material.R;
import java.util.List;
import java.util.WeakHashMap;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.internal.o;
import md1.n0;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Http2;
import q4.u0;
import qu0.u;
import st1.t1;
import t3.d;
import t4.r1;
import tlydtdl.compose.foundation.layout.e;
import tlydtdl.compose.foundation.layout.j2;
import tlydtdl.compose.foundation.layout.l;
import tlydtdl.compose.foundation.layout.l2;
import tlydtdl.compose.foundation.layout.n2;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.foundation.layout.x2;
import tlydtdl.compose.foundation.lazy.layout.h0;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.u1;
import tlydtdl.compose.runtime.x0;
import tlydtdl.compose.ui.platform.a;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static final float a = 50;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2, types: [tlydtdl.compose.runtime.s] */
    /* JADX WARN: Type inference failed for: r12v3, types: [tlydtdl.compose.runtime.m, tlydtdl.compose.runtime.s] */
    /* JADX WARN: Type inference failed for: r12v5, types: [tlydtdl.compose.runtime.s] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r22v1, types: [tlydtdl.compose.runtime.m] */
    public static final void a(u uVar, t3.p pVar, cd1.g gVar, tlydtdl.compose.runtime.m mVar, int i) {
        ?? r12;
        a2.q qVarI;
        ?? r0;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-1944541975);
        int i2 = (i & 6) == 0 ? (sVar.g(uVar) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= sVar.g(pVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar.i(gVar) ? 256 : 128;
        }
        boolean z = true;
        ?? r15 = 0;
        if (sVar.W(i2 & 1, (i2 & 147) != 146)) {
            t3.p pVarA = a.a(b4.v(o2.f(o2.e(pVar, 1.0f), a), w0.a), "nav-bar");
            l2 l2VarA = j2.a(l.a, t3.c.j, sVar, 0);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            t3.p pVarX = j4.x(sVar, pVarA);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
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
            sVar.f0(1545308059);
            ?? r122 = sVar;
            for (i iVar2 : (List) uVar.b) {
                boolean z2 = iVar2 instanceof g;
                t3.p pVar2 = t3.m.a;
                n2 n2Var = n2.a;
                if (z2) {
                    r122.f0(1660410258);
                    g gVar2 = (g) iVar2;
                    b(gVar2.a, ((Boolean) st.w0.r(gVar2.c, (tlydtdl.compose.runtime.m) r122, (int) r15, 7).getValue()).booleanValue(), gVar2.b, gVar2.e, n2Var.a(1.0f, pVar2, z), gVar != null ? bn1.c.i(gVar, gVar2.d, new cd1.a((boolean) r15)) : null, r122, 0);
                    r122.r(r15);
                    r0 = r15;
                } else {
                    if (!(iVar2 instanceof h)) {
                        throw com.ironsource.adqualitysdk.sdk.i.a0.q((tlydtdl.compose.runtime.s) r122, -1193365930, (boolean) r15);
                    }
                    r122.f0(1661226302);
                    h hVar = (h) iVar2;
                    dg1.i iVar3 = (dg1.i) st.w0.r(hVar.i, (tlydtdl.compose.runtime.m) r122, (int) r15, 7).getValue();
                    String string = md1.g.d0(hVar.d, (tlydtdl.compose.runtime.m) r122).toString();
                    a4.q qVarN = bh.j.n(R.dimen.m3_comp_fab_primary_large_icon_size, 6, r122, ld1.r.Companion);
                    t3.p pVarC = o2.c(n2Var.a(1.0f, pVar2, z), 1.0f);
                    if (gVar != null) {
                        String str = hVar.c;
                        if (str == null) {
                            str = HttpUrl.FRAGMENT_ENCODE_SET;
                        }
                        qVarI = bn1.c.i(gVar, str, null);
                    } else {
                        qVarI = null;
                    }
                    if (qVarI != null) {
                        pVarC = pVarC.then(tlydtdl.compose.ui.layout.a.f(pVar2, qVarI));
                    }
                    ?? r22 = r122;
                    r0 = 0;
                    fe1.f.a(iVar3, string, (a1) null, o2.A(md1.g.v(pVarC, (n0) null, new a5.h(0), true, false, (Function0) null, hVar.f610f, hVar.e, 25), null, 3), (d) null, (q4.m) null, 0.0f, qVarN, (Function0) null, false, (n0) null, (fe1.j) null, (fe1.g) null, false, (Function3) null, (fe1.k) null, (tlydtdl.compose.runtime.m) r22, 384, 0, 65392);
                    r122 = r22;
                    r122.r(false);
                }
                r15 = r0;
                z = true;
                r122 = r122;
            }
            r122.r(r15);
            r122.r(true);
            r12 = r122;
        } else {
            sVar.Z();
            r12 = sVar;
        }
        a2 a2VarV = r12.v();
        if (a2VarV != null) {
            a2VarV.d = new h0(i, 9, uVar, pVar, gVar);
        }
    }

    public static final void b(Function0 function0, boolean z, Function1 function1, v vVar, t3.p pVar, Function1 function12, tlydtdl.compose.runtime.m mVar, int i) {
        o.h(vVar, "contentDescription");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(1166141136);
        int i2 = i | (sVar.i(function0) ? 4 : 2) | (sVar.h(z) ? 32 : 16) | (sVar.i(function1) ? 256 : 128) | (sVar.g(vVar) ? 2048 : 1024) | (sVar.g(pVar) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192) | (sVar.i(function12) ? 131072 : 65536);
        if (sVar.W(i2 & 1, (74899 & i2) != 74898)) {
            WeakHashMap weakHashMap = x2.v;
            int iD = (16 & 16) != 0 ? e.e(sVar).k.d((p5.c) sVar.k(r1.h)) : 0;
            Object objR = sVar.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (objR == x0Var) {
                objR = a0.t(null);
                sVar.q0(objR);
            }
            e1 e1Var = (e1) objR;
            t3.p pVarC = o2.c(pVar, 1.0f);
            a5.h hVar = new a5.h(0);
            boolean z2 = (i2 & 896) == 256;
            Object objR2 = sVar.R();
            if (z2 || objR2 == x0Var) {
                objR2 = new t1.d(e1Var, function1);
                sVar.q0(objR2);
            }
            t3.p pVarV = md1.g.v(pVarC, (n0) null, hVar, true, false, (Function0) null, (Function0) objR2, function0, 25);
            if (function12 != null) {
                pVarV = pVarV.then(tlydtdl.compose.ui.layout.a.f(t3.m.a, function12));
            }
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.e, false);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            t3.p pVarX = j4.x(sVar, pVarV);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            a0.y(sVar, u0VarD, s4.k.f435f);
            a0.y(sVar, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            a0.y(sVar, pVarX, s4.k.d);
            String string = md1.g.d0(vVar, sVar).toString();
            boolean zE = sVar.e(iD);
            Object objR3 = sVar.R();
            if (zE || objR3 == x0Var) {
                objR3 = new df1.a(iD, e1Var);
                sVar.q0(objR3);
            }
            t1.e(z, (t3.p) null, (Function1) objR3, string, sVar, (i2 >> 3) & 14, 2);
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new tn0.l(function0, z, function1, vVar, pVar, function12, i);
        }
    }
}
