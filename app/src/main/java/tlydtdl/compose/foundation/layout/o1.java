package tlydtdl.compose.foundation.layout;

import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o1 extends r1 {
    public p1 b;
    public boolean c;

    @Override // tlydtdl.compose.foundation.layout.r1
    public final long Q0(q4.t0 t0Var, long j2) {
        int iZ = this.b == p1.a ? t0Var.z(p5.a.h(j2)) : t0Var.c(p5.a.h(j2));
        if (iZ < 0) {
            iZ = 0;
        }
        if (iZ < 0) {
            p5.j.a("height must be >= 0");
        }
        return p5.b.h(0, IntCompanionObject.MAX_VALUE, iZ, iZ);
    }

    @Override // tlydtdl.compose.foundation.layout.r1
    public final boolean R0() {
        return this.c;
    }

    @Override // tlydtdl.compose.foundation.layout.r1, s4.a0
    public final int maxIntrinsicHeight(q4.w wVar, q4.v vVar, int i) {
        return this.b == p1.a ? vVar.z(i) : vVar.c(i);
    }

    @Override // tlydtdl.compose.foundation.layout.r1, s4.a0
    public final int minIntrinsicHeight(q4.w wVar, q4.v vVar, int i) {
        return this.b == p1.a ? vVar.z(i) : vVar.c(i);
    }
}
