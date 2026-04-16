package tlydtdl.compose.foundation.lazy.layout;

import java.util.List;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import tlydtdl.compose.runtime.e1;
import u10.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l0 implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ e1 b;

    public /* synthetic */ l0(int i, e1 e1Var) {
        this.a = i;
        this.b = e1Var;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return (j0) ((Function0) this.b.getValue()).invoke();
            case 1:
                return new f2.j((Function1) this.b.getValue());
            case 2:
                this.b.setValue(Boolean.FALSE);
                return lx1.b0.a;
            case 3:
                this.b.setValue(Boolean.TRUE);
                return lx1.b0.a;
            case 4:
                this.b.setValue(Boolean.valueOf(!((Boolean) r0.getValue()).booleanValue()));
                return lx1.b0.a;
            case 5:
                this.b.setValue(Boolean.valueOf(!((Boolean) r0.getValue()).booleanValue()));
                return lx1.b0.a;
            case 6:
                this.b.setValue(Boolean.FALSE);
                return lx1.b0.a;
            case 7:
                e1 e1Var = this.b;
                if (e1Var != null) {
                    return (List) e1Var.getValue();
                }
                return null;
            case 8:
                Boolean bool = (Boolean) this.b.getValue();
                bool.booleanValue();
                return bool;
            case 9:
                this.b.setValue(sf1.n0.b);
                return lx1.b0.a;
            case 10:
                return (p5.f) this.b.getValue();
            default:
                s sVar = (s) this.b.getValue();
                if (sVar != null) {
                    sVar.c.invoke();
                }
                return lx1.b0.a;
        }
    }
}
