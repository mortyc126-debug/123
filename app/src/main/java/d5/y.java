package d5;

import p5.p;
import p5.q;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class y {
    public final long a;
    public final long b;
    public final int c;

    public y(long j2, long j3, int i) {
        this.a = j2;
        this.b = j3;
        this.c = i;
        q[] qVarArr = p.b;
        if ((j2 & 1095216660480L) == 0) {
            j5.a.a("width cannot be TextUnit.Unspecified");
        }
        if ((j3 & 1095216660480L) == 0) {
            j5.a.a("height cannot be TextUnit.Unspecified");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return p.a(this.a, yVar.a) && p.a(this.b, yVar.b) && this.c == yVar.c;
    }

    public final int hashCode() {
        q[] qVarArr = p.b;
        return Integer.hashCode(this.c) + s1.a.g(Long.hashCode(this.a) * 31, this.b, 31);
    }

    public final String toString() {
        return "Placeholder(width=" + ((Object) p.e(this.a)) + ", height=" + ((Object) p.e(this.b)) + ", placeholderVerticalAlign=" + ((Object) qg.a.C(this.c)) + ')';
    }
}
