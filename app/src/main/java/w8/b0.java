package w8;

import amuvvoafs.media.MediaFormat;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements l9.t, m9.a, h1 {
    public l9.t a;
    public m9.a b;
    public l9.t c;
    public m9.a d;

    public final void a(long j2, float[] fArr) {
        m9.a aVar = this.d;
        if (aVar != null) {
            aVar.a(j2, fArr);
        }
        m9.a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.a(j2, fArr);
        }
    }

    public final void b() {
        m9.a aVar = this.d;
        if (aVar != null) {
            aVar.b();
        }
        m9.a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    public final void c(long j2, long j3, l8.s sVar, MediaFormat mediaFormat) {
        long j4;
        long j5;
        l8.s sVar2;
        MediaFormat mediaFormat2;
        l9.t tVar = this.c;
        if (tVar != null) {
            tVar.c(j2, j3, sVar, mediaFormat);
            mediaFormat2 = mediaFormat;
            sVar2 = sVar;
            j5 = j3;
            j4 = j2;
        } else {
            j4 = j2;
            j5 = j3;
            sVar2 = sVar;
            mediaFormat2 = mediaFormat;
        }
        l9.t tVar2 = this.a;
        if (tVar2 != null) {
            tVar2.c(j4, j5, sVar2, mediaFormat2);
        }
    }

    @Override // w8.h1
    public final void handleMessage(int i, Object obj) {
        if (i == 7) {
            this.a = (l9.t) obj;
            return;
        }
        if (i == 8) {
            this.b = (m9.a) obj;
            return;
        }
        if (i != 10000) {
            return;
        }
        m9.k kVar = (m9.k) obj;
        if (kVar == null) {
            this.c = null;
            this.d = null;
        } else {
            this.c = kVar.getVideoFrameMetadataListener();
            this.d = kVar.getCameraMotionListener();
        }
    }
}
