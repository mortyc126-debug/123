package tlydtdl.compose.ui.layout;

import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function1;
import q4.h1;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/layout/OnSizeChangedModifier;", "Ls4/c1;", "Lq4/h1;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class OnSizeChangedModifier extends c1 {
    public final Function1 a;

    public OnSizeChangedModifier(Function1 function1) {
        this.a = function1;
    }

    @Override // s4.c1
    public final o create() {
        h1 h1Var = new h1();
        h1Var.a = this.a;
        long j2 = IntCompanionObject.MIN_VALUE;
        h1Var.b = (j2 & 4294967295L) | (j2 << 32);
        return h1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OnSizeChangedModifier) {
            return this.a == ((OnSizeChangedModifier) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("onSizeChanged");
        e2Var.b().c(this.a, "onSizeChanged");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        h1 h1Var = (h1) oVar;
        h1Var.a = this.a;
        long j2 = IntCompanionObject.MIN_VALUE;
        h1Var.b = (j2 & 4294967295L) | (j2 << 32);
    }
}
