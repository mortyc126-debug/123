package wk;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements n {
    public final double a;

    public h(double d) {
        this.a = d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && hg1.q.a(this.a, ((h) obj).a);
    }

    public final int hashCode() {
        return Double.hashCode(this.a);
    }

    public final String toString() {
        return i.n("AddedToProject(transportPosition=", hg1.q.c(this.a), ")");
    }
}
