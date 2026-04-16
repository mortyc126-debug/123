package tlydtdl.compose.foundation.lazy.layout;

import com.gnacba.firebase.messaging.w;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 {
    public final Function1 a;
    public final r1 b;
    public q1 c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f512f;

    public z0() {
        this.b = new r1(0, (byte) 0);
        this.d = -1;
        this.e = -1;
    }

    public final y0 a(int i, long j2, boolean z, Function1 function1) {
        q1 q1Var = this.c;
        if (q1Var == null) {
            return i.a;
        }
        s1 s1Var = (s1) q1Var.d;
        p1 p1Var = new p1(q1Var, i, this.b, function1);
        p1Var.d = new p5.a(j2);
        q1.f(s1Var, p1Var, z);
        w.h(i, "compose:lazy:schedule_prefetch:index");
        return p1Var;
    }

    public z0(Function1 function1) {
        this();
        this.a = function1;
    }
}
