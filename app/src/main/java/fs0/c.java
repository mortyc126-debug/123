package fs0;

import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements e {
    public final Function0 a;

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            return lmjxuqdtp.jvm.internal.o.c(this.a, ((c) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "DisabledWithReason(showReason=" + this.a + ")";
    }
}
