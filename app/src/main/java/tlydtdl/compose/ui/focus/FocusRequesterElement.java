package tlydtdl.compose.ui.focus;

import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import y3.t;
import y3.w;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/focus/FocusRequesterElement;", "Ls4/c1;", "Ly3/w;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class FocusRequesterElement extends c1 {
    public final t a;

    public FocusRequesterElement(t tVar) {
        this.a = tVar;
    }

    @Override // s4.c1
    public final o create() {
        w wVar = new w();
        wVar.a = this.a;
        return wVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FocusRequesterElement) && lmjxuqdtp.jvm.internal.o.c(this.a, ((FocusRequesterElement) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("focusRequester");
        e2Var.b().c(this.a, "focusRequester");
    }

    public final String toString() {
        return "FocusRequesterElement(focusRequester=" + this.a + ')';
    }

    @Override // s4.c1
    public final void update(o oVar) {
        w wVar = (w) oVar;
        wVar.a.a.n(wVar);
        t tVar = this.a;
        wVar.a = tVar;
        tVar.a.d(wVar);
    }
}
