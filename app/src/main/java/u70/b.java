package u70;

import ny1.r2;
import ny1.z;
import st.w0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements id1.a {
    public final r2 a = z.c(z10.a.c);

    public final void a(j jVar, tlydtdl.compose.runtime.m mVar, int i) {
        lmjxuqdtp.jvm.internal.o.h(jVar, "viewModel");
        s sVar = (s) mVar;
        sVar.h0(1887417831);
        int i2 = (sVar.i(jVar) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            k.a((e) w0.r(jVar.o, sVar, 0, 7).getValue(), sVar, 0);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new nu0.b(this, jVar, i, 15);
        }
    }

    public final /* bridge */ /* synthetic */ void c(Object obj, tlydtdl.compose.runtime.m mVar, int i) {
        a((j) obj, mVar, 0);
    }
}
