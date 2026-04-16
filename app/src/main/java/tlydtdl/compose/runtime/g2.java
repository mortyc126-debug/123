package tlydtdl.compose.runtime;

import a2.n3;
import a2.o3;
import a2.q3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import ky1.f1;
import lmjxuqdtp.jvm.functions.Function2;
import o3.b;
import q1.n0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g2 extends w {
    public static final ny1.r2 y = ny1.z.c(b.d);
    public static final AtomicReference z = new AtomicReference(Boolean.FALSE);
    public final f a;
    public final Object b;
    public f1 c;
    public Throwable d;
    public final ArrayList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f532f;
    public q1.o0 g;
    public final k3.e h;
    public final ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f533j;
    public final n0 k;
    public final w2.u l;
    public final n0 m;
    public final n0 n;
    public ArrayList o;
    public LinkedHashSet p;
    public ky1.m q;
    public ru1.c r;
    public boolean s;
    public final ny1.r2 t;
    public final jx0.h u;
    public final ky1.g1 v;
    public final qx1.i w;
    public final x0 x;

    public g2(qx1.i iVar) {
        f fVar = new f(new n3(2, this));
        this.a = fVar;
        this.b = new Object();
        this.e = new ArrayList();
        this.g = new q1.o0();
        this.h = new k3.e(0, new z[16]);
        this.i = new ArrayList();
        this.f533j = new ArrayList();
        this.k = new n0();
        this.l = new w2.u(2);
        this.m = new n0();
        this.n = new n0();
        this.t = ny1.z.c(c2.c);
        this.u = new jx0.h(21);
        ky1.g1 g1Var = new ky1.g1(iVar.get(ky1.e1.a));
        g1Var.K(new o3(10, this));
        this.v = g1Var;
        this.w = iVar.plus(fVar).plus(g1Var);
        this.x = new x0(8);
    }

    public static final void F(ArrayList arrayList, g2 g2Var, z zVar) {
        arrayList.clear();
        synchronized (g2Var.b) {
            Iterator it = g2Var.f533j.iterator();
            while (it.hasNext()) {
                c1 c1Var = (c1) it.next();
                if (c1Var.c.equals(zVar)) {
                    arrayList.add(c1Var);
                    it.remove();
                }
            }
        }
    }

    public static void x(s3.b bVar) {
        try {
            if (bVar.w() instanceof s3.g) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");
            }
        } finally {
            bVar.c();
        }
    }

    public static final void z(g2 g2Var, c1 c1Var, c1 c1Var2) {
        List list = c1Var2.h;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                c1 c1Var3 = (c1) list.get(i);
                w2.u uVar = g2Var.l;
                a1 a1Var = c1Var3.a;
                f1 f1Var = new f1(c1Var3, c1Var);
                k3.a.a((n0) uVar.b, a1Var, f1Var);
                k3.a.a((n0) uVar.c, f1Var.a(), a1Var);
                z(g2Var, c1Var, c1Var3);
            }
        }
    }

    public final ky1.l A() {
        c2 c2Var;
        ny1.r2 r2Var = this.t;
        int iCompareTo = ((c2) r2Var.getValue()).compareTo(c2.b);
        ArrayList arrayList = this.f533j;
        ArrayList arrayList2 = this.i;
        k3.e eVar = this.h;
        if (iCompareTo > 0) {
            if (this.r != null) {
                c2Var = c2.c;
            } else if (this.c == null) {
                this.g = new q1.o0();
                eVar.k();
                c2Var = B() ? c2.d : c2.c;
            } else {
                c2Var = (eVar.c == 0 && !this.g.h() && arrayList2.isEmpty() && arrayList.isEmpty() && !B() && !this.k.j()) ? c2.e : c2.f524f;
            }
            r2Var.i((Object) null, c2Var);
            if (c2Var != c2.f524f) {
                return null;
            }
            ky1.m mVar = this.q;
            this.q = null;
            return mVar;
        }
        for (z zVar : D()) {
        }
        this.e.clear();
        this.f532f = mx1.t.a;
        this.g = new q1.o0();
        eVar.k();
        arrayList2.clear();
        arrayList.clear();
        this.o = null;
        ky1.m mVar2 = this.q;
        if (mVar2 != null) {
            mVar2.l((Throwable) null);
        }
        this.q = null;
        this.r = null;
        return null;
    }

    public final boolean B() {
        return !this.s && (this.a.d.get() & 134217727) > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean C() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.b
            monitor-enter(r0)
            q1.o0 r1 = r2.g     // Catch: java.lang.Throwable -> L1b
            boolean r1 = r1.h()     // Catch: java.lang.Throwable -> L1b
            if (r1 != 0) goto L1d
            k3.e r1 = r2.h     // Catch: java.lang.Throwable -> L1b
            int r1 = r1.c     // Catch: java.lang.Throwable -> L1b
            if (r1 == 0) goto L12
            goto L1d
        L12:
            boolean r1 = r2.B()     // Catch: java.lang.Throwable -> L1b
            if (r1 == 0) goto L19
            goto L1d
        L19:
            r1 = 0
            goto L1e
        L1b:
            r1 = move-exception
            goto L20
        L1d:
            r1 = 1
        L1e:
            monitor-exit(r0)
            return r1
        L20:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.g2.C():boolean");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    public final List D() {
        ?? r0 = this.f532f;
        if (r0 != 0) {
            return r0;
        }
        ArrayList arrayList = this.e;
        mx1.t arrayList2 = arrayList.isEmpty() ? mx1.t.a : new ArrayList(arrayList);
        this.f532f = arrayList2;
        return arrayList2;
    }

    public final void E(z zVar) {
        synchronized (this.b) {
            ArrayList arrayList = this.f533j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((c1) arrayList.get(i)).c.equals(zVar)) {
                    ArrayList arrayList2 = new ArrayList();
                    F(arrayList2, this, zVar);
                    while (!arrayList2.isEmpty()) {
                        G(arrayList2, null);
                        F(arrayList2, this, zVar);
                    }
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0156, code lost:
    
        r3 = r10.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x015b, code lost:
    
        if (r4 >= r3) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0165, code lost:
    
        if (((lx1.l) r10.get(r4)).b == null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0167, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x016a, code lost:
    
        r3 = new java.util.ArrayList(r10.size());
        r4 = r10.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0178, code lost:
    
        if (r8 >= r4) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x017a, code lost:
    
        r11 = (lx1.l) r10.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0182, code lost:
    
        if (r11.b != null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0184, code lost:
    
        r11 = (tlydtdl.compose.runtime.c1) r11.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x018b, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x018c, code lost:
    
        if (r11 == null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x018e, code lost:
    
        r3.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0191, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0194, code lost:
    
        r4 = r16.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0196, code lost:
    
        monitor-enter(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0197, code lost:
    
        mx1.o.i0(r16.f533j, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x019c, code lost:
    
        monitor-exit(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x019d, code lost:
    
        r3 = new java.util.ArrayList(r10.size());
        r4 = r10.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ab, code lost:
    
        if (r8 >= r4) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01ad, code lost:
    
        r11 = r10.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b6, code lost:
    
        if (((lx1.l) r11).b == null) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b8, code lost:
    
        r3.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bb, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01be, code lost:
    
        r10 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List G(java.util.List r17, q1.o0 r18) {
        /*
            Method dump skipped, instruction units count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.g2.G(java.util.List, q1.o0):java.util.List");
    }

    public final z H(z zVar, q1.o0 o0Var) {
        s3.b bVarC;
        if (zVar.v.F || zVar.w == 3) {
            return null;
        }
        LinkedHashSet linkedHashSet = this.p;
        if (linkedHashSet == null || !linkedHashSet.contains(zVar)) {
            o3 o3Var = new o3(9, zVar);
            q3 q3Var = new q3(7, zVar, o0Var);
            s3.b bVarK = s3.l.k();
            s3.b bVar = bVarK instanceof s3.b ? bVarK : null;
            if (bVar == null || (bVarC = bVar.C(o3Var, q3Var)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            try {
                s3.f fVarJ = bVarC.j();
                if (o0Var != null) {
                    try {
                        if (o0Var.h()) {
                            a10.h hVar = new a10.h(5, o0Var, zVar);
                            s sVar = zVar.v;
                            if (sVar.F) {
                                u.c("Preparing a composition while composing is not supported");
                            }
                            sVar.F = true;
                            try {
                                hVar.invoke();
                                sVar.F = false;
                            } catch (Throwable th) {
                                sVar.F = false;
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        s3.f.q(fVarJ);
                        throw th2;
                    }
                }
                boolean z2 = zVar.z();
                s3.f.q(fVarJ);
                if (z2) {
                    return zVar;
                }
            } finally {
                x(bVarC);
            }
        }
        return null;
    }

    public final void I(Throwable th, z zVar) throws Throwable {
        if (!((Boolean) z.get()).booleanValue() || (th instanceof ComposeRuntimeError)) {
            synchronized (this.b) {
                ru1.c cVar = this.r;
                if (cVar != null) {
                    throw ((Throwable) cVar.b);
                }
                this.r = new ru1.c(4, th);
            }
            throw th;
        }
        synchronized (this.b) {
            try {
                com.gnacba.protobuf.c1.y("Error was captured in composition while live edit was enabled.", th);
                this.i.clear();
                this.h.k();
                this.g = new q1.o0();
                this.f533j.clear();
                this.k.a();
                this.m.a();
                this.r = new ru1.c(4, th);
                if (zVar != null) {
                    K(zVar);
                }
                A();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean J() {
        synchronized (this.b) {
            boolean z2 = true;
            if (this.g.g()) {
                if (this.h.c == 0 && !B() && !this.k.j()) {
                    z2 = false;
                }
                return z2;
            }
            List listD = D();
            k3.h hVar = new k3.h(this.g);
            this.g = new q1.o0();
            try {
                int size = listD.size();
                for (int i = 0; i < size; i++) {
                    ((z) listD.get(i)).A(hVar);
                    if (((c2) this.t.getValue()).compareTo(c2.b) <= 0) {
                        break;
                    }
                }
                synchronized (this.b) {
                    if (A() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                    }
                    if (this.h.c == 0 && !B() && !this.k.j()) {
                        z2 = false;
                    }
                }
                return z2;
            } catch (Throwable th) {
                synchronized (this.b) {
                    q1.o0 o0Var = this.g;
                    o0Var.getClass();
                    Iterator it = hVar.iterator();
                    while (it.hasNext()) {
                        o0Var.j(it.next());
                    }
                    throw th;
                }
            }
        }
    }

    public final void K(z zVar) {
        ArrayList arrayList = this.o;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.o = arrayList;
        }
        if (!arrayList.contains(zVar)) {
            arrayList.add(zVar);
        }
        if (this.e.remove(zVar)) {
            this.f532f = null;
        }
    }

    @Override // tlydtdl.compose.runtime.w
    public final void a(z zVar, Function2 function2) throws Throwable {
        c2 c2Var;
        boolean zContains;
        s3.b bVarC;
        boolean z2 = zVar.v.F;
        synchronized (this.b) {
            c2 c2Var2 = (c2) this.t.getValue();
            c2Var = c2.b;
            zContains = c2Var2.compareTo(c2Var) > 0 ? true ^ D().contains(zVar) : true;
        }
        try {
            o3 o3Var = new o3(9, zVar);
            q3 q3Var = new q3(7, zVar, (Object) null);
            s3.b bVarK = s3.l.k();
            s3.b bVar = bVarK instanceof s3.b ? bVarK : null;
            if (bVar == null || (bVarC = bVar.C(o3Var, q3Var)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            try {
                s3.f fVarJ = bVarC.j();
                try {
                    zVar.m(function2);
                    synchronized (this.b) {
                        if (((c2) this.t.getValue()).compareTo(c2Var) > 0 && !D().contains(zVar)) {
                            this.e.add(zVar);
                            this.f532f = null;
                        }
                    }
                    if (!z2) {
                        s3.l.k().m();
                    }
                    try {
                        E(zVar);
                        try {
                            zVar.g();
                            zVar.i();
                            if (z2) {
                                return;
                            }
                            s3.l.k().m();
                        } catch (Throwable th) {
                            I(th, null);
                        }
                    } catch (Throwable th2) {
                        I(th2, zVar);
                    }
                } finally {
                    s3.f.q(fVarJ);
                }
            } finally {
                x(bVarC);
            }
        } catch (Throwable th3) {
            if (zContains) {
                synchronized (this.b) {
                }
            }
            I(th3, zVar);
        }
    }

    @Override // tlydtdl.compose.runtime.w
    public final q1.o0 b(z zVar, m2 m2Var, Function2 function2) {
        jx0.h hVar = this.u;
        try {
            m2 m2Var2 = zVar.p;
            zVar.p = m2Var;
            try {
                a(zVar, function2);
                q1.o0 o0Var = (q1.o0) hVar.get();
                if (o0Var == null) {
                    o0Var = q1.w0.a;
                    lmjxuqdtp.jvm.internal.o.f(o0Var, "null cannot be cast to non-null type tlydtdl.collection.ScatterSet<E of tlydtdl.collection.ScatterSetKt.emptyScatterSet>");
                }
                return o0Var;
            } finally {
                zVar.p = m2Var2;
            }
        } finally {
            hVar.E((Object) null);
        }
    }

    @Override // tlydtdl.compose.runtime.w
    public final void c(c1 c1Var) {
        ky1.m mVarA;
        synchronized (this.b) {
            try {
                k3.a.a(this.k, c1Var.a, c1Var);
                if (c1Var.h != null) {
                    z(this, c1Var, c1Var);
                }
                mVarA = A();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (mVarA != null) {
            mVarA.resumeWith(lx1.b0.a);
        }
    }

    @Override // tlydtdl.compose.runtime.w
    public final boolean e() {
        return ((Boolean) z.get()).booleanValue();
    }

    @Override // tlydtdl.compose.runtime.w
    public final boolean f() {
        return false;
    }

    @Override // tlydtdl.compose.runtime.w
    public final boolean g() {
        return false;
    }

    @Override // tlydtdl.compose.runtime.w
    public final long h() {
        return 1000;
    }

    @Override // tlydtdl.compose.runtime.w
    public final v i() {
        return null;
    }

    @Override // tlydtdl.compose.runtime.w
    public final qx1.i k() {
        return this.w;
    }

    @Override // tlydtdl.compose.runtime.w
    public final void l(c1 c1Var) {
        ky1.m mVarA;
        synchronized (this.b) {
            this.f533j.add(c1Var);
            mVarA = A();
        }
        if (mVarA != null) {
            mVarA.resumeWith(lx1.b0.a);
        }
    }

    @Override // tlydtdl.compose.runtime.w
    public final void m(z zVar) {
        ky1.l lVarA;
        synchronized (this.b) {
            if (this.h.l(zVar)) {
                lVarA = null;
            } else {
                this.h.d(zVar);
                lVarA = A();
            }
        }
        if (lVarA != null) {
            ((ky1.m) lVarA).resumeWith(lx1.b0.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    @Override // tlydtdl.compose.runtime.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void n(tlydtdl.compose.runtime.c1 r18, tlydtdl.compose.runtime.b1 r19, tlydtdl.compose.runtime.c r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            java.lang.Object r3 = r1.b
            monitor-enter(r3)
            q1.n0 r4 = r1.m     // Catch: java.lang.Throwable -> L80
            r4.m(r0, r2)     // Catch: java.lang.Throwable -> L80
            q1.n0 r4 = r1.n     // Catch: java.lang.Throwable -> L80
            java.lang.Object r0 = r4.g(r0)     // Catch: java.lang.Throwable -> L80
            if (r0 != 0) goto L1e
            q1.j0 r0 = q1.t0.b     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "null cannot be cast to non-null type tlydtdl.collection.ObjectList<E of tlydtdl.collection.ObjectListKt.emptyObjectList>"
            lmjxuqdtp.jvm.internal.o.f(r0, r4)     // Catch: java.lang.Throwable -> L80
            goto L31
        L1e:
            boolean r4 = r0 instanceof q1.j0     // Catch: java.lang.Throwable -> L80
            if (r4 == 0) goto L25
            q1.j0 r0 = (q1.j0) r0     // Catch: java.lang.Throwable -> L80
            goto L31
        L25:
            java.lang.Object[] r4 = q1.t0.a     // Catch: java.lang.Throwable -> L80
            q1.j0 r4 = new q1.j0     // Catch: java.lang.Throwable -> L80
            r5 = 1
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L80
            r4.a(r0)     // Catch: java.lang.Throwable -> L80
            r0 = r4
        L31:
            boolean r4 = r0.h()     // Catch: java.lang.Throwable -> L80
            if (r4 == 0) goto L8d
            r4 = r20
            q1.n0 r0 = r2.b(r4, r0)     // Catch: java.lang.Throwable -> L80
            java.lang.Object[] r2 = r0.b     // Catch: java.lang.Throwable -> L80
            java.lang.Object[] r4 = r0.c     // Catch: java.lang.Throwable -> L80
            long[] r0 = r0.a     // Catch: java.lang.Throwable -> L80
            int r5 = r0.length     // Catch: java.lang.Throwable -> L80
            int r5 = r5 + (-2)
            if (r5 < 0) goto L8d
            r6 = 0
            r7 = r6
        L4a:
            r8 = r0[r7]     // Catch: java.lang.Throwable -> L80
            long r10 = ~r8     // Catch: java.lang.Throwable -> L80
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L88
            int r10 = r7 - r5
            int r10 = ~r10     // Catch: java.lang.Throwable -> L80
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L64:
            if (r12 >= r10) goto L86
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L82
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r2[r13]     // Catch: java.lang.Throwable -> L80
            r13 = r4[r13]     // Catch: java.lang.Throwable -> L80
            tlydtdl.compose.runtime.b1 r13 = (tlydtdl.compose.runtime.b1) r13     // Catch: java.lang.Throwable -> L80
            tlydtdl.compose.runtime.c1 r14 = (tlydtdl.compose.runtime.c1) r14     // Catch: java.lang.Throwable -> L80
            q1.n0 r15 = r1.m     // Catch: java.lang.Throwable -> L80
            r15.m(r14, r13)     // Catch: java.lang.Throwable -> L80
            goto L82
        L80:
            r0 = move-exception
            goto L8f
        L82:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L64
        L86:
            if (r10 != r11) goto L8d
        L88:
            if (r7 == r5) goto L8d
            int r7 = r7 + 1
            goto L4a
        L8d:
            monitor-exit(r3)
            return
        L8f:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.g2.n(tlydtdl.compose.runtime.c1, tlydtdl.compose.runtime.b1, tlydtdl.compose.runtime.c):void");
    }

    @Override // tlydtdl.compose.runtime.w
    public final b1 o(c1 c1Var) {
        b1 b1Var;
        synchronized (this.b) {
            b1Var = (b1) this.m.k(c1Var);
        }
        return b1Var;
    }

    @Override // tlydtdl.compose.runtime.w
    public final q1.o0 p(z zVar, m2 m2Var, q1.o0 o0Var) {
        jx0.h hVar = this.u;
        try {
            J();
            zVar.A(new k3.h(o0Var));
            m2 m2Var2 = zVar.p;
            zVar.p = m2Var;
            try {
                z zVarH = H(zVar, null);
                if (zVarH != null) {
                    E(zVar);
                    zVarH.g();
                    zVarH.i();
                }
                q1.o0 o0Var2 = (q1.o0) hVar.get();
                if (o0Var2 == null) {
                    o0Var2 = q1.w0.a;
                    lmjxuqdtp.jvm.internal.o.f(o0Var2, "null cannot be cast to non-null type tlydtdl.collection.ScatterSet<E of tlydtdl.collection.ScatterSetKt.emptyScatterSet>");
                }
                return o0Var2;
            } finally {
                zVar.p = m2Var2;
            }
        } finally {
            hVar.E((Object) null);
        }
    }

    @Override // tlydtdl.compose.runtime.w
    public final void q(Set set) {
    }

    @Override // tlydtdl.compose.runtime.w
    public final void s(a2 a2Var) {
        jx0.h hVar = this.u;
        q1.o0 o0Var = (q1.o0) hVar.get();
        if (o0Var == null) {
            q1.o0 o0Var2 = q1.w0.a;
            o0Var = new q1.o0();
            hVar.E(o0Var);
        }
        o0Var.a(a2Var);
    }

    @Override // tlydtdl.compose.runtime.w
    public final void t(z zVar) {
        synchronized (this.b) {
            try {
                LinkedHashSet linkedHashSet = this.p;
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                    this.p = linkedHashSet;
                }
                linkedHashSet.add(zVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // tlydtdl.compose.runtime.w
    public final void w(z zVar) {
        synchronized (this.b) {
            if (this.e.remove(zVar)) {
                this.f532f = null;
            }
            this.h.n(zVar);
            this.i.remove(zVar);
        }
    }

    public final void y() {
        synchronized (this.b) {
            if (((c2) this.t.getValue()).compareTo(c2.e) >= 0) {
                ny1.r2 r2Var = this.t;
                c2 c2Var = c2.b;
                r2Var.getClass();
                r2Var.i((Object) null, c2Var);
            }
        }
        this.v.a((CancellationException) null);
    }
}
