package tlydtdl.compose.runtime;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements i2 {
    public final ky1.a0 a;

    public d0(ky1.a0 a0Var) {
        this.a = a0Var;
    }

    @Override // tlydtdl.compose.runtime.i2
    public final void d() {
    }

    @Override // tlydtdl.compose.runtime.i2
    public final void e() {
        ky1.a0 a0Var = this.a;
        if (a0Var instanceof l2) {
            ((l2) a0Var).a();
        } else {
            ky1.c0.j(a0Var, new LeftCompositionCancellationException());
        }
    }

    @Override // tlydtdl.compose.runtime.i2
    public final void h() {
        ky1.a0 a0Var = this.a;
        if (a0Var instanceof l2) {
            ((l2) a0Var).a();
        } else {
            ky1.c0.j(a0Var, new LeftCompositionCancellationException());
        }
    }
}
