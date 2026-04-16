package s4;

import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 extends lmjxuqdtp.jvm.internal.p implements Function0 {
    public final /* synthetic */ s0 c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ w1 f439f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(s0 s0Var, long j2, long j3, w1 w1Var) {
        super(0);
        this.c = s0Var;
        this.d = j2;
        this.e = j3;
        this.f439f = w1Var;
    }

    public final Object invoke() {
        s0 s0Var = this.c;
        s0Var.U0().a = false;
        s0Var.U0().b = this.d;
        s0Var.U0().c = this.e;
        Function1 function1D = this.f439f.a.d();
        if (function1D != null) {
            function1D.invoke(s0Var.U0());
        }
        return lx1.b0.a;
    }
}
