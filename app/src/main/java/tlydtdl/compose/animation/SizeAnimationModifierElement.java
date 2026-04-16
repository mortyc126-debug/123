package tlydtdl.compose.animation;

import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function2;
import s1.h1;
import s4.c1;
import t1.z;
import t3.h;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/animation/SizeAnimationModifierElement;", "Ls4/c1;", "Ls1/h1;", "animation"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class SizeAnimationModifierElement extends c1 {
    public final z a;
    public final h b;
    public final Function2 c;

    public SizeAnimationModifierElement(z zVar, h hVar, Function2 function2) {
        this.a = zVar;
        this.b = hVar;
        this.c = function2;
    }

    @Override // s4.c1
    public final o create() {
        return new h1(this.a, this.b, this.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeAnimationModifierElement)) {
            return false;
        }
        SizeAnimationModifierElement sizeAnimationModifierElement = (SizeAnimationModifierElement) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, sizeAnimationModifierElement.a) && this.b.equals(sizeAnimationModifierElement.b) && lmjxuqdtp.jvm.internal.o.c(this.c, sizeAnimationModifierElement.c);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        Function2 function2 = this.c;
        return iHashCode + (function2 == null ? 0 : function2.hashCode());
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("animateContentSize");
        e2Var.b().c(this.a, "animationSpec");
        e2Var.b().c(this.b, "alignment");
        e2Var.b().c(this.c, "finishedListener");
    }

    public final String toString() {
        return "SizeAnimationModifierElement(animationSpec=" + this.a + ", alignment=" + this.b + ", finishedListener=" + this.c + ')';
    }

    @Override // s4.c1
    public final void update(o oVar) {
        h1 h1Var = (h1) oVar;
        h1Var.b = this.a;
        h1Var.d = this.c;
        h1Var.c = this.b;
    }
}
