package wm;

import az1.b2;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class t {
    public static final s Companion = new s();
    public final String a;

    public /* synthetic */ t(int i, String str) {
        if (1 == (i & 1)) {
            this.a = str;
        } else {
            b2.b(i, 1, r.a.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t) && o.c(this.a, ((t) obj).a);
    }

    public final int hashCode() {
        String str = this.a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return i.n("MediaUrls(m4a=", this.a, ")");
    }

    public t(String str) {
        this.a = str;
    }
}
