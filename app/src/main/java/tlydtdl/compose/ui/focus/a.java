package tlydtdl.compose.ui.focus;

import lmjxuqdtp.jvm.functions.Function1;
import t3.p;
import y3.q;
import y3.t;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final p a(p pVar, Function1 function1) {
        return pVar.then(new FocusPropertiesElement(new q(function1)));
    }

    public static final p b(p pVar, t tVar) {
        return pVar.then(new FocusRequesterElement(tVar));
    }

    public static final p c(p pVar, Function1 function1) {
        return pVar.then(new FocusChangedElement(function1));
    }
}
