package tlydtdl.media3.decoder.mpeghaudio;

import amuvvoafs.content.Context;
import amuvvoafs.media.AudioDeviceInfo;
import amuvvoafs.media.AudioTrack;
import amuvvoafs.media.PlaybackParams;
import amuvvoafs.os.Handler;
import amuvvoafs.os.Looper;
import amuvvoafs.os.SystemClock;
import amuvvoafs.util.Pair;
import com.gnacba.common.collect.f1;
import com.gnacba.common.collect.h0;
import com.gnacba.common.collect.k0;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import l8.d;
import l8.q0;
import l8.s;
import l8.t0;
import m8.g;
import m8.h;
import o6.c;
import o8.e0;
import o8.f0;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import s1.a;
import tlydtdl.media3.common.audio.AudioProcessor$UnhandledAudioFormatException;
import tlydtdl.media3.exoplayer.audio.AudioSink$ConfigurationException;
import tlydtdl.media3.exoplayer.audio.AudioSink$InitializationException;
import tlydtdl.media3.exoplayer.audio.AudioSink$WriteException;
import w2.j;
import y8.b;
import y8.b0;
import y8.e;
import y8.f;
import y8.g0;
import y8.k;
import y8.l;
import y8.m;
import y8.o;
import y8.p;
import y8.q;
import y8.u;
import y8.v;
import y8.w;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class MpeghAudioSink implements m {
    private static final int AUDIO_TRACK_SMALLER_BUFFER_RETRY_SIZE = 1000000;
    private static final int AUDIO_TRACK_VOLUME_RAMP_TIME_MS = 20;
    public static final float DEFAULT_PLAYBACK_SPEED = 1.0f;
    private static final boolean DEFAULT_SKIP_SILENCE = false;
    private static final int ERROR_NATIVE_DEAD_OBJECT = -32;
    public static final float MAX_PITCH = 8.0f;
    public static final float MAX_PLAYBACK_SPEED = 8.0f;
    private static final int MINIMUM_REPORT_SKIPPED_SILENCE_DURATION_US = 300000;
    public static final float MIN_PITCH = 0.1f;
    public static final float MIN_PLAYBACK_SPEED = 0.1f;
    public static final int OUTPUT_MODE_OFFLOAD = 1;
    public static final int OUTPUT_MODE_PASSTHROUGH = 2;
    public static final int OUTPUT_MODE_PCM = 0;
    private static final int REPORT_SKIPPED_SILENCE_DELAY_MS = 100;
    private static final String TAG = "MpeghAudioSink";
    public static boolean failOnSpuriousAudioTimestamp;
    private static int pendingReleaseCount;
    private static ScheduledExecutorService releaseExecutor;
    private static final Object releaseExecutorLock = new Object();
    private long accumulatedSkippedSilenceDurationUs;
    private MediaPositionParameters afterDrainParameters;
    private final AlcAudioProcessor alcProcessor;
    private String appRootPath;
    private d audioAttributes;
    private b audioCapabilities;
    private e audioCapabilitiesReceiver;
    private final w8.m audioOffloadListener;
    private final u audioOffloadSupportProvider;
    private MpeghAudioProcessingPipeline audioProcessingPipeline;
    private final h audioProcessorChain;
    private int audioSessionId;
    private AudioTrack audioTrack;
    private final v audioTrackBufferSizeProvider;
    private final q audioTrackPositionTracker;
    private final w audioTrackProvider;
    private l8.e auxEffectInfo;
    private ByteBuffer avSyncHeader;
    private int bytesUntilNextAvSync;
    private Configuration configuration;
    private final Context context;
    private final boolean enableFloatOutput;
    private boolean externalAudioSessionIdProvided;
    private int framesPerEncodedSample;
    private boolean handledEndOfStream;
    private boolean handledOffloadOnPresentationEnded;
    private final PendingExceptionHolder<AudioSink$InitializationException> initializationExceptionPendingExceptionHolder;
    private ByteBuffer inputBuffer;
    private int inputBufferAccessUnitCount;
    private boolean isWaitingForOffloadEndOfStreamHandled;
    private long lastFeedElapsedRealtimeMs;
    private long lastTunnelingAvSyncPresentationTimeUs;
    private l listener;
    private MediaPositionParameters mediaPositionParameters;
    private final ArrayDeque<MediaPositionParameters> mediaPositionParametersCheckpoints;
    private boolean offloadDisabledUntilNextConfiguration;
    private int offloadMode;
    private StreamEventCallbackV29 offloadStreamEventCallbackV29;
    private OnRoutingChangedListenerApi24 onRoutingChangedListener;
    private ByteBuffer outputBuffer;
    private Configuration pendingConfiguration;
    private Looper playbackLooper;
    private t0 playbackParameters;
    private x8.m playerId;
    private boolean playing;
    private final boolean preferAudioTrackPlaybackParams;
    private f preferredDevice;
    private Handler reportSkippedSilenceHandler;
    private boolean skipSilenceEnabled;
    private long skippedOutputFrameCountAtLastPosition;
    private long startMediaTimeUs;
    private boolean startMediaTimeUsNeedsInit;
    private boolean startMediaTimeUsNeedsSync;
    private boolean stoppedAudioTrack;
    private long submittedEncodedFrames;
    private long submittedPcmBytes;
    private final k0 toFloatPcmAvailableAudioProcessors;
    private final g0 trimmingAudioProcessor;
    private boolean tunneling;
    private final VirtualizerAudioProcessor virtualizerProcessor;
    private float volume;
    private final PendingExceptionHolder<AudioSink$WriteException> writeExceptionPendingExceptionHolder;
    private long writtenEncodedFrames;
    private long writtenPcmBytes;

    /* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
    @Deprecated
    public interface AudioProcessorChain extends h {
        @Override // m8.h
        /* synthetic */ t0 applyPlaybackParameters(t0 t0Var);

        @Override // m8.h
        /* synthetic */ boolean applySkipSilenceEnabled(boolean z);

        /* synthetic */ g[] getAudioProcessors();

        @Override // m8.h
        /* synthetic */ long getMediaDuration(long j2);

        @Override // m8.h
        /* synthetic */ long getSkippedOutputFrameCount();
    }

    /* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
    public static class DefaultAudioProcessorChain implements AudioProcessorChain {
        private final g[] audioProcessors;

        public DefaultAudioProcessorChain(g... gVarArr) {
            g[] gVarArr2 = new g[gVarArr.length];
            this.audioProcessors = gVarArr2;
            System.arraycopy(gVarArr, 0, gVarArr2, 0, gVarArr.length);
        }

        @Override // tlydtdl.media3.decoder.mpeghaudio.MpeghAudioSink.AudioProcessorChain, m8.h
        public t0 applyPlaybackParameters(t0 t0Var) {
            return new t0(1.0f, 1.0f);
        }

        @Override // tlydtdl.media3.decoder.mpeghaudio.MpeghAudioSink.AudioProcessorChain, m8.h
        public boolean applySkipSilenceEnabled(boolean z) {
            return MpeghAudioSink.DEFAULT_SKIP_SILENCE;
        }

        @Override // tlydtdl.media3.decoder.mpeghaudio.MpeghAudioSink.AudioProcessorChain
        public g[] getAudioProcessors() {
            return this.audioProcessors;
        }

        @Override // tlydtdl.media3.decoder.mpeghaudio.MpeghAudioSink.AudioProcessorChain, m8.h
        public long getMediaDuration(long j2) {
            return j2;
        }

        @Override // tlydtdl.media3.decoder.mpeghaudio.MpeghAudioSink.AudioProcessorChain, m8.h
        public long getSkippedOutputFrameCount() {
            return 0L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
    public static final class MediaPositionParameters {
        public final long audioTrackPositionUs;
        public long mediaPositionDriftUs;
        public final long mediaTimeUs;
        public final t0 playbackParameters;

        private MediaPositionParameters(t0 t0Var, long j2, long j3) {
            this.playbackParameters = t0Var;
            this.mediaTimeUs = j2;
            this.audioTrackPositionUs = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
    public static final class PendingExceptionHolder<T extends Exception> {
        private static final int RETRY_DELAY_MS = 50;
        private static final int RETRY_DURATION_MS = 200;
        private T pendingException;
        private long throwDeadlineMs = -9223372036854775807L;
        private long earliestNextRetryTimeMs = -9223372036854775807L;

        public void clear() {
            this.pendingException = null;
            this.throwDeadlineMs = -9223372036854775807L;
            this.earliestNextRetryTimeMs = -9223372036854775807L;
        }

        public boolean shouldWaitBeforeRetry() {
            if (this.pendingException == null) {
                return MpeghAudioSink.DEFAULT_SKIP_SILENCE;
            }
            if (!MpeghAudioSink.hasPendingAudioTrackReleases() && SystemClock.elapsedRealtime() >= this.earliestNextRetryTimeMs) {
                return MpeghAudioSink.DEFAULT_SKIP_SILENCE;
            }
            return true;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: T extends java.lang.Exception */
        public void throwExceptionIfDeadlineIsReached(T t) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.pendingException == null) {
                this.pendingException = t;
            }
            if (this.throwDeadlineMs == -9223372036854775807L && !MpeghAudioSink.hasPendingAudioTrackReleases()) {
                this.throwDeadlineMs = 200 + jElapsedRealtime;
            }
            long j2 = this.throwDeadlineMs;
            if (j2 == -9223372036854775807L || jElapsedRealtime < j2) {
                this.earliestNextRetryTimeMs = jElapsedRealtime + 50;
                return;
            }
            T t2 = this.pendingException;
            if (t2 != t) {
                t2.addSuppressed(t);
            }
            T t3 = this.pendingException;
            clear();
            throw t3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
    public final class PositionTrackerListener implements p {
        private PositionTrackerListener() {
        }

        @Override // y8.p
        public void onInvalidLatency(long j2) {
            o8.b.q(MpeghAudioSink.TAG, "Ignoring impossibly large audio latency: " + j2);
        }

        @Override // y8.p
        public void onPositionAdvancing(long j2) {
            if (MpeghAudioSink.this.listener != null) {
                MpeghAudioSink.this.listener.onPositionAdvancing(j2);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.media3.decoder.mpeghaudio.MpeghAudioSink$InvalidAudioTrackTimestampException */
        @Override // y8.p
        public void onPositionFramesMismatch(long j2, long j3, long j4, long j5) throws InvalidAudioTrackTimestampException {
            StringBuilder sbM = a.m(j2, "Spurious audio timestamp (frame position mismatch): ", ", ");
            sbM.append(j3);
            i.B(sbM, ", ", j4, ", ");
            sbM.append(j5);
            sbM.append(", ");
            sbM.append(MpeghAudioSink.this.getSubmittedFrames());
            sbM.append(", ");
            sbM.append(MpeghAudioSink.this.getWrittenFrames());
            String string = sbM.toString();
            if (MpeghAudioSink.failOnSpuriousAudioTimestamp) {
                throw new InvalidAudioTrackTimestampException(string, (1) null);
            }
            o8.b.q(MpeghAudioSink.TAG, string);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.media3.decoder.mpeghaudio.MpeghAudioSink$InvalidAudioTrackTimestampException */
        @Override // y8.p
        public void onSystemTimeUsMismatch(long j2, long j3, long j4, long j5) throws InvalidAudioTrackTimestampException {
            StringBuilder sbM = a.m(j2, "Spurious audio timestamp (system clock mismatch): ", ", ");
            sbM.append(j3);
            i.B(sbM, ", ", j4, ", ");
            sbM.append(j5);
            sbM.append(", ");
            sbM.append(MpeghAudioSink.this.getSubmittedFrames());
            sbM.append(", ");
            sbM.append(MpeghAudioSink.this.getWrittenFrames());
            String string = sbM.toString();
            if (MpeghAudioSink.failOnSpuriousAudioTimestamp) {
                throw new InvalidAudioTrackTimestampException(string, (1) null);
            }
            o8.b.q(MpeghAudioSink.TAG, string);
        }

        @Override // y8.p
        public void onUnderrun(int i, long j2) {
            if (MpeghAudioSink.this.listener != null) {
                MpeghAudioSink.this.listener.i(j2, SystemClock.elapsedRealtime() - MpeghAudioSink.this.lastFeedElapsedRealtimeMs, i);
            }
        }
    }

    private void applyAudioProcessorPlaybackParametersAndSkipSilence(long j2, boolean z) {
        t0 t0VarApplyPlaybackParameters;
        if (useAudioTrackPlaybackParams()) {
            t0VarApplyPlaybackParameters = t0.d;
        } else {
            t0VarApplyPlaybackParameters = shouldApplyAudioProcessorPlaybackParameters() ? this.audioProcessorChain.applyPlaybackParameters(this.playbackParameters) : t0.d;
            this.playbackParameters = t0VarApplyPlaybackParameters;
        }
        t0 t0Var = t0VarApplyPlaybackParameters;
        this.skipSilenceEnabled = shouldApplyAudioProcessorPlaybackParameters() ? this.audioProcessorChain.applySkipSilenceEnabled(this.skipSilenceEnabled) : DEFAULT_SKIP_SILENCE;
        this.mediaPositionParametersCheckpoints.add(new MediaPositionParameters(t0Var, Math.max(0L, j2), this.configuration.framesToDurationUs(getWrittenFrames())));
        setupAudioProcessors(z);
        l lVar = this.listener;
        if (lVar != null) {
            lVar.c(this.skipSilenceEnabled);
        }
    }

    private long applyMediaPositionParameters(long j2) {
        while (!this.mediaPositionParametersCheckpoints.isEmpty() && j2 >= this.mediaPositionParametersCheckpoints.getFirst().audioTrackPositionUs) {
            this.mediaPositionParameters = this.mediaPositionParametersCheckpoints.remove();
        }
        MediaPositionParameters mediaPositionParameters = this.mediaPositionParameters;
        long j3 = j2 - mediaPositionParameters.audioTrackPositionUs;
        long jB = f0.B(j3, mediaPositionParameters.playbackParameters.a);
        if (!this.mediaPositionParametersCheckpoints.isEmpty()) {
            MediaPositionParameters mediaPositionParameters2 = this.mediaPositionParameters;
            return mediaPositionParameters2.mediaTimeUs + jB + mediaPositionParameters2.mediaPositionDriftUs;
        }
        long mediaDuration = this.audioProcessorChain.getMediaDuration(j3);
        MediaPositionParameters mediaPositionParameters3 = this.mediaPositionParameters;
        long j4 = mediaPositionParameters3.mediaTimeUs + mediaDuration;
        mediaPositionParameters3.mediaPositionDriftUs = mediaDuration - jB;
        return j4;
    }

    private long applySkipping(long j2) {
        long skippedOutputFrameCount = this.audioProcessorChain.getSkippedOutputFrameCount();
        long jFramesToDurationUs = j2 + this.configuration.framesToDurationUs(skippedOutputFrameCount);
        long j3 = this.skippedOutputFrameCountAtLastPosition;
        if (skippedOutputFrameCount > j3) {
            long jFramesToDurationUs2 = this.configuration.framesToDurationUs(skippedOutputFrameCount - j3);
            this.skippedOutputFrameCountAtLastPosition = skippedOutputFrameCount;
            handleSkippedSilence(jFramesToDurationUs2);
        }
        return jFramesToDurationUs;
    }

    private AudioTrack buildAudioTrack(Configuration configuration) throws AudioSink$InitializationException {
        try {
            AudioTrack audioTrackBuildAudioTrack = buildAudioTrack(configuration.buildAudioTrackConfig(), this.audioAttributes, this.audioSessionId, configuration.inputFormat);
            w8.m mVar = this.audioOffloadListener;
            if (mVar == null) {
                return audioTrackBuildAudioTrack;
            }
            isOffloadedPlayback(audioTrackBuildAudioTrack);
            mVar.getClass();
            return audioTrackBuildAudioTrack;
        } catch (AudioSink$InitializationException e) {
            l lVar = this.listener;
            if (lVar != null) {
                lVar.f(e);
            }
            throw e;
        }
    }

    private AudioTrack buildAudioTrackWithRetry() throws AudioSink$InitializationException {
        try {
            Configuration configuration = this.configuration;
            configuration.getClass();
            return buildAudioTrack(configuration);
        } catch (AudioSink$InitializationException e) {
            Configuration configuration2 = this.configuration;
            if (configuration2.bufferSize > 1000000) {
                Configuration configurationCopyWithBufferSize = configuration2.copyWithBufferSize(1000000);
                try {
                    AudioTrack audioTrackBuildAudioTrack = buildAudioTrack(configurationCopyWithBufferSize);
                    this.configuration = configurationCopyWithBufferSize;
                    return audioTrackBuildAudioTrack;
                } catch (AudioSink$InitializationException e2) {
                    e.addSuppressed(e2);
                    maybeDisableOffload();
                    throw e;
                }
            }
            maybeDisableOffload();
            throw e;
        }
    }

    private void drainBufferToEndOfStream() {
        boolean zIsAudioTrackInitialized = isAudioTrackInitialized();
        try {
            this.virtualizerProcessor.endOfCodec();
            if (!zIsAudioTrackInitialized) {
                initializeAudioTrack();
            }
            processBuffers(this.lastFeedElapsedRealtimeMs * 1000);
        } catch (AudioSink$InitializationException | AudioSink$WriteException unused) {
        }
        if (zIsAudioTrackInitialized) {
            return;
        }
        flush();
    }

    private void drainOutputBuffer(long j2) throws Exception {
        MpeghAudioSink mpeghAudioSink;
        int iWriteNonBlocking;
        l lVar;
        if (this.outputBuffer == null || this.writeExceptionPendingExceptionHolder.shouldWaitBeforeRetry()) {
            return;
        }
        int iRemaining = this.outputBuffer.remaining();
        boolean z = this.tunneling;
        boolean z2 = DEFAULT_SKIP_SILENCE;
        if (z) {
            o8.b.h(j2 != -9223372036854775807L);
            if (j2 == Long.MIN_VALUE) {
                j2 = this.lastTunnelingAvSyncPresentationTimeUs;
            } else {
                this.lastTunnelingAvSyncPresentationTimeUs = j2;
            }
            mpeghAudioSink = this;
            iWriteNonBlocking = mpeghAudioSink.writeNonBlockingWithAvSync(this.audioTrack, this.outputBuffer, iRemaining, j2);
        } else {
            mpeghAudioSink = this;
            iWriteNonBlocking = writeNonBlocking(mpeghAudioSink.audioTrack, mpeghAudioSink.outputBuffer, iRemaining);
        }
        mpeghAudioSink.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
        if (iWriteNonBlocking < 0) {
            if (isAudioTrackDeadObject(iWriteNonBlocking)) {
                if (getWrittenFrames() > 0) {
                    z2 = true;
                } else if (isOffloadedPlayback(mpeghAudioSink.audioTrack)) {
                    maybeDisableOffload();
                    z2 = true;
                }
            }
            AudioSink$WriteException audioSink$WriteException = new AudioSink$WriteException(iWriteNonBlocking, mpeghAudioSink.configuration.inputFormat, z2);
            l lVar2 = mpeghAudioSink.listener;
            if (lVar2 != null) {
                lVar2.f(audioSink$WriteException);
            }
            if (!audioSink$WriteException.b || mpeghAudioSink.context == null) {
                mpeghAudioSink.writeExceptionPendingExceptionHolder.throwExceptionIfDeadlineIsReached(audioSink$WriteException);
                return;
            } else {
                mpeghAudioSink.audioCapabilities = b.c;
                throw audioSink$WriteException;
            }
        }
        mpeghAudioSink.writeExceptionPendingExceptionHolder.clear();
        if (isOffloadedPlayback(mpeghAudioSink.audioTrack)) {
            if (mpeghAudioSink.writtenEncodedFrames > 0) {
                mpeghAudioSink.isWaitingForOffloadEndOfStreamHandled = DEFAULT_SKIP_SILENCE;
            }
            if (mpeghAudioSink.playing && (lVar = mpeghAudioSink.listener) != null && iWriteNonBlocking < iRemaining && !mpeghAudioSink.isWaitingForOffloadEndOfStreamHandled) {
                lVar.e();
            }
        }
        int i = mpeghAudioSink.configuration.outputMode;
        if (i == 0) {
            mpeghAudioSink.writtenPcmBytes += (long) iWriteNonBlocking;
        }
        if (iWriteNonBlocking == iRemaining) {
            if (i != 0) {
                if (mpeghAudioSink.outputBuffer == mpeghAudioSink.inputBuffer) {
                    z2 = true;
                }
                o8.b.h(z2);
                mpeghAudioSink.writtenEncodedFrames = (((long) mpeghAudioSink.framesPerEncodedSample) * ((long) mpeghAudioSink.inputBufferAccessUnitCount)) + mpeghAudioSink.writtenEncodedFrames;
            }
            mpeghAudioSink.outputBuffer = null;
        }
    }

    private boolean drainToEndOfStream() throws Exception {
        ByteBuffer byteBuffer;
        if (!this.audioProcessingPipeline.isOperational()) {
            drainOutputBuffer(Long.MIN_VALUE);
            if (this.outputBuffer == null) {
                return true;
            }
            return DEFAULT_SKIP_SILENCE;
        }
        this.audioProcessingPipeline.queueEndOfStream();
        processBuffers(Long.MIN_VALUE);
        if (!this.audioProcessingPipeline.isEnded() || ((byteBuffer = this.outputBuffer) != null && byteBuffer.hasRemaining())) {
            return DEFAULT_SKIP_SILENCE;
        }
        return true;
    }

    private static int getAudioTrackMinBufferSize(int i, int i2, int i3) {
        int minBufferSize = AudioTrack.getMinBufferSize(i, i2, i3);
        o8.b.h(minBufferSize != -2 ? true : DEFAULT_SKIP_SILENCE);
        return minBufferSize;
    }

    private static int getFramesPerEncodedSample(int i, ByteBuffer byteBuffer) {
        if (i == 20) {
            return n9.a.x(byteBuffer);
        }
        if (i != 30) {
            switch (i) {
                case 5:
                case 6:
                    break;
                case 7:
                case 8:
                    break;
                case 9:
                    int iPosition = byteBuffer.position();
                    int i2 = f0.a;
                    int iReverseBytes = byteBuffer.getInt(iPosition);
                    if (byteBuffer.order() != ByteOrder.BIG_ENDIAN) {
                        iReverseBytes = Integer.reverseBytes(iReverseBytes);
                    }
                    int iW = n9.a.w(iReverseBytes);
                    if (iW != -1) {
                        return iW;
                    }
                    throw new IllegalArgumentException();
                case 10:
                    return 1024;
                case 11:
                case 12:
                    return 2048;
                default:
                    switch (i) {
                        case 14:
                            int iF = n9.a.f(byteBuffer);
                            if (iF == -1) {
                                return 0;
                            }
                            return n9.a.z(iF, byteBuffer) * 16;
                        case 15:
                            return 512;
                        case 16:
                            return 1024;
                        case 17:
                            return n9.a.q(byteBuffer);
                        case 18:
                            break;
                        default:
                            throw new IllegalStateException(c.k(i, "Unexpected audio encoding: "));
                    }
                    break;
            }
            return n9.a.p(byteBuffer);
        }
        return n9.a.v(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getSubmittedFrames() {
        Configuration configuration = this.configuration;
        return configuration.outputMode == 0 ? this.submittedPcmBytes / ((long) configuration.inputPcmFrameSize) : this.submittedEncodedFrames;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getWrittenFrames() {
        Configuration configuration = this.configuration;
        if (configuration.outputMode != 0) {
            return this.writtenEncodedFrames;
        }
        long j2 = this.writtenPcmBytes;
        long j3 = configuration.outputPcmFrameSize;
        int i = f0.a;
        return ((j2 + j3) - 1) / j3;
    }

    private void handleSkippedSilence(long j2) {
        this.accumulatedSkippedSilenceDurationUs += j2;
        if (this.reportSkippedSilenceHandler == null) {
            this.reportSkippedSilenceHandler = new Handler(Looper.myLooper());
        }
        this.reportSkippedSilenceHandler.removeCallbacksAndMessages((Object) null);
        this.reportSkippedSilenceHandler.postDelayed(new b(this), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasPendingAudioTrackReleases() {
        boolean z;
        synchronized (releaseExecutorLock) {
            z = pendingReleaseCount > 0 ? true : DEFAULT_SKIP_SILENCE;
        }
        return z;
    }

    private boolean initializeAudioTrack() throws AudioSink$InitializationException {
        e eVar;
        x8.m mVar;
        if (this.initializationExceptionPendingExceptionHolder.shouldWaitBeforeRetry()) {
            return DEFAULT_SKIP_SILENCE;
        }
        AudioTrack audioTrackBuildAudioTrackWithRetry = buildAudioTrackWithRetry();
        this.audioTrack = audioTrackBuildAudioTrackWithRetry;
        if (isOffloadedPlayback(audioTrackBuildAudioTrackWithRetry)) {
            registerStreamEventCallbackV29(this.audioTrack);
            Configuration configuration = this.configuration;
            if (configuration.enableOffloadGapless) {
                AudioTrack audioTrack = this.audioTrack;
                s sVar = configuration.inputFormat;
                audioTrack.setOffloadDelayPadding(sVar.G, sVar.H);
            }
        }
        int i = f0.a;
        if (i >= 31 && (mVar = this.playerId) != null) {
            Api31.setLogSessionIdOnAudioTrack(this.audioTrack, mVar);
        }
        this.audioSessionId = this.audioTrack.getAudioSessionId();
        q qVar = this.audioTrackPositionTracker;
        AudioTrack audioTrack2 = this.audioTrack;
        Configuration configuration2 = this.configuration;
        qVar.h(configuration2.outputEncoding, configuration2.outputPcmFrameSize, configuration2.bufferSize, audioTrack2, configuration2.outputMode == 2);
        setVolumeInternal();
        this.auxEffectInfo.getClass();
        f fVar = this.preferredDevice;
        if (fVar != null && i >= 23) {
            Api23.setPreferredDeviceOnAudioTrack(this.audioTrack, fVar);
            e eVar2 = this.audioCapabilitiesReceiver;
            if (eVar2 != null) {
                eVar2.d(this.preferredDevice.a);
            }
        }
        if (i >= 24 && (eVar = this.audioCapabilitiesReceiver) != null) {
            this.onRoutingChangedListener = new OnRoutingChangedListenerApi24(this.audioTrack, eVar);
        }
        this.startMediaTimeUsNeedsInit = true;
        l lVar = this.listener;
        if (lVar != null) {
            lVar.k(this.configuration.buildAudioTrackConfig());
        }
        return true;
    }

    private static boolean isAudioTrackDeadObject(int i) {
        if ((f0.a < 24 || i != -6) && i != ERROR_NATIVE_DEAD_OBJECT) {
            return DEFAULT_SKIP_SILENCE;
        }
        return true;
    }

    private boolean isAudioTrackInitialized() {
        if (this.audioTrack != null) {
            return true;
        }
        return DEFAULT_SKIP_SILENCE;
    }

    private static boolean isOffloadedPlayback(AudioTrack audioTrack) {
        if (f0.a < 29 || !audioTrack.isOffloadedPlayback()) {
            return DEFAULT_SKIP_SILENCE;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$releaseAudioTrackAsync$1(AudioTrack audioTrack, l lVar, Handler handler, k kVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (lVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new a(lVar, kVar, 0));
            }
            synchronized (releaseExecutorLock) {
                try {
                    int i = pendingReleaseCount - 1;
                    pendingReleaseCount = i;
                    if (i == 0) {
                        releaseExecutor.shutdown();
                        releaseExecutor = null;
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            if (lVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new a(lVar, kVar, 0));
            }
            synchronized (releaseExecutorLock) {
                try {
                    int i2 = pendingReleaseCount - 1;
                    pendingReleaseCount = i2;
                    if (i2 == 0) {
                        releaseExecutor.shutdown();
                        releaseExecutor = null;
                    }
                    throw th;
                } finally {
                }
            }
        }
    }

    private void maybeDisableOffload() {
        if (this.configuration.outputModeIsOffload()) {
            this.offloadDisabledUntilNextConfiguration = true;
        }
    }

    private ByteBuffer maybeRampUpVolume(ByteBuffer byteBuffer) {
        if (this.configuration.outputMode == 0) {
            int iQ = (int) f0.q(this.configuration.outputSampleRate, f0.U(20L));
            long writtenFrames = getWrittenFrames();
            if (writtenFrames < iQ) {
                Configuration configuration = this.configuration;
                return qb1.a.x(byteBuffer, configuration.outputEncoding, configuration.outputPcmFrameSize, (int) writtenFrames, iQ);
            }
        }
        return byteBuffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeReportSkippedSilence() {
        if (this.accumulatedSkippedSilenceDurationUs >= 300000) {
            this.listener.d();
            this.accumulatedSkippedSilenceDurationUs = 0L;
        }
    }

    @EnsuresNonNull({"audioCapabilities"})
    private void maybeStartAudioCapabilitiesReceiver() {
        if (this.audioCapabilitiesReceiver == null && this.context != null) {
            this.playbackLooper = Looper.myLooper();
            e eVar = new e(this.context, new f(this), this.audioAttributes, this.preferredDevice);
            this.audioCapabilitiesReceiver = eVar;
            this.audioCapabilities = eVar.b();
        }
        this.audioCapabilities.getClass();
    }

    private void playPendingData() {
        if (this.stoppedAudioTrack) {
            return;
        }
        this.stoppedAudioTrack = true;
        q qVar = this.audioTrackPositionTracker;
        long writtenFrames = getWrittenFrames();
        qVar.z = qVar.b();
        qVar.I.getClass();
        qVar.x = f0.U(SystemClock.elapsedRealtime());
        qVar.A = writtenFrames;
        if (isOffloadedPlayback(this.audioTrack)) {
            this.handledOffloadOnPresentationEnded = DEFAULT_SKIP_SILENCE;
        }
        this.audioTrack.stop();
        this.bytesUntilNextAvSync = 0;
    }

    private void processBuffers(long j2) throws Exception {
        drainOutputBuffer(j2);
        if (this.outputBuffer != null) {
            return;
        }
        if (!this.audioProcessingPipeline.isOperational()) {
            ByteBuffer byteBuffer = this.inputBuffer;
            if (byteBuffer != null) {
                setOutputBuffer(byteBuffer);
                drainOutputBuffer(j2);
                return;
            }
            return;
        }
        while (!this.audioProcessingPipeline.isEnded()) {
            do {
                ByteBuffer output = this.audioProcessingPipeline.getOutput();
                if (output.hasRemaining()) {
                    setOutputBuffer(output);
                    drainOutputBuffer(j2);
                } else {
                    ByteBuffer byteBuffer2 = this.inputBuffer;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.audioProcessingPipeline.queueInput(this.inputBuffer);
                    }
                }
            } while (this.outputBuffer == null);
            return;
        }
    }

    private void registerStreamEventCallbackV29(AudioTrack audioTrack) {
        if (this.offloadStreamEventCallbackV29 == null) {
            this.offloadStreamEventCallbackV29 = new StreamEventCallbackV29(this);
        }
        this.offloadStreamEventCallbackV29.register(audioTrack);
    }

    private static void releaseAudioTrackAsync(AudioTrack audioTrack, l lVar, k kVar) {
        Handler handler = new Handler(Looper.myLooper());
        synchronized (releaseExecutorLock) {
            try {
                if (releaseExecutor == null) {
                    int i = f0.a;
                    releaseExecutor = Executors.newSingleThreadScheduledExecutor(new e0("ExoPlayer:AudioTrackReleaseThread"));
                }
                pendingReleaseCount++;
                releaseExecutor.schedule((Runnable) new c(audioTrack, lVar, handler, kVar, 0), 20L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void resetSinkStateForFlush() {
        this.submittedPcmBytes = 0L;
        this.submittedEncodedFrames = 0L;
        this.writtenPcmBytes = 0L;
        this.writtenEncodedFrames = 0L;
        this.isWaitingForOffloadEndOfStreamHandled = DEFAULT_SKIP_SILENCE;
        this.framesPerEncodedSample = 0;
        this.mediaPositionParameters = new MediaPositionParameters(this.playbackParameters, 0L, 0L);
        this.startMediaTimeUs = 0L;
        this.afterDrainParameters = null;
        this.mediaPositionParametersCheckpoints.clear();
        this.inputBuffer = null;
        this.inputBufferAccessUnitCount = 0;
        this.outputBuffer = null;
        this.stoppedAudioTrack = DEFAULT_SKIP_SILENCE;
        this.handledEndOfStream = DEFAULT_SKIP_SILENCE;
        this.handledOffloadOnPresentationEnded = DEFAULT_SKIP_SILENCE;
        this.avSyncHeader = null;
        this.bytesUntilNextAvSync = 0;
        this.trimmingAudioProcessor.o = 0L;
        setupAudioProcessors(DEFAULT_SKIP_SILENCE);
    }

    private void setAudioProcessorPlaybackParameters(t0 t0Var) {
        MediaPositionParameters mediaPositionParameters = new MediaPositionParameters(t0Var, -9223372036854775807L, -9223372036854775807L);
        if (isAudioTrackInitialized()) {
            this.afterDrainParameters = mediaPositionParameters;
        } else {
            this.mediaPositionParameters = mediaPositionParameters;
        }
    }

    private void setAudioTrackPlaybackParametersV23() {
        if (isAudioTrackInitialized()) {
            try {
                this.audioTrack.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(this.playbackParameters.a).setPitch(this.playbackParameters.b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e) {
                o8.b.r(TAG, "Failed to set playback params", e);
            }
            t0 t0Var = new t0(this.audioTrack.getPlaybackParams().getSpeed(), this.audioTrack.getPlaybackParams().getPitch());
            this.playbackParameters = t0Var;
            q qVar = this.audioTrackPositionTracker;
            qVar.i = t0Var.a;
            o oVar = qVar.e;
            if (oVar != null) {
                oVar.h();
            }
            qVar.g();
        }
    }

    private void setOutputBuffer(ByteBuffer byteBuffer) {
        o8.b.h(this.outputBuffer == null ? true : DEFAULT_SKIP_SILENCE);
        if (byteBuffer.hasRemaining()) {
            this.outputBuffer = maybeRampUpVolume(byteBuffer);
        }
    }

    private void setVolumeInternal() {
        if (isAudioTrackInitialized()) {
            this.audioTrack.setVolume(this.volume);
        }
    }

    private void setupAudioProcessors(boolean z) {
        MpeghAudioProcessingPipeline mpeghAudioProcessingPipeline = this.configuration.audioProcessingPipeline;
        this.audioProcessingPipeline = mpeghAudioProcessingPipeline;
        mpeghAudioProcessingPipeline.flush(z);
    }

    private boolean shouldApplyAudioProcessorPlaybackParameters() {
        if (this.tunneling) {
            return DEFAULT_SKIP_SILENCE;
        }
        Configuration configuration = this.configuration;
        if (configuration.outputMode != 0 || shouldUseFloatOutput(configuration.inputFormat.F)) {
            return DEFAULT_SKIP_SILENCE;
        }
        return true;
    }

    private boolean shouldUseFloatOutput(int i) {
        if (this.enableFloatOutput && f0.M(i)) {
            return true;
        }
        return DEFAULT_SKIP_SILENCE;
    }

    private boolean useAudioTrackPlaybackParams() {
        Configuration configuration = this.configuration;
        if (configuration == null || !configuration.enableAudioTrackPlaybackParams || f0.a < 23) {
            return DEFAULT_SKIP_SILENCE;
        }
        return true;
    }

    private static int writeNonBlocking(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    private int writeNonBlockingWithAvSync(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j2) {
        if (f0.a >= 26) {
            return audioTrack.write(byteBuffer, i, 1, j2 * 1000);
        }
        if (this.avSyncHeader == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.avSyncHeader = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.avSyncHeader.putInt(1431633921);
        }
        if (this.bytesUntilNextAvSync == 0) {
            this.avSyncHeader.putInt(4, i);
            this.avSyncHeader.putLong(8, j2 * 1000);
            this.avSyncHeader.position(0);
            this.bytesUntilNextAvSync = i;
        }
        int iRemaining = this.avSyncHeader.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.avSyncHeader, iRemaining, 1);
            if (iWrite < 0) {
                this.bytesUntilNextAvSync = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iWriteNonBlocking = writeNonBlocking(audioTrack, byteBuffer, i);
        if (iWriteNonBlocking < 0) {
            this.bytesUntilNextAvSync = 0;
            return iWriteNonBlocking;
        }
        this.bytesUntilNextAvSync -= iWriteNonBlocking;
        return iWriteNonBlocking;
    }

    @Override // y8.m
    public void configure(s sVar, int i, int[] iArr) throws AudioSink$ConfigurationException {
        boolean z;
        int i2;
        int i3;
        int i4;
        boolean z2;
        int i6;
        int i7;
        MpeghAudioProcessingPipeline mpeghAudioProcessingPipeline;
        int i8;
        int i9;
        int iP;
        maybeStartAudioCapabilitiesReceiver();
        String str = sVar.n;
        int i10 = sVar.D;
        int i11 = sVar.F;
        if ("audio/raw".equals(str)) {
            o8.b.c(f0.N(i11));
            int iW = f0.w(i11) * i10;
            com.gnacba.common.collect.g0 g0Var = new com.gnacba.common.collect.g0(4);
            g0Var.d(this.toFloatPcmAvailableAudioProcessors);
            MpeghAudioProcessingPipeline mpeghAudioProcessingPipeline2 = new MpeghAudioProcessingPipeline(g0Var.g());
            if (mpeghAudioProcessingPipeline2.equals(this.audioProcessingPipeline)) {
                mpeghAudioProcessingPipeline2 = this.audioProcessingPipeline;
            }
            g0 g0Var2 = this.trimmingAudioProcessor;
            int i12 = sVar.G;
            int i13 = sVar.H;
            g0Var2.i = i12;
            g0Var2.f707j = i13;
            try {
                m8.f fVarConfigure = mpeghAudioProcessingPipeline2.configure(new m8.f(sVar));
                int i14 = fVarConfigure.c;
                int i15 = fVarConfigure.b;
                i3 = fVarConfigure.a;
                int iU = f0.u(i15);
                int iW2 = f0.w(i14) * i15;
                z = this.preferAudioTrackPlaybackParams;
                i4 = iW2;
                i2 = 0;
                i6 = i14;
                i7 = iU;
                mpeghAudioProcessingPipeline = mpeghAudioProcessingPipeline2;
                i8 = iW;
                z2 = false;
            } catch (AudioProcessor$UnhandledAudioFormatException e) {
                throw new AudioSink$ConfigurationException(e, sVar);
            }
        } else {
            MpeghAudioProcessingPipeline mpeghAudioProcessingPipeline3 = new MpeghAudioProcessingPipeline(f1.e);
            int i16 = sVar.E;
            y8.g formatOffloadSupport = this.offloadMode != 0 ? getFormatOffloadSupport(sVar) : y8.g.d;
            if (this.offloadMode == 0 || !formatOffloadSupport.a) {
                Pair pairD = this.audioCapabilities.d(this.audioAttributes, sVar);
                if (pairD == null) {
                    throw new AudioSink$ConfigurationException("Unable to configure passthrough for: " + sVar, sVar);
                }
                int iIntValue = ((Integer) pairD.first).intValue();
                int iIntValue2 = ((Integer) pairD.second).intValue();
                z = this.preferAudioTrackPlaybackParams;
                i2 = 2;
                i3 = i16;
                i4 = -1;
                z2 = false;
                i6 = iIntValue;
                i7 = iIntValue2;
                mpeghAudioProcessingPipeline = mpeghAudioProcessingPipeline3;
                i8 = -1;
            } else {
                str.getClass();
                int iC = q0.c(str, sVar.k);
                int iU2 = f0.u(i10);
                z2 = formatOffloadSupport.b;
                i3 = i16;
                i2 = 1;
                i6 = iC;
                i7 = iU2;
                mpeghAudioProcessingPipeline = mpeghAudioProcessingPipeline3;
                z = true;
                i8 = -1;
                i4 = -1;
            }
        }
        if (i6 == 0) {
            throw new AudioSink$ConfigurationException("Invalid output encoding (mode=" + i2 + ") for: " + sVar, sVar);
        }
        if (i7 == 0) {
            throw new AudioSink$ConfigurationException("Invalid output channel config (mode=" + i2 + ") for: " + sVar, sVar);
        }
        int i17 = sVar.j;
        if ("audio/vnd.dts.hd;profile=lbr".equals(str) && i17 == -1) {
            i17 = 768000;
        }
        int i18 = i17;
        if (i != 0) {
            iP = i;
            i9 = i3;
        } else {
            i9 = i3;
            iP = this.audioTrackBufferSizeProvider.p(getAudioTrackMinBufferSize(i3, i7, i6), i6, i2, i4 != -1 ? i4 : 1, i9, i18, z ? 8.0d : 1.0d);
        }
        this.offloadDisabledUntilNextConfiguration = DEFAULT_SKIP_SILENCE;
        Configuration configuration = new Configuration(sVar, i8, i2, i4, i9, i7, i6, iP, mpeghAudioProcessingPipeline, z, z2, this.tunneling);
        if (isAudioTrackInitialized()) {
            this.pendingConfiguration = configuration;
        } else {
            this.configuration = configuration;
        }
    }

    @Override // y8.m
    public void disableTunneling() {
        if (this.tunneling) {
            this.tunneling = DEFAULT_SKIP_SILENCE;
            flush();
        }
    }

    @Override // y8.m
    public void enableTunnelingV21() {
        o8.b.h(this.externalAudioSessionIdProvided);
        if (this.tunneling) {
            return;
        }
        this.tunneling = true;
        flush();
    }

    @Override // y8.m
    public void flush() {
        OnRoutingChangedListenerApi24 onRoutingChangedListenerApi24;
        if (isAudioTrackInitialized()) {
            resetSinkStateForFlush();
            AudioTrack audioTrack = this.audioTrackPositionTracker.c;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 3) {
                this.audioTrack.pause();
            }
            if (isOffloadedPlayback(this.audioTrack)) {
                StreamEventCallbackV29 streamEventCallbackV29 = this.offloadStreamEventCallbackV29;
                streamEventCallbackV29.getClass();
                streamEventCallbackV29.unregister(this.audioTrack);
            }
            k kVarBuildAudioTrackConfig = this.configuration.buildAudioTrackConfig();
            Configuration configuration = this.pendingConfiguration;
            if (configuration != null) {
                this.configuration = configuration;
                this.pendingConfiguration = null;
            }
            q qVar = this.audioTrackPositionTracker;
            qVar.g();
            qVar.c = null;
            qVar.e = null;
            if (f0.a >= 24 && (onRoutingChangedListenerApi24 = this.onRoutingChangedListener) != null) {
                onRoutingChangedListenerApi24.release();
                this.onRoutingChangedListener = null;
            }
            releaseAudioTrackAsync(this.audioTrack, this.listener, kVarBuildAudioTrackConfig);
            this.audioTrack = null;
        }
        this.writeExceptionPendingExceptionHolder.clear();
        this.initializationExceptionPendingExceptionHolder.clear();
        this.skippedOutputFrameCountAtLastPosition = 0L;
        this.accumulatedSkippedSilenceDurationUs = 0L;
        Handler handler = this.reportSkippedSilenceHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public d getAudioAttributes() {
        return this.audioAttributes;
    }

    @Override // y8.m
    public long getAudioTrackBufferSizeUs() {
        if (!isAudioTrackInitialized()) {
            return -9223372036854775807L;
        }
        if (f0.a >= 23) {
            return Api23.getAudioTrackBufferSizeUs(this.audioTrack, this.configuration);
        }
        Configuration configuration = this.configuration;
        return f0.b0(this.configuration.bufferSize, 1000000L, configuration.outputMode == 0 ? ((long) configuration.outputSampleRate) * ((long) configuration.outputPcmFrameSize) : rt1.f.q(configuration.outputEncoding), RoundingMode.DOWN);
    }

    @Override // y8.m
    public long getCurrentPositionUs(boolean z) {
        if (!isAudioTrackInitialized() || this.startMediaTimeUsNeedsInit) {
            return Long.MIN_VALUE;
        }
        return applySkipping(applyMediaPositionParameters(Math.min(this.audioTrackPositionTracker.a(), this.configuration.framesToDurationUs(getWrittenFrames()))));
    }

    public y8.g getFormatOffloadSupport(s sVar) {
        if (this.offloadDisabledUntilNextConfiguration) {
            return y8.g.d;
        }
        return this.audioOffloadSupportProvider.d(this.audioAttributes, sVar);
    }

    @Override // y8.m
    public int getFormatSupport(s sVar) {
        maybeStartAudioCapabilitiesReceiver();
        String str = sVar.n;
        int i = sVar.F;
        if (!"audio/raw".equals(str)) {
            return this.audioCapabilities.d(this.audioAttributes, sVar) != null ? 2 : 0;
        }
        if (f0.N(i)) {
            return (i == 2 || (this.enableFloatOutput && i == 4)) ? 2 : 1;
        }
        o8.b.q(TAG, "Invalid PCM encoding: " + i);
        return 0;
    }

    @Override // y8.m
    public t0 getPlaybackParameters() {
        return this.playbackParameters;
    }

    public boolean getSkipSilenceEnabled() {
        return this.skipSilenceEnabled;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f9, code lost:
    
        if (r5 == 0) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0173  */
    @Override // y8.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleBuffer(java.nio.ByteBuffer r19, long r20, int r22) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.media3.decoder.mpeghaudio.MpeghAudioSink.handleBuffer(java.nio.ByteBuffer, long, int):boolean");
    }

    @Override // y8.m
    public void handleDiscontinuity() {
        this.startMediaTimeUsNeedsSync = true;
    }

    @Override // y8.m
    public boolean hasPendingData() {
        if (!isAudioTrackInitialized()) {
            return DEFAULT_SKIP_SILENCE;
        }
        if (!(f0.a >= 29 && this.audioTrack.isOffloadedPlayback() && this.handledOffloadOnPresentationEnded) && this.audioTrackPositionTracker.d(getWrittenFrames())) {
            return true;
        }
        return DEFAULT_SKIP_SILENCE;
    }

    @Override // y8.m
    public boolean isEnded() {
        if (!isAudioTrackInitialized()) {
            return true;
        }
        if (!this.handledEndOfStream || hasPendingData()) {
            return DEFAULT_SKIP_SILENCE;
        }
        return true;
    }

    public void onAudioCapabilitiesChanged(b bVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.playbackLooper;
        if (looper != looperMyLooper) {
            throw new IllegalStateException(z.p.f("Current looper (", looperMyLooper != null ? looperMyLooper.getThread().getName() : "null", ") is not the playback looper (", looper == null ? "null" : looper.getThread().getName(), ")"));
        }
        b bVar2 = this.audioCapabilities;
        if (bVar2 == null || bVar.equals(bVar2)) {
            return;
        }
        this.audioCapabilities = bVar;
        l lVar = this.listener;
        if (lVar != null) {
            lVar.l();
        }
    }

    @Override // y8.m
    public void pause() {
        this.playing = DEFAULT_SKIP_SILENCE;
        if (isAudioTrackInitialized()) {
            q qVar = this.audioTrackPositionTracker;
            qVar.g();
            if (qVar.x == -9223372036854775807L) {
                o oVar = qVar.e;
                oVar.getClass();
                oVar.h();
            } else {
                qVar.z = qVar.b();
                if (!isOffloadedPlayback(this.audioTrack)) {
                    return;
                }
            }
            this.audioTrack.pause();
        }
    }

    @Override // y8.m
    public void play() {
        this.playing = true;
        if (isAudioTrackInitialized()) {
            this.audioTrackPositionTracker.i();
            this.audioTrack.play();
        }
    }

    @Override // y8.m
    public void playToEndOfStream() throws AudioSink$WriteException {
        if (!this.handledEndOfStream && isAudioTrackInitialized() && drainToEndOfStream()) {
            this.handledEndOfStream = true;
        }
    }

    public void release() {
        e eVar = this.audioCapabilitiesReceiver;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // y8.m
    public void reset() {
        drainBufferToEndOfStream();
        flush();
        h0 h0VarQ = this.toFloatPcmAvailableAudioProcessors.q(0);
        while (h0VarQ.hasNext()) {
            ((g) h0VarQ.next()).reset();
        }
        MpeghAudioProcessingPipeline mpeghAudioProcessingPipeline = this.audioProcessingPipeline;
        if (mpeghAudioProcessingPipeline != null) {
            mpeghAudioProcessingPipeline.reset();
        }
        this.playing = DEFAULT_SKIP_SILENCE;
        this.offloadDisabledUntilNextConfiguration = DEFAULT_SKIP_SILENCE;
    }

    @Override // y8.m
    public void setAudioAttributes(d dVar) {
        if (this.audioAttributes.equals(dVar)) {
            return;
        }
        this.audioAttributes = dVar;
        if (this.tunneling) {
            return;
        }
        e eVar = this.audioCapabilitiesReceiver;
        if (eVar != null) {
            eVar.c(dVar);
        }
        flush();
    }

    @Override // y8.m
    public void setAudioSessionId(int i) {
        if (this.audioSessionId != i) {
            this.audioSessionId = i;
            this.externalAudioSessionIdProvided = i != 0 ? true : DEFAULT_SKIP_SILENCE;
            flush();
        }
    }

    @Override // y8.m
    public void setAuxEffectInfo(l8.e eVar) {
        if (this.auxEffectInfo.equals(eVar)) {
            return;
        }
        eVar.getClass();
        if (this.audioTrack != null) {
            this.auxEffectInfo.getClass();
        }
        this.auxEffectInfo = eVar;
    }

    @Override // y8.m
    public void setClock(o8.e eVar) {
        this.audioTrackPositionTracker.I = eVar;
    }

    @Override // y8.m
    public void setListener(l lVar) {
        this.listener = lVar;
    }

    public void setOffloadDelayPadding(int i, int i2) {
        Configuration configuration;
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack == null || !isOffloadedPlayback(audioTrack) || (configuration = this.configuration) == null || !configuration.enableOffloadGapless) {
            return;
        }
        this.audioTrack.setOffloadDelayPadding(i, i2);
    }

    public void setOffloadMode(int i) {
        o8.b.h(f0.a >= 29 ? true : DEFAULT_SKIP_SILENCE);
        this.offloadMode = i;
    }

    @Override // y8.m
    public /* bridge */ /* synthetic */ void setOutputStreamOffsetUs(long j2) {
    }

    @Override // y8.m
    public void setPlaybackParameters(t0 t0Var) {
        this.playbackParameters = new t0(f0.h(t0Var.a, 0.1f, 8.0f), f0.h(t0Var.b, 0.1f, 8.0f));
        if (useAudioTrackPlaybackParams()) {
            setAudioTrackPlaybackParametersV23();
        } else {
            setAudioProcessorPlaybackParameters(t0Var);
        }
    }

    @Override // y8.m
    public void setPlayerId(x8.m mVar) {
        this.playerId = mVar;
    }

    @Override // y8.m
    public void setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
        this.preferredDevice = audioDeviceInfo == null ? null : new f(audioDeviceInfo);
        e eVar = this.audioCapabilitiesReceiver;
        if (eVar != null) {
            eVar.d(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            Api23.setPreferredDeviceOnAudioTrack(audioTrack, this.preferredDevice);
        }
    }

    @Override // y8.m
    public void setSkipSilenceEnabled(boolean z) {
        this.skipSilenceEnabled = z;
        setAudioProcessorPlaybackParameters(useAudioTrackPlaybackParams() ? t0.d : this.playbackParameters);
    }

    @Override // y8.m
    public void setVolume(float f2) {
        if (this.volume != f2) {
            this.volume = f2;
            setVolumeInternal();
        }
    }

    @Override // y8.m
    public boolean supportsFormat(s sVar) {
        if (getFormatSupport(sVar) != 0) {
            return true;
        }
        return DEFAULT_SKIP_SILENCE;
    }

    @RequiresNonNull({"#1.audioProcessorChain"})
    private MpeghAudioSink(Builder builder) {
        Context context = builder.context;
        this.context = context;
        this.audioAttributes = d.g;
        this.audioCapabilities = context != null ? null : builder.audioCapabilities;
        this.audioProcessorChain = builder.audioProcessorChain;
        this.appRootPath = builder.appRootPath;
        this.enableFloatOutput = builder.enableFloatOutput;
        this.preferAudioTrackPlaybackParams = f0.a >= 23 && builder.enableAudioTrackPlaybackParams;
        this.offloadMode = 0;
        this.audioTrackBufferSizeProvider = builder.audioTrackBufferSizeProvider;
        u uVar = builder.audioOffloadSupportProvider;
        uVar.getClass();
        this.audioOffloadSupportProvider = uVar;
        this.audioTrackPositionTracker = new q(new PositionTrackerListener());
        g0 g0Var = new g0();
        this.trimmingAudioProcessor = g0Var;
        VirtualizerAudioProcessor virtualizerAudioProcessor = new VirtualizerAudioProcessor(this.appRootPath);
        this.virtualizerProcessor = virtualizerAudioProcessor;
        AlcAudioProcessor alcAudioProcessor = new AlcAudioProcessor();
        this.alcProcessor = alcAudioProcessor;
        this.toFloatPcmAvailableAudioProcessors = k0.u(g0Var, virtualizerAudioProcessor, alcAudioProcessor);
        this.volume = 1.0f;
        this.audioSessionId = 0;
        this.auxEffectInfo = new l8.e();
        t0 t0Var = t0.d;
        this.mediaPositionParameters = new MediaPositionParameters(t0Var, 0L, 0L);
        this.playbackParameters = t0Var;
        this.skipSilenceEnabled = DEFAULT_SKIP_SILENCE;
        this.mediaPositionParametersCheckpoints = new ArrayDeque<>();
        this.initializationExceptionPendingExceptionHolder = new PendingExceptionHolder<>();
        this.writeExceptionPendingExceptionHolder = new PendingExceptionHolder<>();
        this.audioOffloadListener = builder.audioOffloadListener;
        this.audioTrackProvider = builder.audioTrackProvider;
    }

    /* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
    public static final class Builder {
        private String appRootPath;
        private b audioCapabilities;
        private w8.m audioOffloadListener;
        private u audioOffloadSupportProvider;
        private h audioProcessorChain;
        private v audioTrackBufferSizeProvider;
        private w audioTrackProvider;
        private boolean buildCalled;
        private final Context context;
        private boolean enableAudioTrackPlaybackParams;
        private boolean enableFloatOutput;

        @Deprecated
        public Builder() {
            this.context = null;
            this.audioCapabilities = b.c;
            this.audioTrackBufferSizeProvider = v.h2;
            this.audioTrackProvider = w.a;
        }

        public MpeghAudioSink build() {
            o8.b.h(!this.buildCalled);
            this.buildCalled = true;
            if (this.audioProcessorChain == null) {
                this.audioProcessorChain = new DefaultAudioProcessorChain(new g[0]);
            }
            if (this.audioOffloadSupportProvider == null) {
                this.audioOffloadSupportProvider = new j(this.context);
            }
            return new MpeghAudioSink(this);
        }

        public Builder setAppRootPath(String str) {
            this.appRootPath = str;
            return this;
        }

        @Deprecated
        public Builder setAudioCapabilities(b bVar) {
            bVar.getClass();
            this.audioCapabilities = bVar;
            return this;
        }

        public Builder setAudioOffloadSupportProvider(u uVar) {
            this.audioOffloadSupportProvider = uVar;
            return this;
        }

        public Builder setAudioProcessorChain(h hVar) {
            hVar.getClass();
            this.audioProcessorChain = hVar;
            return this;
        }

        public Builder setAudioProcessors(g[] gVarArr) {
            gVarArr.getClass();
            return setAudioProcessorChain(new DefaultAudioProcessorChain(gVarArr));
        }

        public Builder setAudioTrackBufferSizeProvider(v vVar) {
            this.audioTrackBufferSizeProvider = vVar;
            return this;
        }

        public Builder setAudioTrackProvider(w wVar) {
            this.audioTrackProvider = wVar;
            return this;
        }

        public Builder setEnableAudioTrackPlaybackParams(boolean z) {
            this.enableAudioTrackPlaybackParams = z;
            return this;
        }

        public Builder setEnableFloatOutput(boolean z) {
            this.enableFloatOutput = z;
            return this;
        }

        public Builder setExperimentalAudioOffloadListener(w8.m mVar) {
            this.audioOffloadListener = mVar;
            return this;
        }

        public Builder(Context context) {
            this.context = context;
            this.audioCapabilities = b.c;
            this.audioTrackBufferSizeProvider = v.h2;
            this.audioTrackProvider = w.a;
        }
    }

    private AudioTrack buildAudioTrack(k kVar, d dVar, int i, s sVar) throws AudioSink$InitializationException {
        try {
        } catch (IllegalArgumentException e) {
            e = e;
        } catch (UnsupportedOperationException e2) {
            e = e2;
        }
        try {
            AudioTrack audioTrackA = ((b0) this.audioTrackProvider).a(kVar, dVar, i);
            int state = audioTrackA.getState();
            if (state == 1) {
                return audioTrackA;
            }
            try {
                audioTrackA.release();
            } catch (Exception unused) {
            }
            throw new AudioSink$InitializationException(state, kVar.b, kVar.c, kVar.a, sVar, kVar.e, null);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw new AudioSink$InitializationException(0, kVar.b, kVar.c, kVar.a, sVar, kVar.e, e);
        } catch (UnsupportedOperationException e4) {
            e = e4;
            throw new AudioSink$InitializationException(0, kVar.b, kVar.c, kVar.a, sVar, kVar.e, e);
        }
    }
}
