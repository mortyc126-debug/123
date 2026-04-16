package b01;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements s {
    public final String a;

    public q(String str) {
        lmjxuqdtp.jvm.internal.o.h(str, "name");
        this.a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q) && lmjxuqdtp.jvm.internal.o.c(this.a, ((q) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return i.n("CustomNamed(name=", this.a, ")");
    }
}
