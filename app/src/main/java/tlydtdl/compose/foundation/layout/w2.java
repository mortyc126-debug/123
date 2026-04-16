package tlydtdl.compose.foundation.layout;

import amuvvoafs.content.Context;
import amuvvoafs.hardware.input.InputManager;
import amuvvoafs.view.View;
import java.util.WeakHashMap;
import r6.u0;
import t1.q1;
import t4.p0;
import t4.q0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class w2 implements tlydtdl.compose.runtime.j0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ w2(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // tlydtdl.compose.runtime.j0
    public final void dispose() {
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                x2 x2Var = (x2) obj2;
                View view = (View) obj;
                int i2 = x2Var.t - 1;
                x2Var.t = i2;
                if (i2 == 0) {
                    WeakHashMap weakHashMap = u0.a;
                    r6.l0.n(view, null);
                    u0.n(view, null);
                    view.removeOnAttachStateChangeListener(x2Var.u);
                }
                break;
            case 1:
                ((tlydtdl.compose.foundation.lazy.layout.k1) obj2).c.j(obj);
                break;
            case 2:
                ((lb.a) obj2).f();
                ((lb.f) obj).e = null;
                break;
            case 3:
                ((InputManager) obj2).unregisterInputDeviceListener((le1.i) obj);
                break;
            case 4:
                tlydtdl.compose.runtime.e1 e1Var = (tlydtdl.compose.runtime.e1) obj2;
                c2.o oVar = (c2.o) e1Var.getValue();
                if (oVar != null) {
                    c2.n nVar = new c2.n(oVar);
                    c2.m mVar = (c2.m) obj;
                    if (mVar != null) {
                        mVar.b(nVar);
                    }
                    e1Var.setValue(null);
                }
                break;
            case 5:
                pe1.a aVar = (pe1.a) obj2;
                aVar.a.d((ec.a) obj);
                aVar.a(tlydtdl.lifecycle.y.a);
                break;
            case 6:
                ((pe1.a) obj2).a.d((pe1.b) obj);
                break;
            case 7:
                ((t1.h0) obj2).a.n((t1.f0) obj);
                break;
            case 8:
                ((q1) obj2).j.remove((q1) obj);
                break;
            case 9:
                q1 q1Var = (q1) obj2;
                q1Var.getClass();
                t1.j1 j1Var = (t1.j1) ((t1.k1) obj).b.getValue();
                if (j1Var != null) {
                    q1Var.i.remove(j1Var.a);
                }
                break;
            case 10:
                ((q1) obj2).i.remove((t1.n1) obj);
                break;
            case 11:
                ((Context) obj2).getApplicationContext().unregisterComponentCallbacks((p0) obj);
                break;
            default:
                ((Context) obj2).getApplicationContext().unregisterComponentCallbacks((q0) obj);
                break;
        }
    }
}
