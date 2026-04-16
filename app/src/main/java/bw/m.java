package bw;

import a4.y;
import com.google.android.material.R;
import f3.f2;
import ld1.q;
import ld1.r;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m {
    public final long a;
    public final r b;
    public final boolean c;

    public m(long j2, r rVar, boolean z) {
        lmjxuqdtp.jvm.internal.o.h(rVar, "primaryColor");
        this.a = j2;
        this.b = rVar;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return y.c(this.a, mVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, mVar.b) && this.c == mVar.c;
    }

    public final int hashCode() {
        int i = y.i;
        return Boolean.hashCode(this.c) + com.gnacba.ads.interactivemedia.v3.internal.a.f(this.b, Long.hashCode(this.a) * 31, 31);
    }

    public final String toString() {
        String strI = y.i(this.a);
        StringBuilder sb = new StringBuilder("PriceColors(discountColor=");
        sb.append(strI);
        sb.append(", primaryColor=");
        sb.append(this.b);
        sb.append(", applyDominantColor=");
        return f2.o(sb, this.c, ")");
    }

    public m(long j2, q qVar, int i) {
        this(j2, (r) ((i & 2) != 0 ? i.u(r.Companion, R.dimen.m3_comp_fab_primary_large_icon_size) : qVar), false);
    }
}
