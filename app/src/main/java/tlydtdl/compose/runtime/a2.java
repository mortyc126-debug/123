package tlydtdl.compose.runtime;

import lmjxuqdtp.jvm.functions.Function2;
import q1.n0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a2 {
    public b2 a;
    public int b;
    public a c;
    public Function2 d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q1.f0 f522f;
    public n0 g;

    public a2(b2 b2Var) {
        this.a = b2Var;
    }

    public static boolean a(h0 h0Var, n0 n0Var) {
        lmjxuqdtp.jvm.internal.o.f(h0Var, "null cannot be cast to non-null type tlydtdl.compose.runtime.DerivedState<lmjxuqdtp.Any?>");
        x2 x2Var = h0Var.c;
        if (x2Var == null) {
            x2Var = x0.f548f;
        }
        return !x2Var.a(h0Var.i().f531f, n0Var.g(h0Var));
    }

    public final boolean b() {
        if (this.a != null) {
            a aVar = this.c;
            if (aVar != null ? aVar.a() : false) {
                return true;
            }
        }
        return false;
    }

    public final r0 c(Object obj) {
        r0 r0VarB;
        b2 b2Var = this.a;
        return (b2Var == null || (r0VarB = b2Var.b(this, obj)) == null) ? r0.a : r0VarB;
    }

    public final void d() {
        b2 b2Var = this.a;
        if (b2Var != null) {
            b2Var.a();
        }
        this.a = null;
        this.f522f = null;
        this.g = null;
        this.d = null;
    }

    public final void e(boolean z) {
        int i = this.b;
        this.b = z ? i | 32 : i & (-33);
    }
}
