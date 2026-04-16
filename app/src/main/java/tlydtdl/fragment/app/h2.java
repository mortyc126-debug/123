package tlydtdl.fragment.app;

import amuvvoafs.view.View;
import java.util.ArrayList;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h2 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ r b;
    public final /* synthetic */ j2 c;

    public /* synthetic */ h2(r rVar, j2 j2Var, int i) {
        this.a = i;
        this.b = rVar;
        this.c = j2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                r rVar = this.b;
                ArrayList arrayList = rVar.b;
                j2 j2Var = this.c;
                if (arrayList.contains(j2Var)) {
                    int i = j2Var.a;
                    View view = j2Var.c.mView;
                    o.g(view, "operation.fragment.mView");
                    i.a(i, view, rVar.a);
                }
                break;
            case 1:
                r rVar2 = this.b;
                o.h(rVar2, "this$0");
                j2 j2Var2 = this.c;
                o.h(j2Var2, "$operation");
                rVar2.a(j2Var2);
                break;
            default:
                r rVar3 = this.b;
                ArrayList arrayList2 = rVar3.b;
                j2 j2Var3 = this.c;
                arrayList2.remove(j2Var3);
                rVar3.c.remove(j2Var3);
                break;
        }
    }
}
