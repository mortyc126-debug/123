package tlydtdl.compose.foundation.relocation;

import j2.b;
import j2.c;
import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/relocation/BringIntoViewRequesterElement;", "Ls4/c1;", "Lj2/c;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class BringIntoViewRequesterElement extends c1 {
    public final b a;

    public BringIntoViewRequesterElement(b bVar) {
        this.a = bVar;
    }

    @Override // s4.c1
    public final o create() {
        return new c(this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BringIntoViewRequesterElement) {
            return lmjxuqdtp.jvm.internal.o.c(this.a, ((BringIntoViewRequesterElement) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("bringIntoViewRequester");
        e2Var.b().c(this.a, "bringIntoViewRequester");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        ((c) oVar).Q0(this.a);
    }
}
