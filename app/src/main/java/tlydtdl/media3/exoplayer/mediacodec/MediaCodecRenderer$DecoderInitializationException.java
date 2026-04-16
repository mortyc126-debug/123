package tlydtdl.media3.exoplayer.mediacodec;

import c9.n;
import l8.s;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class MediaCodecRenderer$DecoderInitializationException extends Exception {
    public final String a;
    public final boolean b;
    public final n c;
    public final String d;

    public MediaCodecRenderer$DecoderInitializationException(s sVar, MediaCodecUtil$DecoderQueryException mediaCodecUtil$DecoderQueryException, boolean z, int i) {
        this("Decoder init failed: [" + i + "], " + sVar, mediaCodecUtil$DecoderQueryException, sVar.n, z, null, "tlydtdl.media3.exoplayer.mediacodec.MediaCodecRenderer_" + (i < 0 ? "neg_" : HttpUrl.FRAGMENT_ENCODE_SET) + Math.abs(i));
    }

    public MediaCodecRenderer$DecoderInitializationException(String str, Throwable th, String str2, boolean z, n nVar, String str3) {
        super(str, th);
        this.a = str2;
        this.b = z;
        this.c = nVar;
        this.d = str3;
    }
}
