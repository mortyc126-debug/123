package tlydtdl.compose.foundation.layout;

import a2.o3;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.jvm.functions.Function1;
import okhttp3.internal.http2.Http2;
import q4.u0;
import tlydtdl.compose.runtime.x0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static final r4.h a = new r4.h(new g(13));
    public static final int b = 9;
    public static final int c = 6;
    public static final int d = 10;
    public static final int e = 5;

    /* JADX INFO: renamed from: f */
    public static final int f490f = 15;
    public static final int g = 48;

    public m() {
        z0 z0Var = z0.a;
    }

    public static final t3.p A(t3.p pVar, float f2, float f3) {
        return pVar.then(new OffsetElement(f2, f3, new y1(f2, f3, 0)));
    }

    public static t3.p B(t3.p pVar, float f2, float f3, int i) {
        if ((i & 1) != 0) {
            f2 = 0;
        }
        if ((i & 2) != 0) {
            f3 = 0;
        }
        return A(pVar, f2, f3);
    }

    public static final t3.p C(t3.p pVar, e2 e2Var) {
        return pVar.then(new PaddingValuesElement(e2Var, new o3(4, e2Var)));
    }

    public static final t3.p D(t3.p pVar, float f2) {
        return pVar.then(new PaddingElement(f2, f2, f2, f2, new b2(0, f2)));
    }

    public static final t3.p E(t3.p pVar, float f2, float f3) {
        return pVar.then(new PaddingElement(f2, f3, f2, f3, new y1(f2, f3, 1)));
    }

    public static t3.p F(t3.p pVar, float f2, float f3, int i) {
        if ((i & 1) != 0) {
            f2 = 0;
        }
        if ((i & 2) != 0) {
            f3 = 0;
        }
        return E(pVar, f2, f3);
    }

    public static final t3.p G(t3.p pVar, final float f2, final float f3, final float f4, final float f5) {
        return pVar.then(new PaddingElement(f2, f3, f4, f5, new Function1() { // from class: tlydtdl.compose.foundation.layout.c2
            public final Object invoke(Object obj) {
                t4.e2 e2Var = (t4.e2) obj;
                e2Var.d("padding");
                e2Var.b().c(new p5.f(f2), "start");
                e2Var.b().c(new p5.f(f3), "top");
                e2Var.b().c(new p5.f(f4), "end");
                e2Var.b().c(new p5.f(f5), "bottom");
                return lx1.b0.a;
            }
        }));
    }

    public static t3.p H(t3.p pVar, float f2, float f3, float f4, float f5, int i) {
        if ((i & 1) != 0) {
            f2 = 0;
        }
        if ((i & 2) != 0) {
            f3 = 0;
        }
        if ((i & 4) != 0) {
            f4 = 0;
        }
        if ((i & 8) != 0) {
            f5 = 0;
        }
        return G(pVar, f2, f3, f4, f5);
    }

    public static final t3.p I(t3.p pVar) {
        return j4.i(pVar, new a3(2));
    }

    public static final t3.p J(t3.p pVar) {
        return j4.i(pVar, new b3(1));
    }

    public static final long K(long j2, t1 t1Var) {
        return t1Var == t1.a ? p5.b.a(p5.a.j(j2), p5.a.h(j2), p5.a.i(j2), p5.a.g(j2)) : p5.b.a(p5.a.i(j2), p5.a.g(j2), p5.a.j(j2), p5.a.h(j2));
    }

    public static final n1 L(i6.c cVar) {
        return new n1(cVar.a, cVar.b, cVar.c, cVar.d);
    }

    public static final void M(String str, StringBuilder sb) {
        if (sb.length() > 0) {
            sb.append('+');
        }
        sb.append(str);
    }

    public static final t3.p N(t3.p pVar, p1 p1Var) {
        return pVar.then(new IntrinsicWidthElement(p1Var));
    }

    public static final t3.p O(t3.p pVar, v2 v2Var) {
        return j4.i(pVar, new y2(v2Var, 1));
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(t3.p r14, t3.d r15, boolean r16, q3.k r17, tlydtdl.compose.runtime.m r18, int r19, int r20) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.layout.m.a(t3.p, t3.d, boolean, q3.k, tlydtdl.compose.runtime.m, int, int):void");
    }

    public static final void b(t3.p pVar, k kVar, h hVar, p0 p0Var, q3.k kVar2, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        d1 d1Var;
        int i3;
        int i4;
        boolean z;
        Object obj;
        t3.f fVar = t3.c.m;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-1944405121);
        if ((i & 6) == 0) {
            i2 = (sVar.g(pVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.g(kVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar.g(hVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar.g(fVar) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= sVar.e(IntCompanionObject.MAX_VALUE) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= sVar.e(IntCompanionObject.MAX_VALUE) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= sVar.g(p0Var) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= sVar.i(kVar2) ? 8388608 : 4194304;
        }
        int i6 = i2;
        if (sVar.W(i6 & 1, (i6 & 4793491) != 4793490)) {
            int i7 = i6 & 3670016;
            boolean z2 = i7 == 1048576;
            Object objR = sVar.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (z2 || objR == x0Var) {
                p0Var.getClass();
                z0 z0Var = z0.a;
                objR = new d1();
                sVar.q0(objR);
            }
            d1 d1Var2 = (d1) objR;
            int i8 = i6 >> 3;
            boolean zG = ((((i8 & 14) ^ 6) > 4 && sVar.g(kVar)) || (i8 & 6) == 4) | ((((i8 & 112) ^ 48) > 32 && sVar.g(hVar)) || (i8 & 48) == 32) | ((((i8 & 896) ^ 384) > 256 && sVar.g(fVar)) || (i8 & 384) == 256) | ((((i8 & 7168) ^ 3072) > 2048 && sVar.e(IntCompanionObject.MAX_VALUE)) || (i8 & 3072) == 2048) | ((((57344 & i8) ^ 24576) > 16384 && sVar.e(IntCompanionObject.MAX_VALUE)) || (i8 & 24576) == 16384) | sVar.g(d1Var2);
            Object objR2 = sVar.R();
            if (zG || objR2 == x0Var) {
                d1Var = d1Var2;
                i3 = i7;
                f1 f1Var = new f1(false, hVar, kVar, kVar.c(), new i0(fVar), hVar.c(), IntCompanionObject.MAX_VALUE, d1Var);
                sVar.q0(f1Var);
                objR2 = f1Var;
            } else {
                d1Var = d1Var2;
                i3 = i7;
            }
            f1 f1Var2 = (f1) objR2;
            boolean z3 = (i3 == 1048576) | ((i6 & 29360128) == 8388608) | ((i6 & 458752) == 131072);
            Object objR3 = sVar.R();
            if (z3 || objR3 == x0Var) {
                ArrayList arrayList = new ArrayList();
                i4 = 0;
                z = true;
                arrayList.add(new q3.k(new x0(0, kVar2), true, -1720407857));
                p0Var.j(d1Var, arrayList);
                sVar.q0(arrayList);
                obj = arrayList;
            } else {
                i4 = 0;
                z = true;
                obj = objR3;
            }
            q3.k kVar3 = new q3.k(new q4.d0(i4, (List) obj), z, 1271844412);
            boolean zG2 = sVar.g(f1Var2);
            Object objR4 = sVar.R();
            if (zG2 || objR4 == x0Var) {
                objR4 = new q4.c1(f1Var2);
                sVar.q0(objR4);
            }
            u0 u0Var = (u0) objR4;
            int iHashCode = Long.hashCode(sVar.T);
            tlydtdl.compose.runtime.u1 u1VarM = sVar.m();
            t3.p pVarX = j4.x(sVar, pVar);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, u0Var, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
            i.z(0, kVar3, sVar, true);
        } else {
            sVar.Z();
        }
        tlydtdl.compose.runtime.a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new u0(pVar, kVar, hVar, p0Var, kVar2, i, 0);
        }
    }

    public static final void c(t3.p pVar, k kVar, h hVar, t3.f fVar, int i, int i2, q3.k kVar2, tlydtdl.compose.runtime.m mVar, int i3) {
        t3.p pVar2;
        t3.f fVar2;
        int i4;
        int i6;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(1371845627);
        int i7 = i3 | 224262;
        if (sVar.W(i7 & 1, (599187 & i7) != 599186)) {
            t3.f fVar3 = t3.c.m;
            p0 p0Var = p0.h;
            p0 p0VarI = d.i();
            t3.p pVar3 = t3.m.a;
            b(pVar3, kVar, hVar, p0VarI, kVar2, sVar, 14380470);
            pVar2 = pVar3;
            i4 = Integer.MAX_VALUE;
            i6 = Integer.MAX_VALUE;
            fVar2 = fVar3;
        } else {
            sVar.Z();
            pVar2 = pVar;
            fVar2 = fVar;
            i4 = i;
            i6 = i2;
        }
        tlydtdl.compose.runtime.a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new e(pVar2, kVar, hVar, fVar2, i4, i6, kVar2, i3);
        }
    }

    public static final void d(t3.p pVar, h hVar, k kVar, int i, g1 g1Var, q3.k kVar2, tlydtdl.compose.runtime.m mVar, int i2) {
        int i3;
        d1 d1Var;
        int i4;
        int i6;
        boolean z;
        Object obj;
        t3.g gVar = t3.c.j;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-1956591841);
        if ((i2 & 6) == 0) {
            i3 = (sVar.g(pVar) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= sVar.g(hVar) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= sVar.g(kVar) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= sVar.g(gVar) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= sVar.e(i) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= sVar.e(IntCompanionObject.MAX_VALUE) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= sVar.g(g1Var) ? 1048576 : 524288;
        }
        if ((12582912 & i2) == 0) {
            i3 |= sVar.i(kVar2) ? 8388608 : 4194304;
        }
        int i7 = i3;
        if (sVar.W(i7 & 1, (i7 & 4793491) != 4793490)) {
            int i8 = i7 & 3670016;
            boolean z2 = i8 == 1048576;
            Object objR = sVar.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (z2 || objR == x0Var) {
                g1Var.getClass();
                z0 z0Var = z0.a;
                objR = new d1();
                sVar.q0(objR);
            }
            d1 d1Var2 = (d1) objR;
            int i9 = i7 >> 3;
            boolean zG = ((((i9 & 14) ^ 6) > 4 && sVar.g(hVar)) || (i9 & 6) == 4) | ((((i9 & 112) ^ 48) > 32 && sVar.g(kVar)) || (i9 & 48) == 32) | ((((i9 & 896) ^ 384) > 256 && sVar.g(gVar)) || (i9 & 384) == 256) | ((((i9 & 7168) ^ 3072) > 2048 && sVar.e(i)) || (i9 & 3072) == 2048) | ((((57344 & i9) ^ 24576) > 16384 && sVar.e(IntCompanionObject.MAX_VALUE)) || (i9 & 24576) == 16384) | sVar.g(d1Var2);
            Object objR2 = sVar.R();
            if (zG || objR2 == x0Var) {
                d1Var = d1Var2;
                i4 = i8;
                f1 f1Var = new f1(true, hVar, kVar, hVar.c(), new j0(gVar), kVar.c(), i, d1Var);
                sVar.q0(f1Var);
                objR2 = f1Var;
            } else {
                d1Var = d1Var2;
                i4 = i8;
            }
            f1 f1Var2 = (f1) objR2;
            boolean z3 = (i4 == 1048576) | ((i7 & 29360128) == 8388608) | ((i7 & 458752) == 131072);
            Object objR3 = sVar.R();
            if (z3 || objR3 == x0Var) {
                ArrayList arrayList = new ArrayList();
                i6 = 0;
                z = true;
                arrayList.add(new q3.k(new y0(i6, kVar2), true, -1192950673));
                g1Var.j(d1Var, arrayList);
                sVar.q0(arrayList);
                obj = arrayList;
            } else {
                i6 = 0;
                z = true;
                obj = objR3;
            }
            q3.k kVar3 = new q3.k(new q4.d0(i6, (List) obj), z, 1271844412);
            boolean zG2 = sVar.g(f1Var2);
            Object objR4 = sVar.R();
            if (zG2 || objR4 == x0Var) {
                objR4 = new q4.c1(f1Var2);
                sVar.q0(objR4);
            }
            u0 u0Var = (u0) objR4;
            int iHashCode = Long.hashCode(sVar.T);
            tlydtdl.compose.runtime.u1 u1VarM = sVar.m();
            t3.p pVarX = j4.x(sVar, pVar);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, u0Var, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
            i.z(0, kVar3, sVar, true);
        } else {
            sVar.Z();
        }
        tlydtdl.compose.runtime.a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new w0(pVar, hVar, kVar, i, g1Var, kVar2, i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e(t3.p r12, tlydtdl.compose.foundation.layout.h r13, final tlydtdl.compose.foundation.layout.k r14, t3.g r15, int r16, int r17, final q3.k r18, tlydtdl.compose.runtime.m r19, final int r20, final int r21) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.layout.m.e(t3.p, tlydtdl.compose.foundation.layout.h, tlydtdl.compose.foundation.layout.k, t3.g, int, int, q3.k, tlydtdl.compose.runtime.m, int, int):void");
    }

    public static f2 f(float f2, float f3, int i) {
        if ((i & 1) != 0) {
            f2 = 0;
        }
        if ((i & 2) != 0) {
            f3 = 0;
        }
        return new f2(f2, f3, f2, f3);
    }

    public static final f2 g(float f2, float f3, float f4, float f5) {
        return new f2(f2, f3, f4, f5);
    }

    public static f2 h(float f2, float f3, float f4, float f5, int i) {
        if ((i & 1) != 0) {
            f2 = 0;
        }
        if ((i & 2) != 0) {
            f3 = 0;
        }
        if ((i & 4) != 0) {
            f4 = 0;
        }
        if ((i & 8) != 0) {
            f5 = 0;
        }
        return new f2(f2, f3, f4, f5);
    }

    public static final void i(tlydtdl.compose.runtime.m mVar, t3.p pVar) {
        r rVar = r.c;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        int iHashCode = Long.hashCode(sVar.T);
        t3.p pVarX = j4.x(mVar, pVar);
        tlydtdl.compose.runtime.u1 u1VarM = sVar.m();
        s4.l.f436d2.getClass();
        s4.j jVar = s4.k.b;
        qu0.u uVar = sVar.a;
        sVar.j0();
        if (sVar.S) {
            sVar.l(jVar);
        } else {
            sVar.t0();
        }
        tlydtdl.compose.runtime.a0.y(mVar, rVar, s4.k.f435f);
        tlydtdl.compose.runtime.a0.y(mVar, u1VarM, s4.k.e);
        tlydtdl.compose.runtime.a0.y(mVar, pVarX, s4.k.d);
        s4.i iVar = s4.k.g;
        if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
            i.x(iHashCode, sVar, iHashCode, iVar);
        }
        sVar.r(true);
    }

    public static final m1 l(v2 v2Var, tlydtdl.compose.runtime.m mVar) {
        return new m1(v2Var, (p5.c) ((tlydtdl.compose.runtime.s) mVar).k(t4.r1.h));
    }

    public static final t3.p m(float f2, t3.p pVar, boolean z) {
        return pVar.then(new AspectRatioElement(f2, z));
    }

    public static final float n(e2 e2Var, p5.n nVar) {
        return nVar == p5.n.a ? e2Var.c(nVar) : e2Var.b(nVar);
    }

    public static final float o(e2 e2Var, p5.n nVar) {
        return nVar == p5.n.a ? e2Var.b(nVar) : e2Var.c(nVar);
    }

    public static long p(long j2, t1 t1Var) {
        t1 t1Var2 = t1.a;
        return p5.b.a(t1Var == t1Var2 ? p5.a.j(j2) : p5.a.i(j2), t1Var == t1Var2 ? p5.a.h(j2) : p5.a.g(j2), t1Var == t1Var2 ? p5.a.i(j2) : p5.a.j(j2), t1Var == t1Var2 ? p5.a.g(j2) : p5.a.h(j2));
    }

    public static final t3.p q(t3.p pVar, v2 v2Var) {
        return j4.i(pVar, new y2(v2Var, 0));
    }

    public static long r(int i, long j2) {
        return p5.b.a(0, p5.a.h(j2), (i & 4) != 0 ? p5.a.i(j2) : 0, p5.a.g(j2));
    }

    public static final i2 s(q4.v vVar) {
        Object objL = vVar.l();
        if (objL instanceof i2) {
            return (i2) objL;
        }
        return null;
    }

    public static final float t(i2 i2Var) {
        if (i2Var != null) {
            return i2Var.a;
        }
        return 0.0f;
    }

    public static final t3.p u(t3.p pVar, p1 p1Var) {
        return pVar.then(new IntrinsicHeightElement(p1Var));
    }

    public static final boolean v(int i, long j2, int i2) {
        int iJ = p5.a.j(j2);
        if (i > p5.a.h(j2) || iJ > i) {
            return false;
        }
        return i2 <= p5.a.g(j2) && p5.a.i(j2) <= i2;
    }

    public static final q4.v0 w(h2 h2Var, int i, int i2, int i3, int i4, int i6, q4.w0 w0Var, List list, q4.m1[] m1VarArr, int i7, int i8, int[] iArr, int i9) {
        int i10;
        float f2;
        long j2;
        int i11;
        int i12;
        int i13;
        List list2 = list;
        long j3 = i6;
        int i14 = i8 - i7;
        int[] iArr2 = new int[i14];
        int i15 = i7;
        int iMax = 0;
        int i16 = 0;
        int i17 = 0;
        int iMin = 0;
        float f3 = 0.0f;
        while (i15 < i8) {
            q4.t0 t0Var = (q4.t0) list2.get(i15);
            float fT = t(s(t0Var));
            if (fT > 0.0f) {
                f3 += fT;
                i16++;
                j2 = j3;
                i11 = i15;
            } else {
                int i18 = i3 - i17;
                q4.m1 m1VarT = m1VarArr[i15];
                j2 = j3;
                if (m1VarT == null) {
                    if (i3 == Integer.MAX_VALUE) {
                        i11 = i15;
                        i12 = i16;
                        i13 = IntCompanionObject.MAX_VALUE;
                    } else {
                        i11 = i15;
                        i12 = i16;
                        i13 = i18 < 0 ? 0 : i18;
                    }
                    m1VarT = t0Var.T(h2Var.h(0, i13, i4, false));
                } else {
                    i11 = i15;
                    i12 = i16;
                }
                q4.m1 m1Var = m1VarT;
                int iJ = h2Var.j(m1Var);
                int iG = h2Var.g(m1Var);
                iArr2[i11 - i7] = iJ;
                int i19 = i18 - iJ;
                if (i19 < 0) {
                    i19 = 0;
                }
                iMin = Math.min(i6, i19);
                i17 += iJ + iMin;
                iMax = Math.max(iMax, iG);
                m1VarArr[i11] = m1Var;
                i16 = i12;
            }
            i15 = i11 + 1;
            j3 = j2;
        }
        long j4 = j3;
        int i20 = i16;
        if (i20 == 0) {
            i17 -= iMin;
            i10 = 0;
        } else {
            long j5 = ((long) (i20 - 1)) * j4;
            long jRound = ((long) ((i3 != Integer.MAX_VALUE ? i3 : i) - i17)) - j5;
            if (jRound < 0) {
                jRound = 0;
            }
            float f4 = jRound / f3;
            for (int i21 = i7; i21 < i8; i21++) {
                jRound -= (long) Math.round(t(s((q4.t0) list2.get(i21))) * f4);
            }
            int i22 = i7;
            int i23 = iMax;
            int i24 = 0;
            while (i22 < i8) {
                if (m1VarArr[i22] == null) {
                    q4.t0 t0Var2 = (q4.t0) list2.get(i22);
                    f2 = f4;
                    i2 i2VarS = s(t0Var2);
                    float fT2 = t(i2VarS);
                    if (fT2 <= 0.0f) {
                        e2.a.b("All weights <= 0 should have placeables");
                    }
                    int iSignum = Long.signum(jRound);
                    long j6 = jRound - ((long) iSignum);
                    int iMax2 = Math.max(0, Math.round(fT2 * f2) + iSignum);
                    q4.m1 m1VarT2 = t0Var2.T(h2Var.h((!(i2VarS != null ? i2VarS.b : true) || iMax2 == Integer.MAX_VALUE) ? 0 : iMax2, iMax2, i4, true));
                    int iJ2 = h2Var.j(m1VarT2);
                    int iG2 = h2Var.g(m1VarT2);
                    iArr2[i22 - i7] = iJ2;
                    i24 += iJ2;
                    int iMax3 = Math.max(i23, iG2);
                    m1VarArr[i22] = m1VarT2;
                    i23 = iMax3;
                    jRound = j6;
                } else {
                    f2 = f4;
                }
                i22++;
                list2 = list;
                f4 = f2;
            }
            i10 = (int) (((long) i24) + j5);
            int i25 = i3 - i17;
            if (i10 < 0) {
                i10 = 0;
            }
            if (i10 > i25) {
                i10 = i25;
            }
            iMax = i23;
        }
        int i26 = i10 + i17;
        if (i26 < 0) {
            i26 = 0;
        }
        int iMax4 = Math.max(i26, i);
        int iMax5 = Math.max(iMax, Math.max(i2, 0));
        int[] iArr3 = new int[i14];
        h2Var.f(iMax4, iArr2, iArr3, w0Var);
        return h2Var.i(m1VarArr, w0Var, iArr3, iMax4, iMax5, iArr, i9, i7, i8);
    }

    public static final void x(q4.t0 t0Var, f1 f1Var, long j2, Function1 function1) {
        boolean z = f1Var.a;
        if (t(s(t0Var)) == 0.0f) {
            s(t0Var);
            q4.m1 m1VarT = t0Var.T(j2);
            function1.invoke(m1VarT);
            f1Var.j(m1VarT);
            f1Var.g(m1VarT);
            return;
        }
        int iM = z ? t0Var.M(IntCompanionObject.MAX_VALUE) : t0Var.z(IntCompanionObject.MAX_VALUE);
        if (z) {
            t0Var.z(iM);
        } else {
            t0Var.M(iM);
        }
    }

    public static final t3.p y(t3.p pVar) {
        return j4.i(pVar, new b3(0));
    }

    public static final t3.p z(t3.p pVar, Function1 function1) {
        return pVar.then(new OffsetPxElement(function1, new x1(0, function1)));
    }

    public void j(d1 d1Var, ArrayList arrayList) {
        z0 z0Var = z0.a;
        int i = a1.$EnumSwitchMapping$0[1];
    }

    public abstract int k(int i, p5.n nVar);
}
