package y8;

import java.nio.ByteBuffer;
import m8.f;
import tlydtdl.media3.common.audio.AudioProcessor$UnhandledAudioFormatException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends m8.i {
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f707j;
    public boolean k;
    public int l;
    public byte[] m = o8.f0.c;
    public int n;
    public long o;

    @Override // m8.i
    public final f a(f fVar) throws AudioProcessor$UnhandledAudioFormatException {
        int i = fVar.c;
        if (i != 2 && i != 4) {
            throw new AudioProcessor$UnhandledAudioFormatException(fVar);
        }
        this.k = true;
        return (this.i == 0 && this.f707j == 0) ? f.e : fVar;
    }

    @Override // m8.i
    public final void b() {
        if (this.k) {
            this.k = false;
            int i = this.f707j;
            int i2 = this.b.d;
            this.m = new byte[i * i2];
            this.l = this.i * i2;
        }
        this.n = 0;
    }

    @Override // m8.i
    public final void c() {
        if (this.k) {
            int i = this.n;
            if (i > 0) {
                this.o += (long) (i / this.b.d);
            }
            this.n = 0;
        }
    }

    @Override // m8.i
    public final void d() {
        this.m = o8.f0.c;
    }

    @Override // m8.g
    public final long getDurationAfterProcessorApplied(long j2) {
        return j2 - o8.f0.Z(this.b.a, this.f707j + this.i);
    }

    @Override // m8.i, m8.g
    public final ByteBuffer getOutput() {
        int i;
        if (super.isEnded() && (i = this.n) > 0) {
            e(i).put(this.m, 0, this.n).flip();
            this.n = 0;
        }
        return super.getOutput();
    }

    @Override // m8.i, m8.g
    public final boolean isEnded() {
        return super.isEnded() && this.n == 0;
    }

    @Override // m8.g
    public final void queueInput(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        if (i == 0) {
            return;
        }
        int iMin = Math.min(i, this.l);
        this.o += (long) (iMin / this.b.d);
        this.l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.l > 0) {
            return;
        }
        int i2 = i - iMin;
        int length = (this.n + i2) - this.m.length;
        ByteBuffer byteBufferE = e(length);
        int i3 = o8.f0.i(length, 0, this.n);
        byteBufferE.put(this.m, 0, i3);
        int i4 = o8.f0.i(length - i3, 0, i2);
        byteBuffer.limit(byteBuffer.position() + i4);
        byteBufferE.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i6 = i2 - i4;
        int i7 = this.n - i3;
        this.n = i7;
        byte[] bArr = this.m;
        System.arraycopy(bArr, i3, bArr, 0, i7);
        byteBuffer.get(this.m, this.n, i6);
        this.n += i6;
        byteBufferE.flip();
    }
}
