package tw0;

import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;
import rw0.m0;
import sw0.i;
import t3.p;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements a {
    public final m0 a;

    public b(m0 m0Var) {
        o.h(m0Var, "specialCaseAlignment");
        this.a = m0Var;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    @Override // tw0.a
    public final p s(p pVar, Object obj, i iVar) throws NoWhenBranchMatchedException {
        boolean zA;
        tlydtdl.compose.foundation.lazy.a aVar = (tlydtdl.compose.foundation.lazy.a) obj;
        int iOrdinal = this.a.ordinal();
        if (iOrdinal != 0) {
            zA = true;
            if (iOrdinal == 1) {
                zA = false;
            } else if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            zA = iVar.a();
        }
        return zA ? tlydtdl.compose.foundation.lazy.a.c(aVar, pVar) : m.F(pVar, 24, 0.0f, 2);
    }
}
