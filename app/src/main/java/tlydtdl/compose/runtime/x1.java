package tlydtdl.compose.runtime;

import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x1 {
    public final w0 a;

    public x1(Function0 function0) {
        this.a = new w0(function0);
    }

    public abstract y1 a(Object obj);

    public i3 b() {
        return this.a;
    }

    public final i3 c(y1 y1Var, i3 i3Var) {
        i3 i3Var2 = null;
        i3Var2 = null;
        i3Var2 = null;
        i3Var2 = null;
        i3Var2 = null;
        i3Var2 = null;
        if (i3Var instanceof l0) {
            if (y1Var.d) {
                l0 l0Var = (l0) i3Var;
                l0Var.a.setValue(y1Var.a());
                i3Var2 = l0Var;
            }
        } else if (i3Var instanceof h3) {
            if ((y1Var.b || y1Var.e != null) && !y1Var.d) {
                h3 h3Var = (h3) i3Var;
                if (lmjxuqdtp.jvm.internal.o.c(y1Var.a(), h3Var.a)) {
                    i3Var2 = h3Var;
                }
            }
        } else if (i3Var instanceof f0) {
            y1Var.getClass();
        }
        if (i3Var2 != null) {
            return i3Var2;
        }
        if (!y1Var.d) {
            return new h3(y1Var.a());
        }
        Object obj = y1Var.e;
        x2 x2Var = y1Var.c;
        if (x2Var == null) {
            x2Var = x0.f548f;
        }
        return new l0(new n1(obj, x2Var));
    }
}
