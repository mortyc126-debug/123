package m41;

import lmjxuqdtp.jvm.internal.o;
import o6.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements e {
    public final String a;
    public final boolean b;

    public n(String str, boolean z) {
        o.h(str, "id");
        this.a = str;
        this.b = z;
    }

    @Override // m41.e
    public final boolean a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return o.c(this.a, nVar.a) && this.b == nVar.b;
    }

    @Override // m41.e
    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return c.n("UserFollowEntity(id=", this.a, ", isPrivate=", ")", this.b);
    }
}
