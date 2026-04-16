package y8;

import amuvvoafs.media.AudioAttributes;
import amuvvoafs.media.AudioTrack;
import l8.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements w {
    public static AudioAttributes b(d dVar, boolean z) {
        return z ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : (AudioAttributes) dVar.b().a;
    }

    public final AudioTrack a(k kVar, d dVar, int i) {
        int i2 = o8.f0.a;
        if (i2 < 23) {
            return new AudioTrack(b(dVar, kVar.d), o8.f0.t(kVar.b, kVar.c, kVar.a), kVar.f, 1, i);
        }
        AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(b(dVar, kVar.d)).setAudioFormat(o8.f0.t(kVar.b, kVar.c, kVar.a)).setTransferMode(1).setBufferSizeInBytes(kVar.f).setSessionId(i);
        if (i2 >= 29) {
            sessionId.setOffloadedPlayback(kVar.e);
        }
        return sessionId.build();
    }
}
