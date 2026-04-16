package tlydtdl.compose.foundation.text.handwriting;

import lmjxuqdtp.jvm.functions.Function0;
import s4.p;
import tlydtdl.compose.ui.input.pointer.StylusHoverIconModifierElement;
import u2.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final p a;

    static {
        float f2 = 40;
        float f3 = 10;
        a = new p(f3, f2, f3, f2);
    }

    public static final t3.p a(t3.p pVar, boolean z, boolean z2, Function0 function0) {
        if (!z || !b.a) {
            return pVar;
        }
        if (z2) {
            pVar = pVar.then(new StylusHoverIconModifierElement(a));
        }
        return pVar.then(new StylusHandwritingElement(function0));
    }
}
