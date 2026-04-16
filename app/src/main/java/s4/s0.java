package s4;

import com.gnacba.amuvvoafs.gms.internal.ads.ui1;
import java.util.Map;
import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.jvm.functions.Function1;
import q1.o0;
import q4.m1;
import q4.s;
import q4.v0;
import q4.w0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s0 extends m1 implements d1, w0 {

    /* JADX INFO: renamed from: f */
    public p0 f441f;
    public Function1 g;
    public w1 h;
    public boolean i;

    /* JADX INFO: renamed from: j */
    public boolean f442j;
    public boolean k;
    public final q4.q0 l = new q4.q0(0, this);
    public ui1 m;
    public q1.n0 n;

    public static void V0(k1 k1Var) {
        k0 k0Var;
        k1 k1Var2 = k1Var.p;
        j0 j0Var = k1Var.o;
        if (!lmjxuqdtp.jvm.internal.o.c(k1Var2 != null ? k1Var2.o : null, j0Var)) {
            j0Var.F.p.x.g();
            return;
        }
        b bVarF = j0Var.F.p.f();
        if (bVarF == null || (k0Var = ((b1) bVarF).x) == null) {
            return;
        }
        k0Var.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B0(s4.j0 r32, q4.s r33) {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.s0.B0(s4.j0, q4.s):void");
    }

    public final v0 C0(int i, int i2, Map map, Function1 function1, Function1 function12) {
        if ((i & (-16777216)) != 0 || ((-16777216) & i2) != 0) {
            p4.a.b("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new r0(i, i2, map, function1, function12, this);
    }

    public abstract int D0(q4.a aVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final void G0(w1 w1Var, long j2, long j3) {
        boolean z;
        char c;
        long j4;
        long j5;
        long j6;
        j0 j0Var;
        boolean z2;
        int i;
        char c2;
        long j7;
        u1 snapshotObserver;
        q1.n0 n0Var = this.n;
        ui1 ui1Var = this.m;
        if (ui1Var == null) {
            ui1Var = new ui1();
            this.m = ui1Var;
        }
        ui1 ui1Var2 = ui1Var;
        t4.x xVar = Q0().m;
        if (xVar != null && (snapshotObserver = xVar.getSnapshotObserver()) != null) {
            snapshotObserver.a(w1Var, f.e, new q0(this, j2, j3, w1Var));
        }
        boolean zJ = J();
        o0 o0Var = (o0) ui1Var2.e;
        o0 o0Var2 = (o0) ui1Var2.f;
        int i2 = ui1Var2.a;
        for (int i3 = 0; i3 < i2; i3++) {
            byte b = ((byte[]) ui1Var2.d)[i3];
            if (b == 3) {
                s sVar = ((s[]) ui1Var2.b)[i3];
                lmjxuqdtp.jvm.internal.o.e(sVar);
                o0Var2.j(sVar);
            } else if (b != 0 && n0Var != null) {
                s sVar2 = ((s[]) ui1Var2.b)[i3];
                lmjxuqdtp.jvm.internal.o.e(sVar2);
                o0 o0Var3 = (o0) n0Var.k(sVar2);
                if (o0Var3 != null) {
                    o0Var.k(o0Var3);
                }
            }
        }
        int i4 = ui1Var2.a;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            byte[] bArr = (byte[]) ui1Var2.d;
            if (bArr[i7] == 2) {
                i6++;
            } else if (i6 > 0) {
                s[] sVarArr = (s[]) ui1Var2.b;
                sVarArr[i7 - i6] = sVarArr[i7];
            }
            bArr[i7] = 2;
        }
        int i8 = ui1Var2.a;
        for (int i9 = i8 - i6; i9 < i8; i9++) {
            ((s[]) ui1Var2.b)[i9] = null;
        }
        ui1Var2.a -= i6;
        s0 s0VarS0 = S0();
        Object[] objArr = o0Var2.b;
        long[] jArr = o0Var2.a;
        int length = jArr.length - 2;
        char c3 = 7;
        long j8 = -9187201950435737472L;
        int i10 = 8;
        if (length >= 0) {
            j5 = 128;
            int i11 = 0;
            while (true) {
                long j9 = jArr[i11];
                j6 = 255;
                if ((((~j9) << c3) & j9 & j8) != j8) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j9 & 255) < 128) {
                            c2 = c3;
                            s sVar3 = (s) objArr[(i11 << 3) + i13];
                            j7 = j8;
                            s0 s0Var = s0VarS0 == null ? this : s0VarS0;
                            i = i10;
                            s0 s0Var2 = s0Var;
                            while (true) {
                                ui1 ui1Var3 = s0Var2.m;
                                if (ui1Var3 != null) {
                                    z2 = zJ;
                                    if (!mx1.n.N(sVar3, (s[]) ui1Var3.b)) {
                                        break;
                                        break;
                                    }
                                    break;
                                }
                                z2 = zJ;
                                s0 s0VarS02 = s0Var2.S0();
                                if (s0VarS02 == null) {
                                    break;
                                }
                                s0Var2 = s0VarS02;
                                zJ = z2;
                            }
                            q1.n0 n0Var2 = s0Var2.n;
                            o0 o0Var4 = n0Var2 != null ? (o0) n0Var2.k(sVar3) : null;
                            if (o0Var4 != null) {
                                s0Var.W0(o0Var4);
                            }
                        } else {
                            z2 = zJ;
                            i = i10;
                            c2 = c3;
                            j7 = j8;
                        }
                        j9 >>= i;
                        i13++;
                        c3 = c2;
                        j8 = j7;
                        i10 = i;
                        zJ = z2;
                    }
                    z = zJ;
                    c = c3;
                    j4 = j8;
                    if (i12 != i10) {
                        break;
                    }
                } else {
                    z = zJ;
                    c = c3;
                    j4 = j8;
                }
                if (i11 == length) {
                    break;
                }
                i11++;
                c3 = c;
                j8 = j4;
                zJ = z;
                i10 = 8;
            }
        } else {
            z = zJ;
            c = 7;
            j4 = -9187201950435737472L;
            j5 = 128;
            j6 = 255;
        }
        o0Var2.b();
        Object[] objArr2 = o0Var.b;
        long[] jArr2 = o0Var.a;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            int i14 = 0;
            while (true) {
                long j10 = jArr2[i14];
                if ((((~j10) << c) & j10 & j4) != j4) {
                    int i15 = 8 - ((~(i14 - length2)) >>> 31);
                    for (int i16 = 0; i16 < i15; i16++) {
                        if ((j10 & j6) < j5 && (j0Var = (j0) ((h2) objArr2[(i14 << 3) + i16]).get()) != null) {
                            if (z) {
                                j0Var.V(false);
                            } else {
                                j0Var.X(false);
                            }
                        }
                        j10 >>= 8;
                    }
                    if (i15 != 8) {
                        break;
                    }
                }
                if (i14 == length2) {
                    break;
                } else {
                    i14++;
                }
            }
        }
        o0Var.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void I0(q4.v0 r15) {
        /*
            r14 = this;
            q1.n0 r0 = r14.n
            boolean r1 = r14.k
            if (r1 == 0) goto L9
        L6:
            r1 = r14
            goto Lbe
        L9:
            lmjxuqdtp.jvm.functions.Function1 r1 = r15.d()
            r2 = 0
            if (r1 != 0) goto L5a
            if (r0 == 0) goto L6
            java.lang.Object[] r15 = r0.c
            long[] r1 = r0.a
            int r3 = r1.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L56
            r4 = r2
        L1c:
            r5 = r1[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L51
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r2
        L36:
            if (r9 >= r7) goto L4f
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L4b
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r15[r10]
            q1.o0 r10 = (q1.o0) r10
            r14.W0(r10)
        L4b:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L36
        L4f:
            if (r7 != r8) goto L56
        L51:
            if (r4 == r3) goto L56
            int r4 = r4 + 1
            goto L1c
        L56:
            r0.a()
            return
        L5a:
            lmjxuqdtp.jvm.functions.Function1 r0 = r14.g
            r3 = 1
            if (r0 == r1) goto L61
            r0 = r3
            goto L62
        L61:
            r0 = r2
        L62:
            r4 = 0
            if (r0 != 0) goto L9b
            s4.p0 r1 = r14.U0()
            boolean r1 = r1.a
            if (r1 == 0) goto L9b
            q4.b0 r0 = r14.N0()
            long r4 = r0.S(r4)
            long r4 = hs1.d.I(r4)
            long r0 = r0.a()
            s4.p0 r6 = r14.U0()
            long r6 = r6.b
            boolean r6 = p5.k.b(r4, r6)
            if (r6 == 0) goto L96
            s4.p0 r6 = r14.U0()
            long r6 = r6.c
            boolean r6 = p5.m.a(r0, r6)
            if (r6 != 0) goto L97
        L96:
            r2 = r3
        L97:
            r3 = r4
            r5 = r0
            r0 = r2
            goto La2
        L9b:
            r1 = 9223372034707292159(0x7fffffff7fffffff, double:NaN)
            r5 = r4
            r3 = r1
        La2:
            if (r0 == 0) goto L6
            s4.w1 r0 = r14.h
            if (r0 == 0) goto Lad
            r0.a = r15
        Laa:
            r1 = r14
            r2 = r0
            goto Lb5
        Lad:
            s4.w1 r0 = new s4.w1
            r0.<init>(r15, r14)
            r14.h = r0
            goto Laa
        Lb5:
            r1.G0(r2, r3, r5)
            lmjxuqdtp.jvm.functions.Function1 r15 = r15.d()
            r1.g = r15
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.s0.I0(q4.v0):void");
    }

    public boolean J() {
        return false;
    }

    public final int K0(q4.a aVar) {
        int iD0;
        if (O0() && (iD0 = D0(aVar)) != Integer.MIN_VALUE) {
            return iD0 + ((int) (aVar instanceof q4.g2 ? ((m1) this).e >> 32 : ((m1) this).e & 4294967295L));
        }
        return IntCompanionObject.MIN_VALUE;
    }

    public abstract s0 M0();

    public abstract q4.b0 N0();

    public abstract boolean O0();

    public abstract j0 Q0();

    public abstract v0 R0();

    public abstract s0 S0();

    public abstract long T0();

    public final p0 U0() {
        p0 p0Var = this.f441f;
        if (p0Var != null) {
            return p0Var;
        }
        p0 p0Var2 = new p0(this);
        this.f441f = p0Var2;
        return p0Var2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W0(o0 o0Var) {
        j0 j0Var;
        Object[] objArr = o0Var.b;
        long[] jArr = o0Var.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j2 = jArr[i];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j2) < 128 && (j0Var = (j0) ((h2) objArr[(i << 3) + i3]).get()) != null) {
                        if (J()) {
                            j0Var.V(false);
                        } else {
                            j0Var.X(false);
                        }
                    }
                    j2 >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public abstract void X0();

    @Override // s4.d1
    public final void m(boolean z) {
        s0 s0VarS0 = S0();
        j0 j0VarQ0 = s0VarS0 != null ? s0VarS0.Q0() : null;
        if (lmjxuqdtp.jvm.internal.o.c(j0VarQ0, Q0())) {
            this.i = z;
            return;
        }
        if ((j0VarQ0 != null ? j0VarQ0.F.d : null) != f0.c) {
            if ((j0VarQ0 != null ? j0VarQ0.F.d : null) != f0.d) {
                return;
            }
        }
        this.i = z;
    }
}
