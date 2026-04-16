package q10;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 {
    public final t0 a;
    public final l0 b;
    public final Boolean c;

    public j0(t0 t0Var, l0 l0Var, Boolean bool) {
        this.a = t0Var;
        this.b = l0Var;
        this.c = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, j0Var.a) && this.b == j0Var.b && lmjxuqdtp.jvm.internal.o.c(this.c, j0Var.c);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        l0 l0Var = this.b;
        int iHashCode2 = (iHashCode + (l0Var == null ? 0 : l0Var.hashCode())) * 31;
        Boolean bool = this.c;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "Follower(profileId=" + this.a + ", followingState=" + this.b + ", isPrivate=" + this.c + ")";
    }

    public /* synthetic */ j0(t0 t0Var, l0 l0Var) {
        this(t0Var, l0Var, Boolean.FALSE);
    }
}
