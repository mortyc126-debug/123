package oz0;

import aj.a;
import az1.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class h0 {
    public static final g0 Companion = new g0();
    public final double a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public h0(double d, String str, String str2, String str3, String str4) {
        this.a = d;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return Double.compare(this.a, h0Var.a) == 0 && lmjxuqdtp.jvm.internal.o.c(this.b, h0Var.b) && lmjxuqdtp.jvm.internal.o.c(this.c, h0Var.c) && lmjxuqdtp.jvm.internal.o.c(this.d, h0Var.d) && lmjxuqdtp.jvm.internal.o.c(this.e, h0Var.e);
    }

    public final int hashCode() {
        int iHashCode = Double.hashCode(this.a) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.e;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Sample(duration=");
        sb.append(this.a);
        sb.append(", audioUrl=");
        sb.append(this.b);
        s1.a.y(sb, ", uploadUrl=", this.c, ", audioFormat=", this.d);
        return z.p.g(sb, ", status=", this.e, ")");
    }

    public /* synthetic */ h0(int i, double d, String str, String str2, String str3, String str4) {
        if (14 != (i & 14)) {
            b2.b(i, 14, f0.a.getDescriptor());
            throw null;
        }
        this.a = (i & 1) == 0 ? 0.0d : d;
        this.b = str;
        this.c = str2;
        this.d = str3;
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = str4;
        }
    }
}
