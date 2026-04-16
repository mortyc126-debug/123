package y8;

import java.nio.ByteBuffer;
import java.util.Arrays;
import m8.f;
import tlydtdl.media3.common.audio.AudioProcessor$UnhandledAudioFormatException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends m8.i {
    public int[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f710j;

    @Override // m8.i
    public final f a(f fVar) throws AudioProcessor$UnhandledAudioFormatException {
        int i = fVar.c;
        int[] iArr = this.i;
        if (iArr == null) {
            return f.e;
        }
        int i2 = fVar.b;
        if (i != 2 && i != 4) {
            throw new AudioProcessor$UnhandledAudioFormatException(fVar);
        }
        boolean z = i2 != iArr.length;
        int i3 = 0;
        while (i3 < iArr.length) {
            int i4 = iArr[i3];
            if (i4 >= i2) {
                throw new AudioProcessor$UnhandledAudioFormatException("Channel map (" + Arrays.toString(iArr) + ") trying to access non-existent input channel.", fVar);
            }
            z |= i4 != i3;
            i3++;
        }
        return z ? new f(fVar.a, iArr.length, i) : f.e;
    }

    @Override // m8.i
    public final void b() {
        this.f710j = this.i;
    }

    @Override // m8.i
    public final void d() {
        this.f710j = null;
        this.i = null;
    }

    @Override // m8.g
    public final void queueInput(ByteBuffer byteBuffer) {
        int[] iArr = this.f710j;
        iArr.getClass();
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferE = e(((iLimit - iPosition) / this.b.d) * this.c.d);
        while (iPosition < iLimit) {
            for (int i : iArr) {
                int iW = (o8.f0.w(this.b.c) * i) + iPosition;
                int i2 = this.b.c;
                if (i2 == 2) {
                    byteBufferE.putShort(byteBuffer.getShort(iW));
                } else {
                    if (i2 != 4) {
                        throw new IllegalStateException("Unexpected encoding: " + this.b.c);
                    }
                    byteBufferE.putFloat(byteBuffer.getFloat(iW));
                }
            }
            iPosition += this.b.d;
        }
        byteBuffer.position(iLimit);
        byteBufferE.flip();
    }
}
