package tlydtdl.datastore.preferences.protobuf;

import java.util.logging.Level;
import java.util.logging.Logger;
import k7.z0;
import tlydtdl.datastore.preferences.protobuf.CodedOutputStream;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends mu0.u {
    public static final Logger g = Logger.getLogger(m.class.getName());
    public static final boolean h = i1.e;
    public e0 b;
    public final byte[] c;
    public final int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z0 f575f;

    public m(z0 z0Var, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int iMax = Math.max(i, 20);
        this.c = new byte[iMax];
        this.d = iMax;
        this.f575f = z0Var;
    }

    public static int Q(int i, g gVar) {
        int iS = S(i);
        int size = gVar.size();
        return T(size) + size + iS;
    }

    public static int R(String str) {
        int length;
        try {
            length = k1.a(str);
        } catch (Utf8$UnpairedSurrogateException unused) {
            length = str.getBytes(y.a).length;
        }
        return T(length) + length;
    }

    public static int S(int i) {
        return T(i << 3);
    }

    public static int T(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int U(long j2) {
        return (640 - (Long.numberOfLeadingZeros(j2) * 9)) >>> 6;
    }

    public final void K(byte[] bArr, int i, int i2) {
        Y(bArr, i, i2);
    }

    public final void L(int i) {
        int i2 = this.e;
        int i3 = i2 + 1;
        this.e = i3;
        byte[] bArr = this.c;
        bArr[i2] = (byte) (i & 255);
        int i4 = i2 + 2;
        this.e = i4;
        bArr[i3] = (byte) ((i >> 8) & 255);
        int i6 = i2 + 3;
        this.e = i6;
        bArr[i4] = (byte) ((i >> 16) & 255);
        this.e = i2 + 4;
        bArr[i6] = (byte) ((i >> 24) & 255);
    }

    public final void M(long j2) {
        int i = this.e;
        int i2 = i + 1;
        this.e = i2;
        byte[] bArr = this.c;
        bArr[i] = (byte) (j2 & 255);
        int i3 = i + 2;
        this.e = i3;
        bArr[i2] = (byte) ((j2 >> 8) & 255);
        int i4 = i + 3;
        this.e = i4;
        bArr[i3] = (byte) ((j2 >> 16) & 255);
        int i6 = i + 4;
        this.e = i6;
        bArr[i4] = (byte) (255 & (j2 >> 24));
        int i7 = i + 5;
        this.e = i7;
        bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
        int i8 = i + 6;
        this.e = i8;
        bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
        int i9 = i + 7;
        this.e = i9;
        bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
        this.e = i + 8;
        bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
    }

    public final void N(int i, int i2) {
        O((i << 3) | i2);
    }

    public final void O(int i) {
        boolean z = h;
        byte[] bArr = this.c;
        if (z) {
            while ((i & (-128)) != 0) {
                int i2 = this.e;
                this.e = i2 + 1;
                i1.j(bArr, i2, (byte) ((i | 128) & 255));
                i >>>= 7;
            }
            int i3 = this.e;
            this.e = i3 + 1;
            i1.j(bArr, i3, (byte) i);
            return;
        }
        while ((i & (-128)) != 0) {
            int i4 = this.e;
            this.e = i4 + 1;
            bArr[i4] = (byte) ((i | 128) & 255);
            i >>>= 7;
        }
        int i6 = this.e;
        this.e = i6 + 1;
        bArr[i6] = (byte) i;
    }

    public final void P(long j2) {
        boolean z = h;
        byte[] bArr = this.c;
        if (z) {
            while ((j2 & (-128)) != 0) {
                int i = this.e;
                this.e = i + 1;
                i1.j(bArr, i, (byte) ((((int) j2) | 128) & 255));
                j2 >>>= 7;
            }
            int i2 = this.e;
            this.e = i2 + 1;
            i1.j(bArr, i2, (byte) j2);
            return;
        }
        while ((j2 & (-128)) != 0) {
            int i3 = this.e;
            this.e = i3 + 1;
            bArr[i3] = (byte) ((((int) j2) | 128) & 255);
            j2 >>>= 7;
        }
        int i4 = this.e;
        this.e = i4 + 1;
        bArr[i4] = (byte) j2;
    }

    public final void V() {
        this.f575f.write(this.c, 0, this.e);
        this.e = 0;
    }

    public final void W(int i) {
        if (this.d - this.e < i) {
            V();
        }
    }

    public final void X(byte b) {
        if (this.e == this.d) {
            V();
        }
        int i = this.e;
        this.e = i + 1;
        this.c[i] = b;
    }

    public final void Y(byte[] bArr, int i, int i2) {
        int i3 = this.e;
        int i4 = this.d;
        int i6 = i4 - i3;
        byte[] bArr2 = this.c;
        if (i6 >= i2) {
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.e += i2;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i3, i6);
        int i7 = i + i6;
        int i8 = i2 - i6;
        this.e = i4;
        V();
        if (i8 > i4) {
            this.f575f.write(bArr, i7, i8);
        } else {
            System.arraycopy(bArr, i7, bArr2, 0, i8);
            this.e = i8;
        }
    }

    public final void Z(int i, boolean z) {
        W(11);
        N(i, 0);
        byte b = z ? (byte) 1 : (byte) 0;
        int i2 = this.e;
        this.e = i2 + 1;
        this.c[i2] = b;
    }

    public final void a0(int i, g gVar) {
        l0(i, 2);
        b0(gVar);
    }

    public final void b0(g gVar) {
        n0(gVar.size());
        K(gVar.b, gVar.i(), gVar.size());
    }

    public final void c0(int i, int i2) {
        W(14);
        N(i, 5);
        L(i2);
    }

    public final void d0(int i) {
        W(4);
        L(i);
    }

    public final void e0(int i, long j2) {
        W(18);
        N(i, 1);
        M(j2);
    }

    public final void f0(long j2) {
        W(8);
        M(j2);
    }

    public final void g0(int i, int i2) {
        W(20);
        N(i, 0);
        if (i2 >= 0) {
            O(i2);
        } else {
            P(i2);
        }
    }

    public final void h0(int i) {
        if (i >= 0) {
            n0(i);
        } else {
            p0(i);
        }
    }

    public final void i0(int i, a aVar, u0 u0Var) {
        l0(i, 2);
        n0(aVar.a(u0Var));
        u0Var.e(aVar, this.b);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.datastore.preferences.protobuf.CodedOutputStream$OutOfSpaceException */
    public final void j0(int i, String str) throws CodedOutputStream.OutOfSpaceException {
        l0(i, 2);
        k0(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.datastore.preferences.protobuf.CodedOutputStream$OutOfSpaceException */
    public final void k0(String str) throws CodedOutputStream.OutOfSpaceException {
        try {
            int length = str.length() * 3;
            int iT = T(length);
            int i = iT + length;
            int i2 = this.d;
            if (i > i2) {
                byte[] bArr = new byte[length];
                int iP = k1.a.p(str, bArr, 0, length);
                n0(iP);
                Y(bArr, 0, iP);
                return;
            }
            if (i > i2 - this.e) {
                V();
            }
            int iT2 = T(str.length());
            int i3 = this.e;
            byte[] bArr2 = this.c;
            try {
                try {
                    if (iT2 == iT) {
                        int i4 = i3 + iT2;
                        this.e = i4;
                        int iP2 = k1.a.p(str, bArr2, i4, i2 - i4);
                        this.e = i3;
                        O((iP2 - i3) - iT2);
                        this.e = iP2;
                    } else {
                        int iA = k1.a(str);
                        O(iA);
                        this.e = k1.a.p(str, bArr2, this.e, iA);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new CodedOutputStream.OutOfSpaceException(e);
                }
            } catch (Utf8$UnpairedSurrogateException e2) {
                this.e = i3;
                throw e2;
            }
        } catch (Utf8$UnpairedSurrogateException e3) {
            g.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e3);
            byte[] bytes = str.getBytes(y.a);
            try {
                n0(bytes.length);
                K(bytes, 0, bytes.length);
            } catch (IndexOutOfBoundsException e4) {
                throw new CodedOutputStream.OutOfSpaceException(e4);
            }
        }
    }

    public final void l0(int i, int i2) {
        n0((i << 3) | i2);
    }

    public final void m0(int i, int i2) {
        W(20);
        N(i, 0);
        O(i2);
    }

    public final void n0(int i) {
        W(5);
        O(i);
    }

    public final void o0(int i, long j2) {
        W(20);
        N(i, 0);
        P(j2);
    }

    public final void p0(long j2) {
        W(10);
        P(j2);
    }
}
