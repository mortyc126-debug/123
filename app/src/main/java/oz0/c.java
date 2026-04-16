package oz0;

import aj.a;
import az1.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(serializable = true)
public final class c {
    public static final b Companion = new b();
    public final String a;

    public /* synthetic */ c(int i, String str) {
        if (1 == (i & 1)) {
            this.a = str;
        } else {
            b2.b(i, 1, a.a.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && lmjxuqdtp.jvm.internal.o.c(this.a, ((c) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return i.n("AddReactionPayload(reaction=", this.a, ")");
    }

    public c(String str) {
        this.a = str;
    }
}
