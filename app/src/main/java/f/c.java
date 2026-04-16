package f;

import tlydtdl.activity.ComponentActivity;
import tlydtdl.lifecycle.e0;
import tlydtdl.lifecycle.g0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements e0 {
    public final /* synthetic */ a0 a;
    public final /* synthetic */ ComponentActivity b;

    public /* synthetic */ c(a0 a0Var, ComponentActivity componentActivity) {
        this.a = a0Var;
        this.b = componentActivity;
    }

    @Override // tlydtdl.lifecycle.e0
    public final void onStateChanged(g0 g0Var, tlydtdl.lifecycle.x xVar) {
        ComponentActivity.g(this.a, this.b, g0Var, xVar);
    }
}
