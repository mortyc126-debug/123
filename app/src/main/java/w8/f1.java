package w8;

import amuvvoafs.os.SystemClock;
import java.util.List;
import l8.t0;
import o8.f0;
import tlydtdl.media3.exoplayer.ExoPlaybackException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 {
    public static final f9.b0 u = new f9.b0(new Object());
    public final l8.k1 a;
    public final f9.b0 b;
    public final long c;
    public final long d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ExoPlaybackException f633f;
    public final boolean g;
    public final f9.l1 h;
    public final i9.x i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f634j;
    public final f9.b0 k;
    public final boolean l;
    public final int m;
    public final int n;
    public final t0 o;
    public final boolean p;
    public volatile long q;
    public volatile long r;
    public volatile long s;
    public volatile long t;

    public f1(l8.k1 k1Var, f9.b0 b0Var, long j2, long j3, int i, ExoPlaybackException exoPlaybackException, boolean z, f9.l1 l1Var, i9.x xVar, List list, f9.b0 b0Var2, boolean z2, int i2, int i3, t0 t0Var, long j4, long j5, long j6, long j7, boolean z3) {
        this.a = k1Var;
        this.b = b0Var;
        this.c = j2;
        this.d = j3;
        this.e = i;
        this.f633f = exoPlaybackException;
        this.g = z;
        this.h = l1Var;
        this.i = xVar;
        this.f634j = list;
        this.k = b0Var2;
        this.l = z2;
        this.m = i2;
        this.n = i3;
        this.o = t0Var;
        this.q = j4;
        this.r = j5;
        this.s = j6;
        this.t = j7;
        this.p = z3;
    }

    public static f1 j(i9.x xVar) {
        l8.g1 g1Var = l8.k1.a;
        f9.l1 l1Var = f9.l1.d;
        com.gnacba.common.collect.f1 f1Var = com.gnacba.common.collect.f1.e;
        t0 t0Var = t0.d;
        f9.b0 b0Var = u;
        return new f1(g1Var, b0Var, -9223372036854775807L, 0L, 1, null, false, l1Var, xVar, f1Var, b0Var, false, 1, 0, t0Var, 0L, 0L, 0L, 0L, false);
    }

    public final f1 a() {
        return new f1(this.a, this.b, this.c, this.d, this.e, this.f633f, this.g, this.h, this.i, this.f634j, this.k, this.l, this.m, this.n, this.o, this.q, this.r, k(), SystemClock.elapsedRealtime(), this.p);
    }

    public final f1 b(boolean z) {
        return new f1(this.a, this.b, this.c, this.d, this.e, this.f633f, z, this.h, this.i, this.f634j, this.k, this.l, this.m, this.n, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public final f1 c(f9.b0 b0Var) {
        return new f1(this.a, this.b, this.c, this.d, this.e, this.f633f, this.g, this.h, this.i, this.f634j, b0Var, this.l, this.m, this.n, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public final f1 d(f9.b0 b0Var, long j2, long j3, long j4, long j5, f9.l1 l1Var, i9.x xVar, List list) {
        return new f1(this.a, b0Var, j3, j4, this.e, this.f633f, this.g, l1Var, xVar, list, this.k, this.l, this.m, this.n, this.o, this.q, j5, j2, SystemClock.elapsedRealtime(), this.p);
    }

    public final f1 e(int i, int i2, boolean z) {
        return new f1(this.a, this.b, this.c, this.d, this.e, this.f633f, this.g, this.h, this.i, this.f634j, this.k, z, i, i2, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public final f1 f(ExoPlaybackException exoPlaybackException) {
        return new f1(this.a, this.b, this.c, this.d, this.e, exoPlaybackException, this.g, this.h, this.i, this.f634j, this.k, this.l, this.m, this.n, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public final f1 g(t0 t0Var) {
        return new f1(this.a, this.b, this.c, this.d, this.e, this.f633f, this.g, this.h, this.i, this.f634j, this.k, this.l, this.m, this.n, t0Var, this.q, this.r, this.s, this.t, this.p);
    }

    public final f1 h(int i) {
        return new f1(this.a, this.b, this.c, this.d, i, this.f633f, this.g, this.h, this.i, this.f634j, this.k, this.l, this.m, this.n, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public final f1 i(l8.k1 k1Var) {
        return new f1(k1Var, this.b, this.c, this.d, this.e, this.f633f, this.g, this.h, this.i, this.f634j, this.k, this.l, this.m, this.n, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public final long k() {
        long j2;
        long j3;
        if (!l()) {
            return this.s;
        }
        do {
            j2 = this.t;
            j3 = this.s;
        } while (j2 != this.t);
        return f0.U(f0.g0(j3) + ((long) ((SystemClock.elapsedRealtime() - j2) * this.o.a)));
    }

    public final boolean l() {
        return this.e == 3 && this.l && this.n == 0;
    }
}
