package y8;

import java.nio.ByteBuffer;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import m8.f;
import tlydtdl.media3.common.audio.AudioProcessor$UnhandledAudioFormatException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends m8.i {
    public int n;
    public boolean o;
    public int p;
    public long q;
    public byte[] s;
    public byte[] v;
    public int r = 0;
    public int t = 0;
    public int u = 0;
    public final long l = 100000;
    public final float i = 0.2f;
    public final long m = 2000000;
    public final int k = 10;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final short f706j = 1024;

    public e0() {
        byte[] bArr = o8.f0.c;
        this.s = bArr;
        this.v = bArr;
    }

    @Override // m8.i
    public final f a(f fVar) throws AudioProcessor$UnhandledAudioFormatException {
        if (fVar.c == 2) {
            return fVar.a == -1 ? f.e : fVar;
        }
        throw new AudioProcessor$UnhandledAudioFormatException(fVar);
    }

    @Override // m8.i
    public final void b() {
        if (isActive()) {
            f fVar = this.b;
            int i = fVar.b * 2;
            this.n = i;
            int i2 = ((((int) ((this.l * ((long) fVar.a)) / 1000000)) / 2) / i) * i * 2;
            if (this.s.length != i2) {
                this.s = new byte[i2];
                this.v = new byte[i2];
            }
        }
        this.p = 0;
        this.q = 0L;
        this.r = 0;
        this.t = 0;
        this.u = 0;
    }

    @Override // m8.i
    public final void c() {
        if (this.u > 0) {
            g(true);
            this.r = 0;
        }
    }

    @Override // m8.i
    public final void d() {
        this.o = false;
        byte[] bArr = o8.f0.c;
        this.s = bArr;
        this.v = bArr;
    }

    public final int f(int i) {
        int length = ((((int) ((this.m * ((long) this.b.a)) / 1000000)) - this.r) * this.n) - (this.s.length / 2);
        o8.b.h(length >= 0);
        int iMin = (int) Math.min((i * this.i) + 0.5f, length);
        int i2 = this.n;
        return (iMin / i2) * i2;
    }

    public final void g(boolean z) {
        int length;
        int iF;
        int i = this.u;
        byte[] bArr = this.s;
        if (i == bArr.length || z) {
            if (this.r == 0) {
                if (z) {
                    h(i, 3);
                    length = i;
                } else {
                    o8.b.h(i >= bArr.length / 2);
                    length = this.s.length / 2;
                    h(length, 0);
                }
                iF = length;
            } else if (z) {
                int length2 = i - (bArr.length / 2);
                int length3 = (bArr.length / 2) + length2;
                int iF2 = f(length2) + (this.s.length / 2);
                h(iF2, 2);
                iF = iF2;
                length = length3;
            } else {
                length = i - (bArr.length / 2);
                iF = f(length);
                h(iF, 1);
            }
            o8.b.g("bytesConsumed is not aligned to frame size: %s" + length, length % this.n == 0);
            o8.b.h(i >= iF);
            this.u -= length;
            int i2 = this.t + length;
            this.t = i2;
            this.t = i2 % this.s.length;
            int i3 = this.r;
            int i4 = this.n;
            this.r = (iF / i4) + i3;
            this.q += (long) ((length - iF) / i4);
        }
    }

    public final void h(int i, int i2) {
        if (i == 0) {
            return;
        }
        o8.b.c(this.u >= i);
        if (i2 == 2) {
            int i3 = this.t;
            int i4 = this.u;
            int i6 = i3 + i4;
            byte[] bArr = this.s;
            if (i6 <= bArr.length) {
                System.arraycopy(bArr, i6 - i, this.v, 0, i);
            } else {
                int length = i4 - (bArr.length - i3);
                if (length >= i) {
                    System.arraycopy(bArr, length - i, this.v, 0, i);
                } else {
                    int i7 = i - length;
                    System.arraycopy(bArr, bArr.length - i7, this.v, 0, i7);
                    System.arraycopy(this.s, 0, this.v, i7, length);
                }
            }
        } else {
            int i8 = this.t;
            int i9 = i8 + i;
            byte[] bArr2 = this.s;
            if (i9 <= bArr2.length) {
                System.arraycopy(bArr2, i8, this.v, 0, i);
            } else {
                int length2 = bArr2.length - i8;
                System.arraycopy(bArr2, i8, this.v, 0, length2);
                System.arraycopy(this.s, 0, this.v, length2, i - length2);
            }
        }
        o8.b.b("sizeToOutput is not aligned to frame size: " + i, i % this.n == 0);
        o8.b.h(this.t < this.s.length);
        byte[] bArr3 = this.v;
        o8.b.b("byteOutput size is not aligned to frame size " + i, i % this.n == 0);
        if (i2 != 3) {
            for (int i10 = 0; i10 < i; i10 += 2) {
                int i11 = i10 + 1;
                int i12 = (bArr3[i11] << 8) | (bArr3[i10] & UByte.MAX_VALUE);
                int i13 = this.k;
                if (i2 == 0) {
                    i13 = ((((i10 * 1000) / (i - 1)) * (i13 - 100)) / 1000) + 100;
                } else if (i2 == 2) {
                    i13 += (((i10 * 1000) * (100 - i13)) / (i - 1)) / 1000;
                }
                int i14 = (i12 * i13) / 100;
                if (i14 >= 32767) {
                    bArr3[i10] = -1;
                    bArr3[i11] = ByteCompanionObject.MAX_VALUE;
                } else if (i14 <= -32768) {
                    bArr3[i10] = 0;
                    bArr3[i11] = ByteCompanionObject.MIN_VALUE;
                } else {
                    bArr3[i10] = (byte) (i14 & 255);
                    bArr3[i11] = (byte) (i14 >> 8);
                }
            }
        }
        e(i).put(bArr3, 0, i).flip();
    }

    @Override // m8.i, m8.g
    public final boolean isActive() {
        return super.isActive() && this.o;
    }

    @Override // m8.g
    public final void queueInput(ByteBuffer byteBuffer) {
        int iLimit;
        int iPosition;
        while (byteBuffer.hasRemaining() && !this.g.hasRemaining()) {
            int i = this.p;
            short s = this.f706j;
            if (i == 0) {
                int iLimit2 = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit2, byteBuffer.position() + this.s.length));
                int iLimit3 = byteBuffer.limit() - 1;
                while (true) {
                    if (iLimit3 < byteBuffer.position()) {
                        iPosition = byteBuffer.position();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(iLimit3) << 8) | (byteBuffer.get(iLimit3 - 1) & UByte.MAX_VALUE)) > s) {
                        int i2 = this.n;
                        iPosition = ((iLimit3 / i2) * i2) + i2;
                        break;
                    }
                    iLimit3 -= 2;
                }
                if (iPosition == byteBuffer.position()) {
                    this.p = 1;
                } else {
                    byteBuffer.limit(Math.min(iPosition, byteBuffer.capacity()));
                    e(byteBuffer.remaining()).put(byteBuffer).flip();
                }
                byteBuffer.limit(iLimit2);
            } else {
                if (i != 1) {
                    throw new IllegalStateException();
                }
                o8.b.h(this.t < this.s.length);
                int iLimit4 = byteBuffer.limit();
                int iPosition2 = byteBuffer.position() + 1;
                while (true) {
                    if (iPosition2 >= byteBuffer.limit()) {
                        iLimit = byteBuffer.limit();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(iPosition2) << 8) | (byteBuffer.get(iPosition2 - 1) & UByte.MAX_VALUE)) > s) {
                        int i3 = this.n;
                        iLimit = (iPosition2 / i3) * i3;
                        break;
                    }
                    iPosition2 += 2;
                }
                int iPosition3 = iLimit - byteBuffer.position();
                int length = this.t;
                int i4 = this.u;
                int length2 = length + i4;
                byte[] bArr = this.s;
                if (length2 < bArr.length) {
                    length = bArr.length;
                } else {
                    length2 = i4 - (bArr.length - length);
                }
                int i6 = length - length2;
                boolean z = iLimit < iLimit4;
                int iMin = Math.min(iPosition3, i6);
                byteBuffer.limit(byteBuffer.position() + iMin);
                byteBuffer.get(this.s, length2, iMin);
                int i7 = this.u + iMin;
                this.u = i7;
                o8.b.h(i7 <= this.s.length);
                boolean z2 = z && iPosition3 < i6;
                g(z2);
                if (z2) {
                    this.p = 0;
                    this.r = 0;
                }
                byteBuffer.limit(iLimit4);
            }
        }
    }
}
