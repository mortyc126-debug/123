package tlydtdl.media3.exoplayer.audio;

import f3.f2;
import l8.s;
import okhttp3.HttpUrl;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioSink$InitializationException extends Exception {
    public final int a;
    public final boolean b;
    public final s c;

    /* JADX WARN: Illegal instructions before constructor call */
    public AudioSink$InitializationException(int i, int i2, int i3, int i4, s sVar, boolean z, RuntimeException runtimeException) {
        StringBuilder sbI = p.i(i, i2, "AudioTrack init failed ", " Config(", ", ");
        f2.A(sbI, i3, ", ", i4, ") ");
        sbI.append(sVar);
        sbI.append(z ? " (recoverable)" : HttpUrl.FRAGMENT_ENCODE_SET);
        super(sbI.toString(), runtimeException);
        this.a = i;
        this.b = z;
        this.c = sVar;
    }
}
