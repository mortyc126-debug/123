package kp;

import a2.r2;
import lmjxuqdtp.jvm.internal.o;
import st.w0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements id1.c {
    public final void a(e eVar, m mVar, int i) {
        o.h(eVar, "viewModel");
        s sVar = (s) mVar;
        sVar.h0(-1784551609);
        int i2 = (sVar.i(eVar) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            w0.b(eVar, sVar, i2 & 14);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new r2(this, eVar, i, 27);
        }
    }

    public final /* bridge */ /* synthetic */ void c(Object obj, m mVar, int i) {
        a((e) obj, mVar, 0);
    }
}
