package r1;

import java.util.NoSuchElementException;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final int[] a = new int[0];
    public static final long[] b = new long[0];
    public static final Object[] c = new Object[0];

    public static final int a(int i, int i2, int[] iArr) {
        o.h(iArr, "array");
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i6 = (i4 + i3) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i2) {
                i4 = i6 + 1;
            } else {
                if (i7 <= i2) {
                    return i6;
                }
                i3 = i6 - 1;
            }
        }
        return ~i4;
    }

    public static final int b(long[] jArr, int i, long j2) {
        o.h(jArr, "array");
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j3 = jArr[i4];
            if (j3 < j2) {
                i3 = i4 + 1;
            } else {
                if (j3 <= j2) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    public static final void c(String str) {
        o.h(str, "message");
        throw new IllegalArgumentException(str);
    }

    public static final void d(String str) {
        o.h(str, "message");
        throw new IndexOutOfBoundsException(str);
    }

    public static final void e(String str) {
        o.h(str, "message");
        throw new NoSuchElementException(str);
    }
}
