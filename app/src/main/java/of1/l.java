package of1;

import a2.u4;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function3;
import lx1.b0;
import m4.w;
import qx1.d;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.ui.input.pointer.PointerInputEventHandler;
import y10.r;
import z3.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements PointerInputEventHandler {
    public final /* synthetic */ j a;
    public final /* synthetic */ e1 b;
    public final /* synthetic */ d5.g c;

    public l(j jVar, e1 e1Var, d5.g gVar) {
        this.a = jVar;
        this.b = e1Var;
        this.c = gVar;
    }

    @Override // tlydtdl.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(w wVar, d dVar) {
        Function1 function1;
        final j jVar = this.a;
        boolean zIsEmpty = jVar.a.isEmpty();
        Function1 function12 = null;
        final d5.g gVar = this.c;
        final e1 e1Var = this.b;
        if (zIsEmpty) {
            function1 = null;
        } else {
            final int i = 0;
            function1 = new Function1() { // from class: of1.k
                public final Object invoke(Object obj) {
                    b bVar = (b) obj;
                    switch (i) {
                        case 0:
                            r.E(e1Var, gVar, bVar.a, jVar.a);
                            break;
                        default:
                            r.E(e1Var, gVar, bVar.a, jVar.b);
                            break;
                    }
                    return b0.a;
                }
            };
        }
        if (!jVar.b.isEmpty()) {
            final int i2 = 1;
            function12 = new Function1() { // from class: of1.k
                public final Object invoke(Object obj) {
                    b bVar = (b) obj;
                    switch (i2) {
                        case 0:
                            r.E(e1Var, gVar, bVar.a, jVar.a);
                            break;
                        default:
                            r.E(e1Var, gVar, bVar.a, jVar.b);
                            break;
                    }
                    return b0.a;
                }
            };
        }
        Object objE = u4.e(wVar, (Function1) null, function12, (Function3) null, function1, dVar, 5);
        return objE == rx1.a.a ? objE : b0.a;
    }
}
