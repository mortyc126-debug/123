package gp;

import bp.a;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s0 implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ com.gnacba.firebase.messaging.a0 b;

    public /* synthetic */ s0(com.gnacba.firebase.messaging.a0 a0Var, int i) {
        this.a = i;
        this.b = a0Var;
    }

    public final Object invoke(Object obj) {
        wp.u uVar = (wp.u) obj;
        switch (this.a) {
            case 0:
                o.h(uVar, "socialAuthProvider");
                this.b.q(uVar, a.a);
                break;
            default:
                o.h(uVar, "socialAuthProvider");
                this.b.q(uVar, a.b);
                break;
        }
        return b0.a;
    }
}
