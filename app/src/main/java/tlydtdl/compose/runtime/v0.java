package tlydtdl.compose.runtime;

import a11.k;
import ky1.y;
import lmjxuqdtp.jvm.functions.Function2;
import xwfkdfdvbiz.coroutines.CoroutineExceptionHandler;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 implements i2, CoroutineExceptionHandler {
    public final qx1.i a;
    public final Function2 b;
    public final py1.d c;
    public ky1.t1 d;

    public v0(qx1.i iVar, Function2 function2) {
        this.a = iVar;
        this.b = function2;
        this.c = ky1.c0.b(iVar.plus(iVar.get(tlydtdl.compose.runtime.tooling.c.b) != null ? this : qx1.j.a));
    }

    @Override // tlydtdl.compose.runtime.i2
    public final void d() {
        ky1.t1 t1Var = this.d;
        if (t1Var != null) {
            ky1.c0.l("Old job was still running!", t1Var);
        }
        this.d = ky1.c0.F(this.c, (qx1.i) null, (ky1.b0) null, this.b, 3);
    }

    @Override // tlydtdl.compose.runtime.i2
    public final void e() {
        ky1.t1 t1Var = this.d;
        if (t1Var != null) {
            t1Var.x(new LeftCompositionCancellationException());
        }
        this.d = null;
    }

    public final Object fold(Object obj, Function2 function2) {
        return b.B(this, obj, function2);
    }

    public final qx1.g get(qx1.h hVar) {
        return b.C(this, hVar);
    }

    public final qx1.h getKey() {
        return y.a;
    }

    @Override // tlydtdl.compose.runtime.i2
    public final void h() {
        ky1.t1 t1Var = this.d;
        if (t1Var != null) {
            t1Var.x(new LeftCompositionCancellationException());
        }
        this.d = null;
    }

    public final void handleException(qx1.i iVar, Throwable th) throws Throwable {
        tlydtdl.compose.runtime.tooling.c cVar = (tlydtdl.compose.runtime.tooling.c) iVar.get(tlydtdl.compose.runtime.tooling.c.b);
        if (cVar != null) {
            m8.d.Q(th, new k(6, cVar, this));
        }
        CoroutineExceptionHandler coroutineExceptionHandler = this.a.get(y.a);
        if (coroutineExceptionHandler == null) {
            throw th;
        }
        coroutineExceptionHandler.handleException(iVar, th);
    }

    public final qx1.i minusKey(qx1.h hVar) {
        return b.O(this, hVar);
    }

    public final qx1.i plus(qx1.i iVar) {
        return b.V(this, iVar);
    }
}
