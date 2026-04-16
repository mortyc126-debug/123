package ds0;

import d5.m0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import tlydtdl.compose.runtime.e1;
import y3.x;
import y3.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ e1 b;
    public final /* synthetic */ Function1 c;

    public /* synthetic */ c(int i, e1 e1Var, Function1 function1) {
        this.a = i;
        this.b = e1Var;
        this.c = function1;
    }

    public final Object invoke(Object obj) {
        switch (this.a) {
            case 0:
                z zVar = (x) obj;
                o.h(zVar, "focusState");
                z zVar2 = zVar;
                this.b.setValue(Boolean.valueOf(zVar2.a()));
                this.c.invoke(Boolean.valueOf(zVar2.a()));
                break;
            default:
                m0 m0Var = (m0) obj;
                o.h(m0Var, "result");
                this.b.setValue(m0Var);
                Function1 function1 = this.c;
                if (function1 != null) {
                    function1.invoke(m0Var);
                }
                break;
        }
        return b0.a;
    }
}
