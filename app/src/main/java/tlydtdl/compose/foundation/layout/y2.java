package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class y2 implements Function3 {
    public final /* synthetic */ int a;
    public final /* synthetic */ v2 b;

    public /* synthetic */ y2(v2 v2Var, int i) {
        this.a = i;
        this.b = v2Var;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.a) {
            case 0:
                ((Number) obj3).intValue();
                tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) ((tlydtdl.compose.runtime.m) obj2);
                sVar.f0(788931215);
                v2 v2Var = this.b;
                boolean zG = sVar.g(v2Var);
                Object objR = sVar.R();
                if (zG || objR == tlydtdl.compose.runtime.l.a) {
                    objR = new r2(v2Var);
                    sVar.q0(objR);
                }
                r2 r2Var = (r2) objR;
                sVar.r(false);
                return r2Var;
            default:
                ((Number) obj3).intValue();
                tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) ((tlydtdl.compose.runtime.m) obj2);
                sVar2.f0(-1415685722);
                v2 v2Var2 = this.b;
                boolean zG2 = sVar2.g(v2Var2);
                Object objR2 = sVar2.R();
                if (zG2 || objR2 == tlydtdl.compose.runtime.l.a) {
                    objR2 = new l1(v2Var2);
                    sVar2.q0(objR2);
                }
                l1 l1Var = (l1) objR2;
                sVar2.r(false);
                return l1Var;
        }
    }
}
