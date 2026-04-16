package xr0;

import ky1.s;
import lmjxuqdtp.jvm.internal.o;
import s71.d1;
import wr0.b;
import y11.l2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements d {
    public final b a;
    public final l2 b;
    public final d1 c;
    public final s d;

    public c(b bVar, l2 l2Var, d1 d1Var, s sVar) {
        this.a = bVar;
        this.b = l2Var;
        this.c = d1Var;
        this.d = sVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a.equals(cVar.a) && this.b == cVar.b && o.c(this.c, cVar.c) && this.d.equals(cVar.d);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        l2 l2Var = this.b;
        int iHashCode2 = (iHashCode + (l2Var == null ? 0 : l2Var.hashCode())) * 31;
        d1 d1Var = this.c;
        return this.d.hashCode() + ((iHashCode2 + (d1Var != null ? d1Var.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "PersistStudioState(data=" + this.a + ", projectOrigin=" + this.b + ", contentMetadata=" + this.c + ", response=" + this.d + ")";
    }
}
