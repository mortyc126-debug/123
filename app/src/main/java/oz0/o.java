package oz0;

import aj.a;
import az1.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class o {
    public static final n Companion = new n();
    public final Boolean a;
    public final Boolean b;
    public final Boolean c;

    public /* synthetic */ o(int i, Boolean bool, Boolean bool2, Boolean bool3) {
        if (7 != (i & 7)) {
            b2.b(i, 7, m.a.getDescriptor());
            throw null;
        }
        this.a = bool;
        this.b = bool2;
        this.c = bool3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, oVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, oVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, oVar.c);
    }

    public final int hashCode() {
        Boolean bool = this.a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.b;
        int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.c;
        return iHashCode2 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public final String toString() {
        return "AlbumPermissions(purchase=" + this.a + ", delete=" + this.b + ", edit=" + this.c + ")";
    }
}
