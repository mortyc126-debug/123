package y8;

import amuvvoafs.content.Context;
import amuvvoafs.media.MediaFormat;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.Handler;
import c9.k;
import c9.n;
import com.gnacba.common.collect.f1;
import com.gnacba.common.collect.k0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Objects;
import l8.d;
import l8.e;
import l8.q0;
import l8.t0;
import tlydtdl.core.app.NotificationManagerCompat;
import tlydtdl.media3.exoplayer.ExoPlaybackException;
import tlydtdl.media3.exoplayer.audio.AudioSink$ConfigurationException;
import tlydtdl.media3.exoplayer.audio.AudioSink$InitializationException;
import tlydtdl.media3.exoplayer.audio.AudioSink$WriteException;
import u8.c;
import w8.f;
import w8.g;
import w8.l0;
import w8.l1;
import w8.p0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends c9.p implements p0 {
    public final Context l0;
    public final i m0;
    public final a0 n0;
    public final c9.j o0;
    public int p0;
    public boolean q0;
    public boolean r0;
    public l8.s s0;
    public l8.s t0;
    public long u0;
    public boolean v0;
    public boolean w0;
    public boolean x0;
    public int y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(Context context, k kVar, Handler handler, w8.a0 a0Var, a0 a0Var2) {
        super(1, kVar, 44100.0f);
        c9.j jVar = o8.f0.a >= 35 ? new c9.j() : null;
        this.l0 = context.getApplicationContext();
        this.n0 = a0Var2;
        this.o0 = jVar;
        this.y0 = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
        this.m0 = new i(handler, a0Var);
        a0Var2.s = new vp1.b(11, this);
    }

    public final g A(l0 l0Var) {
        l8.s sVar = l0Var.b;
        sVar.getClass();
        this.s0 = sVar;
        g gVarA = super.A(l0Var);
        i iVar = this.m0;
        Handler handler = iVar.a;
        if (handler != null) {
            handler.post(new h(iVar, sVar, gVarA));
        }
        return gVarA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B(l8.s sVar, MediaFormat mediaFormat) throws ExoPlaybackException {
        l8.s sVar2 = this.t0;
        int[] iArrN = null;
        if (sVar2 != null) {
            sVar = sVar2;
        } else if (((c9.p) this).t != null) {
            mediaFormat.getClass();
            String str = sVar.n;
            int i = sVar.D;
            int iD = "audio/raw".equals(str) ? sVar.F : (o8.f0.a < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? o8.f0.D(mediaFormat.getInteger("v-bits-per-sample")) : 2 : mediaFormat.getInteger("pcm-encoding");
            l8.r rVar = new l8.r();
            rVar.r("audio/raw");
            rVar.o(iD);
            rVar.f(sVar.G);
            rVar.g(sVar.H);
            rVar.n(sVar.l);
            rVar.i(sVar.a);
            rVar.k(sVar.b);
            rVar.l(sVar.c);
            rVar.m(sVar.d);
            rVar.t(sVar.e);
            rVar.q(sVar.f);
            rVar.b(mediaFormat.getInteger("channel-count"));
            rVar.s(mediaFormat.getInteger("sample-rate"));
            sVar = rVar.a();
            int i2 = sVar.D;
            if (this.q0 && i2 == 6 && i < 6) {
                iArrN = new int[i];
                for (int i3 = 0; i3 < i; i3++) {
                    iArrN[i3] = i3;
                }
            } else if (this.r0) {
                iArrN = n9.a.n(i2);
            }
        }
        try {
            int i4 = o8.f0.a;
            a0 a0Var = this.n0;
            if (i4 >= 29) {
                if (!((c9.p) this).P || getConfiguration().a == 0) {
                    a0Var.q(0);
                } else {
                    a0Var.q(getConfiguration().a);
                }
            }
            a0Var.configure(sVar, 0, iArrN);
        } catch (AudioSink$ConfigurationException e) {
            throw createRendererException(e, e.a, 5001);
        }
    }

    public final void C(long j2) {
        this.n0.getClass();
    }

    public final void E() {
        this.n0.M = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean H(long j2, long j3, c9.l lVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j4, boolean z, boolean z2, l8.s sVar) throws ExoPlaybackException {
        byteBuffer.getClass();
        if (this.t0 != null && (i2 & 2) != 0) {
            lVar.getClass();
            lVar.j(i);
            return true;
        }
        a0 a0Var = this.n0;
        if (z) {
            if (lVar != null) {
                lVar.j(i);
            }
            ((c9.p) this).g0.f631f += i3;
            a0Var.M = true;
            return true;
        }
        try {
            if (!a0Var.handleBuffer(byteBuffer, j4, i3)) {
                return false;
            }
            if (lVar != null) {
                lVar.j(i);
            }
            ((c9.p) this).g0.e += i3;
            return true;
        } catch (AudioSink$InitializationException e) {
            throw createRendererException(e, this.s0, e.b, (!((c9.p) this).P || getConfiguration().a == 0) ? 5001 : 5004);
        } catch (AudioSink$WriteException e2) {
            throw createRendererException(e2, sVar, e2.b, (!((c9.p) this).P || getConfiguration().a == 0) ? 5002 : 5003);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K() throws ExoPlaybackException {
        try {
            this.n0.playToEndOfStream();
        } catch (AudioSink$WriteException e) {
            throw createRendererException(e, e.c, e.b, ((c9.p) this).P ? 5003 : 5002);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean S(l8.s sVar) {
        if (getConfiguration().a != 0) {
            int iX = X(sVar);
            if ((iX & 512) != 0) {
                if (getConfiguration().a == 2 || (iX & 1024) != 0) {
                    return true;
                }
                if (sVar.G == 0 && sVar.H == 0) {
                    return true;
                }
            }
        }
        return this.n0.supportsFormat(sVar);
    }

    public final int T(c9.i iVar, l8.s sVar) {
        int iX;
        n nVarJ;
        boolean z;
        boolean z2 = true;
        int iB = l1.b(1, 0, 0, 0);
        String str = sVar.n;
        String str2 = sVar.n;
        if (!q0.i(str)) {
            return l1.b(0, 0, 0, 0);
        }
        int i = sVar.M;
        boolean z3 = i != 0;
        boolean z4 = i == 0 || i == 2;
        int i2 = 8;
        a0 a0Var = this.n0;
        if (!z4 || (z3 && c9.u.j() == null)) {
            iX = 0;
        } else {
            iX = X(sVar);
            if (a0Var.supportsFormat(sVar)) {
                return l1.b(4, 8, 32, iX);
            }
        }
        if ((!"audio/raw".equals(str2) || a0Var.supportsFormat(sVar)) && a0Var.supportsFormat(o8.f0.E(2, sVar.D, sVar.E))) {
            f1 f1VarH = str2 == null ? f1.e : (!a0Var.supportsFormat(sVar) || (nVarJ = c9.u.j()) == null) ? c9.u.h(iVar, sVar, false, false) : k0.r(nVarJ);
            if (!f1VarH.isEmpty()) {
                if (!z4) {
                    return l1.b(2, 0, 0, 0);
                }
                n nVar = (n) f1VarH.get(0);
                boolean zF = nVar.f(sVar);
                if (zF) {
                    z = true;
                    z2 = zF;
                } else {
                    for (int i3 = 1; i3 < f1VarH.d; i3++) {
                        n nVar2 = (n) f1VarH.get(i3);
                        if (nVar2.f(sVar)) {
                            z = false;
                            nVar = nVar2;
                            break;
                        }
                    }
                    z = true;
                    z2 = zF;
                }
                int i4 = z2 ? 4 : 3;
                if (z2 && nVar.h(sVar)) {
                    i2 = 16;
                }
                return i4 | i2 | 32 | (nVar.g ? 64 : 0) | (z ? 128 : 0) | iX;
            }
        }
        return iB;
    }

    public final int X(l8.s sVar) {
        g gVarF = this.n0.f(sVar);
        if (!gVarF.a) {
            return 0;
        }
        int i = gVarF.b ? 1536 : 512;
        return gVarF.c ? i | 2048 : i;
    }

    public final int Y(n nVar, l8.s sVar) {
        int i;
        if (!"OMX.gnacba.raw.decoder".equals(nVar.a) || (i = o8.f0.a) >= 24 || (i == 23 && o8.f0.R(this.l0))) {
            return sVar.o;
        }
        return -1;
    }

    public final void Z() {
        long currentPositionUs = this.n0.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.v0) {
                currentPositionUs = Math.max(this.u0, currentPositionUs);
            }
            this.u0 = currentPositionUs;
            this.v0 = false;
        }
    }

    public final g d(n nVar, l8.s sVar, l8.s sVar2) {
        g gVarC = nVar.c(sVar, sVar2);
        int i = gVarC.e;
        if (((c9.p) this).n == null && S(sVar2)) {
            i |= 32768;
        }
        if (Y(nVar, sVar2) > this.p0) {
            i |= 64;
        }
        int i2 = i;
        return new g(nVar.a, sVar, sVar2, i2 != 0 ? 0 : gVarC.d, i2);
    }

    public final p0 getMediaClock() {
        return this;
    }

    public final String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // w8.p0
    public final t0 getPlaybackParameters() {
        return this.n0.D;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w8.p0
    public final long getPositionUs() {
        if (getState() == 2) {
            Z();
        }
        return this.u0;
    }

    public final void handleMessage(int i, Object obj) {
        c9.j jVar;
        a0 a0Var = this.n0;
        if (i == 2) {
            obj.getClass();
            a0Var.setVolume(((Float) obj).floatValue());
            return;
        }
        if (i == 3) {
            d dVar = (d) obj;
            dVar.getClass();
            a0Var.setAudioAttributes(dVar);
            return;
        }
        if (i == 6) {
            e eVar = (e) obj;
            eVar.getClass();
            a0Var.setAuxEffectInfo(eVar);
            return;
        }
        if (i == 12) {
            if (o8.f0.a >= 23) {
                qb0.a.A(a0Var, obj);
                return;
            }
            return;
        }
        if (i == 16) {
            obj.getClass();
            this.y0 = ((Integer) obj).intValue();
            c9.l lVar = ((c9.p) this).t;
            if (lVar != null && o8.f0.a >= 35) {
                Bundle bundle = new Bundle();
                bundle.putInt("importance", Math.max(0, -this.y0));
                lVar.b(bundle);
                return;
            }
            return;
        }
        if (i == 9) {
            obj.getClass();
            a0Var.setSkipSilenceEnabled(((Boolean) obj).booleanValue());
            return;
        }
        if (i != 10) {
            if (i == 11) {
                w8.f0 f0Var = (w8.f0) obj;
                f0Var.getClass();
                ((c9.p) this).o = f0Var;
                return;
            }
            return;
        }
        obj.getClass();
        int iIntValue = ((Integer) obj).intValue();
        a0Var.setAudioSessionId(iIntValue);
        if (o8.f0.a < 35 || (jVar = this.o0) == null) {
            return;
        }
        jVar.d(iIntValue);
    }

    @Override // w8.p0
    public final boolean hasSkippedSilenceSinceLastCall() {
        boolean z = this.x0;
        this.x0 = false;
        return z;
    }

    public final boolean isEnded() {
        return ((c9.p) this).c0 && this.n0.isEnded();
    }

    public final boolean isReady() {
        return this.n0.hasPendingData() || super.isReady();
    }

    public final float o(float f2, l8.s[] sVarArr) {
        int iMax = -1;
        for (l8.s sVar : sVarArr) {
            int i = sVar.E;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f2;
    }

    public final void onDisabled() {
        i iVar = this.m0;
        this.w0 = true;
        this.s0 = null;
        try {
            this.n0.flush();
            try {
                super.onDisabled();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.onDisabled();
                throw th;
            } finally {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onEnabled(boolean z, boolean z2) {
        f fVar = new f();
        ((c9.p) this).g0 = fVar;
        i iVar = this.m0;
        Handler handler = iVar.a;
        if (handler != null) {
            handler.post(new h(iVar, fVar, 0));
        }
        boolean z3 = getConfiguration().b;
        a0 a0Var = this.n0;
        if (z3) {
            a0Var.enableTunnelingV21();
        } else {
            a0Var.disableTunneling();
        }
        a0Var.r = getPlayerId();
        a0Var.h.I = getClock();
    }

    public final void onPositionReset(long j2, boolean z) {
        super.onPositionReset(j2, z);
        this.n0.flush();
        this.u0 = j2;
        this.x0 = false;
        this.v0 = true;
    }

    public final void onRelease() {
        c9.j jVar;
        e eVar = this.n0.y;
        if (eVar != null) {
            eVar.e();
        }
        if (o8.f0.a < 35 || (jVar = this.o0) == null) {
            return;
        }
        jVar.b();
    }

    public final void onReset() {
        a0 a0Var = this.n0;
        this.x0 = false;
        try {
            super.onReset();
        } finally {
            if (this.w0) {
                this.w0 = false;
                a0Var.reset();
            }
        }
    }

    public final void onStarted() {
        this.n0.play();
    }

    public final void onStopped() {
        Z();
        this.n0.pause();
    }

    public final ArrayList p(c9.i iVar, l8.s sVar, boolean z) {
        n nVarJ;
        return c9.u.i(sVar.n == null ? f1.e : (!this.n0.supportsFormat(sVar) || (nVarJ = c9.u.j()) == null) ? c9.u.h(iVar, sVar, z, false) : k0.r(nVarJ), sVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final z.q0 q(c9.n r10, l8.s r11, amuvvoafs.media.MediaCrypto r12, float r13) {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.c0.q(c9.n, l8.s, amuvvoafs.media.MediaCrypto, float):z.q0");
    }

    public final void r(c cVar) {
        l8.s sVar;
        if (o8.f0.a < 29 || (sVar = cVar.c) == null || !Objects.equals(sVar.n, "audio/opus") || !((c9.p) this).P) {
            return;
        }
        ByteBuffer byteBuffer = cVar.h;
        byteBuffer.getClass();
        l8.s sVar2 = cVar.c;
        sVar2.getClass();
        int i = sVar2.G;
        if (byteBuffer.remaining() == 8) {
            this.n0.p(i, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
        }
    }

    @Override // w8.p0
    public final void setPlaybackParameters(t0 t0Var) {
        this.n0.setPlaybackParameters(t0Var);
    }

    public final void x(Exception exc) {
        o8.b.n("MediaCodecAudioRenderer", "Audio codec error", exc);
        i iVar = this.m0;
        Handler handler = iVar.a;
        if (handler != null) {
            handler.post(new h(iVar, exc, 5));
        }
    }

    public final void y(long j2, long j3, String str) {
        i iVar = this.m0;
        Handler handler = iVar.a;
        if (handler != null) {
            handler.post(new h(iVar, str, j2, j3));
        }
    }

    public final void z(String str) {
        i iVar = this.m0;
        Handler handler = iVar.a;
        if (handler != null) {
            handler.post(new h(iVar, str, 9));
        }
    }
}
