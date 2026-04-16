package ty0;

import lmjxuqdtp.jvm.internal.o;
import ny1.d2;
import ny1.z1;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements id1.a {
    public final d2 a;
    public final z1 b;
    public final z1 c;

    public a(d2 d2Var, z1 z1Var, z1 z1Var2) {
        this.a = d2Var;
        this.b = z1Var;
        this.c = z1Var2;
    }

    public final void a(f fVar, m mVar, int i) {
        o.h(fVar, "viewModel");
        s sVar = (s) mVar;
        sVar.h0(736253584);
        int i2 = (sVar.i(fVar) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            uy0.a.a(fVar.a(), sVar, 0);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new sh1.b(this, fVar, i, 21);
        }
    }

    public final /* bridge */ /* synthetic */ void c(Object obj, m mVar, int i) {
        a((f) obj, mVar, 0);
    }
}
