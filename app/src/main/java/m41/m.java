package m41;

import ky1.a0;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.internal.o;
import ny1.r2;
import ny1.z;
import o10.c4;
import q10.i0;
import q10.j0;
import q10.u;
import v41.f;
import xu0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m {
    public final p a;
    public final a0 b;
    public final v41.a c;

    public m(p pVar, a0 a0Var, v41.a aVar) {
        this.a = pVar;
        this.b = a0Var;
        this.c = aVar;
    }

    public static f a(m mVar, j0 j0Var, Boolean bool, i0 i0Var, c4 c4Var, r2 r2Var, Function0 function0, int i) {
        Boolean bool2 = (i & 2) != 0 ? null : bool;
        if ((i & 4) != 0) {
            i0Var = u.INSTANCE;
        }
        i0 i0Var2 = i0Var;
        c4 c4Var2 = (i & 8) != 0 ? null : c4Var;
        r2 r2VarC = (i & 16) != 0 ? z.c(z10.a.c) : r2Var;
        Function0 function02 = (i & 32) != 0 ? null : function0;
        mVar.getClass();
        o.h(i0Var2, "source");
        o.h(r2VarC, "followEvent");
        return mVar.c.a(mVar.a, mVar.b, j0Var, bool2, i0Var2, c4Var2, r2VarC, function02);
    }
}
