package s4;

import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 extends lmjxuqdtp.jvm.internal.p implements Function0 {
    public final /* synthetic */ int c;
    public final /* synthetic */ k1 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h1(k1 k1Var, int i) {
        super(0);
        this.c = i;
        this.d = k1Var;
    }

    public final Object invoke() {
        switch (this.c) {
            case 0:
                k1 k1Var = this.d;
                a4.w wVar = k1Var.E;
                lmjxuqdtp.jvm.internal.o.e(wVar);
                k1Var.d1(wVar, k1Var.D);
                break;
            default:
                k1 k1Var2 = this.d.q;
                if (k1Var2 != null) {
                    k1Var2.q1();
                }
                break;
        }
        return lx1.b0.a;
    }
}
