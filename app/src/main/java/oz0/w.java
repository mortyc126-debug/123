package oz0;

import aj.a;
import az1.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class w {
    public static final s Companion = new s();
    public final String a;
    public final l b;
    public final v c;

    public /* synthetic */ w(int i, String str, l lVar, v vVar) {
        if (7 != (i & 7)) {
            b2.b(i, 7, r.a.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = lVar;
        this.c = vVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, wVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, wVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, wVar.c);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        l lVar = this.b;
        int iHashCode2 = (iHashCode + (lVar == null ? 0 : lVar.hashCode())) * 31;
        v vVar = this.c;
        return iHashCode2 + (vVar != null ? vVar.hashCode() : 0);
    }

    public final String toString() {
        return "AlbumTheme(id=" + this.a + ", colors=" + this.b + ", images=" + this.c + ")";
    }
}
