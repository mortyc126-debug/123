package tlydtdl.compose.runtime;

import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends s3.b0 implements f3 {
    public final Function0 b;
    public final x2 c;
    public g0 d = new g0(s3.l.k().g());

    public h0(x2 x2Var, Function0 function0) {
        this.b = function0;
        this.c = x2Var;
    }

    public final s3.c0 d() {
        return this.d;
    }

    public final void e(s3.c0 c0Var) {
        lmjxuqdtp.jvm.internal.o.f(c0Var, "null cannot be cast to non-null type tlydtdl.compose.runtime.DerivedSnapshotState.ResultRecord<T of tlydtdl.compose.runtime.DerivedSnapshotState>");
        this.d = (g0) c0Var;
    }

    @Override // tlydtdl.compose.runtime.f3
    public final Object getValue() {
        Function1 function1E = s3.l.k().e();
        if (function1E != null) {
            function1E.invoke(this);
        }
        s3.f fVarK = s3.l.k();
        return h((g0) s3.l.j(this.d, fVarK), fVarK, true, this.b).f531f;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final tlydtdl.compose.runtime.g0 h(tlydtdl.compose.runtime.g0 r22, s3.f r23, boolean r24, lmjxuqdtp.jvm.functions.Function0 r25) {
        /*
            Method dump skipped, instruction units count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.h0.h(tlydtdl.compose.runtime.g0, s3.f, boolean, lmjxuqdtp.jvm.functions.Function0):tlydtdl.compose.runtime.g0");
    }

    public final g0 i() {
        s3.f fVarK = s3.l.k();
        return h((g0) s3.l.j(this.d, fVarK), fVarK, false, this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DerivedState(value=");
        g0 g0Var = (g0) s3.l.i(this.d);
        sb.append(g0Var.d(this, s3.l.k()) ? String.valueOf(g0Var.f531f) : "<Not calculated>");
        sb.append(")@");
        sb.append(hashCode());
        return sb.toString();
    }
}
