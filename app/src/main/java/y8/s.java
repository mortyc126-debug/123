package y8;

import amuvvoafs.os.Handler;
import com.airbnb.lottie.e;
import tlydtdl.media3.decoder.mpeghaudio.MpeghAudioRenderer;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements l {
    public final /* synthetic */ MpeghAudioRenderer a;

    public s(MpeghAudioRenderer mpeghAudioRenderer) {
        this.a = mpeghAudioRenderer;
    }

    @Override // y8.l
    public final void c(boolean z) {
        i iVar = ((t) this.a).eventDispatcher;
        Handler handler = iVar.a;
        if (handler != null) {
            handler.post(new e(iVar, z, 3));
        }
    }

    @Override // y8.l
    public final void d() {
        ((t) this.a).hasPendingReportedSkippedSilence = true;
    }

    @Override // y8.l
    public final void f(Exception exc) {
        o8.b.n("DecoderAudioRenderer", "Audio sink error", exc);
        i iVar = ((t) this.a).eventDispatcher;
        Handler handler = iVar.a;
        if (handler != null) {
            handler.post(new h(iVar, exc, 6));
        }
    }

    @Override // y8.l
    public final void i(long j2, long j3, int i) {
        i iVar = ((t) this.a).eventDispatcher;
        Handler handler = iVar.a;
        if (handler != null) {
            handler.post(new h(iVar, i, j2, j3));
        }
    }

    @Override // y8.l
    public final void k(k kVar) {
        i iVar = ((t) this.a).eventDispatcher;
        Handler handler = iVar.a;
        if (handler != null) {
            handler.post(new h(iVar, kVar, 3));
        }
    }

    @Override // y8.l
    public final void m(k kVar) {
        i iVar = ((t) this.a).eventDispatcher;
        Handler handler = iVar.a;
        if (handler != null) {
            handler.post(new h(iVar, kVar, 4));
        }
    }

    @Override // y8.l
    public final void n() {
        this.a.onPositionDiscontinuity();
    }

    @Override // y8.l
    public final void onPositionAdvancing(long j2) {
        i iVar = ((t) this.a).eventDispatcher;
        Handler handler = iVar.a;
        if (handler != null) {
            handler.post(new h(iVar, j2));
        }
    }
}
