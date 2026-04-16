package tlydtdl.compose.ui.layout;

import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function3;
import q4.c0;
import q4.t0;
import t3.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final Object a(t0 t0Var) {
        Object objL = t0Var.l();
        c0 c0Var = objL instanceof c0 ? (c0) objL : null;
        if (c0Var != null) {
            return c0Var.a;
        }
        return null;
    }

    public static final p b(p pVar, Function3 function3) {
        return pVar.then(new LayoutElement(function3));
    }

    public static final p c(p pVar, Object obj) {
        return pVar.then(new LayoutIdElement(obj));
    }

    public static final p d(p pVar, Function1 function1) {
        return pVar.then(new OnGloballyPositionedElement(function1));
    }

    public static final p e(p pVar, Function1 function1) {
        return pVar.then(new OnLayoutRectChangedElement(function1));
    }

    public static final p f(p pVar, Function1 function1) {
        return pVar.then(new OnPlacedElement(function1));
    }

    public static final p g(p pVar, Function1 function1) {
        return pVar.then(new OnSizeChangedModifier(function1));
    }
}
