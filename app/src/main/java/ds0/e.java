package ds0;

import d5.p0;
import tlydtdl.compose.runtime.e1;
import uc0.p;
import v2.h;
import w2.a0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements v2.c {
    public final /* synthetic */ e1 a;

    @Override // v2.c
    public final void a(h hVar) {
        a0 a0Var = hVar.c;
        e1 e1Var = this.a;
        if (!((Boolean) e1Var.getValue()).booleanValue() || ((k3.e) hVar.a().b).c <= 0) {
            return;
        }
        e1Var.setValue(Boolean.FALSE);
        v80.h hVarA = hVar.a();
        int i = 0;
        while (true) {
            k3.e eVar = (k3.e) hVarA.b;
            if (i >= eVar.c) {
                return;
            }
            w2.i iVar = (w2.i) eVar.a[i];
            long jH = p.h(iVar.a, iVar.b);
            w2.i iVar2 = (w2.i) ((k3.e) hVarA.b).a[i];
            long jH2 = p.h(iVar2.c, iVar2.d);
            if (!p0.d(jH) && p0.d(jH2)) {
                hVar.c(0, a0Var.length(), p.J(jH, a0Var));
            }
            i++;
        }
    }
}
