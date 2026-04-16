package tlydtdl.lifecycle;

import lg.e;
import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class x1 implements e0 {
    public final /* synthetic */ y a;
    public final /* synthetic */ z b;
    public final /* synthetic */ ky1.m c;
    public final /* synthetic */ Function0 d;

    public x1(y yVar, z zVar, ky1.m mVar, Function0 function0) {
        this.a = yVar;
        this.b = zVar;
        this.c = mVar;
        this.d = function0;
    }

    @Override // tlydtdl.lifecycle.e0
    public final void onStateChanged(g0 g0Var, x xVar) {
        Object objU;
        x.Companion.getClass();
        x xVarC = v.c(this.a);
        ky1.m mVar = this.c;
        z zVar = this.b;
        if (xVar != xVarC) {
            if (xVar == x.ON_DESTROY) {
                zVar.d(this);
                mVar.resumeWith(e.u(new LifecycleDestroyedException()));
                return;
            }
            return;
        }
        zVar.d(this);
        try {
            objU = this.d.invoke();
        } catch (Throwable th) {
            objU = e.u(th);
        }
        mVar.resumeWith(objU);
    }
}
