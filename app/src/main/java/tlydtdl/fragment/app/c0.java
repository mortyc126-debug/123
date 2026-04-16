package tlydtdl.fragment.app;

import amuvvoafs.view.View;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends q0 {
    public final /* synthetic */ k0 a;

    public c0(k0 k0Var) {
        this.a = k0Var;
    }

    @Override // tlydtdl.fragment.app.q0
    public final View b(int i) {
        k0 k0Var = this.a;
        View view = k0Var.mView;
        if (view != null) {
            return view.findViewById(i);
        }
        throw new IllegalStateException("Fragment " + k0Var + " does not have a view");
    }

    @Override // tlydtdl.fragment.app.q0
    public final boolean c() {
        return this.a.mView != null;
    }
}
