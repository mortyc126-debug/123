package tlydtdl.compose.runtime.tooling;

import j3.l0;
import java.util.List;
import kd.h;
import lmjxuqdtp.jvm.functions.Function2;
import qg.a;
import qx1.g;
import qx1.i;
import tlydtdl.compose.runtime.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements l0, g {
    public static final h b = new h(2);
    public final s a;

    public c(s sVar) {
        this.a = sVar;
    }

    public final List d(Integer num) {
        return this.a.K();
    }

    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    public final g get(qx1.h hVar) {
        return a.n(this, hVar);
    }

    public final qx1.h getKey() {
        return b;
    }

    public final i minusKey(qx1.h hVar) {
        return a.v(this, hVar);
    }

    public final i plus(i iVar) {
        return a.x(this, iVar);
    }
}
