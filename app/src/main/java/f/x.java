package f;

import tlydtdl.lifecycle.g0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends kb.h {
    public final w a;
    public final g0 b;

    public x(g0 g0Var, w wVar) {
        lmjxuqdtp.jvm.internal.o.h(wVar, "callback");
        this.a = wVar;
        this.b = g0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, xVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, xVar.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        g0 g0Var = this.b;
        return iHashCode + (g0Var == null ? 0 : g0Var.hashCode());
    }

    public final String toString() {
        return "OnBackPressedCallbackInfo(callback=" + this.a + ", owner=" + this.b + ')';
    }
}
