package nu0;

import dd.v;
import java.util.Iterator;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import tlydtdl.compose.foundation.layout.m2;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Function3 {
    public final /* synthetic */ int a;
    public final /* synthetic */ l b;
    public final /* synthetic */ e c;

    public /* synthetic */ a(l lVar, e eVar, int i) {
        this.a = i;
        this.b = lVar;
        this.c = eVar;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.a;
        m2 m2Var = (m2) obj;
        m mVar = (m) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        switch (i) {
            case 0:
                o.h(m2Var, "$this$StudioActionBarLayout");
                s sVar = (s) mVar;
                if (sVar.W(iIntValue & 1, (iIntValue & 17) != 16)) {
                    Iterator it = this.b.a.iterator();
                    while (it.hasNext()) {
                        v.g((h) it.next(), this.c, sVar);
                    }
                } else {
                    sVar.Z();
                }
                break;
            default:
                o.h(m2Var, "$this$StudioActionBarLayout");
                s sVar2 = (s) mVar;
                if (sVar2.W(iIntValue & 1, (iIntValue & 17) != 16)) {
                    Iterator it2 = this.b.b.iterator();
                    while (it2.hasNext()) {
                        v.g((h) it2.next(), this.c, sVar2);
                    }
                } else {
                    sVar2.Z();
                }
                break;
        }
        return b0.a;
    }
}
