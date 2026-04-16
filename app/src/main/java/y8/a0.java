package y8;

import amuvvoafs.content.Context;
import amuvvoafs.media.AudioDeviceInfo;
import amuvvoafs.media.AudioTrack;
import amuvvoafs.media.PlaybackParams;
import amuvvoafs.os.Handler;
import amuvvoafs.os.Looper;
import amuvvoafs.os.SystemClock;
import amuvvoafs.util.Pair;
import b02.n;
import com.gnacba.amuvvoafs.gms.internal.ads.g02;
import com.gnacba.amuvvoafs.gms.internal.ads.j02;
import com.gnacba.common.collect.f1;
import com.gnacba.common.collect.h0;
import com.gnacba.common.collect.k0;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import l8.d;
import l8.e;
import l8.q0;
import l8.t0;
import m8.g;
import rt1.f;
import tlydtdl.media3.common.audio.AudioProcessor$UnhandledAudioFormatException;
import tlydtdl.media3.decoder.mpeghaudio.c;
import tlydtdl.media3.exoplayer.audio.AudioSink$ConfigurationException;
import tlydtdl.media3.exoplayer.audio.AudioSink$InitializationException;
import tlydtdl.media3.exoplayer.audio.AudioSink$WriteException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements m {
    public static final Object k0 = new Object();
    public static ScheduledExecutorService l0;
    public static int m0;
    public d A;
    public y B;
    public y C;
    public t0 D;
    public boolean E;
    public ByteBuffer F;
    public int G;
    public long H;
    public long I;
    public long J;
    public long K;
    public int L;
    public boolean M;
    public boolean N;
    public long O;
    public float P;
    public ByteBuffer Q;
    public int R;
    public ByteBuffer S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public int Y;
    public e Z;
    public final Context a;
    public f a0;
    public final qu0.u b;
    public boolean b0;
    public final boolean c;
    public long c0;
    public final r d;
    public long d0;
    public final g0 e;
    public boolean e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f1 f704f;
    public boolean f0;
    public final f1 g;
    public Looper g0;
    public final q h;
    public long h0;
    public final ArrayDeque i;
    public long i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f705j;
    public Handler j0;
    public int k;
    public j02 l;
    public final g02 m;
    public final g02 n;
    public final f o;
    public final w2.j p;
    public final b0 q;
    public x8.m r;
    public l s;
    public x t;
    public x u;
    public m8.e v;
    public AudioTrack w;
    public b x;
    public e y;
    public v01.f z;

    public a0(n nVar) {
        Context context = (Context) nVar.d;
        this.a = context;
        this.A = d.g;
        this.x = context != null ? null : (b) nVar.e;
        this.b = (qu0.u) nVar.f;
        this.c = nVar.b;
        int i = o8.f0.a;
        this.f705j = false;
        this.k = 0;
        this.o = (f) nVar.g;
        w2.j jVar = (w2.j) nVar.i;
        jVar.getClass();
        this.p = jVar;
        this.h = new q(new vp1.b(10, this));
        r rVar = new r();
        this.d = rVar;
        g0 g0Var = new g0();
        this.e = g0Var;
        this.f704f = k0.u(new m8.m(), rVar, g0Var);
        this.g = k0.u(new f0(), rVar, g0Var);
        this.P = 1.0f;
        this.Y = 0;
        this.Z = new e();
        t0 t0Var = t0.d;
        this.C = new y(t0Var, 0L, 0L);
        this.D = t0Var;
        this.E = false;
        this.i = new ArrayDeque();
        this.m = new g02();
        this.n = new g02();
        this.q = (b0) nVar.h;
    }

    public static boolean k(AudioTrack audioTrack) {
        return o8.f0.a >= 29 && audioTrack.isOffloadedPlayback();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(long r10) {
        /*
            r9 = this;
            boolean r0 = r9.s()
            boolean r1 = r9.c
            qu0.u r2 = r9.b
            if (r0 != 0) goto L2d
            boolean r0 = r9.b0
            if (r0 != 0) goto L27
            y8.x r0 = r9.u
            int r3 = r0.c
            if (r3 != 0) goto L27
            l8.s r0 = r0.a
            int r0 = r0.F
            if (r1 == 0) goto L21
            boolean r0 = o8.f0.M(r0)
            if (r0 == 0) goto L21
            goto L27
        L21:
            l8.t0 r0 = r9.D
            r2.applyPlaybackParameters(r0)
            goto L29
        L27:
            l8.t0 r0 = l8.t0.d
        L29:
            r9.D = r0
        L2b:
            r4 = r0
            goto L30
        L2d:
            l8.t0 r0 = l8.t0.d
            goto L2b
        L30:
            boolean r0 = r9.b0
            if (r0 != 0) goto L50
            y8.x r0 = r9.u
            int r3 = r0.c
            if (r3 != 0) goto L50
            l8.s r0 = r0.a
            int r0 = r0.F
            if (r1 == 0) goto L47
            boolean r0 = o8.f0.M(r0)
            if (r0 == 0) goto L47
            goto L50
        L47:
            boolean r0 = r9.E
            java.lang.Object r1 = r2.c
            y8.e0 r1 = (y8.e0) r1
            r1.o = r0
            goto L51
        L50:
            r0 = 0
        L51:
            r9.E = r0
            y8.y r3 = new y8.y
            r0 = 0
            long r5 = java.lang.Math.max(r0, r10)
            y8.x r10 = r9.u
            long r0 = r9.h()
            long r7 = r10.d(r0)
            r3.<init>(r4, r5, r7)
            java.util.ArrayDeque r10 = r9.i
            r10.add(r3)
            y8.x r10 = r9.u
            m8.e r10 = r10.i
            r9.v = r10
            r10.b()
            y8.l r10 = r9.s
            if (r10 == 0) goto L7f
            boolean r11 = r9.E
            r10.c(r11)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.a0.a(long):void");
    }

    public final AudioTrack b(k kVar, d dVar, int i, l8.s sVar) throws AudioSink$InitializationException {
        try {
            AudioTrack audioTrackA = this.q.a(kVar, dVar, i);
            int state = audioTrackA.getState();
            if (state == 1) {
                return audioTrackA;
            }
            try {
                audioTrackA.release();
            } catch (Exception unused) {
            }
            throw new AudioSink$InitializationException(state, kVar.b, kVar.c, kVar.a, sVar, kVar.e, null);
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            throw new AudioSink$InitializationException(0, kVar.b, kVar.c, kVar.a, sVar, kVar.e, e);
        }
    }

    public final AudioTrack c(x xVar) throws AudioSink$InitializationException {
        try {
            return b(xVar.a(), this.A, this.Y, xVar.a);
        } catch (AudioSink$InitializationException e) {
            l lVar = this.s;
            if (lVar != null) {
                lVar.f(e);
            }
            throw e;
        }
    }

    @Override // y8.m
    public final void configure(l8.s sVar, int i, int[] iArr) throws AudioSink$ConfigurationException {
        boolean z;
        int iIntValue;
        int i2;
        int i3;
        int iW;
        int iW2;
        int i4;
        m8.e eVar;
        boolean z2;
        l();
        String str = sVar.n;
        int i6 = sVar.D;
        int i7 = sVar.F;
        boolean zEquals = "audio/raw".equals(str);
        boolean z3 = this.f705j;
        if (zEquals) {
            o8.b.c(o8.f0.N(i7));
            iW = o8.f0.w(i7) * i6;
            com.gnacba.common.collect.g0 g0Var = new com.gnacba.common.collect.g0(4);
            if (this.c && o8.f0.M(i7)) {
                g0Var.d(this.g);
            } else {
                g0Var.d(this.f704f);
                g0Var.b((g[]) this.b.b);
            }
            m8.e eVar2 = new m8.e(g0Var.g());
            if (eVar2.equals(this.v)) {
                eVar2 = this.v;
            }
            int i8 = sVar.G;
            int i9 = sVar.H;
            g0 g0Var2 = this.e;
            g0Var2.i = i8;
            g0Var2.f707j = i9;
            this.d.i = iArr;
            try {
                m8.f fVarA = eVar2.a(new m8.f(sVar));
                int i10 = fVarA.b;
                int i11 = fVarA.c;
                i3 = fVarA.a;
                z = z3;
                iIntValue = o8.f0.u(i10);
                i2 = 0;
                i4 = i11;
                iW2 = o8.f0.w(i11) * i10;
                eVar = eVar2;
                z2 = false;
            } catch (AudioProcessor$UnhandledAudioFormatException e) {
                throw new AudioSink$ConfigurationException(e, sVar);
            }
        } else {
            m8.e eVar3 = new m8.e(f1.e);
            int i12 = sVar.E;
            g gVarF = this.k != 0 ? f(sVar) : g.d;
            if (this.k == 0 || !gVarF.a) {
                Pair pairD = this.x.d(this.A, sVar);
                if (pairD == null) {
                    throw new AudioSink$ConfigurationException("Unable to configure passthrough for: " + sVar, sVar);
                }
                int iIntValue2 = ((Integer) pairD.first).intValue();
                z = z3;
                iIntValue = ((Integer) pairD.second).intValue();
                i2 = 2;
                i3 = i12;
                iW = -1;
                iW2 = -1;
                i4 = iIntValue2;
                eVar = eVar3;
                z2 = false;
            } else {
                str.getClass();
                int iC = q0.c(str, sVar.k);
                int iU = o8.f0.u(i6);
                boolean z4 = gVarF.b;
                i2 = 1;
                iW2 = -1;
                i4 = iC;
                iIntValue = iU;
                eVar = eVar3;
                z = true;
                z2 = z4;
                i3 = i12;
                iW = -1;
            }
        }
        if (i4 == 0) {
            throw new AudioSink$ConfigurationException("Invalid output encoding (mode=" + i2 + ") for: " + sVar, sVar);
        }
        if (iIntValue == 0) {
            throw new AudioSink$ConfigurationException("Invalid output channel config (mode=" + i2 + ") for: " + sVar, sVar);
        }
        int i13 = sVar.j;
        if ("audio/vnd.dts.hd;profile=lbr".equals(str) && i13 == -1) {
            i13 = 768000;
        }
        int i14 = i13;
        int minBufferSize = AudioTrack.getMinBufferSize(i3, iIntValue, i4);
        o8.b.h(minBufferSize != -2);
        int i15 = i3;
        int iP = this.o.p(minBufferSize, i4, i2, iW2 != -1 ? iW2 : 1, i15, i14, z ? 8.0d : 1.0d);
        this.e0 = false;
        int i16 = i2;
        x xVar = new x(sVar, iW, i16, iW2, i15, iIntValue, i4, iP, eVar, z, z2, this.b0);
        if (j()) {
            this.t = xVar;
        } else {
            this.u = xVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(long r13) throws tlydtdl.media3.exoplayer.audio.AudioSink$WriteException {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.a0.d(long):void");
    }

    @Override // y8.m
    public final void disableTunneling() {
        if (this.b0) {
            this.b0 = false;
            flush();
        }
    }

    public final boolean e() throws AudioSink$WriteException {
        ByteBuffer byteBuffer;
        if (!this.v.f()) {
            d(Long.MIN_VALUE);
            return this.S == null;
        }
        this.v.h();
        n(Long.MIN_VALUE);
        return this.v.e() && ((byteBuffer = this.S) == null || !byteBuffer.hasRemaining());
    }

    @Override // y8.m
    public final void enableTunnelingV21() {
        o8.b.h(this.X);
        if (this.b0) {
            return;
        }
        this.b0 = true;
        flush();
    }

    public final g f(l8.s sVar) {
        return this.e0 ? g.d : this.p.d(this.A, sVar);
    }

    @Override // y8.m
    public final void flush() {
        v01.f fVar;
        if (j()) {
            this.H = 0L;
            this.I = 0L;
            this.J = 0L;
            this.K = 0L;
            this.f0 = false;
            this.L = 0;
            this.C = new y(this.D, 0L, 0L);
            this.O = 0L;
            this.B = null;
            this.i.clear();
            this.Q = null;
            this.R = 0;
            this.S = null;
            this.U = false;
            this.T = false;
            this.V = false;
            this.F = null;
            this.G = 0;
            this.e.o = 0L;
            m8.e eVar = this.u.i;
            this.v = eVar;
            eVar.b();
            AudioTrack audioTrack = this.h.c;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 3) {
                this.w.pause();
            }
            if (k(this.w)) {
                j02 j02Var = this.l;
                j02Var.getClass();
                j02Var.b(this.w);
            }
            k kVarA = this.u.a();
            x xVar = this.t;
            if (xVar != null) {
                this.u = xVar;
                this.t = null;
            }
            q qVar = this.h;
            qVar.g();
            qVar.c = null;
            qVar.e = null;
            if (o8.f0.a >= 24 && (fVar = this.z) != null) {
                fVar.v();
                this.z = null;
            }
            AudioTrack audioTrack2 = this.w;
            l lVar = this.s;
            Handler handler = new Handler(Looper.myLooper());
            synchronized (k0) {
                try {
                    if (l0 == null) {
                        l0 = Executors.newSingleThreadScheduledExecutor(new o8.e0("ExoPlayer:AudioTrackReleaseThread"));
                    }
                    m0++;
                    l0.schedule((Runnable) new c(audioTrack2, lVar, handler, kVarA, 1), 20L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.w = null;
        }
        g02 g02Var = this.n;
        g02Var.a = null;
        g02Var.b = -9223372036854775807L;
        g02Var.c = -9223372036854775807L;
        g02 g02Var2 = this.m;
        g02Var2.a = null;
        g02Var2.b = -9223372036854775807L;
        g02Var2.c = -9223372036854775807L;
        this.h0 = 0L;
        this.i0 = 0L;
        Handler handler2 = this.j0;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
    }

    public final long g() {
        x xVar = this.u;
        return xVar.c == 0 ? this.H / ((long) xVar.b) : this.I;
    }

    @Override // y8.m
    public final long getAudioTrackBufferSizeUs() {
        if (!j()) {
            return -9223372036854775807L;
        }
        if (o8.f0.a >= 23) {
            return qb.a.s(this.w, this.u);
        }
        x xVar = this.u;
        return o8.f0.b0(this.u.h, 1000000L, xVar.c == 0 ? ((long) xVar.e) * ((long) xVar.d) : f.q(xVar.g), RoundingMode.DOWN);
    }

    @Override // y8.m
    public final long getCurrentPositionUs(boolean z) {
        ArrayDeque arrayDeque;
        long j2;
        if (!j() || this.N) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.h.a(), this.u.d(h()));
        while (true) {
            arrayDeque = this.i;
            if (arrayDeque.isEmpty() || jMin < ((y) arrayDeque.getFirst()).c) {
                break;
            }
            this.C = (y) arrayDeque.remove();
        }
        y yVar = this.C;
        long j3 = jMin - yVar.c;
        long jB = o8.f0.B(j3, yVar.a.a);
        boolean zIsEmpty = arrayDeque.isEmpty();
        qu0.u uVar = this.b;
        if (zIsEmpty) {
            long mediaDuration = uVar.getMediaDuration(j3);
            y yVar2 = this.C;
            j2 = yVar2.b + mediaDuration;
            yVar2.d = mediaDuration - jB;
        } else {
            y yVar3 = this.C;
            j2 = yVar3.b + jB + yVar3.d;
        }
        long j4 = ((e0) uVar.c).q;
        long jD = this.u.d(j4) + j2;
        long j5 = this.h0;
        if (j4 > j5) {
            long jD2 = this.u.d(j4 - j5);
            this.h0 = j4;
            this.i0 += jD2;
            if (this.j0 == null) {
                this.j0 = new Handler(Looper.myLooper());
            }
            this.j0.removeCallbacksAndMessages((Object) null);
            this.j0.postDelayed(new u0.c(22, this), 100L);
        }
        return jD;
    }

    @Override // y8.m
    public final int getFormatSupport(l8.s sVar) {
        l();
        String str = sVar.n;
        int i = sVar.F;
        if (!"audio/raw".equals(str)) {
            return this.x.d(this.A, sVar) != null ? 2 : 0;
        }
        if (o8.f0.N(i)) {
            return (i == 2 || (this.c && i == 4)) ? 2 : 1;
        }
        o8.b.q("DefaultAudioSink", "Invalid PCM encoding: " + i);
        return 0;
    }

    @Override // y8.m
    public final t0 getPlaybackParameters() {
        return this.D;
    }

    public final long h() {
        x xVar = this.u;
        if (xVar.c != 0) {
            return this.K;
        }
        long j2 = this.J;
        long j3 = xVar.d;
        int i = o8.f0.a;
        return ((j2 + j3) - 1) / j3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0163, code lost:
    
        if (r13 == 0) goto L97;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0158  */
    @Override // y8.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleBuffer(java.nio.ByteBuffer r19, long r20, int r22) throws tlydtdl.media3.exoplayer.audio.AudioSink$InitializationException, tlydtdl.media3.exoplayer.audio.AudioSink$WriteException {
        /*
            Method dump skipped, instruction units count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.a0.handleBuffer(java.nio.ByteBuffer, long, int):boolean");
    }

    @Override // y8.m
    public final void handleDiscontinuity() {
        this.M = true;
    }

    @Override // y8.m
    public final boolean hasPendingData() {
        if (j()) {
            return !(o8.f0.a >= 29 && this.w.isOffloadedPlayback() && this.V) && this.h.d(h());
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean i() throws tlydtdl.media3.exoplayer.audio.AudioSink$InitializationException {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.a0.i():boolean");
    }

    @Override // y8.m
    public final boolean isEnded() {
        if (j()) {
            return this.T && !hasPendingData();
        }
        return true;
    }

    public final boolean j() {
        return this.w != null;
    }

    public final void l() {
        Context context;
        if (this.y == null && (context = this.a) != null) {
            this.g0 = Looper.myLooper();
            e eVar = new e(context, new qx.e(25, this), this.A, this.a0);
            this.y = eVar;
            this.x = eVar.b();
        }
        this.x.getClass();
    }

    public final void m() {
        if (this.U) {
            return;
        }
        this.U = true;
        long jH = h();
        q qVar = this.h;
        qVar.z = qVar.b();
        qVar.I.getClass();
        qVar.x = o8.f0.U(SystemClock.elapsedRealtime());
        qVar.A = jH;
        if (k(this.w)) {
            this.V = false;
        }
        this.w.stop();
        this.G = 0;
    }

    public final void n(long j2) throws AudioSink$WriteException {
        d(j2);
        if (this.S != null) {
            return;
        }
        if (!this.v.f()) {
            ByteBuffer byteBuffer = this.Q;
            if (byteBuffer != null) {
                r(byteBuffer);
                d(j2);
                return;
            }
            return;
        }
        while (!this.v.e()) {
            do {
                ByteBuffer byteBufferD = this.v.d();
                if (byteBufferD.hasRemaining()) {
                    r(byteBufferD);
                    d(j2);
                } else {
                    ByteBuffer byteBuffer2 = this.Q;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.v.i(this.Q);
                    }
                }
            } while (this.S == null);
            return;
        }
    }

    public final void o() {
        if (j()) {
            try {
                this.w.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(this.D.a).setPitch(this.D.b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e) {
                o8.b.r("DefaultAudioSink", "Failed to set playback params", e);
            }
            t0 t0Var = new t0(this.w.getPlaybackParams().getSpeed(), this.w.getPlaybackParams().getPitch());
            this.D = t0Var;
            float f2 = t0Var.a;
            q qVar = this.h;
            qVar.i = f2;
            o oVar = qVar.e;
            if (oVar != null) {
                oVar.h();
            }
            qVar.g();
        }
    }

    public final void p(int i, int i2) {
        x xVar;
        AudioTrack audioTrack = this.w;
        if (audioTrack == null || !k(audioTrack) || (xVar = this.u) == null || !xVar.k) {
            return;
        }
        this.w.setOffloadDelayPadding(i, i2);
    }

    @Override // y8.m
    public final void pause() {
        this.W = false;
        if (j()) {
            q qVar = this.h;
            qVar.g();
            if (qVar.x == -9223372036854775807L) {
                o oVar = qVar.e;
                oVar.getClass();
                oVar.h();
            } else {
                qVar.z = qVar.b();
                if (!k(this.w)) {
                    return;
                }
            }
            this.w.pause();
        }
    }

    @Override // y8.m
    public final void play() {
        this.W = true;
        if (j()) {
            this.h.i();
            this.w.play();
        }
    }

    @Override // y8.m
    public final void playToEndOfStream() {
        if (!this.T && j() && e()) {
            m();
            this.T = true;
        }
    }

    public final void q(int i) {
        o8.b.h(o8.f0.a >= 29);
        this.k = i;
    }

    public final void r(ByteBuffer byteBuffer) {
        o8.b.h(this.S == null);
        if (byteBuffer.hasRemaining()) {
            if (this.u.c == 0) {
                int iQ = (int) o8.f0.q(this.u.e, o8.f0.U(20L));
                long jH = h();
                if (jH < iQ) {
                    x xVar = this.u;
                    byteBuffer = qb1.a.x(byteBuffer, xVar.g, xVar.d, (int) jH, iQ);
                }
            }
            this.S = byteBuffer;
        }
    }

    @Override // y8.m
    public final void reset() {
        flush();
        h0 h0VarQ = this.f704f.q(0);
        while (h0VarQ.hasNext()) {
            ((g) h0VarQ.next()).reset();
        }
        h0 h0VarQ2 = this.g.q(0);
        while (h0VarQ2.hasNext()) {
            ((g) h0VarQ2.next()).reset();
        }
        m8.e eVar = this.v;
        if (eVar != null) {
            eVar.j();
        }
        this.W = false;
        this.e0 = false;
    }

    public final boolean s() {
        x xVar = this.u;
        return xVar != null && xVar.j && o8.f0.a >= 23;
    }

    @Override // y8.m
    public final void setAudioAttributes(d dVar) {
        if (this.A.equals(dVar)) {
            return;
        }
        this.A = dVar;
        if (this.b0) {
            return;
        }
        e eVar = this.y;
        if (eVar != null) {
            eVar.c(dVar);
        }
        flush();
    }

    @Override // y8.m
    public final void setAudioSessionId(int i) {
        if (this.Y != i) {
            this.Y = i;
            this.X = i != 0;
            flush();
        }
    }

    @Override // y8.m
    public final void setAuxEffectInfo(e eVar) {
        if (this.Z.equals(eVar)) {
            return;
        }
        eVar.getClass();
        if (this.w != null) {
            this.Z.getClass();
        }
        this.Z = eVar;
    }

    @Override // y8.m
    public final void setClock(o8.e eVar) {
        this.h.I = eVar;
    }

    @Override // y8.m
    public final void setListener(l lVar) {
        this.s = lVar;
    }

    @Override // y8.m
    public final void setPlaybackParameters(t0 t0Var) {
        this.D = new t0(o8.f0.h(t0Var.a, 0.1f, 8.0f), o8.f0.h(t0Var.b, 0.1f, 8.0f));
        if (s()) {
            o();
            return;
        }
        y yVar = new y(t0Var, -9223372036854775807L, -9223372036854775807L);
        if (j()) {
            this.B = yVar;
        } else {
            this.C = yVar;
        }
    }

    @Override // y8.m
    public final void setPlayerId(x8.m mVar) {
        this.r = mVar;
    }

    @Override // y8.m
    public final void setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
        this.a0 = audioDeviceInfo == null ? null : new f(audioDeviceInfo);
        e eVar = this.y;
        if (eVar != null) {
            eVar.d(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.w;
        if (audioTrack != null) {
            qb.a.x(audioTrack, this.a0);
        }
    }

    @Override // y8.m
    public final void setSkipSilenceEnabled(boolean z) {
        this.E = z;
        y yVar = new y(s() ? t0.d : this.D, -9223372036854775807L, -9223372036854775807L);
        if (j()) {
            this.B = yVar;
        } else {
            this.C = yVar;
        }
    }

    @Override // y8.m
    public final void setVolume(float f2) {
        if (this.P != f2) {
            this.P = f2;
            if (j()) {
                this.w.setVolume(this.P);
            }
        }
    }

    @Override // y8.m
    public final boolean supportsFormat(l8.s sVar) {
        return getFormatSupport(sVar) != 0;
    }
}
