package cu;

import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.time.l;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true)
public final class i {
    public static final h Companion = new h();
    public final Integer a;
    public final Integer b;
    public final l c;

    public /* synthetic */ i(int i, Integer num, Integer num2, l lVar) {
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = num;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = num2;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = lVar;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return o.c(this.a, iVar.a) && o.c(this.b, iVar.b) && o.c(this.c, iVar.c);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        l lVar = this.c;
        return iHashCode2 + (lVar != null ? lVar.hashCode() : 0);
    }

    public final String toString() {
        return "FreeBeatsQuota(remainingCount=" + this.a + ", totalCount=" + this.b + ", nextDate=" + this.c + ")";
    }
}
