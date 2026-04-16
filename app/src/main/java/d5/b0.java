package d5;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {
    public final a0 a;
    public final z b;

    public b0(a0 a0Var, z zVar) {
        this.a = a0Var;
        this.b = zVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.b, b0Var.b) && lmjxuqdtp.jvm.internal.o.c(this.a, b0Var.a);
    }

    public final int hashCode() {
        a0 a0Var = this.a;
        int iHashCode = (a0Var != null ? a0Var.hashCode() : 0) * 31;
        z zVar = this.b;
        return iHashCode + (zVar != null ? zVar.hashCode() : 0);
    }

    public final String toString() {
        return "PlatformTextStyle(spanStyle=" + this.a + ", paragraphSyle=" + this.b + ')';
    }

    public b0(boolean z) {
        this(null, new z(z));
    }
}
