package ro0;

import java.util.List;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import qu0.p;
import z11.g;
import z11.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ir0.a b;

    public /* synthetic */ c(ir0.a aVar, int i) {
        this.a = i;
        this.b = aVar;
    }

    public final Object invoke(Object obj) {
        boolean zC;
        switch (this.a) {
            case 0:
                i iVar = (i) obj;
                o.h(iVar, "it");
                zC = o.c(iVar.getId(), this.b.a());
                break;
            default:
                g gVar = (g) obj;
                o.h(gVar, "region");
                List list = gVar.p;
                ir0.a aVar = this.b;
                if (list != null) {
                    mx1.o.U0(list, new p(8, aVar));
                }
                zC = o.c(gVar.g, aVar.a());
                break;
        }
        return Boolean.valueOf(zC);
    }
}
