package y8;

import java.nio.ByteBuffer;
import kotlin.UByte;
import m8.f;
import tlydtdl.media3.common.audio.AudioProcessor$UnhandledAudioFormatException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends m8.i {
    public static final int i = Float.floatToIntBits(Float.NaN);

    public static void f(int i2, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i2) * 4.656612875245797E-10d));
        if (iFloatToIntBits == i) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // m8.i
    public final f a(f fVar) throws AudioProcessor$UnhandledAudioFormatException {
        int i2 = fVar.c;
        if (o8.f0.M(i2)) {
            return i2 != 4 ? new f(fVar.a, fVar.b, 4) : f.e;
        }
        throw new AudioProcessor$UnhandledAudioFormatException(fVar);
    }

    @Override // m8.g
    public final void queueInput(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferE;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit - iPosition;
        int i3 = this.b.c;
        if (i3 == 21) {
            byteBufferE = e((i2 / 3) * 4);
            while (iPosition < iLimit) {
                f(((byteBuffer.get(iPosition) & UByte.MAX_VALUE) << 8) | ((byteBuffer.get(iPosition + 1) & UByte.MAX_VALUE) << 16) | ((byteBuffer.get(iPosition + 2) & UByte.MAX_VALUE) << 24), byteBufferE);
                iPosition += 3;
            }
        } else if (i3 == 22) {
            byteBufferE = e(i2);
            while (iPosition < iLimit) {
                f((byteBuffer.get(iPosition) & UByte.MAX_VALUE) | ((byteBuffer.get(iPosition + 1) & UByte.MAX_VALUE) << 8) | ((byteBuffer.get(iPosition + 2) & UByte.MAX_VALUE) << 16) | ((byteBuffer.get(iPosition + 3) & UByte.MAX_VALUE) << 24), byteBufferE);
                iPosition += 4;
            }
        } else if (i3 == 1342177280) {
            byteBufferE = e((i2 / 3) * 4);
            while (iPosition < iLimit) {
                f(((byteBuffer.get(iPosition + 2) & UByte.MAX_VALUE) << 8) | ((byteBuffer.get(iPosition + 1) & UByte.MAX_VALUE) << 16) | ((byteBuffer.get(iPosition) & UByte.MAX_VALUE) << 24), byteBufferE);
                iPosition += 3;
            }
        } else {
            if (i3 != 1610612736) {
                throw new IllegalStateException();
            }
            byteBufferE = e(i2);
            while (iPosition < iLimit) {
                f((byteBuffer.get(iPosition + 3) & UByte.MAX_VALUE) | ((byteBuffer.get(iPosition + 2) & UByte.MAX_VALUE) << 8) | ((byteBuffer.get(iPosition + 1) & UByte.MAX_VALUE) << 16) | ((byteBuffer.get(iPosition) & UByte.MAX_VALUE) << 24), byteBufferE);
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferE.flip();
    }
}
