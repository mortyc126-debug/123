package w8;

import amuvvoafs.util.Pair;
import bb.z0;
import java.util.ArrayList;
import x8.g;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 {
    public final g c;
    public final o8.b0 d;
    public final z0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f646f;
    public int g;
    public boolean h;
    public q i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public u0 f647j;
    public u0 k;
    public u0 l;
    public u0 m;
    public u0 n;
    public int o;
    public Object p;
    public long q;
    public final l8.h1 a = new l8.h1();
    public final l8.j1 b = new l8.j1();
    public ArrayList r = new ArrayList();

    public w0(g gVar, o8.b0 b0Var, z0 z0Var, q qVar) {
        this.c = gVar;
        this.d = b0Var;
        this.e = z0Var;
        this.i = qVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static f9.b0 r(l8.k1 r14, java.lang.Object r15, long r16, long r18, l8.j1 r20, l8.h1 r21) {
        /*
            r0 = r16
            r2 = r20
            r4 = r21
            r14.g(r15, r4)
            int r5 = r4.c
            r14.n(r5, r2)
            int r5 = r14.b(r15)
            r7 = r15
        L13:
            l8.b r3 = r4.g
            int r3 = r3.a
            r6 = -1
            if (r3 == 0) goto L6d
            r8 = 1
            r9 = 0
            if (r3 != r8) goto L24
            boolean r10 = r4.g(r9)
            if (r10 != 0) goto L6d
        L24:
            l8.b r10 = r4.g
            int r10 = r10.d
            boolean r10 = r4.h(r10)
            if (r10 == 0) goto L6d
            r10 = 0
            int r12 = r4.c(r10)
            if (r12 == r6) goto L37
            goto L6d
        L37:
            long r12 = r4.d
            int r12 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r12 != 0) goto L3e
            goto L5e
        L3e:
            int r12 = r3 + (-1)
            boolean r12 = r4.g(r12)
            if (r12 == 0) goto L48
            r12 = 2
            goto L49
        L48:
            r12 = r8
        L49:
            int r3 = r3 - r12
        L4a:
            if (r9 > r3) goto L58
            l8.b r12 = r4.g
            l8.a r12 = r12.a(r9)
            long r12 = r12.i
            long r10 = r10 + r12
            int r9 = r9 + 1
            goto L4a
        L58:
            long r12 = r4.d
            int r3 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r3 > 0) goto L6d
        L5e:
            int r3 = r2.o
            if (r5 > r3) goto L6d
            r14.f(r5, r4, r8)
            java.lang.Object r7 = r4.b
            r7.getClass()
            int r5 = r5 + 1
            goto L13
        L6d:
            r14.g(r7, r4)
            int r8 = r4.c(r0)
            if (r8 != r6) goto L82
            int r14 = r4.b(r0)
            f9.b0 r0 = new f9.b0
            r10 = r18
            r0.<init>(r7, r10, r14)
            return r0
        L82:
            r10 = r18
            int r9 = r4.f(r8)
            f9.b0 r6 = new f9.b0
            r12 = -1
            r6.<init>(r7, r8, r9, r10, r12)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.w0.r(l8.k1, java.lang.Object, long, long, l8.j1, l8.h1):f9.b0");
    }

    public final u0 a() {
        u0 u0Var = this.f647j;
        if (u0Var == null) {
            return null;
        }
        if (u0Var == this.k) {
            this.k = u0Var.h();
        }
        u0 u0Var2 = this.f647j;
        if (u0Var2 == this.l) {
            this.l = u0Var2.h();
        }
        this.f647j.t();
        int i = this.o - 1;
        this.o = i;
        if (i == 0) {
            this.m = null;
            u0 u0Var3 = this.f647j;
            this.p = u0Var3.b;
            this.q = u0Var3.h.a.d;
        }
        this.f647j = this.f647j.h();
        n();
        return this.f647j;
    }

    public final void b() {
        if (this.o == 0) {
            return;
        }
        u0 u0VarH = this.f647j;
        o8.b.i(u0VarH);
        this.p = u0VarH.b;
        this.q = u0VarH.h.a.d;
        while (u0VarH != null) {
            u0VarH.t();
            u0VarH = u0VarH.h();
        }
        this.f647j = null;
        this.m = null;
        this.k = null;
        this.l = null;
        this.o = 0;
        n();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final w8.v0 c(l8.k1 r19, w8.u0 r20, long r21) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.w0.c(l8.k1, w8.u0, long):w8.v0");
    }

    public final v0 d(l8.k1 k1Var, u0 u0Var, long j2) {
        l8.h1 h1Var;
        l8.k1 k1Var2;
        v0 v0Var = u0Var.h;
        long j3 = (u0Var.j() + v0Var.e) - j2;
        if (v0Var.h) {
            return c(k1Var, u0Var, j3);
        }
        v0 v0Var2 = u0Var.h;
        f9.b0 b0Var = v0Var2.a;
        Object obj = b0Var.a;
        int i = b0Var.e;
        l8.h1 h1Var2 = this.a;
        k1Var.g(obj, h1Var2);
        boolean z = v0Var2.g;
        if (!b0Var.b()) {
            if (i != -1 && h1Var2.g(i)) {
                return c(k1Var, u0Var, j3);
            }
            int iF = h1Var2.f(i);
            boolean z2 = h1Var2.h(i) && h1Var2.e(i, iF) == 3;
            if (iF != h1Var2.g.a(i).b && !z2) {
                return f(k1Var, b0Var.a, b0Var.e, iF, v0Var2.e, b0Var.d, z);
            }
            k1Var.g(obj, h1Var2);
            long jD = h1Var2.d(i);
            return g(k1Var, b0Var.a, jD == Long.MIN_VALUE ? h1Var2.d : h1Var2.g.a(i).i + jD, v0Var2.e, b0Var.d, false);
        }
        int i2 = b0Var.b;
        int i3 = h1Var2.g.a(i2).b;
        if (i3 == -1) {
            return null;
        }
        int iA = h1Var2.g.a(i2).a(b0Var.c);
        if (iA < i3) {
            return f(k1Var, b0Var.a, i2, iA, v0Var2.c, b0Var.d, z);
        }
        long jLongValue = v0Var2.c;
        if (jLongValue == -9223372036854775807L) {
            Pair pairJ = k1Var.j(this.b, h1Var2, h1Var2.c, -9223372036854775807L, Math.max(0L, j3));
            h1Var = h1Var2;
            k1Var2 = k1Var;
            if (pairJ == null) {
                return null;
            }
            jLongValue = ((Long) pairJ.second).longValue();
        } else {
            h1Var = h1Var2;
            k1Var2 = k1Var;
        }
        int i4 = b0Var.b;
        k1Var2.g(obj, h1Var);
        long jD2 = h1Var.d(i4);
        return g(k1Var, b0Var.a, Math.max(jD2 == Long.MIN_VALUE ? h1Var.d : h1Var.g.a(i4).i + jD2, jLongValue), v0Var2.c, b0Var.d, z);
    }

    public final v0 e(l8.k1 k1Var, f9.b0 b0Var, long j2, long j3) {
        k1Var.g(b0Var.a, this.a);
        return b0Var.b() ? f(k1Var, b0Var.a, b0Var.b, b0Var.c, j2, b0Var.d, false) : g(k1Var, b0Var.a, j3, j2, b0Var.d, false);
    }

    public final v0 f(l8.k1 k1Var, Object obj, int i, int i2, long j2, long j3, boolean z) {
        f9.b0 b0Var = new f9.b0(obj, i, i2, j3, -1);
        l8.h1 h1Var = this.a;
        long jA = k1Var.g(obj, h1Var).a(i, i2);
        long jMax = i2 == h1Var.f(i) ? h1Var.g.b : 0L;
        boolean zH = h1Var.h(i);
        if (jA != -9223372036854775807L && jMax >= jA) {
            jMax = Math.max(0L, jA - 1);
        }
        return new v0(b0Var, jMax, j2, -9223372036854775807L, jA, z, zH, false, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final w8.v0 g(l8.k1 r28, java.lang.Object r29, long r30, long r32, long r34, boolean r36) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.w0.g(l8.k1, java.lang.Object, long, long, long, boolean):w8.v0");
    }

    public final u0 h() {
        return this.l;
    }

    public final v0 i(l8.k1 k1Var, v0 v0Var) {
        f9.b0 b0Var = v0Var.a;
        boolean zB = b0Var.b();
        int i = b0Var.e;
        boolean zH = false;
        boolean z = !zB && i == -1;
        int i2 = b0Var.b;
        boolean zL = l(k1Var, b0Var);
        boolean zK = k(k1Var, b0Var, z);
        Object obj = b0Var.a;
        l8.h1 h1Var = this.a;
        k1Var.g(obj, h1Var);
        long jD = (b0Var.b() || i == -1) ? -9223372036854775807L : h1Var.d(i);
        long jA = b0Var.b() ? h1Var.a(i2, b0Var.c) : (jD == -9223372036854775807L || jD == Long.MIN_VALUE) ? h1Var.d : jD;
        if (b0Var.b()) {
            zH = h1Var.h(i2);
        } else if (i != -1 && h1Var.h(i)) {
            zH = true;
        }
        return new v0(b0Var, v0Var.b, v0Var.c, jD, jA, v0Var.f, zH, z, zL, zK);
    }

    public final void j(l8.k1 k1Var) {
        u0 u0Var;
        v0 v0VarG;
        w0 w0Var = this;
        if (w0Var.i.a == -9223372036854775807L || (u0Var = w0Var.m) == null) {
            if (w0Var.r.isEmpty()) {
                return;
            }
            w0Var.o(new ArrayList());
            return;
        }
        ArrayList arrayList = new ArrayList();
        Object obj = u0Var.h.a.a;
        l8.h1 h1Var = w0Var.a;
        int iE = k1Var.e(k1Var.g(obj, h1Var).c, w0Var.g, w0Var.h);
        Pair pairJ = iE != -1 ? k1Var.j(w0Var.b, w0Var.a, iE, -9223372036854775807L, 0L) : null;
        if (pairJ != null && !k1Var.m(k1Var.g(pairJ.first, h1Var).c, w0Var.b, 0L).a()) {
            long jT = w0Var.t(pairJ.first);
            if (jT == -1) {
                jT = w0Var.f646f;
                w0Var.f646f = 1 + jT;
            }
            long j2 = jT;
            Object obj2 = pairJ.first;
            long jLongValue = ((Long) pairJ.second).longValue();
            f9.b0 b0VarR = r(k1Var, obj2, jLongValue, j2, w0Var.b, w0Var.a);
            if (b0VarR.b()) {
                v0VarG = w0Var.f(k1Var, b0VarR.a, b0VarR.b, b0VarR.c, jLongValue, b0VarR.d, false);
                w0Var = this;
            } else {
                w0Var = this;
                v0VarG = w0Var.g(k1Var, b0VarR.a, jLongValue, -9223372036854775807L, b0VarR.d, false);
            }
            u0 u0VarQ = w0Var.q(v0VarG);
            if (u0VarQ == null) {
                long j3 = (u0Var.j() + u0Var.h.e) - v0VarG.b;
                k0 k0Var = (k0) w0Var.e.b;
                u0VarQ = new u0(k0Var.b, j3, k0Var.d, k0Var.f642f.a, k0Var.s, v0VarG, k0Var.e, k0Var.W.a);
            }
            arrayList.add(u0VarQ);
        }
        w0Var.o(arrayList);
    }

    public final boolean k(l8.k1 k1Var, f9.b0 b0Var, boolean z) {
        int iB = k1Var.b(b0Var.a);
        if (!k1Var.m(k1Var.f(iB, this.a, false).c, this.b, 0L).i) {
            if (k1Var.d(iB, this.a, this.b, this.g, this.h) == -1 && z) {
                return true;
            }
        }
        return false;
    }

    public final boolean l(l8.k1 k1Var, f9.b0 b0Var) {
        boolean z = !b0Var.b() && b0Var.e == -1;
        Object obj = b0Var.a;
        if (z) {
            if (k1Var.m(k1Var.g(obj, this.a).c, this.b, 0L).o == k1Var.b(obj)) {
                return true;
            }
        }
        return false;
    }

    public final void m() {
        u0 u0Var = this.n;
        if (u0Var == null || u0Var.q()) {
            this.n = null;
            for (int i = 0; i < this.r.size(); i++) {
                u0 u0Var2 = (u0) this.r.get(i);
                if (!u0Var2.q()) {
                    this.n = u0Var2;
                    return;
                }
            }
        }
    }

    public final void n() {
        com.gnacba.common.collect.g0 g0VarN = com.gnacba.common.collect.k0.n();
        for (u0 u0VarH = this.f647j; u0VarH != null; u0VarH = u0VarH.h()) {
            g0VarN.a(u0VarH.h.a);
        }
        u0 u0Var = this.k;
        this.d.d(new jo.f(this, g0VarN, u0Var == null ? null : u0Var.h.a, 15));
    }

    public final void o(ArrayList arrayList) {
        for (int i = 0; i < this.r.size(); i++) {
            ((u0) this.r.get(i)).t();
        }
        this.r = arrayList;
        this.n = null;
        m();
    }

    public final int p(u0 u0Var) {
        o8.b.i(u0Var);
        int i = 0;
        if (u0Var.equals(this.m)) {
            return 0;
        }
        this.m = u0Var;
        while (u0Var.h() != null) {
            u0Var = u0Var.h();
            u0Var.getClass();
            if (u0Var == this.k) {
                u0 u0Var2 = this.f647j;
                this.k = u0Var2;
                this.l = u0Var2;
                i = 3;
            }
            if (u0Var == this.l) {
                this.l = this.k;
                i |= 2;
            }
            u0Var.t();
            this.o--;
        }
        u0 u0Var3 = this.m;
        u0Var3.getClass();
        u0Var3.v((u0) null);
        n();
        return i;
    }

    public final u0 q(v0 v0Var) {
        for (int i = 0; i < this.r.size(); i++) {
            if (((u0) this.r.get(i)).c(v0Var)) {
                return (u0) this.r.remove(i);
            }
        }
        return null;
    }

    public final f9.b0 s(l8.k1 k1Var, Object obj, long j2) {
        long jT;
        int iB;
        Object obj2 = obj;
        l8.h1 h1Var = this.a;
        int i = k1Var.g(obj2, h1Var).c;
        Object obj3 = this.p;
        if (obj3 == null || (iB = k1Var.b(obj3)) == -1 || k1Var.f(iB, h1Var, false).c != i) {
            u0 u0VarH = this.f647j;
            while (true) {
                if (u0VarH == null) {
                    u0 u0VarH2 = this.f647j;
                    while (true) {
                        if (u0VarH2 != null) {
                            int iB2 = k1Var.b(u0VarH2.b);
                            if (iB2 != -1 && k1Var.f(iB2, h1Var, false).c == i) {
                                jT = u0VarH2.h.a.d;
                                break;
                            }
                            u0VarH2 = u0VarH2.h();
                        } else {
                            jT = t(obj2);
                            if (jT == -1) {
                                jT = this.f646f;
                                this.f646f = 1 + jT;
                                if (this.f647j == null) {
                                    this.p = obj2;
                                    this.q = jT;
                                }
                            }
                        }
                    }
                } else {
                    if (u0VarH.b.equals(obj2)) {
                        jT = u0VarH.h.a.d;
                        break;
                    }
                    u0VarH = u0VarH.h();
                }
            }
        } else {
            jT = this.q;
        }
        k1Var.g(obj2, h1Var);
        int i2 = h1Var.c;
        l8.j1 j1Var = this.b;
        k1Var.n(i2, j1Var);
        boolean z = false;
        for (int iB3 = k1Var.b(obj); iB3 >= j1Var.n; iB3--) {
            k1Var.f(iB3, h1Var, true);
            boolean z2 = h1Var.g.a > 0;
            z |= z2;
            if (h1Var.c(h1Var.d) != -1) {
                obj2 = h1Var.b;
                obj2.getClass();
            }
            if (z && (!z2 || h1Var.d != 0)) {
                break;
            }
        }
        return r(k1Var, obj2, j2, jT, this.b, this.a);
    }

    public final long t(Object obj) {
        for (int i = 0; i < this.r.size(); i++) {
            u0 u0Var = (u0) this.r.get(i);
            if (u0Var.b.equals(obj)) {
                return u0Var.h.a.d;
            }
        }
        return -1L;
    }

    public final int u(l8.k1 k1Var) {
        l8.k1 k1Var2;
        u0 u0VarH = this.f647j;
        if (u0VarH == null) {
            return 0;
        }
        int iB = k1Var.b(u0VarH.b);
        while (true) {
            k1Var2 = k1Var;
            iB = k1Var2.d(iB, this.a, this.b, this.g, this.h);
            while (true) {
                u0VarH.getClass();
                if (u0VarH.h() == null || u0VarH.h.h) {
                    break;
                }
                u0VarH = u0VarH.h();
            }
            u0 u0VarH2 = u0VarH.h();
            if (iB == -1 || u0VarH2 == null || k1Var2.b(u0VarH2.b) != iB) {
                break;
            }
            u0VarH = u0VarH2;
            k1Var = k1Var2;
        }
        int iP = p(u0VarH);
        u0VarH.h = i(k1Var2, u0VarH.h);
        return iP;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0093, code lost:
    
        return p(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int v(l8.k1 r14, long r15, long r17, long r19) {
        /*
            r13 = this;
            w8.u0 r0 = r13.f647j
            r1 = 0
        L3:
            r2 = 0
            if (r0 == 0) goto L94
            w8.v0 r3 = r0.h
            if (r1 != 0) goto L10
            w8.v0 r1 = r13.i(r14, r3)
            r4 = r15
            goto L2a
        L10:
            r4 = r15
            w8.v0 r6 = r13.d(r14, r1, r4)
            if (r6 == 0) goto L8f
            long r7 = r3.b
            long r9 = r6.b
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L8f
            f9.b0 r7 = r3.a
            f9.b0 r8 = r6.a
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L8f
            r1 = r6
        L2a:
            long r6 = r1.e
            long r8 = r3.c
            w8.v0 r1 = r1.a(r8)
            r0.h = r1
            long r8 = r3.e
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 == 0) goto L86
            int r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r1 != 0) goto L44
            goto L86
        L44:
            r0.z()
            int r14 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r14 != 0) goto L51
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L55
        L51:
            long r3 = r0.y(r6)
        L55:
            w8.u0 r14 = r13.k
            r1 = 1
            r5 = -9223372036854775808
            if (r0 != r14) goto L6c
            w8.v0 r14 = r0.h
            boolean r14 = r14.g
            if (r14 != 0) goto L6c
            int r14 = (r17 > r5 ? 1 : (r17 == r5 ? 0 : -1))
            if (r14 == 0) goto L6a
            int r14 = (r17 > r3 ? 1 : (r17 == r3 ? 0 : -1))
            if (r14 < 0) goto L6c
        L6a:
            r14 = r1
            goto L6d
        L6c:
            r14 = r2
        L6d:
            w8.u0 r7 = r13.l
            if (r0 != r7) goto L7a
            int r5 = (r19 > r5 ? 1 : (r19 == r5 ? 0 : -1))
            if (r5 == 0) goto L79
            int r3 = (r19 > r3 ? 1 : (r19 == r3 ? 0 : -1))
            if (r3 < 0) goto L7a
        L79:
            r2 = r1
        L7a:
            int r0 = r13.p(r0)
            if (r0 == 0) goto L81
            return r0
        L81:
            if (r2 == 0) goto L85
            r14 = r14 | 2
        L85:
            return r14
        L86:
            w8.u0 r1 = r0.h()
            r12 = r1
            r1 = r0
            r0 = r12
            goto L3
        L8f:
            int r14 = r13.p(r1)
            return r14
        L94:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.w0.v(l8.k1, long, long, long):int");
    }
}
