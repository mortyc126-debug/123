package w8;

import amuvvoafs.content.Context;
import amuvvoafs.os.Handler;
import amuvvoafs.os.HandlerThread;
import amuvvoafs.os.Looper;
import amuvvoafs.os.SystemClock;
import amuvvoafs.util.Pair;
import bb.z0;
import com.gnacba.amuvvoafs.gms.internal.ads.gy1;
import com.gnacba.amuvvoafs.gms.internal.ads.iy1;
import com.gnacba.amuvvoafs.gms.internal.ads.kp1;
import com.gnacba.amuvvoafs.gms.internal.ads.ox1;
import com.gnacba.amuvvoafs.gms.internal.ads.ps0;
import com.gnacba.amuvvoafs.gms.internal.ads.py1;
import com.gnacba.common.collect.h0;
import f3.f2;
import f9.b1;
import f9.y;
import i9.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import l8.o0;
import l8.t0;
import o8.f0;
import o8.z;
import tlydtdl.media3.exoplayer.ExoPlaybackException;
import v8.c1;
import x8.c;
import x8.g;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 implements Handler.Callback, y, g1 {
    public static final long b0 = f0.g0(10000);
    public o1 A;
    public f1 B;
    public ox1 C;
    public boolean D;
    public boolean F;
    public boolean G;
    public boolean I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;
    public j0 P;
    public long Q;
    public long R;
    public int S;
    public boolean T;
    public ExoPlaybackException U;
    public q W;
    public l8.k1 X;
    public boolean Z;
    public final py1[] a;
    public final l1[] b;
    public final boolean[] c;
    public final w d;
    public final i9.x e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f642f;
    public final j9.d g;
    public final o8.b0 h;
    public final iy1 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Looper f643j;
    public final l8.j1 k;
    public final l8.h1 l;
    public final long m;
    public final ps0 n;
    public final ArrayList o;
    public final o8.e p;
    public final v q;
    public final w0 r;
    public final gy1 s;
    public final h t;
    public final long u;
    public final x8.m v;
    public final g w;
    public final o8.b0 x;
    public final boolean y;
    public final kp1 z;
    public long Y = -9223372036854775807L;
    public boolean E = false;
    public float a0 = 1.0f;
    public long V = -9223372036854775807L;
    public long H = -9223372036854775807L;

    public k0(Context context, e[] eVarArr, e[] eVarArr2, w wVar, i9.x xVar, j jVar, j9.d dVar, int i, boolean z, g gVar, o1 o1Var, h hVar, long j2, Looper looper, o8.e eVar, v vVar, x8.m mVar, q qVar) {
        Looper looper2;
        this.q = vVar;
        this.d = wVar;
        this.e = xVar;
        this.f642f = jVar;
        this.g = dVar;
        this.J = i;
        this.K = z;
        this.A = o1Var;
        this.t = hVar;
        this.u = j2;
        boolean z2 = false;
        this.p = eVar;
        this.v = mVar;
        this.W = qVar;
        this.w = gVar;
        this.m = jVar.g;
        jVar.getClass();
        this.X = l8.k1.a;
        f1 f1VarJ = f1.j(xVar);
        this.B = f1VarJ;
        this.C = new ox1(f1VarJ);
        this.b = new l1[eVarArr.length];
        this.c = new boolean[eVarArr.length];
        k1 k1Var = (i9.r) wVar;
        k1Var.getClass();
        this.a = new py1[eVarArr.length];
        boolean z3 = false;
        for (int i2 = 0; i2 < eVarArr.length; i2++) {
            eVarArr[i2].init(i2, mVar, eVar);
            this.b[i2] = eVarArr[i2].getCapabilities();
            this.b[i2].setListener(k1Var);
            e eVar2 = eVarArr2[i2];
            if (eVar2 != null) {
                eVar2.init(eVarArr.length + i2, mVar, eVar);
                z3 = true;
            }
            this.a[i2] = new py1(i2, eVarArr[i2], eVarArr2[i2]);
        }
        this.y = z3;
        this.n = new ps0(this, eVar);
        this.o = new ArrayList();
        this.k = new l8.j1();
        this.l = new l8.h1();
        wVar.a = this;
        wVar.b = dVar;
        this.T = true;
        z zVar = (z) eVar;
        o8.b0 b0VarA = zVar.a(looper, (Handler.Callback) null);
        this.x = b0VarA;
        this.r = new w0(gVar, b0VarA, new z0(25, this), qVar);
        this.s = new gy1(this, gVar, b0VarA, mVar);
        iy1 iy1Var = new iy1(1);
        this.i = iy1Var;
        synchronized (iy1Var.a) {
            try {
                if (iy1Var.b == null) {
                    if (iy1Var.d == 0 && iy1Var.c == null) {
                        z2 = true;
                    }
                    o8.b.h(z2);
                    HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                    iy1Var.c = handlerThread;
                    handlerThread.start();
                    iy1Var.b = iy1Var.c.getLooper();
                }
                iy1Var.d++;
                looper2 = iy1Var.b;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f643j = looper2;
        this.h = zVar.a(looper2, this);
        this.z = new kp1(context, looper2, this);
    }

    public static Pair O(l8.k1 k1Var, j0 j0Var, boolean z, int i, boolean z2, l8.j1 j1Var, l8.h1 h1Var) {
        int iP;
        l8.k1 k1Var2 = j0Var.a;
        if (k1Var.p()) {
            return null;
        }
        l8.k1 k1Var3 = k1Var2.p() ? k1Var : k1Var2;
        try {
            Pair pairI = k1Var3.i(j1Var, h1Var, j0Var.b, j0Var.c);
            if (!k1Var.equals(k1Var3)) {
                if (k1Var.b(pairI.first) == -1) {
                    if (!z || (iP = P(j1Var, h1Var, i, z2, pairI.first, k1Var3, k1Var)) == -1) {
                        return null;
                    }
                    return k1Var.i(j1Var, h1Var, iP, -9223372036854775807L);
                }
                if (k1Var3.g(pairI.first, h1Var).f295f && k1Var3.m(h1Var.c, j1Var, 0L).n == k1Var3.b(pairI.first)) {
                    return k1Var.i(j1Var, h1Var, k1Var.g(pairI.first, h1Var).c, j0Var.c);
                }
            }
            return pairI;
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public static int P(l8.j1 j1Var, l8.h1 h1Var, int i, boolean z, Object obj, l8.k1 k1Var, l8.k1 k1Var2) {
        l8.j1 j1Var2 = j1Var;
        l8.k1 k1Var3 = k1Var;
        Object obj2 = k1Var3.m(k1Var3.g(obj, h1Var).c, j1Var, 0L).a;
        for (int i2 = 0; i2 < k1Var2.o(); i2++) {
            if (k1Var2.m(i2, j1Var, 0L).a.equals(obj2)) {
                return i2;
            }
        }
        int iB = k1Var3.b(obj);
        int iH = k1Var3.h();
        int iB2 = -1;
        int i3 = 0;
        while (i3 < iH && iB2 == -1) {
            l8.k1 k1Var4 = k1Var3;
            int iD = k1Var4.d(iB, h1Var, j1Var2, i, z);
            if (iD == -1) {
                break;
            }
            iB2 = k1Var2.b(k1Var4.l(iD));
            i3++;
            k1Var3 = k1Var4;
            iB = iD;
            j1Var2 = j1Var;
        }
        if (iB2 == -1) {
            return -1;
        }
        return k1Var2.f(iB2, h1Var, false).c;
    }

    public static boolean w(u0 u0Var) {
        return (u0Var == null || u0Var.o() || u0Var.i() == Long.MIN_VALUE) ? false : true;
    }

    public final void A() {
        ox1 ox1Var = this.C;
        f1 f1Var = this.B;
        boolean z = ox1Var.a | (((f1) ox1Var.e) != f1Var);
        ox1Var.a = z;
        ox1Var.e = f1Var;
        if (z) {
            d0 d0Var = this.q.a;
            d0Var.f630j.d(new c1(3, d0Var, ox1Var));
            this.C = new ox1(this.B);
        }
    }

    public final void B(int i) {
        py1 py1Var = this.a[i];
        try {
            u0 u0Var = this.r.f647j;
            u0Var.getClass();
            e eVarC = py1Var.c(u0Var);
            eVarC.getClass();
            eVarC.maybeThrowStreamError();
        } catch (IOException | RuntimeException e) {
            int trackType = ((e) py1Var.e).getTrackType();
            if (trackType != 3 && trackType != 5) {
                throw e;
            }
            i9.x xVarM = this.r.f647j.m();
            o8.b.n("ExoPlayerImplInternal", "Disabling track due to error: " + l8.s.d(xVarM.c[i].q()), e);
            i9.x xVar = new i9.x((m1[]) xVarM.b.clone(), (i9.t[]) xVarM.c.clone(), xVarM.d, xVarM.e);
            xVar.b[i] = null;
            xVar.c[i] = null;
            e(i);
            this.r.f647j.a(xVar, this.B.s);
        }
    }

    public final void C(final int i, final boolean z) {
        boolean[] zArr = this.c;
        if (zArr[i] != z) {
            zArr[i] = z;
            this.x.d(new Runnable() { // from class: w8.e0
                @Override // java.lang.Runnable
                public final void run() {
                    k0 k0Var = this.a;
                    g gVar = k0Var.w;
                    py1[] py1VarArr = k0Var.a;
                    int i2 = i;
                    int trackType = ((e) py1VarArr[i2].e).getTrackType();
                    x8.a aVarT = gVar.t();
                    gVar.u(aVarT, 1033, new c(aVarT, i2, trackType, z));
                }
            });
        }
    }

    public final void D() throws Throwable {
        s(this.s.b(), true);
    }

    public final void E(h0 h0Var) throws Throwable {
        l8.k1 k1VarB;
        this.C.a(1);
        int i = h0Var.a;
        int i2 = h0Var.b;
        int i3 = h0Var.c;
        f9.c1 c1Var = h0Var.d;
        gy1 gy1Var = this.s;
        ArrayList arrayList = gy1Var.a;
        o8.b.c(i >= 0 && i <= i2 && i2 <= arrayList.size() && i3 >= 0);
        gy1Var.k = c1Var;
        if (i == i2 || i == i3) {
            k1VarB = gy1Var.b();
        } else {
            int iMin = Math.min(i, i3);
            int iMax = Math.max(((i2 - i) + i3) - 1, i2 - 1);
            int iO = ((e1) arrayList.get(iMin)).d;
            f0.T(arrayList, i, i2, i3);
            while (iMin <= iMax) {
                e1 e1Var = (e1) arrayList.get(iMin);
                e1Var.d = iO;
                iO += e1Var.a.E().o();
                iMin++;
            }
            k1VarB = gy1Var.b();
        }
        s(k1VarB, false);
    }

    public final void F(b1 b1Var) {
        this.h.a(9, (f9.z) b1Var).b();
    }

    public final void G() throws ExoPlaybackException {
        this.C.a(1);
        K(false, false, false, true);
        j jVar = this.f642f;
        HashMap map = jVar.h;
        long id = Thread.currentThread().getId();
        long j2 = jVar.i;
        o8.b.g("Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).", j2 == -1 || j2 == id);
        jVar.i = id;
        x8.m mVar = this.v;
        if (!map.containsKey(mVar)) {
            map.put(mVar, new i());
        }
        i iVar = (i) map.get(mVar);
        iVar.getClass();
        int i = jVar.f639f;
        if (i == -1) {
            i = 13107200;
        }
        iVar.b = i;
        iVar.a = false;
        g0(this.B.a.p() ? 4 : 2);
        f1 f1Var = this.B;
        boolean z = f1Var.l;
        r0(this.z.d(f1Var.e, z), f1Var.n, f1Var.m, z);
        j9.g gVar = this.g;
        gVar.getClass();
        gy1 gy1Var = this.s;
        ArrayList arrayList = gy1Var.a;
        o8.b.h(!gy1Var.f);
        gy1Var.l = gVar;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            e1 e1Var = (e1) arrayList.get(i2);
            gy1Var.e(e1Var);
            gy1Var.e.add(e1Var);
        }
        gy1Var.f = true;
        this.h.f(2);
    }

    public final void H() {
        i9.m mVar;
        try {
            K(true, false, true, false);
            py1[] py1VarArr = this.a;
            for (int i = 0; i < py1VarArr.length; i++) {
                this.b[i].clearListener();
                py1 py1Var = py1VarArr[i];
                ((e) py1Var.e).release();
                py1Var.c = false;
                e eVar = (e) py1Var.f;
                if (eVar != null) {
                    eVar.release();
                    py1Var.d = false;
                }
            }
            j jVar = this.f642f;
            if (jVar.h.remove(this.v) != null) {
                jVar.d();
            }
            if (jVar.h.isEmpty()) {
                jVar.i = -1L;
            }
            kp1 kp1Var = this.z;
            kp1Var.f = null;
            kp1Var.a();
            kp1Var.c(0);
            i9.r rVar = this.d;
            rVar.getClass();
            if (f0.a >= 32 && (mVar = rVar.h) != null) {
                mVar.e();
            }
            ((w) rVar).a = null;
            ((w) rVar).b = null;
            g0(1);
            this.i.a();
            synchronized (this) {
                this.D = true;
                notifyAll();
            }
        } catch (Throwable th) {
            this.i.a();
            synchronized (this) {
                this.D = true;
                notifyAll();
                throw th;
            }
        }
    }

    public final void I(int i, int i2, f9.c1 c1Var) throws Throwable {
        this.C.a(1);
        gy1 gy1Var = this.s;
        gy1Var.getClass();
        o8.b.c(i >= 0 && i <= i2 && i2 <= gy1Var.a.size());
        gy1Var.k = c1Var;
        gy1Var.g(i, i2);
        s(gy1Var.b(), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [w8.k0] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [int] */
    /* JADX WARN: Type inference failed for: r8v6 */
    public final void J() throws ExoPlaybackException {
        int i;
        boolean z;
        float f2 = this.n.getPlaybackParameters().a;
        w0 w0Var = this.r;
        u0 u0VarH = w0Var.f647j;
        u0 u0Var = w0Var.k;
        i9.x xVar = null;
        boolean z2 = true;
        while (u0VarH != null && u0VarH.f) {
            f1 f1Var = this.B;
            i9.x xVarU = u0VarH.u(f2, f1Var.a, f1Var.l);
            i9.x xVar2 = u0VarH == this.r.f647j ? xVarU : xVar;
            i9.x xVarM = u0VarH.m();
            i9.t[] tVarArr = xVarU.c;
            boolean z3 = false;
            if (xVarM != null && xVarM.c.length == tVarArr.length) {
                for (int i2 = 0; i2 < tVarArr.length; i2++) {
                    if (xVarU.a(xVarM, i2)) {
                    }
                }
                if (u0VarH == u0Var) {
                    z2 = false;
                }
                u0VarH = u0VarH.h();
                xVar = xVar2;
            }
            if (z2) {
                w0 w0Var2 = this.r;
                u0 u0Var2 = w0Var2.f647j;
                boolean z4 = (w0Var2.p(u0Var2) & 1) != 0;
                boolean[] zArr = new boolean[this.a.length];
                xVar2.getClass();
                long jB = u0Var2.b(xVar2, this.B.s, z4, zArr);
                f1 f1Var2 = this.B;
                if (f1Var2.e == 4 || jB == f1Var2.s) {
                    z = false;
                } else {
                    z = false;
                    z3 = true;
                }
                f1 f1Var3 = this.B;
                boolean z5 = z;
                i = 4;
                this.B = v(f1Var3.b, jB, f1Var3.c, f1Var3.d, z3, 5);
                if (z3) {
                    M(jB);
                }
                d();
                boolean[] zArr2 = new boolean[this.a.length];
                ?? r82 = z5;
                while (true) {
                    py1[] py1VarArr = this.a;
                    if (r82 >= py1VarArr.length) {
                        break;
                    }
                    int iB = py1VarArr[r82].b();
                    zArr2[r82] = this.a[r82].f();
                    py1 py1Var = this.a[r82];
                    f9.z0 z0Var = u0Var2.c[r82];
                    ps0 ps0Var = this.n;
                    long j2 = this.Q;
                    boolean z6 = zArr[r82];
                    e eVar = (e) py1Var.e;
                    if (py1.g(eVar)) {
                        if (z0Var != eVar.getStream()) {
                            py1Var.a(eVar, ps0Var);
                        } else if (z6) {
                            eVar.resetPosition(j2);
                        }
                    }
                    e eVar2 = (e) py1Var.f;
                    if (eVar2 != null && py1.g(eVar2)) {
                        if (z0Var != eVar2.getStream()) {
                            py1Var.a(eVar2, ps0Var);
                        } else if (z6) {
                            eVar2.resetPosition(j2);
                        }
                    }
                    if (iB - this.a[r82].b() > 0) {
                        C(r82, z5);
                    }
                    this.O -= iB - this.a[r82].b();
                    r82++;
                }
                h(zArr2, this.Q);
                u0Var2.i = true;
            } else {
                i = 4;
                this.r.p(u0VarH);
                if (u0VarH.f) {
                    long jMax = Math.max(u0VarH.h.b, u0VarH.x(this.Q));
                    if (this.y && b() && this.r.l == u0VarH) {
                        d();
                    }
                    u0VarH.a(xVarU, jMax);
                }
            }
            r(true);
            if (this.B.e != i) {
                y();
                s0();
                this.h.f(2);
                return;
            }
            return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void K(boolean r36, boolean r37, boolean r38, boolean r39) {
        /*
            Method dump skipped, instruction units count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.k0.K(boolean, boolean, boolean, boolean):void");
    }

    public final void L() {
        u0 u0Var = this.r.f647j;
        this.F = u0Var != null && u0Var.h.i && this.E;
    }

    public final void M(long j2) throws ExoPlaybackException {
        u0 u0Var = this.r.f647j;
        long jY = u0Var == null ? j2 + 1000000000000L : u0Var.y(j2);
        this.Q = jY;
        ((bb.g0) this.n.c).a(jY);
        for (py1 py1Var : this.a) {
            long j3 = this.Q;
            e eVarC = py1Var.c(u0Var);
            if (eVarC != null) {
                eVarC.resetPosition(j3);
            }
        }
        for (u0 u0VarH = r0.f647j; u0VarH != null; u0VarH = u0VarH.h()) {
            for (i9.t tVar : u0VarH.m().c) {
                if (tVar != null) {
                    tVar.i();
                }
            }
        }
    }

    public final void N(l8.k1 k1Var, l8.k1 k1Var2) {
        if (k1Var.p() && k1Var2.p()) {
            return;
        }
        ArrayList arrayList = this.o;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
        } else {
            f2.y(arrayList.get(size));
            throw null;
        }
    }

    public final void Q(long j2) {
        this.h.a.sendEmptyMessageAtTime(2, j2 + ((this.B.e != 3 || j0()) ? b0 : 1000L));
    }

    public final void R(boolean z) throws ExoPlaybackException {
        f9.b0 b0Var = this.r.f647j.h.a;
        long jT = T(b0Var, this.B.s, true, false);
        if (jT != this.B.s) {
            f1 f1Var = this.B;
            this.B = v(b0Var, jT, f1Var.c, f1Var.d, z, 5);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:36|(10:(9:103|38|(1:46)(1:44)|47|(1:54)|55|56|57|58)(1:61)|96|79|80|105|81|82|83|57|58)|101|62|(1:64)(1:65)|66|(1:68)(1:70)|69|71|72|(1:74)(1:75)|76|99|77|78) */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0157, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0159, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x015a, code lost:
    
        r5 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a1 A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:22:0x0097, B:24:0x00a1, B:31:0x00ad, B:33:0x00b3, B:34:0x00b6, B:36:0x00be, B:40:0x00ce, B:44:0x00d6), top: B:98:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARN: Type inference failed for: r0v16, types: [f9.z, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void S(w8.j0 r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.k0.S(w8.j0):void");
    }

    /* JADX WARN: Type inference failed for: r10v8, types: [f9.z, java.lang.Object] */
    public final long T(f9.b0 b0Var, long j2, boolean z, boolean z2) throws ExoPlaybackException {
        py1[] py1VarArr;
        n0();
        u0(false, true);
        if (z2 || this.B.e == 3) {
            g0(2);
        }
        w0 w0Var = this.r;
        u0 u0Var = w0Var.f647j;
        u0 u0VarH = u0Var;
        while (u0VarH != null && !b0Var.equals(u0VarH.h.a)) {
            u0VarH = u0VarH.h();
        }
        if (z || u0Var != u0VarH || (u0VarH != null && u0VarH.y(j2) < 0)) {
            int i = 0;
            while (true) {
                py1VarArr = this.a;
                if (i >= py1VarArr.length) {
                    break;
                }
                e(i);
                i++;
            }
            this.Y = -9223372036854775807L;
            if (u0VarH != null) {
                while (w0Var.f647j != u0VarH) {
                    w0Var.a();
                }
                w0Var.p(u0VarH);
                u0VarH.w(1000000000000L);
                h(new boolean[py1VarArr.length], w0Var.k.k());
                u0VarH.i = true;
            }
        }
        d();
        if (u0VarH != null) {
            ?? r10 = u0VarH.a;
            w0Var.p(u0VarH);
            if (!u0VarH.f) {
                u0VarH.h = u0VarH.h.b(j2);
            } else if (u0VarH.g) {
                j2 = r10.d(j2);
                r10.k(j2 - this.m);
            }
            M(j2);
            y();
        } else {
            w0Var.b();
            M(j2);
        }
        r(false);
        this.h.f(2);
        return j2;
    }

    public final void U(i1 i1Var) {
        i1Var.getClass();
        o8.b0 b0Var = this.h;
        if (i1Var.e != this.f643j) {
            b0Var.a(15, i1Var).b();
            return;
        }
        synchronized (i1Var) {
        }
        try {
            i1Var.a.handleMessage(i1Var.c, i1Var.d);
            i1Var.a(true);
            int i = this.B.e;
            if (i == 3 || i == 2) {
                b0Var.f(2);
            }
        } catch (Throwable th) {
            i1Var.a(true);
            throw th;
        }
    }

    public final void V(i1 i1Var) {
        Looper looper = i1Var.e;
        if (looper.getThread().isAlive()) {
            this.p.a(looper, (Handler.Callback) null).d(new u0.c(this, i1Var));
        } else {
            o8.b.q("TAG", "Trying to send message on a dead thread.");
            i1Var.a(false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void W(l8.d r7, boolean r8) throws tlydtdl.media3.exoplayer.ExoPlaybackException {
        /*
            r6 = this;
            i9.w r0 = r6.d
            i9.r r0 = (i9.r) r0
            l8.d r1 = r0.i
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto Ld
            goto L12
        Ld:
            r0.i = r7
            r0.e()
        L12:
            if (r8 == 0) goto L15
            goto L16
        L15:
            r7 = 0
        L16:
            com.gnacba.amuvvoafs.gms.internal.ads.kp1 r8 = r6.z
            java.lang.Object r0 = r8.g
            l8.d r0 = (l8.d) r0
            boolean r0 = java.util.Objects.equals(r0, r7)
            if (r0 != 0) goto L55
            r8.g = r7
            r0 = 0
            r1 = 1
            if (r7 != 0) goto L2a
        L28:
            r3 = r0
            goto L49
        L2a:
            int r2 = r7.c
            r3 = 3
            r4 = 2
            java.lang.String r5 = "AudioFocusManager"
            switch(r2) {
                case 0: goto L43;
                case 1: goto L41;
                case 2: goto L3f;
                case 3: goto L28;
                case 4: goto L3f;
                case 5: goto L49;
                case 6: goto L49;
                case 7: goto L49;
                case 8: goto L49;
                case 9: goto L49;
                case 10: goto L49;
                case 11: goto L3b;
                case 12: goto L49;
                case 13: goto L49;
                case 14: goto L41;
                case 15: goto L33;
                case 16: goto L39;
                default: goto L33;
            }
        L33:
            java.lang.String r7 = "Unidentified audio usage: "
            o6.c.x(r2, r7, r5)
            goto L28
        L39:
            r3 = 4
            goto L49
        L3b:
            int r7 = r7.a
            if (r7 != r1) goto L49
        L3f:
            r3 = r4
            goto L49
        L41:
            r3 = r1
            goto L49
        L43:
            java.lang.String r7 = "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default."
            o8.b.q(r5, r7)
            goto L41
        L49:
            r8.c = r3
            if (r3 == r1) goto L4f
            if (r3 != 0) goto L50
        L4f:
            r0 = r1
        L50:
            java.lang.String r7 = "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME."
            o8.b.b(r7, r0)
        L55:
            w8.f1 r7 = r6.B
            boolean r0 = r7.l
            int r1 = r7.n
            int r2 = r7.m
            int r7 = r7.e
            int r7 = r8.d(r7, r0)
            r6.r0(r7, r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.k0.W(l8.d, boolean):void");
    }

    public final void X(AtomicBoolean atomicBoolean, boolean z) {
        if (this.L != z) {
            this.L = z;
            if (!z) {
                for (py1 py1Var : this.a) {
                    py1Var.k();
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    public final void Y(g0 g0Var) throws Throwable {
        this.C.a(1);
        int i = g0Var.c;
        f9.c1 c1Var = g0Var.b;
        ArrayList arrayList = g0Var.a;
        if (i != -1) {
            this.P = new j0(new j1(arrayList, c1Var), g0Var.c, g0Var.d);
        }
        gy1 gy1Var = this.s;
        ArrayList arrayList2 = gy1Var.a;
        gy1Var.g(0, arrayList2.size());
        s(gy1Var.a(arrayList2.size(), arrayList, c1Var), false);
    }

    public final void Z(boolean z) throws ExoPlaybackException {
        this.E = z;
        L();
        if (this.F) {
            w0 w0Var = this.r;
            if (w0Var.k != w0Var.f647j) {
                R(true);
                r(false);
            }
        }
    }

    public final void a(g0 g0Var, int i) throws Throwable {
        this.C.a(1);
        gy1 gy1Var = this.s;
        if (i == -1) {
            i = gy1Var.a.size();
        }
        s(gy1Var.a(i, g0Var.a, g0Var.b), false);
    }

    public final void a0(t0 t0Var) {
        this.h.e(16);
        ps0 ps0Var = this.n;
        ps0Var.setPlaybackParameters(t0Var);
        t0 playbackParameters = ps0Var.getPlaybackParameters();
        u(playbackParameters, playbackParameters.a, true, true);
    }

    public final boolean b() {
        if (!this.y) {
            return false;
        }
        for (py1 py1Var : this.a) {
            if (py1Var.e()) {
                return true;
            }
        }
        return false;
    }

    public final void b0(q qVar) {
        this.W = qVar;
        l8.k1 k1Var = this.B.a;
        w0 w0Var = this.r;
        w0Var.i = qVar;
        w0Var.j(k1Var);
    }

    public final void c() throws ExoPlaybackException {
        J();
        R(true);
    }

    public final void c0(int i) throws ExoPlaybackException {
        this.J = i;
        l8.k1 k1Var = this.B.a;
        w0 w0Var = this.r;
        w0Var.g = i;
        int iU = w0Var.u(k1Var);
        if ((iU & 1) != 0) {
            R(true);
        } else if ((iU & 2) != 0) {
            d();
        }
        r(false);
    }

    public final void d() {
        e eVar;
        if (this.y && b()) {
            for (py1 py1Var : this.a) {
                int iB = py1Var.b();
                if (py1Var.e()) {
                    int i = py1Var.b;
                    boolean z = i == 4 || i == 2;
                    int i2 = i != 4 ? 0 : 1;
                    if (z) {
                        eVar = (e) py1Var.e;
                    } else {
                        eVar = (e) py1Var.f;
                        eVar.getClass();
                    }
                    py1Var.a(eVar, this.n);
                    py1Var.i(z);
                    py1Var.b = i2;
                }
                this.O -= iB - py1Var.b();
            }
            this.Y = -9223372036854775807L;
        }
    }

    public final void d0(o1 o1Var) {
        this.A = o1Var;
    }

    public final void e(int i) {
        py1[] py1VarArr = this.a;
        int iB = py1VarArr[i].b();
        py1 py1Var = py1VarArr[i];
        e eVar = (e) py1Var.e;
        ps0 ps0Var = this.n;
        py1Var.a(eVar, ps0Var);
        e eVar2 = (e) py1Var.f;
        if (eVar2 != null) {
            boolean z = (eVar2.getState() == 0 || py1Var.b == 3) ? false : true;
            py1Var.a(eVar2, ps0Var);
            py1Var.i(false);
            if (z) {
                e eVar3 = (e) py1Var.e;
                eVar2.getClass();
                eVar2.handleMessage(17, eVar3);
            }
        }
        py1Var.b = 0;
        C(i, false);
        this.O -= iB;
    }

    public final void e0(boolean z) throws ExoPlaybackException {
        this.K = z;
        l8.k1 k1Var = this.B.a;
        w0 w0Var = this.r;
        w0Var.h = z;
        int iU = w0Var.u(k1Var);
        if ((iU & 1) != 0) {
            R(true);
        } else if ((iU & 2) != 0) {
            d();
        }
        r(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x020d A[EDGE_INSN: B:629:0x020d->B:104:0x020d BREAK  A[LOOP:10: B:114:0x0238->B:120:0x0251], EDGE_INSN: B:630:0x020d->B:104:0x020d BREAK  A[LOOP:10: B:114:0x0238->B:120:0x0251]] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x06be  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x075d  */
    /* JADX WARN: Removed duplicated region for block: B:497:0x0818  */
    /* JADX WARN: Removed duplicated region for block: B:528:0x0882  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x08bc  */
    /* JADX WARN: Removed duplicated region for block: B:549:0x08bf  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:550:0x08c7  */
    /* JADX WARN: Removed duplicated region for block: B:560:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:563:0x0907  */
    /* JADX WARN: Removed duplicated region for block: B:567:0x090e  */
    /* JADX WARN: Removed duplicated region for block: B:570:0x0915  */
    /* JADX WARN: Removed duplicated region for block: B:571:0x096e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01dc  */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27, types: [int] */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v66 */
    /* JADX WARN: Type inference failed for: r10v67 */
    /* JADX WARN: Type inference failed for: r10v68 */
    /* JADX WARN: Type inference failed for: r10v7, types: [int] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v46, types: [f9.z, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v71, types: [f9.z, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r44v0 */
    /* JADX WARN: Type inference failed for: r44v1 */
    /* JADX WARN: Type inference failed for: r44v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r44v3 */
    /* JADX WARN: Type inference failed for: r45v0, types: [w8.k0] */
    /* JADX WARN: Type inference failed for: r5v111, types: [java.lang.Object, w8.e, w8.h1] */
    /* JADX WARN: Type inference failed for: r5v141 */
    /* JADX WARN: Type inference failed for: r5v142 */
    /* JADX WARN: Type inference failed for: r5v143 */
    /* JADX WARN: Type inference failed for: r5v3, types: [f9.z, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v49 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v64, types: [f9.z, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v66 */
    /* JADX WARN: Type inference failed for: r5v68 */
    /* JADX WARN: Type inference failed for: r5v69, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v70 */
    /* JADX WARN: Type inference failed for: r5v72 */
    /* JADX WARN: Type inference failed for: r5v76 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v49, types: [java.lang.Object, w8.e, w8.h1] */
    /* JADX WARN: Type inference failed for: r6v55 */
    /* JADX WARN: Type inference failed for: r6v56 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34, types: [int] */
    /* JADX WARN: Type inference failed for: r7v58 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f() throws tlydtdl.media3.exoplayer.ExoPlaybackException {
        /*
            Method dump skipped, instruction units count: 2457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.k0.f():void");
    }

    public final void f0(f9.c1 c1Var) throws Throwable {
        this.C.a(1);
        gy1 gy1Var = this.s;
        int size = gy1Var.a.size();
        if (c1Var.b.length != size) {
            c1Var = new f9.c1(new Random(c1Var.a.nextLong())).a(0, size);
        }
        gy1Var.k = c1Var;
        s(gy1Var.b(), false);
    }

    public final void g(u0 u0Var, int i, boolean z, long j2) throws ExoPlaybackException {
        py1 py1Var = this.a[i];
        if (py1Var.f()) {
            return;
        }
        boolean z2 = u0Var == this.r.f647j;
        i9.x xVarM = u0Var.m();
        m1 m1Var = xVarM.b[i];
        i9.t tVar = xVarM.c[i];
        boolean z3 = j0() && this.B.e == 3;
        boolean z4 = !z && z3;
        this.O++;
        f9.z0 z0Var = u0Var.c[i];
        long j3 = this.Q;
        long j4 = u0Var.j();
        f9.b0 b0Var = u0Var.h.a;
        e eVar = (e) py1Var.f;
        int length = tVar != null ? tVar.length() : 0;
        l8.s[] sVarArr = new l8.s[length];
        for (int i2 = 0; i2 < length; i2++) {
            tVar.getClass();
            sVarArr[i2] = tVar.c(i2);
        }
        int i3 = py1Var.b;
        ps0 ps0Var = this.n;
        if (i3 == 0 || i3 == 2 || i3 == 4) {
            py1Var.c = true;
            ((e) py1Var.e).enable(m1Var, sVarArr, z0Var, j3, z4, z2, j2, j4, b0Var);
            ps0Var.d((e) py1Var.e);
        } else {
            py1Var.d = true;
            eVar.getClass();
            eVar.enable(m1Var, sVarArr, z0Var, j3, z4, z2, j2, j4, b0Var);
            ps0Var.d(eVar);
        }
        f0 f0Var = new f0(this);
        e eVarC = py1Var.c(u0Var);
        eVarC.getClass();
        eVarC.handleMessage(11, f0Var);
        if (z3 && z2) {
            py1Var.m();
        }
    }

    public final void g0(int i) {
        f1 f1Var = this.B;
        if (f1Var.e != i) {
            if (i != 2) {
                this.V = -9223372036854775807L;
            }
            this.B = f1Var.h(i);
        }
    }

    public final void h(boolean[] zArr, long j2) throws ExoPlaybackException {
        py1[] py1VarArr;
        long j3;
        u0 u0Var = this.r.k;
        i9.x xVarM = u0Var.m();
        int i = 0;
        while (true) {
            py1VarArr = this.a;
            if (i >= py1VarArr.length) {
                break;
            }
            if (!xVarM.b(i)) {
                py1VarArr[i].k();
            }
            i++;
        }
        int i2 = 0;
        while (i2 < py1VarArr.length) {
            if (xVarM.b(i2) && py1VarArr[i2].c(u0Var) == null) {
                j3 = j2;
                g(u0Var, i2, zArr[i2], j3);
            } else {
                j3 = j2;
            }
            i2++;
            j2 = j3;
        }
    }

    public final void h0(Object obj, AtomicBoolean atomicBoolean) {
        for (py1 py1Var : this.a) {
            e eVar = (e) py1Var.e;
            if (eVar.getTrackType() == 2) {
                int i = py1Var.b;
                if (i == 4 || i == 1) {
                    e eVar2 = (e) py1Var.f;
                    eVar2.getClass();
                    eVar2.handleMessage(1, obj);
                } else {
                    eVar.handleMessage(1, obj);
                }
            }
        }
        int i2 = this.B.e;
        if (i2 == 3 || i2 == 2) {
            this.h.f(2);
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0235  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(amuvvoafs.os.Message r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 760
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.k0.handleMessage(amuvvoafs.os.Message):boolean");
    }

    public final long i(l8.k1 k1Var, Object obj, long j2) {
        l8.h1 h1Var = this.l;
        int i = k1Var.g(obj, h1Var).c;
        l8.j1 j1Var = this.k;
        k1Var.n(i, j1Var);
        if (j1Var.f296f != -9223372036854775807L && j1Var.a() && j1Var.i) {
            return f0.U(f0.C(j1Var.g) - j1Var.f296f) - (j2 + h1Var.e);
        }
        return -9223372036854775807L;
    }

    public final void i0(float f2) {
        this.a0 = f2;
        float f3 = f2 * this.z.d;
        for (py1 py1Var : this.a) {
            e eVar = (e) py1Var.e;
            if (eVar.getTrackType() == 1) {
                eVar.handleMessage(2, Float.valueOf(f3));
                e eVar2 = (e) py1Var.f;
                if (eVar2 != null) {
                    eVar2.handleMessage(2, Float.valueOf(f3));
                }
            }
        }
    }

    public final long j(u0 u0Var) {
        if (u0Var == null) {
            return 0L;
        }
        long j2 = u0Var.j();
        if (!u0Var.f) {
            return j2;
        }
        int i = 0;
        while (true) {
            py1[] py1VarArr = this.a;
            if (i >= py1VarArr.length) {
                return j2;
            }
            if (py1VarArr[i].c(u0Var) != null) {
                e eVarC = py1VarArr[i].c(u0Var);
                Objects.requireNonNull(eVarC);
                long readingPositionUs = eVarC.getReadingPositionUs();
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j2 = Math.max(readingPositionUs, j2);
            }
            i++;
        }
    }

    public final boolean j0() {
        f1 f1Var = this.B;
        return f1Var.l && f1Var.n == 0;
    }

    public final Pair k(l8.k1 k1Var) {
        if (k1Var.p()) {
            return Pair.create(f1.u, 0L);
        }
        Pair pairI = k1Var.i(this.k, this.l, k1Var.a(this.K), -9223372036854775807L);
        f9.b0 b0VarS = this.r.s(k1Var, pairI.first, 0L);
        long jLongValue = ((Long) pairI.second).longValue();
        if (b0VarS.b()) {
            Object obj = b0VarS.a;
            l8.h1 h1Var = this.l;
            k1Var.g(obj, h1Var);
            jLongValue = b0VarS.c == h1Var.f(b0VarS.b) ? h1Var.g.b : 0L;
        }
        return Pair.create(b0VarS, Long.valueOf(jLongValue));
    }

    public final boolean k0(l8.k1 k1Var, f9.b0 b0Var) {
        if (b0Var.b() || k1Var.p()) {
            return false;
        }
        int i = k1Var.g(b0Var.a, this.l).c;
        l8.j1 j1Var = this.k;
        k1Var.n(i, j1Var);
        return j1Var.a() && j1Var.i && j1Var.f296f != -9223372036854775807L;
    }

    public final long l(long j2) {
        u0 u0Var = this.r.m;
        if (u0Var == null) {
            return 0L;
        }
        return Math.max(0L, j2 - u0Var.x(this.Q));
    }

    public final void l0() {
        u0 u0Var = this.r.f647j;
        if (u0Var == null) {
            return;
        }
        i9.x xVarM = u0Var.m();
        int i = 0;
        while (true) {
            py1[] py1VarArr = this.a;
            if (i >= py1VarArr.length) {
                return;
            }
            if (xVarM.b(i)) {
                py1VarArr[i].m();
            }
            i++;
        }
    }

    public final void m(int i) throws ExoPlaybackException {
        f1 f1Var = this.B;
        r0(i, f1Var.n, f1Var.m, f1Var.l);
    }

    public final void m0(boolean z, boolean z2) {
        K(z || !this.L, false, true, false);
        this.C.a(z2 ? 1 : 0);
        j jVar = this.f642f;
        if (jVar.h.remove(this.v) != null) {
            jVar.d();
        }
        this.z.d(1, this.B.l);
        g0(1);
    }

    public final void n() {
        i0(this.a0);
    }

    public final void n0() {
        ps0 ps0Var = this.n;
        ps0Var.b = false;
        bb.g0 g0Var = (bb.g0) ps0Var.c;
        if (g0Var.b) {
            g0Var.a(g0Var.getPositionUs());
            g0Var.b = false;
        }
        for (py1 py1Var : this.a) {
            e eVar = (e) py1Var.f;
            e eVar2 = (e) py1Var.e;
            if (py1.g(eVar2) && eVar2.getState() == 2) {
                eVar2.stop();
            }
            if (eVar != null && eVar.getState() != 0 && eVar.getState() == 2) {
                eVar.stop();
            }
        }
    }

    public final void o(f9.z zVar) {
        w0 w0Var = this.r;
        u0 u0Var = w0Var.m;
        if (u0Var != null && u0Var.a == zVar) {
            long j2 = this.Q;
            if (u0Var != null) {
                u0Var.s(j2);
            }
            y();
            return;
        }
        u0 u0Var2 = w0Var.n;
        if (u0Var2 == null || u0Var2.a != zVar) {
            return;
        }
        z();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [f9.b1, java.lang.Object] */
    public final void o0() {
        u0 u0Var = this.r.m;
        boolean z = this.I || (u0Var != null && u0Var.a.isLoading());
        f1 f1Var = this.B;
        if (z != f1Var.g) {
            this.B = f1Var.b(z);
        }
    }

    public final void p(f9.z zVar) {
        this.h.a(8, zVar).b();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void p0(i9.x xVar) {
        u0 u0Var = this.r.m;
        u0Var.getClass();
        l(u0Var.g());
        if (k0(this.B.a, u0Var.h.a)) {
            long j2 = this.t.h;
        }
        l8.k1 k1Var = this.B.a;
        float f2 = this.n.getPlaybackParameters().a;
        boolean z = this.B.l;
        i9.t[] tVarArr = xVar.c;
        j jVar = this.f642f;
        i iVar = (i) jVar.h.get(this.v);
        iVar.getClass();
        int iMax = jVar.f639f;
        if (iMax == -1) {
            int length = tVarArr.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = 13107200;
                if (i < length) {
                    i9.t tVar = tVarArr[i];
                    if (tVar != null) {
                        switch (tVar.m().c) {
                            case -2:
                                i3 = 0;
                                i2 += i3;
                                break;
                            case -1:
                            case 1:
                                i2 += i3;
                                break;
                            case 0:
                                i3 = 144310272;
                                i2 += i3;
                                break;
                            case 2:
                                i3 = 131072000;
                                i2 += i3;
                                break;
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                i3 = 131072;
                                i2 += i3;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    }
                    i++;
                } else {
                    iMax = Math.max(13107200, i2);
                }
            }
        }
        iVar.b = iMax;
        jVar.d();
    }

    public final void q(IOException iOException, int i) {
        ExoPlaybackException exoPlaybackException = new ExoPlaybackException(0, iOException, i);
        u0 u0Var = this.r.f647j;
        if (u0Var != null) {
            exoPlaybackException = exoPlaybackException.c(u0Var.h.a);
        }
        o8.b.n("ExoPlayerImplInternal", "Playback error", exoPlaybackException);
        m0(false, false);
        this.B = this.B.f(exoPlaybackException);
    }

    public final void q0(List list, int i, int i2) throws Throwable {
        this.C.a(1);
        gy1 gy1Var = this.s;
        gy1Var.getClass();
        ArrayList arrayList = gy1Var.a;
        o8.b.c(i >= 0 && i <= i2 && i2 <= arrayList.size());
        o8.b.c(list.size() == i2 - i);
        for (int i3 = i; i3 < i2; i3++) {
            ((e1) arrayList.get(i3)).a.u((l8.k0) list.get(i3 - i));
        }
        s(gy1Var.b(), false);
    }

    public final void r(boolean z) {
        u0 u0Var = this.r.m;
        f9.b0 b0Var = u0Var == null ? this.B.b : u0Var.h.a;
        boolean zEquals = this.B.k.equals(b0Var);
        if (!zEquals) {
            this.B = this.B.c(b0Var);
        }
        f1 f1Var = this.B;
        f1Var.q = u0Var == null ? f1Var.s : u0Var.g();
        f1 f1Var2 = this.B;
        f1Var2.r = l(f1Var2.q);
        if ((!zEquals || z) && u0Var != null && u0Var.f) {
            p0(u0Var.m());
        }
    }

    public final void r0(int i, int i2, int i3, boolean z) throws ExoPlaybackException {
        boolean z2 = z && i != -1;
        if (i == -1) {
            i3 = 2;
        } else if (i3 == 2) {
            i3 = 1;
        }
        if (i == 0) {
            i2 = 1;
        } else if (i2 == 1) {
            i2 = 0;
        }
        f1 f1Var = this.B;
        if (f1Var.l == z2 && f1Var.n == i2 && f1Var.m == i3) {
            return;
        }
        this.B = f1Var.e(i3, i2, z2);
        u0(false, false);
        w0 w0Var = this.r;
        for (u0 u0VarH = w0Var.f647j; u0VarH != null; u0VarH = u0VarH.h()) {
            for (i9.t tVar : u0VarH.m().c) {
                if (tVar != null) {
                    tVar.n(z2);
                }
            }
        }
        if (!j0()) {
            n0();
            s0();
            long j2 = this.Q;
            u0 u0Var = w0Var.m;
            if (u0Var != null) {
                u0Var.s(j2);
                return;
            }
            return;
        }
        int i4 = this.B.e;
        o8.b0 b0Var = this.h;
        if (i4 != 3) {
            if (i4 == 2) {
                b0Var.f(2);
            }
        } else {
            ps0 ps0Var = this.n;
            ps0Var.b = true;
            ((bb.g0) ps0Var.c).b();
            l0();
            b0Var.f(2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0204  */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13, types: [int] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [l8.k1] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r19v12 */
    /* JADX WARN: Type inference failed for: r19v13 */
    /* JADX WARN: Type inference failed for: r19v14 */
    /* JADX WARN: Type inference failed for: r19v24 */
    /* JADX WARN: Type inference failed for: r19v25 */
    /* JADX WARN: Type inference failed for: r19v26 */
    /* JADX WARN: Type inference failed for: r19v27 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r19v7 */
    /* JADX WARN: Type inference failed for: r19v8 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v12 */
    /* JADX WARN: Type inference failed for: r20v18 */
    /* JADX WARN: Type inference failed for: r20v19 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v20 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r20v7 */
    /* JADX WARN: Type inference failed for: r20v8 */
    /* JADX WARN: Type inference failed for: r2v14, types: [l8.k1] */
    /* JADX WARN: Type inference failed for: r2v19, types: [w8.f1] */
    /* JADX WARN: Type inference failed for: r37v0, types: [w8.k0] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s(l8.k1 r38, boolean r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1153
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.k0.s(l8.k1, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00d0  */
    /* JADX WARN: Type inference failed for: r2v21, types: [f9.z, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s0() throws tlydtdl.media3.exoplayer.ExoPlaybackException {
        /*
            Method dump skipped, instruction units count: 709
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.k0.s0():void");
    }

    public final void t(f9.z zVar) throws ExoPlaybackException {
        u0 u0Var;
        w0 w0Var = this.r;
        u0 u0Var2 = w0Var.m;
        ps0 ps0Var = this.n;
        if (u0Var2 != null && u0Var2.a == zVar) {
            u0Var2.getClass();
            if (!u0Var2.f) {
                float f2 = ps0Var.getPlaybackParameters().a;
                f1 f1Var = this.B;
                u0Var2.n(f2, f1Var.a, f1Var.l);
            }
            p0(u0Var2.m());
            if (u0Var2 == w0Var.f647j) {
                M(u0Var2.h.b);
                h(new boolean[this.a.length], w0Var.k.k());
                u0Var2.i = true;
                f1 f1Var2 = this.B;
                f9.b0 b0Var = f1Var2.b;
                long j2 = u0Var2.h.b;
                this.B = v(b0Var, j2, f1Var2.c, j2, false, 5);
            }
            y();
            return;
        }
        int i = 0;
        while (true) {
            if (i >= w0Var.r.size()) {
                u0Var = null;
                break;
            }
            u0Var = (u0) w0Var.r.get(i);
            if (u0Var.a == zVar) {
                break;
            } else {
                i++;
            }
        }
        if (u0Var != null) {
            o8.b.h(true ^ u0Var.f);
            float f3 = ps0Var.getPlaybackParameters().a;
            f1 f1Var3 = this.B;
            u0Var.n(f3, f1Var3.a, f1Var3.l);
            u0 u0Var3 = w0Var.n;
            if (u0Var3 == null || u0Var3.a != zVar) {
                return;
            }
            z();
        }
    }

    public final void t0(l8.k1 k1Var, f9.b0 b0Var, l8.k1 k1Var2, f9.b0 b0Var2, long j2, boolean z) {
        boolean zK0 = k0(k1Var, b0Var);
        Object obj = b0Var.a;
        if (!zK0) {
            t0 t0Var = b0Var.b() ? t0.d : this.B.o;
            ps0 ps0Var = this.n;
            if (ps0Var.getPlaybackParameters().equals(t0Var)) {
                return;
            }
            this.h.e(16);
            ps0Var.setPlaybackParameters(t0Var);
            u(this.B.o, t0Var.a, false, false);
            return;
        }
        l8.h1 h1Var = this.l;
        int i = k1Var.g(obj, h1Var).c;
        l8.j1 j1Var = this.k;
        k1Var.n(i, j1Var);
        l8.f0 f0Var = j1Var.f297j;
        h hVar = this.t;
        hVar.getClass();
        hVar.c = f0.U(f0Var.a);
        hVar.f635f = f0.U(f0Var.b);
        hVar.g = f0.U(f0Var.c);
        float f2 = f0Var.d;
        if (f2 == -3.4028235E38f) {
            f2 = 0.97f;
        }
        hVar.f636j = f2;
        float f3 = f0Var.e;
        if (f3 == -3.4028235E38f) {
            f3 = 1.03f;
        }
        hVar.i = f3;
        if (f2 == 1.0f && f3 == 1.0f) {
            hVar.c = -9223372036854775807L;
        }
        hVar.a();
        if (j2 != -9223372036854775807L) {
            hVar.d = i(k1Var, obj, j2);
            hVar.a();
            return;
        }
        if (!Objects.equals(!k1Var2.p() ? k1Var2.m(k1Var2.g(b0Var2.a, h1Var).c, j1Var, 0L).a : null, j1Var.a) || z) {
            hVar.d = -9223372036854775807L;
            hVar.a();
        }
    }

    public final void u(t0 t0Var, float f2, boolean z, boolean z2) {
        int i;
        if (z) {
            if (z2) {
                this.C.a(1);
            }
            this.B = this.B.g(t0Var);
        }
        float f3 = t0Var.a;
        u0 u0VarH = this.r.f647j;
        while (true) {
            i = 0;
            if (u0VarH == null) {
                break;
            }
            i9.t[] tVarArr = u0VarH.m().c;
            int length = tVarArr.length;
            while (i < length) {
                i9.t tVar = tVarArr[i];
                if (tVar != null) {
                    tVar.g(f3);
                }
                i++;
            }
            u0VarH = u0VarH.h();
        }
        py1[] py1VarArr = this.a;
        int length2 = py1VarArr.length;
        while (i < length2) {
            py1 py1Var = py1VarArr[i];
            float f4 = t0Var.a;
            ((e) py1Var.e).setPlaybackSpeed(f2, f4);
            e eVar = (e) py1Var.f;
            if (eVar != null) {
                eVar.setPlaybackSpeed(f2, f4);
            }
            i++;
        }
    }

    public final void u0(boolean z, boolean z2) {
        long jElapsedRealtime;
        this.G = z;
        if (!z || z2) {
            jElapsedRealtime = -9223372036854775807L;
        } else {
            this.p.getClass();
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        this.H = jElapsedRealtime;
    }

    public final f1 v(f9.b0 b0Var, long j2, long j3, long j4, boolean z, int i) {
        com.gnacba.common.collect.f1 f1VarG;
        boolean z2;
        this.T = (!this.T && j2 == this.B.s && b0Var.equals(this.B.b)) ? false : true;
        L();
        f1 f1Var = this.B;
        f9.l1 l1VarL = f1Var.h;
        i9.x xVarM = f1Var.i;
        com.gnacba.common.collect.f1 f1Var2 = f1Var.f634j;
        if (this.s.f) {
            u0 u0Var = this.r.f647j;
            l1VarL = u0Var == null ? f9.l1.d : u0Var.l();
            xVarM = u0Var == null ? this.e : u0Var.m();
            i9.t[] tVarArr = xVarM.c;
            com.gnacba.common.collect.g0 g0Var = new com.gnacba.common.collect.g0(4);
            boolean z3 = false;
            for (i9.t tVar : tVarArr) {
                if (tVar != null) {
                    l8.p0 p0Var = tVar.c(0).l;
                    if (p0Var == null) {
                        g0Var.a(new l8.p0(new o0[0]));
                    } else {
                        g0Var.a(p0Var);
                        z3 = true;
                    }
                }
            }
            if (z3) {
                f1VarG = g0Var.g();
            } else {
                h0 h0Var = com.gnacba.common.collect.k0.b;
                f1VarG = com.gnacba.common.collect.f1.e;
            }
            f1Var2 = f1VarG;
            if (u0Var != null) {
                v0 v0Var = u0Var.h;
                if (v0Var.c != j3) {
                    u0Var.h = v0Var.a(j3);
                }
            }
            py1[] py1VarArr = this.a;
            w0 w0Var = this.r;
            u0 u0Var2 = w0Var.f647j;
            if (u0Var2 == w0Var.k && u0Var2 != null) {
                i9.x xVarM2 = u0Var2.m();
                int i2 = 0;
                boolean z4 = false;
                while (true) {
                    if (i2 >= py1VarArr.length) {
                        z2 = true;
                        break;
                    }
                    if (xVarM2.b(i2)) {
                        if (((e) py1VarArr[i2].e).getTrackType() != 1) {
                            z2 = false;
                            break;
                        }
                        if (xVarM2.b[i2].a != 0) {
                            z4 = true;
                        }
                    }
                    i2++;
                }
                boolean z5 = z4 && z2;
                if (z5 != this.N) {
                    this.N = z5;
                    if (!z5 && this.B.p) {
                        this.h.f(2);
                    }
                }
            }
        } else if (!b0Var.equals(f1Var.b)) {
            l1VarL = f9.l1.d;
            xVarM = this.e;
            f1Var2 = com.gnacba.common.collect.f1.e;
        }
        f9.l1 l1Var = l1VarL;
        i9.x xVar = xVarM;
        com.gnacba.common.collect.f1 f1Var3 = f1Var2;
        if (z) {
            ox1 ox1Var = this.C;
            if (!ox1Var.c || ox1Var.d == 5) {
                ox1Var.a = true;
                ox1Var.c = true;
                ox1Var.d = i;
            } else {
                o8.b.c(i == 5);
            }
        }
        f1 f1Var4 = this.B;
        return f1Var4.d(b0Var, j2, j3, j4, l(f1Var4.q), l1Var, xVar, f1Var3);
    }

    public final synchronized void v0(xs1.m mVar, long j2) {
        this.p.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j2;
        boolean z = false;
        while (!((Boolean) mVar.get()).booleanValue() && j2 > 0) {
            try {
                this.p.getClass();
                wait(j2);
            } catch (InterruptedException unused) {
                z = true;
            }
            this.p.getClass();
            j2 = jElapsedRealtime - SystemClock.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public final boolean x() {
        u0 u0Var = this.r.f647j;
        long j2 = u0Var.h.e;
        if (u0Var.f) {
            return j2 == -9223372036854775807L || this.B.s < j2 || !j0();
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [f9.z, java.lang.Object] */
    public final void y() {
        boolean zC;
        if (w(this.r.m)) {
            u0 u0Var = this.r.m;
            long jL = l(u0Var.i());
            u0 u0Var2 = this.r.f647j;
            long j2 = k0(this.B.a, u0Var.h.a) ? this.t.h : -9223372036854775807L;
            x8.m mVar = this.v;
            l8.k1 k1Var = this.B.a;
            float f2 = this.n.getPlaybackParameters().a;
            boolean z = this.B.l;
            m0 m0Var = new m0(mVar, jL, f2, this.G, j2);
            zC = this.f642f.c(m0Var);
            u0 u0Var3 = this.r.f647j;
            if (!zC && u0Var3.f && jL < 500000 && this.m > 0) {
                u0Var3.a.k(this.B.s);
                zC = this.f642f.c(m0Var);
            }
        } else {
            zC = false;
        }
        this.I = zC;
        if (zC) {
            u0 u0Var4 = this.r.m;
            u0Var4.getClass();
            n0 n0Var = new n0();
            n0Var.c(u0Var4.x(this.Q));
            n0Var.d(this.n.getPlaybackParameters().a);
            n0Var.b(this.H);
            u0Var4.d(n0Var.a());
        }
        o0();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [f9.b1, java.lang.Object] */
    public final void z() {
        w0 w0Var = this.r;
        w0Var.m();
        u0 u0Var = w0Var.n;
        if (u0Var != null) {
            ?? r12 = u0Var.a;
            if ((!u0Var.e || u0Var.f) && !r12.isLoading()) {
                l8.k1 k1Var = this.B.a;
                if (u0Var.f) {
                    r12.n();
                }
                Iterator it = this.f642f.h.values().iterator();
                while (it.hasNext()) {
                    if (((i) it.next()).a) {
                        return;
                    }
                }
                if (!u0Var.e) {
                    u0Var.r(this, u0Var.h.b);
                    return;
                }
                n0 n0Var = new n0();
                n0Var.c(u0Var.x(this.Q));
                n0Var.d(this.n.getPlaybackParameters().a);
                n0Var.b(this.H);
                u0Var.d(n0Var.a());
            }
        }
    }
}
