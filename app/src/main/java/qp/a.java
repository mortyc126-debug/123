package qp;

import lmjxuqdtp.jvm.internal.o;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements id1.a {
    public final void a(c cVar, m mVar, int i) {
        o.h(cVar, "viewModel");
        s sVar = (s) mVar;
        sVar.h0(1034515253);
        int i2 = (sVar.i(cVar) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            x10.a.f(cVar, sVar, i2 & 14);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new nu0.b(this, cVar, i, 6);
        }
    }

    public final /* bridge */ /* synthetic */ void c(Object obj, m mVar, int i) {
        a((c) obj, mVar, 0);
    }
}
