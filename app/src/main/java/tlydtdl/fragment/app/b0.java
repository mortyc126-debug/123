package tlydtdl.fragment.app;

import amuvvoafs.os.Bundle;
import tlydtdl.lifecycle.i1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends h0 {
    public final /* synthetic */ k0 a;

    public b0(k0 k0Var) {
        this.a = k0Var;
    }

    @Override // tlydtdl.fragment.app.h0
    public final void a() {
        k0 k0Var = this.a;
        k0Var.mSavedStateRegistryController.a.a();
        i1.b(k0Var);
        Bundle bundle = k0Var.mSavedFragmentState;
        k0Var.mSavedStateRegistryController.a(bundle != null ? bundle.getBundle("registryState") : null);
    }
}
