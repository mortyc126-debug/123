package jv0;

import m10.j0;
import md1.b1;
import y11.d4;
import y11.g4;
import y11.l1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m {
    public static n a(String str, l1 l1Var) {
        g4 g4Var;
        lmjxuqdtp.jvm.internal.o.h(l1Var, "revision");
        d4 d4Var = l1Var.h;
        String strJ = b1.j((d4Var == null || (g4Var = d4Var.p) == null) ? null : g4Var.c, " - ", d4Var != null ? d4Var.c : null);
        String str2 = d4Var != null ? d4Var.d : null;
        j0 j0VarF = l1Var.f();
        return new n(str, strJ, str2, j0VarF != null ? j0VarF.g() : null);
    }

    public final wy1.a serializer() {
        return l.a;
    }
}
