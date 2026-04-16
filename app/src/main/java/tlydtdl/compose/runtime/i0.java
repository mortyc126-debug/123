package tlydtdl.compose.runtime;

import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 implements i2 {
    public final Function1 a;
    public j0 b;

    public i0(Function1 function1) {
        this.a = function1;
    }

    @Override // tlydtdl.compose.runtime.i2
    public final void d() {
        this.b = (j0) this.a.invoke(a0.b);
    }

    @Override // tlydtdl.compose.runtime.i2
    public final void e() {
    }

    @Override // tlydtdl.compose.runtime.i2
    public final void h() {
        j0 j0Var = this.b;
        if (j0Var != null) {
            j0Var.dispose();
        }
        this.b = null;
    }
}
