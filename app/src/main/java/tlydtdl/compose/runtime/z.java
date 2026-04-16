package tlydtdl.compose.runtime;

import a2.p3;
import amuvvoafs.os.Trace;
import com.gnacba.amuvvoafs.gms.internal.ads.j70;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.jvm.functions.Function2;
import okhttp3.HttpUrl;
import q1.n0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements b2, v {
    public final w a;
    public final qu0.u b;
    public final AtomicReference c = new AtomicReference(null);
    public final Object d = new Object();
    public final q1.q0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o2 f550f;
    public final n0 g;
    public final q1.o0 h;
    public final q1.o0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final n0 f551j;
    public final j3.a k;
    public final j3.a l;
    public final n0 m;
    public n0 n;
    public boolean o;
    public m2 p;
    public q1 q;
    public z r;
    public int s;
    public final ru1.c t;
    public final j70 u;
    public final s v;
    public int w;
    public Function2 x;

    public z(w wVar, qu0.u uVar) {
        this.a = wVar;
        this.b = uVar;
        q1.q0 q0Var = new q1.q0(new q1.o0());
        this.e = q0Var;
        o2 o2Var = new o2();
        if (wVar.e()) {
            o2Var.k = new q1.z();
        }
        if (wVar.g()) {
            o2Var.d();
        }
        this.f550f = o2Var;
        this.g = j4.j();
        this.h = new q1.o0();
        this.i = new q1.o0();
        this.f551j = j4.j();
        j3.a aVar = new j3.a();
        this.k = aVar;
        j3.a aVar2 = new j3.a();
        this.l = aVar2;
        this.m = j4.j();
        this.n = j4.j();
        ru1.c cVar = new ru1.c(3, wVar);
        this.t = cVar;
        this.u = new j70();
        s sVar = new s(uVar, wVar, o2Var, q0Var, aVar, aVar2, cVar, this);
        wVar.r(sVar);
        this.v = sVar;
        this.x = i.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A(k3.h hVar) {
        Object obj;
        while (true) {
            Object obj2 = this.c.get();
            if (obj2 == null || obj2.equals(a0.a)) {
                obj = hVar;
            } else if (obj2 instanceof Set) {
                obj = new Set[]{obj2, hVar};
            } else {
                if (!(obj2 instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.c).toString());
                }
                Set[] setArr = (Set[]) obj2;
                int length = setArr.length;
                Object[] objArrCopyOf = Arrays.copyOf(setArr, length + 1);
                objArrCopyOf[length] = hVar;
                obj = objArrCopyOf;
            }
            AtomicReference atomicReference = this.c;
            while (!atomicReference.compareAndSet(obj2, obj)) {
                if (atomicReference.get() != obj2) {
                    break;
                }
            }
            if (obj2 == null) {
                synchronized (this.d) {
                    r();
                }
                return;
            }
            return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r14.d
            monitor-enter(r0)
            r14.x(r15)     // Catch: java.lang.Throwable -> L4f
            q1.n0 r1 = r14.f551j     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r15 = r1.g(r15)     // Catch: java.lang.Throwable -> L4f
            if (r15 == 0) goto L61
            boolean r1 = r15 instanceof q1.o0     // Catch: java.lang.Throwable -> L4f
            if (r1 == 0) goto L5c
            q1.o0 r15 = (q1.o0) r15     // Catch: java.lang.Throwable -> L4f
            java.lang.Object[] r1 = r15.b     // Catch: java.lang.Throwable -> L4f
            long[] r15 = r15.a     // Catch: java.lang.Throwable -> L4f
            int r2 = r15.length     // Catch: java.lang.Throwable -> L4f
            int r2 = r2 + (-2)
            if (r2 < 0) goto L61
            r3 = 0
            r4 = r3
        L1f:
            r5 = r15[r4]     // Catch: java.lang.Throwable -> L4f
            long r7 = ~r5     // Catch: java.lang.Throwable -> L4f
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = r4 - r2
            int r7 = ~r7     // Catch: java.lang.Throwable -> L4f
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L39:
            if (r9 >= r7) goto L55
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L51
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]     // Catch: java.lang.Throwable -> L4f
            tlydtdl.compose.runtime.h0 r10 = (tlydtdl.compose.runtime.h0) r10     // Catch: java.lang.Throwable -> L4f
            r14.x(r10)     // Catch: java.lang.Throwable -> L4f
            goto L51
        L4f:
            r15 = move-exception
            goto L63
        L51:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L39
        L55:
            if (r7 != r8) goto L61
        L57:
            if (r4 == r2) goto L61
            int r4 = r4 + 1
            goto L1f
        L5c:
            tlydtdl.compose.runtime.h0 r15 = (tlydtdl.compose.runtime.h0) r15     // Catch: java.lang.Throwable -> L4f
            r14.x(r15)     // Catch: java.lang.Throwable -> L4f
        L61:
            monitor-exit(r0)
            return
        L63:
            monitor-exit(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.z.B(java.lang.Object):void");
    }

    public final void C(Function2 function2) {
        boolean zL = l();
        t();
        w wVar = this.a;
        if (!zL) {
            this.x = function2;
            wVar.a(this, function2);
            return;
        }
        s sVar = this.v;
        sVar.z = 100;
        sVar.y = true;
        this.x = function2;
        wVar.a(this, function2);
        sVar.w();
    }

    @Override // tlydtdl.compose.runtime.b2
    public final void a() {
        this.o = true;
        this.t.n();
    }

    @Override // tlydtdl.compose.runtime.b2
    public final r0 b(a2 a2Var, Object obj) {
        z zVar;
        int i = a2Var.b;
        if ((i & 2) != 0) {
            a2Var.b = i | 4;
        }
        a aVar = a2Var.c;
        if (aVar == null || !aVar.a()) {
            return r0.a;
        }
        if (this.f550f.i(aVar)) {
            if (a2Var.d == null) {
                return r0.a;
            }
            r0 r0VarW = w(a2Var, aVar, obj);
            if (r0VarW != r0.a) {
                this.t.n();
            }
            return r0VarW;
        }
        synchronized (this.d) {
            zVar = this.r;
        }
        if (zVar != null) {
            s sVar = zVar.v;
            if (sVar.F && sVar.l0(a2Var, obj)) {
                return r0.d;
            }
        }
        return r0.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    @Override // tlydtdl.compose.runtime.b2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(java.lang.Object r22) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.z.c(java.lang.Object):void");
    }

    public final void d() {
        this.c.set(null);
        this.k.b.I0();
        this.l.b.I0();
        q1.q0 q0Var = this.e;
        if (q0Var.a.g()) {
            return;
        }
        j70 j70Var = this.u;
        try {
            j70Var.h(q0Var, this.v.E());
            j70Var.c();
        } finally {
            j70Var.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(java.lang.Object r20, boolean r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            q1.n0 r2 = r0.g
            java.lang.Object r2 = r2.g(r1)
            if (r2 == 0) goto L9a
            boolean r3 = r2 instanceof q1.o0
            q1.o0 r4 = r0.h
            q1.o0 r5 = r0.i
            q1.n0 r6 = r0.m
            if (r3 == 0) goto L7d
            q1.o0 r2 = (q1.o0) r2
            java.lang.Object[] r3 = r2.b
            long[] r2 = r2.a
            int r7 = r2.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L9a
            r9 = 0
        L22:
            r10 = r2[r9]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L78
            int r12 = r9 - r7
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r14 = 0
        L3c:
            if (r14 >= r12) goto L75
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r10
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L6c
            int r15 = r9 << 3
            int r15 = r15 + r14
            r15 = r3[r15]
            tlydtdl.compose.runtime.a2 r15 = (tlydtdl.compose.runtime.a2) r15
            boolean r16 = com.gnacba.amuvvoafs.gms.internal.measurement.j4.B(r6, r1, r15)
            if (r16 != 0) goto L6c
            tlydtdl.compose.runtime.r0 r8 = r15.c(r1)
            r17 = r13
            tlydtdl.compose.runtime.r0 r13 = tlydtdl.compose.runtime.r0.a
            if (r8 == r13) goto L6e
            q1.n0 r8 = r15.g
            if (r8 == 0) goto L68
            if (r21 != 0) goto L68
            r5.a(r15)
            goto L6e
        L68:
            r4.a(r15)
            goto L6e
        L6c:
            r17 = r13
        L6e:
            long r10 = r10 >> r17
            int r14 = r14 + 1
            r13 = r17
            goto L3c
        L75:
            r8 = r13
            if (r12 != r8) goto L9a
        L78:
            if (r9 == r7) goto L9a
            int r9 = r9 + 1
            goto L22
        L7d:
            tlydtdl.compose.runtime.a2 r2 = (tlydtdl.compose.runtime.a2) r2
            boolean r3 = com.gnacba.amuvvoafs.gms.internal.measurement.j4.B(r6, r1, r2)
            if (r3 != 0) goto L9a
            tlydtdl.compose.runtime.r0 r1 = r2.c(r1)
            tlydtdl.compose.runtime.r0 r3 = tlydtdl.compose.runtime.r0.a
            if (r1 == r3) goto L9a
            q1.n0 r1 = r2.g
            if (r1 == 0) goto L97
            if (r21 != 0) goto L97
            r5.a(r2)
            return
        L97:
            r4.a(r2)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.z.e(java.lang.Object, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0183 A[EDGE_INSN: B:73:0x0183->B:224:0x0122 BREAK  A[LOOP:13: B:63:0x0151->B:74:0x0185]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(java.util.Set r34, boolean r35) {
        /*
            Method dump skipped, instruction units count: 918
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.z.f(java.util.Set, boolean):void");
    }

    public final void g() {
        synchronized (this.d) {
            try {
                h(this.k);
                r();
            } catch (Throwable th) {
                try {
                    if (!this.e.a.g()) {
                        j70 j70Var = this.u;
                        try {
                            j70Var.h(this.e, this.v.E());
                            j70Var.c();
                            j70Var.a();
                        } catch (Throwable th2) {
                            j70Var.a();
                            throw th2;
                        }
                    }
                    throw th;
                } catch (Throwable th3) {
                    d();
                    throw th3;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h(j3.a r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.z.h(j3.a):void");
    }

    public final void i() {
        synchronized (this.d) {
            try {
                if (this.l.b.L0()) {
                    h(this.l);
                }
            } catch (Throwable th) {
                try {
                    if (!this.e.a.g()) {
                        j70 j70Var = this.u;
                        try {
                            j70Var.h(this.e, this.v.E());
                            j70Var.c();
                            j70Var.a();
                        } catch (Throwable th2) {
                            j70Var.a();
                            throw th2;
                        }
                    }
                    throw th;
                } finally {
                }
            }
        }
    }

    public final void j() {
        j70 j70Var;
        synchronized (this.d) {
            try {
                this.v.v = null;
                if (!this.e.a.g()) {
                    j70Var = this.u;
                    try {
                        j70Var.h(this.e, this.v.E());
                        j70Var.c();
                        j70Var.a();
                    } finally {
                    }
                }
            } catch (Throwable th) {
                try {
                    if (!this.e.a.g()) {
                        j70Var = this.u;
                        try {
                            j70Var.h(this.e, this.v.E());
                            j70Var.c();
                            j70Var.a();
                        } finally {
                        }
                    }
                    throw th;
                } catch (Throwable th2) {
                    d();
                    throw th2;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void k() {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.z.k():void");
    }

    public final boolean l() {
        boolean z;
        synchronized (this.d) {
            z = true;
            if (this.w != 1) {
                z = false;
            }
            if (z) {
                this.w = 0;
            }
        }
        return z;
    }

    public final void m(Function2 function2) {
        try {
            synchronized (this.d) {
                q();
                n0 n0Var = this.n;
                this.n = j4.j();
                try {
                    s sVar = this.v;
                    m2 m2Var = this.p;
                    if (!sVar.e.b.K0()) {
                        u.c("Expected applyChanges() to have been called");
                    }
                    sVar.P = m2Var;
                    try {
                        sVar.p(n0Var, function2);
                    } finally {
                        sVar.P = null;
                    }
                } catch (Throwable th) {
                    this.n = n0Var;
                    throw th;
                }
            }
        } catch (Throwable th2) {
            try {
                if (!this.e.a.g()) {
                    j70 j70Var = this.u;
                    try {
                        j70Var.h(this.e, this.v.E());
                        j70Var.c();
                        j70Var.a();
                    } catch (Throwable th3) {
                        j70Var.a();
                        throw th3;
                    }
                }
                throw th2;
            } catch (Throwable th4) {
                d();
                throw th4;
            }
        }
    }

    public final q1 n(boolean z, Function2 function2) {
        if (this.q != null) {
            v1.b("A pausable composition is in progress");
        }
        q1 q1Var = new q1(this, this.a, this.v, this.e, function2, z, this.b, this.d);
        this.q = q1Var;
        return q1Var;
    }

    public final void o() {
        synchronized (this.d) {
            try {
                if (this.q != null) {
                    v1.b("Deactivate is not supported while pausable composition is in progress");
                }
                boolean z = this.f550f.b > 0;
                if (z || !this.e.a.g()) {
                    Trace.beginSection("Compose:deactivate");
                    try {
                        j70 j70Var = this.u;
                        try {
                            j70Var.h(this.e, this.v.E());
                            if (z) {
                                r2 r2VarH = this.f550f.h();
                                try {
                                    r2VarH.n(r2VarH.t, new a2.r2(6, this.u, r2VarH));
                                    r2VarH.e(true);
                                    this.b.e();
                                    j70Var.d();
                                } catch (Throwable th) {
                                    r2VarH.e(false);
                                    throw th;
                                }
                            }
                            j70Var.c();
                            j70Var.a();
                        } catch (Throwable th2) {
                            j70Var.a();
                            throw th2;
                        }
                    } finally {
                        Trace.endSection();
                    }
                }
                this.g.a();
                this.f551j.a();
                this.n.a();
                this.k.b.I0();
                this.l.b.I0();
                s sVar = this.v;
                sVar.E.clear();
                sVar.s.clear();
                sVar.e.b.I0();
                sVar.v = null;
                this.w = 1;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final void p() {
        synchronized (this.d) {
            try {
                if (this.v.F) {
                    v1.b("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
                }
                if (this.w != 3) {
                    this.w = 3;
                    this.x = i.b;
                    j3.a aVar = this.v.L;
                    if (aVar != null) {
                        h(aVar);
                    }
                    boolean z = this.f550f.b > 0;
                    if (z || !this.e.a.g()) {
                        j70 j70Var = this.u;
                        try {
                            j70Var.h(this.e, this.v.E());
                            if (z) {
                                r2 r2VarH = this.f550f.h();
                                try {
                                    r2VarH.n(r2VarH.t, new p3(4, this.u));
                                    r2VarH.I();
                                    r2VarH.e(true);
                                    this.b.m();
                                    this.b.e();
                                    j70Var.d();
                                } catch (Throwable th) {
                                    r2VarH.e(false);
                                    throw th;
                                }
                            }
                            j70Var.c();
                            j70Var.a();
                        } catch (Throwable th2) {
                            j70Var.a();
                            throw th2;
                        }
                    }
                    s sVar = this.v;
                    sVar.getClass();
                    Trace.beginSection("Compose:Composer.dispose");
                    try {
                        sVar.b.v(sVar);
                        sVar.E.clear();
                        sVar.s.clear();
                        sVar.e.b.I0();
                        sVar.v = null;
                        sVar.a.m();
                        Trace.endSection();
                    } catch (Throwable th3) {
                        Trace.endSection();
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        this.a.w(this);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    public final void q() throws KotlinNothingValueException {
        Object obj = a0.a;
        AtomicReference atomicReference = this.c;
        Object andSet = atomicReference.getAndSet(obj);
        if (andSet != null) {
            if (andSet.equals(obj)) {
                u.d("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                f((Set) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                u.d("corrupt pendingModifications drain: " + atomicReference);
                throw new KotlinNothingValueException();
            }
            for (Set set : (Set[]) andSet) {
                f(set, true);
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    public final void r() throws KotlinNothingValueException {
        AtomicReference atomicReference = this.c;
        Object andSet = atomicReference.getAndSet(null);
        if (lmjxuqdtp.jvm.internal.o.c(andSet, a0.a)) {
            return;
        }
        if (andSet instanceof Set) {
            f((Set) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set set : (Set[]) andSet) {
                f(set, false);
            }
            return;
        }
        if (andSet == null) {
            u.d("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        }
        u.d("corrupt pendingModifications drain: " + atomicReference);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    public final void s() throws KotlinNothingValueException {
        mx1.v vVar = mx1.v.a;
        AtomicReference atomicReference = this.c;
        Object andSet = atomicReference.getAndSet(vVar);
        if (lmjxuqdtp.jvm.internal.o.c(andSet, a0.a) || andSet == null) {
            return;
        }
        if (andSet instanceof Set) {
            f((Set) andSet, false);
            return;
        }
        if (!(andSet instanceof Object[])) {
            u.d("corrupt pendingModifications drain: " + atomicReference);
            throw new KotlinNothingValueException();
        }
        for (Set set : (Set[]) andSet) {
            f(set, false);
        }
    }

    public final void t() {
        int i = this.w;
        if (i != 0) {
            v1.b(i != 1 ? i != 2 ? i != 3 ? HttpUrl.FRAGMENT_ENCODE_SET : "The composition is disposed" : "A previous pausable composition for this composition was cancelled. This composition must be disposed." : "The composition should be activated before setting content.");
        }
        if (this.q == null) {
            return;
        }
        v1.b("A pausable composition is in progress");
    }

    public final void u(ArrayList arrayList) {
        q1.q0 q0Var = this.e;
        s sVar = this.v;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (!((c1) ((lx1.l) arrayList.get(i)).a).c.equals(this)) {
                    u.c("Check failed");
                    break;
                }
                i++;
            }
        }
        try {
            sVar.getClass();
            try {
                sVar.H(arrayList);
                sVar.j();
            } catch (Throwable th) {
                sVar.a();
                throw th;
            }
        } catch (Throwable th2) {
            try {
                if (!q0Var.a.g()) {
                    j70 j70Var = this.u;
                    try {
                        j70Var.h(q0Var, sVar.E());
                        j70Var.c();
                        j70Var.a();
                    } catch (Throwable th3) {
                        j70Var.a();
                        throw th3;
                    }
                }
                throw th2;
            } catch (Throwable th4) {
                d();
                throw th4;
            }
        }
    }

    public final void v() {
        b2 b2Var;
        synchronized (this.d) {
            try {
                for (Object obj : this.f550f.c) {
                    a2 a2Var = obj instanceof a2 ? (a2) obj : null;
                    if (a2Var != null && (b2Var = a2Var.a) != null) {
                        b2Var.b(a2Var, null);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d5 A[Catch: all -> 0x0042, EDGE_INSN: B:80:0x00d5->B:65:0x00d5 BREAK  A[LOOP:0: B:47:0x008c->B:61:0x00cd], EDGE_INSN: B:81:0x00d5->B:65:0x00d5 BREAK  A[LOOP:0: B:47:0x008c->B:61:0x00cd], TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:4:0x000b, B:6:0x0010, B:8:0x0018, B:10:0x001f, B:14:0x0029, B:16:0x002f, B:13:0x0024, B:25:0x0047, B:27:0x004d, B:32:0x0058, B:36:0x005e, B:37:0x0067, B:39:0x006b, B:40:0x0074, B:42:0x007c, B:44:0x0080, B:47:0x008c, B:49:0x009c, B:51:0x00a8, B:53:0x00b2, B:57:0x00c1, B:61:0x00cd, B:62:0x00d0, B:65:0x00d5), top: B:78:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final tlydtdl.compose.runtime.r0 w(tlydtdl.compose.runtime.a2 r21, tlydtdl.compose.runtime.a r22, java.lang.Object r23) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.z.w(tlydtdl.compose.runtime.a2, tlydtdl.compose.runtime.a, java.lang.Object):tlydtdl.compose.runtime.r0");
    }

    public final void x(Object obj) {
        Object objG = this.g.g(obj);
        if (objG == null) {
            return;
        }
        boolean z = objG instanceof q1.o0;
        n0 n0Var = this.m;
        if (!z) {
            a2 a2Var = (a2) objG;
            if (a2Var.c(obj) == r0.d) {
                j4.f(n0Var, obj, a2Var);
                return;
            }
            return;
        }
        q1.o0 o0Var = (q1.o0) objG;
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
                    if ((255 & j2) < 128) {
                        a2 a2Var2 = (a2) objArr[(i << 3) + i3];
                        if (a2Var2.c(obj) == r0.d) {
                            j4.f(n0Var, obj, a2Var2);
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

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean y(java.util.Set r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            boolean r2 = r1 instanceof k3.h
            q1.n0 r3 = r0.f551j
            q1.n0 r4 = r0.g
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L5e
            k3.h r1 = (k3.h) r1
            q1.o0 r1 = r1.a
            java.lang.Object[] r2 = r1.b
            long[] r1 = r1.a
            int r7 = r1.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L7b
            r8 = r5
        L1c:
            r9 = r1[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L59
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r5
        L36:
            if (r13 >= r11) goto L57
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L53
            int r14 = r8 << 3
            int r14 = r14 + r13
            r14 = r2[r14]
            boolean r15 = r4.c(r14)
            if (r15 != 0) goto L52
            boolean r14 = r3.c(r14)
            if (r14 == 0) goto L53
        L52:
            return r6
        L53:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L36
        L57:
            if (r11 != r12) goto L7b
        L59:
            if (r8 == r7) goto L7b
            int r8 = r8 + 1
            goto L1c
        L5e:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L64:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L7b
            java.lang.Object r2 = r1.next()
            boolean r7 = r4.c(r2)
            if (r7 != 0) goto L7a
            boolean r2 = r3.c(r2)
            if (r2 == 0) goto L64
        L7a:
            return r6
        L7b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.z.y(java.util.Set):boolean");
    }

    public final boolean z() {
        synchronized (this.d) {
            q1 q1Var = this.q;
            boolean zL0 = false;
            if (q1Var != null && q1Var.h.get() != r1.e) {
                q1Var.e();
                return false;
            }
            q();
            try {
                n0 n0Var = this.n;
                this.n = j4.j();
                try {
                    s sVar = this.v;
                    m2 m2Var = this.p;
                    j3.m0 m0Var = sVar.e.b;
                    if (!m0Var.K0()) {
                        u.c("Expected applyChanges() to have been called");
                    }
                    if (n0Var.e > 0 || !sVar.s.isEmpty()) {
                        sVar.P = m2Var;
                        try {
                            sVar.p(n0Var, null);
                            sVar.P = null;
                            zL0 = m0Var.L0();
                        } catch (Throwable th) {
                            sVar.P = null;
                            throw th;
                        }
                    }
                    if (!zL0) {
                        r();
                    }
                    return zL0;
                } catch (Throwable th2) {
                    this.n = n0Var;
                    throw th2;
                }
            } catch (Throwable th3) {
                try {
                    if (!this.e.a.g()) {
                        j70 j70Var = this.u;
                        try {
                            j70Var.h(this.e, this.v.E());
                            j70Var.c();
                            j70Var.a();
                        } catch (Throwable th4) {
                            j70Var.a();
                            throw th4;
                        }
                    }
                    throw th3;
                } catch (Throwable th5) {
                    d();
                    throw th5;
                }
            }
        }
    }
}
