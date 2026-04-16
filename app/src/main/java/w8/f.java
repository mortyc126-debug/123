package w8;

import f3.f2;
import java.util.Locale;
import o8.f0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f631f;
    public int g;
    public int h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f632j;
    public long k;
    public int l;

    public final String toString() {
        int i = this.a;
        int i2 = this.b;
        int i3 = this.c;
        int i4 = this.d;
        int i6 = this.e;
        int i7 = this.f631f;
        int i8 = this.g;
        int i9 = this.h;
        int i10 = this.i;
        int i11 = this.f632j;
        long j2 = this.k;
        int i12 = this.l;
        int i13 = f0.a;
        Locale locale = Locale.US;
        StringBuilder sbI = z.p.i(i, i2, "DecoderCounters {\n decoderInits=", ",\n decoderReleases=", "\n queuedInputBuffers=");
        f2.A(sbI, i3, "\n skippedInputBuffers=", i4, "\n renderedOutputBuffers=");
        f2.A(sbI, i6, "\n skippedOutputBuffers=", i7, "\n droppedBuffers=");
        f2.A(sbI, i8, "\n droppedInputBuffers=", i9, "\n maxConsecutiveDroppedBuffers=");
        f2.A(sbI, i10, "\n droppedToKeyframeEvents=", i11, "\n totalVideoFrameProcessingOffsetUs=");
        sbI.append(j2);
        sbI.append("\n videoFrameProcessingOffsetCount=");
        sbI.append(i12);
        sbI.append("\n}");
        return sbI.toString();
    }
}
