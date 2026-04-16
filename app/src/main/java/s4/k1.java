package s4;

import a4.o0;
import a4.w0;
import amuvvoafs.os.Build;
import amuvvoafs.view.ViewParent;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import okhttp3.internal.http2.Http2;
import q4.m1;
import q4.v0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k1 extends s0 implements q4.t0, q4.b0, t1 {
    public static final a4.x0 K;
    public static final x L;
    public static final float[] M;
    public static final e N;
    public static final e O;
    public float A;
    public z3.a B;
    public x C;
    public d4.c D;
    public a4.w E;
    public g1 F;
    public boolean H;
    public s1 I;
    public d4.c J;
    public final j0 o;
    public k1 p;
    public k1 q;
    public boolean r;
    public boolean s;
    public Function1 t;
    public p5.c u;
    public p5.n v;
    public v0 x;
    public q1.f0 y;
    public float w = 0.8f;
    public long z = 0;
    public final h1 G = new h1(this, 1);

    static {
        a4.x0 x0Var = new a4.x0();
        x0Var.b = 1.0f;
        x0Var.c = 1.0f;
        x0Var.d = 1.0f;
        long j2 = a4.i0.a;
        x0Var.h = j2;
        x0Var.i = j2;
        x0Var.l = 8.0f;
        x0Var.m = a4.f1.b;
        x0Var.n = w0.a;
        x0Var.p = 0;
        x0Var.q = 9205357640488583168L;
        x0Var.r = es1.c.c();
        x0Var.s = p5.n.a;
        x0Var.t = 3;
        K = x0Var;
        L = new x();
        M = a4.m0.a();
        N = new e(1);
        O = new e(2);
    }

    public k1(j0 j0Var) {
        this.o = j0Var;
        this.u = j0Var.x;
        this.v = j0Var.y;
    }

    public static k1 D1(q4.b0 b0Var) {
        k1 k1Var;
        q4.r0 r0Var = b0Var instanceof q4.r0 ? (q4.r0) b0Var : null;
        if (r0Var != null && (k1Var = r0Var.a.o) != null) {
            return k1Var;
        }
        lmjxuqdtp.jvm.internal.o.f(b0Var, "null cannot be cast to non-null type tlydtdl.compose.ui.node.NodeCoordinator");
        return (k1) b0Var;
    }

    public final long A(long j2) {
        long jY = Y(j2);
        t4.x xVarA = m0.a(this.o);
        xVarA.y();
        return a4.m0.b(jY, xVarA.S);
    }

    public final void A1(z3.a aVar, boolean z, boolean z2) {
        t4.y1 y1Var = this.I;
        if (y1Var != null) {
            if (this.s) {
                if (z2) {
                    long jI1 = i1();
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (jI1 >> 32)) / 2.0f;
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jI1 & 4294967295L)) / 2.0f;
                    long j2 = ((m1) this).c;
                    aVar.a(-fIntBitsToFloat, -fIntBitsToFloat2, ((int) (j2 >> 32)) + fIntBitsToFloat, ((int) (j2 & 4294967295L)) + fIntBitsToFloat2);
                } else if (z) {
                    long j3 = ((m1) this).c;
                    aVar.a(0.0f, 0.0f, (int) (j3 >> 32), (int) (j3 & 4294967295L));
                }
                if (aVar.b()) {
                    return;
                }
            }
            y1Var.c(aVar, false);
        }
        long j4 = this.z;
        float f2 = (int) (j4 >> 32);
        aVar.a += f2;
        aVar.c += f2;
        float f3 = (int) (j4 & 4294967295L);
        aVar.b += f3;
        aVar.d += f3;
    }

    public final z3.c B(q4.b0 b0Var, boolean z) {
        if (!g()) {
            p4.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        if (!b0Var.g()) {
            p4.a.b("LayoutCoordinates " + b0Var + " is not attached!");
        }
        k1 k1VarD1 = D1(b0Var);
        k1VarD1.t1();
        k1 k1VarF1 = f1(k1VarD1);
        z3.a aVar = this.B;
        if (aVar == null) {
            aVar = new z3.a();
            this.B = aVar;
        }
        aVar.a = 0.0f;
        aVar.b = 0.0f;
        aVar.c = (int) (b0Var.a() >> 32);
        aVar.d = (int) (b0Var.a() & 4294967295L);
        while (k1VarD1 != k1VarF1) {
            k1VarD1.A1(aVar, z, false);
            if (aVar.b()) {
                return z3.c.e;
            }
            k1VarD1 = k1VarD1.q;
            lmjxuqdtp.jvm.internal.o.e(k1VarD1);
        }
        Y0(k1VarF1, aVar, z);
        return new z3.c(aVar.a, aVar.b, aVar.c, aVar.d);
    }

    public final void B1() throws NoWhenBranchMatchedException, KotlinNothingValueException {
        if (this.I != null) {
            if (this.J != null) {
                this.J = null;
            }
            I1(false, null);
            this.o.X(false);
        }
    }

    public final void C1(v0 v0Var) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        k1 k1Var;
        v0 v0Var2 = this.x;
        if (v0Var != v0Var2) {
            this.x = v0Var;
            j0 j0Var = this.o;
            int i = 0;
            if (v0Var2 == null || v0Var.getWidth() != v0Var2.getWidth() || v0Var.getHeight() != v0Var2.getHeight()) {
                int width = v0Var.getWidth();
                int height = v0Var.getHeight();
                t4.y1 y1Var = this.I;
                if (y1Var != null) {
                    y1Var.f((((long) width) << 32) | (((long) height) & 4294967295L));
                } else if (j0Var.J() && (k1Var = this.q) != null) {
                    k1Var.q1();
                }
                m0((((long) height) & 4294967295L) | (((long) width) << 32));
                if (this.t != null) {
                    J1(false);
                }
                boolean zH = l1.h(4);
                t3.o oVarJ1 = j1();
                if (zH || (oVarJ1 = oVarJ1.getParent$ui_release()) != null) {
                    for (t3.o oVarL1 = l1(zH); oVarL1 != null && (oVarL1.getAggregateChildKindSet$ui_release() & 4) != 0; oVarL1 = oVarL1.getChild$ui_release()) {
                        if ((oVarL1.getKindSet$ui_release() & 4) != 0) {
                            t3.o oVarE = oVarL1;
                            k3.e eVar = null;
                            while (oVarE != null) {
                                if (oVarE instanceof q) {
                                    ((q) oVarE).o0();
                                } else if ((oVarE.getKindSet$ui_release() & 4) != 0 && (oVarE instanceof o)) {
                                    int i2 = 0;
                                    for (t3.o child$ui_release = ((o) oVarE).b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                                        if ((child$ui_release.getKindSet$ui_release() & 4) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                oVarE = child$ui_release;
                                            } else {
                                                if (eVar == null) {
                                                    eVar = new k3.e(0, new t3.o[16]);
                                                }
                                                if (oVarE != null) {
                                                    eVar.d(oVarE);
                                                    oVarE = null;
                                                }
                                                eVar.d(child$ui_release);
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                oVarE = g.e(eVar);
                            }
                        }
                        if (oVarL1 == oVarJ1) {
                            break;
                        }
                    }
                }
                t4.x xVar = j0Var.m;
                if (xVar != null) {
                    xVar.u(j0Var);
                }
            }
            q1.f0 f0Var = this.y;
            if ((f0Var == null || f0Var.e == 0) && v0Var.b().isEmpty()) {
                return;
            }
            q1.f0 f0Var2 = this.y;
            Map mapB = v0Var.b();
            if (f0Var2 != null && f0Var2.e == mapB.size()) {
                Object[] objArr = f0Var2.b;
                int[] iArr = f0Var2.c;
                long[] jArr = f0Var2.a;
                int length = jArr.length - 2;
                if (length < 0) {
                    return;
                }
                int i3 = 0;
                loop0: while (true) {
                    long j2 = jArr[i3];
                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i4 = 8 - ((~(i3 - length)) >>> 31);
                        for (int i6 = i; i6 < i4; i6++) {
                            if ((255 & j2) < 128) {
                                int i7 = (i3 << 3) + i6;
                                Object obj = objArr[i7];
                                int i8 = iArr[i7];
                                Integer num = (Integer) mapB.get((q4.a) obj);
                                if (num == null || num.intValue() != i8) {
                                    break loop0;
                                }
                            }
                            j2 >>= 8;
                        }
                        if (i4 != 8) {
                            return;
                        }
                    }
                    if (i3 == length) {
                        return;
                    }
                    i3++;
                    i = 0;
                }
            }
            j0Var.F.p.x.g();
            q1.f0 f0Var3 = this.y;
            if (f0Var3 == null) {
                q1.f0 f0Var4 = q1.s0.a;
                f0Var3 = new q1.f0();
                this.y = f0Var3;
            }
            f0Var3.a();
            for (Map.Entry entry : v0Var.b().entrySet()) {
                f0Var3.h(((Number) entry.getValue()).intValue(), entry.getKey());
            }
        }
    }

    public final long E1(long j2) {
        t4.y1 y1Var = this.I;
        if (y1Var != null) {
            j2 = y1Var.d(j2, false);
        }
        long j3 = this.z;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) + ((int) (j3 >> 32));
        return (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)) + ((int) (j3 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public final z3.c F1() {
        if (g()) {
            q4.b0 b0VarG = q4.y1.g(this);
            z3.a aVar = this.B;
            if (aVar == null) {
                aVar = new z3.a();
                this.B = aVar;
            }
            long jA1 = a1(i1());
            int i = (int) (jA1 >> 32);
            aVar.a = -Float.intBitsToFloat(i);
            int i2 = (int) (jA1 & 4294967295L);
            aVar.b = -Float.intBitsToFloat(i2);
            aVar.c = Float.intBitsToFloat(i) + e0();
            aVar.d = Float.intBitsToFloat(i2) + b0();
            k1 k1Var = this;
            while (k1Var != b0VarG) {
                k1Var.A1(aVar, false, true);
                if (!aVar.b()) {
                    k1Var = k1Var.q;
                    lmjxuqdtp.jvm.internal.o.e(k1Var);
                }
            }
            return new z3.c(aVar.a, aVar.b, aVar.c, aVar.d);
        }
        return z3.c.e;
    }

    public final void G1(k1 k1Var, float[] fArr) {
        float[] fArrA;
        if (lmjxuqdtp.jvm.internal.o.c(k1Var, this)) {
            return;
        }
        k1 k1Var2 = this.q;
        lmjxuqdtp.jvm.internal.o.e(k1Var2);
        k1Var2.G1(k1Var, fArr);
        if (!p5.k.b(this.z, 0L)) {
            float[] fArr2 = M;
            a4.m0.e(fArr2);
            long j2 = this.z;
            a4.m0.i(fArr2, -((int) (j2 >> 32)), -((int) (j2 & 4294967295L)));
            a4.m0.h(fArr, fArr2);
        }
        t4.y1 y1Var = this.I;
        if (y1Var == null || (fArrA = y1Var.a()) == null) {
            return;
        }
        a4.m0.h(fArr, fArrA);
    }

    public final void H1(k1 k1Var, float[] fArr) {
        k1 k1Var2 = this;
        while (!k1Var2.equals(k1Var)) {
            t4.y1 y1Var = k1Var2.I;
            if (y1Var != null) {
                a4.m0.h(fArr, y1Var.b());
            }
            if (!p5.k.b(k1Var2.z, 0L)) {
                float[] fArr2 = M;
                a4.m0.e(fArr2);
                a4.m0.i(fArr2, (int) (r1 >> 32), (int) (r1 & 4294967295L));
                a4.m0.h(fArr, fArr2);
            }
            k1Var2 = k1Var2.q;
            lmjxuqdtp.jvm.internal.o.e(k1Var2);
        }
    }

    public final void I1(boolean z, Function1 function1) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        t4.x xVar;
        k3.e eVar;
        Reference referencePoll;
        if (function1 != null && this.J != null) {
            p4.a.a("layerBlock can't be provided when explicitLayer is provided");
        }
        j0 j0Var = this.o;
        boolean z2 = (!z && this.t == function1 && lmjxuqdtp.jvm.internal.o.c(this.u, j0Var.x) && this.v == j0Var.y) ? false : true;
        this.u = j0Var.x;
        this.v = j0Var.y;
        boolean zI = j0Var.I();
        h1 h1Var = this.G;
        if (zI && function1 != null) {
            this.t = function1;
            if (this.I != null) {
                if (z2 && J1(true)) {
                    j0Var.O();
                    m0.a(j0Var).getRectManager().f(j0Var);
                    return;
                }
                return;
            }
            t4.x xVarA = m0.a(j0Var);
            g1 g1Var = this.F;
            if (g1Var == null) {
                g1 g1Var2 = new g1(0, this, new h1(this, 0));
                this.F = g1Var2;
                g1Var = g1Var2;
            }
            t4.y1 y1VarG = xVarA.g(g1Var, h1Var, (d4.c) null);
            t4.y1 y1Var = y1VarG;
            y1Var.f(((m1) this).c);
            y1Var.e(this.z);
            this.I = y1VarG;
            J1(true);
            j0Var.I = true;
            h1Var.invoke();
            return;
        }
        this.t = null;
        t4.y1 y1Var2 = this.I;
        if (y1Var2 != null) {
            t4.y1 y1Var3 = y1Var2;
            t4.x xVar2 = y1Var3.c;
            if (!w0.n(y1Var3.b())) {
                j0Var.O();
            }
            y1Var3.d = null;
            y1Var3.e = null;
            y1Var3.g = true;
            if (y1Var3.j) {
                y1Var3.j = false;
                xVar2.s(y1Var3, false);
            }
            a4.h0 h0Var = y1Var3.b;
            if (h0Var != null) {
                h0Var.a(y1Var3.a);
                i11.c cVar = xVar2.u0;
                do {
                    ReferenceQueue referenceQueue = (ReferenceQueue) cVar.c;
                    eVar = (k3.e) cVar.b;
                    referencePoll = referenceQueue.poll();
                    if (referencePoll != null) {
                        eVar.n(referencePoll);
                    }
                } while (referencePoll != null);
                eVar.d(new WeakReference(y1Var3, (ReferenceQueue) cVar.c));
                xVar2.x.remove(y1Var3);
            }
            j0Var.I = true;
            h1Var.invoke();
            if (g() && j0Var.J() && (xVar = j0Var.m) != null) {
                xVar.u(j0Var);
            }
        }
        this.I = null;
        this.H = false;
    }

    public final boolean J1(boolean z) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        boolean z2;
        boolean z3;
        t4.x xVar;
        Function0 function0;
        int i;
        Function0 function02;
        if (this.J != null) {
            return false;
        }
        t4.y1 y1Var = this.I;
        if (y1Var == null) {
            if (this.t == null) {
                return false;
            }
            p4.a.b("null layer with a non-null layerBlock");
            return false;
        }
        Function1 function1 = this.t;
        if (function1 == null) {
            throw s1.a.q("updateLayerParameters requires a non-null layerBlock");
        }
        a4.x0 x0Var = K;
        x0Var.i(1.0f);
        x0Var.j(1.0f);
        x0Var.b(1.0f);
        x0Var.u(0.0f);
        x0Var.v(0.0f);
        x0Var.l(0.0f);
        long j2 = a4.i0.a;
        x0Var.c(j2);
        x0Var.n(j2);
        x0Var.f(0.0f);
        x0Var.g(0.0f);
        if (x0Var.l != 8.0f) {
            x0Var.a |= 2048;
            x0Var.l = 8.0f;
        }
        long j3 = a4.f1.b;
        x0Var.r(j3);
        x0Var.m(w0.a);
        x0Var.d(false);
        if (x0Var.t != 3) {
            x0Var.a |= 524288;
            x0Var.t = 3;
        }
        if (x0Var.p != 0) {
            x0Var.a |= 32768;
            x0Var.p = 0;
        }
        x0Var.q = 9205357640488583168L;
        x0Var.u = null;
        x0Var.a = 0;
        j0 j0Var = this.o;
        x0Var.r = j0Var.x;
        x0Var.s = j0Var.y;
        x0Var.q = ln1.e.P(((m1) this).c);
        m0.a(j0Var).getSnapshotObserver().a(this, f.g, new b5.b(17, function1));
        x xVar2 = this.C;
        if (xVar2 == null) {
            xVar2 = new x();
            this.C = xVar2;
        }
        x xVar3 = L;
        xVar3.getClass();
        xVar3.a = xVar2.a;
        xVar3.b = xVar2.b;
        xVar3.c = xVar2.c;
        xVar3.d = xVar2.d;
        xVar3.e = xVar2.e;
        xVar3.f444f = xVar2.f444f;
        xVar3.g = xVar2.g;
        xVar3.h = xVar2.h;
        float f2 = x0Var.b;
        xVar2.a = f2;
        xVar2.b = x0Var.c;
        xVar2.c = x0Var.e;
        xVar2.d = x0Var.f;
        xVar2.e = x0Var.j;
        xVar2.f444f = x0Var.k;
        xVar2.g = x0Var.l;
        long j4 = x0Var.m;
        xVar2.h = j4;
        t4.y1 y1Var2 = y1Var;
        t4.x xVar4 = y1Var2.c;
        int i2 = x0Var.a | y1Var2.n;
        y1Var2.l = x0Var.s;
        y1Var2.k = x0Var.r;
        int i3 = i2 & 4096;
        if (i3 != 0) {
            y1Var2.o = j4;
        }
        if ((i2 & 1) != 0) {
            d4.e eVar = y1Var2.a.a;
            if (eVar.y() != f2) {
                eVar.p(f2);
            }
        }
        if ((i2 & 2) != 0) {
            d4.c cVar = y1Var2.a;
            float f3 = x0Var.c;
            d4.e eVar2 = cVar.a;
            if (eVar2.M() != f3) {
                eVar2.C(f3);
            }
        }
        if ((i2 & 4) != 0) {
            y1Var2.a.f(x0Var.d);
        }
        if ((i2 & 8) != 0) {
            d4.c cVar2 = y1Var2.a;
            float f4 = x0Var.e;
            d4.e eVar3 = cVar2.a;
            if (eVar3.H() != f4) {
                eVar3.K(f4);
            }
        }
        if ((i2 & 16) != 0) {
            d4.c cVar3 = y1Var2.a;
            float f5 = x0Var.f;
            d4.e eVar4 = cVar3.a;
            if (eVar4.G() != f5) {
                eVar4.b(f5);
            }
        }
        if ((i2 & 32) != 0) {
            d4.c cVar4 = y1Var2.a;
            float f7 = x0Var.g;
            d4.e eVar5 = cVar4.a;
            if (eVar5.L() != f7) {
                eVar5.z(f7);
                cVar4.g = true;
                cVar4.a();
            }
            if (x0Var.g > 0.0f && !y1Var2.t && (function02 = y1Var2.e) != null) {
                function02.invoke();
            }
        }
        if ((i2 & 64) != 0) {
            d4.c cVar5 = y1Var2.a;
            long j5 = x0Var.h;
            d4.e eVar6 = cVar5.a;
            if (!a4.y.c(j5, eVar6.k())) {
                eVar6.n(j5);
            }
        }
        if ((i2 & 128) != 0) {
            d4.c cVar6 = y1Var2.a;
            long j6 = x0Var.i;
            d4.e eVar7 = cVar6.a;
            if (!a4.y.c(j6, eVar7.m())) {
                eVar7.t(j6);
            }
        }
        if ((i2 & 1024) != 0) {
            d4.c cVar7 = y1Var2.a;
            float f8 = x0Var.k;
            d4.e eVar8 = cVar7.a;
            if (eVar8.j() != f8) {
                eVar8.A(f8);
            }
        }
        if ((i2 & 256) != 0) {
            d4.c cVar8 = y1Var2.a;
            float f9 = x0Var.j;
            d4.e eVar9 = cVar8.a;
            if (eVar9.I() != f9) {
                eVar9.w(f9);
            }
        }
        if ((i2 & 512) != 0) {
            d4.e eVar10 = y1Var2.a.a;
            if (eVar10.h() != 0.0f) {
                eVar10.l();
            }
        }
        if ((i2 & 2048) != 0) {
            d4.c cVar9 = y1Var2.a;
            float f10 = x0Var.l;
            d4.e eVar11 = cVar9.a;
            if (eVar11.q() != f10) {
                eVar11.v(f10);
            }
        }
        if (i3 != 0) {
            if (a4.f1.a(y1Var2.o, j3)) {
                d4.c cVar10 = y1Var2.a;
                if (!z3.b.d(cVar10.v, 9205357640488583168L)) {
                    cVar10.v = 9205357640488583168L;
                    cVar10.a.E(9205357640488583168L);
                }
            } else {
                d4.c cVar11 = y1Var2.a;
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(a4.f1.c(y1Var2.o) * ((int) (y1Var2.f & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(a4.f1.b(y1Var2.o) * ((int) (y1Var2.f >> 32)))) << 32);
                if (!z3.b.d(cVar11.v, jFloatToRawIntBits)) {
                    cVar11.v = jFloatToRawIntBits;
                    cVar11.a.E(jFloatToRawIntBits);
                }
            }
        }
        if ((i2 & Http2.INITIAL_MAX_FRAME_SIZE) != 0) {
            d4.c cVar12 = y1Var2.a;
            boolean z4 = x0Var.o;
            if (cVar12.w != z4) {
                cVar12.w = z4;
                cVar12.g = true;
                cVar12.a();
            }
        }
        if ((131072 & i2) != 0) {
            d4.e eVar12 = y1Var2.a.a;
        }
        if ((262144 & i2) != 0) {
            d4.e eVar13 = y1Var2.a.a;
            if (!lmjxuqdtp.jvm.internal.o.c(eVar13.g(), (Object) null)) {
                eVar13.o();
            }
        }
        if ((i2 & 524288) != 0) {
            d4.c cVar13 = y1Var2.a;
            int i4 = x0Var.t;
            d4.e eVar14 = cVar13.a;
            if (eVar14.x() != i4) {
                eVar14.c(i4);
            }
        }
        if ((i2 & 32768) != 0) {
            d4.c cVar14 = y1Var2.a;
            int i6 = x0Var.p;
            if (i6 == 0) {
                i = 0;
            } else if (i6 == 1) {
                i = 1;
            } else {
                i = 2;
                if (i6 != 2) {
                    throw new IllegalStateException("Not supported composition strategy");
                }
            }
            d4.e eVar15 = cVar14.a;
            if (eVar15.f() != i) {
                eVar15.J(i);
            }
        }
        if ((i2 & 7963) != 0) {
            y1Var2.q = true;
            y1Var2.r = true;
        }
        if (lmjxuqdtp.jvm.internal.o.c(y1Var2.p, x0Var.u)) {
            z2 = true;
            z3 = false;
        } else {
            o0 o0Var = x0Var.u;
            y1Var2.p = o0Var;
            if (o0Var == null) {
                z2 = true;
            } else {
                d4.c cVar15 = y1Var2.a;
                if (o0Var instanceof o0) {
                    z3.c cVar16 = o0Var.a;
                    float f12 = cVar16.a;
                    float f13 = cVar16.b;
                    cVar15.g(0.0f, (((long) Float.floatToRawIntBits(f12)) << 32) | (((long) Float.floatToRawIntBits(f13)) & 4294967295L), (((long) Float.floatToRawIntBits(cVar16.c - f12)) << 32) | (((long) Float.floatToRawIntBits(cVar16.d - f13)) & 4294967295L));
                } else if (o0Var instanceof a4.n0) {
                    a4.k kVar = ((a4.n0) o0Var).a;
                    cVar15.k = null;
                    cVar15.i = 9205357640488583168L;
                    cVar15.h = 0L;
                    cVar15.j = 0.0f;
                    cVar15.g = true;
                    cVar15.n = false;
                    cVar15.l = kVar;
                    cVar15.a();
                } else {
                    if (!(o0Var instanceof a4.p0)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    a4.p0 p0Var = (a4.p0) o0Var;
                    a4.k kVar2 = p0Var.b;
                    if (kVar2 != null) {
                        cVar15.k = null;
                        cVar15.i = 9205357640488583168L;
                        cVar15.h = 0L;
                        cVar15.j = 0.0f;
                        z2 = true;
                        cVar15.g = true;
                        cVar15.n = false;
                        cVar15.l = kVar2;
                        cVar15.a();
                    } else {
                        z2 = true;
                        z3.d dVar = p0Var.a;
                        cVar15.g(Float.intBitsToFloat((int) (dVar.h >> 32)), (((long) Float.floatToRawIntBits(dVar.a)) << 32) | (((long) Float.floatToRawIntBits(dVar.b)) & 4294967295L), (((long) Float.floatToRawIntBits(dVar.b())) << 32) | (((long) Float.floatToRawIntBits(dVar.a())) & 4294967295L));
                    }
                    if ((o0Var instanceof a4.n0) && Build.VERSION.SDK_INT < 33 && (function0 = y1Var2.e) != null) {
                        function0.invoke();
                    }
                }
                z2 = true;
                if (o0Var instanceof a4.n0) {
                    function0.invoke();
                }
            }
            z3 = z2;
        }
        y1Var2.n = x0Var.a;
        if (i2 != 0 || z3) {
            ViewParent parent = xVar4.getParent();
            if (parent != null) {
                parent.onDescendantInvalidated(xVar4, xVar4);
            }
            if (xVar4.f) {
                xVar4.H(0.0f);
            }
        }
        boolean z5 = this.s;
        this.s = x0Var.o;
        this.w = x0Var.d;
        boolean z6 = (xVar3.a == xVar2.a && xVar3.b == xVar2.b && xVar3.c == xVar2.c && xVar3.d == xVar2.d && xVar3.e == xVar2.e && xVar3.f444f == xVar2.f444f && xVar3.g == xVar2.g && a4.f1.a(xVar3.h, xVar2.h)) ? z2 : false;
        boolean z7 = !z6;
        if (z && ((!z6 || z5 != this.s) && (xVar = j0Var.m) != null)) {
            xVar.u(j0Var);
        }
        return z7;
    }

    public final void K(float[] fArr) {
        t4.x xVarA = m0.a(this.o);
        k1 k1VarD1 = D1(q4.y1.g(this));
        H1(k1VarD1, fArr);
        if (xVarA instanceof m4.g) {
            ((m4.g) xVarA).o(fArr);
            return;
        }
        long jS = k1VarD1.S(0L);
        if ((9223372034707292159L & jS) != 9205357640488583168L) {
            a4.m0.i(fArr, Float.intBitsToFloat((int) (jS >> 32)), Float.intBitsToFloat((int) (jS & 4294967295L)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean K1(long r24) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.k1.K1(long):boolean");
    }

    @Override // s4.s0
    public final s0 M0() {
        return this.p;
    }

    @Override // s4.s0
    public final q4.b0 N0() {
        return this;
    }

    @Override // s4.s0
    public final boolean O0() {
        return this.x != null;
    }

    @Override // s4.s0
    public final j0 Q0() {
        return this.o;
    }

    @Override // s4.s0
    public final v0 R0() {
        v0 v0Var = this.x;
        if (v0Var != null) {
            return v0Var;
        }
        throw new IllegalStateException("Asking for measurement result of unmeasured layout modifier");
    }

    public final long S(long j2) {
        if (!g()) {
            p4.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return m0.a(this.o).p(Y(j2));
    }

    @Override // s4.s0
    public final s0 S0() {
        return this.q;
    }

    @Override // s4.s0
    public final long T0() {
        return this.z;
    }

    public final q4.b0 V() {
        if (!g()) {
            p4.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        t1();
        return ((k1) this.o.E.e).q;
    }

    @Override // s4.s0
    public final void X0() {
        d4.c cVar = this.J;
        if (cVar != null) {
            j0(this.z, this.A, cVar);
        } else {
            k0(this.z, this.A, this.t);
        }
    }

    public final long Y(long j2) {
        if (!g()) {
            p4.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        t1();
        for (k1 k1Var = this; k1Var != null; k1Var = k1Var.q) {
            j2 = k1Var.E1(j2);
        }
        return j2;
    }

    public final void Y0(k1 k1Var, z3.a aVar, boolean z) {
        if (k1Var == this) {
            return;
        }
        k1 k1Var2 = this.q;
        if (k1Var2 != null) {
            k1Var2.Y0(k1Var, aVar, z);
        }
        long j2 = this.z;
        float f2 = (int) (j2 >> 32);
        aVar.a -= f2;
        aVar.c -= f2;
        float f3 = (int) (j2 & 4294967295L);
        aVar.b -= f3;
        aVar.d -= f3;
        t4.y1 y1Var = this.I;
        if (y1Var != null) {
            y1Var.c(aVar, true);
            if (this.s && z) {
                long j3 = ((m1) this).c;
                aVar.a(0.0f, 0.0f, (int) (j3 >> 32), (int) (j3 & 4294967295L));
            }
        }
    }

    public final long Z0(k1 k1Var, long j2) {
        if (k1Var == this) {
            return j2;
        }
        k1 k1Var2 = this.q;
        return (k1Var2 == null || lmjxuqdtp.jvm.internal.o.c(k1Var, k1Var2)) ? g1(j2) : g1(k1Var2.Z0(k1Var, j2));
    }

    public final long a() {
        return ((m1) this).c;
    }

    public final long a1(long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) - e0();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L)) - b0();
        float fMax = Math.max(0.0f, fIntBitsToFloat / 2.0f);
        return (((long) Float.floatToRawIntBits(Math.max(0.0f, fIntBitsToFloat2 / 2.0f))) & 4294967295L) | (Float.floatToRawIntBits(fMax) << 32);
    }

    public final float b1(long j2, long j3) {
        if (e0() >= Float.intBitsToFloat((int) (j3 >> 32)) && b0() >= Float.intBitsToFloat((int) (j3 & 4294967295L))) {
            return Float.POSITIVE_INFINITY;
        }
        long jA1 = a1(j3);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jA1 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jA1 & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j2 >> 32));
        float fMax = Math.max(0.0f, fIntBitsToFloat3 < 0.0f ? -fIntBitsToFloat3 : fIntBitsToFloat3 - e0());
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j2 & 4294967295L));
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Math.max(0.0f, fIntBitsToFloat4 < 0.0f ? -fIntBitsToFloat4 : fIntBitsToFloat4 - b0()))) & 4294967295L) | (((long) Float.floatToRawIntBits(fMax)) << 32);
        if ((fIntBitsToFloat > 0.0f || fIntBitsToFloat2 > 0.0f) && Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) <= fIntBitsToFloat && Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) <= fIntBitsToFloat2) {
            return z3.b.f(jFloatToRawIntBits);
        }
        return Float.POSITIVE_INFINITY;
    }

    public final void c1(a4.w wVar, d4.c cVar) throws NoWhenBranchMatchedException {
        t4.y1 y1Var = this.I;
        if (y1Var == null) {
            long j2 = this.z;
            float f2 = (int) (j2 >> 32);
            float f3 = (int) (j2 & 4294967295L);
            wVar.j(f2, f3);
            d1(wVar, cVar);
            wVar.j(-f2, -f3);
            return;
        }
        t4.y1 y1Var2 = y1Var;
        c4.b bVar = y1Var2.m;
        y1Var2.g();
        y1Var2.t = y1Var2.a.a.L() > 0.0f;
        tlydtdl.compose.foundation.lazy.layout.r1 r1Var = bVar.b;
        r1Var.u(wVar);
        r1Var.b = cVar;
        ln1.e.q(bVar, y1Var2.a);
    }

    public final q4.b0 d() {
        if (!g()) {
            p4.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        t1();
        return this.q;
    }

    @Override // s4.t1
    public final boolean d0() {
        return (this.I == null || this.r || !this.o.I()) ? false : true;
    }

    public final void d1(a4.w wVar, d4.c cVar) {
        a4.w wVar2;
        d4.c cVar2;
        t3.o oVarK1 = k1(4);
        if (oVarK1 == null) {
            y1(wVar, cVar);
            return;
        }
        j0 j0Var = this.o;
        j0Var.getClass();
        l0 sharedDrawScope = m0.a(j0Var).getSharedDrawScope();
        long jP = ln1.e.P(((m1) this).c);
        sharedDrawScope.getClass();
        k3.e eVar = null;
        while (oVarK1 != null) {
            if (oVarK1 instanceof q) {
                wVar2 = wVar;
                cVar2 = cVar;
                sharedDrawScope.c(wVar2, jP, this, (q) oVarK1, cVar2);
            } else {
                wVar2 = wVar;
                cVar2 = cVar;
                if ((oVarK1.getKindSet$ui_release() & 4) != 0 && (oVarK1 instanceof o)) {
                    int i = 0;
                    for (t3.o child$ui_release = ((o) oVarK1).b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                        if ((child$ui_release.getKindSet$ui_release() & 4) != 0) {
                            i++;
                            if (i == 1) {
                                oVarK1 = child$ui_release;
                            } else {
                                if (eVar == null) {
                                    eVar = new k3.e(0, new t3.o[16]);
                                }
                                if (oVarK1 != null) {
                                    eVar.d(oVarK1);
                                    oVarK1 = null;
                                }
                                eVar.d(child$ui_release);
                            }
                        }
                    }
                    if (i == 1) {
                    }
                }
                wVar = wVar2;
                cVar = cVar2;
            }
            oVarK1 = g.e(eVar);
            wVar = wVar2;
            cVar = cVar2;
        }
    }

    public final float e() {
        return this.o.x.e();
    }

    public abstract void e1();

    public final k1 f1(k1 k1Var) {
        j0 j0VarV = k1Var.o;
        j0 j0Var = this.o;
        if (j0VarV == j0Var) {
            t3.o oVarJ1 = k1Var.j1();
            t3.o oVarJ12 = j1();
            if (!oVarJ12.getNode().isAttached()) {
                p4.a.b("visitLocalAncestors called on an unattached node");
            }
            for (t3.o parent$ui_release = oVarJ12.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                if ((parent$ui_release.getKindSet$ui_release() & 2) != 0 && parent$ui_release == oVarJ1) {
                    return k1Var;
                }
            }
            return this;
        }
        while (j0VarV.o > j0Var.o) {
            j0VarV = j0VarV.v();
            lmjxuqdtp.jvm.internal.o.e(j0VarV);
        }
        j0 j0VarV2 = j0Var;
        while (j0VarV2.o > j0VarV.o) {
            j0VarV2 = j0VarV2.v();
            lmjxuqdtp.jvm.internal.o.e(j0VarV2);
        }
        while (j0VarV != j0VarV2) {
            j0VarV = j0VarV.v();
            j0VarV2 = j0VarV2.v();
            if (j0VarV == null || j0VarV2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        if (j0VarV2 != j0Var) {
            if (j0VarV != k1Var.o) {
                return (v) j0VarV.E.d;
            }
            return k1Var;
        }
        return this;
    }

    public final boolean g() {
        return j1().isAttached();
    }

    public final long g1(long j2) {
        long j3 = this.z;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)) - ((int) (j3 & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 >> 32)) - ((int) (j3 >> 32)))) << 32);
        t4.y1 y1Var = this.I;
        return y1Var != null ? y1Var.d(jFloatToRawIntBits, true) : jFloatToRawIntBits;
    }

    public final p5.n getLayoutDirection() {
        return this.o.y;
    }

    public abstract t0 h1();

    public final long i(long j2) {
        if (!g()) {
            p4.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        q4.b0 b0VarG = q4.y1.g(this);
        t4.x xVarA = m0.a(this.o);
        xVarA.y();
        return s1(b0VarG, z3.b.i(a4.m0.b(j2, xVarA.T), b0VarG.Y(0L)));
    }

    public final long i1() {
        return this.u.J0(this.o.z.f());
    }

    public abstract void j0(long j2, float f2, d4.c cVar);

    public abstract t3.o j1();

    public final t3.o k1(int i) {
        boolean zH = l1.h(i);
        t3.o oVarJ1 = j1();
        if (!zH && (oVarJ1 = oVarJ1.getParent$ui_release()) == null) {
            return null;
        }
        for (t3.o oVarL1 = l1(zH); oVarL1 != null && (oVarL1.getAggregateChildKindSet$ui_release() & i) != 0; oVarL1 = oVarL1.getChild$ui_release()) {
            if ((oVarL1.getKindSet$ui_release() & i) != 0) {
                return oVarL1;
            }
            if (oVarL1 == oVarJ1) {
                return null;
            }
        }
        return null;
    }

    public final Object l() {
        j0 j0Var = this.o;
        if (!j0Var.E.p(64)) {
            return null;
        }
        j1();
        Object objC = null;
        for (t3.o parent$ui_release = (d2) j0Var.E.f89f; parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if ((parent$ui_release.getKindSet$ui_release() & 64) != 0) {
                t3.o oVarE = parent$ui_release;
                k3.e eVar = null;
                while (oVarE != null) {
                    if (oVarE instanceof v1) {
                        objC = ((v1) oVarE).c(j0Var.x, objC);
                    } else if ((oVarE.getKindSet$ui_release() & 64) != 0 && (oVarE instanceof o)) {
                        int i = 0;
                        for (t3.o child$ui_release = ((o) oVarE).b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                            if ((child$ui_release.getKindSet$ui_release() & 64) != 0) {
                                i++;
                                if (i == 1) {
                                    oVarE = child$ui_release;
                                } else {
                                    if (eVar == null) {
                                        eVar = new k3.e(0, new t3.o[16]);
                                    }
                                    if (oVarE != null) {
                                        eVar.d(oVarE);
                                        oVarE = null;
                                    }
                                    eVar.d(child$ui_release);
                                }
                            }
                        }
                        if (i == 1) {
                        }
                    }
                    oVarE = g.e(eVar);
                }
            }
        }
        return objC;
    }

    public final t3.o l1(boolean z) {
        t3.o oVarJ1;
        dl.c cVar = this.o.E;
        if (((k1) cVar.e) == this) {
            return (t3.o) cVar.g;
        }
        if (!z) {
            k1 k1Var = this.q;
            if (k1Var != null) {
                return k1Var.j1();
            }
            return null;
        }
        k1 k1Var2 = this.q;
        if (k1Var2 == null || (oVarJ1 = k1Var2.j1()) == null) {
            return null;
        }
        return oVarJ1.getChild$ui_release();
    }

    public final void m1(t3.o oVar, e eVar, long j2, t tVar, int i, boolean z) {
        if (oVar == null) {
            p1(eVar, j2, tVar, i, z);
            return;
        }
        int i2 = tVar.c;
        q1.j0 j0Var = tVar.a;
        tVar.d(i2 + 1, j0Var.b);
        tVar.c++;
        j0Var.a(oVar);
        tVar.b.a(g.a(-1.0f, z, false));
        m1(g.d(oVar, eVar.a()), eVar, j2, tVar, i, z);
        tVar.c = i2;
    }

    public final long n(q4.b0 b0Var, long j2) {
        return s1(b0Var, j2);
    }

    public final void n1(t3.o oVar, e eVar, long j2, t tVar, int i, boolean z, float f2) {
        if (oVar == null) {
            p1(eVar, j2, tVar, i, z);
            return;
        }
        int i2 = tVar.c;
        q1.j0 j0Var = tVar.a;
        tVar.d(i2 + 1, j0Var.b);
        tVar.c++;
        j0Var.a(oVar);
        tVar.b.a(g.a(f2, z, false));
        x1(g.d(oVar, eVar.a()), eVar, j2, tVar, i, z, f2, true);
        tVar.c = i2;
    }

    public final void o1(e eVar, long j2, t tVar, int i, boolean z) {
        boolean z2;
        boolean z3;
        t3.o oVarK1 = k1(eVar.a());
        if (!K1(j2)) {
            if (i == 1) {
                float fB1 = b1(j2, i1());
                if ((Float.floatToRawIntBits(fB1) & IntCompanionObject.MAX_VALUE) < 2139095040) {
                    if (tVar.c != ct1.b.z(tVar)) {
                        if (g.g(tVar.b(), g.a(fB1, false, false)) <= 0) {
                            return;
                        }
                    }
                    n1(oVarK1, eVar, j2, tVar, i, false, fB1);
                    return;
                }
                return;
            }
            return;
        }
        if (oVarK1 == null) {
            p1(eVar, j2, tVar, i, z);
            return;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L));
        if (fIntBitsToFloat >= 0.0f && fIntBitsToFloat2 >= 0.0f && fIntBitsToFloat < e0() && fIntBitsToFloat2 < b0()) {
            m1(oVarK1, eVar, j2, tVar, i, z);
            return;
        }
        float fB12 = i == 1 ? b1(j2, i1()) : Float.POSITIVE_INFINITY;
        if ((Float.floatToRawIntBits(fB12) & IntCompanionObject.MAX_VALUE) < 2139095040) {
            if (tVar.c != ct1.b.z(tVar)) {
                z2 = z;
                if (g.g(tVar.b(), g.a(fB12, z2, false)) > 0) {
                }
                x1(oVarK1, eVar, j2, tVar, i, z2, fB12, z3);
            }
            z2 = z;
            z3 = true;
            x1(oVarK1, eVar, j2, tVar, i, z2, fB12, z3);
        }
        z2 = z;
        z3 = false;
        x1(oVarK1, eVar, j2, tVar, i, z2, fB12, z3);
    }

    public void p1(e eVar, long j2, t tVar, int i, boolean z) {
        k1 k1Var = this.p;
        if (k1Var != null) {
            k1Var.o1(eVar, k1Var.g1(j2), tVar, i, z);
        }
    }

    public final void q1() {
        s1 s1Var = this.I;
        if (s1Var != null) {
            s1Var.invalidate();
            return;
        }
        k1 k1Var = this.q;
        if (k1Var != null) {
            k1Var.q1();
        }
    }

    public final boolean r1() {
        if (this.I != null && this.w <= 0.0f) {
            return true;
        }
        k1 k1Var = this.q;
        if (k1Var != null) {
            return k1Var.r1();
        }
        return false;
    }

    public final long s1(q4.b0 b0Var, long j2) {
        if (b0Var instanceof q4.r0) {
            q4.r0 r0Var = (q4.r0) b0Var;
            r0Var.a.o.t1();
            return r0Var.c(this, j2 ^ (-9223372034707292160L)) ^ (-9223372034707292160L);
        }
        k1 k1VarD1 = D1(b0Var);
        k1VarD1.t1();
        k1 k1VarF1 = f1(k1VarD1);
        while (k1VarD1 != k1VarF1) {
            j2 = k1VarD1.E1(j2);
            k1VarD1 = k1VarD1.q;
            lmjxuqdtp.jvm.internal.o.e(k1VarD1);
        }
        return Z0(k1VarF1, j2);
    }

    public final void t1() {
        this.o.F.b();
    }

    public final float u0() {
        return this.o.x.u0();
    }

    public final void u1() {
        t3.o parent$ui_release;
        boolean zH = l1.h(128);
        t3.o oVarL1 = l1(zH);
        if (oVarL1 == null || (oVarL1.getNode().getAggregateChildKindSet$ui_release() & 128) == 0) {
            return;
        }
        s3.f fVarO = rs1.g.o();
        Function1 function1E = fVarO != null ? fVarO.e() : null;
        s3.f fVarP = rs1.g.p(fVarO);
        try {
            if (!zH) {
                parent$ui_release = j1().getParent$ui_release();
                if (parent$ui_release == null) {
                }
            }
            parent$ui_release = j1();
            for (t3.o oVarL12 = l1(zH); oVarL12 != null; oVarL12 = oVarL12.getChild$ui_release()) {
                if ((oVarL12.getAggregateChildKindSet$ui_release() & 128) == 0) {
                    break;
                }
                if ((oVarL12.getKindSet$ui_release() & 128) != 0) {
                    t3.o oVarE = oVarL12;
                    k3.e eVar = null;
                    while (oVarE != null) {
                        if (oVarE instanceof y) {
                            ((y) oVarE).m(((m1) this).c);
                        } else if ((oVarE.getKindSet$ui_release() & 128) != 0 && (oVarE instanceof o)) {
                            int i = 0;
                            for (t3.o child$ui_release = ((o) oVarE).b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                                if ((child$ui_release.getKindSet$ui_release() & 128) != 0) {
                                    i++;
                                    if (i == 1) {
                                        oVarE = child$ui_release;
                                    } else {
                                        if (eVar == null) {
                                            eVar = new k3.e(0, new t3.o[16]);
                                        }
                                        if (oVarE != null) {
                                            eVar.d(oVarE);
                                            oVarE = null;
                                        }
                                        eVar.d(child$ui_release);
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        oVarE = g.e(eVar);
                    }
                }
                if (oVarL12 == parent$ui_release) {
                    break;
                }
            }
        } finally {
            rs1.g.s(fVarO, fVarP, function1E);
        }
    }

    public final long v(long j2) {
        if (!g()) {
            p4.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return s1(q4.y1.g(this), m0.a(this.o).C(j2));
    }

    public final void v1() {
        boolean zH = l1.h(128);
        t3.o oVarJ1 = j1();
        if (!zH && (oVarJ1 = oVarJ1.getParent$ui_release()) == null) {
            return;
        }
        for (t3.o oVarL1 = l1(zH); oVarL1 != null && (oVarL1.getAggregateChildKindSet$ui_release() & 128) != 0; oVarL1 = oVarL1.getChild$ui_release()) {
            if ((oVarL1.getKindSet$ui_release() & 128) != 0) {
                t3.o oVarE = oVarL1;
                k3.e eVar = null;
                while (oVarE != null) {
                    if (oVarE instanceof y) {
                        ((y) oVarE).R(this);
                    } else if ((oVarE.getKindSet$ui_release() & 128) != 0 && (oVarE instanceof o)) {
                        int i = 0;
                        for (t3.o child$ui_release = ((o) oVarE).b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                            if ((child$ui_release.getKindSet$ui_release() & 128) != 0) {
                                i++;
                                if (i == 1) {
                                    oVarE = child$ui_release;
                                } else {
                                    if (eVar == null) {
                                        eVar = new k3.e(0, new t3.o[16]);
                                    }
                                    if (oVarE != null) {
                                        eVar.d(oVarE);
                                        oVarE = null;
                                    }
                                    eVar.d(child$ui_release);
                                }
                            }
                        }
                        if (i == 1) {
                        }
                    }
                    oVarE = g.e(eVar);
                }
            }
            if (oVarL1 == oVarJ1) {
                return;
            }
        }
    }

    public final void w(q4.b0 b0Var, float[] fArr) {
        k1 k1VarD1 = D1(b0Var);
        k1VarD1.t1();
        k1 k1VarF1 = f1(k1VarD1);
        a4.m0.e(fArr);
        k1VarD1.H1(k1VarF1, fArr);
        G1(k1VarF1, fArr);
    }

    public final void w1() throws NoWhenBranchMatchedException, KotlinNothingValueException {
        this.r = true;
        this.G.invoke();
        B1();
        if (p5.k.b(this.z, 0L)) {
            return;
        }
        this.o.O();
    }

    /* JADX WARN: Removed duplicated region for block: B:203:0x0170 A[PHI: r1
  0x0170: PHI (r1v6 k3.e) = (r1v1 k3.e), (r1v1 k3.e), (r1v8 k3.e) binds: [B:185:0x0138, B:187:0x013c, B:201:0x016a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void x1(t3.o r17, s4.e r18, long r19, s4.t r21, int r22, boolean r23, float r24, boolean r25) {
        /*
            Method dump skipped, instruction units count: 712
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.k1.x1(t3.o, s4.e, long, s4.t, int, boolean, float, boolean):void");
    }

    public abstract void y1(a4.w wVar, d4.c cVar);

    public final void z1(long j2, float f2, Function1 function1, d4.c cVar) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        j0 j0Var = this.o;
        if (cVar != null) {
            if (function1 != null) {
                p4.a.a("both ways to create layers shouldn't be used together");
            }
            if (this.J != cVar) {
                this.J = null;
                I1(false, null);
                this.J = cVar;
            }
            if (this.I == null) {
                t4.x xVarA = m0.a(j0Var);
                g1 g1Var = this.F;
                if (g1Var == null) {
                    g1 g1Var2 = new g1(0, this, new h1(this, 0));
                    this.F = g1Var2;
                    g1Var = g1Var2;
                }
                h1 h1Var = this.G;
                t4.y1 y1VarG = xVarA.g(g1Var, h1Var, cVar);
                t4.y1 y1Var = y1VarG;
                y1Var.f(((m1) this).c);
                y1Var.e(j2);
                this.I = y1VarG;
                j0Var.I = true;
                h1Var.invoke();
            }
        } else {
            if (this.J != null) {
                this.J = null;
                I1(false, null);
            }
            I1(false, function1);
        }
        if (!p5.k.b(this.z, j2)) {
            m0.a(j0Var).H(-4.0f);
            this.z = j2;
            j0Var.F.p.I0();
            t4.y1 y1Var2 = this.I;
            if (y1Var2 != null) {
                y1Var2.e(j2);
            } else {
                k1 k1Var = this.q;
                if (k1Var != null) {
                    k1Var.q1();
                }
            }
            j0Var.O();
            s0.V0(this);
            t4.x xVar = j0Var.m;
            if (xVar != null) {
                xVar.u(j0Var);
            }
        }
        this.A = f2;
        if (!this.k) {
            I0(R0());
        }
        if (this == ((k1) j0Var.E.e)) {
            m0.a(j0Var).getRectManager().g(j0Var, !j0Var.F.p.k);
        }
    }
}
