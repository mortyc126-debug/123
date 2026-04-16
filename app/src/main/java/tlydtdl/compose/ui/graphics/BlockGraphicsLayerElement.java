package tlydtdl.compose.ui.graphics;

import a4.t;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;
import s4.c1;
import s4.g;
import s4.k1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/graphics/BlockGraphicsLayerElement;", "Ls4/c1;", "La4/t;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class BlockGraphicsLayerElement extends c1 {
    public final Function1 a;

    public BlockGraphicsLayerElement(Function1 function1) {
        this.a = function1;
    }

    @Override // s4.c1
    public final o create() {
        return new t(this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BlockGraphicsLayerElement) {
            return this.a == ((BlockGraphicsLayerElement) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("graphicsLayer");
        e2Var.b().c(this.a, "block");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    @Override // s4.c1
    public final void update(o oVar) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        t tVar = (t) oVar;
        tVar.a = this.a;
        k1 k1Var = g.s(tVar, 2).p;
        if (k1Var != null) {
            k1Var.I1(true, tVar.a);
        }
    }
}
