package tlydtdl.compose.foundation.layout;

import java.util.WeakHashMap;
import lmjxuqdtp.jvm.functions.Function3;
import tlydtdl.compose.runtime.x0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a3 implements Function3 {
    public final /* synthetic */ int a;

    public /* synthetic */ a3(int i) {
        this.a = i;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.a;
        x0 x0Var = tlydtdl.compose.runtime.l.a;
        switch (i) {
            case 0:
                ((Number) obj3).intValue();
                tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) ((tlydtdl.compose.runtime.m) obj2);
                sVar.f0(359872873);
                WeakHashMap weakHashMap = x2.v;
                x2 x2VarE = e.e(sVar);
                boolean zG = sVar.g(x2VarE);
                Object objR = sVar.R();
                if (zG || objR == x0Var) {
                    objR = new l1(x2VarE.b);
                    sVar.q0(objR);
                }
                l1 l1Var = (l1) objR;
                sVar.r(false);
                return l1Var;
            case 1:
                ((Number) obj3).intValue();
                tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) ((tlydtdl.compose.runtime.m) obj2);
                sVar2.f0(359872873);
                WeakHashMap weakHashMap2 = x2.v;
                x2 x2VarE2 = e.e(sVar2);
                boolean zG2 = sVar2.g(x2VarE2);
                Object objR2 = sVar2.R();
                if (zG2 || objR2 == x0Var) {
                    objR2 = new l1(x2VarE2.c);
                    sVar2.q0(objR2);
                }
                l1 l1Var2 = (l1) objR2;
                sVar2.r(false);
                return l1Var2;
            default:
                ((Number) obj3).intValue();
                tlydtdl.compose.runtime.s sVar3 = (tlydtdl.compose.runtime.s) ((tlydtdl.compose.runtime.m) obj2);
                sVar3.f0(359872873);
                WeakHashMap weakHashMap3 = x2.v;
                x2 x2VarE3 = e.e(sVar3);
                boolean zG3 = sVar3.g(x2VarE3);
                Object objR3 = sVar3.R();
                if (zG3 || objR3 == x0Var) {
                    objR3 = new l1(x2VarE3.f496f);
                    sVar3.q0(objR3);
                }
                l1 l1Var3 = (l1) objR3;
                sVar3.r(false);
                return l1Var3;
        }
    }
}
