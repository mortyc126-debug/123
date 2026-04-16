package tlydtdl.compose.foundation.lazy.layout;

import ky1.c0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import qx1.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h1 implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ j1 b;

    public /* synthetic */ h1(j1 j1Var, int i) {
        this.a = i;
        this.b = j1Var;
    }

    public final Object invoke(Object obj) {
        switch (this.a) {
            case 0:
                j0 j0Var = (j0) this.b.a.invoke();
                int iA = j0Var.a();
                int i = 0;
                while (true) {
                    if (i >= iA) {
                        i = -1;
                    } else if (!o.c(j0Var.d(i), obj)) {
                        i++;
                    }
                }
                return Integer.valueOf(i);
            default:
                int iIntValue = ((Integer) obj).intValue();
                j1 j1Var = this.b;
                j0 j0Var2 = (j0) j1Var.a.invoke();
                if (iIntValue < 0 || iIntValue >= j0Var2.a()) {
                    StringBuilder sbR = o6.c.r(iIntValue, "Can't scroll to index ", ", it is out of bounds [0, ");
                    sbR.append(j0Var2.a());
                    sbR.append(')');
                    d2.a.a(sbR.toString());
                }
                c0.F(j1Var.getCoroutineScope(), (i) null, (ky1.b0) null, new ae0.e(j1Var, iIntValue, (qx1.d) null, 1), 3);
                return Boolean.TRUE;
        }
    }
}
