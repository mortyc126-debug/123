package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.Metadata;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/layout/AspectRatioElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/layout/o;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class AspectRatioElement extends s4.c1 {
    public final float a;
    public final boolean b;

    public AspectRatioElement(float f2, boolean z) {
        this.a = f2;
        this.b = z;
        if (f2 > 0.0f) {
            return;
        }
        e2.a.a("aspectRatio " + f2 + " must be > 0");
    }

    @Override // s4.c1
    public final t3.o create() {
        o oVar = new o();
        oVar.a = this.a;
        oVar.b = this.b;
        return oVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        AspectRatioElement aspectRatioElement = obj instanceof AspectRatioElement ? (AspectRatioElement) obj : null;
        if (aspectRatioElement != null && this.a == aspectRatioElement.a) {
            return this.b == ((AspectRatioElement) obj).b;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (Float.hashCode(this.a) * 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(t4.e2 e2Var) {
    }

    @Override // s4.c1
    public final void update(t3.o oVar) {
        o oVar2 = (o) oVar;
        oVar2.a = this.a;
        oVar2.b = this.b;
    }
}
