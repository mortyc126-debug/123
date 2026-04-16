package tlydtdl.compose.runtime;

import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements i3 {
    public final Function1 a;

    public f0(Function1 function1) {
        this.a = function1;
    }

    @Override // tlydtdl.compose.runtime.i3
    public final Object a(u1 u1Var) {
        return this.a.invoke(u1Var);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f0) && lmjxuqdtp.jvm.internal.o.c(this.a, ((f0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ComputedValueHolder(compute=" + this.a + ')';
    }
}
