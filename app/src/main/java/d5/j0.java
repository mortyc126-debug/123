package d5;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 implements b {
    public final String a;

    public final boolean equals(Object obj) {
        if (obj instanceof j0) {
            return lmjxuqdtp.jvm.internal.o.c(this.a, ((j0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return o6.c.i(')', "StringAnnotation(value=", this.a);
    }
}
