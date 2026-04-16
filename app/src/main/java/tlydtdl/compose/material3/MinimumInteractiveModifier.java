package tlydtdl.compose.material3;

import f3.r1;
import g3.w;
import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ltlydtdl/compose/material3/MinimumInteractiveModifier;", "Ls4/c1;", "Lf3/r1;", "<init>", "()V", "material3"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class MinimumInteractiveModifier extends c1 {
    public static final MinimumInteractiveModifier a = new MinimumInteractiveModifier();

    private MinimumInteractiveModifier() {
    }

    @Override // s4.c1
    public final o create() {
        return new r1();
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return w.j(this);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("minimumInteractiveComponentSize");
        e2Var.b().c("Reserves at least 48.dp in size to disambiguate touch interactions if the element would measure smaller", "README");
    }

    @Override // s4.c1
    public final /* bridge */ /* synthetic */ void update(o oVar) {
    }
}
