package tlydtdl.datastore.preferences.protobuf;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends k {
    public final FileInputStream c;
    public final byte[] d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f571f;
    public int g;
    public int h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f572j = IntCompanionObject.MAX_VALUE;

    public j(FileInputStream fileInputStream) {
        Charset charset = y.a;
        this.c = fileInputStream;
        this.d = new byte[4096];
        this.e = 0;
        this.g = 0;
        this.i = 0;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int A() throws InvalidProtocolBufferException {
        if (c()) {
            this.h = 0;
            return 0;
        }
        int iK = K();
        this.h = iK;
        if ((iK >>> 3) != 0) {
            return iK;
        }
        throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int B() {
        return K();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final long C() {
        return L();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final boolean D(int i) throws InvalidProtocolBufferException {
        int i2 = i & 7;
        int i3 = 0;
        if (i2 != 0) {
            if (i2 == 1) {
                P(8);
                return true;
            }
            if (i2 == 2) {
                P(K());
                return true;
            }
            if (i2 == 3) {
                E();
                a(((i >>> 3) << 3) | 4);
                return true;
            }
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw InvalidProtocolBufferException.b();
            }
            P(4);
            return true;
        }
        int i4 = this.e - this.g;
        byte[] bArr = this.d;
        if (i4 >= 10) {
            while (i3 < 10) {
                int i6 = this.g;
                this.g = i6 + 1;
                if (bArr[i6] < 0) {
                    i3++;
                }
            }
            throw InvalidProtocolBufferException.c();
        }
        while (i3 < 10) {
            if (this.g == this.e) {
                O(1);
            }
            int i7 = this.g;
            this.g = i7 + 1;
            if (bArr[i7] < 0) {
                i3++;
            }
        }
        throw InvalidProtocolBufferException.c();
        return true;
    }

    public final byte[] F(int i) throws IOException {
        byte[] bArrG = G(i);
        if (bArrG != null) {
            return bArrG;
        }
        int i2 = this.g;
        int i3 = this.e;
        int length = i3 - i2;
        this.i += i3;
        this.g = 0;
        this.e = 0;
        ArrayList<byte[]> arrayListH = H(i - length);
        byte[] bArr = new byte[i];
        System.arraycopy(this.d, i2, bArr, 0, length);
        for (byte[] bArr2 : arrayListH) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }

    public final byte[] G(int i) throws IOException {
        if (i == 0) {
            return y.b;
        }
        if (i < 0) {
            throw InvalidProtocolBufferException.d();
        }
        int i2 = this.i;
        int i3 = this.g;
        int i4 = i2 + i3 + i;
        if (i4 - IntCompanionObject.MAX_VALUE > 0) {
            throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i6 = this.f572j;
        if (i4 > i6) {
            P((i6 - i2) - i3);
            throw InvalidProtocolBufferException.e();
        }
        int i7 = this.e - i3;
        int i8 = i - i7;
        FileInputStream fileInputStream = this.c;
        if (i8 >= 4096) {
            try {
                if (i8 > fileInputStream.available()) {
                    return null;
                }
            } catch (InvalidProtocolBufferException e) {
                e.a = true;
                throw e;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.d, this.g, bArr, 0, i7);
        this.i += this.e;
        this.g = 0;
        this.e = 0;
        while (i7 < i) {
            try {
                int i9 = fileInputStream.read(bArr, i7, i - i7);
                if (i9 == -1) {
                    throw InvalidProtocolBufferException.e();
                }
                this.i += i9;
                i7 += i9;
            } catch (InvalidProtocolBufferException e2) {
                e2.a = true;
                throw e2;
            }
        }
        return bArr;
    }

    public final ArrayList H(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                int i3 = this.c.read(bArr, i2, iMin - i2);
                if (i3 == -1) {
                    throw InvalidProtocolBufferException.e();
                }
                this.i += i3;
                i2 += i3;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int I() throws InvalidProtocolBufferException {
        int i = this.g;
        if (this.e - i < 4) {
            O(4);
            i = this.g;
        }
        this.g = i + 4;
        byte[] bArr = this.d;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    public final long J() throws InvalidProtocolBufferException {
        int i = this.g;
        if (this.e - i < 8) {
            O(8);
            i = this.g;
        }
        this.g = i + 8;
        byte[] bArr = this.d;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int K() {
        int i;
        int i2 = this.g;
        int i3 = this.e;
        if (i3 != i2) {
            int i4 = i2 + 1;
            byte[] bArr = this.d;
            byte b = bArr[i2];
            if (b >= 0) {
                this.g = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i6 = i2 + 2;
                int i7 = (bArr[i4] << 7) ^ b;
                if (i7 < 0) {
                    i = i7 ^ (-128);
                } else {
                    int i8 = i2 + 3;
                    int i9 = (bArr[i6] << 14) ^ i7;
                    if (i9 >= 0) {
                        i = i9 ^ 16256;
                    } else {
                        int i10 = i2 + 4;
                        int i11 = i9 ^ (bArr[i8] << 21);
                        if (i11 < 0) {
                            i = (-2080896) ^ i11;
                        } else {
                            i8 = i2 + 5;
                            byte b3 = bArr[i10];
                            int i12 = (i11 ^ (b3 << 28)) ^ 266354560;
                            if (b3 < 0) {
                                i10 = i2 + 6;
                                if (bArr[i8] < 0) {
                                    i8 = i2 + 7;
                                    if (bArr[i10] < 0) {
                                        i10 = i2 + 8;
                                        if (bArr[i8] < 0) {
                                            i8 = i2 + 9;
                                            if (bArr[i10] < 0) {
                                                int i13 = i2 + 10;
                                                if (bArr[i8] >= 0) {
                                                    i6 = i13;
                                                    i = i12;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i12;
                            }
                            i = i12;
                        }
                        i6 = i10;
                    }
                    i6 = i8;
                }
                this.g = i6;
                return i;
            }
        }
        return (int) M();
    }

    public final long L() {
        long j2;
        long j3;
        long j4;
        long j5;
        int i = this.g;
        int i2 = this.e;
        if (i2 != i) {
            int i3 = i + 1;
            byte[] bArr = this.d;
            byte b = bArr[i];
            if (b >= 0) {
                this.g = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i6 = (bArr[i3] << 7) ^ b;
                if (i6 < 0) {
                    j2 = i6 ^ (-128);
                } else {
                    int i7 = i + 3;
                    int i8 = (bArr[i4] << 14) ^ i6;
                    if (i8 >= 0) {
                        j2 = i8 ^ 16256;
                        i4 = i7;
                    } else {
                        int i9 = i + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            j5 = (-2080896) ^ i10;
                        } else {
                            long j6 = i10;
                            i4 = i + 5;
                            long j7 = j6 ^ (((long) bArr[i9]) << 28);
                            if (j7 >= 0) {
                                j4 = 266354560;
                            } else {
                                i9 = i + 6;
                                long j8 = j7 ^ (((long) bArr[i4]) << 35);
                                if (j8 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j7 = j8 ^ (((long) bArr[i9]) << 42);
                                    if (j7 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i9 = i + 8;
                                        j8 = j7 ^ (((long) bArr[i4]) << 49);
                                        if (j8 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j9 = (j8 ^ (((long) bArr[i9]) << 56)) ^ 71499008037633920L;
                                            if (j9 < 0) {
                                                int i11 = i + 10;
                                                if (bArr[i4] >= 0) {
                                                    i4 = i11;
                                                }
                                            }
                                            j2 = j9;
                                        }
                                    }
                                }
                                j5 = j3 ^ j8;
                            }
                            j2 = j4 ^ j7;
                        }
                        i4 = i9;
                        j2 = j5;
                    }
                }
                this.g = i4;
                return j2;
            }
        }
        return M();
    }

    public final long M() throws InvalidProtocolBufferException {
        long j2 = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.g == this.e) {
                O(1);
            }
            int i2 = this.g;
            this.g = i2 + 1;
            byte b = this.d[i2];
            j2 |= ((long) (b & ByteCompanionObject.MAX_VALUE)) << i;
            if ((b & ByteCompanionObject.MIN_VALUE) == 0) {
                return j2;
            }
        }
        throw InvalidProtocolBufferException.c();
    }

    public final void N() {
        int i = this.e + this.f571f;
        this.e = i;
        int i2 = this.i + i;
        int i3 = this.f572j;
        if (i2 <= i3) {
            this.f571f = 0;
            return;
        }
        int i4 = i2 - i3;
        this.f571f = i4;
        this.e = i - i4;
    }

    public final void O(int i) throws InvalidProtocolBufferException {
        if (Q(i)) {
            return;
        }
        if (i <= (IntCompanionObject.MAX_VALUE - this.i) - this.g) {
            throw InvalidProtocolBufferException.e();
        }
        throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final void P(int i) throws InvalidProtocolBufferException {
        int i2 = this.e;
        int i3 = this.g;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.g = i3 + i;
            return;
        }
        FileInputStream fileInputStream = this.c;
        if (i < 0) {
            throw InvalidProtocolBufferException.d();
        }
        int i6 = this.i;
        int i7 = i6 + i3;
        int i8 = i7 + i;
        int i9 = this.f572j;
        if (i8 > i9) {
            P((i9 - i6) - i3);
            throw InvalidProtocolBufferException.e();
        }
        this.i = i7;
        this.e = 0;
        this.g = 0;
        while (i4 < i) {
            long j2 = i - i4;
            try {
                try {
                    long jSkip = fileInputStream.skip(j2);
                    if (jSkip < 0 || jSkip > j2) {
                        throw new IllegalStateException(fileInputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i4 += (int) jSkip;
                    }
                } catch (InvalidProtocolBufferException e) {
                    e.a = true;
                    throw e;
                }
            } catch (Throwable th) {
                this.i += i4;
                N();
                throw th;
            }
        }
        this.i += i4;
        N();
        if (i4 >= i) {
            return;
        }
        int i10 = this.e;
        int i11 = i10 - this.g;
        this.g = i10;
        O(1);
        while (true) {
            int i12 = i - i11;
            int i13 = this.e;
            if (i12 <= i13) {
                this.g = i12;
                return;
            } else {
                i11 += i13;
                this.g = i13;
                O(1);
            }
        }
    }

    public final boolean Q(int i) throws IOException {
        FileInputStream fileInputStream = this.c;
        int i2 = this.g;
        int i3 = i2 + i;
        int i4 = this.e;
        if (i3 <= i4) {
            throw new IllegalStateException(z.p.c(i, "refillBuffer() called when ", " bytes were already available in buffer"));
        }
        int i6 = this.i;
        if (i <= (IntCompanionObject.MAX_VALUE - i6) - i2 && i6 + i2 + i <= this.f572j) {
            byte[] bArr = this.d;
            if (i2 > 0) {
                if (i4 > i2) {
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                this.i += i2;
                this.e -= i2;
                this.g = 0;
            }
            int i7 = this.e;
            try {
                int i8 = fileInputStream.read(bArr, i7, Math.min(bArr.length - i7, (IntCompanionObject.MAX_VALUE - this.i) - i7));
                if (i8 == 0 || i8 < -1 || i8 > bArr.length) {
                    throw new IllegalStateException(fileInputStream.getClass() + "#read(byte[]) returned invalid result: " + i8 + "\nThe InputStream implementation is buggy.");
                }
                if (i8 > 0) {
                    this.e += i8;
                    N();
                    if (this.e >= i) {
                        return true;
                    }
                    return Q(i);
                }
            } catch (InvalidProtocolBufferException e) {
                e.a = true;
                throw e;
            }
        }
        return false;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final void a(int i) throws InvalidProtocolBufferException {
        if (this.h != i) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int b() {
        return this.i + this.g;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final boolean c() {
        return this.g == this.e && !Q(1);
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final void h(int i) {
        this.f572j = i;
        N();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int i(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.d();
        }
        int i2 = this.i + this.g + i;
        if (i2 < 0) {
            throw new InvalidProtocolBufferException("Failed to parse the message.");
        }
        int i3 = this.f572j;
        if (i2 > i3) {
            throw InvalidProtocolBufferException.e();
        }
        this.f572j = i2;
        N();
        return i3;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final boolean j() {
        return L() != 0;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final g k() throws IOException {
        int iK = K();
        int i = this.e;
        int i2 = this.g;
        int i3 = i - i2;
        byte[] bArr = this.d;
        if (iK <= i3 && iK > 0) {
            g gVarE = g.e(bArr, i2, iK);
            this.g += iK;
            return gVarE;
        }
        if (iK == 0) {
            return g.c;
        }
        if (iK < 0) {
            throw InvalidProtocolBufferException.d();
        }
        byte[] bArrG = G(iK);
        if (bArrG != null) {
            return g.e(bArrG, 0, bArrG.length);
        }
        int i4 = this.g;
        int i6 = this.e;
        int length = i6 - i4;
        this.i += i6;
        this.g = 0;
        this.e = 0;
        ArrayList<byte[]> arrayListH = H(iK - length);
        byte[] bArr2 = new byte[iK];
        System.arraycopy(bArr, i4, bArr2, 0, length);
        for (byte[] bArr3 : arrayListH) {
            System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
            length += bArr3.length;
        }
        g gVar = g.c;
        return new g(bArr2);
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final double l() {
        return Double.longBitsToDouble(J());
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int m() {
        return K();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int n() {
        return I();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final long p() {
        return J();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final float q() {
        return Float.intBitsToFloat(I());
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int r() {
        return K();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final long s() {
        return L();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int u() {
        return I();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final long v() {
        return J();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int w() {
        int iK = K();
        return (-(iK & 1)) ^ (iK >>> 1);
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final long x() {
        long jL = L();
        return (-(jL & 1)) ^ (jL >>> 1);
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final String y() throws InvalidProtocolBufferException {
        int iK = K();
        byte[] bArr = this.d;
        if (iK > 0) {
            int i = this.e;
            int i2 = this.g;
            if (iK <= i - i2) {
                String str = new String(bArr, i2, iK, y.a);
                this.g += iK;
                return str;
            }
        }
        if (iK == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (iK < 0) {
            throw InvalidProtocolBufferException.d();
        }
        if (iK > this.e) {
            return new String(F(iK), y.a);
        }
        O(iK);
        String str2 = new String(bArr, this.g, iK, y.a);
        this.g += iK;
        return str2;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final String z() throws IOException {
        int iK = K();
        int i = this.g;
        int i2 = this.e;
        int i3 = i2 - i;
        byte[] bArrF = this.d;
        if (iK <= i3 && iK > 0) {
            this.g = i + iK;
        } else {
            if (iK == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            if (iK < 0) {
                throw InvalidProtocolBufferException.d();
            }
            i = 0;
            if (iK <= i2) {
                O(iK);
                this.g = iK;
            } else {
                bArrF = F(iK);
            }
        }
        return k1.a.n(bArrF, i, iK);
    }
}
