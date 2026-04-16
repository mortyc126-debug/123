package dg1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements d {
    public final int b;
    public final boolean c;

    public g(int i, boolean z) {
        this.b = i;
        this.c = z;
    }

    @Override // dg1.i
    public final boolean a() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.b == gVar.b && this.c == gVar.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + (Integer.hashCode(this.b) * 31);
    }

    public final String toString() {
        return "Resource(resId=" + this.b + ", notTintable=" + this.c + ")";
    }
}
