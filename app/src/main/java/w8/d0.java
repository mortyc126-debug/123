package w8;

import amuvvoafs.content.Context;
import amuvvoafs.graphics.Rect;
import amuvvoafs.graphics.SurfaceTexture;
import amuvvoafs.net.Uri;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.Handler;
import amuvvoafs.os.Looper;
import amuvvoafs.util.Pair;
import amuvvoafs.util.SparseBooleanArray;
import amuvvoafs.view.Surface;
import amuvvoafs.view.SurfaceHolder;
import amuvvoafs.view.SurfaceView;
import amuvvoafs.view.TextureView;
import av1.g;
import bb.z0;
import com.gnacba.amuvvoafs.gms.internal.ads.ox1;
import com.gnacba.amuvvoafs.gms.internal.ads.pg0;
import com.gnacba.amuvvoafs.gms.internal.ads.py0;
import com.gnacba.common.collect.h0;
import f9.c1;
import i9.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import l8.a2;
import l8.b1;
import l8.m0;
import l8.n0;
import l8.s1;
import l8.t0;
import l8.v0;
import l8.x0;
import l8.y0;
import n8.c;
import o8.f0;
import o8.y;
import o8.z;
import tlydtdl.compose.foundation.lazy.layout.q1;
import tlydtdl.media3.common.PlaybackException;
import tlydtdl.media3.exoplayer.ExoPlaybackException;
import tlydtdl.media3.exoplayer.ExoPlayer;
import tlydtdl.media3.exoplayer.ExoTimeoutException;
import tlydtdl.media3.exoplayer.image.ImageOutput;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends l8.f implements ExoPlayer {
    public final q1 A;
    public final py0 B;
    public final py0 C;
    public final long D;
    public final g E;
    public int F;
    public boolean G;
    public int H;
    public int I;
    public boolean J;
    public c1 K;
    public q L;
    public v0 M;
    public n0 N;
    public n0 O;
    public Object P;
    public Surface Q;
    public SurfaceHolder R;
    public m9.k S;
    public boolean T;
    public TextureView U;
    public final int V;
    public y W;
    public l8.d X;
    public float Y;
    public boolean Z;
    public c a0;
    public final i9.x b;
    public final boolean b0;
    public final v0 c;
    public boolean c0;
    public final py0 d = new py0(5);
    public final int d0;
    public final Context e;
    public boolean e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d0 f629f;
    public final l8.l f0;
    public final e[] g;
    public a2 g0;
    public final e[] h;
    public n0 h0;
    public final w i;
    public f1 i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o8.b0 f630j;
    public int j0;
    public final v k;
    public long k0;
    public final k0 l;
    public final pg0 m;
    public final CopyOnWriteArraySet n;
    public final l8.h1 o;
    public final ArrayList p;
    public final boolean q;
    public final f9.a0 r;
    public final x8.g s;
    public final Looper t;
    public final j9.d u;
    public final long v;
    public final long w;
    public final long x;
    public final a0 y;
    public final b0 z;

    static {
        l8.l0.a("media3.exoplayer");
    }

    public d0(p pVar) {
        try {
            o8.b.p("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.6.1] [" + f0.b + "]");
            Context context = pVar.a;
            this.e = context.getApplicationContext();
            t4.j jVar = pVar.h;
            o8.e eVar = pVar.b;
            jVar.getClass();
            this.s = new x8.g(eVar);
            this.d0 = pVar.f645j;
            this.X = pVar.k;
            this.V = pVar.l;
            this.Z = false;
            this.D = pVar.t;
            a0 a0Var = new a0(this);
            this.y = a0Var;
            this.z = new b0();
            Handler handler = new Handler(pVar.i);
            n1 n1Var = (n1) pVar.c.get();
            e[] eVarArrB = n1Var.b(handler, a0Var, a0Var, a0Var, a0Var);
            this.g = eVarArrB;
            o8.b.h(eVarArrB.length > 0);
            this.h = new e[eVarArrB.length];
            int i = 0;
            while (true) {
                e[] eVarArr = this.h;
                if (i >= eVarArr.length) {
                    break;
                }
                n1Var.a(this.g[i]);
                eVarArr[i] = null;
                i++;
            }
            w wVar = (w) pVar.e.get();
            this.i = wVar;
            this.r = (f9.a0) pVar.d.get();
            j9.g gVar = (j9.d) pVar.g.get();
            this.u = gVar;
            this.q = pVar.m;
            o1 o1Var = pVar.n;
            this.v = pVar.o;
            this.w = pVar.p;
            this.x = pVar.q;
            Looper looper = pVar.i;
            this.t = looper;
            z zVar = pVar.b;
            this.f629f = this;
            this.m = new pg0(looper, zVar, new v(this));
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.n = copyOnWriteArraySet;
            this.p = new ArrayList();
            this.K = new c1();
            this.L = q.b;
            e[] eVarArr2 = this.g;
            i9.x xVar = new i9.x(new m1[eVarArr2.length], new i9.t[eVarArr2.length], s1.b, (Object) null);
            this.b = xVar;
            this.o = new l8.h1();
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            int[] iArr = {1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32};
            int length = iArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = iArr[i2];
                o8.b.h(!false);
                sparseBooleanArray.append(i3, true);
                i2++;
                wVar = wVar;
            }
            w wVar2 = wVar;
            wVar2.getClass();
            o8.b.h(!false);
            sparseBooleanArray.append(29, true);
            o8.b.h(!false);
            l8.q qVar = new l8.q(sparseBooleanArray);
            this.c = new v0(qVar);
            SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray();
            for (int i4 = 0; i4 < qVar.a.size(); i4++) {
                int iB = qVar.b(i4);
                o8.b.h(!false);
                sparseBooleanArray2.append(iB, true);
            }
            o8.b.h(!false);
            sparseBooleanArray2.append(4, true);
            o8.b.h(!false);
            sparseBooleanArray2.append(10, true);
            o8.b.h(!false);
            this.M = new v0(new l8.q(sparseBooleanArray2));
            this.f630j = zVar.a(looper, (Handler.Callback) null);
            v vVar = new v(this);
            this.k = vVar;
            this.i0 = f1.j(xVar);
            this.s.v(this, looper);
            x8.m mVar = new x8.m(pVar.w);
            k0 k0Var = new k0(this.e, this.g, this.h, wVar2, xVar, (j) pVar.f644f.get(), gVar, this.F, this.G, this.s, o1Var, pVar.r, pVar.s, looper, zVar, vVar, mVar, this.L);
            this.l = k0Var;
            Looper looper2 = k0Var.f643j;
            this.Y = 1.0f;
            this.F = 0;
            n0 n0Var = n0.K;
            this.N = n0Var;
            this.O = n0Var;
            this.h0 = n0Var;
            this.j0 = -1;
            this.a0 = c.c;
            this.b0 = true;
            x0(this.s);
            Handler handler2 = new Handler(looper);
            x8.g gVar2 = this.s;
            j9.g gVar3 = gVar;
            gVar3.getClass();
            gVar2.getClass();
            dd.b bVar = gVar3.c;
            bVar.getClass();
            CopyOnWriteArrayList<j9.c> copyOnWriteArrayList = (CopyOnWriteArrayList) bVar.b;
            for (j9.c cVar : copyOnWriteArrayList) {
                if (cVar.b == gVar2) {
                    cVar.c = true;
                    copyOnWriteArrayList.remove(cVar);
                }
            }
            copyOnWriteArrayList.add(new j9.c(handler2, gVar2));
            copyOnWriteArraySet.add(this.y);
            if (f0.a >= 31) {
                zVar.a(k0Var.f643j, (Handler.Callback) null).d(new pt1.x(this.e, pVar.u, this, mVar));
            }
            g gVar4 = new g(0, looper2, looper, zVar, new v(this));
            this.E = gVar4;
            ((o8.b0) gVar4.b).d(new tlydtdl.lifecycle.w0(21, this));
            q1 q1Var = new q1(pVar.a, looper2, pVar.i, this.y, zVar);
            this.A = q1Var;
            q1Var.i(false);
            this.B = new py0(context, looper2, zVar, 6);
            this.C = new py0(context, looper2, zVar, 7);
            this.f0 = l8.l.e;
            this.g0 = a2.d;
            this.W = y.c;
            k0Var.h.b(31, this.X, 0, 0).b();
            g1(1, 3, this.X);
            g1(2, 4, Integer.valueOf(this.V));
            g1(2, 5, 0);
            g1(1, 9, Boolean.valueOf(this.Z));
            g1(2, 7, this.z);
            g1(6, 8, this.z);
            g1(-1, 16, Integer.valueOf(this.d0));
            this.d.g();
        } catch (Throwable th) {
            this.d.g();
            throw th;
        }
    }

    public static long X0(f1 f1Var) {
        l8.j1 j1Var = new l8.j1();
        l8.h1 h1Var = new l8.h1();
        f1Var.a.g(f1Var.b.a, h1Var);
        long j2 = f1Var.c;
        return j2 == -9223372036854775807L ? f1Var.a.m(h1Var.c, j1Var, 0L).l : h1Var.e + j2;
    }

    public static f1 Y0(f1 f1Var, int i) {
        f1 f1VarH = f1Var.h(i);
        return (i == 1 || i == 4) ? f1VarH.b(false) : f1VarH;
    }

    @Override // l8.f, l8.z0
    public final long A0() {
        r1();
        return o(this.i0);
    }

    @Override // l8.z0
    public final void B0(int i, List list) {
        r1();
        ArrayList arrayListL = l(list);
        r1();
        o8.b.c(i >= 0);
        ArrayList arrayList = this.p;
        int iMin = Math.min(i, arrayList.size());
        if (!arrayList.isEmpty()) {
            p1(g(this.i0, iMin, arrayListL), 0, false, 5, -9223372036854775807L, -1, false);
            return;
        }
        boolean z = this.j0 == -1;
        r1();
        i1(arrayListL, -1, -9223372036854775807L, z);
    }

    @Override // l8.z0
    public final void C(int i, boolean z) {
        r1();
    }

    @Override // l8.f, l8.z0
    public final long C0() {
        r1();
        if (!u()) {
            return M0();
        }
        f1 f1Var = this.i0;
        return f1Var.k.equals(f1Var.b) ? f0.g0(this.i0.q) : getDuration();
    }

    @Override // l8.z0
    public final void D() {
        r1();
    }

    @Override // l8.z0
    public final void E(int i) {
        r1();
    }

    @Override // l8.z0
    public final void F(SurfaceView surfaceView) {
        r1();
        if (surfaceView instanceof l9.s) {
            f1();
            l1(surfaceView);
            j1(surfaceView.getHolder());
            return;
        }
        boolean z = surfaceView instanceof m9.k;
        a0 a0Var = this.y;
        if (z) {
            f1();
            this.S = (m9.k) surfaceView;
            i1 i1VarM = m(this.z);
            o8.b.h(!i1VarM.f638f);
            i1VarM.c = 10000;
            m9.k kVar = this.S;
            o8.b.h(true ^ i1VarM.f638f);
            i1VarM.d = kVar;
            i1VarM.b();
            this.S.a(a0Var);
            l1(this.S.getVideoSurface());
            j1(surfaceView.getHolder());
            return;
        }
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        r1();
        if (holder == null) {
            k();
            return;
        }
        f1();
        this.T = true;
        this.R = holder;
        holder.addCallback(a0Var);
        Surface surface = holder.getSurface();
        if (surface == null || !surface.isValid()) {
            l1(null);
            b1(0, 0);
        } else {
            l1(surface);
            Rect surfaceFrame = holder.getSurfaceFrame();
            b1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // l8.z0
    public final n0 F0() {
        r1();
        return this.O;
    }

    @Override // l8.z0
    public final void G(l8.d dVar, boolean z) {
        r1();
        if (this.e0) {
            return;
        }
        boolean zEquals = Objects.equals(this.X, dVar);
        pg0 pg0Var = this.m;
        if (!zEquals) {
            this.X = dVar;
            g1(1, 3, dVar);
            pg0Var.c(20, new z0(24, dVar));
        }
        this.l.h.b(31, this.X, z ? 1 : 0, 0).b();
        pg0Var.b();
    }

    @Override // l8.z0
    public final int G0() {
        r1();
        int iV0 = V0(this.i0);
        if (iV0 == -1) {
            return 0;
        }
        return iV0;
    }

    @Override // l8.z0
    public final void H0(SurfaceView surfaceView) {
        r1();
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        r1();
        if (holder == null || holder != this.R) {
            return;
        }
        k();
    }

    @Override // l8.z0
    public final void I(int i, int i2) {
        r1();
        o8.b.c(i >= 0 && i2 >= i);
        int size = this.p.size();
        int iMin = Math.min(i2, size);
        if (i >= size || i == iMin) {
            return;
        }
        f1 f1VarD1 = d1(this.i0, i, iMin);
        p1(f1VarD1, 0, !f1VarD1.b.a.equals(this.i0.b.a), 4, U0(f1VarD1), -1, false);
    }

    @Override // l8.z0
    public final void J0(int i, int i2, int i3) {
        r1();
        o8.b.c(i >= 0 && i <= i2 && i3 >= 0);
        ArrayList arrayList = this.p;
        int size = arrayList.size();
        int iMin = Math.min(i2, size);
        int iMin2 = Math.min(i3, size - (iMin - i));
        if (i >= size || i == iMin || i == iMin2) {
            return;
        }
        l8.k1 k1VarA0 = a0();
        this.H++;
        f0.T(arrayList, i, iMin, iMin2);
        j1 j1Var = new j1(arrayList, this.K);
        f1 f1Var = this.i0;
        f1 f1VarZ0 = Z0(f1Var, j1Var, W0(k1VarA0, j1Var, V0(f1Var), o(this.i0)));
        c1 c1Var = this.K;
        k0 k0Var = this.l;
        k0Var.getClass();
        k0Var.h.a(19, new h0(i, iMin, iMin2, c1Var)).b();
        p1(f1VarZ0, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // l8.z0
    public final PlaybackException K() {
        r1();
        return this.i0.f633f;
    }

    @Override // l8.z0
    public final void L(boolean z) {
        r1();
        o1(1, z);
    }

    @Override // l8.z0
    public final boolean L0() {
        r1();
        return false;
    }

    @Override // l8.z0
    public final void M(x0 x0Var) {
        r1();
        x0Var.getClass();
        this.m.e(x0Var);
    }

    @Override // l8.f, l8.z0
    public final long M0() {
        r1();
        if (this.i0.a.p()) {
            return this.k0;
        }
        f1 f1Var = this.i0;
        if (f1Var.k.d != f1Var.b.d) {
            return f0.g0(f1Var.a.m(G0(), this.a, 0L).m);
        }
        long j2 = f1Var.q;
        if (this.i0.k.b()) {
            f1 f1Var2 = this.i0;
            l8.h1 h1VarG = f1Var2.a.g(f1Var2.k.a, this.o);
            long jD = h1VarG.d(this.i0.k.b);
            j2 = jD == Long.MIN_VALUE ? h1VarG.d : jD;
        }
        f1 f1Var3 = this.i0;
        l8.k1 k1Var = f1Var3.a;
        Object obj = f1Var3.k.a;
        l8.h1 h1Var = this.o;
        k1Var.g(obj, h1Var);
        return f0.g0(j2 + h1Var.e);
    }

    @Override // l8.z0
    public final void N0(int i) {
        r1();
    }

    @Override // l8.z0
    public final void P(int i) {
        r1();
    }

    @Override // l8.z0
    public final s1 Q() {
        r1();
        return this.i0.i.d;
    }

    @Override // l8.z0
    public final n0 Q0() {
        r1();
        return this.N;
    }

    @Override // l8.z0
    public final void R0(List list) {
        r1();
        ArrayList arrayListL = l(list);
        r1();
        i1(arrayListL, -1, -9223372036854775807L, true);
    }

    @Override // l8.z0
    public final c S() {
        r1();
        return this.a0;
    }

    @Override // l8.z0
    public final long S0() {
        r1();
        return this.v;
    }

    @Override // l8.z0
    public final void T(l8.q1 q1Var) {
        r1();
        i9.r rVar = this.i;
        rVar.getClass();
        if (q1Var.equals(rVar.d())) {
            return;
        }
        rVar.a(q1Var);
        this.m.f(19, new w(q1Var, 0));
    }

    @Override // l8.z0
    public final int U() {
        r1();
        if (u()) {
            return this.i0.b.b;
        }
        return -1;
    }

    public final long U0(f1 f1Var) {
        if (f1Var.a.p()) {
            return f0.U(this.k0);
        }
        long jK = f1Var.p ? f1Var.k() : f1Var.s;
        if (f1Var.b.b()) {
            return jK;
        }
        l8.k1 k1Var = f1Var.a;
        Object obj = f1Var.b.a;
        l8.h1 h1Var = this.o;
        k1Var.g(obj, h1Var);
        return jK + h1Var.e;
    }

    public final int V0(f1 f1Var) {
        return f1Var.a.p() ? this.j0 : f1Var.a.g(f1Var.b.a, this.o).c;
    }

    @Override // l8.z0
    public final void W(boolean z) {
        r1();
    }

    public final Pair W0(l8.k1 k1Var, j1 j1Var, int i, long j2) {
        if (k1Var.p() || j1Var.p()) {
            boolean z = !k1Var.p() && j1Var.p();
            return a1(j1Var, z ? -1 : i, z ? -9223372036854775807L : j2);
        }
        Pair pairI = k1Var.i(this.a, this.o, i, f0.U(j2));
        Object obj = pairI.first;
        if (j1Var.b(obj) != -1) {
            return pairI;
        }
        int iP = k0.P(this.a, this.o, this.F, this.G, obj, k1Var, j1Var);
        if (iP == -1) {
            return a1(j1Var, -1, -9223372036854775807L);
        }
        l8.j1 j1Var2 = this.a;
        j1Var.m(iP, j1Var2, 0L);
        return a1(j1Var, iP, f0.g0(j1Var2.l));
    }

    @Override // l8.z0
    public final void X(List list, int i, int i2) {
        r1();
        o8.b.c(i >= 0 && i2 >= i);
        ArrayList arrayList = this.p;
        int size = arrayList.size();
        if (i > size) {
            return;
        }
        int iMin = Math.min(i2, size);
        if (iMin - i == list.size()) {
            for (int i3 = i; i3 < iMin; i3++) {
                if (c0.c((c0) arrayList.get(i3)).c((l8.k0) list.get(i3 - i))) {
                }
            }
            this.H++;
            this.l.h.b(27, list, i, iMin).b();
            for (int i4 = i; i4 < iMin; i4++) {
                c0 c0Var = (c0) arrayList.get(i4);
                c0Var.d(new f9.k1(c0Var.b(), (l8.k0) list.get(i4 - i)));
            }
            p1(this.i0.i(new j1(arrayList, this.K)), 0, false, 4, -9223372036854775807L, -1, false);
            return;
        }
        ArrayList arrayListL = l(list);
        if (!arrayList.isEmpty()) {
            f1 f1VarD1 = d1(g(this.i0, iMin, arrayListL), i, iMin);
            p1(f1VarD1, 0, !f1VarD1.b.a.equals(this.i0.b.a), 4, U0(f1VarD1), -1, false);
        } else {
            boolean z = this.j0 == -1;
            r1();
            i1(arrayListL, -1, -9223372036854775807L, z);
        }
    }

    @Override // l8.z0
    public final int Z() {
        r1();
        return this.i0.n;
    }

    public final f1 Z0(f1 f1Var, l8.k1 k1Var, Pair pair) {
        com.gnacba.common.collect.f1 f1Var2;
        o8.b.c(k1Var.p() || pair != null);
        l8.k1 k1Var2 = f1Var.a;
        long jO = o(f1Var);
        f1 f1VarI = f1Var.i(k1Var);
        if (k1Var.p()) {
            f9.b0 b0Var = f1.u;
            long jU = f0.U(this.k0);
            f1 f1VarC = f1VarI.d(b0Var, jU, jU, jU, 0L, f9.l1.d, this.b, com.gnacba.common.collect.f1.e).c(b0Var);
            f1VarC.q = f1VarC.s;
            return f1VarC;
        }
        Object obj = f1VarI.b.a;
        int i = f0.a;
        boolean zEquals = obj.equals(pair.first);
        f9.b0 b0Var2 = !zEquals ? new f9.b0(pair.first) : f1VarI.b;
        long jLongValue = ((Long) pair.second).longValue();
        long jU2 = f0.U(jO);
        if (!k1Var2.p()) {
            jU2 -= k1Var2.g(obj, this.o).e;
        }
        if (!zEquals || jLongValue < jU2) {
            f9.b0 b0Var3 = b0Var2;
            o8.b.h(!b0Var3.b());
            f9.l1 l1Var = !zEquals ? f9.l1.d : f1VarI.h;
            i9.x xVar = !zEquals ? this.b : f1VarI.i;
            if (zEquals) {
                f1Var2 = f1VarI.f634j;
            } else {
                h0 h0Var = com.gnacba.common.collect.k0.b;
                f1Var2 = com.gnacba.common.collect.f1.e;
            }
            f1 f1VarC2 = f1VarI.d(b0Var3, jLongValue, jLongValue, jLongValue, 0L, l1Var, xVar, f1Var2).c(b0Var3);
            f1VarC2.q = jLongValue;
            return f1VarC2;
        }
        if (jLongValue != jU2) {
            f9.b0 b0Var4 = b0Var2;
            o8.b.h(!b0Var4.b());
            long jMax = Math.max(0L, f1VarI.r - (jLongValue - jU2));
            long j2 = f1VarI.q;
            if (f1VarI.k.equals(f1VarI.b)) {
                j2 = jLongValue + jMax;
            }
            f1 f1VarD = f1VarI.d(b0Var4, jLongValue, jLongValue, jLongValue, jMax, f1VarI.h, f1VarI.i, f1VarI.f634j);
            f1VarD.q = j2;
            return f1VarD;
        }
        int iB = k1Var.b(f1VarI.k.a);
        if (iB != -1 && k1Var.f(iB, this.o, false).c == k1Var.g(b0Var2.a, this.o).c) {
            return f1VarI;
        }
        k1Var.g(b0Var2.a, this.o);
        long jA = b0Var2.b() ? this.o.a(b0Var2.b, b0Var2.c) : this.o.d;
        f9.b0 b0Var5 = b0Var2;
        f1 f1VarC3 = f1VarI.d(b0Var5, f1VarI.s, f1VarI.s, f1VarI.d, jA - f1VarI.s, f1VarI.h, f1VarI.i, f1VarI.f634j).c(b0Var5);
        f1VarC3.q = jA;
        return f1VarC3;
    }

    @Override // l8.z0
    public final l8.k1 a0() {
        r1();
        return this.i0.a;
    }

    public final Pair a1(l8.k1 k1Var, int i, long j2) {
        if (k1Var.p()) {
            this.j0 = i;
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            this.k0 = j2;
            return null;
        }
        if (i == -1 || i >= k1Var.o()) {
            i = k1Var.a(this.G);
            j2 = f0.g0(k1Var.m(i, this.a, 0L).l);
        }
        return k1Var.i(this.a, this.o, i, f0.U(j2));
    }

    @Override // l8.z0
    public final Looper b0() {
        return this.t;
    }

    public final void b1(int i, int i2) {
        y yVar = this.W;
        if (i == yVar.a && i2 == yVar.b) {
            return;
        }
        this.W = new y(i, i2);
        this.m.f(24, new u(i, i2, 0));
        g1(2, 14, new y(i, i2));
    }

    @Override // l8.f
    public final void c(long j2, int i, boolean z) {
        r1();
        if (i == -1) {
            return;
        }
        o8.b.c(i >= 0);
        l8.k1 k1Var = this.i0.a;
        if (k1Var.p() || i < k1Var.o()) {
            x8.g gVar = this.s;
            if (!gVar.i) {
                x8.a aVarP = gVar.p();
                gVar.i = true;
                gVar.u(aVarP, -1, new x8.c(aVarP));
            }
            this.H++;
            if (u()) {
                o8.b.q("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                ox1 ox1Var = new ox1(this.i0);
                ox1Var.a(1);
                d0 d0Var = this.k.a;
                d0Var.f630j.d(new v8.c1(3, d0Var, ox1Var));
                return;
            }
            f1 f1VarH = this.i0;
            int i2 = f1VarH.e;
            if (i2 == 3 || (i2 == 4 && !k1Var.p())) {
                f1VarH = this.i0.h(2);
            }
            int iG0 = G0();
            f1 f1VarZ0 = Z0(f1VarH, k1Var, a1(k1Var, i, j2));
            this.l.h.a(3, new j0(k1Var, i, f0.U(j2))).b();
            p1(f1VarZ0, 0, true, 1, U0(f1VarZ0), iG0, z);
        }
    }

    @Override // l8.z0
    public final void c0() {
        r1();
    }

    public final void c1() {
        boolean z;
        o8.b.p("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.6.1] [" + f0.b + "] [" + l8.l0.b() + "]");
        r1();
        this.A.i(false);
        this.B.h(false);
        this.C.h(false);
        k0 k0Var = this.l;
        synchronized (k0Var) {
            if (k0Var.D || !k0Var.f643j.getThread().isAlive()) {
                z = true;
            } else {
                k0Var.h.f(7);
                k0Var.v0(new f9.n(3, k0Var), k0Var.u);
                z = k0Var.D;
            }
        }
        if (!z) {
            this.m.f(10, new tt1.a(16));
        }
        this.m.d();
        this.f630j.a.removeCallbacksAndMessages((Object) null);
        j9.g gVar = this.u;
        x8.g gVar2 = this.s;
        CopyOnWriteArrayList<j9.c> copyOnWriteArrayList = (CopyOnWriteArrayList) gVar.c.b;
        for (j9.c cVar : copyOnWriteArrayList) {
            if (cVar.b == gVar2) {
                cVar.c = true;
                copyOnWriteArrayList.remove(cVar);
            }
        }
        f1 f1Var = this.i0;
        if (f1Var.p) {
            this.i0 = f1Var.a();
        }
        f1 f1VarY0 = Y0(this.i0, 1);
        this.i0 = f1VarY0;
        f1 f1VarC = f1VarY0.c(f1VarY0.b);
        this.i0 = f1VarC;
        f1VarC.q = f1VarC.s;
        this.i0.r = 0L;
        x8.g gVar3 = this.s;
        o8.b0 b0Var = gVar3.h;
        o8.b.i(b0Var);
        b0Var.d(new u0.c(16, gVar3));
        f1();
        Surface surface = this.Q;
        if (surface != null) {
            surface.release();
            this.Q = null;
        }
        this.a0 = c.c;
        this.e0 = true;
    }

    @Override // l8.z0
    public final l8.q1 d0() {
        r1();
        return this.i.d();
    }

    public final f1 d1(f1 f1Var, int i, int i2) {
        int iV0 = V0(f1Var);
        long jO = o(f1Var);
        l8.k1 k1Var = f1Var.a;
        ArrayList arrayList = this.p;
        int size = arrayList.size();
        this.H++;
        e1(i, i2);
        j1 j1Var = new j1(arrayList, this.K);
        f1 f1VarZ0 = Z0(f1Var, j1Var, W0(k1Var, j1Var, iV0, jO));
        int i3 = f1VarZ0.e;
        if (i3 != 1 && i3 != 4 && i < i2 && i2 == size && iV0 >= f1VarZ0.a.o()) {
            f1VarZ0 = Y0(f1VarZ0, 4);
        }
        this.l.h.b(20, this.K, i, i2).b();
        return f1VarZ0;
    }

    @Override // l8.z0
    public final void e0(int i, long j2, List list) {
        r1();
        ArrayList arrayListL = l(list);
        r1();
        i1(arrayListL, i, j2, false);
    }

    public final void e1(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.p.remove(i3);
        }
        c1 c1Var = this.K;
        int i4 = i2 - i;
        int[] iArr = c1Var.b;
        int[] iArr2 = new int[iArr.length - i4];
        int i6 = 0;
        for (int i7 = 0; i7 < iArr.length; i7++) {
            int i8 = iArr[i7];
            if (i8 < i || i8 >= i2) {
                int i9 = i7 - i6;
                if (i8 >= i) {
                    i8 -= i4;
                }
                iArr2[i9] = i8;
            } else {
                i6++;
            }
        }
        this.K = new c1(iArr2, new Random(c1Var.a.nextLong()));
    }

    public final ArrayList f(int i, List list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            e1 e1Var = new e1((f9.a) list.get(i2), this.q);
            arrayList.add(e1Var);
            c0 c0Var = new c0(e1Var.b, e1Var.a);
            this.p.add(i2 + i, c0Var);
        }
        this.K = this.K.a(i, arrayList.size());
        return arrayList;
    }

    public final void f1() {
        m9.k kVar = this.S;
        a0 a0Var = this.y;
        if (kVar != null) {
            i1 i1VarM = m(this.z);
            o8.b.h(!i1VarM.f638f);
            i1VarM.c = 10000;
            o8.b.h(!i1VarM.f638f);
            i1VarM.d = null;
            i1VarM.b();
            this.S.b(a0Var);
            this.S = null;
        }
        TextureView textureView = this.U;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != a0Var) {
                o8.b.q("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.U.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            this.U = null;
        }
        SurfaceHolder surfaceHolder = this.R;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(a0Var);
            this.R = null;
        }
    }

    public final f1 g(f1 f1Var, int i, ArrayList arrayList) {
        l8.k1 k1Var = f1Var.a;
        this.H++;
        ArrayList arrayListF = f(i, arrayList);
        j1 j1Var = new j1(this.p, this.K);
        f1 f1VarZ0 = Z0(f1Var, j1Var, W0(k1Var, j1Var, V0(f1Var), o(f1Var)));
        this.l.h.b(18, new g0(arrayListF, this.K, -1, -9223372036854775807L), i, 0).b();
        return f1VarZ0;
    }

    @Override // l8.z0
    public final void g0(TextureView textureView) {
        r1();
        if (textureView == null) {
            k();
            return;
        }
        f1();
        this.U = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            o8.b.q("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.y);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            l1(null);
            b1(0, 0);
        } else {
            Surface surface = new Surface(surfaceTexture);
            l1(surface);
            this.Q = surface;
            b1(textureView.getWidth(), textureView.getHeight());
        }
    }

    public final void g1(int i, int i2, Object obj) {
        for (e eVar : this.g) {
            if (i == -1 || eVar.getTrackType() == i) {
                i1 i1VarM = m(eVar);
                o8.b.h(!i1VarM.f638f);
                i1VarM.c = i2;
                o8.b.h(!i1VarM.f638f);
                i1VarM.d = obj;
                i1VarM.b();
            }
        }
        for (e eVar2 : this.h) {
            if (eVar2 != null && (i == -1 || eVar2.getTrackType() == i)) {
                i1 i1VarM2 = m(eVar2);
                o8.b.h(!i1VarM2.f638f);
                i1VarM2.c = i2;
                o8.b.h(!i1VarM2.f638f);
                i1VarM2.d = obj;
                i1VarM2.b();
            }
        }
    }

    @Override // l8.z0
    public final long getCurrentPosition() {
        r1();
        return f0.g0(U0(this.i0));
    }

    @Override // l8.f, l8.z0
    public final long getDuration() {
        r1();
        if (!u()) {
            return o0();
        }
        f1 f1Var = this.i0;
        f9.b0 b0Var = f1Var.b;
        l8.k1 k1Var = f1Var.a;
        Object obj = b0Var.a;
        l8.h1 h1Var = this.o;
        k1Var.g(obj, h1Var);
        return f0.g0(h1Var.a(b0Var.b, b0Var.c));
    }

    @Override // l8.z0
    public final t0 getPlaybackParameters() {
        r1();
        return this.i0.o;
    }

    @Override // l8.z0
    public final float getVolume() {
        r1();
        return this.Y;
    }

    @Override // l8.z0
    public final void h() {
        r1();
        f1 f1Var = this.i0;
        if (f1Var.e != 1) {
            return;
        }
        f1 f1VarF = f1Var.f(null);
        f1 f1VarY0 = Y0(f1VarF, f1VarF.a.p() ? 4 : 2);
        this.H++;
        o8.b0 b0Var = this.l.h;
        b0Var.getClass();
        o8.a0 a0VarC = o8.b0.c();
        a0VarC.a = b0Var.a.obtainMessage(29);
        a0VarC.b();
        p1(f1VarY0, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // l8.z0
    public final int h0() {
        r1();
        return 0;
    }

    public final void h1(boolean z) {
        r1();
        if (this.e0) {
            return;
        }
        this.A.i(z);
    }

    public final n0 i() {
        l8.k1 k1VarA0 = a0();
        if (k1VarA0.p()) {
            return this.h0;
        }
        l8.k0 k0Var = k1VarA0.m(G0(), this.a, 0L).c;
        m0 m0VarA = this.h0.a();
        n0 n0Var = k0Var.d;
        if (n0Var != null) {
            com.gnacba.common.collect.k0 k0Var2 = n0Var.J;
            byte[] bArr = n0Var.k;
            CharSequence charSequence = n0Var.a;
            if (charSequence != null) {
                m0VarA.a = charSequence;
            }
            CharSequence charSequence2 = n0Var.b;
            if (charSequence2 != null) {
                m0VarA.b = charSequence2;
            }
            CharSequence charSequence3 = n0Var.c;
            if (charSequence3 != null) {
                m0VarA.c = charSequence3;
            }
            CharSequence charSequence4 = n0Var.d;
            if (charSequence4 != null) {
                m0VarA.d = charSequence4;
            }
            CharSequence charSequence5 = n0Var.e;
            if (charSequence5 != null) {
                m0VarA.e = charSequence5;
            }
            CharSequence charSequence6 = n0Var.f304f;
            if (charSequence6 != null) {
                m0VarA.f302f = charSequence6;
            }
            CharSequence charSequence7 = n0Var.g;
            if (charSequence7 != null) {
                m0VarA.g = charSequence7;
            }
            Long l = n0Var.h;
            if (l != null) {
                m0VarA.c(l);
            }
            b1 b1Var = n0Var.i;
            if (b1Var != null) {
                m0VarA.i = b1Var;
            }
            b1 b1Var2 = n0Var.f305j;
            if (b1Var2 != null) {
                m0VarA.f303j = b1Var2;
            }
            Uri uri = n0Var.m;
            if (uri != null || bArr != null) {
                m0VarA.m = uri;
                m0VarA.b(bArr, n0Var.l);
            }
            Integer num = n0Var.n;
            if (num != null) {
                m0VarA.n = num;
            }
            Integer num2 = n0Var.o;
            if (num2 != null) {
                m0VarA.o = num2;
            }
            Integer num3 = n0Var.p;
            if (num3 != null) {
                m0VarA.p = num3;
            }
            Boolean bool = n0Var.q;
            if (bool != null) {
                m0VarA.q = bool;
            }
            Boolean bool2 = n0Var.r;
            if (bool2 != null) {
                m0VarA.r = bool2;
            }
            Integer num4 = n0Var.s;
            if (num4 != null) {
                m0VarA.s = num4;
            }
            Integer num5 = n0Var.t;
            if (num5 != null) {
                m0VarA.s = num5;
            }
            Integer num6 = n0Var.u;
            if (num6 != null) {
                m0VarA.t = num6;
            }
            Integer num7 = n0Var.v;
            if (num7 != null) {
                m0VarA.u = num7;
            }
            Integer num8 = n0Var.w;
            if (num8 != null) {
                m0VarA.v = num8;
            }
            Integer num9 = n0Var.x;
            if (num9 != null) {
                m0VarA.w = num9;
            }
            Integer num10 = n0Var.y;
            if (num10 != null) {
                m0VarA.x = num10;
            }
            CharSequence charSequence8 = n0Var.z;
            if (charSequence8 != null) {
                m0VarA.y = charSequence8;
            }
            CharSequence charSequence9 = n0Var.A;
            if (charSequence9 != null) {
                m0VarA.z = charSequence9;
            }
            CharSequence charSequence10 = n0Var.B;
            if (charSequence10 != null) {
                m0VarA.A = charSequence10;
            }
            Integer num11 = n0Var.C;
            if (num11 != null) {
                m0VarA.B = num11;
            }
            Integer num12 = n0Var.D;
            if (num12 != null) {
                m0VarA.C = num12;
            }
            CharSequence charSequence11 = n0Var.E;
            if (charSequence11 != null) {
                m0VarA.D = charSequence11;
            }
            CharSequence charSequence12 = n0Var.F;
            if (charSequence12 != null) {
                m0VarA.E = charSequence12;
            }
            CharSequence charSequence13 = n0Var.G;
            if (charSequence13 != null) {
                m0VarA.F = charSequence13;
            }
            Integer num13 = n0Var.H;
            if (num13 != null) {
                m0VarA.G = num13;
            }
            Bundle bundle = n0Var.I;
            if (bundle != null) {
                m0VarA.H = bundle;
            }
            if (!k0Var2.isEmpty()) {
                m0VarA.I = com.gnacba.common.collect.k0.o(k0Var2);
            }
        }
        return new n0(m0VarA);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i1(java.util.List r16, int r17, long r18, boolean r20) {
        /*
            r15 = this;
            r1 = r17
            w8.f1 r2 = r15.i0
            int r2 = r15.V0(r2)
            long r3 = r15.getCurrentPosition()
            int r5 = r15.H
            r6 = 1
            int r5 = r5 + r6
            r15.H = r5
            java.util.ArrayList r5 = r15.p
            boolean r7 = r5.isEmpty()
            r8 = 0
            if (r7 != 0) goto L22
            int r7 = r5.size()
            r15.e1(r8, r7)
        L22:
            r7 = r16
            java.util.ArrayList r10 = r15.f(r8, r7)
            w8.j1 r7 = new w8.j1
            f9.c1 r9 = r15.K
            r7.<init>(r5, r9)
            boolean r5 = r7.p()
            int r9 = r7.g
            if (r5 != 0) goto L40
            if (r1 >= r9) goto L3a
            goto L40
        L3a:
            tlydtdl.media3.common.IllegalSeekPositionException r1 = new tlydtdl.media3.common.IllegalSeekPositionException
            r1.<init>()
            throw r1
        L40:
            r5 = -1
            if (r20 == 0) goto L50
            boolean r1 = r15.G
            int r1 = r7.a(r1)
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L4e:
            r12 = r1
            goto L58
        L50:
            if (r1 != r5) goto L55
            r12 = r2
            r2 = r3
            goto L58
        L55:
            r2 = r18
            goto L4e
        L58:
            w8.f1 r1 = r15.i0
            amuvvoafs.util.Pair r4 = r15.a1(r7, r12, r2)
            w8.f1 r1 = r15.Z0(r1, r7, r4)
            int r4 = r1.e
            if (r12 == r5) goto L74
            if (r4 == r6) goto L74
            boolean r4 = r7.p()
            if (r4 != 0) goto L73
            if (r12 < r9) goto L71
            goto L73
        L71:
            r4 = 2
            goto L74
        L73:
            r4 = 4
        L74:
            w8.f1 r1 = Y0(r1, r4)
            long r13 = o8.f0.U(r2)
            f9.c1 r11 = r15.K
            w8.k0 r2 = r15.l
            o8.b0 r2 = r2.h
            w8.g0 r9 = new w8.g0
            r9.<init>(r10, r11, r12, r13)
            r3 = 17
            o8.a0 r2 = r2.a(r3, r9)
            r2.b()
            w8.f1 r2 = r15.i0
            f9.b0 r2 = r2.b
            java.lang.Object r2 = r2.a
            f9.b0 r3 = r1.b
            java.lang.Object r3 = r3.a
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto Lac
            w8.f1 r2 = r15.i0
            l8.k1 r2 = r2.a
            boolean r2 = r2.p()
            if (r2 != 0) goto Lac
            r3 = r6
            goto Lad
        Lac:
            r3 = r8
        Lad:
            long r5 = r15.U0(r1)
            r7 = -1
            r8 = 0
            r2 = 0
            r4 = 4
            r0 = r15
            r0.p1(r1, r2, r3, r4, r5, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.d0.i1(java.util.List, int, long, boolean):void");
    }

    @Override // l8.z0
    public final boolean isLoading() {
        r1();
        return this.i0.g;
    }

    @Override // l8.z0
    public final int j() {
        r1();
        return this.F;
    }

    public final void j1(SurfaceHolder surfaceHolder) {
        this.T = false;
        this.R = surfaceHolder;
        surfaceHolder.addCallback(this.y);
        Surface surface = this.R.getSurface();
        if (surface == null || !surface.isValid()) {
            b1(0, 0);
        } else {
            Rect surfaceFrame = this.R.getSurfaceFrame();
            b1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public final void k() {
        r1();
        f1();
        l1(null);
        b1(0, 0);
    }

    @Override // l8.z0
    public final v0 k0() {
        r1();
        return this.M;
    }

    public final void k1(q qVar) {
        r1();
        if (this.L.equals(qVar)) {
            return;
        }
        this.L = qVar;
        this.l.h.a(28, qVar).b();
    }

    public final ArrayList l(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.r.d((l8.k0) list.get(i)));
        }
        return arrayList;
    }

    @Override // l8.z0
    public final boolean l0() {
        r1();
        return this.i0.l;
    }

    public final void l1(Object obj) {
        Object obj2 = this.P;
        boolean z = true;
        boolean z2 = (obj2 == null || obj2 == obj) ? false : true;
        long j2 = z2 ? this.D : -9223372036854775807L;
        k0 k0Var = this.l;
        synchronized (k0Var) {
            if (!k0Var.D && k0Var.f643j.getThread().isAlive()) {
                AtomicBoolean atomicBoolean = new AtomicBoolean();
                k0Var.h.a(30, new Pair(obj, atomicBoolean)).b();
                if (j2 != -9223372036854775807L) {
                    k0Var.v0(new f9.n(4, atomicBoolean), j2);
                    z = atomicBoolean.get();
                }
            }
        }
        if (z2) {
            Object obj3 = this.P;
            Surface surface = this.Q;
            if (obj3 == surface) {
                surface.release();
                this.Q = null;
            }
        }
        this.P = obj;
        if (z) {
            return;
        }
        m1(new ExoPlaybackException(2, new ExoTimeoutException(3), 1003));
    }

    public final i1 m(h1 h1Var) {
        int iV0 = V0(this.i0);
        l8.k1 k1Var = this.i0.a;
        if (iV0 == -1) {
            iV0 = 0;
        }
        k0 k0Var = this.l;
        return new i1(k0Var, h1Var, k1Var, iV0, k0Var.f643j);
    }

    @Override // l8.z0
    public final void m0(boolean z) {
        r1();
        if (this.G != z) {
            this.G = z;
            o8.b0 b0Var = this.l.h;
            b0Var.getClass();
            o8.a0 a0VarC = o8.b0.c();
            a0VarC.a = b0Var.a.obtainMessage(12, z ? 1 : 0, 0);
            a0VarC.b();
            k8.g gVar = new k8.g(z, 1);
            pg0 pg0Var = this.m;
            pg0Var.c(9, gVar);
            n1();
            pg0Var.b();
        }
    }

    public final void m1(ExoPlaybackException exoPlaybackException) {
        f1 f1Var = this.i0;
        f1 f1VarC = f1Var.c(f1Var.b);
        f1VarC.q = f1VarC.s;
        f1VarC.r = 0L;
        f1 f1VarY0 = Y0(f1VarC, 1);
        if (exoPlaybackException != null) {
            f1VarY0 = f1VarY0.f(exoPlaybackException);
        }
        f1 f1Var2 = f1VarY0;
        this.H++;
        o8.b0 b0Var = this.l.h;
        b0Var.getClass();
        o8.a0 a0VarC = o8.b0.c();
        a0VarC.a = b0Var.a.obtainMessage(6);
        a0VarC.b();
        p1(f1Var2, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // l8.z0
    public final long n0() {
        r1();
        return this.x;
    }

    public final void n1() {
        v0 v0Var = this.M;
        v0 v0VarV = f0.v(this.f629f, this.c);
        this.M = v0VarV;
        if (v0VarV.equals(v0Var)) {
            return;
        }
        this.m.c(13, new v(this));
    }

    public final long o(f1 f1Var) {
        f9.b0 b0Var = f1Var.b;
        long j2 = f1Var.c;
        l8.k1 k1Var = f1Var.a;
        if (!b0Var.b()) {
            return f0.g0(U0(f1Var));
        }
        Object obj = f1Var.b.a;
        l8.h1 h1Var = this.o;
        k1Var.g(obj, h1Var);
        if (j2 == -9223372036854775807L) {
            return f0.g0(k1Var.m(V0(f1Var), this.a, 0L).l);
        }
        return f0.g0(j2) + f0.g0(h1Var.e);
    }

    public final void o1(int i, boolean z) {
        f1 f1VarA = this.i0;
        int i2 = f1VarA.n;
        int i3 = (i2 != 1 || z) ? 0 : 1;
        if (f1VarA.l == z && i2 == i3 && f1VarA.m == i) {
            return;
        }
        this.H++;
        if (f1VarA.p) {
            f1VarA = f1VarA.a();
        }
        f1 f1VarE = f1VarA.e(i, i3, z);
        o8.b0 b0Var = this.l.h;
        b0Var.getClass();
        o8.a0 a0VarC = o8.b0.c();
        a0VarC.a = b0Var.a.obtainMessage(1, z ? 1 : 0, i | (i3 << 4));
        a0VarC.b();
        p1(f1VarE, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // l8.f, l8.z0
    public final int p0() {
        r1();
        if (this.i0.a.p()) {
            return 0;
        }
        f1 f1Var = this.i0;
        return f1Var.a.b(f1Var.b.a);
    }

    public final void p1(final f1 f1Var, final int i, boolean z, final int i2, long j2, int i3, boolean z2) {
        Pair pair;
        int i4;
        final l8.k0 k0Var;
        boolean z3;
        boolean z4;
        boolean z5;
        int i6;
        Object obj;
        l8.k0 k0Var2;
        Object obj2;
        int i7;
        long j3;
        long j4;
        long jX0;
        long jX02;
        Object obj3;
        l8.k0 k0Var3;
        Object obj4;
        int i8;
        f1 f1Var2 = this.i0;
        this.i0 = f1Var;
        boolean zEquals = f1Var2.a.equals(f1Var.a);
        l8.j1 j1Var = this.a;
        l8.h1 h1Var = this.o;
        l8.k1 k1Var = f1Var2.a;
        f9.b0 b0Var = f1Var2.b;
        l8.k1 k1Var2 = f1Var.a;
        f9.b0 b0Var2 = f1Var.b;
        if (k1Var2.p() && k1Var.p()) {
            pair = new Pair(Boolean.FALSE, -1);
        } else if (k1Var2.p() != k1Var.p()) {
            pair = new Pair(Boolean.TRUE, 3);
        } else if (k1Var.m(k1Var.g(b0Var.a, h1Var).c, j1Var, 0L).a.equals(k1Var2.m(k1Var2.g(b0Var2.a, h1Var).c, j1Var, 0L).a)) {
            pair = (z && i2 == 0 && b0Var.d < b0Var2.d) ? new Pair(Boolean.TRUE, 0) : (z && i2 == 1 && z2) ? new Pair(Boolean.TRUE, 2) : new Pair(Boolean.FALSE, -1);
        } else {
            if (z && i2 == 0) {
                i4 = 1;
            } else if (z && i2 == 1) {
                i4 = 2;
            } else {
                if (zEquals) {
                    throw new IllegalStateException();
                }
                i4 = 3;
            }
            pair = new Pair(Boolean.TRUE, Integer.valueOf(i4));
        }
        boolean zBooleanValue = ((Boolean) pair.first).booleanValue();
        final int iIntValue = ((Integer) pair.second).intValue();
        if (zBooleanValue) {
            k0Var = !f1Var.a.p() ? f1Var.a.m(f1Var.a.g(f1Var.b.a, this.o).c, this.a, 0L).c : null;
            this.h0 = n0.K;
        } else {
            k0Var = null;
        }
        if (zBooleanValue || !f1Var2.f634j.equals(f1Var.f634j)) {
            m0 m0VarA = this.h0.a();
            List list = f1Var.f634j;
            for (int i9 = 0; i9 < list.size(); i9++) {
                l8.p0 p0Var = (l8.p0) list.get(i9);
                for (int i10 = 0; i10 < p0Var.e(); i10++) {
                    p0Var.d(i10).a(m0VarA);
                }
            }
            this.h0 = new n0(m0VarA);
        }
        n0 n0VarI = i();
        boolean zEquals2 = n0VarI.equals(this.N);
        this.N = n0VarI;
        boolean z6 = f1Var2.l != f1Var.l;
        boolean z7 = f1Var2.e != f1Var.e;
        if (z7 || z6) {
            q1();
        }
        boolean z8 = f1Var2.g != f1Var.g;
        if (!zEquals) {
            final int i11 = 0;
            this.m.c(0, new o8.r() { // from class: w8.r
                public final void invoke(Object obj5) {
                    switch (i11) {
                        case 0:
                            ((x0) obj5).z0(((f1) f1Var).a, i);
                            break;
                        default:
                            x0 x0Var = (x0) obj5;
                            x0Var.s0(i, (l8.k0) f1Var);
                            break;
                    }
                }
            });
        }
        if (z) {
            l8.h1 h1Var2 = new l8.h1();
            if (f1Var2.a.p()) {
                z3 = zBooleanValue;
                z4 = zEquals2;
                z5 = z7;
                i6 = i3;
                obj = null;
                k0Var2 = null;
                obj2 = null;
                i7 = -1;
            } else {
                Object obj5 = f1Var2.b.a;
                f1Var2.a.g(obj5, h1Var2);
                int i12 = h1Var2.c;
                int iB = f1Var2.a.b(obj5);
                z3 = zBooleanValue;
                z4 = zEquals2;
                z5 = z7;
                obj = f1Var2.a.m(i12, this.a, 0L).a;
                k0Var2 = this.a.c;
                obj2 = obj5;
                i6 = i12;
                i7 = iB;
            }
            if (i2 == 0) {
                if (f1Var2.b.b()) {
                    f9.b0 b0Var3 = f1Var2.b;
                    jX0 = h1Var2.a(b0Var3.b, b0Var3.c);
                    jX02 = X0(f1Var2);
                } else if (f1Var2.b.e != -1) {
                    jX0 = X0(this.i0);
                    jX02 = jX0;
                } else {
                    j3 = h1Var2.e;
                    j4 = h1Var2.d;
                    jX0 = j3 + j4;
                    jX02 = jX0;
                }
            } else if (f1Var2.b.b()) {
                jX0 = f1Var2.s;
                jX02 = X0(f1Var2);
            } else {
                j3 = h1Var2.e;
                j4 = f1Var2.s;
                jX0 = j3 + j4;
                jX02 = jX0;
            }
            long jG0 = f0.g0(jX0);
            long jG02 = f0.g0(jX02);
            f9.b0 b0Var4 = f1Var2.b;
            final y0 y0Var = new y0(obj, i6, k0Var2, obj2, i7, jG0, jG02, b0Var4.b, b0Var4.c);
            l8.j1 j1Var2 = this.a;
            int iG0 = G0();
            if (this.i0.a.p()) {
                obj3 = null;
                k0Var3 = null;
                obj4 = null;
                i8 = -1;
            } else {
                f1 f1Var3 = this.i0;
                Object obj6 = f1Var3.b.a;
                f1Var3.a.g(obj6, this.o);
                int iB2 = this.i0.a.b(obj6);
                Object obj7 = this.i0.a.m(iG0, j1Var2, 0L).a;
                k0Var3 = j1Var2.c;
                i8 = iB2;
                obj4 = obj6;
                obj3 = obj7;
            }
            long jG03 = f0.g0(j2);
            long jG04 = this.i0.b.b() ? f0.g0(X0(this.i0)) : jG03;
            f9.b0 b0Var5 = this.i0.b;
            final y0 y0Var2 = new y0(obj3, iG0, k0Var3, obj4, i8, jG03, jG04, b0Var5.b, b0Var5.c);
            this.m.c(11, new o8.r() { // from class: w8.x
                public final void invoke(Object obj8) {
                    x0 x0Var = (x0) obj8;
                    int i13 = i2;
                    x0Var.e(i13);
                    x0Var.h0(i13, y0Var, y0Var2);
                }
            });
        } else {
            z3 = zBooleanValue;
            z4 = zEquals2;
            z5 = z7;
        }
        if (z3) {
            final int i13 = 1;
            this.m.c(1, new o8.r() { // from class: w8.r
                public final void invoke(Object obj52) {
                    switch (i13) {
                        case 0:
                            ((x0) obj52).z0(((f1) k0Var).a, iIntValue);
                            break;
                        default:
                            x0 x0Var = (x0) obj52;
                            x0Var.s0(iIntValue, (l8.k0) k0Var);
                            break;
                    }
                }
            });
        }
        if (f1Var2.f633f != f1Var.f633f) {
            final int i14 = 7;
            this.m.c(10, new o8.r() { // from class: w8.s
                public final void invoke(Object obj8) {
                    x0 x0Var = (x0) obj8;
                    switch (i14) {
                        case 0:
                            f1 f1Var4 = f1Var;
                            x0Var.d0(f1Var4.g);
                            x0Var.u0(f1Var4.g);
                            break;
                        case 1:
                            f1 f1Var5 = f1Var;
                            x0Var.C0(f1Var5.e, f1Var5.l);
                            break;
                        case 2:
                            x0Var.f0(f1Var.e);
                            break;
                        case 3:
                            f1 f1Var6 = f1Var;
                            x0Var.v0(f1Var6.m, f1Var6.l);
                            break;
                        case 4:
                            x0Var.c0(f1Var.n);
                            break;
                        case 5:
                            x0Var.H0(f1Var.l());
                            break;
                        case 6:
                            x0Var.t0(f1Var.o);
                            break;
                        case 7:
                            x0Var.D0(f1Var.f633f);
                            break;
                        case 8:
                            x0Var.d(f1Var.f633f);
                            break;
                        default:
                            x0Var.n0(f1Var.i.d);
                            break;
                    }
                }
            });
            if (f1Var.f633f != null) {
                final int i15 = 8;
                this.m.c(10, new o8.r() { // from class: w8.s
                    public final void invoke(Object obj8) {
                        x0 x0Var = (x0) obj8;
                        switch (i15) {
                            case 0:
                                f1 f1Var4 = f1Var;
                                x0Var.d0(f1Var4.g);
                                x0Var.u0(f1Var4.g);
                                break;
                            case 1:
                                f1 f1Var5 = f1Var;
                                x0Var.C0(f1Var5.e, f1Var5.l);
                                break;
                            case 2:
                                x0Var.f0(f1Var.e);
                                break;
                            case 3:
                                f1 f1Var6 = f1Var;
                                x0Var.v0(f1Var6.m, f1Var6.l);
                                break;
                            case 4:
                                x0Var.c0(f1Var.n);
                                break;
                            case 5:
                                x0Var.H0(f1Var.l());
                                break;
                            case 6:
                                x0Var.t0(f1Var.o);
                                break;
                            case 7:
                                x0Var.D0(f1Var.f633f);
                                break;
                            case 8:
                                x0Var.d(f1Var.f633f);
                                break;
                            default:
                                x0Var.n0(f1Var.i.d);
                                break;
                        }
                    }
                });
            }
        }
        i9.x xVar = f1Var2.i;
        i9.x xVar2 = f1Var.i;
        if (xVar != xVar2) {
            w wVar = this.i;
            Object obj8 = xVar2.e;
            wVar.getClass();
            wVar.c = (i9.v) obj8;
            final int i16 = 9;
            this.m.c(2, new o8.r() { // from class: w8.s
                public final void invoke(Object obj82) {
                    x0 x0Var = (x0) obj82;
                    switch (i16) {
                        case 0:
                            f1 f1Var4 = f1Var;
                            x0Var.d0(f1Var4.g);
                            x0Var.u0(f1Var4.g);
                            break;
                        case 1:
                            f1 f1Var5 = f1Var;
                            x0Var.C0(f1Var5.e, f1Var5.l);
                            break;
                        case 2:
                            x0Var.f0(f1Var.e);
                            break;
                        case 3:
                            f1 f1Var6 = f1Var;
                            x0Var.v0(f1Var6.m, f1Var6.l);
                            break;
                        case 4:
                            x0Var.c0(f1Var.n);
                            break;
                        case 5:
                            x0Var.H0(f1Var.l());
                            break;
                        case 6:
                            x0Var.t0(f1Var.o);
                            break;
                        case 7:
                            x0Var.D0(f1Var.f633f);
                            break;
                        case 8:
                            x0Var.d(f1Var.f633f);
                            break;
                        default:
                            x0Var.n0(f1Var.i.d);
                            break;
                    }
                }
            });
        }
        if (!z4) {
            this.m.c(14, new z0(23, this.N));
        }
        if (z8) {
            final int i17 = 0;
            this.m.c(3, new o8.r() { // from class: w8.s
                public final void invoke(Object obj82) {
                    x0 x0Var = (x0) obj82;
                    switch (i17) {
                        case 0:
                            f1 f1Var4 = f1Var;
                            x0Var.d0(f1Var4.g);
                            x0Var.u0(f1Var4.g);
                            break;
                        case 1:
                            f1 f1Var5 = f1Var;
                            x0Var.C0(f1Var5.e, f1Var5.l);
                            break;
                        case 2:
                            x0Var.f0(f1Var.e);
                            break;
                        case 3:
                            f1 f1Var6 = f1Var;
                            x0Var.v0(f1Var6.m, f1Var6.l);
                            break;
                        case 4:
                            x0Var.c0(f1Var.n);
                            break;
                        case 5:
                            x0Var.H0(f1Var.l());
                            break;
                        case 6:
                            x0Var.t0(f1Var.o);
                            break;
                        case 7:
                            x0Var.D0(f1Var.f633f);
                            break;
                        case 8:
                            x0Var.d(f1Var.f633f);
                            break;
                        default:
                            x0Var.n0(f1Var.i.d);
                            break;
                    }
                }
            });
        }
        if (z5 || z6) {
            final int i18 = 1;
            this.m.c(-1, new o8.r() { // from class: w8.s
                public final void invoke(Object obj82) {
                    x0 x0Var = (x0) obj82;
                    switch (i18) {
                        case 0:
                            f1 f1Var4 = f1Var;
                            x0Var.d0(f1Var4.g);
                            x0Var.u0(f1Var4.g);
                            break;
                        case 1:
                            f1 f1Var5 = f1Var;
                            x0Var.C0(f1Var5.e, f1Var5.l);
                            break;
                        case 2:
                            x0Var.f0(f1Var.e);
                            break;
                        case 3:
                            f1 f1Var6 = f1Var;
                            x0Var.v0(f1Var6.m, f1Var6.l);
                            break;
                        case 4:
                            x0Var.c0(f1Var.n);
                            break;
                        case 5:
                            x0Var.H0(f1Var.l());
                            break;
                        case 6:
                            x0Var.t0(f1Var.o);
                            break;
                        case 7:
                            x0Var.D0(f1Var.f633f);
                            break;
                        case 8:
                            x0Var.d(f1Var.f633f);
                            break;
                        default:
                            x0Var.n0(f1Var.i.d);
                            break;
                    }
                }
            });
        }
        if (z5) {
            final int i19 = 2;
            this.m.c(4, new o8.r() { // from class: w8.s
                public final void invoke(Object obj82) {
                    x0 x0Var = (x0) obj82;
                    switch (i19) {
                        case 0:
                            f1 f1Var4 = f1Var;
                            x0Var.d0(f1Var4.g);
                            x0Var.u0(f1Var4.g);
                            break;
                        case 1:
                            f1 f1Var5 = f1Var;
                            x0Var.C0(f1Var5.e, f1Var5.l);
                            break;
                        case 2:
                            x0Var.f0(f1Var.e);
                            break;
                        case 3:
                            f1 f1Var6 = f1Var;
                            x0Var.v0(f1Var6.m, f1Var6.l);
                            break;
                        case 4:
                            x0Var.c0(f1Var.n);
                            break;
                        case 5:
                            x0Var.H0(f1Var.l());
                            break;
                        case 6:
                            x0Var.t0(f1Var.o);
                            break;
                        case 7:
                            x0Var.D0(f1Var.f633f);
                            break;
                        case 8:
                            x0Var.d(f1Var.f633f);
                            break;
                        default:
                            x0Var.n0(f1Var.i.d);
                            break;
                    }
                }
            });
        }
        if (z6 || f1Var2.m != f1Var.m) {
            final int i20 = 3;
            this.m.c(5, new o8.r() { // from class: w8.s
                public final void invoke(Object obj82) {
                    x0 x0Var = (x0) obj82;
                    switch (i20) {
                        case 0:
                            f1 f1Var4 = f1Var;
                            x0Var.d0(f1Var4.g);
                            x0Var.u0(f1Var4.g);
                            break;
                        case 1:
                            f1 f1Var5 = f1Var;
                            x0Var.C0(f1Var5.e, f1Var5.l);
                            break;
                        case 2:
                            x0Var.f0(f1Var.e);
                            break;
                        case 3:
                            f1 f1Var6 = f1Var;
                            x0Var.v0(f1Var6.m, f1Var6.l);
                            break;
                        case 4:
                            x0Var.c0(f1Var.n);
                            break;
                        case 5:
                            x0Var.H0(f1Var.l());
                            break;
                        case 6:
                            x0Var.t0(f1Var.o);
                            break;
                        case 7:
                            x0Var.D0(f1Var.f633f);
                            break;
                        case 8:
                            x0Var.d(f1Var.f633f);
                            break;
                        default:
                            x0Var.n0(f1Var.i.d);
                            break;
                    }
                }
            });
        }
        if (f1Var2.n != f1Var.n) {
            final int i21 = 4;
            this.m.c(6, new o8.r() { // from class: w8.s
                public final void invoke(Object obj82) {
                    x0 x0Var = (x0) obj82;
                    switch (i21) {
                        case 0:
                            f1 f1Var4 = f1Var;
                            x0Var.d0(f1Var4.g);
                            x0Var.u0(f1Var4.g);
                            break;
                        case 1:
                            f1 f1Var5 = f1Var;
                            x0Var.C0(f1Var5.e, f1Var5.l);
                            break;
                        case 2:
                            x0Var.f0(f1Var.e);
                            break;
                        case 3:
                            f1 f1Var6 = f1Var;
                            x0Var.v0(f1Var6.m, f1Var6.l);
                            break;
                        case 4:
                            x0Var.c0(f1Var.n);
                            break;
                        case 5:
                            x0Var.H0(f1Var.l());
                            break;
                        case 6:
                            x0Var.t0(f1Var.o);
                            break;
                        case 7:
                            x0Var.D0(f1Var.f633f);
                            break;
                        case 8:
                            x0Var.d(f1Var.f633f);
                            break;
                        default:
                            x0Var.n0(f1Var.i.d);
                            break;
                    }
                }
            });
        }
        if (f1Var2.l() != f1Var.l()) {
            final int i22 = 5;
            this.m.c(7, new o8.r() { // from class: w8.s
                public final void invoke(Object obj82) {
                    x0 x0Var = (x0) obj82;
                    switch (i22) {
                        case 0:
                            f1 f1Var4 = f1Var;
                            x0Var.d0(f1Var4.g);
                            x0Var.u0(f1Var4.g);
                            break;
                        case 1:
                            f1 f1Var5 = f1Var;
                            x0Var.C0(f1Var5.e, f1Var5.l);
                            break;
                        case 2:
                            x0Var.f0(f1Var.e);
                            break;
                        case 3:
                            f1 f1Var6 = f1Var;
                            x0Var.v0(f1Var6.m, f1Var6.l);
                            break;
                        case 4:
                            x0Var.c0(f1Var.n);
                            break;
                        case 5:
                            x0Var.H0(f1Var.l());
                            break;
                        case 6:
                            x0Var.t0(f1Var.o);
                            break;
                        case 7:
                            x0Var.D0(f1Var.f633f);
                            break;
                        case 8:
                            x0Var.d(f1Var.f633f);
                            break;
                        default:
                            x0Var.n0(f1Var.i.d);
                            break;
                    }
                }
            });
        }
        if (!f1Var2.o.equals(f1Var.o)) {
            final int i23 = 6;
            this.m.c(12, new o8.r() { // from class: w8.s
                public final void invoke(Object obj82) {
                    x0 x0Var = (x0) obj82;
                    switch (i23) {
                        case 0:
                            f1 f1Var4 = f1Var;
                            x0Var.d0(f1Var4.g);
                            x0Var.u0(f1Var4.g);
                            break;
                        case 1:
                            f1 f1Var5 = f1Var;
                            x0Var.C0(f1Var5.e, f1Var5.l);
                            break;
                        case 2:
                            x0Var.f0(f1Var.e);
                            break;
                        case 3:
                            f1 f1Var6 = f1Var;
                            x0Var.v0(f1Var6.m, f1Var6.l);
                            break;
                        case 4:
                            x0Var.c0(f1Var.n);
                            break;
                        case 5:
                            x0Var.H0(f1Var.l());
                            break;
                        case 6:
                            x0Var.t0(f1Var.o);
                            break;
                        case 7:
                            x0Var.D0(f1Var.f633f);
                            break;
                        case 8:
                            x0Var.d(f1Var.f633f);
                            break;
                        default:
                            x0Var.n0(f1Var.i.d);
                            break;
                    }
                }
            });
        }
        n1();
        this.m.b();
        if (f1Var2.p != f1Var.p) {
            Iterator it = this.n.iterator();
            while (it.hasNext()) {
                ((a0) ((m) it.next())).a.q1();
            }
        }
    }

    @Override // l8.z0
    public final boolean q() {
        r1();
        return this.G;
    }

    @Override // l8.z0
    public final void q0(TextureView textureView) {
        r1();
        if (textureView == null || textureView != this.U) {
            return;
        }
        k();
    }

    public final void q1() {
        int iR = r();
        py0 py0Var = this.C;
        py0 py0Var2 = this.B;
        boolean z = false;
        if (iR != 1) {
            if (iR == 2 || iR == 3) {
                r1();
                boolean z2 = this.i0.p;
                if (l0() && !z2) {
                    z = true;
                }
                py0Var2.h(z);
                py0Var.h(l0());
                return;
            }
            if (iR != 4) {
                throw new IllegalStateException();
            }
        }
        py0Var2.h(false);
        py0Var.h(false);
    }

    @Override // l8.z0
    public final int r() {
        r1();
        return this.i0.e;
    }

    @Override // l8.z0
    public final a2 r0() {
        r1();
        return this.g0;
    }

    public final void r1() {
        this.d.d();
        Thread threadCurrentThread = Thread.currentThread();
        Looper looper = this.t;
        if (threadCurrentThread != looper.getThread()) {
            String name = Thread.currentThread().getName();
            String name2 = looper.getThread().getName();
            int i = f0.a;
            Locale locale = Locale.US;
            String strF = z.p.f("Player is accessed on the wrong thread.\nCurrent thread: '", name, "'\nExpected thread: '", name2, "'\nSee https://developer.amuvvoafs.com/guide/topics/media/issues/player-accessed-on-wrong-thread");
            if (this.b0) {
                throw new IllegalStateException(strF);
            }
            o8.b.r("ExoPlayerImpl", strF, this.c0 ? null : new IllegalStateException());
            this.c0 = true;
        }
    }

    @Override // l8.z0
    public final void s(Surface surface) {
        r1();
        f1();
        l1(surface);
        int i = surface == null ? 0 : -1;
        b1(i, i);
    }

    @Override // l8.z0
    public final l8.d s0() {
        r1();
        return this.X;
    }

    @Override // tlydtdl.media3.exoplayer.ExoPlayer
    public final void setImageOutput(ImageOutput imageOutput) {
        r1();
        g1(4, 15, imageOutput);
    }

    @Override // l8.z0
    public final void setPlaybackParameters(t0 t0Var) {
        r1();
        if (this.i0.o.equals(t0Var)) {
            return;
        }
        f1 f1VarG = this.i0.g(t0Var);
        this.H++;
        this.l.h.a(4, t0Var).b();
        p1(f1VarG, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // l8.z0
    public final void setVolume(float f2) {
        r1();
        final float fH = f0.h(f2, 0.0f, 1.0f);
        if (this.Y == fH) {
            return;
        }
        this.Y = fH;
        this.l.h.a(32, Float.valueOf(fH)).b();
        this.m.f(22, new o8.r() { // from class: w8.t
            public final void invoke(Object obj) {
                ((x0) obj).w0(fH);
            }
        });
    }

    @Override // l8.z0
    public final void stop() {
        r1();
        m1(null);
        this.a0 = new c(com.gnacba.common.collect.f1.e, this.i0.s);
    }

    @Override // l8.z0
    public final void t(int i) {
        r1();
        if (this.F != i) {
            this.F = i;
            o8.b0 b0Var = this.l.h;
            b0Var.getClass();
            o8.a0 a0VarC = o8.b0.c();
            a0VarC.a = b0Var.a.obtainMessage(11, i, 0);
            a0VarC.b();
            j10.a aVar = new j10.a(i, 1);
            pg0 pg0Var = this.m;
            pg0Var.c(8, aVar);
            n1();
            pg0Var.b();
        }
    }

    @Override // l8.z0
    public final l8.l t0() {
        r1();
        return this.f0;
    }

    @Override // l8.z0
    public final boolean u() {
        r1();
        return this.i0.b.b();
    }

    @Override // l8.z0
    public final void u0(int i, int i2) {
        r1();
    }

    @Override // l8.z0
    public final long v() {
        r1();
        return f0.g0(this.i0.r);
    }

    @Override // l8.z0
    public final int v0() {
        r1();
        if (u()) {
            return this.i0.b.c;
        }
        return -1;
    }

    @Override // l8.z0
    public final void x0(x0 x0Var) {
        x0Var.getClass();
        this.m.a(x0Var);
    }

    @Override // l8.z0
    public final void z(n0 n0Var) {
        r1();
        n0Var.getClass();
        if (n0Var.equals(this.O)) {
            return;
        }
        this.O = n0Var;
        this.m.f(15, new qx.e(10, this));
    }

    @Override // l8.z0
    public final long z0() {
        r1();
        return this.w;
    }
}
