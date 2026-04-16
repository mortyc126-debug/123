package tlydtdl.compose.ui.input.key;

import k4.e;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function1;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/input/key/KeyInputElement;", "Ls4/c1;", "Lk4/e;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class KeyInputElement extends c1 {
    public final Function1 a;
    public final Function1 b;

    public KeyInputElement(Function1 function1, Function1 function12) {
        this.a = function1;
        this.b = function12;
    }

    @Override // s4.c1
    public final o create() {
        e eVar = new e();
        eVar.a = this.a;
        eVar.b = this.b;
        return eVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyInputElement)) {
            return false;
        }
        KeyInputElement keyInputElement = (KeyInputElement) obj;
        return this.a == keyInputElement.a && this.b == keyInputElement.b;
    }

    public final int hashCode() {
        Function1 function1 = this.a;
        int iHashCode = (function1 != null ? function1.hashCode() : 0) * 31;
        Function1 function12 = this.b;
        return iHashCode + (function12 != null ? function12.hashCode() : 0);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        Function1 function1 = this.a;
        if (function1 != null) {
            e2Var.d("onKeyEvent");
            e2Var.b().c(function1, "onKeyEvent");
        }
        Function1 function12 = this.b;
        if (function12 != null) {
            e2Var.d("onPreviewKeyEvent");
            e2Var.b().c(function12, "onPreviewKeyEvent");
        }
    }

    @Override // s4.c1
    public final void update(o oVar) {
        e eVar = (e) oVar;
        eVar.a = this.a;
        eVar.b = this.b;
    }
}
