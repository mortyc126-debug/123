package tlydtdl.lifecycle;

import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {
    public y a;
    public e0 b;

    public final void a(g0 g0Var, x xVar) {
        y yVarA = xVar.a();
        y yVar = this.a;
        o.h(yVar, "state1");
        if (yVarA.compareTo(yVar) < 0) {
            yVar = yVarA;
        }
        this.a = yVar;
        this.b.onStateChanged(g0Var, xVar);
        this.a = yVarA;
    }
}
