package tlydtdl.compose.runtime;

import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements qx1.g {
    public static final x0 a = new x0(5);

    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    public final qx1.g get(qx1.h hVar) {
        return qg.a.n(this, hVar);
    }

    public final qx1.h getKey() {
        return a;
    }

    public final qx1.i minusKey(qx1.h hVar) {
        return qg.a.v(this, hVar);
    }

    public final qx1.i plus(qx1.i iVar) {
        return qg.a.x(this, iVar);
    }
}
