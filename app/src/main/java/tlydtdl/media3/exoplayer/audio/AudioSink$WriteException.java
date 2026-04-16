package tlydtdl.media3.exoplayer.audio;

import l8.s;
import o6.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioSink$WriteException extends Exception {
    public final int a;
    public final boolean b;
    public final s c;

    public AudioSink$WriteException(int i, s sVar, boolean z) {
        super(c.k(i, "AudioTrack write failed: "));
        this.b = z;
        this.a = i;
        this.c = sVar;
    }
}
