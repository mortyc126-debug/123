package l8;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f281f = new b(new a[0], 0, -9223372036854775807L, 0);
    public static final a g;
    public static final String h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f282j;
    public static final String k;
    public final int a;
    public final long b;
    public final long c;
    public final int d;
    public final a[] e;

    static {
        a aVar = new a(0L, -1, -1, new int[0], new k0[0], new long[0], 0L, false, new String[0], false);
        int[] iArr = aVar.f278f;
        int length = iArr.length;
        int iMax = Math.max(0, length);
        int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
        Arrays.fill(iArrCopyOf, length, iMax, 0);
        long[] jArr = aVar.g;
        int length2 = jArr.length;
        int iMax2 = Math.max(0, length2);
        long[] jArrCopyOf = Arrays.copyOf(jArr, iMax2);
        Arrays.fill(jArrCopyOf, length2, iMax2, -9223372036854775807L);
        g = new a(aVar.a, 0, aVar.c, iArrCopyOf, (k0[]) Arrays.copyOf(aVar.e, 0), jArrCopyOf, aVar.i, aVar.f279j, (String[]) Arrays.copyOf(aVar.h, 0), aVar.k);
        int i2 = o8.f0.a;
        h = Integer.toString(1, 36);
        i = Integer.toString(2, 36);
        f282j = Integer.toString(3, 36);
        k = Integer.toString(4, 36);
    }

    public b(a[] aVarArr, long j2, long j3, int i2) {
        this.b = j2;
        this.c = j3;
        this.a = aVarArr.length + i2;
        this.e = aVarArr;
        this.d = i2;
    }

    public final a a(int i2) {
        int i3 = this.d;
        return i2 < i3 ? g : this.e[i2 - i3];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && Arrays.equals(this.e, bVar.e);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.e) + (((((((this.a * 961) + ((int) this.b)) * 31) + ((int) this.c)) * 31) + this.d) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AdPlaybackState(adsId=null, adResumePositionUs=");
        sb.append(this.b);
        sb.append(", adGroups=[");
        int i2 = 0;
        while (true) {
            a[] aVarArr = this.e;
            if (i2 >= aVarArr.length) {
                sb.append("])");
                return sb.toString();
            }
            sb.append("adGroup(timeUs=");
            sb.append(aVarArr[i2].a);
            sb.append(", ads=[");
            for (int i3 = 0; i3 < aVarArr[i2].f278f.length; i3++) {
                sb.append("ad(state=");
                int i4 = aVarArr[i2].f278f[i3];
                if (i4 == 0) {
                    sb.append('_');
                } else if (i4 == 1) {
                    sb.append('R');
                } else if (i4 == 2) {
                    sb.append('S');
                } else if (i4 == 3) {
                    sb.append('P');
                } else if (i4 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(aVarArr[i2].g[i3]);
                sb.append(')');
                if (i3 < aVarArr[i2].f278f.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i2 < aVarArr.length - 1) {
                sb.append(", ");
            }
            i2++;
        }
    }
}
