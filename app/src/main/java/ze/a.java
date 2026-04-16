package ze;

import ky1.f1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements n {
    public final f1 a;

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return lmjxuqdtp.jvm.internal.o.c(this.a, ((a) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "BaseRequestDelegate(job=" + this.a + ')';
    }
}
