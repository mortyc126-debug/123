package wz0;

import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ g0 b;

    public /* synthetic */ w(g0 g0Var, int i) {
        this.a = i;
        this.b = g0Var;
    }

    public final Object invoke() {
        Function0 function0;
        Function0 function02;
        switch (this.a) {
            case 0:
                g0 g0Var = this.b;
                if (g0Var != null && (function0 = g0Var.g) != null) {
                    function0.invoke();
                }
                break;
            default:
                g0 g0Var2 = this.b;
                if (g0Var2 != null && (function02 = g0Var2.g) != null) {
                    function02.invoke();
                }
                break;
        }
        return lx1.b0.a;
    }
}
