package tlydtdl.compose.foundation.lazy.layout;

import lmjxuqdtp.jvm.functions.Function2;
import tlydtdl.compose.runtime.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 implements Function2 {
    public final /* synthetic */ j0 a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public i0(int i, j0 j0Var, Object obj) {
        this.a = j0Var;
        this.b = i;
        this.c = obj;
    }

    public final Object invoke(Object obj, Object obj2) {
        tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj;
        int iIntValue = ((Number) obj2).intValue();
        s sVar = (s) mVar;
        if (sVar.W(iIntValue & 1, (iIntValue & 3) != 2)) {
            this.a.e(this.b, this.c, sVar, 0);
        } else {
            sVar.Z();
        }
        return lx1.b0.a;
    }
}
