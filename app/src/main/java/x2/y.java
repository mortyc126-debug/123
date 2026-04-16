package x2;

import a2.k3;
import a3.d0;
import amuvvoafs.view.ActionMode;
import c2.o;
import com.gnacba.amuvvoafs.gms.internal.measurement.o4;
import d5.m0;
import d5.p0;
import f3.f2;
import g3.e;
import i4.a;
import java.util.concurrent.CancellationException;
import ky1.c0;
import ky1.t1;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.internal.b0;
import m2.a1;
import m2.k;
import m2.u;
import m2.y1;
import p5.c;
import p5.n;
import t4.m1;
import t4.u0;
import t4.w2;
import tlydtdl.compose.runtime.h0;
import tlydtdl.compose.runtime.n1;
import v2.i;
import v2.p;
import w2.c1;
import w2.y0;
import z3.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class y {
    public final o4 A;
    public final c1 a;
    public final y0 b;
    public c c;
    public boolean d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f682f;
    public final s2.g g;
    public final ky1.a0 h;
    public final a3.r i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m1 f683j;
    public a k;
    public u l;
    public Function0 n;
    public Function0 o;
    public final n1 t;
    public final n1 u;
    public final n1 v;
    public a3.c1 w;
    public int x;
    public o y;
    public final h0 z;
    public final n1 m = tlydtdl.compose.runtime.a0.t(Boolean.TRUE);
    public final n1 p = tlydtdl.compose.runtime.a0.t(new b(9205357640488583168L));
    public final n1 q = tlydtdl.compose.runtime.a0.t(new b(9205357640488583168L));
    public final n1 r = tlydtdl.compose.runtime.a0.t(null);
    public final n1 s = tlydtdl.compose.runtime.a0.t(j.a);

    public y(c1 c1Var, y0 y0Var, c cVar, boolean z, boolean z2, boolean z3, s2.g gVar, ky1.a0 a0Var, a3.r rVar, m1 m1Var) {
        this.a = c1Var;
        this.b = y0Var;
        this.c = cVar;
        this.d = z;
        this.e = z2;
        this.f682f = z3;
        this.g = gVar;
        this.h = a0Var;
        this.i = rVar;
        this.f683j = m1Var;
        Boolean bool = Boolean.FALSE;
        this.t = tlydtdl.compose.runtime.a0.t(bool);
        this.u = tlydtdl.compose.runtime.a0.t(a0.a);
        this.v = tlydtdl.compose.runtime.a0.t(bool);
        this.x = -1;
        this.z = tlydtdl.compose.runtime.a0.q(new k(this, 3));
        this.A = new o4(this.f683j);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(x2.y r9, m4.w r10, sx1.c r11) throws java.lang.Throwable {
        /*
            r9.getClass()
            boolean r0 = r11 instanceof x2.o
            if (r0 == 0) goto L17
            r0 = r11
            x2.o r0 = (x2.o) r0
            int r1 = r0.n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L17
            int r1 = r1 - r2
            r0.n = r1
        L15:
            r6 = r0
            goto L1d
        L17:
            x2.o r0 = new x2.o
            r0.<init>(r9, r11)
            goto L15
        L1d:
            java.lang.Object r11 = r6.l
            rx1.a r0 = rx1.a.a
            int r1 = r6.n
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            lmjxuqdtp.jvm.internal.b0 r10 = r6.k
            lmjxuqdtp.jvm.internal.b0 r1 = r6.j
            lg.e.O(r11)     // Catch: java.lang.Throwable -> L30
            goto L7c
        L30:
            r0 = move-exception
            r11 = r0
            goto L87
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3b:
            lg.e.O(r11)
            lmjxuqdtp.jvm.internal.b0 r11 = new lmjxuqdtp.jvm.internal.b0
            r11.<init>()
            r3 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            r11.a = r3
            lmjxuqdtp.jvm.internal.b0 r7 = new lmjxuqdtp.jvm.internal.b0
            r7.<init>()
            r7.a = r3
            r1 = r2
            v00.d r2 = new v00.d     // Catch: java.lang.Throwable -> L82
            r3 = 9
            r2.<init>(r11, r9, r7, r3)     // Catch: java.lang.Throwable -> L82
            x2.i r3 = new x2.i     // Catch: java.lang.Throwable -> L82
            r4 = 2
            r3.<init>(r11, r7, r9, r4)     // Catch: java.lang.Throwable -> L82
            x2.i r4 = new x2.i     // Catch: java.lang.Throwable -> L82
            r5 = 3
            r4.<init>(r11, r7, r9, r5)     // Catch: java.lang.Throwable -> L82
            v50.o r5 = new v50.o     // Catch: java.lang.Throwable -> L82
            r8 = 19
            r5.<init>(r7, r9, r11, r8)     // Catch: java.lang.Throwable -> L82
            r6.j = r11     // Catch: java.lang.Throwable -> L82
            r6.k = r7     // Catch: java.lang.Throwable -> L82
            r6.n = r1     // Catch: java.lang.Throwable -> L82
            r1 = r10
            java.lang.Object r10 = a2.y0.h(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L82
            if (r10 != r0) goto L7a
            return r0
        L7a:
            r1 = r11
            r10 = r7
        L7c:
            k(r1, r10, r9)
            lx1.b0 r9 = lx1.b0.a
            return r9
        L82:
            r0 = move-exception
            r10 = r0
            r1 = r11
            r11 = r10
            r10 = r7
        L87:
            k(r1, r10, r9)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.y.a(x2.y, m4.w, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(x2.y r14, m4.w r15, boolean r16, sx1.c r17) throws java.lang.Throwable {
        /*
            r0 = r17
            boolean r1 = r0 instanceof x2.p
            if (r1 == 0) goto L16
            r1 = r0
            x2.p r1 = (x2.p) r1
            int r2 = r1.o
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r2 & r3
            if (r5 == 0) goto L16
            int r2 = r2 - r3
            r1.o = r2
        L14:
            r7 = r1
            goto L1c
        L16:
            x2.p r1 = new x2.p
            r1.<init>(r14, r0)
            goto L14
        L1c:
            java.lang.Object r0 = r7.m
            rx1.a r8 = rx1.a.a
            int r1 = r7.o
            r6 = 1
            if (r1 == 0) goto L3d
            if (r1 != r6) goto L35
            m2.a1 r1 = r7.l
            lmjxuqdtp.jvm.internal.b0 r2 = r7.k
            lmjxuqdtp.jvm.internal.b0 r3 = r7.j
            lg.e.O(r0)     // Catch: java.lang.Throwable -> L32
            goto L97
        L32:
            r0 = move-exception
            goto Lb1
        L35:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3d:
            lg.e.O(r0)
            lmjxuqdtp.jvm.internal.b0 r1 = new lmjxuqdtp.jvm.internal.b0
            r1.<init>()
            r2 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            r1.a = r2
            lmjxuqdtp.jvm.internal.b0 r2 = new lmjxuqdtp.jvm.internal.b0
            r2.<init>()
            r9 = 0
            r2.a = r9
            if (r16 == 0) goto L5b
            m2.a1 r0 = m2.a1.b
        L59:
            r3 = r0
            goto L5e
        L5b:
            m2.a1 r0 = m2.a1.c
            goto L59
        L5e:
            fb.d r0 = new fb.d     // Catch: java.lang.Throwable -> Lac
            r4 = r14
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lac
            r9 = r0
            x2.i r10 = new x2.i     // Catch: java.lang.Throwable -> Lac
            r0 = 0
            r10.<init>(r1, r14, r2, r0)     // Catch: java.lang.Throwable -> Lac
            x2.i r11 = new x2.i     // Catch: java.lang.Throwable -> Lac
            r0 = 1
            r11.<init>(r1, r14, r2, r0)     // Catch: java.lang.Throwable -> Lac
            b71.c r0 = new b71.c     // Catch: java.lang.Throwable -> Lac
            r4 = r2
            r2 = r1
            r1 = r4
            r4 = r14
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> La7
            r12 = r1
            r13 = r2
            r1 = r3
            r7.j = r13     // Catch: java.lang.Throwable -> La3
            r7.k = r12     // Catch: java.lang.Throwable -> La3
            r7.l = r1     // Catch: java.lang.Throwable -> La3
            r7.o = r6     // Catch: java.lang.Throwable -> La3
            r2 = r15
            r6 = r0
            r3 = r9
            r4 = r10
            r5 = r11
            java.lang.Object r0 = a2.y0.h(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> La3
            if (r0 != r8) goto L95
            return r8
        L95:
            r2 = r12
            r3 = r13
        L97:
            m2.a1 r0 = r14.p()
            if (r0 != r1) goto La0
            l(r3, r2, r14)
        La0:
            lx1.b0 r0 = lx1.b0.a
            return r0
        La3:
            r0 = move-exception
        La4:
            r2 = r12
        La5:
            r3 = r13
            goto Lb1
        La7:
            r0 = move-exception
            r12 = r1
            r13 = r2
            r1 = r3
            goto La4
        Lac:
            r0 = move-exception
            r13 = r1
            r12 = r2
            r1 = r3
            goto La5
        Lb1:
            m2.a1 r4 = r14.p()
            if (r4 != r1) goto Lba
            l(r3, r2, r14)
        Lba:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.y.b(x2.y, m4.w, boolean, sx1.c):java.lang.Object");
    }

    public static final void k(b0 b0Var, b0 b0Var2, y yVar) {
        if ((b0Var.a & 9223372034707292159L) != 9205357640488583168L) {
            b0Var.a = 9205357640488583168L;
            b0Var2.a = 9205357640488583168L;
            yVar.h();
        }
    }

    public static final void l(b0 b0Var, b0 b0Var2, y yVar) {
        if ((b0Var.a & 9223372034707292159L) != 9205357640488583168L) {
            yVar.h();
            b0Var.a = 9205357640488583168L;
            b0Var2.a = 0L;
            yVar.x = -1;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void A() throws NoWhenBranchMatchedException {
        c1 c1Var = this.a;
        p pVar = c1Var.a;
        v2.c cVar = c1Var.b;
        y2.c cVar2 = y2.c.a;
        pVar.b.a().f();
        v2.h hVar = pVar.b;
        x10.a.J(hVar, 0, hVar.c.length());
        p.a(pVar, cVar, true, cVar2);
    }

    public final void B(boolean z) {
        this.t.setValue(Boolean.valueOf(z));
    }

    public final void C(a0 a0Var) {
        this.u.setValue(a0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object D(sx1.c r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof x2.w
            if (r0 == 0) goto L13
            r0 = r8
            x2.w r0 = (x2.w) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            x2.w r0 = new x2.w
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f680j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            tlydtdl.compose.runtime.n1 r3 = r7.u
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L34
            if (r2 != r5) goto L2c
            lg.e.O(r8)     // Catch: java.lang.Throwable -> L2a
            goto L48
        L2a:
            r8 = move-exception
            goto L5d
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L34:
            lg.e.O(r8)
            qi.k r8 = new qi.k     // Catch: java.lang.Throwable -> L2a
            r2 = 0
            r6 = 20
            r8.<init>(r7, r2, r6)     // Catch: java.lang.Throwable -> L2a
            r0.l = r5     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r8 = ky1.c0.o(r8, r0)     // Catch: java.lang.Throwable -> L2a
            if (r8 != r1) goto L48
            return r1
        L48:
            ky1.f1 r8 = (ky1.f1) r8     // Catch: java.lang.Throwable -> L2a
            r7.B(r4)
            java.lang.Object r8 = r3.getValue()
            x2.a0 r8 = (x2.a0) r8
            x2.a0 r0 = x2.a0.a
            if (r8 == r0) goto L5a
            r7.v()
        L5a:
            lx1.b0 r8 = lx1.b0.a
            return r8
        L5d:
            r7.B(r4)
            java.lang.Object r0 = r3.getValue()
            x2.a0 r0 = (x2.a0) r0
            x2.a0 r1 = x2.a0.a
            if (r0 == r1) goto L6d
            r7.v()
        L6d:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.y.D(sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final lx1.b0 E() {
        /*
            r3 = this;
            com.gnacba.amuvvoafs.gms.internal.measurement.o4 r0 = r3.A
            java.lang.Object r1 = r0.c
            t4.m1 r1 = (t4.m1) r1
            t4.h r1 = (t4.h) r1
            t4.i r2 = r1.a
            amuvvoafs.content.ClipboardManager r2 = r2.a
            boolean r2 = r2.hasPrimaryClip()
            if (r2 == 0) goto L26
            t4.i r1 = r1.a
            amuvvoafs.content.ClipboardManager r1 = r1.a
            amuvvoafs.content.ClipDescription r1 = r1.getPrimaryClipDescription()
            if (r1 == 0) goto L26
            java.lang.String r2 = "text/*"
            boolean r1 = r1.hasMimeType(r2)
            r2 = 1
            if (r1 != r2) goto L26
            goto L27
        L26:
            r2 = 0
        L27:
            r0.b = r2
            rx1.a r0 = rx1.a.a
            lx1.b0 r0 = lx1.b0.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.y.E():lx1.b0");
    }

    public final void F(a1 a1Var, long j2) {
        this.r.setValue(a1Var);
        this.q.setValue(new b(j2));
    }

    public final long G(i iVar, int i, int i2, boolean z, a0.p pVar, boolean z2, boolean z3) {
        long jH;
        a aVar;
        long j2 = iVar.d;
        p0 p0Var = new p0(j2);
        if (z3 || (!z2 && p0.d(j2))) {
            p0Var = null;
        }
        m0 m0VarB = this.b.b();
        boolean z4 = false;
        if (m0VarB == null) {
            jH = p0.b;
        } else if (p0Var == null && pVar.equals(d0.e)) {
            jH = uc0.p.h(i, i2);
        } else {
            a3.c1 c1VarD = k4.c.D(m0VarB, i, i2, this.x, p0Var != null ? p0Var.a : p0.b, p0Var == null, z);
            if (p0Var == null || c1VarD.p(this.w)) {
                long jD = pVar.c(c1VarD).d();
                this.w = c1VarD;
                this.x = z ? i : i2;
                jH = jD;
            } else {
                jH = p0Var.a;
            }
        }
        if (!p0.c(jH, j2)) {
            if (p0.h(jH) != p0.h(j2) && p0.c(uc0.p.h((int) (4294967295L & jH), (int) (jH >> 32)), j2)) {
                z4 = true;
            }
            if (((Boolean) this.m.getValue()).booleanValue() && !z4 && (aVar = this.k) != null) {
                aVar.a(9);
            }
        }
        return jH;
    }

    public final boolean c() {
        return q() && p0.d(this.a.f().d);
    }

    public final boolean d() {
        return !p0.d(this.a.f().d);
    }

    public final boolean e() {
        return !p0.d(this.a.f().d) && q();
    }

    public final boolean f() {
        if (q()) {
            if (this.A.b) {
                return true;
            }
            Function0 function0 = this.o;
            if (function0 != null) {
                f2.y(function0.invoke());
            }
        }
        return false;
    }

    public final boolean g() {
        c1 c1Var = this.a;
        return p0.e(c1Var.f().d) != c1Var.f().c.length();
    }

    public final void h() {
        this.r.setValue(null);
        this.q.setValue(new b(9205357640488583168L));
        this.p.setValue(new b(9205357640488583168L));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(boolean r11, sx1.c r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof x2.m
            if (r0 == 0) goto L13
            r0 = r12
            x2.m r0 = (x2.m) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            x2.m r0 = new x2.m
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            w2.c1 r3 = r10.a
            r4 = 1
            lx1.b0 r5 = lx1.b0.a
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            boolean r11 = r0.j
            lg.e.O(r12)
            goto L70
        L2d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L35:
            lg.e.O(r12)
            v2.i r12 = r3.f()
            long r6 = r12.d
            long r8 = r12.d
            boolean r2 = d5.p0.d(r6)
            if (r2 == 0) goto L47
            goto L72
        L47:
            d5.g r2 = new d5.g
            int r6 = d5.p0.g(r8)
            int r7 = d5.p0.f(r8)
            java.lang.CharSequence r12 = r12.c
            java.lang.CharSequence r12 = r12.subSequence(r6, r7)
            java.lang.String r12 = r12.toString()
            r2.<init>(r12)
            t4.m1 r12 = r10.f683j
            t4.k1 r2 = d2.b.c(r2)
            r0.j = r11
            r0.m = r4
            t4.h r12 = (t4.h) r12
            r12.a(r2)
            if (r5 != r1) goto L70
            return r1
        L70:
            if (r11 != 0) goto L73
        L72:
            return r5
        L73:
            r3.a()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.y.i(boolean, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(sx1.c r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof x2.n
            if (r0 == 0) goto L13
            r0 = r11
            x2.n r0 = (x2.n) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            x2.n r0 = new x2.n
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            w2.c1 r3 = r10.a
            r4 = 1
            lx1.b0 r5 = lx1.b0.a
            if (r2 == 0) goto L33
            if (r2 != r4) goto L2b
            lg.e.O(r11)
            goto L6c
        L2b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L33:
            lg.e.O(r11)
            v2.i r11 = r3.f()
            long r6 = r11.d
            long r8 = r11.d
            boolean r2 = d5.p0.d(r6)
            if (r2 == 0) goto L45
            return r5
        L45:
            d5.g r2 = new d5.g
            int r6 = d5.p0.g(r8)
            int r7 = d5.p0.f(r8)
            java.lang.CharSequence r11 = r11.c
            java.lang.CharSequence r11 = r11.subSequence(r6, r7)
            java.lang.String r11 = r11.toString()
            r2.<init>(r11)
            t4.m1 r11 = r10.f683j
            t4.k1 r2 = d2.b.c(r2)
            r0.l = r4
            t4.h r11 = (t4.h) r11
            r11.a(r2)
            if (r5 != r1) goto L6c
            return r1
        L6c:
            r3.c()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.y.j(sx1.c):java.lang.Object");
    }

    public final Object m(m4.w wVar, sx1.i iVar) {
        Object objQ = wVar.Q(new e(this, (qx1.d) null, 2), iVar);
        return objQ == rx1.a.a ? objQ : lx1.b0.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final x2.d n(boolean r9) {
        /*
            r8 = this;
            w2.c1 r0 = r8.a
            v2.i r0 = r0.f()
            tlydtdl.compose.runtime.n1 r1 = r8.t
            java.lang.Object r1 = r1.getValue()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            tlydtdl.compose.runtime.n1 r2 = r8.s
            java.lang.Object r2 = r2.getValue()
            x2.j r2 = (x2.j) r2
            x2.j r3 = x2.j.a
            r4 = 1
            r5 = 0
            if (r2 != r3) goto L22
            r2 = r4
            goto L23
        L22:
            r2 = r5
        L23:
            m2.a1 r3 = r8.p()
            if (r1 == 0) goto L79
            if (r2 == 0) goto L79
            long r1 = r0.d
            boolean r1 = d5.p0.d(r1)
            if (r1 == 0) goto L79
            lx1.l r1 = r0.f624f
            if (r1 != 0) goto L79
            java.lang.CharSequence r0 = r0.c
            int r0 = r0.length()
            if (r0 <= 0) goto L79
            m2.a1 r0 = m2.a1.a
            if (r3 == r0) goto L7a
            s3.f r1 = rs1.g.o()
            if (r1 == 0) goto L4f
            lmjxuqdtp.jvm.functions.Function1 r0 = r1.e()
        L4d:
            r2 = r0
            goto L51
        L4f:
            r0 = 0
            goto L4d
        L51:
            s3.f r3 = rs1.g.p(r1)
            z3.c r0 = r8.o()     // Catch: java.lang.Throwable -> L73
            long r6 = r0.c()     // Catch: java.lang.Throwable -> L73
            rs1.g.s(r1, r3, r2)
            q4.b0 r0 = r8.u()
            if (r0 == 0) goto L6f
            z3.c r0 = com.gnacba.amuvvoafs.gms.internal.measurement.j4.O(r0)
            boolean r0 = com.gnacba.amuvvoafs.gms.internal.measurement.j4.k(r6, r0)
            goto L70
        L6f:
            r0 = r5
        L70:
            if (r0 == 0) goto L79
            goto L7a
        L73:
            r0 = move-exception
            r9 = r0
            rs1.g.s(r1, r3, r2)
            throw r9
        L79:
            r4 = r5
        L7a:
            if (r4 != 0) goto L7f
            x2.d r9 = x2.d.f677f
            return r9
        L7f:
            x2.d r0 = new x2.d
            if (r9 == 0) goto L8d
            z3.c r9 = r8.o()
            long r1 = r9.c()
        L8b:
            r2 = r1
            goto L93
        L8d:
            r1 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            goto L8b
        L93:
            o5.j r5 = o5.j.a
            r6 = 0
            r1 = 1
            r4 = 0
            r0.<init>(r1, r2, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.y.n(boolean):x2.d");
    }

    public final z3.c o() {
        m0 m0VarB = this.b.b();
        z3.c cVar = z3.c.e;
        if (m0VarB == null) {
            return cVar;
        }
        i iVarF = this.a.f();
        if (!p0.d(iVarF.d)) {
            return cVar;
        }
        z3.c cVarC = m0VarB.c((int) (iVarF.d >> 32));
        float fFloor = (float) Math.floor(this.c.w0(y1.a));
        if (fFloor < 1.0f) {
            fFloor = 1.0f;
        }
        float f2 = m0VarB.a.h == n.a ? (fFloor / 2) + cVarC.a : cVarC.c - (fFloor / 2);
        float f3 = fFloor / 2;
        float f4 = ((int) (m0VarB.c >> 32)) - f3;
        if (f2 > f4) {
            f2 = f4;
        }
        if (f2 < f3) {
            f2 = f3;
        }
        float fFloor2 = ((int) fFloor) % 2 == 1 ? ((float) Math.floor(f2)) + 0.5f : (float) Math.rint(f2);
        return new z3.c(fFloor2 - f3, cVarC.b, fFloor2 + f3, cVarC.d);
    }

    public final a1 p() {
        return (a1) this.r.getValue();
    }

    public final boolean q() {
        return this.d && !this.e;
    }

    public final long r() {
        n1 n1Var = this.q;
        if ((((b) n1Var.getValue()).a & 9223372034707292159L) == 9205357640488583168L) {
            return 9205357640488583168L;
        }
        n1 n1Var2 = this.p;
        if ((((b) n1Var2.getValue()).a & 9223372034707292159L) == 9205357640488583168L) {
            return q51.a.p(this.b, ((b) n1Var.getValue()).a);
        }
        long j2 = ((b) n1Var.getValue()).a;
        long j3 = ((b) n1Var2.getValue()).a;
        q4.b0 b0VarU = u();
        return b.j(j2, b.i(j3, b0VarU != null ? b0VarU.A(0L) : 9205357640488583168L));
    }

    public final long s(boolean z) {
        long j2;
        m0 m0VarB = this.b.b();
        if (m0VarB == null) {
            return 0L;
        }
        long j3 = this.a.f().d;
        if (z) {
            int i = p0.c;
            j2 = j3 >> 32;
        } else {
            int i2 = p0.c;
            j2 = 4294967295L & j3;
        }
        return mn1.f.I(m0VarB, (int) j2, z, p0.h(j3));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final x2.d t(boolean r18, boolean r19) {
        /*
            r17 = this;
            r0 = r17
            if (r18 == 0) goto L7
            m2.a1 r1 = m2.a1.b
            goto L9
        L7:
            m2.a1 r1 = m2.a1.c
        L9:
            w2.y0 r2 = r0.b
            d5.m0 r2 = r2.b()
            if (r2 != 0) goto L14
            x2.d r1 = x2.d.f677f
            return r1
        L14:
            w2.c1 r3 = r0.a
            v2.i r4 = r3.f()
            long r4 = r4.d
            boolean r6 = d5.p0.d(r4)
            if (r6 == 0) goto L25
            x2.d r1 = x2.d.f677f
            return r1
        L25:
            long r6 = r17.s(r18)
            tlydtdl.compose.runtime.n1 r8 = r0.s
            java.lang.Object r8 = r8.getValue()
            x2.j r8 = (x2.j) r8
            x2.j r9 = x2.j.a
            r10 = 1
            r11 = 0
            if (r8 != r9) goto L51
            m2.a1 r8 = r0.p()
            if (r8 == r1) goto L4f
            q4.b0 r1 = r0.u()
            if (r1 == 0) goto L4c
            z3.c r1 = com.gnacba.amuvvoafs.gms.internal.measurement.j4.O(r1)
            boolean r1 = com.gnacba.amuvvoafs.gms.internal.measurement.j4.k(r6, r1)
            goto L4d
        L4c:
            r1 = r11
        L4d:
            if (r1 == 0) goto L51
        L4f:
            r1 = r10
            goto L52
        L51:
            r1 = r11
        L52:
            if (r1 != 0) goto L57
            x2.d r1 = x2.d.f677f
            return r1
        L57:
            v2.i r1 = r3.f()
            lx1.l r1 = r1.f624f
            if (r1 != 0) goto L61
            r1 = r10
            goto L62
        L61:
            r1 = r11
        L62:
            if (r1 != 0) goto L67
            x2.d r1 = x2.d.f677f
            return r1
        L67:
            r8 = 4294967295(0xffffffff, double:2.1219957905E-314)
            r1 = 32
            if (r18 == 0) goto L74
            long r10 = r4 >> r1
            int r3 = (int) r10
            goto L7c
        L74:
            long r12 = r4 & r8
            int r3 = (int) r12
            int r3 = r3 - r10
            int r3 = java.lang.Math.max(r3, r11)
        L7c:
            o5.j r15 = r2.a(r3)
            boolean r16 = d5.p0.h(r4)
            if (r19 == 0) goto L96
            q4.b0 r3 = r0.u()
            if (r3 == 0) goto L94
            z3.c r3 = com.gnacba.amuvvoafs.gms.internal.measurement.j4.O(r3)
            long r6 = q51.a.m(r6, r3)
        L94:
            r12 = r6
            goto L9c
        L96:
            r6 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            goto L94
        L9c:
            if (r18 == 0) goto La2
            long r3 = r4 >> r1
        La0:
            int r1 = (int) r3
            goto La5
        La2:
            long r3 = r4 & r8
            goto La0
        La5:
            x2.d r10 = new x2.d
            r11 = 1
            float r14 = qq1.w.F(r2, r1)
            r10.<init>(r11, r12, r14, r15, r16)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.y.t(boolean, boolean):x2.d");
    }

    public final q4.b0 u() {
        q4.b0 b0VarD = this.b.d();
        if (b0VarD == null || !b0VarD.g()) {
            return null;
        }
        return b0VarD;
    }

    public final void v() {
        t1 t1Var;
        if (st1.t1.a) {
            s2.f fVar = this.g.a;
            if (fVar == null || (t1Var = fVar.g) == null) {
                return;
            }
            t1Var.a((CancellationException) null);
            fVar.g = null;
            return;
        }
        u uVar = this.l;
        if (uVar != null) {
            u0 u0Var = uVar.a;
            if (u0Var.d == w2.a) {
                u0Var.d = w2.b;
                ActionMode actionMode = u0Var.b;
                if (actionMode != null) {
                    actionMode.finish();
                }
                u0Var.b = null;
            }
        }
    }

    public final void w() {
        a3.r rVar = this.i;
        if (rVar != null) {
            c1 c1Var = this.a;
            CharSequence charSequence = c1Var.f().c;
            long j2 = c1Var.f().d;
            if (charSequence.length() > 0 && !p0.d(j2)) {
                c0.F(this.h, (qx1.i) null, ky1.b0.d, new k3(rVar, charSequence, j2, this, (qx1.d) null, 13), 1);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object x(sx1.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof x2.s
            if (r0 == 0) goto L13
            r0 = r7
            x2.s r0 = (x2.s) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            x2.s r0 = new x2.s
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            lx1.b0 r3 = lx1.b0.a
            r4 = 1
            if (r2 == 0) goto L50
            if (r2 == r4) goto L4c
            r4 = 2
            r5 = 3
            if (r2 == r4) goto L37
            if (r2 != r5) goto L2f
            lg.e.O(r7)
            return r3
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L37:
            lg.e.O(r7)
            t4.k1 r7 = (t4.k1) r7
            if (r7 != 0) goto L47
            r0.l = r5
            java.lang.Object r7 = r6.y(r0)
            if (r7 != r1) goto L67
            goto L66
        L47:
            r7.b()
            r7 = 0
            throw r7
        L4c:
            lg.e.O(r7)
            return r3
        L50:
            lg.e.O(r7)
            lmjxuqdtp.jvm.functions.Function0 r7 = r6.o
            if (r7 == 0) goto L5e
            java.lang.Object r7 = r7.invoke()
            f3.f2.y(r7)
        L5e:
            r0.l = r4
            java.lang.Object r7 = r6.y(r0)
            if (r7 != r1) goto L67
        L66:
            return r1
        L67:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.y.x(sx1.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        if (r7 == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object y(sx1.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof x2.t
            if (r0 == 0) goto L13
            r0 = r7
            x2.t r0 = (x2.t) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            x2.t r0 = new x2.t
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            lx1.b0 r3 = lx1.b0.a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L38
            if (r2 == r5) goto L34
            if (r2 != r4) goto L2c
            lg.e.O(r7)
            goto L63
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L34:
            lg.e.O(r7)
            goto L56
        L38:
            lg.e.O(r7)
            t4.m1 r7 = r6.f683j
            r0.l = r5
            t4.h r7 = (t4.h) r7
            t4.i r7 = r7.a
            amuvvoafs.content.ClipboardManager r7 = r7.a
            amuvvoafs.content.ClipData r7 = r7.getPrimaryClip()
            if (r7 == 0) goto L52
            t4.k1 r2 = new t4.k1
            r2.<init>(r7)
            r7 = r2
            goto L53
        L52:
            r7 = 0
        L53:
            if (r7 != r1) goto L56
            goto L62
        L56:
            t4.k1 r7 = (t4.k1) r7
            if (r7 == 0) goto L72
            r0.l = r4
            java.lang.String r7 = d2.b.b(r7)
            if (r7 != r1) goto L63
        L62:
            return r1
        L63:
            java.lang.String r7 = (java.lang.String) r7
            if (r7 != 0) goto L68
            goto L72
        L68:
            y2.c r0 = y2.c.a
            r0 = 0
            r1 = 10
            w2.c1 r2 = r6.a
            w2.c1.k(r2, r7, r0, r1)
        L72:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.y.y(sx1.c):java.lang.Object");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean z(long r17) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.y.z(long):boolean");
    }
}
