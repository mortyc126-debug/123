package tlydtdl.compose.ui.input.key;

import lmjxuqdtp.jvm.functions.Function1;
import t3.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final p a(p pVar, Function1 function1) {
        return pVar.then(new KeyInputElement(function1, null));
    }

    public static final p b(p pVar, Function1 function1) {
        return pVar.then(new KeyInputElement(null, function1));
    }
}
