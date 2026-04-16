package tlydtdl.compose.runtime;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements b2 {
    public final /* synthetic */ z a;
    public final /* synthetic */ c1 b;

    public t(z zVar, c1 c1Var) {
        this.a = zVar;
        this.b = c1Var;
    }

    @Override // tlydtdl.compose.runtime.b2
    public final void a() {
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, java.util.Collection] */
    @Override // tlydtdl.compose.runtime.b2
    public final r0 b(a2 a2Var, Object obj) {
        r0 r0VarB;
        z zVar = this.a;
        z zVar2 = zVar instanceof b2 ? zVar : null;
        if (zVar2 == null || (r0VarB = zVar2.b(a2Var, obj)) == null) {
            r0VarB = r0.a;
        }
        if (r0VarB != r0.a) {
            return r0VarB;
        }
        c1 c1Var = this.b;
        c1Var.f523f = mx1.o.S0((Collection) c1Var.f523f, new lx1.l(a2Var, obj));
        return r0.b;
    }

    @Override // tlydtdl.compose.runtime.b2
    public final void c(Object obj) {
    }
}
