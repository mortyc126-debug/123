package tlydtdl.compose.foundation.lazy.layout;

import amuvvoafs.view.View;
import t5.c0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements tlydtdl.compose.runtime.j0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ e0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // tlydtdl.compose.runtime.j0
    public final void dispose() {
        switch (this.a) {
            case 0:
                ((f0) this.b).d = null;
                break;
            case 1:
                z0 z0Var = (z0) this.b;
                q1 q1Var = z0Var.c;
                if (q1Var != null) {
                    q1Var.a = false;
                }
                z0Var.c = null;
                break;
            case 2:
                ((u0) this.b).f508f = true;
                break;
            case 3:
                com.bandlab.uikit.compose.bottomsheet.i0 i0Var = (com.bandlab.uikit.compose.bottomsheet.i0) this.b;
                i0Var.dismiss();
                i0Var.h.d();
                break;
            case 4:
                ((g.c) this.b).f();
                break;
            case 5:
                ((g.e) this.b).f();
                break;
            case 6:
                x2.y yVar = (x2.y) this.b;
                yVar.v();
                yVar.k = null;
                break;
            case 7:
                ((a3.v1) this.b).r();
                break;
            case 8:
                ((View) this.b).setKeepScreenOn(false);
                break;
            case 9:
                ((t4.t1) this.b).b.invoke();
                break;
            default:
                c0 c0Var = (c0) this.b;
                c0Var.d();
                tlydtdl.lifecycle.i1.j(c0Var, null);
                c0Var.n.removeViewImmediate(c0Var);
                break;
        }
    }
}
