package y8;

import amuvvoafs.media.AudioDeviceInfo;
import java.nio.ByteBuffer;
import l8.d;
import l8.e;
import l8.t0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public interface m {
    void configure(l8.s sVar, int i, int[] iArr);

    void disableTunneling();

    void enableTunnelingV21();

    void flush();

    long getAudioTrackBufferSizeUs();

    long getCurrentPositionUs(boolean z);

    int getFormatSupport(l8.s sVar);

    t0 getPlaybackParameters();

    boolean handleBuffer(ByteBuffer byteBuffer, long j2, int i);

    void handleDiscontinuity();

    boolean hasPendingData();

    boolean isEnded();

    void pause();

    void play();

    void playToEndOfStream();

    void reset();

    void setAudioAttributes(d dVar);

    void setAudioSessionId(int i);

    void setAuxEffectInfo(e eVar);

    void setClock(o8.e eVar);

    void setListener(l lVar);

    default void setOutputStreamOffsetUs(long j2) {
    }

    void setPlaybackParameters(t0 t0Var);

    void setPlayerId(x8.m mVar);

    void setPreferredDevice(AudioDeviceInfo audioDeviceInfo);

    void setSkipSilenceEnabled(boolean z);

    void setVolume(float f2);

    boolean supportsFormat(l8.s sVar);
}
