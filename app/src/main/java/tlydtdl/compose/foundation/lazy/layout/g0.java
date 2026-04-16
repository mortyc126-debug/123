package tlydtdl.compose.foundation.lazy.layout;

import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.internal.o;
import tlydtdl.compose.foundation.layout.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {
    public final r3.c a;
    public final l0 b;
    public final q1.n0 c;

    public g0(r3.c cVar, l0 l0Var) {
        this.a = cVar;
        this.b = l0Var;
        long[] jArr = q1.v0.a;
        this.c = new q1.n0();
    }

    public final Function2 a(int i, Object obj, Object obj2) {
        q1.n0 n0Var = this.c;
        f0 f0Var = (f0) n0Var.g(obj);
        if (f0Var != null && f0Var.c == i && o.c(f0Var.b, obj2)) {
            q3.k kVar = f0Var.d;
            if (kVar != null) {
                return kVar;
            }
            q3.k kVar2 = new q3.k(new z(1, f0Var.e, f0Var), true, 818252804);
            f0Var.d = kVar2;
            return kVar2;
        }
        f0 f0Var2 = new f0(this, i, obj, obj2);
        n0Var.m(obj, f0Var2);
        q3.k kVar3 = f0Var2.d;
        if (kVar3 != null) {
            return kVar3;
        }
        q3.k kVar4 = new q3.k(new z(1, this, f0Var2), true, 818252804);
        f0Var2.d = kVar4;
        return kVar4;
    }

    public final Object b(Object obj) {
        if (obj == null) {
            return null;
        }
        f0 f0Var = (f0) this.c.g(obj);
        if (f0Var != null) {
            return f0Var.b;
        }
        j0 j0Var = (j0) this.b.invoke();
        int iC = j0Var.c(obj);
        if (iC != -1) {
            return j0Var.b(iC);
        }
        return null;
    }
}
