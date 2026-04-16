package tlydtdl.compose.runtime;

import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Function2 {
    public static final h b = new h(0);
    public static final h c = new h(1);
    public final /* synthetic */ int a;

    public /* synthetic */ h(int i) {
        this.a = i;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                m mVar = (m) obj;
                int iIntValue = ((Number) obj2).intValue();
                s sVar = (s) mVar;
                if (!sVar.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                    sVar.Z();
                }
                break;
            default:
                m mVar2 = (m) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                s sVar2 = (s) mVar2;
                if (!sVar2.W(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    sVar2.Z();
                }
                break;
        }
        return lx1.b0.a;
    }
}
