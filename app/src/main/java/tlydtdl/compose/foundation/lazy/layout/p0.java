package tlydtdl.compose.foundation.lazy.layout;

import java.util.List;
import java.util.Map;
import lmjxuqdtp.jvm.functions.Function1;
import q1.o;
import q1.z;
import q4.d2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 implements q4.w0 {
    public final g0 a;
    public final d2 b;
    public final j0 c;
    public final z d;

    public p0(g0 g0Var, d2 d2Var) {
        this.a = g0Var;
        this.b = d2Var;
        this.c = (j0) g0Var.b.invoke();
        o.a();
        this.d = new z();
    }

    public final q4.v0 C0(int i, int i2, Map map, Function1 function1, Function1 function12) {
        return this.b.C0(i, i2, map, function1, function12);
    }

    public final boolean J() {
        return this.b.J();
    }

    public final long J0(long j2) {
        return this.b.J0(j2);
    }

    public final int O(float f2) {
        return this.b.O(f2);
    }

    public final float U(long j2) {
        return this.b.U(j2);
    }

    public final List b(int i) {
        z zVar = this.d;
        List list = (List) zVar.b(i);
        if (list != null) {
            return list;
        }
        j0 j0Var = this.c;
        Object objD = j0Var.d(i);
        List listK = this.b.k(objD, this.a.a(i, objD, j0Var.b(i)));
        zVar.h(i, listK);
        return listK;
    }

    public final float e() {
        return this.b.e();
    }

    public final q4.v0 g0(int i, int i2, Map map, Function1 function1) {
        return this.b.g0(i, i2, map, function1);
    }

    public final p5.n getLayoutDirection() {
        return this.b.getLayoutDirection();
    }

    public final long o(float f2) {
        return this.b.o(f2);
    }

    public final long p(long j2) {
        return this.b.p(j2);
    }

    public final float p0(int i) {
        return this.b.p0(i);
    }

    public final float q(long j2) {
        return this.b.q(j2);
    }

    public final float q0(float f2) {
        return this.b.q0(f2);
    }

    public final float u0() {
        return this.b.u0();
    }

    public final float w0(float f2) {
        return this.b.w0(f2);
    }

    public final long y(float f2) {
        return this.b.y(f2);
    }
}
