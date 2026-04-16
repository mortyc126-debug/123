package tlydtdl.compose.runtime;

import kotlin.jvm.internal.IntCompanionObject;
import q1.n0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 {
    public final o2 a;

    public b1(o2 o2Var) {
        this.a = o2Var;
    }

    public static final void a(r2 r2Var, int i) {
        while (r2Var.v >= 0 && r2Var.u <= i) {
            r2Var.N();
            r2Var.j();
        }
    }

    public final n0 b(c cVar, q1.j0 j0Var) {
        o2 o2Var;
        int i;
        Object[] objArr = j0Var.a;
        int i2 = j0Var.b;
        int i3 = 0;
        while (true) {
            o2Var = this.a;
            if (i3 >= i2) {
                break;
            }
            if (o2Var.i(((c1) objArr[i3]).e)) {
                i3++;
            } else {
                q1.j0 j0Var2 = new q1.j0();
                Object[] objArr2 = j0Var.a;
                int i4 = j0Var.b;
                for (int i6 = 0; i6 < i4; i6++) {
                    Object obj = objArr2[i6];
                    if (o2Var.i(((c1) obj).e)) {
                        j0Var2.a(obj);
                    }
                }
                j0Var = j0Var2;
            }
        }
        q1.j0 j0VarM = cn1.j.M(j0Var, new a1.d(17, this));
        if (j0VarM.g()) {
            n0 n0Var = q1.v0.b;
            lmjxuqdtp.jvm.internal.o.f(n0Var, "null cannot be cast to non-null type tlydtdl.collection.ScatterMap<K of tlydtdl.collection.ScatterMapKt.emptyScatterMap, V of tlydtdl.collection.ScatterMapKt.emptyScatterMap>");
            return n0Var;
        }
        long[] jArr = q1.v0.a;
        n0 n0Var2 = new n0();
        r2 r2VarH = o2Var.h();
        try {
            Object[] objArr3 = j0VarM.a;
            int i7 = j0VarM.b;
            for (int i8 = 0; i8 < i7; i8++) {
                c1 c1Var = (c1) objArr3[i8];
                int iC = r2VarH.c(c1Var.e);
                int iF = r2VarH.F(iC, r2VarH.b);
                a(r2VarH, iF);
                a(r2VarH, iF);
                while (true) {
                    i = r2VarH.t;
                    if (i == iF || i == r2VarH.u) {
                        break;
                    }
                    if (iF < r2VarH.t(i) + i) {
                        r2VarH.Q();
                    } else {
                        r2VarH.M();
                    }
                }
                if (i != iF) {
                    u.c("Unexpected slot table structure");
                }
                r2VarH.Q();
                r2VarH.a(iC - r2VarH.t);
                n0Var2.m(c1Var, u.e(c1Var.c, c1Var, r2VarH, cVar));
            }
            a(r2VarH, IntCompanionObject.MAX_VALUE);
            r2VarH.e(true);
            return n0Var2;
        } catch (Throwable th) {
            r2VarH.e(false);
            throw th;
        }
    }
}
