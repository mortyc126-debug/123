package nu0;

import java.util.List;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public final List a;
    public final List b;

    public l(List list, List list2) {
        o.h(list2, "right");
        this.a = list;
        this.b = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return o.c(this.a, lVar.a) && o.c(this.b, lVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "StudioActionBarViewState(left=" + this.a + ", right=" + this.b + ")";
    }
}
