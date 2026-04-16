package y8;

import amuvvoafs.os.Handler;
import amuvvoafs.os.SystemClock;
import com.gnacba.amuvvoafs.gms.internal.ads.ds0;
import l8.q0;
import l8.t0;
import tlydtdl.media3.decoder.DecoderException;
import tlydtdl.media3.decoder.mpeghaudio.MpeghAudioRenderer;
import tlydtdl.media3.decoder.mpeghaudio.MpeghAudioSink;
import tlydtdl.media3.exoplayer.ExoPlaybackException;
import tlydtdl.media3.exoplayer.audio.AudioSink$ConfigurationException;
import tlydtdl.media3.exoplayer.audio.AudioSink$InitializationException;
import tlydtdl.media3.exoplayer.audio.AudioSink$WriteException;
import u8.c;
import u8.d;
import u8.g;
import w8.e;
import w8.f;
import w8.l0;
import w8.l1;
import w8.p0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t extends e implements p0 {
    private static final int MAX_PENDING_OUTPUT_STREAM_OFFSET_COUNT = 10;
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "DecoderAudioRenderer";
    private boolean allowPositionDiscontinuity;
    private final m audioSink;
    private boolean audioTrackNeedsConfigure;
    private long currentPositionUs;
    private u8.b decoder;
    private f decoderCounters;
    private z8.f decoderDrmSession;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private int encoderDelay;
    private int encoderPadding;
    private final i eventDispatcher;
    private boolean firstStreamSampleRead;
    private final c flagsOnlyBuffer;
    private boolean hasPendingReportedSkippedSilence;
    private c inputBuffer;
    private l8.s inputFormat;
    private boolean inputStreamEnded;
    private boolean isRendereringToEndOfStream;
    private boolean isStarted;
    private long largestQueuedPresentationTimeUs;
    private long lastBufferInStreamPresentationTimeUs;
    private long nextBufferToWritePresentationTimeUs;
    private g outputBuffer;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs;
    private z8.f sourceDrmSession;

    public t(Handler handler, j jVar, MpeghAudioSink mpeghAudioSink) {
        super(1);
        this.eventDispatcher = new i(handler, jVar);
        this.audioSink = mpeghAudioSink;
        mpeghAudioSink.setListener(new s((MpeghAudioRenderer) this));
        this.flagsOnlyBuffer = new c(0);
        this.decoderReinitializationState = 0;
        this.audioTrackNeedsConfigure = true;
        h(-9223372036854775807L);
        this.pendingOutputStreamOffsetsUs = new long[10];
        this.largestQueuedPresentationTimeUs = -9223372036854775807L;
        this.lastBufferInStreamPresentationTimeUs = -9223372036854775807L;
        this.nextBufferToWritePresentationTimeUs = -9223372036854775807L;
    }

    public final boolean c() throws ExoPlaybackException {
        if (this.outputBuffer == null) {
            g gVar = (g) this.decoder.dequeueOutputBuffer();
            this.outputBuffer = gVar;
            if (gVar == null) {
                return false;
            }
            int i = ((d) gVar).d;
            if (i > 0) {
                this.decoderCounters.f631f += i;
                this.audioSink.handleDiscontinuity();
            }
            if (this.outputBuffer.g(134217728)) {
                this.audioSink.handleDiscontinuity();
                if (this.pendingOutputStreamOffsetCount != 0) {
                    h(this.pendingOutputStreamOffsetsUs[0]);
                    int i2 = this.pendingOutputStreamOffsetCount - 1;
                    this.pendingOutputStreamOffsetCount = i2;
                    long[] jArr = this.pendingOutputStreamOffsetsUs;
                    System.arraycopy(jArr, 1, jArr, 0, i2);
                }
            }
        }
        if (this.outputBuffer.g(4)) {
            if (this.decoderReinitializationState == 2) {
                g();
                e();
                this.audioTrackNeedsConfigure = true;
                return false;
            }
            this.outputBuffer.p();
            this.outputBuffer = null;
            try {
                this.outputStreamEnded = true;
                this.audioSink.playToEndOfStream();
                this.nextBufferToWritePresentationTimeUs = this.lastBufferInStreamPresentationTimeUs;
                this.isRendereringToEndOfStream = true;
                return false;
            } catch (AudioSink$WriteException e) {
                throw createRendererException(e, e.c, e.b, 5002);
            }
        }
        this.nextBufferToWritePresentationTimeUs = -9223372036854775807L;
        if (this.audioTrackNeedsConfigure) {
            l8.r rVarA = getOutputFormat(this.decoder).a();
            rVarA.f(this.encoderDelay);
            rVarA.g(this.encoderPadding);
            rVarA.n(this.inputFormat.l);
            this.inputFormat.getClass();
            rVarA.i(this.inputFormat.a);
            rVarA.k(this.inputFormat.b);
            rVarA.l(this.inputFormat.c);
            rVarA.m(this.inputFormat.d);
            rVarA.t(this.inputFormat.e);
            rVarA.q(this.inputFormat.f);
            this.audioSink.configure(rVarA.a(), 0, getChannelMapping(this.decoder));
            this.audioTrackNeedsConfigure = false;
        }
        m mVar = this.audioSink;
        g gVar2 = this.outputBuffer;
        if (!mVar.handleBuffer(gVar2.g, ((d) gVar2).c, 1)) {
            this.nextBufferToWritePresentationTimeUs = ((d) this.outputBuffer).c;
            return false;
        }
        this.decoderCounters.e++;
        this.outputBuffer.p();
        this.outputBuffer = null;
        return true;
    }

    public w8.g canReuseDecoder(String str, l8.s sVar, l8.s sVar2) {
        return new w8.g(str, sVar, sVar2, 0, 1);
    }

    /* JADX INFO: renamed from: createDecoder */
    public abstract u8.b mo1793createDecoder(l8.s sVar, u8.a aVar);

    public final boolean d() throws ExoPlaybackException {
        u8.b bVar = this.decoder;
        if (bVar == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            c cVar = (c) bVar.dequeueInputBuffer();
            this.inputBuffer = cVar;
            if (cVar == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 1) {
            c cVar2 = this.inputBuffer;
            ((ds0) cVar2).b = 4;
            this.decoder.queueInputBuffer(cVar2);
            this.inputBuffer = null;
            this.decoderReinitializationState = 2;
            return false;
        }
        l0 formatHolder = getFormatHolder();
        int source = readSource(formatHolder, this.inputBuffer, 0);
        if (source == -5) {
            f(formatHolder);
            return true;
        }
        if (source != -4) {
            if (source != -3) {
                throw new IllegalStateException();
            }
            if (hasReadStreamToEnd()) {
                this.lastBufferInStreamPresentationTimeUs = this.largestQueuedPresentationTimeUs;
            }
            return false;
        }
        if (this.inputBuffer.g(4)) {
            this.inputStreamEnded = true;
            this.lastBufferInStreamPresentationTimeUs = this.largestQueuedPresentationTimeUs;
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            return false;
        }
        if (!this.firstStreamSampleRead) {
            this.firstStreamSampleRead = true;
            this.inputBuffer.b(134217728);
        }
        this.largestQueuedPresentationTimeUs = this.inputBuffer.g;
        if (hasReadStreamToEnd() || this.inputBuffer.g(536870912)) {
            this.lastBufferInStreamPresentationTimeUs = this.largestQueuedPresentationTimeUs;
        }
        this.inputBuffer.r();
        c cVar3 = this.inputBuffer;
        cVar3.c = this.inputFormat;
        this.decoder.queueInputBuffer(cVar3);
        this.decoderReceivedBuffers = true;
        this.decoderCounters.c++;
        this.inputBuffer = null;
        return true;
    }

    public final void e() throws ExoPlaybackException {
        u8.a aVarD;
        if (this.decoder != null) {
            return;
        }
        z8.f fVar = this.sourceDrmSession;
        z8.f.b(this.decoderDrmSession, fVar);
        this.decoderDrmSession = fVar;
        if (fVar != null) {
            aVarD = fVar.d();
            if (aVarD == null && this.decoderDrmSession.getError() == null) {
                return;
            }
        } else {
            aVarD = null;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            o8.d.b("createAudioDecoder");
            u8.b bVarMo1793createDecoder = mo1793createDecoder(this.inputFormat, aVarD);
            this.decoder = bVarMo1793createDecoder;
            bVarMo1793createDecoder.setOutputStartTimeUs(getLastResetPositionUs());
            o8.d.q();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            i iVar = this.eventDispatcher;
            String name = this.decoder.getName();
            long j2 = jElapsedRealtime2 - jElapsedRealtime;
            Handler handler = iVar.a;
            if (handler != null) {
                handler.post(new h(iVar, name, jElapsedRealtime2, j2));
            }
            this.decoderCounters.a++;
        } catch (OutOfMemoryError e) {
            throw createRendererException(e, this.inputFormat, 4001);
        } catch (DecoderException e2) {
            o8.b.n(TAG, "Audio codec error", e2);
            i iVar2 = this.eventDispatcher;
            Handler handler2 = iVar2.a;
            if (handler2 != null) {
                handler2.post(new h(iVar2, e2, 5));
            }
            throw createRendererException(e2, this.inputFormat, 4001);
        }
    }

    public final void f(l0 l0Var) throws ExoPlaybackException {
        l8.s sVar = l0Var.b;
        sVar.getClass();
        z8.f fVar = l0Var.a;
        z8.f.b(this.sourceDrmSession, fVar);
        this.sourceDrmSession = fVar;
        l8.s sVar2 = this.inputFormat;
        this.inputFormat = sVar;
        this.encoderDelay = sVar.G;
        this.encoderPadding = sVar.H;
        u8.b bVar = this.decoder;
        if (bVar == null) {
            e();
            i iVar = this.eventDispatcher;
            l8.s sVar3 = this.inputFormat;
            Handler handler = iVar.a;
            if (handler != null) {
                handler.post(new h(iVar, sVar3, (w8.g) null));
                return;
            }
            return;
        }
        w8.g gVar = fVar != this.decoderDrmSession ? new w8.g(bVar.getName(), sVar2, sVar, 0, 128) : canReuseDecoder(bVar.getName(), sVar2, sVar);
        if (gVar.d == 0) {
            if (this.decoderReceivedBuffers) {
                this.decoderReinitializationState = 1;
            } else {
                g();
                e();
                this.audioTrackNeedsConfigure = true;
            }
        }
        i iVar2 = this.eventDispatcher;
        l8.s sVar4 = this.inputFormat;
        Handler handler2 = iVar2.a;
        if (handler2 != null) {
            handler2.post(new h(iVar2, sVar4, gVar));
        }
    }

    public final void g() {
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        this.largestQueuedPresentationTimeUs = -9223372036854775807L;
        this.lastBufferInStreamPresentationTimeUs = -9223372036854775807L;
        u8.b bVar = this.decoder;
        if (bVar != null) {
            this.decoderCounters.b++;
            bVar.release();
            i iVar = this.eventDispatcher;
            String name = this.decoder.getName();
            Handler handler = iVar.a;
            if (handler != null) {
                handler.post(new h(iVar, name, 9));
            }
            this.decoder = null;
        }
        z8.f.b(this.decoderDrmSession, (z8.f) null);
        this.decoderDrmSession = null;
    }

    public int[] getChannelMapping(u8.b bVar) {
        return null;
    }

    public long getDurationToProgressUs(long j2, long j3) {
        if (this.nextBufferToWritePresentationTimeUs == -9223372036854775807L) {
            return 10000L;
        }
        long audioTrackBufferSizeUs = this.audioSink.getAudioTrackBufferSizeUs();
        if (!this.isRendereringToEndOfStream && audioTrackBufferSizeUs == -9223372036854775807L) {
            return 10000L;
        }
        long jMin = this.nextBufferToWritePresentationTimeUs - j2;
        if (audioTrackBufferSizeUs != -9223372036854775807L) {
            jMin = Math.min(audioTrackBufferSizeUs, jMin);
        }
        long jU = (long) ((jMin / (getPlaybackParameters() != null ? getPlaybackParameters().a : 1.0f)) / 2.0f);
        if (this.isStarted) {
            getClock().getClass();
            jU -= o8.f0.U(SystemClock.elapsedRealtime()) - j3;
        }
        return Math.max(10000L, jU);
    }

    @Override // w8.e
    public p0 getMediaClock() {
        return this;
    }

    public abstract l8.s getOutputFormat(u8.b bVar);

    @Override // w8.p0
    public t0 getPlaybackParameters() {
        return this.audioSink.getPlaybackParameters();
    }

    @Override // w8.p0
    public long getPositionUs() {
        if (getState() == 2) {
            i();
        }
        return this.currentPositionUs;
    }

    public final int getSinkFormatSupport(l8.s sVar) {
        return this.audioSink.getFormatSupport(sVar);
    }

    public final void h(long j2) {
        this.outputStreamOffsetUs = j2;
        if (j2 != -9223372036854775807L) {
            this.audioSink.setOutputStreamOffsetUs(j2);
        }
    }

    @Override // w8.e, w8.h1
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 2) {
            this.audioSink.setVolume(((Float) obj).floatValue());
            return;
        }
        if (i == 3) {
            this.audioSink.setAudioAttributes((l8.d) obj);
            return;
        }
        if (i == 6) {
            this.audioSink.setAuxEffectInfo((l8.e) obj);
            return;
        }
        if (i == 12) {
            if (o8.f0.a >= 23) {
                qa0.f.H(this.audioSink, obj);
            }
        } else if (i == 9) {
            this.audioSink.setSkipSilenceEnabled(((Boolean) obj).booleanValue());
        } else {
            if (i != 10) {
                return;
            }
            this.audioSink.setAudioSessionId(((Integer) obj).intValue());
        }
    }

    @Override // w8.p0
    public boolean hasSkippedSilenceSinceLastCall() {
        boolean z = this.hasPendingReportedSkippedSilence;
        this.hasPendingReportedSkippedSilence = false;
        return z;
    }

    public final void i() {
        long currentPositionUs = this.audioSink.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.allowPositionDiscontinuity) {
                currentPositionUs = Math.max(this.currentPositionUs, currentPositionUs);
            }
            this.currentPositionUs = currentPositionUs;
            this.allowPositionDiscontinuity = false;
        }
    }

    @Override // w8.e
    public boolean isEnded() {
        return this.outputStreamEnded && this.audioSink.isEnded();
    }

    @Override // w8.e
    public boolean isReady() {
        if (this.audioSink.hasPendingData()) {
            return true;
        }
        if (this.inputFormat != null) {
            return isSourceReady() || this.outputBuffer != null;
        }
        return false;
    }

    @Override // w8.e
    public void onDisabled() {
        this.inputFormat = null;
        this.audioTrackNeedsConfigure = true;
        h(-9223372036854775807L);
        this.hasPendingReportedSkippedSilence = false;
        this.nextBufferToWritePresentationTimeUs = -9223372036854775807L;
        this.isRendereringToEndOfStream = false;
        try {
            z8.f.b(this.sourceDrmSession, (z8.f) null);
            this.sourceDrmSession = null;
            g();
            this.audioSink.reset();
        } finally {
            this.eventDispatcher.a(this.decoderCounters);
        }
    }

    @Override // w8.e
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        f fVar = new f();
        this.decoderCounters = fVar;
        i iVar = this.eventDispatcher;
        Handler handler = iVar.a;
        if (handler != null) {
            handler.post(new h(iVar, fVar, 0));
        }
        if (getConfiguration().b) {
            this.audioSink.enableTunnelingV21();
        } else {
            this.audioSink.disableTunneling();
        }
        this.audioSink.setPlayerId(getPlayerId());
        this.audioSink.setClock(getClock());
    }

    public void onPositionDiscontinuity() {
        this.allowPositionDiscontinuity = true;
    }

    @Override // w8.e
    public void onPositionReset(long j2, boolean z) throws ExoPlaybackException {
        this.audioSink.flush();
        this.currentPositionUs = j2;
        this.nextBufferToWritePresentationTimeUs = -9223372036854775807L;
        this.isRendereringToEndOfStream = false;
        this.hasPendingReportedSkippedSilence = false;
        this.allowPositionDiscontinuity = true;
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if (this.decoder != null) {
            if (this.decoderReinitializationState != 0) {
                g();
                e();
                return;
            }
            this.inputBuffer = null;
            g gVar = this.outputBuffer;
            if (gVar != null) {
                gVar.p();
                this.outputBuffer = null;
            }
            u8.b bVar = this.decoder;
            bVar.getClass();
            bVar.flush();
            bVar.setOutputStartTimeUs(getLastResetPositionUs());
            this.decoderReceivedBuffers = false;
        }
    }

    @Override // w8.e
    public void onStarted() {
        this.audioSink.play();
        this.isStarted = true;
    }

    @Override // w8.e
    public void onStopped() {
        i();
        this.audioSink.pause();
        this.isStarted = false;
    }

    @Override // w8.e
    public void onStreamChanged(l8.s[] sVarArr, long j2, long j3, f9.b0 b0Var) throws ExoPlaybackException {
        this.firstStreamSampleRead = false;
        if (this.outputStreamOffsetUs == -9223372036854775807L) {
            h(j3);
            return;
        }
        int i = this.pendingOutputStreamOffsetCount;
        if (i == this.pendingOutputStreamOffsetsUs.length) {
            o8.b.q(TAG, "Too many stream changes, so dropping offset: " + this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1]);
        } else {
            this.pendingOutputStreamOffsetCount = i + 1;
        }
        this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1] = j3;
    }

    @Override // w8.e
    public void render(long j2, long j3) throws ExoPlaybackException {
        if (this.outputStreamEnded) {
            try {
                this.audioSink.playToEndOfStream();
                this.nextBufferToWritePresentationTimeUs = this.lastBufferInStreamPresentationTimeUs;
                this.isRendereringToEndOfStream = true;
                return;
            } catch (AudioSink$WriteException e) {
                throw createRendererException(e, e.c, e.b, 5002);
            }
        }
        if (this.inputFormat == null) {
            l0 formatHolder = getFormatHolder();
            this.flagsOnlyBuffer.o();
            int source = readSource(formatHolder, this.flagsOnlyBuffer, 2);
            if (source != -5) {
                if (source == -4) {
                    o8.b.h(this.flagsOnlyBuffer.g(4));
                    this.inputStreamEnded = true;
                    try {
                        this.outputStreamEnded = true;
                        this.audioSink.playToEndOfStream();
                        this.nextBufferToWritePresentationTimeUs = this.lastBufferInStreamPresentationTimeUs;
                        this.isRendereringToEndOfStream = true;
                        return;
                    } catch (AudioSink$WriteException e2) {
                        throw createRendererException(e2, null, 5002);
                    }
                }
                return;
            }
            f(formatHolder);
        }
        e();
        if (this.decoder != null) {
            try {
                o8.d.b("drainAndFeed");
                while (c()) {
                }
                while (d()) {
                }
                o8.d.q();
                synchronized (this.decoderCounters) {
                }
            } catch (DecoderException e3) {
                o8.b.n(TAG, "Audio codec error", e3);
                i iVar = this.eventDispatcher;
                Handler handler = iVar.a;
                if (handler != null) {
                    handler.post(new h(iVar, e3, 5));
                }
                throw createRendererException(e3, this.inputFormat, 4003);
            } catch (AudioSink$ConfigurationException e4) {
                throw createRendererException(e4, e4.a, 5001);
            } catch (AudioSink$InitializationException e5) {
                throw createRendererException(e5, e5.c, e5.b, 5001);
            } catch (AudioSink$WriteException e6) {
                throw createRendererException(e6, e6.c, e6.b, 5002);
            }
        }
    }

    @Override // w8.p0
    public void setPlaybackParameters(t0 t0Var) {
        this.audioSink.setPlaybackParameters(t0Var);
    }

    public final boolean sinkSupportsFormat(l8.s sVar) {
        return this.audioSink.supportsFormat(sVar);
    }

    @Override // w8.l1
    public final int supportsFormat(l8.s sVar) {
        if (!q0.i(sVar.n)) {
            return l1.b(0, 0, 0, 0);
        }
        int iSupportsFormatInternal = supportsFormatInternal(sVar);
        return iSupportsFormatInternal <= 2 ? l1.b(iSupportsFormatInternal, 0, 0, 0) : iSupportsFormatInternal | 168;
    }

    public abstract int supportsFormatInternal(l8.s sVar);
}
