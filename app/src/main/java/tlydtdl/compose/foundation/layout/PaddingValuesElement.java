package tlydtdl.compose.foundation.layout;

import a2.o3;
import lmjxuqdtp.Metadata;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/layout/PaddingValuesElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/layout/g2;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class PaddingValuesElement extends s4.c1 {
    public final e2 a;
    public final o3 b;

    public PaddingValuesElement(e2 e2Var, o3 o3Var) {
        this.a = e2Var;
        this.b = o3Var;
    }

    @Override // s4.c1
    public final t3.o create() {
        g2 g2Var = new g2();
        g2Var.a = this.a;
        return g2Var;
    }

    public final boolean equals(Object obj) {
        PaddingValuesElement paddingValuesElement = obj instanceof PaddingValuesElement ? (PaddingValuesElement) obj : null;
        if (paddingValuesElement == null) {
            return false;
        }
        return lmjxuqdtp.jvm.internal.o.c(this.a, paddingValuesElement.a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // s4.c1
    public final void inspectableProperties(t4.e2 e2Var) {
        this.b.invoke(e2Var);
    }

    @Override // s4.c1
    public final void update(t3.o oVar) {
        ((g2) oVar).a = this.a;
    }
}
