package cf1;

import a4.y;
import c4.d;
import c4.h;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import df1.b;
import ey1.e;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import md1.g;
import okhttp3.internal.http2.Http2;
import t1.v1;
import t4.r1;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.f3;
import tlydtdl.datastore.preferences.protobuf.j1;
import z3.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w0 {
    public static final a4.k a = a4.o.a();

    public static final void a(h hVar, q qVar, n nVar, p0 p0Var, boolean z, boolean z2, t3.p pVar, float f2, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        tlydtdl.compose.runtime.s sVar;
        t3.p pVar2;
        t3.p pVar3;
        t3.p pVar4;
        float f3 = r0.b;
        tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
        sVar2.h0(1564562806);
        if ((i & 6) == 0) {
            i2 = (sVar2.i(hVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? sVar2.g(qVar) : sVar2.i(qVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? sVar2.g(nVar) : sVar2.i(nVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar2.g(p0Var) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= sVar2.d(f3) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= sVar2.h(z) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= sVar2.h(z2) ? 1048576 : 524288;
        }
        int i3 = 12582912 | i2;
        if ((100663296 & i) == 0) {
            i3 |= sVar2.d(f2) ? 67108864 : 33554432;
        }
        if (sVar2.W(i3 & 1, (38347923 & i3) != 38347922)) {
            f3 f3VarO = g.o(g(qVar, z, false, z2), "inactiveTrackColor", (v1) null, sVar2, 48, 12);
            f3 f3VarO2 = g.o(g(qVar, z, true, z2), "activeTrackColor", (v1) null, sVar2, 48, 12);
            f3 f3VarO3 = g.o(f(nVar, z, false, z2), "inactiveTickColor", (v1) null, sVar2, 48, 12);
            f3 f3VarO4 = g.o(f(nVar, z, true, z2), "activeTickColor", (v1) null, sVar2, 48, 12);
            t3.p pVar5 = t3.m.a;
            t3.p pVarD = j4.D(o2.f(o2.e(pVar5, 1.0f), b.a), sVar2.k(r1.n) == p5.n.b ? 180.0f : 0.0f);
            boolean zI = ((i3 & 57344) == 16384) | sVar2.i(hVar) | sVar2.g(f3VarO) | sVar2.g(f3VarO2) | sVar2.g(f3VarO3) | sVar2.g(f3VarO4) | ((234881024 & i3) == 67108864) | ((i3 & 7168) == 2048);
            Object objR = sVar2.R();
            if (zI || objR == tlydtdl.compose.runtime.l.a) {
                pVar3 = pVarD;
                pVar4 = pVar5;
                sVar = sVar2;
                s0 s0Var = new s0(hVar, f2, p0Var, f3VarO, f3VarO2, f3VarO3, f3VarO4);
                sVar.q0(s0Var);
                objR = s0Var;
            } else {
                pVar3 = pVarD;
                pVar4 = pVar5;
                sVar = sVar2;
            }
            j1.c(0, sVar, (Function1) objR, pVar3);
            pVar2 = pVar4;
        } else {
            sVar = sVar2;
            sVar.Z();
            pVar2 = pVar;
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new t0(hVar, qVar, nVar, p0Var, z, z2, pVar2, f2, i);
        }
    }

    public static final void b(final b0 b0Var, final q qVar, final n nVar, final p0 p0Var, final boolean z, final boolean z2, final q0 q0Var, t3.p pVar, final float f2, tlydtdl.compose.runtime.m mVar, final int i) {
        int i2;
        tlydtdl.compose.runtime.s sVar;
        final t3.p pVar2;
        t3.p pVar3;
        int i3;
        t3.p pVar4;
        float f3 = r0.b;
        tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
        sVar2.h0(514958423);
        if ((i & 6) == 0) {
            i2 = (sVar2.i(b0Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? sVar2.g(qVar) : sVar2.i(qVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? sVar2.g(nVar) : sVar2.i(nVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar2.g(p0Var) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= sVar2.d(f3) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= sVar2.h(z) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= sVar2.h(z2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= sVar2.e(q0Var.ordinal()) ? 8388608 : 4194304;
        }
        int i4 = 100663296 | i2;
        if ((805306368 & i) == 0) {
            i4 |= sVar2.d(f2) ? 536870912 : 268435456;
        }
        if (sVar2.W(i4 & 1, (306783379 & i4) != 306783378)) {
            final f3 f3VarO = g.o(g(qVar, z, false, z2), "inactiveTrackColor", (v1) null, sVar2, 48, 12);
            final f3 f3VarO2 = g.o(g(qVar, z, true, z2), "activeTrackColor", (v1) null, sVar2, 48, 12);
            final f3 f3VarO3 = g.o(f(nVar, z, false, z2), "inactiveTickColor", (v1) null, sVar2, 48, 12);
            final f3 f3VarO4 = g.o(f(nVar, z, true, z2), "activeTickColor", (v1) null, sVar2, 48, 12);
            t3.p pVar5 = t3.m.a;
            t3.p pVarD = j4.D(o2.f(o2.e(pVar5, 1.0f), b.a), sVar2.k(r1.n) == p5.n.b ? 180.0f : 0.0f);
            boolean zI = ((29360128 & i4) == 8388608) | sVar2.i(b0Var) | sVar2.g(f3VarO) | sVar2.g(f3VarO2) | sVar2.g(f3VarO3) | sVar2.g(f3VarO4) | ((57344 & i4) == 16384) | ((1879048192 & i4) == 536870912) | ((i4 & 7168) == 2048);
            Object objR = sVar2.R();
            if (zI || objR == tlydtdl.compose.runtime.l.a) {
                pVar3 = pVar5;
                i3 = 0;
                pVar4 = pVarD;
                sVar = sVar2;
                Function1 function1 = new Function1() { // from class: cf1.u0
                    {
                        float f4 = r0.a;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
                    public final Object invoke(Object obj) throws Throwable {
                        a4.w wVar;
                        float f4 = r0.b;
                        d dVar = (d) obj;
                        lmjxuqdtp.jvm.internal.o.h(dVar, "$this$Canvas");
                        b0 b0Var2 = b0Var;
                        float fQ0 = (b0Var2.n.h() != Float.NEGATIVE_INFINITY && b0Var2.e().a()) ? dVar.q0(b0Var2.n.h()) : dVar.q0(b0Var2.m.h());
                        int iOrdinal = q0Var.ordinal();
                        float f5 = f2;
                        p0 p0Var2 = p0Var;
                        f3 f3Var = f3VarO;
                        f3 f3Var2 = f3VarO2;
                        f3 f3Var3 = f3VarO3;
                        f3 f3Var4 = f3VarO4;
                        if (iOrdinal == 0) {
                            w0.d(dVar, b0Var2.i, 0.0f, b0Var2.d(), ((y) f3Var.getValue()).a, ((y) f3Var2.getValue()).a, ((y) f3Var3.getValue()).a, ((y) f3Var4.getValue()).a, dVar.p0(0), fQ0, f5, p0Var2, false, b0Var2.f(), b0Var2.f());
                        } else {
                            if (iOrdinal != 1) {
                                throw new NoWhenBranchMatchedException();
                            }
                            float[] fArr = b0Var2.i;
                            float fD = b0Var2.d();
                            long j2 = ((y) f3Var.getValue()).a;
                            long j3 = ((y) f3Var2.getValue()).a;
                            long j4 = ((y) f3Var3.getValue()).a;
                            long j5 = ((y) f3Var4.getValue()).a;
                            float f7 = r0.a;
                            boolean zF = b0Var2.f();
                            a4.w wVarJ = dVar.x0().j();
                            try {
                                wVarJ.f(m8.d.g(0L, dVar.h()), a4.w0.g());
                                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (dVar.H0() & 4294967295L)))) & 4294967295L);
                                long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (dVar.h() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (dVar.H0() & 4294967295L)))) & 4294967295L);
                                long jFloatToRawIntBits3 = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (dVar.H0() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (dVar.H0() >> 32)))) << 32);
                                float fW0 = dVar.w0(f7);
                                float f8 = 2;
                                float f9 = fW0 / f8;
                                try {
                                    float fW02 = dVar.w0(f5);
                                    int i6 = (int) (jFloatToRawIntBits2 >> 32);
                                    float fIntBitsToFloat = Float.intBitsToFloat(i6);
                                    int i7 = (int) (jFloatToRawIntBits >> 32);
                                    float fIntBitsToFloat2 = (fIntBitsToFloat - Float.intBitsToFloat(i7)) * fD;
                                    float fW03 = zF ? dVar.w0(f4) + (dVar.w0(fQ0) / f8) : 0.0f;
                                    int i8 = (int) (jFloatToRawIntBits3 >> 32);
                                    long jFloatToRawIntBits4 = (((long) Float.floatToRawIntBits(Math.min(fIntBitsToFloat2, Float.intBitsToFloat(i8)))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (dVar.H0() & 4294967295L)))) & 4294967295L);
                                    long jFloatToRawIntBits5 = (((long) Float.floatToRawIntBits(Math.max(fIntBitsToFloat2, Float.intBitsToFloat(i8)))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (dVar.H0() & 4294967295L)))) & 4294967295L);
                                    long jFloatToRawIntBits6 = (((long) Float.floatToRawIntBits(st.w0.i(fIntBitsToFloat2 - (fIntBitsToFloat2 - fW03 < Float.intBitsToFloat(i8) ? fW03 : 0.0f), 0.0f, Float.intBitsToFloat(i8)))) << 32) | (((long) Float.floatToRawIntBits(fW0)) & 4294967295L);
                                    wVar = wVarJ;
                                    try {
                                        w0.e(dVar, (((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (dVar.H0() & 4294967295L)) - (Float.intBitsToFloat((int) (jFloatToRawIntBits6 & 4294967295L)) / f8))) & 4294967295L), jFloatToRawIntBits6, j2, fW02, f9);
                                        float f10 = fIntBitsToFloat2 + fW03;
                                        long jFloatToRawIntBits7 = (((long) Float.floatToRawIntBits(st.w0.i(((Float.intBitsToFloat(i6) - Float.intBitsToFloat(i8)) - (fIntBitsToFloat2 - Float.intBitsToFloat(i8))) - (f10 > Float.intBitsToFloat(i8) ? fW03 : 0.0f), 0.0f, Float.intBitsToFloat(i6) - Float.intBitsToFloat(i8)))) << 32) | (((long) Float.floatToRawIntBits(fW0)) & 4294967295L);
                                        w0.e(dVar, (((long) Float.floatToRawIntBits(Math.max(f10, Float.intBitsToFloat(i8)))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (dVar.H0() & 4294967295L)) - (Float.intBitsToFloat((int) (jFloatToRawIntBits7 & 4294967295L)) / f8))) & 4294967295L), jFloatToRawIntBits7, j2, fW02, f9);
                                        int i9 = (int) (jFloatToRawIntBits4 >> 32);
                                        float fMin = Float.intBitsToFloat(i9) < Float.intBitsToFloat(i8) ? Math.min(Float.intBitsToFloat(i8) - Float.intBitsToFloat(i9), fW03) : 0.0f;
                                        int i10 = (int) (jFloatToRawIntBits5 >> 32);
                                        float fMin2 = Float.intBitsToFloat(i10) > Float.intBitsToFloat(i8) ? Math.min(Float.intBitsToFloat(i10) - Float.intBitsToFloat(i8), fW03) : 0.0f;
                                        float fIntBitsToFloat3 = Float.intBitsToFloat(i9) + fMin;
                                        long jFloatToRawIntBits8 = (((long) Float.floatToRawIntBits(fW0)) & 4294967295L) | (((long) Float.floatToRawIntBits((Float.intBitsToFloat(i10) - fMin2) - fIntBitsToFloat3)) << 32);
                                        w0.e(dVar, (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (dVar.H0() & 4294967295L)) - (Float.intBitsToFloat((int) (jFloatToRawIntBits8 & 4294967295L)) / f8))) & 4294967295L), jFloatToRawIntBits8, j3, fW02, fW02);
                                        w0.c(dVar, fArr, (((long) Float.floatToRawIntBits(Float.intBitsToFloat(i7))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)))) & 4294967295L), (((long) Float.floatToRawIntBits(Float.intBitsToFloat(i6))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jFloatToRawIntBits2 & 4294967295L)))) & 4294967295L), fD > 0.5f ? 0.5f : fD, fD < 0.5f ? 0.5f : fD, j4, j5, true, new e(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY), new e(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY), p0Var2);
                                        wVar.k();
                                    } catch (Throwable th) {
                                        th = th;
                                        wVar.k();
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    wVar = wVarJ;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                wVar = wVarJ;
                            }
                        }
                        return lx1.b0.a;
                    }
                };
                sVar.q0(function1);
                objR = function1;
            } else {
                sVar = sVar2;
                pVar4 = pVarD;
                pVar3 = pVar5;
                i3 = 0;
            }
            j1.c(i3, sVar, (Function1) objR, pVar4);
            pVar2 = pVar3;
        } else {
            sVar = sVar2;
            sVar.Z();
            pVar2 = pVar;
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new Function2() { // from class: cf1.v0
                {
                    float f4 = r0.a;
                }

                public final Object invoke(Object obj, Object obj2) {
                    float f4 = r0.a;
                    ((Integer) obj2).getClass();
                    w0.b(b0Var, qVar, nVar, p0Var, z, z2, q0Var, pVar2, f2, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(i | 1));
                    return lx1.b0.a;
                }
            };
        }
    }

    public static final void c(d dVar, float[] fArr, long j2, long j3, float f2, float f3, long j4, long j5, boolean z, e eVar, e eVar2, p0 p0Var) {
        int length = fArr.length;
        int i = 0;
        while (i < length) {
            float f4 = fArr[i];
            boolean z2 = f4 > f3 || f4 < f2;
            int i2 = i;
            long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (ln1.e.I(f4, j2, z3.b.b(j3, Float.intBitsToFloat((int) (j3 >> 32)) - Float.intBitsToFloat((int) (p0Var.a >> 32)), 0.0f, 2)) >> 32)))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (dVar.H0() & 4294967295L)))) & 4294967295L);
            if (!z || !eVar.d(Float.valueOf(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32))))) {
                if (!eVar2.d(Float.valueOf(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32))))) {
                    d.n0(dVar, z2 ? j4 : j5, z3.b.b(jFloatToRawIntBits, 0.0f, Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) - (Float.intBitsToFloat((int) (p0Var.a & 4294967295L)) / 2), 1), p0Var.a, p0Var.b, (h) null, 0.0f, 1, 112);
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(c4.d r29, float[] r30, float r31, float r32, long r33, long r35, long r37, long r39, float r41, float r42, float r43, cf1.p0 r44, boolean r45, boolean r46, boolean r47) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 704
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cf1.w0.d(c4.d, float[], float, float, long, long, long, long, float, float, float, cf1.p0, boolean, boolean, boolean):void");
    }

    public static final void e(d dVar, long j2, long j3, long j4, float f2, float f3) {
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L);
        long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        c cVarG = m8.d.g(j2, (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
        z3.d dVar2 = new z3.d(cVarG.a, cVarG.b, cVarG.c, cVarG.d, jFloatToRawIntBits, jFloatToRawIntBits2, jFloatToRawIntBits2, jFloatToRawIntBits);
        a4.k kVar = a;
        a4.k.b(kVar, dVar2);
        d.Z(dVar, kVar, j4, 0.0f, (h) null, 60);
        kVar.a.rewind();
    }

    public static final ld1.r f(n nVar, boolean z, boolean z2, boolean z3) {
        return z ? z3 ? z2 ? nVar.c() : nVar.a() : nVar.a() : z3 ? z2 ? nVar.d() : nVar.b() : nVar.b();
    }

    public static final ld1.r g(q qVar, boolean z, boolean z2, boolean z3) {
        return z ? z3 ? z2 ? qVar.d() : qVar.b() : qVar.b() : z3 ? z2 ? qVar.a() : qVar.c() : qVar.c();
    }
}
