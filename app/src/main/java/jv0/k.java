package jv0;

import az1.b2;
import m10.j0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class k {
    public static final j Companion = new j();
    public final String a;
    public final j0 b;

    public /* synthetic */ k(int i, String str, j0 j0Var) {
        if (3 != (i & 3)) {
            b2.b(i, 3, i.a.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = j0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, kVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, kVar.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        j0 j0Var = this.b;
        return iHashCode + (j0Var == null ? 0 : j0Var.hashCode());
    }

    public final String toString() {
        return "Image(id=" + this.a + ", picture=" + this.b + ")";
    }
}
