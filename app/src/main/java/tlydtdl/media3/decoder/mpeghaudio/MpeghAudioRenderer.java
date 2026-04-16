package tlydtdl.media3.decoder.mpeghaudio;

import amuvvoafs.os.Handler;
import l8.q0;
import l8.r;
import l8.s;
import m8.g;
import o8.d;
import o8.f0;
import tlydtdl.media3.decoder.mpeghaudio.MpeghAudioSink;
import tlydtdl.media3.exoplayer.ExoPlaybackException;
import u8.a;
import y8.j;
import y8.t;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class MpeghAudioRenderer extends t {
    private static final int DEFAULT_INPUT_BUFFER_SIZE = 5760;
    private static final int NUM_BUFFERS = 16;
    private static final String TAG = "MpeghAudioRenderer";
    private final boolean enableFloatOutput;

    public MpeghAudioRenderer(Handler handler, j jVar, String str, boolean z) {
        super(handler, jVar, new MpeghAudioSink.Builder().setAudioProcessorChain(new MpeghAudioSink.DefaultAudioProcessorChain(new g[0])).setAppRootPath(str).setEnableFloatOutput(z).setEnableAudioTrackPlaybackParams(false).build());
        this.enableFloatOutput = z;
    }

    private boolean sinkSupportsFormat(s sVar, int i) {
        return sinkSupportsFormat(f0.E(i, sVar.D, sVar.E));
    }

    @Override // w8.e
    public /* bridge */ /* synthetic */ void enableMayRenderStartOfStream() {
    }

    @Override // w8.e, w8.l1
    public String getName() {
        return TAG;
    }

    @Override // w8.e
    public /* bridge */ /* synthetic */ void setPlaybackSpeed(float f2, float f3) throws ExoPlaybackException {
    }

    @Override // y8.t
    public int supportsFormatInternal(s sVar) {
        String str = sVar.n;
        str.getClass();
        if (!MpeghLibrary.isAvailable() || !q0.i(str)) {
            return 0;
        }
        if (!MpeghLibrary.supportsFormat(str)) {
            return 1;
        }
        if (sinkSupportsFormat(sVar, 2) || sinkSupportsFormat(sVar, 4)) {
            return sVar.M != 0 ? 2 : 4;
        }
        return 1;
    }

    @Override // w8.e, w8.l1
    public int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    @Override // y8.t
    /* JADX INFO: renamed from: createDecoder, reason: merged with bridge method [inline-methods] */
    public MpeghDecoder mo1793createDecoder(s sVar, a aVar) throws MpeghDecoderException {
        d.b("createMpeghDecoder");
        MpeghDecoder mpeghDecoder = new MpeghDecoder(16, 16, DEFAULT_INPUT_BUFFER_SIZE, sVar.n, sVar.q, this.enableFloatOutput);
        d.q();
        return mpeghDecoder;
    }

    @Override // y8.t
    public s getOutputFormat(MpeghDecoder mpeghDecoder) {
        mpeghDecoder.getClass();
        r rVar = new r();
        rVar.r("audio/raw");
        rVar.b(mpeghDecoder.getChannelCount());
        rVar.s(mpeghDecoder.getSampleRate());
        rVar.o(mpeghDecoder.getEncoding());
        return rVar.a();
    }
}
