package tlydtdl.compose.ui.platform;

import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;
import t4.h1;
import t4.x;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"tlydtdl/compose/ui/platform/AndroidComposeView$bringIntoViewNode$1", "Ls4/c1;", "Lt4/h1;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class AndroidComposeView$bringIntoViewNode$1 extends c1 {
    public final /* synthetic */ x a;

    public AndroidComposeView$bringIntoViewNode$1(x xVar) {
        this.a = xVar;
    }

    @Override // s4.c1
    public final o create() {
        h1 h1Var = new h1();
        h1Var.a = this.a;
        return h1Var;
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("BringIntoViewOnScreen");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        ((h1) oVar).a = this.a;
    }
}
