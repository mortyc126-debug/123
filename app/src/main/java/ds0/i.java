package ds0;

import a2.u4;
import lmjxuqdtp.jvm.functions.Function1;
import lx1.b0;
import m4.w;
import tlydtdl.compose.ui.input.pointer.PointerInputEventHandler;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements PointerInputEventHandler {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ c2.m b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ Function1 d;

    public i(boolean z, c2.m mVar, Function1 function1, Function1 function12) {
        this.a = z;
        this.b = mVar;
        this.c = function1;
        this.d = function12;
    }

    @Override // tlydtdl.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(w wVar, qx1.d dVar) {
        Object objE;
        return (this.a && (objE = u4.e(wVar, (Function1) null, (Function1) null, new h(this.b, this.c, this.d, (qx1.d) null, 0), (Function1) null, dVar, 11)) == rx1.a.a) ? objE : b0.a;
    }
}
