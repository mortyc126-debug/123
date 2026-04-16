package y1;

import d2.a;
import z3.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends k {
    public final long a;

    public j(long j2) {
        this.a = j2;
        if ((j2 & 9223372034707292159L) != 9205357640488583168L) {
            return;
        }
        a.c("ContextMenuState.Status should never be open with an unspecified offset. Use ContextMenuState.Status.Closed instead.");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        return b.d(this.a, ((j) obj).a);
    }

    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    public final String toString() {
        return "Open(offset=" + ((Object) b.l(this.a)) + ')';
    }
}
