package tlydtdl.datastore.preferences.protobuf;

import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends k {
    public final byte[] c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f */
    public int f569f;
    public final int g;
    public int h;
    public int i = IntCompanionObject.MAX_VALUE;

    public i(byte[] bArr, int i, int i2, boolean z) {
        this.c = bArr;
        this.d = i2 + i;
        this.f569f = i;
        this.g = i;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int A() throws InvalidProtocolBufferException {
        if (c()) {
            this.h = 0;
            return 0;
        }
        int iH = H();
        this.h = iH;
        if ((iH >>> 3) != 0) {
            return iH;
        }
        throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int B() {
        return H();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final long C() {
        return I();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final boolean D(int i) throws InvalidProtocolBufferException {
        int i2 = i & 7;
        int i3 = 0;
        if (i2 != 0) {
            if (i2 == 1) {
                L(8);
                return true;
            }
            if (i2 == 2) {
                L(H());
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
            L(4);
            return true;
        }
        int i4 = this.d - this.f569f;
        byte[] bArr = this.c;
        if (i4 >= 10) {
            while (i3 < 10) {
                int i6 = this.f569f;
                this.f569f = i6 + 1;
                if (bArr[i6] < 0) {
                    i3++;
                }
            }
            throw InvalidProtocolBufferException.c();
        }
        while (i3 < 10) {
            int i7 = this.f569f;
            if (i7 == this.d) {
                throw InvalidProtocolBufferException.e();
            }
            this.f569f = i7 + 1;
            if (bArr[i7] < 0) {
                i3++;
            }
        }
        throw InvalidProtocolBufferException.c();
        return true;
    }

    public final int F() throws InvalidProtocolBufferException {
        int i = this.f569f;
        if (this.d - i < 4) {
            throw InvalidProtocolBufferException.e();
        }
        this.f569f = i + 4;
        byte[] bArr = this.c;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    public final long G() throws InvalidProtocolBufferException {
        int i = this.f569f;
        if (this.d - i < 8) {
            throw InvalidProtocolBufferException.e();
        }
        this.f569f = i + 8;
        byte[] bArr = this.c;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int H() {
        int i;
        int i2 = this.f569f;
        int i3 = this.d;
        if (i3 != i2) {
            int i4 = i2 + 1;
            byte[] bArr = this.c;
            byte b = bArr[i2];
            if (b >= 0) {
                this.f569f = i4;
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
                this.f569f = i6;
                return i;
            }
        }
        return (int) J();
    }

    public final long I() {
        long j2;
        long j3;
        long j4;
        long j5;
        int i = this.f569f;
        int i2 = this.d;
        if (i2 != i) {
            int i3 = i + 1;
            byte[] bArr = this.c;
            byte b = bArr[i];
            if (b >= 0) {
                this.f569f = i3;
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
                this.f569f = i4;
                return j2;
            }
        }
        return J();
    }

    public final long J() throws InvalidProtocolBufferException {
        long j2 = 0;
        for (int i = 0; i < 64; i += 7) {
            int i2 = this.f569f;
            if (i2 == this.d) {
                throw InvalidProtocolBufferException.e();
            }
            this.f569f = i2 + 1;
            byte b = this.c[i2];
            j2 |= ((long) (b & ByteCompanionObject.MAX_VALUE)) << i;
            if ((b & ByteCompanionObject.MIN_VALUE) == 0) {
                return j2;
            }
        }
        throw InvalidProtocolBufferException.c();
    }

    public final void K() {
        int i = this.d + this.e;
        this.d = i;
        int i2 = i - this.g;
        int i3 = this.i;
        if (i2 <= i3) {
            this.e = 0;
            return;
        }
        int i4 = i2 - i3;
        this.e = i4;
        this.d = i - i4;
    }

    public final void L(int i) throws InvalidProtocolBufferException {
        if (i >= 0) {
            int i2 = this.d;
            int i3 = this.f569f;
            if (i <= i2 - i3) {
                this.f569f = i3 + i;
                return;
            }
        }
        if (i >= 0) {
            throw InvalidProtocolBufferException.e();
        }
        throw InvalidProtocolBufferException.d();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final void a(int i) throws InvalidProtocolBufferException {
        if (this.h != i) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int b() {
        return this.f569f - this.g;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final boolean c() {
        return this.f569f == this.d;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final void h(int i) {
        this.i = i;
        K();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int i(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.d();
        }
        int iB = b() + i;
        if (iB < 0) {
            throw new InvalidProtocolBufferException("Failed to parse the message.");
        }
        int i2 = this.i;
        if (iB > i2) {
            throw InvalidProtocolBufferException.e();
        }
        this.i = iB;
        K();
        return i2;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final boolean j() {
        return I() != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x002f  */
    @Override // tlydtdl.datastore.preferences.protobuf.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final tlydtdl.datastore.preferences.protobuf.g k() throws tlydtdl.datastore.preferences.protobuf.InvalidProtocolBufferException {
        /*
            r4 = this;
            int r0 = r4.H()
            byte[] r1 = r4.c
            if (r0 <= 0) goto L19
            int r2 = r4.d
            int r3 = r4.f569f
            int r2 = r2 - r3
            if (r0 > r2) goto L19
            tlydtdl.datastore.preferences.protobuf.g r1 = tlydtdl.datastore.preferences.protobuf.g.e(r1, r3, r0)
            int r2 = r4.f569f
            int r2 = r2 + r0
            r4.f569f = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            tlydtdl.datastore.preferences.protobuf.g r0 = tlydtdl.datastore.preferences.protobuf.g.c
            return r0
        L1e:
            if (r0 <= 0) goto L2f
            int r2 = r4.d
            int r3 = r4.f569f
            int r2 = r2 - r3
            if (r0 > r2) goto L2f
            int r0 = r0 + r3
            r4.f569f = r0
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r3, r0)
            goto L35
        L2f:
            if (r0 > 0) goto L42
            if (r0 != 0) goto L3d
            byte[] r0 = tlydtdl.datastore.preferences.protobuf.y.b
        L35:
            tlydtdl.datastore.preferences.protobuf.g r1 = tlydtdl.datastore.preferences.protobuf.g.c
            tlydtdl.datastore.preferences.protobuf.g r1 = new tlydtdl.datastore.preferences.protobuf.g
            r1.<init>(r0)
            return r1
        L3d:
            tlydtdl.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = tlydtdl.datastore.preferences.protobuf.InvalidProtocolBufferException.d()
            throw r0
        L42:
            tlydtdl.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = tlydtdl.datastore.preferences.protobuf.InvalidProtocolBufferException.e()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.datastore.preferences.protobuf.i.k():tlydtdl.datastore.preferences.protobuf.g");
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final double l() {
        return Double.longBitsToDouble(G());
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int m() {
        return H();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int n() {
        return F();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final long p() {
        return G();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final float q() {
        return Float.intBitsToFloat(F());
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int r() {
        return H();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final long s() {
        return I();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int u() {
        return F();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final long v() {
        return G();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final int w() {
        int iH = H();
        return (-(iH & 1)) ^ (iH >>> 1);
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final long x() {
        long jI = I();
        return (-(jI & 1)) ^ (jI >>> 1);
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final String y() throws InvalidProtocolBufferException {
        int iH = H();
        if (iH > 0) {
            int i = this.d;
            int i2 = this.f569f;
            if (iH <= i - i2) {
                String str = new String(this.c, i2, iH, y.a);
                this.f569f += iH;
                return str;
            }
        }
        if (iH == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (iH < 0) {
            throw InvalidProtocolBufferException.d();
        }
        throw InvalidProtocolBufferException.e();
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final String z() throws InvalidProtocolBufferException {
        int iH = H();
        if (iH > 0) {
            int i = this.d;
            int i2 = this.f569f;
            if (iH <= i - i2) {
                String strN = k1.a.n(this.c, i2, iH);
                this.f569f += iH;
                return strN;
            }
        }
        if (iH == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (iH <= 0) {
            throw InvalidProtocolBufferException.d();
        }
        throw InvalidProtocolBufferException.e();
    }
}
