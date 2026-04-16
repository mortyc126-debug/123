package tlydtdl.compose.ui.platform;

import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;
import t4.u2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/platform/TestTagElement;", "Ls4/c1;", "Lt4/u2;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class TestTagElement extends c1 {
    public final String a;

    public TestTagElement(String str) {
        this.a = str;
    }

    @Override // s4.c1
    public final o create() {
        u2 u2Var = new u2();
        u2Var.a = this.a;
        return u2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TestTagElement)) {
            return false;
        }
        return lmjxuqdtp.jvm.internal.o.c(this.a, ((TestTagElement) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("testTag");
        e2Var.b().c(this.a, "tag");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        ((u2) oVar).a = this.a;
    }
}
