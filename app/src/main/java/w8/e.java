package w8;

import f9.z0;
import java.io.IOException;
import java.util.Objects;
import kotlin.jvm.internal.LongCompanionObject;
import tlydtdl.media3.exoplayer.ExoPlaybackException;
import u8.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e implements l1, h1 {
    private o8.e clock;
    private m1 configuration;
    private int index;
    private long lastResetPositionUs;
    private x8.m playerId;
    private k1 rendererCapabilitiesListener;
    private int state;
    private z0 stream;
    private l8.s[] streamFormats;
    private boolean streamIsFinal;
    private long streamOffsetUs;
    private boolean throwRendererExceptionIsExecuting;
    private final int trackType;
    private final Object lock = new Object();
    private final l0 formatHolder = new l0();
    private long readingPositionUs = Long.MIN_VALUE;
    private l8.k1 timeline = l8.k1.a;

    public e(int i) {
        this.trackType = i;
    }

    @Override // w8.l1
    public final void clearListener() {
        synchronized (this.lock) {
            this.rendererCapabilitiesListener = null;
        }
    }

    public final ExoPlaybackException createRendererException(Throwable th, l8.s sVar, int i) {
        return createRendererException(th, sVar, false, i);
    }

    public final void disable() {
        o8.b.h(this.state == 1);
        l0 l0Var = this.formatHolder;
        l0Var.a = null;
        l0Var.b = null;
        this.state = 0;
        this.stream = null;
        this.streamFormats = null;
        this.streamIsFinal = false;
        onDisabled();
    }

    public final void enable(m1 m1Var, l8.s[] sVarArr, z0 z0Var, long j2, boolean z, boolean z2, long j3, long j4, f9.b0 b0Var) throws ExoPlaybackException {
        o8.b.h(this.state == 0);
        this.configuration = m1Var;
        this.state = 1;
        onEnabled(z, z2);
        replaceStream(sVarArr, z0Var, j3, j4, b0Var);
        this.streamIsFinal = false;
        this.lastResetPositionUs = j3;
        this.readingPositionUs = j3;
        onPositionReset(j3, z);
    }

    public void enableMayRenderStartOfStream() {
    }

    public final l1 getCapabilities() {
        return this;
    }

    public final o8.e getClock() {
        o8.e eVar = this.clock;
        eVar.getClass();
        return eVar;
    }

    public final m1 getConfiguration() {
        m1 m1Var = this.configuration;
        m1Var.getClass();
        return m1Var;
    }

    public final l0 getFormatHolder() {
        l0 l0Var = this.formatHolder;
        l0Var.a = null;
        l0Var.b = null;
        return l0Var;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getLastResetPositionUs() {
        return this.lastResetPositionUs;
    }

    public p0 getMediaClock() {
        return null;
    }

    @Override // w8.l1
    public abstract String getName();

    public final x8.m getPlayerId() {
        x8.m mVar = this.playerId;
        mVar.getClass();
        return mVar;
    }

    public final long getReadingPositionUs() {
        return this.readingPositionUs;
    }

    public final int getState() {
        return this.state;
    }

    public final z0 getStream() {
        return this.stream;
    }

    public final l8.s[] getStreamFormats() {
        l8.s[] sVarArr = this.streamFormats;
        sVarArr.getClass();
        return sVarArr;
    }

    public final long getStreamOffsetUs() {
        return this.streamOffsetUs;
    }

    public final l8.k1 getTimeline() {
        return this.timeline;
    }

    @Override // w8.l1
    public final int getTrackType() {
        return this.trackType;
    }

    @Override // w8.h1
    public void handleMessage(int i, Object obj) {
    }

    public final boolean hasReadStreamToEnd() {
        return this.readingPositionUs == Long.MIN_VALUE;
    }

    public final void init(int i, x8.m mVar, o8.e eVar) {
        this.index = i;
        this.playerId = mVar;
        this.clock = eVar;
        onInit();
    }

    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    public abstract boolean isEnded();

    public abstract boolean isReady();

    public final boolean isSourceReady() {
        if (hasReadStreamToEnd()) {
            return this.streamIsFinal;
        }
        z0 z0Var = this.stream;
        z0Var.getClass();
        return z0Var.b();
    }

    public final void maybeThrowStreamError() throws IOException {
        z0 z0Var = this.stream;
        z0Var.getClass();
        z0Var.e();
    }

    public void onDisabled() {
    }

    public void onEnabled(boolean z, boolean z2) {
    }

    public void onInit() {
    }

    public void onPositionReset(long j2, boolean z) {
    }

    public void onRelease() {
    }

    public final void onRendererCapabilitiesChanged() {
        i9.r rVar;
        synchronized (this.lock) {
            rVar = this.rendererCapabilitiesListener;
        }
        if (rVar != null) {
            i9.r rVar2 = rVar;
            synchronized (rVar2.d) {
                rVar2.g.getClass();
            }
        }
    }

    public void onReset() {
    }

    public void onStarted() {
    }

    public void onStopped() {
    }

    public void onStreamChanged(l8.s[] sVarArr, long j2, long j3, f9.b0 b0Var) {
    }

    public void onTimelineChanged(l8.k1 k1Var) {
    }

    public final int readSource(l0 l0Var, c cVar, int i) {
        z0 z0Var = this.stream;
        z0Var.getClass();
        int iC = z0Var.c(l0Var, cVar, i);
        if (iC == -4) {
            if (cVar.g(4)) {
                this.readingPositionUs = Long.MIN_VALUE;
                return this.streamIsFinal ? -4 : -3;
            }
            long j2 = cVar.g + this.streamOffsetUs;
            cVar.g = j2;
            this.readingPositionUs = Math.max(this.readingPositionUs, j2);
            return iC;
        }
        if (iC == -5) {
            l8.s sVar = l0Var.b;
            sVar.getClass();
            long j3 = sVar.s;
            if (j3 != LongCompanionObject.MAX_VALUE) {
                l8.r rVarA = sVar.a();
                rVarA.u(j3 + this.streamOffsetUs);
                l0Var.b = rVarA.a();
            }
        }
        return iC;
    }

    public final void release() {
        o8.b.h(this.state == 0);
        onRelease();
    }

    public abstract void render(long j2, long j3);

    public final void replaceStream(l8.s[] sVarArr, z0 z0Var, long j2, long j3, f9.b0 b0Var) throws ExoPlaybackException {
        o8.b.h(!this.streamIsFinal);
        this.stream = z0Var;
        if (this.readingPositionUs == Long.MIN_VALUE) {
            this.readingPositionUs = j2;
        }
        this.streamFormats = sVarArr;
        this.streamOffsetUs = j3;
        onStreamChanged(sVarArr, j2, j3, b0Var);
    }

    public final void reset() {
        o8.b.h(this.state == 0);
        l0 l0Var = this.formatHolder;
        l0Var.a = null;
        l0Var.b = null;
        onReset();
    }

    public final void resetPosition(long j2) throws ExoPlaybackException {
        this.streamIsFinal = false;
        this.lastResetPositionUs = j2;
        this.readingPositionUs = j2;
        onPositionReset(j2, false);
    }

    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    @Override // w8.l1
    public final void setListener(k1 k1Var) {
        synchronized (this.lock) {
            this.rendererCapabilitiesListener = k1Var;
        }
    }

    public void setPlaybackSpeed(float f2, float f3) {
    }

    public final void setTimeline(l8.k1 k1Var) {
        if (Objects.equals(this.timeline, k1Var)) {
            return;
        }
        this.timeline = k1Var;
        onTimelineChanged(k1Var);
    }

    public int skipSource(long j2) {
        z0 z0Var = this.stream;
        z0Var.getClass();
        return z0Var.g(j2 - this.streamOffsetUs);
    }

    public final void start() throws ExoPlaybackException {
        o8.b.h(this.state == 1);
        this.state = 2;
        onStarted();
    }

    public final void stop() {
        o8.b.h(this.state == 2);
        this.state = 1;
        onStopped();
    }

    @Override // w8.l1
    public int supportsMixedMimeTypeAdaptation() {
        return 0;
    }

    public final ExoPlaybackException createRendererException(Throwable th, l8.s sVar, boolean z, int i) {
        int iSupportsFormat;
        if (sVar == null || this.throwRendererExceptionIsExecuting) {
            iSupportsFormat = 4;
        } else {
            this.throwRendererExceptionIsExecuting = true;
            try {
                iSupportsFormat = supportsFormat(sVar) & 7;
            } catch (ExoPlaybackException unused) {
                iSupportsFormat = 4;
            } finally {
                this.throwRendererExceptionIsExecuting = false;
            }
        }
        return new ExoPlaybackException(1, th, i, getName(), getIndex(), sVar, sVar == null ? 4 : iSupportsFormat, z);
    }
}
