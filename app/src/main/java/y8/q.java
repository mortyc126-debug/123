package y8;

import amuvvoafs.media.AudioTrack;
import amuvvoafs.os.SystemClock;
import java.lang.reflect.Method;
import o8.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q {
    public long A;
    public long B;
    public long C;
    public boolean D;
    public long E;
    public long F;
    public boolean G;
    public long H;
    public e I;
    public final p a;
    public final long[] b;
    public AudioTrack c;
    public int d;
    public o e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f708f;
    public boolean g;
    public long h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f709j;
    public long k;
    public long l;
    public Method m;
    public long n;
    public boolean o;
    public boolean p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public int v;
    public int w;
    public long x;
    public long y;
    public long z;

    public q(p pVar) {
        this.a = pVar;
        try {
            this.m = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.b = new long[10];
        this.I = e.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a() {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.q.a():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long b() {
        /*
            r12 = this;
            long r0 = r12.x
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L16
            long r0 = r12.c()
            long r2 = r12.A
            long r0 = java.lang.Math.min(r2, r0)
            return r0
        L16:
            o8.e r0 = r12.I
            o8.z r0 = (o8.z) r0
            r0.getClass()
            long r0 = amuvvoafs.os.SystemClock.elapsedRealtime()
            long r4 = r12.r
            long r4 = r0 - r4
            r6 = 5
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 < 0) goto L93
            amuvvoafs.media.AudioTrack r4 = r12.c
            r4.getClass()
            int r5 = r4.getPlayState()
            r6 = 1
            if (r5 != r6) goto L38
            goto L91
        L38:
            int r4 = r4.getPlaybackHeadPosition()
            long r6 = (long) r4
            r8 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r6 = r6 & r8
            boolean r4 = r12.g
            r8 = 0
            if (r4 == 0) goto L57
            r4 = 2
            if (r5 != r4) goto L54
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 != 0) goto L54
            long r10 = r12.s
            r12.u = r10
        L54:
            long r10 = r12.u
            long r6 = r6 + r10
        L57:
            int r4 = o8.f0.a
            r10 = 29
            if (r4 > r10) goto L75
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 != 0) goto L73
            long r10 = r12.s
            int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r4 <= 0) goto L73
            r4 = 3
            if (r5 != r4) goto L73
            long r4 = r12.y
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L91
            r12.y = r0
            goto L91
        L73:
            r12.y = r2
        L75:
            long r2 = r12.s
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 <= 0) goto L8f
            boolean r4 = r12.G
            if (r4 == 0) goto L88
            long r4 = r12.H
            long r4 = r4 + r2
            r12.H = r4
            r2 = 0
            r12.G = r2
            goto L8f
        L88:
            long r2 = r12.t
            r4 = 1
            long r2 = r2 + r4
            r12.t = r2
        L8f:
            r12.s = r6
        L91:
            r12.r = r0
        L93:
            long r0 = r12.s
            long r2 = r12.H
            long r0 = r0 + r2
            long r2 = r12.t
            r4 = 32
            long r2 = r2 << r4
            long r0 = r0 + r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.q.b():long");
    }

    public final long c() {
        AudioTrack audioTrack = this.c;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 2) {
            return this.z;
        }
        this.I.getClass();
        return this.z + o8.f0.q(this.f708f, o8.f0.B(o8.f0.U(SystemClock.elapsedRealtime()) - this.x, this.i));
    }

    public final boolean d(long j2) {
        if (j2 > o8.f0.q(this.f708f, a())) {
            return true;
        }
        if (!this.g) {
            return false;
        }
        AudioTrack audioTrack = this.c;
        audioTrack.getClass();
        return audioTrack.getPlayState() == 2 && b() == 0;
    }

    public final boolean e(long j2) {
        if (this.y == -9223372036854775807L || j2 <= 0) {
            return false;
        }
        this.I.getClass();
        return SystemClock.elapsedRealtime() - this.y >= 200;
    }

    public final boolean f(long j2) {
        AudioTrack audioTrack = this.c;
        audioTrack.getClass();
        int playState = audioTrack.getPlayState();
        if (this.g) {
            if (playState == 2) {
                this.o = false;
                return false;
            }
            if (playState == 1 && b() == 0) {
                return false;
            }
        }
        boolean z = this.o;
        boolean zD = d(j2);
        this.o = zD;
        if (z && !zD && playState != 1) {
            this.a.onUnderrun(this.d, o8.f0.g0(this.h));
        }
        return true;
    }

    public final void g() {
        this.k = 0L;
        this.w = 0;
        this.v = 0;
        this.l = 0L;
        this.C = 0L;
        this.F = 0L;
        this.f709j = false;
    }

    public final void h(int i, int i2, int i3, AudioTrack audioTrack, boolean z) {
        this.c = audioTrack;
        this.d = i3;
        this.e = new o(audioTrack);
        this.f708f = audioTrack.getSampleRate();
        this.g = z && o8.f0.a < 23 && (i == 5 || i == 6);
        boolean zN = o8.f0.N(i);
        this.p = zN;
        this.h = zN ? o8.f0.Z(this.f708f, i3 / i2) : -9223372036854775807L;
        this.s = 0L;
        this.t = 0L;
        this.G = false;
        this.H = 0L;
        this.u = 0L;
        this.o = false;
        this.x = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.q = 0L;
        this.n = 0L;
        this.i = 1.0f;
    }

    public final void i() {
        if (this.x != -9223372036854775807L) {
            this.I.getClass();
            this.x = o8.f0.U(SystemClock.elapsedRealtime());
        }
        o oVar = this.e;
        oVar.getClass();
        oVar.h();
    }
}
