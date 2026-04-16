package pf1;

import tlydtdl.compose.runtime.n1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final n1 a;
    public final n1 b;

    public c(n1 n1Var) {
        this.a = n1Var;
        this.b = n1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.a.equals(((c) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "EllipsisState(isEllipsizedState=" + this.a + ")";
    }
}
