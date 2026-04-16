package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.jvm.functions.Function2;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements i {
    public final float a;
    public final boolean b;
    public final Function2 c;
    public final float d;

    public j(float f2, boolean z, Function2 function2) {
        this.a = f2;
        this.b = z;
        this.c = function2;
        this.d = f2;
    }

    @Override // tlydtdl.compose.foundation.layout.k
    public final void a(p5.c cVar, int i, int[] iArr, int[] iArr2) {
        k(cVar, i, iArr, p5.n.a, iArr2);
    }

    @Override // tlydtdl.compose.foundation.layout.h, tlydtdl.compose.foundation.layout.k
    public final float c() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return p5.f.a(this.a, jVar.a) && this.b == jVar.b && lmjxuqdtp.jvm.internal.o.c(this.c, jVar.c);
    }

    public final int hashCode() {
        int iF = s1.a.f(Float.hashCode(this.a) * 31, 31, this.b);
        Function2 function2 = this.c;
        return iF + (function2 == null ? 0 : function2.hashCode());
    }

    @Override // tlydtdl.compose.foundation.layout.h
    public final void k(p5.c cVar, int i, int[] iArr, p5.n nVar, int[] iArr2) {
        int i2;
        int iMin;
        if (iArr.length == 0) {
            return;
        }
        int iO = cVar.O(this.a);
        boolean z = this.b && nVar == p5.n.b;
        g gVar = l.a;
        if (z) {
            i2 = 0;
            iMin = 0;
            for (int length = iArr.length - 1; -1 < length; length--) {
                int i3 = iArr[length];
                int iMin2 = Math.min(i2, i - i3);
                iArr2[length] = iMin2;
                iMin = Math.min(iO, (i - iMin2) - i3);
                i2 = iArr2[length] + i3 + iMin;
            }
        } else {
            int length2 = iArr.length;
            int i4 = 0;
            i2 = 0;
            iMin = 0;
            int i6 = 0;
            while (i4 < length2) {
                int i7 = iArr[i4];
                int iMin3 = Math.min(i2, i - i7);
                iArr2[i6] = iMin3;
                int iMin4 = Math.min(iO, (i - iMin3) - i7);
                int i8 = iArr2[i6] + i7 + iMin4;
                i4++;
                iMin = iMin4;
                i2 = i8;
                i6++;
            }
        }
        int i9 = i2 - iMin;
        Function2 function2 = this.c;
        if (function2 == null || i9 >= i) {
            return;
        }
        int iIntValue = ((Number) function2.invoke(Integer.valueOf(i - i9), nVar)).intValue();
        int length3 = iArr2.length;
        for (int i10 = 0; i10 < length3; i10++) {
            iArr2[i10] = iArr2[i10] + iIntValue;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b ? HttpUrl.FRAGMENT_ENCODE_SET : "Absolute");
        sb.append("Arrangement#spacedAligned(");
        q.q2.p(this.a, ", ", sb);
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }
}
