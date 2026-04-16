package tlydtdl.compose.material3;

import a4.a1;
import a5.h;
import c2.m;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import f3.c3;
import f3.i3;
import f3.j3;
import f3.p1;
import f3.p2;
import h3.t;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import okhttp3.internal.http2.Http2;
import q4.q;
import q4.u0;
import s4.i;
import s4.j;
import s4.k;
import t1.z0;
import t3.p;
import tlydtdl.compose.foundation.d;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.foundation.layout.x;
import tlydtdl.compose.foundation.selection.c;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.l;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.u1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final float a;
    public static final float b;
    public static final float c;
    public static final float d;
    public static final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final z0 f521f;

    static {
        float f2 = t.c;
        a = f2;
        b = t.i;
        c = t.h;
        float f3 = t.e;
        d = f3;
        e = (f3 - f2) / 2;
        f521f = new z0();
    }

    public static final void a(boolean z, Function1 function1, p pVar, boolean z2, i3 i3Var, m mVar, tlydtdl.compose.runtime.m mVar2, int i) {
        int i2;
        m mVar3;
        p pVarA;
        s sVar = (s) mVar2;
        sVar.h0(-263339167);
        if ((i & 6) == 0) {
            i2 = (sVar.h(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.i(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar.g(pVar) ? 256 : 128;
        }
        int i3 = i2 | 3072;
        if ((i & 24576) == 0) {
            i3 |= sVar.h(z2) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= sVar.g(i3Var) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= sVar.g(mVar) ? 1048576 : 524288;
        }
        int i4 = i3;
        if (sVar.W(i4 & 1, (599187 & i4) != 599186)) {
            sVar.b0();
            if ((i & 1) != 0 && !sVar.D()) {
                sVar.Z();
            }
            sVar.s();
            if (mVar == null) {
                sVar.f0(1768604058);
                Object objR = sVar.R();
                if (objR == l.a) {
                    objR = s1.a.h(sVar);
                }
                sVar.r(false);
                mVar3 = (m) objR;
            } else {
                sVar.f0(334145757);
                sVar.r(false);
                mVar3 = mVar;
            }
            if (function1 != null) {
                q qVar = p1.a;
                pVarA = c.a(MinimumInteractiveModifier.a, z, mVar3, z2, new h(2), function1);
            } else {
                pVarA = t3.m.a;
            }
            int i6 = i4 << 3;
            int i7 = i4 >> 6;
            b(o2.l(o2.A(pVar.then(pVarA), t3.c.e, 2), c, d), z, z2, i3Var, mVar3, c3.a(t.a, sVar), sVar, (i6 & 112) | (i7 & 896) | (i7 & 7168) | (i6 & 57344));
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new j3(z, function1, pVar, z2, i3Var, mVar, i);
        }
    }

    public static final void b(p pVar, boolean z, boolean z2, i3 i3Var, m mVar, a1 a1Var, tlydtdl.compose.runtime.m mVar2, int i) {
        int i2;
        s sVar = (s) mVar2;
        sVar.h0(-670917213);
        if ((i & 6) == 0) {
            i2 = (sVar.g(pVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.h(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar.h(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar.g(i3Var) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= sVar.i(null) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= sVar.g(mVar) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= sVar.g(a1Var) ? 1048576 : 524288;
        }
        if (sVar.W(i2 & 1, (599187 & i2) != 599186)) {
            long j2 = z2 ? z ? i3Var.b : i3Var.f : z ? i3Var.j : i3Var.n;
            long j3 = z2 ? z ? i3Var.a : i3Var.e : z ? i3Var.i : i3Var.m;
            a1 a1VarA = c3.a(t.g, sVar);
            p pVarC = tlydtdl.compose.foundation.a.c(qg.a.d(pVar, t.f, z2 ? z ? i3Var.c : i3Var.g : z ? i3Var.k : i3Var.o, a1VarA), j2, a1VarA);
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.a, false);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, pVarC);
            s4.l.f436d2.getClass();
            j jVar = k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            i iVar = k.f435f;
            a0.y(sVar, u0VarD, iVar);
            i iVar2 = k.e;
            a0.y(sVar, u1VarM, iVar2);
            i iVar3 = k.g;
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar3);
            }
            i iVar4 = k.d;
            a0.y(sVar, pVarX, iVar4);
            p pVarC2 = tlydtdl.compose.foundation.a.c(d.a(x.a.b(t3.m.a, t3.c.d).then(new ThumbElement(mVar, z, f3.o2.a(h3.k.b, sVar))), mVar, p2.b(4, t.d / 2)), j3, a1Var);
            u0 u0VarD2 = tlydtdl.compose.foundation.layout.s.d(t3.c.e, false);
            int iHashCode2 = Long.hashCode(sVar.T);
            u1 u1VarM2 = sVar.m();
            p pVarX2 = j4.x(sVar, pVarC2);
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
            sVar.f0(1236071411);
            sVar.r(false);
            sVar.r(true);
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new j3(pVar, z, z2, i3Var, mVar, a1Var, i);
        }
    }
}
