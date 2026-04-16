package tlydtdl.fragment.app;

import amuvvoafs.os.Bundle;
import amuvvoafs.util.Log;
import java.util.Map;
import tlydtdl.lifecycle.e0;
import tlydtdl.lifecycle.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 implements e0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ q1 b;
    public final /* synthetic */ z c;
    public final /* synthetic */ k1 d;

    public b1(k1 k1Var, String str, q1 q1Var, z zVar) {
        this.d = k1Var;
        this.a = str;
        this.b = q1Var;
        this.c = zVar;
    }

    @Override // tlydtdl.lifecycle.e0
    public final void onStateChanged(tlydtdl.lifecycle.g0 g0Var, tlydtdl.lifecycle.x xVar) {
        Bundle bundle;
        k1 k1Var = this.d;
        Map map = k1Var.m;
        tlydtdl.lifecycle.x xVar2 = tlydtdl.lifecycle.x.ON_START;
        String str = this.a;
        if (xVar == xVar2 && (bundle = (Bundle) map.get(str)) != null) {
            this.b.k(bundle, str);
            map.remove(str);
            if (k1.N(2)) {
                Log.v("FragmentManager", "Clearing fragment result with key " + str);
            }
        }
        if (xVar == tlydtdl.lifecycle.x.ON_DESTROY) {
            this.c.d(this);
            k1Var.n.remove(str);
        }
    }
}
