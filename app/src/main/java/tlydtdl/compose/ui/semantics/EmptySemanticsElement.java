package tlydtdl.compose.ui.semantics;

import a5.d;
import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/semantics/EmptySemanticsElement;", "Ls4/c1;", "La5/d;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class EmptySemanticsElement extends c1 {
    public final d a;

    public EmptySemanticsElement(d dVar) {
        this.a = dVar;
    }

    @Override // s4.c1
    public final o create() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
    }

    @Override // s4.c1
    public final /* bridge */ /* synthetic */ void update(o oVar) {
    }
}
