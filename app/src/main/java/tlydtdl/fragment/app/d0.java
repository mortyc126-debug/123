package tlydtdl.fragment.app;

import amuvvoafs.view.View;
import tlydtdl.lifecycle.e0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements e0 {
    public final /* synthetic */ k0 a;

    public d0(k0 k0Var) {
        this.a = k0Var;
    }

    @Override // tlydtdl.lifecycle.e0
    public final void onStateChanged(tlydtdl.lifecycle.g0 g0Var, tlydtdl.lifecycle.x xVar) {
        View view;
        if (xVar != tlydtdl.lifecycle.x.ON_STOP || (view = this.a.mView) == null) {
            return;
        }
        view.cancelPendingInputEvents();
    }
}
