package tlydtdl.compose.foundation;

import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import v1.d0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/ExcludeFromSystemGestureElement;", "Ls4/c1;", "Lv1/d0;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class ExcludeFromSystemGestureElement extends c1 {
    @Override // s4.c1
    public final o create() {
        return new d0();
    }

    public final boolean equals(Object obj) {
        return obj instanceof ExcludeFromSystemGestureElement;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("systemGestureExclusion");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        ((d0) oVar).getClass();
    }
}
