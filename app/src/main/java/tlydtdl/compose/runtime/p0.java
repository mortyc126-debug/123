package tlydtdl.compose.runtime;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 {
    public int[] a;
    public int b;

    public p0(int i, boolean z) {
        switch (i) {
            case 2:
                this.a = new int[30];
                break;
            default:
                this.a = new int[10];
                break;
        }
    }

    public static long b(boolean z, int i, int i2, int i3, int i4) {
        int i6 = z ? i3 : i4;
        if (z) {
            i3 = i4;
        }
        if (i < i2) {
            return uc0.p.h(i, i);
        }
        if (i == i2) {
            return i6 == 0 ? uc0.p.h(i2, i3 + i2) : uc0.p.h(i2, i2);
        }
        if (i < i2 + i6) {
            return i3 == 0 ? uc0.p.h(i2, i2) : uc0.p.h(i2, i3 + i2);
        }
        int i7 = (i - i6) + i3;
        return uc0.p.h(i7, i7);
    }

    public long a(int i, boolean z) {
        int iMin;
        int iMax;
        int[] iArr = this.a;
        int i2 = this.b;
        if (i2 < 0) {
            iMin = i;
            iMax = iMin;
        } else if (z) {
            int iMax2 = i;
            int i3 = 0;
            int i4 = iMax2;
            while (i3 < i2) {
                int i6 = i3 * 3;
                int i7 = iArr[i6];
                int i8 = iArr[i6 + 1];
                int i9 = iArr[i6 + 2];
                long jB = b(z, i4, i7, i8, i9);
                long jB2 = b(z, iMax2, i7, i8, i9);
                int i10 = d5.p0.c;
                int iMin2 = Math.min((int) (jB >> 32), (int) (jB2 >> 32));
                iMax2 = Math.max((int) (jB & 4294967295L), (int) (jB2 & 4294967295L));
                i3++;
                i4 = iMin2;
            }
            iMin = i4;
            iMax = iMax2;
        } else {
            iMax = i;
            iMin = iMax;
            for (int i11 = i2 - 1; -1 < i11; i11--) {
                int i12 = i11 * 3;
                int i13 = iArr[i12];
                int i14 = iArr[i12 + 1];
                int i15 = iArr[i12 + 2];
                long jB3 = b(z, iMin, i13, i14, i15);
                long jB4 = b(z, iMax, i13, i14, i15);
                int i16 = d5.p0.c;
                iMin = Math.min((int) (jB3 >> 32), (int) (jB4 >> 32));
                iMax = Math.max((int) (jB3 & 4294967295L), (int) (jB4 & 4294967295L));
            }
        }
        return uc0.p.h(iMin, iMax);
    }

    public int c(int i) {
        int i2 = this.b - 1;
        return i2 >= 0 ? this.a[i2] : i;
    }

    public int d() {
        int[] iArr = this.a;
        int i = this.b - 1;
        this.b = i;
        return iArr[i];
    }

    public void e(int i) {
        int[] iArrCopyOf = this.a;
        if (this.b >= iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length * 2);
            lmjxuqdtp.jvm.internal.o.g(iArrCopyOf, "copyOf(...)");
            this.a = iArrCopyOf;
        }
        int i2 = this.b;
        this.b = i2 + 1;
        iArrCopyOf[i2] = i;
    }

    public void f(int i, int i2, int i3) {
        int i4 = this.b;
        int[] iArrCopyOf = this.a;
        int i6 = i4 + 3;
        if (i6 >= iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length * 2);
            lmjxuqdtp.jvm.internal.o.g(iArrCopyOf, "copyOf(...)");
            this.a = iArrCopyOf;
        }
        iArrCopyOf[i4] = i + i3;
        iArrCopyOf[i4 + 1] = i2 + i3;
        iArrCopyOf[i4 + 2] = i3;
        this.b = i6;
    }

    public void g(int i, int i2, int i3, int i4) {
        int i6 = this.b;
        int[] iArrCopyOf = this.a;
        int i7 = i6 + 4;
        if (i7 >= iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length * 2);
            lmjxuqdtp.jvm.internal.o.g(iArrCopyOf, "copyOf(...)");
            this.a = iArrCopyOf;
        }
        iArrCopyOf[i6] = i;
        iArrCopyOf[i6 + 1] = i2;
        iArrCopyOf[i6 + 2] = i3;
        iArrCopyOf[i6 + 3] = i4;
        this.b = i7;
    }

    public void h(int i, int i2) {
        if (i < i2) {
            int i3 = i - 3;
            for (int i4 = i; i4 < i2; i4 += 3) {
                int[] iArr = this.a;
                int i6 = iArr[i4];
                int i7 = iArr[i2];
                if (i6 < i7 || (i6 == i7 && iArr[i4 + 1] <= iArr[i2 + 1])) {
                    i3 += 3;
                    j(i3, i4);
                }
            }
            j(i3 + 3, i2);
            h(i, i3);
            h(i3 + 6, i2);
        }
    }

    public void i(int i, int i2, int i3) {
        if (!(i3 >= 0)) {
            d2.a.a("Expected newLen to be ≥ 0, was " + i3);
        }
        int iMin = Math.min(i, i2);
        int iMax = Math.max(iMin, i2) - iMin;
        if (iMax >= 2 || iMax != i3) {
            int i4 = this.b + 1;
            int[] iArr = this.a;
            if (i4 > iArr.length / 3) {
                int[] iArrCopyOf = Arrays.copyOf(this.a, Math.max(i4 * 2, (iArr.length / 3) * 2) * 3);
                lmjxuqdtp.jvm.internal.o.g(iArrCopyOf, "copyOf(...)");
                this.a = iArrCopyOf;
            }
            int[] iArr2 = this.a;
            int i6 = this.b * 3;
            iArr2[i6] = iMin;
            iArr2[i6 + 1] = iMax;
            iArr2[i6 + 2] = i3;
            this.b = i4;
        }
    }

    public void j(int i, int i2) {
        int[] iArr = this.a;
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
        int i4 = i + 1;
        int i6 = i2 + 1;
        int i7 = iArr[i4];
        iArr[i4] = iArr[i6];
        iArr[i6] = i7;
        int i8 = i + 2;
        int i9 = i2 + 2;
        int i10 = iArr[i8];
        iArr[i8] = iArr[i9];
        iArr[i9] = i10;
    }

    public p0(int i) {
        this.a = new int[i];
    }
}
