package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements r4.c {
    public final Function1 a;
    public v2 b;

    public h0(Function1 function1) {
        this.a = function1;
    }

    @Override // r4.c
    public final void V(r4.g gVar) {
        v2 v2Var = (v2) gVar.f(m.a);
        if (lmjxuqdtp.jvm.internal.o.c(v2Var, this.b)) {
            return;
        }
        this.b = v2Var;
        this.a.invoke(v2Var);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h0) && ((h0) obj).a == this.a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
