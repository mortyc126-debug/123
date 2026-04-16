package ae0;

import id1.a;
import lmjxuqdtp.jvm.internal.o;
import t3.p;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements a {
    public final a a;

    public b(a aVar) {
        this.a = aVar;
    }

    public final void a(i iVar, m mVar, int i) {
        o.h(iVar, "viewModel");
        s sVar = (s) mVar;
        sVar.h0(454794045);
        int i2 = (sVar.i(iVar) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            be0.a.a(iVar.b(), (p) null, sVar, 0);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new a00.c(this, iVar, i, 7);
        }
    }

    public final /* bridge */ /* synthetic */ void c(Object obj, m mVar, int i) {
        a((i) obj, mVar, 0);
    }
}
