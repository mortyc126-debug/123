package tlydtdl.compose.foundation.lazy.layout;

import a2.k2;
import lmjxuqdtp.Metadata;
import s4.c1;
import t3.o;
import t4.e2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/lazy/layout/q;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = tlydtdl.compose.foundation.layout.m.g)
final class LazyLayoutBeyondBoundsModifierElement extends c1 {
    public final r a;
    public final a2.b b;
    public final boolean c;
    public final k2 d;

    public LazyLayoutBeyondBoundsModifierElement(r rVar, a2.b bVar, boolean z, k2 k2Var) {
        this.a = rVar;
        this.b = bVar;
        this.c = z;
        this.d = k2Var;
    }

    @Override // s4.c1
    public final o create() {
        q qVar = new q();
        qVar.a = this.a;
        qVar.b = this.b;
        qVar.c = this.c;
        qVar.d = this.d;
        return qVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyLayoutBeyondBoundsModifierElement)) {
            return false;
        }
        LazyLayoutBeyondBoundsModifierElement lazyLayoutBeyondBoundsModifierElement = (LazyLayoutBeyondBoundsModifierElement) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, lazyLayoutBeyondBoundsModifierElement.a) && lmjxuqdtp.jvm.internal.o.c(this.b, lazyLayoutBeyondBoundsModifierElement.b) && this.c == lazyLayoutBeyondBoundsModifierElement.c && this.d == lazyLayoutBeyondBoundsModifierElement.d;
    }

    public final int hashCode() {
        return this.d.hashCode() + s1.a.f((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31, this.c);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
    }

    @Override // s4.c1
    public final void update(o oVar) {
        q qVar = (q) oVar;
        qVar.a = this.a;
        qVar.b = this.b;
        qVar.c = this.c;
        qVar.d = this.d;
    }
}
