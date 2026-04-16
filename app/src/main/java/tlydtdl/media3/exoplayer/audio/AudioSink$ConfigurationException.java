package tlydtdl.media3.exoplayer.audio;

import l8.s;
import tlydtdl.media3.common.audio.AudioProcessor$UnhandledAudioFormatException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioSink$ConfigurationException extends Exception {
    public final s a;

    public AudioSink$ConfigurationException(AudioProcessor$UnhandledAudioFormatException audioProcessor$UnhandledAudioFormatException, s sVar) {
        super(audioProcessor$UnhandledAudioFormatException);
        this.a = sVar;
    }

    public AudioSink$ConfigurationException(String str, s sVar) {
        super(str);
        this.a = sVar;
    }
}
