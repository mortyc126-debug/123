package wk;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements f {
    public final double a;
    public final boolean b;

    public b(double d, boolean z) {
        this.a = d;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return hg1.q.a(this.a, bVar.a) && this.b == bVar.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (Double.hashCode(this.a) * 31);
    }

    public final String toString() {
        return o6.c.n("AddedToProject(transportPosition=", hg1.q.c(this.a), ", isTrimmed=", ")", this.b);
    }
}
